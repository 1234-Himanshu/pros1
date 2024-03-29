package model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean VerifyLogin(String email,String password);
    public void SaveRegistration(String name,String city,String email,String mobile);
    public boolean existsByEmail(String email);
	public ResultSet getAllRegistration();
	public void updateRegistration(String email, String mobile);
	public void deleteByEmail(String email);
}
