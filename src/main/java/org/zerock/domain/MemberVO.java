package org.zerock.domain;

import java.util.Date;

public class MemberVO {

	private int uno;
	private String uid;
	private String upw;
	private String uname;
	private String uhome;
	private int ux;
	private int uy;
	
	private String sessionId;
	private int sessionLimit;
	private Date updatedate;
	
	
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUhome() {
		return uhome;
	}
	public void setUhome(String uhome) {
		this.uhome = uhome;
	}
	public int getUx() {
		return ux;
	}
	public void setUx(int ux) {
		this.ux = ux;
	}
	public int getUy() {
		return uy;
	}
	public void setUy(int uy) {
		this.uy = uy;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getSessionLimit() {
		return sessionLimit;
	}
	public void setSessionLimit(int sessionLimit) {
		this.sessionLimit = sessionLimit;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "MemberVO [uno=" + uno + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uhome=" + uhome
				+ ", ux=" + ux + ", uy=" + uy + ", sessionId=" + sessionId + ", sessionLimit=" + sessionLimit
				+ ", updatedate=" + updatedate + "]";
	}
	
	
	
}
