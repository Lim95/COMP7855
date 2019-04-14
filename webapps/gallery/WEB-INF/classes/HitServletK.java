// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;



// Extend HttpServlet class
public class HitServlet extends HttpServlet {


   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
	  File f = new File("C:/tomcat/webapps/midp/pic");
	  File[] fList = f.listFiles();
	  ArrayList<String> photoGallery = new ArrayList<String>();

		for (File d : f.listFiles())  {
                photoGallery.add(d.getPath());
            }
			
	  PrintWriter out = response.getWriter();
	  
	  String aaa = photoGallery.get(0);
	  
      response.setContentType("text/html");
		String title = "IU Photo Book";
      String docType =
      "<!doctype html public \"-//w3c//dtd html 4.0 " +
      "transitional//en\">\n";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title +  "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + aaa + "</h1>\n" +
                "<ul>\n" +
                 "<img src= \"12.jpg\" alt=\"Some Picture\" height=\"500\" width=\"500\">" +
                "</body></html>");
      
   }

   public void destroy() {
      // do nothing.
   }
}