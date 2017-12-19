package xupt.se.ttms.idao;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.model.PageBean;

/**
 * 定义对演出厅表的增删改查接口
 * @author 
 */
public interface IStudio {

	// 增
    public boolean insert(Studio studio);

    // 删
    public boolean delete(int studioId);

    // 改
    public boolean update(Studio studio);

    // 查所有演出厅(一般用于和界面交互)
    public ArrayList<Studio> findStudioAll();
    
    //分页查找，返回json数组
    public JSONArray StudioList(PageBean pageBean,Studio studio) throws Exception;
    
    //返回数据总条数
    public int StudioCount(Studio studio)throws Exception;
    
    //删除多个演出厅(通过studioId)
    public int deletemount(String delIds);
    
    // 根据演出厅id查(一般用于数据内部关联操作)
    public Studio findStudioById(int studioId);
}
