import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.HttpJspPage;
import java.io.IOException;

/**
 * @author Riddle
 * @description
 * @time 2021-08-22 22:29
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1.调用构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("2.初始化");
        String username = servletConfig.getInitParameter("username");
        System.out.println(username);
        ServletContext servletContext = servletConfig.getServletContext();
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
        System.out.println(servletContext);



    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是处理请求并相应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3. service===helloServlet");
        HttpServletRequest hsr= (HttpServletRequest) servletRequest;
        String method = hsr.getMethod();
        if("GET".equals(method)){
            System.out.println("GET");
            servletResponse.setContentType("text/html;charset=UTF-8");
            servletResponse.getWriter().write("中国");
        }else if("POST".equals(method)){
            System.out.println("POST");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁方法");
    }
}
