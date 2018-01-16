package util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class Response {

    private static final String ENTER = "\r\n";

    private static final String SPACE = " ";

    //构建输出流
    private BufferedWriter bw;

    //头信息
    private StringBuffer headInfo;
    //正文
    private StringBuffer context;

    //正文信息长度
    private int contentLength;

    public Response() {
        headInfo = new StringBuffer();
        context = new StringBuffer();
        contentLength = 0;
    }

    public Response(BufferedWriter bw1) {
        this();
        this.bw = bw1;
    }

    public void createHeader(int code) {
        headInfo.append("HTTP/1.1").append(SPACE).append(code).append(SPACE);
        switch (code) {
            case 200:
                headInfo.append("OK").append(ENTER);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(ENTER);
                break;
            case 500:
                headInfo.append("SERVER ERROR").append(ENTER);
                break;
            default:
                break;
        }
        headInfo.append("Server:myServer").append(SPACE).append("0.0.1v").append(ENTER);
        headInfo.append("Date:Sat," + SPACE).append(new Date()).append(ENTER);
        headInfo.append("Content-Type:text/html;charset=UTF-8").append(ENTER);
        headInfo.append("Content-Length:").append(contentLength).append(ENTER);
        headInfo.append(ENTER);
    }

    public Response htmlResponse(String content) {
        context.append(content).append(ENTER);
        contentLength = context.toString().getBytes().length;
        return this;
    }

    public void pushToClient(int code){
        createHeader(code);
        try {
            bw.append(headInfo.toString());
            System.out.println(headInfo.toString());
            bw.append(context.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
