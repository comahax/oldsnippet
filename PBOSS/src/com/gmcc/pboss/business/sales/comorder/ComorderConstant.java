package com.gmcc.pboss.business.sales.comorder;

public class ComorderConstant {
	//辅助信息是否能订购参数（不能订购）
	public static final String ORDER_CANNT= "0";
	//缴费方式是否为银行划扣参数（是银行划扣）
	public static final String PAYTYPE_BANK = "BANK";
	
	//系统参数所属模块（分销）
	public static final String PARAMTYPE_FX = "pboss_fx";
	//系统参数id（日/月订购限制开关id）
	public static final String SYSTEMID_ORDER_MONTH_DAY = "9";
	//系统参数id（月订购量浮动开关id）
	public static final String SYSTEMID_ORDER_MONTH = "8";
	//系统参数id（基准库存开关id）
	public static final String SYSTEMID_ORDER_STDSTOCK= "10";
	//系统参数id（商品订购提示信息id）
	public static final String SYSTEMID_ORDER_HINT= "26";
	
	//系统参数id（预警库存开关id）
	public static final String SYSTEMID_ORDER_STOCKALARM = "45";
	
	//日/月订购限制开关状态
	public static final String ORDER_MONTHDAY_OPEN = "1";
	public static final String ORDER_MONTHDAY_CLOSE = "0";
	//月订购量浮动开关状态
	public static final String ORDER_MONTH_OPEN = "1";
	public static final String ORDER_MONTH_CLOSE = "0";
	//基准库存限制开关状态
	public static final String ORDER_STDSTOCK_OPEN = "1";
	public static final String ORDER_STDSTOCK_CLOSE = "0";
	//最大订购量模式（基准库存模式）
	public static final String MAXAMTMODE_STDSTOCK = "STDSTOCK";
	//最大订购量模式（激活率模式）
	public static final String MAXAMTMODE_ACTRATE = "ACTRATE";
	
	//资源类别（套卡）
	public static final String RESTYPE_SMP = "COMRESSMP";
	//套卡订购基数模式（按星期）
	public static final String UNITAGEMODE_WEEK = "WEEK";
	//套卡订购基数默认值
	public static final String BASE_ORDER_DEFAULT = "20";
	
	//售价区分方式(无区分)
	public static final String PRICEDIFTYPE_NODIF = "NODIF";
	//售价区分方式(按公私账户区分)
	public static final String PRICEDIFTYPE_ACCOUNT = "ACCOUNT";
	//售价区分方式(按是否打印发票区分)
	public static final String PRICEDIFTYPE_INVOICE = "INVOICE";
	//公私账户参数（对公）
	public static final Short ACCOUNT_TO_CO = 0;
	//是否打印发票参数（打印发票）
	public static final Short INVOICE_PRI = 1;

	public static final String ORDERAVE_HALL = "HALL";	//订购途径(营业厅)
	public static final String ORDERAVE_WEB = "WEB";	//订购途径(网站)
	public static final String ORDERAVE_SMS = "SMS";	//订购途径(短信)
	public static final String ORDERAVE_IVR = "IVR";	//订购途径(语音)
	public static final String ORDERAVE_AUTO = "AUTO";  //订购途径(自动分配)
	
	//订单流程有效性（有效）
	public static final String EFFECTIVE_YES = "1";
	//实收金额（金额数量为0）
	public static final Double ACTAMT_ZERO = 0d;
	//订单商品类型（客户订购）
	public static final String COMORDER_TYPE = "CUSTORDER";
	
	//品牌类型（所有品牌）
	public static final String BRAND_TYPE_ALLBRAND = "AllBrand";
	
	//合作类型（所有类型）
	public static final String COOPTYPE_ALL= "ALL";
	
	//星级（所有星级）
	public static final String STARLEVEL_ALL= "-1";
	
	//订购量约束模式（日/月订购限制）
	public static final String MODE_MONDAYLIMIT= "MONDAYLIMIT";
	//订购量约束模式（基准库存限制）
	public static final String MODE_STDSTOCK= "STDSTOCK";
	//订购量约束模式（预警库存）
	public static final String MODE_STOCKALARM= "STOCKALARM";
	//订购量约束模式（日月库存组合模式）
	public static final String MODE_MONDAYSTOCK= "MONDAYSTOCK";
	//套卡订购信息（日月预警库存组合模式）
	public static final String MODE_MONDAYALARM= "MONDAYALARM";
	
}
