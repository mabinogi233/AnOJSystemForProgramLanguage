package com.beginerprogrammer.programmer.service;

import com.beginerprogrammer.programmer.dao.problemXMapper;
import com.beginerprogrammer.programmer.dao.userQuestionMapper;
import com.beginerprogrammer.programmer.dao.wrongTestMapper;
import com.beginerprogrammer.programmer.entity.json_problem;
import com.beginerprogrammer.programmer.entity.problemX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class problemGet {
    @Autowired
    private problemXMapper problemXmapper;


    //获取题目ID列表
    public List<Integer> getProblemID(String language, String classify){
        return problemXmapper.getByLanguageAndClassify(language,classify);
    }

    //获取全部题目列表
    public List<Integer> getAllProblemID(){
        return problemXmapper.getAllID();
    }

    //根据ID获取题目
    public ArrayList<json_problem> getProblemJson(int pid) {
        problemX item = problemXmapper.selectByPrimaryKey(pid);
        ArrayList<json_problem> result = new ArrayList<json_problem>();
        json_problem jsonProblem = new json_problem();
        //json格式
        //title 题目
        jsonProblem.setTitle(item.getProblemname());
        //option [A,B,C,D] 存在的选项编号
        ArrayList<String> option = new ArrayList<String>();
        option.add("A");
        option.add("B");
        option.add("C");
        option.add("D");
        jsonProblem.setOption(option);
        //src_title 是否有图片 0表示无图
        jsonProblem.setSrc_title("0");
        //code 1,2 1为单选2为多选
        jsonProblem.setCode("1");
        //true_option []正确答案选项
        ArrayList<String> true_option = new ArrayList<String>();
        true_option.add(item.getTrueanswer());
        jsonProblem.setTrue_option(true_option);
        //current null
        jsonProblem.setCurrent("");
        //topic null
        jsonProblem.setTopic("");
        //code2 null
        jsonProblem.setCode2("");
        //alt null
        jsonProblem.setAlt("");
        //comment null
        jsonProblem.setComment("");
        //testList [] 内部单元格式为
        //{name 答案信息 code null click_index null }
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", item.getAnswera());
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", item.getAnswerb());
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("name", item.getAnswerc());
        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("name", item.getAnswerd());
        ArrayList<Map<String, String>> testlist = new ArrayList<Map<String, String>>();
        testlist.add(map1);
        testlist.add(map2);
        testlist.add(map3);
        testlist.add(map4);
        jsonProblem.setTestList(testlist);
        //languageName 编程语言
        jsonProblem.setLanguageName(item.getLanguagename());
        //classify 题目考察点
        jsonProblem.setClassify(item.getClassify());
        result.add(jsonProblem);
        return result;
    }

    public problemX getProblemX(int pid){
        return problemXmapper.selectByPrimaryKey(pid);
    }
}
