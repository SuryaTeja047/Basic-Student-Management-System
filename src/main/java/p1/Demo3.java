package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Demo3")
public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Demo3() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");
			Statement st=con.createStatement();
			int id=Integer.parseInt(request.getParameter("id"));
			String query="delete from student_info where(id="+id+")";
			int i=st.executeUpdate(query);
			if(i>0) {
				out.println("Records Deleted Succesfully");
			}
			else {
				out.println("Records NOt Deleted CHeck exception");
			}
			out.close();
			st.close();
			con.close();
		}
		catch(ClassNotFoundException e) {
			out.println("Driver class not loaded"+e);
		}
		catch(SQLException e1) {
			out.println("Sql Exception"+e1);
		}
		
	}

}
