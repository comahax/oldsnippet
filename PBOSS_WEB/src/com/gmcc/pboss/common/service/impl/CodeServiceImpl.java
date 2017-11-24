package com.gmcc.pboss.common.service.impl;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.info.node.service.DbBankService;
import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.CodeService;

public class CodeServiceImpl implements CodeService {

	private OperationService operationService;
	
	private DictItemService dictItemService;

	/** 银行标识 */
	private DbBankService dbBankService; 
	
	//getter/setter方法
	/**
	 * @return the operationService
	 */
	public OperationService getOperationService() {
		return operationService;
	}

	/**
	 * @param operationService the operationService to set
	 */
	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	/**
	 * @return the dictItemService
	 */
	public DictItemService getDictItemService() {
		return dictItemService;
	}

	/**
	 * @param dictItemService the dictItemService to set
	 */
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	
	/**
	 * @return the dbBankService
	 */
	public DbBankService getDbBankService() {
		return dbBankService;
	}

	/**
	 * @param dbBankService the dbBankService to set
	 */
	public void setDbBankService(DbBankService dbBankService) {
		this.dbBankService = dbBankService;
	}

	public String getCodeByName(String codeType, String name) {
		// TODO Auto-generated method stub
		return "";
	}

	public String getNameByCode(String codeType, String code) {
		//此处通过内存（Service取值）
		if (CodeReverseKey.OPNNAME.equals(codeType)){
			return operationService.getOperationName(code);
		}else if (CodeReverseKey.DICTITEMNAME.equals(codeType)){
			return dictItemService.getNameByCode(code);
		}else if (CodeReverseKey.DEBANKID.equals(codeType)){
			return dbBankService.getNameByCode(code);
		}
		
		//此处通过固定参数表（XML取值）
		else if (CodeReverseKey.BRAND.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//分销套卡品牌
		else if (CodeReverseKey.ORDERFSTATE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//分销订单状态
		else if (CodeReverseKey.ORDERAVE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//分销订购途径
		else if (CodeReverseKey.DELITYPE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//送货方式
		else if (CodeReverseKey.PAYTYPE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//缴费方式
		else if (CodeReverseKey.SIGNSTATE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//签收状态
		else if (CodeReverseKey.DISSTATE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//订单订购类型
		else if (CodeReverseKey.ORDERCOMTYPE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//资源类别单位
		else if(CodeReverseKey.COMCATEGORY_UNIT.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//酬金名称
		else if (ConstantsType.SOCIETY_REWARD_TPYPE_SHORTNAME.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//雇员在职状态
		else if(ConstantsType.EMPSTATUS.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}

		/* 自定义反射方法 */
		//分公司名称
		else if (CodeReverseKey.CNTYNAME.equals(codeType)){
			return Constant.getCountyidchName(code);
		}
		return null;
	}
	
	/**
	 * 通过固定固定参数表（XML）取值
	 * @param codeType -- 参数类型
	 * @param code -- 代码
	 * @return
	 */
	private String getConstantsByCode(String codeType,String code){
		return Constant.getConstantName(codeType, code);
	}
}
