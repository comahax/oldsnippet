package com.gmcc.pboss.common.bean;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.common.context.ContextUtil;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.CodeService;


/**
 * 对于代码的选择，采用静态生成的方式，统一方法调用
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
	 * 提取业务名称
	 */
	public String getOpnname() {
		return this.getProperty(CodeReverseKey.OPNNAME, "opnid");
	}

	/**
	 * 提取商品种类名称
	 */
	public String getDictItemName() {
		return this.getProperty(CodeReverseKey.DICTITEMNAME, "dictitem");
	}
	
	/**
	 * 个性：提取商品种类名称
	 */
	public String getComcategoryName() {
		return this.getProperty(CodeReverseKey.DICTITEMNAME, "comcategory");
	}

	/**
	 * 个性：卡类购销划扣银行标识 名称
	 */
	public String getDebankidName(){
		return this.getProperty(CodeReverseKey.DEBANKID, "debankid");
	}
	/**
	 * 提取套卡品牌名称
	 */
	public String getBrandName() {
		return this.getProperty(CodeReverseKey.BRAND, "brand");
	}
	
	/**
	 * 提取套卡品牌名称
	 */
	public String getOrderstateName() {
		return this.getProperty(CodeReverseKey.ORDERFSTATE, "orderstate");
	}
	/**
	 * 提取订购途径名称
	 */
	public String getOrderaveName() {
		return this.getProperty(CodeReverseKey.ORDERAVE, "orderave");
	}
	/**
	 * 提取订购途径名称
	 */
	public String getDelitypeName() {
		return this.getProperty(CodeReverseKey.DELITYPE, "delitype");
	}
	/**
	 * 提取订单订购类型
	 */
	public String getOrdercomtypeName() {
		return this.getProperty(CodeReverseKey.ORDERCOMTYPE, "ordercomtype");
	}
	/**
	 * 提取缴费方式
	 */
	public String getPaytypeName() {
		return this.getProperty(CodeReverseKey.PAYTYPE, "paytype");
	}
	
	/**
	 * 提取缴费方式
	 */
	public String getDisstateName() {
		return this.getProperty(CodeReverseKey.DISSTATE, "disstate");
	}
	
	/**
	 * 社会（网站）渠道 酬金类型-简称
	 */
	public String getRewardtypeshortName(){
		return this.getProperty(ConstantsType.SOCIETY_REWARD_TPYPE_SHORTNAME, "rewardtype");
	}
	
	/**
	 * 社会渠道 酬金类型
	 */
	public String getRewardtypeName(){
		return this.getProperty(ConstantsType.SOCIETY_REWARD_TPYPE, "rewardtype");
	}
	/**
	 * 在职状态
	 * @return
	 */
	public String getEmpstatusName(){
		return this.getProperty(ConstantsType.EMPSTATUS, "empstatus");
	}
	
	/**
	 * 分公司名称状态
	 * @return
	 */
	public String getDatasCountyName(){
		return this.getProperty(CodeReverseKey.CNTYNAME, "datas.countyid");
	}
	/**
	 * 根据CodeType和属性名（propertyName）获得名称（CodeName）
	 * @author ywj
	 * @param codeType：String 编码类型，如LicenseColor
	 * @param propertyName：String 类中编码属性名，如licenseColorCode
	 * 2009-09-16
	 */
	protected String getProperty(String codeType,String propertyName){
		try{
			if (codeService == null) {
				codeService = (CodeService) ContextUtil.getContext().getBean("codeService");
				if (codeService ==null){
					logger.error("反射注入出错!");
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
	 * 根据CodeType和传入值（property）获得名称（CodeName）
	 * @author ywj
	 * @param codeType：String 编码类型，如LicenseColor
	 * @param property：Object类中编码属性值，如licenseColorCode
	 * 2009-05-05
	 */
	protected String getPropertyByValue(String codeType,Object property){
		try{
			if (codeService == null) {
				codeService = (CodeService) ContextUtil.getContext().getBean("codeService");
				if (codeService ==null){
					logger.error("反射注入出错!");
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
