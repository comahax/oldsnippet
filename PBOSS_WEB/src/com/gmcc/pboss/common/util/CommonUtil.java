package com.gmcc.pboss.common.util;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.common.util.date.TimeUtil;
import com.common.util.string.CharacterStrUtil;
import com.common.util.validate.ValidateUtil;
import com.gmcc.pboss.biz.communi.CPDictionary;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.config.bean.PendingTaskConfigBean;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;

/**
 * 从兴公司营账开发部
 * @author yuwenjun
 * @date 2009-8-6
 * @update 2010-05-05
 * 所属项目：PBOSS
 * 所属模块：门户
 * 描述：公共帮助类
 */
public class CommonUtil {
	protected static final Log logger = LogFactory.getLog(AbstractAction.class);
	/**
     * 用于判断是否为中国移动号码的正则表达式
     */
    public static final String CHINAMOBILE_REGEX = "^1(3[4-9]|5[0-27-9]|88)\\d{8}$";
	/**
	 * 将字符串按指定分隔符分割，在按指定位置取出。
	 * @param str 待分割字符串
	 * @param regex 分割符
	 * @param position 取第几位
	 * @return 为得到返回null
	 */
	public static String getPart(String str, String regex, int position){
		String r = null;
		String[]s = str.split(regex);
		if(position >= 0 || position < s.length){
			r = s[position];
		}
		return r;
	}
	/**
	 * 判断字符串是否为空或者为NULL
	 * @param str 待判断字符串
	 * @return false or true
	 */
	public static boolean isEmptyOrNull(String str	){
		return CharacterStrUtil.isBlank(str);
	}
	/**
     * 判断号码是否为中国移动的号码，判断规则，符合以下正则表达式的号码都为中国移动的号码
     * 正则表达式：^1(3[4-9]|5[0-27-9]|88)\\d{8}$
     * @param mobile 要判断的手机号码
     * @return boolean true为是中国移动的号码，false不是
     */
    public static boolean isChinaMobile(String mobile) {
		return ValidateUtil.isChinaMobile(mobile);
    }
    /**
     * 根据传入的格式返回当天的日期， 如果传入的格式为空时，默认返回格式为yyyy-MM-dd
     * @param s 要返回的日期格式，如yyyy-MM-dd HH:mm:ss等，不传默认为yyyy-MM-dd
     * @return String 代表当天的字符串
     */
    public static String getToday(String s) {
		return TimeUtil.getToday(s);
    }
    /**
     * 根据传入的格式返回昨天的日期， 如果传入的格式为空时，默认返回格式为yyyy-MM-dd
     * @param s 要返回的日期格式，如yyyy-MM-dd HH:mm:ss等，不传默认为yyyy-MM-dd
     * @return String 代表昨天的字符串
     */
    public static String getYesterday(String s) {
		return TimeUtil.getYesterday(s);
    }
    /**
     * 等到当前月的前一个月
     * @return 返回格式为YYYYMM
     */
    public static String getMonth() {
    	return TimeUtil.getLastMonth(TimeUtil.YEARMONTH);
    }
    /**
     * 等到当前月的标准化格式
     * @return 返回格式为YYYYMM
     */
    public static String getNowMonthString() {
		return TimeUtil.getNowMonth(TimeUtil.YEARMONTH);
    }
    
    /**
     * 返回当前月MM
     * @return
     */
    public static String getNowMonth(){
    	return TimeUtil.getCurrentlyMonthStr();
    }
    
    /**
     * 得到当前天DD
     * @return
     */
    public static String getNowDate(){
    	return TimeUtil.getCurrentlyDayStr();
    }
    /**
     * 根据传入的格式返回每个月最后一天的日期， 如果传入的格式为空时，默认返回格式为yyyy-MM-dd
     * @param s 要返回的日期格式，如yyyy-MM-dd HH:mm:ss等，默认为yyyy-MM-dd
     * @return String 代表当月最后一天的字符串
     */
    public static String getLastDayOfMonth(String s) {
		return TimeUtil.getEndDayOfMonth(s);
    }
    /**
     * 获取当前年份
     * @return 年份
     */
    public static int getNowYear() {
		return TimeUtil.getCurrentlyYear();
    }
    
    /**
     * 邮箱的验证， 判断用户是否输入的邮箱是否正确
     * @param email
     * @return false or true
     */
    public static boolean isEmail(String email) {
		return ValidateUtil.isEmail(email);
    }
    
    public static HashMap<String, String> getQueryToTable(String queryString){
    	LinkedHashMap<String, String> rtn = new LinkedHashMap<String, String>();
    	String[] queryAll = queryString.split("&");
		String key=null,value=null;
    	for(String queryValue:queryAll ){
    		String[] dtl = queryValue.split("=");
    		key = dtl[0];
    		if (dtl.length>1){ 
    			value = dtl[1];
    		}else{
    			value = null;
    		}//if
    		rtn.put(key, value);
    	}//for
    	return rtn;
    }
    

	// ---获取时间格式字符串
	public static String getDateTime(java.util.Date dDateTime, int iStyle) {
		//
		if (dDateTime == null)
			return "";
		String dResult = dDateTime.toString();
		String y = Integer.toString(dDateTime.getYear() + 1900);
		String m = Integer.toString(dDateTime.getMonth() + 1);
		String d = Integer.toString(dDateTime.getDate());
		String h = Integer.toString(dDateTime.getHours());
		String n = Integer.toString(dDateTime.getMinutes());
		String s = Integer.toString(dDateTime.getSeconds());
		int w = dDateTime.getDay();

		String yy = y;
		y = y.substring(2, 4);
		String mm = m;
		String dd = d;
		String hh = h;
		String nn = n;
		String ss = s;
		if (m.length() == 1)
			mm = "0" + m;
		if (d.length() == 1)
			dd = "0" + d;
		if (h.length() == 1)
			hh = "0" + h;
		if (n.length() == 1)
			nn = "0" + n;
		if (s.length() == 1)
			ss = "0" + s;

		if (iStyle == 1)
			dResult = y + "-" + m + "-" + d;
		if (iStyle == 10)
			dResult = y + "-" + m + "-" + d + " " + h + ":" + n;
		if (iStyle == 100)
			dResult = y + "-" + m + "-" + d + " " + h + ":" + n + ":" + s;

		if (iStyle == 2)
			dResult = yy + "-" + mm + "-" + dd;
		if (iStyle == 20)
			dResult = yy + "-" + mm + "-" + dd + " " + hh + ":" + nn;
		if (iStyle == 200)
			dResult = yy + "-" + mm + "-" + dd + " " + hh + ":" + nn + ":" + ss;

		if (iStyle == 3)
			dResult = y + "年" + m + "月" + d + "日";
		if (iStyle == 31)
			dResult = y + "年" + m + "月";
		if (iStyle == 30)
			dResult = y + "年" + m + "月" + d + "日 " + h + "时" + n + "分";
		if (iStyle == 300)
			dResult = y + "年" + m + "月" + d + "日 " + h + "时" + n + "分" + s
					+ "秒";

		if (iStyle == 4)
			dResult = yy + "年" + mm + "月" + dd + "日";
		if (iStyle == 41) {
			String strTemp = "";
			switch (w) {
			case 0:
				strTemp = "星期日";
				break;
			case 1:
				strTemp = "星期一";
				break;
			case 2:
				strTemp = "星期二";
				break;
			case 3:
				strTemp = "星期三";
				break;
			case 4:
				strTemp = "星期四";
				break;
			case 5:
				strTemp = "星期五";
				break;
			case 6:
				strTemp = "星期六";
				break;
			}// switch
			dResult = yy + "年" + mm + "月" + dd + "日 " + strTemp;
		}
		if (iStyle == 40)
			dResult = yy + "年" + mm + "月" + dd + "日 " + hh + "时" + nn + "分";
		if (iStyle == 42)
			dResult = yy + "年" + mm + "月";
		if (iStyle == 400)
			dResult = yy + "年" + mm + "月" + dd + "日 " + hh + "时" + nn + "分"
					+ ss + "秒";

		if (iStyle == 5)
			dResult = yy + "/" + mm + "/" + dd;
		if (iStyle == 50)
			dResult = yy + "/" + mm + "/" + dd + " " + hh + ":" + nn;
		if (iStyle == 500)
			dResult = yy + "/" + mm + "/" + dd + " " + hh + ":" + nn + ":" + ss;

		if (iStyle == 60)
			dResult = mm + "月" + dd + "日 ";
		if (iStyle == 600)
			dResult = mm + "月" + dd + "日 " + hh + "时" + nn + "分" + ss + "秒";

		if (iStyle == 11)
			dResult = h + ":" + n + ":" + s;

		return dResult;
	}// getDateTime()
	/**
	 * 搞年月显示
	 * @param setMonth --6位数字，必须是4位年+2位月
	 * @return
	 */
	public static String getShowMonth(String setMonth){
		String setParam = setMonth+"01";
		try {
			Date getSet = DateUtil.convertStringToDate("yyyyMMdd",setParam);
			return CommonUtil.getDateTime(getSet, 42);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("[CommonUtil.getShowTimeName]日期转换出错:"+e.getMessage());
			logger.warn("[CommonUtil.getShowTimeName]日期转换出错:"+e.getMessage());
			return null;
		}
	}
	/**
	 * 创建异常打印信息
	 * @param e
	 * @return
	 */
	public static String createExceptionString(Exception e){
		StringBuffer info = new StringBuffer();
		
		info.append(e.toString());
		
		return info.toString();
	}
	/**
	 * 生成公告信息表及待办任务Bean
	 * @param bean		待办任务配置信息
	 * @param now		时间
	 * @param auditWork	工单信息
	 * @param stepid	步骤id
	 * @param oprCode   发布工号
	 * @return
	 */
	public static ChPwAdvinfo createPendingTask(PendingTaskConfigBean bean, Date now,
			ChPwAuditwork auditWork,String stepid,String oprCode ){
		ChPwAdvinfo info = createPendingTask(bean, now, auditWork, stepid);
		info.setOprcode(oprCode);
		return info;
	}
	/**
	 * 生成公告信息表及待办任务Bean
	 * @param bean		待办任务配置信息
	 * @param now		时间
	 * @param auditWork	工单信息
	 * @param stepid	步骤id
	 * @return
	 */
	public static ChPwAdvinfo createPendingTask(PendingTaskConfigBean bean, Date now,
										ChPwAuditwork auditWork,String stepid ){
		
		ChPwAdvinfo info = new ChPwAdvinfo();
		info.setTitle(bean.getTitel());
		info.setUrl(getPendingTaskURL(bean.getUrl(),auditWork.getApplyno(),auditWork.getSeqid(),stepid));
		info.setType(new Long(CPDictionary.PENDING_REQUEST));//待办任务
		info.setReleasetime(now);
		info.setPlantime(DateUtil.getDate(now,bean.getPlantime()));
		info.setDesttype(new Long(bean.getDesttype()));
		info.setSmsnotify(new Long(bean.getSmsnotify()));
		info.setNdapproval(new Long(bean.getNdapproval()));
		info.setState(new Long(bean.getState()));
		return info;
	}
	/**
	 * 得到待办任务URL
	 * @param url 		配置文件中的URL
	 * @param applyno 	申请ID
	 * @param seqid		单号
	 * @param stepid	步骤id
	 * @return
	 */
	public static String getPendingTaskURL(String url, Long applyno, 
										Long seqid,String stepid){
		StringBuffer newUrl = new StringBuffer();
		newUrl.append(url).append('?');
//		newUrl.append("form.auditstatus_work=0").append('&');
//		newUrl.append("form.stepid=").append(stepid).append('&');
		newUrl.append("param._pk=").append(applyno).append('&');
		newUrl.append("form.seqid=").append(seqid);
		
		return newUrl.toString();
	}
	// ------------------------------------------------------
	// 程序：fOmit
	// 描述：省略字符串
	// 参数：
	// strText -- 指定字符串
	// intKeepLen -- 指定省略长度
	// ------------------------------------------------------
	public static String fOmit(String strText, int KeepLen) {
		String strOmit = "... ";
		if (strText == null)
			return "";
		if (((strText + strOmit).length()) <= KeepLen)
			return strText;
		else
			try {
				return (strText.substring(0, KeepLen - 2) + strOmit);
			} catch (Exception e) {
				return strText;
			}
	}// fOmit
	
	/**  
     * 删除input字符串中的html格式  
     *   
     * @param input  
     * @param length  
     * @return  
     */  
    public static String moveHTML(String input, int length) {   
        if (input == null || input.trim().equals("")) {   
            return "";   
        }   
         // 去掉所有html元素,     
        String str = input.replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "").replaceAll("</[a-zA-Z]+[1-9]?>", "");  
        
//        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
//        str = str.replaceAll("[(/>)<]", "");
        //去掉空格&nbsp;
        str = str.replaceAll("&nbsp;", "");  
        if (length>0){
        	str = fOmit(str, length); 
        }
        return str;
    }  
    
	/**
	 * 对PropertyUtils.getProperty的补充,可以取得Map里对应key的值
	 * @param value
	 * @param arg
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
    public static Object getProperty(Object value,String key) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Object obj = null;
		if (value instanceof Map){//判断value是否Map的实现,因为Map已经目标接口,不需要isAssignableFrom来判断超类
			//如果value是Map的子类,直接取KEY
			Map m = (Map)value;
			obj = m.get(key);
			
		}else{
			obj =  PropertyUtils.getProperty(value, key);
		}
		
		return obj;
	}
}
