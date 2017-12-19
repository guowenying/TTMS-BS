package xupt.se.ttms.service;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.IEmployee;
import xupt.se.ttms.model.Employee;
import xupt.se.ttms.model.PageBean;

import java.util.ArrayList;

import net.sf.json.JSONArray;

public class EmployeeSrv {
    private IEmployee employeeDAO=DAOFactory.creatEmployeeDAO();

    public boolean add(Employee stu){
        return employeeDAO.insert(stu);
    }

    public boolean update(Employee stu){
        return employeeDAO.update(stu);
    }

    public boolean delete(int ID){
        return employeeDAO.delete(ID);
    }
    
    public int deletemount(String delIds){
        return employeeDAO.deletemount(delIds);
    }
    
    public ArrayList<Employee>  SearchAll(){
    	return employeeDAO.findEmployeeAll();
    }
    
    public ArrayList<Employee>  SearchByNotInUser(){
    	return employeeDAO.findEmployeeByNotInUser();
    }
    
    public ArrayList<Employee>  SearchByName(String employeeName){
    	return employeeDAO.findEmployeeByName(employeeName);
    }
    
    public Employee SearchById(int employeeId){
    	return employeeDAO.findEmployeeById(employeeId);
    }
    
    public Employee SearchByNo(String employee_no){
    	return employeeDAO.findEmployeeByNo(employee_no);
    }
    
    public JSONArray SearchByPage(PageBean pageBean,Employee employee) throws Exception{
    	return employeeDAO.EmployeeList(pageBean, employee);
    }
    
    public int SearchCount(Employee employee) throws Exception {
    	return employeeDAO.EmployeeCount(employee);
    }
}
