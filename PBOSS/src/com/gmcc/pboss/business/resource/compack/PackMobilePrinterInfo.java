package com.gmcc.pboss.business.resource.compack;

import java.util.List;

/**
 * �׿���װ(����)��ӡ�����Ϣ��
 * @author zhangsiwei
 *
 */
public class PackMobilePrinterInfo {

	/**����*/
	private String pack_number;
	/**�����б�*/
	private List<String> mobileno;
	
	public String getPack_number() {
		return pack_number;
	}
	public void setPack_number(String pack_number) {
		this.pack_number = pack_number;
	}
	public List<String> getMobileno() {
		return mobileno;
	}
	public void setMobileno(List<String> mobileno) {
		this.mobileno = mobileno;
	}
	
	
	
	
}
