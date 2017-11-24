package com.sunrise.jop.exception.business;

import com.sunrise.jop.exception.JOPException;

/**
 * <p>
 * Title: ����ҵ�������Ϣ
 * </p>
 * <p>
 * Description: ����ҵ�����ʧ������µĴ�����Ϣ
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class SaleException extends RuntimeException {
	private static final long serialVersionUID = 4800793721453063275L;

	public static final String ERROR_CODE_SALE = "business.sale";

	private String errorCode = ERROR_CODE_SALE;

	private String timesect; // ����ʱ���

	private String comcode; // ��Ʒ�������

	private String brandcode; // Ʒ�Ʊ���

	private String brandname; // Ʒ������

	private Long orderamt; // ��������

	private Long unitage; // ��������

	private Long maxamt; // ��������

	private String compname; // �ֹ�˾����

	private String cooptypename; // ������������
	
	private Long montimes; // �¶�������
	
	private Long monmaxtimes; // ����󶩹�����

	private String starlevelname; // �Ǽ�
	/**
	 * ���췽�� ���쳣��ʾ��ֻ�ṩ�����뼴��
	 * 
	 * @param errorCode
	 *            ������
	 */
	public SaleException(String errorCode) {
		super(JOPException.toMessage(SaleException.class,
				checkErrorCode(errorCode), ""));
		setErrorCode(errorCode);
	}

	/**
	 * ���췽�� �����Ҫ�滻���ݵ��쳣��ʾ����Ҫ��д������ʹ��������������
	 * 
	 * @param errorCode
	 *            ������
	 * @param msgParam
	 *            �������ֵ�������滻����
	 */
	public SaleException(String errorCode, String msgParam) {
		super(JOPException.toMessage(SaleException.class,
				checkErrorCode(errorCode), msgParam));
		setErrorCode(errorCode);
	}

	/**
	 * ���췽�� �����Ҫ�滻���ݵ��쳣��ʾ����Ҫ��д������ʹ�������������
	 * 
	 * @param errorCode
	 *            ������
	 * @param msgParam
	 *            �������ֵ�������滻����
	 */
	public SaleException(String errorCode, String[] msgParam) {
		super(JOPException.toMessage(SaleException.class,
				checkErrorCode(errorCode), msgParam));
		setErrorCode(errorCode);
	}

	/**
	 * ��������
	 * 
	 * @param errorCode
	 *            ������
	 * @return
	 */
	protected static String checkErrorCode(String errorCode) {
		return (errorCode == null) ? ERROR_CODE_SALE : errorCode;
	}

	public Long getUnitage() {
		return unitage;
	}

	public void setUnitage(Long unitage) {
		this.unitage = unitage;
	}

	public String getBrandcode() {
		return brandcode;
	}

	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getCooptypename() {
		return cooptypename;
	}

	public void setCooptypename(String cooptypename) {
		this.cooptypename = cooptypename;
	}

	public Long getMaxamt() {
		return maxamt;
	}

	public void setMaxamt(Long maxamt) {
		this.maxamt = maxamt;
	}

	public Long getOrderamt() {
		return orderamt;
	}

	public void setOrderamt(Long orderamt) {
		this.orderamt = orderamt;
	}

	public String getTimesect() {
		return timesect;
	}

	public void setTimesect(String timesect) {
		this.timesect = timesect;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Long getMonmaxtimes() {
		return monmaxtimes;
	}

	public void setMonmaxtimes(Long monmaxtimes) {
		this.monmaxtimes = monmaxtimes;
	}

	public Long getMontimes() {
		return montimes;
	}

	public void setMontimes(Long montimes) {
		this.montimes = montimes;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static String getERROR_CODE_SALE() {
		return ERROR_CODE_SALE;
	}

	public String getStarlevelname() {
		return starlevelname;
	}

	public void setStarlevelname(String starlevelname) {
		this.starlevelname = starlevelname;
	}
	
}