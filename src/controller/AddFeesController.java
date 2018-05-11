package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fees;
import dao.FeesDao;
import dao.FeesDaoImp;

/**
 * Servlet implementation class AddFeesController
 */
@WebServlet(urlPatterns={"/addFees"})
public class AddFeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FeesDao feesDao = new FeesDaoImp();
		if(request.getParameter("id") != null){
			int id = Integer.parseInt(request.getParameter("id"));
			feesDao.deleteCurseFees(id);	
		}
		
		List<Fees> feesList = feesDao.getAllCourseFees();
		request.setAttribute("feesList", feesList);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/addFeesPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fees fees = new Fees();
		 fees.setCourse(request.getParameter("course"));
		 fees.setAmount(Double.parseDouble(request.getParameter("amount")));
	
		 FeesDao feesDao = new FeesDaoImp();
		 boolean stat = feesDao.addFees(fees);
		 if(stat)
		response.sendRedirect(request.getContextPath()+"/addFees");
	}

}
