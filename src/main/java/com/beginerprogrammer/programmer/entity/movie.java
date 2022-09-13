package com.beginerprogrammer.programmer.entity;

public class movie {
    private Integer movienumber;

    private String chapter;

    private String classify;

    private String languagename;

    private String movieurl;

    private String packagename;

    private String moviename;

    public Integer getMovienumber() {
        return movienumber;
    }

    public void setMovienumber(Integer movienumber) {
        this.movienumber = movienumber;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter == null ? null : chapter.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename == null ? null : languagename.trim();
    }

    public String getMovieurl() {
        return movieurl;
    }

    public void setMovieurl(String movieurl) {
        this.movieurl = movieurl == null ? null : movieurl.trim();
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename == null ? null : packagename.trim();
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename == null ? null : moviename.trim();
    }
}