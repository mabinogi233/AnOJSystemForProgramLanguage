package com.beginerprogrammer.programmer.dao;

import com.beginerprogrammer.programmer.entity.movie;

import java.util.List;

public interface movieMapper {
    int deleteByPrimaryKey(Integer movienumber);

    int insert(movie record);

    int insertSelective(movie record);

    movie selectByPrimaryKey(Integer movienumber);

    int updateByPrimaryKeySelective(movie record);

    int updateByPrimaryKey(movie record);

    List<String> selectALLPackageName();

    List<movie> selectByPackageName(String packageName);

    List<movie> selectAll();

}