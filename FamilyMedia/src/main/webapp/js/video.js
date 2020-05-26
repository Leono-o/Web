
let jlistParam =   {
	"layout" : [ 
			[ "id", "id", "", "", "false" ],
			[ "ftype", "ftype", "ftype", "", "true" ],
			[ "fname", "fname", "", "", "true" ] ]
};

$(function(){
	freeze();
	request("GET",
			makeString("/FamilyMedia/rs/{$0}/videos", [ $('#user').val()]),
			null,
			showList, 
			$("#Jlist"));
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
			$(this).parent().children(".Jlist_children")[0].innerHTML = "";
		} else {
			$("#Jlist").find(".Jlist_main").removeClass("selected");
			$(this).addClass("selected");
		}
		
		if ($(this).hasClass("selected")){
			if ($(this).children("[name='ftype']").first().text() === "DIR") {
				freeze();
				let uri=makeString("/FamilyMedia/rs/{$0}/videos?resourceid={$1}", [ $('#user').val(), $(this).children("[name='id']").first().val()]);
				request("GET", 
						uri,
						null,
						showList,
						$(this).parent().children(".Jlist_children").first());
			} else {
				let uri=makeString("/FamilyMedia/rs/{$0}/videobyid?resourceid={$1}" , [$('#user').val(), $(this).children("[name='id']").first().val()]);
				$("#video-payer")[0].src = uri;
			}
		}
	});
}

