package com.fl.auth.authshiro.service.impl;

import com.fl.auth.authshiro.dao.TPermissionMapper;
import com.fl.auth.authshiro.dao.TRolePermissionMapper;
import com.fl.auth.authshiro.entity.TPermission;
import com.fl.auth.authshiro.entity.TRolePermission;
import com.fl.auth.authshiro.service.IPermissionService;
import com.fl.auth.authshiro.vo.BaseVo;
import com.fl.auth.authshiro.vo.Result;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService implements IPermissionService{

    @Autowired
    private TPermissionMapper permissionMapper;

    @Autowired
    private TRolePermissionMapper rolePermissionMapper;


    @Override
    public List<String> getRolePermissionKeys(List<Integer> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)){
            return null;
        }
        Example example = new Example(TRolePermission.class);
        example.createCriteria().andIn("nRoleId",roleIds);
        List<TRolePermission> rolePermissionList = rolePermissionMapper.selectByExample(example);
        List<Integer> permissionIds = rolePermissionList.stream().map(rolePermission -> rolePermission.getnPermissionId()).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(permissionIds)){
            return null;
        }
        Example permissionExample = new Example(TPermission.class);
        permissionExample.createCriteria().andIn("nId",permissionIds);
        List<TPermission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<String> permKeys = permissionList.stream().map(permission -> permission.getcPermission()).collect(Collectors.toList());
        return permKeys;
    }

    @Override
    public BaseVo addPermission(String permKey, String permName, String url, Integer parent, Integer operator) {
        BaseVo baseVo = new BaseVo();
        TPermission permission = new TPermission();
        Date curTime = new Date();
        permission.setcPermission(permKey);
        permission.setcPermissionName(permName);
        permission.setUrl(url);
        permission.setnParent(parent);
        permission.setnCreateUser(operator);
        permission.setdCreateTime(curTime);
        permission.setnUpdateUser(operator);
        permission.setdUpdateTime(curTime);
        permission.setDelete(false);
        int count = permissionMapper.insert(permission);
        if(count <= 0){
            baseVo.setResult(Result.FAILED);
            return baseVo;
        }
        baseVo.setResult(Result.SUCCESS);
        return baseVo;
    }

    @Override
    public BaseVo addRolePermission(Integer roleId, Integer permissionId, Integer operator) {
        BaseVo baseVo = new BaseVo();
        TRolePermission rolePermission = new TRolePermission();
        Date curTime = new Date();
        rolePermission.setnRoleId(roleId);
        rolePermission.setnPermissionId(permissionId);
        rolePermission.setnCreateUser(operator);
        rolePermission.setdCreateTime(curTime);
        rolePermission.setnUpdateUser(operator);
        rolePermission.setdUpdateTime(curTime);
        rolePermission.setDelete(false);
        int count = rolePermissionMapper.insert(rolePermission);
        if(count <= 0){
            baseVo.setResult(Result.FAILED);
            return baseVo;
        }
        baseVo.setResult(Result.SUCCESS);
        return baseVo;
    }
}
