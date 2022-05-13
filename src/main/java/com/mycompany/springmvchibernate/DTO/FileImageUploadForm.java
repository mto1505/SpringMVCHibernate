package com.mycompany.springmvchibernate.DTO;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.springmvchibernate.AnnotationValidator.UploadFileImageMaxSize;
@Component
public class FileImageUploadForm implements Serializable {

	@UploadFileImageMaxSize
	private MultipartFile multipartFile;

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
