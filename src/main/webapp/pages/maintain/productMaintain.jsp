<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(document).ready(function(){
		//初始化所有产品
		
		//initTypes($('#current_product'), product_json);
		initProductList();
		
		var brandInfo = initSelectMenu(brand_json);
		$("#brandSelect").append(brandInfo);
		
		//保存产品
		$('#product_submit_btn').click(function() {
			var brandId = $("#brandSelect select").val();
			if(brandId == ''){
				alert('请选择品牌');
				return;
			}
			$.post('/addNewProduct', {
				'name' : $('#new_product').val(),
				'brandId':brandId
			}, function(data, textStatus) {
				initProductList();
				$('#new_product').val('');
			});
		});
		
		$(document).on('click','#current_product li input',function(){
			var id = $(this).attr('lang');
			var li_flag = $(this).closest('li');
			$.ajax({
				type : "POST",
				url : "/deleteProduct",
				async : false,
				data : {'id': id},
				success : function(data, textStatus) {
					li_flag.remove();
				}
			});
		});
	});
	
	function initProductList(){
		$('#current_product').empty();
		var temp = "";
		$(brand_json).each(function(index){
			var d = brand_json[index];
			temp += "<li><div><h2>"+ d.name + "</h2></div>";
			var _product_json = getJsonData("/queryAllProduct",{brandId:d.id});
			temp += "<ul>";
			$(_product_json).each(function(index){
				var val = _product_json[index];
				temp += "<li><input type=\"button\" data-icon=\"delete\" data-iconpos=\"right\" lang=\"" + val.id + "\" value=\""+ val.name +"\"/></li>";
			});
			temp += "</ul></li>";
		});
		$('#current_product').append(temp).trigger('create'); 
	}
</script>

<div data-role="header">
	<h1>产品名称维护</h1>
	<a href="#" onclick="window.location.href='../collect/incomeInfoCollect.jsp'" class="ui-icon-back">返回</a>
</div>
<!-- /header -->

<div role="main" class="ui-content jqm-content">
	<table style="width: 100%;">
		<tr>
			<td style="width: 50px;">品牌：</td>
			<td id="brandSelect"></td>
			<td><input type="text" id="new_product" placeholder="填写新产品名称" /></td>
		</tr>
	</table>

	<fieldset data-role="controlgroup" data-type="horizontal" style="text-align: center;">
		<button id="product_submit_btn" type="button">提交</button>
		<button type="reset">取消</button>
	</fieldset>
	
		<h3>已有产品名称：</h3>
		
		<ul class="simple_list" id="current_product">
		</ul>
</div>
<!-- /content -->
