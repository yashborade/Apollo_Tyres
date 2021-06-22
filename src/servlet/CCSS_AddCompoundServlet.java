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
import beans.UserBean;
import dao.CCSS_AddCompoundDao;
import mapper.CCSS_AddCompundMapper;

/**
 * Servlet implementation class CCSS_AddCompoundServlet
 */
@WebServlet("/CCSS/CCSS_AddCompoundServlet")
public class CCSS_AddCompoundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CCSS_AddCompoundServlet() {
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
		
		
		CCSS_AddCompoundDao compDao = new CCSS_AddCompundMapper();
		String action = request.getParameter("action");	
		System.out.println("actin"+action);
		
		if (action != "" && action.equalsIgnoreCase("load"))
		{
			request.setAttribute("msg", "");
			forward = "./CCSS_AddCompund.jsp";
		}
		
		else if (action != "" && action.equalsIgnoreCase("Insert"))
		{
			synchronized (this)
			{
				msg = compDao.insComp(request);
				
				if(msg.equals("0"))
				{
					msg = "Error in inserting data";
					
				}
				else
				{
					msg = "Data inserted successfully";
					
				}
				request.setAttribute("msg",msg);
				forward = "./CCSS_AddCompund.jsp";
			}
		}
		else if(action != "" && action.equalsIgnoreCase("Report"))
		{
			System.out.println("inside Report");
			ArrayList<CCSS_AddCompundBean> reports = compDao.genereport(request, users);
			request.setAttribute("ReportComp", reports);
			forward = "./CCSS_AddCompoundReport.jsp";
			
		}
		else {
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
