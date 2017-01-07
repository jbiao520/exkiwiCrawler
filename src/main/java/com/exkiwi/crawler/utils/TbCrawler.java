package com.exkiwi.crawler.utils;

import com.exkiwi.crawler.entity.JdItem;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by george on 2017/1/6.
 */
public class TbCrawler {
    public JdItem getTbItem(String url) throws UnsupportedEncodingException {
        JdItem ji = new JdItem();
        PhantomJsCrawler jsCrawler = new PhantomJsCrawler();
        try {
            String result = jsCrawler.getAjaxCotnent(url);
            Document doc = Jsoup.parse(result);
            String title = doc.title();
            String detail = doc.select("#J_DivItemDesc").html();
            String price = doc.select("#J_PromoPriceNum").text();
            String avatar = doc.select("#J_ImgBooth").attr("src");
            avatar=avatar.startsWith("http")?avatar:"http:"+avatar;
            if(url.contains("tmall.com")){
                price=doc.select("#J_PromoPrice > dd > div > span").text();
                detail = doc.select("#description").html();
            }
            ji.setName(title);
            ji.setPrice(price);
            ji.setoPrice("");
            ji.setUrl(url);
            ji.setAvatar(avatar);
            ji.setDetail(detail);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ji;
    }




}
