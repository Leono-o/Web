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