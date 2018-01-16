package servlet;


import util.Request;
import util.Response;

import javax.servlet.http.HttpServlet;

public class Service extends HttpServlet {
    public void service(Request request, Response response){
        String username = (String)request.getParamter("user");
        response.htmlResponse("<html><head></head><body>This is my page<br><br>");
        response.htmlResponse("欢迎："+username+"  来到我的地盘</body></html>");
    }
}
