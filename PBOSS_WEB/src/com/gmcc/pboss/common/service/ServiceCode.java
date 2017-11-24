package com.gmcc.pboss.common.service;

/**
 * 从兴公司电子渠道业务部
 * 
 * @author tangzhu
 * @date 2009-7-31 所属项目： 所属模块： 描述： 业务编码
 */
public class ServiceCode {
	/**
	 * 一般公共处理
	 */
	public static final String COMMON = "COMMON";
	/**
	 * 用户操作Serivic
	 */
	public static final String USER = "USER";

	/**
	 * 用户操作Service
	 */
	public static final String MEMBER = "MEMBER";

	/**
	 * 延迟加载的登录用户信息
	 */
	public static final String MEMBER_INFO_DELAT_LOAD = "MEMBER_INFO_DELAT_LOAD";
	
	/**
	 * 酬金明细查询_社会渠道Service
	 */
	public static final String REWARD_SOCIETY = "REWARDDETAILS_SOCIETY";
	
	/**
	 * 酬金明细查询_B2M网站Service
	 */
	public static final String REWARD_BBC = "REWARDDETAILS_BBC";
	
	/**
	 * 酬金明细查询_UNPB创新联盟
	 */
	public static final String REWARD_UNPB = "REWARDDETAILS_UNPB";
	
	/**
	 * 酬金校验失败信息_社会渠道
	 */
	public static final String REWARDFAIL_SOCIETY = "REWARDFAIL_SOCIETY";
	
	/**
	 * 酬金校验失败信息_网站渠道
	 */
	public static final String REWARDFAIL_BBC = "REWARDFAIL_BBC";
	
	/**
	 * 本地酬金
	 */
	public static final String REWARD_LOCAL = "REWARD";
	
	/**
	 * 月应发酬金报表_社会渠道
	 */
	public static final String REWARDTOTAL_SOCIETY = "REWARDTOTAL_SOCIETY";
	/**
	 * 月应发酬金报表_B2M网站
	 */
	public static final String REWARDTOTAL_BBC = "REWARDTOTAL_BBC";
	/**
	 * 月应发酬金报表_UNPB创新联盟
	 */
	public static final String REWARDTOTAL_UNPB = "REWARDTOTAL_UNPB";
	
	/**
	 * 月实际支付酬金报表-社会渠道
	 */
	public static final String REWARDREPORT_TOTAL = "REWARDREPORT_TOTAL";
	/**
	 * 月实际支付酬金报表-B2M网站
	 */
	public static final String REWARDREPORT_TOTAL_BBC = "REWARDREPORT_TOTAL_BBC";
	/**
	 * 月实际支付酬金报表-UNPB创新联盟
	 */
	public static final String REWARDREPORT_TOTAL_UNPB = "REWARDREPORT_TOTAL_UNPB";
	
	/**
	 * 酬金余额查询 
	 */
	public static final String REWARDBALANC = "REWARDBALANC";

	/**
	 * 考核报表Service
	 */
	public static final String EXAMINE = "EXAMINE";

	/**
	 * 网点资料Service
	 */
	public static final String NODE = "NODE_INFO";
	/**
	 * 卡类购销划扣银行标识加载
	 */
	public static final String DBBank  = "DBBANK";


	/**
	 * 商品种类
	 */
	public static final String DICTITEM  = "DICTITEM";
	/**
	 * 商品订购
	 */
	public static final String GOODSAPPLY  = "GOODSAPPLY";
	/**
	 * 业务代码
	 */
	public static final String OPERATION = "OPERATION";

	/**
	 * 网点申请
	 */
	public static final String WAYAPPLY = "WAYAPPLY";
	
	/**
	 * 店员管理Service
	 */
	public static final String EMPLOYEE = "EMPLOYEE";

	/**
	 * 短信
	 */
	public static final String SMS = "SMS";

	/**
	 * 月度套卡激活登记明细查询
	 */
	public static final String REGACT_DETAILS = "REGACT_DETAILS";
	
	/**
	 * 月套卡激活量统计查询
	 */
	public static final String REGACT_TOTAL = "REGACT_TOTAL";
	
	/**
	 * 商品订购历史查询
	 */
	public static final String SALESHISTORY = "SALESHISTORY";
	
	/**
	 * 订单信息
	 */
	public static final String SALESORDER = "SALESORDER";
	
	/**
	 * 配送商管理
	 */
	public static final String DELIVERY = "DELIVERY";
	public static final String BatchDelivery = "BatchDelivery";//批量配送处理
	
	
	/**沟通平台*/
	public static final String COMMUNICATE = "COMMUNICATE_PLATEAU";
	/**沟通平台_在线问答*/
	public static final String COMMUNICATE_ONLINE = "COMMUNICATE_ONLINE";
	/**沟通平台_首页*/
	public static final String COMMUNICATE_INDEX = "COMMUNICATE_PLATEAU_INDEX";
	
	/***
     * 附件下载
     */
    public static final String AFFIX_DOWNLOAD = "AFFIX_DOWNLOAD";
    
    /**固定参数加载*/
    public static final String CONSTANT_LOAD = "CONSTANT_LOAD";
    /**
     * 
     */
    public static final String FLASH_IMAGE_LOAD ="FLASH_IMAGE_LOAD" ;
    /**
     * 配送垫资
     */
    public static final String ADPAYSUM = "ADPAYSUM";
    /**
     * 订购次数信息查询
     */
    public static final String ORDER_TIMES="ORDER_TIMES";
    /**
     * 经理人员-店员信息查询
     */
    public static final String MANAGER_MEMBER_QUERY="MANAGER_MEMBER_QUERY";
    /**
     * 经理人员-网点信息查询
     */
    public static final String MANAGER_NODE_QUERY="MANAGER_NODE_QUERY";
    /**
     * 经理人员-网点店员信息查询
     */
    public static final String MANAGER_NODE_MEMBER="MANAGER_NODE_MEMBER";
    /**
	 * 新业务销售汇总查询
	 */
	public static final String REGISTERNEW_TOTAL = "REGISTERNEW_TOTAL";
	
	/**
	 * 网点明细查询
	 */
	public static final String WAY_DETAILS = "WAY_DETAILS";
	
	/**
	 * 销售汇总查询
	 */
	public static final String SALES_TOTAL = "SALES_TOTAL";
	/**
	 * 销售服务中心查询
	 */
	public static final String SERVCENT_DETAILS = "SERVCENT_DETAILS";
	
    /**
     * 新业务销售明细查询
     */
    public static final String REGISTER_NEW_QUERY="REGISTER_NEW_QUERY";//店员店主
    public static final String MAG_REGISTER_NEW_QUERY="MAG_REGISTER_NEW_QUERY";//经理人员
    /**
     * 套卡销售明细查询
     */
    public static final String REGISTER_SIM_QUERY="REGISTER_SIM_QUERY";//店员店主
    public static final String MAG_REGISTER_SIM_QUERY="MAG_REGISTER_SIM_QUERY";//经理人员
    /**
     * 业务编码查询CH_PW_OPERATIONSMS
     */
    public static final String OPERATION_SMS="OPERATION_SMS";
    /**
     * 人员信息展示-弹出框展示和选择
     */
    public static final String EMPLOYEE_FOE_SELECT="EMPLOYEE_FOE_SELECT";
    /**
     * 套卡销售汇总
     */
    public static final String SALES_CARDSTOTAL="SALES_CARDSTOTAL";
    
    /**
     * 客户质量发展奖励酬金
     */
    public static final String CARDREWDET_QUERY = "CARDREWDET_QUERY";
    
    /**
     * 加载菜单项
     */
    public static final String MENU_LOAD = "MENU_LOAD";
    /**
     * 酬金结果汇总
     */
    public static final String CITYRECORD_STAT = "CITYRECORD_STAT";
    /**
     * 税后酬金查询
     */
    public static final String ADJUMENT_STAT = "ADJUMENT_STAT";
    /**
     * 创新联盟数据业务推荐失败明细查询
     */
    public static final String MIS_UNVRCFAILDAY_QUERY = "MIS_UNVRCFAILDAY_QUERY";
        
    /**
     * 创新联盟数据业务推荐成功明细查询
     */
    public static final String MIS_SUCCESS_QUERY = "MIS_SUCCESS_QUERY";
    //酬金核算成功记录查询
    public static final String MIS_REALTIMESUCC_QUERY="MIS_REALTIMESUCC_QUERY";
    //酬金核算失败记录查询
    public static final String MIS_REALTIMEFAIL_QUERY="MIS_REALTIMEFAIL_QUERY";
    
    /**
	 * 终端计酬成功明细（我的酬金-》终端酬金-》终端计酬成功明细）
	 */
	public static final String REWARDTD_SUC = "REWARDTD_SUC";
	 
	/**
	 * 终端计酬失败明细（我的酬金-》终端酬金-》终端计酬失败明细）
	 */
	public static final String REWARDTD_FAIL = "REWARDTD_FAIL";
	
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
	 * 酬金类型
	 */
	public static final String SADBDICTITEM  = "SADBDICTITEM";

	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》业务明细报表（结算月维度））
	 */
	public static final String SETTLEMENTMONTH = "SETTLEMENTMONTH";
	
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》业务明细报表（销售月维度））
	 */
	public static final String SALEMONTH = "SALEMONTH";
	
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》月度应发酬金报表）
	 */
	public static final String MONTHREMUN = "MONTHREMUN";
	
	/**
	 * 终端预发计酬失败明细（我的酬金-》终端酬金-》业务办理酬金分期表）
	 */
	public static final String REWARDBUSINESS = "REWARDBUSINESS";
	
	/**
	 * 酬金一体化配置（我的酬金-》酬金一体化-》酬金一体化配置）
	 */
	public static final String REWARD_CONFIG = "REWARD_CONFIG";
	
	/**
	 * 酬金一体化管理（我的酬金-》酬金一体化-》酬金一体化管理）
	 */
	public static final String REWARD_MANAGE = "REWARD_MANAGE";
}