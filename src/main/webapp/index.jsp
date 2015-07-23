<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("userName");
	if (obj != null) {
		response.sendRedirect("/pages/view/stock.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>库存管理</title>
<link rel="stylesheet"
	href="../css/themes/default/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="../css/jquery.mobile.datepicker.css">
<link rel="stylesheet" href="../css/index.css">

<script src="../js/jquery.js"></script>
<script src="../js/jquery.mobile-1.4.5.min.js"></script>
<script id="mobile-datepicker" src="../js/jquery.mobile.datepicker.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#login_submit').click(function() {
			$.ajax({
				type : "POST",
				url : "/login",
				async : false,
				data : {
					userName : $('#name').val(),
					password : $('#password').val()
				},
				success : function(data, textStatus) {
					if (data == 'ok') {
						window.location.href = "/pages/view/stock.jsp";
					}else{
						alert('用户名或密码不正确!');
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<div data-role="header">
		<h1>登陆</h1>
	</div>

	<div role="main" class="ui-content jqm-content jqm-fullwidth">
		<table style="width: 80%; text-align: center;">
			<tbody>
				<tr>
					<td><label for="name">用户名:</label></td>
					<td><input type="text" name="userName" id="name" value=""
						data-clear-btn="true" data-mini="true" /></td>
				</tr>
				<tr>
					<td><label for="password">密码:</label></td>
					<td><input type="password" name="password" id="password"
						value="" data-clear-btn="true" autocomplete="off" data-mini="true" /></td>
				</tr>
			</tbody>
		</table>
		<fieldset data-role="controlgroup" data-type="horizontal"
			style="text-align: center;">
			<button id="login_submit" type="button">确定</button>
			<button type="reset">取消</button>
		</fieldset>
	</div>
</body>
</html>
