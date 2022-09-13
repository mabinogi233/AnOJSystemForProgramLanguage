package com.beginerprogrammer.programmer.service;


import com.beginerprogrammer.programmer.entity.user;

public interface myLoadService {
    //登录并返回错误信息
    String load(user users);
    //注册
    String register(user users);
}
