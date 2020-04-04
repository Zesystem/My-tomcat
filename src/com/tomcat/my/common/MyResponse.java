package com.tomcat.my.common;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName MyResponse
 * @Description
 * @Author 戴书博
 * @Date 2020/3/30 9:03
 * @Version 1.0
 **/
public class MyResponse {

    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }

}
