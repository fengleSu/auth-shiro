package com.fl.auth.authshiro.service.impl;

import com.fl.auth.authshiro.dao.TUserMapper;
import com.fl.auth.authshiro.entity.TUser;
import com.fl.auth.authshiro.service.IUserService;
import com.fl.auth.authshiro.vo.Result;
import com.fl.auth.authshiro.vo.UserVo;
import com.fl.auth.authshiro.vo.ValidateMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService implements IUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public UserVo regist(String email, String username, String password, String repassword, Integer userId) {
        UserVo userVo = new UserVo();
        if(StringUtils.isEmpty(email)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.EMAIL_EMPTY);
        }
        if(StringUtils.isEmpty(username)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.USERNAME_EMPTY);
        }
        if(StringUtils.isEmpty(password)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.PASSWORD_EMPTY);
        }
        if(StringUtils.isEmpty(repassword)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.REPASSWORD_EMPTY);
        }
        if(!StringUtils.equals(password,repassword)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.PASSWORD_INCONSISTENT);
        }
        TUser user = new TUser();
        user.setcUsername(username);
        user.setcPassword(password);
        user.setcSalt("SALT");
        user.setcEmail(email);
        user.setnCreateUser(userId);
        user.setdCreateTime(new Date());
        user.setnUpdateUser(userId);
        user.setdUpdateTime(new Date());
        user.setDelete(false);
        userMapper.insert(user);
        userVo.setResult(Result.SUCCESS);
        userVo.setUsername(username);
        return userVo;
    }

    @Override
    public UserVo login(String username, String password) {
        UserVo userVo = new UserVo();
        TUser user = new TUser();
        user.setcUsername(username);
        user.setcPassword(password);
        TUser existUser =  userMapper.selectOne(user);
        if(existUser == null){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.USER_NOT_EXIST);
        }
        userVo.setResult(Result.SUCCESS);
        userVo.setUsername(existUser.getcUsername());
        return userVo;
    }
}
