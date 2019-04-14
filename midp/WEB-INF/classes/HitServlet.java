// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;



// Extend HttpServlet class
public class HitServlet extends HttpServlet {

	private int	index = 0;
	private	String btnL;
		private	String btnR;
	private int size;
	File f = new File("C:/tomcat/webapps/midp/pic"); //file path
	  File[] fList = f.listFiles();
	  ArrayList<String> photoGallery = new ArrayList<String>();

		
	
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
	  
		for (File d : f.listFiles())  {
                photoGallery.add(d.getPath());
            }
	  size = photoGallery.size();
			
	  PrintWriter out = response.getWriter();
	  response.setContentType("text/html");
	  
	  String ImgPath = photoGallery.get(index);
	  
	  String Img2show = ImgPath.substring(23);
	  
      
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
                "<h1 align=\"center\">" + size + "</h1>\n" +
                "<ul>\n" +
				
				"<form action=\"hits\" method=\"post\">"+
				"<div style=\"text-align: center;\">"+
                
				"<img src= \""+ Img2show +"\" alt=\"IUtheBEST\" align=\"center\" height=\"500\" width=\"500\">" +
				"</div>"+
                "<br>\n" +
				"<br>\n" +
				
				"<div style=\"text-align: center;\">"+
				"<button type=\"submit\" value=\"left\" name=\"btn\" >LEFT</button>" +
				"<button type=\"submit\" value=\"right\" name=\"btn\"  >RIGHT</button>" +
				"</div>"+
				"</form>"+
				"<br>\n" +

				"<p id=\"demo\">" +"hi"+ "</p>" +
				
				"</body></html>");
				
	
   }
   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		btnR = request.getParameter("btn");
	if(btnR.equals("right")){
	  index++;
	  }
	  else{
		  --index;
		  if (index <=0)
			  index = index + size;
	  }
	  
		  
	  
	  
		
      doGet(request, response);
   }
   
   public void destroy() {
      // do nothing.
   }
}