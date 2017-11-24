package com.gmcc.pboss.common.tagext;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;

public class Type2StringFunction {
	/**
	 * ��������ת��
	 * @param type
	 * @return
	 */
	public static String cateToStr(Integer type) {
		return Constant.getConstantName(ConstantsType.CATETYPE, type.toString());
	}
	/**
	 * ҵ̬����ת��
	 * @param formate
	 * @return
	 */
	public static String formateToStr(Integer formate) {
		return Constant.getConstantName(ConstantsType.FORMTYPE, formate.toString());
	}
	/**
	 * ��õ�������
	 * @param cityId
	 * @return
	 */
	public static String getBranchName(String cityId){
		return Constant.getConstantName(ConstantsType.BRANCH_NAME, cityId);
	}
	
	/**
	 * ��õ��зֹ�˾��
	 */
	public static String getCountyidchName(String countyid){
		return Constant.getCountyidchName(countyid);
	}
	/**
	 * ��ñ��س�𱨱�����
	 * @param rewardtype
	 * @return
	 */
	public static String getRewardtypehName(String rewardtype){
		return Constant.getConstantName(ConstantsType.REWARDLOCALTYPE,rewardtype);
	}
	
	/**
	 * �����Ǽ�
	 * @param starlevel
	 * @return
	 */
	public static String getStarlevelName(String starlevel){
		//���������Ǽ�
		return Constant.getConstantName(ConstantsType.STARLEVEL, starlevel);		
	}
	
	/**
	 * JSTLת��ΪString����
	 * @param convObj
	 * @return
	 */
	public static String convSting(Object convObj){
		return convObj.toString();
	}
}
