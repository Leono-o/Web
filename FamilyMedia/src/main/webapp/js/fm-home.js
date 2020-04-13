


$(function(){

    $("#btn_video").click(function(){
    	$("#btn_video").addClass("selected");
    	$("#btn_music").removeClass("selected");
   	 	
        $("#fm-context").load("video.html");
    });


    $("#btn_music").click(function(){
    	$("#btn_video").removeClass("selected");
    	$("#btn_music").addClass("selected");
    	
    	$("#fm-context").load("music.html");
    });
        
});