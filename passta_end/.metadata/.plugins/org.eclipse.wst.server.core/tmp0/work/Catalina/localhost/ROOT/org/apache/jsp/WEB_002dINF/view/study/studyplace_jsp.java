/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2021-11-25 12:14:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import poly.dto.ContestDTO;
import java.util.List;
import static poly.util.CmmUtil.nvl;

public final class studyplace_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("static poly.util.CmmUtil.nvl");
    _jspx_imports_classes.add("poly.dto.ContestDTO");
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("\r\n");
      out.write("\r\n");

	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>Spoilbroth_StudyPlace</title>\r\n");
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
      out.write("\r\n");
      out.write("<!-- data table -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/map.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("/* ????????? (??????) */\r\n");
      out.write("div.dataTables_filter {\r\n");
      out.write("	text-align: left !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* ?????? ????????? ?????? */\r\n");
      out.write("div.dataTables_length {\r\n");
      out.write("	text-align: left !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body data-aos-easing=\"slide\" data-aos-duration=\"800\" data-aos-delay=\"0\">\r\n");
      out.write("\r\n");
      out.write("	<!-- ?????? ????????? START-->\r\n");
      out.write("	<div id=\"colorlib-page\">\r\n");
      out.write("		<!-- START ?????? NANI -->\r\n");
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
      out.write("<!-- ???????????? -->\r\n");
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
      out.write("						<a href=\"/user/login.do\" style=\"font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 32px;\">?????? ???????????????????</a>\r\n");
      out.write("					");
 } else { 
      out.write("\r\n");
      out.write("						<a href=\"#\" style=\"font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 24px;\" method=post>?????????  : ");
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
      out.write(" ??? Log out</a>\r\n");
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
      out.write("				<span style=\"font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive; font-size: 28px;\">???????????? ?????? ????????? ????????? ?????????.</span>\r\n");
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
      out.write("		<!-- END ?????? NANI -->\r\n");
      out.write("\r\n");
      out.write("		<!-- START ?????? NANI -->\r\n");
      out.write("		<div class=\"padding\" style=\"padding-bottom: 90px;\"></div>\r\n");
      out.write("		<div class=\"sidebar-heading\"\r\n");
      out.write("			style=\"text-align: center; position: fixed; top: 0; width: 100%; background-color: #fff; z-index: 5; padding-top: 20px; font-weight: 500; color: black;\">\r\n");
      out.write("			<div class=\"hh\" style=\"font-size: 23px; height: 32px;\">\r\n");
      out.write("				<span>S</span><span>T</span><span>U</span><span>D</span><span>Y</span><span>&nbsp;</span><span>P</span><span>L</span><span>A</span><span>C</span><span>E</span>\r\n");
      out.write("			</div>\r\n");
      out.write("			<hr\r\n");
      out.write("				style=\"width: 90%; height: 1.5px; border: none; background-color: #666666;\">\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- END ?????? NANI -->\r\n");
      out.write("\r\n");
      out.write("		<!-- ?????? ????????? START-->\r\n");
      out.write("		<div id=\"colorlib-main\">\r\n");
      out.write("			<section class=\"ftco-section ftco-no-pt ftco-no-pb\">\r\n");
      out.write("				<div class=\"container\">\r\n");
      out.write("					<!-- ?????? ????????? 2?????? -->\r\n");
      out.write("					<div class=\"row d-flex\">\r\n");
      out.write("\r\n");
      out.write("						<!-- ?????? ???????????? -->\r\n");
      out.write("						<div class=\"col-xl-8 px-md-5\" style=\"background-color: #f7fbff;\">\r\n");
      out.write("\r\n");
      out.write("							<!-- My ????????? ???????????? -->\r\n");
      out.write("							<div class=\"emp-profile\" style=\"\">\r\n");
      out.write("								<label\r\n");
      out.write("									style=\"font-size: 30px; font-family: 'Do Hyeon', sans-serif; font-family: 'Nanum Pen Script', cursive;\">\r\n");
      out.write("									????????? ?????? ???????????? </label>\r\n");
      out.write("								<hr style=\"margin-top: 0px; margin-bottom: 8px;\" />\r\n");
      out.write("\r\n");
      out.write("								<div class=\"row\" style=\"font-size: 11px; margin: 0px;\">\r\n");
      out.write("									<!-- ????????? ????????? ?????? -->\r\n");
      out.write("									<div class=\"map_wrap\">\r\n");
      out.write("									    <div id=\"map\" style=\"width:100%;height:100%;position:relative;overflow:hidden;\"></div>\r\n");
      out.write("									</div>\r\n");
      out.write("									<!-- ????????? ?????? -->\r\n");
      out.write("									<div class=\"map_wrap\" style=\"margin-top: 10px; height: 100%;\">\r\n");
      out.write("										<div id=\"menu_wrap\" class=\"bg_white\">\r\n");
      out.write("									        <div class=\"option\">\r\n");
      out.write("									            <div>\r\n");
      out.write("									                <form onsubmit=\"searchPlaces(); return false;\">\r\n");
      out.write("									                    ????????? : <input type=\"text\" value=\"?????? ???????????????\" id=\"keyword\" size=\"15\"> \r\n");
      out.write("									                    <button type=\"submit\">????????????</button> \r\n");
      out.write("									                </form>\r\n");
      out.write("									            </div>\r\n");
      out.write("									        </div>\r\n");
      out.write("									        <hr>\r\n");
      out.write("									        <ul id=\"placesList\" style=\" padding-left: 0px;\"></ul>\r\n");
      out.write("									        <div id=\"pagination\"></div>\r\n");
      out.write("									    </div>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("\r\n");
      out.write("							<!-- Join Study Group -->\r\n");
      out.write("							<!-- ???????????? START -->\r\n");
      out.write("							<div class=\"row pt-md-4\">\r\n");
      out.write("								<div class=\"col-md-12\">\r\n");
      out.write("									<!-- ????????? ????????? -->\r\n");
      out.write("\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<!-- ???????????? END -->\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<!-- ????????? ???????????? -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</section>\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- ?????? ????????? END-->\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- ?????? ????????? END-->\r\n");
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
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=ca9ca185a462a7a555b9983adefd2093&libraries=services\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	window.addEventListener(\"load\",function() {\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	// ????????? ?????? ???????????????\r\n");
      out.write("	var markers = [];\r\n");
      out.write("\r\n");
      out.write("	var mapContainer = document.getElementById('map'), // ????????? ????????? div \r\n");
      out.write("	    mapOption = {\r\n");
      out.write("	        center: new kakao.maps.LatLng(37.566826, 126.9786567), // ????????? ????????????\r\n");
      out.write("	        level: 3 // ????????? ?????? ??????\r\n");
      out.write("	    };  \r\n");
      out.write("\r\n");
      out.write("	// ????????? ???????????????    \r\n");
      out.write("	var map = new kakao.maps.Map(mapContainer, mapOption); \r\n");
      out.write("\r\n");
      out.write("	// ?????? ?????? ????????? ???????????????\r\n");
      out.write("	var ps = new kakao.maps.services.Places();  \r\n");
      out.write("\r\n");
      out.write("	// ?????? ?????? ???????????? ????????? ???????????? ??? ???????????? ????????? ?????????????????? ???????????????\r\n");
      out.write("	var infowindow = new kakao.maps.InfoWindow({zIndex:1});\r\n");
      out.write("\r\n");
      out.write("	// ???????????? ????????? ???????????????\r\n");
      out.write("	searchPlaces();\r\n");
      out.write("\r\n");
      out.write("	// ????????? ????????? ???????????? ???????????????\r\n");
      out.write("	function searchPlaces() {\r\n");
      out.write("\r\n");
      out.write("	    var keyword = document.getElementById('keyword').value;\r\n");
      out.write("\r\n");
      out.write("	    if (!keyword.replace(/^\\s+|\\s+$/g, '')) {\r\n");
      out.write("	        swal ('???????????? ??????????????????.!');\r\n");
      out.write("	        return false;\r\n");
      out.write("	    }\r\n");
      out.write("\r\n");
      out.write("	    // ???????????? ????????? ?????? ???????????? ??????????????? ???????????????\r\n");
      out.write("	    ps.keywordSearch( keyword, placesSearchCB); \r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// ??????????????? ???????????? ??? ???????????? ???????????? ?????????\r\n");
      out.write("	function placesSearchCB(data, status, pagination) {\r\n");
      out.write("	    if (status === kakao.maps.services.Status.OK) {\r\n");
      out.write("\r\n");
      out.write("	        // ??????????????? ????????? ???????????????\r\n");
      out.write("	        // ?????? ????????? ????????? ???????????????\r\n");
      out.write("	        displayPlaces(data);\r\n");
      out.write("\r\n");
      out.write("	        // ????????? ????????? ???????????????\r\n");
      out.write("	        displayPagination(pagination);\r\n");
      out.write("\r\n");
      out.write("	    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {\r\n");
      out.write("\r\n");
      out.write("	        swal ('?????? ????????? ???????????? ????????????.');\r\n");
      out.write("	        return;\r\n");
      out.write("\r\n");
      out.write("	    } else if (status === kakao.maps.services.Status.ERROR) {\r\n");
      out.write("\r\n");
      out.write("	        swal ('?????? ?????? ??? ????????? ??????????????????.');\r\n");
      out.write("	        return;\r\n");
      out.write("\r\n");
      out.write("	    }\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// ?????? ?????? ????????? ????????? ???????????? ???????????????\r\n");
      out.write("	function displayPlaces(places) {\r\n");
      out.write("\r\n");
      out.write("	    var listEl = document.getElementById('placesList'), \r\n");
      out.write("	    menuEl = document.getElementById('menu_wrap'),\r\n");
      out.write("	    fragment = document.createDocumentFragment(), \r\n");
      out.write("	    bounds = new kakao.maps.LatLngBounds(), \r\n");
      out.write("	    listStr = '';\r\n");
      out.write("	    \r\n");
      out.write("	    // ?????? ?????? ????????? ????????? ???????????? ???????????????\r\n");
      out.write("	    removeAllChildNods(listEl);\r\n");
      out.write("\r\n");
      out.write("	    // ????????? ???????????? ?????? ????????? ???????????????\r\n");
      out.write("	    removeMarker();\r\n");
      out.write("	    \r\n");
      out.write("	    for ( var i=0; i<places.length; i++ ) {\r\n");
      out.write("\r\n");
      out.write("	        // ????????? ???????????? ????????? ???????????????\r\n");
      out.write("	        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),\r\n");
      out.write("	            marker = addMarker(placePosition, i), \r\n");
      out.write("	            itemEl = getListItem(i, places[i]); // ?????? ?????? ?????? Element??? ???????????????\r\n");
      out.write("\r\n");
      out.write("	        // ????????? ?????? ????????? ???????????? ?????? ????????? ?????????????????????\r\n");
      out.write("	        // LatLngBounds ????????? ????????? ???????????????\r\n");
      out.write("	        bounds.extend(placePosition);\r\n");
      out.write("\r\n");
      out.write("	        // ????????? ???????????? ????????? mouseover ?????????\r\n");
      out.write("	        // ?????? ????????? ?????????????????? ???????????? ???????????????\r\n");
      out.write("	        // mouseout ?????? ?????? ?????????????????? ????????????\r\n");
      out.write("	        (function(marker, title) {\r\n");
      out.write("	            kakao.maps.event.addListener(marker, 'click', function() {\r\n");
      out.write("	                displayInfowindow(marker, title);\r\n");
      out.write("	            });\r\n");
      out.write("\r\n");
      out.write("	            kakao.maps.event.addListener(marker, 'mouseout', function() {\r\n");
      out.write("	                infowindow.close();\r\n");
      out.write("	            });\r\n");
      out.write("\r\n");
      out.write("	            itemEl.onmouseover =  function () {\r\n");
      out.write("	                displayInfowindow(marker, title);\r\n");
      out.write("	            };\r\n");
      out.write("\r\n");
      out.write("	            itemEl.onmouseout =  function () {\r\n");
      out.write("	                infowindow.close();\r\n");
      out.write("	            };\r\n");
      out.write("	        })(marker, places[i].place_name);\r\n");
      out.write("\r\n");
      out.write("	        fragment.appendChild(itemEl);\r\n");
      out.write("	    }\r\n");
      out.write("\r\n");
      out.write("	    // ???????????? ???????????? ???????????? ?????? Elemnet??? ???????????????\r\n");
      out.write("	    listEl.appendChild(fragment);\r\n");
      out.write("	    menuEl.scrollTop = 0;\r\n");
      out.write("\r\n");
      out.write("	    // ????????? ?????? ????????? ???????????? ?????? ????????? ??????????????????\r\n");
      out.write("	    map.setBounds(bounds);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// ???????????? ????????? Element??? ???????????? ???????????????\r\n");
      out.write("	function getListItem(index, places) {\r\n");
      out.write("	    var el = document.createElement('li'),\r\n");
      out.write("	    itemStr = '<span class=\"markerbg marker_' + (index+1) + '\"></span>' +\r\n");
      out.write("	                '<div class=\"info\">' +\r\n");
      out.write("	                '   <h5>' + places.place_name + '</h5>';\r\n");
      out.write("\r\n");
      out.write("	    if (places.road_address_name) {\r\n");
      out.write("	        itemStr += '    <span>' + places.road_address_name + '</span>' +\r\n");
      out.write("	                    '   <span class=\"jibun gray\">' +  places.address_name  + '</span>';\r\n");
      out.write("	    } else {\r\n");
      out.write("	        itemStr += '    <span>' +  places.address_name  + '</span>'; \r\n");
      out.write("	    }\r\n");
      out.write("	                 \r\n");
      out.write("	      itemStr += '  <span class=\"tel\">' + places.phone  + '</span>' +\r\n");
      out.write("	                '</div>';           \r\n");
      out.write("\r\n");
      out.write("	    el.innerHTML = itemStr;\r\n");
      out.write("	    el.className = 'item';\r\n");
      out.write("\r\n");
      out.write("	    return el;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// ????????? ???????????? ?????? ?????? ????????? ???????????? ???????????????\r\n");
      out.write("	function addMarker(position, idx, title) {\r\n");
      out.write("	    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // ?????? ????????? url, ??????????????? ???????????? ?????????\r\n");
      out.write("	        imageSize = new kakao.maps.Size(36, 37),  // ?????? ???????????? ??????\r\n");
      out.write("	        imgOptions =  {\r\n");
      out.write("	            spriteSize : new kakao.maps.Size(36, 691), // ??????????????? ???????????? ??????\r\n");
      out.write("	            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // ??????????????? ????????? ??? ????????? ????????? ????????? ??????\r\n");
      out.write("	            offset: new kakao.maps.Point(13, 37) // ?????? ????????? ???????????? ????????? ???????????? ??????\r\n");
      out.write("	        },\r\n");
      out.write("	        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),\r\n");
      out.write("	            marker = new kakao.maps.Marker({\r\n");
      out.write("	            position: position, // ????????? ??????\r\n");
      out.write("	            image: markerImage \r\n");
      out.write("	        });\r\n");
      out.write("\r\n");
      out.write("	    marker.setMap(map); // ?????? ?????? ????????? ???????????????\r\n");
      out.write("	    markers.push(marker);  // ????????? ????????? ????????? ???????????????\r\n");
      out.write("\r\n");
      out.write("	    return marker;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// ?????? ?????? ???????????? ?????? ????????? ?????? ???????????????\r\n");
      out.write("	function removeMarker() {\r\n");
      out.write("	    for ( var i = 0; i < markers.length; i++ ) {\r\n");
      out.write("	        markers[i].setMap(null);\r\n");
      out.write("	    }   \r\n");
      out.write("	    markers = [];\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// ???????????? ?????? ????????? ?????????????????? ????????? ???????????????\r\n");
      out.write("	function displayPagination(pagination) {\r\n");
      out.write("	    var paginationEl = document.getElementById('pagination'),\r\n");
      out.write("	        fragment = document.createDocumentFragment(),\r\n");
      out.write("	        i; \r\n");
      out.write("\r\n");
      out.write("	    // ????????? ????????? ?????????????????? ???????????????\r\n");
      out.write("	    while (paginationEl.hasChildNodes()) {\r\n");
      out.write("	        paginationEl.removeChild (paginationEl.lastChild);\r\n");
      out.write("	    }\r\n");
      out.write("\r\n");
      out.write("	    for (i=1; i<=pagination.last; i++) {\r\n");
      out.write("	        var el = document.createElement('a');\r\n");
      out.write("	        el.href = \"#\";\r\n");
      out.write("	        el.innerHTML = i;\r\n");
      out.write("\r\n");
      out.write("	        if (i===pagination.current) {\r\n");
      out.write("	            el.className = 'on';\r\n");
      out.write("	        } else {\r\n");
      out.write("	            el.onclick = (function(i) {\r\n");
      out.write("	                return function() {\r\n");
      out.write("	                    pagination.gotoPage(i);\r\n");
      out.write("	                }\r\n");
      out.write("	            })(i);\r\n");
      out.write("	        }\r\n");
      out.write("\r\n");
      out.write("	        fragment.appendChild(el);\r\n");
      out.write("	    }\r\n");
      out.write("	    paginationEl.appendChild(fragment);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// ???????????? ?????? ?????? ????????? ???????????? ??? ???????????? ???????????????\r\n");
      out.write("	// ?????????????????? ???????????? ???????????????\r\n");
      out.write("	function displayInfowindow(marker, title) {\r\n");
      out.write("	    var content = '<div style=\"padding:5px;z-index:1;\">' + title + '</div>';\r\n");
      out.write("\r\n");
      out.write("	    infowindow.setContent(content);\r\n");
      out.write("	    infowindow.open(map, marker);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	 // ???????????? ????????? ?????? Element??? ???????????? ???????????????\r\n");
      out.write("	function removeAllChildNods(el) {   \r\n");
      out.write("	    while (el.hasChildNodes()) {\r\n");
      out.write("	        el.removeChild (el.lastChild);\r\n");
      out.write("	    }\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
