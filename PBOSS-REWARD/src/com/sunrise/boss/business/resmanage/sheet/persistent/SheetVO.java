package com.sunrise.boss.business.resmanage.sheet.persistent;

import java.util.Date;

/**
 * 流通单表 im_pr_sheet
 * @author zengwenqu
 *
 */
public class SheetVO implements java.io.Serializable{
	
	private String sheetid;//流通单标识
	private Date createtime;//生成时间
	private Long sheettype;//流通单类型(出仓单/退仓单)
	private Long sheetstate;//流通单状态
	private String salesopr;//营业员工号
	private String oprcode;//操作员工号
	private Date oprtime;//操作时间
	private Long hasprinted;
	private String wayid;//渠道标识
	private String memo;
	private Long sheetrestype;//流通单资源类型(0 Sim卡、1 积分卡、2 套卡、3 空白SIM卡）
	
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
