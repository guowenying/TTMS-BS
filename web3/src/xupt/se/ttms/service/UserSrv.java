package xupt.se.ttms.service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.IUser;
import xupt.se.ttms.model.PageBean;
import xupt.se.ttms.model.User;

public class UserSrv {

	private IUser userDAO=DAOFactory.creatUserDAO();

    public boolean add(User user){
        return userDAO.insert(user);
    }

    public boolean update(User user){
        return userDAO.update(user);
    }

    public boolean delete(String UserName){
        return userDAO.delete(UserName);
    }
    
    public int deletemount(String delIds){
        return userDAO.deletemount(delIds);
    }
    
    public User SearchByNo(String emp_no){
    	return userDAO.findUserByName(emp_no);
    }
    
    public ArrayList<User>  SearchAll(){
    	return userDAO.findUserAll();
    }
    
    public ArrayList<User>  SearchByHeadIsNull(){
    	return userDAO.findUserByHeadIsNull();
    }
    
    public JSONArray SearchByPage(PageBean pageBean,User user) throws Exception{
    	return userDAO.UserList(pageBean, user);
    }
    
    public int SearchCount(User user) throws Exception {
    	return userDAO.UserCount(user);
    }
}
