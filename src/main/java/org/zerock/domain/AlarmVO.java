package org.zerock.domain;

import java.util.Date;

public class AlarmVO {

	
	private int sno;	
	private String sname;
	private Date stime;
	private Date endtime;
	private int rutine;
	private int alert;
	private String uhome;
	private int hour;
	private int hour_10;
	private int hour_1;
	private int minute;
	private int minute_10;
	private int minute_1;
	
	
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public int getRutine() {
		return rutine;
	}
	public void setRutine(int rutine) {
		this.rutine = rutine;
	}
	public int getAlert() {
		return alert;
	}
	public void setAlert(int alert) {
		this.alert = alert;
	}
	public String getUhome() {
		return uhome;
	}
	public void setUhome(String uhome) {
		this.uhome = uhome;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getHour_10() {
		return hour_10;
	}
	public void setHour_10(int hour_10) {
		this.hour_10 = hour_10;
	}
	public int getHour_1() {
		return hour_1;
	}
	public void setHour_1(int hour_1) {
		this.hour_1 = hour_1;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getMinute_10() {
		return minute_10;
	}
	public void setMinute_10(int minute_10) {
		this.minute_10 = minute_10;
	}
	public int getMinute_1() {
		return minute_1;
	}
	public void setMinute_1(int minute_1) {
		this.minute_1 = minute_1;
	}
	@Override
	public String toString() {
		return "AlarmVO [sno=" + sno + ", sname=" + sname + ", stime=" + stime + ", endtime=" + endtime + ", rutine="
				+ rutine + ", alert=" + alert + ", uhome=" + uhome + ", hour=" + hour + ", hour_10=" + hour_10
				+ ", hour_1=" + hour_1 + ", minute=" + minute + ", minute_10=" + minute_10 + ", minute_1=" + minute_1
				+ "]";
	}

	
	
	
	
	
}
