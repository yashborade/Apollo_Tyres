package mapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.UserBean;
import utility.CCSS_hibernateFactory;

public class CCSS_AutoCompleteMapper implements dao.CCSS_AutoCompleteDao {
	
		public CCSS_AutoCompleteMapper(){
		
			CCSS_hibernateFactory.buildIfNeeded();
		}

		@Override
		public List<String> getTyresize(HttpServletRequest request, UserBean users) {
			// TODO Auto-generated method stub
			
			Session session = null;
			List<String> lst = null;
			
			try
			{
				session = CCSS_hibernateFactory.openSession();
				Query query = session.createQuery("SELECT SIZE from TPRC_TyreMstBean where "
						+ " PLT=" + users.getPlt() + " "
						+ " and SIZE LIKE '%" + request.getParameter("term") + "%'");
				lst = (List<String>) query.list();
				System.out.println("size :"+lst.size());
			}
			catch(Exception ex)
			{
				System.out.println("Auto complete --> Exception" + ex.getMessage());
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
		public List<String> getPattern(HttpServletRequest request, UserBean users) {
			// TODO Auto-generated method stub
			Session session = null;
			List<String> lst = null;
			
			try
			{
				session = CCSS_hibernateFactory.openSession();
				Query query = session.createQuery("SELECT PATT_NAM from CCSS_AddPatternBean where "
						+ " PLT=" + users.getPlt() + " "
						+ " and PATT_NAM LIKE '%" + request.getParameter("term") + "%'");
				lst = (List<String>) query.list();
				System.out.println("size :"+lst.size());
			}
			catch(Exception ex)
			{
				System.out.println("Auto complete --> Exception" + ex.getMessage());
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
		public List<String> getConstruction(HttpServletRequest request, UserBean users) {
			// TODO Auto-generated method stub
			Session session = null;
			List<String> lst = null;
			
			try
			{
				session = CCSS_hibernateFactory.openSession();
				Query query = session.createQuery("SELECT CONST from BS_ConstMasterBean where "
						+ " PLT=" + users.getPlt() + " "
						+ " and CONST LIKE '%" + request.getParameter("term") + "%'");
				lst = (List<String>) query.list();
				System.out.println("size :"+lst.size());
			}
			catch(Exception ex)
			{
				System.out.println("Auto complete --> Exception" + ex.getMessage());
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
		public List<String> getCompound(HttpServletRequest request, UserBean users) {
			// TODO Auto-generated method stub
			Session session = null;
			List<String> lst = null;
			
			try
			{
				session = CCSS_hibernateFactory.openSession();
				Query query = session.createQuery("SELECT COMP_NAME from CCSS_AddCompundBean where "
						+ " PLT=" + users.getPlt() + " "
						+ " and COMP_NAME LIKE '%" + request.getParameter("term") + "%'");
				lst = (List<String>) query.list();
				System.out.println("size :"+lst.size());
			}
			catch(Exception ex)
			{
				System.out.println("Auto complete --> Exception" + ex.getMessage());
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
		public List<String> getCurecode(HttpServletRequest request, UserBean users) {
			// TODO Auto-generated method stub
			Session session = null;
			List<String> lst = null;
			
			try
			{
				session = CCSS_hibernateFactory.openSession();
				Query query = session.createQuery("SELECT CURE_CODE from CCSS_AddCureCodeBean where "
						+ " PLT=" + users.getPlt() + " "
						+ " and CURE_CODE LIKE '%" + request.getParameter("term") + "%'");
				lst = (List<String>) query.list();
				System.out.println("size :"+lst.size());
			}
			catch(Exception ex)
			{
				System.out.println("Auto complete --> Exception" + ex.getMessage());
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
