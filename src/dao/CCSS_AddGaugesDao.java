package dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import beans.CCSS_AddGaugesBean;
import beans.UserBean;

public interface CCSS_AddGaugesDao {
	
	String insGauge(HttpServletRequest request);
	
	ArrayList<CCSS_AddGaugesBean> genereport(HttpServletRequest request, UserBean users);

}
