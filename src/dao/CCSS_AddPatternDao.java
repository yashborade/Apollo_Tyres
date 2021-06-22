package dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.CCSS_AddPatternBean;
import beans.UserBean;

public interface CCSS_AddPatternDao {
	
	String insPattern(HttpServletRequest request);
	
	ArrayList<CCSS_AddPatternBean> genereport(HttpServletRequest request, UserBean users);

}
