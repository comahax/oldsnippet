package com.sunrise.boss.business.resmanage.interf.param;

import java.util.Date;
 /** <p>Title: BOSS1.5</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author Rodney
 * @version ����11:32:082006-9-5
 */
public class ComResSmpParam extends BaseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393583690796741043L;
	private Date s_comactive; // ��󼤻�����***

	private Long simtype; // sim������***

	private String especnoupd; // �غ�ת��ģ��***

	private Long simyno; // sim���Ƿ������***

	private String dummycz;// �Ƿ���������ֵ��***

	private Long comid; // �׿���Ʒ��ʶ (pk)***

	private String batchno;// �׿�����***

	private String wayid;// ������ʶ***

	private Long comdisc;// ��Ʒ�ۿ�***
	
	private Double dcomdisc;

	private Long price;// ��Ʒ����***
	
	private Double dprice;

	private String prodid;// ��ƷƷ��***

	private String mobileno; // ����

	private String simno; // ��SIM��

	private String imsino; // IMSI

	private String pukno; // PUK
	
	private Long simprice;//sim���۸�
	
	private Double dsimprice;
	
	private Long mobiletype;//�û�����
	
	private String noprompt;//�����ض�����

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Long getComdisc() {
		return comdisc;
	}

	public void setComdisc(Long comdisc) {
		this.comdisc = comdisc;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getDummycz() {
		return dummycz;
	}

	public void setDummycz(String dummycz) {
		this.dummycz = dummycz;
	}

	public String getEspecnoupd() {
		return especnoupd;
	}

	public void setEspecnoupd(String especnoupd) {
		this.especnoupd = especnoupd;
	}

	public String getImsino() {
		return imsino;
	}

	public void setImsino(String imsino) {
		this.imsino = imsino;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getPukno() {
		return pukno;
	}

	public void setPukno(String pukno) {
		this.pukno = pukno;
	}

	public String getSimno() {
		return simno;
	}

	public void setSimno(String simno) {
		this.simno = simno;
	}

	public Long getSimtype() {
		return simtype;
	}

	public void setSimtype(Long simtype) {
		this.simtype = simtype;
	}

	public Double getDcomdisc() {
		return dcomdisc;
	}

	public void setDcomdisc(Double dcomdisc) {
		this.dcomdisc = dcomdisc;
		if(dcomdisc != null){
			double tmp = dcomdisc.doubleValue();
			this.comdisc = new Long((long)(tmp * 100));
		}
	}

	public Double getDprice() {
		return dprice;
	}

	public void setDprice(Double dprice) {
		this.dprice = dprice;
		if(dprice != null){
			double tmp = dprice.doubleValue();
			this.price = new Long((long)(tmp * 100));
		}
	}

	public Long getSimyno() {
		return simyno;
	}

	public void setSimyno(Long simyno) {
		this.simyno = simyno;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Long getMobiletype() {
		return mobiletype;
	}

	public void setMobiletype(Long mobiletype) {
		this.mobiletype = mobiletype;
	}

	public String getNoprompt() {
		return noprompt;
	}

	public void setNoprompt(String noprompt) {
		this.noprompt = noprompt;
	}

	public Double getDsimprice() {
		return dsimprice;
	}

	public void setDsimprice(Double dsimprice) {
		this.dsimprice = dsimprice;
		if(dsimprice != null){
			double tmp = dsimprice.doubleValue();
			this.simprice = new Long((long)(tmp * 100));
		}
	}

	public Date getS_comactive() {
		return s_comactive;
	}

	public void setS_comactive(Date s_comactive) {
		this.s_comactive = s_comactive;
	}

	public Long getSimprice() {
		return simprice;
	}

	public void setSimprice(Long simprice) {
		this.simprice = simprice;
	}
}


