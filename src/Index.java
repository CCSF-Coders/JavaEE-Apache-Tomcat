
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("INIT");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name", "Java-EE-Struts2-MyAttr");
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }

}
