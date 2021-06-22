<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="beans.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cure Code Report</title>
<%@ include file="/CCSS/CCSS_CSS_Container.jsp" %> 
<%@ include file="/CCSS/CCSS_JS_Container.jsp"  %>
</head>
<%
				ArrayList<CCSS_AddCureCodeBean> genReports = null;
				if(request.getAttribute("reportcure") != null)
				{
					genReports = (ArrayList<CCSS_AddCureCodeBean>) request.getAttribute("reportcure");
					//System.out.println(genReports.size());
				}
				else
				{
					genReports = new ArrayList<CCSS_AddCureCodeBean>();
				}
			%>
<body>
<jsp:include page="/CCSS/CCSS_Header.jsp"/>
<div class="container col-5">

<form action="CCSS_AddCureCodeServlet" method="post" name="formAddNode">
	
	<center>
		<h3 class="my-2 text-success">Cure Code Report</h3>
		<table class="table table-responsive table-hover table-striped" id="userTbl">
		<thead>
    		<tr style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
    			<th>Sr. no</th>
        		<th>Section</th>
        		<th>Cure Code Name</th>
    		</tr>
   		</thead>
   		<tbody>
        		<%for(CCSS_AddCureCodeBean list : genReports){ %>
  				<tr style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
  				
    				<td><%=list.getSRNO()%></td>
    				<td><%=list.getSEC()%></td>
    				<td><%=list.getCURE_CODE() %></td>
    				
  				</tr>
  				<%} %>
      	</tbody>
      	</table>
		
		<input type="button" class="my-3 btn btn-success btn-md" value="Download to Excel" onclick="exportExl()" value="Export">
		<input type="hidden" value="" name="action" id="action" />
		</center>
		
	</form>
</div>
<script type="text/javascript">
			function exportExl()
			{				
				$("#userTbl").table2excel({
				    exclude:".noExl",
				    name:"Worksheet Name",
				    filename:"Cure Code Report",//do not include extension
				    fileext:".xls" // file extension
				  });							
			}
		</script>

<jsp:include page="/CCSS/CCSS_Footer.jsp"/>

</body>
</html>