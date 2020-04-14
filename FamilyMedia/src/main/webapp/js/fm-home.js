


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

$(document).ready(function(){
	// 窗口大小改变时
	$(window).resize(function() {
		$("body").css("--window-height","" + $(window).height() + "px");
    	//$("#fm-context").css("height","calc(var(--window-height) - var(--header-height))");
	});

});

