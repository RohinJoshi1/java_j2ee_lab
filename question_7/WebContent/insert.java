

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String cause = request.getParameter("cause");
		String doctor = request.getParameter("doctor");
		String date = request.getParameter("date");
		String treatment = request.getParameter("treatment");
		String insertQuery = String.format(
	             "insert into PatientRecords  values (%d, '%s', %d, '%s', '%s', '%s', '%s')",
	             ID, name, age, date, cause, doctor, treatment);
//		String query = "insert into PatientRecords values("+ID+","+name+","+age+","+date+","+cause+","+doctor+","+treatment+");";
		
		new RunQuery().update(insertQuery);
//		response.getWriter().println("Inserted values");
		

	}
}
