<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <title>查找</title>
 <style>
 body, ul, li { 
 margin:0; padding:0;}body {
  font-size:12px; font-family:sumsun, arial; background:#FFFFFF;
  }
  .gover_search { 
  position:relative; z-index:99; height:63px; padding:15px 0 0 20px; 
  border:1px solid #b8cfe6; border-bottom:0; 
  background:url(../images/gover_search_bg.gif) repeat-x 0 0;}
  .gover_search_form {
  height:36px;
  }
  .gover_search .search_t { float:left; width:112px; line-height:26px; color:#666;
  }
  .gover_search .input_search_key { float:left; 
  width:462px; height:18px;
   padding:3px;
    margin-right:5px;
     border:1px solid #ccc; 
     line-height:18px; background:#fff;
     }
     .gover_search .search_btn { 
     float:left; width:68px; height:26px;
      overflow:hidden; border:1px solid #ccc; 
      text-align:center; color:#ff3300; 
      letter-spacing:5px; 
      background:url(../images/gover_search_bg.gif) no-repeat 0 -79px;
       cursor:pointer;
        font-weight:bold;
      }
      .gover_search .search_suggest { 
      position:absolute; z-index:999;
       left:132px; top:41px; width:468px; 
       border:1px solid #ccc; 
       border-top:none; 
       display:none; 
       color:#004080;
       }
       .gover_search .search_suggest li {
        height:24px; 
        overflow:hidden;
         padding-left:3px;
          line-height:24px;
           background:#fff; cursor:default;
           }
           .gover_search .search_suggest li.hover {
           background:#ddd;
           }
           .num_right {
            float:right;
             text-align:right; 
             line-height:24px;
              padding-right:10px
              }</style></head>
              <body>
              <div class="gover_search"> 
              <div class="gover_search_form clearfix">   
              <span class="search_t">å³é®è¯æç´¢</span>  
              <input type="text" class="input_search_key" id="gover_search_key" placeholder="è¯·è¾å¥å³é®è¯ç´æ¥æç´¢" /> 
               <button type="submit" class="search_btn">æç´¢</button> 
                <div class="search_suggest" id="gov_search_suggest">   
              <ul>  
               </ul> 
               </div>
                </div>
               </div>
               <script type="text/javascript" src="js/jquery-1.8.3.js">
               </script>
               <script type="text/javascript"> 
              function oSearchSuggest(searchFuc){  var input = $('#gover_search_key'); 
              var suggestWrap = $('#gov_search_suggest'); 
              var key = ""; 
              var init = function(){  
            	  input.bind('keyup',sendKeyWord); 
              input.bind('blur',function(){setTimeout(hideSuggest,100);}) 
              }  
              var hideSuggest = function(){   suggestWrap.hide(); 
              }  //åéè¯·æ±ï¼æ ¹æ®å³é®å­å°åå°æ¥è¯¢ 
              var sendKeyWord = function(event){   //é®çéæ©ä¸æé¡¹   
            	  if(suggestWrap.css('display')=='block'&&event.keyCode == 38||event.keyCode == 40)  {    
            	  var current = suggestWrap.find('li.hover');   
            	  if(event.keyCode == 38)   {    
            		  if(current.length>0)    {  
            	  var prevLi = current.removeClass('hover').prev();     
            	  if(prevLi.length>0)     {     
            		  prevLi.addClass('hover');      
            		  input.val(prevLi.html());  
            		  }    
            	  }  
            		  else    {    
            			  var last = suggestWrap.find('li:last');    
            			  last.addClass('hover');     
              input.val(last.html());    
              } 
            		  }  
            	  else if(event.keyCode == 40)   {    
            			  if(current.length>0)    {   
            	  var nextLi = current.removeClass('hover').next();    
            	  if(nextLi.length>0)     {     
            		  nextLi.addClass('hover');      
            		  input.val(nextLi.html());    
            		  }   
            	  }  
              else    {   
            	  var first = suggestWrap.find('li:first');  
            	  first.addClass('hover');   
            	  input.val(first.html());   
            	  }  
              }    //è¾å¥å­ç¬¦
              } 
              else  {    var valText = $.trim(input.val());  
              if(valText ==''||valText==key)   {     
            	  return;   
            	  }   
              searchFuc(valText);   
              key = valText;  
              } 
              }  //è¯·æ±è¿ååï¼æ§è¡æ°æ®å±ç¤º 
              this.dataDisplay = function(data){ 
            	  if(data.length<=0)  {  
            		  suggestWrap.hide();  
            		  return;  
            		  }   //å¾æç´¢æ¡ä¸æå»ºè®®æ¾ç¤ºæ ä¸­æ·»å æ¡ç®å¹¶æ¾ç¤º   
            		  var li;  
            		  var tmpFrag = document.createDocumentFragment();   
            		  suggestWrap.find('ul').html(''); 
            		  for(var i=0; i<data.length; i++)  {  
            			  li = document.createElement('LI');  
            			  li.innerHTML = data[i];   
            			  tmpFrag.appendChild(li);  
            			  } 
            		  suggestWrap.find('ul').append(tmpFrag); 
            		  suggestWrap.show();   //ä¸ºä¸æéé¡¹ç»å®é¼ æ äºä»¶ 
            		  suggestWrap.find('li').hover(function(){  
            			  suggestWrap.find('li').removeClass('hover');  
            			  $(this).addClass('hover');  },
            			  function(){ 
            				  $(this).removeClass('hover');  
            				  })
            				  .bind('click',function(){ 
            					  $(this).find("span").remove();   
            					  input.val(this.innerHTML);   
            					  suggestWrap.hide();   }); 
            		  } 
              init();
              }; //å®ä¾åè¾å¥æç¤ºçJS,åæ°ä¸ºè¿è¡æ¥è¯¢æä½æ¶è¦è°ç¨çå½æ°å 
              var searchSuggest = new oSearchSuggest(sendKeyWordToBack); //è¿æ¯ä¸ä¸ªæ¨¡ä¼¼å½æ°ï¼å®ç°ååå°åéajaxæ¥è¯¢è¯·æ±ï¼å¹¶è¿åä¸ä¸ªæ¥è¯¢ç»ææ°æ®ï¼ä¼ éç»åå°çJS,åç±åå°JSæ¥å±ç¤ºæ°æ®ãæ¬å½æ°ç±ç¨åºåè¿è¡ä¿®æ¹å®ç°æ¥è¯¢çè¯·æ± //åæ°ä¸ºä¸ä¸ªå­ç¬¦ä¸²ï¼æ¯æç´¢è¾å¥æ¡ä¸­å½åçåå®¹ 
              function sendKeyWordToBack(keyword){
            	  var aData = [];  aData.push('<span class="num_right">çº¦100ä¸ª</span>'+keyword+''); 
            	  aData.push('<span class="num_right">çº¦200ä¸ª</span>'+keyword+'');  
            	  aData.push('<span class="num_right">çº¦100ä¸ª</span>'+keyword+''); 
            	  aData.push('<span class="num_right">çº¦50000ä¸ª</span>'+keyword+''); 
            	  aData.push('<span class="num_right">çº¦1044ä¸ª</span>'+keyword+''); 
            	  aData.push('<span class="num_right">çº¦100ä¸ª</span>'+keyword+'');  
            	  aData.push('<span class="num_right">çº¦100ä¸ª</span>'+keyword+'');  
                  aData.push('<span class="num_right">çº¦100ä¸ª</span>'+keyword+''); 
                  
//å°è¿åçæ°æ®ä¼ éç»å®ç°æç´¢è¾å¥æ¡çè¾å¥æç¤ºjsç±»  
         searchSuggest.dataDisplay(aData); 
} 
           
              </script>       
            <div id="content">
	
	
	<div id="select_product">
	
		<div id="select_img"><a href="ShowProDetailServlet?id=1"><img width="205" height="154" src="Picture/1.jpg"></a></div>
			<!-- <div id="select_about"><a class="a" href="ShowProDetailServlet?id=1">äººçè¥åªå¦åè§</a><br> 
			å®ä»·ï¼<span style="color:#FF6600;font-weight:bold;">ï¿¥24</span>å<br>
			å·²å®åºï¼<span style="font-weight:bold;">86</span>&nbsp;ç¬
			</div> -->		
	</div>	
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServlet?id=2"><img width="205" height="154" src="Picture/2.jpg"></a></div>
			<!-- <div id="select_about"><a class="a" href="ShowProDetailServletid=2">JSPåºç¨å¼åè¯¦è§£  </a><br> 
			å®ä»·ï¼<span style="color:#FF6600;font-weight:bold;">ï¿¥50</span>å<br>
			å·²å®åºï¼<span style="font-weight:bold;">275</span>&nbsp;ç¬
		</div>	 -->	
	</div>
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServlet?id=3"><img width="205" height="154" src="Picture/3.jpg"></a></div>
			<!-- <div id="select_about"><a class="a" href="item?id=3">è¡è²æµªæ¼«ï¼æ°ç</a><br> 
			å®ä»·ï¼<span style="color:#FF6600;font-weight:bold;">ï¿¥28</span>å<br>
			å·²å®åºï¼<span style="font-weight:bold;">279</span>&nbsp;ç¬
		</div>	 -->	
	</div>
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServletid=4"><img width="205" height="154" src="Picture/4.jpg"></a></div>
			<!-- <div id="select_about"><a class="a" href="ShowProDetailServlet?id=4">å¾·é²åæ¥å¿  </a><br> 
			å®ä»·ï¼<span style="color:#FF6600;font-weight:bold;">ï¿¥53</span>å<br>
			å·²å®åºï¼<span style="font-weight:bold;">119</span>&nbsp;ç¬
		</div>	 -->	
	</div>	
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServlet?id=5"><img width="205" height="154" src="Picture/5.jpg"></a></div>
			<!-- <div id="select_about"><a class="a" href="ShowProDetailServlet?id=5">JavaScript DOMç¼ç¨èºæ¯   </a><br> 
			å®ä»·ï¼<span style="color:#FF6600;font-weight:bold;">ï¿¥38</span>å<br>
			å·²å®åºï¼<span style="font-weight:bold;">429</span>&nbsp;ç¬
		</div>	 -->	
	</div>	
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServlet?id=6"><img width="205" height="154" src="Picture/6.jpg"></a></div>
			<!-- <div id="select_about"><a class="a" href="ShowProDetailServlet?id=6">ç½é¡µè®¾è®¡åºç¡:HTML,CSSåJavaScript </a><br> 
			å®ä»·ï¼<span style="color:#FF6600;font-weight:bold;">ï¿¥15</span>å<br>
			å·²å®åºï¼<span style="font-weight:bold;">86</span>&nbsp;ç¬
		</div> -->		
	</div>
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServlet?id=7"><img width="205" height="154" src="Picture/7.jpg"></a></div>
	</div>	
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServlet?id=8"><img width="205" height="154" src="Picture/8.jpg"></a></div>
	</div>
	<div id="select_product">
		<div id="select_img"><a href="ShowProDetailServlet?id=9"><img width="205" height="154" src="Picture/9.jpg"></a></div>
	</div>
</div>

              </body>
              </html>