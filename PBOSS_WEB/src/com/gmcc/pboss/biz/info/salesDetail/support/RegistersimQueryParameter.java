package com.gmcc.pboss.biz.info.salesDetail.support;

import java.util.Date;

import com.gmcc.pboss.common.support.QueryParameter;

/**
 * 套卡销售明细查询参数CH_PW_REGISTERSIM
 * @author Administrator
 *
 */
public class RegistersimQueryParameter extends QueryParameter {
	//网店编码
	private String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	
	//店员-工号
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	
	//分公司
	private String countyid;
	public void setCountyid(String id){
		this.countyid = id;
	}
	public String getCountyid(){
		return this.countyid;
	}
	
	//销售服务中
	private String svccode;
	public void setSvccode(String svc){
		this.svccode = svc;
	}
	public String getSvccode(){
		return this.svccode;
	}
	
	//套卡号码
	private String mobile;	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	//品牌
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
	}
	
	//登记方式
	private String flag;	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	//商品类型
	private String type;		
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//登记起始时间
	private Date startDate;
	public void setStartDate(Date s){
		this.startDate = s;
	}
	public Date getStartDate(){
		return this.startDate;
	}
	
	//登记结束时间
	private Date endDate;
	public void setEndDate(Date e){
		this.endDate = e;
	}
	public Date getEndDate(){
		return this.endDate;
	}
	
	//激活起始时间
	private Date activeFrom;
	public Date getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}

	//激活结束时间
	private Date activeTo;
	public Date getActiveTo() {
		return activeTo;
	}
	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}
	
	//地市id
	private String cityid;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
}
