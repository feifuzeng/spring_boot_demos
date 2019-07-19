package com.github.feifuzeng.style.echart.model;
/** * @author  feifz: 
    * @date ：2017年7月26日 下午5:27:32 
    * @return  
	* @desc
    */
public class EchartReq {
	private String name;
	private String startTime;
	private String endTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
