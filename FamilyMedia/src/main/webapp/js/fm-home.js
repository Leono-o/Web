


$(function(){

	// 【视频】按钮
    $("#btn_video").click(function(){
    	$("#btn_video").addClass("selected");
    	$("#btn_music").removeClass("selected");
   	 	
        $("#fm-context").load("video.html");
    });

    // 【音乐】按钮
    $("#btn_music").click(function(){
    	$("#btn_video").removeClass("selected");
    	$("#btn_music").addClass("selected");
    	
    	$("#fm-context").load("music.html");
    });
   
});

