package com.gmcc.pboss.business.resource.compack;

import java.util.List;

/**
 * 套卡包装(包号)打印结果信息类
 * @author zhangsiwei
 *
 */
public class PackMobilePrinterInfo {

	/**包号*/
	private String pack_number;
	/**号码列表*/
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
