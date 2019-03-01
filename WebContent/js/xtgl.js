/**
 * 跳转刷新右边内容
 * @param pageType
 * @return
 */
function forwardPageXtgl(pageType, str, obj){
	if(pageType=='yhwh'){
		queryYhwh(0,str);
	} else if(pageType=='dwwh'){
		queryDwwh(str);
	} else if(pageType=='yhzwh'){
		queryYhzwh(str);
	}
	/*事项选中*/
	if (obj != "" && obj != null) {
		jQuery(".pf-nav a").removeClass("active");
		jQuery(obj).addClass("active");
	}
}

/**
 * 查询用户维护
 * @return
 */
function queryYhwh(currentPage,str){
	var map = {};
	map["queryModel.showCount"] = 10; //每页记录数
	map["queryModel.sortName"] = 'xhgh'; //排序字段
	map["queryModel.sortOrder"] = 'asc'; //排序方式
	map["queryModel.currentPage"] = currentPage;
	map["xhgh"] = jQuery('#xhgh').val();
	map["xm"] = jQuery('#xm').val();
	map["yhlb"] = jQuery('#yhlb').val();
	map["yhzt"] = jQuery('#yhzt').val();
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("xtgl_cxYhwh.html", map, function(){
		jQuery("#rightHtml").fadeIn("slow");
	});
}

/**
 * 更改用户状态为启用
 * @param {Object} xhgh
 * @return {TypeName} 
 */
function updateYhztEnable(currentPage,xhgh){
	var url='xtgl_updateYhzt.html';
	var map = {};
	map["xhgh"]  = xhgh;
	map["yhzt"]  = '1';
	jQuery.ajaxSetup({async:false});
	jQuery.post(url,map,function(data){
		if(data.IS_SUCCESS=="FAILURE"){
			alert("启用失败！");
			return false;
		}else{
			alert("启用成功！");
		}
		queryYhwh(currentPage);
	},'json');
	jQuery.ajaxSetup({async:true});
}

/**
 * 更改用户状态为禁用
 * @param {Object} xhgh
 * @return {TypeName} 
 */
function updateYhztDisable(currentPage,xhgh){
	var url='xtgl_updateYhzt.html';
	var map = {};
	map["xhgh"]  = xhgh;
	map["yhzt"]  = '0';
	jQuery.ajaxSetup({async:false});
	jQuery.post(url,map,function(data){
		if(data.IS_SUCCESS=="FAILURE"){
			alert("禁用失败！");
			return false;
		}else{
			alert("禁用成功！");
		}
		queryYhwh(currentPage);
	},'json');
	jQuery.ajaxSetup({async:true});
}
			
/**
 * 查询单位维护
 * @return
 */
function queryDwwh(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("xtgl_cxDwwh.html?doType=query",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 查询用户组维护
 * @return
 */
function queryYhzwh(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("xtgl_cxYhzwh.html?doType=query",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 修改用户组
 * @return
 */
function modYhz(type_id){
	var map = {};
	map["type_id"]  = type_id;
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("xtgl_cxYhzxx.html",map,
		function(){
			jQuery("#rightHtml").fadeIn("slow");
		}
	);
}