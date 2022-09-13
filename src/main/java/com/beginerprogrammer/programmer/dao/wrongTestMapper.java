package com.beginerprogrammer.programmer.dao;


import com.beginerprogrammer.programmer.entity.wrongTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface wrongTestMapper {
    int deleteByPrimaryKey(@Param("questionid") Integer questionid, @Param("userid") Integer userid);

    int insert(wrongTest record);

    int insertSelective(wrongTest record);

    //查询用户的记录
    List<wrongTest> selectByUserId(@Param("userid") Integer userid);
    //查询全部
    List<wrongTest> selectAll();

}