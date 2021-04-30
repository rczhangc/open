function getUrl() {     
	var urlPath = "/wsa";
	if (window.location.protocol == 'http:') {  
		url = 'ws://127.0.0.1:9999' + urlPath;
	} else {  
		url = 'wss://127.0.0.1:9999' + urlPath;
	}   
	return url;
} 

function disconnect(ws) {  
    if (ws != null) {  
        ws.close();  
        ws = null;  
    }  
}  

function replace_em(str){
	str = str.replace(/\[em_([0-9]*)\]/g,'<img src="../../img/arclist/$1.gif" border="0" />');
	return str;
}

function connect(ws) { 
    ws.onopen = function () {  
    	$("#ChatContent").append("<small>连接成功。。。</small><br>");
    };  
    ws.onmessage = function (event) {
    	if(typeof(event.data)=="string"){  
	    	var dataAll = event.data;
	    	var jsonData = JSON.parse(dataAll); 
	    	console.log(jsonData);
	    	var msgType = jsonData.messageType;
	    	if(msgType == "0000"){
	    		$("#ChatContent").append("<strong>系统消息：</strong>" + jsonData.message + "<br>");
	    	}else{
	    		var data = jsonData.message;
		    	var userId = jsonData.fromUserName;
		    	var msg = jsonData.message;
		    	var result = replace_em(msg);
		    	if(document.getElementById(userId)){
		    		document.getElementById(userId).setAttribute('src', './img/msgget.gif');
			    	var number = $("#ChatContent").scrollTop();
		    		//var number = $("#ChatContent").height();
			    	number += 15;
			    	$("#ChatContent").scrollTop(number);
			    	$("#ChatContent").append("<strong>"+userId+" ：</strong>" + result + "<br>");
		    	}else{
		    		var content = "<img src=\"./img/msgget.gif\" id=\""
						+ userId
						+ "\" alt=\"\" style=\"cursor: pointer\" width='40px' "
						+ "onclick=\"ChatNew()\" />"
						+ userId
						+ "<br><br>";
			    	$("#content").append(content);
			    	$("#ChatContent").append("<strong>"+userId+" ：</strong>" + result + "<br>");
		    	}
		    	
	    	}
	    }else{  
    	  var reader = new FileReader();  
    	  reader.onload = function(event){  
    	       if(event.target.readyState == FileReader.DONE){  
    	            var url = event.target.result;  
    	            if (imgName != msgUser){
    	            	$("#ChatContent").append("<p align=\"right\"><strong>"+imgName+" ：</strong>"+"<img src = "+url+" width='100px'/></p><br>");  
    	       		}else{
    	            	$("#ChatContent").append("<strong>"+imgName+" ：</strong>"+"<img src = "+url+" width='100px'/><br>");  
    	       		}
    	            if (fileImgSize != 0){
    	            	fileImgSize = fileImgSize - 1;
    	            }else{
    	            	imgName = msgUser;
    	            }
    	       }
    	   }  
	      reader.readAsDataURL(event.data);  
	    }  
    };  
    ws.onclose = function (event) {  
        //alert('网络连接失败！');  
    };  
} 
 