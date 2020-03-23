package com.studentservice;

import com.connection.StudentCon;
import com.studentbean.StudentBean;

public class StudentService {

	public String insertData(StudentBean s)
	{
		StudentCon con=new StudentCon();
		int status=con.insert(s);
		if(status==0)
		    return "insertion failed";
		else
			return "insertion success";
		
	}
	
	public String deleteData(int id)
	{
		StudentCon con=new StudentCon();
		int status=con.delete(id);
		if(status==0)
		    return "deletion failed";
		else
			return "deletion success";
		
	}
	public String updateData(StudentBean s) throws Exception
	{
		//System.out.println("service ke update data main aaya");
		StudentCon con=new StudentCon();
		int status=con.update(s);
		if(status==0)
		    return "updation failed";
		else
			return "updation success";
	}
}
