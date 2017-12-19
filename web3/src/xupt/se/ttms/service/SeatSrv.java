package xupt.se.ttms.service;

import java.util.ArrayList;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.ISeat;
import xupt.se.ttms.model.Seat;

public class SeatSrv {

	private ISeat seatDAO=DAOFactory.creatSeatDAO();

    public boolean add(Seat stu){
        return seatDAO.insert(stu);
    }

    public boolean update(Seat stu){
        return seatDAO.update(stu);
    }

    public boolean delete(int ID){
        return seatDAO.delete(ID);
    }
    
    public int deletemount(String delIds){
        return seatDAO.deletemount(delIds);
    }
    
    public ArrayList<Seat>  SearchAll(){
    	return seatDAO.findSeatAll();
    }
    
    public ArrayList<Seat> SearchByStudioId(int studio_id){
    	return seatDAO.findSeatByStudioId(studio_id);
    }
    
    public  int deleteseatToStudioId(String studio_id) {
    	return seatDAO.deleteStudio(studio_id);
    }
    
    public boolean insertseatToStudioId(int studio_id,int seat_row,int seat_column,int seat_status) {
    	return seatDAO.insertseat(studio_id, seat_row, seat_column, seat_status);
    }
}
