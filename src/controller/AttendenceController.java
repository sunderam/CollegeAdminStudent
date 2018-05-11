package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Attendence;
import dao.AttendenceDao;
import dao.AttendenceDaoImp;

/**
 * Servlet implementation class AttendenceController
 */
@WebServlet(urlPatterns={"/attendence"})
public class AttendenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendenceController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		if(request.getParameter("msg") != null){
			msg = request.getParameter("msg");
			request.setAttribute("msg", msg);
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/studentAttendencePage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentId = Integer.parseInt(request.getParameter("id"));
		String presence = request.getParameter("presence");
		
		Attendence sa = new Attendence();
		sa.setStudentId(studentId);
		sa.setPresence(presence);
		AttendenceDao dao = new AttendenceDaoImp();
		dao.addAttendence(sa);
		response.sendRedirect(request.getContextPath()+"/attendence?msg=success");
	}

}
