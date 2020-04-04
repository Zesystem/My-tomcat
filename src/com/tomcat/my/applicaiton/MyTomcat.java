package com.tomcat.my.applicaiton;

import com.tomcat.my.common.MyRequest;
import com.tomcat.my.common.MyResponse;
import com.tomcat.my.config.ServletMapping;
import com.tomcat.my.config.ServletMappingConfig;
import com.tomcat.my.servlet.MyServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyTomcat
 * @Description
 * @Author 戴书博
 * @Date 2020/3/30 9:36
 * @Version 1.0
 **/
public class MyTomcat {

    private int port = 8080;

    private Map<String,String> urlServletMap = new HashMap<String,String>();

    public MyTomcat(int port){
        this.port = port;
    }

    public void start(){
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is start");
            while(true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                MyRequest request = new MyRequest(inputStream);
                MyResponse response = new MyResponse(outputStream);
                dispatch(request,response);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initServletMapping(){
        for(ServletMapping servletMapping: ServletMappingConfig.servletMappingList){
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    private void dispatch(MyRequest request, MyResponse response){
        String clazz = urlServletMap.get(request.getUrl());
        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.service(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new MyTomcat(8080).start();
    }
}
