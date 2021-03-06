package com.hotmail.ch.leon.familymedia.mvc.controller;

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
import com.hotmail.ch.leon.familymedia.logic.ResourceLogic;
import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.VideoModel;


@RestController
@RequestMapping(value="/rs")
public class VideoController {


	@RequestMapping(value="/{user}/videos", method=RequestMethod.GET)
	public ResponseBean listAll(
			@PathVariable String user,
			@RequestParam(value = "resourceid", required = false) String resourceid)  {
		
		VideoModel model = FmBeanFactory.getModel(VideoModel.class);
		
		try {
			return model.getList(user, resourceid);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseBean("400","wrong");
		}
	}
	
    @RequestMapping(value="/{user}/videobyid", method=RequestMethod.GET)
    public void download(
    		@PathVariable String user,
    		@RequestParam(value = "resourceid", required = true) String resourceid,
    		HttpServletRequest request, HttpServletResponse response) {
    	
    	FileInfoDTO finfo = null;
		try {
			finfo = ResourceLogic.getFileInfo(user, resourceid);
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