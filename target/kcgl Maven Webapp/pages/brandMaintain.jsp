<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div data-role="header">
	<h1>品牌维护</h1>
	<a href="#panel-responsive-page5" class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-mini ui-icon-back ui-btn-icon-left">返回</a>
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
