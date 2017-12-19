package xupt.se.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import xupt.se.ttms.idao.IUser;
import xupt.se.ttms.model.User;
import xupt.se.ttms.model.PageBean;
import xupt.se.util.ConnectionManager;
import xupt.se.util.JsonUtil;
import xupt.se.util.StringUtil;

public class UserDAO implements IUser
{
	//分页查找，返回json数组
		@SuppressWarnings("finally")
		public JSONArray UserList(PageBean pageBean,User user)throws Exception{
			Connection con = ConnectionManager.getInstance().getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			JSONArray jsonArray=null;
			try
			{
				StringBuffer sb=new StringBuffer("select * from user");
				if(user!=null && StringUtil.isNotEmpty(user.getEmp_no())){
					sb.append(" and emp_no like '%"+user.getEmp_no()+"%'");
				}
				if(pageBean!=null){
					sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
				}
				pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
				rs=pstmt.executeQuery();
				jsonArray=JsonUtil.formatRsToJsonArray(rs);
		   }catch(Exception e)
	    	{
	           e.printStackTrace();
	       }
	       finally
	       {
	           // 关闭连接
	           ConnectionManager.close(rs, pstmt, con);
	           return jsonArray;
	       }
		}
		
		//返回总条数
		public int UserCount(User user)throws Exception{
			Connection con = ConnectionManager.getInstance().getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer sb=new StringBuffer("select count(*) as total from user");
			if(StringUtil.isNotEmpty(user.getEmp_no())){
				sb.append(" and emp_no like '%"+user.getEmp_no()+"%'");
			}
			pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
			rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt("total");
			}else{
				return 0;
			}
		}
	
    /**
     * 存储用户密码与权限
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean insert(User user)
    {
        boolean result = false;
        if(user == null)
            return result;

        // 获取Connection
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            String sql = "insert into user(emp_no, emp_pass, type, head_path) values(?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmp_no());
            pstmt.setString(2, user.getEmp_pass());
            pstmt.setInt(3, user.getType());
            pstmt.setString(4, user.getHead_path());

            pstmt.executeUpdate();
            result = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }

    /**
     * 删除用户密码与权限(通过username)
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean delete(String UserName)
    {
        boolean result = false;
        if(UserName == null || UserName.equals(""))
            return result;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            // 删除子某个用户
            String sql = "delete from user where emp_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, UserName);
            pstmt.executeUpdate();
            ConnectionManager.close(null, pstmt, con);

            result = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }
    
    /**
     * 删除多个用户(通过userno)
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public int deletemount(String delIds)
    {
		int result=0;
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            // 删除子某个用户
            String sql = "delete from user where emp_no in("+delIds+")";
            pstmt = con.prepareStatement(sql);
            int delNums=pstmt.executeUpdate();
            ConnectionManager.close(null, pstmt, con);

            result = delNums;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
	}

    /**
     * 修改用户密码与权限信息
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean update(User user)
    {
        boolean result = false;
        if(user == null)
            return result;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            String sql = "update user set emp_no=?,emp_pass=?,type=?,head_path=?where emp_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getEmp_no());
            pstmt.setString(2, user.getEmp_pass());
            pstmt.setInt(3, user.getType());
            pstmt.setString(4, user.getHead_path());
            pstmt.setString(5, user.getEmp_no());

            pstmt.executeUpdate();
            result = true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // 关闭连接
            ConnectionManager.close(null, pstmt, con);
            return result;
        }
    }

    /**
     * 获取所有用户信息(一般用于和界面交互)
     * @return User列表
     */
    @SuppressWarnings("finally")
    public ArrayList<User> findUserAll()
    {
        ArrayList<User> list = new ArrayList<User>();
        User info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from user");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                info = new User();

                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_pass(rs.getString("emp_pass"));
                info.setType(rs.getInt("type"));
                info.setHead_path(rs.getString("head_path"));
                // 加入列表
                list.add(info);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return list;
        }
    }

    /**
     * 获取所有头像信息为空用户信息(一般用于和界面交互)
     * @return User列表
     */
    @SuppressWarnings("finally")
    public ArrayList<User> findUserByHeadIsNull()
    {
        ArrayList<User> list = new ArrayList<User>();
        User info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from user where head_path = ''");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                info = new User();

                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_pass(rs.getString("emp_pass"));
                info.setType(rs.getInt("type"));
                info.setHead_path(rs.getString("head_path"));
                // 加入列表
                list.add(info);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return list;
        }
    }
    /**
     * 根据用户名获取用户密码权限信息(一般用于和界面交互)
     * @return User
     */
    @SuppressWarnings("finally")
    public User findUserByName(String UserName)
    {
        if(UserName == null || UserName.equals(""))
            return null;

        User info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据:模糊查询
            pstmt = con.prepareStatement("select * from user where emp_no like ?");
            pstmt.setString(1, "%" + UserName + "%");// 拼接模糊查询串
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                // 如果有值的话再实例化
                info = new User();
                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_pass(rs.getString("emp_pass"));
                info.setType(rs.getInt("type"));
                info.setHead_path(rs.getString("head_path"));
                // 加入列表
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return info;
        }
    }
    	
    /**
     * 根据用户名和密码判断是否存在
     * @return User
     */
    @SuppressWarnings("finally")
    public User login(String UserName,String PassWord)
    {
        if(UserName == null || UserName.equals(""))
            return null;
        if(PassWord == null || PassWord.equals(""))
            return null;
        User info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取用户
            pstmt = con.prepareStatement("select * from user where emp_no=? and emp_pass=?");
            pstmt.setString(1, UserName);
            pstmt.setString(2, PassWord);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                // 如果有值的话再实例化
                info = new User();
                info.setEmp_no(rs.getString("emp_no"));
                info.setEmp_pass(rs.getString("emp_pass"));
                info.setType(rs.getInt("type"));
                info.setHead_path(rs.getString("head_path"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionManager.close(rs, pstmt, con);
            return info;
        }
    }
}
