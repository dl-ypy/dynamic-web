package com.ypy.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport{
	private List<File> img;     //设置未集合可批量上传
	private List<String> imgContentType;
	private List<String> imgFileName;
	public List<File> getImg() {
		return img;
	}
	public void setImg(List<File> img) {
		this.img = img;
	}
	public List<String> getImgContentType() {
		return imgContentType;
	}
	public void setImgContentType(List<String> imgContentType) {
		this.imgContentType = imgContentType;
	}
	public List<String> getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(List<String> imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	public String upload() {
		if (img != null) {
			for (int i=0; i<img.size(); i++) {
				File f = new File("F:/upload/"+imgFileName.get(i));
				try {
					FileUtils.copyFile(img.get(i), f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return SUCCESS;
	}
}
