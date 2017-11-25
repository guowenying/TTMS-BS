package idao;

import java.util.ArrayList;

import org.apache.tomcat.jni.User;

public interface IUser
{
    // 增
    public boolean insert(org.apache.catalina.User user);

    // 删
    public boolean delete(int emp_no);

    // 改
    public boolean update(org.apache.catalina.User user);

    // 查所有User用户
    public ArrayList<model.User> findUserAll();

    // 根据用户编号查
    public ArrayList<User> findUserByNo(String userNo);

    // 根据用户type查(一般用于数据内部关联操作)
    public User findUserByType(int type);

    boolean insert(model.User user);

    boolean update(model.User user);

    User findUserByType1(int type);
}