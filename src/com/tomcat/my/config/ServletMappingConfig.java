package com.tomcat.my.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ServletMappingConfig
 * @Description
 * @Author 戴书博
 * @Date 2020/3/30 9:33
 * @Version 1.0
 **/
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static{
        servletMappingList.add(new ServletMapping("findGril","/girl","com.tomcat.my.servlet.FriendGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld","/world","com.tomcat.my.servlet.HelloWorldServlet"));
    }
}
