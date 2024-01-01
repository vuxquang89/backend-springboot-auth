package com.vux.example.RegisterLogin.Util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import com.vux.example.RegisterLogin.Exception.BaseException;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailUtil {
	@Value("${upload.path}")
	private static String UPLOADED_FOLDER;
	
	public static final int SIZE_WIDTH_100 = 100;
	public static final int SIZE_HEIGHT_100 = 100;
	public static final int SIZE_HEIGHT_160 = 160;
	
	
	public static String resize100x160(String pathName, String fileName) throws BaseException {
		String pathFile = UPLOADED_FOLDER + pathName;
		String path = pathFile+"/"+fileName;
		File file = new File(path);
		
		if(!file.isFile()) {
			throw new BaseException("Upload file is null");
		}
		
		String thumbnailFilename = fileName.replace(".", "_"+SIZE_WIDTH_100+"x"+SIZE_HEIGHT_160+".");
		
		try {
			Thumbnails.of(path)
				.size(SIZE_WIDTH_100, SIZE_HEIGHT_160)
				.toFile(pathFile+"/"+thumbnailFilename);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return thumbnailFilename;
	}

}
