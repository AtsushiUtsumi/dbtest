package com.example.dbtest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dbtest.TestRepository;

/**
 * TestService
 */
@Service
public class TestService {

    public String index() {
        return "サービステスト";
    }

    @Transactional
    public void fuga() {
        var x = new TestRepository();
        x.select("select * from table1 where id=5");
    }
}