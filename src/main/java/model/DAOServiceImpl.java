package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
private Connection con;
private Statement stmnt;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prac8","root","test");
			stmnt=con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean VerifyLogin(String email, String password) {
	try {
		ResultSet result=stmnt.executeQuery("Select * from login where email='"+email+"'and password='"+password+"'");
       if(result.next()) {
    	   return true;
       }else {
    	   return false;
       }
      
	}catch(Exception e) {
		e.printStackTrace();
	}
	return false;
		
	}

	@Override
	public void SaveRegistration(String name, String city, String email, String mobile) {
	   try {
		   stmnt.executeUpdate("insert into registration value('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		   stmnt=con.createStatement();
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
		
	}

	@Override
	public boolean existsByEmail(String email) {
	try {
		ResultSet result=stmnt.executeQuery("Select * from registration where email='"+email+"'");
		if(result.next()) {
			return true;
		}else {
			return false;
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public ResultSet getAllRegistration() {
		try {
		ResultSet result=stmnt.executeQuery("Select * from registration");
		return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			stmnt=con.createStatement();
		stmnt.executeUpdate("UPDATE registration SET mobile='"+mobile+"' where email='"+email+"'");
		stmnt.close();
	}catch(Exception e) {
		e.printStackTrace();
	}

}

	@Override
	public void deleteByEmail(String email) {
	try {
		stmnt.executeUpdate("Delete from registration where email='"+email+"'");
		stmnt=con.createStatement();
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
}
