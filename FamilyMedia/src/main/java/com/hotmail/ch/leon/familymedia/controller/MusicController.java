package com.hotmail.ch.leon.familymedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotmail.ch.leon.familymedia.bean.MusicBean;
import com.hotmail.ch.leon.familymedia.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.facade.MusicFacade;


@RestController
public class MusicController {


    @RequestMapping(value="/music", method=RequestMethod.GET)
    public ResponseBean listAll() {
    	List<MusicBean> resultBeans = MusicFacade.getList();
    	ResponseBean result = new ResponseBean();
    	result.setData(resultBeans);
    	result.setStatus("400");
    	return result;
    }

    @RequestMapping(value="/music", method=RequestMethod.POST)
    public String addMusic() {
        return "hello restful";
    }
}