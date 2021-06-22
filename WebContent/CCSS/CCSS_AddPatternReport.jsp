<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="beans.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pattern Report</title>
<%@ include file="/CCSS/CCSS_CSS_Container.jsp" %> 
<%@ include file="/CCSS/CCSS_JS_Container.jsp"  %>
</head>
<%
				ArrayList<CCSS_AddPatternBean> genReports = null;
				if(request.getAttribute("reportpatt") != null)
				{
					genReports = (ArrayList<CCSS_AddPatternBean>) request.getAttribute("reportpatt");
					//System.out.println(genReports.size());
				}
				else
				{
					genReports = new ArrayList<CCSS_AddPatternBean>();
				}
			%>
<body>
<jsp:include page="/CCSS/CCSS_Header.jsp"/>
<div class="container col-3">

<form action="CCSS_AddPatternServlet" method="post" name="formAddNode">
	
	<center>
		<h3 class="my-2 text-success">Pattern Report</h3>
		<table class="table table-responsive table-hover table-striped" id="userTbl">
		<thead>
    		<tr style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
    			<th>Sr. no</th>
        		<th>Section</th>
        		<th>Pattern Name</th>
    		</tr>
   		</thead>
   		<tbody>
        		<%for(CCSS_AddPatternBean list : genReports){ %>
  				<tr style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
  				
    				<td><%=list.getSRNO()%></td>
    				<td><%=list.getSEC()%></td>
    				<td><%=list.getPATT_NAM() %></td>
    				
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
				    filename:"Pattern Report",//do not include extension
				    fileext:".xls" // file extension
				  });							
			}
		</script>

<jsp:include page="/CCSS/CCSS_Footer.jsp"/>

</body>
</html>