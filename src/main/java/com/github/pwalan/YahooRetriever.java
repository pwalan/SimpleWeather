package com.github.pwalan;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 连接Yahoo!Weather，返回xml数据
 * @author AlanP
 * @Date 2017/8/22
 */
public class YahooRetriever {

    private static Logger log = Logger.getLogger(YahooRetriever.class);

    public InputStream retrieve(int zipcode) throws Exception {
        log.info( "Retrieving Weather Data" );
        //该地址可能无法使用了，新地址为https://developer.yahoo.com/weather/
        String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
