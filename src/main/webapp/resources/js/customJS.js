/**
 * 
 */

//客户端密码校验
function validatepwd(pwd_arg,retype_arg,form){
	var pwd=document.getElementById(pwd_arg).value;
	var retype=document.getElementById(retype_arg).value;
	var pwdFomat=/^[a-zA-Z0-9]+$/g;
	if(pwdFomat.test(pwd)==true&&pwd==retype){
		document.getElementById(form).submit();
		return;
	}
	else{
		return alert("retype password!");
	}
	
}