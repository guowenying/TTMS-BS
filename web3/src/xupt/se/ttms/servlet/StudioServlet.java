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
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.service.SeatSrv;
import xupt.se.ttms.service.StudioSrv;
import xupt.se.util.StringUtil;

/**
 * Servlet implementation class StudioServlet
 */
@WebServlet("/GetStudio")
public class StudioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudioServlet() {
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
                    	if(method.equalsIgnoreCase("search"))
                    		search(request, response);
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
		int studio_rowINT=0;
		int studio_colINT=0;
	 	response.setCharacterEncoding("utf-8"); 
    	PrintWriter pw = response.getWriter();
	 	String studio_id=request.getParameter("id");
        String studio_name=request.getParameter("name");
        String studio_row=request.getParameter("row");
        String studio_col=request.getParameter("col");
        String studio_introduction=request.getParameter("introduction");
        String studio_flag=request.getParameter("flag");
        Studio studio =new Studio();
        if(StringUtil.isNotEmpty(studio_id)){
        	studio.setStudio_id(Integer.parseInt(studio_id));
		}
        studio.setStudio_name(studio_name);
        if(StringUtil.isNotEmpty(studio_row)) {
        	studio_rowINT =Integer.parseInt(studio_row);
        	studio.setStudio_row_count(studio_rowINT);
        }
        if(StringUtil.isNotEmpty(studio_col)) {
        	studio_colINT = Integer.parseInt(studio_col);
        	studio.setStudio_col_count(studio_colINT);
        }
        studio.setStudio_introduction(studio_introduction);
        if(StringUtil.isNotEmpty(studio_flag)) {
        	studio.setStudio_flag(Integer.parseInt(studio_flag));
        }
        
        StudioSrv dao =new StudioSrv();
        SeatSrv seatdao = new SeatSrv();
        boolean TOF; 
        if(StringUtil.isNotEmpty(studio_id)){
        	Studio studiomodel =dao.SearchById(Integer.parseInt(studio_id));
        	if(studiomodel.getStudio_row_count()==studio_rowINT&&studiomodel.getStudio_col_count()==studio_colINT) {
        		
        	}else {
        		seatdao.deleteseatToStudioId(studio_id);
        		for(int i=1;i<=studio_rowINT;i++) {
    				for(int j=1;j<=studio_colINT;j++) {
    					seatdao.insertseatToStudioId(Integer.parseInt(studio_id), i, j, 1);
    				}
    			}
        	}
        	TOF=dao.update(studio);
		}else{
			TOF=dao.add(studio);
			 ArrayList<Studio> studioList = dao.SearchAll();
			 int studioid = 0;
			 for(Studio s:studioList) {
				 if(s.getStudio_id()>studioid)
					 studioid = s.getStudio_id();
			 }
			for(int i=1;i<=studio_rowINT;i++) {
				for(int j=1;j<=studio_colINT;j++) {
					seatdao.insertseatToStudioId(studioid, i, j, 1);
				}
			}
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
	
	 private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
	    	String json="";
	    	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	    	String delIds=request.getParameter("delIds");
			String str[]=delIds.split(",");
			StudioSrv dao =new StudioSrv();
			SeatSrv seatdao = new SeatSrv();
			for(int i=0;i<str.length;i++){
				Studio f=dao.SearchById(Integer.parseInt(str[i]));
				if(f == null){
					json = "{\"errorIndex\":" + i + ",\"errorMsg\":" + "未找到符合该id的演出厅" + "}"; 
					pw.write(json);
					return;
				}
			}
			seatdao.deleteseatToStudioId(delIds);
			int delNums=dao.deletemount(delIds);
			if(delNums>0){
				json = "{\"success\":" + "true" + ",\"delNums\":" + delNums + "}"; 
			}else{
				json = "{\"errorMsg\":" + "删除失败" + "}"; 
			}
			pw.print(json);	
			pw.close();
	    }
	 
	 private void search(HttpServletRequest request, HttpServletResponse response) throws IOException
	    {
	    	response.setCharacterEncoding("utf-8"); 
	    	PrintWriter pw = response.getWriter();
	    	StudioSrv dao=new StudioSrv();
	        ArrayList<Studio> studioList = dao.SearchAll();
	        String emp_no=request.getParameter("fieldId");
	        String emp_noValue=request.getParameter("fieldValue");
	        String json="";
	        if(emp_no.equals("name"))
	        {
	        	if(emp_noValue!=null)
		        {
	        		for(Studio e : studioList)
	                {
	                    if(e.getStudio_name().equals(emp_noValue)) {
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
			String studio_name=request.getParameter("studio_name");
			if(studio_name==null){
				studio_name="";
			}
			Studio studio =new Studio();
			studio.setStudio_name(studio_name);
			StudioSrv dao= new StudioSrv();
			PageBean pageBean=new PageBean(page,rows);			
			int total=dao.SearchCount(studio);
			String jsonArray = dao.SearchByPage(pageBean, studio).toString();
			String json = "{\"total\":" + total + ",\"rows\":" + jsonArray + "}"; 
			pw.print(json);	
			pw.close();
	    }
}
