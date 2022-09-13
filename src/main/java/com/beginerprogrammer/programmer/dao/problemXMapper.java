package com.beginerprogrammer.programmer.dao;

import com.beginerprogrammer.programmer.entity.problemX;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface problemXMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(problemX record);

    int insertSelective(problemX record);

    problemX selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(problemX record);

    int updateByPrimaryKey(problemX record);

    List<Integer> getByLanguageAndClassify(@Param("languageName")String languageName,@Param("classify")String classify);

    List<Integer> getAllID();

    List<problemX> selectAll();
}