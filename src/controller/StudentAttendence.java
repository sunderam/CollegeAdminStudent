package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Attendence;
import dao.AttendenceDao;
import dao.AttendenceDaoImp;

/**
 * Servlet implementation class StudentAttendence
 */
@WebServlet(urlPatterns={"/StudentAttendence"})
public class StudentAttendence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAttendence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttendenceDao dao = new AttendenceDaoImp();
		
		RequestDispatcher view = this.getServletContext().getRequestDispatcher("/WEB-INF/view/studentAttendenceView.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		HttpSession session = request.getSession(false);
		String username = session.getAttribute("user").toString();
		
		AttendenceDao attendence = new AttendenceDaoImp();
		List<Attendence> studentAttendence;
		studentAttendence = attendence.getAttendenceByMonth(username, from, to);
		
		request.setAttribute("attendence", studentAttendence);
		RequestDispatcher view = this.getServletContext().getRequestDispatcher("/WEB-INF/view/studentAttendenceView.jsp");
		view.forward(request, response);
		
	}

}
