package com.gmcc.pboss.biz.index.support;

import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.CommunicateConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-14
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������ҳ������
 */
public class IndexParameter extends CommunicatePlateauParameter{
	/**
	 * 
	 */
	private static final long serialVersionUID = -737390739489024728L;
	
	/**������Ϣ��*/
	private int psOfAffiche;
	/**֪ʶ����Ϣ��*/
	private int psOfKnowledge;
	/**ҵ����Ϣ��*/
	private int psOfOperation;
	/**�����ʾ���Ϣ��*/
	private int psOfQuestion;
	/**����������Ϣ��*/
	private int psOfPendinReq;
	/**�����ĵ���Ϣ��*/
	private int psOfInterlocu;
	/**�Ƿ�ֵ��ѯflashͼƬ*/
	private boolean blnFlashImage = false;
	
	
	
	public IndexParameter() {
		psOfAffiche = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMUNICATE_FILE, 
						CommunicateConfig.ADVINFO_PAGESIZE));

		psOfKnowledge = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMUNICATE_FILE, 
						CommunicateConfig.KR_PAGESIZE));
		
		psOfOperation = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMUNICATE_FILE, 
						CommunicateConfig.BIZ_PAGESIZE));
		
		psOfQuestion = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMUNICATE_FILE, 
						CommunicateConfig.QUESTION_PAGESIZE));
		
		psOfPendinReq = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMUNICATE_FILE, 
						CommunicateConfig.PR_PAGESIZE));
		
		psOfInterlocu = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMUNICATE_FILE, 
						CommunicateConfig.INTER_PAGESIZE));
	}
	public int getPsOfAffiche() {
		return psOfAffiche;
	}
	public void setPsOfAffiche(int psOfAffiche) {
		this.psOfAffiche = psOfAffiche;
	}
	public int getPsOfKnowledge() {
		return psOfKnowledge;
	}
	public void setPsOfKnowledge(int psOfKnowledge) {
		this.psOfKnowledge = psOfKnowledge;
	}
	public int getPsOfOperation() {
		return psOfOperation;
	}
	public void setPsOfOperation(int psOfOperation) {
		this.psOfOperation = psOfOperation;
	}
	public int getPsOfQuestion() {
		return psOfQuestion;
	}
	public void setPsOfQuestion(int psOfQuestion) {
		this.psOfQuestion = psOfQuestion;
	}
	public int getPsOfPendinReq() {
		return psOfPendinReq;
	}
	public void setPsOfPendinReq(int psOfPendinReq) {
		this.psOfPendinReq = psOfPendinReq;
	}
	public int getPsOfInterlocu() {
		return psOfInterlocu;
	}
	public void setPsOfInterlocu(int psOfInterlocu) {
		this.psOfInterlocu = psOfInterlocu;
	}
	public boolean isBlnFlashImage() {
		return blnFlashImage;
	}
	public void setBlnFlashImage(boolean blnFlashImage) {
		this.blnFlashImage = blnFlashImage;
	}
}
