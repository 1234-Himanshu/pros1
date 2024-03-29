package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOService;
import model.DAOServiceImpl;


@WebServlet("/saveReg21")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationController() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		boolean StatusOfEmail=service.existsByEmail(email);
		if(StatusOfEmail) {
			request.setAttribute("msg","Email id Exist!!");
		}else {
		service.SaveRegistration(name, city, email, mobile);
		request.setAttribute("msg", "Record is Saved!!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/New2.jsp");
		rd.forward(request, response);
		
	}

}
