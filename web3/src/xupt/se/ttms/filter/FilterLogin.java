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

@WebFilter(
{ "/JSP/*" })
public class FilterLogin implements Filter
{
    public FilterLogin()
    {}

    public void destroy()
    {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {

        HttpServletRequest req = (HttpServletRequest) request;
        String flag = (String) req.getSession().getAttribute("login");
        if(flag == null || !flag.equals("ok"))
        {
            request.setAttribute("desc", "你没有登录或者找不到");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        else
            chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException
    {}

}
