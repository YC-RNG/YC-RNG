function post(url,param,callback){
	var xhr;
	try{
		 xhr=new XMLHttpRequest();
	}catch(e){
		xhr=new ActiveXObject("xxxxxx");
	}
	//xhr.onreadystatechange=callback;
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			callback(xhr.responseText);
		}
	}
	xhr.open("POST",url);//开启连接，第三个参数true异步 /false同步
	//如果是文件上传方式，请求不要设置Content-type,因为太复杂
	if(!(param instanceof FormData)){
		//POST提交数据的编码方式
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	}
	
	xhr.send(param);//发送请求参数 发送的请求参数
}