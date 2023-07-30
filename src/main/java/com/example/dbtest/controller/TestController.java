package com.example.dbtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dbtest.TestRepository;

/**
 * TestController
 */
@Controller
@RequestMapping("/")
@ResponseBody
public class TestController {
    @GetMapping()
    public String index(){
        return "ホーム画面だよ";
    }

    @GetMapping("db")
    public String db() {
        var x = new TestRepository();
        return "DB" + x.hoge();
    }
}