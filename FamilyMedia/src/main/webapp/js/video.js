
let jlistParam =   {
	"layout": [
			  { "name":"id",  "field":"id", "format":"", "display":"false" },
			  { "name":"ftype",  "field":"ftype", "format":"", "display":"true" },
			  { "name":"fname",  "field":"fname", "format":"", "display":"true" },			  
			  { "name":"size",  "field":"size", "format":"", "display":"true" },
			  { "name":"cmt",  "field":"cmt", "format":"", "display":"true" }			  
		   ],

	};

$(function(){
	freeze();
	request("GET","/FamilyMedia/video?user=" + $('#user').val() ,null,showList, $("#Jlist"));
});


function showList(ele, res, success){
	ease();
	
	if (!success) {
		return ;
	}
	
	makeJlist(ele[0], res.data, jlistParam);
	
	// [单击] 为收到的所有条目加上单击事件
	ele.children(".Jlist_row").click(function(){
		if ($(this).hasClass("selected")){
			$(ele).children(".Jlist_row").removeClass("selected");
		} else {
			$(ele).children(".Jlist_row").removeClass("selected");
			$(this).addClass("selected");
		}
		
		if ($(this).hasClass("selected")){
			if ($(this).children("[name='ftype']").first().text() === "DIR") {
				freeze();
				request("GET", "/FamilyMedia/video?user="
						+ $('#user').val()
						+ "&folderid=" + $(this).children("[name='id']").first().val(),
						null,
						showList,
						$(this).children("[name='children']").first());
			} else {
				let uri=makeString("/FamilyMedia/video/{$0}" , [$(this).children("[name='id']").first().val()]);
				$("#video-payer")[0].src = uri;
			}
		}
	});
}

