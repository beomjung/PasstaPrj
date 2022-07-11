package poly.controller;

import static poly.util.CmmUtil.nvl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import poly.dto.BoardDTO;
import poly.dto.OcrDTO;
import poly.service.IBoardService;
import poly.service.IImgService;
import poly.service.IStudyService;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.FileUtil;
import poly.util.S3Util;


@Controller
public class NoticeController {

	private Logger log = Logger.getLogger(this.getClass());

	final private String FILE_UPLOAD_SAVE_PATH = "c:/upload";

	@Resource(name = "UserService")
	IUserService userService;

	@Resource(name = "StudyService")
	IStudyService studyService;

	@Resource(name = "BoardService")
	IBoardService boardService;

	@Resource(name = "ImgService")
	private IImgService imgService;

	/**
	 * 게시판 리스트 보여주기
	 */
	@RequestMapping(value = "board/BoardReg", method = RequestMethod.GET)
	public String BoardReg(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".BoardReg start!");
		String study_seq = nvl(request.getParameter("study_seq"));
		String study_name = studyService.getStudyName(study_seq);

		model.addAttribute("study_seq", study_seq);
		model.addAttribute("study_name", study_name);
		log.info(this.getClass().getName() + ".BoardReg end!");

		return "/board/BoardReg";
	}

	/**
	 * 게시판 글 등록
	 */
	@RequestMapping(value = "board/BoardInsert", method = RequestMethod.POST)
	public String BoardInsert(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model, MultipartHttpServletRequest mft) throws Exception {

		log.info(this.getClass().getName() + ".BoardInsert start!");

		String msg = "";
		String url = "";

		try {

			int res1 = 0;
			/*
			 * 게시판 글 등록되기 위해 사용되는 form객체의 하위 input 객체 등을 받아오기 위해 사용함
			 */
			String user_id = CmmUtil.nvl((String) session.getAttribute("user_id")); // 아이디
			String title = CmmUtil.nvl(request.getParameter("title")); // 제목
			String notice_yn = CmmUtil.nvl(request.getParameter("notice_yn")); // 공지글 여부
			String contents = CmmUtil.nvl(request.getParameter("contents")); // 내용
			String study_seq = CmmUtil.nvl(request.getParameter("study_seq")); // 스터디 그룹 고유번호
			String study_name = studyService.getStudyName(study_seq);

			/*
			 * ####################################################### 반드시, 값을 받았으면, 꼭 로그를
			 * 찍어서 값이 제대로 들어오는지 파악해야함 반드시 작성할 것
			 * #######################################################
			 */
			log.info("user_id : " + user_id);
			log.info("title : " + title);
			log.info("notice_yn : " + notice_yn);
			log.info("contents : " + contents);
			log.info("study_seq : " + study_seq);

			BoardDTO pDTO = new BoardDTO();

			pDTO.setUser_id(user_id);
			pDTO.setTitle(title);
			pDTO.setNotice_yn(notice_yn);
			pDTO.setContents(contents);
			pDTO.setStudy_seq(study_seq);
			pDTO.setReg_dt(DateUtil.getDateTime("yyyy-MM-dd"));
			pDTO.setStudy_seq(study_seq);
			/*
			 * 게시글 등록하기위한 비즈니스 로직을 호출
			 */
			res1 = boardService.InsertBoardInfo(pDTO);
			BoardDTO rDTO = new BoardDTO();

			if (res1 == 1) {
				log.info("게시판 입력 성공");
				rDTO = boardService.getNotiSeq(pDTO);
			} else {
				log.info("게시판 입력 실패");
			}
			log.info(rDTO.getNotice_seq());
			String notice_seq = CmmUtil.nvl(rDTO.getNotice_seq());

			int res = 0;
			int i = 0;
			OcrDTO fDTO = null;

			List<MultipartFile> fileList = mft.getFiles("studyfileUpload");
			for (MultipartFile mf : fileList) {
				i++;
				String originalFileName = mf.getOriginalFilename();

				// 파일 확장자 가져오기
				String ext = originalFileName
						.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()).toLowerCase();

				
				String saveFileName = originalFileName;

				// 웹 서버에 업로드한 파일 저장하는 물리적 경로
				String saveFilePath = FileUtil.mkdirForDate(FILE_UPLOAD_SAVE_PATH);

				String fullFileInfo = saveFilePath + "/" + originalFileName;

				log.info("ext : " + ext);
				log.info("saveFileName : " + saveFileName);
				log.info("saveFilePath : " + saveFilePath);
				log.info("fullFileInfo : " + fullFileInfo);
				
				mf.transferTo(new File(fullFileInfo));
				  S3Util s3 = new S3Util();
			     
			        String bucketName = "passtafile";
			        System.out.println("Bucket Name : " + bucketName);
			         
			        // 파일 업로드
			        String fileName = fullFileInfo;
			        log.info(fileName);
			        
			        s3.fileUpload(bucketName, new File(fileName));
			        log.info(s3.getFileURL(bucketName, saveFileName));

			        String fileurl = S3Util.getFileURL(bucketName, fileName);
			        log.info(fileurl);
			        
				 

				fDTO = new OcrDTO();

				fDTO.setSave_file_name(saveFileName);// 저장되는 파일명
				fDTO.setSave_file_path(fileurl);// 저장되는 경로
				fDTO.setOrg_file_name(originalFileName);
				fDTO.setNotice_seq((String) session.getAttribute("notice_seq"));
				// 원래 파일명
				fDTO.setExt(ext);
				// 확장자명
				fDTO.setChg_id(user_id);
				fDTO.setStudy_seq(study_seq);
				fDTO.setChg_dt(DateUtil.getDateTime("yyyy-MM-dd-hh:mm:ss"));
				fDTO.setNotice_seq(notice_seq);
				fDTO.setFull_file_info(fullFileInfo);

				int result = imgService.insertFilePath(fDTO);

				/* res += ocrService.InsertImage(rList); */

				// 업로드 되는 파일을 서버에 저장
				log.info(result);
				// mf.transferTo(targetFile);
				

			}

			// 저장이 완료되면 사용자에게 보여줄 메시지
			msg = "등록되었습니다.";

			// 변수 초기화(메모리 효율화 시키기 위해 사용함)
			pDTO = null;

		} catch (Exception e) {

			// 저장이 실패되면 사용자에게 보여줄 메시지
			msg = "실패하였습니다. : " + e.toString();
			log.info(e.toString());
			e.printStackTrace();

		} finally {
			log.info(this.getClass().getName() + ".BoardInsert end!");
			String study_seq = CmmUtil.nvl(request.getParameter("study_seq")); // 스터디 그룹 고유번호
			String study_name = studyService.getStudyName(study_seq);

			url = "/study/studyboard.do?study_name=" + study_name;
			// 결과 메시지 전달하기
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);

		}

		return "/redirect";
	}

	/**
	 * 게시판 상세보기
	 */
	@RequestMapping(value = "board/BoardInfo", method = RequestMethod.GET)
	public String BoardInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

		log.info(this.getClass().getName() + ".BoardInfo start!");

		/*
		 * 게시판 글 등록되기 위해 사용되는 form객체의 하위 input 객체 등을 받아오기 위해 사용함
		 */
		String notice_seq = nvl(request.getParameter("notice_seq")); // 공지글번호(PK)
		String study_seq = nvl(request.getParameter("study_seq"));

		String study_name = studyService.getStudyName(study_seq);

		/*
		 * ####################################################### 반드시, 값을 받았으면, 꼭 로그를
		 * 찍어서 값이 제대로 들어오는지 파악해야함 반드시 작성할 것
		 * #######################################################
		 */
		log.info("notice_seq : " + notice_seq);
		log.info("study_seq : " + study_seq);
		log.info("study_name : " + study_name);

		List<OcrDTO> fList = boardService.getFileList(notice_seq);
		log.info(fList);

		/*
		 * 값 전달은 반드시 DTO 객체를 이용해서 처리함 전달 받은 값을 DTO 객체에 넣는다.
		 */
		BoardDTO pDTO = new BoardDTO();

		pDTO.setNotice_seq(notice_seq);
		pDTO.setStudy_seq(study_seq);

		// 공지사항 글 조회수 증가
		boardService.updateBoardReadCnt(pDTO);

		log.info("read_cnt update success!!!");

		// 공지사항 상세정보 가져오기
		BoardDTO rDTO = boardService.getBoardInfo(pDTO);

		if (rDTO == null) {
			rDTO = new BoardDTO();

		}

		//

		log.info("getBoardInfo success!!!");

		// 조회된 리스트 결과값 넣어주기
		model.addAttribute("rDTO", rDTO);
		model.addAttribute("fList", fList);
		model.addAttribute("study_name", study_name);
		// 변수 초기화(메모리 효율화 시키기 위해 사용함)
		rDTO = null;
		pDTO = null;

		log.info(this.getClass().getName() + ".BoardInfo end!");

		return "/board/BoardInfo";
	}

	/**
	 * 게시판 수정 보기
	 */
	@RequestMapping(value = "board/BoardEditInfo", method = RequestMethod.GET)
	public String BoardEditInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {

		log.info(this.getClass().getName() + ".BoardEditInfo start!");

		String notice_seq = nvl(request.getParameter("notice_seq")); // 공지글번호(PK)
		String study_seq = nvl(request.getParameter("study_seq")); // 스터디 고유번호

		log.info("notice_seq : " + notice_seq);

		BoardDTO pDTO = new BoardDTO();

		pDTO.setNotice_seq(notice_seq);
		pDTO.setStudy_seq(study_seq);
		/*
		 * ####################################################### 공지사항 수정정보 가져오기(상세보기
		 * 쿼리와 동일하여, 같은 서비스 쿼리 사용함)
		 * #######################################################
		 */
		BoardDTO rDTO = boardService.getBoardInfo(pDTO);

		if (rDTO == null) {
			rDTO = new BoardDTO();

		}
		
		List<OcrDTO> fList = boardService.getFileList(notice_seq);
		log.info(fList);

		// 조회된 리스트 결과값 넣어주기
		model.addAttribute("rDTO", rDTO);
		model.addAttribute("fList", fList);
		
		// 변수 초기화(메모리 효율화 시키기 위해 사용함)
		rDTO = null;
		pDTO = null;

		log.info(this.getClass().getName() + ".BoardEditInfo end!");

		return "/board/BoardEditInfo";
	}

	/**
	 * 게시판 글 수정
	 */
	@RequestMapping(value = "board/BoardUpdate", method = RequestMethod.POST)
	public String BoardUpdate(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {

		log.info(this.getClass().getName() + ".BoardUpdate start!");

		String msg = "";
		String url = "";

		try {

			String user_id = nvl((String) session.getAttribute("user_id")); // 아이디
			String notice_seq = nvl(request.getParameter("notice_seq")); // 글번호(PK)
			String title = nvl(request.getParameter("title")); // 제목
			String notice_yn = nvl(request.getParameter("notice_yn")); // 공지글 여부
			String contents = nvl(request.getParameter("contents")); // 내용
			String study_seq = nvl(request.getParameter("study_seq")); // 스터 고유번호

			log.info("user_id : " + user_id);
			log.info("notice_seq : " + notice_seq);
			log.info("title : " + title);
			log.info("notice_yn : " + notice_yn);
			log.info("contents : " + contents);


			BoardDTO pDTO = new BoardDTO();

			pDTO.setUser_id(user_id);
			pDTO.setNotice_seq(notice_seq);
			pDTO.setTitle(title);
			pDTO.setNotice_yn(notice_yn);
			pDTO.setContents(contents);
			pDTO.setChg_dt(DateUtil.getDateTime("yyyy-MM-dd"));
			pDTO.setStudy_seq(study_seq);
			
			BoardDTO dDTO = new BoardDTO();
			dDTO.setNotice_seq(notice_seq);
		
			// 게시글 수정하기 DB
			boardService.updateBoardInfo(pDTO);
			
			msg = "수정되었습니다.";
			url = "/board/BoardInfo.do?notice_seq=" + nvl(request.getParameter("notice_seq")) + "&&study_seq="
					+ nvl(request.getParameter("study_seq"));

			// 변수 초기화(메모리 효율화 시키기 위해 사용함)
			pDTO = null;

		} catch (Exception e) {
			msg = "실패하였습니다. : " + e.toString();
			url = "/board/BoardInfo.do?notice_seq=" + nvl(request.getParameter("notice_seq")) + "&&study_seq="
					+ nvl(request.getParameter("study_seq"));
			log.info(e.toString());
			e.printStackTrace();

		} finally {
			log.info(this.getClass().getName() + ".BoardUpdate end!");

			// 결과 메시지 전달하기
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);

		}

		return "/redirect";
	}

	/**
	 * 게시판 글 삭제
	 */
	@RequestMapping(value = "board/BoardDelete", method = RequestMethod.GET)
	public String BoardDelete(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {

		log.info(this.getClass().getName() + ".BoardDelete start!");

		String msg = "";
		String url = "";

		try {

			String notice_seq = nvl(request.getParameter("notice_seq")); // 글번호(PK)
			String study_seq = nvl(request.getParameter("study_seq"));

			String study_name = studyService.getStudyName(study_seq);

			BoardDTO pDTO = new BoardDTO();
			BoardDTO dDTO = new BoardDTO();
			pDTO.setNotice_seq(notice_seq);
			pDTO.setStudy_seq(study_seq);
			
			
			// 게시글 삭제하기 DB
			boardService.deleteBoardInfo(pDTO);
			
			//파일삭제
			dDTO.setNotice_seq(notice_seq);
			boardService.delBoardFile(dDTO);
			
			

			msg = "삭제되었습니다.";
			url = "/study/studyboard.do?study_name=" + study_name;
			// 변수 초기화(메모리 효율화 시키기 위해 사용함)
			pDTO = null;

		} catch (Exception e) {
			String study_seq = nvl(request.getParameter("study_seq"));
			String study_name = studyService.getStudyName(study_seq);

			msg = "실패하였습니다. : " + e.toString();
			url = "/study/studyboard.do?study_name=" + study_name;
			log.info(e.toString());
			e.printStackTrace();

		} finally {
			log.info(this.getClass().getName() + ".BoardDelete end!");

			// 결과 메시지 전달하기
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
		}

		return "/redirect";
	}

	@RequestMapping("/boadDown")
	public ModelAndView board(@RequestParam HashMap<Object, Object> params, ModelAndView mv) {
		mv.setViewName("board/BoardInfo");
		return mv;
	}

}
