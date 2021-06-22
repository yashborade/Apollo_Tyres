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
import beans.CCSS_AddGaugesBean;
import beans.UserBean;
import dao.CCSS_AddGaugesDao;
import mapper.CCSS_AddGaugeMapper;

/**
 * Servlet implementation class CCSS_AddGaugesServlet
 */
@WebServlet("/CCSS/CCSS_AddGaugesServlet")
public class CCSS_AddGaugesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CCSS_AddGaugesServlet() {
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
		
		CCSS_AddGaugesDao gaugeDao = new CCSS_AddGaugeMapper();
		
		String action = request.getParameter("action");	
		System.out.println("actin"+action);
		
		if (action != "" && action.equalsIgnoreCase("load"))
		{
			request.setAttribute("msg", msg);
			forward = "./CCSS_AddGauges.jsp";
		}
		else if (action != "" && action.equalsIgnoreCase("Insert"))
		{
			synchronized (this)
			{
				msg = gaugeDao.insGauge(request);
				
				if(msg.equals("0"))
				{
					msg = "Error in inserting data";
					
				}
				else
				{
					msg = "Data inserted successfully";
					
				}
				request.setAttribute("msg",msg);
				forward = "./CCSS_AddGauges.jsp";
			}
		}
		else if(action != "" && action.equalsIgnoreCase("Report"))
		{
			System.out.println("inside Report");
			ArrayList<CCSS_AddGaugesBean> reports = gaugeDao.genereport(request, users);
			request.setAttribute("reportgauge", reports);
			forward = "./CCSS_AddGaugeReport.jsp";
			
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
