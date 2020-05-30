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
	    		
	    		// 使用延时的目的是防止递归调用
	    		setTimeout(function(){
	    			
	    			let myBrowser = getBrowserName();
	    			if (myBrowser === "Edge") {
	    				// 不支持<Dialog>的浏览器用prompt()
	    				let pswd =  prompt("请输入密码：");
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
	    			} else {
		    			// 不能使用prompt()，手机端取不到返回值
			    		$("#pswdDialog_yes").click(function(){
			    			
			    			let pswd =  $('#pswd').val();
			    			$('#pswd').val("");
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
			    			$('#pswd').val("");
			    			$('#pswdDialog')[0].close();
			    			ease();
			    	    });
			    		
			    		$('#pswdDialog')[0].showModal();
	    			}
		    	},1);
	    		
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


function getBrowserName() {
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
    var isIE = userAgent.indexOf("compatible") > -1
            && userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
    var isEdge = userAgent.indexOf("Edge") > -1; //判断是否IE的Edge浏览器
    var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
    var isSafari = userAgent.indexOf("Safari") > -1
            && userAgent.indexOf("Chrome") == -1; //判断是否Safari浏览器
    var isChrome = userAgent.indexOf("Chrome") > -1
            && userAgent.indexOf("Safari") > -1; //判断Chrome浏览器

    if (isIE) {
        var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        reIE.test(userAgent);
        var fIEVersion = parseFloat(RegExp["$1"]);
        if (fIEVersion == 7) {
            return "IE7";
        } else if (fIEVersion == 8) {
            return "IE8";
        } else if (fIEVersion == 9) {
            return "IE9";
        } else if (fIEVersion == 10) {
            return "IE10";
        } else if (fIEVersion == 11) {
            return "IE11";
        } else {
            return "0";
        }//IE版本过低
        return "IE";
    }
    if (isOpera) {
        return "Opera";
    }
    if (isEdge) {
        return "Edge";
    }
    if (isFF) {
        return "FF";
    }
    if (isSafari) {
        return "Safari";
    }
    if (isChrome) {
        return "Chrome";
    }
    
}