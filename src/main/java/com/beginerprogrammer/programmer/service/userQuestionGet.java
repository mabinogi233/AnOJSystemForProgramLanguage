package com.beginerprogrammer.programmer.service;

import com.beginerprogrammer.programmer.dao.userQuestionMapper;
import com.beginerprogrammer.programmer.entity.userQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userQuestionGet {
    @Autowired
    private userQuestionMapper userquestionmapper;

    public void insert(userQuestion uq){
        userquestionmapper.insert(uq);
    }

    public void deleteByPrimaryKey(int questionID,int userID){
        userquestionmapper.deleteByPrimaryKey(userID,questionID);
    }

    public List<userQuestion> getByUserID(int userid){
        return userquestionmapper.selectByUserId(userid);
    }
}
