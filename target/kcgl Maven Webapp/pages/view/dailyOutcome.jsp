<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("userName");
	String userName = null;
	if (obj != null) {
		userName = (String) obj;
		if (!"admin".equals(userName) && !"vip".equals(userName)) {
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
<link rel="stylesheet"
	href="../../css/themes/default/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="../../css/jquery.mobile.datepicker.css">
<link rel="stylesheet" href="../../css/index.css">

<script src="../../js/jquery.js"></script>
<script src="../../js/jquery.mobile-1.4.5.min.js"></script>
<script id="mobile-datepicker" src="../../js/jquery.mobile.datepicker.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$.getJSON('/queryOutcomeDaily', function(data) {
			var temp = "";
			var size = data.size;
			for (var i = 0; i < size; i++) {
				temp += "<th><a href=\"#\" onclick=\"window.location.href='dailyOutcomeDetail.jsp?day="+ (i + 1) +"'\">" + (i + 1) + "</a></th>";
			}
			$('#table_dailyOutcome thead tr th:last').before(temp);
			var content = data.content;
			temp = "";
			$(content).each(function(index) {
				var obj = content[index];
				temp += "<tr>";
				temp += "<th>" + ++index + "</th>";
				temp += "<td>" + obj.brandName + "</td>";
				temp += "<td>" + obj.productName + "</td>";
				temp += "<td>" + obj.techName + "</td>";
				temp += "<td>" + obj.thicknessName + "</td>";
				for (var i = 0; i < size; i++) {
					temp += "<td>" + obj.data[i] + "</td>";
				}
				temp += "<td>" + obj.amount + "</td>";
				temp += "</tr>";
			});
			$('#table_dailyOutcome tbody').append(temp);
		});
	});
</script>
</head>
<body>
	<div data-role="header">
		<h1>出货数据日报表</h1>
		<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a> <a
			href="/login?logout=true" data-icon="power" data-iconpos="notext">注销</a>
	</div>
	<!-- /header -->

	<div role="main" class="ui-content jqm-content">
		<label style="float: right;">当前时间：<%=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())%></label>
		<table id="table_dailyOutcome" data-role="table" class="ui-responsive table-stroke">
			<thead>
				<tr>
					<th data-priority="1">序号</th>
					<th data-priority="2">品牌</th>
					<th data-priority="3">产品名称</th>
					<th data-priority="4">工艺</th>
					<th data-priority="5">厚度</th>
					<th data-priority="6">本月总数</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<!-- /content -->
	<%@include file="../menu.jsp"%>
</body>
</html>