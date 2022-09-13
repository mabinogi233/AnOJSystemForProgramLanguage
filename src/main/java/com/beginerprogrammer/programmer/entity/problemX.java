package com.beginerprogrammer.programmer.entity;

public class problemX {
    private Integer id;

    private String classify;

    private String trueanswer;

    private String answerd;

    private String answerc;

    private String answerb;

    private String answera;

    private String languagename;

    private String problemname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getTrueanswer() {
        return trueanswer;
    }

    public void setTrueanswer(String trueanswer) {
        this.trueanswer = trueanswer == null ? null : trueanswer.trim();
    }

    public String getAnswerd() {
        return answerd;
    }

    public void setAnswerd(String answerd) {
        this.answerd = answerd == null ? null : answerd.trim();
    }

    public String getAnswerc() {
        return answerc;
    }

    public void setAnswerc(String answerc) {
        this.answerc = answerc == null ? null : answerc.trim();
    }

    public String getAnswerb() {
        return answerb;
    }

    public void setAnswerb(String answerb) {
        this.answerb = answerb == null ? null : answerb.trim();
    }

    public String getAnswera() {
        return answera;
    }

    public void setAnswera(String answera) {
        this.answera = answera == null ? null : answera.trim();
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename == null ? null : languagename.trim();
    }

    public String getProblemname() {
        return problemname;
    }

    public void setProblemname(String problemname) {
        this.problemname = problemname == null ? null : problemname.trim();
    }
}