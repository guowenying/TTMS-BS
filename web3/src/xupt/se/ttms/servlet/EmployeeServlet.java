package xupt.se.ttms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.JsonObject;

import xupt.se.ttms.model.PageBean;
import xupt.se.ttms.dao.EmployeeDAO;
import xupt.se.ttms.dao.UserDAO;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.model.Employee;
import xupt.se.ttms.model.User;
import xupt.se.ttms.service.EmployeeSrv;
import xupt.se.ttms.service.UserSrv;
import xupt.se.util.StringUtil;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@WebServlet("/GetEmployee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final MultipartConfig config;

    // 得到注解信息
    static
    {
        config = EmployeeServlet.class.getAnnotation(MultipartConfig.class);
    } 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
        if(method.equalsIgnoreCase("ajax"))
            ajax(request, response);
        else
            if(method.equalsIgnoreCase("delete"))
					delete(request, response);
			else
                if(method.equalsIgnoreCase("updateMyprofile"))
                	updateMyprofile(request, response);
                else
                    if(method.equalsIgnoreCase("save"))
                       save(request, response);
                    else
                        if(method.equalsIgnoreCase("passchange"))
                        	passchange(request, response);
                    else
                        if(method.equalsIgnoreCase("useradd"))
                        	useradd(request, response);
                        else
                        	if(method.equalsIgnoreCase("search"))
                        		search(request, response);
                        	else
                        		if(method.equalsIgnoreCase("searchByPage"))
                        			try {
                        				searchByPage(request, response);
                        			}catch (Exception e) {
                        				// TODO 自动生成的 catch 块
                        				e.printStackTrace();
                        			}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void ajax(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setCharacterEncoding("UTF-8");
		String emp_no = (String) request.getSession().getAttribute("currentUserName");
		EmployeeDAO employeedao = (EmployeeDAO) DAOFactory.creatEmployeeDAO();
		UserDAO userdao = (UserDAO) DAOFactory.creatUserDAO();
		User user =new User();
		user=userdao.findUserByName(emp_no);
		Employee employee = new Employee();
		employee=employeedao.findEmployeeByNo(emp_no);
        JsonObject jsobjcet = new JsonObject();
        jsobjcet.addProperty("emp_id", employee.getEmp_id());
        jsobjcet.addProperty("emp_no", employee.getEmp_no());
        jsobjcet.addProperty("emp_name", employee.getEmp_name());
        jsobjcet.addProperty("emp_tel_num", employee.getEmp_tel_num());
        jsobjcet.addProperty("emp_addr", employee.getEmp_addr());
        jsobjcet.addProperty("emp_email", employee.getEmp_email());
        if(user.getType()==0)
        	jsobjcet.addProperty("type", "user");
        else
        	jsobjcet.addProperty("type", "admin");
        PrintWriter out = response.getWriter();
        out.write(jsobjcet.toString());
        out.close();
	}
	 private void save(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
		 	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
		 	String emp_id=request.getParameter("id");
	        String emp_no=request.getParameter("number");
	        String emp_name=request.getParameter("name");
	        String emp_tel_num=request.getParameter("phone");
	        String emp_addr=request.getParameter("address");
	        String emp_email=request.getParameter("email");
	        Employee employee=new Employee();
	        if(StringUtil.isNotEmpty(emp_id)){
	        	employee.setEmp_id(Integer.parseInt(emp_id));
			}
	        employee.setEmp_no(emp_no);
	        employee.setEmp_name(emp_name);
	        employee.setEmp_tel_num(emp_tel_num);
	        employee.setEmp_addr(emp_addr);
	        employee.setEmp_email(emp_email);
	        EmployeeSrv dao = new EmployeeSrv();
	        boolean TOF; 
	        if(StringUtil.isNotEmpty(emp_id)){
	        	TOF=dao.update(employee);
			}else{
				TOF=dao.add(employee);
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
	 
	 private void passchange(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
		 	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	        String emp_no=request.getParameter("id");
	        String passwordold=request.getParameter("passwordold");
	        String passwordnew=request.getParameter("passwordnew");
	        JsonObject jsobjcet = new JsonObject();
	        UserSrv userdao =new UserSrv();
	        User ss=new User();
	        User user=userdao.SearchByNo(emp_no);
	        if(user.getEmp_pass().equals(passwordold)) {
	        	ss.setEmp_no(emp_no);
	        	ss.setEmp_pass(passwordnew);
	        	ss.setType(user.getType());
	        	ss.setHead_path(user.getHead_path());
	        	userdao.update(ss);
	        	jsobjcet.addProperty("success", true);
	        }else {
	        	jsobjcet.addProperty("success", false);
	        	jsobjcet.addProperty("errorMsg", "原密码错误，更改失败");
	        }
	        pw.print(jsobjcet.toString());	
			pw.close();
	    }
	    
	    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
	    	String json="";
	    	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	    	String delIds=request.getParameter("delIds");
			String str[]=delIds.split(",");
			EmployeeSrv dao = new EmployeeSrv();
			for(int i=0;i<str.length;i++){
				Employee f=dao.SearchById(Integer.parseInt(str[i]));
				if(f == null){
					json = "{\"errorIndex\":" + i + ",\"errorMsg\":" + "未找到符合该id的员工" + "}"; 
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
	    
	    private void updateMyprofile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	    {
	    	try {
	    	Part part;
	    	EmployeeSrv employeedao = new EmployeeSrv();
	    	UserSrv userdao =new UserSrv();
	    	request.setCharacterEncoding("UTF-8");
			Employee employee1 = new Employee();
			User user=new User();
			// 接收文本
			employee1.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
			employee1.setEmp_no(request.getParameter("emp_no"));
			employee1.setEmp_addr(request.getParameter("emp_addr"));
			employee1.setEmp_email(request.getParameter("emp_email"));
			employee1.setEmp_name(request.getParameter("emp_name"));
			employee1.setEmp_tel_num(request.getParameter("emp_tel_num"));
			employeedao.update(employee1);
			// 接收图片:图片封装在part对象中
            part = request.getPart("user_image");
            String fileName = getFileName(part);
            user.setEmp_no(request.getParameter("emp_no"));
            user.setHead_path("../../UserImages/"+fileName);
            // 保存图片
            part.write(getServletContext().getRealPath("/") +"UserImages/"+fileName);
            user.setEmp_pass(userdao.SearchByNo(request.getParameter("emp_no")).getEmp_pass());
            user.setType(userdao.SearchByNo(request.getParameter("emp_no")).getType());
            userdao.update(user);
			response.sendRedirect("JSP/OrdinaryUser/my-profile.jsp");
	    	}catch(Exception e)
	        {
	            if(config.maxRequestSize() == -1L || config.maxFileSize() == -1L)
	            {
	                System.out.println("上传文件过大!");
	            }
	            request.setAttribute("desc", "上传文件过大(限制5M)，或存在异常!");
	            request.getRequestDispatcher("JSP/OrdinaryUser/my-profile.jsp").forward(request, response);
	        }
	    }
	    
	    /**
	     * 从Part的Header信息中提取上传文件的文件名
	     * @param part
	     * @return 上传文件的文件名，如果如果没有则返回null
	     */
	    private String getFileName(Part part)
	    {
	        // 获取header信息中的content-disposition，如果为文件，则可以从其中提取出文件名
	        // IE下文件名带路径，而火狐、chrome文件名不带
	        String header = part.getHeader("content-disposition");
	        String[] params = header.split(";");
	        String[] temp = params[2].split("=");
	        // 获取文件名，兼容各种浏览器的写法，去掉文件名前路径和双引号
	        String fileName = "";
	        if(temp[1].lastIndexOf("\\") < 0)
	            fileName = temp[1].substring(1, temp[1].length() - 1);
	        else
	            fileName = temp[1].substring(temp[1].lastIndexOf("\\") + 1, temp[1].length() - 1);
	        return fileName;
	    }
	    
	    private void useradd(HttpServletRequest request, HttpServletResponse response) throws IOException 
	    {
	    	String json = "";
	    	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	    	EmployeeSrv employeedao = new EmployeeSrv();
			ArrayList<Employee> e =employeedao.SearchByNotInUser();
			for(Employee s:e) {
				json+=s.getEmp_no()+",";
			}
			pw.print(json);	
			pw.close();
	    }
	    
	    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
	    	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	    	EmployeeSrv dao = new EmployeeSrv();
	        ArrayList<Employee> employeeList = dao.SearchAll();
	        String emp_no=request.getParameter("fieldId");
	        String emp_noValue=request.getParameter("fieldValue");
	        String json="";
	        if(emp_no.equals("number"))
	        {
	        	if(emp_noValue!=null)
		        {
	        		for(Employee e : employeeList)
	                {
	                    if(e.getEmp_no().equals(emp_noValue)) {
	                    	json = "{\"success\":" + false + "}"; 
	                    	break;
	                    }
	                    else
	                    	json = "{\"success\":" + true + "}";
	                }
		        }
	        	
	        }
	        else if(emp_no.equals("phone")) 
	        {
	        	if(emp_noValue!=null)
		        {
	        		for(Employee e : employeeList)
	                {
	                    if(e.getEmp_tel_num().equals(emp_noValue)) {
	                    	json = "{\"success\":" + false + "}"; 
	                    	break;
	                    }
	                    else
	                    	json = "{\"success\":" + true + "}";
	                }
		        }
	        }
	        else if(emp_no.equals("email")) 
	        {
	        	if(emp_noValue!=null)
		        {
	        		for(Employee e : employeeList)
	                {
	                    if(e.getEmp_email().equals(emp_noValue)) {
	                    	json = "{\"success\":" + false + "}"; 
	                    	break;
	                    }
	                    else
	                    	json = "{\"success\":" + true + "}";
	                }
		        }
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
			String emp_name=request.getParameter("emp_name");
			if(emp_name==null){
				emp_name="";
			}
			Employee employee=new Employee();
			employee.setEmp_name(emp_name);
			EmployeeSrv dao = new EmployeeSrv();
			PageBean pageBean=new PageBean(page,rows);			
			int total=dao.SearchCount(employee);
			String jsonArray = dao.SearchByPage(pageBean, employee).toString();
			String json = "{\"total\":" + total + ",\"rows\":" + jsonArray + "}"; 
			pw.print(json);	
			pw.close();
	    }
}