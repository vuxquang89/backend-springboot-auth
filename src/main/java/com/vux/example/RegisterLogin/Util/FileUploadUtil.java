package com.vux.example.RegisterLogin.Util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
//	@Value("${upload.path}")
//	private static String UPLOADED_FOLDER;

	public static String uploadFile(String optFolder, String fileName, MultipartFile multipartFile) throws IOException {
		String uploadDir = Variables.UPLOADED_FOLDER + "upload/" + optFolder;
		Path uploadPath = Paths.get(uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		String fileCode = RandomStringUtils.randomAlphanumeric(8);
		String fName = fileCode + "-" + fileName;
		try (InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadPath.resolve(fName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		}catch (IOException e) {
			throw new IOException("Could not save file : " + fileName, e);
		}
		return fName;
	}
	
	public static List<String> uploadMultiFile(List<MultipartFile> files, String pathUpload) throws IOException{
		List<String> fileNames = new ArrayList<String>();
		for(MultipartFile file : files) {
			if(file.isEmpty()) {
				continue;
			}
			
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			fileName = uploadFile(pathUpload, fileName, file);
			System.out.println("upload filename ");
			System.out.println(fileName);
			fileNames.add(fileName);
		}
		
		return fileNames;
		
	}
}
