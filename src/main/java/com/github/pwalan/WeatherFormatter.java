package com.github.pwalan;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

/**
 * 接受Weather对象，生成结果
 * @author AlanP
 * @Date 2017/8/22
 */
public class WeatherFormatter {
    private static Logger log = Logger.getLogger(WeatherFormatter.class);

    public String format( Weather weather ) throws Exception {
        log.info( "Formatting Weather Data" );
        Reader reader = new InputStreamReader(getClass().getClassLoader()
                        .getResourceAsStream("output.vm"));
        VelocityContext context = new VelocityContext();
        context.put("weather", weather);
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "", reader);
        return writer.toString();
    }
}