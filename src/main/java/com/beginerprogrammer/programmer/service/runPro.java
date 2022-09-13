package com.beginerprogrammer.programmer.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class runPro {

    String file_root_path = "/root";
    String file_name = "Test";

    public Map<String,String> run(Map<String,String> map) {
        json2file load = new json2file(map);
        String suffix = load.to_file(file_root_path,file_name);
        String input = load.getInput();
        Map<String,String> result = new HashMap<String, String>();
        if(suffix.equals(".c")){
            result = new runC().run(file_root_path,file_name,input);
        }else if(suffix.equals(".cpp")){
            result = new runCC().run(file_root_path,file_name,input);
        }else if(suffix.equals(".java")){
            result = new runJava().run(file_root_path,file_name,input);
        }else if(suffix.equals(".py")){
            result = new runPython().run(file_root_path +"/"+ file_name,input);
        }
        return result;
    }
}
