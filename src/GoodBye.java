

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodBye extends HttpServlet {

      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		request.getRequestDispatcher("WEB-INF/goodbye.jsp").forward(request, response);
      }

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(request.getParameter("name"));
  		request.getRequestDispatcher("WEB-INF/goodbye.jsp").forward(request, response);
      }
}
