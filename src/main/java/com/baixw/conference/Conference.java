package com.baixw.conference;
/**
 * 会议提纲 实体类
 * @author baixw
 *
 */
public class Conference {
	/**
	 * 会议名称
	 */
	private String name;
	/**
	 * 会议时长
	 */
	private int min;
	/**
	 * 会议开始时间
	 */
	private String time;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
