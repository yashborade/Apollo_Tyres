package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import beans.UserBean;
import dao.CCSS_AutoCompleteDao;
import mapper.CCSS_AutoCompleteMapper;

/**
 * Servlet implementation class CCSS_HelpServlet
 */
@WebServlet("/CCSS/CCSS_HelpServlet")
public class CCSS_HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CCSS_HelpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		UserBean users = (UserBean) session.getAttribute("Users");
		
		String param = request.getParameter("field");
		//System.out.println("field Name :" +param);
		String arg[] = param.split("\\?");
		//System.out.println("field Name :" +param);
		
		String field = arg[0];
		String q = request.getParameter("term");
		
		//System.out.println("field another : " + field);
		//System.out.println("q : " + q);
		
		 List<String> search = new ArrayList<String>();
		 
		 if(field.equalsIgnoreCase("searchSize"))
		 {
			 	try 
				{
					CCSS_AutoCompleteDao mapAutoNode = new CCSS_AutoCompleteMapper();
					search = mapAutoNode.getTyresize(request, users);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
		 }
		 else if(field.equalsIgnoreCase("searchPattern"))
		 {
			 	try 
				{
					CCSS_AutoCompleteDao mapAutoNode = new CCSS_AutoCompleteMapper();
					search = mapAutoNode.getPattern(request, users);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
		 }
		 else if(field.equalsIgnoreCase("searchConstruct"))
		 {
			 	try 
				{
					CCSS_AutoCompleteDao mapAutoNode = new CCSS_AutoCompleteMapper();
					search = mapAutoNode.getConstruction(request, users);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
		 }
		 else if(field.equalsIgnoreCase("searchCompound"))
		 {
			 	try 
				{
					CCSS_AutoCompleteDao mapAutoNode = new CCSS_AutoCompleteMapper();
					search = mapAutoNode.getCompound(request, users);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
		 }
		 else if(field.equalsIgnoreCase("searchCurecode"))
		 {
			 	try 
				{
					CCSS_AutoCompleteDao mapAutoNode = new CCSS_AutoCompleteMapper();
					search = mapAutoNode.getCurecode(request, users);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
		 }
		
		 
		 //JSON Array
		  JSONArray arrayObj = new JSONArray();
			 if(search.isEmpty())
				{
					arrayObj.put("No Match Found");
				}
				else if(search != null)
				{
					System.out.println(" Search List is not null....:)");
					for (String string : search) {
						arrayObj.put(string);						
					}
				}
				PrintWriter out=response.getWriter();
				out.println(arrayObj.toString());
			  	out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
