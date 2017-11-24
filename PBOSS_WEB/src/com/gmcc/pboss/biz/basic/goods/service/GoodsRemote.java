package com.gmcc.pboss.biz.basic.goods.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gmcc.pboss.biz.basic.goods.bean.Goods;
import com.gmcc.pboss.biz.basic.goods.supper.GoodsListQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.ServiceResult;

public interface GoodsRemote extends BaseService {
	/**
	 * ��Ʒ�����ʸ���
	 * @param wayId ��������
	 * @return
	 */
	public ServiceResult chkQualification(LoginMember member);
	
	/**
	 * ������Ϣ��ѯ
	 * @param wayId ��������
	 * @return
	 */
	public ServiceResult getBaseInfo(LoginMember member);
	
	/**
	 * ��Ʒ�ۼ�/����������ѯ
	 * @param wayId ��������
	 * @param prdcClg ��Ʒ���ࣨ��������ֵ����
	 * @return
	 */
	public ServiceResult getPriceRadix(LoginMember member,String comType);
	
	/**
	 * ��Ʒ��Դ��ȡ
	 * @param wayId �����̱���
	 * @param comType ��Ʒ�����ʶ��
	 * @param orderCount ����������
	 * @return
	 */
	public ServiceResult getProductList(String wayId,String comType,int orderCount,GoodsListQueryParameter param);
	
	/**
	 * ��Ʒ���������ύ
	 * @param wayId �����̱���
	 * @param sendObj �ַ�������,ÿ������Ϊ����Ʒ�����ʶ~��������
	 * @return
	 */
	public ServiceResult submitOrder(LoginMember member,List<Goods> sendObj,boolean isQueryDetail);
	
}