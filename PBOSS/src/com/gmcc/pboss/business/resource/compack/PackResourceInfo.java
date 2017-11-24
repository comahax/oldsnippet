package com.gmcc.pboss.business.resource.compack;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * �׿������Ϣ
 * @author Administrator
 *
 */
public class PackResourceInfo {

	private long totalPack = 0;//�ܰ���
	private long processPack = 0;//�Ѿ�����İ���
	private String fileName ;//д�����¼���ļ� 
	private Date startTime;
	private Date endTime;
	
	private boolean finish = false;
	private String errMsg;//������Ϣ
	

	public boolean isFinish() {
		return finish;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public void setFinish(boolean isFinish) {
		this.finish = isFinish;
	}

	private long resource;//�׿�����
	public long getResource() {
		return resource;
	}
	public void setResource(long resource) {
		this.resource = resource;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private DecimalFormat percentFormat = new DecimalFormat("##%");
	public long getTotalPack() {
		return totalPack;
	}
	public void setTotalPack(long totalPack) {
		this.totalPack = totalPack;
	}
	public long getProcessPack() {
		return processPack;
	}
	public void setProcessPack(long processPack) {
		this.processPack = processPack;
	}
		
	public String getPercent(){
		if(totalPack == 0)
			return percentFormat.format(0);
		return percentFormat.format(1.0*this.processPack/this.totalPack); 
	}
}
