package com.beginerprogrammer.programmer.service;

import com.beginerprogrammer.programmer.dao.movieMapper;
import com.beginerprogrammer.programmer.entity.movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieGet {
    @Autowired
    private movieMapper moviemapper;

    public List<String> getPackageName(){
        return moviemapper.selectALLPackageName();
    }

    public List<movie> getByPackageName(String packageName){
        return moviemapper.selectByPackageName(packageName);
    }
}
