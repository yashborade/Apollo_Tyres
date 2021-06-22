package dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.CCSS_AddCureCodeBean;
import beans.UserBean;

public interface CCSS_AddCureCodeDao {
	
	String insCurecode(HttpServletRequest request);
	
	ArrayList<CCSS_AddCureCodeBean> genereport(HttpServletRequest request, UserBean users);

}
