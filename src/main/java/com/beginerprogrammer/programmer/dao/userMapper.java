package com.beginerprogrammer.programmer.dao;

import com.beginerprogrammer.programmer.entity.user;

public interface userMapper {
    int deleteByPrimaryKey(Integer phonenumber);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer phonenumber);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}