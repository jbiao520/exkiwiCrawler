package com.exkiwi.crawler.controller;

import com.exkiwi.crawler.entity.JdItem;
import com.exkiwi.crawler.utils.JdCrawler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

//@EnableAutoConfiguration
@RestController
public class ExkiwiController {
    @RequestMapping("/jd/{id}")
    public JdItem getJdItem(@PathVariable String id) throws UnsupportedEncodingException {
        //2639008
        JdCrawler jc = new JdCrawler();
        JdItem ji = jc.getJdItem(id);
        return ji;
    }
}
