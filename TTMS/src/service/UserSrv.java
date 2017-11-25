package service;

import idao.DAOFactory;
import idao.IUser;

import java.util.ArrayList;

import org.apache.catalina.User;

public class UserSrv
{
    private IUser userDAO = DAOFactory.creatUserDAO();

    public boolean add(User user)
    {
        return userDAO.insert(user);
    }

    public boolean update(User user)
    {
        return userDAO.update(user);
    }

    public boolean delete(int ID)
    {
        return userDAO.delete(ID);
    }

    public ArrayList<model.User> FetchAll()
    {
        return userDAO.findUserAll();
    }

    public ArrayList<org.apache.tomcat.jni.User> findUserByNo(String no)
    {
        return userDAO.findUserByNo(no);
    }

    public User findUserByType(int type)
    {
        return (User) userDAO.findUserByType(type);
    }

}
