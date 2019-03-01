//判断操作系统和浏览器类型，需要判断的页面加上detectOS()；
function detectOS() { 
	var sUserAgent = navigator.userAgent; 
	var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");
	
	if (isWin) { 
		var isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1 || sUserAgent.indexOf("Windows 2000") > -1; 
		var isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1 || sUserAgent.indexOf("Windows XP") > -1; 
		var isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1 || sUserAgent.indexOf("Windows 2003") > -1; 
		var isWinVista= sUserAgent.indexOf("Windows NT 6.0") > -1 || sUserAgent.indexOf("Windows Vista") > -1; 
		var isWin7 = sUserAgent.indexOf("Windows NT 6.1") > -1 || sUserAgent.indexOf("Windows 7") > -1; 
		
		if(navigator.userAgent.indexOf("MSIE 6.0")>0 || navigator.userAgent.indexOf("MSIE 7.0")>0){ //IE6.0和IE7.0
			window.location.href = "../web/index_browser.html?link=" + encodeURIComponent(location.href);
		}
	}
}


//移除提示代码
function removeerror(text){
	$(".tips_top").animate({top:"-35px"},function(){$(".tips_top").remove()});
}

detectOS();