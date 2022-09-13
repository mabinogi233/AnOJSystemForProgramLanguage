package com.beginerprogrammer.programmer.service;

import com.beginerprogrammer.programmer.dao.userMapper;
import com.beginerprogrammer.programmer.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//登录服务器
@Service
public class loadService implements myLoadService {

    @Autowired
    private userMapper usermapper;

    //判断手机号合法性
    private static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }


    @Override
    public String load(user users){
        if(usermapper.selectByPrimaryKey(users.getPhonenumber())==null){
            return "账号不存在";
        }
        user olduser = usermapper.selectByPrimaryKey(users.getPhonenumber());
        if(!olduser.getPassword().equals(users.getPassword())){
            return "密码错误";
        }else {
            return "登录成功";
        }
    }

    @Override
    public String register(user users){
        if(!isPhone(Integer.toString(users.getPhonenumber()))){
            return "非手机号";
        }
        if (usermapper.selectByPrimaryKey(users.getPhonenumber())!=null){
            return "账号已存在";
        }
        usermapper.insert(users);
        return "注册成功";
    }
}
