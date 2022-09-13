package com.beginerprogrammer.programmer.service;

import com.beginerprogrammer.programmer.dao.wrongTestMapper;
import com.beginerprogrammer.programmer.entity.userQuestion;
import com.beginerprogrammer.programmer.entity.wrongTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class wrongQuestionGet {

    @Autowired
    private wrongTestMapper wrongmapper;

    public void insert(wrongTest wt){
        wrongmapper.insert(wt);
    }

    public void deleteByPrimaryKey(int questionID,int userID){
        wrongmapper.deleteByPrimaryKey(questionID,userID);
    }
    public List<wrongTest> getByUserID(int userid){
        return wrongmapper.selectByUserId(userid);
    }

}
