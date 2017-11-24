package com.gmcc.pboss.biz.communi.support;

import com.gmcc.pboss.common.support.QueryParameter;
/**
 * ���˹�˾��������ҵ��
 * @author zhangsiwei
 * @date 2009-11-06
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������ͨƽ̨�������
 */
public class CommunicateReplyParameter extends QueryParameter {

	/**
	 * ������ϢID
	 */
	private Long advinfoid;
	
	/**
	 * �����ʶ
	 */
	private String oid;
	
	/**
	 * �ϴ�����
	 */
	private String affix;
	/**
	 * ����
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
