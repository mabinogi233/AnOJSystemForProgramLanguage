package com.beginerprogrammer.programmer.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class runC {
    public Map<String,String> run(String file_root_path,String file_name, String input){
        StringBuilder result= new StringBuilder();
        StringBuilder error= new StringBuilder();
        try {
            Process pc;
            Runtime rt;
            rt = Runtime.getRuntime();
            String[] command = {"/bin/sh", "-c","/runC.sh"};
            pc = Runtime.getRuntime().exec(command);
            OutputStream fos = pc.getOutputStream();
            PrintStream ps = new PrintStream(fos);
            ps.print(input+"\n");
            ps.flush();
            InputStream ios = pc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ios, "gbk"));
            String s;
            while ((s = br.readLine()) != null) {
                result.append(s);
                result.append("\n");
            }
            BufferedReader er = new BufferedReader(new InputStreamReader(pc.getErrorStream()));
            String errors = null;
            while ((errors = er.readLine()) != null){
                error.append(errors);
                error.append("\n");
            }
            er.close();
            br.close();
            ios.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("error",error.toString());
        map.put("output",result.toString());
        return map;
    }
}
