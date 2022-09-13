package com.beginerprogrammer.programmer.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


public class runJava {
    public Map<String,String> run(String file_root_path,String file_name,String input){
        StringBuilder result= new StringBuilder();
        StringBuilder error= new StringBuilder();
        try{
            String[] command = {"/bin/sh", "-c","/runJava.sh"};
            Process p = Runtime.getRuntime().exec(command);
            PrintStream ps = new PrintStream(p.getOutputStream());
            ps.print(input+"\n");
            ps.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String buff = null;
            while ((buff = br.readLine()) != null){
                result.append(buff);
                result.append("\n");
            }
            BufferedReader er = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String errors = null;
            while ((errors = er.readLine()) != null){
                error.append(errors);
                error.append("\n");
            }
            er.close();
            br.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("error",error.toString());
        map.put("output",result.toString());
        return map;
    }
}
