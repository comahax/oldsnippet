package com.gmcc.pboss.common.bean;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.common.context.ContextUtil;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.CodeService;


/**
 * ���ڴ����ѡ�񣬲��þ�̬���ɵķ�ʽ��ͳһ��������
 * @author ywj
 * 2009-9-16
 */
public class CodeReverse extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 253021062546448254L;

	private CodeService codeService ;

	protected static final Log logger = LogFactory.getLog(CodeReverse.class);
	
	/**
	 * ��ȡҵ������
	 */
	public String getOpnname() {
		return this.getProperty(CodeReverseKey.OPNNAME, "opnid");
	}

	/**
	 * ��ȡ��Ʒ��������
	 */
	public String getDictItemName() {
		return this.getProperty(CodeReverseKey.DICTITEMNAME, "dictitem");
	}
	
	/**
	 * ���ԣ���ȡ��Ʒ��������
	 */
	public String getComcategoryName() {
		return this.getProperty(CodeReverseKey.DICTITEMNAME, "comcategory");
	}

	/**
	 * ���ԣ����๺���������б�ʶ ����
	 */
	public String getDebankidName(){
		return this.getProperty(CodeReverseKey.DEBANKID, "debankid");
	}
	/**
	 * ��ȡ�׿�Ʒ������
	 */
	public String getBrandName() {
		return this.getProperty(CodeReverseKey.BRAND, "brand");
	}
	
	/**
	 * ��ȡ�׿�Ʒ������
	 */
	public String getOrderstateName() {
		return this.getProperty(CodeReverseKey.ORDERFSTATE, "orderstate");
	}
	/**
	 * ��ȡ����;������
	 */
	public String getOrderaveName() {
		return this.getProperty(CodeReverseKey.ORDERAVE, "orderave");
	}
	/**
	 * ��ȡ����;������
	 */
	public String getDelitypeName() {
		return this.getProperty(CodeReverseKey.DELITYPE, "delitype");
	}
	/**
	 * ��ȡ������������
	 */
	public String getOrdercomtypeName() {
		return this.getProperty(CodeReverseKey.ORDERCOMTYPE, "ordercomtype");
	}
	/**
	 * ��ȡ�ɷѷ�ʽ
	 */
	public String getPaytypeName() {
		return this.getProperty(CodeReverseKey.PAYTYPE, "paytype");
	}
	
	/**
	 * ��ȡ�ɷѷ�ʽ
	 */
	public String getDisstateName() {
		return this.getProperty(CodeReverseKey.DISSTATE, "disstate");
	}
	
	/**
	 * ��ᣨ��վ������ �������-���
	 */
	public String getRewardtypeshortName(){
		return this.getProperty(ConstantsType.SOCIETY_REWARD_TPYPE_SHORTNAME, "rewardtype");
	}
	
	/**
	 * ������� �������
	 */
	public String getRewardtypeName(){
		return this.getProperty(ConstantsType.SOCIETY_REWARD_TPYPE, "rewardtype");
	}
	/**
	 * ��ְ״̬
	 * @return
	 */
	public String getEmpstatusName(){
		return this.getProperty(ConstantsType.EMPSTATUS, "empstatus");
	}
	
	/**
	 * �ֹ�˾����״̬
	 * @return
	 */
	public String getDatasCountyName(){
		return this.getProperty(CodeReverseKey.CNTYNAME, "datas.countyid");
	}
	/**
	 * ����CodeType����������propertyName��������ƣ�CodeName��
	 * @author ywj
	 * @param codeType��String �������ͣ���LicenseColor
	 * @param propertyName��String ���б�������������licenseColorCode
	 * 2009-09-16
	 */
	protected String getProperty(String codeType,String propertyName){
		try{
			if (codeService == null) {
				codeService = (CodeService) ContextUtil.getContext().getBean("codeService");
				if (codeService ==null){
					logger.error("����ע�����!");
					return null;
				}
			}
			Object property = PropertyUtils.getProperty(this, propertyName);
			String code = null;
			if(property != null){
				code = property.toString();
			} else {
				return null;
			}
			return codeService.getNameByCode(codeType, code);
		}
		catch(Exception ex){
			logger.warn("[CodeReverse Error]:"+ex.getMessage());
			return null;
		}
	}

	/**
	 * ����CodeType�ʹ���ֵ��property��������ƣ�CodeName��
	 * @author ywj
	 * @param codeType��String �������ͣ���LicenseColor
	 * @param property��Object���б�������ֵ����licenseColorCode
	 * 2009-05-05
	 */
	protected String getPropertyByValue(String codeType,Object property){
		try{
			if (codeService == null) {
				codeService = (CodeService) ContextUtil.getContext().getBean("codeService");
				if (codeService ==null){
					logger.error("����ע�����!");
					return null;
				}
			}
			String code = null;
			if(property != null){
				code = property.toString();
			} else {
				return null;
			}
			return codeService.getNameByCode(codeType, code);
		}
		catch(Exception ex){
			logger.warn("[CodeReverse Error]:"+ex.getMessage());
			return null;
		}
	}

}
