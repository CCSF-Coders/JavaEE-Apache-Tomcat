
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Registration;

@SuppressWarnings("serial")
public class Index extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "sa", "");

		    Statement stmt = conn.createStatement();
		    try {
			    // Select first_name and last_name column from the customers table
			    ResultSet rset = stmt.executeQuery ("select t.* from Registration t");
			    rset.next();
			    // Close the RseultSet
			    rset.close();
		    } finally {
			    // Close the Statement
			    stmt.close();
		    }

		    List<Registration> resistrations = new Registration().list(conn);
			request.setAttribute("registrations", resistrations);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

}
