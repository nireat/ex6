package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Download extends AbstractView{
	//view객체 역할을 해야 함-> AbstractView 상속
	//여기는 filedownload 처리하는 view
	public Download(){
		setContentType("application/download;charset=UTF-8");
		//미디어 파일 형식에 맞는 플레이어 준비해줌
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ModelAndView 의 view 부분. 
		File f = (File)model.get("downloadFile");
		String oriName = (String)model.get("oriName");
		
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());
		
		//String fileName = URLEncoder.encode( f.getName(), "UTF-8");
		String fileName = URLEncoder.encode( f.getName(), "UTF-8");
		fileName = fileName.substring(fileName.lastIndexOf("_")+1);
		//(_ 포함)
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//response: socket의 역할
		OutputStream out = response.getOutputStream();
		FileInputStream fi = null;
		
		fi = new FileInputStream(f);
		
		FileCopyUtils.copy(fi, out);
		
		fi.close();
		out.close();
	}

}
