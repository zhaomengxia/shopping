/**
 * 跳转刷新右边内容
 * @param pageType
 * @return
 */
function forwardPageTjfx(pageType, str, obj){
	// 评价统计页面
	if(pageType=='pjtj'){
		queryPjtj(0, str);
	}
	// 办理统计页面
	else if(pageType=='bltj'){
		queryBltj(0, str);
	}
	else if(pageType=='wdtj'){
		queryWdtj(0, str);
	}
	/*事项选中*/
	if (obj != "" && obj != null) {
		jQuery(".pf-nav a").removeClass("active");
		jQuery(obj).addClass("active");
	}
}

/**
 * 评价统计
 * @return
 */
function queryPjtj(currentPage, str) {
	if (str != 'redirect') {
		// 检索条件
		// 评价时间From
		var evalute_time_from = jQuery('#evalute_time_from').val();
		// 评价时间To
		var evalute_time_to = jQuery('#evalute_time_to').val();
		// 部门ID
		var dept_id = jQuery('#dept_id').val();
		// 事项
		var blsx = jQuery('#blsx').val();
	}
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'transaction_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["evalute_time_from"] = evalute_time_from;
		map["evalute_time_to"] = evalute_time_to;
		map["dept_id"] = dept_id;
		map["blsx"] = blsx;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("tjfx_cxPjtj.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 办理统计
 * @return
 */
function queryWdtj(currentPage, str) {
	if (str != 'redirect') {
		// 检索条件
		// 办理时间From
		var transaction_time_from = jQuery('#transaction_time_from').val();
		// 办理时间To
		var transaction_time_to = jQuery('#transaction_time_to').val();
		// 部门ID
		var dept_id = jQuery('#dept_id').val();
		// 事项
		var blsx = jQuery('#blsx').val();
		// 状态
		var choiceStatus = jQuery('#choiceStatus').val();
	}
	var totalPage = jQuery('#totalPage').val();
	var totalResult = jQuery('#totalResult').val();
		
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.currentPage"] = currentPage;
	map["queryModel.totalPage"] = totalPage;
	map["queryModel.totalResult"] = totalResult;
	if (str != 'redirect') {
		map["transaction_time_from"] = transaction_time_from;
		map["transaction_time_to"] = transaction_time_to;
		map["dept_id"] = dept_id;
		map["blsx"] = blsx;
		map["sqzt"] = choiceStatus;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("tjfx_cxWdtj.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 办理统计
 * @return
 */
function queryBltj(currentPage, str) {
	if (str != 'redirect') {
		// 检索条件
		// 办理时间From
		var transaction_time_from = jQuery('#transaction_time_from').val();
		// 办理时间To
		var transaction_time_to = jQuery('#transaction_time_to').val();
		// 部门ID
		var dept_id = jQuery('#dept_id').val();
		// 事项
		var blsx = jQuery('#blsx').val();
	}
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["transaction_time_from"] = transaction_time_from;
		map["transaction_time_to"] = transaction_time_to;
		map["dept_id"] = dept_id;
		map["blsx"] = blsx;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("tjfx_cxBltj.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}