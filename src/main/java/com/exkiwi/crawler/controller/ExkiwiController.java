package com.exkiwi.crawler.controller;

import com.exkiwi.crawler.entity.JdItem;
import com.exkiwi.crawler.utils.JdCrawler;
import com.exkiwi.crawler.utils.TbCrawler;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

//@EnableAutoConfiguration
@RestController
public class ExkiwiController {
    @RequestMapping(value = "jdItemDetails",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public JdItem getJdItem(@RequestParam(value = "url") String url) throws UnsupportedEncodingException {
        //2639008
        JdCrawler jc = new JdCrawler();
        JdItem ji = jc.getJdItem(url);
        return ji;
    }

    @RequestMapping(value = "tbItemDetails",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public JdItem getTbItem(@RequestParam(value = "url") String url) throws UnsupportedEncodingException {
        //2639008
        TbCrawler tc = new TbCrawler();
        JdItem ji = tc.getTbItem(url);
        return ji;
    }
}
