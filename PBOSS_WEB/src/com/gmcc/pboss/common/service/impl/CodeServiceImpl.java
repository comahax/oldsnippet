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

	/** ���б�ʶ */
	private DbBankService dbBankService; 
	
	//getter/setter����
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
		//�˴�ͨ���ڴ棨Serviceȡֵ��
		if (CodeReverseKey.OPNNAME.equals(codeType)){
			return operationService.getOperationName(code);
		}else if (CodeReverseKey.DICTITEMNAME.equals(codeType)){
			return dictItemService.getNameByCode(code);
		}else if (CodeReverseKey.DEBANKID.equals(codeType)){
			return dbBankService.getNameByCode(code);
		}
		
		//�˴�ͨ���̶�������XMLȡֵ��
		else if (CodeReverseKey.BRAND.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//�����׿�Ʒ��
		else if (CodeReverseKey.ORDERFSTATE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//��������״̬
		else if (CodeReverseKey.ORDERAVE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//��������;��
		else if (CodeReverseKey.DELITYPE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//�ͻ���ʽ
		else if (CodeReverseKey.PAYTYPE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//�ɷѷ�ʽ
		else if (CodeReverseKey.SIGNSTATE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}//ǩ��״̬
		else if (CodeReverseKey.DISSTATE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//������������
		else if (CodeReverseKey.ORDERCOMTYPE.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//��Դ���λ
		else if(CodeReverseKey.COMCATEGORY_UNIT.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//�������
		else if (ConstantsType.SOCIETY_REWARD_TPYPE_SHORTNAME.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}
		//��Ա��ְ״̬
		else if(ConstantsType.EMPSTATUS.equals(codeType)){
			return getConstantsByCode(codeType, code);
		}

		/* �Զ��巴�䷽�� */
		//�ֹ�˾����
		else if (CodeReverseKey.CNTYNAME.equals(codeType)){
			return Constant.getCountyidchName(code);
		}
		return null;
	}
	
	/**
	 * ͨ���̶��̶�������XML��ȡֵ
	 * @param codeType -- ��������
	 * @param code -- ����
	 * @return
	 */
	private String getConstantsByCode(String codeType,String code){
		return Constant.getConstantName(codeType, code);
	}
}
