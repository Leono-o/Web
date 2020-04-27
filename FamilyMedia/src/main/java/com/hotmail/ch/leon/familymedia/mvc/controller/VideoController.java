package com.hotmail.ch.leon.familymedia.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotmail.ch.leon.familymedia.cmdto.DownloadDTO;
import com.hotmail.ch.leon.familymedia.cmlogic.DownloadLogic;
import com.hotmail.ch.leon.familymedia.consts.ContentType;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.logic.ResouceLogic;
import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.mvc.bean.VideoBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.VideoModel;


@RestController
public class VideoController {


	@RequestMapping(value="/video", method=RequestMethod.GET)
	public ResponseBean listAll(
			@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "resourceid", required = false) String resourceid)  {
		VideoModel model = FmBeanFactory.getModel(VideoModel.class);
		
		try {
			List<VideoBean> resultBeans = model.getList(user, resourceid);
			ResponseBean result = new ResponseBean();
			result.setData(resultBeans);
			result.setStatus("200");
			return result;
			
		} catch (Exception e) {
			ResponseBean result = new ResponseBean();
			result.setStatus("400");
			return result;
		}
	}
	
    @RequestMapping(value="/video/{resourceid}", method=RequestMethod.GET)
    public void download(
    		@PathVariable String resourceid,
    		@RequestParam(value = "user", required = true) String user, 
    		HttpServletRequest request, HttpServletResponse response) {
    	
    	FileInfoDTO finfo;
		try {
			finfo = ResouceLogic.getFileInfo(user, resourceid);
		} catch (Exception e) {
			response.setStatus(400);
			return;
		}
    	if (finfo == null) {
    		response.setStatus(HttpStatus.NOT_FOUND.value());
    		return;
    	}
    	
    	DownloadDTO downloadDTO = new DownloadDTO();
    	downloadDTO.setUrl(finfo.getLocalpath());
    	downloadDTO.setSaveAs(finfo.getDispname());
    	downloadDTO.setContentType(ContentType.typeOf(finfo.getFileType()));
    	downloadDTO.setFirstpackageSz(5*1024*1024);
    	
		DownloadLogic.execute(downloadDTO, request, response);
    }
    
}