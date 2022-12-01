

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		String e=request.getParameter("userEmail");
		String c=request.getParameter("userCountry");
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","Ahamad@123");
		PreparedStatement ps=con.prepareStatement("insert into Register values(?,?,?,?,?)");
		ps.setString(1,"0");
		ps.setString(2,n);
		ps.setString(3,p);
		ps.setString(4,e);
		ps.setString(5,c);
		
		int i=ps.executeUpdate();
		if(i>0)
		{
		out.print("You are successfully registered...");
		out.println("<a href='Register.html'>Register</a>"  );
		}
			
		}catch (Exception e2) 
		{
			System.out.println(e2);
		}
		
		out.close();
	}

}
