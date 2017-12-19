package xupt.se.ttms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xupt.se.ttms.dao.UserDAO;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession().invalidate();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = "用户名、密码错误!";
        String page = "index.jsp";
        UserDAO user = (UserDAO) DAOFactory.creatUserDAO();
        User currentUser = user.login(username, password);
        if(currentUser == null)
        {
            request.setAttribute("desc", result);
            request.getRequestDispatcher(page).forward(request, response);
        }
        else
        {
            HttpSession session = request.getSession();
            session.setAttribute("login", "ok");
            session.setAttribute("currentUserName", currentUser.getEmp_no());
            if(currentUser.getType() == 1)
                session.setAttribute("Admin", "ok");
            response.sendRedirect("JSP/OrdinaryUser/nav.jsp");
        }
    }

}
