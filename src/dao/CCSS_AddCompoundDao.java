package dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.CCSS_AddCompundBean;
import beans.UserBean;

public interface CCSS_AddCompoundDao {
	
	String insComp (HttpServletRequest request);
	
	ArrayList<CCSS_AddCompundBean> genereport(HttpServletRequest request, UserBean users);

}
