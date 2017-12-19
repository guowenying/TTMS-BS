package xupt.se.ttms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import xupt.se.ttms.model.PageBean;
import xupt.se.ttms.model.User;
import xupt.se.ttms.service.UserSrv;
import xupt.se.util.StringUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/GetUser")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
        if(method.equalsIgnoreCase("delete"))
				delete(request, response);
            else
                if(method.equalsIgnoreCase("save"))
                   save(request, response);
                else
                	if(method.equalsIgnoreCase("Head"))
                		Head(request, response);
                    else
                        if(method.equalsIgnoreCase("searchByPage"))
							try {
								searchByPage(request, response);
							} catch (Exception e) {
								e.printStackTrace();
							}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
	 	response.setCharacterEncoding("utf-8"); 
    	PrintWriter pw = response.getWriter();
    	String id =request.getParameter("id");
	 	String emp_no=request.getParameter("username");
        String emp_pass=request.getParameter("password");
        String type=request.getParameter("type");
        String head_path=request.getParameter("head_path");
        User user =new User();
        user.setEmp_no(emp_no);
        user.setEmp_pass(emp_pass);
        if(StringUtil.isNotEmpty(type)) {
        	user.setType(Integer.parseInt(type));
        }
        user.setHead_path(head_path);
        UserSrv dao =new UserSrv();
        boolean TOF; 
        if(id.equals("1")){
        	TOF=dao.update(user);
		}else{
			TOF=dao.add(user);
		}
        JsonObject jsobjcet = new JsonObject();
        if(TOF){
        	jsobjcet.addProperty("success", "true");
		}else{
			jsobjcet.addProperty("success", "true");
			jsobjcet.addProperty("errorMsg", "更新失败"); 
		}
        pw.print(jsobjcet.toString());	
		pw.close();
    }
	//将所有没头像的用户设置为初始头像
	private void Head(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	String json="";
    	response.setCharacterEncoding("utf-8"); 
    	PrintWriter pw = response.getWriter();
		UserSrv dao =new UserSrv();
		ArrayList<User> f=dao.SearchByHeadIsNull();
		if(f == null){
			json = "{\"success\":" + "false" + ",\"errorMsg\":" + "未找到符合的用户" + "}"; 
			pw.write(json);
			return;
		}
		boolean delNums=false;
		for(User u:f) {
			User user = new User();
			user.setEmp_no(u.getEmp_no());
			user.setEmp_pass(u.getEmp_pass());
			user.setHead_path("../../UserImages/default.jpg");
			user.setType(u.getType());
			delNums=dao.update(user);
		}
		if(delNums){
			json = "{\"success\":" + "true" + ",\"delNums\":" + delNums + "}"; 
		}else{
			json = "{\"success\":" + "false" +",\"errorMsg\":" + "设置失败" + "}"; 
		}
		pw.print(json);	
		pw.close();
    }
	
	 private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
	    	String json="";
	    	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	    	String delIds=request.getParameter("delIds");
			String str[]=delIds.split(",");
			UserSrv dao =new UserSrv();
			for(int i=0;i<str.length;i++){
				String ss=str[i].substring(1, str[i].length()-1);
				User f=dao.SearchByNo(ss);
				if(f == null){
					json = "{\"errorIndex\":" + i + ",\"errorMsg\":" + "未找到符合该编号的用户" + "}"; 
					pw.write(json);
					return;
				}
			}
			int delNums=dao.deletemount(delIds);
			if(delNums>0){
				json = "{\"success\":" + "true" + ",\"delNums\":" + delNums + "}"; 
			}else{
				json = "{\"errorMsg\":" + "删除失败" + "}"; 
			}
			pw.print(json);	
			pw.close();
	    }
	 
	 
	 private void searchByPage(HttpServletRequest request, HttpServletResponse response) throws Exception
	    {
	    	
	    	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	    	int rows = Integer.parseInt(request.getParameter("pageSize")); 
	    	int page = Integer.parseInt(request.getParameter("pageNumber"));
			String emp_no=request.getParameter("emp_no");
			if(emp_no==null){
				emp_no="";
			}
			User user =new User();
			user.setEmp_no(emp_no);
			UserSrv dao= new UserSrv();
			PageBean pageBean=new PageBean(page,rows);			
			int total=dao.SearchCount(user);
			String jsonArray = dao.SearchByPage(pageBean, user).toString();
			String json = "{\"total\":" + total + ",\"rows\":" + jsonArray + "}"; 
			pw.print(json);	
			pw.close();
	    }

}
