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
import com.hotmail.ch.leon.familymedia.dto.FMResponse;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.logic.ResourceLogic;
import com.hotmail.ch.leon.familymedia.mvc.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.mvc.model.MusicModel;


@RestController
public class MusicController {


	@RequestMapping(value="/music", method=RequestMethod.GET)
	public ResponseBean listAll(
			@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "resourceid", required = false) String resourceid)  {
		
		MusicModel model = FmBeanFactory.getModel(MusicModel.class);
		
		try {
			return model.getList(user, resourceid);
			
		} catch (Exception e) {
			return new ResponseBean("400","wrong");
		}
	}
	

    @RequestMapping(value="/music/{resourceid}", method=RequestMethod.GET)
    public void download(
    		@PathVariable String resourceid,
    		@RequestParam(value = "user", required = true) String user, 
    		HttpServletRequest request, HttpServletResponse response) {
    	
    	FileInfoDTO finfo;
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
