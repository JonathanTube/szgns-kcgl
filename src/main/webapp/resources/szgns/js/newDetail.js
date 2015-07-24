$(function() {
	
	$('.banner').unslider({
		speed: 500,               //  The speed to animate each slide (in milliseconds)
		delay: 3000,              //  The delay between slide animations (in milliseconds), false for no autoplay
		complete: function() {},  //  A function that gets called after every slide animation
		keys: true,               //  Enable keyboard (left, right) arrow shortcuts
		dots: true,               //  Display dot navigation
		fluid: false              //  Support responsive design. May break non-responsive designs
	});
	
	// 左右控制js
	var unslider = $('.banner').unslider();
	$('.unslider-arrow').click(function(){
		var fn = this.className.split(' ')[1];
		unslider.data('unslider')[fn]();
	});
	
	if($(".banner li img").length > 1){
		$(".banner a").show();
	}
	
});

function showIsRecord(state){
	if(state == "0"){
		$("#saveNew img").attr("src",getBasePath()+"/css/mobile/images/star-0.png");
	}else{
		$("#saveNew img").attr("src",getBasePath()+"/css/mobile/images/star-1.png");
	}
}
  
function showCreateDate(time){
	$("#saveNew").before(time.split(" ")[0]);
}

