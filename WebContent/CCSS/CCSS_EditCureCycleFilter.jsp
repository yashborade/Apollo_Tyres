<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Cure Cycle</title>
<%@ include file="/CCSS/CCSS_CSS_Container.jsp" %> 
<%@ include file="/CCSS/CCSS_JS_Container.jsp"  %>
<script type="text/javascript">
		function submitValues(element)
		{	
			if(element.value=="Updated"){
					//alert("ins"+element.value);
					document.formEdit.action.value="Updated";
					//alert("action"+document.getElementById("action").value);
					document.formEdit.submit();
			}
			else if(element.value=="cancel")
			{
				//alert("can"+element.value);
				document.formEdit.action.value="cancel";
				//alert("action"+document.getElementById("action").value);
				document.formEdit.submit();

			}
		}
</script>
<script type="text/javascript">
	$(function() {   
	    function split( val ) {
	      return val.split( /,\s*/ );
	    }
	    function extractLast( term ) {
	      return split( term ).pop();
	    }
	  </script>
</head>
<body>
<%
		HttpSession httpSession = request.getSession();
		UserBean users = (UserBean) httpSession.getAttribute("Users");	

%>
<%
	CCSS_AddCureCycleBean groupBean = null;
	groupBean = (CCSS_AddCureCycleBean) request.getAttribute("groupupdate");
	
	System.out.println("group Data :"+groupBean);
	
	CCSS_AddCureCycleBean groupData = null;
	if(request.getAttribute("groupupdate") != null)
	{
		System.out.println("into groupdata");
		groupData = (CCSS_AddCureCycleBean) request.getAttribute("groupupdate");
		//System.ot.println("sz"+ftData.size());
	}
	else
	{
		groupData = new CCSS_AddCureCycleBean();
		//out.println("no records to display...");	
	} 
%>
<jsp:include page="/CCSS/CCSS_Header.jsp"/>
<form action="CCSS_AddCureCycleServlet" method="get" name="formEdit">		
		
	<div class="container mt-3">
		<div class="row">
			<div class="col-xs-12 text-center pt-1" style="border-radius:20px 20px 0 0; font-weight :bold; font-size:16pt; letter-spacing: 1px;  width: 100%; height:40px; background-color: #a78cc2;">
				Update Cure Cycle
			</div>
			<table>
			<tr>
			
			<th>Pattern Name :-</font> <input type="text" name="patt_nam" id="patt_nam" value= "<%=groupData.getPATT_NAM() %>" placeholder="Pattern Name " readonly style="height: 50px; width: 1135px"/></p></th>
			<th></font> <input type="hidden" name="rev_no" id="rev_no" value= "<%=groupData.getREV_NO() %>" placeholder="Construction " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Tyre Size :-</font> <input type="text" name="tyre_size" id="tyre_size" value= "<%=groupData.getTYRE_SIZE() %>" placeholder="Tyre Size " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Construction :-</font> <input type="text" name="cons" id="cons" value= "<%=groupData.getCONS() %>" readonly="readonly" placeholder="Construction " style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Cap :-</font> <input type="text" name="cap" id="cap" value= "<%=groupData.getTHR_CAP() %>" placeholder="Construction " readonly="readonly" style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Base :-</font> <input type="text" name="base" id="base" value= "<%=groupData.getTHR_BASE() %>" placeholder="Construction " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>WingTip :-</font> <input type="text" name="wingtip" id="wingtip" value= "<%=groupData.getTHR_WINGTIP() %>" placeholder="Construction " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Tyre Code :-</font> <input type="text" name="tyre_code" id="tyre_code" value= "<%=groupData.getTYRE_CODE() %>" placeholder="Tyre Code " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Gauge Name:-</font> <input type="text" name="central" id="central" value= "<%=groupData.getGAUGES_CENTRAL() %>" placeholder="Construction " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Thread Center:-</font> <input type="text" name="th_cen" id="th_cen" value= "<%=groupData.getTHREAD_CENTRAL() %>" placeholder="Construction " style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Total Center:-</font> <input type="text" name="to_cen" id="to_cen" value= "<%=groupData.getTOTAL_CENTRAL() %>" placeholder="Construction "  style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Gauge Name :-</font> <input type="text" name="shoulder" id="shoulder" value= "<%=groupData.getGAUGES_SHOULDER() %>" placeholder="Construction " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Thread Shoulder:-</font> <input type="text" name="th_sh" id="th_sh" value= "<%=groupData.getTHREAD_SHOULDER() %>" placeholder="Construction " style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Total Shoulder:-</font> <input type="text" name="to_sh" id="to_sh" value= "<%=groupData.getTOTAL_SHOULDER() %>" placeholder="Construction " style="height: 50px; width: 1135px"/></p></th>
			</tr>
			<tr>
			<th>Cure Code :-</font> <input type="text" name="cure_code" id="cure_code" value= "<%=groupData.getCURE_CODE() %>" placeholder="Cure Code " readonly style="height: 50px; width: 1135px"/></p></th>
			</tr>
			</table>
	</div>
</div>
	<div class="row">
			<div class="col-md-12 text-center">
				<input type="hidden" value="" name="action" id="action" />
				<input class="my-3 py-2" type="button" value="Updated" id="Update" onclick="submitValues(this)" style=" border:2px solid black; letter-spacing: 2px; font-weight:300; border-radius:20px 0  0 20px; background-color: #e94e0f; color:white; font-size: 14pt; " />
				<input class="my-3 py-2" type="button" value="cancel" id="cancel" onclick="submitValues(this)" style="  border:2px solid black; letter-spacing: 2px; font-weight:300; border-radius: 0 20px 20px 0; background-color: #e94e0f; color:white; font-size: 14pt; " />
			</div>		  
		</div>
</form>
</body>
</html>