package com.gmcc.pboss.common.pnrg;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-18
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 * 		中国移动手机号码信息
 */
public class MobileInfo {
	/**获取成功*/
	public static final String SUCCESS = "SUCCESS";
	/**非广东省号码*/
	public static final String UN_EXIST = "UN_EXIST";
	/**加载号码段文件出现异常*/
	public static final String EXCEPTION = "EXCEPTION";
	
	/**结果*/
	private String flage;
	/**地市编码*/
	private String branchCode;
	
	/**地市编码*/
	public String getBranchCode() {
		return branchCode;
	}
	/**地市编码*/
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getFlage() {
		return flage;
	}
	public void setFlage(String flage) {
		this.flage = flage;
	}
	
}
