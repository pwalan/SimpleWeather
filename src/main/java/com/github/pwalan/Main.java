package com.github.pwalan;


import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

/**
 * 系统入口
 * @author AlanP
 * @Date 2017/8/22
 */
public class Main {
    public static void main(String[] args) throws Exception{
        //配置log4j
        PropertyConfigurator.configure(Main.class.getClassLoader()
        .getResource("log4j.properties"));

        //获取邮政编码
        int zipcode = 60202;
        if(args.length>1){
            zipcode = Integer.parseInt(args[0]);
        }

        //开始程序
        new Main(zipcode).start();
    }

    private int zip;

    public Main(int zip){
        this.zip = zip;
    }

    public void start() throws Exception{
        //接受数据
        InputStream dataIn = new YahooRetriever().retrieve(zip);

        //处理数据
        Weather weather = new YahooParser().parse(dataIn);

        //展示结构化数据
        System.out.println(new WeatherFormatter().format(weather));
    }
}
