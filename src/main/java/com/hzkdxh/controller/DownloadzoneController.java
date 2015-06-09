package com.hzkdxh.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzkdxh.bean.Downloadzone;
import com.hzkdxh.service.DownloadzoneService;
import com.hzkdxh.util.CodeGenerator;
import com.hzkdxh.util.CommonConst;
import com.hzkdxh.util.DateUtils;


@Controller
@RequestMapping(value="/downloadzone")
public class DownloadzoneController extends BaseController{
	
	@Autowired
	private DownloadzoneService downloadzoneService;
	
	private static final Logger logger = Logger.getLogger(StaticPictureController.class);
	
	@RequestMapping("/save.do")
	public void saveFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String path = CommonConst.DZ_FILE_PATH;													//文件主图路径
			String id = CodeGenerator.createUUID();
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("path", path);
			List<Downloadzone> list = uploadDownloadzone(request, response, map); 	 	//上传文件
			Downloadzone file = new Downloadzone();
			file.setId(id);
			Timestamp time = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			file.setCrtime(time);
			if(list.size() != 0){
				Downloadzone f = list.get(0);
				file.setFilesrc(f.getFilesrc());
				file.setFilename(f.getFilename());
			}
			downloadzoneService.addDownloadzone(file);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	

	@RequestMapping("/fileAdd.do")
	public ModelAndView addFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			ModelAndView view = new ModelAndView("downloadzone/fileAdd");
			return view;
		}catch (RuntimeException e) { 
			logger.error("获取添加文件信息列表出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/delFile.do")
	public void delFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String id = request.getParameter("id");	
			downloadzoneService.deleteDownloadzone(id);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除文件出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

}
