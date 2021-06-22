package mapper;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.CCSS_AddCompundBean;
import beans.CCSS_AddPatternBean;
import beans.CCSS_Control_No;
import beans.UserBean;
import utility.CCSS_hibernateFactory;

public class CCSS_AddPatternMapper implements dao.CCSS_AddPatternDao{
	
	public String msg = "";
	
	public CCSS_AddPatternMapper(){
		
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
	public String insPattern(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = "";
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			tx = (Transaction) session.beginTransaction();
			
			CCSS_AddPatternBean pattBean = new CCSS_AddPatternBean();
			
			HttpSession httpSession = request.getSession();
			UserBean users = (UserBean) httpSession.getAttribute("Users");
			getControlsno(users.getPlt(),"CCSS_PatternMst");
			
			if (obj == null)
			{
				session = CCSS_hibernateFactory.openSession();
				tx = (Transaction) session.beginTransaction();
				System.out.println("into obj...");
				obj = new CCSS_Control_No();
				obj.setPLT(users.getPlt());
				obj.setFIN_YR(users.getFinyear());
				obj.setCTRLNO_DOCUMENT("CCSS_PatternMst");
				obj.setCTRLNO_NEXT_NO(0);
			}
			
			pattBean.setSRNO(obj.getCTRLNO_NEXT_NO()+1);
			pattBean.setPLT(users.getPlt());
			pattBean.setSEC(users.getSec());
			pattBean.setPATT_NAM(request.getParameter("patt_nam"));
			pattBean.setFLG("Y");
			pattBean.setUPD_ON(new Date());
			pattBean.setUPD_BY(users.getUid());
			
			session.save(pattBean);
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
	public ArrayList<CCSS_AddPatternBean> genereport(HttpServletRequest request, UserBean users) {
		// TODO Auto-generated method stub
		Session session = null;
		ArrayList<CCSS_AddPatternBean> lstpatt = null;
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			int plt = users.getPlt();
			
			Query query = session.createQuery("from CCSS_AddPatternBean "
					+ " where PLT ="+users.getPlt()+" ");
			lstpatt = (ArrayList<CCSS_AddPatternBean>) query.list();
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
		return lstpatt;
	}
}
