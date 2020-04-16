
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
	request("GET","/FamilyMedia/music",null,showList);
        
});


function showList(res, success){
	ease();
	
	if (!success) {
		return ;
	}
	makeJlist($("#Jlist")[0], res.data, jlistParam);
	
	// [单击]
	$("#Jlist").children(".Jlist_row").click(function(){

		let uri=makeString("/FamilyMedia/music/{$0}" , [$(this).children("[name='id']").first().val()]);
		$("#music-payer")[0].src = uri;
	});
}