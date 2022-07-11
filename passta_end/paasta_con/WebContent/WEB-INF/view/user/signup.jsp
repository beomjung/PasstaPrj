<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String email = CmmUtil.nvl((String)request.getAttribute("email"));
	String nickname = CmmUtil.nvl((String)request.getAttribute("nickname"));

%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>SignUp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="/login/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/login/css/util.css">
<link rel="stylesheet" type="text/css" href="/login/css/main.css">
<!--===============================================================================================-->
<style>
.container-login100:before {
	content: "";
	background: url(/login/images/desk20.jpg);
	padding-bottom: 20px;
	background-size: cover;
	opacity: 0.8;
	position: absolute;
	top: 0px;
	left: 0px;
	right: 0px;
	bottom: 0px;
}
</style>

<script type="text/javascript">

	// 회원가입 정보의 유효성 체크하기
	function doRegUserCheck(f){
		
		if(f.user_id.value==""){
			alert("아이디를 입력하세요.");
			f.user_id.focus();
			return false;
		}
		
		if(f.user_email.value==""){
			alert("이메일을 입력하세요.");
			f.user_email.focus();
			return false;
		}
		
		if(f.user_pwd.value==""){
			alert("비밀번호를 입력하세요.");
			f.user_pwd.focus();
			return false;
		}
		
		if(f.user_dept.value==""){
			alert("소속학과를 입력하세요.");
			f.user_dept.focus();
			return false;
		}
		
		if(f.user_age.value==""){
			alert("나이를 입력하세요.");
			f.user_age.focus();
			return false;
		}
		
	}

</script>
</head>
<body>

	<div class="limiter">
		<div class="container-login100 p-b-20" style="padding-bottom: 20px;">
			<div class="wrap-login100">
				<div class="login100-form"
					style="font-size: 30px; color: darkcyan; padding-bottom: 30px;">
					Sign Up</div>

				<form class="login100-form validate-form" method="post"
					action="/user/inserUserInfo.do"
					onsubmit="return doRegUserCheck(this)"
					style="padding-top: 30px; padding-bottom: 30px;">

					<div class="wrap-input100 validate-input m-b-20"
						data-validate="UserId is required">
						<span class="label-input100">아이디</span> <input class="input100"
							type="text" name="user_id" id="user_id"
							placeholder="Enter userId"> <span class="focus-input100"></span>
					</div>
					<div class="msg m-b-15"></div>

					<div class="wrap-input100 validate-input m-b-20"
						data-validate="UserName is required">
						<span class="label-input100">이름</span> <input class="input100"
							type="text" name="user_name" id="user_name"
							placeholder="Enter userName" value="<%=nickname %>"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-20"
						data-validate="Useremail is required">
						<span class="label-input100">이메일</span> <input class="input100"
							type="email" name="user_email" id="user_email"
							placeholder="Enter useremail" value="<%=email %>"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18"
						data-validate="Password is required">
						<span class="label-input100">비밀번호</span> <input class="input100"
							type="password" name="user_pwd" id="newPassWord"
							placeholder="Enter password"> <span
							class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-18"
						data-validate="Password is required">
						<span class="label-input100">비밀번호 확인</span> <input
							class="input100" type="password" name="user_pwd2"
							id="passWordCheck" placeholder="your Password Check"> <span
							class="focus-input100"></span>
					</div>
					<div class="renew m-b-15"></div>

					<div class="wrap-input100 m-b-20"
						data-validate="userdept is required">
						<span class="label-input100">관심분야</span> <select
							class="form-control" style="width: 100%" name="user_dept">
							<option value="IT개발" selected>IT개발</option>
							<option value="공모전">공모전</option>
							<option value="어학/회화">어학/회화</option>
							<option value="봉사활동">봉사활동</option>
							<option value="취업/면접">취업/면접</option>
							<option value="스포츠">스포츠</option>
							<option value="여행">여행</option>
						</select>
					</div>

					<div class="wrap-input100 validate-input m-b-18"
						data-validate="age is required">
						<span class="label-input100">나이</span> <input class="input100"
							name="user_age" id="user_age" type="number" min='18' max='40'
							step='1'> <span class="focus-input100"></span>
					</div>

					<div class="padding" style="padding-bottom: 50px;"></div>



					<div class="container-login100-form-btn" style="padding-top: 20px;">
						<button type="submit" class="login100-form-btn"
							style="margin: auto; z-index: 5;">Register</button>
					</div>

				</form>
			</div>
		</div>
	</div>


	<!--===============================================================================================-->
	<script src="/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/bootstrap/js/popper.js"></script>
	<script src="/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/daterangepicker/moment.min.js"></script>
	<script src="/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="/login/js/main.js"></script>

</body>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
	$(document).ready(function(){
			swal ( "간편 회원가입을 진행합니다." )   ;
	    	// alert("간편 회원가입을 진행합니다.");
	});
	
	$('#passWordCheck').on('keyup', function(){
			
				var pw = document.getElementById("newPassWord").value; //비밀번호
				var pw2 = document.getElementById("passWordCheck").value; // 확인 비밀번호
				
		if (pw != '' && pw2 == '') {
			null;
		} else if (pw != "" || pw2 != "") {
			if (pw == pw2) {
				$(".renew").text("비밀번호가 일치합니다.");
				$(".renew").css("color", "#00f");
				newPwd = 'Y';
			} else {
				$(".renew").text("비밀번호가 일치하지 않습니다.");
				$(".renew").css("color", "#f00");
				newPwd = 'N';
			}
		}
	})
	var doCheck = 'N'
	
	$('#user_id').on('keyup', function(){
		var query = {
			userId : $("#user_id").val()
		};
		$.ajax({
			url : "/user/idCheck.do",
			type : "post",
			data : query,
			success : function(data) {
				if (data == 1) {
					$(".msg").text("사용하고 있는 아이디입니다.");
					$(".msg").attr("style", "color:#f00");
					doCheck = 'N'
				} else {
					$(".msg").text("사용 가능한 아이디입니다.");
					$(".msg").attr("style", "color:#00f");
					//$('#userId').attr("disabled", true);
					doCheck = 'Y'
				}
			}
		}); // ajax 끝
	});
	function check() {
		if (doCheck == 'N') {
			alert("사용중인 아이디입니다.")
			return false;
		}
	}
	
	</script>


</html>