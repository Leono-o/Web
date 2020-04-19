package com.hotmail.ch.leon.familymedia.cmdto;

public class DownloadDTO {
	private String url = "";
	
	private String saveAs = "";
	
	private long firstpackageSz = 0;
	
	private String contentType = "";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSaveAs() {
		return saveAs;
	}

	public void setSaveAs(String saveAs) {
		this.saveAs = saveAs;
	}


	public long getFirstpackageSz() {
		return firstpackageSz;
	}

	public void setFirstpackageSz(long firstpackageSz) {
		this.firstpackageSz = firstpackageSz;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
