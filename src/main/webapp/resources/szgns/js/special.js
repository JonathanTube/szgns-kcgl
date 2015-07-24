/**
 * create by kongxm@20140827
 * 
 * 修改表格和toolbar的样式
 */

$(document).ready(function() {
	changeStyle();
});

function changeStyle() {
	$('.ui-chkbox-all').prependTo($('.ui-toolbar-group-left'));
	$('.ui-chkbox-all').css('padding-top', '5px');
	$('.ui-chkbox-all').css('padding-left', '8px');
	$('.ui-chkbox-all').css('margin-right', '20px');
	$('.ui-chkbox-all').css('position', 'absolute');
	$('.ui-chkbox-all').css('top', '25px;');
	$(".ui-datatable .ui-widget-header:first").remove();

	// 去除表格左右border
	$('.ui-widget-content').css('border-left', 'none');
	$('.ui-widget-content').css('border-right', 'none');

	addHoverEvent();
}

/*
 * 添加tr 的hover事件监听
 */
function addHoverEvent() {
	$('.ui-datatable-data tr').hover(function() {
		$(this).find('.buttons').css('visibility', 'visible');
	}, function() {
		$(this).find('.buttons').css('visibility', 'hidden');
	});
}