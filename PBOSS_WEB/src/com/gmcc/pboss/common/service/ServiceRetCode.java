package com.gmcc.pboss.common.service;

/**
 * ���˹�˾��������ҵ��
 * 
 * @author tangzhu
 * @date 2009-7-31 ������Ŀ�� ����ģ�飺 ������ ҵ�񹫹������� С��100
 */
public class ServiceRetCode {
	/**
	 * ҵ��ɹ�
	 */
	public static final int SUCCESS = 0;
	/**
	 * ҵ��ʧ��
	 */
	public static final int FAIL = 1;
	/**
	 * �û�δ��¼����ʹ��
	 */
	public static final int NOT_LOGIN = 2;
	/**
	 * û��Ȩ��ʹ�ø�ҵ��
	 */
	public static final int NOT_AUTHOR = 3;
	/**
	 * �����쳣
	 */
	public static final int EXCEPTION = 4;

	/**
	 * ҵ�����/����δ��ʼ��
	 */
	public static final int INIT_FAIL = 5;

	/**
	 * �˳�
	 */
	public static final int LOGOUT = 6;

	/**
	 * ��¼��ʽ����
	 */
	public static final int UN_LOGINTYPE = 7;

	/**
	 * ����ʧЧ
	 */
	public static final int CHANNEL_INVALIDATION = 8;

	/**
	 * ������ɾ��
	 */
	public static final int CHANNEL_DELETE = 9;

	/**
	 * ����״̬����
	 */
	public static final int CHANNEL_STATE_MISTAKE = 10;

	/**
	 * ������ʾ��Ϣ
	 */
	public static final String ERRORMESSAGE = "Error:";

	/**
	 * δ������Ϣ
	 */
	public static final int REWARD_STRIKE_BALANCE = 11;
	
	/**
	 * ע��ɹ���Ϣ
	 */
	public static final int REGISTER_SUCCESS = 12;
	
	/**
	 * �ǹ㶫ʡ�ƶ�����
	 */
	public static final int UN_GD_MOBILE = 13;
	
	/**
	 * ����ְ
	 */
	public static final int DISMISSIONED = 14;
	
	/**
	 * ���ƶ��ֻ�����
	 */
	public static final int UNMOBILE = 15;
	
	/**
	 * ��֤�����
	 */
	public static final int FAIL_ICODE = 16;
	
	/**
	 * ���ڸ�ʽ����
	 */
	public static final int DATE_FORMAT = 17;
	
	/**
	 * �Ƿ�����
	 */
	public static final int ILLEGALITY = 18;
	
	/**
	 * ����δ�鵽
	 */
	public static final int NOTFOUND_OPRCODE = 19;
	
	/**
	 * �����ѹر�
	 */
	public static final int QUESTION_CLOSE = 20;
	
	/***
	 * ����Ϊ��
	 */
	public static final int EMPTY = 21;
	
	/**�û��ֻ������ϵͳĬ�ϵ���*/
	public static final int UNDEFAULT_BRANCH = 22;
	/***
	 * �ֻ������Ѿ�����
	 */
	public static final int MOBLEEXIST = 23;
	
	/**�û��ֻ����벻����*/
	public static final int MOBLENOTEXIST = 24;

	/** �ֻ����벻����ѡ���к��� */
	public static final int MOBILENOCITYERROR = 25;
	/**
	 * �����Ѿ��ر�
	 */
	public static final int INVALIDCITY = 30;
	
	/**
	 * ������������
	 */
	public static final int EMPTY_WAYMMG = 190;
	
	/**
	 * �ύ�ɹ�
	 */
	public static final int DEF_APPLY = 200;
	/**
	 * �˳��ɹ�
	 */
	public static final int DEF_OUT = 201;
	
	/**
	 * ҵ�����г���
	 */
	//public static final int SERVICE_RUN = 99;
}
