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
					var size = $('#income_table tbody tr').length;
					if(size < 10){
						insertRows(1);
					}
				});
				
				$('#del_button').click(function(){
					var size = $('#income_table tbody tr').length;
					if(size > 1){
						$('#income_table tbody tr:last').remove();
					}
				});

				//提交表单
				$('#income_submit_btn').click(
						function() {
							var json = "[";
							var size = $('#income_table tbody tr').length;
							var isOk = true;
							$('#income_table tbody tr').each(
									function(index) {
										json += "{";
											var brandId = $(this).children().eq(1).find('select').val();
											var productId = $(this).children().eq(2).find('select').val();
											var techId = $(this).children().eq(3).find('select').val();
											var thicknessId = $(this).children().eq(4).find('select').val();
											var amount = $(this).children().eq(5).find('input').val();
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
											if(amount == ''){
												alert('数量不能为空,或非数字！');
												isOk = false;
												return false;
											}
											if(parseInt(amount) <= 0) {
												alert("入库数量必须大于0");
												isOk = false;
												return false;
											}
											json += "'id':" + $(this).children().eq(0).find('label').html() + ",";
											json += "'brandId':" + brandId + ",";
											json += "'productId':" + productId + ",";
											json += "'techId':" + techId + ",";
											json += "'thicknessId':" + thicknessId + ",";
											json += "'amount':" + amount;
										json += "}";
										if(index < size - 1){
											json += ",";
										}
									});
							json += "]";
							if(isOk){
								$.post('/addIncomeInfos', {'json': json},function(result){
									    alert(result);
								});
							}
						});
			});

	//填充主form中的内容
	function insertRows(size) {
		var temp = "";
		temp_brand = initSelectMenu(brand_json);
		temp_product = initSelectMenu(product_json);
		temp_tech = initSelectMenu(tech_json);
		temp_thickness = initSelectMenu(thickness_json);
		for (var i = 1; i <= size; i++) {
			var index = $('#income_table tbody tr').length + i;
			temp += "<tr>";
			temp += "<th><label>" + index + "</label></th>";
			temp += "<td>" + temp_brand + "</td>";
			temp += "<td>" + temp_product + "</td>";
			temp += "<td>" + temp_tech + "</td>";
			temp += "<td>" + temp_thickness + "</td>";
			temp += "<td><input type='number' pattern=''[0-9]*' value='' data-clear-btn='true' min='1'></td>";
			temp += "</tr>";
		}
		$('#income_table tbody').append(temp).trigger('create');
	}
</script>
</head>
<body>
	<div data-role="page" id="incomeInfoCollect_page">
		<div data-role="header">
			<h1>产品入库信息采集</h1>
			<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a>
			<a href="/login?logout=true" data-icon="power" data-iconpos="notext">注销</a>
		</div>
		<!-- /header -->
		<div role="main" class="ui-content jqm-content">
				<fieldset data-role="controlgroup" data-type="horizontal"> 
					<button id="add_button">增加行</button>
					<button id="del_button">减少行</button>
				</fieldset>
				<table id="income_table" data-role="table" class="ui-responsive table-stroke">
					<thead>
						<tr>
							<th data-priority="1">序号</th>
							<th data-priority="2"><a href="#brand_maintain">品牌</a></th>
							<th data-priority="3"><a href="#product_maintain">产品名称</a></th>
							<th data-priority="4"><a href="#tech_maintain">工艺</a></th>
							<th data-priority="5"><a href="#thickness_maintain">厚度</a></th>
							<th>入库数量</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
		
				<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
					<button id="income_submit_btn">提交</button>
					<button id="income_reset_btn">清空</button>
				</fieldset>
		</div>
		<%@include file="../menu.jsp" %> 
	</div>
	
	<div data-role="page" id="brand_maintain">
		<%@include file="../maintain/brandMaintain.jsp"%>
	</div>

	<div data-role="page" id="product_maintain">
		<%@include file="../maintain/productMaintain.jsp"%>
	</div>
	
	<div data-role="page" id="tech_maintain">
		<%@include file="../maintain/techMaintain.jsp"%>
	</div>
	
	<div data-role="page" id="thickness_maintain">
		<%@include file="../maintain/thicknessMaintain.jsp"%>
	</div>
</body>
</html>