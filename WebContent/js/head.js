/**
 * 点击登录显示登录文本框
 * @return
 */	
function show(){
	jQuery('#hidden_login').fadeIn(500);
}

function hide(){
	jQuery('#hidden_login').fadeOut(500);
}

function login(){
	var yhm = jQuery("#yhm").val();
	var mm = jQuery("#mm").val();
	if(yhm==null || yhm==''){
	  	alert('请输入用户名！');
	  	return false;
	}
	if(mm==null || mm==''){
	  	alert('请输入密码！');
	  	return false;
	}
	submitForm('../web/login_login.html');
}

function ssoLogin(contextPath,vpnUrl,casUrl,ywxtservername){
//	jQuery.post('index_sendGET.html', {url : casUrl}, function(data) {
//		if (data != null && data.length > 0) {
//			if(data == 'right'){
//				window.location.href = casUrl+"/login?service=http://"+ywxtservername+contextPath+"/web/index_indexC.html";
//			}else{
//				window.location.href = vpnUrl;
//			}
//		}
//	}, 'json');
	
	var p = new Ping();
 
	p.ping(casUrl+"/login", function(data) {
		if(parseInt(data) < parseInt('1000')){
			window.location.href = casUrl+"/login?service=http://"+ywxtservername+contextPath+"/web/index_indexC.html";
		}else{
			window.location.href = vpnUrl;
		}
	});
}

function keyPressLogin(evt){
	if(evt.keyCode==13) {
		login();
	}
}

function enterSubmit(){
	var event=arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异
    if (event.keyCode == 13){
    	login();
    }
}

function enterSubmitSx(){
	var event=arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异
    if (event.keyCode == 13){
    	querySx();
    }
}

function querySx(){
	var transaction_name = jQuery("#transaction_name_input").val();
	var url = "../web/module_business.html?transaction_name="+transaction_name;
	window.location.href = url;
}

//事项名称搜索（回车）
function enterDown(){
	document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){ // enter
        	//$('#transaction_name').val(($('#transaction_name')[0].value).trim());
        }
    }; 
}


//表单
function aa(cdlj, str, obj){
	if(cdlj.indexOf("target=blank") > 0){
		cdlj = cdlj.substr(0,cdlj.indexOf("?target=blank"));
		window.open(cdlj);
	}else{
		var map = {};
		map["queryModel.showCount"]  = 10;  		  //每页记录数
		map["queryModel.currentPage"]= 1;
		jQuery("#rightHtml").html("<table style='width:100%;height:100%;'><tr valign=middle align=center><td><img src='../images/ico_load.gif'/></td></tr></table>");
		jQuery("#rightHtml").load(cdlj,map, function() {
			jQuery("#rightHtml").fadeIn("slow");
		});
	}
	/*class选中*/
	if(obj != null && obj != ""){
		$(".pf-nav a").removeClass("active");
		$(obj).addClass("active");
	}
}