/**
 * 
 */
package com.gmcc.pboss.service.result.goods;

import java.util.List;

import com.gmcc.pboss.service.result.RetResult;

/**
 * ��Ʒ��Դ�����
 * 
 * @author hbm
 */
public class GoodsResource extends RetResult {
	static final public int OVER_QUERY_LIMIT_TIMES = 3; //(�����볣��)��ѯʧ�ܣ���ѯ������������
	
	private List goodsList;//List�����Ԫ����<SCPackage>����

	public List getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List goodsList) {
		this.goodsList = goodsList;
	}

}
