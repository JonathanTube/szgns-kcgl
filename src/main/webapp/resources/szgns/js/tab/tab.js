/*
 * Tab
 */
var tabs;
var tmpCount = 0;

$(function() {

	tabs = $('#tabs').cleverTabs({

		// 是否安装右键菜单（默认为：true）
		setupContextMenu : true

	});

	$(window).bind('resize', function() {
		tabs.resizePanelContainer();
	});

	tabs.add({
		url : 'welcome.html',
		label : '欢迎使用等保系统'
	});

});

var addTab = function(tab) {
	if(tab == null){
		return;
	}
	var url = tab.url;
	var label = tab.funcName;
	if (url != null) {
		tabs.add({
			url : url,
			label : label
		});
	} /*else {
		alert("链接地址不存在！");
	}*/
};
