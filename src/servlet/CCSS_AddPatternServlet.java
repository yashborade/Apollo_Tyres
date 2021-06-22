package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CCSS_AddCompundBean;
import beans.CCSS_AddPatternBean;
import beans.UserBean;
import dao.CCSS_AddPatternDao;
import mapper.CCSS_AddPatternMapper;

/**
 * Servlet implementation class CCSS_AddPatternServlet
 */
@WebServlet("/CCSS/CCSS_AddPatternServlet")
public class CCSS_AddPatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CCSS_AddPatternServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hello ");
		HttpSession httpSession = request.getSession();
		UserBean users = (UserBean) httpSession.getAttribute("Users");
		String forward = "";
		String msg = "";
		
		CCSS_AddPatternDao pattDao = new CCSS_AddPatternMapper();
		String action = request.getParameter("action");	
		System.out.println("actin"+action);
		
		if (action != "" && action.equalsIgnoreCase("load"))
		{
			request.setAttribute("msg", msg);
			forward = "./CCSS_AddPattern.jsp";
		}
		else if (action != "" && action.equalsIgnoreCase("Insert"))
		{
			synchronized (this)
			{
				msg = pattDao.insPattern(request);
				
				if(msg.equals("0"))
				{
					msg = "Error in inserting data";
					
				}
				else
				{
					msg = "Data inserted successfully";
					
				}
				request.setAttribute("msg",msg);
				forward = "./CCSS_AddPattern.jsp";
			}
		}
		else if(action != "" && action.equalsIgnoreCase("Report"))
		{
			System.out.println("inside Report");
			ArrayList<CCSS_AddPatternBean> reports = pattDao.genereport(request, users);
			request.setAttribute("reportpatt", reports);
			forward = "./CCSS_AddPatternReport.jsp";
			
		}
		else
		{
			forward = "./CCSS_Welcome.jsp";
		}
		
		RequestDispatcher dispatchForward = request.getRequestDispatcher(forward);
		dispatchForward.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
