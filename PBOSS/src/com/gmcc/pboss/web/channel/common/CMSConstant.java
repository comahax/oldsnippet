package com.gmcc.pboss.web.channel.common;

import java.io.File;

public class CMSConstant {
    private CMSConstant() {
    }
   

    public final static String GMCC = "GMCC";
    public final static int POSTIL_FILEDATA_LENGTH = 4; // ���������ļ������������ļ��ģ�ÿ�����ݵĳ���
    
    /* ������ʽ */
    /* ƥ��"yyyy-MM-dd"��ʽ���ַ���, yyyy����Ϊ4Ϊ����, ����MM[00-12], dd[00-31] */
    public final static String DATE_REGEX = "^\\d{4}-{1}(0{1}[0-9]{1}|1{1}[012]{1})-{1}(0{1}[0-9]{1}|[12]{1}\\d{1}|3{1}[01]{1})$";
    
    public final static String COMMAND_STATE = "STATE";
    public final static String COMMAND_STEP = "STEP";
    public final static String COMMAND_RECID = "RECID";
    public final static String COMMAND_FLOWFLAG = "FLOWFLAG";
    public final static String COMMAND_NEXT = "NEXT";
    public final static String COMMAND_BACK = "BACK";
    public final static String RESOPRDATA_RESTYPE_APPLY = "1"; // ��Դ�����ͣ����룩
    public final static String RESOPRDATA_RESTYPE_PUT = "2"; // ��Դ�����ͣ����ţ�
    public final static String RESOPRDATA_RESTYPE_BACK = "3"; // ��Դ�����ͣ����գ�
    public final static String RESOPRDATA_RESTYPE_INDEPOT = "4"; // ��Դ�����ͣ���⣩

    public final static String COMMAND_MAIN = "MAIN"; // ת��mainҳ��
    public final static String COMMAND_RELEASE = "RELEASE"; // �����������뵥�����棩
    public final static String COMMAND_UPDATE = "UPDATE"; // ���뵥���£��޸ģ�
    public final static String COMMAND_TOPUT = "TOPUT"; // ת�����ţ���������ǩҳ
    public final static String COMMAND_TOBATCHPOSTIL = "TOBATCHPOSTIL"; // ת������������ǩҳ
    public final static String COMMAND_PUT = "PUT"; // ����
    public final static String COMMAND_BATCHPOSTIL = "BATCHPOSTIL"; // ��������
    public final static String COMMAND_UNIFYPUT = "UNIFYPUT"; // ͳһ����
    public final static String COMMAND_LEACHTYPE = "LEACHTYPE"; // ������Ʒ����
    public final static String COMMAND_LEACHID = "LEACHID"; // ������Ʒ��ʶ
    public final static String COMMAND_SUBMIT = "SUBMIT"; // �ύ
    public final static String COMMAND_DENY = "DENY"; // �ܾ�
    public final static String COMMAND_TOSEND = "TOSEND"; // ת����Դ���͵�ҳ��
    public final static String COMMAND_TOPRINT = "TOPRINT"; // ת����ӡ���͵�ҳ��
    public final static String COMMAND_UPDATE_SENDNO = "UPDATE_SENDNO"; // �������͵���
    public final static String COMMAND_INCEPT = "INCEPT"; // ����
    public final static String COMMAND_SHOWDIALOG = "SHOWDIALOG"; // ����������
    
    
    /* �м������ */
    public final static short CH_GOODSCLASS_INTEGRAL = 2; // ���ֿ���
    public final static short CH_GOODSCLASS_SIM = 5; // SIM��
    public final static short CH_GOODSCLASS_OTHERS = 99; // ����
    
    /* ҳ�����  */
    /* ���͵��� */
    public final static String SEND = "SEND"; // ��ʶ�Ƿ������͵�ҳ�� 
    public final static String NOT_TOBE_SEND = "NOT_TOBE_SEND"; // ���뵥ҳ�棨����Ӫ�����ʣ� 
    public final static String TOBE_SEND = "TOBE_SEND"; // ������ҳ�棨��Դ���͵���
    public final static String REQUEST_PARAMETER_SENDNO = "SENDNO"; // ���͵���
    public final static String REQUEST_PARAMETER_AGAIN = "AGAIN"; // �ٴ˱������͵���
    public final static String REQUEST_PARAMETER_PRINTTIME = "PRINTTIME"; // ��ӡʱ��
    public final static String REQUEST_PARAMETER_PRINTCODE = "PRINTCODE"; // ��ӡ�ˣ�����Ա������
    public final static String PAGE_ATTRIBUTE_ERRORMSG = "ERRORMSG"; // ������Ϣ��־
    public final static String REQUEST_PARAMETER_RECID = "RECID"; // ��Դ����ʶ
    /* PUT */
    public final static String REQUEST_PARAMETER_OPINION = "OPINION"; // �������
    
    /* ҳ�淭�� */
    public final static String TRANSLATE_IM_COMTYPE = "IM_COMTYPE"; // ��Ʒ���ͷ�����ID
    public final static String TRANSLATE_COMTYPE = "COMTYPE"; // ��Ʒ���ͷ���
    
    /* �̶����� */
    public final static String DICTITEM_IM_SIMTYPE = "IM_SIMTYPE"; // SIM������
    
    /* ��ť���� */
    public final static String BUTTON_SAVE_DISABLED = "SAVE_DISABLED"; // ���水ť������
    public final static String BUTTON_SEND_DISABLED = "SEND_DISABLED"; // ���Ű�ť������
    
    /* ���̲��� */
    public final static short FLOW_STEP_ONE = 0;
    public final static short FLOW_STEP_TWO = 1;
    public final static short FLOW_STEP_THREE = 2;
    public final static short FLOW_STEP_FOUR = 3;
    public final static short FLOW_STEP_FIVE = 4;
    public final static short FLOW_STEP_SIX = 5;
    public final static short FLOW_STEP_SEVEN = 6;
    
    //��Ϣ������
    public final static Short MAIL_STATE_SHORT = new Short("0");//�ʼ�
    public final static Short MESSAGE_STATE_SHORT = new Short("1");//����
    public final static Short REMSG_STATE_SHORT = new Short("2");//�ظ�
    public final static String MAIL_ADDR_SPLIT = ",";
    public final static String APPENDIX_UPLOADPATH = File.separator+"upload"+File.separator+"cms"+File.separator+"mail"+File.separator;
    public final static String REQUEST_ATTRIBUTE_FOLDERSEQ = "FOLDERSEQ";
    public final static String REQUEST_ATTRIBUTE_GROUPSEQ = "GROUPSEQ";

    /* �����Ӫ��� */
    /* ҳ����� */
    public final static String REQUEST_PARAMETER_REARTIME = "REARTIME"; // ʵʱ��ѯ
    
    //��ͬ��Ϣ�ϴ�����λ��
    public final static String COMPACT_UPLOADPATH = File.separator+"upload"+File.separator+"cms"+File.separator+"compact"+File.separator;

}
