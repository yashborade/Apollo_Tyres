<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.UserBean"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Insert title here</title>
<%@ include file="/CCSS/CCSS_CSS_Container.jsp" %> 
<%@ include file="/CCSS/CCSS_JS_Container.jsp"  %>

<style>
.navbar-nav li:hover .dropdown-menu {
        display: block;
        color: purple;
    }
.navbar{ 
background-color: #e0e0eb;

}
 
.dropdown{
    border-radius:0;
    border:0; 
}
.dropdown-menu{
    background:#ffd6cc;
    border:0;
    top:80%; 
    border-radius:0px 0px 10px 10px;
}
.dropdown-item:hover{
    background: #ff3300;
    color:white;
    border-radius:10px 10px 10px 10px;
}
.dropdown-menu a{ 
    color: #5C2482;
}   
.navbar .nav-item .nav-link{
    color: purple;
    
}
.navbar .nav-item .nav-link:hover .navbar .nav-item .nav-link{
    color:white;
    
}  
</style>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	UserBean users1 = (UserBean) httpSession.getAttribute("Users");
%>  
    

<div style="background-color: white;" class="py-1 pl-3">
	<img src="images/LOGOS/ApolloPNG3.png" alt="Distance Logo"/>
</div>    
     
<nav class="navbar navbar-expand-lg navbar-light"> 
<a class="navbar-brand" href="/CureCycleSelectionSystem/CCSS/CCSS_Welcome.jsp" style="">
 <!-- <a class="navbar-brand" href="/EMS/ENS/ENS_Welcome.jsp" style=""> -->
  <img class="img-fluid" src="images/LOGOS/ApolloPNG5.png" alt="Distance Logo"/>
  </a>
        
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>  
     
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Master
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
 
          <a class="dropdown-item" href="CCSS_AddCompoundServlet?action=load">Add Compound</a>
          <a class="dropdown-item" href="CCSS_AddPatternServlet?action=load">Add Pattern</a>
           <a class="dropdown-item" href="CCSS_AddGaugesServlet?action=load">Add Gauges</a>
           <a class="dropdown-item" href="CCSS_AddCureCodeServlet?action=load">Add Cure Code</a>
           <a class="dropdown-item" href="CCSS_AddCureCycleServlet?action=load">Add Cure Cycle</a>
          
          </div>
         
      </li>
      
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Reports
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
 
          <a class="dropdown-item" href="CCSS_AddCompoundServlet?action=Report">Compound Report</a>
          <a class="dropdown-item" href="CCSS_AddPatternServlet?action=Report">Pattern Report</a>
           <a class="dropdown-item" href="CCSS_AddGaugesServlet?action=Report">Gauge Report</a>
           <a class="dropdown-item" href="CCSS_AddCureCodeServlet?action=Report">Cure Code Report</a>
           <a class="dropdown-item" href="CCSS_AddCureCycleServlet?action=Report">Cure Cycle Report</a>
          </div>         
      </li>
      </ul>
     
    <ul class="navbar-nav text-right">
    	<li class="nav-item active">
    		<a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Logged in as <%= users1.getUsername() %></a>
    	</li>
    </ul>
  </div>
</nav>


<script type="text/javascript">
$(document).ready(function () {
	$('.navbar-light .dmenu').hover(function () {
	        $(this).find('.sm-menu').first().stop(true, true).slideDown(150);
	    }, function () {
	        $(this).find('.sm-menu').first().stop(true, true).slideUp(105)
	    });
	});
</script>
	
</body>
</html>