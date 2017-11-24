package com.sunrise.boss.business.resmanage.common.pubdef;


/**
 * <p>
 * 资源固定参数常量
 * </p>
 * 命名主要参照BOSS1.0
 */

public class ResConstant {
	public static final String DEFINITION_FILE_PATH = "/com/sunrise/boss/ui/resmanage/common/definition.xml";
	public static final String EXCELOUT_FILE_PATH = "/com/sunrise/boss/resource/excelout/excelout.xml";
	public static final String DEFINITION_IMPLEMENT_PREFIX = "com.sunrise.boss.ui.resmanage.common.definition.impl.";
	public static final String Excelout_IMPLEMENT_PREFIX ="com.sunrise.boss.ui.resmanage.common.excelout.impl.";
	public static final String RESCOMMONCHK_FILE_PATH = "/com/sunrise/boss/resource/rescommonchk/rescommonchk.xml";
	public static final String FILEDEF_FILE_PATH = "/com/sunrise/boss/resource/filedef/filedef.xml";
	/**
	 * 卡商CX1
	 */
	public static final Long CARDMILL_SEHUMBERGER = new Long(0);// Sehumberger(斯伦贝谢)
	public static final Long CARDMILL_GEMPLUS = new Long(1);// Gemplus(金普斯)
	public static final Long CARDMILL_WHTIANYU = new Long(2);// 武汉天喻
	public static final Long CARDMILL_JXJIEDE = new Long(3);// 江西捷德
	public static final Long CARDMILL_DXHEPING = new Long(4);// 东信和平
	public static final Long CARDMILL_DTDIANXIN = new Long(5);// 大唐电信
	public static final Long CARDMILL_HTJIUZHOUTONG = new Long(6);// 航天九州通
	public static final Long CARDMILL_BJWOQI = new Long(7);// 北京握奇
	public static final Long CARDMILL_DFYINGKA = new Long(8);// 东方英卡
	public static final Long CARDMILL_HUANGHONG = new Long(9);// 华虹
	public static final Long CARDMILL_SHKESI = new Long(10);// 上海柯斯(ICCID代码中用A表示)
	public static final Long CARDMILL_HTZHITONG = new Long(11);// 航天智通(ICCID代码中用B表示)

	
	/**
	 * 资源类型CX2
	 */
	public static final Long RESTYPE_SIMCARD = new Long(100);// SIM卡
	public static final Long RESTYPE_NUMBER = new Long(101);// 号码
	public static final Long RESTYPE_INVOICE = new Long(102);// 发票
	public static final Long RESTYPE_JFCARD = new Long(103);// 积分卡
	public static final Long RESTYPE_GIFTRES = new Long(104);// 礼品资源
	public static final Long RESTYPE_OTHERRES = new Long(105);// 非商品类其他资源
	public static final Long RESTYPE_TERMINALINF = new Long(106);// 终端信息
	public static final Long RESTYPE_GROUPSERIAL = new Long(107);// 集团编号
	//空中选号新增
	public static final Long RESTYPE_EMPTYSIMCARD = new Long(110);// 空白SIM卡
	
	
	/**
	 * 商品类型CX3
	 */
	public static final Long COMTYPE_AOC_CHUZHICARD = new Long(1);// AOC储值卡
	public static final Long COMTYPE_SHENZHOUDAZHONGCARD = new Long(2);// 神州大众卡
	public static final Long COMTYPE_SHENZHOUXING_CHONGZHICARD = new Long(3);// 神州行充值卡
	public static final Long COMTYPE_YIXING_IPCHONGZHICARD = new Long(4);// 异型IP充值卡
	public static final Long COMTYPE_QUANQIUTONG_CHONGZHICARD = new Long(5);// 全球通充值卡
	public static final Long COMTYPE_LOCAL_IPCHONGZHICARD = new Long(6);// 本地IP充值卡
	public static final Long COMTYPE_IPJIZHANGCARD = new Long(7);// IP记帐卡
	public static final Long COMTYPE_IPCHONGZHICARD = new Long(8);// IP充值卡
	public static final Long COMTYPE_QUANQIUTONG_JIAOFEICARD = new Long(9);// 全球通缴费卡
	public static final Long COMTYPE_IPGUOJIMANYOUCARD = new Long(10);// IP国际漫游卡
	public static final Long COMTYPE_MOBILEPHONE = new Long(11);// 手机
	public static final Long COMTYPE_SUI_E_XING = new Long(12);// 随e行
	public static final Long COMTYPE_SHENZHOUXING_TAOCARD = new Long(13);// 神州行套卡
	public static final Long COMTYPE_MZONECARD = new Long(14);// 动感地带卡
	public static final Long COMTYPE_MOBILE_EARPHONE = new Long(15);// 手机耳机
	public static final Long COMTYPE_MOBILE_CELL = new Long(16);// 手机电池
	public static final Long COMTYPE_MOBILE_SHEATH = new Long(17);// 手机皮套
	public static final Long COMTYPE_WIRELESSCARD = new Long(18);// 无线上网卡
	public static final Long COMTYPE_ELETRI_CHONGZHIJUAN = new Long(19);// 电子充值券
	public static final Long COMTYPE_HUIGE_DAZHONGCARD = new Long(20);// 回割大众卡
	public static final Long COMTYPE_MOBILE_CHONGZHICARD = new Long(21);// 手机充值卡
	public static final Long COMTYPE_HK_IPCARD = new Long(22);// 香港IP电话卡
	public static final Long COMTYPE_DIAMONDCARD = new Long(23);// 钻石卡
	public static final Long COMTYPE_GOLDENCARD = new Long(24);// 金卡
	public static final Long COMTYPE_SILVERCARD = new Long(25);// 银卡
	public static final Long COMTYPE_VIPCARD = new Long(26);// 贵宾卡
	public static final Long COMTYPE_JIFENCARD = new Long(27);// 积分卡
	public static final Long COMTYPE_MOBILE_MEMBERCARD = new Long(28);// 手机会员卡
	public static final Long COMTYPE_DONGLI100_DATACARD = new Long(29);// 动力100数据卡
	public static final Long COMTYPE_INFO_EQUIPMENT = new Long(30);// 信息设备
	public static final Long COMTYPE_MOBILE_CHONGZHIJUAN = new Long(31);// 手机充值券包资源
	public static final Long COMTYPE_OTHER = new Long(99);// 其他
	

	/**
	 * SIM卡状态CX4(与后台进行统一 jiaofl 2009-05-19)
	 */
	public static final Long SIMSTATE_NOPUTIN = new Long(0);// 未投放
	public static final Long SIMSTATE_RESERVE = new Long(1);// 预订
	public static final Long SIMSTATE_USING = new Long(2);// 已使用
	public static final Long SIMSTATE_LOST = new Long(3);// 丢失
	public static final Long SIMSTATE_BROKEN = new Long(4);// 损坏
	public static final Long SIMSTATE_CANUSE = new Long(5);// 可用
	public static final Long SIMSTATE_FORBIDUSE = new Long(6);// 禁用
	public static final Long SIMSTATE_REVOKE = new Long(8);// 作废
	public static final Long SIMSTATE_SENDING = new Long(11);// 配送中
	public static final Long SIMSTATE_BACK = new Long(12);// 退仓
	public static final Long SIMSTATE_RECYCLING = new Long(16);// 回收中(配送流程)
	public static final Long SIMSTATE_LOSE = new Long(17);// 盘亏
	public static final Long SIMSTATE_DESTORY = new Long(18);// 损毁报废
	public static final Long SIMSTATE_SURPLUSLOAD = new Long(19);// 盘盈入库
	public static final Long SIMSTATE_LOCKED = new Long(21);// 锁定
	public static final Long SIMSTATE_NOCARDWEITOU = new Long(22);// 非实体卡可用
	public static final Long SIMSTATE_NOCARDINUSED = new Long(23);// 非实体卡已使用
	public static final Long SIMSTATE_NOCARDDISUSE = new Long(24);// 非实体卡作废
	
	
	/**
	 * 空白SIM卡状态(与后台进行统一 jiaofl 2009-05-19)
	 */
	public static final Long EMPTYSIMSTATE_PUTIN = new Long(0);// 空白卡入库
	public static final Long EMPTYSIMSTATE_TMPCHOOSE = new Long(1);// 暂选
	public static final Long EMPTYSIMSTATE_WRITERSUCCESS = new Long(2);// 写卡成功
	public static final Long EMPTYSIMSTATE_LOST = new Long(3);// 丢失
	public static final Long EMPTYSIMSTATE_WRITERFAIL = new Long(4);// 写卡作废
	public static final Long EMPTYSIMSTATE_CANUSE = new Long(5);// 可用空白卡
	public static final Long EMPTYSIMSTATE_SOLD = new Long(10);// 已售
	public static final Long EMPTYSIMSTATE_SENDING = new Long(11);// 配送中
	public static final Long EMPTYSIMSTATE_BACK= new Long(12);// 退仓
	public static final Long EMPTYSIMSTATE_RECYCLING= new Long(16);// 回收中(配送流程)
	
	
	/**
	 * 号码状态CX5
	 */
	public static final Long CALLSTATE_ONSALE = new Long(0);// 可售号
	public static final Long CALLSTATE_RESERVE = new Long(1);// 预订号
	public static final Long CALLSTATE_USING = new Long(2);// 已使用
	public static final Long CALLSTATE_CHGNO = new Long(3);// 改号态
	public static final Long CALLSTATE_KEEP = new Long(4);// 预留号
	public static final Long CALLSTATE_FORBID = new Long(5);// 禁售号
	public static final Long CALLSTATE_HALFSTOP = new Long(6);// 半停
	public static final Long CALLSTATE_STOP = new Long(7);// 停机
	public static final Long CALLSTATE_PREDEL = new Long(8);// 预销号
	public static final Long CALLSTATE_DEL = new Long(9);// 被销号
	public static final Long CALLSTATE_NOPUT = new Long(10);// 未投放
	public static final Long CALLSTATE_TMPCHOOSE = new Long(11);// 暂选
	public static final Long CALLSTATE_RECYCLE = new Long(12);// 回收
	
	
	/**
	 * 商品状态CX6
	 */
	public static final Long COMSTATE_FORBID = new Long(0);// 不可售
	public static final Long COMSTATE_ONSALE = new Long(1);// 可售
	public static final Long COMSTATE_SOLD = new Long(2);// 已售
	public static final Long COMSTATE_REVOKE = new Long(3);// 损坏作废
	public static final Long COMSTATE_DELSTOP = new Long(4);// 已销户
	public static final Long COMSTATE_RESERVE = new Long(5);// 预订
	public static final Long COMSTATE_DAISHOU = new Long(6);// 代售中
	public static final Long COMSTATE_DECODEFAIL = new Long(7);// 解密失败
	public static final Long COMSTATE_PRINTFAIL = new Long(8);// 打印失败
	public static final Long COMSTATE_PACKAGE = new Long(9);// 打包态
	public static final Long COMSTATE_FETCH = new Long(10);// 抽取态
	public static final Long COMSTATE_SENDING = new Long(11);// 配送中
	public static final Long COMSTATE_BACK = new Long(12);// 退仓
	public static final Long COMSTATE_BACKED = new Long(13);// 已退
	public static final Long COMSTATE_WAITSALE = new Long(14);// 待售
	public static final Long COMSTATE_WANE = new Long(15);// 盘亏
	public static final Long COMSTATE_RECYCLING = new Long(17);// 回收中
	
	/**
	 * SIM卡类型CX7
	 */
	public static final Long SIMTYPE_8K_NORMALCARD = new Long(0);// 8K普通卡
	public static final Long SIMTYPE_16K_NORMAILCARD = new Long(1);// 16K普通卡
	public static final Long SIMTYPE_16K_STK = new Long(2);// 16K STK
	public static final Long SIMTYPE_32K_STK = new Long(3);// 32K STK
	public static final Long SIMTYPE_32K_LICAITONG = new Long(4);// 32K理财通
	public static final Long SIMTYPE_DOUBLENO = new Long(5);// 一卡双号
	public static final Long SIMTYPE_MZONE = new Long(6);// 动感地带
	public static final Long SIMTYPE_16K_BIGCAPACITY = new Long(7);// 16K大容量
	public static final Long SIMTYPE_GUANGDONG_DYNAMIC = new Long(8);// 广东动态
	public static final Long SIMTYPE_SHENZHEN_DYNAMIC = new Long(9);// 深圳动态
	public static final Long SIMTYPE_8K_SHENZHOUXING = new Long(10);// 8K神州行
	public static final Long SIMTYPE_16K_DAZHONGCARD = new Long(11);// 16K大众卡
	public static final Long SIMTYPE_SUI_E_XING = new Long(12);// 随e卡
	public static final Long SIMTYPE_16K_SHENZHOUXING = new Long(13);// 16K神州行
	public static final Long SIMTYPE_32K_SHENZHOUXING = new Long(14);// 32K神州行
	public static final Long SIMTYPE_16K_LICAITONG = new Long(15);// 16K理财通
	public static final Long SIMTYPE_16K_MUTILNO = new Long(16);// 16K一卡多号(即粤港一卡多号)
	public static final Long SIMTYPE_32K_MUTILNO = new Long(17);// 32K一卡多号(即粤港一卡多号)
	public static final Long SIMTYPE_WIB = new Long(18);// WIB(一种可以动态下载手机菜单的卡)
	public static final Long SIMTYPE_64K_CARD = new Long(19);// 64K 卡（广州） 32K
																// OTA（清远，其它地区没有）
	public static final Long SIMTYPE_AIR_STK = new Long(20);// 空中充值STK
	public static final Long SIMTYPE_64K_WIB = new Long(21);// 64KWIB
	public static final Long SIMTYPE_64K_DOUBLENO = new Long(22);// 64K一卡双号
	public static final Long SIMTYPE_16K_SHENZHOUXING_PRECARD = new Long(23);// 16K神州行预制卡
	public static final Long SIMTYPE_32K_QUANQIUTONG_PRECARD = new Long(24);// 32K全球通预制卡
	public static final Long SIMTYPE_32K_MZONE_PRECARD = new Long(25);// 32K动感预制卡
	public static final Long SIMTYPE_QUANQIUTONG_EMPTYSIM = new Long(26);// 全球通空白SIM卡
	public static final Long SIMTYPE_DOUBLENO_EMPTYSIM = new Long(27);// 一卡双号空白SIM卡
	public static final Long SIMTYPE_MZONE_EMPTYSIM = new Long(28);// 动感地带空白SIM卡
	public static final Long SIMTYPE_SHENZHOUXING_EMPTYSIM = new Long(29);// 神州行空白SIM卡
	public static final Long SIMTYPE_128K_CARD = new Long(30);// 128K
																// 卡（广州有，其它地区没有）
	public static final Long SIMTYPE_32K_DAZHONGCARD = new Long(31);// 32K大众卡（新增）
	public static final Long SIMTYPE_64K_MZONE = new Long(32);// 64K动感卡
	public static final Long SIMTYPE_USIM = new Long(60);// USIM卡
	public static final Long SIMTYPE_64K_ZHUANSHU = new Long(61);// 全球通专属SIM卡(64K)
	public static final Long SIMTYPE_DONGLI100_DATACARD = new Long(62);// 动力100数据卡
	public static final Long SIMTYPE_64K_SHENZHOUXING = new Long(63);// 64K神州行
																		// sim卡
	public static final Long SIMTYPE_64K_MZONESIM = new Long(64);// 64K动感
																	// sim卡
	public static final Long SIMTYPE_128K_MZONESIM = new Long(65);// 128K动感
																	// sim卡
	public static final Long SIMTYPE_128K_DAZHONGSIM = new Long(66);// 128K大众卡
																	// sim卡
	public static final Long SIMTYPE_128K_SHENZHOUXINGSIM = new Long(67);// 128K神州行
																			// sim卡
	public static final Long SIMTYPE_64K_SHENZHOUXING51YUAN = new Long(68);// 神州行64K
																			// 51元SIM卡
	public static final Long SIMTYPE_64K_SHENZHOUDAZHOU51YUAN = new Long(69);// 神州大众卡64K
																				// 51元SIM卡
	public static final Long SIMTYPE_64K_MZONE20YUAN = new Long(70);// 动感地带64K
																	// 20元SIM卡

	
	/**
	 * 积分卡资源状态CX8
	 */
	public static final Long JFCARDSTATE_NOUSE = new Long(0);// 不可用
	public static final Long JFCARDSTATE_CANUSE = new Long(1);// 可使用
	public static final Long JFCARDSTATE_USING = new Long(2);// 正使用
	public static final Long JFCARDSTATE_CHANGED = new Long(3);// 已换卡
	public static final Long JFCARDSTATE_REVOKE = new Long(4);// 已作废
	public static final Long JFCARDSTATE_SENDING = new Long(5);// 配送中
	public static final Long JFCARDSTATE_RECYCLING = new Long(6);// 回收中
	
	
	/**
	 * 主副号标志CX12
	 */
	public static final Long NOATTRIBUTE_NORMALNO = new Long(0);// 普通(缺省值)
	public static final Long NOATTRIBUTE_PRIMARYNO = new Long(1);// 主号
	public static final Long NOATTRIBUTE_DOUBLENO = new Long(2);// 一卡双号副号
	public static final Long NOATTRIBUTE_BUNDLE = new Long(3);// 捆绑关系副号
	
	
	/**
	 * 资源操作动作CX19
	 */
	public static final Long RESOPRTYPE_PUTINDB = new Long(0);// 入库
	public static final Long RESOPRTYPE_DISTRIB = new Long(1);// 发放
	public static final Long RESOPRTYPE_RECYCLE = new Long(2);// 回收
	public static final Long RESOPRTYPE_DEL = new Long(3);// 删除
	public static final Long RESOPRTYPE_STATECHANGE = new Long(4);// 状态修改
	public static final Long RESOPRTYPE_SENDING = new Long(5);// 配送
	public static final Long RESOPRTYPE_PROPERTYCHANGE = new Long(6);// 属性修改　--2009.02.26前后台"属性修改"操作动作统一为6
	public static final Long RESOPRTYPE_WANE = new Long(7);// 盘亏
	public static final Long RESOPRTYPE_DAMAGE = new Long(8);// 毁损报废
	public static final Long RESOPRTYPE_CC = new Long(9);// 出仓
	public static final Long RESOPRTYPE_TC = new Long(10);// 退仓
	public static final Long RESOPRTYPE_JJ = new Long(11);// 交接
	public static final Long RESOPRTYPE_JieShou = new Long(12);// 接收
	public static final Long RESOPRTYPE_JuShou = new Long(13);// 拒收
	public static final Long RESOPRTYPE_TuiChangJieShou = new Long(14);// 退仓接收
	public static final Long RESOPRTYPE_ZhaoHui = new Long(15);// 招回
	
	/**
	 * 操作成功/失败标识
	 */
	public static final Long OPERATE_SUCCESS = new Long(1);
	public static final Long OPERATE_FAIL = new Long(0);
	
	
	/**
	 * 最大数量
	 */
	public static final int MAX_SIZE = 100000;
	
	
	/**
	 * 主副号标志
	 */
	public static final Long NO_TYPE_NORMAL = new Long(0);// 普通(缺省值)
	public static final Long NO_TYPE_HOST = new Long(1);// 主号
	public static final Long NO_TYPE_DEPUTY = new Long(2);// 副号
	public static final Long NO_TYPE_BIND = new Long(3);// 捆绑副号
	
	
	/**
	 * IMSI使用状态CX42
	 */
	public static final Long IMSISTATE_NOTUSE = new Long(0);// 未用
	public static final Long IMSISTATE_RESERVE = new Long(1);// 预订
	public static final Long IMSISTATE_WAITACTIVATE = new Long(2);// 待激活
	public static final Long IMSISTATE_ACTIVATE = new Long(3);// 激活
	public static final Long IMSISTATE_FORBID = new Long(4);// 禁用
	public static final Long IMSISTATE_REVOKE = new Long(5);// 作废
	public static final Long IMSISTATE_RECYCLE2EKI = new Long(6);// 已经回收EKI
	
	/**
	 * 商品类别
	 */
	public static final Long COMCLASS_GUACARD = new Long(0);// 刮卡类
	public static final Long COMCLASS_MOBILEPHONE = new Long(1);// 手机类
	public static final Long COMCLASS_PHONEFITTINGS = new Long(2);// 手机配件类
	public static final Long COMCLASS_SMP = new Long(3);// SIM套卡类
	public static final Long COMCLASS_ECHONGZHI = new Long(4);// 电子充值券
	public static final Long COMCLASS_OTHER = new Long(99);// 其他
	
	/**
	 * 使用状态
	 */
	public static final Long USESTATE_CANUSE = new Long(1);// 可用
	public static final Long USESTATE_FORBID = new Long(0);// 禁用
	
	/**
	 * 台帐参数
	 */
	public static final Long SHEETSTATE_CREATED = new Long(0);// 流通单状态:已生成
	public static final Long SHEETSTATE_COMPLETED = new Long(1);// 流通单状态:已完成
	public static final Long SHEETSTATE_NEEDCONFIRM = new Long(2);// 流通单状态:待确认
	public static final Long SHEETSTATE_CANCELED = new Long(3);// 流通单状态:已撤单
	public static final Long SHEETSTATE_REGISTERED = new Long(4);// 流通单状态:已登记
	public static final Long SHEETSTATE_PARTCOMPLETED= new Long(5);// 流通单状态:部分完成
	public static final Long SHEETSTATE_FAILED= new Long(6);// 流通单状态:处理失败
	public static final Long SHEETSTATE_CONFIRMED= new Long(7);// 流通单状态:已确认
	
	public static final Long SHEETTYPE_CC = new Long(0);// 流通单类型:出仓单
	public static final Long SHEETTYPE_TC = new Long(1);// 流通单类型:退仓单
	public static final Long SHEETTYPE_JJ = new Long(2);// 流通单类型:交接单
	
	public static final Long SHEETRESTYPE_SIM = new Long(0);// 流通单资源类型:Sim卡
	public static final Long SHEETRESTYPE_VIPCARD = new Long(1);// 流通单资源类型:积分卡
	public static final Long SHEETRESTYPE_COM = new Long(2);// 流通单资源类型:商品
	public static final Long SHEETRESTYPE_EMPTYSIM = new Long(3);// 流通单资源类型:空白SIM卡
	
	public static final Long HASPRINTED_YES = new Long(1);// 流通单是否打印:已打印
	public static final Long HASPRINTED_NO = new Long(0);// 流通单是否打印:未打印
	
	public static final Long RESACTION_SYSTEM = new Long(3);// 操作动作：3系统操作
	
	public static final Short AUDITSATE_NEEDAUDIT = new Short("1");//审核状态:待审核
	public static final Short AUDITSATE_REJECT = new Short("0");//审核状态:审核不通过
	public static final Short AUDITSATE_NEEDCONFIRM = new Short("2");//审核状态:待确认
	public static final Short AUDITSATE_CONFIRMED = new Short("3");//审核状态:已确认
	
	public static final Short AUDITOPRTYPE_REJECT = new Short("0");//审核操作类型:不通过审核
	public static final Short AUDITOPRTYPE_PERMIT = new Short("1");//审核操作类型:通过审核
	public static final Short AUDITOPRTYPE_CONFIRM = new Short("2");//审核操作类型:确认
	
	public static final Long AUDITFLAG_START = 	new Long("1");//台帐电子签收启动标志:启用
	public static final Long AUDITFLAG_STOP = 	new Long("0");//台帐电子签收启动标志:停用
	public static final Long AUDITFLAG_PARAM = new Long("50");//电子签收启动标志系统参数
	/**
	 * 票据状态
	 */
	public static final Long BILLSTATE_NOPUTIN = new Long(0); // 未投放
	public static final Long BILLSTATE_CANUSE = new Long(1); // 可使用
	public static final Long BILLSTATE_USING = new Long(2); // 已使用
	public static final Long BILLSTATE_REDBILL = new Long(3); // 红票
	public static final Long BILLSTATE_LOST = new Long(4); // 遗失
	public static final Long BILLSTATE_REVOKE = new Long(5); // 作废
	public static final Long BILLSTATE_HXIAO = new Long(6); // 核销
	public static final Long BILLSTATE_JXIAO = new Long(7); // 缴销
	public static final Long BILLSTATE_HPZMP = new Long(8); // 红票证明票

	/**
	 * 配送单状态
	 */
	
	public static final Long SENDSTATE_WeiJieShou = new Long(0);// 未接收
	public static final Long SENDSTATE_YiJieShou = new Long(1);// 已接收
	public static final Long SENDSTATE_JuShou = new Long(2);// 拒收
	public static final Long SENDSTATE_ZhaoHui = new Long(3);// 招回
	public static final Long SENDSTATE_TuiChangJieShou = new Long(4);// 退仓接收
	
	/**
	 * 电子充值卷参数
	 */
	public static final Long FTPSERVER_URL = new Long(24);
	public static final Long REMOTE_TICKETPACKAGEFILE_DIR = new Long(22);
	
	/**
	 * 资源调拨状态
	 */
	public static final Long RECSTATE_NORECEPT = new Long(0);// 待签收
	public static final Long RECSTATE_DONE = new Long(1);// 已完成
	public static final Long RECSTATE_BACK = new Long(2);// 退回待核

	/**
	 * 调拔资源类型
	 */
	public static final Long IM_RESOURCETYPE_SIM = new Long(0); //SIM卡
	public static final Long IM_RESOURCETYPE_NORES = new Long(1); //号码
	public static final Long IM_RESOURCETYPE_SANHAO = new Long(10); //散号
	public static final Long IM_RESOURCETYPE_COMRESPACKAG = new Long(104); //商品资源包
	public static final Long IM_RESOURCETYPE_BILLRES = new Long(2); // 发票
	public static final Long IM_RESOURCETYPE_COMRES = new Long(3); // 商品
	public static final Long IM_RESOURCETYPE_CZCARD = new Long(301); // 充值卡
	public static final Long IM_RESOURCETYPE_SMP = new Long(302); // 套卡
	public static final Long IM_RESOURCETYPE_PHONE = new Long(303); // 手机
	public static final Long IM_RESOURCETYPE_OTHERCOMRES = new Long(304); // 商品扩展资源
	public static final Long IM_RESOURCETYPE_VIPCARD = new Long(4); // VIP卡
	public static final Long IM_RESOURCETYPE_IMSIRES = new Long(5); // IMSI
	public static final Long IM_RESOURCETYPE_EMPTYSIM = new Long(6); // 空白SIM卡
	public static final Long IM_RESOURCETYPE_PHONEMEMBERCARD = new Long(7); // 手机会员卡
	public static final Long IM_RESOURCETYPE_OTHERRES = new Long(99); // 其他
	
	/**
	 * 审批状态
	 */
	public static final Short CHKSTATE_Wait = new Short((short)1); //待审批
	public static final Short CHKSTATE_Pass = new Short((short)2); //已审批
	public static final Short CHKSTATE_Reject = new Short((short)3); //审批不通过
	public static final Short CHKSTATE_AllSuccess = new Short((short)4); //全部成功
	public static final Short CHKSTATE_PartlySuccess = new Short((short)5); //部分成功
	public static final Short CHKSTATE_AllFailed = new Short((short)6); //全部失败
	
	/**
	 * 集团编号状态  
	 */
	public static final Short GROUPSERIALSTATE_NOPUTIN = new Short((short)0); //未投放
	public static final Short GROUPSERIALSTATE_CANSELL = new Short((short)1); //可售号
	public static final Short GROUPSERIALSTATE_USED = new Short((short)2); //已使用
	public static final Short GROUPSERIALSTATE_CANCEL = new Short((short)3); //被销号
	
	//令牌值
	public static final String Right_RecordBillUseWayNoCheck = "1A2BC0_WayNoCheck";//票据录入时，不检查渠道，操作员可录入任何渠道的票据
	
	public static final String Right_ChgNofee = "1A2B1A10_NOFEECHG"; //修改选号费控制令牌
	
	public static final String Right_ShowSelfWayNO = "1A2B1AM0_SHOWSELFWAYNO"; //选号屏查询属性设置“是否显示本渠道号码”的修改功能
	public static final String Right_ShowAllWayid = "1A2B1AM0_SHOWALLWAYID"; //选号屏查询属性设置-显示所有渠道
	
	//系统参数值
	public static final Long SysParam_RecParam = new Long(25); //调拔签收流程所用参数值
	public static final Long SysParam_BatchFileFTP = new Long(32); //批量文件处理FTP主机参数值
	public static final Long SysParam_BatchFileDir = new Long(33); //批量处理文件目录
	
	//CMS
	public static final Long CARDRESMANAGE_NORES_DIR = new Long(51); //服务器上存放文号码卡文件的目录
	public static final Long CARDRESMANAGE_SIM_DIR = new Long(52); //服务器上存放文SIM卡文件的目录
	public static final Long CARDRESMANAGE_COMRESSMP_DIR = new Long(53); //服务器上存放套卡文件的目录
	public static final Long CARDRESMANAGE_COMRESCARD_DIR = new Long(54); //服务器上存放充值卡文件的目录
	public static final Long CARDRESMANAGE_IMSI_DIR = new Long(55); //服务器上存放IMSI文件的目录
	
	//集团号码规则例外号码类型
	public static final Long IGNORERULE_NOTTYPES = new Long(56);
	
	/**
	 * 电子交接参数定义
	 */
	//电子交接启停标识参数
	public static final Long ETRANSFLAG_START = new Long(1);
	public static final Long ETRANSFLAG_STOP = new Long(0);
	public static final Long ETRANSFLAG_SYSPARAM = new Long(57);
	//资源新增状态（库存态，适用于套卡，SIM卡，空白SIM卡，冲值卡，积分卡，手机,其它商品资源）
	public static final Long ETRANSSTATE_TOBEAUDITED = new Long(25);	//资源待审核状态
	public static final Long ETRANSSTATE_TOBERECEIVED = new Long(26);	//资源待接收状态
	public static final Long ETRANSSTATE_TOBESALED = new Long(27);		//资源待销售状态
	public static final Long ETRANSSTATE_TOBEBACKED = new Long(28);		//资源待回退状态(回退待审核)
	public static final Long ETRANSSTATE_BACKTOBERECEIVED = new Long(29);//资源回退待接收状态
	//im_wl_applyreq表登记的操作动作
	public static final Short ETRANSOPRTYPE_DIS = new Short((short)0);				//发放
	public static final Short ETRANSOPRTYPE_BACK = new Short((short)1);				//回退
	public static final Short ETRANSOPRTYPE_DISREC = new Short((short)2);			//发放接收一台清
	public static final Short ETRANSOPRTYPE_AUDITPASS = new Short((short)3);		//审核通过
	public static final Short ETRANSOPRTYPE_AUDITREJECT = new Short((short)4);		//审核不通过
	public static final Short ETRANSOPRTYPE_RECPASS = new Short((short)5);			//接收通过
	public static final Short ETRANSOPRTYPE_RECREJECT = new Short((short)6);		//接收不通过
	public static final Short ETRANSOPRTYPE_BACKAUDITPASS = new Short((short)7);	//回退审核通过
	public static final Short ETRANSOPRTYPE_BACKAUDITREJECT = new Short((short)8);	//回退审核不通过
	public static final Short ETRANSOPRTYPE_BACKREC = new Short((short)9);			//回退接收通过
	public static final Short ETRANSOPRTYPE_BACKRECREJECT = new Short((short)10);	//回退接收不通过
	//资源类型
	public static final Long ETRANSRESTYPE_SIM = new Long(0);		//Sim卡
	public static final Long ETRANSRESTYPE__VIPCARD = new Long(1);	//积分卡
	public static final Long ETRANSRESTYPE__COM = new Long(2);		//商品
	public static final Long ETRANSRESTYPE__EMPTYSIM = new Long(3);	//空白SIM卡
	//库存标准类型
	public static final Short OPERSTANDTYPE_NUM = new Short((short)0);	//根据数量
	public static final Short OPERSTANDTYPE_SUM = new Short((short)1);	//根据金额
	//审批单状态
	public static final Short RECSTATE_TOBEAUDITED = new Short((short)0);	//待审核
	public static final Short RECSTATE_TOBEREC = new Short((short)1);		//待接收
//	public static final Short RECSTATE_TOBESALED= new Short((short)2);		//待销售
//	public static final Short RECSTATE_TOBEBACKED = new Short((short)3);	//待回退
	public static final Short RECSTATE_REJECT = new Short((short)2);		//审核不通过
	public static final Short RECSTATE_FINISHED = new Short((short)3);		//完成
	//申请类型
	public static final Short APPLYTYPE_DIST = new Short((short)0);//发放
	public static final Short APPLYTYPE_BACK = new Short((short)1);//回退
	//审批动作
	public static final Short APPLYOPRTYPE_NEW = new Short((short)0);	//新增
	public static final Short APPLYOPRTYPE_AUDIT = new Short((short)1);	//审核
	public static final Short APPLYOPRTYPE_ACC = new Short((short)2);	//接收
	public static final Short APPLYOPRTYPE_BACK = new Short((short)3);	//回退
	//回退标识，用于im_pr_resstation标识资源回退状况
	public static final Short ETRANSBACKFLAG_UNBACK = new Short((short)0);	//未回退
	public static final Short ETRANSBACKFLAG_BACKING = new Short((short)1);	//回退中
	public static final Short ETRANSBACKFLAG_BACKED = new Short((short)2);	//已回退	
	//资源类型，目前仅用于库存盘点 2008.10.08
	public static final Long ETRANS_STOCKCHKRESTYPE_VIPCARD = new Long(0);	//积分卡
	public static final Long ETRANS_STOCKCHKRESTYPE_SIM = new Long(1);		//SIM卡
	public static final Long ETRANS_STOCKCHKRESTYPE_EMPTYSIM = new Long(2); //空白SIM卡
	public static final Long ETRANS_STOCKCHKRESTYPE_CZCARD = new Long(3);	//充值卡
	public static final Long ETRANS_STOCKCHKRESTYPE_SMP = new Long(4);		//套卡
	public static final Long ETRANS_STOCKCHKRESTYPE_PHONE = new Long(5);	//终端设备
	public static final Long ETRANS_STOCKCHKRESTYPE_OTHERCOMRES = new Long(6);//商品扩展资源
	
	//系统参数-SIM卡旧卡回收SIM卡类型
	public static final Long SYSPARAM_RECYCLESIMTYPE = new Long(59);
	
	
	
	/**
	 * 已售电子充值券包参数定义
	 */
	
	//已售电子充值券包充值卡状态
	public static final Long ECHARGESTATE_NOUSE = new Long(0); 	// 不可用
	public static final Long ECHARGESTATE_CANUSE = new Long(1);	// 可用
	public static final Long ECHARGESTATE_USED = new Long(2);	// 已使用
	public static final Long ECHARGESTATE_LOCKED = new Long(3);	// 锁定
	public static final Long ECHARGESTATE_REVOKE = new Long(5);	// 预订
	
	
}
