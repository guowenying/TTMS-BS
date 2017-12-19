package xupt.se.ttms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xupt.se.ttms.model.Seat;
import xupt.se.ttms.service.SeatSrv;
import xupt.se.util.StringUtil;

/**
 * Servlet implementation class SeatServlet
 */
@WebServlet("/GetSeat")
public class SeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
        if(method.equalsIgnoreCase("getstatus"))
        	getstatus(request, response);
        else
            if(method.equalsIgnoreCase("savestatus"))
            	savestatus(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void getstatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String studio_id =request.getParameter("studio_id");
		response.setCharacterEncoding("utf-8"); 
    	PrintWriter pw = response.getWriter();
    	SeatSrv seatdao = new SeatSrv();
    	String json ="";
    	if(StringUtil.isNotEmpty(studio_id))
    	{
    		ArrayList<Seat> ss=seatdao.SearchByStudioId(Integer.parseInt(studio_id));
    		for(Seat s:ss) {
    			json += s.getSeat_status()+",";
        	}
    	}else {
    		json = "false"; 
    	}
    	pw.print(json);	
		pw.close();
	}
	//管理员设置座位状态保存
	private void savestatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int i=0;
		String json="";
    	response.setCharacterEncoding("utf-8"); 
    	PrintWriter pw = response.getWriter();
    	String studio_id =request.getParameter("studio_id");
    	String delIds=request.getParameter("saveStatus");
		String str[]=delIds.split(",");
		SeatSrv seatdao =new SeatSrv();
		boolean TOF=false;
		if(StringUtil.isNotEmpty(studio_id))
    	{
    		ArrayList<Seat> ss=seatdao.SearchByStudioId(Integer.parseInt(studio_id));
    		for(Seat s:ss) {
    			s.setSeat_status(Integer.parseInt(str[i]));
    			i++;
    			TOF=seatdao.update(s);
    		}
    	}
		if(TOF) {
			json = "{\"success\":" + true + "}"; 
		}else {
			json = "{\"success\":" + false + ",\"errormessage\":" + "更新失败" + "}"; 
		}		
		pw.print(json);	
		pw.close();
	}
}
