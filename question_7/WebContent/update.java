

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		// TODO Auto-generated method stub
		String ID = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String cause = request.getParameter("cause");
		String doctor = request.getParameter("doctor");
		String date = request.getParameter("date");
		String treatment = request.getParameter("treatment");
		String query = "update PatientRecords set name="+name+"age="+age+"cause="+cause+"doctor="+doctor+ 
				"date="+date+"treatment="+treatment+"where id ="+ID;
		new RunQuery().update(query);
		response.getWriter().println("Updated");
		
	}

}
