<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String user_id = (String) request.getAttribute("user_id");
	String user_email = (String) request.getAttribute("user_email");
	String join_dt = (String) request.getAttribute("join_dt");
	String user_name = "이재훈";
	String user_mbti = "ENTP";
	String user_dept = "데이터분석과";
	
	String[] study_group = user_name.split("");
	int study_count = study_group.length;
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Spoilbroth_StudyGroup</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap"	rel="stylesheet">
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

<!-- profile -->
<link rel="stylesheet" href="/css/profile.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!-- profile -->

<!-- owl -->
<script src="/andrea-master/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">
<!-- owl -->


</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">
	
	<!-- 전체 페이지 START-->
	<div id="colorlib-page">
		<!-- START 왼쪽 NANI -->
		<%@ include file="/WEB-INF/view/sidebar.jsp"%>
		<!-- END 왼쪽 NANI -->

		<!-- START 상단 NANI -->
		<div class="padding" style="padding-bottom: 150px;"></div>
		<div class="sidebar-heading" style="text-align: center; position: fixed; top: 0; width: 100%; background-color: #fff; z-index: 5; padding-top: 20px;font-weight: 500;">
		My Study Page
			<hr style=" width: 90%; height: 1.5px; border: none; background-color: #666666;">
			<ul class="tagcloud">
				<a href="#" class="tag-cloud-link" style="font-size: 14px;">자유스터디</a>
				<a href="#" class="tag-cloud-link" style="font-size: 14px;">공모전</a>
				<a href="#" class="tag-cloud-link" style="font-size: 14px;">어학/회화</a>
				<a href="#" class="tag-cloud-link" style="font-size: 14px;">봉사활동</a>
				<a href="#" class="tag-cloud-link" style="font-size: 14px;">취업/면접</a>
				<a href="#" class="tag-cloud-link" style="font-size: 14px;">스포츠</a>
				<a href="#" class="tag-cloud-link" style="font-size: 14px;">여행</a>
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
						<div class="col-xl-8 px-md-5">
							<!-- My 프로필 메인화면 -->
							<div class="emp-profile">

								<!-- 사진 프로필 START -->
								<div class="d-flex">
									<div class="profile-card">
										<div class="d-flex align-items-center">
											<div class="image">
												<img src="/andrea-master/images/image_1.jpg" class="rounded"
													width="100%">
											</div>
										</div>
										<div class="button mt-2 d-flex flex-row align-items-center">
											<button class="btn btn-sm btn-primary w-100">Change
												My Gallery</button>
										</div>

									</div>

									<div class="profile-card"
										style="padding-left: 20px; padding-top: 20px;">
										<h5
											style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;letter-spacing: 13px;">
											<%=user_name%></h5>
										<h6
											style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
											<%=user_dept%></h6>
										<p class="mb-2"
											style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: #6c757d;">
											Join Study : <span><%=study_count%>/5</span>
										</p>
									</div>
								</div>
								<!-- 사진프로필  END -->


								<hr style="margin-top: 10px; margin-bottom: 0px;" />
								
								
								<!-- 사용자 정보 START-->
								<div class="row" style="font-size: 15px;">
									<div class="col-md-6">
										<div class="profile-head">
											<ul class="nav nav-tabs" id="myTab" role="tablist">
												<li class="nav-item"><a class="nav-link active"
													id="home-tab" data-toggle="tab" href="#home" role="tab"
													aria-controls="home" aria-selected="true">About</a></li>
												<li class="nav-item"><a class="nav-link"
													id="profile-tab" data-toggle="tab" href="#profile"
													role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
												</li>
											</ul>
										</div>
									</div>

								</div>
								<div class="row" style="font-size: 13px;">
									<div class="col-md-8">
										<div class="tab-content profile-tab" id="myTabContent">
											<div class="tab-pane fade show active" id="home"
												role="tabpanel" aria-labelledby="home-tab">
												<div class="row">
													<div class="col-6">
														<label>User Id</label>
													</div>
													<div class="col-6">
														<div style="margin-left: 20px; color:#0062cc;font-size: 15px;"><%=user_id%></div>
													</div>
												</div>

												<div class="row">
													<div class="col-6">
														<label>Email</label>
													</div>
													<div class="col-6">
														<div style="margin-left: 20px; color:#0062cc;font-size: 15px;" ><%=user_email%></div>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label>MBTI</label>
													</div>
													<div class="col-6">
														<div style="margin-left: 20px; color:#0062cc;font-size: 15px;"><%=user_mbti%></div>
													</div>
												</div>

											</div>

											<div class="tab-pane fade" id="profile" role="tabpanel"
												aria-labelledby="profile-tab">
												<div class="row">
													<div class="col-md-12">
														<label>Join Study Group List</label>
													</div>
												</div>

												<%
													for (int i = 0; i < study_count; i++) {
												%>
												<div class="row">
													<div style="margin-left: 20px; color:#0062cc;font-size: 15px;"><%=study_group[i]%></div>
												</div>
												<%
													}
												%>

											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 사용자 정보 END-->
							
							
							<!-- Join Study Group -->
							<!-- 슬라이드 -->
							<div class="slider-1">
								<label style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
								My 스터디
								</label>
								<div class="owl-carousel owl-theme">
									
									<!-- 가입한 스터디 리스트로 뿌려줌 -->
									<div class="item" style="coler:white">
										<div style="background-image: url(/andrea-master/images/image_1.jpg); height:300px;">
											<div class="txt-box">
											</div>
										</div>
										<div>
										<div style="font-size:20px">hi</div>
											<ul>
												<li>목록1</li>
												<li>목록1</li>
											</ul>
										</div>
									</div>
									
									<div class="item" style="coler:white">
										<div style="background-image: url(/andrea-master/images/image_2.jpg); height:300px;">
										</div>
										<div>
											<div style="font-size:20px">hi</div>
											<ul>
												<li>목록1</li>
												<li>목록1</li>
											</ul>
										</div>
									</div>
									

								</div>
							</div>
							<!-- 슬라이드 END-->
							
							<!-- Join Study Group -->
							<!-- 그룹목록 START -->
							<div class="row pt-md-4">
								<div class="col-md-12">
									<div
										class="blog-entry ftco-animate d-md-flex fadeInUp ftco-animated">
										<a href="single.html" class="img img-2"
											style="background-image: url(/andrea-master/images/image_3.jpg);"></a>
										<div class="text text-2 pl-md-4">
											<h3 class="mb-2">
												<a href="single.html">A Loving Heart is the Truest
													Wisdom</a>
											</h3>

											<div class="meta-wrap">
												<p class="meta">
													<span><i class="icon-calendar mr-2"></i>June 28,
														2019</span> <span><a href="single.html"><i
															class="icon-folder-o mr-2"></i>Travel</a></span> <span><i
														class="icon-comment2 mr-2"></i>5 Comment</span>
												</p>
											</div>
											<p class="mb-4">A small river named Duden flows by their
												place and supplies it with the necessary regelialia.</p>
											<p>
												<a href="#" class="btn-custom">Read More <span
													class="ion-ios-arrow-forward"></span></a>
											</p>
										</div>
									</div>
								</div>
							</div>
							<!-- 그룹목록 END -->
							
							왼쪽 스크립트 끝
						</div>

						<!-- 오른쪽 스크립트 -->
						<div
							class="col-xl-4 sidebar ftco-animate bg-light pt-5 fadeInUp ftco-animated">
							<div>오른쪽 스크립트 시작</div>


							<div class="sidebar-box ftco-animate">
								<h3 class="sidebar-heading">Archives</h3>
								<ul class="categories">
									<li><a href="#">Decob14 2018 <span>(10)</span></a></li>
									<li><a href="#">September 2018 <span>(6)</span></a></li>
									<li><a href="#">August 2018 <span>(8)</span></a></li>
									<li><a href="#">July 2018 <span>(2)</span></a></li>
									<li><a href="#">June 2018 <span>(7)</span></a></li>
									<li><a href="#">May 2018 <span>(5)</span></a></li>
								</ul>
							</div>

							<div class="sidebar-box ftco-animate">
								<h3 class="sidebar-heading">Paragraph</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Ducimus itaque, autem necessitatibus voluptate quod mollitia
									delectus aut.</p>
							</div>
							<div>오른쪽 스크립트 시작</div>
						</div>

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
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none" troke-width="4" stroke="#eeeeee"></circle>
			<circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"></circle></svg>
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
	$('.slider-1 > .owl-carousel')
			.owlCarousel(
					{
						autoplay : true, // 오토 플레이
						autoplayTimeout : 3000, // 오토 플레이 시에 다음 슬라이드로 넘어가는 주기, 2초
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