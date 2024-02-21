package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Demo2")
public class Demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Demo2() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");
			Statement st=con.createStatement();
			
			int id=Integer.parseInt(request.getParameter("id"));
			int choice=Integer.parseInt(request.getParameter("choice"));
			int marks=Integer.parseInt(request.getParameter("marks"));
			switch(choice) {
			case 1: String query1="update student_info set m1="+marks+" where(id="+id+") ";
					int flag=st.executeUpdate(query1);
					if(flag>0) {
						out.println("Records Updated Succesfully");
					}
					else {
						out.println("Record Not inserted check for exception");
					}
					break;
			case 2: String query2="update student_info set m2="+marks+" where(id="+id+") ";
					int flag1=st.executeUpdate(query2);
					if(flag1>0) {
						out.println("Records Updated Succesfully");
					}
					else {
						out.println("Record Not inserted check for exception");
					}
					break;
			case 3: String query3="update student_info set m3="+marks+" where(id="+id+") ";
					int flag2=st.executeUpdate(query3);
					if(flag2>0) {
						out.println("Records Updated Succesfully");
					}
					else {
						out.println("Record Not inserted check for exception");
					}
					break;
			case 4: String query4="update student_info set m4="+marks+" where(id="+id+") ";
					int flag4=st.executeUpdate(query4);
					if(flag4>0) {
						out.println("Records Updated Succesfully");
					}
					else {
						out.println("Record Not inserted check for exception");
					}
					break;
			case 5: String query5="update student_info set m5="+marks+" where(id="+id+") ";
					int flag5=st.executeUpdate(query5);
					if(flag5>0) {
						out.println("Records Updated Succesfully");
					}
					else {
						out.println("Record Not inserted check for exception");
					}
					break;
			case 6: String query6="update student_info set m6="+marks+" where(id="+id+") ";
					int flag6=st.executeUpdate(query6);
					if(flag6>0) {
						out.println("Records Updated Succesfully");
					}
					else {
						out.println("Record Not inserted check for exception");
					}
					break;
			default: out.println("Enter a valid SUbject Number");
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
