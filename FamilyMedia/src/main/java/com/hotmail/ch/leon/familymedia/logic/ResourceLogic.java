package com.hotmail.ch.leon.familymedia.logic;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.util.StringUtils;

import com.hotmail.ch.leon.familymedia.dao.GroupDao;
import com.hotmail.ch.leon.familymedia.dao.dto.FolderDTO;
import com.hotmail.ch.leon.familymedia.dao.dto.ResourceDTO;
import com.hotmail.ch.leon.familymedia.dto.FileInfoDTO;
import com.hotmail.ch.leon.familymedia.filter.FMFileFilter;
import com.hotmail.ch.leon.familymedia.mvc.bean.ResponseBean;
import com.hotmail.ch.leon.familymedia.mvc.factory.FmBeanFactory;
import com.hotmail.ch.leon.familymedia.utils.FileUtil;

public class ResourceLogic {
	
	/**
	 * 根据resourceid获取文件的基本信息
	 * @param userName 用户名 用来进行权限check
	 * @param resourceid 
	 * @return
	 * @throws Exception
	 */
	public static FileInfoDTO getFileInfo(String userName, String resourceid) throws Exception {
		
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String[] resource = new String(decoder.decode(resourceid), "UTF-8").split(":");
		BigDecimal folderid =new BigDecimal(resource[0]); 
		String fileName =resource[1];
		
		GroupDao dao = FmBeanFactory.getDao(GroupDao.class);
		FolderDTO folderDTO = dao.findByid(userName, folderid);
		
		return new FileInfoDTO(folderDTO.getUrl() + "/" + fileName, fileName,
				FileUtil.getExtension(fileName));

	}
	
	/**
	 * 根据resourceid取得旗下成员列表
	 * @param userName 用户名 用来进行权限check
	 * @param resourceid
	 * @param rtype
	 * @return 
	 * @throws Exception
	 */
	public static ResponseBean getMember(String userName, String resourceid, FMFileFilter ffilter) throws Exception {
		
		GroupDao dao = FmBeanFactory.getDao(GroupDao.class);
		final Base64.Encoder encoder = Base64.getUrlEncoder();

		if (StringUtils.isEmpty(resourceid)) {
			// 没有resourceid的时候，返回顶层目录
			List<ResourceDTO> result = dao.findFolderListByUserName(userName, ffilter.getSymbol());

			for (ResourceDTO dto : result) {
				dto.setRtype("DIR");
				dto.setId(encoder.encodeToString(dto.getId().getBytes("UTF-8")));
			}
			return new ResponseBean("200", result);

		} else {

			Base64.Decoder decoder = Base64.getUrlDecoder();
			String[] resource = new String(decoder.decode(resourceid), "UTF-8").split(":");
			String folderid = resource[0];
			String fileurl = "";
			if (resource.length == 2) {
				fileurl = resource[1];
			}

			FolderDTO folderDTO = dao.findByid(userName, new BigDecimal(folderid));
			if (folderDTO == null) {
				// 用户和没有该文件夹的权限，或不存在该文件夹
				
				return new ResponseBean("403", "not available");
			}

			String path = folderDTO.getUrl();
			String resourceString = folderid + ":";
			if (!StringUtils.isEmpty(fileurl)) {
				path = path + "/" + fileurl;
				resourceString = resourceString + fileurl + "/";
			}

			List<String>fileList =  FileUtil.listDirectory(path);
			List<ResourceDTO> result = new ArrayList<ResourceDTO>();
			
			for (String fname : fileList) {
				if ((new File(path + "/" + fname)).isDirectory()) {
					ResourceDTO dto = new ResourceDTO();
					dto.setName(fname);
					dto.setId(encoder.encodeToString((resourceString + fname).getBytes("UTF-8")));
					dto.setRtype("DIR");
					result.add(dto);
				} else {
					String fileExtension = FileUtil.getExtension(fname);
					if (ffilter.check(fileExtension)) {
						ResourceDTO dto = new ResourceDTO();
						dto.setName(FileUtil.getMain(fname));
						dto.setId(encoder.encodeToString((resourceString + fname).getBytes("UTF-8")));
						dto.setRtype(fileExtension);
						result.add(dto);
					}
				}
			}		
			return new ResponseBean("200", result);
		}
	}

}
