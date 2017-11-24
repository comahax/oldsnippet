package com.gmcc.pboss.biz.communi.service;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-10-29
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������Զ���������100����
 */
public class CommunicatePlateauOperation {
	/**�ظ�*/
	public static final int REPLAY = 101;
	/**��ѯ�ظ�*/
	public static final int REPLAY_QUERY = 102;
	
	/**����*/
	public static final int READ = 103;

	/**��������*/
	public static final int CREATE_QUESTION = 104;
	/**�ر�����*/
	public static final int CLOSE_QUESTION = 105;
	/**��ѯ����*/
	public static final int QUERY_QUESTION = 106;
	
	/**��������鿴*/
	public static final int READ_PENDING_TASK = 107;
	/**�����������*/
	public static final int FINISH_PENDING_TASK = 108;
	
	/**
	 * �����Ϣ��ѯ����
	 * @param type ��Ϣ����
	 * @return 200 + ��Ϣ����
	 */
	public static int getQueryInfosKind(String type){
		return 200 + Integer.parseInt(type);
	}
	
	/**
	 * �����Ϣ�鿴����
	 * @param type
	 * @return 300 + ��Ϣ����
	 */
	public static int getShowInfosKind(String type){
		return 300 + Integer.parseInt(type);
	}
}
