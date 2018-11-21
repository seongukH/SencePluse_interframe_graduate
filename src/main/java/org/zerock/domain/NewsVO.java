package org.zerock.domain;

import java.util.Date;

public class NewsVO {

	
	private String headImage;	
	private String headLine;
	private String sumNews;
	private String newsLink;
	private Date time;
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getHeadLine() {
		return headLine;
	}
	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}
	public String getSumNews() {
		return sumNews;
	}
	public void setSumNews(String sumNews) {
		this.sumNews = sumNews;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "NewsVO [headImage=" + headImage + ", headLine=" + headLine + ", sumNews=" + sumNews + ", newsLink="
				+ newsLink + ", time=" + time + "]";
	}
	
	
	
	
	
	
}
