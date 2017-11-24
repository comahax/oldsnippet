package com.gmcc.pboss.common.tagext;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class Type2StringFunction {
	/**
	 * 连锁性质转换
	 * @param type
	 * @return
	 */
	public static String cateToStr(Integer type) {
		return Constant.getConstantName(ConstantsType.CATETYPE, type.toString());
	}
	/**
	 * 业态类型转换
	 * @param formate
	 * @return
	 */
	public static String formateToStr(Integer formate) {
		return Constant.getConstantName(ConstantsType.FORMTYPE, formate.toString());
	}
	/**
	 * 获得地市名称
	 * @param cityId
	 * @return
	 */
	public static String getBranchName(String cityId){
		return Constant.getConstantName(ConstantsType.BRANCH_NAME, cityId);
	}
	
	/**
	 * 获得地市分公司号
	 */
	public static String getCountyidchName(String countyid){
		return Constant.getCountyidchName(countyid);
	}
	/**
	 * 获得本地酬金报表名称
	 * @param rewardtype
	 * @return
	 */
	public static String getRewardtypehName(String rewardtype){
		return Constant.getConstantName(ConstantsType.REWARDLOCALTYPE,rewardtype);
	}
	
	/**
	 * 翻地星级
	 * @param starlevel
	 * @return
	 */
	public static String getStarlevelName(String starlevel){
		//翻译渠道星级
		return Constant.getConstantName(ConstantsType.STARLEVEL, starlevel);		
	}
	
	/**
	 * JSTL转换为String类型
	 * @param convObj
	 * @return
	 */
	public static String convSting(Object convObj){
		return convObj.toString();
	}
}
