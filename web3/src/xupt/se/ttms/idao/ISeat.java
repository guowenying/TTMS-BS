package xupt.se.ttms.idao;

import java.util.ArrayList;

import xupt.se.ttms.model.Seat;

/**
 * 定义对座位表的增删改查接口
 * @author 
 */
public interface ISeat {

	// 增
    public boolean insert(Seat seat);

    // 删
    public boolean delete(int seatId);

    // 改
    public boolean update(Seat seat);

    // 查所有座位(一般用于和界面交互)
    public ArrayList<Seat> findSeatAll();
    
    //获取一个演出厅所有座位信息(通过演出厅ID)
    public ArrayList<Seat> findSeatByStudioId(int studio_id);
    
    //删除多个座位(通过seatId)
    public int deletemount(String delIds);
    
    //删除演出厅的多个座位(通过studioId)
    public int deleteStudio(String studio_id);
    
    //插入演出厅的多个座位(通过studioId)
    public boolean insertseat(int studio_id,int seat_row,int seat_column,int seat_status);
}
