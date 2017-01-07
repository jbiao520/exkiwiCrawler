package com.exkiwi.crawler.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by george on 2017/1/7.
 */
public class PhantomJsCrawler {
    public String getAjaxCotnent(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("phantomjs.exe --output-encoding=utf-8 C:\\phantomjs-2.1.1\\code.js "+url);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while((tmp = br.readLine())!=null){
            sbf.append(tmp);
        }
        return sbf.toString();
    }
}
