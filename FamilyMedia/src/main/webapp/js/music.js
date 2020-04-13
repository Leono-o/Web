
var layout =   [
			  { "name":"id",  "field":"id", "format":"", "display":"false" },
			  { "name":"ftype",  "field":"ftype", "format":"", "display":"true" },
			  { "name":"fname",  "field":"fname", "format":"", "display":"true" },			  
			  { "name":"size",  "field":"size", "format":"", "display":"true" },
			  { "name":"cmt",  "field":"cmt", "format":"", "display":"true" }			  
		   ];

$(function(){
	freeze();
	request("GET","/FamilyMedia/music",null,setRes);
        
});


function setRes(res, success){
	ease();
	
	if (!success) {
		return ;
	}
	makeJlist($("#Jlist")[0], res.data, layout);
}