/**
 * 
 */
package com.gmcc.pboss.BgProcess.service.sms;

/**
 * @author hbm
 * Э����
 */
public class SMSProtocol {
	
	//����Ӫҵ����PBOSS������
	static public String INTERFACE_ACTIVITYRATIO = "77001";  //�׿������ʲ�ѯ�ӿ�
	static public String INTERFACE_COMORDER = "77002";       //��Ʒ�����ӿ�
	static public String INTERFACE_ORDERQUERY = "77003";     //������ѯ�ӿ�

	static public String WORD_SLIT_SYMBOL = "~"; // �ʷָ���
	static public String STR_SLIT_SYMBOL = "^"; // ���ָ���
	static public String WORD_END_SYMBOL = ";"; // ��������
	static public String STR_END_SYMBOL = "|"; // ��������
	static public String DATA_SLIT_SYMBOL = "#"; // ���ݶηָ�����

	public static final String WRONG_FORMAT = "MMM~�����ʽ����(wrong request format);";
	
	public static final String WRONG_COMMAND_STR = ";";

	static public boolean checkFormatIsOK(String msg) {
		if (msg == null) {
			return false;
		}
		if (msg.trim().length() < 6) { //����Ҫ��������Ҫ��
			return false;
		}
		if(msg.indexOf(WORD_SLIT_SYMBOL) > 4){
			return true;
		}
		//@todo ��Ӳ��ж��߼�
		return false;
	}

	static public String getCommandStr(String msg) {
		return msg.substring(0, msg.indexOf(WORD_SLIT_SYMBOL));
	}
	
	static public String getContextStr(String msg) {
		return msg.substring(msg.indexOf(WORD_SLIT_SYMBOL)+1,msg.length()-1);
	}
}
