package com.beginerprogrammer.programmer.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;


public class json2file {
    String codes;
    String type;
    String input;
    public json2file(Map<String,String> object){
        codes=object.get("code");
        type= object.get("type");
        input=object.get("input");
    }
    //根路径和文件名称（无后缀）,返回后缀名
    public String to_file(String file_root_path,String file_name){

        FileOutputStream fileOutputStream = null;
        String suffix="";
        if(type.equals("python")){
            suffix=".py";
        }else if(type.equals("c")||type.equals("C")){
            suffix=".c";
        }else if(type.equals("c++")||type.equals("C++")){
            suffix=".cpp";
        }else if(type.equals("java")){
            suffix=".java";
        }
        File file = new File(file_root_path+"/"+file_name+suffix);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(codes.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suffix;
    }

    public String getInput() {
        return input;
    }
}
