package com.beginerprogrammer.programmer.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class runPython {
    public Map<String,String> run(String file_path,String input){
        StringBuilder result = new StringBuilder();
        StringBuilder error= new StringBuilder();
        try{
            String[] command = {"/bin/sh", "-c","/runPy.sh"};
            Process p = Runtime.getRuntime().exec(command);
            String line = input+"\n";
            FilterOutputStream outputStream= new FilterOutputStream(p.getOutputStream());
            byte[] bs=line.getBytes("GBK");
            outputStream.write(bs);
            outputStream.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
            String buff = null;
            while ((buff = br.readLine()) != null){
                result.append(buff);
                result.append("\n");
            }
            BufferedReader er = new BufferedReader(new InputStreamReader(p.getErrorStream(),"gbk"));
            String errors = null;
            while ((errors = er.readLine()) != null){
                error.append(errors);
                error.append("\n");
            }
            er.close();
            br.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("error",error.toString());
        map.put("output",result.toString());
        return map;
    }
}

