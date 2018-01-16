package solveConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个servlet可以对应多个action
 * @author SNOOPY
 *
 */
public class XmlMapping {

    private String servlet_name;

    private List<String> url_pattern;

    public XmlMapping() {
        url_pattern = new ArrayList<String>();
    }
    public String getServlet_name() {
        return servlet_name;
    }
    public void setServlet_name(String servlet_name) {
        this.servlet_name = servlet_name;
    }
    public List<String> getUrl_pattern() {
        return url_pattern;
    }
    public void setUrl_pattern(List<String> url_pattern) {
        this.url_pattern = url_pattern;
    }
}