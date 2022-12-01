

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","Ahamad@123");
			Statement st=con.createStatement();
			String query="select * from register";
			ResultSet i=st.executeQuery(query);
			out.print("<table border='1' width='100%'");
			out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
			while(i.next())
			{
				out.println("<tr><td>"+i.getInt(1)+"</td><td>"+i.getString(2)+"</td><td>"+i.getString(3)+"</td><td>"+i.getString(4)+"</td><td>"+i.getString(5)+"</td></tr>");
			}
			
			out.println("<a href='Register.html'>Add New Employee</a>");
		}
		catch (Exception e)
		{
			out.println(e.getMessage());
		}
	}

}
