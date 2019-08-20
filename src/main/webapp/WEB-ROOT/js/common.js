function getTree(data) {
	var tree = [
	{
		text : "无",
		href : "javascript:tetet()"
	} ];

	$.each(data, function(i, item) {
		var node = '{"text":"' + item.name + '"' + ','
				+ '"href":"javascript:selectList(' + '\''+item.number+'\''+ ')"}';
		obj = jQuery.parseJSON(node);
		tree[i] = obj;
	});
	return tree;
};

var getFormData = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
}

function getMyDate(str) {
	var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
			.getMonth() + 1, oDay = oDate.getDate(), oTime = oYear + '-'
			+ getzf(oMonth) + '-' + getzf(oDay);
	return oTime;
};

function getzf(num) {
	if (parseInt(num) < 10) {
		num = '0' + num;
	}
	return num;
}