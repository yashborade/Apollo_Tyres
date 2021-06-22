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

import beans.CCSS_AddCureCodeBean;
import beans.UserBean;
import dao.CCSS_AddCureCodeDao;
import mapper.CCSS_AddCureCodeMapper;

/**
 * Servlet implementation class CCSS_AddCureCodeServlet
 */
@WebServlet("/CCSS/CCSS_AddCureCodeServlet")
public class CCSS_AddCureCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CCSS_AddCureCodeServlet() {
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
		
		CCSS_AddCureCodeDao cureDao = new CCSS_AddCureCodeMapper();
		
		String action = request.getParameter("action");	
		System.out.println("actin"+action);
		
		if (action != "" && action.equalsIgnoreCase("load"))
		{
			request.setAttribute("msg", "");
			forward = "./CCSS_AddCureCode.jsp";
		}
		else if (action != "" && action.equalsIgnoreCase("Insert"))
		{
			synchronized (this)
			{
				msg = cureDao.insCurecode(request);
				
				if(msg.equals("0"))
				{
					msg = "Error in inserting data";
					
				}
				else
				{
					msg = "Data inserted successfully";
					
				}
				request.setAttribute("msg",msg);
				forward = "./CCSS_AddCureCode.jsp";
			}
		}
		else if(action != "" && action.equalsIgnoreCase("Report"))
		{
			System.out.println("inside Report");
			ArrayList<CCSS_AddCureCodeBean> reports = cureDao.genereport(request, users);
			request.setAttribute("reportcure", reports);
			forward = "./CCSS_AddCureCodeReport.jsp";
			
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
