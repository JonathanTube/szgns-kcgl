<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("userName");
	String userName = null;
	if (obj != null) {
		userName = (String) obj;
		if (!"admin".equals(userName) && !"vip".equals(userName) && !"user".equals(userName) && !"szgns".equals(userName) && !"dgsy".equals(userName)) {
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

<script type="text/javascript">
	function showLoader() {  
	    //显示加载器.for jQuery Mobile 1.2.0  
	    $.mobile.loading('show', {  
	        text: '加载中...', //加载器中显示的文字  
	        textVisible: true, //是否显示文字  
	        theme: 'a',        //加载器主题样式a-e  
	        textonly: false,   //是否只显示文字  
	        html: ""           //要显示的html内容，如图片等  
	    });  
	}
	showLoader();
	  
	//隐藏加载器.for jQuery Mobile 1.2.0  
	function hideLoader()  
	{  
	    //隐藏加载器  
	    $.mobile.loading('hide');  
	}  

	$(document).ready(function() {
		initData();
		hideLoader();
		setInterval(initData,5000);
	});
	
	function initData(){
		var temp = "";
		$.getJSON('/queryStock',function(data){
			$(data).each(function(index) {
				var obj = data[index];
				temp +="<tr>";
				temp +="<th>" + ++index + "</th>";
				temp +="<td>" + obj.brandName + "</td>";
				temp +="<td>" + obj.productName + "</td>";
				temp +="<td>" + obj.techName+ "</td>";
				temp +="<td>" + obj.thicknessName + "</td>";
				temp +="<td>" + obj.amount + "</td>";
				temp += "</tr>";
			});
			$('#table_stock tbody').empty();
			$('#table_stock tbody').append(temp);
		});
	}
</script>
</head>
<body>
<div data-role="header">
	<h1>库存数据实时动态报表</h1>
	<%@include file="../header.jsp" %>
</div>
<!-- /header -->
<div role="main" class="ui-content jqm-content jqm-fullwidth">
	<label style="float: right;">当前时间：<%=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())%></label>
	<table id="table_stock" data-role="table" id="table-column-toggle" class="ui-responsive table-stroke">
		<thead>
			<tr>
				<th data-priority="1">序号</th>
				<th data-priority="2">品牌</th>
				<th data-priority="3">产品名称</th>
				<th data-priority="4">工艺</th>
				<th data-priority="5">厚度</th>
				<th data-priority="6">库存数</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</div>
<!-- /content -->
<%@include file="../menu.jsp" %>
</body>
</html>