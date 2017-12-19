package xupt.se.ttms.service;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.IStudio;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.model.PageBean;

public class StudioSrv {

	private IStudio studioDAO=DAOFactory.creatStudioDAO();

    public boolean add(Studio stu){
        return studioDAO.insert(stu);
    }

    public boolean update(Studio stu){
        return studioDAO.update(stu);
    }

    public boolean delete(int ID){
        return studioDAO.delete(ID);
    }
    
    public int deletemount(String delIds){
        return studioDAO.deletemount(delIds);
    }
    
    public Studio SearchById(int studioId){
    	return studioDAO.findStudioById(studioId);
    }
    
    public ArrayList<Studio>  SearchAll(){
    	return studioDAO.findStudioAll();
    }
    
    public JSONArray SearchByPage(PageBean pageBean,Studio studio) throws Exception{
    	return studioDAO.StudioList(pageBean, studio);
    }
    
    public int SearchCount(Studio studio) throws Exception {
    	return studioDAO.StudioCount(studio);
    }
}
