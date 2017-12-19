package xupt.se.ttms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/JSP/Admin/user.jsp")
public class FilterAuthority implements Filter
{
    public FilterAuthority()
    {}

    public void destroy()
    {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        System.out.print("12344");
        HttpServletRequest req = (HttpServletRequest) request;
        String flag = (String) req.getSession().getAttribute("Admin");
        if(flag == null || !flag.equals("ok"))
        {
            request.setAttribute("desc", "无权访问管理员页面");
            request.getRequestDispatcher("/nopower.jsp").forward(request, response);
        }
        else
            chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException
    {}

}
