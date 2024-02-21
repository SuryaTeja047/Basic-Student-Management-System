package p1;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Demo4")
public class Demo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Demo4() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","tiger");
			Statement st=con.createStatement();
			int id=Integer.parseInt(request.getParameter("id"));
			ResultSet rs=st.executeQuery("Select * from student_info where(id="+id+")");
			while(rs.next()) {
				char g1=re.grade(rs.getInt(3));
				char g2=re.grade(rs.getInt(4));
				char g3=re.grade(rs.getInt(5));
				char g4=re.grade(rs.getInt(6));
				char g5=re.grade(rs.getInt(7));
				char g6=re.grade(rs.getInt(8));
				
				out.println("Student Name:"+rs.getString(2));
				out.println("Student Id:"+rs.getInt(1));
				out.println("Subject_name\tMarks\tTotal\tGrade\t");
				out.println("\tM1\t"+rs.getInt(3)+"\t"+"100"+"\t"+g1);
				out.println("\tM2\t"+rs.getInt(4)+"\t"+"100"+"\t"+g2);
				out.println("\tM3\t"+rs.getInt(5)+"\t"+"100"+"\t"+g3);
				out.println("\tM4\t"+rs.getInt(6)+"\t"+"100"+"\t"+g4);
				out.println("\tM5\t"+rs.getInt(7)+"\t"+"100"+"\t"+g5);
				out.println("\tM6\t"+rs.getInt(8)+"\t"+"100"+"\t"+g6);
				char ch[]=new char[6];
				for(int i=3;i<ch.length;i++) {
					ch[i]=re.grade(rs.getInt(i));
				}
				double average=(rs.getInt(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7)+rs.getInt(8))/ch.length;
					out.println("Average:"+average);
			
			out.close();
			st.close();
			con.close();
			}
		}
		catch(ClassNotFoundException e) {
			out.println("Driver class not loaded"+e);
		}
		catch(SQLException e1) {
			out.println("Sql Exception"+e1);
		}
	}
}
