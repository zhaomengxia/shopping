/**
 * 跳转刷新右边内容
 * @param pageType
 * @return
 */
function forwardPageInfo(pageType, str, obj) {
	if (pageType == 'ggxx') { //公告信息
		queryGg(0, str);
	} else if (pageType == 'jlzxxx') { //交流咨询信息
		queryJlzx(0, str);
	} else if (pageType == 'yqljxx') { //友情链接信息
		queryYqlj(0, str);
	} else if (pageType == 'jcwmjs') { //基础文明建设
		queryJcwmjs(0, str);
	} else if (pageType == 'wxewmxx') { //微信二维码信息
		queryWxewm(0, str);
	}
	/*事项选中*/
	if (obj != "" && obj != null) {
		jQuery(".pf-nav a").removeClass("active");
		jQuery(obj).addClass("active");
	}
}
/**
 * 查询友情链接
 * @return
 */
function queryYqlj(currentPage, str) {
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("info_cxYqlj.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加友情链接
 * @return
 */
function addYqlj() {
	showWindow('增加友情链接', 460, 300, 'info_zjYqlj.html');
}

/**
 * 修改友情链接
 * @return
 */
function modYqlj(id) {
	showWindow('修改友情链接', 460, 300,	'info_xgYqlj.html?yqljModel.id=' + id);
}

/**
 * 删除友情链接
 * @return
 */
function delYqlj(id) {
	var url = 'info_scYqlj.html';
	var map = {};
	map["yqljModel.id"] = id;
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
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
 * 验证输入是否为空
 * 
 * @param inputStr
 *            格式：!! 多个字符之间必须用 !!
 * @return
 */
function checkInputForNotNull(inputStr,tips){
	var input = inputStr.split("!!");
	for(var i=0;i<input.length;i++){
		var temp = document.getElementById(input[i]);
		var tempvalue = trim(document.getElementById(input[i]).value);
		if(temp==null || tempvalue==null || tempvalue==""){
			alert("请将"+ tips + "信息填写完整！" );
			return false;
		}
	}
	return true;
}

/**
 * 查询公告
 * @return
 */
function queryGg(currentPage, str) {
	if (str != 'redirect') {
		var ggbt = jQuery('#ggbt').val();
		var choiceStatus = jQuery('#choiceStatus').val();
		var dept_id = jQuery('#dept_id').val();;
	}
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'issue_time'; //排序字段
	map["queryModel.sortOrder"] = 'desc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["ggbt"] = ggbt;
		map["published"] = choiceStatus;
		map["dept_id"] = dept_id;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("info_cxGgxx.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加公告
 * @return
 */
function addGg() {
	showWindowScroll('增加公告', 780, 500, 'info_zjGgxx.html');
}

/**
 * 修改公告
 * @return
 */
function modGg(notice_id) {
	showWindowScroll('修改公告', 780, 500, 'info_xgGgxx.html?notice_id=' + notice_id);
}

/**
 * 删除公告
 * @return
 */
function delGg(notice_id) {
	var url = 'info_scGgxx.html';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, {
			notice_id : notice_id
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
 * 查询交流咨询
 * @return
 */
function queryJlzx(currentPage, str) {
	if (str != 'redirect') {
		var zxnr = jQuery('#zxnr').val();
		var dept_id = jQuery('#dept_id').val();
		var faqcategory_id = jQuery('#faqcategory_id').val();
	}

	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'create_time'; //排序字段
	map["queryModel.sortOrder"] = 'desc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["zxnr"] = zxnr;
		map["dept_id"] = dept_id;
		map["faqcategory_id"] = faqcategory_id;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("info_cxJlzxxx.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加交流咨询
 * @return
 */
function addJlzx() {
	showWindowScroll('增加常见问题', 780, 500, 'info_zjJlzxxx.html');
}

/**
 * 修改交流咨询
 * @return
 */
function modJlzx(faq_id) {
	showWindowScroll('修改常见问题', 780, 500, 'info_xgJlzxxx.html?faq_id=' + faq_id);
}

/**
 * 删除交流咨询
 * @return
 */
function delJlzx(faq_id) {
	var url = 'info_scJlzxxx.html';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, {
			faq_id : faq_id
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
 * 查询基础文明建设
 * @return
 */
function queryJcwmjs(currentPage, str) {
	if (str != 'redirect') {
		var xh = jQuery('#xh').val();
		var xm = jQuery('#xm').val();
	}

	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'gyqdcrq'; //排序字段
	map["queryModel.sortOrder"] = 'desc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	if (str != 'redirect') {
		map["xh"] = xh;
		map["xm"] = xm;
	}
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("info_cxJcwmjs.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加基础文明建设
 * @return
 */
function addJcwmjs() {
	showWindowScroll('增加基础文明建设', 800, 600, 'info_zjJcwmjs.html');
}

/**
 * 修改基础文明建设
 * @return
 */
function modJcwmjs(id) {
	showWindowScroll('修改基础文明建设', 800, 600, 'info_xgJcwmjs.html?id=' + id);
}

/**
 * 删除基础文明建设
 * @return
 */
function delJcwmjs(id) {
	var url = 'info_scJcwmjs.html';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, {
			id : id
		}, function(data) {
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
 * 查看基础文明建设
 * @return
 */
function showJcwmjs(id) {
	showWindowScroll('查看基础文明建设', 800, 600, 'info_ckJcwmjs.html?id=' + id);
}

/**
 * 查询微信二维码维护
 * @return
 */
function queryWxewm(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 1; //每页记录数
	map["queryModel.sortName"] = 'id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_04.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("info_cxWxewm.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 修改微信二维码
 * @return
 */
function modWxewm(id) {
	showWindowScroll('修改微信二维码', 500, 400, 'info_xgWxewm.html?wxewmModel.id=' + id );
}


/**
 * 加载学生基本信息
 */
function loadInfo(){
	var xh = jQuery("#xh").val();
	var url = "<%=request.getContextPath()%>/web/info_loadInfo.html";
	var map = {};
	map["xh"] = xh;
	jQuery.ajaxSetup({async:false});
	jQuery.post(url,map,function(data){
		jQuery("#xm").val(data.xm);
		jQuery("#xb").val(data.xb);
		jQuery("#xy").val(data.xy);
		jQuery("#nj").val(data.nj);
		jQuery("#zy").val(data.zy);
		jQuery("#bj").val(data.bj);
	},'json');
	jQuery.ajaxSetup({async:true});
}