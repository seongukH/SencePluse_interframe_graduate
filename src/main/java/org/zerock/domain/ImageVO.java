package org.zerock.domain;

import java.util.Date;

public class ImageVO {

	private int imageNo;
	private String uhome;	
	private String imageName;
	private Date time;
	private String imageType;
	private String artist;
	private String imageScript;
	private String imageText;
	private String imageArtist;
	
	
	
	public int getImageNo() {
		return imageNo;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public String getImageArtist() {
		return imageArtist;
	}
	public void setImageArtist(String imageArtist) {
		this.imageArtist = imageArtist;
	}
	public String getImageText() {
		return imageText;
	}
	public void setImageText(String imageText) {
		this.imageText = imageText;
	}
	public String getUhome() {
		return uhome;
	}
	public void setUhome(String uhome) {
		this.uhome = uhome;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getImageScript() {
		return imageScript;
	}
	public void setImageScript(String imageScript) {
		this.imageScript = imageScript;
	}
	@Override
	public String toString() {
		return "ImageVO [imageNo=" + imageNo + ", uhome=" + uhome + ", imageName=" + imageName + ", time=" + time
				+ ", imageType=" + imageType + ", artist=" + artist + ", imageScript=" + imageScript + ", imageText="
				+ imageText + ", imageArtist=" + imageArtist + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
