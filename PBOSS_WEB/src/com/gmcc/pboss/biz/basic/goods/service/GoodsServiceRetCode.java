package com.gmcc.pboss.biz.basic.goods.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * ���˹�˾��������ҵ��
 * @author yuwenjun
 * @date 2009-11-12
 * ������Ŀ��PBOSS
 * ����ģ�飺��Ʒ���� 
 * ������
 */
public class GoodsServiceRetCode extends ServiceRetCode {
	//���ﳵ����
	/**
	 * ���ﳵΪ��
	 */
	public static final int CAREMPTY = 109;
	/**
	 * ���ﳵ�����쳣
	 */
	public static final int CARERROR = 108;
	/**
	 * ���ﳵ�����ڴ���Ʒ
	 */
	public static final int CARNOTFIND = 107;
	//�û�����Ʒ�����ʸ���
	/**
	 * �û��ж����ʸ�
	 */
	public static final int QUALIFICATION_SUCC = 110;
	/**
	 * �û�û�ж����ʸ�
	 */
	public static final int QUALIFICATION_FAIL = 111;
	/**
	 * �����ʸ��ж��쳣
	 */
	public static final int QUALIFICATION_ERROR = 112;
	
	//������Ϣ��ѯ
	/**
	 * ��ѯ�ɹ�
	 */
	public static final int QUERYBASEINFO_SUCC = 120;
	/**
	 * ������
	 */
	public static final int QUERYBASEINFO_FAIL = 121;
	/**
	 * ϵͳ�ڲ�����
	 */
	public static final int QUERYBASEINFO_ERROR = 122;
	
	//��Ʒ�ۼ�/����������ѯ
	/**
	 * ��ѯ�ɹ�
	 */
	public static final int QUERYPRICERADIX_SUCC = 130;
	/**
	 * ������
	 */
	public static final int QUERYPRICERADIX_FAIL = 131;
	/**
	 * ϵͳ�ڲ�����
	 */
	public static final int QUERYPRICERADIX_ERROR = 132;
	
	//���ϳ�ȡ
	/**
	 * ��ѯ�ɹ�
	 */
	public static final int GETGOODSRESOURCE_SUCC = 140;
	/**
	 * ������
	 */
	public static final int GETGOODSRESOURCE_FAIL = 141;
	/**
	 * ϵͳ�ڲ�����
	 */
	public static final int GETGOODSRESOURCE_ERROR = 142;
	/**
	 * ��ѯ��������
	 */
	public static final int GETGOODSRESOURCE_EXCEED = 146;
	/**
	 * ComType ����Ϊ��
	 */
	public static final int GETGOODSRESOURCE_COMTYPENULL = 143;
	/**
	 * OrderCount ����Ϊ��
	 */
	public static final int GETGOODSRESOURCE_ORDERCOUNTNULL = 144;
	/**
	 * WayID ����Ϊ��
	 */
	public static final int GETGOODSRESOURCE_WAYIDNULL = 145;

	//��Ʒ���������ύ
	/**
	 * ��ѯ�ɹ�
	 */
	public static final int ORDERCOMMIT_SUCC = 150;
	/**
	 * ������
	 */
	public static final int ORDERCOMMIT_FAIL = 151;
	/**
	 * ϵͳ�ڲ�����
	 */
	public static final int ORDERCOMMIT_ERROR = 152;
}
