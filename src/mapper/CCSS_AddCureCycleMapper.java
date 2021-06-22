package mapper;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibm.db2.jcc.am.r;

import beans.CCSS_AddCompundBean;
import beans.CCSS_AddCureCycleBean;
import beans.CCSS_Control_No;
import beans.UserBean;
import utility.CCSS_hibernateFactory;

public class CCSS_AddCureCycleMapper implements dao.CCSS_AddCureCycleDao{
	
	public String msg = "";
	
	public CCSS_AddCureCycleMapper(){
		
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
	public String insCureCycle(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = "";
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			tx = (Transaction) session.beginTransaction();
			
			CCSS_AddCureCycleBean cureBean = new CCSS_AddCureCycleBean();
			
			HttpSession httpSession = request.getSession();
			UserBean users = (UserBean) httpSession.getAttribute("Users");
			getControlsno(users.getPlt(),"CCSS_CureMst");
			
			if (obj == null)
			{
				session = CCSS_hibernateFactory.openSession();
				tx = (Transaction) session.beginTransaction();
				System.out.println("into obj...");
				obj = new CCSS_Control_No();
				obj.setPLT(users.getPlt());
				obj.setFIN_YR(users.getFinyear());
				obj.setCTRLNO_DOCUMENT("CCSS_CureMst");
				obj.setCTRLNO_NEXT_NO(0);
			}
			
			String a = request.getParameter("th_cen");
			double x = Double.parseDouble(a);
			
			String b = request.getParameter("to_cen");
			double y = Double.parseDouble(b);
			
			String c = request.getParameter("th_sh");
			double z = Double.parseDouble(c);
			
			String d = request.getParameter("to_sh");
			double w = Double.parseDouble(d);
			
			cureBean.setSRNO(obj.getCTRLNO_NEXT_NO()+1);
			cureBean.setPLT(users.getPlt());
			cureBean.setSEC(users.getSec());
			cureBean.setREV_NO(0);
			cureBean.setPATT_NAM(request.getParameter("patt_nam"));
			cureBean.setTYRE_SIZE(request.getParameter("tyre_size"));
			cureBean.setCONS(request.getParameter("cons"));
			cureBean.setTHR_CAP(request.getParameter("cap"));
			cureBean.setTHR_BASE(request.getParameter("base"));
			cureBean.setTHR_WINGTIP(request.getParameter("wingtip"));
			cureBean.setTYRE_CODE(request.getParameter("tyre_code"));
			cureBean.setGAUGES_CENTRAL(request.getParameter("central"));
			cureBean.setGAUGES_SHOULDER(request.getParameter("shoulder"));
			cureBean.setTHREAD_CENTRAL(x);
			cureBean.setTOTAL_CENTRAL(y);
			cureBean.setTHREAD_SHOULDER(z);
			cureBean.setTOTAL_SHOULDER(w);
			cureBean.setCURE_CODE(request.getParameter("cure_code"));
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
	public ArrayList<CCSS_AddCureCycleBean> genereport(HttpServletRequest request, UserBean users) {
		// TODO Auto-generated method stub
		Session session = null;
		ArrayList<CCSS_AddCureCycleBean> lstComp = null;
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			int plt = users.getPlt();
			
			Query query = session.createQuery("from CCSS_AddCureCycleBean "
					+ " where PLT ="+users.getPlt()+" "
					+ "and PATT_NAM = '"+request.getParameter("new_des")+"'"
					+ "and FLG = 'Y'");
			lstComp = (ArrayList<CCSS_AddCureCycleBean>) query.list();
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

	@Override
	public ArrayList<CCSS_AddCureCycleBean> genereportRef(HttpServletRequest request, UserBean users) {
		// TODO Auto-generated method stub
		Session session = null;
		ArrayList<CCSS_AddCureCycleBean> lstComp = null;
		
		try
		{
			session = CCSS_hibernateFactory.openSession();
			int plt = users.getPlt();
			
			Query query = session.createQuery("from CCSS_AddCureCycleBean "
					+ " where PLT ="+users.getPlt()+" "
					+ "and PATT_NAM = '"+request.getParameter("ref_des")+"'"
					+ "and FLG = 'Y'");
			lstComp = (ArrayList<CCSS_AddCureCycleBean>) query.list();
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

	@Override
	public String editData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = "";
		
		try
		{
			String n = request.getParameter("patt_nam");
			System.out.println("Pattern name :"+n);
			
			session = CCSS_hibernateFactory.openSession();
			tx = (Transaction) session.beginTransaction();
			
			Query query = session.createQuery("UPDATE CCSS_AddCureCycleBean c set c.FLG = 'N'"
					+ "where c.PATT_NAM = :patt_nam");
			query.setParameter("patt_nam", n);
			int result = query.executeUpdate();
			System.out.println("rows affected :"+result);
			
			CCSS_AddCureCycleBean cureBean = new CCSS_AddCureCycleBean();
			
			HttpSession httpSession = request.getSession();
			UserBean users = (UserBean) httpSession.getAttribute("Users");
			getControlsno(users.getPlt(),"CCSS_CureMst");
			
			if (obj == null)
			{
				session = CCSS_hibernateFactory.openSession();
				tx = (Transaction) session.beginTransaction();
				System.out.println("into obj...");
				obj = new CCSS_Control_No();
				obj.setPLT(users.getPlt());
				obj.setFIN_YR(users.getFinyear());
				obj.setCTRLNO_DOCUMENT("CCSS_CureMst");
				obj.setCTRLNO_NEXT_NO(0);
			}
			
			
			
			String a = request.getParameter("th_cen");
			double x = Double.parseDouble(a);
			
			String b = request.getParameter("to_cen");
			double y = Double.parseDouble(b);
			
			String c = request.getParameter("th_sh");
			double z = Double.parseDouble(c);
			
			String d = request.getParameter("to_sh");
			double w = Double.parseDouble(d);
			
			String e = request.getParameter("rev_no");
			int rev = Integer.parseInt(e);
			
			cureBean.setSRNO(obj.getCTRLNO_NEXT_NO()+1);
			cureBean.setPLT(users.getPlt());
			cureBean.setSEC(users.getSec());
			cureBean.setREV_NO(rev+1);
			cureBean.setPATT_NAM(request.getParameter("patt_nam"));
			cureBean.setTYRE_SIZE(request.getParameter("tyre_size"));
			cureBean.setCONS(request.getParameter("cons"));
			cureBean.setTHR_CAP(request.getParameter("cap"));
			cureBean.setTHR_BASE(request.getParameter("base"));
			cureBean.setTHR_WINGTIP(request.getParameter("wingtip"));
			cureBean.setTYRE_CODE(request.getParameter("tyre_code"));
			cureBean.setGAUGES_CENTRAL(request.getParameter("central"));
			cureBean.setGAUGES_SHOULDER(request.getParameter("shoulder"));
			cureBean.setTHREAD_CENTRAL(x);
			cureBean.setTOTAL_CENTRAL(y);
			cureBean.setTHREAD_SHOULDER(z);
			cureBean.setTOTAL_SHOULDER(w);
			cureBean.setCURE_CODE(request.getParameter("cure_code"));
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
		return msg;
	}

	@Override
	public CCSS_AddCureCycleBean getTyre(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		CCSS_AddCureCycleBean lst = null;
		try
		{
			session = CCSS_hibernateFactory.openSession();
			Query query = session.createQuery("from CCSS_AddCureCycleBean where "
					+ "TYRE_SIZE ='" + request.getParameter("tyre_size") + "'"
					+ "and FLG = 'Y'");
			lst = (CCSS_AddCureCycleBean) query.uniqueResult();
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
		return lst;
	}

	@Override
	public String editCurecycle(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String msg = "";
		
		try
		{
			String n = request.getParameter("patt_nam");
			System.out.println("Pattern name :"+n);
			String m = request.getParameter("cons");
			System.out.println("construction :"+m);
			
			session = CCSS_hibernateFactory.openSession();
			tx = (Transaction) session.beginTransaction();
			
			CCSS_AddCureCycleBean cureBean = new CCSS_AddCureCycleBean();
			
			HttpSession httpSession = request.getSession();
			UserBean users = (UserBean) httpSession.getAttribute("Users");
			getControlsno(users.getPlt(),"CCSS_CureMst");
			
			if (obj == null)
			{
				session = CCSS_hibernateFactory.openSession();
				tx = (Transaction) session.beginTransaction();
				System.out.println("into obj...");
				obj = new CCSS_Control_No();
				obj.setPLT(users.getPlt());
				obj.setFIN_YR(users.getFinyear());
				obj.setCTRLNO_DOCUMENT("CCSS_CureMst");
				obj.setCTRLNO_NEXT_NO(0);
			}
			
			
			String a = request.getParameter("th_cen");
			double x = Double.parseDouble(a);
			
			String b = request.getParameter("to_cen");
			double y = Double.parseDouble(b);
			
			String c = request.getParameter("th_sh");
			double z = Double.parseDouble(c);
			
			String d = request.getParameter("to_sh");
			double w = Double.parseDouble(d);
			
			String o = request.getParameter("rev_no");
			int rev = Integer.parseInt(o);
			
			
			cureBean.setSRNO(obj.getCTRLNO_NEXT_NO()+1);
			cureBean.setPLT(users.getPlt());
			cureBean.setSEC(users.getSec());
			cureBean.setREV_NO(rev);
			cureBean.setPATT_NAM(request.getParameter("patt_nam"));
			cureBean.setTYRE_SIZE(request.getParameter("tyre_size"));
			cureBean.setCONS(request.getParameter("cons"));
			cureBean.setTHR_CAP(request.getParameter("cap"));
			cureBean.setTHR_BASE(request.getParameter("base"));
			cureBean.setTHR_WINGTIP(request.getParameter("wingtip"));
			cureBean.setTYRE_CODE(request.getParameter("tyre_code"));
			cureBean.setGAUGES_CENTRAL(request.getParameter("central"));
			cureBean.setGAUGES_SHOULDER(request.getParameter("shoulder"));
			cureBean.setTHREAD_CENTRAL(x);
			cureBean.setTOTAL_CENTRAL(y);
			cureBean.setTHREAD_SHOULDER(z);
			cureBean.setTOTAL_SHOULDER(w);
			cureBean.setCURE_CODE(request.getParameter("cure_code"));
			cureBean.setFLG("Y");
			cureBean.setUPD_ON(new Date());
			cureBean.setUPD_BY(users.getUid());
			
			session.update(cureBean);
			session.flush();
			tx.commit();
			msg = "<font color='green' style='font-size: 14pt;'><b>Data Inserted Successfully.</b></font>";
			
			obj.setCTRLNO_NEXT_NO(obj.getCTRLNO_NEXT_NO()+1);
			session.saveOrUpdate(obj);
			session.flush();
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
		return msg;
	}

	@Override
	public CCSS_AddCureCycleBean getTyreSize(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		CCSS_AddCureCycleBean lst = null;
		try
		{
			session = CCSS_hibernateFactory.openSession();
			Query query = session.createQuery("from CCSS_AddCureCycleBean where "
					+ "TYRE_SIZE ='" + request.getParameter("tyre_size") + "'"
					+ "and FLG = 'Y'");
			lst = (CCSS_AddCureCycleBean) query.uniqueResult();
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
		return lst;
	}

	@Override
	public CCSS_AddCureCycleBean getPattern(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		CCSS_AddCureCycleBean lst = null;
		try
		{
			session = CCSS_hibernateFactory.openSession();
			Query query = session.createQuery("from CCSS_AddCureCycleBean where "
					+ "PATT_NAM ='" + request.getParameter("refpatt_nam") + "'"
					+ "and FLG = 'Y'");
			lst = (CCSS_AddCureCycleBean) query.uniqueResult();
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
		return lst;
	}
}
