package com.hotmail.ch.leon.familymedia.cmlogic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotmail.ch.leon.familymedia.cmdto.DownloadDTO;

public class DownloadLogic {

	// 断点续传
	public static void  execute(DownloadDTO dto, HttpServletRequest request, HttpServletResponse response) {
		InputStream inputStream = null;
        OutputStream bufferOut = null;
        try {
        	File proposeFile = new File(dto.getUrl());
            // 设置响应报头
            long fSize = proposeFile.length();
            response.setContentType(dto.getContentType());
            // Content-Disposition: attachment; filename=WebGoat-OWASP_Developer-5.2.zip
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(proposeFile.getName(), "UTF-8"));
            // Accept-Ranges: bytes
            response.setHeader("Accept-Ranges", "bytes");
            //pos开始读取位置;  last最后读取位置;  sum记录总共已经读取了多少字节
            long pos = 0;
            long  last = fSize - 1;
            long  sum = 0;
            if (null != request.getHeader("Range")) {
                // 断点续传
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                try {
                    // 情景一：RANGE: bytes=2000070- 情景二：RANGE: bytes=2000070-2000970
                    String numRang = request.getHeader("Range").replaceAll("bytes=", "");
                    String[] strRange = numRang.split("-");
                    if (strRange.length == 2) {
                        pos = Long.parseLong(strRange[0].trim());
                        last = Long.parseLong(strRange[1].trim());
                    } else {
                        pos = Long.parseLong(numRang.replaceAll("-", "").trim());
                    }
					if (pos > last) {
						pos = last;
					}
                } catch (NumberFormatException e) {
                    pos = 0;
                }
            } else {
            	if (last >= dto.getFirstpackageSz() ) {
            		last = dto.getFirstpackageSz() -1;
            	}
            }
            long rangLength = last - pos + 1;// 总共需要读取的字节
            // Content-Range: bytes 10-1033/304974592
            String contentRange = new StringBuffer("bytes ").append(pos).append("-").append(last).append("/").append(fSize).toString();
            response.setHeader("Content-Range", contentRange);
            // Content-Length: 1024
            response.addHeader("Content-Length", String.valueOf(rangLength));

            // 跳过已经下载的部分，进行后续下载
            bufferOut = new BufferedOutputStream(response.getOutputStream());
            inputStream = new BufferedInputStream(new FileInputStream(proposeFile));
            inputStream.skip(pos);
            byte[] buffer = new byte[1024];
            int length = 0;
            while (sum < rangLength) {
                length = inputStream.read(buffer, 0, ((rangLength - sum) <= buffer.length ? ((int) (rangLength - sum)) : buffer.length));
                sum = sum + length;
                bufferOut.write(buffer, 0, length);
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (bufferOut != null) {
                    bufferOut.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
