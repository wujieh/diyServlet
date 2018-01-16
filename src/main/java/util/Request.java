package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Request {
    private String action;
    private String method;
    private BufferedReader reader;
    //存放request请求信息
    private ArrayList<String> list = new ArrayList<String>();

    //存放请求参数
    private HashMap<String, String> parameter = new HashMap<String, String>();

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Request(BufferedReader reader1) {
        this.reader = reader1;
        analyzeRequest();
    }

    private void analyzeRequest() {
        try {
            String content = reader.readLine();
            while (!("".equals(content.trim()))) {
                list.add(content);
                content = reader.readLine();
            }
            getRequestAction();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getRequestAction() {
        String firstLine = list.get(0);
        System.out.println(firstLine);
        if(firstLine.indexOf("/favicon.ico")!=-1)
        {
            return;
        }
        String requestType = firstLine.trim().substring(0, firstLine.trim().indexOf("/")).trim();
        String firstLine1 = firstLine.substring(firstLine.indexOf("?")+1).trim();
        String[] firstLine2 = firstLine1.split("&");
        for (String str1 : firstLine2) {
            String[] firstLine3 = str1.split("=");
            if (firstLine3.length == 1) {
                parameter.put(firstLine3[0], null);
            } else {
                parameter.put(firstLine3[0], firstLine3[1]);
            }
        }
        if (requestType.equals("post")) {
            System.out.println("post请求");
        } else if (requestType.equals("GET")) {
            int firstLineIndex = firstLine.indexOf("/");
            String newFirstLine = firstLine.substring(firstLineIndex);
            action = newFirstLine.substring(0,newFirstLine.indexOf("?")).trim();
            System.out.println(action);
        }
    }

    public String getParamter(String key) {
         String value = parameter.get(key);
         if(value==null)
         {
             return "";
         }else{
             return value;
         }
    }
}
