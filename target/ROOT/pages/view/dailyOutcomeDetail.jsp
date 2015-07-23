<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("userName");
	String userName = null;
	if (obj != null) {
		userName = (String) obj;
		if (!"admin".equals(userName) && !"vip".equals(userName)) {
			response.sendRedirect("/");
		}
	} else {
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
<script src="../../js/index.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var day = getUrlParam('day');
		getDataInfo(day,null,null);

		$("#query_btn").click(function() {
			var dateTime = $('#dateTime').val();
			if(dateTime){
				dateTime = dateTime.replace(/-/gm,'');
			}
			var custId = $('#cust select').val();
			getDataInfo(null,dateTime,custId);
		});
		temp_cust = initSelectMenu(cust_json);
		$('#cust').append(temp_cust).trigger('create');
	});

	function getDataInfo(day,dateTime,custId) {
		$('#table_dailyOutcomeDetail tbody').empty();
		$.ajax({
			type : "POST",
			url : "/queryOutcomeDailyDetail",
			async : false,
			data : {'day': day,'dateTime':dateTime,'custId':custId},
			success : function(data, textStatus) {
				var temp = "";
				$(data).each(function(index) {
					var obj = data[index];
					temp += "<tr>";
					temp += "<th>" + ++index + "</th>";
					temp += "<td>" + obj.createTime + "</td>";
					temp += "<td>" + obj.brandName + "</td>";
					temp += "<td>" + obj.productName + "</td>";
					temp += "<td>" + obj.techName + "</td>";
					temp += "<td>" + obj.thicknessName + "</td>";
					temp += "<td>" + obj.custName + "</td>";
					temp += "<td>" + obj.amount + "</td>";
					temp += "<td>" + obj.unitPrice + "</td>";
					temp += "<td>" + obj.totalPrice + "</td>";
					temp += "</tr>";
				});
				
				$('#table_dailyOutcomeDetail tbody').append(temp);
			}
		});
	}
	
	function getUrlParam(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r!=null){
			return unescape(r[2]);
		}
		return null;
	} 
</script>
</head>
<body>
	<div data-role="header">
		<h1>每日出货明细表</h1>
		<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a> <a
			href="/login?logout=true" data-icon="power" data-iconpos="notext">注销</a>
	</div>
	<!-- /header -->

	<div role="main" class="ui-content jqm-content">
		<table style="width: 100%">
			<tr>
				<td><input id="dateTime" type="date" data-clear-btn="true" name="date-2" id="date-2" value=""></td>
				<td id="cust"></td>
				<td><input id="query_btn" type="button" value="查询" /></td>
				<td style="text-align: right;">当前时间：<label
					style="float: right;"><%=new SimpleDateFormat("yyyy-MM-dd HH:mm")
					.format(new Date())%></label></td>
			</tr>
		</table>
		<table id="table_dailyOutcomeDetail" data-role="table"
			class="ui-responsive table-stroke">
			<thead>
				<tr>
					<th data-priority="1">序号</th>
					<th data-priority="2">日期</th>
					<th data-priority="3">品牌</th>
					<th data-priority="4">产品名称</th>
					<th data-priority="5">工艺</th>
					<th data-priority="6">厚度</th>
					<th>客户名称</th>
					<th>出货数</th>
					<th>单价</th>
					<th>合计</th>
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