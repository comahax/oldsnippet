package com.gmcc.pboss.biz.info.salesDetail.support;

import java.util.List;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import com.gmcc.pboss.common.support.QueryParameter;

/**
 * ��ҵ��������ϸ��ѯ����CH_PW_REGISTERNEW
 * @author Administrator
 *
 */
public class RegisternewQueryParameter extends QueryParameter {
	
	//�������
	private String wayid;
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	public String getWayid(){
		return this.wayid;
	}
	
	//��Ա-����
	private String oprcode;
	public void setOprcode(String oprcode){
		this.oprcode = oprcode;
	}
	public String getOprcode(){
		return this.oprcode;
	}
	
	//�ֹ�˾
	private String countyid;
	public void setCountyid(String id){
		this.countyid = id;
	}
	public String getCountyid(){
		return this.countyid;
	}
	
	//���۷�����
	private String svccode;
	public void setSvccode(String svc){
		this.svccode = svc;
	}
	public String getSvccode(){
		return this.svccode;
	}
	
	//ҵ�����
	private String opnid;
	public void setOpnid(String id){
		this.opnid = id;
	}
	public String getOpnid(){
		return this.opnid;
	}
	
	//Ʒ��
	private String brand;
	public void setBrand(String b){
		this.brand = b;
	}
	public String getBrand(){
		return this.brand;
	}
	
	//�Ǽ���ʼʱ��
	private Date startDate;
	public void setStartDate(Date s){
		this.startDate = s;
	}
	public Date getStartDate(){
		return this.startDate;
	}
	
	//�Ǽǽ���ʱ��
	private Date endDate;
	public void setEndDate(Date e){
		this.endDate = e;
	}
	public Date getEndDate(){
		return this.endDate;
	}
	
	//����id
	private String cityid;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

}
