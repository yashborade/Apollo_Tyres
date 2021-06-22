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

import beans.CCSS_AddCureCycleBean;
import beans.UserBean;
import dao.CCSS_AddCureCycleDao;
import mapper.CCSS_AddCureCycleMapper;

/**
 * Servlet implementation class CCSS_AddCureCycleServlet
 */
@WebServlet("/CCSS/CCSS_AddCureCycleServlet")
public class CCSS_AddCureCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CCSS_AddCureCycleServlet() {
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
		
		CCSS_AddCureCycleDao cycleDao = new CCSS_AddCureCycleMapper();
		String action = request.getParameter("action");	
		System.out.println("actin"+action);
		
		if (action != "" && action.equalsIgnoreCase("load"))
		{
			request.setAttribute("msg", msg);
			forward = "./CCSS_AddCureCycle.jsp";
		}
		else if (action != "" && action.equalsIgnoreCase("OK"))
		{
			CCSS_AddCureCycleBean groupBean = null;
			groupBean = cycleDao.getPattern(request);
			request.setAttribute("groupupdate", groupBean);
			
			String a = request.getParameter("patt_nam");
			System.out.println("pattern name :"+a);
			request.setAttribute("ref_patt", a);
			
			request.setAttribute("msg", msg);
			forward = "./CCSS_AddCureCycleInsert.jsp";
		}
		else if (action != "" && action.equalsIgnoreCase("Insert"))
		{
			
			ArrayList<CCSS_AddCureCycleBean> reports = cycleDao.genereport(request, users);
			request.setAttribute("ReportComp", reports);
			
			
			synchronized (this)
			{
				msg = cycleDao.insCureCycle(request);
				
				if(msg.equals("0"))
				{
					msg = "Error in inserting data";
					
				}
				else
				{
					msg = "Data inserted successfully";
					
				}
				request.setAttribute("msg",msg);
				forward = "./CCSS_AddCureCycle.jsp";
			}
		}
		else if (action != "" && action.equalsIgnoreCase("Report"))
		{
			System.out.println("inside node number report");
			
			
			forward = "./CCSS_AddCureCycleReportFilter.jsp";
			
		}
		else if(action != "" && action.equalsIgnoreCase("FilterReport"))
		{
			String a = request.getParameter("new_des");
			System.out.println("New Design :"+a);
			String b = request.getParameter("ref_des");
			System.out.println("Reference Design :"+b);
			
			System.out.println("inside Report");
			ArrayList<CCSS_AddCureCycleBean> reports = cycleDao.genereport(request, users);
			request.setAttribute("ReportComp", reports);
			
			ArrayList<CCSS_AddCureCycleBean> reports1 = cycleDao.genereportRef(request, users);
			request.setAttribute("ReportRef", reports1);
			forward = "./CCSS_AddCureCycleReport.jsp";
			
		}
		else if(action != "" && action.equalsIgnoreCase("Revision"))
		{
			System.out.println("inside Edit");
			
			request.setAttribute("msg", msg);
			
			forward = "./CCSS_RevisionCureCycle.jsp";
			
		}
		else if(action != "" && action.equalsIgnoreCase("Modify"))
		{
			System.out.println("inside modify");
			
			CCSS_AddCureCycleBean groupBean = null;
			groupBean = cycleDao.getTyre(request);
			request.setAttribute("groupupdate", groupBean);
			
			request.setAttribute("msg", msg);
			forward = "./CCSS_RevisionCureCycleFilter.jsp";
			
		}
		else if(action != "" && action.equalsIgnoreCase("Update"))
		{
			String a = request.getParameter("cons");
			System.out.println("Construction :"+a);
			synchronized (this) 
			{	
				msg = cycleDao.editData(request);
				
				if (msg.equals("0"))
				{
					msg = "Error in Inserting Data.";
					
				}
				else
				{
					msg = "Data Updated Successfully.";
					
				}
				request.setAttribute("msg", msg);
				
				forward = "./CCSS_AddCureCycle.jsp";
			}
			
		}
		else if(action != "" && action.equalsIgnoreCase("Edit"))
		{
			System.out.println("inside Edit");
			
			request.setAttribute("msg", msg);
			
			forward = "./CCSS_EditCureCycle.jsp";
			
		}
		else if(action != "" && action.equalsIgnoreCase("Modified"))
		{
			System.out.println("inside modify");
			
			CCSS_AddCureCycleBean groupBean = null;
			groupBean = cycleDao.getTyreSize(request);
			request.setAttribute("groupupdate", groupBean);
			
			request.setAttribute("msg", msg);
			forward = "./CCSS_EditCureCycleFilter.jsp";
			
		}
		else if(action != "" && action.equalsIgnoreCase("Updated"))
		{
			String a = request.getParameter("cons");
			System.out.println("Construction :"+a);
			synchronized (this) 
			{	
				msg = cycleDao.editCurecycle(request);
				
				if (msg.equals("0"))
				{
					msg = "Error in Inserting Data.";
					
				}
				else
				{
					msg = "Data Updated Successfully.";
					
				}
				request.setAttribute("msg", msg);
				
				forward = "./CCSS_AddCureCycle.jsp";
			}
			
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
