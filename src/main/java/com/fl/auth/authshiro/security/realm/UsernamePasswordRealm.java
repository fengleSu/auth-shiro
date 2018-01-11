package com.fl.auth.authshiro.security.realm;

import com.fl.auth.authshiro.service.IPermissionService;
import com.fl.auth.authshiro.service.IRoleService;
import com.fl.auth.authshiro.service.IUserService;
import com.fl.auth.authshiro.vo.UserVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

public class UsernamePasswordRealm  extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IRoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Iterator<UserVo> iterator = principals.fromRealm(this.getClass().getName()).iterator();
        if (iterator.hasNext()) {
            UserVo user = iterator.next();
            List<Integer> roleIds =  roleService.getUserRoleIds(user.getUserId());
            List<String> permissionKeys = permissionService.getRolePermissionKeys(roleIds);
            info.addStringPermissions(permissionKeys);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        UserVo userVo = userService.getUser(usernamePasswordToken.getUsername());
        return new SimpleAuthenticationInfo(usernamePasswordToken,userVo, this.getClass().getName());
    }
}
