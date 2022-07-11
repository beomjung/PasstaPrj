package poly.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class S3Util {

	private String accessKey = "AKIA6EFLBOIKSLL5EQ5F";
	private String secretKey = "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";

	private static AmazonS3 conn;

	public S3Util() {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		conn = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_NORTHEAST_2).build();
	}

	// Bucket List
	public List<Bucket> getBucketList() {
		return conn.listBuckets();d
	}

	/*
	 * // Bucket 생성 public Bucket createBucket(String bucketName) { return
	 * conn.createBucket(bucketName); }
	 * 
	 * // 폴더 생성 (폴더는 파일명 뒤에 "/"를 붙여야한다.) public void createFolder(String bucketName,
	 * String folderName) { conn.putObject(bucketName, folderName + "/", new
	 * ByteArrayInputStream(new byte[0]), new ObjectMetadata()); }
	 */

	// 파일 업로드
	public void fileUpload(String bucketName, File file) throws FileNotFoundException {
		conn.putObject(bucketName, file.getName(), new FileInputStream(file), new ObjectMetadata());
	}

	// 파일 삭제
	public void fileDelete(String bucketName, String fileName) {
		conn.deleteObject(bucketName, fileName);
	}

	// 파일 URL
	public static String getFileURL(String bucketName, String fileName) {
        return conn.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, fileName)).toString();
    }
	

	
	
	
}

