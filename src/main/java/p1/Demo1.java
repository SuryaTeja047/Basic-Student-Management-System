package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Demo1")
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Demo1() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");
			Statement st=con.createStatement();
			
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			int m1=Integer.parseInt(request.getParameter("m1"));
			int m2=Integer.parseInt(request.getParameter("m2"));
			int m3=Integer.parseInt(request.getParameter("m3"));
			int m4=Integer.parseInt(request.getParameter("m4"));
			int m5=Integer.parseInt(request.getParameter("m5"));
			int m6=Integer.parseInt(request.getParameter("m6"));
			
			String query="insert into student_info values("+id+",'"+name+"',"+m1+","+m2+","+m3+","+m4+","+m5+","+m6+")";
			int flag=st.executeUpdate(query);
			if(flag>0) {
				out.println("Records inserted Succesfully");
			}
			else {
				out.println("Records not inserted check for sql syntax");
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
