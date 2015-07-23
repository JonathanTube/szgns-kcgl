<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {
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
			$('#table_stock tbody').append(temp);
		});
	});
</script>

<div data-role="header">
	<h1>库存数据实时动态报表</h1>
	<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a> <a href="#login-form" data-icon="gear" data-iconpos="notext">登陆</a>
</div>
<!-- /header -->
<div role="main" class="ui-content jqm-content jqm-fullwidth">
	<label>当前时间：2015-03-04 10:45</label>
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


<div data-role="panel" data-display="push" data-theme="b" id="nav-panel">
	<ul data-role="listview">
		<li data-icon="delete"><a href="#" data-rel="close">关闭菜单</a></li>
		<li><a href="#panel-responsive-page1">库存总报表</a></li>
		<li><a href="#panel-responsive-page2">入库日报表</a></li>
		<li><a href="#panel-responsive-page3">出货日报表</a></li>
		<li><a href="#panel-responsive-page4">每日出货明细表</a></li>
		<li><a href="#panel-responsive-page5">产品入库界面</a></li>
		<li><a href="#panel-responsive-page6">产品出货界面</a></li>
		<li><a href="#panel-responsive-page7">出货单格式</a></li>
	</ul>

</div>
<!-- /panel -->

<div data-role="panel" data-position="right" data-display="reveal" data-theme="a" id="login-form">

	<form class="userform">

		<h2>登陆</h2>

		<label for="name">用户名:</label> <input type="text" name="name" id="name" value="" data-clear-btn="true" data-mini="true"> <label for="password">密码:</label>
		<input type="password" name="password" id="password" value="" data-clear-btn="true" autocomplete="off" data-mini="true">

		<div class="ui-grid-a">
			<div class="ui-block-a">
				<a href="#" data-rel="close" class="ui-btn ui-shadow ui-corner-all ui-btn-b ui-mini">取消</a>
			</div>
			<div class="ui-block-b">
				<a href="#" data-rel="close" class="ui-btn ui-shadow ui-corner-all ui-btn-a ui-mini">确定</a>
			</div>
		</div>
	</form>

</div>
<!-- /panel -->