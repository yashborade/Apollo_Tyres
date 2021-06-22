package mapper;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.CCSS_AddCureCodeBean;
import beans.CCSS_AddPatternBean;
import beans.CCSS_Control_No;
import beans.UserBean;
import utility.CCSS_hibernateFactory;

public class CCSS_AddCureCodeMapper implements dao.CCSS_AddCureCodeDao {
	
	public String msg = "";
	
	public CCSS_AddCureCodeMapper(){
		
			CCSS_hibernateFactory.buildIfNeeded();
	}
	
	private CCSS_Control_No obj = null;
	
	private  void getControlsno(int plt, String table) 
	{
		Session session = null;
		session = CCSS_hibernateFactory.openSession();
		Query query = session.createQuery("from CCSS_Control_No where PLT = " + plt + " "
				+ " and CTRLNO_DOCUMENT='" + table + "'");
		obj = (CCSS_Control_No) query.uniqueResult();
	}

	@Override
	public String insCurecode(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = "";
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			tx = (Transaction) session.beginTransaction();
			
			CCSS_AddCureCodeBean cureBean = new CCSS_AddCureCodeBean();
			HttpSession httpSession = request.getSession();
			UserBean users = (UserBean) httpSession.getAttribute("Users");
			getControlsno(users.getPlt(),"CCSS_CureCodeMst");
			
			if (obj == null)
			{
				session = CCSS_hibernateFactory.openSession();
				tx = (Transaction) session.beginTransaction();
				System.out.println("into obj...");
				obj = new CCSS_Control_No();
				obj.setPLT(users.getPlt());
				obj.setFIN_YR(users.getFinyear());
				obj.setCTRLNO_DOCUMENT("CCSS_CureCodeMst");
				obj.setCTRLNO_NEXT_NO(0);
			}
			
			cureBean.setSRNO(obj.getCTRLNO_NEXT_NO()+1);
			cureBean.setPLT(users.getPlt());
			cureBean.setSEC(users.getSec());
			cureBean.setCURE_CODE(request.getParameter("cure_nam"));
			cureBean.setFLG("Y");
			cureBean.setUPD_ON(new Date());
			cureBean.setUPD_BY(users.getUid());
			session.save(cureBean);
			session.flush();
			tx.commit();
			msg = "<font color='green' style='font-size: 14pt;'><b>Data Inserted Successfully.</b></font>";
			
			obj.setCTRLNO_NEXT_NO(obj.getCTRLNO_NEXT_NO()+1);
			session.saveOrUpdate(obj);
			session.flush();
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception fired" + ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				CCSS_hibernateFactory.close(session);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return msg;
	}

	@Override
	public ArrayList<CCSS_AddCureCodeBean> genereport(HttpServletRequest request, UserBean users) {
		// TODO Auto-generated method stub
		Session session = null;
		ArrayList<CCSS_AddCureCodeBean> lstcure = null;
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			int plt = users.getPlt();
			
			Query query = session.createQuery("from CCSS_AddCureCodeBean "
					+ " where PLT ="+users.getPlt()+" ");
			lstcure = (ArrayList<CCSS_AddCureCodeBean>) query.list();
		}
		catch(Exception ex)
		{
			System.out.println("Mapper Method --> Exception" + ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				CCSS_hibernateFactory.close(session);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return lstcure;
	}
}
