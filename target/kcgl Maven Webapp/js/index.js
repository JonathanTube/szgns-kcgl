/**
 * js
 */
//获得所有的类型json数据
var brand_json = getJsonData("/queryAllBrand");
var product_json = getJsonData("/queryAllProduct");
var tech_json = getJsonData("/queryAllTech");
var thickness_json = getJsonData("/queryAllThickness");
var cust_json = getJsonData("/queryAllCust");

//根据URL地址获取json对象
function getJsonData(url) {
	var d = null;
	jQuery.ajax({
		type : "post",
		async : false,
		url : url,
		dataType : "json",
		cache : false,
		success : function(data) {
			d = data;
		}
	});
	return d;
}

//初始化下拉框
function initSelectMenu(json_data) {
	var temp = "<select data-native-menu='false' data-mini='true' value=''>";
	temp += "<option value='' data-placeholder='true'>请选择...</option>";
	$(json_data).each(function(index) {
		var val = json_data[index];
		temp += "<option value="+ val.id +">" + val.name + "</option>";
	});
	temp += "</select>";
	return temp;
}

//function start
//加载各种类型
function initTypes(target, json_data) {
	target.empty();
	var temp = "";
	$(json_data).each(function(index) {
		var val = json_data[index];
		temp += "<li><input type=\"button\" data-icon=\"delete\" data-iconpos=\"right\" lang=\"" + val.id + "\" value=\""+ val.name +"\"/></li>";
	});
	target.append(temp).trigger('create');
}