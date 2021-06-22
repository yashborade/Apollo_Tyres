package dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.CCSS_AddCureCycleBean;
import beans.UserBean;

public interface CCSS_AddCureCycleDao {
	
	String insCureCycle(HttpServletRequest request);
	
	ArrayList<CCSS_AddCureCycleBean> genereport (HttpServletRequest request, UserBean users);
	
	ArrayList<CCSS_AddCureCycleBean> genereportRef (HttpServletRequest request, UserBean users);
	
	String editData(HttpServletRequest request);
	
	CCSS_AddCureCycleBean getTyre(HttpServletRequest request);
	
	String editCurecycle(HttpServletRequest request);
	
	CCSS_AddCureCycleBean getTyreSize(HttpServletRequest request);
	
	CCSS_AddCureCycleBean getPattern(HttpServletRequest request);
	
	
	

}
