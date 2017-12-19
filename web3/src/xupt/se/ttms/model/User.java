package xupt.se.ttms.model;

import java.io.Serializable;

public class User implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5983567545293767748L;
	/*
     * type : 0为普通用户，1是管理员
     */
    private String emp_no;
    private String emp_pass;
    private int type;
    private String head_path;

    public String getEmp_no()
    {
        return emp_no;
    }

    public void setEmp_no(String emp_no)
    {
        this.emp_no = emp_no;
    }

    public String getEmp_pass()
    {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass)
    {
        this.emp_pass = emp_pass;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getHead_path()
    {
        return head_path;
    }

    public void setHead_path(String head_path)
    {
        this.head_path = head_path;
    }

	@Override
	public String toString() {
		return "User [emp_no=" + emp_no + ", emp_pass=" + emp_pass + ", type=" + type + ", head_path=" + head_path
				+ "]";
	}    
}
