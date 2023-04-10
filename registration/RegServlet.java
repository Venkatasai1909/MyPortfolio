package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/register")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config)
    {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl?useSSL = false","Venky19","0919");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void destroy()
    {
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  //    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("name");
		String s2 = request.getParameter("email");
		String s3 = request.getParameter("pass");
		String s4 =request.getParameter("contact");
		String s5 = request.getParameter("re_pass");
		RequestDispatcher dispatcher = null;
		if(s1 == null || s1.equals(" "))
		{
			request.setAttribute("status","InvalidName");  
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(!s3.equals(s5))
		{
			request.setAttribute("status","InvalidRePass");  
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(s2 == null || s2.equals(" "))
		{
			request.setAttribute("status","InvalidEmail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(s3 == null || s3.equals(" "))
		{
			request.setAttribute("status","InvalidPass");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(s4 == null || s4.equals(" ") || s4.length()!=10)
		{
			request.setAttribute("status","InvalidNo");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		try {
		PreparedStatement pstmt = con.prepareStatement("insert into Users Values(?,?,?,?)");
		pstmt.setString(1, s1);
		pstmt.setString(2, s2);
		pstmt.setString(3,s3);
		pstmt.setString(4, s4);
		int rowCount = pstmt.executeUpdate();
		dispatcher = request.getRequestDispatcher("registration.jsp");
		if(rowCount > 0)
		{
			request.setAttribute("status","success");
		}
		else
		{
			request.setAttribute("status","failed");
		}
		dispatcher.forward(request, response);
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
