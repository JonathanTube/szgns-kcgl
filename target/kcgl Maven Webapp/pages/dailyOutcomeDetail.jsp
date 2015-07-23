<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript">
	$(document).ready(function() {
		$.getJSON('/queryOutcomeDailyDetail', function(data) {
			temp = "";
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
		});
	});
</script>

<div data-role="header">
	<h1>每日出货明细表</h1>
	<a href="#panel-responsive-page1"
		class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-mini ui-icon-back ui-btn-icon-left">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	<input type="text" name="textinput-1" id="textinput-1" placeholder="客户名称" value="" />
	<input type="button" value="查询" />
	<label style="float:right;">当前时间：2015-03-04 10:45</label>

	<table id="table_dailyOutcomeDetail" data-role="table" class="ui-responsive table-stroke">
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
