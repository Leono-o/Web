

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

		txt = txt + '<li class="Jlist_row"><div class="Jlist_main">' + row + "</div><ul class='Jlist_children'></ul></li>";
	});

	obj.innerHTML = txt;

	obj.style.cssText =  "list-style-type:none;";
};
