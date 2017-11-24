package com.gmcc.pboss.common.dictionary;

import com.gmcc.pboss.common.util.JSTLConstants;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-8-21
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������̶���������,û������˵���Ķ��Ǵ������ļ���ȡ����
 */
public class ConstantsType extends JSTLConstants {
	/**������� ������� �����ݿ���ȡ*/
	public static final String SOCIETY_REWARD_TPYPE = "CH_REWARDTYPE";
	/**��վ���� ������� �����ݿ���ȡ*/
	public static final String BBC_REWARD_TPYPE = "CH_BBCREWARDTYPE";
	
	/**������� ���У��ʧЧ ������� XML*/
	public static final String SOCIETY_REWARDVERIFIED_TPYPE = "SOCIETY_REWARDVERIFIED_TPYPE";
	/**��վ���� ���У��ʧЧ ������� XML*/
	public static final String BBC_REWARDVERIFIED_TPYPE = "BBC_REWARDVERIFIED_TPYPE";
	
	/**��ᣨ��վ������ �������-��� XML*/
	public static final String SOCIETY_REWARD_TPYPE_SHORTNAME = "SOCIETY_REWARD_TPYPE_SHORTNAME";
	/**�������� ҵ��ƽ̨��Դ XML */
	public static final String CH_UNPB_OSSRC="CH_UNPB_OSSRC";
	
	
	/**21�������� XML*/
	public static final String BRANCH_NAME = "BRANCH_NAME";
	/**21���б��� XML*/
	public static final String BRANCH_NO = "BRANCH_NO";

	/**
	 * 21�������Ż��Ƿ񿪷� XML
	 * 1-���ţ�0-�ر�
	 */
	public static final String ISOPEN = "ISOPEN";
	public static final String ISOPEN_YES = "1";
	public static final String ISOPEN_NO = "0";
	/**
	 * 21�������Ż��Ƿ���ʾ���ģ�� XML
	 */
	public static final String CAN_QUERY_REWARD = "CAN_QUERY_REWARD";
	public static final String CAN_QUERY_REWARD_YES = "1";
	public static final String CAN_QUERY_REWARD_NO = "0";
	
	/**21������  ��Ʒ�����Ƿ���Ҫ��ѯ��Դ��ϸ XML
	 * 1-��Ҫ��0-����Ҫ
	 */
	public static final String ISQUERY = "ISQUERY";
	/** 21������  ��Ʒ������Ҫ��ѯ��Դ��ϸ
	 * 1-��Ҫ
	 */
	public static final String QueryTrue = "1";

	/** 21������  ��Ʒ��������Ҫ��ѯ��Դ��ϸ
	 * 0-��Ҫ
	 */
	public static final String QueryFlase = "0";

	/**���๺����������״̬  �����ݿ���ȡ*/
	public static final String VALIDFLAG = "CH_VALIDFLAG";
	
	/**��Ӫҵ̬ �����ݿ���ȡ*/
	public static final String FORMTYPE = "CH_FORMTYPE";
	
	/**�������� �����ݿ���ȡ*/
	public static final String CATETYPE = "CH_CATETYPE";
	
	/**�Ƴ귽ʽ �����ݿ���ȡ*/
	public static final String ACCTYPE = "CH_ACCTYPE";
	
	/**�Ƴ귽ʽ �����ݿ���ȥ*/
	public static final String BSACCTYPE = "CH_BSACCTYPE";
	
	/**���س������ �����ݿ���ȥ*/
	public static final String REWARDLOCALTYPE = "CH_REWARDLOCALTYPE";
	
	/** 
	 * ���س������ - �Ƴ���ϸ���� 
	 */
	public static final String RPWDLocalRPT = "RPWDLocalRPT";
	/** 
	 * ���س������ - ���������ܱ�
	 */
	public static final String RRWDSumRPT = "RRWDSumRPT";
	
	/**����ˮƽ �����ݿ���ȡ*/
	public static String EDULEVEL = "CH_EDULEVEL";
	
	/**�Ա� �����ݿ���ȡ*/
	public static final String SEX = "CH_SEX";
	
	/**�Ͷ���ϵ �����ݿ���ȡ*/
	public static final String CONTACTTYPE = "CH_CONTACTTYPE";
	
	/**�ù����� �����ݿ���ȡ*/
	public static String EMPLOYTYPE = "CH_EMPLOYTYPE";
	
	/**�ù�״̬ �����ݿ���ȡ*/
	public static final String EMPSTATUS = "CH_EMPSTATUS";
	
	/**Ʒ�� �����ݿ���ȡ*/
	public static final String SIMBRAND = "CH_SIMBRAND";
	
	/**��¼��ʽ �����ݿ���ȡ*/
	public static final String AUTH_TYPE = "WEB_AUTHTYPE";
	/**
	 * �׿����� �����ݿ���ȡ
	 */
	public final static String IM_COMTYPE = "IM_COMCLASS";
	/**
	 * �׿���� �����ݿ���ȡ
	 */
	public final static String IM_COMTYPE2 = "IM_COMTYPE";
	/**
	 * �׿��Ǽ�����
	 */
	public final static String CH_MFLAG="CH_MFLAG";
	
	
	/**��������� XML*/
	public static final String WAY_SUB_TYPE="WAY_SUB_TYPE";
	
	/** һ�����״̬ - 0ֵδ����  */
	public static final Byte AUDITSTATUS_NO = new Byte("0");
	
	/**δ����״̬*/
	public static final Long UNPUBLISH = new Long(1);
	
	//�ύ����
	/**
	 * �ύ���� - ADD
	 */
	public static final String ACTION_ADD="ADD";
	/**
	 * �ύ���� - UPDATE
	 */
	public static final String ACTION_UPDATE="UPDATE";
	
	
	//��������CH_PW_AUDITWORK
	/**
	 *������ - AUDITWORK �������� - ע��
	 */
	public static final String AUDITWORKTYPE_WAYADD = "WAY_ADD_AUDIT";
	/**
	 *������ - AUDITWORK �������� - �������ϲ�ѯ���޸�����
	 */
	public static final String AUDITWORKTYPE_WAYUPDATE = "WAY_UPDATE_AUDIT";
	/**
	 *������ - AUDITWORK �������� - �����˳�
	 */
	public static final String AUDITWORKTYPE_WAYREMOVE = "WAY_REMOVE_AUDIT";
	/**
	 *������ - AUDITWORK �������� -��Ա����
	 */
	public static final String AUDITWORKTYPE_EMPLOYEEUPDATE = "EMPLOYEE_UPDATE_AUDIT";
	/**
	 *������ - AUDITWORK �������� -��Ա����
	 */
	public static final String AUDITWORKTYPE_EMPLOYEEADD = "EMPLOYEE_ADD_AUDIT";
	/**
	 *������ - AUDITWORK �������� -��Ա�˳�
	 */
	public static final String AUDITWORKTYPE_EMPLOYEEREMOVE = "EMPLOYEE_REMOVE_AUDIT";
	/**
	 * ��ǰ���� - AUDITSTEPID �������� -ע��
	 */
	public static final String AUDITSTEPID_WAY_ADD1 = "WAY_ADD_AUDIT1";
	/**
	 * ��ǰ���� - AUDITSTEPID �������� -�������ϲ�ѯ���޸�����
	 */
	public static final String AUDITSTEPID_WAY_UPDATE1 = "WAY_UPDATE_AUDIT1";
	/**
	 * ��ǰ���� - AUDITSTEPID �������� -�����˳�
	 */
	public static final String AUDITSTEPID_WAY_REMOVE1 = "WAY_REMOVE_AUDIT1";
	/**
	 * ��ǰ���� - AUDITSTEPID �������� -��Ա����
	 */
	public static final String AUDITSTEPID_EMPLOYEEADD1 = "EMPLOYEE_ADD_AUDIT";
	/**
	 * ��ǰ���� - AUDITSTEPID �������� -��Ա�����޸�����
	 */
	public static final String AUDITSTEPID_EMPLOYEEUPDATE1 = "EMPLOYEE_UPDATE_AUDIT";
	/**
	 * ��ǰ���� - AUDITSTEPID �������� -��Ա�˳�
	 */
	public static final String AUDITSTEPID_EMPLOYEEREMOVE1 = "EMPLOYEE_REMOVE_AUDIT";
	/**
	 * ���۱��� - ��ѯ�ӱ����� - ������Դ��ϸ
	 */
	public static final String SALES_SELECTYPE_RESDETS = "RESDETS";
	/**
	 * ���۱��� - ��ѯ�ӱ����� - ������Ʒ����
	 */
	public static final String SALES_SELECTYPE_COMCATE = "COMCATE";
	/**
	 * �����ʴ� - �ҵ����� - ����״̬ XML
	 */
	public static final String QUESTION_STATE = "QUESTION_STATE";
	
	/**
	 * ��ֵ�� COMRESCARD
	 */
	public static final String COMRESCARD = "COMRESCARD";
	/**
	 * �׿� COMRESSMP
	 */
	public static final String COMRESSMP = "COMRESSMP";
	
	/**
	* �հ�SIM�� COMRESSMP
	*/
	public static final String EMPTYSIM = "EMPTYSIM";
	
	//������������
	/**
	 * �������� - �ͻ����� 
	 */
	public static final String ORDERCOMTYPE_CUSTORDER = "CUSTORDER";
	/**
	 * �������� - ϵͳ����
	 */
	public static final String ORDERCOMTYPE_SYSGIFT = "SYSGIFT";
	/**
	 * �������� - ϵͳ����
	 */
	public static final String ORDERCOMTYPE_SYSTIEIN = "SYSTIEIN";
	
	/**
	 * �����Ǽ�
	 */
	public static final String STARLEVEL = "CH_STARLEVEL";
	

	/**
	 * ���͵�״̬ - ȡֵ��ʽ��ͨ���̶�������xml�ļ���
	 */
	public final static String DISSTATE = "FX_DISFORMSTATE";
	
	/**
	 * ���͵��̶�״̬ - ������
	 */
	public final static String DISSTATE_WAITOUT = "WAITOUT";
	/**
	 * ���͵��̶�״̬ - ������
	 */
	public final static String DISSTATE_WAITDIS = "WAITDIS";
	/**
	 * ���͵��̶�״̬ - ������	
	 */
	public final static String DISSTATE_DISING= "DISING";
	/**
	 * ���͵��̶�״̬ - �������
	 */
	public final static String DISSTATE_DISOVER = "DISOVER";
	/**
	 * ���͵��̶�״̬ - ����
	 */
	public final static String DISSTATE_CANCEL = "CANCEL";
	/**
	 * ����ȷ������
	 */
	public final static String FX_SMSCONTYPE = "FX_SMSCONTYPE";
	/**
	 * ����ȷ������ - ����ȷ��
	 */
	public final static String FX_SMSCONTYPE_ORDERCON = "ORDERCON";
	/**
	 * ����ȷ������ - ������ǩ��
	 */
	public final static String FX_SMSCONTYPE_PARSIGN = "PARSIGN";
	/**
	 * ���Żظ�״̬
	 */
	public final static String FX_SMSREPSTATE = "FX_SMSREPSTATE";
	/**
	 * ���Żظ�״̬ - ���ظ�
	 */
	public final static String FX_SMSREPSTATE_WAITREP = "WAITREP";
	/**
	 * ���Żظ�״̬ - �ѻظ�
	 */
	public final static String FX_SMSREPSTATE_REPLIED = "REPLIED";
	/**
	 * ����״̬ - WAITCON ��ȷ��
	 */
	public final static String ORDERSTATE_WAITCON = "WAITCON";
	/**
	 * ����״̬ - CANCEL ����
	 */
	public final static String ORDERSTATE_CANCEL = "CANCEL";
	/**
	 * �����Ƿ�ȷ�� -- ���־
	 */
	public final static Short Confirmflag_NO = 0;
	/**
	 * �����Ƿ�ȷ�� -- �Ǳ�־
	 */
	public final static Short Confirmflag_YES = 1;
	/**
	 * ������� ������� �ͻ�������չ��� 
	 */
	public final static String CH_REWARD_TYPE = "CH_REWARD_TYPE";
	/**
	 * �ƹ�רԱ-��Ա����
	 */
	public final static String CH_EMPATTR2 = "CH_EMPATTR2";
}