package com.beginerprogrammer.programmer.controller;

import com.beginerprogrammer.programmer.dao.userQuestionMapper;
import com.beginerprogrammer.programmer.dao.wrongTestMapper;
import com.beginerprogrammer.programmer.entity.*;
import com.beginerprogrammer.programmer.service.*;
import com.fasterxml.jackson.core.util.InternCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class ProController {

    @Autowired
    private problemGet problemget;

    @Autowired
    private movieGet movieget;

    @Autowired
    private userQuestionGet userquestionget;

    @Autowired
    private wrongQuestionGet wrongtestget;

    //运行代码
    @CrossOrigin
    @PostMapping("/run")
    @ResponseBody
    public Map<String,String> run(@RequestBody Map<String,String> map){
        return new runPro().run(map);
    }

    //登录和注册
    @RequestMapping("/load")
    @ResponseBody
    public String load(@RequestBody user users){
        return new loadService().load(users);
    }
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody user users){
        return new loadService().register(users);
    }

    //获取根据类别获取题目ID
    @PostMapping("/getProblemID")
    @ResponseBody
    public List<Integer> getProblem(@RequestBody Map<String,String> map){
        return problemget.getProblemID(map.get("language"),map.get("classify"));
    }

    //获取全部题目ID
    @RequestMapping("/getAllProblemID")
    @ResponseBody
    public List<Integer> getallProblem(){
        return problemget.getAllProblemID();
    }

    //根据ID获取题目
    @PostMapping("/getProblemJson")
    @ResponseBody
    public ArrayList<json_problem> getProblemJson(@RequestBody Map<String,String> map){
        return problemget.getProblemJson(Integer.parseInt(map.get("id")));
    }

    //获取全部视频名称
    @RequestMapping("/getPakcageName")
    @ResponseBody
    public List<String> getPackageName(){
        return movieget.getPackageName();
    }

    //根据视频名称获取视频数据
    @PostMapping("/getByPackageName")
    @ResponseBody
    public List<movie> getByPackageName(@RequestBody Map<String,String> map){
        return movieget.getByPackageName(map.get("packageName"));
    }

    //错题本加入错题
    @PostMapping("/insertWrongQuestion")
    public void insertWrongQuestion(@RequestBody wrongTest wt){
        wrongtestget.insert(wt);
    }
    //错题本删除错题
    @PostMapping("/deleteWrongQuestion")
    public void insertWrongQuestion(@RequestBody Map<String,String> map){
        wrongtestget.deleteByPrimaryKey(Integer.parseInt(map.get("questionid")),Integer.parseInt(map.get("userid")));
    }

    //错题本查询错题
    @PostMapping("/selectWrongQuestion")
    @ResponseBody
    public List<wrongTest> selectWrongQuestion(@RequestBody Map<String,String> map){
        return wrongtestget.getByUserID(Integer.parseInt(map.get("userid")));
    }

    //记录用户做题记录
    @PostMapping("/insertUserQuestion")
    public void insertUserQuestion(@RequestBody userQuestion uq){
        userquestionget.insert(uq);
    }

    //查询用户做题记录
    @PostMapping("/selectUserQuestion")
    @ResponseBody
    public List<userQuestion> selectUserQuestion(@RequestBody Map<String,String> map){
        return userquestionget.getByUserID(Integer.parseInt(map.get("userid")));
    }



    //本地实验
    @RequestMapping("/getPackageNameTest")
    @ResponseBody
    public List<String> getMovieTest(){
        return movieget.getPackageName();
    }

    //本地测试
    @RequestMapping("/getProblemTest")
    @ResponseBody
    public List<Integer> getProblemXTest(){
        return problemget.getAllProblemID();
    }

    //本地测试
    @RequestMapping("getWrongTest")
    @ResponseBody
    public List<wrongTest> getWrongTest(){
        return wrongtestget.getByUserID(2);
    }

    //本地测试
    @RequestMapping("/getuserQuestionTest")
    @ResponseBody
    public List<userQuestion> getUserQuestionXTest(){
        return userquestionget.getByUserID(1);
    }

}
