<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
.sendNumber{
	padding: 3px 10px 3px 10px; 
	border-radius: 20px; 
	background-color: #289B14; 
	color: white; 
	font-family: 'Nanum Gothic', sans-serif; 
	font-weight: 400; 
	font-size: 12px; 
	display: inline;
	float: right;
}
</style>

<script type="text/javascript">
	//체크 버튼에 따라 아이디/비밀번호 기능이 달라진다
	function search_check(num) {
		if (num == '1') {
			document.getElementById("searchP").style.display = "none";
			document.getElementById("searchI").style.display = "";
		} else {
			document.getElementById("searchI").style.display = "none";
			document.getElementById("searchP").style.display = "";
		}
	}
</script>
</head>
<body>
	<div class="limiter">
		<div class="container-login100 p-b-20" style="padding-bottom: 20px;">
			<div class="wrap-login100">
			<div class="login100-form"
                 style="font-size: 30px; color: darkcyan; display: block; padding:43px 30px; text-align: center; font-family: 'Nanum Gothic', sans-serif; font-weight: 400;">
                비밀번호 찾기</div>
				<!-- <div class="login100-form"
					style="font-size: 30px; color: darkcyan; display: block; padding: 43px 30px; text-align: center;">
					아</div> -->
				<%-- 	<%@ include file="userIdSearchModal.jsp" %> --%>
				<div class="full">
					<div class="container">
						<div class="area_inputs wow fadeIn">
							<!-- <div style="margin-bottom: 10px;" class="custom-control custom-radio custom-control-inline">
								<button type="button" class="btn btn-outline-warning active" onclick="search_check(1)" style="border-radius: 5px;">아이디 찾기</button>
							</div>
							<div class="custom-control custom-radio custom-control-inline">
							<span style="border-radius: 5px;"></span>
								<button type="button" class="btn btn-outline-warning active" onclick="search_check(2)" style=" border-radius: 5px;">비밀번호 찾기</button>
							</div> -->
							<!-- <div data-role="tabs">
							<div data-role="navbar">
								<ul>
									<li><a href="#tab1">아이디 찾기</a></li>
									<li><a href="#tab2">비밀번호 찾기</a></li>
								</ul>
							</div> -->
							<form class="login100-form validate-form" method="post" action="/user/findPwProc.do" onsubmit="return doRegUserCheck(this)">
								<div class="wrap-input100 validate-input m-b-20">
									<span class="label-input100">ID</span>
										<input class="input100" type="text" name="user_id" id="user_id" placeholder="Enter userId">
                    				<span class="focus-input100"></span>
								</div>
								<div class="wrap-input100 validate-input m-b-20" style="margin-bottom: 10px">
									<span class="label-input100">Email</span>
									<input class="input100" type="email" name="user_email"
											id="user_email" placeholder="Enter useremail" style="display: inline;">
								</div>
			
								<div class="container-login100-form-btn" style="display: block; padding-top: 30px;">
									<button class="login100-form-btn" style="margin: auto;" onclick="location.href='/user/findPwProc.do'">임시비밀번호받기</button>
								</div>
								
							</form>
							</div>
						</div>
						</div>
					</div>
				</div>
			</div>