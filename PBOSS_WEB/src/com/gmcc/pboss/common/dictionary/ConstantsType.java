package com.gmcc.pboss.common.dictionary;

import com.gmcc.pboss.common.util.JSTLConstants;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：固定参数类型,没有特殊说明的都是从配置文件中取数。
 */
public class ConstantsType extends JSTLConstants {
	/**社会渠道 酬金类型 从数据库中取*/
	public static final String SOCIETY_REWARD_TPYPE = "CH_REWARDTYPE";
	/**网站渠道 酬金类型 从数据库中取*/
	public static final String BBC_REWARD_TPYPE = "CH_BBCREWARDTYPE";
	
	/**社会渠道 酬金校验失效 酬金类型 XML*/
	public static final String SOCIETY_REWARDVERIFIED_TPYPE = "SOCIETY_REWARDVERIFIED_TPYPE";
	/**网站渠道 酬金校验失效 酬金类型 XML*/
	public static final String BBC_REWARDVERIFIED_TPYPE = "BBC_REWARDVERIFIED_TPYPE";
	
	/**社会（网站）渠道 酬金类型-简称 XML*/
	public static final String SOCIETY_REWARD_TPYPE_SHORTNAME = "SOCIETY_REWARD_TPYPE_SHORTNAME";
	/**创新联盟 业务平台来源 XML */
	public static final String CH_UNPB_OSSRC="CH_UNPB_OSSRC";
	
	
	/**21地市名称 XML*/
	public static final String BRANCH_NAME = "BRANCH_NAME";
	/**21地市编码 XML*/
	public static final String BRANCH_NO = "BRANCH_NO";

	/**
	 * 21个地市门户是否开放 XML
	 * 1-开放，0-关闭
	 */
	public static final String ISOPEN = "ISOPEN";
	public static final String ISOPEN_YES = "1";
	public static final String ISOPEN_NO = "0";
	/**
	 * 21个地市门户是否显示酬金模块 XML
	 */
	public static final String CAN_QUERY_REWARD = "CAN_QUERY_REWARD";
	public static final String CAN_QUERY_REWARD_YES = "1";
	public static final String CAN_QUERY_REWARD_NO = "0";
	
	/**21个地市  商品订购是否需要查询资源明细 XML
	 * 1-需要，0-不需要
	 */
	public static final String ISQUERY = "ISQUERY";
	/** 21个地市  商品订购需要查询资源明细
	 * 1-需要
	 */
	public static final String QueryTrue = "1";

	/** 21个地市  商品订购不需要查询资源明细
	 * 0-需要
	 */
	public static final String QueryFlase = "0";

	/**卡类购销划扣银行状态  从数据库中取*/
	public static final String VALIDFLAG = "CH_VALIDFLAG";
	
	/**经营业态 从数据库中取*/
	public static final String FORMTYPE = "CH_FORMTYPE";
	
	/**连锁性质 从数据库中取*/
	public static final String CATETYPE = "CH_CATETYPE";
	
	/**计酬方式 从数据库中取*/
	public static final String ACCTYPE = "CH_ACCTYPE";
	
	/**计酬方式 从数据库中去*/
	public static final String BSACCTYPE = "CH_BSACCTYPE";
	
	/**本地酬金类型 从数据库中去*/
	public static final String REWARDLOCALTYPE = "CH_REWARDLOCALTYPE";
	
	/** 
	 * 本地酬金类型 - 计酬明细报表 
	 */
	public static final String RPWDLocalRPT = "RPWDLocalRPT";
	/** 
	 * 本地酬金类型 - 渠道酬金汇总表
	 */
	public static final String RRWDSumRPT = "RRWDSumRPT";
	
	/**教育水平 从数据库中取*/
	public static String EDULEVEL = "CH_EDULEVEL";
	
	/**性别 从数据库中取*/
	public static final String SEX = "CH_SEX";
	
	/**劳动关系 从数据库中取*/
	public static final String CONTACTTYPE = "CH_CONTACTTYPE";
	
	/**用工性质 从数据库中取*/
	public static String EMPLOYTYPE = "CH_EMPLOYTYPE";
	
	/**用工状态 从数据库中取*/
	public static final String EMPSTATUS = "CH_EMPSTATUS";
	
	/**品牌 从数据库中取*/
	public static final String SIMBRAND = "CH_SIMBRAND";
	
	/**登录方式 从数据库中取*/
	public static final String AUTH_TYPE = "WEB_AUTHTYPE";
	/**
	 * 套卡类型 从数据库中取
	 */
	public final static String IM_COMTYPE = "IM_COMCLASS";
	/**
	 * 套卡类别 从数据库中取
	 */
	public final static String IM_COMTYPE2 = "IM_COMTYPE";
	/**
	 * 套卡登记类型
	 */
	public final static String CH_MFLAG="CH_MFLAG";
	
	
	/**渠道子类别 XML*/
	public static final String WAY_SUB_TYPE="WAY_SUB_TYPE";
	
	/** 一般审核状态 - 0值未审批  */
	public static final Byte AUDITSTATUS_NO = new Byte("0");
	
	/**未发布状态*/
	public static final Long UNPUBLISH = new Long(1);
	
	//提交动作
	/**
	 * 提交动作 - ADD
	 */
	public static final String ACTION_ADD="ADD";
	/**
	 * 提交动作 - UPDATE
	 */
	public static final String ACTION_UPDATE="UPDATE";
	
	
	//处理工单表CH_PW_AUDITWORK
	/**
	 *单类型 - AUDITWORK 处理工单表 - 注册
	 */
	public static final String AUDITWORKTYPE_WAYADD = "WAY_ADD_AUDIT";
	/**
	 *单类型 - AUDITWORK 处理工单表 - 网点资料查询与修改申请
	 */
	public static final String AUDITWORKTYPE_WAYUPDATE = "WAY_UPDATE_AUDIT";
	/**
	 *单类型 - AUDITWORK 处理工单表 - 网点退出
	 */
	public static final String AUDITWORKTYPE_WAYREMOVE = "WAY_REMOVE_AUDIT";
	/**
	 *单类型 - AUDITWORK 处理工单表 -店员更新
	 */
	public static final String AUDITWORKTYPE_EMPLOYEEUPDATE = "EMPLOYEE_UPDATE_AUDIT";
	/**
	 *单类型 - AUDITWORK 处理工单表 -店员加入
	 */
	public static final String AUDITWORKTYPE_EMPLOYEEADD = "EMPLOYEE_ADD_AUDIT";
	/**
	 *单类型 - AUDITWORK 处理工单表 -店员退出
	 */
	public static final String AUDITWORKTYPE_EMPLOYEEREMOVE = "EMPLOYEE_REMOVE_AUDIT";
	/**
	 * 当前步骤 - AUDITSTEPID 处理工单表 -注册
	 */
	public static final String AUDITSTEPID_WAY_ADD1 = "WAY_ADD_AUDIT1";
	/**
	 * 当前步骤 - AUDITSTEPID 处理工单表 -网点资料查询与修改申请
	 */
	public static final String AUDITSTEPID_WAY_UPDATE1 = "WAY_UPDATE_AUDIT1";
	/**
	 * 当前步骤 - AUDITSTEPID 处理工单表 -网点退出
	 */
	public static final String AUDITSTEPID_WAY_REMOVE1 = "WAY_REMOVE_AUDIT1";
	/**
	 * 当前步骤 - AUDITSTEPID 处理工单表 -店员加入
	 */
	public static final String AUDITSTEPID_EMPLOYEEADD1 = "EMPLOYEE_ADD_AUDIT";
	/**
	 * 当前步骤 - AUDITSTEPID 处理工单表 -店员资料修改申请
	 */
	public static final String AUDITSTEPID_EMPLOYEEUPDATE1 = "EMPLOYEE_UPDATE_AUDIT";
	/**
	 * 当前步骤 - AUDITSTEPID 处理工单表 -店员退出
	 */
	public static final String AUDITSTEPID_EMPLOYEEREMOVE1 = "EMPLOYEE_REMOVE_AUDIT";
	/**
	 * 销售报表 - 查询子表类型 - 订购资源明细
	 */
	public static final String SALES_SELECTYPE_RESDETS = "RESDETS";
	/**
	 * 销售报表 - 查询子表类型 - 订购商品种类
	 */
	public static final String SALES_SELECTYPE_COMCATE = "COMCATE";
	/**
	 * 在线问答 - 我的提问 - 提问状态 XML
	 */
	public static final String QUESTION_STATE = "QUESTION_STATE";
	
	/**
	 * 充值卡 COMRESCARD
	 */
	public static final String COMRESCARD = "COMRESCARD";
	/**
	 * 套卡 COMRESSMP
	 */
	public static final String COMRESSMP = "COMRESSMP";
	
	/**
	* 空白SIM卡 COMRESSMP
	*/
	public static final String EMPTYSIM = "EMPTYSIM";
	
	//订单订购类型
	/**
	 * 订购类型 - 客户订购 
	 */
	public static final String ORDERCOMTYPE_CUSTORDER = "CUSTORDER";
	/**
	 * 订购类型 - 系统赠送
	 */
	public static final String ORDERCOMTYPE_SYSGIFT = "SYSGIFT";
	/**
	 * 订购类型 - 系统搭售
	 */
	public static final String ORDERCOMTYPE_SYSTIEIN = "SYSTIEIN";
	
	/**
	 * 渠道星级
	 */
	public static final String STARLEVEL = "CH_STARLEVEL";
	

	/**
	 * 配送单状态 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String DISSTATE = "FX_DISFORMSTATE";
	
	/**
	 * 配送单固定状态 - 待发货
	 */
	public final static String DISSTATE_WAITOUT = "WAITOUT";
	/**
	 * 配送单固定状态 - 待配送
	 */
	public final static String DISSTATE_WAITDIS = "WAITDIS";
	/**
	 * 配送单固定状态 - 配送中	
	 */
	public final static String DISSTATE_DISING= "DISING";
	/**
	 * 配送单固定状态 - 配送完成
	 */
	public final static String DISSTATE_DISOVER = "DISOVER";
	/**
	 * 配送单固定状态 - 作废
	 */
	public final static String DISSTATE_CANCEL = "CANCEL";
	/**
	 * 短信确认类型
	 */
	public final static String FX_SMSCONTYPE = "FX_SMSCONTYPE";
	/**
	 * 短信确认类型 - 订购确认
	 */
	public final static String FX_SMSCONTYPE_ORDERCON = "ORDERCON";
	/**
	 * 短信确认类型 - 合作商签收
	 */
	public final static String FX_SMSCONTYPE_PARSIGN = "PARSIGN";
	/**
	 * 短信回复状态
	 */
	public final static String FX_SMSREPSTATE = "FX_SMSREPSTATE";
	/**
	 * 短信回复状态 - 待回复
	 */
	public final static String FX_SMSREPSTATE_WAITREP = "WAITREP";
	/**
	 * 短信回复状态 - 已回复
	 */
	public final static String FX_SMSREPSTATE_REPLIED = "REPLIED";
	/**
	 * 订单状态 - WAITCON 待确认
	 */
	public final static String ORDERSTATE_WAITCON = "WAITCON";
	/**
	 * 订单状态 - CANCEL 作废
	 */
	public final static String ORDERSTATE_CANCEL = "CANCEL";
	/**
	 * 订单是否确认 -- 否标志
	 */
	public final static Short Confirmflag_NO = 0;
	/**
	 * 订单是否确认 -- 是标志
	 */
	public final static Short Confirmflag_YES = 1;
	/**
	 * 社会渠道 酬金类型 客户质量发展酬金 
	 */
	public final static String CH_REWARD_TYPE = "CH_REWARD_TYPE";
	/**
	 * 推广专员-成员属性
	 */
	public final static String CH_EMPATTR2 = "CH_EMPATTR2";
}