package com.beginerprogrammer.programmer.dao;

import com.beginerprogrammer.programmer.entity.userQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userQuestionMapper {
    int deleteByPrimaryKey(@Param("userid") Integer userid, @Param("questionid") Integer questionid);

    int insert(userQuestion record);

    int insertSelective(userQuestion record);

    //查询用户的记录
    List<userQuestion> selectByUserId(@Param("userid") Integer userid);
    //查询全部
    List<userQuestion> selectAll();
}