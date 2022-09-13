package com.beginerprogrammer.programmer.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class json_problem {
    //json格式
    //title 题目
    private String title;
    //option [A,B,C,D] 存在的选项编号
    private ArrayList<String> option;
    //src_title 是否有图片 0表示无图
    private String src_title;
    //code 1,2 1为单选2为多选
    private String code;
    //true_option []正确答案选项
    private ArrayList<String> true_option;
    //current null
    private String current;
    //topic null
    private String topic;
    //code2 null
    private String code2;
    //alt null
    private String alt;
    //comment null
    private String comment;
    //testList [] 内部单元格式为
    //{name 答案信息 code null click_index null }
    private ArrayList<Map<String, String>> testList;
    //languageName 编程语言
    private String languageName;
    //classify 题目考察点
    private String classify;

    public ArrayList<Map<String, String>> getTestList() {
        return testList;
    }

    public ArrayList<String> getOption() {
        return option;
    }

    public ArrayList<String> getTrue_option() {
        return true_option;
    }

    public String getAlt() {
        return alt;
    }

    public String getCode() {
        return code;
    }

    public String getClassify() {
        return classify;
    }

    public String getCode2() {
        return code2;
    }

    public String getComment() {
        return comment;
    }

    public String getCurrent() {
        return current;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getSrc_title() {
        return src_title;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setOption(ArrayList<String> option) {
        this.option = option;
    }

    public void setSrc_title(String src_title) {
        this.src_title = src_title;
    }

    public void setTestList(ArrayList<Map<String, String>> testList) {
        this.testList = testList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTrue_option(ArrayList<String> true_option) {
        this.true_option = true_option;
    }
}
