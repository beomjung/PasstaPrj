package poly.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.service.impl.downloadS3;

@Controller
@RequestMapping("/common")
public class CommonController {
	@Resource(name = "downloadS3")
	private downloadS3 downloadS3;

	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam HashMap<Object, Object> params) throws IOException {
		String filename = (String) params.get("fileName");

		return downloadS3.getObject(filename);
	}
}
