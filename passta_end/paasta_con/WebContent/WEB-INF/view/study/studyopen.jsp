<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String user_id = (String) request.getAttribute("user_id");
	String user_name = (String) request.getAttribute("user_name");
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
<link rel="stylesheet" href="/css/owlowl.css">
<!-- owl -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	function doRegFileCheck(f){
		
		if(f.fileUplod2.value==""){
			swal ('스터디 이미지를 등록해주세요.');
			f.fileUplod2.focus();
			return false;
		}
		
		if(f.study_name.value==""){
			swal ('스터디 이름을 등록해주세요.');
			f.study_name.focus();
			return false;
		}
		if(f.study_title.value==""){
			swal ('스터디 제목을 등록해주세요.');
			f.study_title.focus();
			return false;
		}
		if(f.study_contents.value==""){
			swal ('스터디 메시지를 등록해주세요.');
			f.study_contents.focus();
			return false;
		}
		
	}
</script>
</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">
	
	<!-- 전체 페이지 START-->
	<div id="colorlib-page">
		<!-- START 왼쪽 NANI -->
		<%@ include file="/WEB-INF/view/sidebar.jsp"%>
		<!-- END 왼쪽 NANI -->

		<!-- START 상단 NANI -->
		<div class="padding" style="padding-bottom: 105px;"></div>
		<div class="sidebar-heading" style="text-align: center; position: fixed; top: 0; width: 100%; height:130px; background-color: #fff; z-index: 5; padding-top: 20px;font-weight: 500; color: black;">
			<div class="hh" style="font-size: 23px;height: 32px;">
			<span>S</span><span>T</span><span>U</span><span>D</span><span>Y</span><span>&nbsp;</span><span>M</span><span>A</span><span>T</span><span>C</span><span>H</span><span>I</span><span>N</span><span>G</span>
			</div>
			<hr style=" width: 90%; height: 1.5px; border: none; background-color: #666666;">
			<ul class="tagcloud" style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;margin-bottom: 0px;">
				<a href="/study/match.do" class="tag-cloud-link" style="font-size: 17px; border-width: 1.5px; border-color: #ff0050; float: left; margin-left: 20px;">이전</a>
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
							<!-- 스터디 개설  START -->
							<div class="emp-profile">
								<label style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
								스터디 개설하기
								</label>
								<!-- 사진 프로필 START -->
								<div class="d-flex card m-2 p-3">
								
										<form action="/study/insertStudyInfo.do" class="p-1 contact-form" method="post" enctype="multipart/form-data" 
											onsubmit="return doRegFileCheck(this)"
											style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;">
										<div class="profile-card" style="width: 100%;">
												<div class="align-items-center">
													<div class="image">
														<img id="preview-image" src="/img/study.jpg" class="rounded" width="100%" alt="My Image">
													</div>
												</div>
												<div id="input-image" class="button mt-2 d-flex flex-row align-items-center">
													<input type="file" id="file" name="fileUplod2" onchange="changeValue(this)" style="display:none;"/>
													<button class="btn btn-sm btn-primary w-100" id="btn-upload" style="margin-right: 2px;font-size: 20px;">Select File</button>
												</div>
											
										</div>
										
										<div>
	              							<label style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											스터디 분야
											</label>
	              							<div class="form-group">
		              							<select class="form-control" style="width: 100%; font-size: 22px;" name="study_field">
													<option value="자유스터디" selected>자유스터디</option>
													<option value="IT개발" selected>IT개발</option>
													<option value="공모전">공모전</option>
													<option value="어학/회화">어학/회화</option>
													<option value="봉사활동">봉사활동</option>
													<option value="취업/면접">취업/면접</option>
													<option value="스포츠">스포츠</option>
													<option value="여행">여행</option>
												</select>
	              							</div>
	              							<div class="form-group">
	                							<input type="text" id="study_name" class="form-control" placeholder="Study Name" name="study_name" style="font-size: 20px;">
	              							</div>
	              							<div class="form-group">
	                							<input type="text" class="form-control" placeholder="Study Title" name="study_title" style="font-size: 20px;">
	              							</div>
								            <div class="form-group">
								                <textarea id="" cols="20" rows="7" class="form-control" placeholder="Message" name="study_contents" style="font-size: 18px;"></textarea>
								            </div>
								            <div class="form-group text-center" style="font-size:24px;margin-bottom: 0px;">
												<input type="submit" value="Create Study" class="btn btn-success py-2 px-3" style="font-size: 20px;">
								             </div>
								            <p class="mb-3" style="font-size: 20px;font-family: 'Do Hyeon', sans-serif;font-family: 'Nanum Pen Script', cursive;color: #6c757d;float: right;">
											By <span><%=user_name%></span>
											</p>
										</div>
								        </form>
									</div>
								</div>
								<!-- 스터디 개설  END -->

								<hr style="margin-top: 10px; margin-bottom: 0px;" />
								
							</div>
						</div>
						<!-- 왼쪽 스크립트 끝 -->
						
						<!-- 오른쪽 스크립트 시작 -->
						

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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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



</html>