package com.sunrise.boss.business.resmanage.sheet.persistent;

import java.util.Date;

/**
 * ��ͨ���� im_pr_sheet
 * @author zengwenqu
 *
 */
public class SheetVO implements java.io.Serializable{
	
	private String sheetid;//��ͨ����ʶ
	private Date createtime;//����ʱ��
	private Long sheettype;//��ͨ������(���ֵ�/�˲ֵ�)
	private Long sheetstate;//��ͨ��״̬
	private String salesopr;//ӪҵԱ����
	private String oprcode;//����Ա����
	private Date oprtime;//����ʱ��
	private Long hasprinted;
	private String wayid;//������ʶ
	private String memo;
	private Long sheetrestype;//��ͨ����Դ����(0 Sim����1 ���ֿ���2 �׿���3 �հ�SIM����
	
	public Long getHasprinted() {
		return hasprinted;
	}

	public void setHasprinted(Long hasprinted) {
		this.hasprinted = hasprinted;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public SheetVO(){}
	
	public SheetVO(String sheetid,Date createtime,Long sheettype,Long sheetstate,String salesopr,String oprcode,Date oprtime,Long hasprinted,String wayid,String memo){
		this.sheetid = sheetid;
		this.createtime = createtime;
		this.sheettype = sheettype;
		this.sheetstate = sheetstate;
		this.salesopr = salesopr;
		this.oprcode = oprcode;
		this.oprtime = oprtime;
		this.hasprinted = hasprinted;
		this.wayid = wayid;
		this.memo = memo;
	}
	

	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Date getOprtime() {
		return oprtime;
	}
	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}
	public String getSalesopr() {
		return salesopr;
	}
	public void setSalesopr(String salesopr) {
		this.salesopr = salesopr;
	}
	public String getSheetid() {
		return sheetid;
	}
	public void setSheetid(String sheetid) {
		this.sheetid = sheetid;
	}
	public Long getSheetstate() {
		return sheetstate;
	}
	public void setSheetstate(Long sheetstate) {
		this.sheetstate = sheetstate;
	}
	public Long getSheettype() {
		return sheettype;
	}
	public void setSheettype(Long sheettype) {
		this.sheettype = sheettype;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Long getSheetrestype() {
		return sheetrestype;
	}

	public void setSheetrestype(Long sheetrestype) {
		this.sheetrestype = sheetrestype;
	}
	
}
