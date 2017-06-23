package com.choa.file;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public String filesave(String realPath, String oriName, byte [] fileData) throws Exception{
		System.out.println(realPath);
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		//upload 파일에 저장되는 실제 파일 name(FileCopyUtils 이용)
		String fileName = UUID.randomUUID().toString()+"_"+oriName;
		File target = new File(f, fileName);
		FileCopyUtils.copy(fileData, target);
		return fileName;
	}
	
	public String filesave(String realPath, MultipartFile m) throws Exception{
		File f = new File(realPath);
		//파일명이 존재하지 않는다면
		if(!f.exists()){
			f.mkdirs();
		}
		//String fileName = UUID.randomUUID().toString()+"_"+m.getOriginalFilename();
		
		//중복이 안되도록 하는 방법(carlender 이용)
		Calendar ca = Calendar.getInstance();
		String fileName=ca.getTimeInMillis()+"_"+m.getOriginalFilename();
		File target = new File(f, fileName);
		m.transferTo(target);
		
		return fileName;
	}

}
