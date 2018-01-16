package com.ypy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileuploadController {
	@RequestMapping("/upload")
	public String fileupload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req) throws IOException {
		//获取文件名
		file.getOriginalFilename();
		//获取上传文件的路径
		String path = req.getRealPath("/fileupload");
		InputStream is = file.getInputStream();
		OutputStream os = new FileOutputStream(new File(path,file.getOriginalFilename()));
		int len = 0;
		byte[] buffer = new byte[400];
		while ((len=is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
		
		return "/index.jsp";
	}
}
