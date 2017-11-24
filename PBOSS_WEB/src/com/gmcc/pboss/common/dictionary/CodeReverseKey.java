package com.gmcc.pboss.common.dictionary;

/**
 * 反射关键字表
 * @author ywj
 * 2009-09-16 
 *
 */
public class CodeReverseKey {
	/**
	 * 业务名称
	 */
	public final static String OPNNAME = "OPNNAME";
	/**
	 * 商品种类名称
	 */
	public final static String DICTITEMNAME = "DICTITEMNAME";
	/**
	 * 分公司名称
	 */
	public final static String CNTYNAME = "CNTYNAME";
	/** 
	 * 卡类购销划扣银行标识 
	 * */
	public static final String DEBANKID = "DEBANKID";

	/**
	 * 分销套卡品牌 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String BRAND = "FX_SMPBRAND";
	
	/**
	 * 分销订单状态 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String ORDERFSTATE = "FX_ORDERFSTATE";
	
	/**
	 * 分销订购途径 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String ORDERAVE = "FX_ORDERAVE";
	
	/**
	 * 送货方式 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String DELITYPE = "FX_DELITYPE";
	
	/**
	 * 缴费方式 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String PAYTYPE = "FX_PAYTYPE";

	/**
	 * 签收状态 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String SIGNSTATE = "FX_SIGNSTATE";
	
	/**
	 * 配送单状态 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String DISSTATE = "FX_DISFORMSTATE";
	
	/**
	 * 订单订购类型 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String ORDERCOMTYPE = "FX_ORDERCOMTYPE";
	
	/**
	 * 垫资汇总单 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String SUMSTATE = "FX_SUMSTATE";

	/**
	 * 不能修改的配送单状态 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String CNNT_DISSTATE = "CANNOT_DISFORMSTATE";
	
	/**
	 * 雇员在职状态名称 - 取值方式：通过固定参数表（xml文件）
	 */
	public final static String EMPSTATUSNAME = "EMPSTATUS";
	/**
	 * 资源类别单位 - 取值方式：通过配置文件数表（xml文件）
	 */
	public final static String COMCATEGORY_UNIT = "COMCATEGORY_UNIT";
	/**
	 * 登陆方式-
	 */
	public final static String AUTH_TYPE = "WEB_AUTHTYPE";
	/**
	 * 品牌-神州行、全球通、动感地带、其他-数据库固定参数表
	 */
	public final static String SIMBRAND = "CH_SIMBRAND";	
	/**
	 * 套卡类别
	 */
	public final static String IM_COMTYPE="IM_COMCLASS";
	/**
	 * 套卡登记类型
	 */
	public final static String CH_MFLAG="CH_MFLAG";
	/**
	 * 套卡类型
	 */
	public final static String IM_COMTYPE2="IM_COMTYPE";
}
