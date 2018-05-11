package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentFees;
import dao.FeesDao;
import dao.FeesDaoImp;

/**
 * Servlet implementation class StudentFeesController
 */
@WebServlet(urlPatterns={"/studentFees"})
public class StudentFeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFeesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null){
			String username = session.getAttribute("user").toString();
			FeesDao dao = new FeesDaoImp();
			StudentFees fees = dao.getStudentFeesByUsername(username);
			System.out.println("from controller fees  :"+fees.getTotalFees());
			request.setAttribute("fees", fees);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/studentFeesPage.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double pay = Double.parseDouble(request.getParameter("payfees"));
		Date date = new Date();
		HttpSession session = request.getSession();
		String username = session.getAttribute("user").toString();
		StudentFees studfees = new StudentFees();
		studfees.setPaidFees(pay);
		studfees.setFeesPaidDate(date);
		FeesDao feesDao = new FeesDaoImp();
		boolean stat = feesDao.updateStudentFees(username,pay, date);
		if(stat)
			response.sendRedirect(request.getContextPath()+"/studentFees");
	}

}
