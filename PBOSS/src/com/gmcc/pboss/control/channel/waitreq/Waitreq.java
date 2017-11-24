/**
 * auto-generated code
 * Wed Nov 18 16:14:43 CST 2009
 */
package com.gmcc.pboss.control.channel.waitreq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.waitreq.WaitreqDBParam;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Waitreq
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public interface Waitreq extends AbstractControl {
	public WaitreqVO doCreate(WaitreqVO vo) throws Exception;

	/*
	 * 0:渠道管理 1:考核管理 2:酬金管理 3:分销管理 4:促销管理 5:资源管理 6:沟通管理 8:其它 100:高优先级（网站验证码）
	 */
	public static final Short SMS_CH = new Short("0");
	public static final Short SMS_KEHE = new Short("1");
	public static final Short SMS_REWARD = new Short("2");
	public static final Short SMS_FX = new Short("3");
	public static final Short SMS_PRO = new Short("4");
	public static final Short SMS_IM = new Short("5");
	public static final Short SMS_GOTO = new Short("6");
	public static final Short SMS_OTHER = new Short("8");
	public static final Short SMS_PRIORITY = new Short("100");

	/**
	 * 输入参数：短信类型 ，短信内容，接受号码
	 */
	public WaitreqVO doInsert(Short mobileType, String content, String mobile)
			throws Exception;
	
	public WaitreqVO doInsert2(Short mobileType, String content, String sendno, String recno)
		throws Exception ;

	public void doRemoveByVO(WaitreqVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public WaitreqVO doUpdate(WaitreqVO vo) throws Exception;

	public WaitreqVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(WaitreqDBParam params) throws Exception;
	
	/*
	 * 参数:短信类型,短信内容,发送号码,接收号码,发送时间
	 */
	public WaitreqVO doInsert3(Short mobileType, String content, String sendno, String recno, Date senttime) throws Exception ;
	
	//保存到信息待发送表
	public void doSaveWaitreq(Short mobileType, String content, String desttype, List<String> objidList)throws Exception;
	
	/**
	 * 【发送短信】公共方法 --采集平台所用到的
	 *  @param 短信标识,需替换参数的键值，接收号码
	 * 根据短信标识查询短信模板表，并对短信内容进行替换，然后插入短信待发送表           
	 * @author yedaoe
	 */
	public WaitreqVO doInsertForCj(String sId, Map<String,String> keyAndValue, String recno) throws Exception;

}
