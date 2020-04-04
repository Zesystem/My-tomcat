package com.tomcat.my.servlet;

import com.tomcat.my.common.MyRequest;
import com.tomcat.my.common.MyResponse;

/**
 * @ClassName MyServlet
 * @Description
 * @Author 戴书博
 * @Date 2020/3/30 9:09
 * @Version 1.0
 **/
public abstract class MyServlet {

    public abstract void doGet(MyRequest request, MyResponse response);

    public abstract void doPost(MyRequest request,MyResponse response);

    public void service(MyRequest request,MyResponse response){
        if(request.getMethod().equalsIgnoreCase("POST")){
            doPost(request, response);
        }else{
            doGet(request, response);
        }
    }
}
