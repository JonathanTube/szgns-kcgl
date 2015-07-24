var index = 1;

$(document).on("pageinit",function(){
	getNews(1,$("#newType").val());
});

function getNewsMore(){
	this.index = this.index + 1;
	getNews(this.index,$("#newType").val());
}

function getNewsByType(index,newType){
	$("#newType").val(newType);
	this.index = 1;
	getNews(this.index,$("#newType").val());
}

function getNews(index,newType){
	var param = "index="+index+"&newType="+newType;
	$.ajax({
		type:'get',
		url:getBasePath()+'/newsdata',
		data:param,
		dataType:'json',
		success:function(msg){
			if(index == 1){
				$("#thelist").empty();
			}
			if(msg != null){
				showList(msg);
			}
		},
		error:function(){
			
		}
	});
}

//循环展示产品
function showList(data){
	var leng = data.length;
	if(leng == 0){
		alert("无更多数据");
	}
	for(var i=0; i<leng; i++){
		var result = createHtml(data[i]);
		$("#thelist").append(result);
	}
}

//创建每个产品的代码
function createHtml(item){
	var copy = $("#dataitem").clone();
	copy.show();
	if(item['pictures'][0] != null){
		copy.find("img[name='picture']").attr("src",getImagePath()+item['pictures'][0]['imgPath']);
	}else{
		copy.find("img[name='picture']").attr("src",getBasePath()+"/css/mobile/images/nopicture.jpg");
	}
	copy.find("div[name='title']").text(item['title']);
	var newtxt = item['content'].replace(/<[^>].*?>/g,"");
	copy.find("p[name='subtitle']").text(newtxt.substring(0,26)+"...");

	copy.click(function(){
		window.location.href = getBasePath()+"/newdetail?newid="+item["id"];
	});
	
	return copy;
}