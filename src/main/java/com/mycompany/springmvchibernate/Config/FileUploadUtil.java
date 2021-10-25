package com.mycompany.springmvchibernate.Config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	 
	public static String UPLOADED_FOLDER = "E://temp//";
	
	public static void saveFile(String uploadDir, String fileName,MultipartFile multipartFile) throws IOException
	{
		Path uploadPath=Paths.get(UPLOADED_FOLDER+uploadDir);
		
		if(!Files.exists(uploadPath))
		{
			//tạo mới
			Files.createDirectories(uploadPath);
		}
		try {
			InputStream inputStream=multipartFile.getInputStream();
			Path filePath=uploadPath.resolve(fileName); //
			System.out.println(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING );
		}
		catch(IOException e)
		{
			   throw new IOException("Could not save image file: " + fileName, e);
			
		}
		
	}


}
