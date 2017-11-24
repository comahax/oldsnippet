package com.gmcc.pboss.service;

import java.util.List;

import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.BookBasicInfo;
import com.gmcc.pboss.service.result.goods.GoodsInfo;
import com.gmcc.pboss.service.result.goods.GoodsResource;

/**
 * �ṩ����վʹ�õĽӿ�
 * 
 * @author hbm
 */
public interface WebSiteService {
	// ���ڲ��Է����Ƿ����
	String test(String param);

	// ��Ʒ�����ʸ���
	// ��������: ��֤�û��Ƿ������Ʒ�������ʸ�
	RetResult bookQualificationCheck(String wayid);

	// ������Ϣ��ѯ
	// ������������ѯ�û������Ķ�����Ϣ��
	BookBasicInfo queryBookBasicInfo(String wayid);

	// ��Ʒ�ۼۡ�����������ѯ
	// ������������ѯ��Ʒ�ۼۡ�����������
	GoodsInfo queryGoodsPriceRadix(String wayid, String comType);

	// ��Ʒ��Դ��ȡ
	// ����������������Ʒ�����������������Ʒ������Դ��ϸ���ṩ���û�ѡ��
	GoodsResource getGoodsResource(String wayid, String comType, int orderCount);

	// ��Ʒ���������ύ
	// ������������Ʒ������
	RetResult comOrderCommit(String wayid, boolean isQueryDetail, List comOrderList);
	
	/**
	 * ������һ������
	 * @param wayid
	 * @param orderid
	 * @return
	 */
	RetResult doOrderNextProc (String wayid,String orderid);
}
