/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.io.Serializable;

/**
 * ��Դ����
 * 
 * @author hbm
 */
public class SCPackage implements Serializable {
	private String batchNo;// ���κ�
	private String packageNo;// ����
	private String[] mobiles;// �ֻ�����

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}

	public String[] getMobiles() {
		return mobiles;
	}

	public void setMobiles(String[] mobiles) {
		this.mobiles = mobiles;
	}

}
