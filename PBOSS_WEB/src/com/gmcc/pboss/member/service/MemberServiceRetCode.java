package com.gmcc.pboss.member.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-7-31
 * ������Ŀ��
 * ����ģ�飺
 * ������
 */
public class MemberServiceRetCode extends ServiceRetCode {
	/**
	 * ��֤��ʧ��
	 */
	public static final int VERIFY_FAIL = 101;
	
	/**
	 * δע��
	 */
	public static final int NOT_REGISTER = 102;
	
	/**
	 * δ������֤��
	 */
	public static final int NOT_VCODE = 103;
	
	/**
	 * ���벻��ȷ
	 */
	public static final int INPUT_FAIL = 104;
	
	/**
	 * ������Ϣ��ѯʧ��
	 */
	public static final int CHANNEL_FAIL = 105;
	
	/**
	 *�����̵�¼ 
	 */
	public static final int CHANNEL_LOGIN = 106;
	
	/**
	 * �����̵�¼
	 */
	public static final int DELIVERY_LOGIN = 107;
	
	/**
	 * �������Ӧ����ڸ���Ա
	 */
	public static final int MORE_THAN_ONE_MASTER = 198;
	
	/**
	 * �̶�����-��֤ʧ��
	 */
	public static final int FIXED_PW_VERIFY_FAIL = 199;
	
	/**
	 * ������Ա��¼
	 */
	public static final int MANAGER_LOGIN = 191;
	
	/**
	 * �������Ͳ���ȷ
	 */
	public static final int UNCORRECT_WAYTYPE = 108;
	
	/**
	 * ��Ա������ɹ�
	 */
	public static final int EMPLOYEEAPPLY= 200;
	/**
	 * ��Ա�޸�������ɹ�
	 */
	public static final int EMPLOYEEUPADEAPPLY= 202;
	/**
	 * ��Ա�˳�����ɹ�
	 */
	public static final int EMPLOYEEQUIT= 201;
	/**
	 * �Ҳ���Ĭ�ϴ�����
	 */
	public static final int OPRCODEISNULL = 210;
	/**
	 * ��Ͻ�ɫ��½��������+��������
	 */
	public static final int MIX_ROLE = 211;
	
	/**
	 * �޷�ȷ����½��Ա��������
	 */
	public static final int MEMBERCITY = 212;
	/**
	 * רԱ����Ϊ�գ����ܷ���
	 */
	public static final int MEMBERNULL = 213;
	/**
	 * ��������רԱ���Ͳ�֧�ַ���
	 */
	public static final int MEMBERTYPE = 214;
	
	/**
	 * ʡ������Ա��¼
	 */
	public static final int GDMEMBERTYPE = 220;
	/**
	 * �о�����Ա��¼
	 */
	public static final int CITYMEMBERTYPE = 221;
}
