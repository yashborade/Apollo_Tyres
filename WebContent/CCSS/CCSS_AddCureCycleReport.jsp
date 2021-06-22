<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="beans.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cure Cycle Report</title>
<%@ include file="/CCSS/CCSS_CSS_Container.jsp" %> 
<%@ include file="/CCSS/CCSS_JS_Container.jsp"  %>
</head>
<%
				ArrayList<CCSS_AddCureCycleBean> genReports = null;
				if(request.getAttribute("ReportComp") != null)
				{
					genReports = (ArrayList<CCSS_AddCureCycleBean>) request.getAttribute("ReportComp");
					//System.out.println(genReports.size());
				}
				else
				{
					genReports = new ArrayList<CCSS_AddCureCycleBean>();
				}
			%>
			<%
				ArrayList<CCSS_AddCureCycleBean> genReports1 = null;
				if(request.getAttribute("ReportRef") != null)
				{
					genReports1 = (ArrayList<CCSS_AddCureCycleBean>) request.getAttribute("ReportRef");
					//System.out.println(genReports.size());
				}
				else
				{
					genReports1 = new ArrayList<CCSS_AddCureCycleBean>();
				}
			%>
<body>
<jsp:include page="/CCSS/CCSS_Header.jsp"/>
<div class="container col-5">

<form action="CCSS_AddCureCycleServlet" method="post" name="formAddNode">
	
	<center>
		<h3 class="my-2 text-success">Cure Cycle Report</h3>
		<table class="table table-responsive table-hover table-striped" id="userTbl" border='2'>
		
		<%for(CCSS_AddCureCycleBean list : genReports){ %>
		<%for(CCSS_AddCureCycleBean list1 : genReports1){ %>
    	<tr>
    		<th><center><img src="images/LOGOS/ApolloPNG5.png"></center></th>
    		<th colspan="5"><center>TECHNOLOGY DEPARTMENT LIMDA</center></th>
  		</tr>
  		<tr>
    		<td></td>
    		<td colspan="5"><b><center>Cure Verification for New Tyres</center></b></td>
  		</tr>
  		<tr>
    		<td></td>
    		<td colspan="2"><b>NEW DESIGN</b></td>
    		<td colspan="3"><b>Reference  Size</b></td>
  		</tr>
  		<tr>
    		<td><b>Pattern Name</b></td>
   	 		<td colspan="2"><%=list.getPATT_NAM() %></td>
    		<td colspan="3"><%=list1.getPATT_NAM() %></td>
  		</tr>
  		<tr>
    		<td><b>Tyre Size</b></td>
    		<td colspan="2"><%=list.getTYRE_SIZE() %></td>
    		<td colspan="3"><%=list1.getTYRE_SIZE() %></td>
  		</tr>
  		<tr>
    		<td><b>CONSTRUCTION</b></td>
    		<td colspan="2"><%=list.getCONS() %></td>
    		<td colspan="3"><%=list1.getCONS() %></td>
  		</tr>
  		<tr>
    		<td colspan="6"><b><center>Tread compound package</center></b></td>
  		</tr>
  		<tr>
    		<td><b>CAP</b></td>
    		<td colspan="2"><%=list.getTHR_CAP() %></td>
    		<td colspan="3"><%=list1.getTHR_CAP() %></td>
  		</tr>
  		<tr>
    		<td><b>BASE</b></td>
    		<td colspan="2"><%=list.getTHR_BASE() %></td>
    		<td colspan="3"><%=list1.getTHR_BASE() %></td>
  		</tr>
  		<tr>
    		<td><b>WINGTIP</b></td>
    		<td colspan="2"><%=list.getTHR_WINGTIP() %></td>
    		<td colspan="3"><%=list1.getTHR_WINGTIP() %></td>
  		</tr>
  		<tr>
    		<td colspan="6"><b><center>Tread Gauge comparison</center></b></td>
  		</tr>
  		<tr>
    		<td rowspan="3"></td>
    		<td rowspan="3"><b>TYRE CODE</b><br></td>
    		<td colspan="4"><b><center>Gauges</center></b></td>
  		</tr>
  		<tr>
    		<td colspan="2"><b>CENTER LINE</b></td>
    		<td colspan="2"><b>SHOULDER</b></td>
  		</tr>
  		<tr>
    		<td><b>Thread</b></td>
    		<td><b>Total</b></td>
    		<td><b>Thread</b></td>
    		<td><b>Total</b></td>
  		</tr>
  		<tr>
    		<td><b>New Design</b></td>
    		<td><%=list.getTYRE_CODE() %></td>
    		<td><%=list.getTHREAD_CENTRAL() %></td>
    		<td><%=list.getTOTAL_CENTRAL() %></td>
    		<td><%=list.getTHREAD_SHOULDER() %></td>
    		<td><%=list.getTOTAL_SHOULDER() %></td>
  		</tr>
  		<tr>
    		<td><b>Reference Size 1</b></td>
    		<td><%=list1.getTYRE_CODE() %></td>
    		<td><%=list1.getTHREAD_CENTRAL() %></td>
    		<td><%=list1.getTOTAL_CENTRAL() %></td>
    		<td><%=list1.getTHREAD_SHOULDER() %></td>
    		<td><%=list1.getTOTAL_SHOULDER() %></td>
  		</tr>
  		<!-- <tr>
    		<td><b>Reference Size 2</b></td>
    		<td>185/65 R14  86H  SN832i</td>
    		<td>1</td>
    		<td>1</td>
    		<td>1</td>
    		<td>1</td>
  		</tr> -->
  		<tr>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td></td>
  		</tr>
  		<tr>
    		<td><b>Remarks:</b></td>
    		<td colspan="5"></td>
  		</tr>
  		<tr>
    		<td colspan="2"><b>CURE CODE FOR Reference Size</b></td>
    		<td colspan="4"><%=list1.getCURE_CODE() %></td>
  		</tr>
  		<tr>
    		<td colspan="2"><b>CURE CODE FOR  New  design</b></td>
    		<td colspan="4"><%=list.getCURE_CODE() %></td>
  		</tr>
  		<tr>
    		<td colspan="6"><b><center>Revision History</center></b></td>
  		</tr>
  		<tr>
    		<td><b><center>Rev.No</center></b></td>
    		<td><b><center>Date</center></b></td>
    		<td colspan="4"><b><center>Reason For Change</center></b></td>
  		</tr>
  		<tr>
  		<% SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
  			Date date = new Date();
  			String a = formatter.format(date);
	  	%>
  			<td><center><%=list1.getREV_NO() %></center></td>
  			<td><center><%=a %></center></td>
    		<td colspan="4"><center></center></td>
  		</tr>
  		<tr>
    		<td><b><center>Originated By</center></b></td>
    		<td><b><center>Checked By</center></b></td>
    		<td colspan="4"><center><b>Approved By</b></center></td>
  		</tr>
  		<tr>
  			<td></td>
  			<td></td>
    		<td colspan="4"></td>
  		</tr>
  		<tr>
    		<td colspan="6"><font size="0px"><b>Developed by AODMS</b></font></td>
  		</tr>
  <%} %>
  <%} %>
  		
      	</table>
      	
		
		<input type="button" class="my-3 btn btn-success btn-md" value="Download to Pdf" onclick="exportExl()" value="Export">
		<input type="hidden" value="" name="action" id="action" />
		</center>
		
	</form>
</div>
<script type="text/javascript">

			function exportExl()
			{			
				html2canvas(document.getElementById('userTbl'), {
	                onrendered: function (canvas) {
	                    var data = canvas.toDataURL();
	                    var docDefinition = {
	                        content: [{
	                            image: data,
	                            width: 500,
	                            height: 760
	                        }]
	                    };
	                    pdfMake.createPdf(docDefinition).download("CureCycle.pdf");
	                }
	            });							
			}
		</script>

<jsp:include page="/CCSS/CCSS_Footer.jsp"/>

</body>
</html>