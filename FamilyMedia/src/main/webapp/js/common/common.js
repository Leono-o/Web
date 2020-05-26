function freeze() {
	$("#waitmask").css("display","block");
}

function ease() {
	$("#waitmask").css("display","none");
}


function request(method, url, obj, func, ele) {
	
	let requestUrl = url;
	
	if (requestUrl.indexOf("&user=")>0 || requestUrl.indexOf("?user=")>0){
		// do nothing
	} else {
		if (requestUrl.indexOf("?") >0){
			requestUrl = requestUrl + "&user=" + $('#user').val();
		} else {
			requestUrl = requestUrl + "?user=" + $('#user').val();
		}
	}
	
	$.ajax({
	    async: false, //同步false
	    type: method,
	    dataType: "json", //json text 服务器返回的数据类型
	    contentType: "application/json",
	    url: requestUrl,
	    data: {
	        object: JSON.stringify(obj)
	    },
	    success: function (result) {
	    	func(ele,result , true);
	    },
	    error: function (result) {
	    	if (result.status === 401){
	    		let pswd = prompt("请输入密码：");
	    		if (pswd == null){
	    			ease();
	    		} else {
	    			let n = requestUrl.indexOf("&token=");
	    			if (n>0){
	    				requestUrl = requestUrl.slice(0,n) +"&token=" + pswd;
	    			} else {
	    				requestUrl = requestUrl +"&token=" + pswd;
	    			}
	    			request(method, requestUrl, obj, func, ele);
	    		}
	    	} else{
	    		func(ele,result, false);
	    	}
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
