<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div data-role="header">
	<h1>工艺维护</h1>
	<a href="#panel-responsive-page5" class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-mini ui-icon-back ui-btn-icon-left">返回</a>
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
