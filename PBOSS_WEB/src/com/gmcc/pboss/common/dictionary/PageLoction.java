package com.gmcc.pboss.common.dictionary;


import java.util.LinkedHashMap;
import java.util.Map;

import com.gmcc.pboss.common.action.PageInfo;
import com.gmcc.pboss.common.util.JSTLConstants;

/**
 * PageLoction ҳ��λ��ͳһ��
 * @author yuwenjun
 * @date Jun 18, 2009
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż�
 * ������ҳ���ʶ
 */
public class PageLoction extends JSTLConstants {
	public static final String EMPTY = "";//��
	//���˵���ʶ
	/**
	 * ��ҳ
	 */
	public static final String INDEX = "INDEX";//��ҳ
	/**
	 * ��Ϣ��ѯ
	 */
	public static final String INFO = "INFO";//��Ϣ��ѯ
	/**
	 * ��Ϣ��ѯ(����)
	 */
	public static final String MagInfo = "MagInfo";//��Ϣ��ѯ
	/**
	 * ��������
	 */
	public static final String BASE = "BASE";//��������  
	/**
	 * ��ͨƽ̨
	 */
	public static final String COMMUNI = "COMMUNI";//��ͨƽ̨
	/**
	 * �ҵĳ��
	 */
	public static final String REWARD = "REWARD";//�ҵĳ��
	/**
	 * ������Ϣ-������Ա�ɼ�
	 */
	//public static final String BASE_INFO="BaseInfo";//������Ϣ
	 
	//�����˵�
	/**
	 * �׿����������ѯ
	 */
	public static final String REGACT = "REGACT";//�׿����������ѯ
	/**
	 * �ҵĿ��˽����ѯ
	 */
	public static final String EXAMINE = "EXAMINE";//�ҵĿ��˽����ѯ
	/**
	 * �ҵĶ�����Ϣ��ѯ
	 */
	public static final String SALES = "SALES";//�ҵĶ�����Ϣ��ѯ
	/**
	 * ��Ʒ����
	 */
	public static final String GOODSRESERVE = "GOODSRESERVE";//��Ʒ����
	/**
	 * �������ϲ�ѯ���޸�����
	 */
	public static final String NODEQUERY = "NODEQUERY";//�������ϲ�ѯ���޸�����
	/**
	 * �������˳�����
	 */
	public static final String NODEQUIT = "NODEQUIT";//�������˳�����
	/**
	 * ��Ա����
	 */
	public static final String SHOPASSISTANTLIST = "SHOPASSISTANTLIST";//��Ա����
	/**
	 * ��𱨱�
	 */
	public static final String REWARDRPT = "REWARDRPT";//��𱨱�
	/**
	 * �����ϸ
	 */
	public static final String REWARDDTL = "REWARDDTL";//�����ϸ
	/**
	 * �����
	 */
	public static final String REWARDPAY = "RewardPay";
	/**
	 * ���ۻ���
	 */
	public static final String SaleTotalQuery = "SaleTotalQuery";//���ۻ���
	/**
	 * ���ۻ��ܣ�����
	 */
	public static final String MagSaleStatistics = "MagSaleStatistics";//���ۻ���
	
	/**
	 * �ն˳��
	 */
	public static final String  RWARDTD= "RewarTd";
	
	/**
	 * �¶��׿�����Ǽ���ϸ��ѯ
	 */
	public static String RegactInfoQuery = "RegactInfoQuery";	
	/**
	 * �¶��׿�������ͳ�Ʋ�ѯ
	 */
	public static String RegactStatisticsQuery = "RegactStatisticsQuery";	
	/**
	 * ��Ʒ������ʷ��ѯ
	 */
	public static String SalesHistory = "SalesHistoryQuery";	
	/**
	 * ��Ʒ����������Ϣ��ѯ
	 */
	public static String SalesOrder = "SalesOrderQuery";
	/**
	 * ��Ʒ����������Ϣ��ѯ
	 */
	public static String SalesOrderTimes="SalesOrderTimesQuery";
	/**
	 * ��Ʒ������Դ��ϸ
	 */
	public static String SalesOrderDtl = "SalesOrderDtl";	
	/**
	 * ���͵���ѯ
	 */
	public static final String DeliveryQuery = "DeliveryQuery";	
	public static final String BatchDisover = "BatchDisover";//�����������
	public static final String BatchSMSSign = "BatchSMSSign";//��������ǩ�ն���
	public static final String BatchLogi = "BatchLogi";//������������¼��
	/**
	 * ���ʵ���ѯ
	 */
	public static final String AdpaysumQuery = "AdpaysumQuery";
	
	/**
	 * ������� - Ӧ�������ϸ��ѯ
	 */
	public static String RewardRecordList = "RewardRecordList";	
	/**
	 * ������� - ʵ�������ܲ�ѯ
	 */
	public static String RewardTotalList = "RewardTotalList";	
	/**
	 * ������� - ���У��ʧ����Ϣ��ѯ
	 */
	public static String RewardVerifiedList = "RewardVerifiedList";
	
	/**
	 * B2mӦ�������ϸ��ѯ
	 */
	public static String BbcRewardRecordList = "BbcRewardRecordList";	
	/**
	 * B2M��վ����ܶ��ѯ
	 */
	public static String BbcRewardTotalList = "BbcRewardTotalList";	
	/**
	 * B2M��վ����ܶ��ѯ
	 */
	public static String BbcRewardVerifiedList = "BbcRewardVerifiedList";		

	/**
	 * �������������ʵ��֧����𱨱�
	 */
	public static String RewardRealPayList = "RewardRealPayList";	
	/**
	 * �����������������
	 */
	public static String RewardBalance = "RewardBalance";	
	/**
	 * ���س��
	 */
	public static String RewardLocal = "RewardLocal";	
	/**
	 * �ͻ�������չ���������ϸ
	 */
	public static final String Cardrewdet = "Cardrewdet";
	/**
	 * �ͻ�������չ����������
	 */
	public static final String CardrewdetStat = "CardrewdetStat";	
	/**
	 * ���˽����ѯ
	 */
	public static String ExamineList = "ExamineList";	
	/**
	 * ��Ʒ����
	 */
	public static String GoodsReserve = "GoodsReserve";	
	/**
	 * �������ϲ�ѯ
	 */
	public static String NodeQuery = "NodeQuery";	
	/**
	 * �������˳����� 
	 */
	public static String NodeQuit = "NodeQuit";		
	/**
	 * ��Ա��������
	 */
	public static String ShopAssistantJoin = "ShopAssistantJoin";
	/**
	 * �ҵĵ�Ա��ѯ
	 */
	public static String ShopAssistantList = "ShopAssistantList";
	/**
	 * �ҵĵ�Ա��ѯ
	 */
	public static String ShopAssistantLoad = "ShopAssistantLoad";
	/**
	 * ��Ա�˳�����
	 */
	public static String ShopAssistantQuit = "ShopAssistantQuit";
	/**
	 * ����ҵ���ѯ
	 */
	public static String PendingRequestQuery = "PendingRequestQuery";
	/**
	 * ҵ����Ϣ��ѯ
	 */
	public static String OperationInfoQuery = "OperationInfoQuery";
	/**
	 * ������Ϣ��ѯ
	 */
	public static String AfficheInfoQuery = "AfficheInfoQuery";
	/**
	 * ֪ʶ���ѯ
	 */
	public static String KnowledgeQuery = "KnowledgeQuery";
	/**
	 * �����ʴ�
	 */
	public static String Interlocution = "Interlocution";
	/**
	 * ����
	 */
	public static String Question = "Question";
	/**
	 * �ҵ�����
	 */
	public static String MyQuestion = "MyQuestion";
	
	/**
	 * ������Ϣ��һ���˵���-������Ա�ɼ�
	 */
	public static final String BASE_INFO="BaseInfo";//������Ϣ
	/**
	 * ��Ϣ��ѯ��һ���˵���-������Ա�ɼ�
	 */
	public static final String MAG_INFO="MagInfo";//��Ϣ��ѯ
	public static final String Mag_Reward="MagReward";//����ѯ
	/**
	 * ������Ϣ��ѯ-������Ա����
	 */
	public static String MAG_NODE_LIST="magNodeList";//������Ϣ�б�
	public static String Node_List = "nodeInfoList";
	public static String MAG_NODE_INFO="magNodeInfo";//������Ϣ����
	public static String MAG_NODE_MEMBER="magNodeMember";//�����Ա��Ϣ
	
	/**
	 * ������Ϣ��ѯ-�й�˾��Ա����
	 */

	public static final String CITYINFO="CITYINFO";//��Ϣ��ѯ
	public static String CITY_NODE_LIST="CITY_NODE_LIST";//��Ϣ�б�
	
	/**
	 * ������Ϣ��ѯ-ʡ��˾��Ա����
	 */
	public static final String GDINFO="GDINFO";//��Ϣ��ѯ
	public static String GD_NODE_LIST="GD_NODE_LIST";//������Ϣ�б�
	/**
	 * ��Ա��Ϣ��ѯ-������Ա����
	 */
	public static String MAG_ASSISTANT_LIST="magAssistantList";//��Ա��Ϣ�б�
	public static String Assistant_List = "assistantInfoList";
	public static String MAG_ASSISTANT_INFO="magAssistantInfo";//��Ա��Ϣ����
	/**
	 * ��ҵ�����ۻ��ܲ�ѯ
	 */
	public static String RegisternewcntQuery = "RegisternewcntQuery";
	/**
	 * ��ҵ�����ۻ��ܲ�ѯ(����)
	 */
	public static String MagRegNewSaleStatistics = "MagRegNewSaleStatistics";
	/**
	 * ���ۻ��ܲ�ѯ
	 */
	public static String SalescntQuery = "SalescntQuery";	
	
	//�׿����ۻ���
	public static String SalesCardsTotalQuery = "SalesCardsTotalQuery";
	public static String CardsTotalQuery = "CardsTotalQuery";	
	/**
	 * ��Ա������������Ա���ɼ�
	 */
	/**
	 * ������ϸ��ѯ�������˵���
	 */
	public static String SALE_DETAIL_QUERY = "SaleDetailQuery";//��Ա����
	public static String MAG_SALE_DETAIL_QUERY="MagSaleDetailQuery";//����
	/**
	 * ������ϸ��ѯ -> �׿�������ϸ��ѯ
	 */
	public static String CARD_SALE_DETAIL_QUERY = "CardSaleDetailQuery";//��Ա����
	public static String MAG_CARD_SALE_DETAIL_QUERY = "MagCardSaleDetailQuery";//����
	/**
	 * ������ϸ��ѯ -> ��ҵ��������ϸ��ѯCH_PW_REGISTERNEW
	 */
	public static String NEW_BUSI_SALE_DETAIL_QUERY = "NewBusiSaleDetailQuery";//��Ա����
	public static String MAG_REG_NEW_SALE_DETAIL_QUERY = "MagRegNewSaleDetailQuery";//����
	/**
	 * ���������
	 */
	public static final String CITYRECORD_STAT = "CITYRECORD_STAT";
	public static final String MAG_CITYRECORD_STAT = "MAG_CITYRECORD_STAT";

	/**
	 * ��Ϣ��ѯ��רԱ��
	 */
	public static String MISSIONERINFO = "MISSIONERINFO";	
	/**
	 * ��н����ҵ��Ǽ���ϸ��ѯ��רԱ��
	 */
	public static String MissionerDetailQuery = "MissionerDetailQuery";
	/**
	 * ��н����ҵ��Ǽ���ϸ��ѯ->�Ƽ��ɹ���ϸ��ѯ��רԱ��
	 */
	public static String RecommendSuccessQuery = "Mis_Mdq_Success";
	/**
	 * ��н����ҵ��Ǽ���ϸ��ѯ->�Ƽ�ʧ����ϸ��ѯ��רԱ��
	 */
	public static String RecommendFailQuery = "Mis_mdq_fail";
	//ʵʱ�������¼��ѯ��רԱ��
	public static String RealTimeAccounting ="RealTimeAccounting";
	//ʵʱ�������¼��ѯ->������ɹ���¼��ѯ��רԱ��
	public static String RealTimeAccountingSucc="RealTimeAccountingSucc";
	//ʵʱ�������¼��ѯ -> ������ʧ�ܼ�¼��ѯ��רԱ��
	public static String RealTimeAccountingFail="RealTimeAccountingFail";
	
	/**
	 * ��������ܣ��ҵĳ��->�����->˰�����ѯ��
	 */
	public static String ADJUSTMENT_STAT = "ADJUSTMENT_STAT"; //��������Ա
	public static String MAG_ADJUSTMENT_STAT = "MAG_ADJUSTMENT_STAT"; //�������� 
	
	/**
	 * �ն˼Ƴ�ɹ���ϸ���ҵĳ��-���ն˳��-���ն˼Ƴ�ɹ���ϸ��
	 */
	public static final String REWARDTD_SUC = "REWARDTD_SUC";
	/**
	 * �й�˾�ն˼Ƴ�ɹ���ϸ���ҵĳ��-���ն˳��-���ն˼Ƴ�ɹ���ϸ��
	 */
	public static final String CITY_REWARDTD_SUC = "CITY_REWARDTD_SUC";
	/**
	 * ʡ��˾�ն˼Ƴ�ɹ���ϸ���ҵĳ��-���ն˳��-���ն˼Ƴ�ɹ���ϸ��
	 */
	public static final String GD_REWARDTD_SUC = "GD_REWARDTD_SUC";
	 
	/**
	 * �ն˼Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-���ն˼Ƴ�ʧ����ϸ��
	 */
	public static final String REWARDTD_FAIL = "REWARDTD_FAIL";
	/**
	 * �й�˾_�ն˼Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-���ն˼Ƴ�ʧ����ϸ��
	 */
	public static final String CITY_REWARDTD_FAIL = "CITY_REWARDTD_FAIL";
	/**
	 * ʡ��˾_�ն˼Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-���ն˼Ƴ�ʧ����ϸ��
	 */
	public static final String GD_REWARDTD_FAIL = "GD_REWARDTD_FAIL";
	
	/**
	 * �ն˼Ƴ�ɹ����ݻ��ܣ��ҵĳ��-���ն˳��-���ն˼Ƴ�ɹ����ݻ��ܣ�
	 */
	public static final String REWARDTD_SUC_DATA = "REWARDTD_SUC_DATA";
	
	/**
	 * �ն�Ԥ���Ƴ�ɹ���ϸ���ҵĳ��-���ն˳��-���ն�Ԥ���Ƴ�ɹ���ϸ��
	 */
	public static final String REWARDAD_SUC = "REWARDAD_SUC";
	/**
	 * �ն�Ԥ���Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-���ն�Ԥ���Ƴ�ʧ����ϸ��
	 */
	public static final String REWARDAD_FAIL = "REWARDAD_FAIL";
	
	/**
	 * �ն�Ԥ���Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-��ҵ����ϸ����������ά�ȣ���
	 */
	public static final String SETTLEMENTMONTH = "SETTLEMENTMONTH";
	public static final String MAG_SETTLEMENTMONTH = "MAG_SETTLEMENTMONTH";
	
	/**
	 * �ն�Ԥ���Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-��ҵ����ϸ����������ά�ȣ���
	 */
	public static final String SALEMONTH = "SALEMONTH";
	public static final String MAG_SALEMONTH = "MAG_SALEMONTH";
	
	/**
	 * �ն�Ԥ���Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-���¶�Ӧ����𱨱�
	 */
	public static final String MONTHREMUN = "MONTHREMUN";
	public static final String MAG_MONTHREMUN = "MAG_MONTHREMUN";
	
	/**
	 * �ն�Ԥ���Ƴ�ʧ����ϸ���ҵĳ��-���ն˳��-��ҵ���������ڱ�
	 */
	public static final String REWARDBUSINESS = "REWARDBUSINESS";
	public static final String MAG_REWARDBUSINESS = "MAG_REWARDBUSINESS";
	
	
	/**
	 * ���ҵĳ��-����𱨱�-�����һ�廯����
	 */
	public static final String GD_REWARDPRO = "GD_REWARDPRO";
	public static final String GD_REWARDPRO_PAYMENT = "GD_REWARDPRO_PAYMENT";
	

	/**
	 * ���ҵĳ��-�����һ�廯��-�����һ�廯���á�
	 */
	public static final String GD_REWARD_PAYMENT = "GD_REWARDPRO";
	public static final String GD_REWARD_PAYMENT_CONFIG = "GD_REWARD_PAYMENT_CONFIG";
	
	/**
	 * ���ҵĳ��-�����һ�廯��-�����һ�廯����
	 */
	public static final String GD_REWARD_PAYMENT_MANAGE = "GD_REWARD_PAYMENT_MANAGE";
	
	
	
	//���¹���ҳ����Ϣ
	public static Map allPageInfo = new LinkedHashMap();
	static{
		//������Ա����--���㡢��Ա������ѯ����
		allPageInfo.put(MAG_NODE_LIST, new PageInfo(BASE_INFO,Node_List,EMPTY));
		allPageInfo.put(MAG_NODE_INFO, new PageInfo(BASE_INFO,Node_List,EMPTY));
		allPageInfo.put(MAG_NODE_MEMBER, new PageInfo(BASE_INFO,Node_List,EMPTY));
		allPageInfo.put(MAG_ASSISTANT_LIST, new PageInfo(BASE_INFO,Assistant_List,EMPTY));
		allPageInfo.put(MAG_ASSISTANT_INFO, new PageInfo(BASE_INFO,Assistant_List,EMPTY));
		allPageInfo.put(RegisternewcntQuery, new PageInfo(INFO,SaleTotalQuery,RegisternewcntQuery));// ��ҵ�����ۻ��ܲ�ѯ
		allPageInfo.put(SalescntQuery, new PageInfo(INFO,SaleTotalQuery,SalescntQuery));// ���ۻ��ܲ�ѯ
		allPageInfo.put(MagRegNewSaleStatistics, new PageInfo(MagInfo,MagSaleStatistics,MagRegNewSaleStatistics));// ��ҵ�����ۻ��ܲ�ѯ
		allPageInfo.put(SalesCardsTotalQuery, new PageInfo(INFO,SaleTotalQuery,SalesCardsTotalQuery));
		allPageInfo.put(CardsTotalQuery, new PageInfo(MagInfo,MagSaleStatistics,CardsTotalQuery));
		
		//������Ա����--��Ϣ��ѯ
		allPageInfo.put(MAG_CARD_SALE_DETAIL_QUERY, new PageInfo(MAG_INFO,MAG_SALE_DETAIL_QUERY,MAG_CARD_SALE_DETAIL_QUERY));
		allPageInfo.put(MAG_REG_NEW_SALE_DETAIL_QUERY, new PageInfo(MAG_INFO,MAG_SALE_DETAIL_QUERY,MAG_REG_NEW_SALE_DETAIL_QUERY));
		allPageInfo.put(MAG_CITYRECORD_STAT, new PageInfo(MAG_INFO,Mag_Reward,MAG_CITYRECORD_STAT));//���������
		
		//�׿����������ѯ
		allPageInfo.put(RegactInfoQuery, new PageInfo(INFO,REGACT,RegactInfoQuery));// �¶��׿�����Ǽ���ϸ��ѯ
		allPageInfo.put(RegactStatisticsQuery, new PageInfo(INFO,REGACT,RegactStatisticsQuery));// �¶��׿�������ͳ�Ʋ�ѯ
		
		//�ҵĶ���
		allPageInfo.put(SalesHistory, new PageInfo(INFO,SALES,SalesHistory));// ��Ʒ������ʷ��ѯ		
		allPageInfo.put(SalesOrder, new PageInfo(INFO,SALES,SalesOrder));// ��Ʒ������ʷ��ѯ
		allPageInfo.put(SalesOrderDtl, new PageInfo(INFO,SALES,SalesOrder));// ��Ʒ������Դ��ϸ
		allPageInfo.put(SalesOrderTimes, new PageInfo(INFO,SALES,SalesOrderTimes));//����������Ϣ��ѯ
		
		// ���˽����ѯ
		allPageInfo.put(ExamineList, new PageInfo(INFO,EXAMINE,EMPTY));
		
		//������ϸ��ѯ
		allPageInfo.put(CARD_SALE_DETAIL_QUERY, new PageInfo(INFO,SALE_DETAIL_QUERY,CARD_SALE_DETAIL_QUERY));//�׿�������ϸ��ѯ
		allPageInfo.put(NEW_BUSI_SALE_DETAIL_QUERY, new PageInfo(INFO,SALE_DETAIL_QUERY,NEW_BUSI_SALE_DETAIL_QUERY));//��ҵ��������ϸ��ѯ
		
		//�����̽���
		allPageInfo.put(DeliveryQuery, new PageInfo(DeliveryQuery,EMPTY,EMPTY));// ���͵���ѯ
		allPageInfo.put(BatchDisover, new PageInfo(DeliveryQuery,BatchDisover,EMPTY));//�����������
		allPageInfo.put(BatchSMSSign, new PageInfo(DeliveryQuery,BatchSMSSign,EMPTY));//��������ǩ�ն���
		allPageInfo.put(BatchLogi, new PageInfo(DeliveryQuery,BatchLogi,EMPTY));//������������¼��
		allPageInfo.put(AdpaysumQuery, new PageInfo(AdpaysumQuery,EMPTY,EMPTY));// ���ʵ���ѯ
		
		allPageInfo.put(ExamineList, new PageInfo(INFO,EXAMINE,EMPTY));// ���˽����ѯ
		
		allPageInfo.put(GoodsReserve, new PageInfo(BASE,GOODSRESERVE,EMPTY));// ��Ʒ����
		
		allPageInfo.put(NodeQuery, new PageInfo(BASE,NODEQUERY,EMPTY));// �������ϲ�ѯ
		allPageInfo.put(NodeQuit, new PageInfo(BASE,NODEQUIT,EMPTY));// �������ϲ�ѯ
		
		allPageInfo.put(ShopAssistantJoin, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantJoin));// ��Ա��������
		allPageInfo.put(ShopAssistantList, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantList));// �ҵĵ�Ա��ѯ
		allPageInfo.put(ShopAssistantLoad, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantLoad));// ��Ա��ϸ��ѯ
		allPageInfo.put(ShopAssistantQuit, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantQuit));// ��Ա��ϸ��ѯ
		
		//�ҵĳ��
		allPageInfo.put(RewardRecordList, new PageInfo(REWARD,REWARDDTL,RewardRecordList));// �����ϸ��ѯ  �������
		allPageInfo.put(BbcRewardRecordList, new PageInfo(REWARD,REWARDDTL,BbcRewardRecordList));//�����ϸ��ѯ  B2m
		
		allPageInfo.put(RewardVerifiedList, new PageInfo(REWARD,REWARDDTL,RewardVerifiedList));// ���У��ʧ����ϸ��ѯ -  �������
		allPageInfo.put(BbcRewardVerifiedList, new PageInfo(REWARD,REWARDDTL,BbcRewardVerifiedList));// ���У��ʧ����ϸ��ѯ - b2m
		
		allPageInfo.put(CITYRECORD_STAT, new PageInfo(REWARD,REWARDPAY,CITYRECORD_STAT));//���������
		
		allPageInfo.put(Cardrewdet, new PageInfo(REWARD,REWARDDTL,Cardrewdet));//�ͻ�������չ���������ϸ
		allPageInfo.put(CardrewdetStat,new PageInfo(REWARD,REWARDRPT,CardrewdetStat));//�ͻ�������չ����������
		
		allPageInfo.put(RewardTotalList, new PageInfo(REWARD,REWARDRPT,RewardTotalList));// ��𱨱� - ��Ӧ����𱨱�
		allPageInfo.put(RewardRealPayList, new PageInfo(REWARD,REWARDRPT,RewardRealPayList));// ��𱨱� - �������������ʵ��֧����𱨱�
		allPageInfo.put(RewardBalance, new PageInfo(REWARD,REWARDRPT,RewardBalance));// ��𱨱� - �������������ʵ��֧����𱨱�
		
		//��ͨƽ̨
		allPageInfo.put(PendingRequestQuery, new PageInfo(COMMUNI,PendingRequestQuery,EMPTY));//����ҵ���ѯ
		allPageInfo.put(OperationInfoQuery, new PageInfo(COMMUNI,OperationInfoQuery,EMPTY));//ҵ����Ϣ��ѯ
		allPageInfo.put(AfficheInfoQuery, new PageInfo(COMMUNI,AfficheInfoQuery,EMPTY));//������Ϣ��ѯ
		allPageInfo.put(KnowledgeQuery, new PageInfo(COMMUNI,KnowledgeQuery,EMPTY));//֪ʶ����Ϣ��ѯ
		allPageInfo.put(Interlocution, new PageInfo(COMMUNI,Interlocution,EMPTY));//�����ʴ�
		allPageInfo.put(Question,new PageInfo(COMMUNI,Interlocution,Question));//����
		allPageInfo.put(MyQuestion, new PageInfo(COMMUNI,Interlocution,MyQuestion));//�ҵ�����
		
		allPageInfo.put(RewardTotalList, new PageInfo(REWARD,REWARDRPT,RewardTotalList));// ��𱨱� - �²�����𱨱� 
		allPageInfo.put(RewardRealPayList, new PageInfo(REWARD,REWARDRPT,RewardRealPayList));// ��𱨱� - �������������ʵ��֧����𱨱�
		allPageInfo.put(RewardLocal, new PageInfo(REWARD,null,null));// ��𱨱� - �������������ʵ��֧����𱨱�
		
		//רԱ
		allPageInfo.put(RecommendSuccessQuery, new PageInfo(MISSIONERINFO,MissionerDetailQuery,RecommendSuccessQuery));// �Ƽ��ɹ���ϸ��ѯ
		allPageInfo.put(RecommendFailQuery, new PageInfo(MISSIONERINFO,MissionerDetailQuery,RecommendFailQuery));// �Ƽ�ʧ����ϸ��ѯ
		allPageInfo.put(RealTimeAccountingSucc, new PageInfo(MISSIONERINFO,RealTimeAccounting,RealTimeAccountingSucc));//������ɹ���¼��ѯ��רԱ��
		allPageInfo.put(RealTimeAccountingFail, new PageInfo(MISSIONERINFO,RealTimeAccounting,RealTimeAccountingFail));//������ʧ�ܼ�¼��ѯ��רԱ��
		
		
		//˰�����ѯ 
	 	allPageInfo.put(ADJUSTMENT_STAT, new PageInfo(REWARD,REWARDPAY,ADJUSTMENT_STAT)); //��������Ա
	 	allPageInfo.put(MAG_ADJUSTMENT_STAT, new PageInfo(MAG_INFO,Mag_Reward,MAG_ADJUSTMENT_STAT)); //��������
	 	
	 	//�ն˳��
	 	allPageInfo.put(REWARDTD_SUC, new PageInfo(REWARD,RWARDTD,REWARDTD_SUC)); // �ն˼Ƴ�ɹ���ϸ
	 	allPageInfo.put(CITY_REWARDTD_SUC, new PageInfo(CITYINFO,CITY_NODE_LIST,CITY_REWARDTD_SUC)); // �й�˾_�ն˼Ƴ�ɹ���ϸ
	 	allPageInfo.put(GD_REWARDTD_SUC, new PageInfo(GDINFO,GD_NODE_LIST,GD_REWARDTD_SUC)); // ʡ��˾_�ն˼Ƴ�ɹ���ϸ
	 	allPageInfo.put(REWARDTD_FAIL, new PageInfo(REWARD,RWARDTD,REWARDTD_FAIL)); //�ն˼Ƴ�ʧ����ϸ
	 	allPageInfo.put(CITY_REWARDTD_FAIL, new PageInfo(CITYINFO,CITY_NODE_LIST,CITY_REWARDTD_FAIL)); // �й�˾_�ն˼Ƴ�ʧ����ϸ
	 	allPageInfo.put(GD_REWARDTD_FAIL, new PageInfo(GDINFO,GD_NODE_LIST,GD_REWARDTD_FAIL)); // ʡ��˾_�ն˼Ƴ�ʧ����ϸ
	 	allPageInfo.put(REWARDTD_SUC_DATA, new PageInfo(REWARD,RWARDTD,REWARDTD_SUC_DATA));  //�ն˼Ƴ�ɹ����ݻ���
	 	allPageInfo.put(REWARDAD_SUC, new PageInfo(REWARD,RWARDTD,REWARDAD_SUC)); // �ն�Ԥ���Ƴ�ɹ���ϸ
	 	allPageInfo.put(REWARDAD_FAIL, new PageInfo(REWARD,RWARDTD,REWARDAD_FAIL)); //�ն�Ԥ���Ƴ�ʧ����ϸ
	 	allPageInfo.put(SETTLEMENTMONTH, new PageInfo(REWARD,REWARDPAY,SETTLEMENTMONTH)); //ҵ����ϸ����������ά�ȣ�
	 	allPageInfo.put(MAG_SETTLEMENTMONTH, new PageInfo(MAG_INFO,Mag_Reward,MAG_SETTLEMENTMONTH)); //ҵ����ϸ����������ά�ȣ�������ɼ���
	 	allPageInfo.put(SALEMONTH, new PageInfo(REWARD,REWARDPAY,SALEMONTH)); //ҵ����ϸ����������ά�ȣ�
	 	allPageInfo.put(MAG_SALEMONTH, new PageInfo(MAG_INFO,Mag_Reward,MAG_SALEMONTH)); //ҵ����ϸ����������ά�ȣ�������ɼ���
	 	allPageInfo.put(MONTHREMUN, new PageInfo(REWARD,REWARDPAY,MONTHREMUN)); //�¶�Ӧ����𱨱�
	 	allPageInfo.put(MAG_MONTHREMUN, new PageInfo(MAG_INFO,Mag_Reward,MAG_MONTHREMUN)); //�¶�Ӧ����𱨱�����ɼ���
	 	allPageInfo.put(REWARDBUSINESS, new PageInfo(REWARD,REWARDPAY,REWARDBUSINESS)); //ҵ���������ڱ�
	 	allPageInfo.put(MAG_REWARDBUSINESS, new PageInfo(MAG_INFO,Mag_Reward,MAG_REWARDBUSINESS)); //ҵ���������ڱ�����ɼ���
	 	
		allPageInfo.put(GD_REWARDPRO_PAYMENT, new PageInfo(GDINFO,GD_REWARDPRO,GD_REWARDPRO_PAYMENT)); // ���ҵĳ��-����𱨱�-�����һ�廯����
		allPageInfo.put(GD_REWARD_PAYMENT_MANAGE, new PageInfo(GDINFO,GD_REWARD_PAYMENT,GD_REWARD_PAYMENT_MANAGE)); // ���ҵĳ��-����𱨱�-�����һ�廯����
		allPageInfo.put(GD_REWARD_PAYMENT_CONFIG, new PageInfo(GDINFO,GD_REWARD_PAYMENT,GD_REWARD_PAYMENT_CONFIG)); // ���ҵĳ��-����𱨱�-�����һ�廯����
	 	
	 	
	}
}
