package xupt.se.ttms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.清理session<br>
 * 2.跳回首页(登陆页)
 */
@WebServlet(urlPatterns = "/ExitServlet")
public class ExitServlet extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8842005334326717737L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }
}
