function freeze() {
	$("#waitmask").css("display","block");
}

function ease() {
	$("#waitmask").css("display","none");
}


function request(method, uil, obj, func) {
	$.ajax({
	    async: false, //同步false
	    type: method,
	    dataType: "json", //json text 服务器返回的数据类型
	    contentType: "application/json",
	    url: "" + uil,
	    data: {
	        object: JSON.stringify(obj)
	    },
	    success: function (result) {
	    	func(result , true);
	    },
	    error: function (result) {
	    	func(result, false);
	    }
	});
}

function getCssVal($ele, name ){
	return getComputedStyle($ele[0]).getPropertyValue(name).trim();
}

function setCssVal($ele, name , val){
	$ele[0].style.setProperty(name,val);
}



/**
 * 格式化字符串 </br>
 * 将原字符串中的{$0},{$1}等置换成对应数组中的字符串
 * @param stringformat
 * @param valueArray
 * @returns
 */
function makeString(stringformat, valueArray) {
	valueArray.forEach(function(v, i) {
		stringformat = stringformat.replace("{$" + i + "}", v);
	});
	
	return stringformat;
}
