package com.gmcc.pboss.biz.basic.goods.bean;
/**
 * ���˹�˾Ӫ�˲�
 * @author yuwenjun
 * @date 2009-10-3
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������Ʒ����������Ʒͳ����Ϣ
 */
public class GoodsStat {
	/**
	 * ��Ʒ����
	 */
	private String type;

	/**
	 * ��Ʒ���ͱ���
	 */
	private String comType;
	/**
	 * ���� - �����������û��
	 */
	private int pckgCnt = 0;
	/**
	 * ����
	 */
	private int dtlCnt = 0;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the comType
	 */
	public String getComType() {
		return comType;
	}

	/**
	 * @param comType the comType to set
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}

	/**
	 * @return the pckgCnt
	 */
	public int getPckgCnt() {
		return pckgCnt;
	}

	/**
	 * @param pckgCnt the pckgCnt to set
	 */
	public void setPckgCnt(int pckgCnt) {
		this.pckgCnt = pckgCnt;
	}

	/**
	 * @return the dtlCnt
	 */
	public int getDtlCnt() {
		return dtlCnt;
	}

	/**
	 * @param dtlCnt the dtlCnt to set
	 */
	public void setDtlCnt(int dtlCnt) {
		this.dtlCnt = dtlCnt;
	}
	public void addNew(int packageCnt,int dtl){
		this.pckgCnt += packageCnt;
		this.dtlCnt += dtl;
	}
	public void delOne(Goods goods){
		this.pckgCnt-- ;
		this.dtlCnt -= goods.getOrderCount();
	}
}
