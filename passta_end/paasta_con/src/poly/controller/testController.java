package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.OcrDTO;
import poly.service.IImgService;
import poly.util.UploadFileUtil;

// 테스트 코드 작성 Controller
@Controller
public class testController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "ImgService")
	IImgService imgService;
	
	//////////////////////// 이미지 테스트 코드 start ////////////////////////
	// 프로필 이미지가 업로드되는 파일이 저장되는 기본폴더 설정(자바에서 경로는 /로 표현함)
	final private String USERFILE_UPLOAD_SAVE_PATH = "C:\\userimg"; // C:\\upload 폴더에 저장 /upload
	// 스터디 이미지가 업로드되는 기본폴더 설정
	final private String STUDYFILE_UPLOAD_SAVE_PATH = "C:\\studyimg"; // C:\\upload 폴더에 저장 /upload
	
	// 프로필 이미지파일 업로드 (ajax로 구현)
	@RequestMapping(value = "testFileUpload")
	@ResponseBody
	public void testFileUpload(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(value = "testFileUpload") MultipartFile mf, HttpSession session) throws Exception {
		
		String user_id = (String) session.getAttribute("user_id");
		
		log.info("FileUplod start");
		int res = 0;
		// 파일 업로드
		OcrDTO pDTO = UploadFileUtil.uploadfile(mf, USERFILE_UPLOAD_SAVE_PATH, user_id);
		
		// 파일 저장할 경로를 DB에 저장
		System.out.println("imgService start!!");
		res = imgService.InsertImage(pDTO);
		System.out.println("imgService end!!");
		System.out.println("res : " + res);
	}

	@RequestMapping(value = "test/imageupload")
	public String test(HttpServletRequest request, ModelMap model) throws Exception {
		log.info("imageupload start ");
		log.info("imageupload end");

		return "test/imageupload";

	}
	////////////////////////이미지 테스트 코드 end ////////////////////////

}
