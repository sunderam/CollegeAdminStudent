package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentAddress;
import dao.StudentDao;
import dao.StudentDaoImp;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDaoImp();
		
		String action="";
				if(request.getParameter("action")!=null){
					action = request.getParameter("action");
				}
			if(action.equalsIgnoreCase("delete")){
				int id = Integer.parseInt(request.getParameter("id"));
				studentDao.deleteStudent(id);
				response.sendRedirect(request.getContextPath()+"/studentList");
			}
			else if(action.equalsIgnoreCase("update")){
				int id = Integer.parseInt(request.getParameter("id"));
				Student student = studentDao.getStudentById(id);
				request.setAttribute("student", student);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/addStudentPage.jsp");
				dispatcher.forward(request, response);
			}
			else{
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/addStudentPage.jsp");
				dispatcher.forward(request, response);
			}
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setEmail(request.getParameter("email"));
		student.setStd(request.getParameter("course"));
		student.setDiv(request.getParameter("section"));
		
		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setStreet(request.getParameter("street"));
		studentAddress.setArea(request.getParameter("area"));
		studentAddress.setCity(request.getParameter("city"));
		studentAddress.setState(request.getParameter("state"));
		studentAddress.setZip(request.getParameter("zip"));
		
		student.setStudentAdress(studentAddress);
		
		StudentDao dao = new StudentDaoImp();
		boolean status = false;
		if(request.getParameter("studId") != null ){
		 student.setStudId(Integer.parseInt(request.getParameter("studId")));
		 status =  dao.updateStudent(student);
		}
		else{
			status = dao.addStudent(student);
		}
		
		if(status){
			response.sendRedirect(request.getContextPath() + "/studentList");
		}
		
	
	}

}
