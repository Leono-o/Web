


function makeJlist(obj, res, layout) {

	loadcss("js/lib/J-list.css");
	
	obj.innerHTML = "";

	var txt = "";

	res.forEach(function(rv,ri,ra) {

		var row = "";
		layout.forEach(function(lv,li,la) {
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

};


function makeString(stringformat, valueArray) {
	valueArray.forEach(function(v, i) {
		stringformat = stringformat.replace("{$" + i + "}", v);
	});
	
	return stringformat;
}
