package com.gmcc.pboss.biz.basic.goods.bean;

import java.util.Date;
import java.util.List;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-9-17
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������׿���
 */
public class SuitCardPackage extends Goods{
	/**����*/
	private String packageNo;
	/**����ʱ��*/
	private Date publicTime;
	/**�׿��б�*/
	private List suitCardList;
	
	/**����*/
	public String getPackageNo() {
		return packageNo;
	}
	/**����*/
	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}
	
	/**����ʱ��*/
	public Date getPublicTime() {
		return publicTime;
	}
	/**����ʱ��*/
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	
	/**�׿��б�*/
	public List getSuitCardList() {
		return suitCardList;
	}
	/**�׿��б�*/
	public void setSuitCardList(List suitCardList) {
		this.suitCardList = suitCardList;
	}
	
	
}
