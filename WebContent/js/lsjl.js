/**
 * 跳转刷新右边内容
 * @param pageType
 * @return
 */
function forwardPageLsjl(pageType, str, obj){
	// 历史办理页面
	if (pageType=='lsbl') {
		queryLsbl(0, str);
    // 历史评价
	} else if (pageType=='lspj') {
		queryLspj(0, str);
	} else if (pageType=='wdsq') {
		queryWdsq(0, str);
	} else if (pageType=='wdbl') {
		queryWdbl(0, str);
	} else if (pageType=='wdlspj'){
		queryWdlspj(0,str);
	}
	/*事项选中*/
	if (obj != "" && obj != null) {
		$(".pf-nav a").removeClass("active");
		$(obj).addClass("active");
	}
}
function forwardPagecommon(cdlj, str, obj) { 
	querycommon(cdlj,0,str,obj);
}

function querycommon(cdlj,currentPage,str,obj) {
	if(cdlj.indexOf("target=blank") > 0){
		cdlj = cdlj.substr(0,cdlj.indexOf("?target=blank"));
		window.open(cdlj);
	}else{
		var map = {};
		if(str != 'redirect'){
			var area_id = jQuery('#area_id').val();
			var dept_id = jQuery('#dept_id').val();
			var transaction_name = jQuery('#transaction_name').val();
		}
		map["queryModel.showCount"] = 10; //每页记录数
		map["queryModel.currentPage"]= currentPage;
		if(str != 'redirect'){
			map["area_id"]  = area_id;
			map["dept_id"]  = dept_id;
			map["transaction_name"]  = transaction_name;
		}
		jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
		jQuery("#rightHtml").load(cdlj,map, function() {
			jQuery("#rightHtml").fadeIn("slow");
		});
		/*事项选中*/
		$(".pf-nav a").removeClass("active");
		$(obj).addClass("active");
	}
}

/**
 * 中央民大接口：获取我的申请
 * 获取个人申请记录（分页）
 */
function queryWdsq(currentPage, str) {
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
	jQuery("#rightHtml").load("lsjl_cxWdsq.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 中央民大接口：获取我的申请
 * 获取申请记录（分页）
 */
function queryWdbl(currentPage, str) {
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
		var sqzt = jQuery('#choiceStatus').val();
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
		map["sqzt"] = sqzt;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("lsjl_cxWddb.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 历史办理
 * @return
 */
function queryLsbl(currentPage, str) {
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
	jQuery("#rightHtml").load("lsjl_cxLsbl.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 历史评价
 * @return
 */
function queryLspj(currentPage, str) {
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
	map["queryModel.sortName"] = 'evalute_time'; //排序字段
	map["queryModel.sortOrder"] = 'desc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["evalute_time_from"] = evalute_time_from;
		map["evalute_time_to"] = evalute_time_to;
		map["dept_id"] = dept_id;
		map["blsx"] = blsx;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("lsjl_cxLspj.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
		});
}

/**
 * 我的历史评价
 * @return
 */
function queryWdlspj(currentPage, str) {
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
	map["queryModel.sortName"] = 'evalute_time'; //排序字段
	map["queryModel.sortOrder"] = 'desc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["evalute_time_from"] = evalute_time_from;
		map["evalute_time_to"] = evalute_time_to;
		map["dept_id"] = dept_id;
		map["blsx"] = blsx;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("lsjl_cxLspj.html?query=me", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
		});
}

/**
 * 删除历史评价
 * @return
 */
function delPj(evalute_id) {
	var url = 'lsjl_scLspj.html';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, {
			evalute_id : evalute_id
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
 * 提交表单
 * @return
 */
function submitBd(formId, tableId) {
	var params = {
			"tableId" : tableId,
			"id" : formId
		};
		$.post("../form/formSbManager_ajaxSaveTable.html",params,function(data){
			   alert(data);
			   refershParentX();
		});
}

/**
 * 查看表单
 * @return
 */
function viewBd(formId, tableId, yhm, workId) {
	showWindow('查看详情', 780,520, '../form/formSbManager_sbqkTableView.html?tableId='+ tableId +"&id=" + formId + "&assignYhm=" + yhm + "&workId=" + workId);
	return false;
}

/**
 * 表单编辑
 * @return
 */
function editBd(formId, tableId, yhm) {
	showWindow('修改', 780,520, '../form/formSbManager_sbqkTableEdit.html?tableId='+ tableId + "&id=" + formId + "&assignYhm=" + yhm + "&doType=edit");
}
		
/**
 * 表单删除
 * @return
 */
function delBd(formId, tableId) {
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
	    var params = {
			"tableId" : tableId,
			"id" : formId
		};
		
		$.post("../form/formSbManager_ajaxDeleteTableByBc.html",params,function(data){
			   //alert(data);
			   refershParentX();
		}, 'json');
		
		jQuery.ajaxSetup( {
			async : true
		});
	}
	showConfirmDivLayerX('您确定要删除表单记录吗？', {
		'okFun' : _do
	})
}

/**
 * 流程跟踪
 * @return
 */
function followLc(work_id) {
	showWindowX('流程跟踪', 780, 540, '../work/formFollowWorkManager_lcgzForm.html?workId=' + work_id + "&t=" + new Date().getTime());
	return false;
}

/**
 * 把原有的弹出窗口转成ymPormpt式弹出
 * @param title
 * @param width
 * @param height
 * @param url
 */
function showWindowX(title,width,height,url,handler){
	
	ymPrompt.win({message:url,
				width:width,
				height:height,
				title:title,
				maxBtn:true,
				minBtn:true,
				iframe:true,
				showShadow:false,
				useSlide:true,
				maskAlphaColor:"#FFFFFF",
				maskAlpha:0.3,
				handler:handler
			}
	);
}

function refershParentX(){
	jQuery(window.parent.document).find('#search_go').click();
	iFCloseX();
}

function iFCloseX(){
	var doc = jQuery(window.parent.document);
	doc.find("#windownbg").remove();
	var _version = jQuery.browser.version;
	if ( _version == 6.0 ) {
		//doc.find("#DivShim").remove();//背景变成白色，盖掉下拉列表框
	}
	doc.find("#windown-box").fadeOut("fast",function(){jQuery(this).remove();});
}