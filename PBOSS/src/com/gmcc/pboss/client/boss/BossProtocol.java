/**
 * 
 */
package com.gmcc.pboss.client.boss;


import org.apache.log4j.Logger;

import com.gmcc.pboss.client.boss.result.CancelAccountResult;
import com.gmcc.pboss.client.boss.result.IncomeAccountResult;
import com.gmcc.pboss.client.boss.send.CancelAccountDataPack;
import com.gmcc.pboss.client.boss.send.ChargeData;
import com.gmcc.pboss.client.boss.send.IncomeAccountDataPack;
import com.sunrise.jop.common.utils.lang.StringUtils;

/**
 * BOSS 接口协议，主要实现装包和拆包工作
 * 
 * @author hbm
 * 
 */
public class BossProtocol {
	/**
	 * 
	 */
	
	private static Logger log = Logger.getLogger(BossProtocol.class);
	
	public static final String ENCODE = "GBK"; //字符编码
	
	static public String INCOME_ACCOUNT = "52210"; // 入账命令字
	static public String CANCEL_ACCOUNT = "52211"; // 退入账命令字
	
	static public String WORD_SLIT_SYMBOL = "~"; //	词分隔符
	static public String STR_SLIT_SYMBOL = "^"; // 串分隔符
	static public String WORD_END_SYMBOL = ";"; // 结束符号
	static public String STR_END_SYMBOL = "|"; // 结束符号
	
	//------入账--------------------------------
	/**
	 * 
		发送报文：
		
		命令字：52210
		datatrans：操作渠道~操作工号~收费方式串~费用串~PBOSS订单编号;
		
		参数说明：
			操作渠道：业务受理渠道
			操作工号：业务受理操作员工号
			收费方式串：收费方式^金额^POS交易号^|，说明：收费方式包括CASH（现金）、POS（POS机）、BANK（银行划账），非POS时POS交易号为空
			费用串：XS^商品费用^100.00^，说明：本次分销订单的总费用
			PBOSS订单编号：PBOSS系统订单编号，说明：用于资源明细查询
	 *
	 */
	static public String packForIncomeAccount(IncomeAccountDataPack data){
		//拼 收费方式串
		StringBuffer chargeStr = new StringBuffer(); 
		ChargeData chargeData = data.getChargeData();
		chargeStr.append(chargeData.getChargeType()).append(STR_SLIT_SYMBOL);
		chargeStr.append(chargeData.getMoney()).append(STR_SLIT_SYMBOL);
		if(ChargeData.CHARGE_TYPE_POS.equals(data.getChargeData().getChargeType())){
			chargeStr.append(chargeData.getPosNo());
		}
		chargeStr.append(STR_SLIT_SYMBOL).append(STR_END_SYMBOL);
		//拼 费用串
		StringBuffer feeStr = new StringBuffer(); 
		feeStr.append("XS^商品费用^").append(data.getFeeStr()).append(STR_SLIT_SYMBOL);
		
		StringBuffer sb = new StringBuffer(); 
		//sb.append(INCOME_ACCOUNT).append(WORD_SLIT_SYMBOL);//命令字
		sb.append(data.getWayid()).append(WORD_SLIT_SYMBOL); //操作渠道
		sb.append(data.getOprcode()).append(WORD_SLIT_SYMBOL);//操作工号
		sb.append(chargeStr.toString()).append(WORD_SLIT_SYMBOL);//收费方式串
		sb.append(feeStr.toString()).append(WORD_SLIT_SYMBOL);//费用串
		sb.append(data.getPbossNo()).append(WORD_END_SYMBOL);//PBOSS订单编
		log.info("发送报文:"+sb.toString());
		return sb.toString();
	}
	
	/**
	 * 
		回送报文:
		
		datatrans：ret~说明;[标题;列宽段;]数据段;
		
		数据段格式：BOSS的工单编号;
			ret=0   操作成功
			ret=1   未找到订单对应的商品资源
			ret=MMM 操作失败，要求在"说明"中描述失败原因
	 * 
	 */
	static public IncomeAccountResult unpackForIncomeAccount(String retStr){
		IncomeAccountResult result = new IncomeAccountResult();
		
		String[] words = StringUtils.split(retStr.trim(),WORD_END_SYMBOL);
		log.info("回送报文:"+retStr);
		if(words.length<2){
			throw new BossException("回送报文格式不符：[" + retStr + "]");
		}else{
			String[] first = StringUtils.split(words[0],WORD_SLIT_SYMBOL);
			String last = words[words.length-1];
			result.setRet(first[0]);
			result.setExplain(first[1]);
			result.setBossNo(last);
			
			if(words.length>2){
				StringBuffer sb = new StringBuffer();
				for(int i=1; i<words.length-1; ++i){
					sb.append(words[i]);
				}
				result.setOther(sb.toString());
			}
		}
		return result;
	}
	//------------------------------------------
	
	
	
	//------退入账------------------------------
	/**
	 * 
	 	发送报文：
	 	
	 	命令字：52211
		datatrans：操作渠道~操作工号~收费方式串~费用串~PBOSS订单编号~BOSS入账工单编号;
		
		参数说明：
			操作渠道：业务受理渠道
			操作工号：业务受理操作员工号
			收费方式串：收费方式^金额^POS交易号^|, 说明：收费方式包括CASH（现金）、POS（POS机）、BANK（银行划账），非POS时POS交易号为空值，金额也是原金额的相反数
			费用串：XS^商品费用^-100^, 说明：原订单总费用的相反数
			金额单位：分
			PBOSS订单编号：PBOSS分销商品退售订单编号
			BOSS入账工单编号：BOSS系统入账时登记的工单编号
	 *
	 */
	static public String packForCancelAccount(CancelAccountDataPack data){
		//拼 收费方式串
		StringBuffer chargeStr = new StringBuffer(); 
		ChargeData chargeData = data.getChargeData();
		chargeStr.append(chargeData.getChargeType()).append(STR_SLIT_SYMBOL);
		chargeStr.append(chargeData.getMoney()).append(STR_SLIT_SYMBOL);
		if(ChargeData.CHARGE_TYPE_POS.equals(data.getChargeData().getChargeType())){
			chargeStr.append(chargeData.getPosNo());
		}
		chargeStr.append(STR_SLIT_SYMBOL).append(STR_END_SYMBOL);
		//拼 费用串
		StringBuffer feeStr = new StringBuffer(); 
		feeStr.append("XS^商品费用^").append(data.getFeeStr()).append(STR_SLIT_SYMBOL);
		
		StringBuffer sb = new StringBuffer(); 
		//sb.append(INCOME_ACCOUNT).append(WORD_SLIT_SYMBOL);//命令字
		sb.append(data.getWayid()).append(WORD_SLIT_SYMBOL); //操作渠道
		sb.append(data.getOprcode()).append(WORD_SLIT_SYMBOL);//操作工号
		sb.append(chargeStr.toString()).append(WORD_SLIT_SYMBOL);//收费方式串
		sb.append(feeStr.toString()).append(WORD_SLIT_SYMBOL);//费用串
		sb.append(data.getPbossNo()).append(WORD_SLIT_SYMBOL);//PBOSS订单编号
		sb.append(data.getBossNo()).append(WORD_END_SYMBOL);//BOSS入账工单编号
		sb.append("\n");
		
		return sb.toString();
	}

	/**
	 * 
	 	回送报文 :
		
		datatrans：ret~说明;[标题;列宽段;]数据段;
	
		数据段格式：工单编号; （BOSS退入账操作产生的工单编号）
			ret=0   操作成功
			ret=1   未找到订单对应的商品资源
			ret=MMM 操作失败，要求在“说明”中描述失败原因
	 * 
	 */
	static public CancelAccountResult unpackForCancelAccount(String retStr){
		CancelAccountResult result = new CancelAccountResult();
		String[] words = StringUtils.split(retStr.trim(),WORD_END_SYMBOL);
		if(words.length<2){
			throw new BossException("回送报文格式不符：[" + retStr + "]");
		}else{
			String[] first = StringUtils.split(words[0],WORD_SLIT_SYMBOL);
			String last = words[words.length-1];
			result.setRet(first[0]);
			result.setExplain(first[1]);
			result.setBossNo(last);
			
			if(words.length>2){
				StringBuffer sb = new StringBuffer();
				for(int i=1; i<words.length-1; ++i){
					sb.append(words[i]);
				}
				result.setOther(sb.toString());
			}
		}
		return result;
	}
	//------------------------------------------

}
