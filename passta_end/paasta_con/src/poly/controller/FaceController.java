package poly.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import poly.dto.FaceDTO;
import poly.dto.UserDTO;
import poly.service.IFaceService;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.FileUtil;

@Controller
public class FaceController {

	@Resource(name = "FaceService")
	IFaceService faceSerivice;

	@Resource(name = "UserService")
	IUserService userService;

	private Logger log = Logger.getLogger(this.getClass());

	final private String FACE_UPLOAD_SAVE_PATH = "/faceimg"; // C:\\faceimg 폴더에 저장, 윈도우용 경로
	final private String FACE_MODEL_PATH = "/python_upload/model"; // C:\\faceimg 폴더에 저장, 윈도우용 경로

	@RequestMapping(value = "face/faceregister")
	public String faceregister(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {

		String user_id = (String) session.getAttribute("user_id");
		log.info("user_id : " + user_id);
		if (user_id == null) {
			return "/user/login";
		}
		model.addAttribute("user_id", user_id);
		return "face/faceregister";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "face/faceupload")
	@ResponseBody
	public int faceupload(HttpServletRequest request, HttpSession session, @RequestBody Map<String, Object> param)
			throws Exception {
		int res = 1;
		String user_id = (String) session.getAttribute("user_id");
		log.info("user_id : " + user_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(param.get("imglist"));

//		JSONParser jsonParse = new JSONParser();
//		JSONArray jsonArray = new JSONArray();
//		jsonArray.add(user_id);
//		JSONArray jsonArray = (JSONArray) jsonParse.parse(jsonString);
//		JSONObject jsonob = new JSONObject();
//		jsonob.put("img", jsonArray);
		
		String saveFilePath = FileUtil.mkdirface(FACE_UPLOAD_SAVE_PATH, user_id);

//		for (int i = 0; i < jsonArray.size(); ++i) {
//			String img = String.valueOf(jsonArray.get(i));
//
//			byte[] inputFile = null;
//			try {
//				if (img == null || img.trim().equals("")) {
//					throw new Exception();
//				}
//
//				inputFile = Base64.decodeBase64(img);
//
//				String saveFileName = i + 1 + "." + "jpeg";
//
//				String fullFileInfo = saveFilePath + "/" + saveFileName;
//
//				InputStream inputStream = new ByteArrayInputStream(inputFile);
//				BufferedImage inputImage = ImageIO.read(inputStream);

// 이미지 흑백 처리			    
//				for(int y = 0; y < inputImage.getHeight(); y++) {
//					   for(int x = 0; x < inputImage.getWidth(); x++) {
//					       Color colour = new Color(inputImage.getRGB(x, y));
//					       Choose one from below
//					       int Y = (int) (0.299 * colour.getRed() + 0.587 * colour.getGreen() + 0.114 * colour.getBlue());
//					       int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
//					       inputImage.setRGB(x, y, new Color(Y, Y, Y).getRGB());
//					   }
//					}
//				
//				ImageIO.write(inputImage, "jpeg", new File(fullFileInfo));
//				res = 1;
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println(e);
//			}
//
//		}

		// 파일 저장할 경로를 DB에 저장
		String save_file_path = FACE_UPLOAD_SAVE_PATH + "\\" + user_id;
		String save_model_path = FACE_MODEL_PATH + "\\" + user_id + "_trainner.yml";

		FaceDTO pDTO = new FaceDTO();
		pDTO.setUser_id(user_id);
		pDTO.setSave_file_path(save_file_path);
		pDTO.setSave_model_path(save_model_path);
		pDTO.setReg_dt(DateUtil.getDateTime("yyyy-MM-dd-hh:mm:ss"));

		int res2 = faceSerivice.FaceInsertImage(pDTO);
		
		
		// flask 서버에 이미지 파일 보내기 (json)
		String inputLine = null;
		StringBuffer stringBuffer = new StringBuffer();

//		URL url = new URL("http://localhost:8000/facelearningAPI"); // URL객체 생성
		URL url = new URL("http://13.125.99.115:8000/facelearningAPI"); // URL객체 생성

		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // url주소를 가지고 Http 커넥션 객체 생성

		System.out.println(conn.toString());
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setConnectTimeout(200000);
		conn.setReadTimeout(200000);

		// 데이터 전송
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bWriter.write(jsonString.toString());
		bWriter.flush();
		bWriter.close();

		// 전송된 결과를 읽어옴
		BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		while ((inputLine = bReader.readLine()) != null) {
			stringBuffer.append(inputLine);
		}
		bWriter.close();
		bReader.close();
		conn.disconnect();
		log.info("result : " + stringBuffer.toString());

		if (res == 1 && res2 == 1 && stringBuffer.toString().equals("success")) {
			res = 1;
		} else {
			res = 0;
		}
		return res;
	}

	@RequestMapping(value = "face/facelogin")
	public String facelogin(HttpServletRequest request, ModelMap model) throws Exception {
		return "face/facelogin";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "face/faceanalysis")
	@ResponseBody
	public int faceanalysis(HttpServletRequest request, HttpSession session, @RequestBody Map<String, Object> param)
			throws Exception {
		log.info("faceanalysis start");

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(param.get("imglist"));

		JSONParser jsonParse = new JSONParser();
//		JSONArray jsonArray = new JSONArray();
//		jsonArray.add(user_id);
		JSONArray jsonArray = (JSONArray) jsonParse.parse(jsonString);
		JSONObject jsonob = new JSONObject();

		jsonob.put("img", jsonArray);

		// flask 서버에 이미지 파일 보내기 (json)
		String inputLine = null;
		StringBuffer stringBuffer = new StringBuffer();

		URL url = new URL("http://13.125.99.115:8000/faceloginAPI"); // URL객체 생성

		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // url주소를 가지고 Http 커넥션 객체 생성

		System.out.println(conn.toString());
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept-Charset", "UTF-8");
		conn.setConnectTimeout(200000);
		conn.setReadTimeout(200000);

		// 데이터 전송
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bWriter.write(jsonString.toString());
		bWriter.flush();
		bWriter.close();

		// 전송된 결과를 읽어옴
		BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		while ((inputLine = bReader.readLine()) != null) {
			stringBuffer.append(inputLine);
		}
		bWriter.close();
		bReader.close();
		conn.disconnect();
		log.info("result : " + stringBuffer.toString());
		int res = 0;
		if (stringBuffer.toString().equals("success")) {
			res = 1;
		} else {
			res = 0;
		}
		return res;
	}

	@RequestMapping(value = "face/faceloginProc")
	public String faceloginProc(HttpSession session, HttpServletRequest request, ModelMap model) throws Exception {

		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		log.info("user_id : " + user_id);

		HashMap<String, String> pMap = new HashMap<String, String>();
		pMap.put("user_id", user_id);
		UserDTO pDTO = userService.getFaceInfo(pMap);

		String msg = "";
		String url = "";

		if (pDTO == null) {
			log.info("pDTO == null?" + (pDTO == null));
			msg = "아이디를 다시 확인해주세요";
			url = "/user/login.do";
		} else {
			log.info("데이터 조회완료");
			session.setAttribute("user_id", pDTO.getUser_id());
			session.setAttribute("user_pwd", pDTO.getUser_pwd());
			session.setAttribute("join_dt", pDTO.getJoin_dt());
			msg = "환영합니다.";
			url = "/spoilbroth/mystudy.do";

		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		log.info("faceloginproc End!!");
		return "/redirect";
	}
}
