package com.zzj.muxin.replite;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ShanDongNewsReptile implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {

        Logger logger = Logger.getLogger("ShanDongNewsReptile");
        logger.setLevel(Level.INFO);
        logger.info("爬取的山东新闻----》" + page);
        List<String> titles = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        List<String> imgs = new ArrayList<>();
//        titles.addAll(page.getHtml().xpath("//div[@class='news-img']//a/img/@alt").all());
//        urls .addAll(page.getHtml().xpath("//div[@class='news-img']//a/@href").all());
//        imgs.addAll(page.getHtml().xpath("//div[@class='news-img']//a/img/@src").all());

        titles.addAll(page.getHtml().xpath("//div[@class='news-img']//a/img/@alt").all());
        urls .addAll(page.getHtml().xpath("//div[@class='news-img']//a/@href").all());
        imgs.addAll(page.getHtml().xpath("//div[@class='news-img']//a/img/@src").all());


        System.out.println("titles--->"+titles+"抓取数量----》"+titles.size());
        System.out.println("urls----->"+urls+"抓取数量----》"+urls.size());
        System.out.println("imgs----->"+imgs+"抓取数量----》"+imgs.size());




    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Spider.create(new ShanDongNewsReptile()).addUrl("http://sd.sina.com.cn/").thread(5).run();
            }
        }, 1000);
    }

    public static void startReptile(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Spider.create(new ShanDongNewsReptile()).addUrl("http://sd.sina.com.cn/").run();
            }
        }, 1000,60*1000*60);
    }
}
