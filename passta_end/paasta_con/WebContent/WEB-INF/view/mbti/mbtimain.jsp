<%@page import="poly.dto.MbtiDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserDTO uDTO = (UserDTO)request.getAttribute("rDTO");
	MbtiDTO mDTO = (MbtiDTO)request.getAttribute("mDTO");
	String user_id = CmmUtil.nvl(uDTO.getUser_id());
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Spoilbroth_StudyGroup</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">

<link rel="stylesheet" href="/andrea-master/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/andrea-master/css/animate.css">
<link rel="stylesheet" href="/andrea-master/css/owl.carousel.min.css">
<link rel="stylesheet" href="/andrea-master/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/andrea-master/css/magnific-popup.css">
<link rel="stylesheet" href="/andrea-master/css/aos.css">
<link rel="stylesheet" href="/andrea-master/css/ionicons.min.css">
<link rel="stylesheet" href="/andrea-master/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/andrea-master/css/jquery.timepicker.css">
<link rel="stylesheet" href="/andrea-master/css/flaticon.css">
<link rel="stylesheet" href="/andrea-master/css/icomoon.css">
<link rel="stylesheet" href="/andrea-master/css/style.css">



</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">

	<div id="colorlib-page">
		<!-- START 왼쪽 NANI -->
		<%@ include file="/WEB-INF/view/sidebar.jsp"%>
		<!-- END 왼쪽 NANI -->
		
		<!-- START 상단 NANI -->
		<div class="padding" style="padding-bottom: 70px;"></div>
		<div class="sidebar-heading" style="text-align: center; position: fixed; top: 0; width: 100%; height:70px; background-color: #fff; z-index: 5; padding-top: 20px;font-weight: 500; color: black;">
			<div class="hh" style="font-size: 23px;height: 32px;">
			<span>M</span><span>B</span><span>T</span><span>I</span><span>&nbsp;</span><span>A</span><span>N</span><span>A</span><span>L</span><span>Y</span><span>S</span><span>I</span><span>S</span>
			</div>
			<hr style=" width: 90%; height: 1.5px; border: none; background-color: #666666;">
		</div>
		<!-- END 상단 NANI -->
		
		<div id="colorlib-main">
			<div class="container">
				<section class="ftco-section ftco-no-pt ftco-no-pb">

					<!-- 왼쪽 오른쪽 2분할 -->
					<div class="row d-flex">
						<!-- 왼쪽 스크립트 -->
						<div class="col-xl-8 py-4 px-md-5" style="background-color: #f7fbff;">
							

							<button type="button" class="btn btn-outline-warning active" onclick="location.href='/mbti/mbtimain.do'" style="border-radius: 5px;">My MBTI</button>
							<span style="padding-left: 50px;"></span>
							<button type="button" class="btn btn-outline-warning" onclick="location.href='/mbti/mbtianalysis.do'" style="border-radius: 5px;">MBTI Analysis</button>
							<hr>
							<div style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 32px;">
							My MBTI</div>
							
							<div class="row p-2">
									<%if(mDTO.getMbti_name()==null){ %>
										<div class="card p-l-55 p-r-55 p-t-65 p-b-54 shadowbox col-12" 
											style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 20px; margin-bottom: 0px;">
											<div style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 20px;">
											아직 측정이 되어있지 않습니다.</div>
										</div>
									<% }else{ %>
										<div class="card p-l-55 p-r-55 p-t-65 p-b-54 shadowbox col-6" 
											style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 20px; margin-bottom: 0px;">
										<strong style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 30px;">
										<%=mDTO.getMbti_name() %></strong>
										<div style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 20px;">
										<%=mDTO.getMbti_content() %></div>
										</div>
										<div class="card p-l-55 p-r-55 p-t-65 p-b-54 shadowbox col-6" style="border:none; border-radius: 7px;-moz-border-radius: 7px;
											-khtml-border-radius: 7px;-webkit-border-radius: 7px; padding-left:0px;padding-right:0px; width:100%; margin-bottom: 0px;">
											<img src="<%=mDTO.getMbti_img_path() %>" width="100%" height="202" alt="등록된 사진이 없습니다." style="border:none; border-radius: 7px;">
										</div>	
									<% } %>
								</div>
							
							</div>
							<div class="row p-2">
								<div class="card p-l-55 p-r-55 p-t-65 p-b-54 shadowbox col-12" 
								style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 20px;">
								
									<div class="mb-3 mt-2">
										<img src="/andrea-master/images/mbtiex00.png" alt="등록된 사진이 없습니다." style="border:none; border-radius: 7px; width:100%">
										<p style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 22px;">
										MBTI 검사는 전세계에서 가장 유명한 성격유형검사 중 하나로, 인간의 성격을 4가지 척도로 분류한 성격유형검사입니다.
										두 개의 태도지표(외향-내향, 판단-인식)와 두 개의 기능지표(감각-직관, 사고-감정)에 대한 
										개인의 선호도를 밝혀서 4가지 척도에서 바라본 개인의 성격유형을 알려줍니다.
										</p>
										
										<img src="/andrea-master/images/mbticon01.jpg" width="100%" height="210" alt="등록된 사진이 없습니다." style="border:none; border-radius: 7px;">
									</div>
									
									<button type="button" class="btn btn-success mb-2" style="font-size:20px;border-radius: 10px;" onclick="location.href='/mbti/mbtianalysis.do' ">Start</button>
							
								</div>
								<div style="text-align: center; width:100%;" class="mb-3">
								<p style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 22px; color:orangered;">
								※자신의 MBTI를 12문제로 간단히 테스트하고 <br>나와 잘맞는 성격의 팀원과 스터디그룹을 찾아봅시다!<br>
								꾸미지 않고 솔직한 답변을 부탁드립니다.</p>
								</div>
							</div>
							
						
					</div>
				</div>
			</section>
		</div>
	</div>
	<!-- END COLORLIB-PAGE -->

	<!-- loader -->
	<div id="ftco-loader" class="fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee"></circle>
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"></circle></svg>
	</div>
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
<script>

</script>
</html>