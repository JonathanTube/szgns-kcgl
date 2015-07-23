<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 搞定后要删掉哦 -->
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">

<title>库存管理</title>
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" href="../css/themes/default/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="../css/jquery.mobile.datepicker.css">
<link rel="stylesheet" href="../css/index.css">

<script src="../js/jquery.js"></script>
<script src="../js/jquery.mobile-1.4.5.min.js"></script>
<script id="mobile-datepicker" src="../js/jquery.mobile.datepicker.js"></script>
<script type="text/javascript" src="../js/index.js"></script>

</head>
<body>
	<div data-role="page" class="jqm-demos ui-responsive-panel" id="panel-responsive-page1" data-title="库存">
		<%@include file="stock.jsp"%>
	</div>

	<div data-role="page" id="panel-responsive-page2">
		<%@include file="dailyIncome.jsp"%>
	</div>

	<!-- /page -->
	<div data-role="page" id="panel-responsive-page3">
		<%@include file="dailyOutcome.jsp"%>
	</div>
	<!-- /page -->


	<!-- /page -->
	<div data-role="page" id="panel-responsive-page4">
		<%@include file="dailyOutcomeDetail.jsp"%>
	</div>
	<!-- /page -->

	<!-- /page -->
	<div data-role="page" id="panel-responsive-page5">
		<%@include file="incomeInfoCollect.jsp"%>
	</div>
	<!-- /page -->


	<!-- /page -->
	<div data-role="page" id="panel-responsive-page6">
		<%@include file="outcomeInfoCollect.jsp"%>
	</div>
	<!-- /page -->


	<!-- /page -->
	<div data-role="page" id="panel-responsive-page7">
		<%@include file="billOfSales.jsp"%>
	</div>
	<!-- /page -->


	<div data-role="page" id="brand_maintain">
		<%@include file="brandMaintain.jsp"%>
	</div>

	<div data-role="page" id="product_maintain">
		<%@include file="productMaintain.jsp"%>
	</div>
	
	<div data-role="page" id="tech_maintain">
		<%@include file="techMaintain.jsp"%>
	</div>
	
	<div data-role="page" id="thickness_maintain">
		<%@include file="thicknessMaintain.jsp"%>
	</div>
</body>
</html>
