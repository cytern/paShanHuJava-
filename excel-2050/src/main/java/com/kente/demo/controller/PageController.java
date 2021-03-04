package com.kente.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("excel/index")
    String getIndex(){
        return "uploadExcel";
    }

}
