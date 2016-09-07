

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodBye extends HttpServlet {
    String[] page = {
            "<html>",
            "<body>",
            "<h1>Goodbye -- </h1>",    
            "<a href='Hello' >Goto Hello</a>", 
            "</body>",
            "</html>",      
          };

          protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              PrintWriter writer = response.getWriter();
              for ( String s: page) {
                  writer.println(s);
              }
              
          }
}
