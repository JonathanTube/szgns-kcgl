<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function() {
		//初始化所有品牌
		initTypes($('#current_brand'), brand_json);
		
		//保存品牌
		$('#brand_submit_btn').click(
				function() {
					$.post('/addNewBrand', {
						name : $('#new_brand').val()
					}, function(data, textStatus) {
						initTypes($('#current_brand'), getJsonData("/queryAllBrand"));
						$('#new_brand').val(''	);
					});
				});
		
		$(document).on('click','#current_brand li input',function(){
			var id = $(this).attr('lang');
			var li_flag = $(this).closest('li');
			$.ajax({
				type : "POST",
				url : "/deleteBrand",
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
	<h1>品牌维护</h1>
	<a href="#" onclick="window.location.href='../collect/incomeInfoCollect.jsp'" class="ui-icon-back">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	<input type="text" id="new_brand" placeholder="填写新品牌" />

	<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
		<button id="brand_submit_btn" type="button">提交</button>
		<button type="reset">取消</button>
	</fieldset>
	
		<h3>已有品牌：</h3>
		
		<ul class="simple_list" id="current_brand">
		</ul>
</div>
<!-- /content -->
