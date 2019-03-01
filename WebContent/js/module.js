jQuery(function() {
	jQuery("#businessTransaction").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	var transaction_id = jQuery("#transaction_id").val();
	var clickInTransaction  = jQuery("#clickInTransaction").val();
	jQuery("#businessTransaction").load("module_businessOperate.html?transaction_id="+transaction_id+"&click="+clickInTransaction,null,
			function(){
				jQuery("#businessTransaction").fadeIn("slow");
			}
	);
	jQuery("#ID"+transaction_id).addClass("active");
})

function showTransaction(transaction_id){
	jQuery("#businessTransaction").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
	jQuery("#businessTransaction").load("module_businessOperate.html?transaction_id="+transaction_id,null,
		function(){
			jQuery("#businessTransaction").fadeIn("slow");
		}
	);
	//点击查看事项的时候
	jQuery.post("module_insSxdjcsb.html", {transaction_id:transaction_id}, function(data){
    },'json');
	jQuery("#accordion a").removeClass("active");
	jQuery("#ID"+transaction_id).addClass("active");
}

function downLoadFile(attach_address){
	window.location.href = "../web/module_downLoad.html?filePath="+encodeURIComponent(attach_address);
}
//					onlineHandle('/zftal-web',ContextPath
//								'close',school.outnet
//								'http://portal.zfsoft.com:8043/zfca/login',school.vpnUrl
//								'http://portal.zfsoft.com:8043/zfca',zfsso.casurl
//								'127.0.0.1:8080',zfsso.ywxtservername
//								'0',zfsso.usezfca
//								'http://10.71.32.124:8088/datacapture/form/formSbManager_ajaxSbForm.html?compForm.id=942',transaction_url
//								'ZFSOFT10102',transaction_id
//								'020000',dept_id
//								'0',whether_dock
//								''form_id);
function onlineHandle(contextPath,outnet,vpnUrl,casurl,ywxtservername,usezfca,transaction_url,transaction_id,dept_id,whether_dock,form_id,whether_logo){
	var yhmSession = jQuery("#yhmSession").val();
    if( yhmSession == ""){
    	if(usezfca==0){
    		alert("请先登录!");
    	}else{
    		if(outnet == 'open'){
//    			jQuery.post('index_sendGET.html', {url : casurl}, function(data) {
//					if (data != null && data.length > 0) {
//						if(data == 'right'){
//							if(transaction_id != ""){
//					    		var url = casurl+"/login?service=http://"+ywxtservername+contextPath+"/web/module_businessC.html?transaction_id="+transaction_id+"%26click=true";
//								window.location.href = url;
//					    	}else{
//					    		var url = casurl+"/login?service=http://"+ywxtservername+contextPath+"/web/module_transactionHandle.html?dept_id="+dept_id;
//								window.location.href = url;
//					    	}
//						}else{
//							window.location.href = vpnUrl;
//						}
//					}
//				}, 'json');
    			
    			var p = new Ping();
				p.ping(casurl+"/login", function(data) {
					if(parseInt(data) < parseInt('1000')){
						if(transaction_id != ""){
				    		var url = casurl+"/login?service=http://"+ywxtservername+contextPath+"/web/module_businessC.html?transaction_id="+transaction_id+"%26click=true";
							window.location.href = url;
				    	}else{
				    		var url = casurl+"/login?service=http://"+ywxtservername+contextPath+"/web/module_transactionHandle.html?dept_id="+dept_id;
							window.location.href = url;
				    	}
					}else{
						window.location.href = vpnUrl;
					}
				});
    		}else{
    			if(transaction_id != ""){
		    		var url = casurl+"/login?service=http://"+ywxtservername+contextPath+"/web/module_businessC.html?transaction_id="+transaction_id+"%26click=true";
					window.location.href = url;
		    	}else{
		    		var url = casurl+"/login?service=http://"+ywxtservername+contextPath+"/web/module_transactionHandle.html?dept_id="+dept_id;
					window.location.href = url;
				}
			}
		}
	}else{
		// 是否对接=1新建的时候
		if (whether_dock==1) {
//			var url = "module_bdms.html?id=" + form_id + "&transaction_id=" + transaction_id;
			var url = "../form/formSbManager_main.html?id=" + form_id + "&transaction_id=" + transaction_id;
			window.open(url);
			//showWindowX('办理表单',700, 500, url);
		} else {
			// 是否对接=0对接的时候
			// 办理件表的插入
			jQuery.post("module_insBljb.html", {transaction_id:transaction_id}, function(data){
			},'json');
			if(whether_logo=='1'){
				window.open(transaction_url);
			}else if(whether_logo=='0'){
				var url = "module_bdms.html?transaction_url="+transaction_url;
				window.open(url);
			}
		}
	}
}

function onlineEvaluate(casurl,ywxtservername,usezfca,transaction_id){
	var yhmSession = jQuery("#yhmSession").val();
    if( yhmSession == "")
    {
    	alert("请先登录!");
    }else{
		if (checkInputNotNull("pjfs")){
			//评价内容不能为空
			var pj = jQuery("#pj_content").val();
			if (pj == '') {
				alert("评价内容不能为空");
				return false;
			}
			var len = pj.length;
			if (len > 100) {
				alert("评价内容长度不能大于100个汉字");
				return false;
			}
			var url = "../web/module_onlineEvaluate.html";
			var map = {};
			map["transaction_id"] = transaction_id;
			map["pjfs"] = jQuery("#pjfs").val();
			map["pjContent"] = jQuery("#pj_content").val();
			jQuery.ajaxSetup({async:false});
			jQuery.post(url,map,function(data){
				if(data.IS_SUCCESS=="IS_SUCCESS"){
					alert("评价成功！");
				}
			},'json');
			jQuery.ajaxSetup({async:true});
			alert("评价成功！");
		}
    }
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

function showDiv(divID){
	jQuery("#bsznDiv").css("display","none");
	jQuery("#bllcDiv").css("display","none");
	jQuery("#clxzDiv").css("display","none");
	jQuery("#zxpjDiv").css("display","none");
	jQuery("#"+divID+"").removeAttr("style");
}