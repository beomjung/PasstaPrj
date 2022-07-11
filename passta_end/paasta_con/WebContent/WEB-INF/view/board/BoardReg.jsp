<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil"%>
<%@ page import="poly.dto.BoardDTO"%>
<%
	String user_id = CmmUtil.nvl((String)session.getAttribute("user_id"));
	String study_seq = CmmUtil.nvl((String)request.getAttribute("study_seq"));
	String study_name = CmmUtil.nvl((String)request.getAttribute("study_name"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판 글쓰기</title>
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
<!-- data table -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">


</head>
<body onload="doOnload();">

	<!-- 전체 페이지 START-->
	<div id="colorlib-page">
		<!-- START 왼쪽 NANI -->
		<%@ include file="/WEB-INF/view/sidebar.jsp"%>
		<!-- END 왼쪽 NANI -->

		<!-- START 상단 NANI -->
		<div class="padding" style="padding-bottom: 55px;"></div>
		<div class="sidebar-heading"
			style="text-align: center; position: fixed; top: 0; width: 100%; height: 70px; background-color: #fff; z-index: 5; padding-top: 20px; font-weight: 500; color: black;">
			<div class="hh" style="font-size: 23px; height: 32px;">
				<span>S</span><span>T</span><span>U</span><span>D</span><span>Y</span><span>&nbsp;</span><span>B</span><span>O</span><span>A</span><span>R</span><span>D</span>
			</div>
			<hr
				style="width: 90%; height: 1.5px; border: none; background-color: #666666;">

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
						<div class="" style="margin-left: 20px">
							<label
								style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-top: 18px; margin-bottom: -8px;">
								새 글쓰기
							</label>
						</div>
						<div class="emp-profile">
							<!-- 사진 프로필 START -->
							<div class="d-flex card p-3" style="magin: -11px;">
								
								<form name="f" method="post" enctype="multipart/form-data" action="/board/BoardInsert.do" onsubmit="return doSubmit(this);">
									<input type="hidden" name="study_seq" value="<%=CmmUtil.nvl(study_seq)%>" />
										<div class="form-group">
										<label style="font-size: 27px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-left: 5px; margin-top: 5px; margin-bottom: -8px;">
										제목</label>
										<hr style="margin-top: 10px; margin-bottom: 7px;" />
										<div class="card fontstyle p-2" style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;width:100%;">
										<input type="text" name="title" maxlength="100" />
										</div>
										
										<hr style="margin-top: 10px; margin-bottom: 0px;" />
										
										<label style="font-size: 27px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-left: 5px; margin-top: 5px; margin-bottom: -8px;">
										파일업로드</label>
										<hr style="margin-top: 10px; margin-bottom: 7px;" />
										<div class="card fontstyle p-2" style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;width:100%;">
										<input multiple="multiple" type="file"  name="studyfileUpload"/>
										</div>
										<hr style="margin-top: 10px; margin-bottom: 0px;" />
										
										<label style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-top: 18px; margin-bottom: -10px;">
										공지글 여부</label>
											<div style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-top: 5px; margin-bottom: -8px;">
												예<input type="radio" name="notice_yn" value="1"/>
												아니오<input type="radio" name="notice_yn" value="2"/>
											</div>
										
										<hr style="margin-top: 10px; margin-bottom: 0px;" />
										<label style="font-size: 27px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-left: 5px; margin-top: 18px; margin-bottom: 0px;">
										내용</label>
										<div class="card fontstyle p-2" style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;width:100%;">
											<textarea name="contents" cols="40" rows="8"></textarea>
										</div>
										<hr style="margin-top: 10px; margin-bottom: 0px;" />
										<div class="row" style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
										<input type="submit" value="[등록]" style="margin-left: 15px;color: darkblue;"/>
										<input type="reset" value="[다시 작성]" style="margin-left: 15px;color: coral;"/>
										</div>
									</div>
								</form>
								<!-- 프로세스 처리용 iframe / form 태그에서 target을 iframe으로 한다. -->
								<iframe name="ifrPrc" style="display:none"></iframe>
							</div>
						</div>
						<!-- 왼쪽 스크립트 끝 -->

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
		<svg class="circular" width="48px" height="48px"> <circle
			class="path-bg" cx="24" cy="24" r="22" fill="none" troke-width="4"
			stroke="#eeeeee"></circle> <circle class="path" cx="24" cy="24"
			r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
			stroke="#F96D00"></circle></svg>
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
	<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>


</body>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
	//로그인 여부 체크
	function doOnload(){
		var user_id = "<%=user_id%>";
		
		if (user_id==""){
			swal("로그인된 사용자만 글을 쓸 수 있습니다.")
			.then((value) => {
				top.location.href="/study/studyboard.do?study_name="<%=study_name %>;
			});
			
			
		}
		
	}
	//전송시 유효성 체크
	function doSubmit(f){
		if(f.title.value == ""){
			swal("제목을 입력하시기 바랍니다.");
			f.title.focus();
			return false;
		}
		
		if(calBytes(f.title.value) > 200){
			swal("최대 200Bytes까지 입력 가능합니다.");
			f.title.focus();
			return false;
		}	
		
		var noticeCheck = false; //체크 여부 확인 변수
		for(var i=0;i<f.noticeYn.length;i++){
			if (f.noticeYn[i].checked){
				noticeCheck = true;
			}
		}
		
		if(noticeCheck==false){
			swal("공지글 여부를 선택하시기 바랍니다.");
			f.noticeYn[0].focus();
			return false;
		}	
		
		if(f.contents.value == ""){
			swal("내용을 입력하시기 바랍니다.");
			f.contents.focus();
			return false;
		}	
		
		if(calBytes(f.contents.value) > 4000){
			swal("최대 4000Bytes까지 입력 가능합니다.");
			f.contents.focus();
			return false;
		}		
		
		
	}
	//글자 길이 바이트 단위로 체크하기(바이트값 전달)
	function calBytes(str){
		
		var tcount = 0;
		var tmpStr = new String(str);
		var strCnt = tmpStr.length;
		var onechar;
		for (i=0;i<strCnt;i++){
			onechar = tmpStr.charAt(i);
			
			if (escape(onechar).length > 4){
				tcount += 2;
			}else{
				tcount += 1;
			}
		}
		
		return tcount;
	}
	</script>
</html>