
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
	request("GET","/FamilyMedia/music",null,showList, $("#Jlist"));
        
});


function showList(ele, res, success){
	ease();
	
	if (!success) {
		return ;
	}
	
	makeJlist(ele[0], res.data, jlistParam);
	
	// [单击] 为收到的所有条目加上单击事件
	ele.find(".Jlist_main").click(function(){
		if ($(this).hasClass("selected")){
			$("#Jlist").find(".Jlist_main").removeClass("selected");
		} else {
			$("#Jlist").find(".Jlist_main").removeClass("selected");
			$(this).addClass("selected");
		}
		
		if ($(this).hasClass("selected")){
			if ($(this).children("[name='ftype']").first().text() === "DIR") {
				freeze();
				request("GET", "/FamilyMedia/music?user="
						+ $('#user').val()
						+ "&folderid=" + $(this).children("[name='id']").first().val(),
						null,
						showList,
						$(this).parent().children(".Jlist_children").first());
			} else {
				let uri=makeString("/FamilyMedia/music/{$0}" , [$(this).children("[name='id']").first().val()]);
				$("#music-payer")[0].src = uri;
			}
		}
	});
	
}