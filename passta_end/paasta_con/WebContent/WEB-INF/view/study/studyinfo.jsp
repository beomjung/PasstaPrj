<%@page import="poly.util.DateUtil"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.StudyListDTO"%>
<%@page import="poly.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserDTO uDTO = (UserDTO) request.getAttribute("rDTO");
	String user_id = uDTO.getUser_id();
	String user_name = uDTO.getUser_name();
	String join_dt = DateUtil.getDateTime("yyyy-MM-dd-hh:mm:ss");
	String user_mbti = uDTO.getUser_mbti();
	String user_dept = uDTO.getUser_dept();

	StudyListDTO sDTO = (StudyListDTO) request.getAttribute("sDTO");
	String study_name = (String) request.getAttribute("study_name");
	String study_contents = CmmUtil.nvl(sDTO.getStudy_contents());
	String study_title = CmmUtil.nvl(sDTO.getStudy_title());
	String study_field = CmmUtil.nvl(sDTO.getStudy_field());
	
	int mbti_score = (int)request.getAttribute("mbti_score");
	
	String study_img = (String)request.getAttribute("study_img");
	
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Spoilbroth_StudyGroup</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="/andrea-master/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/andrea-master/css/animate.css">
<link rel="stylesheet" href="/andrea-master/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="/andrea-master/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/andrea-master/css/magnific-popup.css">
<link rel="stylesheet" href="/andrea-master/css/aos.css">
<link rel="stylesheet" href="/andrea-master/css/ionicons.min.css">
<link rel="stylesheet"
	href="/andrea-master/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/andrea-master/css/jquery.timepicker.css">
<link rel="stylesheet" href="/andrea-master/css/flaticon.css">
<link rel="stylesheet" href="/andrea-master/css/icomoon.css">
<link rel="stylesheet" href="/andrea-master/css/style.css">

<!-- profile -->
<link rel="stylesheet" href="/css/profile.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!-- profile -->

<!-- owl -->
<script src="/andrea-master/js/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/owlowl.css">
<!-- owl -->

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">

	<!-- 전체 페이지 START-->
	<div id="colorlib-page">
		<!-- START 왼쪽 NANI -->
		<%@ include file="/WEB-INF/view/sidebar.jsp"%>
		<!-- END 왼쪽 NANI -->

		<!-- START 상단 NANI -->
		<div class="padding" style="padding-bottom: 105px;"></div>
		<div class="sidebar-heading"
			style="text-align: center; position: fixed; top: 0; width: 100%; height: 130px; background-color: #fff; z-index: 5; padding-top: 20px; font-weight: 500; color: black;">
			<div class="hh" style="font-size: 23px; height: 32px;">
				<span>S</span><span>T</span><span>U</span><span>D</span><span>Y</span><span>&nbsp;</span><span>M</span><span>A</span><span>T</span><span>C</span><span>H</span><span>I</span><span>N</span><span>G</span>
			</div>
			<hr
				style="width: 90%; height: 1.5px; border: none; background-color: #666666;">
			<ul class="tagcloud"
				style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
				<a href="/study/match.do" class="tag-cloud-link"
					style="font-size: 17px; border-width: 1.5px; border-color: #ff0050; float: left; margin-left: 20px;">이전</a>
			</ul>
		</div>
		<!-- END 상단 NANI -->

		<!-- 메인 페이지 START-->
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">

					<!-- 왼쪽 오른쪽 2분할 -->
					<div class="row d-flex">

						<!-- 왼쪽 스크립트 -->
						<div class="col-xl-8 px-md-5" style="background-color: #f7fbff;">
							<!-- 스터디 가입  START -->
							<div class="emp-profile">
								<label
									style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
									<%=study_name%> 팀 의 스터디 </label>
								<!-- 사진 프로필 START -->
								<div class="d-flex card m-2 p-3">

									<div class="d-flex align-items-center">
										<div class="image">
											<img src="<%=study_img%>" class="rounded"
												width="100%">
										</div>
									</div>
									<hr>
									<div style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; 
										font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px; font-size:25px;">
										<div class="profile-card col-12" style="padding-right:3px; padding-left:3px;">
										팀원 MBTI 분석 : <% for(int k=0; k<mbti_score; k++) {%>
										<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="22" height="22"
											 viewBox="0 0 422.448 422.448" style="enable-background:new 0 0 422.448 422.448;" xml:space="preserve">
										<path style="fill:#FF4979;" d="M387.15,59.153c-47.066-47.065-123.374-47.065-170.44,0l-4,4l-4-4
											C163.342,10.448,87.081,7.742,38.376,53.109s-51.412,121.628-6.044,170.334c1.885,2.023,3.839,3.981,5.858,5.871l170.8,170.8
											c2.018,1.981,5.217,2.085,7.36,0.24l170.8-170.8c47.065-47.066,47.065-123.374,0-170.44L387.15,59.153z"/>
										</svg>
										
										<%} %>
										</div>
										<label
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											스터디 분야</label>
										<div class="form-group">
											<div class="form-control" style="font-size: 25px;">
											<%=study_field %></div>
										</div>
										<div class="form-group">
											<div class="form-control" style="font-size: 25px;">
											<%=study_title %></div>
										</div>
										<div class="form-group">
											<textarea id="" cols="20" rows="7" class="form-control"
												name="study_msg"
												style="font-size: 20px;" readonly><%=study_contents%></textarea>
										</div>
										<div class="form-group text-center"
											style="font-size: 24px; margin-bottom: 0px;">
											<button type="button" class="btn btn-success py-2 px-3"
												style="border-radius: 10px; font-size: 20px;"
												onclick="location.href='/study/studysignup.do?study_name=<%=study_name %>' ">Sign up</button>
										</div>
										<p class="mb-3"
											style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: #6c757d; float: right;">
											By Creator :  <span><%=user_name%></span>
										</p>
									</div>
								</div>
								<!-- 스터디 가입  END -->

								<hr style="margin-top: 10px; margin-bottom: 0px;" />

							</div>
						</div>
						<!-- 왼쪽 스크립트 끝 -->
						</div>
					</div>
			</section>
		</div>
		<!-- 메인 페이지 END-->
	</div>
	<!-- 전체 페이지 END-->

	<!-- loader -->
	<div id="ftco-loader" class="fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				troke-width="4" stroke="#eeeeee"></circle>
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"></circle></svg>
	</div>

	<script src="/andrea-master/js/jquery.min.js"></script>
	<script src="/andrea-master/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/andrea-master/js/popper.min.js"></script>
	<script src="/andrea-master/js/bootstrap.min.js"></script>
	<script src="/andrea-master/js/jquery.easing.1.3.js"></script>
	<script src="/andrea-master/js/jquery.waypoints.min.js"></script>
	<script src="/andrea-master/js/jquery.stellar.min.js"></script>
	<script src="/andrea-master/js/owl.carousel.min.js"></script>
	<script src="/andrea-master/js/jquery.magnific-popup.min.js"></script>
	<script src="/andrea-master/js/aos.js"></script>
	<script src="/andrea-master/js/jquery.animateNumber.min.js"></script>
	<script src="/andrea-master/js/scrollax.min.js"></script>
	<script src="/andrea-master/js/main.js"></script>
</body>
<script type="text/javascript">
	$('.slider-1 > .owl-carousel').owlCarousel({
		autoplay : true, // 오토 플레이
		autoplayTimeout : 6000, // 오토 플레이 시에 다음 슬라이드로 넘어가는 주기, 2초
		loop : true,
		margin : 0,
		nav : true,
		navText : [],
		responsive : {
			0 : {
				items : 1
			}
		}
	});

	var $firstDot = $('.slider-1 > .owl-carousel > .owl-dots > .owl-dot.active');

	$firstDot.removeClass('active');

	setTimeout(function() {
		$firstDot.addClass('active');
	}, 100);
</script>
</html>