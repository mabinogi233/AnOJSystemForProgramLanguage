package com.beginerprogrammer.programmer.controller;

import com.beginerprogrammer.programmer.dao.movieMapper;
import com.beginerprogrammer.programmer.dao.problemXMapper;
import com.beginerprogrammer.programmer.dao.userQuestionMapper;
import com.beginerprogrammer.programmer.dao.wrongTestMapper;
import com.beginerprogrammer.programmer.entity.movie;
import com.beginerprogrammer.programmer.entity.problemX;
import com.beginerprogrammer.programmer.entity.userQuestion;
import com.beginerprogrammer.programmer.entity.wrongTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Adm")
public class AdmController {
    @Autowired
    private movieMapper moviemapper;
    @Autowired
    private problemXMapper problemxmapper;
    @Autowired
    private userQuestionMapper userquestionmapper;
    @Autowired
    private wrongTestMapper wrongtestmapper;

    //管理视频，查询ALL，select update，insert，delete
    @RequestMapping("selectAllmovie")
    @ResponseBody
    public List<movie> selectAllmovie(){
        return moviemapper.selectAll();
    }
    @PostMapping("selectmovie")
    @ResponseBody
    public movie selectmovie(@RequestBody Map<String,String> map){
        return moviemapper.selectByPrimaryKey(Integer.parseInt(map.get("movieid")));
    }
    @PostMapping("updatemovie")
    public void updatemovie(@RequestBody movie mv){
        moviemapper.updateByPrimaryKey(mv);
    }
    @PostMapping("deletemovie")
    public void deletemovie(@RequestBody Map<String,String> map){
        moviemapper.deleteByPrimaryKey(Integer.parseInt(map.get("movieid")));
    }
    @RequestMapping("insertmovie")
    @ResponseBody
    public void insertmovie(@RequestBody movie mv){
        moviemapper.insert(mv);
    }


    //管理选择题，查询ALL，select update，insert，delete
    @RequestMapping("selectAllproblem")
    @ResponseBody
    public List<problemX> selectAllproblem(){
        return problemxmapper.selectAll();
    }
    @PostMapping("selectproblem")
    @ResponseBody
    public problemX selectproblem(@RequestBody Map<String,String> map){
        return problemxmapper.selectByPrimaryKey(Integer.parseInt(map.get("problemid")));
    }
    @PostMapping("updateproblem")
    public void updateproblem(@RequestBody problemX px){
        problemxmapper.updateByPrimaryKey(px);
    }
    @PostMapping("deleteproblem")
    public void deleteproblem(@RequestBody Map<String,String> map){
        problemxmapper.deleteByPrimaryKey(Integer.parseInt(map.get("problemid")));
    }
    @RequestMapping("insertproblem")
    @ResponseBody
    public void insertproblem(@RequestBody problemX px){
        problemxmapper.insert(px);
    }

    //管理做题记录，查询ALL,delete
    @RequestMapping("selectAlluserQuestion")
    @ResponseBody
    public List<userQuestion> selectAlluserQuestion(){
        return userquestionmapper.selectAll();
    }

    @PostMapping("deleteuserQuestion")
    public void deleteuserQuestion(@RequestBody Map<String,String> map){
        userquestionmapper.deleteByPrimaryKey(Integer.parseInt(map.get("userid")),Integer.parseInt(map.get("questionid")));
    }


    //管理错题记录，查询ALL,delete
    @RequestMapping("selectAllwrongQuestion")
    @ResponseBody
    public List<wrongTest> selectAllwrongQuestion(){
        return wrongtestmapper.selectAll();
    }

    @PostMapping("deletewrongQuestion")
    public void deletewrongQuestion(@RequestBody Map<String,String> map){
        wrongtestmapper.deleteByPrimaryKey(Integer.parseInt(map.get("questionid")),Integer.parseInt(map.get("userid")));
    }
}
