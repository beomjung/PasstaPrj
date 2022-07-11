<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="/login/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100" style="padding-top: 50px;">
				<div class="login100-form-title" style="background-image: url(/login/images/desk20.jpg);">
					<span class="login100-form-title-1">
						Spoilbroth
					</span>
				</div>

				<form class="login100-form validate-form" action="/user/loginProc.do" method="post" style="padding: 35px 15px 35px 15px;">
					<div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
						<span class="label-input100">ID</span>
						<input class="input100" type="text" name="user_id" placeholder="Enter userid">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="user_pwd" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								ID기억하기
							</label>
						</div>

						<div>
								<a href="/user/findId.do" class="txt1">ID찾기</a><a href="#">&nbsp;/&nbsp; </a><a href="/user/findPw.do" class="txt1">PASSWORD찾기</a>
						</div>
					</div>
					
					<div class="container-login100-form-btn" style="padding-top: 20px;">
						<button class="login100-form-btn" style="margin: auto;">
							Login
						</button>
					</div>
					
					<div class="container-login100-form-btn" style="padding-top: 10px; ">
						<button onclick="location.href='/user/signup.do'" class="login100-form-btn" style="margin: auto; background-color: #565c568c;">
							Sign up
						</button>
					</div>
					<!-- 페이스 로그인 -->
					<div class="container-login100-form-btn" style="padding-top: 10px;">
						<button onclick="location.href='/face/facelogin.do'" class="login100-form-btn" style="margin: auto; background-color: blueviolet;">
							Face Login
						</button>
					</div>
					
					<!-- 카카오톡 로그인 -->
					<div class="form-group row" id="kakaologin" style="padding-top: 10px;display: block;margin: auto;text-align: center;">
						<div class="kakaobtn">
							<input type="hidden" name="kakaoemail" id="kakaoemail" />
							<input type="hidden" name="kakaoname" id="kakaoname" />
							<input type="hidden" name="kakaobirth" id="kakaobirth" />
								<a href="https://kauth.kakao.com/oauth/authorize?client_id=d953100edaca490adae7d0fde386bac5&
								redirect_uri=http://spoilbroth.toast.paas-ta.com/kakaoLogin.do&&response_type=code"> 
									<img src="/login/images/kakao_login.png" />
								</a>
						</div>
					</div>
					
				</form>
				
			</div>
		</div>
	</div>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
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
</html>