package xupt.se.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import xupt.se.ttms.idao.ISeat;
import xupt.se.ttms.model.Seat;
import xupt.se.util.ConnectionManager;

public class SeatDAO implements ISeat{

		/**
	     * 存储座位信息
	     * @return 成功与否boolean
	     */
	    @SuppressWarnings("finally")
	    public boolean insert(Seat seat)
	    {
	        boolean result = false;
	        if(seat == null)
	            return result;

	        // 获取Connection
	        Connection con = ConnectionManager.getInstance().getConnection();
	        PreparedStatement pstmt = null;
	        try
	        {
	            String sql = "insert into seat(studio_id, seat_row, seat_column, seat_status) values(?,?,?,?)";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, seat.getStudio_id());
	            pstmt.setInt(2, seat.getSeat_row());
	            pstmt.setInt(3, seat.getSeat_column());
	            pstmt.setInt(4, seat.getSeat_status());

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
	     * 删除座位(通过seatId)
	     * @return 成功与否boolean
	     */
	    @SuppressWarnings("finally")
	    public boolean delete(int seatId)
	    {
	        boolean result = false;
	        if(seatId == 0)
	            return result;

	        Connection con = ConnectionManager.getInstance().getConnection();
	        PreparedStatement pstmt = null;
	        try
	        {
	            // 删除子某个座位
	            String sql = "delete from seat where seat_id=?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, seatId);
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
	     * 删除多个座位(通过seatId)
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
	            // 删除子某个座位
	            String sql = "delete from seat where seat_id in("+delIds+")";
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
	     * 删除演出厅的多个座位(通过studioId)
	     * @return 成功与否boolean
	     */
	    @SuppressWarnings("finally")
	    public int deleteStudio(String delIds)
	    {
			int result=0;
	        Connection con = ConnectionManager.getInstance().getConnection();
	        PreparedStatement pstmt = null;
	        try
	        {
	            // 删除子某个座位
	            String sql = "delete from seat where studio_id in("+delIds+")";
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
	     * 插入演出厅的多个座位(通过studioId)
	     * @return 成功与否boolean
	     */
		@SuppressWarnings("finally")
		public boolean insertseat(int studio_id,int seat_row,int seat_column,int seat_status) {
			boolean result = false;
	        if(studio_id == 0)
	            return result;
	        Connection con = ConnectionManager.getInstance().getConnection();
	        PreparedStatement pstmt = null;
			try {
				// 插入某个演出厅的全部座位
				String sql = "insert into seat ( studio_id ,seat_row , seat_column,seat_status) values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, studio_id);
	            pstmt.setInt(2, seat_row);
	            pstmt.setInt(3, seat_column);
	            pstmt.setInt(4, seat_status);
	            pstmt.executeUpdate();
	            ConnectionManager.close(null, pstmt, con);
	            result = true;						
			} catch (Exception e) {
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
	     * 修改座位信息
	     * @return 成功与否boolean
	     */
	    @SuppressWarnings("finally")
	    public boolean update(Seat seat)
	    {
	        boolean result = false;
	        if(seat == null)
	            return result;

	        Connection con = ConnectionManager.getInstance().getConnection();
	        PreparedStatement pstmt = null;
	        try
	        {
	            String sql = "update seat set studio_id=?,seat_row=?,seat_column=?,seat_status=? where seat_id=?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, seat.getStudio_id());
	            pstmt.setInt(2, seat.getSeat_row());
	            pstmt.setInt(3, seat.getSeat_column());
	            pstmt.setInt(4, seat.getSeat_status());
	            pstmt.setInt(5, seat.getSeat_id());

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
	     * 获取所有座位信息(一般用于和界面交互)
	     * @return Seat列表
	     */
	    @SuppressWarnings("finally")
	    public ArrayList<Seat> findSeatAll()
	    {
	        ArrayList<Seat> list = new ArrayList<Seat>();
	        Seat info = null;

	        Connection con = ConnectionManager.getInstance().getConnection();
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try
	        {
	            // 获取所有用户数据
	            pstmt = con.prepareStatement("select * from seat");
	            rs = pstmt.executeQuery();
	            while(rs.next())
	            {
	                info = new Seat();

	                info.setSeat_id(rs.getInt("seat_id"));
	                info.setStudio_id(rs.getInt("studio_id"));
	                info.setSeat_row(rs.getInt("seat_row"));
	                info.setSeat_column(rs.getInt("seat_column"));
	                info.setSeat_status(rs.getInt("seat_status"));
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
	     * 获取一个演出厅所有座位信息(一般用于和界面交互)
	     * @return Seat列表
	     */
	    @SuppressWarnings("finally")
	    public ArrayList<Seat> findSeatByStudioId(int studio_id)
	    {
	        ArrayList<Seat> list = new ArrayList<Seat>();
	        Seat info = null;

	        Connection con = ConnectionManager.getInstance().getConnection();
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try
	        {
	            // 获取所有用户数据
	            pstmt = con.prepareStatement("select * from seat where studio_id = ?");
	            pstmt.setInt(1, studio_id);
	            rs = pstmt.executeQuery();
	            while(rs.next())
	            {
	                info = new Seat();

	                info.setSeat_id(rs.getInt("seat_id"));
	                info.setStudio_id(rs.getInt("studio_id"));
	                info.setSeat_row(rs.getInt("seat_row"));
	                info.setSeat_column(rs.getInt("seat_column"));
	                info.setSeat_status(rs.getInt("seat_status"));
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
