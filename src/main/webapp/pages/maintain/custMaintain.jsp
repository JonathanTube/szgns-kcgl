<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		initTypes($('#current_cust'), cust_json);
		
		//保存客户
		$('#cust_submit_btn').click(function() {
					$.post('/addNewCust', {
						name : $('#new_cust').val()
					}, function(data, textStatus) {
						initTypes($('#current_cust'), getJsonData("/queryAllCust"));
						$('#new_cust').val('');
					});
				});
		
		$(document).on('click','#current_cust li input',function(){
			var id = $(this).attr('lang');
			var li_flag = $(this).closest('li');
			$.ajax({
				type : "POST",
				url : "/deleteCust",
				async : false,
				data : {'id': id},
				success : function(data, textStatus) {
					li_flag.remove();
				}
			});
		});
	});
</script>
<div data-role="header">
	<h1>客户名称维护</h1>
	<a href="#" onclick="window.location.href='../collect/outcomeInfoCollect.jsp'" class="ui-icon-back">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	<input type="text" id="new_cust" placeholder="填写新客户名称" />

	<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
		<button id="cust_submit_btn" type="button">提交</button>
		<button type="reset">取消</button>
	</fieldset>
	
	<h3>已有客户名称：</h3>
	
	<ul class="simple_list" id="current_cust">
	</ul>
</div>
<!-- /content -->
