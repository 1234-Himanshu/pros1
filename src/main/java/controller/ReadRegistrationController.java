package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOService;
import model.DAOServiceImpl;


@WebServlet("/allReg21")
public class ReadRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadRegistrationController() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		ResultSet result =service.getAllRegistration();
		request.setAttribute("res", result);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/showregistrations.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

}
	}
