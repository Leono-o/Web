

/**
 * 生成列表
 * 
 * @param obj
 * @param res
 * @param jlistParam
 * @returns
 */
function makeJlist(obj, res, jlistParam) {

	//loadcss("js/lib/J-list.css");
	
	obj.innerHTML = "";

	let txt = "";

	res.forEach(function(rv,ri,ra) {

		let row = "";
		jlistParam.layout.forEach(function(lv,li,la) {
			if (lv["display"] === "true"){
				row = row
				+ makeString('<div name="{$0}">{$1}</div>', [lv["name"], rv[lv["field"]] ]);
			} else {
				row = row
						+ makeString('<input type="hidden" name="{$0}" value="{$1}" />', [lv["name"], rv[lv["field"]] ]);
			}
		});

		txt = txt + '<div class="Jlist_row">' + row + "</div>";
	});

	obj.innerHTML = txt;

	// 全部变成非选择状态
	$(obj).children(".Jlist_row").removeClass("selected");
	
	// [单击]
	$(obj).children(".Jlist_row").click(function(){
		
		// 使被单击的选项变成选中状态
		$(obj).children(".Jlist_row").removeClass("selected");
		$(this).addClass("selected");
	});
};
