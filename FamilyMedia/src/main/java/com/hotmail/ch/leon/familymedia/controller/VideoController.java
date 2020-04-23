package com.hotmail.ch.leon.familymedia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotmail.ch.leon.familymedia.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.bean.VideoBean;
import com.hotmail.ch.leon.familymedia.cmdto.DownloadDTO;
import com.hotmail.ch.leon.familymedia.cmlogic.DownloadLogic;
import com.hotmail.ch.leon.familymedia.consts.ContentType;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.facade.VideoFacade;
import com.hotmail.ch.leon.familymedia.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.logic.ResouceLogic;


@RestController
public class VideoController {


	@RequestMapping(value="/video", method=RequestMethod.GET)
    public ResponseBean listAll() {
		VideoFacade facade = FmBeanFactory.getFacade(VideoFacade.class);
    	List<VideoBean> resultBeans = facade.getList();
    	ResponseBean result = new ResponseBean();
    	result.setData(resultBeans);
    	result.setStatus("200");
    	return result;
    }

    @RequestMapping(value="/video/{id}", method=RequestMethod.GET)
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
    	FileInfoDTO finfo = ResouceLogic.getFileInfo(id) ;
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