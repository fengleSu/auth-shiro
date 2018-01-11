package com.fl.auth.authshiro;

import com.fl.auth.authshiro.service.IPermissionService;
import com.fl.auth.authshiro.service.impl.PermissionService;
import com.fl.auth.authshiro.vo.BaseVo;
import com.fl.auth.authshiro.vo.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuthShiroApplication.class ,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PermissionServiceTest {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 添加权限
     */
    @Test
    public void testAddPermission(){
        BaseVo baseVo = permissionService.addPermission("super:user:select","查询用户列表","/searchUserList",0,1);
        Assert.assertEquals(baseVo.getResult(), Result.SUCCESS);
    }

    /**
     * 添加角色权限
     */
    @Test
    public void testAddRolePermission(){
        BaseVo baseVo = permissionService.addRolePermission(1,1,1);
        Assert.assertEquals(baseVo.getResult(),Result.SUCCESS);

    }

    /**
     * 获取角色权限key
     */
    @Test
    public void testGetRolePermissionKeys(){
        List<Integer> roleIds = new ArrayList<>();
        roleIds.add(1);
        List<String> permKeys = permissionService.getRolePermissionKeys(roleIds);
        Assert.assertEquals(permKeys.size(),1);
    }

}
