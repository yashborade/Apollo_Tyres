<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.UserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/CCSS/CCSS_CSS_Container.jsp" %> 
<%@ include file="/CCSS/CCSS_JS_Container.jsp"  %>
<title> Add Gauges</title>
</head>
<script type="text/javascript">
		function submitValues(element)
		{	
			if(element.value=="Insert"){
				
					document.formAddNode.action.value="Insert";
					document.formAddNode.submit();
			}
			else if(element.value=="Report")
			{
				//alert("rep"+element.value);
				document.formAddNode.action.value="Report";
				//alert("action"+document.getElementById("action").value);
				document.formAddNode.submit();

			}
			else if(element.value=="cancel")
			{
				//alert("can"+element.value);
				document.formAddNode.action.value="cancel";
				//alert("action"+document.getElementById("action").value);
				document.formAddNode.submit();

			}
		}
</script>
<script>
$(document).ready(function(){
	$("#nod_nam").hover(function(){
		$("#spnPatt").hide();
	});
	
	$("#nod_nam").focus(function(){
		$("#errorMsg").text("");
	});
});
</script>
<body>
<%-- <%
		HttpSession httpSession = request.getSession();
		UserBean users = (UserBean) httpSession.getAttribute("Users");	

%> --%>
<jsp:include page="/CCSS/CCSS_Header.jsp"/>


<div>
<form action="CCSS_AddGaugesServlet" method="get" name="formAddNode" id="formAddNode">		
		
	<div class="container mt-3">
		<div class="row">
			<div class="col-xs-12 text-center pt-1" style="border-radius:20px 20px 0 0; font-weight :bold; font-size:16pt; letter-spacing: 1px;  width: 100%; height:40px; background-color: #a78cc2;">
				Register Gauges
			</div>
			
		</div>
		<div class="row py-3" style="border: 2px solid #a78cc2;">
		<div class="col-lg-3 col-md-4 col-sm-6 col-xs-5 my-1 align-bottom">
				<label for="nod_nam" class="inp">
				<span class="label">Enter Tyre Size &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<script>
					$(document).ready(function() {
					$("#size").autocomplete({
					width : 250,
					max : 10,
					delay : 100,
					minLength : 1,
					autoFocus : true,
					cacheLength : 1,
					scroll : true,
					highlight : false,
					source : function(request, response) {
						$.ajax({
							url : "CCSS_HelpServlet?field=searchSize",
							data : request,
							dataType : "json",
							success : function(data, textStatus, jqXHR) {
								console.log(data);
								response(data);
							},
							error : function(jqXHR, textStatus, errorThrown) {
								console.log(textStatus);
							}
						});
					}
				});
			});
</script>
					<input type="text" id="size" name="size" placeholder="&nbsp;" onblur="getEmpDetail()">
					<span class="border"></span>
				</label>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6 col-xs-5 my-1 align-bottom">
				<label for="section" class="inp">
					<span class="label">Select Gauges </span>
					<select class="form-control form-control-sm col-md-12"  style="width: 100%;" id="gauges" name="gauges" onchange="disForm(this)">	    	    	
			      		<option>--Select--</option>
			      		<option>CENTRAL LINE</option>
			      		<option>SHOULDER</option>			      					      
			    	</select>
				</label>
			</div>

			<div class="col-lg-3 col-md-4 col-sm-6 col-xs-5 my-1 align-bottom">
				<label for="nod_nam" class="inp">
				<span class="label">Enter Thread &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<input type="text" id="thread" name="thread" placeholder="&nbsp;" onblur="getEmpDetail()">
					<span class="border"></span>
				</label>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6 col-xs-5 my-1 align-bottom">
				<label for="nod_nam" class="inp">
				<span class="label">Enter Total &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<input type="text" id="total" name="total" placeholder="&nbsp;" onblur="getEmpDetail()">
					<span class="border"></span>
				</label>
			</div>
	</div>
	<div class="row">
			<div class="col-md-12 text-center">
				<input type="hidden" value="" name="action" id="action" />
				<input class="my-3 py-2" type="button" value="Insert" id="insert" onclick="submitValues(this)" style=" border:2px solid black; letter-spacing: 2px; font-weight:300; border-radius:20px 0  0 20px; background-color: #e94e0f; color:white; font-size: 14pt; " />
				<input class="my-3 py-2" type="button" value="Report" id="report" onclick="submitValues(this)" style="  border:2px solid black; letter-spacing: 2px; font-weight:300; border-radius: 0 0 0 0; background-color: #e94e0f; color:white; font-size: 14pt; " />
				<input class="my-3 py-2" type="button" value="cancel" id="cancel" onclick="submitValues(this)" style="  border:2px solid black; letter-spacing: 2px; font-weight:300; border-radius: 0 20px 20px 0; background-color: #e94e0f; color:white; font-size: 14pt; " />
			</div>		  
		</div>
		<%-- <span id="errorMsg" style="color: red; font-size: 30px; font-weight: bold; padding-top: 20px;"></span>
				
				<%
				if (request.getAttribute("msg").equals("") || request.getAttribute("msg").equals(null))
				{
					out.println(request.getAttribute("msg").toString());
				}
				else
				{
					String m = request.getAttribute("msg").toString();
					out.println("<br /><span id='spnPatt'>");
					out.println("<font color='green' style='font-size: 18pt;'><b>" + m + "</b></font>");
					out.println("</span>");
				}
			%> --%>
			</div>
			</form>
			</div>
	
<jsp:include page="/CCSS/CCSS_Footer.jsp"/>
</body>

</html>