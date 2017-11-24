package com.asisinfo.common.model;

import java.math.BigDecimal;

/**
 * ������Ҫ��ʾ�Ķ�̬�е�Ԫ�����Ϣ
 * @author johnson
 *
 */
public class ColMeta {
	/**����,��Ӧ����ݼ������� */
	private String name;
	/**�������������еı�����ʾ*/
	private String desc;
	/**�ֶ����ͣ�������ʽ���еĸ�ʽ */
	private String type;
	/** ��ݵ�λ�����typeΪ��ֵ��2,3ʱ,����ָ���䵥λ*/
	private String orgUnit;
	/** ��ʾ��λ*/
	private String displayUnit;
	/** ת�����ӡ� ��ֵ(orgUnit)=��ֵ*numerator/denominator(displayUnit)*/
	private BigDecimal numerator;
	/** ת����ĸ*/
	private BigDecimal denominator;
	/** �ַ����ֶβ���ת��*/
	public static final String COL_TYPE_STRING = "0";
	
	/** С���ֶ� ����2λС��*/
	public static final String COL_TYPE_DECIMAL = "1";
	
	/** �����ֶ� ��ҪС��λ*/
	public static final String COL_TYPE_INT = "2";
	
	/** �ٷֱ�*/
	public static final String COL_TYPE_PERCENT = "3";
	
	/** ����*/
	public static final String COL_TYPE_DATE = "4";
	
	/** ʱ��*/
	public static final String COL_TYPE_TIME = "5";
	
	public ColMeta(){
	}
	
	public ColMeta(String name,String desc){
		this.name = name;
		this.desc = desc;
	}
	
	public ColMeta(String name,String desc,String type){
		this.name = name;
		this.desc = desc;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrgUnit() {
		return orgUnit;
	}

	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}

	public String getDisplayUnit() {
		return displayUnit;
	}

	public void setDisplayUnit(String displayUnit) {
		this.displayUnit = displayUnit;
	}

	public BigDecimal getNumerator() {
		return numerator;
	}

	public void setNumerator(BigDecimal numerator) {
		this.numerator = numerator;
	}

	public BigDecimal getDenominator() {
		return denominator;
	}

	public void setDenominator(BigDecimal denominator) {
		this.denominator = denominator;
	}

}
