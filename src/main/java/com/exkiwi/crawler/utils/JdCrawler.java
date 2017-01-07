package com.exkiwi.crawler.utils;

import com.exkiwi.crawler.entity.JdItem;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by george on 2017/1/6.
 */
public class JdCrawler {
    public static final String SESSION_INIT = "https://item.jd.com/";
    public static final String priceAPI = "http://p.3.cn/prices/mgets?skuIds=J_#ID#&type=1";

    public JdItem getJdItem(String url) {
        JdItem ji = new JdItem();
        PhantomJsCrawler jsCrawler = new PhantomJsCrawler();
        try {
            String result = jsCrawler.getAjaxCotnent(url);
            Document doc = Jsoup.parse(result);
            String title = doc.title();
            String detail = doc.select("#J-detail-content").outerHtml().replaceAll("data-lazyload=\"//","src=\"http://");
            String avatar = doc.select("#spec-n1 > img").attr("jqimg");
            avatar=avatar.startsWith("http")?avatar:"http:"+avatar;
            //get price
            String itemId = url.split("https://item.jd.com/")[1].split(".html")[0];
            String priceUrl = priceAPI.replaceFirst("#ID#",itemId);
            HttpClientHelper hc = new HttpClientHelper(true);
            HttpResult pr = hc.get(priceUrl);
            JSONObject prJson = new JSONObject(pr.getHtml().substring(1,pr.getHtml().length()-2));
            String price = prJson.getString("p");
            String oPrice = prJson.getString("op");
            ji.setName(title);
            ji.setAvatar(avatar);
            ji.setoPrice(oPrice);
            ji.setPrice(price);
            ji.setUrl(url);
            ji.setDetail(detail);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ji;
    }

//    public static void main(String args[]) {
//        JdItem ji = new JdItem();
//        PhantomJsCrawler jsCrawler = new PhantomJsCrawler();
//        String url = "https://item.jd.com/10809967515.html";
//        try {
//            String result = jsCrawler.getAjaxCotnent(url);
//            Document doc = Jsoup.parse(result);
//            String title = doc.title();
//            System.out.println("start crawl jd");
//            Elements elements = doc.select("#J-detail-content").get(0).select("img");
//            System.out.println("start crawl jd:"+elements.size());
//            StringBuffer detailSb =new StringBuffer();
//            for(int i=0;i<elements.size();i++){
//                System.out.println("elements.get(i).attr(\"src\"):"+elements.get(i).outerHtml());
//                String imgSrc = elements.get(i).attr("data-lazyload");
//                if(imgSrc.isEmpty()){
//                    imgSrc=elements.get(i).attr("src");
//                }
//                imgSrc=imgSrc.startsWith("http")?imgSrc:"http:"+imgSrc;
//                detailSb.append(imgSrc+"@@@");
//            }
//            System.out.println(detailSb.toString());
//            String avatar = doc.select("#spec-n1 > img").attr("jqimg");
//            avatar=avatar.startsWith("http")?avatar:"http:"+avatar;
//            //get price
//            String itemId = url.split("https://item.jd.com/")[1].split(".html")[0];
//            String priceUrl = priceAPI.replaceFirst("#ID#",itemId);
//            HttpClientHelper hc = new HttpClientHelper(true);
//            HttpResult pr = hc.get(priceUrl);
//            JSONObject prJson = new JSONObject(pr.getHtml().substring(1,pr.getHtml().length()-2));
//            String price = prJson.getString("p");
//            String oPrice = prJson.getString("op");
//            ji.setName(title);
//            ji.setAvatar(avatar);
//            ji.setoPrice(oPrice);
//            ji.setPrice(price);
//            ji.setUrl(url);
//            ji.setDetail(detailSb.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
