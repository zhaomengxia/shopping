/**
 * 跳转刷新右边内容
 * @param pageType
 * @return
 */
function forwardPageJcsjgl(pageType, str, obj){
	if(pageType=='yhlxwh'){
		queryYhlxwh(0,str);
	} else if(pageType=='fwdxwh'){
		queryFwdxwh(0,str);
	} else if(pageType=='fwlxwh'){
		queryFwlxwh(0,str);
	} else if(pageType=='sshzwh'){
		querySshzwh(0,str);
	}else if(pageType=='tzlbwh'){
		queryTzlbwh(0,str);
	} else if(pageType=='zxlbwh'){
		queryZxlbwh(0,str);
	} else if(pageType=='dhtbwh'){
		queryDhtbwh(0,str);
	} else if(pageType=='xszywh'){
		queryXszywh(0,str);
	} else if(pageType=='anmcwh'){
		queryAnmcwh(0,str);
	} else if(pageType=='xtcdwh'){
		queryXtcdwh(0,str);
	}
	/*事项选中*/
	if (obj != "" && obj != null) {
		$(".pf-nav a").removeClass("active");
		$(obj).addClass("active");
	}
}

/**
 * 查询系统菜单维护
 * @return
 */
function queryXtcdwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'cdid'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxXtcdwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 更改系统菜单状态为启用
 * @param {Object} cdid
 */
function updateSfxsEnable(currentPage,cdid){
	var url='jcsjgl_updateSfxs.html';
	var map = {};
	map["cdid"]  = cdid;
	map["sfxs"]  = '1';
	jQuery.ajaxSetup({async:false});
	jQuery.post(url,map,function(data){
		if(data.IS_SUCCESS=="FAILURE"){
			alert("启用失败！");
			return false;
		}else{
			alert("启用成功！");
		}
		queryXtcdwh(currentPage);
	},'json');
	jQuery.ajaxSetup({async:true});
}

/**
 * 更改系统菜单状态为禁用
 * @param {Object} cdid
 */
function updateSfxsDisable(currentPage,cdid){
	var url='jcsjgl_updateSfxs.html';
	var map = {};
	map["cdid"]  = cdid;
	map["sfxs"]  = '0';
	jQuery.ajaxSetup({async:false});
	jQuery.post(url,map,function(data){
		if(data.IS_SUCCESS=="FAILURE"){
			alert("禁用失败！");
			return false;
		}else{
			alert("禁用成功！");
		}
		queryXtcdwh(currentPage);
	},'json');
	jQuery.ajaxSetup({async:true});
}

/**
 * 查询用户类型维护
 * @return
 */
function queryYhlxwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'type_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["type_name"] = jQuery('#type_name').val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxYhlxwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加用户类型
 * @return
 */
function addYhlx() {
	showWindowScroll('增加用户类型', 460, 300, 'jcsjgl_zjYhlxxx.html');
}

/**
 * 修改用户类型
 * @return
 */
function modYhlx(type_id) {
	showWindowScroll('修改用户类型', 460, 300, 'jcsjgl_xgYhlxxx.html?yhlxModel.type_id=' + type_id);
}

/**
 * 删除用户类型[该方法暂不用，且保留]
 * @return
 */
function delYhlx(type_id) {
	var url = 'jcsjgl_scYhlxxx.html';
	var map = {};
	map["yhlxModel.type_id"] = type_id;
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
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
 * 查询服务对象维护
 * @return
 */
function queryFwdxwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'obj_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["obj_name"] = jQuery('#obj_name').val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxFwdxwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加服务对象
 * @return
 */
function addFwdx() {
	showWindowScroll('增加服务对象', 460, 300, 'jcsjgl_zjFwdxxx.html');
}

/**
 * 修改服务对象
 * @return
 */
function modFwdx(obj_id) {
	showWindowScroll('修改服务对象', 460, 300, 'jcsjgl_xgFwdxxx.html?fwdxModel.obj_id=' + obj_id);
}

/**
 * 删除服务对象[该方法暂不用，且保留]
 * @return
 */
function delFwdx(obj_id) {
	var url = 'jcsjgl_scFwdxxx.html';
	var map = {};
	map["fwdxModel.obj_id"] = obj_id;
	map["fwdxModel.delete_tag"] = '1';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
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
 * 查询所属分类维护
 * @return
 */
function queryFwlxwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'type_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["type_name"] = jQuery('#type_name').val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxFwlxwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加所属分类
 * @return
 */
function addFwlx() {
	showWindowScroll('增加所属分类', 550, 270, 'jcsjgl_zjFwlxxx.html');
}

/**
 * 修改所属分类
 * @return
 */
function modFwlx(type_id) {
	showWindowScroll('修改所属分类', 550, 270, 'jcsjgl_xgFwlxxx.html?fwlxModel.type_id=' + type_id);
}

/**
 * 删除所属分类[该方法暂不用，且保留]
 * @return
 */
function delFwlx(type_id) {
	var url = 'jcsjgl_scFwlxxx.html';
	var map = {};
	map["fwlxModel.type_id"] = type_id;
	map["fwlxModel.delete_tag"] = '1';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
			alert(data);
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
 * 查询所属汇总维护
 * @return
 */
function querySshzwh(currentPage,str){
	var choiceStatus = jQuery('#choiceStatus').val();
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'type_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["type_name"] = jQuery('#type_name').val();
	map["bllx_id"] = jQuery('#choiceStatus').val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxSshzwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加所属汇总
 * @return
 */
function addSshz() {
	showWindowScroll('增加所属汇总', 550, 270, 'jcsjgl_zjSshzxx.html');
}

/**
 * 修改所属汇总
 * @return
 */
function modSshz(type_id) {
	showWindowScroll('修改所属汇总', 550, 270, 'jcsjgl_xgSshzxx.html?sshzModel.type_id=' + type_id);
}

/**
 * 删除所属汇总[该方法暂不用，且保留]
 * @return
 */
function delSshz(type_id) {
	var url = 'jcsjgl_scSshzxx.html';
	var map = {};
	map["sshzModel.type_id"] = type_id;
	map["sshzModel.delete_tag"] = '1';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
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
 * 查询通知类别维护
 * @return
 */
function queryTzlbwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'noticecategory_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["noticecategory_name"] = jQuery('#noticecategory_name').val();
	map["dwdm"] = jQuery('#dwdm').val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxTzlbwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加通知类别
 * @return
 */
function addTzlb() {
	showWindowScroll('增加通知类别', 460, 300, 'jcsjgl_zjTzlbxx.html');
}

/**
 * 修改通知类别
 * @return
 */
function modTzlb(noticecategory_id) {
	showWindowScroll('修改通知类别', 460, 300, 'jcsjgl_xgTzlbxx.html?tzlbModel.noticecategory_id=' + noticecategory_id);
}

/**
 * 删除通知类别[该方法暂不用，且保留]
 * @return
 */
function delTzlb(noticecategory_id) {
	var url = 'jcsjgl_scTzlbxx.html';
	var map = {};
	map["tzlbModel.noticecategory_id"] = noticecategory_id;
	map["tzlbModel.delete_tag"] = '1';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
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
 * 查询咨询类别维护
 * @return
 */
function queryZxlbwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'faqcategory_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["faqcategory_name"] = jQuery('#faqcategory_name').val();
	map["dwdm"] = jQuery('#dwdm').val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxZxlbwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加咨询类别
 * @return
 */
function addZxlb() {
	showWindowScroll('增加问题类别', 460, 300, 'jcsjgl_zjZxlbxx.html');
}

/**
 * 修改咨询类别
 * @return
 */
function modZxlb(faqcategory_id) {
	showWindowScroll('修改问题类别', 460, 300, 'jcsjgl_xgZxlbxx.html?zxlbModel.faqcategory_id=' + faqcategory_id);
}

/**
 * 删除咨询类别[该方法暂不用，且保留]
 * @return
 */
function delZxlb(faqcategory_id) {
	var url = 'jcsjgl_scZxlbxx.html';
	var map = {};
	map["zxlbModel.faqcategory_id"] = faqcategory_id;
	map["zxlbModel.delete_tag"] = '1';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
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
 * 查询导航图标维护
 * @return
 */
function queryDhtbwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'table_enName,table_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["table_enName"] = jQuery("#table_enName").val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxDhtbwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 修改导航图标
 * @return
 */
function modDhtb(icon_id,table_enName,table_id) {
	showWindowScroll('修改导航图标', 460, 300, 'jcsjgl_xgDhtbxx.html?dhtbModel.icon_id=' + icon_id + '&dhtbModel.table_enName=' + table_enName + '&dhtbModel.table_id=' + table_id);
}

/**
 * 查询新手指引维护
 * @return
 */
function queryXszywh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'tips_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxXszywh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 修改新手指引
 * @return
 */
function modXszy(tips_id) {
	showWindowScroll('修改新手指引', 460, 300, 'jcsjgl_xgXszyxx.html?xszyModel.tips_id=' + tips_id);
}

/**
 * 查询按钮名称维护
 * @return
 */
function queryAnmcwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'button_id'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("jcsjgl_cxAnmcwh.html", map, function() {
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 增加按钮名称
 * @return
 */
function addAnmc() {
	showWindowScroll('增加按钮名称', 460, 300, 'jcsjgl_zjAnmcxx.html');
}

/**
 * 修改按钮名称
 * @return
 */
function modAnmc(button_id) {
	showWindowScroll('修改按钮名称', 460, 300, 'jcsjgl_xgAnmcxx.html?anmcModel.button_id=' + button_id);
}

/**
 * 删除按钮名称
 * @return
 */
function delAnmc(button_id) {
	var url = 'jcsjgl_scAnmcxx.html';
	var map = {};
	map["anmcModel.button_id"] = button_id;
	map["anmcModel.delete_tag"] = '1';
	var _do = function() {
		jQuery.ajaxSetup( {
			async : false
		});
		jQuery.post(url, map, function(data) {
			alert(data);
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