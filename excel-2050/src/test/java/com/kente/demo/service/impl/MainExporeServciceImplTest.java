package com.kente.demo.service.impl;

import com.kente.demo.service.MainExporeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MainExporeServciceImplTest {
    @Autowired
private MainExporeService mainExporeService;
    @Test
    void operateData() {
          mainExporeService.operateData("C:\\Users\\24771\\Desktop\\数\\标书\\test\\acc.xls");
    }

    @Test
    void initKenteCom() {
    }

    @Test
    void initExcel() {
    }

    @Test
    void getComData() {
    }
}