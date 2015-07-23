<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		//初始化所有厚度
		initTypes($('#current_thickness'), thickness_json);

		//保存厚度
		$('#thickness_submit_btn').click(
				function() {
					$.post('/addNewThickness', {
						name : $('#new_thickness').val()
					}, function(data, textStatus) {
						initTypes($('#current_thickness'), getJsonData("/queryAllThickness"));
						$('#new_thickness').val('');
					});
				});
		
		$(document).on('click','#current_thickness li input',function(){
			var id = $(this).attr('lang');
			var li_flag = $(this).closest('li');
			$.ajax({
				type : "POST",
				url : "/deleteThickness",
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
	<h1>厚度维护</h1>
	<a href="#" onclick="window.location.href='../collect/incomeInfoCollect.jsp'" class="ui-icon-back">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	<input type="text" id="new_thickness" placeholder="填写新厚度" />

	<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
		<button id="thickness_submit_btn" type="button">提交</button>
		<button type="reset">取消</button>
	</fieldset>
	
		<h3>已有厚度：</h3>
		
		<ul class="simple_list" id="current_thickness">
		</ul>
</div>
<!-- /content -->
