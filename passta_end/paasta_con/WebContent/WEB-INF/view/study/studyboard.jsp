
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.BoardDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.StudyListDTO"%>
<%@page import="poly.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserDTO uDTO = (UserDTO) request.getAttribute("rDTO");
String user_id = uDTO.getUser_id();
String user_name = uDTO.getUser_name();

StudyListDTO sDTO = (StudyListDTO) request.getAttribute("sDTO");
String study_name = (String) request.getAttribute("study_name");
String study_notify = CmmUtil.nvl(sDTO.getStudy_notify());
String study_title = CmmUtil.nvl(sDTO.getStudy_title());
String study_creator = CmmUtil.nvl(sDTO.getStudy_creator());
String study_seq = CmmUtil.nvl(sDTO.getStudy_seq());
System.out.println("study_creator : " + study_creator);
System.out.println("study_seq : " + study_seq);

String[] study_group = user_name.split("");
int study_count = study_group.length;

// 게시판 조회 결과 보여주기
List<BoardDTO> rList = (List<BoardDTO>) request.getAttribute("rList");
if (rList == null) {
	rList = new ArrayList<BoardDTO>();
}

// 스터디그룹에 가입한 유저의 MBTI정보
List<String> mList = (List<String>) request.getAttribute("mList");
String member_mbti = String.join(",", mList);

int mbti_score = (int) request.getAttribute("mbti_score");
String study_img = (String) request.getAttribute("study_img");
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
<!-- data table -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">

<style>
</style>
</head>
<body data-aos-easing="slide" data-aos-duration="800" data-aos-delay="0">

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
				<span>S</span><span>T</span><span>U</span><span>D</span><span>Y</span><span>&nbsp;</span><span>M</span><span>A</span><span>T</span><span>C</span><span>H</span><span>I</span><span>N</span><span>G</span>
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
									<%=study_name%> 팀의 커뮤니티
								</label>
							</div>
							<div class="emp-profile">
								<!-- 사진 프로필 START -->
								<div class="d-flex card p-3" style="magin: -11px;">



									<form id="uploadForm" enctype="multipart/form-data">
										<div class="d-flex align-items-center">
											<div class="image">
												<img id="preview-image" src="<%=study_img%>" class="rounded"
													width="100%">
											</div>
										</div>
										<div id="input-image"
											class="button mt-2 d-flex flex-row align-items-center">
											<input type="file" id="file" name="fileUplod2"
												onchange="changeValue(this)" style="display: none" /> <input
												type="hidden" name="study_name" value="<%=study_name%>">
											<button class="btn btn-sm btn-primary w-100" id="btn-upload"
												style="margin-right: 2px;">Select File</button>
											<button id="btnUpload" class="btn btn-sm btn-primary w-100"
												style="margin-left: 2px;">Register</button>
										</div>
									</form>

									<!-- 스터디 정보 -->
									<hr>
									<div class="form-group" style="margin-bottom: 0px;">
										<label
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											Title : <%=study_title%>
										</label><br> <label
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											스터디 시작일 : <%=sDTO.getStudy_dt()%>
										</label><br> <label
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											멤버 : <%=sDTO.getStudy_member()%>
										</label><br> <label
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											멤버의 MBTI : <%=member_mbti%>
										</label><br>
										<div class="profile-card"
											style="padding-right: 3px; padding-left: 3px;">
											<%
												for (int k = 0; k < mbti_score; k++) {
											%>
											<svg version="1.1" id="Capa_1"
												xmlns="http://www.w3.org/2000/svg"
												xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
												width="22" height="22" viewBox="0 0 422.448 422.448"
												style="enable-background: new 0 0 422.448 422.448;"
												xml:space="preserve">
										<path style="fill:#FF4979;"
													d="M387.15,59.153c-47.066-47.065-123.374-47.065-170.44,0l-4,4l-4-4
											C163.342,10.448,87.081,7.742,38.376,53.109s-51.412,121.628-6.044,170.334c1.885,2.023,3.839,3.981,5.858,5.871l170.8,170.8
											c2.018,1.981,5.217,2.085,7.36,0.24l170.8-170.8c47.065-47.066,47.065-123.374,0-170.44L387.15,59.153z" />
										</svg>
											<%
												}
											%>
										</div>
									</div>

									<div class="form-group mt-3">
										<label
											style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											알림</label>
										<div class="card fontstyle p-2"
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											<div id="text_aera"><%=sDTO.getStudy_notify()%></div>
											<!-- 스터디 개설자만 알림을 수정할 수 있음 -->
											<%
												if (sDTO.getStudy_creator().equals(uDTO.getUser_id())) {
											%>
											<button class="btn btn-sm btn-primary w-100" id="btn-upload"
												style="margin-right: 2px;" data-toggle="modal"
												data-target="#exampleModalCenter">알림 수정하기</button>
											<%
												} else {
											}
											%>
										</div>
										<!-- modal 알림창  -->
										<!-- Modal -->
										<div class="modal fade" id="exampleModalCenter" tabindex="-1"
											role="dialog" aria-labelledby="exampleModalCenterTitle"
											aria-hidden="true"
											style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											<div class="modal-dialog modal-dialog-centered"
												role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" style="font-size: 30px;"
															id="exampleModalLongTitle">알림 수정하기</h5>
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
													</div>
													<div class="modal-body">
														<textarea cols="50" rows="10" style="width: 100%"
															id="text_modify"><%=sDTO.getStudy_notify()%></textarea>
													</div>
													<div class="modal-footer" style="font-size: 25px;">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">닫기</button>
														<button type="button" class="btn btn-primary"
															onclick="text_modify();">수정하기</button>
													</div>
												</div>
											</div>
										</div>
										<!-- model 끝 -->

									</div>
									<!-- 멀티 게시판  -->
									<div style="display: flex">
										<div style="margin: 0 auto;">
											<label
												style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
												게시판</label>
										</div>
										<div>
											<button type="button" class="btn btn-outline-warning"
												onclick="location.href='/chat/chatting.do?study_name=거북목'"
												style="font-weight: 600; color: tomato; border-width: revert; border-color: tomato;">
												Let's 채팅</button>
										</div>
									</div>
									<hr>
									<!-- 게시판 -->
									<table id="example" class="display"
										style="width: 100%; font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
										<thead style="font-size: 15px";>
											<tr>
												<th>no</th>
												<th>title</th>
												<th>name</th>
												<th>v</th>

											</tr>
										</thead>
										<%
											for (int i = 0; i < rList.size(); i++) {
											BoardDTO rDTO = rList.get(i);
											if (rDTO == null) {
												rDTO = new BoardDTO();
											}
										%>
										<tr>
											<td style="font-size: 15px";>
												<%
													// 공지글이라면, [공지]표시
												if (CmmUtil.nvl(rDTO.getNotice_yn()).equals("1")) {
													out.print("<b>[공지]</b>");
												} else {
													out.print(CmmUtil.nvl(rDTO.getNotice_seq()));
												}
												%>
											</td>
											<td><a style="color: brown;"
												href="javascript:doDetail('<%=CmmUtil.nvl(rDTO.getNotice_seq())%>','<%=CmmUtil.nvl(study_seq)%>');">
													<%=CmmUtil.nvl(rDTO.getTitle())%></a></td>
											<th style="font-size: 15px";><%=CmmUtil.nvl(rDTO.getUser_name())%>
											</th>
											<th style="font-size: 15px";><%=CmmUtil.nvl(rDTO.getRead_cnt())%>
											</th>
										</tr>
										<%
											}
										%>
									</table>
									<div
										style="font-size: 20px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
										<a href="javascript:newReg('<%=study_seq%>');"> [글쓰기]</a>
									</div>
									<!-- 스터디 개설  END -->
									<%
										if (user_id.equals(study_creator)) {
									%>
									<button id="btnUpload" class="btn btn-sm btn-danger w-100"
										style="margin-top: 20px; margin-left: 2px;" onclick="del();">스터디
										삭제하기</button>

									<%
										} else {
									%>

									<button id="btnUpload" class="btn btn-sm btn-danger w-100"
										style="margin-top: 20px; margin-left: 2px;" onclick="leave();">스터디
										탈퇴하기</button>

									<%
										}
									%>

									<hr style="margin-top: 10px; margin-bottom: 0px;" />

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
	<script
		src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>


</body>
<script type="text/javascript">
//상세보기 이동
function doDetail(seq, seq2){
	location.href="/board/BoardInfo.do?notice_seq="+seq+"&study_seq="+seq2;
}

function newReg(seq){
	location.href="/board/BoardReg.do?study_seq="+seq;
}
</script>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	$('#btnUpload').on('click', function(event) {
	    event.preventDefault();
	    
	    var form = $('#uploadForm')[0]
	    var data = new FormData(form);
	    $('#btnUpload').prop('disabled', true);
		
	    $.ajax({
	        type: "POST",
	        enctype: 'multipart/form-data',
	        url: "/FileUplod2.do",
	        data: data,
	        processData: false,
	        contentType: false,
	        cache: false,
	        timeout: 600000,
	        success: function (data) {
	        	$('#btnUpload').prop('disabled', false);
	        	alert('등록이 성공하였습니다.')
	        },
	        error: function (e) {
	            $('#btnUpload').prop('disabled', false);
	            alert('등록이 실패하였습니다.');
	        }
	    });
	})
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({
			"columns" : [
					{"width" : "10%"},
					{ "width" : "80%" },
					{ "width" : "5%" },
					{ "width" : "5%" } 
			]
		});
	});
	
function del() {
	if (window.confirm('스터디 그룹을 삭제하시겠습니까?')){
		window.location = '/study/del.do?study_name=<%=study_name%>';
	}else{
	    // They clicked no
	}
}

function leave() {
	if (window.confirm('스터디 그룹을 탈퇴하시겠습니까?')){
		window.location = '/study/leave.do?study_name=<%=study_name%>';
	}else{
	    // They clicked no
	}
}

function text_modify() {
    let study_seq = <%=sDTO.getStudy_seq()%>
    const study_notify = document.getElementById("text_modify").value;
    console.log(study_notify);

	let request = {
            method: 'POST',
            body: JSON.stringify({ study_seq : study_seq , study_notify : study_notify }),
            headers: {
                'Content-Type': 'application/json'
            }
        };
    
   fetch("/study/textModify.do", request)
	.then(function(res){
		return res.text()
	})
	.then(function(data){
		console.log(data);
		if(data == 1){
		
		swal("수정이 완료 되었습니다.!")
		.then((value) => {
			location.reload();
		});
		
		}else{
		swal("수정이 실패 되었습니다.!")
		.then((value) => {
			location.reload();
		});
		}
		
	})
}
</script>
</html>