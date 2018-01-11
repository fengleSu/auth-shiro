package com.fl.auth.authshiro;


import com.fl.auth.authshiro.service.IRoleService;
import com.fl.auth.authshiro.vo.BaseVo;
import com.fl.auth.authshiro.vo.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuthShiroApplication.class,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class RoleServiceTest {

    @Autowired
    private IRoleService roleService;

    @Test
    public void testAddRole(){
        BaseVo baseVo = roleService.addRole("超级管理员",1);
        Assert.assertEquals(baseVo.getResult(), Result.SUCCESS);
    }

    @Test
    public void testAddUserRole(){
        BaseVo baseVo = roleService.addUserRole(1,1,1);
        Assert.assertEquals(baseVo.getResult(),Result.SUCCESS);
    }

    @Test
    public void testGetUserRoleIds(){
        List<Integer> roleIds = roleService.getUserRoleIds(1);
        Assert.assertEquals(roleIds.size(),1);
    }
}
