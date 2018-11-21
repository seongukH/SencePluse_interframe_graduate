package org.zerock.domain;

import java.util.Date;

public class AirVO {

	
	private String uhome;	
	private int temp;
	private int humid;
	private int dust;
	private Date time;
	
	
	public String getUhome() {
		return uhome;
	}
	public void setUhome(String uhome) {
		this.uhome = uhome;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getHumid() {
		return humid;
	}
	public void setHumid(int humid) {
		this.humid = humid;
	}
	public int getDust() {
		return dust;
	}
	public void setDust(int dust) {
		this.dust = dust;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	@Override
	public String toString() {
		return "AirVO [uhome=" + uhome + ", temp=" + temp + ", humid=" + humid + ", dust=" + dust + ", time=" + time
				+ "]";
	}
	
	
	
	
	
	
}
