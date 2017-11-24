package com.sunrise.boss.ui.cms.reward.constant;

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
 * 0	��׼���̶����
 * 1	��׼�����ֳ��
 * 2	��׼��ר�Ž���
 * 3	����ҵ��������
 * 4	����ҵ�������
 * 5	����ҵ��������
 * 6	����ҵ�������
 * 7	�Ǽ����
 * 8	��Ŀ������
 */
public class RewardType {
	public final static int CARD_FIXED = 0; //��׼���̶����
	public final static int CARD_INTEGRAL = 1; //��׼�����ֳ��
	public final static int CARD_ALLOWANCE = 2; //��׼��ר�Ž���
	public final static int DATA_BASIC = 3; //����ҵ��������
	public final static int DATA_ENCOURAGE = 4; //����ҵ�������
	public final static int SERV_BASIC = 5; //����ҵ��������
	public final static int SERV_ENCOURAGE = 6; //����ҵ�������
	public final static int START = 7; //�Ǽ����
	public final static int STARTUP = 8; //��Ŀ������
	
	public static String getName(int type) {
		switch (type) {
		case 0:
			return "��׼���̶����";
		case 1:
			return "��׼�����ֳ��";
		case 2:
			return "��׼��ר�Ž���";
		case 3:
			return "����ҵ��������";
		case 4:
			return "����ҵ�������";
		case 5:
			return "����ҵ��������";
		case 6:
			return "����ҵ�������";
		case 7:
			return "�Ǽ����";
		case 8:
			return "��Ŀ������";
		default:
			return "" + type;
		}
	}
}
