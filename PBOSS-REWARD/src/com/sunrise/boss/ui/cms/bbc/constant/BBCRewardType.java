package com.sunrise.boss.ui.cms.bbc.constant;

/**
 * <p>
 * </p>
 * <p>
 * Description: BBC��վ�������(CH_BBCREWARDTYPE)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Linli
 * @version 1.0 2008��8��27��13:55:39
 */


/**
 * �������(CH_BBCREWARDTYPE)
 * 9	������������
 * 10	�����ཱ�����
 * 11	������վ��Ծ�ͻ��������
 * 12	������վ��Ծ�ͻ��������
 * 13	e100��Ծ�ͻ��������
 * 14	e100��Ծ�ͻ��������
 */

public class BBCRewardType {
	public final static int SELL_BASIC = 9; //������������
	public final static int SELL_ENCOURAGE = 10; //�����ཱ�����
	public final static int ACTV_NEW_BASIC = 11; //������վ��Ծ�ͻ��������
	public final static int ACTV_NEW_ENCOURAGE = 12; //������վ��Ծ�ͻ��������
	public final static int ACTV_E100_BASIC = 13; //e100��Ծ�ͻ��������
	public final static int ACTV_E100_ENCOURAGE = 14; //e100��Ծ�ͻ��������
	public static String getName(int type) {
		switch (type) {
		case 9:
			return "������������";
		case 10:
			return "�����ཱ�����";
		case 11:
			return "������վ��Ծ�ͻ��������";
		case 12:
			return "������վ��Ծ�ͻ��������";
		case 13:
			return "e100��Ծ�ͻ��������";
		case 14:
			return "e100��Ծ�ͻ��������";
		default:
			return "" + type;
		}
	}
}
