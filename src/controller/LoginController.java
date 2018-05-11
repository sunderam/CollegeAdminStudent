package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.LoginDaoImp;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns={"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDao user = new LoginDaoImp();
		String authUser = user.isAuthenticated(username, password); 
		if(authUser != null){
		
			if(authUser.equals("ADMIN")){
				HttpSession session = request.getSession(true);
				session.setAttribute("admin", username);
				session.setAttribute("user", username);
				response.sendRedirect(request.getContextPath() + "/admin");
			}
			else if(authUser.equals("STUDENT")){
				HttpSession session = request.getSession(true);
				session.setAttribute("StudentUser", username);
				session.setAttribute("user", username);
				response.sendRedirect(request.getContextPath() + "/student");
			}
			else{
				request.setAttribute("err", "Something is wrong. please try again !");
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginPage.jsp");
				dispatcher.forward(request, response);
			}
		}else{
			request.setAttribute("err", "Something is wrong. please try again !");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginPage.jsp");
			dispatcher.forward(request, response);
		}
	}

}
