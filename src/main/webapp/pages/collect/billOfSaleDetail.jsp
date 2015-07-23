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
	String seq = request.getParameter("seq");
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
		$('#print_btn').click(function(){
			$("#table_content").jqprint();
		});
		
		$("#delete_btn").click(function(){
			jQuery.ajax({
				type : "post",
				async : false,
				url : '/deleteBill',
				data :{'seq' : <%= "'" + seq +"'"%>},
				dataType : "json",
				cache : false,
				complete : function(data) {
					alert(data.responseText);
					window.location.href='/pages/collect/billOfSales.jsp';
				}
			});
		});
		
		var price = 0;
		jQuery.ajax({
			type : "post",
			async : false,
			url : '/queryBillBySeq',
			data :{'seq' : <%= "'" + request.getParameter("seq") +"'"%>},
			dataType : "json",
			cache : false,
			success : function(data) {
				var temp = "";
				$(data).each(function(index){
					var obj = data[index];
					temp += "<tr>";
					temp += "<td>"+ (index + 1) +"</td>";
					temp += "<td>"+ obj.brandName +"</td>"; 
					temp += "<td>"+ obj.productName +"</td>";
					temp += "<td>"+ obj.techName +"</td>";
					temp += "<td>"+ obj.thicknessName +"</td>";
					temp += "<td>"+ obj.amount +"</td>";
					temp += "<td>"+ obj.unitPrice +"</td>";
					temp += "<td>"+ obj.totalPrice +"</td>";
					temp += "</tr>"
					price += parseInt(obj.totalPrice);
				});
				$('#table_content').append(temp);
				$('#price').append(price);
			}
		});
	});
</script>
</head>
<body>
	<div data-role="header">
		<h1>出货单</h1>
		<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a>
		<a href="/login?logout=true" data-icon="power" data-iconpos="notext">注销</a>
	</div>
	<!-- /header -->
	
	<div role="main" class="ui-content jqm-content">
		<table id="table_content" data-role="table" data-mode="table" class="ui-responsive table-stroke">
			<thead>
				<tr>
					<th colspan="4"><%=seq.startsWith("S") ? "深圳格纳斯" : "东莞晟煜" %> 发货单</th>
					<th colspan="4" style="text-align: right;">单号：<%=request.getParameter("seq") %></th>
				</tr>
				<tr>
					<th data-priority="2">序号</th>
					<th>品牌</th>
					<th data-priority="3">产品名称</th>
					<th data-priority="1">工艺</th>
					<th data-priority="5">厚度</th>
					<th>数量</th>
					<th>单价</th>
					<th>合计</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th colspan="8"><label id="price">以上产品出货总价为：</label></th>
				</tr>
				<tr>
					<th colspan="4">发货员（签字）：</th>
					<th colspan="4">客户（签字）：</th>
				</tr>
			</tfoot>
			<tbody>
			</tbody>
		</table>
		<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
			<a id="print_btn" href="#" class="ui-btn ui-btn-inline">打印</a>
			<a href="#popupDialog" data-rel="popup" data-position-to="window" data-transition="pop" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-icon-delete ui-btn-icon-left ui-btn-b">删除出货单</a>
		</fieldset>
		
		<div data-role="popup" id="popupDialog" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="max-width:400px;">
		    <div data-role="header" data-theme="a">
		    <h1>删除出货单？</h1>
		    </div>
		    <div role="main" class="ui-content">
		        <h3 class="ui-title">确定要删除该出货单?</h3>
		    <p>该步骤不能回退.</p><a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back" data-transition="flow" id="delete_btn">删除</a><a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back">取消</a>
		    </div>
		</div>
	</div>
	<%@include file="../menu.jsp" %>
</body>
</html>