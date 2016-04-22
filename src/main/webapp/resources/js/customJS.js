
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

function getCurrentUser() {
	$.ajax({
		type : "get",
		url : "getCurrentUser",
		dataType : "json",
		success : function(user) {
			$("#name").html(user.name);
			$("#email").html(user.loginName);
			$("#id").html(user.id);
			$("#regTime").html(user.registTime);
		}
	});
}
function showBooks() {
	$.ajax({
		type : "get",
		url : "showBooks",
		dataType : "json",
		success : function(books) {
		var book;
		for(var i = 0 ; i < books.length; i++){
			book = '<div class="col-xs-5 col-md-2" ><div class="thumbnail"><img src="resources/images/cover/' + books[i].cover+'"' + '><div class="caption"><h4>'+ books[i].name +'</h4><input type="hidden" value="'+ books[i].id+'"><p>'+ books[i].author+'</p><p><a href="#" class="btn btn-default btn-sm" role="button" onclick="getBook()">get it</a> <a href="#" class="btn btn-default btn-sm" role="button">view details</a></p></div></div></div>'
			$("#panel").append(book);
		}
		}
	});
}

function currentUserBooks() {

	$.ajax({
				type : "get",
				url : "currentUserBooks",
				dataType : "json",
				success : function(bookList) {

					var cover;
					var cover_location;
					for (var i = 0; i < bookList.length; i++) {
						cover = bookList[i].cover;
						cover_location = '<ul class="nav nav-list"><li><div class="col-md-3" ><div class="thumbnail"><img  src="resources/images/cover/'+ cover+'"'+'></div></div></li></ul>'
						$("#sidebarInner").append(cover_location);
					}
				}
			});
}

function getBook() {
	var target = event.srcElement.parentNode.parentNode.children;
	var bookId = target[1].value;
	$.ajax({
		type : "get",
		url : "getBook?id=" + bookId,
		dataType : "text",
		success : function(data) {
			if (data == "0")
				alert("Sorry,you already have this book !");
			if (data == "1") {
				$("#sidebarInner").empty();
				currentUserBooks();
			}
		}
	});

}



