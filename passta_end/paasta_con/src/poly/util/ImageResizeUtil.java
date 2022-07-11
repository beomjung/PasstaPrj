package poly.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageResizeUtil {
	
	// 이미지 리사이징
	public static BufferedImage resize(InputStream inputStream, int width, int height)throws IOException{
		
		BufferedImage inputImage = ImageIO.read(inputStream); // 받은 이미지 읽기
		
		BufferedImage outputImage = new BufferedImage(width, height, inputImage.getType()); // 입력받은 리사이즈 길이와 높이
		
		Graphics2D graphics2D = outputImage.createGraphics();
		graphics2D.drawImage(inputImage, 0, 0, width, height, null); // 그리기
		graphics2D.dispose(); // 자원 해제
		
		return outputImage;
	}
}
