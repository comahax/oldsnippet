package com.gmcc.pboss.service.sms.result;

import java.util.List;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.sunrise.jop.common.utils.lang.StringUtils;

/**
 * 短信营业厅回送报文抽象类
 * @author Canigar
 * datatrans：ret~说明;[标题;列宽段];数据段;
 */
public abstract class SMSResult {
	
	public static final String RET_TYPE_SUCC_0 = "0"; //成功
	/**获取号码归属地市失败*/
	public static final String RET_TYPE_FAIL_1 = "1"; 
	public static final String RET_MESSAGE_FAIL_1 = "获取号码归属地市失败";
	public static final String RET_TYPE_FAIL_111 = "111"; //短信营业厅调用其他异常调用失败

	protected String ret; //返回码
	protected String message; //返回信息
	protected String meno; //说明信息[标题;列宽段]
	protected List<String> datas; //数据段
	
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
	 * 设置短信营业厅的列说明
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
