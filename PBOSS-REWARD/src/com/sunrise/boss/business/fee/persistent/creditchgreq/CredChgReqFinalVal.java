package com.sunrise.boss.business.fee.persistent.creditchgreq;

public class CredChgReqFinalVal {
	
	/**
	 * 信控请求待处理-请求来源
	 */
	public final static Short SRC_PAY_PAY = new Short("0"); //缴费
	public final static Short SRC_PAY_ROLL = new Short("1"); //退费
	public final static Short SRC_TRAN_FAILD = new Short("2"); //划帐失败
	public final static Short SRC_TRAN_SUCC = new Short("3"); //划帐成功
	public final static Short SRC_REAL_FLASH = new Short("4"); //实时费用更新
	public final static Short SRC_HIGH_FLASH = new Short("5"); //高额更新
	public final static Short SRC_REC_CHANGE = new Short("6"); //应收变更
	public final static Short SRC_FEE_CX = new Short("7"); //冲销话费
	public final static Short SRC_FEE_ADJUDGE = new Short("8"); //话费调整
	public final static Short SRC_CREDIT_POLL = new Short("9"); //信用处理轮循
	public final static Short SRC_CREDIT_ACT_ = new Short("10"); //月结停机专用
	//public final static Short SRC_CREDIT_MON_STOP = new Short("11"); //月结停机
	public final static Short SRC_ACC_FAILD = new Short("20"); //划扣失败，帐号异常
	//public final static Short SRC_CREDIT_ACT = new Short("1000"); //
	public final static Short SRC_ALL = new Short("10000"); //所有来源
	
	/**
	 * 信控请求待处理-请求类型
	 */
	public final static Short REQTYPE_REALRT = new Short("1"); //实时划扣
	public final static Short REQTYPE_OPEN = new Short("2"); //开机
	
}
