package solveConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * servlet的上下文
 * @author SNOOPY
 *
 */
public class ServletContext {

    //通过对应的servlet类名创建servlet对象
    //private Map<String, Servlet> servlet ;
    private Map<String, String> servlet ;
    //通过请求名（action）找到对应的servlet类名
    private Map<String , String> mapping ;

    public ServletContext() {
        servlet = new HashMap<String,String>();
        mapping = new HashMap<String,String>();
    }


    public Map<String, String> getServlet() {
        return servlet;
    }
    public void setServlet(Map<String, String> servlet) {
        this.servlet = servlet;
    }


    public Map<String, String> getMapping() {
        return mapping;
    }
    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
