package com.gmcc.pboss.service.sms.result;

import java.util.List;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.sunrise.jop.common.utils.lang.StringUtils;

/**
 * ����Ӫҵ�����ͱ��ĳ�����
 * @author Canigar
 * datatrans��ret~˵��;[����;�п��];���ݶ�;
 */
public abstract class SMSResult {
	
	public static final String RET_TYPE_SUCC_0 = "0"; //�ɹ�
	/**��ȡ�����������ʧ��*/
	public static final String RET_TYPE_FAIL_1 = "1"; 
	public static final String RET_MESSAGE_FAIL_1 = "��ȡ�����������ʧ��";
	public static final String RET_TYPE_FAIL_111 = "111"; //����Ӫҵ�����������쳣����ʧ��

	protected String ret; //������
	protected String message; //������Ϣ
	protected String meno; //˵����Ϣ[����;�п��]
	protected List<String> datas; //���ݶ�
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer("");
		sb.append(getRet()).append(SMSProtocol.WORD_SLIT_SYMBOL);
		
		if(!StringUtils.isEmpty(getMessage())){
			if(getMessage().endsWith(SMSProtocol.WORD_END_SYMBOL)){
				sb.append(getMessage());
			}else{
				sb.append(getMessage()).append(SMSProtocol.WORD_END_SYMBOL);
			}
		}
		
		if(!StringUtils.isEmpty(getMeno())){
			if(getMeno().endsWith(SMSProtocol.WORD_END_SYMBOL)){
				sb.append(getMeno());
			}else{
				sb.append(getMeno()).append(SMSProtocol.WORD_END_SYMBOL);
			}
		}
		if(getDatas() != null && getDatas().size() != 0){
			for(String data : getDatas()){
				if(data.endsWith(SMSProtocol.WORD_END_SYMBOL)){
					sb.append(data);
				}else{
					sb.append(data).append(SMSProtocol.WORD_END_SYMBOL);
				}
			}
		}
		return  sb.toString();
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * ���ö���Ӫҵ������˵��
	 */
	public abstract String getMeno();

	public void setMeno(String meno){
		this.meno = meno;
	}

	public List<String> getDatas() {
		return datas;
	}

	public void setDatas(List<String> datas) {
		this.datas = datas;
	}
	
}
