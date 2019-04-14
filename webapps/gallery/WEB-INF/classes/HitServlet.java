// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class HitServlet extends HttpServlet {

	private String username, userPassword;
	private String adminUsername = "admin";
	private String adminuserPassword = "admin";
	
	private int	index = 0;
	private	String btn;
	private int size;

	ArrayList<String> photoGallery = new ArrayList<String>();
	
   public void init() throws ServletException {
      // Do required initialization
     // message = "Hello World";

   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
	   	File f = new File("C:\\tomcat\\webapps\\gallery\\pics"); //file path
		File[] fList = f.listFiles();
		photoGallery.clear();
		username = request.getParameter("uname");
		userPassword = request.getParameter("psw");
		// Set response content type
		//  response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (username.equals(adminUsername) && userPassword.equals(adminuserPassword))
		{
			for (File d : f.listFiles())  {
                photoGallery.add(d.getPath());
            }
			size = photoGallery.size();
			
			
			response.setContentType("text/html");
	  
			String ImgPath = photoGallery.get(index);
	  
			String Img2show = ImgPath.substring(26);
	  
      
			String title = "IU Photo Book";
		


	
			String docType =
			"<!doctype html public \"-//w3c//dtd html 4.0 " +
			"transitional//en\">\n";
			out.println(docType +
					"<html>\n" +
					"<head><title>" + title +  "</title></head>\n" +
					"<style>"+
					"button {background-color: #008CBA;  color: white;	padding: 20px;	margin: auto;	border: none;	cursor: pointer; width: 30%;}"+
					"button:hover {opacity: 0.8;}"+
					"</style>"+
					"<body bgcolor=\"#f0f0f0\">\n" +
					"<h1 align=\"center\">Photo Gallery Application</h1>\n" +
					"<ul>\n" +
					
					"<form action=\"pho?uname=" +adminUsername+ "&psw="+adminuserPassword+"\""+ "method=\"post\">"+
					"<div style=\"text-align: center;\">"+
					
					"<img src= \""+ Img2show +"\" alt=\"IUtheBEST\" align=\"center\" height=\"500\" width=\"500\">" +
					"</div>"+
					"<br>\n" +
					"<br>\n" +
					
					"<div style=\"text-align: center;\">"+
					"<button type=\"submit\" value=\"left\" name=\"btn\" >LEFT</button>" +
					"<button type=\"submit\" value=\"right\" name=\"btn\"  >RIGHT</button>" +
					"<button type=\"submit\" value=\"upload\" name=\"btn\"  >UPLOAD</button>" +
					"</div>"+
					"</form>"+
					"<br>\n" +		
					"</body></html>");
		}
		else
			response.sendRedirect("loginWithError.html");	
   }

   public void destroy() {
      // do nothing.
   }
   	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
	btn = request.getParameter("btn");
	if(btn.equals("right"))
	{
	  index++;
	  if (index >= size)
		  index = 0;
	}
	if (btn.equals("left"))
	{
		index--;
		if (index < 0)
			index = size-1;
	}
	if (btn.equals("upload"))
	{
		request.getRequestDispatcher("/gal.html").forward(request, response);
	}
	

      doGet(request, response);
   }
}