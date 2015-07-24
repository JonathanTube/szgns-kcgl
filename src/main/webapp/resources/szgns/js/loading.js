/**
 *  页面加载等待页面
 *
 * @author kongxm
 * @date 2014/5/20
 *
 */

 var height = window.screen.height-250;
 var width = window.screen.width;
 var leftW = 300;
 if(width>1200){
 	leftW = 400;
 }else if(width>1000){
 	leftW = 350;
 }else {
 	leftW = 100;
 }
 
 var _html = "<div id='loading' style='position:absolute;left:0;width:100%;height:100%;top:0;background:#E0ECFF;opacity:0.8;filter:alpha(opacity=80);z-index:99999999'>\
 <div style='position:absolute;	cursor:wait;left:"+leftW+"px;top:200px;width:auto;height:20px;padding:12px 5px 10px 30px;\
 background:#fff url(/resources/hyjd/images/loading.gif) no-repeat scroll 5px 10px;border:2px solid #ccc;color:#000;'>\
 <span style='margin-left:20px;font-size:14px'>正在加载，请等待...</span>\
 </div></div>";
 
document.write(_html);
 
window.onload = function(){
 	var _mask = document.getElementById('loading');
 	_mask.parentNode.removeChild(_mask);
 };
 