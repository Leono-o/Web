

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
	
	if (res.length === 0){
		txt = '<li class="Jlist_row"><div class="Jlist_main empty">空</div></li>';
	} else {
		res.forEach(function(rv,ri,ra) {
	
			let row = "";
			jlistParam.layout.forEach(function(lv,li,la) {
				if (lv[4] === "true"){
					if ( lv[2] === ""){
						row = row
						+ makeString('<div name="{$0}">{$1}</div>', [lv[0], rv[lv[1]] ]);
					} else {
						row = row
						+ makeString('<div name="{$0}" class="Jlist_{$1}">{$2}</div>', [lv[0], rv[lv[2]], rv[lv[1]] ]);
					}
				} else {
					row = row
							+ makeString('<input type="hidden" name="{$0}" value="{$1}" />', [lv[0], rv[lv[1]] ]);
				}
			});
	
			txt = txt + '<li class="Jlist_row"><div class="Jlist_main">' + row + "</div><ul class='Jlist_children'></ul></li>";
		});
	}

	obj.innerHTML = txt;

	obj.style.cssText =  "list-style-type:none";
};
