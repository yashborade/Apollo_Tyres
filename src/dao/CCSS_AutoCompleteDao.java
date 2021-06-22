package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import beans.UserBean;

public interface CCSS_AutoCompleteDao {
	
	List<String> getTyresize(HttpServletRequest request, UserBean users);
	
	List<String> getPattern(HttpServletRequest request, UserBean users);
	
	List<String> getConstruction(HttpServletRequest request, UserBean users);
	
	List<String> getCompound(HttpServletRequest request, UserBean users);
	
	List<String> getCurecode(HttpServletRequest request, UserBean users);
}
