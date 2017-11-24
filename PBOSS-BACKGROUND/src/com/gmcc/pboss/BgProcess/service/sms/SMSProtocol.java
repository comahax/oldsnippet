/**
 * 
 */
package com.gmcc.pboss.BgProcess.service.sms;

/**
 * @author hbm
 * 协议类
 */
public class SMSProtocol {
	
	//短信营业厅调PBOSS命令字
	static public String INTERFACE_ACTIVITYRATIO = "77001";  //套卡激活率查询接口
	static public String INTERFACE_COMORDER = "77002";       //商品订购接口
	static public String INTERFACE_ORDERQUERY = "77003";     //订单查询接口

	static public String WORD_SLIT_SYMBOL = "~"; // 词分隔符
	static public String STR_SLIT_SYMBOL = "^"; // 串分隔符
	static public String WORD_END_SYMBOL = ";"; // 结束符号
	static public String STR_END_SYMBOL = "|"; // 结束符号
	static public String DATA_SLIT_SYMBOL = "#"; // 数据段分隔符号

	public static final String WRONG_FORMAT = "MMM~请求格式错误(wrong request format);";
	
	public static final String WRONG_COMMAND_STR = ";";

	static public boolean checkFormatIsOK(String msg) {
		if (msg == null) {
			return false;
		}
		if (msg.trim().length() < 6) { //至少要比命令字要长
			return false;
		}
		if(msg.indexOf(WORD_SLIT_SYMBOL) > 4){
			return true;
		}
		//@todo 添加拆串判断逻辑
		return false;
	}

	static public String getCommandStr(String msg) {
		return msg.substring(0, msg.indexOf(WORD_SLIT_SYMBOL));
	}
	
	static public String getContextStr(String msg) {
		return msg.substring(msg.indexOf(WORD_SLIT_SYMBOL)+1,msg.length()-1);
	}
}
