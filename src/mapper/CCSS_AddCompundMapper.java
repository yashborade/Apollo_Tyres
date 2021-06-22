package mapper;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.CCSS_AddCompundBean;
import beans.CCSS_Control_No;
import beans.UserBean;
import utility.CCSS_hibernateFactory;

public class CCSS_AddCompundMapper implements dao.CCSS_AddCompoundDao{
	
	public String msg = "";
	
	public CCSS_AddCompundMapper(){
		
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
	public String insComp(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = "";
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			tx = (Transaction) session.beginTransaction();
			
			CCSS_AddCompundBean compBean = new CCSS_AddCompundBean();
			
			HttpSession httpSession = request.getSession();
			UserBean users = (UserBean) httpSession.getAttribute("Users");
			getControlsno(users.getPlt(),"CCSS_CompoundMst");
			
			if (obj == null)
			{
				session = CCSS_hibernateFactory.openSession();
				tx = (Transaction) session.beginTransaction();
				System.out.println("into obj...");
				obj = new CCSS_Control_No();
				obj.setPLT(users.getPlt());
				obj.setFIN_YR(users.getFinyear());
				obj.setCTRLNO_DOCUMENT("CCSS_CompoundMst");
				obj.setCTRLNO_NEXT_NO(0);
			}
			
			compBean.setSRNO(obj.getCTRLNO_NEXT_NO()+1);
			compBean.setPLT(users.getPlt());
			compBean.setSEC(users.getSec());
			compBean.setCOMP_PKG(request.getParameter("cmp_pkg"));
			compBean.setCOMP_NAME(request.getParameter("cmp_nam"));
			compBean.setFLG("Y");
			compBean.setUPD_ON(new Date());
			compBean.setUPD_BY(users.getUid());
			session.save(compBean);
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
	public ArrayList<CCSS_AddCompundBean> genereport(HttpServletRequest request, UserBean users) {
		// TODO Auto-generated method stub
		
		Session session = null;
		ArrayList<CCSS_AddCompundBean> lstComp = null;
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			int plt = users.getPlt();
			
			Query query = session.createQuery("from CCSS_AddCompundBean "
					+ " where PLT ="+users.getPlt()+" ");
			lstComp = (ArrayList<CCSS_AddCompundBean>) query.list();
		}
		catch(Exception ex)
		{
			System.out.println("Machine Number Method --> Exception" + ex.getMessage());
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
		return lstComp;
	}
}
