<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {
		//初始化录入页面的下拉框
		initOutcomeCollectForm();

		//提交表单
		$('#outcome_submit_btn').click(function() {
			$('#income_form').submit({
				url : 'addIncomeInfo',
				type : 'post',
				data : $('#income_form').serialize(),
				success : function(data) {
					if (data.statusCode == "OK") {
						alert('success');
					} else {
						alert('failed');
					}
				}
			});
		});
	});

	//填充主form中的内容
	function initOutcomeCollectForm() {
		var temp = "";
		temp_brand = initSelectMenu(brand_json);
		temp_product = initSelectMenu(product_json);
		temp_tech = initSelectMenu(tech_json);
		temp_thickness = initSelectMenu(thickness_json);
		for (var i = 1; i <= 10; i++) {
			temp += "<tr>";
			temp += "<th>" + i + "</th>";
			temp += "<td>" + temp_brand + "</td>";
			temp += "<td>" + temp_product + "</td>";
			temp += "<td>" + temp_tech + "</td>";
			temp += "<td>" + temp_thickness + "</td>";
			temp += "<td><input type='number' pattern=''[0-9]*' value='' data-clear-btn='true'></td>";
			temp += "<td><input type='number' pattern=''[0-9]*' value='' data-clear-btn='true'></td>";
			temp += "<td><input type='number' pattern=''[0-9]*' value='' data-clear-btn='true'></td>";
			temp += "</tr>";
		}
		$('#outcome_table tbody').append(temp);
	}
</script>
<div data-role="header">
	<h1>产品出库信息采集</h1>
	<a href="#panel-responsive-page1"
		class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-mini ui-icon-back ui-btn-icon-left">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	<table id="outcome_table" data-role="table" data-mode="columntoggle"
		class="ui-responsive table-stroke">
		<thead>
			<tr>
				<th data-priority="1">序号</th>
				<th data-priority="2">品牌</th>
				<th data-priority="3">产品名称</th>
				<th data-priority="4">工艺</th>
				<th data-priority="5">厚度</th>
				<th>数量</th>
				<th>单价</th>
				<th>合计</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th colspan="8"><label>以上产品出货总价为：</label></th>
			</tr>
		</tfoot>
		<tbody>
		</tbody>
	</table>

	 
	<fieldset data-role="controlgroup" data-type="horizontal"
		style="text-align: center;">
		<button>预览</button>
		<button>打印</button>
		<button>清空</button>
	</fieldset>
</div>
<!-- /content -->
