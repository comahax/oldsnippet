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
 * BOSS �ӿ�Э�飬��Ҫʵ��װ���Ͳ������
 * 
 * @author hbm
 * 
 */
public class BossProtocol {
	/**
	 * 
	 */
	
	private static Logger log = Logger.getLogger(BossProtocol.class);
	
	public static final String ENCODE = "GBK"; //�ַ�����
	
	static public String INCOME_ACCOUNT = "52210"; // ����������
	static public String CANCEL_ACCOUNT = "52211"; // ������������
	
	static public String WORD_SLIT_SYMBOL = "~"; //	�ʷָ���
	static public String STR_SLIT_SYMBOL = "^"; // ���ָ���
	static public String WORD_END_SYMBOL = ";"; // ��������
	static public String STR_END_SYMBOL = "|"; // ��������
	
	//------����--------------------------------
	/**
	 * 
		���ͱ��ģ�
		
		�����֣�52210
		datatrans����������~��������~�շѷ�ʽ��~���ô�~PBOSS�������;
		
		����˵����
			����������ҵ����������
			�������ţ�ҵ���������Ա����
			�շѷ�ʽ�����շѷ�ʽ^���^POS���׺�^|��˵�����շѷ�ʽ����CASH���ֽ𣩡�POS��POS������BANK�����л��ˣ�����POSʱPOS���׺�Ϊ��
			���ô���XS^��Ʒ����^100.00^��˵�������η����������ܷ���
			PBOSS������ţ�PBOSSϵͳ������ţ�˵����������Դ��ϸ��ѯ
	 *
	 */
	static public String packForIncomeAccount(IncomeAccountDataPack data){
		//ƴ �շѷ�ʽ��
		StringBuffer chargeStr = new StringBuffer(); 
		ChargeData chargeData = data.getChargeData();
		chargeStr.append(chargeData.getChargeType()).append(STR_SLIT_SYMBOL);
		chargeStr.append(chargeData.getMoney()).append(STR_SLIT_SYMBOL);
		if(ChargeData.CHARGE_TYPE_POS.equals(data.getChargeData().getChargeType())){
			chargeStr.append(chargeData.getPosNo());
		}
		chargeStr.append(STR_SLIT_SYMBOL).append(STR_END_SYMBOL);
		//ƴ ���ô�
		StringBuffer feeStr = new StringBuffer(); 
		feeStr.append("XS^��Ʒ����^").append(data.getFeeStr()).append(STR_SLIT_SYMBOL);
		
		StringBuffer sb = new StringBuffer(); 
		//sb.append(INCOME_ACCOUNT).append(WORD_SLIT_SYMBOL);//������
		sb.append(data.getWayid()).append(WORD_SLIT_SYMBOL); //��������
		sb.append(data.getOprcode()).append(WORD_SLIT_SYMBOL);//��������
		sb.append(chargeStr.toString()).append(WORD_SLIT_SYMBOL);//�շѷ�ʽ��
		sb.append(feeStr.toString()).append(WORD_SLIT_SYMBOL);//���ô�
		sb.append(data.getPbossNo()).append(WORD_END_SYMBOL);//PBOSS������
		log.info("���ͱ���:"+sb.toString());
		return sb.toString();
	}
	
	/**
	 * 
		���ͱ���:
		
		datatrans��ret~˵��;[����;�п��;]���ݶ�;
		
		���ݶθ�ʽ��BOSS�Ĺ������;
			ret=0   �����ɹ�
			ret=1   δ�ҵ�������Ӧ����Ʒ��Դ
			ret=MMM ����ʧ�ܣ�Ҫ����"˵��"������ʧ��ԭ��
	 * 
	 */
	static public IncomeAccountResult unpackForIncomeAccount(String retStr){
		IncomeAccountResult result = new IncomeAccountResult();
		
		String[] words = StringUtils.split(retStr.trim(),WORD_END_SYMBOL);
		log.info("���ͱ���:"+retStr);
		if(words.length<2){
			throw new BossException("���ͱ��ĸ�ʽ������[" + retStr + "]");
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
	
	
	
	//------������------------------------------
	/**
	 * 
	 	���ͱ��ģ�
	 	
	 	�����֣�52211
		datatrans����������~��������~�շѷ�ʽ��~���ô�~PBOSS�������~BOSS���˹������;
		
		����˵����
			����������ҵ����������
			�������ţ�ҵ���������Ա����
			�շѷ�ʽ�����շѷ�ʽ^���^POS���׺�^|, ˵�����շѷ�ʽ����CASH���ֽ𣩡�POS��POS������BANK�����л��ˣ�����POSʱPOS���׺�Ϊ��ֵ�����Ҳ��ԭ�����෴��
			���ô���XS^��Ʒ����^-100^, ˵����ԭ�����ܷ��õ��෴��
			��λ����
			PBOSS������ţ�PBOSS������Ʒ���۶������
			BOSS���˹�����ţ�BOSSϵͳ����ʱ�ǼǵĹ������
	 *
	 */
	static public String packForCancelAccount(CancelAccountDataPack data){
		//ƴ �շѷ�ʽ��
		StringBuffer chargeStr = new StringBuffer(); 
		ChargeData chargeData = data.getChargeData();
		chargeStr.append(chargeData.getChargeType()).append(STR_SLIT_SYMBOL);
		chargeStr.append(chargeData.getMoney()).append(STR_SLIT_SYMBOL);
		if(ChargeData.CHARGE_TYPE_POS.equals(data.getChargeData().getChargeType())){
			chargeStr.append(chargeData.getPosNo());
		}
		chargeStr.append(STR_SLIT_SYMBOL).append(STR_END_SYMBOL);
		//ƴ ���ô�
		StringBuffer feeStr = new StringBuffer(); 
		feeStr.append("XS^��Ʒ����^").append(data.getFeeStr()).append(STR_SLIT_SYMBOL);
		
		StringBuffer sb = new StringBuffer(); 
		//sb.append(INCOME_ACCOUNT).append(WORD_SLIT_SYMBOL);//������
		sb.append(data.getWayid()).append(WORD_SLIT_SYMBOL); //��������
		sb.append(data.getOprcode()).append(WORD_SLIT_SYMBOL);//��������
		sb.append(chargeStr.toString()).append(WORD_SLIT_SYMBOL);//�շѷ�ʽ��
		sb.append(feeStr.toString()).append(WORD_SLIT_SYMBOL);//���ô�
		sb.append(data.getPbossNo()).append(WORD_SLIT_SYMBOL);//PBOSS�������
		sb.append(data.getBossNo()).append(WORD_END_SYMBOL);//BOSS���˹������
		sb.append("\n");
		
		return sb.toString();
	}

	/**
	 * 
	 	���ͱ��� :
		
		datatrans��ret~˵��;[����;�п��;]���ݶ�;
	
		���ݶθ�ʽ���������; ��BOSS�����˲��������Ĺ�����ţ�
			ret=0   �����ɹ�
			ret=1   δ�ҵ�������Ӧ����Ʒ��Դ
			ret=MMM ����ʧ�ܣ�Ҫ���ڡ�˵����������ʧ��ԭ��
	 * 
	 */
	static public CancelAccountResult unpackForCancelAccount(String retStr){
		CancelAccountResult result = new CancelAccountResult();
		String[] words = StringUtils.split(retStr.trim(),WORD_END_SYMBOL);
		if(words.length<2){
			throw new BossException("���ͱ��ĸ�ʽ������[" + retStr + "]");
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
