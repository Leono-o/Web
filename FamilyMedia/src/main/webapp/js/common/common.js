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
	    		
	    		$("#pswdDialog_yes").click(function(){
	    			
	    			let pswd =  $('#pswd').val();
	    			$('#pswdDialog')[0].close();
	    			
		    		if (pswd == ""){
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
	    	    });
	    		
	    		$("#pswdDialog_no").click(function(){
	    			$('#pswdDialog')[0].close();
	    			ease();
	    	    });
	    		
	    		$('#pswdDialog')[0].showModal();
	    		
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
