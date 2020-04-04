package com.tomcat.my.common;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MyRequest
 * @Description
 * @Author 戴书博
 * @Date 2020/3/30 8:54
 * @Version 1.0
 **/
public class MyRequest {

    private String url;
    private String method;

    public  MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestByte = new byte[1024];
        int length = 0;
        if((length = inputStream.read(httpRequestByte)) > 0){
            httpRequest = new String(httpRequestByte,0,length);
        }
        System.out.println("httpRequest => " + httpRequest);
        String httpHead = httpRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println("MyRequest this => " + this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

}
