package mapper;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.CCSS_AddCompundBean;
import beans.CCSS_AddGaugesBean;
import beans.CCSS_AddPatternBean;
import beans.CCSS_Control_No;
import beans.UserBean;
import utility.CCSS_hibernateFactory;

public class CCSS_AddGaugeMapper implements dao.CCSS_AddGaugesDao{
	
	public String msg = "";
	
	public CCSS_AddGaugeMapper(){
		
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
	public String insGauge(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = "";
		try
		{
			session = CCSS_hibernateFactory.openSession();
			tx = (Transaction) session.beginTransaction();
			
			CCSS_AddGaugesBean gaugeBean = new CCSS_AddGaugesBean();
			
			
			HttpSession httpSession = request.getSession();
			UserBean users = (UserBean) httpSession.getAttribute("Users");
			getControlsno(users.getPlt(),"CCSS_GaugeMst");
			
			if (obj == null)
			{
				session = CCSS_hibernateFactory.openSession();
				tx = (Transaction) session.beginTransaction();
				System.out.println("into obj...");
				obj = new CCSS_Control_No();
				obj.setPLT(users.getPlt());
				obj.setFIN_YR(users.getFinyear());
				obj.setCTRLNO_DOCUMENT("CCSS_GaugeMst");
				obj.setCTRLNO_NEXT_NO(0);
			}
			
			String a = request.getParameter("thread");
			double th = Double.parseDouble(a);
			
			String b = request.getParameter("total");
			double to = Double.parseDouble(b);
			
			gaugeBean.setSRNO(obj.getCTRLNO_NEXT_NO()+1);
			gaugeBean.setPLT(users.getPlt());
			gaugeBean.setSEC(users.getSec());
			gaugeBean.setTYRE_CODE(request.getParameter("size"));
			gaugeBean.setGAUGE_TYPE(request.getParameter("gauges"));
			gaugeBean.setTHREAD(th);
			gaugeBean.setTOTAL(to);
			gaugeBean.setFLG("Y");
			gaugeBean.setUPD_ON(new Date());
			gaugeBean.setUPD_BY(users.getUid());
			session.save(gaugeBean);
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
	public ArrayList<CCSS_AddGaugesBean> genereport(HttpServletRequest request, UserBean users) {
		// TODO Auto-generated method stub
		
		Session session = null;
		ArrayList<CCSS_AddGaugesBean> lstgauge = null;
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			int plt = users.getPlt();
			
			Query query = session.createQuery("from CCSS_AddGaugesBean "
					+ " where PLT ="+users.getPlt()+" ");
			lstgauge = (ArrayList<CCSS_AddGaugesBean>) query.list();
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
		return lstgauge;
	}
	

}
