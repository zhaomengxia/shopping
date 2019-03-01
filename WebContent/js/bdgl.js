/**
 * 跳转刷新右边内容
 * @param pageType
 * @return
 */
function forwardPageBdgl(pageType,str){
	if(pageType=='ywkwh'){
		queryYwkwh(str);
	} else if(pageType=='bzywh'){
		queryBzywh(str);
	} else if(pageType=='xxwh'){
		queryXxwh(str);
	} else if(pageType=='bdsj'){
		queryBdsj(str);
	} else if(pageType=='csbd'){
		queryCsbd(str);
	} else if(pageType=='csbdlb'){
		queryCsbdlb(str);
	} else if(pageType=='dsp'){
		queryDsp(str);
	} else if(pageType=='ysp'){
		queryYsp(str);
	}
}

/**
 * 业务库维护
 * @return
 */
function queryYwkwh(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../sys/sjkpzManager_main.html",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 表资源维护
 * @return
 */
function queryBzywh(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../sys/resourceManager_main.html",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 信息维护
 * @return
 */
function queryXxwh(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../form/infoManager_main.html",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 表单设计
 * @return
 */
function queryBdsj(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../form/compFormManager_main.html",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}


/**
 * 测试表单
 * @param str
 * @return
 */
function queryCsbd(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../form/formSbManager_main.html?id=231",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 测试表单列表
 * @param str
 * @return
 */
function queryCsbdlb(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../form/formSbManager_sbqkTable.html?id=231",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 待审批
 * @param str
 * @return
 */
function queryDsp(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../work/formWorkManager_main.html?id=231",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}

/**
 * 已审批
 * @param str
 * @return
 */
function queryYsp(str){
	jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#rightHtml").load("../work/formFollowWorkManager_main.html?id=231",null,
			function(){
				jQuery("#rightHtml").fadeIn("slow");
			}
	);
}