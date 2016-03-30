
//客户端密码校验
function validatepwd(pwd_arg, retype_arg, form) {
	var pwd = document.getElementById(pwd_arg).value;
	var retype = document.getElementById(retype_arg).value;
	var pwdFomat = /^[a-zA-Z0-9]+$/g;
	if (pwdFomat.test(pwd) == true && pwd == retype) {
		document.getElementById(form).submit();
		return;
	} else {
		return alert("retype password!");
	}

}
var xmlHttp;
function getXMLHttpRequest() {
	if (window.ActiveXObject) {
		return xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		return xmlHttp = new XMLHttpRequest();

	}
}
function checkUniqueLoginName(loginName_arg) {
	var xhr = getXMLHttpRequest();
	var loginName = document.getElementById(loginName_arg).value;
	var url = "/OneLibrary/checkUniqueLoginName?loginName=" + loginName;
	XHRequestByGet(url, xhr);
}
function XHRequestByGet(url, xhr) {
	xhr.open("GET", url, true);
	xhr.onreadystatechange = handleResult;
	xhr.send(null);
}
function handleResult() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var result = xmlHttp.responseText;
			if(result==1){
				document.getElementById("btn").disabled=true;
				document.getElementById("notification").innerHTML="This email has been registed";
			}
			else {
				document.getElementById("btn").disabled=false;
				document.getElementById("notification").innerHTML="";
			}
		}
	}
	
}
