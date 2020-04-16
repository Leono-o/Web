package com.hotmail.ch.leon.familymedia.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotmail.ch.leon.familymedia.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.facade.MusicFacade;
import com.hotmail.ch.leon.familymedia.logic.ResouceLogic;


@RestController
public class MusicController {


    @RequestMapping(value="/music", method=RequestMethod.GET)
    public ResponseBean listAll() {
    	List<MusicBean> resultBeans = MusicFacade.getList();
    	ResponseBean result = new ResponseBean();
    	result.setData(resultBeans);
    	result.setStatus("200");
    	return result;
    }

    @RequestMapping(value="/music/{id}", method=RequestMethod.GET)
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
    	FileInfoDTO finfo = ResouceLogic.getFileInfo(id) ;
    	if (finfo == null) {
    		response.setStatus(HttpStatus.NOT_FOUND.value());
    		return;
    	}
    	
		// 设置响应头和客户端保存文件名
		response.setCharacterEncoding("utf-8");
		response.setContentType("audio/mp3");
		response.setHeader("Content-Disposition", "attachment;fileName=" + finfo.getDispname());

		InputStream inputStream = null;
		OutputStream os = null;
		try {
			// 打开本地文件流
			File file = new File(finfo.getLocalpath());
			inputStream = new FileInputStream(file);
			// 激活下载操作
			os = response.getOutputStream();

			// 循环写入输出流
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}

		} catch (IOException e) {
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 这里主要关闭。
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
