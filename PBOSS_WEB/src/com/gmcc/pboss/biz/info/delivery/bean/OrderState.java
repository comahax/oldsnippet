package com.gmcc.pboss.biz.info.delivery.bean;

import com.gmcc.pboss.common.bean.CodeReverse;

/**
 * ���˹�˾Ӫ�˲�
 * @author yuwenjun
 * @date 2009-10-3
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������������Ʒͳ����Ϣ
 */
public class OrderState extends CodeReverse {
	/**
	 * ��Ʒ���ͱ���
	 */
	private String dictitem;
	/**
	 * ����
	 */
	private Long num = new Long(0);
	
	/**
	 * @return the dictitem
	 */
	public String getDictitem() {
		return dictitem;
	}
	/**
	 * @param dictitem the dictitem to set
	 */
	public void setDictitem(String dictitem) {
		this.dictitem = dictitem;
	}
	/**
	 * @return the num
	 */
	public Long getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Long num) {
		this.num = num;
	}
	

}
