package com.example.dbtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dbtest.TestRepository;
import com.example.dbtest.service.TestService;

/**
 * TestController
 */
@Controller
@RequestMapping("/")
@ResponseBody
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping()
    public String index(){
        return testService.index();
    }

    @GetMapping("db")
    public String db() {
        var x = new TestRepository();
        return "DB" + x.select("select * from table1 where id=5");
    }
}