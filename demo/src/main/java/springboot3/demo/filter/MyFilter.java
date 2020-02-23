package springboot3.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: demo
 * @description:
 * @author: doddd
 * @create: 2020-02-20 20:54
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
