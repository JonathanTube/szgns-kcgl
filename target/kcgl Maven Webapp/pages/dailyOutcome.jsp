<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {
		$.getJSON('/queryOutcomeDaily', function(data) {
			var temp = "";
			var size = data.size;
			for (var i = 0; i < size; i++) {
				temp += "<th data-priority='6'>" + (i + 1) + "</th>";
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

<div data-role="header">
	<h1>出货数据日报表</h1>
	<a href="#panel-responsive-page1"
		class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-mini ui-icon-back ui-btn-icon-left">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	当前时间：2015-03-04 10:45
	<table id="table_dailyOutcome" data-role="table" data-mode="columntoggle"
		class="ui-responsive table-stroke">
		<thead>
			<tr>
				<th data-priority="2">序号</th>
				<th>品牌</th>
				<th data-priority="3">产品名称</th>
				<th data-priority="1">工艺</th>
				<th data-priority="5">厚度</th>
				<th data-priority="6">本月总数</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<!-- /content -->