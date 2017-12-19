package xupt.se.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.idao.IStudio;
import xupt.se.ttms.model.PageBean;
import xupt.se.util.ConnectionManager;
import xupt.se.util.JsonUtil;
import xupt.se.util.StringUtil;

public class StudioDAO implements IStudio{
	
		//分页查找，返回json数组
		@SuppressWarnings("finally")
		public JSONArray StudioList(PageBean pageBean,Studio studio)throws Exception{
			Connection con = ConnectionManager.getInstance().getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			JSONArray jsonArray=null;
			try
			{
				StringBuffer sb=new StringBuffer("select * from studio");
				if(studio!=null && StringUtil.isNotEmpty(studio.getStudio_name())){
					sb.append(" and studio_name like '%"+studio.getStudio_name()+"%'");
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
		public int StudioCount(Studio studio)throws Exception{
			Connection con = ConnectionManager.getInstance().getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StringBuffer sb=new StringBuffer("select count(*) as total from Studio");
			if(StringUtil.isNotEmpty(studio.getStudio_name())){
				sb.append(" and studio_name like '%"+studio.getStudio_name()+"%'");
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
     * 存储演出厅信息
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean insert(Studio studio)
    {
        boolean result = false;
        if(studio == null)
            return result;

        // 获取Connection
        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            String sql = "insert into studio(studio_name, studio_row_count, studio_col_count, studio_introduction , studio_flag) values(?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, studio.getStudio_name());
            pstmt.setInt(2, studio.getStudio_row_count());
            pstmt.setInt(3, studio.getStudio_col_count());
            pstmt.setString(4, studio.getStudio_introduction());
            pstmt.setInt(5, studio.getStudio_flag());

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
     * 删除演出厅(通过studioId)
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean delete(int studioId)
    {
        boolean result = false;
        if(studioId == 0)
            return result;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            // 删除子某个演出厅
            String sql = "delete from studio where studio_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, studioId);
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
     * 删除多个演出厅(通过studioId)
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
            // 删除子某个演出厅
            String sql = "delete from studio where studio_id in("+delIds+")";
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
     * 修改演出厅信息
     * @return 成功与否boolean
     */
    @SuppressWarnings("finally")
    public boolean update(Studio studio)
    {
        boolean result = false;
        if(studio == null)
            return result;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        try
        {
            String sql = "update studio set studio_name=?,studio_row_count=?,studio_col_count=?,studio_introduction=?,studio_flag=? where studio_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, studio.getStudio_name());
            pstmt.setInt(2, studio.getStudio_row_count());
            pstmt.setInt(3, studio.getStudio_col_count());
            pstmt.setString(4, studio.getStudio_introduction());
            pstmt.setInt(5, studio.getStudio_flag());
            pstmt.setInt(6, studio.getStudio_id());

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
     * 根据studio_id获取用户信息(一般用于数据内部关联操作)
     * @return 用户
     */
    @SuppressWarnings("finally")
    public Studio findStudioById(int studioId)
    {
        Studio info = null;
        if(studioId == 0)
            return info;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from studio where studio_id=?");
            pstmt.setInt(1, studioId);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                // 如果有值的话再实例化
                info = new Studio();
                info.setStudio_id(rs.getInt("studio_id"));
                info.setStudio_name(rs.getString("studio_name"));
                info.setStudio_row_count(rs.getInt("studio_row_count"));
                info.setStudio_col_count(rs.getInt("studio_col_count"));
                info.setStudio_introduction(rs.getString("studio_introduction"));
                info.setStudio_flag(rs.getInt("studio_flag"));
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
     * 获取所有演出厅信息(一般用于和界面交互)
     * @return Studio列表
     */
    @SuppressWarnings("finally")
    public ArrayList<Studio> findStudioAll()
    {
        ArrayList<Studio> list = new ArrayList<Studio>();
        Studio info = null;

        Connection con = ConnectionManager.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            // 获取所有用户数据
            pstmt = con.prepareStatement("select * from studio");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                info = new Studio();

                info.setStudio_id(rs.getInt("studio_id"));
                info.setStudio_name(rs.getString("studio_name"));
                info.setStudio_row_count(rs.getInt("studio_row_count"));
                info.setStudio_col_count(rs.getInt("studio_col_count"));
                info.setStudio_introduction(rs.getString("studio_introduction"));
                info.setStudio_flag(rs.getInt("studio_flag"));
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

}
