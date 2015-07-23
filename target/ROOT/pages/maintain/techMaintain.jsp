<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
			//初始化所有工艺
			initTypes($('#current_tech'), tech_json);
			
			//保存工艺
			$('#tech_submit_btn').click(
					function() {
						$.post('/addNewTech', {
							name : $('#new_tech').val()
						}, function(data, textStatus) {
							initTypes($('#current_tech'), getJsonData("/queryAllTech"));
							$('#new_tech').val('');
						});
					});
			
			$(document).on('click','#current_tech li input',function(){
				var id = $(this).attr('lang');
				var li_flag = $(this).closest('li');
				$.ajax({
					type : "POST",
					url : "/deleteTech",
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
	<h1>工艺维护</h1>
	<a href="#" onclick="window.location.href='../collect/incomeInfoCollect.jsp'" class="ui-icon-back">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	<input type="text" id="new_tech" placeholder="填写新工艺" />

	<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
		<button id="tech_submit_btn" type="button">提交</button>
		<button type="reset">取消</button>
	</fieldset>
	
		<h3>已有工艺：</h3>
		
		<ul class="simple_list" id="current_tech">
		</ul>
</div>
<!-- /content -->
