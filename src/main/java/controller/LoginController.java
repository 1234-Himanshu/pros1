package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/him20")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		model.DAOService service=new model.DAOServiceImpl();
		service.connectDB();
		boolean status=service.VerifyLogin(email, password);
		if(status) {
			HttpSession session=request.getSession(true);
			session.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/New2.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error","Invalid username/password");
			RequestDispatcher rd=request.getRequestDispatcher("New1.jsp");
			rd.forward(request, response);
		}
		
	}

}
