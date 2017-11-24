package com.gmcc.pboss.biz.info.registernewmagcnt.support;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class Registernewmagcnt {

	// ��Ա����
	private String employeename;
	// �������
	private String officetel;
	// Ʒ��
	private String brand;
	private String brandName;
	// ҵ�����
	private String opnid;
	// ҵ������
	private String opnname;
	// ����
	private String cnt;
	
	public Registernewmagcnt() {
		super();
	}
	
	/**
	 * 
	 * @param employeename ��Ա����
	 * @param officetel �������
	 * @param brand Ʒ��
	 * @param opnid ҵ�����
	 * @param opnname ҵ������
	 * @param cnt ����
	 */
	public Registernewmagcnt(String employeename, String officetel, String brand, String opnid, String opnname, String cnt) {
		super();
		this.employeename = employeename;
		this.officetel = officetel;
		this.brand = brand;
		if (brand != null)
			this.brandName = Constant.getConstantName(ConstantsType.SIMBRAND,brand.toString());
		this.opnid = opnid;
		this.opnname = opnname;
		this.cnt = cnt;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
