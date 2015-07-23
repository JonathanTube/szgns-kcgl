<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("userName");
	String userName = null;
	if (obj != null) {
		userName = (String) obj;
		if (!"admin".equals(userName) && !"szgns".equals(userName) && !"dgsy".equals(userName)) {
			response.sendRedirect("/");
		}
	}else{
		response.sendRedirect("/");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 搞定后要删掉哦 -->
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">

<title>库存管理</title>
<link rel="stylesheet" href="../../css/themes/default/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="../../css/jquery.mobile.datepicker.css">
<link rel="stylesheet" href="../../css/index.css">

<script src="../../js/jquery.js"></script>
<script src="../../js/jquery.mobile-1.4.5.min.js"></script>
<script id="mobile-datepicker" src="../../js/jquery.mobile.datepicker.js"></script>
<script id="mobile-datepicker" src="../../js/jquery.jqprint-0.3.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		jQuery.ajax({
			type : "post",
			async : false,
			url : '/queryAllBill',
			dataType : "json",
			cache : false,
			success : function(data) {
				var temp = "";
				$(data).each(function(index){
					var obj = data[index];
					temp += "<tr>";
					temp += "<td>"+ (index + 1) +"</td>";
					temp += "<td>"+ obj.seq +"</td>";
					temp += "<td>"+ obj.createTimeStr +"</td>";
					var _seq = obj.seq.replace(/"/gm,''); 
					temp += "<td><a href=\"#\" onclick=\"window.location.href='billOfSaleDetail.jsp?seq="+_seq+"'\">查看</a></td>";  
					temp += "</tr>"
				});
				$('#table_list').append(temp);
			}
		});
	});
</script>
</head>
<body>
	<div data-role="header">
		<h1>出货清单</h1>
		<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a>
		<a href="/login?logout=true" data-icon="power" data-iconpos="notext">注销</a>
	</div>
	<!-- /header -->
	
	<div role="main" class="ui-content jqm-content">
		<table id="table_list" data-role="table" data-mode="table" class="ui-responsive table-stroke">
			<thead>
				<tr>
					<th>序号</th>
					<th>单号</th>
					<th>录入时间</th>
					<th>查看</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<%@include file="../menu.jsp" %>
</body>
</html>