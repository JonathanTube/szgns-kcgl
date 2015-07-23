<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(
			function() {
				//初始化录入页面的下拉框
				initIncomeCollectForm();
				//初始化所有品牌
				initTypes($('#current_brand'), temp_brand);
				//初始化所有产品
				initTypes($('#current_product'), temp_product);
				//初始化所有工艺
				initTypes($('#current_tech'), temp_tech);
				//初始化所有厚度
				initTypes($('#current_thickness'), temp_thickness);

				//保存品牌
				$('#brand_submit_btn').click(
						function() {
							$.post('/addNewBrand', {
								name : $('#new_brand').val()
							}, function(data, textStatus) {
								initTypes($('#current_brand'),
										getJsonData("/queryAllBrand"));
							});
						});

				//保存产品
				$('#product_submit_btn').click(
						function() {
							$.post('/addNewProduct', {
								name : $('#new_product').val()
							}, function(data, textStatus) {
								initTypes($('#current_product'),
										getJsonData("/queryAllProduct"));
							});
						});

				//保存工艺
				$('#tech_submit_btn').click(
						function() {
							$.post('/addNewTech', {
								name : $('#new_tech').val()
							}, function(data, textStatus) {
								initTypes($('#current_tech'),
										getJsonData("/queryAllTech"));
							});
						});

				//保存厚度
				$('#thickness_submit_btn').click(
						function() {
							$.post('/addNewThickness', {
								name : $('#new_thickness').val()
							}, function(data, textStatus) {
								initTypes($('#current_thickness'),
										getJsonData("/queryAllThickness"));
							});
						});

				//提交表单
				$('#income_submit_btn').click(
						function() {
							var json = "[";
							var size = $('#income_table tbody tr').length;
							$('#income_table tbody tr').each(
									function(index) {
										json += "{";
											json += "'id':" + $(this).children().eq(0).find('label').html() + ",";
											json += "'brandId':" + $(this).children().eq(1).find('select').val() + ",";
											json += "'productId':" + $(this).children().eq(2).find('select').val() + ",";
											json += "'techId':" + $(this).children().eq(3).find('select').val() + ",";
											json += "'thicknessId':" + $(this).children().eq(4).find('select').val() + ",";
											json += "'amount':" + $(this).children().eq(5).find('input').val();
										json += "}";
										if(index < size - 1){
											json += ",";
										}
									});
							json += "]";
							
							$.post('/addIncomeInfos', {'json': json},function(result){
								    //	$("span").html(result);
							});
						});
			});

	//function start
	//加载各种类型
	function initTypes(target, json_data) {
		target.empty();
		var temp = "";
		$(json_data).each(function(index) {
			var val = json_data[index];
			temp += "<li><font>" + val.name + "</font></li>";
		});
		target.append(temp);
	}

	//填充主form中的内容
	function initIncomeCollectForm() {
		var temp = "";
		temp_brand = initSelectMenu(brand_json);
		temp_product = initSelectMenu(product_json);
		temp_tech = initSelectMenu(tech_json);
		temp_thickness = initSelectMenu(thickness_json);
		for (var i = 1; i <= 1; i++) {
			temp += "<tr>";
			temp += "<th><label>" + i + "</label></th>";
			temp += "<td>" + temp_brand + "</td>";
			temp += "<td>" + temp_product + "</td>";
			temp += "<td>" + temp_tech + "</td>";
			temp += "<td>" + temp_thickness + "</td>";
			temp += "<td><input name='amount_" + i + "' type='number' pattern=''[0-9]*' value='' data-clear-btn='true'></td>";
			temp += "</tr>";
		}
		$('#income_table tbody').append(temp);
	}
</script>

<div data-role="header">
	<h1>产品入库信息采集</h1>
	<a href="#panel-responsive-page1" class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-mini ui-icon-back ui-btn-icon-left">返回</a>
	<a href="#panel-responsive-page1" class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-mini ui-icon-back ui-btn-icon-left">返回</a>
</div>
<!-- /header -->
<div role="main" class="ui-content jqm-content">
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

	<fieldset data-role="controlgroup" data-type="horizontal" tyle="text-align: center;">
		<button id="income_submit_btn">提交</button>
		<button type="reset">清空</button>
	</fieldset>
</div>