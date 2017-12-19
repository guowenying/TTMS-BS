package xupt.se.ttms.idao;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import xupt.se.ttms.model.Employee;
import xupt.se.ttms.model.PageBean;

/**
 * 定义对用户表的增删改查接口
 * @author 张荣
 */
public interface IEmployee
{
    // 增
    public boolean insert(Employee employee);

    // 删
    public boolean delete(int employeeId);

    // 改
    public boolean update(Employee employee);

    // 查所有用户(一般用于和界面交互)
    public ArrayList<Employee> findEmployeeAll();
    
    // 查所有没有账户的用户信息(一般用于和界面交互)
    public ArrayList<Employee> findEmployeeByNotInUser();

    // 根据用户名查(一般用于和界面交互)
    public ArrayList<Employee> findEmployeeByName(String employeeName);

    // 根据用户id查(一般用于数据内部关联操作)
    public Employee findEmployeeById(int employeeId);

    // 根据用户no查(一般用于数据内部关联操作)
    public Employee findEmployeeByNo(String employee_no);
    
    //分页查找，返回json数组
    public JSONArray EmployeeList(PageBean pageBean,Employee employee) throws Exception;
    
    //返回数据总条数
    public int EmployeeCount(Employee employee)throws Exception;
    
    //删除多个用户(通过employeeId)
    public int deletemount(String delIds);
}
