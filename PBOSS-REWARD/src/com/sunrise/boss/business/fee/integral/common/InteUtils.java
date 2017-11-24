package com.sunrise.boss.business.fee.integral.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.common.subscriber.persistent.SubscriberDAO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberVO;
import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgDAO;
import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgVO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaVO;
import com.sunrise.boss.business.fee.realtran.payway.SqlUtils;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

public class InteUtils {

	private Logger log = Logger.getLogger(InteUtils.class);
	
	/*** A = add ，R = reduce ****/
	public  final static int CONSUME_RSN_A = 0; 	/**消费积分增加**/
	public  final static int CONSUME_RSN_R = 1; 	/**消费积分减少**/
	public  final static int INNET_RSN_A = 2; 	/**在网积分增加**/
	public  final static int INNET_RSN_R = 3; 	/**在网积分减少**/
	public  final static int CREDIT_RSN_A = 4; 	/**信用积分增加**/
	public  final static int CREDIT_RSN_R = 5; 	/**信用积分减少**/
	public  final static int TUNE_RSN_A = 50; 	/**调整积分增加**/
	public  final static int TUNE_RSN_R = 51; 	/**调整积分减少**/
	public  final static int DATAOPER_RSN_R = 6; 	/**数据业务积分减少**/
	public  final static int DATAOPER_RSN_A = 7; 	/**数据业务积分增加**/
	public  final static int OFFICIALDERATE_RSN_A = 36; 	/**公务机减免积分增加**/
	public  final static int OFFICIALDERATE_RSN_R = 13; 	/**公务机减免积分减少**/
	public  final static int HORTATION_RSN_A = 8; 	/** 奖励积分增加**/
	public  final static int HORTATION_RSN_R = 9; 	/**奖励积分减少**/
	
	public  final static int TRANSFRE_RSN_A = 15; 	/** 积分转入**/
	public  final static int TRANSFRE_RSN_R = 16; 	/** 积分转出**/
	
	
	public  final static int CONSUME = 0; 	/**消费积分**/
	public  final static int INNET = 1; 	/**在网积分**/
	public  final static int CREDIT = 2; 	/**信用积分**/
	public  final static int TUNE = 3; 	/**调整积分**/
	public  final static int YEARINTE = 4; 	/**年度积分**/
	public  final static int DATAOPER = 5; 	/**数据业务积分**/
	public  final static int OFFICIALDERATE = 6; 	/**公务机减免积分**/
	public  final static int HORTATION = 7; 	/**奖励积分**/
	
	/* add by xiefufeng */
	public final static int CUSTINTE_LIMIT = 1000; /* 客户消费积分阀值 */
	/* add by xiefufeng */
	
	/**
	 * 获得当前时间
	 */
	public static Date getNowDate() {		
		return new Date(System.currentTimeMillis());
	}
	
	/**
	 * 根据积分周期年（yyyy）获得有效帐务周期下限（当前年的1月份）
	 */
	public static String getLowerDate(String integralcyc) {
		if (null != integralcyc && integralcyc.length() == 4) {
			return integralcyc + "0100";
		}
		return null;
	}
	/**
	 * 根据积分周期年（yyyy）获得有效帐务周期上限（当前年的12月份） 
	 */
	public static String getUpDate(String integralcyc) {
		if (null != integralcyc && integralcyc.length() == 4) {
			return integralcyc + "1200";
		}
		return null;
	}

	/**
	 * 根据帐务周期获得积分周期年yyyy，（范围：当前年1月-当前年12）
	 */
	public static long getIntegralcyc(Long validbillcyc) {
		long update = 0;
		if (null != validbillcyc 
				&& validbillcyc.toString().length() >= 6) {
			return Long.parseLong(validbillcyc.toString().substring(0, 4));
		}
		return update;
	}
	
	/***根据积分类型和积分值 取得积分修正原因类型***/
	public static Integer selectGetRsn(long value, int jftype, boolean isDeta) {
		int rsn = -1;
		boolean increase = value > 0 ? true : false;
		
		if(!isDeta){
			rsn = increase ? TRANSFRE_RSN_A : TRANSFRE_RSN_R;
		}else{		
			switch (jftype) {
				case CONSUME:
					rsn = increase ? CONSUME_RSN_A : CONSUME_RSN_R;
					break;
				case INNET:
					rsn = increase ? INNET_RSN_A : INNET_RSN_R;
					break;
				case CREDIT:
					rsn = increase ? CREDIT_RSN_A : CREDIT_RSN_R;
					break;
				case TUNE:
					rsn = increase ? TUNE_RSN_A : TUNE_RSN_R;
					break;
				case YEARINTE:
					break;
				case DATAOPER:
					rsn = increase ? DATAOPER_RSN_A : DATAOPER_RSN_R;
					break;
				case OFFICIALDERATE:
					rsn = increase ? OFFICIALDERATE_RSN_A : OFFICIALDERATE_RSN_R;
					break;
				case HORTATION:
					rsn = increase ? HORTATION_RSN_A : HORTATION_RSN_R;
					break;
			}
		}	
		return new Integer(rsn);
	}
	
	/** 写日志 **/	
	public static void createInteLog(Long subsid, Long custid,Long integralcyc, 
			Long beforeavlint, Long afteravailint, long value,
			int jftype, String memo,User user, boolean isDeta ) throws Exception {
		
		CustInteChgDAO chgdao = (CustInteChgDAO) DAOFactory.build( CustInteChgDAO.class, user.getCityid());
		
		CustInteChgVO chgvo = new CustInteChgVO();
		chgvo.setCustid(custid);
		chgvo.setSubsid(subsid);
		chgvo.setIntegralcyc(integralcyc);
		chgvo.setBeforeavlint(beforeavlint);
		chgvo.setAfteravlint(afteravailint);
		chgvo.setIntchgrsn(InteUtils.selectGetRsn(value, jftype,isDeta));
		chgvo.setOprcode(user.getOpercode());
		chgvo.setUpdatetime(InteUtils.getNowDate());
		chgvo.setDescrp(memo);
		chgdao.create(chgvo);
	}
	
	
	/**
	 * 求各种积分类型的积分值总数，如果各种积分值为null，设置初始值为0
	 * 暂时不记年度积分和奖励积分（4 和 7）
	 * @return 积分值总数
	 */
	public static Long sumValue(CustInteDetaVO params) {
		long value = 0;
		if (null != params) {
			if (null == params.getConsumeinte())
				params.setConsumeinte(new Long(0));
			if (null == params.getInnetinte())
				params.setInnetinte(new Long(0));
			if (null == params.getCreditinte())
				params.setCreditinte(new Long(0));
			if (null == params.getTuneinte())
				params.setTuneinte(new Long(0));
			// if(null == params.getYearinte()) params.setYearinte(new Long(0));
			if (null == params.getDataoperinte())
				params.setDataoperinte(new Long(0));
			if (null == params.getOfficialderateinte())
				params.setOfficialderateinte(new Long(0));
			// if(null == params.getHortationinte()) params.setHortationinte(new
			// Long(0));
			value = params.getConsumeinte().longValue()
					+ params.getInnetinte().longValue()
					+ params.getTuneinte().longValue()
					+ params.getDataoperinte().longValue()
					+ params.getCreditinte().longValue()
					+ params.getOfficialderateinte().longValue();
		}
		return new Long(value);
	}
	
	/** 设置相对应的积分类型的积分值和备注 **/
	public static void selectSetItem(CustInteDetaVO vo, CustInteDetaVO params) {		
		selectSetMemo(vo, params);
		selectSetValue(vo, params);
	}
	
	/** 初始化各种积分类型的值为0 **/
	public static CustInteDetaVO intiCustInteDetaVO(CustInteDetaVO vo) {
		if(null == vo){
			vo = new CustInteDetaVO();
		}
		vo.setConsumeinte(new Long(0));
		vo.setInnetinte(new Long(0));
		vo.setCreditinte(new Long(0));
		vo.setTuneinte(new Long(0));
		vo.setYearinte(new Long(0));
		vo.setDataoperinte(new Long(0));
		vo.setOfficialderateinte(new Long(0));
		vo.setHortationinte(new Long(0));
		vo.setValue(new Long(0));
		vo.setSumValue(new Long(0));

		return vo;
	}
	
	/**根据积分类型取积分备注**/
	public static String selectGetMemo(CustInteDetaVO params,int jftype){
		String memo = "";		
		switch (jftype) {
			case CONSUME:
				memo = params.getMemo0();
				break;
			case INNET:
				memo = params.getMemo1();
				break;
			case CREDIT:
				memo = params.getMemo2();
				break;
			case TUNE:
				memo = params.getMemo3();
				break;
			case YEARINTE:
				memo = params.getMemo4();
				break;
			case DATAOPER:
				memo = params.getMemo5();
				break;
			case OFFICIALDERATE:
				memo = params.getMemo6();
				break;
			case HORTATION:
				memo = params.getMemo7();
				break;
		}		
		return memo;		
	}
	
	/**根据积分类型取积分值**/
	public static Long selectGetValue(CustInteDetaVO params,int jftype){
		Long value = null;
		if(null != params){
		
			switch (jftype) {
				case CONSUME:
					value = params.getConsumeinte();
					break;
				case INNET:
					value = params.getInnetinte();
					break;
				case CREDIT:
					value = params.getCreditinte();
					break;
				case TUNE:
					value = params.getTuneinte();
					break;
				case YEARINTE:
					value = params.getYearinte();
					break;
				case DATAOPER:
					value = params.getDataoperinte();
					break;
				case OFFICIALDERATE:
					value = params.getOfficialderateinte();
					break;
				case HORTATION:
					value = params.getHortationinte();
					break;
			}	
		}
		if(null == value){
			value = new Long(0);
		}
		return value;		
	}
	
	/** 设置相对应的积分类型的备注 **/
	public static void selectSetMemo(CustInteDetaVO vo, CustInteDetaVO params) {
		
		int jftype = -1;
		if(null != params.getJftype()){
			jftype = params.getJftype().intValue();
		}
		switch (jftype) {
			case CONSUME:
				vo.setMemo0(params.getMemo());
				break;
			case INNET:
				vo.setMemo1(params.getMemo());
				break;
			case CREDIT:
				vo.setMemo2(params.getMemo());
				break;
			case TUNE:
				vo.setMemo3(params.getMemo());
				break;
			case YEARINTE:
				vo.setMemo4(params.getMemo());
				break;
			case DATAOPER:
				vo.setMemo5(params.getMemo());
				break;
			case OFFICIALDERATE:
				vo.setMemo6(params.getMemo());
				break;
			case HORTATION:
				vo.setMemo7(params.getMemo());
				break;
		}
	}
	
	/** 设置相对应的积分类型的积分值 **/
	public static void selectSetValue(CustInteDetaVO vo, CustInteDetaVO params) {
		
		int jftype = -1;
		if(null != params.getJftype()){
			jftype = params.getJftype().intValue();
		}
		switch (jftype) {
			case CONSUME:
				vo.setConsumeinte(params.getValue());
				break;
			case INNET:
				vo.setInnetinte(params.getValue());
				break;
			case CREDIT:
				vo.setCreditinte(params.getValue());
				break;
			case TUNE:
				vo.setTuneinte(params.getValue());
				break;
			case YEARINTE:
				vo.setYearinte(params.getValue());
				break;
			case DATAOPER:
				vo.setDataoperinte(params.getValue());
				break;
			case OFFICIALDERATE:
				vo.setOfficialderateinte(params.getValue());
				break;
			case HORTATION:
				vo.setHortationinte(params.getValue());
				break;
		}
	}
	
	/**
	 * 获取客户标识Custid和用户标识Userid
	 * 该号码只取停机和正常使用2中状态的客户
	 * 这里的userid是subsid
	 * return boolean
	 */
	public static boolean getCustidAndUserid(CustInteDetaVO vo, User user)
			throws Exception {
				
			
		if (null != vo) {
			SubscriberVO svo = FEEUtils.getSubscriberVO(vo.getMobilenum(), user);
			if( !(SubscriberDAO.SUBS_STATE_NORMAL.equals(svo.getStatus()) 
					|| SubscriberDAO.SUBS_STATE_STOP.equals(svo.getStatus()))) {						
				return false;					
			}
												
			String custid = FEEUtils.chgGroCustid(svo.getProid(), 
					svo.getAcctid().toString(), svo.getCustid().toString(), user);
				
			vo.setCustid(new Long(custid));
			vo.setUserid(svo.getSubsid());
			return true;										
	
		}
		return false;
	}
	
	/**
	 * 获取客户2004年1月份到现在的消费总积分
	 * @param custid 客户标识
	 * @param cityid 操作员区域标识
	 * @return sumInt 客户2004年1月份到现在的消费总积分
	 * @throws BusinessException
	 * @author xiefufeng
	 * @throws SQLException 
	 */
	public static long getCustSumConsumeInte( Long custid, String cityid )
	throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select sum(value) from IB_CU_CustIntDeta where validbillcyc >= ? and jftype = ? and custid = ?";
		long sumInt = 0;
		
		if( custid!=null ){
			try{
				pstmt = SqlUtils.getBSQLStatement( sql, cityid );
				pstmt.setLong( 1, 20040100 );
				pstmt.setInt( 2, CONSUME );
				pstmt.setObject( 3, custid );
				
				rs = pstmt.executeQuery();
				if( rs!=null && rs.next() ){
					sumInt = rs.getLong( 1 );
				}
			} finally {
				if( rs!=null ){
					rs.close();
				}
				if( pstmt!=null ){
					pstmt.close();
				}
			}
		}
		
		return sumInt;
	}
	
	/**
	 * 判断客户2004年1月份到现在的消费总积分是否达到门限阀值(1000)
	 * @param custid 客户标识
	 * @param cityid 操作员区域标识
	 * @return result 返回1,表示该客户消费总积分已达到阀值;
	 *                返回0,表示该客户消费总积分尚未达到阀值;
	 *                返回-1,表示抛出异常;
	 * @author xiefufeng
	 */
	public static int checkCustInteLimit( Long custid, String cityid )
	throws Exception {
		int result = 0;
		
		if( custid!=null ){
			//获取客户2004年1月份到现在的消费总积分
			try{
				long sumInte = getCustSumConsumeInte( custid, cityid );
				if( sumInte >= CUSTINTE_LIMIT ){
					result = 1;
				}
			}catch(Exception ex){
				ex.printStackTrace();
				result = -1;
			}
		}
		
		return result;
	}
}
