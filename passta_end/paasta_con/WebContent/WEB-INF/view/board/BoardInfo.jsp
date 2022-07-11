<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%@ page import="poly.dto.BoardDTO" %>
<%@ page import="poly.dto.OcrDTO" %>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%>



<%
String study_name = CmmUtil.nvl((String)request.getAttribute("study_name"));
BoardDTO rDTO = (BoardDTO)request.getAttribute("rDTO");
List<OcrDTO> rList = (List<OcrDTO>) request.getAttribute("fList");
//공지글 정보를 못불러왔다면, 객체 생성
if (rDTO==null){
	rDTO = new BoardDTO();
}
String user_id = CmmUtil.nvl((String)session.getAttribute("user_id"));
//본인이 작성한 글만 수정 가능하도록 하기(1:작성자 아님 / 2: 본인이 작성한 글 / 3: 로그인안함)
int edit = 1;
//로그인 안했다면....
if (user_id.equals("")){
	edit = 3;
	
//본인이 작성한 글이면 2가 되도록 변경
}else if (user_id.equals(CmmUtil.nvl(rDTO.getUser_id()))){
	edit = 2;
}
System.out.println("user_id : "+ CmmUtil.nvl(rDTO.getUser_id()));
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
							<!-- 게시판 보드START -->
							<div class="" style="margin-left:20px">
							<label style="font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-top: 18px; margin-bottom: -8px;">
									<%=rDTO.getUser_id() %> 님의 글 </label>
							</div>
							<div class="emp-profile">
								<!-- 게시판 상세보기 -->
								<div class="d-flex card p-3" style="magin: -11px;">
									<div class="form-group mt-3">
										<label style="font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											제목 : <%=rDTO.getTitle() %></label>
											<br/>
										첨부파일
										<div class="card fontstyle p-2" style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
												<%
												for (int i = 0; i < rList.size(); i++) {
												
													String fname="filedown";
													String fsrc = "/common/download.do?fileName=";
													String src = "&src=";
													String res = rList.get(i).getSave_file_path();
													
													//
											%>	
											<a href="<%=fsrc + rList.get(i).getSave_file_name()%>" title="<%= rList.get(i).getOrg_file_name() %>" id="<%= fname + i%>" class="fdown"><%= rList.get(i).getOrg_file_name() %></a>
											 <%
												}
											 %>	
										</div>	
										내용
										<div class="card fontstyle p-2" style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
											<%=rDTO.getContents() %>
										</div>
									</div>
									
									<hr style="margin-top: 10px; margin-bottom: 0px;" />
										<div class="row" style="font-size: 22px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; margin-bottom: 0px;">
										<a href="javascript:doEdit();" style="margin-left: 15px;">[수정]</a>
										<a href="javascript:doDelete();" style="margin-left: 15px; color:red;">[삭제]</a>
										<a href="javascript:doList();" style="margin-left: 15px; color:coral;">[목록]</a>
										</div>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
//수정하기
function doEdit(){
	if ("<%=edit%>"==2){
		location.href="/board/BoardEditInfo.do?notice_seq=<%=CmmUtil.nvl(rDTO.getNotice_seq())%>&&study_seq=<%=CmmUtil.nvl(rDTO.getStudy_seq()) %>";
		
	}else if ("<%=edit%>"==3){
		swal("로그인 하시길 바랍니다.");
		
	}else {
		swal("본인이 작성한 글만 수정 가능합니다.");
		
	}
}
//삭제하기
function doDelete(){
	if ("<%=edit%>"==2){
		if(confirm("작성한 글을 삭제하시겠습니까?")){
			location.href="/board/BoardDelete.do?notice_seq=<%=CmmUtil.nvl(rDTO.getNotice_seq())%>&&study_seq=<%=CmmUtil.nvl(rDTO.getStudy_seq()) %>";
		}
		
	}else if ("<%=edit%>"==3){
		swal("로그인 하시길 바랍니다.");
		
	}else {
		swal("본인이 작성한 글만 삭제 가능합니다.");
		
	}
}
//목록으로 이동
function doList(){
	location.href="/study/studyboard.do?study_name=<%=CmmUtil.nvl(study_name) %>";		
}



</script>	

</html>