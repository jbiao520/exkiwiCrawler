package com.exkiwi.crawler.utils;

import com.exkiwi.crawler.entity.JdItem;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by george on 2017/1/6.
 */
public class JdCrawler {
    public static final String SESSION_INIT = "https://item.jd.com/";
    public static final String priceAPI = "http://p.3.cn/prices/mgets?skuIds=J_#ID#&type=1";
    public JdItem getJdItem(String id) throws UnsupportedEncodingException {
        JdItem ji = new JdItem();
        String pageUrl = SESSION_INIT+id+".html";
        String priceUrl = priceAPI.replaceFirst("#ID#",id);
        Document doc = null;
        try {
            doc = Jsoup.connect(pageUrl).timeout(100000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpClientHelper hc = new HttpClientHelper(true);
        HttpResult pr = hc.get(priceUrl);
        System.out.println(pr.getHtml());
        JSONObject prJson = new JSONObject(pr.getHtml().substring(1,pr.getHtml().length()-2));
        String price = prJson.getString("p");
        String oPrice = prJson.getString("op");
        ji.setPrice(price);
        ji.setName(doc.select("#name > h1").text());
        ji.setoPrice(oPrice);
        return ji;
    }
    /**
     * @param args
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            Document document = Jsoup.connect("https://item.jd.com/2639008.html").timeout(100000).get();
            System.out.println(document.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Header[] setHeader() {
        Header[] result = {
                new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36"),
                new BasicHeader("Accept-Encoding","deflate"),
                new BasicHeader("Accept-Language","zh-CN,zh;q=0.8"),
                new BasicHeader("Cache-Control","no-cache"),
                new BasicHeader("Connection","Keep-Alive"),
                new BasicHeader("Content-Type","application/x-www-form-urlencoded"),
                new BasicHeader("Host","item.jd.com"),
                new BasicHeader("Referer","https://www.jd.com/"),
                new BasicHeader("Upgrade-Insecure-Requests","1"),
                new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
        };
        return result;
    }



}