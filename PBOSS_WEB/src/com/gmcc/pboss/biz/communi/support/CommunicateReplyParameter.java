package com.gmcc.pboss.biz.communi.support;

import com.gmcc.pboss.common.support.QueryParameter;
/**
 * 从兴公司电子渠道业务部
 * @author zhangsiwei
 * @date 2009-11-06
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：沟通平台处理参数
 */
public class CommunicateReplyParameter extends QueryParameter {

	/**
	 * 公告信息ID
	 */
	private Long advinfoid;
	
	/**
	 * 对象标识
	 */
	private String oid;
	
	/**
	 * 上传附件
	 */
	private String affix;
	/**
	 * 类型
	 */
	private Integer type;
	
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getAdvinfoid() {
		return advinfoid;
	}
	public void setAdvinfoid(Long advinfoid) {
		this.advinfoid = advinfoid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getAffix() {
		return affix;
	}
	public void setAffix(String affix) {
		this.affix = affix;
	}
	
	
}
