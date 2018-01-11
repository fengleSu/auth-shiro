package com.fl.auth.authshiro.service;

import com.fl.auth.authshiro.dao.TPermissionMapper;
import com.fl.auth.authshiro.vo.BaseVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 权限服务
 */
public interface IPermissionService {

    /**
     * 获取角色所有权限
     * @param roleIds
     * @return
     */
    List<String> getRolePermissionKeys(List<Integer> roleIds);

    /**
     * 添加权限
     * @param permKey 权限key
     * @param permName 权限名称
     * @param url 路径
     * @param parent 父权限
     * @param operator 操作人id
     * @return
     */
    BaseVo addPermission(String permKey, String permName, String url, Integer parent, Integer operator);

    /**
     * 添加角色权限
     * @param roleId 角色id
     * @param permissionId 权限id
     * @param operator 操作人id
     * @return
     */
    BaseVo addRolePermission(Integer roleId,Integer permissionId,Integer operator);

}
