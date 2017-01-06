package com.exkiwi.crawler.controller;

import com.exkiwi.crawler.entity.JdItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by george on 2017/1/6.
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public JdItem getJdItem(){
        JdItem ji = new JdItem();
        ji.setName("sdfsdfs222sdfsd2d");
        return ji;
    }
}
