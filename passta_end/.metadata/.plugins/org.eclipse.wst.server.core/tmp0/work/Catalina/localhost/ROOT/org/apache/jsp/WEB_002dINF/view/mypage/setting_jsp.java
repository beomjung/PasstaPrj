/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2021-11-24 16:13:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import static poly.util.CmmUtil.nvl;

public final class setting_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/view/sidebar.jsp", Long.valueOf(1636443453083L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("static poly.util.CmmUtil.nvl");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	String user_id = (String) request.getAttribute("user_id");
String user_email = (String) request.getAttribute("user_email");
String join_dt = (String) request.getAttribute("join_dt");
String user_name = "이재훈";
String user_mbti = "ENTP";
String user_dept = "데이터분석과";

String[] study_group = user_name.split("");
int study_count = study_group.length;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>Spoilbroth_StudyGroup</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("	content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"/andrea-master/css/open-iconic-bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/animate.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/owl.carousel.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"/andrea-master/css/owl.theme.default.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/magnific-popup.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/aos.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/ionicons.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"/andrea-master/css/bootstrap-datepicker.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/jquery.timepicker.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/flaticon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/icomoon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/andrea-master/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- profile -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/profile.css\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- profile -->\r\n");
      out.write("\r\n");
      out.write("<!-- owl -->\r\n");
      out.write("<script src=\"/andrea-master/js/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/owlowl.css\">\r\n");
      out.write("<!-- owl -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body data-aos-easing=\"slide\" data-aos-duration=\"800\" data-aos-delay=\"0\">\r\n");
      out.write("\r\n");
      out.write("	<!-- 전체 페이지 START-->\r\n");
      out.write("	<div id=\"colorlib-page\">\r\n");
      out.write("		<!-- START 왼쪽 NANI -->\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("\r\n");


	String id = nvl((String)session.getAttribute("user_id"));
	String date = nvl((String)session.getAttribute("join_dt")); 

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<!-- 구글폰트 -->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Pen+Script&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<a href=\"#\" class=\"js-colorlib-nav-toggle colorlib-nav-toggle\"><i></i></a>\r\n");
      out.write("		<aside id=\"colorlib-aside\" role=\"complementary\" class=\"js-fullheight\"\r\n");
      out.write("			style=\"height: 812px;\">\r\n");
      out.write("			\r\n");
      out.write("			<nav id=\"colorlib-main-menu\" role=\"navigation\">\r\n");
      out.write("			<a href=\"single.html\" class=\"img img-2\" style=\"background-image: url(/andrea-master/images/image_1.jpg);\"></a>\r\n");
      out.write("			<div class=\"colorlib-active\">\r\n");
      out.write("			<ul>\r\n");
      out.write("				<li>\r\n");
      out.write("					");
if(date.isEmpty()) { 
      out.write("\r\n");
      out.write("						<a href=\"/user/login.do\" style=\"font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 32px;\">가입 하시겠습니까?</a>\r\n");
      out.write("					");
 } else { 
      out.write("\r\n");
      out.write("						<a href=\"#\" style=\"font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 24px;\" method=post>첫방문  : ");
      out.print(date );
      out.write("</a>\r\n");
      out.write("					");
} 
      out.write("\r\n");
      out.write("				\r\n");
      out.write("				</li>\r\n");
      out.write("				<li>\r\n");
      out.write("					");
if(id.isEmpty()) { 
      out.write("\r\n");
      out.write("						<a href=\"/user/login.do\" style= \"font-family: 'Nanum Pen Script', cursive; font-size: 20px; padding-left: 70px;\">Sign in</a>\r\n");
      out.write("					");
 } else { 
      out.write("\r\n");
      out.write("						<a href=\"/user/logOut.do\" style=\" font-family: 'Nanum Pen Script', cursive; font-size: 24px; padding-left: 40px;\">");
      out.print(id );
      out.write(" 님 Log out</a>\r\n");
      out.write("					");
} 
      out.write("\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		</div>\r\n");
      out.write("		<hr style=\" width: 90%; height: 1.5px; border: none; background-color: #666666;\"/>\r\n");
      out.write("				<ul class=\"nav2\">\r\n");
      out.write("					<li class=\"colorlib-active\"><a href=\"/spoilbroth/mystudy.do\">Home</a></li>\r\n");
      out.write("					<li class=\"nana0\"><a href=\"/face/faceregister.do\">Face Register</a></li>\r\n");
      out.write("					<li class=\"nana1\"><a href=\"/mbti/mbtimain.do\">MBTI Analysis</a></li>\r\n");
      out.write("					<li class=\"nana2\"><a href=\"/study/match.do\">Study Matching</a></li>\r\n");
      out.write("					<li class=\"nana3\"><a href=\"/study/contest.do\">Study Imformation</a></li>\r\n");
      out.write("					<li class=\"nana4\"><a href=\"/study/studyplace.do\">Study Place</a></li>\r\n");
      out.write("					<li class=\"nana5\"><a href=\"/mypage/setting.do\">Setting</a></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</nav>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"colorlib-footer\" style=\"padding-bottom: 20px;\">\r\n");
      out.write("				<h1 id=\"colorlib-logo\" class=\"mb-4\">\r\n");
      out.write("					<a href=\"/spoilbroth/main.do\" style=\"background-image: url(/andrea-master/images/bg_1.jpg); font-size: 57px;\">Spoilbroth</a>\r\n");
      out.write("				</h1>\r\n");
      out.write("				<span style=\"font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 28px;\">요리사가 너무 많으면 수프를 망친다.</span>\r\n");
      out.write("				<div class=\"mb-4\">\r\n");
      out.write("					<h3>Subscribe for Spoilbroth</h3>\r\n");
      out.write("					<form action=\"#\" class=\"colorlib-subscribe-form\">\r\n");
      out.write("						<div class=\"form-group d-flex\">\r\n");
      out.write("							<div class=\"icon\">\r\n");
      out.write("								<span class=\"icon-paper-plane\"></span>\r\n");
      out.write("							</div>\r\n");
      out.write("							<input type=\"text\" class=\"form-control\"\r\n");
      out.write("								placeholder=\"Enter Email Address\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("				\r\n");
      out.write("			</div>\r\n");
      out.write("		</aside>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"/andrea-master/js/jquery.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("    var url = window.location.pathname;  \r\n");
      out.write("    var activePage = url.substring(url.lastIndexOf('/')+1);\r\n");
      out.write("    console.log(\"activePage: \" + activePage);\r\n");
      out.write("    \r\n");
      out.write("    $('.nav2 li a').each(function(){  \r\n");
      out.write("        var currentPage = this.href.substring(this.href.lastIndexOf('/')+1);\r\n");
      out.write("		console.log(\"currentPage : \"+currentPage)\r\n");
      out.write("		\r\n");
      out.write("        if (activePage == currentPage) {\r\n");
      out.write("        	$(\".nav2\").find(\".colorlib-active\").removeClass(\"colorlib-active\");\r\n");
      out.write("            $(this).parent().addClass('colorlib-active');\r\n");
      out.write("            $(this).addClass('colorlib-active');\r\n");
      out.write("            \r\n");
      out.write("        }else if(activePage == \"faceregister.do\"){\r\n");
      out.write("        	$(\".nav2\").find(\".colorlib-active\").removeClass(\"colorlib-active\");\r\n");
      out.write("        	$('.nana0').addClass('colorlib-active');\r\n");
      out.write("        }else if(activePage == \"mbtianalysis.do\"){\r\n");
      out.write("        	$(\".nav2\").find(\".colorlib-active\").removeClass(\"colorlib-active\");\r\n");
      out.write("        	$('.nana1').addClass('colorlib-active');\r\n");
      out.write("        }else if(activePage == \"match.do\"){\r\n");
      out.write("        	$(\".nav2\").find(\".colorlib-active\").removeClass(\"colorlib-active\");\r\n");
      out.write("        	$('.nana2').addClass('colorlib-active');\r\n");
      out.write("        }else if(activePage == \"contest.do\"){\r\n");
      out.write("        	$(\".nav2\").find(\".colorlib-active\").removeClass(\"colorlib-active\");\r\n");
      out.write("        	$('.nana3').addClass('colorlib-active');\r\n");
      out.write("        }else if(activePage == \"studyplace.do\"){\r\n");
      out.write("        	$(\".nav2\").find(\".colorlib-active\").removeClass(\"colorlib-active\");\r\n");
      out.write("        	$('.nana4').addClass('colorlib-active');\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("		<!-- END 왼쪽 NANI -->\r\n");
      out.write("\r\n");
      out.write("		<!-- START 상단 NANI -->\r\n");
      out.write("		<div class=\"padding\" style=\"padding-bottom: 100px;\"></div>\r\n");
      out.write("		<div class=\"sidebar-heading\"\r\n");
      out.write("			style=\"text-align: center; position: fixed; top: 0; width: 100%; height: 70px; background-color: #fff; z-index: 5; padding-top: 20px; font-weight: 500; color: black;\">\r\n");
      out.write("			<div class=\"hh\" style=\"font-size: 23px; height: 32px;\">\r\n");
      out.write("				<span>M</span><span>Y</span><span>P</span><span>A</span><span>S</span><span>E</span>\r\n");
      out.write("			</div>\r\n");
      out.write("			<hr style=\"width: 90%; height: 1.5px; border: none; background-color: #666666;\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- END 상단 NANI -->\r\n");
      out.write("\r\n");
      out.write("		<!-- 메인 페이지 START-->\r\n");
      out.write("		<div id=\"colorlib-main\">\r\n");
      out.write("			<section class=\"ftco-section ftco-no-pt ftco-no-pb\">\r\n");
      out.write("				<div class=\"container\">\r\n");
      out.write("					<!-- 왼쪽 오른쪽 2분할 -->\r\n");
      out.write("					<div class=\"row d-flex\">\r\n");
      out.write("\r\n");
      out.write("						<!-- 왼쪽 스크립트 -->\r\n");
      out.write("						<div class=\"col-xl-8 px-md-5\" style=\"background-color: #f7fbff;\">\r\n");
      out.write("							<!-- My 프로필 메인화면 -->\r\n");
      out.write("							<div class=\"emp-profile\" style=\"font-size: 25px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("								<div class=\"content\" style=\"padding-bottom: 50px;\">\r\n");
      out.write("									<div class=\"card\">\r\n");
      out.write("										<div class=\"card-header\">\r\n");
      out.write("											<h4 class=\"mt-0 mb-0 text-center\">\r\n");
      out.write("												<b>Setting</b>\r\n");
      out.write("											</h4>\r\n");
      out.write("										</div>\r\n");
      out.write("										<hr>\r\n");
      out.write("										<div class=\"card-body\">\r\n");
      out.write("\r\n");
      out.write("											<div style=\"text-align: center; font-size: 10px;\">\r\n");
      out.write("\r\n");
      out.write("												<h3>\r\n");
      out.write("													<button class=\"btn btn-warning btn-block btn-lg\"\r\n");
      out.write("														onclick=\"location='/mypage/mbtiModify.do'\">MBTI 변경\r\n");
      out.write("													</button>\r\n");
      out.write("												</h3>\r\n");
      out.write("												<br> <br>\r\n");
      out.write("												<h3>\r\n");
      out.write("													<button class=\"btn btn-warning btn-block btn-lg\"\r\n");
      out.write("														onclick=\"location='/mypage/userCorrection.do'\">회원정보\r\n");
      out.write("														수정</button>\r\n");
      out.write("												</h3>\r\n");
      out.write("												<br> <br>\r\n");
      out.write("												<h3>\r\n");
      out.write("													<button class=\"btn btn-warning btn-block btn-lg\"\r\n");
      out.write("														onclick=\"location='/mypage/passWordChange.do'\">비밀번호\r\n");
      out.write("														변경</button>\r\n");
      out.write("												</h3>\r\n");
      out.write("												<br> <br>\r\n");
      out.write("												<h3>\r\n");
      out.write("													<button class=\"btn btn-warning btn-block btn-lg\"\r\n");
      out.write("														onclick=\"location='/mypage/userDelete.do'\">회원\r\n");
      out.write("														탈퇴</button>\r\n");
      out.write("												</h3>\r\n");
      out.write("												<br> <br>\r\n");
      out.write("\r\n");
      out.write("											</div>\r\n");
      out.write("\r\n");
      out.write("										</div>\r\n");
      out.write("									</div>\r\n");
      out.write("									<!-- 뉴스 기사 끝. -->\r\n");
      out.write("									<!-- 다음으로 넘어가는 버튼 만들기  -->\r\n");
      out.write("\r\n");
      out.write("								</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- 그룹목록 END -->\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("			</section>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- 메인 페이지 END-->\r\n");
      out.write("\r\n");
      out.write("	<!-- 전체 페이지 END-->\r\n");
      out.write("\r\n");
      out.write("	<!-- loader -->\r\n");
      out.write("	<div id=\"ftco-loader\" class=\"fullscreen\">\r\n");
      out.write("		<svg class=\"circular\" width=\"48px\" height=\"48px\">\r\n");
      out.write("			<circle class=\"path-bg\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\"\r\n");
      out.write("				troke-width=\"4\" stroke=\"#eeeeee\"></circle>\r\n");
      out.write("			<circle class=\"path\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\"\r\n");
      out.write("				stroke-width=\"4\" stroke-miterlimit=\"10\" stroke=\"#F96D00\"></circle></svg>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script src=\"/andrea-master/js/jquery.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/jquery-migrate-3.0.1.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/popper.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/bootstrap.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/jquery.easing.1.3.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/jquery.waypoints.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/jquery.stellar.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/owl.carousel.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/aos.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/jquery.animateNumber.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/scrollax.min.js\"></script>\r\n");
      out.write("	<script src=\"/andrea-master/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$('.slider-1 > .owl-carousel').owlCarousel({\r\n");
      out.write("		autoplay : true, // 오토 플레이\r\n");
      out.write("		autoplayTimeout : 6000, // 오토 플레이 시에 다음 슬라이드로 넘어가는 주기, 2초\r\n");
      out.write("		loop : true,\r\n");
      out.write("		margin : 0,\r\n");
      out.write("		nav : true,\r\n");
      out.write("		navText : [],\r\n");
      out.write("		responsive : {\r\n");
      out.write("			0 : {\r\n");
      out.write("				items : 1\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("\r\n");
      out.write("	var $firstDot = $('.slider-1 > .owl-carousel > .owl-dots > .owl-dot.active');\r\n");
      out.write("\r\n");
      out.write("	$firstDot.removeClass('active');\r\n");
      out.write("\r\n");
      out.write("	setTimeout(function() {\r\n");
      out.write("		$firstDot.addClass('active');\r\n");
      out.write("	}, 100);\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
