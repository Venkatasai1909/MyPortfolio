package logServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class FogotPassword
 */
@WebServlet("/forgot")
public class FogotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FogotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con;
    public void init(ServletConfig config)
    {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Venky19","0919");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String email = request.getParameter("email");
		String pword = request.getParameter("password");
		String newpword = request.getParameter("newpassword");
		String conpword = request.getParameter("conpassword");
		try {
			
			PreparedStatement pstmt = con.prepareStatement("select mail,password from users where mail = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, pword);
			ResultSet rs = pstmt.executeQuery();
		    if(newpword.equals(conpword))
		    {
		    	if(rs.next())
				{
					pstmt  = con.prepareStatement("update users set password = ? where mail = ?");
					pstmt.setString(1,newpword);
					pstmt.setString(2,email);
					pstmt.executeUpdate();
					request.setAttribute("status", "success");
					rd = request.getRequestDispatcher("login.jsp");
				}
		    	else
		    	{
		    		request.setAttribute("status","failure");
		    		rd = request.getRequestDispatcher("forgotPassword.jsp");
		    	}
		    }
		    else
		    {
		    	request.setAttribute("password", "failure");
		    	rd = request.getRequestDispatcher("forgotPassword.jsp");
		    }
		    rd.forward(request, response);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
