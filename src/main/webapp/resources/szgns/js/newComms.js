var comm,floorId,parentName,newId;
$(document).on("pageinit",function(){
	$(".commsTitle a").attr("style","font-size:1em");

	$("h1[name='oneFloor']").click(function(){
		//切换对话人物
		$(this).parent().find("textarea").attr("placeholder","回复楼主:");
		$(this).parent().find("textarea").attr("parentName","");
		//如果没有楼层是显示第二层的，则展示回复新闻的对话框
		var flag = false;
		$("h1[name='oneFloor']").each(function(i,e){
			if($(".commsTitle :eq("+i+")").attr("class").indexOf("ui-collapsible-collapsed") == -1){
				flag = true;
				return;
			}
		});
		if(flag){
			$("textarea[name='commForNew']").hide();
		}else{
			$("textarea[name='commForNew']").show();
		}
	});

	$("#commsMore").click(function(){
		$(".commsTitle").show(200);
	});
	
	//搜集评论信息
	$("textarea").blur(function(){
		comm = $(this).val();
		floorId = $(this).attr("floorId");
		parentName = $(this).attr("parentName");
		newId = $("#newid").val();
	});
	
	//提交评论
	$("#submitComms").click(function(){
		submitComm(comm,floorId,parentName,newId);
	});
	
	//是否展示更多按钮
	dispalySeeMore();

});

function reComm(name,id){
	$("textarea[name='text"+ id +"']").attr("placeholder","回复"+name+":");
	$("textarea[name='text"+ id +"']").attr("parentName",name);
}

function dispalySeeMore(){
	if($(".commsTitle").length < 6){
		$("#commsMore").hide();
	}
}

function submitComm(comm,floorId,parentName,newId){
	if(!isNull(comm)){
		var param = "comm="+encodeURIComponent(encodeURIComponent(comm));
		if(isNull(floorId)){
			floorId = "";
		}
		param = param + "&floorId="+floorId;
		if(isNull(parentName)){
			parentName = "";
		}
		param = param + "&parentName="+parentName;
		param = param + "&newId="+newId;
		$.ajax({
			type:'get',
			url:getBasePath()+'/savecomm',
			data:param,
			dataType:'json',
			success:function(msg){
				window.location.reload();
			}
		});
	}else{
		$("#submitComms").removeClass("ui-btn-active");
	}
}