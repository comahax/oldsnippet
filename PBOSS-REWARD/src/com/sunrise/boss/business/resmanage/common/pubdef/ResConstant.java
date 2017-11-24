package com.sunrise.boss.business.resmanage.common.pubdef;


/**
 * <p>
 * ��Դ�̶���������
 * </p>
 * ������Ҫ����BOSS1.0
 */

public class ResConstant {
	public static final String DEFINITION_FILE_PATH = "/com/sunrise/boss/ui/resmanage/common/definition.xml";
	public static final String EXCELOUT_FILE_PATH = "/com/sunrise/boss/resource/excelout/excelout.xml";
	public static final String DEFINITION_IMPLEMENT_PREFIX = "com.sunrise.boss.ui.resmanage.common.definition.impl.";
	public static final String Excelout_IMPLEMENT_PREFIX ="com.sunrise.boss.ui.resmanage.common.excelout.impl.";
	public static final String RESCOMMONCHK_FILE_PATH = "/com/sunrise/boss/resource/rescommonchk/rescommonchk.xml";
	public static final String FILEDEF_FILE_PATH = "/com/sunrise/boss/resource/filedef/filedef.xml";
	/**
	 * ����CX1
	 */
	public static final Long CARDMILL_SEHUMBERGER = new Long(0);// Sehumberger(˹�ױ�л)
	public static final Long CARDMILL_GEMPLUS = new Long(1);// Gemplus(����˹)
	public static final Long CARDMILL_WHTIANYU = new Long(2);// �人����
	public static final Long CARDMILL_JXJIEDE = new Long(3);// �����ݵ�
	public static final Long CARDMILL_DXHEPING = new Long(4);// ���ź�ƽ
	public static final Long CARDMILL_DTDIANXIN = new Long(5);// ���Ƶ���
	public static final Long CARDMILL_HTJIUZHOUTONG = new Long(6);// �������ͨ
	public static final Long CARDMILL_BJWOQI = new Long(7);// ��������
	public static final Long CARDMILL_DFYINGKA = new Long(8);// ����Ӣ��
	public static final Long CARDMILL_HUANGHONG = new Long(9);// ����
	public static final Long CARDMILL_SHKESI = new Long(10);// �Ϻ���˹(ICCID��������A��ʾ)
	public static final Long CARDMILL_HTZHITONG = new Long(11);// ������ͨ(ICCID��������B��ʾ)

	
	/**
	 * ��Դ����CX2
	 */
	public static final Long RESTYPE_SIMCARD = new Long(100);// SIM��
	public static final Long RESTYPE_NUMBER = new Long(101);// ����
	public static final Long RESTYPE_INVOICE = new Long(102);// ��Ʊ
	public static final Long RESTYPE_JFCARD = new Long(103);// ���ֿ�
	public static final Long RESTYPE_GIFTRES = new Long(104);// ��Ʒ��Դ
	public static final Long RESTYPE_OTHERRES = new Long(105);// ����Ʒ��������Դ
	public static final Long RESTYPE_TERMINALINF = new Long(106);// �ն���Ϣ
	public static final Long RESTYPE_GROUPSERIAL = new Long(107);// ���ű��
	//����ѡ������
	public static final Long RESTYPE_EMPTYSIMCARD = new Long(110);// �հ�SIM��
	
	
	/**
	 * ��Ʒ����CX3
	 */
	public static final Long COMTYPE_AOC_CHUZHICARD = new Long(1);// AOC��ֵ��
	public static final Long COMTYPE_SHENZHOUDAZHONGCARD = new Long(2);// ���ݴ��ڿ�
	public static final Long COMTYPE_SHENZHOUXING_CHONGZHICARD = new Long(3);// �����г�ֵ��
	public static final Long COMTYPE_YIXING_IPCHONGZHICARD = new Long(4);// ����IP��ֵ��
	public static final Long COMTYPE_QUANQIUTONG_CHONGZHICARD = new Long(5);// ȫ��ͨ��ֵ��
	public static final Long COMTYPE_LOCAL_IPCHONGZHICARD = new Long(6);// ����IP��ֵ��
	public static final Long COMTYPE_IPJIZHANGCARD = new Long(7);// IP���ʿ�
	public static final Long COMTYPE_IPCHONGZHICARD = new Long(8);// IP��ֵ��
	public static final Long COMTYPE_QUANQIUTONG_JIAOFEICARD = new Long(9);// ȫ��ͨ�ɷѿ�
	public static final Long COMTYPE_IPGUOJIMANYOUCARD = new Long(10);// IP�������ο�
	public static final Long COMTYPE_MOBILEPHONE = new Long(11);// �ֻ�
	public static final Long COMTYPE_SUI_E_XING = new Long(12);// ��e��
	public static final Long COMTYPE_SHENZHOUXING_TAOCARD = new Long(13);// �������׿�
	public static final Long COMTYPE_MZONECARD = new Long(14);// ���еش���
	public static final Long COMTYPE_MOBILE_EARPHONE = new Long(15);// �ֻ�����
	public static final Long COMTYPE_MOBILE_CELL = new Long(16);// �ֻ����
	public static final Long COMTYPE_MOBILE_SHEATH = new Long(17);// �ֻ�Ƥ��
	public static final Long COMTYPE_WIRELESSCARD = new Long(18);// ����������
	public static final Long COMTYPE_ELETRI_CHONGZHIJUAN = new Long(19);// ���ӳ�ֵȯ
	public static final Long COMTYPE_HUIGE_DAZHONGCARD = new Long(20);// �ظ���ڿ�
	public static final Long COMTYPE_MOBILE_CHONGZHICARD = new Long(21);// �ֻ���ֵ��
	public static final Long COMTYPE_HK_IPCARD = new Long(22);// ���IP�绰��
	public static final Long COMTYPE_DIAMONDCARD = new Long(23);// ��ʯ��
	public static final Long COMTYPE_GOLDENCARD = new Long(24);// ��
	public static final Long COMTYPE_SILVERCARD = new Long(25);// ����
	public static final Long COMTYPE_VIPCARD = new Long(26);// �����
	public static final Long COMTYPE_JIFENCARD = new Long(27);// ���ֿ�
	public static final Long COMTYPE_MOBILE_MEMBERCARD = new Long(28);// �ֻ���Ա��
	public static final Long COMTYPE_DONGLI100_DATACARD = new Long(29);// ����100���ݿ�
	public static final Long COMTYPE_INFO_EQUIPMENT = new Long(30);// ��Ϣ�豸
	public static final Long COMTYPE_MOBILE_CHONGZHIJUAN = new Long(31);// �ֻ���ֵȯ����Դ
	public static final Long COMTYPE_OTHER = new Long(99);// ����
	

	/**
	 * SIM��״̬CX4(���̨����ͳһ jiaofl 2009-05-19)
	 */
	public static final Long SIMSTATE_NOPUTIN = new Long(0);// δͶ��
	public static final Long SIMSTATE_RESERVE = new Long(1);// Ԥ��
	public static final Long SIMSTATE_USING = new Long(2);// ��ʹ��
	public static final Long SIMSTATE_LOST = new Long(3);// ��ʧ
	public static final Long SIMSTATE_BROKEN = new Long(4);// ��
	public static final Long SIMSTATE_CANUSE = new Long(5);// ����
	public static final Long SIMSTATE_FORBIDUSE = new Long(6);// ����
	public static final Long SIMSTATE_REVOKE = new Long(8);// ����
	public static final Long SIMSTATE_SENDING = new Long(11);// ������
	public static final Long SIMSTATE_BACK = new Long(12);// �˲�
	public static final Long SIMSTATE_RECYCLING = new Long(16);// ������(��������)
	public static final Long SIMSTATE_LOSE = new Long(17);// �̿�
	public static final Long SIMSTATE_DESTORY = new Long(18);// ��ٱ���
	public static final Long SIMSTATE_SURPLUSLOAD = new Long(19);// ��ӯ���
	public static final Long SIMSTATE_LOCKED = new Long(21);// ����
	public static final Long SIMSTATE_NOCARDWEITOU = new Long(22);// ��ʵ�忨����
	public static final Long SIMSTATE_NOCARDINUSED = new Long(23);// ��ʵ�忨��ʹ��
	public static final Long SIMSTATE_NOCARDDISUSE = new Long(24);// ��ʵ�忨����
	
	
	/**
	 * �հ�SIM��״̬(���̨����ͳһ jiaofl 2009-05-19)
	 */
	public static final Long EMPTYSIMSTATE_PUTIN = new Long(0);// �հ׿����
	public static final Long EMPTYSIMSTATE_TMPCHOOSE = new Long(1);// ��ѡ
	public static final Long EMPTYSIMSTATE_WRITERSUCCESS = new Long(2);// д���ɹ�
	public static final Long EMPTYSIMSTATE_LOST = new Long(3);// ��ʧ
	public static final Long EMPTYSIMSTATE_WRITERFAIL = new Long(4);// д������
	public static final Long EMPTYSIMSTATE_CANUSE = new Long(5);// ���ÿհ׿�
	public static final Long EMPTYSIMSTATE_SOLD = new Long(10);// ����
	public static final Long EMPTYSIMSTATE_SENDING = new Long(11);// ������
	public static final Long EMPTYSIMSTATE_BACK= new Long(12);// �˲�
	public static final Long EMPTYSIMSTATE_RECYCLING= new Long(16);// ������(��������)
	
	
	/**
	 * ����״̬CX5
	 */
	public static final Long CALLSTATE_ONSALE = new Long(0);// ���ۺ�
	public static final Long CALLSTATE_RESERVE = new Long(1);// Ԥ����
	public static final Long CALLSTATE_USING = new Long(2);// ��ʹ��
	public static final Long CALLSTATE_CHGNO = new Long(3);// �ĺ�̬
	public static final Long CALLSTATE_KEEP = new Long(4);// Ԥ����
	public static final Long CALLSTATE_FORBID = new Long(5);// ���ۺ�
	public static final Long CALLSTATE_HALFSTOP = new Long(6);// ��ͣ
	public static final Long CALLSTATE_STOP = new Long(7);// ͣ��
	public static final Long CALLSTATE_PREDEL = new Long(8);// Ԥ����
	public static final Long CALLSTATE_DEL = new Long(9);// ������
	public static final Long CALLSTATE_NOPUT = new Long(10);// δͶ��
	public static final Long CALLSTATE_TMPCHOOSE = new Long(11);// ��ѡ
	public static final Long CALLSTATE_RECYCLE = new Long(12);// ����
	
	
	/**
	 * ��Ʒ״̬CX6
	 */
	public static final Long COMSTATE_FORBID = new Long(0);// ������
	public static final Long COMSTATE_ONSALE = new Long(1);// ����
	public static final Long COMSTATE_SOLD = new Long(2);// ����
	public static final Long COMSTATE_REVOKE = new Long(3);// ������
	public static final Long COMSTATE_DELSTOP = new Long(4);// ������
	public static final Long COMSTATE_RESERVE = new Long(5);// Ԥ��
	public static final Long COMSTATE_DAISHOU = new Long(6);// ������
	public static final Long COMSTATE_DECODEFAIL = new Long(7);// ����ʧ��
	public static final Long COMSTATE_PRINTFAIL = new Long(8);// ��ӡʧ��
	public static final Long COMSTATE_PACKAGE = new Long(9);// ���̬
	public static final Long COMSTATE_FETCH = new Long(10);// ��ȡ̬
	public static final Long COMSTATE_SENDING = new Long(11);// ������
	public static final Long COMSTATE_BACK = new Long(12);// �˲�
	public static final Long COMSTATE_BACKED = new Long(13);// ����
	public static final Long COMSTATE_WAITSALE = new Long(14);// ����
	public static final Long COMSTATE_WANE = new Long(15);// �̿�
	public static final Long COMSTATE_RECYCLING = new Long(17);// ������
	
	/**
	 * SIM������CX7
	 */
	public static final Long SIMTYPE_8K_NORMALCARD = new Long(0);// 8K��ͨ��
	public static final Long SIMTYPE_16K_NORMAILCARD = new Long(1);// 16K��ͨ��
	public static final Long SIMTYPE_16K_STK = new Long(2);// 16K STK
	public static final Long SIMTYPE_32K_STK = new Long(3);// 32K STK
	public static final Long SIMTYPE_32K_LICAITONG = new Long(4);// 32K���ͨ
	public static final Long SIMTYPE_DOUBLENO = new Long(5);// һ��˫��
	public static final Long SIMTYPE_MZONE = new Long(6);// ���еش�
	public static final Long SIMTYPE_16K_BIGCAPACITY = new Long(7);// 16K������
	public static final Long SIMTYPE_GUANGDONG_DYNAMIC = new Long(8);// �㶫��̬
	public static final Long SIMTYPE_SHENZHEN_DYNAMIC = new Long(9);// ���ڶ�̬
	public static final Long SIMTYPE_8K_SHENZHOUXING = new Long(10);// 8K������
	public static final Long SIMTYPE_16K_DAZHONGCARD = new Long(11);// 16K���ڿ�
	public static final Long SIMTYPE_SUI_E_XING = new Long(12);// ��e��
	public static final Long SIMTYPE_16K_SHENZHOUXING = new Long(13);// 16K������
	public static final Long SIMTYPE_32K_SHENZHOUXING = new Long(14);// 32K������
	public static final Long SIMTYPE_16K_LICAITONG = new Long(15);// 16K���ͨ
	public static final Long SIMTYPE_16K_MUTILNO = new Long(16);// 16Kһ�����(������һ�����)
	public static final Long SIMTYPE_32K_MUTILNO = new Long(17);// 32Kһ�����(������һ�����)
	public static final Long SIMTYPE_WIB = new Long(18);// WIB(һ�ֿ��Զ�̬�����ֻ��˵��Ŀ�)
	public static final Long SIMTYPE_64K_CARD = new Long(19);// 64K �������ݣ� 32K
																// OTA����Զ����������û�У�
	public static final Long SIMTYPE_AIR_STK = new Long(20);// ���г�ֵSTK
	public static final Long SIMTYPE_64K_WIB = new Long(21);// 64KWIB
	public static final Long SIMTYPE_64K_DOUBLENO = new Long(22);// 64Kһ��˫��
	public static final Long SIMTYPE_16K_SHENZHOUXING_PRECARD = new Long(23);// 16K������Ԥ�ƿ�
	public static final Long SIMTYPE_32K_QUANQIUTONG_PRECARD = new Long(24);// 32Kȫ��ͨԤ�ƿ�
	public static final Long SIMTYPE_32K_MZONE_PRECARD = new Long(25);// 32K����Ԥ�ƿ�
	public static final Long SIMTYPE_QUANQIUTONG_EMPTYSIM = new Long(26);// ȫ��ͨ�հ�SIM��
	public static final Long SIMTYPE_DOUBLENO_EMPTYSIM = new Long(27);// һ��˫�ſհ�SIM��
	public static final Long SIMTYPE_MZONE_EMPTYSIM = new Long(28);// ���еش��հ�SIM��
	public static final Long SIMTYPE_SHENZHOUXING_EMPTYSIM = new Long(29);// �����пհ�SIM��
	public static final Long SIMTYPE_128K_CARD = new Long(30);// 128K
																// ���������У���������û�У�
	public static final Long SIMTYPE_32K_DAZHONGCARD = new Long(31);// 32K���ڿ���������
	public static final Long SIMTYPE_64K_MZONE = new Long(32);// 64K���п�
	public static final Long SIMTYPE_USIM = new Long(60);// USIM��
	public static final Long SIMTYPE_64K_ZHUANSHU = new Long(61);// ȫ��ͨר��SIM��(64K)
	public static final Long SIMTYPE_DONGLI100_DATACARD = new Long(62);// ����100���ݿ�
	public static final Long SIMTYPE_64K_SHENZHOUXING = new Long(63);// 64K������
																		// sim��
	public static final Long SIMTYPE_64K_MZONESIM = new Long(64);// 64K����
																	// sim��
	public static final Long SIMTYPE_128K_MZONESIM = new Long(65);// 128K����
																	// sim��
	public static final Long SIMTYPE_128K_DAZHONGSIM = new Long(66);// 128K���ڿ�
																	// sim��
	public static final Long SIMTYPE_128K_SHENZHOUXINGSIM = new Long(67);// 128K������
																			// sim��
	public static final Long SIMTYPE_64K_SHENZHOUXING51YUAN = new Long(68);// ������64K
																			// 51ԪSIM��
	public static final Long SIMTYPE_64K_SHENZHOUDAZHOU51YUAN = new Long(69);// ���ݴ��ڿ�64K
																				// 51ԪSIM��
	public static final Long SIMTYPE_64K_MZONE20YUAN = new Long(70);// ���еش�64K
																	// 20ԪSIM��

	
	/**
	 * ���ֿ���Դ״̬CX8
	 */
	public static final Long JFCARDSTATE_NOUSE = new Long(0);// ������
	public static final Long JFCARDSTATE_CANUSE = new Long(1);// ��ʹ��
	public static final Long JFCARDSTATE_USING = new Long(2);// ��ʹ��
	public static final Long JFCARDSTATE_CHANGED = new Long(3);// �ѻ���
	public static final Long JFCARDSTATE_REVOKE = new Long(4);// ������
	public static final Long JFCARDSTATE_SENDING = new Long(5);// ������
	public static final Long JFCARDSTATE_RECYCLING = new Long(6);// ������
	
	
	/**
	 * �����ű�־CX12
	 */
	public static final Long NOATTRIBUTE_NORMALNO = new Long(0);// ��ͨ(ȱʡֵ)
	public static final Long NOATTRIBUTE_PRIMARYNO = new Long(1);// ����
	public static final Long NOATTRIBUTE_DOUBLENO = new Long(2);// һ��˫�Ÿ���
	public static final Long NOATTRIBUTE_BUNDLE = new Long(3);// �����ϵ����
	
	
	/**
	 * ��Դ��������CX19
	 */
	public static final Long RESOPRTYPE_PUTINDB = new Long(0);// ���
	public static final Long RESOPRTYPE_DISTRIB = new Long(1);// ����
	public static final Long RESOPRTYPE_RECYCLE = new Long(2);// ����
	public static final Long RESOPRTYPE_DEL = new Long(3);// ɾ��
	public static final Long RESOPRTYPE_STATECHANGE = new Long(4);// ״̬�޸�
	public static final Long RESOPRTYPE_SENDING = new Long(5);// ����
	public static final Long RESOPRTYPE_PROPERTYCHANGE = new Long(6);// �����޸ġ�--2009.02.26ǰ��̨"�����޸�"��������ͳһΪ6
	public static final Long RESOPRTYPE_WANE = new Long(7);// �̿�
	public static final Long RESOPRTYPE_DAMAGE = new Long(8);// ���𱨷�
	public static final Long RESOPRTYPE_CC = new Long(9);// ����
	public static final Long RESOPRTYPE_TC = new Long(10);// �˲�
	public static final Long RESOPRTYPE_JJ = new Long(11);// ����
	public static final Long RESOPRTYPE_JieShou = new Long(12);// ����
	public static final Long RESOPRTYPE_JuShou = new Long(13);// ����
	public static final Long RESOPRTYPE_TuiChangJieShou = new Long(14);// �˲ֽ���
	public static final Long RESOPRTYPE_ZhaoHui = new Long(15);// �л�
	
	/**
	 * �����ɹ�/ʧ�ܱ�ʶ
	 */
	public static final Long OPERATE_SUCCESS = new Long(1);
	public static final Long OPERATE_FAIL = new Long(0);
	
	
	/**
	 * �������
	 */
	public static final int MAX_SIZE = 100000;
	
	
	/**
	 * �����ű�־
	 */
	public static final Long NO_TYPE_NORMAL = new Long(0);// ��ͨ(ȱʡֵ)
	public static final Long NO_TYPE_HOST = new Long(1);// ����
	public static final Long NO_TYPE_DEPUTY = new Long(2);// ����
	public static final Long NO_TYPE_BIND = new Long(3);// ���󸱺�
	
	
	/**
	 * IMSIʹ��״̬CX42
	 */
	public static final Long IMSISTATE_NOTUSE = new Long(0);// δ��
	public static final Long IMSISTATE_RESERVE = new Long(1);// Ԥ��
	public static final Long IMSISTATE_WAITACTIVATE = new Long(2);// ������
	public static final Long IMSISTATE_ACTIVATE = new Long(3);// ����
	public static final Long IMSISTATE_FORBID = new Long(4);// ����
	public static final Long IMSISTATE_REVOKE = new Long(5);// ����
	public static final Long IMSISTATE_RECYCLE2EKI = new Long(6);// �Ѿ�����EKI
	
	/**
	 * ��Ʒ���
	 */
	public static final Long COMCLASS_GUACARD = new Long(0);// �ο���
	public static final Long COMCLASS_MOBILEPHONE = new Long(1);// �ֻ���
	public static final Long COMCLASS_PHONEFITTINGS = new Long(2);// �ֻ������
	public static final Long COMCLASS_SMP = new Long(3);// SIM�׿���
	public static final Long COMCLASS_ECHONGZHI = new Long(4);// ���ӳ�ֵȯ
	public static final Long COMCLASS_OTHER = new Long(99);// ����
	
	/**
	 * ʹ��״̬
	 */
	public static final Long USESTATE_CANUSE = new Long(1);// ����
	public static final Long USESTATE_FORBID = new Long(0);// ����
	
	/**
	 * ̨�ʲ���
	 */
	public static final Long SHEETSTATE_CREATED = new Long(0);// ��ͨ��״̬:������
	public static final Long SHEETSTATE_COMPLETED = new Long(1);// ��ͨ��״̬:�����
	public static final Long SHEETSTATE_NEEDCONFIRM = new Long(2);// ��ͨ��״̬:��ȷ��
	public static final Long SHEETSTATE_CANCELED = new Long(3);// ��ͨ��״̬:�ѳ���
	public static final Long SHEETSTATE_REGISTERED = new Long(4);// ��ͨ��״̬:�ѵǼ�
	public static final Long SHEETSTATE_PARTCOMPLETED= new Long(5);// ��ͨ��״̬:�������
	public static final Long SHEETSTATE_FAILED= new Long(6);// ��ͨ��״̬:����ʧ��
	public static final Long SHEETSTATE_CONFIRMED= new Long(7);// ��ͨ��״̬:��ȷ��
	
	public static final Long SHEETTYPE_CC = new Long(0);// ��ͨ������:���ֵ�
	public static final Long SHEETTYPE_TC = new Long(1);// ��ͨ������:�˲ֵ�
	public static final Long SHEETTYPE_JJ = new Long(2);// ��ͨ������:���ӵ�
	
	public static final Long SHEETRESTYPE_SIM = new Long(0);// ��ͨ����Դ����:Sim��
	public static final Long SHEETRESTYPE_VIPCARD = new Long(1);// ��ͨ����Դ����:���ֿ�
	public static final Long SHEETRESTYPE_COM = new Long(2);// ��ͨ����Դ����:��Ʒ
	public static final Long SHEETRESTYPE_EMPTYSIM = new Long(3);// ��ͨ����Դ����:�հ�SIM��
	
	public static final Long HASPRINTED_YES = new Long(1);// ��ͨ���Ƿ��ӡ:�Ѵ�ӡ
	public static final Long HASPRINTED_NO = new Long(0);// ��ͨ���Ƿ��ӡ:δ��ӡ
	
	public static final Long RESACTION_SYSTEM = new Long(3);// ����������3ϵͳ����
	
	public static final Short AUDITSATE_NEEDAUDIT = new Short("1");//���״̬:�����
	public static final Short AUDITSATE_REJECT = new Short("0");//���״̬:��˲�ͨ��
	public static final Short AUDITSATE_NEEDCONFIRM = new Short("2");//���״̬:��ȷ��
	public static final Short AUDITSATE_CONFIRMED = new Short("3");//���״̬:��ȷ��
	
	public static final Short AUDITOPRTYPE_REJECT = new Short("0");//��˲�������:��ͨ�����
	public static final Short AUDITOPRTYPE_PERMIT = new Short("1");//��˲�������:ͨ�����
	public static final Short AUDITOPRTYPE_CONFIRM = new Short("2");//��˲�������:ȷ��
	
	public static final Long AUDITFLAG_START = 	new Long("1");//̨�ʵ���ǩ��������־:����
	public static final Long AUDITFLAG_STOP = 	new Long("0");//̨�ʵ���ǩ��������־:ͣ��
	public static final Long AUDITFLAG_PARAM = new Long("50");//����ǩ��������־ϵͳ����
	/**
	 * Ʊ��״̬
	 */
	public static final Long BILLSTATE_NOPUTIN = new Long(0); // δͶ��
	public static final Long BILLSTATE_CANUSE = new Long(1); // ��ʹ��
	public static final Long BILLSTATE_USING = new Long(2); // ��ʹ��
	public static final Long BILLSTATE_REDBILL = new Long(3); // ��Ʊ
	public static final Long BILLSTATE_LOST = new Long(4); // ��ʧ
	public static final Long BILLSTATE_REVOKE = new Long(5); // ����
	public static final Long BILLSTATE_HXIAO = new Long(6); // ����
	public static final Long BILLSTATE_JXIAO = new Long(7); // ����
	public static final Long BILLSTATE_HPZMP = new Long(8); // ��Ʊ֤��Ʊ

	/**
	 * ���͵�״̬
	 */
	
	public static final Long SENDSTATE_WeiJieShou = new Long(0);// δ����
	public static final Long SENDSTATE_YiJieShou = new Long(1);// �ѽ���
	public static final Long SENDSTATE_JuShou = new Long(2);// ����
	public static final Long SENDSTATE_ZhaoHui = new Long(3);// �л�
	public static final Long SENDSTATE_TuiChangJieShou = new Long(4);// �˲ֽ���
	
	/**
	 * ���ӳ�ֵ�����
	 */
	public static final Long FTPSERVER_URL = new Long(24);
	public static final Long REMOTE_TICKETPACKAGEFILE_DIR = new Long(22);
	
	/**
	 * ��Դ����״̬
	 */
	public static final Long RECSTATE_NORECEPT = new Long(0);// ��ǩ��
	public static final Long RECSTATE_DONE = new Long(1);// �����
	public static final Long RECSTATE_BACK = new Long(2);// �˻ش���

	/**
	 * ������Դ����
	 */
	public static final Long IM_RESOURCETYPE_SIM = new Long(0); //SIM��
	public static final Long IM_RESOURCETYPE_NORES = new Long(1); //����
	public static final Long IM_RESOURCETYPE_SANHAO = new Long(10); //ɢ��
	public static final Long IM_RESOURCETYPE_COMRESPACKAG = new Long(104); //��Ʒ��Դ��
	public static final Long IM_RESOURCETYPE_BILLRES = new Long(2); // ��Ʊ
	public static final Long IM_RESOURCETYPE_COMRES = new Long(3); // ��Ʒ
	public static final Long IM_RESOURCETYPE_CZCARD = new Long(301); // ��ֵ��
	public static final Long IM_RESOURCETYPE_SMP = new Long(302); // �׿�
	public static final Long IM_RESOURCETYPE_PHONE = new Long(303); // �ֻ�
	public static final Long IM_RESOURCETYPE_OTHERCOMRES = new Long(304); // ��Ʒ��չ��Դ
	public static final Long IM_RESOURCETYPE_VIPCARD = new Long(4); // VIP��
	public static final Long IM_RESOURCETYPE_IMSIRES = new Long(5); // IMSI
	public static final Long IM_RESOURCETYPE_EMPTYSIM = new Long(6); // �հ�SIM��
	public static final Long IM_RESOURCETYPE_PHONEMEMBERCARD = new Long(7); // �ֻ���Ա��
	public static final Long IM_RESOURCETYPE_OTHERRES = new Long(99); // ����
	
	/**
	 * ����״̬
	 */
	public static final Short CHKSTATE_Wait = new Short((short)1); //������
	public static final Short CHKSTATE_Pass = new Short((short)2); //������
	public static final Short CHKSTATE_Reject = new Short((short)3); //������ͨ��
	public static final Short CHKSTATE_AllSuccess = new Short((short)4); //ȫ���ɹ�
	public static final Short CHKSTATE_PartlySuccess = new Short((short)5); //���ֳɹ�
	public static final Short CHKSTATE_AllFailed = new Short((short)6); //ȫ��ʧ��
	
	/**
	 * ���ű��״̬  
	 */
	public static final Short GROUPSERIALSTATE_NOPUTIN = new Short((short)0); //δͶ��
	public static final Short GROUPSERIALSTATE_CANSELL = new Short((short)1); //���ۺ�
	public static final Short GROUPSERIALSTATE_USED = new Short((short)2); //��ʹ��
	public static final Short GROUPSERIALSTATE_CANCEL = new Short((short)3); //������
	
	//����ֵ
	public static final String Right_RecordBillUseWayNoCheck = "1A2BC0_WayNoCheck";//Ʊ��¼��ʱ�����������������Ա��¼���κ�������Ʊ��
	
	public static final String Right_ChgNofee = "1A2B1A10_NOFEECHG"; //�޸�ѡ�ŷѿ�������
	
	public static final String Right_ShowSelfWayNO = "1A2B1AM0_SHOWSELFWAYNO"; //ѡ������ѯ�������á��Ƿ���ʾ���������롱���޸Ĺ���
	public static final String Right_ShowAllWayid = "1A2B1AM0_SHOWALLWAYID"; //ѡ������ѯ��������-��ʾ��������
	
	//ϵͳ����ֵ
	public static final Long SysParam_RecParam = new Long(25); //����ǩ���������ò���ֵ
	public static final Long SysParam_BatchFileFTP = new Long(32); //�����ļ�����FTP��������ֵ
	public static final Long SysParam_BatchFileDir = new Long(33); //���������ļ�Ŀ¼
	
	//CMS
	public static final Long CARDRESMANAGE_NORES_DIR = new Long(51); //�������ϴ���ĺ��뿨�ļ���Ŀ¼
	public static final Long CARDRESMANAGE_SIM_DIR = new Long(52); //�������ϴ����SIM���ļ���Ŀ¼
	public static final Long CARDRESMANAGE_COMRESSMP_DIR = new Long(53); //�������ϴ���׿��ļ���Ŀ¼
	public static final Long CARDRESMANAGE_COMRESCARD_DIR = new Long(54); //�������ϴ�ų�ֵ���ļ���Ŀ¼
	public static final Long CARDRESMANAGE_IMSI_DIR = new Long(55); //�������ϴ��IMSI�ļ���Ŀ¼
	
	//���ź�����������������
	public static final Long IGNORERULE_NOTTYPES = new Long(56);
	
	/**
	 * ���ӽ��Ӳ�������
	 */
	//���ӽ�����ͣ��ʶ����
	public static final Long ETRANSFLAG_START = new Long(1);
	public static final Long ETRANSFLAG_STOP = new Long(0);
	public static final Long ETRANSFLAG_SYSPARAM = new Long(57);
	//��Դ����״̬�����̬���������׿���SIM�����հ�SIM������ֵ�������ֿ����ֻ�,������Ʒ��Դ��
	public static final Long ETRANSSTATE_TOBEAUDITED = new Long(25);	//��Դ�����״̬
	public static final Long ETRANSSTATE_TOBERECEIVED = new Long(26);	//��Դ������״̬
	public static final Long ETRANSSTATE_TOBESALED = new Long(27);		//��Դ������״̬
	public static final Long ETRANSSTATE_TOBEBACKED = new Long(28);		//��Դ������״̬(���˴����)
	public static final Long ETRANSSTATE_BACKTOBERECEIVED = new Long(29);//��Դ���˴�����״̬
	//im_wl_applyreq��ǼǵĲ�������
	public static final Short ETRANSOPRTYPE_DIS = new Short((short)0);				//����
	public static final Short ETRANSOPRTYPE_BACK = new Short((short)1);				//����
	public static final Short ETRANSOPRTYPE_DISREC = new Short((short)2);			//���Ž���һ̨��
	public static final Short ETRANSOPRTYPE_AUDITPASS = new Short((short)3);		//���ͨ��
	public static final Short ETRANSOPRTYPE_AUDITREJECT = new Short((short)4);		//��˲�ͨ��
	public static final Short ETRANSOPRTYPE_RECPASS = new Short((short)5);			//����ͨ��
	public static final Short ETRANSOPRTYPE_RECREJECT = new Short((short)6);		//���ղ�ͨ��
	public static final Short ETRANSOPRTYPE_BACKAUDITPASS = new Short((short)7);	//�������ͨ��
	public static final Short ETRANSOPRTYPE_BACKAUDITREJECT = new Short((short)8);	//������˲�ͨ��
	public static final Short ETRANSOPRTYPE_BACKREC = new Short((short)9);			//���˽���ͨ��
	public static final Short ETRANSOPRTYPE_BACKRECREJECT = new Short((short)10);	//���˽��ղ�ͨ��
	//��Դ����
	public static final Long ETRANSRESTYPE_SIM = new Long(0);		//Sim��
	public static final Long ETRANSRESTYPE__VIPCARD = new Long(1);	//���ֿ�
	public static final Long ETRANSRESTYPE__COM = new Long(2);		//��Ʒ
	public static final Long ETRANSRESTYPE__EMPTYSIM = new Long(3);	//�հ�SIM��
	//����׼����
	public static final Short OPERSTANDTYPE_NUM = new Short((short)0);	//��������
	public static final Short OPERSTANDTYPE_SUM = new Short((short)1);	//���ݽ��
	//������״̬
	public static final Short RECSTATE_TOBEAUDITED = new Short((short)0);	//�����
	public static final Short RECSTATE_TOBEREC = new Short((short)1);		//������
//	public static final Short RECSTATE_TOBESALED= new Short((short)2);		//������
//	public static final Short RECSTATE_TOBEBACKED = new Short((short)3);	//������
	public static final Short RECSTATE_REJECT = new Short((short)2);		//��˲�ͨ��
	public static final Short RECSTATE_FINISHED = new Short((short)3);		//���
	//��������
	public static final Short APPLYTYPE_DIST = new Short((short)0);//����
	public static final Short APPLYTYPE_BACK = new Short((short)1);//����
	//��������
	public static final Short APPLYOPRTYPE_NEW = new Short((short)0);	//����
	public static final Short APPLYOPRTYPE_AUDIT = new Short((short)1);	//���
	public static final Short APPLYOPRTYPE_ACC = new Short((short)2);	//����
	public static final Short APPLYOPRTYPE_BACK = new Short((short)3);	//����
	//���˱�ʶ������im_pr_resstation��ʶ��Դ����״��
	public static final Short ETRANSBACKFLAG_UNBACK = new Short((short)0);	//δ����
	public static final Short ETRANSBACKFLAG_BACKING = new Short((short)1);	//������
	public static final Short ETRANSBACKFLAG_BACKED = new Short((short)2);	//�ѻ���	
	//��Դ���ͣ�Ŀǰ�����ڿ���̵� 2008.10.08
	public static final Long ETRANS_STOCKCHKRESTYPE_VIPCARD = new Long(0);	//���ֿ�
	public static final Long ETRANS_STOCKCHKRESTYPE_SIM = new Long(1);		//SIM��
	public static final Long ETRANS_STOCKCHKRESTYPE_EMPTYSIM = new Long(2); //�հ�SIM��
	public static final Long ETRANS_STOCKCHKRESTYPE_CZCARD = new Long(3);	//��ֵ��
	public static final Long ETRANS_STOCKCHKRESTYPE_SMP = new Long(4);		//�׿�
	public static final Long ETRANS_STOCKCHKRESTYPE_PHONE = new Long(5);	//�ն��豸
	public static final Long ETRANS_STOCKCHKRESTYPE_OTHERCOMRES = new Long(6);//��Ʒ��չ��Դ
	
	//ϵͳ����-SIM���ɿ�����SIM������
	public static final Long SYSPARAM_RECYCLESIMTYPE = new Long(59);
	
	
	
	/**
	 * ���۵��ӳ�ֵȯ����������
	 */
	
	//���۵��ӳ�ֵȯ����ֵ��״̬
	public static final Long ECHARGESTATE_NOUSE = new Long(0); 	// ������
	public static final Long ECHARGESTATE_CANUSE = new Long(1);	// ����
	public static final Long ECHARGESTATE_USED = new Long(2);	// ��ʹ��
	public static final Long ECHARGESTATE_LOCKED = new Long(3);	// ����
	public static final Long ECHARGESTATE_REVOKE = new Long(5);	// Ԥ��
	
	
}
