package com.gmcc.pboss.business.sales.comorder;

public class ComorderConstant {
	//������Ϣ�Ƿ��ܶ������������ܶ�����
	public static final String ORDER_CANNT= "0";
	//�ɷѷ�ʽ�Ƿ�Ϊ���л��۲����������л��ۣ�
	public static final String PAYTYPE_BANK = "BANK";
	
	//ϵͳ��������ģ�飨������
	public static final String PARAMTYPE_FX = "pboss_fx";
	//ϵͳ����id����/�¶������ƿ���id��
	public static final String SYSTEMID_ORDER_MONTH_DAY = "9";
	//ϵͳ����id���¶�������������id��
	public static final String SYSTEMID_ORDER_MONTH = "8";
	//ϵͳ����id����׼��濪��id��
	public static final String SYSTEMID_ORDER_STDSTOCK= "10";
	//ϵͳ����id����Ʒ������ʾ��Ϣid��
	public static final String SYSTEMID_ORDER_HINT= "26";
	
	//ϵͳ����id��Ԥ����濪��id��
	public static final String SYSTEMID_ORDER_STOCKALARM = "45";
	
	//��/�¶������ƿ���״̬
	public static final String ORDER_MONTHDAY_OPEN = "1";
	public static final String ORDER_MONTHDAY_CLOSE = "0";
	//�¶�������������״̬
	public static final String ORDER_MONTH_OPEN = "1";
	public static final String ORDER_MONTH_CLOSE = "0";
	//��׼������ƿ���״̬
	public static final String ORDER_STDSTOCK_OPEN = "1";
	public static final String ORDER_STDSTOCK_CLOSE = "0";
	//��󶩹���ģʽ����׼���ģʽ��
	public static final String MAXAMTMODE_STDSTOCK = "STDSTOCK";
	//��󶩹���ģʽ��������ģʽ��
	public static final String MAXAMTMODE_ACTRATE = "ACTRATE";
	
	//��Դ����׿���
	public static final String RESTYPE_SMP = "COMRESSMP";
	//�׿���������ģʽ�������ڣ�
	public static final String UNITAGEMODE_WEEK = "WEEK";
	//�׿���������Ĭ��ֵ
	public static final String BASE_ORDER_DEFAULT = "20";
	
	//�ۼ����ַ�ʽ(������)
	public static final String PRICEDIFTYPE_NODIF = "NODIF";
	//�ۼ����ַ�ʽ(����˽�˻�����)
	public static final String PRICEDIFTYPE_ACCOUNT = "ACCOUNT";
	//�ۼ����ַ�ʽ(���Ƿ��ӡ��Ʊ����)
	public static final String PRICEDIFTYPE_INVOICE = "INVOICE";
	//��˽�˻��������Թ���
	public static final Short ACCOUNT_TO_CO = 0;
	//�Ƿ��ӡ��Ʊ��������ӡ��Ʊ��
	public static final Short INVOICE_PRI = 1;

	public static final String ORDERAVE_HALL = "HALL";	//����;��(Ӫҵ��)
	public static final String ORDERAVE_WEB = "WEB";	//����;��(��վ)
	public static final String ORDERAVE_SMS = "SMS";	//����;��(����)
	public static final String ORDERAVE_IVR = "IVR";	//����;��(����)
	public static final String ORDERAVE_AUTO = "AUTO";  //����;��(�Զ�����)
	
	//����������Ч�ԣ���Ч��
	public static final String EFFECTIVE_YES = "1";
	//ʵ�ս��������Ϊ0��
	public static final Double ACTAMT_ZERO = 0d;
	//������Ʒ���ͣ��ͻ�������
	public static final String COMORDER_TYPE = "CUSTORDER";
	
	//Ʒ�����ͣ�����Ʒ�ƣ�
	public static final String BRAND_TYPE_ALLBRAND = "AllBrand";
	
	//�������ͣ��������ͣ�
	public static final String COOPTYPE_ALL= "ALL";
	
	//�Ǽ��������Ǽ���
	public static final String STARLEVEL_ALL= "-1";
	
	//������Լ��ģʽ����/�¶������ƣ�
	public static final String MODE_MONDAYLIMIT= "MONDAYLIMIT";
	//������Լ��ģʽ����׼������ƣ�
	public static final String MODE_STDSTOCK= "STDSTOCK";
	//������Լ��ģʽ��Ԥ����棩
	public static final String MODE_STOCKALARM= "STOCKALARM";
	//������Լ��ģʽ�����¿�����ģʽ��
	public static final String MODE_MONDAYSTOCK= "MONDAYSTOCK";
	//�׿�������Ϣ������Ԥ��������ģʽ��
	public static final String MODE_MONDAYALARM= "MONDAYALARM";
	
}
