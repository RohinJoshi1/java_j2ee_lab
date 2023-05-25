

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ITreturns
 */
@WebServlet("/ITreturns")
public class ITreturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITreturns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//I take the params and I shove them into a new file
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		String tax = request.getParameter("tax");
		PrintWriter out = response.getWriter();
		
		File file = new File("/Users/rohinjoshi/Coding/codes/sem_6/java/Lab/SEE/test/tester.txt");
		if(file.createNewFile()) {
			System.out.println("Successful");
		}else {
				System.out.println("Fail");
			}
			
		FileOutputStream fout = new FileOutputStream(file);
		String s = String.format("%s %s %s %s", name,gender,salary,tax);
		out.println(  "<h1>"+s+"</h1>");
		fout.write(s.getBytes());
		fout.close();
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
