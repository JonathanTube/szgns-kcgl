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
<script type="text/javascript" src="../../js/index.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		//初始化录入页面的下拉框
		insertRows(1);
		
		$('#add_button').click(function(){
			var size = $('#outcome_table tbody tr').length;
			if(size < 10){
				insertRows(1);
			}
		});
		
		$('#del_button').click(function(){
			var size = $('#outcome_table tbody tr').length;
			if(size > 1){
				$('#outcome_table tbody tr:last').remove();
			}
		});
		
		
		
		//提交表单
	$('#outcome_submit_btn').click(function() {
				var json = "[";
				var size = $('#outcome_table tbody tr').length;
				var isOk = true;
				$('#outcome_table tbody tr').each(
						function(index) {
							json += "{";
								var brandId = $(this).children().eq(1).find('select').val();
								var productId = $(this).children().eq(2).find('select').val();
								var techId = $(this).children().eq(3).find('select').val();
								var thicknessId = $(this).children().eq(4).find('select').val();
								var custId = $(this).children().eq(5).find('select').val();
								var amount = $(this).children().eq(6).find('input').val();
								var unitPrice = $(this).children().eq(7).find('input').val();
								var totalPrice = $(this).children().eq(8).find('input').val();
								if(brandId == ''){
									alert('品牌不能为空！');
									isOk = false;
									return false;
								}
								if(productId == ''){
									alert('产品名称不能为空！');
									isOk = false;
									return false;
								}
								if(techId == ''){
									alert('工艺不能为空！');
									isOk = false;
									return false;
								}
								if(thicknessId == ''){
									alert('厚度不能为空！');
									isOk = false;
									return false;
								}
								if(custId == ''){
									alert('客户名称不能为空！');
									isOk = false;
									return false;
								}
								if(amount == ''){
									alert('数量不能为空，或非数字！');
									isOk = false;
									return false;
								}
								if(unitPrice == ''){
									alert('单价不能为空，或非数字！');
									isOk = false;
									return false;
								}
								if(parseInt(amount) <= 0){
									alert('数量必须大于0！');
									isOk = false;
									return false;
								}
								if(parseInt(unitPrice) <= 0){
									alert('单价必须大于0！');
									isOk = false;
									return false;
								}
								json += "'id':" + $(this).children().eq(0).find('label').html() + ",";
								json += "'brandId':" + brandId + ",";
								json += "'productId':" + productId + ",";
								json += "'techId':" + techId + ",";
								json += "'thicknessId':" + thicknessId + ",";
								json += "'custId':" + custId + ",";
								json += "'amount':" + amount + ",";
								json += "'unitPrice':" + unitPrice + ",";
								json += "'totalPrice':" + totalPrice;
							json += "}";
							if(index < size - 1){
								json += ",";
							}
						});
				json += "]"; 
				if(isOk){
					$.post('/addOutcomeInfos', {'json': json,'userName' : <%="'" + userName + "'"%>},function(result){
						    alert(result);
					});
				}
			});
		
		$('#outcome_table tbody tr td input').bind("propertychange input",function(){
			var inputObj = $(this).closest('tr').find('input');
			var _amount = inputObj.eq(0).val();
			var _unitPrice = inputObj.eq(1).val();
			var totalPrice = inputObj.eq(2);
			var result = _amount * _unitPrice;
			totalPrice.val(result);
			
			var total_price = 0;
			$('.tt').each(function(){
				total_price += parseInt($(this).val());
			});
			$('#label_total_price').html(total_price);
		});

	});

	//填充主form中的内容
	function insertRows(size) {
		var temp = "";
		temp_brand = initSelectMenu(brand_json);
		temp_product = initSelectMenu(product_json);
		temp_tech = initSelectMenu(tech_json);
		temp_thickness = initSelectMenu(thickness_json);
		temp_cust = initSelectMenu(cust_json);
		for (var i = 1; i <= size; i++) {
			var index = $('#outcome_table tbody tr').length + i;
			temp += "<tr>";
			temp += "<th><label>" + index+ "</label></th>";
			temp += "<td>" + temp_brand + "</td>";
			temp += "<td>" + temp_product + "</td>";
			temp += "<td>" + temp_tech + "</td>";
			temp += "<td>" + temp_thickness + "</td>";
			temp += "<td>" + temp_cust + "</td>";
			temp += "<td><input type='number' pattern='[0-9]*' value='' data-clear-btn='true'></td>";
			temp += "<td><input type='number' pattern='[0-9]*' value='' data-clear-btn='true'></td>";
			temp += "<td><input type='number' pattern='[0-9]*' value='0' data-clear-btn='true' disabled='disabled' class='tt'></td>";
			temp += "</tr>";
		}
		$('#outcome_table tbody').append(temp).trigger('create');
	}
</script>
</head>

<body>
	<div data-role="page" id="outcomeInfoCollect_page">
		<div data-role="header">
			<h1>产品出库信息采集</h1>
			<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a>
			<a href="/login?logout=true" data-icon="power" data-iconpos="notext">注销</a>
		</div>
		<!-- /header -->
		
		<div role="main" class="ui-content jqm-content">
			<fieldset data-role="controlgroup" data-type="horizontal"> 
					<button id="add_button">增加行</button>
					<button id="del_button">减少行</button>
			</fieldset>
			<table id="outcome_table" data-role="table" class="ui-responsive table-stroke">
				<thead>
					<tr>
						<th data-priority="1" width="40px;">序号</th>
						<th data-priority="2">品牌</th>
						<th data-priority="3">产品名称</th>
						<th data-priority="4">工艺</th>
						<th data-priority="5">厚度</th>
						<th><a href="#cust_maintain">客户名称</a></th>
						<th>数量</th>
						<th>单价</th>
						<th>合计</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th colspan="8"><label>以上产品出货总价为：<font id="label_total_price">0</font></label></th>
					</tr>
				</tfoot>
				<tbody>
				</tbody>
			</table>
		
			 
			<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
				<button id="outcome_submit_btn">保存</button>
				<button onclick="window.location.href='billOfSales.jsp'">打印预览</button>
				<button>清空</button>
			</fieldset>
		</div>
	<%@include file="../menu.jsp" %>
	</div>
	
	<div data-role="page" id="cust_maintain">
		<%@include file="../maintain/custMaintain.jsp"%>
	</div>
</body>
</html>