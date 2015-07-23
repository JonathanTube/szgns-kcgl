<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<a href="#nav-panel" data-icon="bars" data-iconpos="notext">菜单</a>
<a href="#" data-icon="power" data-iconpos="notext" id="logout_btn">注销</a>

<script type="text/javascript">
	$('#logout_btn').click(function() {
		$.ajax({
			type : "GET",
			url : "/login?logout=true",
			success : function(data, textStatus) {
				window.location.href = "/";
			}
		});
	});
</script>