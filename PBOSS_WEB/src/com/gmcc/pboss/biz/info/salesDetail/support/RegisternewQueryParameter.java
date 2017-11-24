package com.gmcc.pboss.biz.info.salesDetail.support;

import java.util.List;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import com.gmcc.pboss.common.support.QueryParameter;

/**
 * 新业务销售明细查询参数CH_PW_REGISTERNEW
 * @author Administrator
 *
 */
public class RegisternewQueryParameter extends QueryParameter {
	
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
	
	//业务编码
	private String opnid;
	public void setOpnid(String id){
		this.opnid = id;
	}
	public String getOpnid(){
		return this.opnid;
	}
	
	//品牌
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
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
	
	//地市id
	private String cityid;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

}
