package com.fl.auth.authshiro.service;

import com.fl.auth.authshiro.entity.TRole;
import com.fl.auth.authshiro.entity.TUserRole;
import com.fl.auth.authshiro.vo.BaseVo;

import java.util.List;

/**
 * 角色服务
 */
public interface IRoleService {

    /**
     * 获取用户角色Id
     * @param userId 用户id
     * @return
     */
    List<Integer> getUserRoleIds(Integer userId);

    /**
     * 添加角色
     * @param roleName 角色名称
     * @param operatorId 操作人id
     * @return
     */
    BaseVo addRole(String roleName, Integer operatorId);

    /**
     * 添加用户角色
     * @param roleId 角色id
     * @param relUserId 关联用户id
     * @param operatorId 操作人id
     * @return
     */
    BaseVo addUserRole(Integer roleId,Integer relUserId,Integer operatorId);


}
