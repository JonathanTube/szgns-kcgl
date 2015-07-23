<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Object object = session.getAttribute("userName");
	String name = null;
	if (object != null) {
		name = (String) object;
	}
%>
<div data-role="panel" data-display="push" data-theme="b" id="nav-panel">
	<ul data-role="listview">
		<%
			if (object != null) {
				if ("admin".equals(name) || "vip".equals(name) || "user".equals(name) || "szgns".equals(name) || "dgsy".equals(name)) {
		%>
		<li><a href="/pages/view/stock.jsp" target="_self">库存总报表</a></li>
		<%
			}
				if ("admin".equals(name) || "vip".equals(name)) {
		%>
		<li><a href="/pages/view/dailyIncome.jsp" target="_self">入库日报表</a></li>
		<li><a href="/pages/view/dailyOutcome.jsp" target="_self">出货日报表</a></li>
		<li><a href="/pages/view/dailyOutcomeDetail.jsp" target="_self">每日出货明细表</a></li>
		<%
			}
				if ("admin".equals(name) || "szgns".equals(name) || "dgsy".equals(name)) {
		%>
		<li><a href="/pages/collect/incomeInfoCollect.jsp" target="_self">产品入库界面</a></li>
		<li><a href="/pages/collect/outcomeInfoCollect.jsp" target="_self">产品出货界面</a></li>
 		<li><a href="/pages/collect/billOfSales.jsp" target="_self">发货单</a></li>
		<%
			}
		%>
	</ul>
	<%
		}
	%>
</div>
