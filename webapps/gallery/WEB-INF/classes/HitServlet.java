// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


// Extend HttpServlet class
public class HitServlet extends HttpServlet {

   private String username, userPassword;
   
	private String adminUsername = "admin";
	private String adminuserPassword = "admin";
	
   public void init() throws ServletException {
      // Do required initialization
     // message = "Hello World";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
	
	
   throws ServletException, IOException {
      username = request.getParameter("uname");
	userPassword = request.getParameter("psw");
      // Set response content type
    //  response.setContentType("text/html");
      PrintWriter out = response.getWriter();

	if (username.equals(adminUsername) && userPassword.equals(adminuserPassword)){
      // Actual logic goes here.
      request.getRequestDispatcher("gal.html").forward(request, response);
	
   }
   else
   {
	   out.println("<h1>FUCK OFF</h1>");
	   response.sendRedirect("loginWithError.html");
   }
   }

   public void destroy() {
      // do nothing.
   }
}