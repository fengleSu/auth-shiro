package com.fl.auth.authshiro.service.impl;

import com.fl.auth.authshiro.dao.TRoleMapper;
import com.fl.auth.authshiro.dao.TUserRoleMapper;
import com.fl.auth.authshiro.entity.TRole;
import com.fl.auth.authshiro.entity.TUserRole;
import com.fl.auth.authshiro.service.IRoleService;
import com.fl.auth.authshiro.vo.BaseVo;
import com.fl.auth.authshiro.vo.Result;
import com.fl.auth.authshiro.vo.ValidateMessage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private TRoleMapper roleMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Override
    public List<Integer> getUserRoleIds(Integer userId) {
        if(userId == null) {
            return null;
        }
        TUserRole userRoleCondition = new TUserRole();
        userRoleCondition.setnUserId(userId);
        userRoleCondition.setDelete(false);
        List<TUserRole> userRoleList = userRoleMapper.select(userRoleCondition);
        if(CollectionUtils.isEmpty(userRoleList)){
            return null;
        }
        List<Integer> userRoleIds = userRoleList.stream().map(userRole -> userRole.getnRoleId()).collect(Collectors.toList());
        return userRoleIds;
    }

    @Override
    public BaseVo addRole(String roleName, Integer operatorId) {
        BaseVo baseVo = new BaseVo();
        if(StringUtils.isEmpty(roleName)){
            baseVo.setResult(Result.INVALID);
            baseVo.setValidation(ValidateMessage.ROLE_NAME_EMPTY);
            return baseVo;
        }
        if(operatorId == null) {
            baseVo.setResult(Result.INVALID);
            baseVo.setValidation(ValidateMessage.OPERATOR_EMPTY);
            return baseVo;
        }
        TRole role = new TRole();
        Date curTime = new Date();
        role.setcRoleName(roleName);
        role.setnCreateUser(operatorId);
        role.setdCreateTime(curTime);
        role.setnUpdateUser(operatorId);
        role.setdUpdateTime(curTime);
        role.setDelete(false);
        int count = roleMapper.insert(role);
        if(count <= 0){
            baseVo.setResult(Result.FAILED);
            return baseVo;
        }
        baseVo.setResult(Result.SUCCESS);
        return baseVo;
    }

    @Override
    public BaseVo addUserRole(Integer roleId, Integer relUserId, Integer operatorId) {
        BaseVo baseVo = new BaseVo();
        if(roleId == null){
            baseVo.setResult(Result.INVALID);
            baseVo.setValidation(ValidateMessage.ROLE_ID_NULL);
            return baseVo;
        }
        TRole role = roleMapper.selectByPrimaryKey(roleId);
        if(role == null || role.getDelete()){
            baseVo.setResult(Result.INVALID);
            baseVo.setValidation(ValidateMessage.ROLE_NOT_EXIST);
            return baseVo;
        }
        if(relUserId == null){
            baseVo.setResult(Result.INVALID);
            baseVo.setValidation(ValidateMessage.USER_NOT_EXIST);
            return baseVo;
        }
        TUserRole existUserRole = new TUserRole();
        existUserRole.setnUserId(relUserId);
        existUserRole.setDelete(false);
        int existCount = userRoleMapper.selectCount(existUserRole);
        if(existCount > 0){
            baseVo.setResult(Result.INVALID);
            baseVo.setValidation(ValidateMessage.USER_HAS_ROLE);
            return baseVo;
        }
        if(operatorId == null){
            baseVo.setResult(Result.INVALID);
            baseVo.setValidation(ValidateMessage.OPERATOR_EMPTY);
            return baseVo;
        }
        TUserRole userRole = new TUserRole();
        Date curTime = new Date();
        userRole.setnUserId(relUserId);
        userRole.setnRoleId(roleId);
        userRole.setnCreateUser(operatorId);
        userRole.setdCreateTime(curTime);
        userRole.setnUpdateUser(operatorId);
        userRole.setdUpdateTime(curTime);
        userRole.setDelete(false);
        int count = userRoleMapper.insert(userRole);
        if(count <= 0){
            baseVo.setResult(Result.FAILED);
            return baseVo;
        }
        baseVo.setResult(Result.SUCCESS);
        return baseVo;
    }
}
