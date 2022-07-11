package poly.controller;

import static poly.util.CmmUtil.nvl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.BoardDTO;
import poly.dto.OcrDTO;
import poly.dto.StudyListDTO;
import poly.dto.UserDTO;
import poly.service.IBoardService;
import poly.service.IContestService;
import poly.service.IImgService;
import poly.service.IStudyService;
import poly.service.IUserService;
import poly.util.DateUtil;
import poly.util.FileUtil;
import poly.util.MbtiUtil;

@Controller
public class KakaoMapController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "UserService")
	IUserService userService;

	@Resource(name = "StudyService")
	IStudyService studyService;

	@Resource(name = "ImgService")
	IImgService imgService;

	@Resource(name = "BoardService")
	IBoardService boardService;
	
	@Resource(name = "ContestService")
	IContestService contestService;
	
	// 스터디 카페 장소 찾기
	@RequestMapping(value = "study/studyplace")
	public String studyplace(HttpServletRequest request, HttpSession session, ModelMap model)throws Exception{
		
		String user_id = (String) session.getAttribute("user_id");
		log.info("user_id : " + user_id);
		if (user_id == null) {
			return "/user/login";
		}
		return "study/studyplace";
	}
}
