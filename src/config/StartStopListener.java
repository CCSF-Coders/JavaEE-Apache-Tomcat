package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartStopListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Connection conn; // our connnection to the db - presist for life of
							// program

		// Load the HSQL Database Engine JDBC driver
		// hsqldb.jar should be in the class path or made part of the current
		// jar
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "sa", ""); // password
			Statement stmt = conn.createStatement();

			String sql = "CREATE TABLE REGISTRATION " 
					+ "(id INTEGER not NULL, " 
					+ " last VARCHAR(255), "
					+ " first VARCHAR(255), " 
					+ " email VARCHAR(255), " 
					+ " phone VARCHAR(255), " 
					+ " age INTEGER, "
					+ " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(0, 'Abensohn', 'Steven', 'sabensoh@ccsf.edu', '239-3747', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(1, 'Boyd', 'Gregory', 'gboyd@ccsf.edu', '239-3139', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(2, 'Brick', 'Aaron', 'abrick@ccsf.edu', '239-3961', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(3, 'Conner', 'Constance', 'cconner@ccsf.edu', '239-3963', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(4, 'Giambattista', 'Louie', 'lgiambat@ccsf.edu', '239-3845', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(5, 'Harden', 'David', 'dharden@ccsf.edu', '-none', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(6, 'Hunter', 'Cherron', 'chunter@ccsf.edu', '239-3823', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(7, 'Ibrahim', 'Hanan', 'hibrahim@ccsf.edu', '', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(8, 'Luttrell', 'Maximilian', 'mluttrell@ccsf.edu', '', 55 )";
			stmt.executeUpdate(sql);
			sql = "insert into REGISTRATION values(9, 'Masters', 'Jessica', 'jlmasters@ccsf.edu', '', 55 )";
			stmt.executeUpdate(sql);
			conn.close();
			System.out.println("connected!! created!! inserted!!! closed!!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("Servlet has been stopped.");
	}

}