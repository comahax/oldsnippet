package com.gmcc.pboss.common.dictionary;


import java.util.LinkedHashMap;
import java.util.Map;

import com.gmcc.pboss.common.action.PageInfo;
import com.gmcc.pboss.common.util.JSTLConstants;

/**
 * PageLoction 页面位置统一类
 * @author yuwenjun
 * @date Jun 18, 2009
 * 所属项目：PBOSS
 * 所属模块：门户
 * 描述：页面标识
 */
public class PageLoction extends JSTLConstants {
	public static final String EMPTY = "";//空
	//主菜单标识
	/**
	 * 首页
	 */
	public static final String INDEX = "INDEX";//首页
	/**
	 * 信息查询
	 */
	public static final String INFO = "INFO";//信息查询
	/**
	 * 信息查询(经理)
	 */
	public static final String MagInfo = "MagInfo";//信息查询
	/**
	 * 基础服务
	 */
	public static final String BASE = "BASE";//基础服务  
	/**
	 * 沟通平台
	 */
	public static final String COMMUNI = "COMMUNI";//沟通平台
	/**
	 * 我的酬金
	 */
	public static final String REWARD = "REWARD";//我的酬金
	/**
	 * 基础信息-经理人员可见
	 */
	//public static final String BASE_INFO="BaseInfo";//基础信息
	 
	//二级菜单
	/**
	 * 套卡激活情况查询
	 */
	public static final String REGACT = "REGACT";//套卡激活情况查询
	/**
	 * 我的考核结果查询
	 */
	public static final String EXAMINE = "EXAMINE";//我的考核结果查询
	/**
	 * 我的订购信息查询
	 */
	public static final String SALES = "SALES";//我的订购信息查询
	/**
	 * 商品订购
	 */
	public static final String GOODSRESERVE = "GOODSRESERVE";//商品订购
	/**
	 * 网点资料查询与修改申请
	 */
	public static final String NODEQUERY = "NODEQUERY";//网点资料查询与修改申请
	/**
	 * 渠道商退出申请
	 */
	public static final String NODEQUIT = "NODEQUIT";//渠道商退出申请
	/**
	 * 店员管理
	 */
	public static final String SHOPASSISTANTLIST = "SHOPASSISTANTLIST";//店员管理
	/**
	 * 酬金报表
	 */
	public static final String REWARDRPT = "REWARDRPT";//酬金报表
	/**
	 * 酬金明细
	 */
	public static final String REWARDDTL = "REWARDDTL";//酬金明细
	/**
	 * 酬金结果
	 */
	public static final String REWARDPAY = "RewardPay";
	/**
	 * 销售汇总
	 */
	public static final String SaleTotalQuery = "SaleTotalQuery";//销售汇总
	/**
	 * 销售汇总（经理）
	 */
	public static final String MagSaleStatistics = "MagSaleStatistics";//销售汇总
	
	/**
	 * 终端酬金
	 */
	public static final String  RWARDTD= "RewarTd";
	
	/**
	 * 月度套卡激活登记明细查询
	 */
	public static String RegactInfoQuery = "RegactInfoQuery";	
	/**
	 * 月度套卡激活量统计查询
	 */
	public static String RegactStatisticsQuery = "RegactStatisticsQuery";	
	/**
	 * 商品订购历史查询
	 */
	public static String SalesHistory = "SalesHistoryQuery";	
	/**
	 * 商品订购订单信息查询
	 */
	public static String SalesOrder = "SalesOrderQuery";
	/**
	 * 商品订购次数信息查询
	 */
	public static String SalesOrderTimes="SalesOrderTimesQuery";
	/**
	 * 商品订单资源明细
	 */
	public static String SalesOrderDtl = "SalesOrderDtl";	
	/**
	 * 配送单查询
	 */
	public static final String DeliveryQuery = "DeliveryQuery";	
	public static final String BatchDisover = "BatchDisover";//批量完成配送
	public static final String BatchSMSSign = "BatchSMSSign";//批量补发签收短信
	public static final String BatchLogi = "BatchLogi";//物流单号批量录入
	/**
	 * 垫资单查询
	 */
	public static final String AdpaysumQuery = "AdpaysumQuery";
	
	/**
	 * 社会渠道 - 应付酬金明细查询
	 */
	public static String RewardRecordList = "RewardRecordList";	
	/**
	 * 社会渠道 - 实付酬金汇总查询
	 */
	public static String RewardTotalList = "RewardTotalList";	
	/**
	 * 社会渠道 - 酬金校验失败信息查询
	 */
	public static String RewardVerifiedList = "RewardVerifiedList";
	
	/**
	 * B2m应付酬金明细查询
	 */
	public static String BbcRewardRecordList = "BbcRewardRecordList";	
	/**
	 * B2M网站酬金总额查询
	 */
	public static String BbcRewardTotalList = "BbcRewardTotalList";	
	/**
	 * B2M网站酬金总额查询
	 */
	public static String BbcRewardVerifiedList = "BbcRewardVerifiedList";		

	/**
	 * 社会渠道网点月实际支付酬金报表
	 */
	public static String RewardRealPayList = "RewardRealPayList";	
	/**
	 * 社会渠道网点酬金池余额
	 */
	public static String RewardBalance = "RewardBalance";	
	/**
	 * 本地酬金
	 */
	public static String RewardLocal = "RewardLocal";	
	/**
	 * 客户质量发展奖励酬金明细
	 */
	public static final String Cardrewdet = "Cardrewdet";
	/**
	 * 客户质量发展奖励酬金汇总
	 */
	public static final String CardrewdetStat = "CardrewdetStat";	
	/**
	 * 考核结果查询
	 */
	public static String ExamineList = "ExamineList";	
	/**
	 * 商品订购
	 */
	public static String GoodsReserve = "GoodsReserve";	
	/**
	 * 网点资料查询
	 */
	public static String NodeQuery = "NodeQuery";	
	/**
	 * 渠道商退出申请 
	 */
	public static String NodeQuit = "NodeQuit";		
	/**
	 * 店员加入申请
	 */
	public static String ShopAssistantJoin = "ShopAssistantJoin";
	/**
	 * 我的店员查询
	 */
	public static String ShopAssistantList = "ShopAssistantList";
	/**
	 * 我的店员查询
	 */
	public static String ShopAssistantLoad = "ShopAssistantLoad";
	/**
	 * 店员退出申请
	 */
	public static String ShopAssistantQuit = "ShopAssistantQuit";
	/**
	 * 待办业务查询
	 */
	public static String PendingRequestQuery = "PendingRequestQuery";
	/**
	 * 业务信息查询
	 */
	public static String OperationInfoQuery = "OperationInfoQuery";
	/**
	 * 公告信息查询
	 */
	public static String AfficheInfoQuery = "AfficheInfoQuery";
	/**
	 * 知识库查询
	 */
	public static String KnowledgeQuery = "KnowledgeQuery";
	/**
	 * 在线问答
	 */
	public static String Interlocution = "Interlocution";
	/**
	 * 提问
	 */
	public static String Question = "Question";
	/**
	 * 我的提问
	 */
	public static String MyQuestion = "MyQuestion";
	
	/**
	 * 基础信息（一级菜单）-经理人员可见
	 */
	public static final String BASE_INFO="BaseInfo";//基础信息
	/**
	 * 信息查询（一级菜单）-经理人员可见
	 */
	public static final String MAG_INFO="MagInfo";//信息查询
	public static final String Mag_Reward="MagReward";//酬金查询
	/**
	 * 网点信息查询-经理人员界面
	 */
	public static String MAG_NODE_LIST="magNodeList";//网点信息列表
	public static String Node_List = "nodeInfoList";
	public static String MAG_NODE_INFO="magNodeInfo";//网点信息详情
	public static String MAG_NODE_MEMBER="magNodeMember";//网点店员信息
	
	/**
	 * 网点信息查询-市公司人员界面
	 */

	public static final String CITYINFO="CITYINFO";//信息查询
	public static String CITY_NODE_LIST="CITY_NODE_LIST";//信息列表
	
	/**
	 * 网点信息查询-省公司人员界面
	 */
	public static final String GDINFO="GDINFO";//信息查询
	public static String GD_NODE_LIST="GD_NODE_LIST";//网点信息列表
	/**
	 * 店员信息查询-经理人员界面
	 */
	public static String MAG_ASSISTANT_LIST="magAssistantList";//店员信息列表
	public static String Assistant_List = "assistantInfoList";
	public static String MAG_ASSISTANT_INFO="magAssistantInfo";//店员信息详情
	/**
	 * 新业务销售汇总查询
	 */
	public static String RegisternewcntQuery = "RegisternewcntQuery";
	/**
	 * 新业务销售汇总查询(经理)
	 */
	public static String MagRegNewSaleStatistics = "MagRegNewSaleStatistics";
	/**
	 * 销售汇总查询
	 */
	public static String SalescntQuery = "SalescntQuery";	
	
	//套卡销售汇总
	public static String SalesCardsTotalQuery = "SalesCardsTotalQuery";
	public static String CardsTotalQuery = "CardsTotalQuery";	
	/**
	 * 店员店主、经理人员都可见
	 */
	/**
	 * 销售明细查询（二级菜单）
	 */
	public static String SALE_DETAIL_QUERY = "SaleDetailQuery";//店员店主
	public static String MAG_SALE_DETAIL_QUERY="MagSaleDetailQuery";//经理
	/**
	 * 销售明细查询 -> 套卡销售明细查询
	 */
	public static String CARD_SALE_DETAIL_QUERY = "CardSaleDetailQuery";//店员店主
	public static String MAG_CARD_SALE_DETAIL_QUERY = "MagCardSaleDetailQuery";//经理
	/**
	 * 销售明细查询 -> 新业务销售明细查询CH_PW_REGISTERNEW
	 */
	public static String NEW_BUSI_SALE_DETAIL_QUERY = "NewBusiSaleDetailQuery";//店员店主
	public static String MAG_REG_NEW_SALE_DETAIL_QUERY = "MagRegNewSaleDetailQuery";//经理
	/**
	 * 酬金结果汇总
	 */
	public static final String CITYRECORD_STAT = "CITYRECORD_STAT";
	public static final String MAG_CITYRECORD_STAT = "MAG_CITYRECORD_STAT";

	/**
	 * 信息查询（专员）
	 */
	public static String MISSIONERINFO = "MISSIONERINFO";	
	/**
	 * 创薪联盟业务登记明细查询（专员）
	 */
	public static String MissionerDetailQuery = "MissionerDetailQuery";
	/**
	 * 创薪联盟业务登记明细查询->推荐成功明细查询（专员）
	 */
	public static String RecommendSuccessQuery = "Mis_Mdq_Success";
	/**
	 * 创薪联盟业务登记明细查询->推荐失败明细查询（专员）
	 */
	public static String RecommendFailQuery = "Mis_mdq_fail";
	//实时酬金核算记录查询（专员）
	public static String RealTimeAccounting ="RealTimeAccounting";
	//实时酬金核算记录查询->酬金核算成功记录查询（专员）
	public static String RealTimeAccountingSucc="RealTimeAccountingSucc";
	//实时酬金核算记录查询 -> 酬金核算失败记录查询（专员）
	public static String RealTimeAccountingFail="RealTimeAccountingFail";
	
	/**
	 * 酬金结果汇总（我的酬金->酬金结果->税后酬金查询）
	 */
	public static String ADJUSTMENT_STAT = "ADJUSTMENT_STAT"; //店主，店员
	public static String MAG_ADJUSTMENT_STAT = "MAG_ADJUSTMENT_STAT"; //渠道经理 
	
	/**
	 * 终端计酬成功明细（我的酬金-》终端酬金-》终端计酬成功明细）
	 */
	public static final String REWARDTD_SUC = "REWARDTD_SUC";
	/**
	 * 市公司终端计酬成功明细（我的酬金-》终端酬金-》终端计酬成功明细）
	 */
	public static final String CITY_REWARDTD_SUC = "CITY_REWARDTD_SUC";
	/**
	 * 省公司终端计酬成功明细（我的酬金-》终端酬金-》终端计酬成功明细）
	 */
	public static final String GD_REWARDTD_SUC = "GD_REWARDTD_SUC";
	 
	/**
	 * 终端计酬失败明细（我的酬金-》终端酬金-》终端计酬失败明细）
	 */
	public static final String REWARDTD_FAIL = "REWARDTD_FAIL";
	/**
	 * 市公司_终端计酬失败明细（我的酬金-》终端酬金-》终端计酬失败明细）
	 */
	public static final String CITY_REWARDTD_FAIL = "CITY_REWARDTD_FAIL";
	/**
	 * 省公司_终端计酬失败明细（我的酬金-》终端酬金-》终端计酬失败明细）
	 */
	public static final String GD_REWARDTD_FAIL = "GD_REWARDTD_FAIL";
	
	/**
	 * 终端计酬成功数据汇总（我的酬金-》终端酬金-》终端计酬成功数据汇总）
	 */
	public static final String REWARDTD_SUC_DATA = "REWARDTD_SUC_DATA";
	
	/**
	 * 终端预发计酬成功明细（我的酬金-》终端酬金-》终端预发计酬成功明细）
	 */
	public static final String REWARDAD_SUC = "REWARDAD_SUC";
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》终端预发计酬失败明细）
	 */
	public static final String REWARDAD_FAIL = "REWARDAD_FAIL";
	
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》业务明细报表（结算月维度））
	 */
	public static final String SETTLEMENTMONTH = "SETTLEMENTMONTH";
	public static final String MAG_SETTLEMENTMONTH = "MAG_SETTLEMENTMONTH";
	
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》业务明细报表（销售月维度））
	 */
	public static final String SALEMONTH = "SALEMONTH";
	public static final String MAG_SALEMONTH = "MAG_SALEMONTH";
	
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》月度应发酬金报表）
	 */
	public static final String MONTHREMUN = "MONTHREMUN";
	public static final String MAG_MONTHREMUN = "MAG_MONTHREMUN";
	
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》业务办理酬金分期表）
	 */
	public static final String REWARDBUSINESS = "REWARDBUSINESS";
	public static final String MAG_REWARDBUSINESS = "MAG_REWARDBUSINESS";
	
	
	/**
	 * 【我的酬金】-【酬金报表】-【酬金一体化报表】
	 */
	public static final String GD_REWARDPRO = "GD_REWARDPRO";
	public static final String GD_REWARDPRO_PAYMENT = "GD_REWARDPRO_PAYMENT";
	

	/**
	 * 【我的酬金】-【酬金一体化】-【酬金一体化配置】
	 */
	public static final String GD_REWARD_PAYMENT = "GD_REWARDPRO";
	public static final String GD_REWARD_PAYMENT_CONFIG = "GD_REWARD_PAYMENT_CONFIG";
	
	/**
	 * 【我的酬金】-【酬金一体化】-【酬金一体化管理】
	 */
	public static final String GD_REWARD_PAYMENT_MANAGE = "GD_REWARD_PAYMENT_MANAGE";
	
	
	
	//以下构造页面信息
	public static Map allPageInfo = new LinkedHashMap();
	static{
		//经理人员界面--网点、店员店主查询界面
		allPageInfo.put(MAG_NODE_LIST, new PageInfo(BASE_INFO,Node_List,EMPTY));
		allPageInfo.put(MAG_NODE_INFO, new PageInfo(BASE_INFO,Node_List,EMPTY));
		allPageInfo.put(MAG_NODE_MEMBER, new PageInfo(BASE_INFO,Node_List,EMPTY));
		allPageInfo.put(MAG_ASSISTANT_LIST, new PageInfo(BASE_INFO,Assistant_List,EMPTY));
		allPageInfo.put(MAG_ASSISTANT_INFO, new PageInfo(BASE_INFO,Assistant_List,EMPTY));
		allPageInfo.put(RegisternewcntQuery, new PageInfo(INFO,SaleTotalQuery,RegisternewcntQuery));// 新业务销售汇总查询
		allPageInfo.put(SalescntQuery, new PageInfo(INFO,SaleTotalQuery,SalescntQuery));// 销售汇总查询
		allPageInfo.put(MagRegNewSaleStatistics, new PageInfo(MagInfo,MagSaleStatistics,MagRegNewSaleStatistics));// 新业务销售汇总查询
		allPageInfo.put(SalesCardsTotalQuery, new PageInfo(INFO,SaleTotalQuery,SalesCardsTotalQuery));
		allPageInfo.put(CardsTotalQuery, new PageInfo(MagInfo,MagSaleStatistics,CardsTotalQuery));
		
		//经理人员界面--信息查询
		allPageInfo.put(MAG_CARD_SALE_DETAIL_QUERY, new PageInfo(MAG_INFO,MAG_SALE_DETAIL_QUERY,MAG_CARD_SALE_DETAIL_QUERY));
		allPageInfo.put(MAG_REG_NEW_SALE_DETAIL_QUERY, new PageInfo(MAG_INFO,MAG_SALE_DETAIL_QUERY,MAG_REG_NEW_SALE_DETAIL_QUERY));
		allPageInfo.put(MAG_CITYRECORD_STAT, new PageInfo(MAG_INFO,Mag_Reward,MAG_CITYRECORD_STAT));//酬金结果汇总
		
		//套卡激活情况查询
		allPageInfo.put(RegactInfoQuery, new PageInfo(INFO,REGACT,RegactInfoQuery));// 月度套卡激活登记明细查询
		allPageInfo.put(RegactStatisticsQuery, new PageInfo(INFO,REGACT,RegactStatisticsQuery));// 月度套卡激活量统计查询
		
		//我的订购
		allPageInfo.put(SalesHistory, new PageInfo(INFO,SALES,SalesHistory));// 商品订购历史查询		
		allPageInfo.put(SalesOrder, new PageInfo(INFO,SALES,SalesOrder));// 商品订购历史查询
		allPageInfo.put(SalesOrderDtl, new PageInfo(INFO,SALES,SalesOrder));// 商品订单资源明细
		allPageInfo.put(SalesOrderTimes, new PageInfo(INFO,SALES,SalesOrderTimes));//订单次数信息查询
		
		// 考核结果查询
		allPageInfo.put(ExamineList, new PageInfo(INFO,EXAMINE,EMPTY));
		
		//销售明细查询
		allPageInfo.put(CARD_SALE_DETAIL_QUERY, new PageInfo(INFO,SALE_DETAIL_QUERY,CARD_SALE_DETAIL_QUERY));//套卡销售明细查询
		allPageInfo.put(NEW_BUSI_SALE_DETAIL_QUERY, new PageInfo(INFO,SALE_DETAIL_QUERY,NEW_BUSI_SALE_DETAIL_QUERY));//新业务销售明细查询
		
		//配送商界面
		allPageInfo.put(DeliveryQuery, new PageInfo(DeliveryQuery,EMPTY,EMPTY));// 配送单查询
		allPageInfo.put(BatchDisover, new PageInfo(DeliveryQuery,BatchDisover,EMPTY));//批量完成配送
		allPageInfo.put(BatchSMSSign, new PageInfo(DeliveryQuery,BatchSMSSign,EMPTY));//批量补发签收短信
		allPageInfo.put(BatchLogi, new PageInfo(DeliveryQuery,BatchLogi,EMPTY));//物流单号批量录入
		allPageInfo.put(AdpaysumQuery, new PageInfo(AdpaysumQuery,EMPTY,EMPTY));// 垫资单查询
		
		allPageInfo.put(ExamineList, new PageInfo(INFO,EXAMINE,EMPTY));// 考核结果查询
		
		allPageInfo.put(GoodsReserve, new PageInfo(BASE,GOODSRESERVE,EMPTY));// 商品订购
		
		allPageInfo.put(NodeQuery, new PageInfo(BASE,NODEQUERY,EMPTY));// 网点资料查询
		allPageInfo.put(NodeQuit, new PageInfo(BASE,NODEQUIT,EMPTY));// 网点资料查询
		
		allPageInfo.put(ShopAssistantJoin, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantJoin));// 店员加入申请
		allPageInfo.put(ShopAssistantList, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantList));// 我的店员查询
		allPageInfo.put(ShopAssistantLoad, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantLoad));// 店员明细查询
		allPageInfo.put(ShopAssistantQuit, new PageInfo(BASE,SHOPASSISTANTLIST,ShopAssistantQuit));// 店员明细查询
		
		//我的酬金
		allPageInfo.put(RewardRecordList, new PageInfo(REWARD,REWARDDTL,RewardRecordList));// 酬金明细查询  社会渠道
		allPageInfo.put(BbcRewardRecordList, new PageInfo(REWARD,REWARDDTL,BbcRewardRecordList));//酬金明细查询  B2m
		
		allPageInfo.put(RewardVerifiedList, new PageInfo(REWARD,REWARDDTL,RewardVerifiedList));// 酬金校验失败明细查询 -  社会渠道
		allPageInfo.put(BbcRewardVerifiedList, new PageInfo(REWARD,REWARDDTL,BbcRewardVerifiedList));// 酬金校验失败明细查询 - b2m
		
		allPageInfo.put(CITYRECORD_STAT, new PageInfo(REWARD,REWARDPAY,CITYRECORD_STAT));//酬金结果汇总
		
		allPageInfo.put(Cardrewdet, new PageInfo(REWARD,REWARDDTL,Cardrewdet));//客户质量发展奖励酬金明细
		allPageInfo.put(CardrewdetStat,new PageInfo(REWARD,REWARDRPT,CardrewdetStat));//客户质量发展奖励酬金汇总
		
		allPageInfo.put(RewardTotalList, new PageInfo(REWARD,REWARDRPT,RewardTotalList));// 酬金报表 - 月应发酬金报表
		allPageInfo.put(RewardRealPayList, new PageInfo(REWARD,REWARDRPT,RewardRealPayList));// 酬金报表 - 社会渠道网点月实际支付酬金报表
		allPageInfo.put(RewardBalance, new PageInfo(REWARD,REWARDRPT,RewardBalance));// 酬金报表 - 社会渠道网点月实际支付酬金报表
		
		//沟通平台
		allPageInfo.put(PendingRequestQuery, new PageInfo(COMMUNI,PendingRequestQuery,EMPTY));//待办业务查询
		allPageInfo.put(OperationInfoQuery, new PageInfo(COMMUNI,OperationInfoQuery,EMPTY));//业务信息查询
		allPageInfo.put(AfficheInfoQuery, new PageInfo(COMMUNI,AfficheInfoQuery,EMPTY));//公告信息查询
		allPageInfo.put(KnowledgeQuery, new PageInfo(COMMUNI,KnowledgeQuery,EMPTY));//知识库信息查询
		allPageInfo.put(Interlocution, new PageInfo(COMMUNI,Interlocution,EMPTY));//在线问答
		allPageInfo.put(Question,new PageInfo(COMMUNI,Interlocution,Question));//提问
		allPageInfo.put(MyQuestion, new PageInfo(COMMUNI,Interlocution,MyQuestion));//我的提问
		
		allPageInfo.put(RewardTotalList, new PageInfo(REWARD,REWARDRPT,RewardTotalList));// 酬金报表 - 月产生酬金报表 
		allPageInfo.put(RewardRealPayList, new PageInfo(REWARD,REWARDRPT,RewardRealPayList));// 酬金报表 - 社会渠道网点月实际支付酬金报表
		allPageInfo.put(RewardLocal, new PageInfo(REWARD,null,null));// 酬金报表 - 社会渠道网点月实际支付酬金报表
		
		//专员
		allPageInfo.put(RecommendSuccessQuery, new PageInfo(MISSIONERINFO,MissionerDetailQuery,RecommendSuccessQuery));// 推荐成功明细查询
		allPageInfo.put(RecommendFailQuery, new PageInfo(MISSIONERINFO,MissionerDetailQuery,RecommendFailQuery));// 推荐失败明细查询
		allPageInfo.put(RealTimeAccountingSucc, new PageInfo(MISSIONERINFO,RealTimeAccounting,RealTimeAccountingSucc));//酬金核算成功记录查询（专员）
		allPageInfo.put(RealTimeAccountingFail, new PageInfo(MISSIONERINFO,RealTimeAccounting,RealTimeAccountingFail));//酬金核算失败记录查询（专员）
		
		
		//税后酬金查询 
	 	allPageInfo.put(ADJUSTMENT_STAT, new PageInfo(REWARD,REWARDPAY,ADJUSTMENT_STAT)); //店主，店员
	 	allPageInfo.put(MAG_ADJUSTMENT_STAT, new PageInfo(MAG_INFO,Mag_Reward,MAG_ADJUSTMENT_STAT)); //渠道经理
	 	
	 	//终端酬金
	 	allPageInfo.put(REWARDTD_SUC, new PageInfo(REWARD,RWARDTD,REWARDTD_SUC)); // 终端计酬成功明细
	 	allPageInfo.put(CITY_REWARDTD_SUC, new PageInfo(CITYINFO,CITY_NODE_LIST,CITY_REWARDTD_SUC)); // 市公司_终端计酬成功明细
	 	allPageInfo.put(GD_REWARDTD_SUC, new PageInfo(GDINFO,GD_NODE_LIST,GD_REWARDTD_SUC)); // 省公司_终端计酬成功明细
	 	allPageInfo.put(REWARDTD_FAIL, new PageInfo(REWARD,RWARDTD,REWARDTD_FAIL)); //终端计酬失败明细
	 	allPageInfo.put(CITY_REWARDTD_FAIL, new PageInfo(CITYINFO,CITY_NODE_LIST,CITY_REWARDTD_FAIL)); // 市公司_终端计酬失败明细
	 	allPageInfo.put(GD_REWARDTD_FAIL, new PageInfo(GDINFO,GD_NODE_LIST,GD_REWARDTD_FAIL)); // 省公司_终端计酬失败明细
	 	allPageInfo.put(REWARDTD_SUC_DATA, new PageInfo(REWARD,RWARDTD,REWARDTD_SUC_DATA));  //终端计酬成功数据汇总
	 	allPageInfo.put(REWARDAD_SUC, new PageInfo(REWARD,RWARDTD,REWARDAD_SUC)); // 终端预发计酬成功明细
	 	allPageInfo.put(REWARDAD_FAIL, new PageInfo(REWARD,RWARDTD,REWARDAD_FAIL)); //终端预发计酬失败明细
	 	allPageInfo.put(SETTLEMENTMONTH, new PageInfo(REWARD,REWARDPAY,SETTLEMENTMONTH)); //业务明细报表（结算月维度）
	 	allPageInfo.put(MAG_SETTLEMENTMONTH, new PageInfo(MAG_INFO,Mag_Reward,MAG_SETTLEMENTMONTH)); //业务明细报表（结算月维度）（经理可见）
	 	allPageInfo.put(SALEMONTH, new PageInfo(REWARD,REWARDPAY,SALEMONTH)); //业务明细报表（销售月维度）
	 	allPageInfo.put(MAG_SALEMONTH, new PageInfo(MAG_INFO,Mag_Reward,MAG_SALEMONTH)); //业务明细报表（销售月维度）（经理可见）
	 	allPageInfo.put(MONTHREMUN, new PageInfo(REWARD,REWARDPAY,MONTHREMUN)); //月度应发酬金报表
	 	allPageInfo.put(MAG_MONTHREMUN, new PageInfo(MAG_INFO,Mag_Reward,MAG_MONTHREMUN)); //月度应发酬金报表（经理可见）
	 	allPageInfo.put(REWARDBUSINESS, new PageInfo(REWARD,REWARDPAY,REWARDBUSINESS)); //业务办理酬金分期表
	 	allPageInfo.put(MAG_REWARDBUSINESS, new PageInfo(MAG_INFO,Mag_Reward,MAG_REWARDBUSINESS)); //业务办理酬金分期表（经理可见）
	 	
		allPageInfo.put(GD_REWARDPRO_PAYMENT, new PageInfo(GDINFO,GD_REWARDPRO,GD_REWARDPRO_PAYMENT)); // 【我的酬金】-【酬金报表】-【酬金一体化报表】
		allPageInfo.put(GD_REWARD_PAYMENT_MANAGE, new PageInfo(GDINFO,GD_REWARD_PAYMENT,GD_REWARD_PAYMENT_MANAGE)); // 【我的酬金】-【酬金报表】-【酬金一体化报表】
		allPageInfo.put(GD_REWARD_PAYMENT_CONFIG, new PageInfo(GDINFO,GD_REWARD_PAYMENT,GD_REWARD_PAYMENT_CONFIG)); // 【我的酬金】-【酬金报表】-【酬金一体化报表】
	 	
	 	
	}
}
