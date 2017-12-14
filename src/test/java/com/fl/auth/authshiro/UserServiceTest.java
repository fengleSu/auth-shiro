package com.fl.auth.authshiro;

import com.fl.auth.authshiro.service.IUserService;
import com.fl.auth.authshiro.vo.Result;
import com.fl.auth.authshiro.vo.UserVo;
import com.fl.auth.authshiro.vo.ValidateMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuthShiroApplication.class ,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    /**
     * 注册
     */
    @Test
    public void testRegist(){
        // 空邮箱
        UserVo emailEmptyVo = userService.regist("","","","",1);
        Assert.assertEquals(emailEmptyVo.getResult(), Result.INVALID);
        Assert.assertEquals(emailEmptyVo.getValidation(), ValidateMessage.EMAIL_EMPTY);

        // 空用户名
        UserVo usernameEmptyVo = userService.regist("644930725@qq.com","","","",1);
        Assert.assertEquals(usernameEmptyVo.getResult(), Result.INVALID);
        Assert.assertEquals(usernameEmptyVo.getValidation(), ValidateMessage.USERNAME_EMPTY);

        // 空密码
        UserVo passwordEmptyVo = userService.regist("644930725@qq.com","fengle","","",1);
        Assert.assertEquals(passwordEmptyVo.getResult(), Result.INVALID);
        Assert.assertEquals(passwordEmptyVo.getValidation(), ValidateMessage.PASSWORD_EMPTY);

        // 空重复密码
        UserVo repasswordEmptyVo = userService.regist("644930725@qq.com","fengle","123456","",1);
        Assert.assertEquals(repasswordEmptyVo.getResult(), Result.INVALID);
        Assert.assertEquals(repasswordEmptyVo.getValidation(), ValidateMessage.REPASSWORD_EMPTY);

        // 两次输入密码不一致
        UserVo passwordInconsistentEmptyVo = userService.regist("644930725@qq.com","fengle","12345","123456",1);
        Assert.assertEquals(passwordInconsistentEmptyVo.getResult(), Result.INVALID);
        Assert.assertEquals(passwordInconsistentEmptyVo.getValidation(), ValidateMessage.PASSWORD_INCONSISTENT);

        // 注册成功
        UserVo successVo = userService.regist("644930725@qq.com","fengle","fengle","fengle",1);
        Assert.assertEquals(successVo.getResult(), Result.SUCCESS);
        Assert.assertNull(successVo.getValidation());
    }

    /**
     *  登录
     */
    @Test
    public void testLogin(){
        // 用户不存在
        UserVo userNotExistVo = userService.login("644930725@qq.com","fengle");
        Assert.assertEquals(userNotExistVo.getResult(), Result.INVALID);
        Assert.assertEquals(userNotExistVo.getValidation(), ValidateMessage.USER_NOT_EXIST);

        // 登录成功
        UserVo successVo = userService.login("fengle","fengle");
        Assert.assertEquals(successVo.getResult(), Result.SUCCESS);
        Assert.assertNull(successVo.getValidation());
    }
}
