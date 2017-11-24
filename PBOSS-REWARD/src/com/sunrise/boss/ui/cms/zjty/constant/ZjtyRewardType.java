package com.sunrise.boss.ui.cms.zjty.constant;

/**
 * <p>
 * Title: StdrewardbjAction
 * </p>
 * <p>
 * Description: �������(CH_REWARDTYPE)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0 2008-03-06
 */

/**
 * �������(CH_REWARDTYPE)
 * 80	��׼�����۳��
 * 81	��׼��������
 * 82	��׼���ͻ�������
 * 83	����ҵ��������
 * 84	����ҵ�������
 * 85	����ҵ��������
 * 86	����ҵ�������
 * 87	�ն����ۻ������
 * 88   �̶����
 */
public class ZjtyRewardType {
	public final static int CARD_FIXED = 80; //��׼�����۳��
	public final static int CARD_INTEGRAL = 81; //��׼��������
	public final static int CARD_ALLOWANCE = 82; //��׼���ͻ�������
	public final static int SERV_BASIC = 83; //����ҵ��������
	public final static int SERV_ENCOURAGE = 84; //����ҵ�������
	public final static int DATA_BASIC = 85; //����ҵ��������
	public final static int DATA_ENCOURAGE = 86; //����ҵ�������
	public final static int CLIENT_BASIC = 87; //�ն����ۻ������
	public final static int FIXED_BASIC = 88; //�̶����
	
	public static String getName(int type) {
		switch (type) {
		case 80:
			return "��׼�����۳��";
		case 81:
			return "��׼��������";
		case 82:
			return "��׼���ͻ�������";
		case 83:
			return "����ҵ��������";
		case 84:
			return "����ҵ�������";
		case 85:
			return "����ҵ��������";
		case 86:
			return "����ҵ�������";
		case 87:
			return "�ն����ۻ������";
		case 88:
			return "�̶����";
		default:
			return "" + type;
		}
	}
}
