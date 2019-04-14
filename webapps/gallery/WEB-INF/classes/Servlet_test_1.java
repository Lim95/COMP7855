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
	private int currentPhotoIndex;
	private String strPrev, strNext;
	private String photoPath;
	private PrintWriter out;
	private String photoName;
	private String sss;
   public void init() throws ServletException {
      // Do required initialization
     // message = "Hello World";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {

		/*
		HttpSession session = request.getSession(true);		
		if (session.isNew()) {
			currentPhotoIndex = 0;
			photoPath = photoGallery.get(currentPhotoIndex);
			displayHtml(response);
		}
		else {
			if (strPrev.equals("Prev"))
				--currentPhotoIndex;
			else if (strNext.equals("Next"))
				++currentPhotoIndex;
			else
			{}
			if (currentPhotoIndex < 0)
				currentPhotoIndex = 0;
			else if (currentPhotoIndex >= photoGallery.size())
				currentPhotoIndex = photoGallery.size() - 1;
			else 
			{}
			photoPath = photoGallery.get(currentPhotoIndex);
			displayHtml(response);
		}*/
/*********************************************************************/		
		username = request.getParameter("uname");
		userPassword = request.getParameter("psw");
		
		if (username.equals(adminUsername) && userPassword.equals(adminuserPassword))
			{//request.getRequestDispatcher("gal.html").forward(request, response);
				response.setContentType("text/html");
		out = response.getWriter();
		File f = new File("C:\\tomcat\\webapps\\pics");
		File[] fList = f.listFiles();
		ArrayList<String> photoGallery = new ArrayList<String>();
		for (File d : f.listFiles())  {
			photoGallery.add(d.getPath());
        }
/*********************************************************************/		
		java.io.PrintWriter out = response.getWriter();	
		photoPath = photoGallery.get(0);
		
		sss = photoPath.substring(photoPath.lastIndexOf("\\"));
		
		out.println("<!DOCTYPE html><html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><style>body {font-family: Arial, Helvetica, sans-serif;}form {border: 3px solid #f1f1f1;}input[type=text], input[type=password] { width: 100%; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid #ccc; box-sizing: border-box;}.iu { text-align: center;}button {background-color: purple; color: white; padding: 14px 20px; margin: 8px 0; border: none; cursor: pointer; width: 20%; display: inline-block;}button:hover { opacity: 0.8;}.imgcontainer { text-align: center; margin: 24px 0 12px 0;}img.avatar { width: 20%; border-radius: 20%;}.container { padding: 16px;}span.psw { float: right; padding-top: 16px;}</style></head><body><h2 align=\"center\">" +
		photoPath +" 11111 " + "\""+ 
		"</h2><div class=\"imgcontainer\"> <img id = \"myImg\" src=\"" + photoPath +"\"" +
		" width = \"460\" height = \"345\"></div> <div class=\"iu\"> <input type = \"submit\" value = \"Prev\" name = \"prev\"> <input type = \"submit\" value = \"Next\" name = \"next\"></div> </body></html>");

		strPrev = request.getParameter("prev");
		strNext = request.getParameter("next");}
		else{
			response.sendRedirect("loginWithError.html");
		}
   }

   
   public void destroy() {
      // do nothing.
   }
   private void displayHtml(HttpServletResponse response){
	//	try{
	//	java.io.PrintWriter out = response.getWriter();	
	//	out.println("<!DOCTYPE html><html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><style>body {font-family: Arial, Helvetica, sans-serif;}form {border: 3px solid #f1f1f1;}input[type=text], input[type=password] { width: 100%; padding: 12px 20px; margin: 8px 0; display: inline-block; border: 1px solid #ccc; box-sizing: border-box;}.iu { text-align: center;}button {background-color: purple; color: white; padding: 14px 20px; margin: 8px 0; border: none; cursor: pointer; width: 20%; display: inline-block;}button:hover { opacity: 0.8;}.imgcontainer { text-align: center; margin: 24px 0 12px 0;}img.avatar { width: 20%; border-radius: 20%;}.container { padding: 16px;}span.psw { float: right; padding-top: 16px;}</style></head><body><h2 align=\"center\">Photo Gallery Application</h2><div class=\"imgcontainer\"> <img id = \"myImg\" src=" +photoPath +
	//	"width = \"460\" height = \"345\"></div> <div class=\"iu\"> <input type = \"submit\" value = \"Prev\" name = \"prev\"> <input type = \"submit\" value = \"Next\" name = \"next\"></div> </body></html>");
		//}
		//catch(IOException ie){}
   }
}