package poly.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import poly.dto.OcrDTO;

public class UploadFileUtil {

	public static OcrDTO uploadfile(MultipartFile mf, String path, String name) throws Exception {
		System.out.println("path : " + path);
		OcrDTO pDTO = new OcrDTO();

		// 임의로 정의된 파일명을 원래대로 만들어주기 위한 목적
		String originalFileName = mf.getOriginalFilename();

		// 파일 확장자 가져오기
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length())
				.toLowerCase();

		// 이미지 파일만 실행되도록 함
		if (ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {

			// 웹서버에 저장되는 파일이름 (영어, 숫자로 파일명 변경)
			String saveFileName = DateUtil.getDateTime("24hhmmss") + "." + ext;

			// 웹서버에 업로드한 파일 저장하는 물리적 경로
			String saveFilePath = FileUtil.mkdirForDate(path);
			String fullFileInfo = saveFilePath + "/" + saveFileName;

			// 정상적으로 값이 생성되었는지 로그에 찍어서 확인
			System.out.println("ext : " + ext);
			System.out.println("originalFileName : " + originalFileName);
			System.out.println("saveFileName : " + saveFileName);
			System.out.println("saveFilePath : " + saveFilePath);
			System.out.println("fullFileInfo : " + fullFileInfo);

			// 업로드 되는 파일을 서버에 저장
			File targetFile = new File(fullFileInfo);
			targetFile.setReadable(true, false);
			targetFile.setWritable(false, false);
			targetFile.setWritable(true, true);

			// 이미지 리사이징
//			File file = new File(mf.getOriginalFilename());
//			mf.transferTo(file); // MultipartFile을 File 로 변환
			
			InputStream inputStream = mf.getInputStream();
			
//			Image img = new ImageIcon(mf.).getImage(); // 파일정보 추출
//			System.out.println("사진의 가로길이 : " + img.getWidth(null));
//			System.out.println("사진의 세로길이 : " + img.getHeight(null));

			int width = 700; // 리사이즈할 가로길이
			int height = 550; // 리사이즈한 세로길이

			BufferedImage resizedImage = ImageResizeUtil.resize(inputStream, width, height);
			ImageIO.write(resizedImage, ext, new File(fullFileInfo));

			pDTO.setSave_file_name(saveFileName);
			pDTO.setSave_file_path(saveFilePath);
			pDTO.setOrg_file_name(originalFileName);
			pDTO.setExt(ext);
			pDTO.setChg_id(name);
			pDTO.setChg_dt(DateUtil.getDateTime("yyyy-MM-dd-hh:mm:ss"));

		}
		return pDTO;
	}
}
