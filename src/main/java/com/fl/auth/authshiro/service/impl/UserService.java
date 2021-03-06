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
    public UserVo regist(String email, String username, String password, String repassword) {
        UserVo userVo = new UserVo();
        if(StringUtils.isEmpty(email)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.EMAIL_EMPTY);
            return userVo;
        }
        if(StringUtils.isEmpty(username)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.USERNAME_EMPTY);
            return userVo;
        }
        if(StringUtils.isEmpty(password)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.PASSWORD_EMPTY);
            return userVo;
        }
        if(StringUtils.isEmpty(repassword)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.REPASSWORD_EMPTY);
            return userVo;
        }
        if(!StringUtils.equals(password,repassword)){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.PASSWORD_INCONSISTENT);
            return userVo;
        }
        TUser user = new TUser();
        user.setcUsername(username);
        user.setcPassword(password);
        user.setcSalt("SALT");
        user.setcEmail(email);
        user.setnCreateUser(0);
        user.setdCreateTime(new Date());
        user.setnUpdateUser(0);
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
            return userVo;
        }
        userVo.setResult(Result.SUCCESS);
        userVo.setUsername(existUser.getcUsername());
        return userVo;
    }

    @Override
    public UserVo getUser(String username) {
        UserVo userVo = new UserVo();
        TUser user = new TUser();
        user.setcUsername(username);
        TUser existUser =  userMapper.selectOne(user);
        if(existUser == null){
            userVo.setResult(Result.INVALID);
            userVo.setValidation(ValidateMessage.USER_NOT_EXIST);
            return userVo;
        }
        userVo.setResult(Result.SUCCESS);
        userVo.setUsername(existUser.getcUsername());
        userVo.setPassword(existUser.getcPassword());
        userVo.setSalt(existUser.getcSalt());
        return userVo;
    }
}
