/**
 * 跳转刷新右边内容
 * @param pageType
 * @return
 */
function forwardPageSxgl(pageType, str, obj) {
	//事项维护
	if (pageType=='sxwh') {
		querySxwh(0, str);
	//热门事项
	} else if (pageType=='rmsx') {
		queryRmsx(0, str);
	//热门点击事项
	} else if (pageType=='rmdjsx') {
		queryRmDjsx(0, str);
	}
	/*事项选中*/
	if (obj != "" && obj != null) {
		jQuery(".pf-nav a").removeClass("active");
		jQuery(obj).addClass("active");
	}
}

/**
 * 查询事项
 * @return
 */
function querySxwh(currentPage, str) {
	if (str != 'redirect') {
		//事项名称
		var sxmc = jQuery('#sxmc').val();
		//所属部门
		var dept_id = jQuery('#dept_id').val();
		//服务对象
		var obj_id = jQuery('#obj_id').val();
	}
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'transaction_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["sxmc"] = sxmc;
		map["dept_id"] = dept_id;
		map["obj_id"] = obj_id;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("sxgl_cxSxwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 查询热门事项
 * @return
 */
function queryRmsx(currentPage, str) {
	if (str != 'redirect') {
		//事项名称
		var sxmc = jQuery('#sxmc').val();
		//所属部门
		var dept_id = jQuery('#dept_id').val();
		//服务对象
		var obj_id = jQuery('#obj_id').val();
	}
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["sxmc"] = sxmc;
		map["dept_id"] = dept_id;
		map["obj_id"] = obj_id;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("sxgl_cxRmsx.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 查询热门点击事项
 * @return
 */
function queryRmDjsx(currentPage, str) {
	if (str != 'redirect') {
		//事项名称
		var sxmc = jQuery('#sxmc').val();
		//所属部门
		var dept_id = jQuery('#dept_id').val();
		//服务对象
		var obj_id = jQuery('#obj_id').val();
	}
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["sxmc"] = sxmc;
		map["dept_id"] = dept_id;
		map["obj_id"] = obj_id;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("sxgl_cxRmDjsx.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 删除事项
 * @return
 */
function delSx(transaction_id) {
	var url = 'sxgl_scSxwh.html';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, {
			transaction_id : transaction_id
		}, function(data) {
			//alert(data.toString());
				refershParent();
			}, 'json');
		jQuery.ajaxSetup( {
			async : true
		});
	}
	showConfirmDivLayerX('您确定要删除记录吗？', {
		'okFun' : _do
	})
}

/**
 * 取消置顶事项
 * @return
 */
function qxzdSx(transaction_id) {
	var url = 'sxgl_qxzdSxwh.html';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, {
			transaction_id : transaction_id,
			whether_top : 1
		}, function(data) {
			//alert(data.toString());
				refershParent();
			}, 'json');
		jQuery.ajaxSetup( {
			async : true
		});
	}
	showConfirmDivLayerX('您确定要取消置顶吗？', {
		'okFun' : _do
	})
}

/**
 * 置顶事项
 * @return
 */
function zdSx(transaction_id) {
	var url = 'sxgl_zdSxwh.html';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, {
			transaction_id : transaction_id,
			whether_top : 0
		}, function(data) {
			//alert(data.toString());
				refershParent();
			}, 'json');
		jQuery.ajaxSetup( {
			async : true
		});
	}
	showConfirmDivLayerX('您确定要置顶该事项吗？', {
		'okFun' : _do
	})
}