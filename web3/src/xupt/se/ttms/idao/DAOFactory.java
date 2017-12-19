package xupt.se.ttms.idao;

import xupt.se.ttms.dao.EmployeeDAO;
import xupt.se.ttms.dao.SeatDAO;
import xupt.se.ttms.dao.StudioDAO;
import xupt.se.ttms.dao.UserDAO;

public class DAOFactory
{
    public static IEmployee creatEmployeeDAO()
    {
        return new EmployeeDAO();
    }

    public static IUser creatUserDAO()
    {
        return new UserDAO();
    }
    
    public static IStudio creatStudioDAO()
    {
        return new StudioDAO();
    }
    
    public static ISeat creatSeatDAO()
    {
        return new SeatDAO();
    }
}
