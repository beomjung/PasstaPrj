<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@page import="static poly.util.CmmUtil.nvl" %>
<%

	String id = nvl((String)session.getAttribute("user_id"));
	String date = nvl((String)session.getAttribute("join_dt")); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- 구글폰트 -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Pen+Script&display=swap" rel="stylesheet">

<body>

<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight"
			style="height: 812px;">
			
			<nav id="colorlib-main-menu" role="navigation">
			<a href="single.html" class="img img-2" style="background-image: url(/andrea-master/images/image_1.jpg);"></a>
			<div class="colorlib-active">
			<ul>
				<li>
					<%if(date.isEmpty()) { %>
						<a href="/user/login.do" style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 32px;">가입 하시겠습니까?</a>
					<% } else { %>
						<a href="#" style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 24px;" method=post>첫방문  : <%=date %></a>
					<%} %>
				
				</li>
				<li>
					<%if(id.isEmpty()) { %>
						<a href="/user/login.do" style= "font-family: 'Nanum Pen Script', cursive; font-size: 20px; padding-left: 70px;">Sign in</a>
					<% } else { %>
						<a href="/user/logOut.do" style=" font-family: 'Nanum Pen Script', cursive; font-size: 24px; padding-left: 40px;"><%=id %> 님 Log out</a>
					<%} %>
				</li>
			</ul>
		</div>
		<hr style=" width: 90%; height: 1.5px; border: none; background-color: #666666;"/>
				<ul class="nav2">
					<li class="colorlib-active"><a href="/spoilbroth/mystudy.do">Home</a></li>
					<li class="nana0"><a href="/face/faceregister.do">Face Register</a></li>
					<li class="nana1"><a href="/mbti/mbtimain.do">MBTI Analysis</a></li>
					<li class="nana2"><a href="/study/match.do">Study Matching</a></li>
					<li class="nana3"><a href="/study/contest.do">Study Imformation</a></li>
					<li class="nana4"><a href="/study/studyplace.do">Study Place</a></li>
					<li class="nana5"><a href="/mypage/setting.do">Setting</a></li>
				</ul>
			</nav>

			<div class="colorlib-footer" style="padding-bottom: 20px;">
				<h1 id="colorlib-logo" class="mb-4">
					<a href="/spoilbroth/main.do" style="background-image: url(/andrea-master/images/bg_1.jpg); font-size: 57px;">Spoilbroth</a>
				</h1>
				<span style="font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 28px;">요리사가 너무 많으면 수프를 망친다.</span>
				<div class="mb-4">
					<h3>Subscribe for Spoilbroth</h3>
					<form action="#" class="colorlib-subscribe-form">
						<div class="form-group d-flex">
							<div class="icon">
								<span class="icon-paper-plane"></span>
							</div>
							<input type="text" class="form-control"
								placeholder="Enter Email Address">
						</div>
					</form>
				</div>
				
			</div>
		</aside>


<script src="/andrea-master/js/jquery.min.js"></script>
</body>
<script>
$(function(){
    var url = window.location.pathname;  
    var activePage = url.substring(url.lastIndexOf('/')+1);
    console.log("activePage: " + activePage);
    
    $('.nav2 li a').each(function(){  
        var currentPage = this.href.substring(this.href.lastIndexOf('/')+1);
		console.log("currentPage : "+currentPage)
		
        if (activePage == currentPage) {
        	$(".nav2").find(".colorlib-active").removeClass("colorlib-active");
            $(this).parent().addClass('colorlib-active');
            $(this).addClass('colorlib-active');
            
        }else if(activePage == "faceregister.do"){
        	$(".nav2").find(".colorlib-active").removeClass("colorlib-active");
        	$('.nana0').addClass('colorlib-active');
        }else if(activePage == "mbtianalysis.do"){
        	$(".nav2").find(".colorlib-active").removeClass("colorlib-active");
        	$('.nana1').addClass('colorlib-active');
        }else if(activePage == "match.do"){
        	$(".nav2").find(".colorlib-active").removeClass("colorlib-active");
        	$('.nana2').addClass('colorlib-active');
        }else if(activePage == "contest.do"){
        	$(".nav2").find(".colorlib-active").removeClass("colorlib-active");
        	$('.nana3').addClass('colorlib-active');
        }else if(activePage == "studyplace.do"){
        	$(".nav2").find(".colorlib-active").removeClass("colorlib-active");
        	$('.nana4').addClass('colorlib-active');
        }
    });
})

</script>
</html>