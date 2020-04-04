package com.tomcat.my.servlet;

import com.tomcat.my.common.MyRequest;
import com.tomcat.my.common.MyResponse;

import java.io.IOException;

/**
 * @ClassName HelloWorldServlet
 * @Description
 * @Author 戴书博
 * @Date 2020/3/30 9:27
 * @Version 1.0
 **/
public class HelloWorldServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        this.doGet(request, response);
    }
}
