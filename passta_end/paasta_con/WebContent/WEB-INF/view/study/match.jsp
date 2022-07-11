<%@page import="poly.dto.StudyListDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String user_id = (String) request.getAttribute("user_id");
	String user_name = (String) request.getAttribute("user_name");
	String user_email = (String) request.getAttribute("user_email");
	String user_mbti = (String) request.getAttribute("user_mbti");
	String user_dept = (String) request.getAttribute("user_dept");
	String user_study = (String) request.getAttribute("user_study");
	
	List<StudyListDTO> pList = (List<StudyListDTO>)request.getAttribute("pList");
	int count = pList.size();
	List<String> mbti_scores = (List<String>)request.getAttribute("mbti_scores");
	List<String> iList = (List<String>)request.getAttribute("iList");
	
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Spoilbroth_StudyGroup</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no">

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

<style type="text/css">

#box { position: relative; top: 50%; text-align: center; margin-top: -25px; }
#box [class^="hex-icon"] { vertical-align: top; }

[class^="hex-icon"] { width: 42px; height: 50px; margin: 0 10px; display: inline-block; transition: all 0.2s cubic-bezier(0.215, 0.610, 0.355, 1.000); -webkit-transition: all 0.2s cubic-bezier(0.215, 0.610, 0.355, 1.000); }
[class^="hex-icon"]:hover { transform: scale3d(1.2, 1.2, 1); -webkit-transform: scale3d(1.2, 1.2, 1); transition: all 0.35s cubic-bezier(0.000, 1.270, 0.460, 1.650); -webkit-transition: all 0.35s cubic-bezier(0.000, 1.270, 0.460, 1.650); }
[class^="hex-icon"] svg { width: 100%; height: 100%; display: block; }

.hex-icon-sun path:first-of-type { fill: #fff; }
.hex-icon-sun circle { stroke: #757579; stroke-width: 2px; fill: none; }
.hex-icon-sun circle:last-of-type { stroke-width: 2px; stroke-dasharray: 2,7.4; }

.hex-icon-wave path:first-of-type { fill: #219cb5; }
.hex-icon-wave circle { stroke: #fff; stroke-width: 2px; fill: none; }
.hex-icon-wave mask circle { fill: #fff; stroke: none; }
.hex-icon-wave path:last-of-type { fill: #fff; }

.hex-icon-heart path:first-of-type { fill: #7b5af7; }
.hex-icon-heart path:last-of-type { fill: #fff; transform-origin: 21px 25px; -webkit-transform-origin: 21px 25px;
  animation: hex-icon-heart-beat 1s linear infinite;
  -webkit-animation: hex-icon-heart-beat 1s linear infinite;
}
@keyframes hex-icon-heart-beat { 0% { transform: scale3d(1, 1, 1); } 30% { transform: scale3d(0.75, 0.75, 1); } 60% { transform: scale3d(1, 1, 1); } }
@-webkit-keyframes hex-icon-heart-beat { 0% { -webkit-transform: scale3d(1, 1, 1); } 30% { -webkit-transform: scale3d(0.75, 0.75, 1); } 60% { -webkit-transform: scale3d(1, 1, 1); } }

</style>

</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">
	
	<!-- 전체 페이지 START-->
	<div id="colorlib-page">
		<!-- START 왼쪽 NANI -->
		<%@ include file="/WEB-INF/view/sidebar.jsp"%>
		<!-- END 왼쪽 NANI -->

		<!-- START 상단 NANI -->
		<div class="padding" style="padding-bottom: 175px;"></div>
		<div class="sidebar-heading" style="text-align: center; position: fixed; top: 0; width: 100%; height:190px; background-color: #fff; z-index: 5; padding-top: 20px;font-weight: 500; color: black;">
			<div class="hh" style="font-size: 23px;height: 32px;">
			<span>S</span><span>T</span><span>U</span><span>D</span><span>Y</span><span>&nbsp;</span><span>M</span><span>A</span><span>T</span><span>C</span><span>H</span><span>I</span><span>N</span><span>G</span>
			</div>
			<hr style=" width: 90%; height: 1.5px; border: none; background-color: #666666;">
			<ul class="tagcloud" style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
				<a href="/study/match.do" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;"> 전체</a>
				<a href="/study/match2.do?study_field=IT개발" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;"> IT개발</a>
				<a href="/study/match2.do?study_field=자유스터디" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;"> 자유스터디</a>
				<a href="/study/match2.do?study_field=공모전" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;">공모전</a>
				<a href="/study/match2.do?study_field=어학/회화" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;">어학/회화</a>
				<a href="/study/match2.do?study_field=봉사활동" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;">봉사활동</a>
				<a href="/study/match2.do?study_field=취업/면접" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;">취업/면접</a>
				<a href="/study/match2.do?study_field=스포츠" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;">스포츠</a>
				<a href="/study/match2.do?study_field=여행" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ffc107;">여행</a>
			</ul>
		</div>
		<!-- END 상단 NANI -->
		<hr />
		<!-- 메인 페이지 START-->
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					
				<!-- 공보전정보, 개설하기 버튼 Start -->
				<div class="row">
					<div class="col-2">
					<span class="hex-icon-sun" OnClick="location.href='/study/contest.do'">
    					<svg>
      					<path d="M19,1 Q21,0,23,1 L39,10 Q41.5,11,42,14 L42,36 Q41.5,39,39,40 L23,49 Q21,50,19,49 L3,40 Q0.5,39,0,36 L0,14 Q0.5,11,3,10 L19,1" />
      					<circle cx="21" cy="25" r="8" />
      					<circle cx="21" cy="25" r="12">
        				<animateTransform attributeName="transform" attributeType="XML" type="rotate" from="0 21 25" to="360 21 25" dur="3.5s" repeatCount="indefinite" />
      					</circle>
    					</svg>
  					</span>
					</div>
					
					<div class="col-3" OnClick="location.href='/study/contest.do'">
  					<label style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
							공모전 정보</label>
					</div>
					
					<div class="col-2" OnClick="location.href='/study/studyopen.do'">
					<span class="hex-icon-heart">
    					<svg>
      					<path d="M19,1 Q21,0,23,1 L39,10 Q41.5,11,42,14 L42,36 Q41.5,39,39,40 L23,49 Q21,50,19,49 L3,40 Q0.5,39,0,36 L0,14 Q0.5,11,3,10 L19,1" />
      					<path d="M11,17 Q16,14,21,20 Q26,14,31,17 Q35,22,31,27 L21,36 L11,27 Q7,22,11,17" />
    					</svg>
  					</span>
					</div>
					
					<div class="col-3" OnClick="location.href='/study/studyopen.do'">
  					<label style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
							개설하기</label>
					</div>
				</div>
				<hr style="margin-top: 5px; margin-bottom: 0px;" />
				<!-- 공보전정보, 개설하기 버튼 END -->
					
					<!-- 왼쪽 오른쪽 2분할 -->
					<div class="row d-flex">
					
						<!-- 왼쪽 스크립트 -->
						<div class="col-xl-8 px-md-5" style="background-color: #f7fbff;">
							<!-- 추천 Study Group -->
							<!-- 슬라이드 -->
							<div class="slider-1">
								<label
									style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
									추천 스터디 </label>
								<div class="owl-carousel owl-theme">
									<%
										int i = 0;
										for (StudyListDTO sDTO : pList) {
											if(Integer.parseInt(mbti_scores.get(i)) >= 3 && !user_study.contains(sDTO.getStudy_name())){
									%>
									<!-- 모든 스터디 리스트로 뿌려줌 -->
									<div class="item"
										style="font-size: 33px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; coler: white;">
										<a href="/study/studyinfo.do?study_name=<%=sDTO.getStudy_name()%>">
										<img src="<%=iList.get(i)%>" class="rounded" width="100%">
										</a>
										<div class="txt-box"></div>
										<div style="margin-top: 10px; margin-bottom: 0px;">
											<label style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
											<%=sDTO.getStudy_name()%> </label>
											<div style="font-size: 20px"><%=sDTO.getStudy_title()%></div>
											
											<!-- asd -->
											<div class="emp-profile">
												<div class="d-flex">
													<div class="profile-card col-4" style="padding-right:0px; padding-left:0px;">
													<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"  width="50" height="50"
															 viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
														<path style="fill:#FFDC64;" d="M446.942,160.817l-129.819-12.041L265.555,29.03c-3.611-8.385-15.499-8.385-19.109,0l-51.568,119.745
															L65.058,160.817c-9.091,0.843-12.764,12.149-5.905,18.175l97.948,86.047l-28.665,127.187c-2.007,8.906,7.611,15.894,15.46,11.233
															l112.103-66.565l112.103,66.565c7.85,4.661,17.467-2.327,15.46-11.233l-28.666-127.187l97.949-86.047
															C459.706,172.965,456.032,161.66,446.942,160.817z"/>
														<g>
															<path style="fill:#FFF082;" d="M123.288,24.908c6.618,9.193,25.298,48.67,35.977,71.677c1.679,3.617-2.859,6.884-5.756,4.144
																c-18.43-17.426-49.943-47.665-56.56-56.857c-5.237-7.274-3.585-17.416,3.688-22.651C107.909,15.983,118.051,17.634,123.288,24.908z
																"/>
															<path style="fill:#FFF082;" d="M388.714,24.908c-6.618,9.193-25.298,48.67-35.977,71.677c-1.679,3.617,2.859,6.884,5.756,4.144
																c18.431-17.426,49.943-47.665,56.56-56.857c5.237-7.274,3.585-17.416-3.688-22.651C404.091,15.983,393.95,17.634,388.714,24.908z"
																/>
															<path style="fill:#FFF082;" d="M493.293,294.471c-10.769-3.512-54.056-9.314-79.219-12.498c-3.956-0.501-5.69,4.815-2.199,6.743
																c22.202,12.264,60.586,33.099,71.355,36.611c8.521,2.779,17.682-1.876,20.46-10.397C506.468,306.41,501.813,297.25,493.293,294.471
																z"/>
															<path style="fill:#FFF082;" d="M18.708,294.471c10.769-3.512,54.056-9.314,79.219-12.498c3.956-0.501,5.69,4.815,2.199,6.743
																c-22.202,12.264-60.586,33.099-71.355,36.611c-8.521,2.779-17.682-1.876-20.46-10.397C5.531,306.41,10.187,297.25,18.708,294.471z"
																/>
															<path style="fill:#FFF082;" d="M240.27,477.619c0-11.327,7.907-54.28,12.682-79.19c0.751-3.916,6.342-3.916,7.093,0
																c4.776,24.91,12.682,67.863,12.682,79.19c0,8.963-7.266,16.229-16.229,16.229C247.535,493.847,240.27,486.582,240.27,477.619z"/>
														</g>
														<path style="fill:#FFC850;" d="M284.306,72.575L265.555,29.03c-3.611-8.385-15.499-8.385-19.109,0l-51.568,119.745L65.058,160.817
															c-9.091,0.843-12.764,12.149-5.905,18.175l97.948,86.047l-28.665,127.187c-2.007,8.906,7.611,15.894,15.46,11.233l14.921-8.86
															C183.277,236.261,252.042,120.03,284.306,72.575z"/>
														<path d="M363.194,267.733l94.601-83.108c5.461-4.796,7.458-12.07,5.213-18.981c-2.246-6.913-8.138-11.624-15.375-12.294
															l-125.386-11.63L298.77,87.199c-1.639-3.804-6.049-5.562-9.855-3.922c-3.804,1.638-5.56,6.05-3.922,9.854l25.24,58.61
															c1.086,2.521,3.463,4.248,6.196,4.501l129.819,12.041c1.656,0.154,2.273,1.315,2.493,1.994c0.221,0.679,0.404,1.981-0.846,3.078
															l-97.948,86.048c-2.063,1.812-2.97,4.605-2.366,7.284l28.665,127.185c0.365,1.623-0.549,2.568-1.126,2.988
															c-0.578,0.419-1.759,0.997-3.188,0.146l-112.105-66.562c-2.359-1.4-5.299-1.4-7.658,0l-112.102,66.564
															c-1.428,0.851-2.61,0.272-3.189-0.147c-0.577-0.419-1.491-1.365-1.126-2.986l14.798-65.653c0.911-4.041-1.627-8.055-5.667-8.966
															c-4.044-0.91-8.056,1.627-8.966,5.667l-14.798,65.654c-1.598,7.09,1.063,14.148,6.942,18.419c3.172,2.305,6.824,3.468,10.497,3.467
															c3.137,0,6.289-0.848,9.167-2.557l108.273-64.291l108.275,64.291c6.25,3.71,13.784,3.361,19.662-0.91
															c5.88-4.271,8.54-11.33,6.942-18.42L363.194,267.733z"/>
														<path d="M54.203,184.625l94.602,83.108l-6.148,27.284c-0.911,4.04,1.627,8.055,5.668,8.965c0.555,0.125,1.109,0.186,1.655,0.186
															c3.43,0,6.524-2.367,7.31-5.854l7.128-31.628c0.604-2.678-0.304-5.472-2.366-7.283l-97.948-86.048
															c-1.249-1.097-1.065-2.399-0.846-3.078c0.221-0.679,0.838-1.84,2.493-1.994l129.818-12.041c2.733-0.253,5.11-1.98,6.196-4.501
															l51.569-119.744c0.657-1.527,1.953-1.755,2.666-1.755c0.714,0,2.01,0.228,2.667,1.755l14.006,32.523
															c1.639,3.804,6.05,5.561,9.855,3.922c3.804-1.639,5.56-6.051,3.922-9.855l-14.006-32.523c-2.875-6.675-9.176-10.822-16.444-10.822
															c-7.268,0-13.568,4.146-16.443,10.822L189.75,141.72L64.365,153.35c-7.237,0.671-13.128,5.382-15.374,12.294
															C46.746,172.555,48.744,179.828,54.203,184.625z"/>
														<path d="M161.899,118.9c1.432,1.332,3.267,2.009,5.111,2.009c1.529,0,3.064-0.466,4.38-1.414c2.901-2.089,3.925-5.935,2.446-9.19
															c-3.536-7.78-34.824-76.394-44.462-89.781l0,0c-3.703-5.144-9.188-8.538-15.443-9.557c-6.262-1.02-12.534,0.459-17.678,4.164
															c-10.618,7.645-13.037,22.501-5.394,33.12C100.498,61.639,155.643,113.079,161.899,118.9z M105.017,27.306
															c1.502-1.082,3.267-1.647,5.082-1.647c0.472,0,0.946,0.038,1.421,0.115c2.302,0.375,4.318,1.623,5.681,3.515l0,0
															c4.536,6.299,16.055,29.718,26.48,51.719c-17.558-16.868-36.112-35.22-40.647-41.519C100.222,35.583,101.112,30.118,105.017,27.306z"/>
														<path d="M340.612,119.496c1.315,0.947,2.851,1.414,4.38,1.414c1.845,0,3.681-0.678,5.111-2.009
															c6.256-5.821,61.399-57.26,71.038-70.647c7.644-10.618,5.225-25.475-5.394-33.12c-5.146-3.704-11.426-5.183-17.678-4.163
															c-6.256,1.019-11.74,4.413-15.443,9.556c-9.638,13.387-40.926,82.001-44.462,89.781C336.687,113.561,337.71,117.407,340.612,119.496
															z M394.8,29.29L394.8,29.29c1.362-1.893,3.379-3.141,5.681-3.516c0.475-0.077,0.949-0.115,1.421-0.115
															c1.815,0,3.58,0.565,5.082,1.646c3.905,2.813,4.795,8.278,1.983,12.184c-4.535,6.299-23.091,24.652-40.647,41.52
															C378.746,59.008,390.265,35.59,394.8,29.29z"/>
														<path d="M509.414,299.151c-2.871-5.651-7.771-9.846-13.797-11.811c0-0.001,0-0.001,0-0.001c-15.682-5.113-90.56-14.075-99.045-15.08
															c-3.538-0.417-6.903,1.724-8.012,5.123c-1.109,3.398,0.336,7.107,3.451,8.861c7.447,4.191,73.21,41.1,88.892,46.213
															c2.422,0.79,4.908,1.182,7.383,1.182c3.685,0,7.344-0.868,10.724-2.586c5.651-2.871,9.846-7.771,11.81-13.796
															C512.784,311.23,512.285,304.802,509.414,299.151z M496.559,312.605c-0.723,2.217-2.265,4.019-4.343,5.075
															c-2.081,1.056-4.446,1.239-6.661,0.516c-7.379-2.406-30.502-14.508-51.907-26.108c24.129,3.249,49.94,7.106,57.319,9.514
															c2.217,0.723,4.019,2.266,5.075,4.344C497.099,308.024,497.282,310.388,496.559,312.605z"/>
														<path d="M123.44,277.383c-1.108-3.398-4.461-5.547-8.012-5.123c-8.486,1.005-83.364,9.967-99.045,15.08c0,0,0,0,0,0.001
															c-6.026,1.965-10.926,6.159-13.797,11.811c-2.871,5.65-3.37,12.08-1.405,18.105c1.965,6.025,6.159,10.926,11.811,13.797
															c3.38,1.718,7.039,2.586,10.724,2.586c2.475,0,4.961-0.392,7.382-1.181c15.683-5.114,81.445-42.022,88.893-46.214
															C123.104,284.49,124.549,280.781,123.44,277.383z M26.445,318.197c-2.217,0.722-4.583,0.537-6.66-0.517
															c-2.078-1.057-3.62-2.858-4.344-5.076c-0.723-2.216-0.539-4.581,0.517-6.66c1.057-2.078,2.858-3.621,5.075-4.344
															c7.38-2.407,33.19-6.265,57.319-9.514C56.949,303.689,33.825,315.79,26.445,318.197z"/>
														<path d="M256.497,372.751c-3.575,0-6.653,2.523-7.354,6.029c-1.676,8.38-16.374,82.345-16.374,98.839
															c0,13.084,10.645,23.728,23.728,23.728c13.084,0,23.728-10.645,23.728-23.728c0-16.495-14.698-90.46-16.374-98.839
															C263.151,375.274,260.072,372.751,256.497,372.751z M256.497,486.347c-4.813,0-8.729-3.916-8.729-8.729
															c0-7.762,4.336-33.498,8.729-57.443c4.393,23.945,8.729,49.682,8.729,57.443C265.226,482.431,261.31,486.347,256.497,486.347z"/>
														
														</svg>
													
													</div>
													
													<div class="profile-card col-8">
															<span class="mb-2" style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: gold;">
															<U>강하게 추천? 추천!!!</U>
															</span>
														
													</div>
												</div>
												<hr style="margin: 5px;">
												
											</div>
											<!-- asd -->
										</div>
									</div>
									<%
											}
										i++;
										}
									%>

								</div>
							</div>
							<!-- 슬라이드 END-->
							<hr style="margin-top: 5px; margin-bottom: 0px;" />
							<!-- My 프로필 메인화면 -->
							<label style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
								스터디 목록
							</label>
							<hr style="margin-top: 5px; margin-bottom: 0px;" />
							
							<!-- 스터디 목록 정보 START-->
							<%
								int j = 0;
								for(StudyListDTO pDTO : pList) {%>
							<% 	String[] arr = pDTO.getStudy_member().split(",");
								int membercount = arr.length;
							%>
							<div class="emp-profile">
								<div class="d-flex">
									<div class="profile-card">
										<div class="d-flex align-items-center">
											<div class="image">
												<img src="<%=iList.get(j)%>" class="rounded" width="100%">
											</div>
										</div>
										<div class="button mt-2 d-flex flex-row align-items-center">
										<% if(user_study.contains(pDTO.getStudy_name())) { %>
											<button class="btn btn-sm btn-primary w-100" onclick="location.href='/study/studyboard.do?study_name=<%=pDTO.getStudy_name() %>' " method="get";>
												Study Join</button>
										<% }else { %>
											<button class="btn btn-sm btn-secondary w-100" onclick="location.href='/study/studyinfo.do?study_name=<%=pDTO.getStudy_name() %>' " method="get";>
												Sign Up</button>
										<% } %>
										</div>
									</div>
									
									<div class="profile-card" style="padding-left: 20px; padding-top: 20px;">
										<h5
											style="font-size: 26px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;letter-spacing: 8px;">
											<%=pDTO.getStudy_name()%></h5>
										<h6
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
											<%=pDTO.getStudy_title()%></h6>
										<p class="mb-2" style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: #6c757d;">
											Join Study : <span><%=membercount%>/5</span>
										</p>
										<%-- <p class="mb-2" style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: #6c757d;">
											Score : <%=mbti_scores.get(j) %>
										</p> --%>
									</div>
								</div>
							</div>
							<!-- asd -->
							<div class="emp-profile">
								<div class="d-flex">
									<div class="profile-card col-5" style="padding-right:3px; padding-left:3px;">
									<% for(int k=0; k<Integer.parseInt(mbti_scores.get(j)); k++) {%>
									<svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="22" height="22"
										 viewBox="0 0 422.448 422.448" style="enable-background:new 0 0 422.448 422.448;" xml:space="preserve">
									<path style="fill:#FF4979;" d="M387.15,59.153c-47.066-47.065-123.374-47.065-170.44,0l-4,4l-4-4
										C163.342,10.448,87.081,7.742,38.376,53.109s-51.412,121.628-6.044,170.334c1.885,2.023,3.839,3.981,5.858,5.871l170.8,170.8
										c2.018,1.981,5.217,2.085,7.36,0.24l170.8-170.8c47.065-47.066,47.065-123.374,0-170.44L387.15,59.153z"/>
									</svg>
									
									<%} %>
									</div>
									
									<div class="profile-card col-7">
										<% if(Integer.parseInt(mbti_scores.get(j)) >= 0 && Integer.parseInt(mbti_scores.get(j)) <= 2) {%>
											<span class="mb-2" style="font-size: 18px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: #ff4500;">
											서로 양보하고 노력 해야해요.
											</span>
										<%}else if(Integer.parseInt(mbti_scores.get(j)) >= 3 && Integer.parseInt(mbti_scores.get(j)) <= 4 ){%>
											<span class="mb-2" style="font-size: 18px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: royalblue;">
											이번 기회에 친해져 볼까요?
											</span>
										<%}else{%>
											<span class="mb-2" style="font-size: 18px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: blueviolet;">
											더 없이 좋을수는 없어요. 
											</span>
										<%} %>
									</div>
								</div>
								<hr style="margin: 5px;">
								<p class="" style="font-size: 18px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; color: red; margin-bottom:0px">
								※ 스터디그룹에 가입된 팀원의 MBTI를 분석한 결과입니다.
								</p>
							</div>
							<!-- asd -->
							<div class="meta-wrap" style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
								<p class="meta">
									<span  style="color: cornflowerblue;"><i class="icon-folder-o mr-2"></i><%=pDTO.getStudy_field() %></span>
									<span><i class="icon-calendar mr-2"></i><%=pDTO.getStudy_dt() %></span>
								</p>
								<p class="mb-4" style="font-size: 18px;"><%=pDTO.getStudy_contents()%></p>
							</div>
								
							<!-- 스터디 목록 정보 END-->
							<hr style="margin-top: 5px; margin-bottom: 0px;" />
							<% 
								j++;
								} %>
						</div>

						<!-- 오른쪽 스크립트 START -->
						
						<!-- 오른쪽 스크립트 END -->
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
		$(function () {
			$('#btn-upload').click(function (e) {
				e.preventDefault();
				$('#file').click();
			});
		});
		
		
		function readImage(input) {
		    // 인풋 태그에 파일이 있는 경우
		    if(input.files && input.files[0]) {
		       
		        // FileReader 인스턴스 생성
		        const reader = new FileReader()
		        // 이미지가 로드가 된 경우
		        reader.onload = e => {
		            const previewImage = document.getElementById("preview-image")
		            console.log("previewImage : " + previewImage)
		            previewImage.src = e.target.result
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0])
		    }
		}
		// input file에 change 이벤트 부여
		const inputImage = document.getElementById("input-image")
		inputImage.addEventListener("change", e => {
		    readImage(e.target)
		})
</script>

<script type="text/javascript">
	$('.slider-1 > .owl-carousel')
			.owlCarousel(
					{
						autoplay : true, // 오토 플레이
						autoplayTimeout : 3000, // 오토 플레이 시에 다음 슬라이드로 넘어가는 주기, 2초
						mouseDrag: true,
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