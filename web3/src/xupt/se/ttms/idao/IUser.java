package xupt.se.ttms.idao;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import xupt.se.ttms.model.PageBean;
import xupt.se.ttms.model.User;

/**
 * 定义对用户密码权限表的增删改查接口
 * @author
 */
public interface IUser
{
    // 增
    public boolean insert(User user);

    // 删
    public boolean delete(String UserName);

    // 改
    public boolean update(User user);

    // 查所有用户(一般用于和界面交互)
    public ArrayList<User> findUserAll();
    
    // 查所有未设置头像的用户(一般用于和界面交互)
    public ArrayList<User> findUserByHeadIsNull();

    // 根据用户名查(一般用于和界面交互)
    public User findUserByName(String UserName);

    //删除多个用户(通过emp_no)
    public int deletemount(String delIds);
    
    //分页查找，返回json数组
    public JSONArray UserList(PageBean pageBean,User user) throws Exception;
    
    //返回数据总条数
    public int UserCount(User user)throws Exception;
}
