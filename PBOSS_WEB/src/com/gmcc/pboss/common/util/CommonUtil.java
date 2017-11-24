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
 * ���˹�˾Ӫ�˿�����
 * @author yuwenjun
 * @date 2009-8-6
 * @update 2010-05-05
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż�
 * ����������������
 */
public class CommonUtil {
	protected static final Log logger = LogFactory.getLog(AbstractAction.class);
	/**
     * �����ж��Ƿ�Ϊ�й��ƶ������������ʽ
     */
    public static final String CHINAMOBILE_REGEX = "^1(3[4-9]|5[0-27-9]|88)\\d{8}$";
	/**
	 * ���ַ�����ָ���ָ����ָ�ڰ�ָ��λ��ȡ����
	 * @param str ���ָ��ַ���
	 * @param regex �ָ��
	 * @param position ȡ�ڼ�λ
	 * @return Ϊ�õ�����null
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
	 * �ж��ַ����Ƿ�Ϊ�ջ���ΪNULL
	 * @param str ���ж��ַ���
	 * @return false or true
	 */
	public static boolean isEmptyOrNull(String str	){
		return CharacterStrUtil.isBlank(str);
	}
	/**
     * �жϺ����Ƿ�Ϊ�й��ƶ��ĺ��룬�жϹ��򣬷�������������ʽ�ĺ��붼Ϊ�й��ƶ��ĺ���
     * ������ʽ��^1(3[4-9]|5[0-27-9]|88)\\d{8}$
     * @param mobile Ҫ�жϵ��ֻ�����
     * @return boolean trueΪ���й��ƶ��ĺ��룬false����
     */
    public static boolean isChinaMobile(String mobile) {
		return ValidateUtil.isChinaMobile(mobile);
    }
    /**
     * ���ݴ���ĸ�ʽ���ص�������ڣ� �������ĸ�ʽΪ��ʱ��Ĭ�Ϸ��ظ�ʽΪyyyy-MM-dd
     * @param s Ҫ���ص����ڸ�ʽ����yyyy-MM-dd HH:mm:ss�ȣ�����Ĭ��Ϊyyyy-MM-dd
     * @return String ��������ַ���
     */
    public static String getToday(String s) {
		return TimeUtil.getToday(s);
    }
    /**
     * ���ݴ���ĸ�ʽ������������ڣ� �������ĸ�ʽΪ��ʱ��Ĭ�Ϸ��ظ�ʽΪyyyy-MM-dd
     * @param s Ҫ���ص����ڸ�ʽ����yyyy-MM-dd HH:mm:ss�ȣ�����Ĭ��Ϊyyyy-MM-dd
     * @return String ����������ַ���
     */
    public static String getYesterday(String s) {
		return TimeUtil.getYesterday(s);
    }
    /**
     * �ȵ���ǰ�µ�ǰһ����
     * @return ���ظ�ʽΪYYYYMM
     */
    public static String getMonth() {
    	return TimeUtil.getLastMonth(TimeUtil.YEARMONTH);
    }
    /**
     * �ȵ���ǰ�µı�׼����ʽ
     * @return ���ظ�ʽΪYYYYMM
     */
    public static String getNowMonthString() {
		return TimeUtil.getNowMonth(TimeUtil.YEARMONTH);
    }
    
    /**
     * ���ص�ǰ��MM
     * @return
     */
    public static String getNowMonth(){
    	return TimeUtil.getCurrentlyMonthStr();
    }
    
    /**
     * �õ���ǰ��DD
     * @return
     */
    public static String getNowDate(){
    	return TimeUtil.getCurrentlyDayStr();
    }
    /**
     * ���ݴ���ĸ�ʽ����ÿ�������һ������ڣ� �������ĸ�ʽΪ��ʱ��Ĭ�Ϸ��ظ�ʽΪyyyy-MM-dd
     * @param s Ҫ���ص����ڸ�ʽ����yyyy-MM-dd HH:mm:ss�ȣ�Ĭ��Ϊyyyy-MM-dd
     * @return String ���������һ����ַ���
     */
    public static String getLastDayOfMonth(String s) {
		return TimeUtil.getEndDayOfMonth(s);
    }
    /**
     * ��ȡ��ǰ���
     * @return ���
     */
    public static int getNowYear() {
		return TimeUtil.getCurrentlyYear();
    }
    
    /**
     * �������֤�� �ж��û��Ƿ�����������Ƿ���ȷ
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
    

	// ---��ȡʱ���ʽ�ַ���
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
			dResult = y + "��" + m + "��" + d + "��";
		if (iStyle == 31)
			dResult = y + "��" + m + "��";
		if (iStyle == 30)
			dResult = y + "��" + m + "��" + d + "�� " + h + "ʱ" + n + "��";
		if (iStyle == 300)
			dResult = y + "��" + m + "��" + d + "�� " + h + "ʱ" + n + "��" + s
					+ "��";

		if (iStyle == 4)
			dResult = yy + "��" + mm + "��" + dd + "��";
		if (iStyle == 41) {
			String strTemp = "";
			switch (w) {
			case 0:
				strTemp = "������";
				break;
			case 1:
				strTemp = "����һ";
				break;
			case 2:
				strTemp = "���ڶ�";
				break;
			case 3:
				strTemp = "������";
				break;
			case 4:
				strTemp = "������";
				break;
			case 5:
				strTemp = "������";
				break;
			case 6:
				strTemp = "������";
				break;
			}// switch
			dResult = yy + "��" + mm + "��" + dd + "�� " + strTemp;
		}
		if (iStyle == 40)
			dResult = yy + "��" + mm + "��" + dd + "�� " + hh + "ʱ" + nn + "��";
		if (iStyle == 42)
			dResult = yy + "��" + mm + "��";
		if (iStyle == 400)
			dResult = yy + "��" + mm + "��" + dd + "�� " + hh + "ʱ" + nn + "��"
					+ ss + "��";

		if (iStyle == 5)
			dResult = yy + "/" + mm + "/" + dd;
		if (iStyle == 50)
			dResult = yy + "/" + mm + "/" + dd + " " + hh + ":" + nn;
		if (iStyle == 500)
			dResult = yy + "/" + mm + "/" + dd + " " + hh + ":" + nn + ":" + ss;

		if (iStyle == 60)
			dResult = mm + "��" + dd + "�� ";
		if (iStyle == 600)
			dResult = mm + "��" + dd + "�� " + hh + "ʱ" + nn + "��" + ss + "��";

		if (iStyle == 11)
			dResult = h + ":" + n + ":" + s;

		return dResult;
	}// getDateTime()
	/**
	 * ��������ʾ
	 * @param setMonth --6λ���֣�������4λ��+2λ��
	 * @return
	 */
	public static String getShowMonth(String setMonth){
		String setParam = setMonth+"01";
		try {
			Date getSet = DateUtil.convertStringToDate("yyyyMMdd",setParam);
			return CommonUtil.getDateTime(getSet, 42);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("[CommonUtil.getShowTimeName]����ת������:"+e.getMessage());
			logger.warn("[CommonUtil.getShowTimeName]����ת������:"+e.getMessage());
			return null;
		}
	}
	/**
	 * �����쳣��ӡ��Ϣ
	 * @param e
	 * @return
	 */
	public static String createExceptionString(Exception e){
		StringBuffer info = new StringBuffer();
		
		info.append(e.toString());
		
		return info.toString();
	}
	/**
	 * ���ɹ�����Ϣ����������Bean
	 * @param bean		��������������Ϣ
	 * @param now		ʱ��
	 * @param auditWork	������Ϣ
	 * @param stepid	����id
	 * @param oprCode   ��������
	 * @return
	 */
	public static ChPwAdvinfo createPendingTask(PendingTaskConfigBean bean, Date now,
			ChPwAuditwork auditWork,String stepid,String oprCode ){
		ChPwAdvinfo info = createPendingTask(bean, now, auditWork, stepid);
		info.setOprcode(oprCode);
		return info;
	}
	/**
	 * ���ɹ�����Ϣ����������Bean
	 * @param bean		��������������Ϣ
	 * @param now		ʱ��
	 * @param auditWork	������Ϣ
	 * @param stepid	����id
	 * @return
	 */
	public static ChPwAdvinfo createPendingTask(PendingTaskConfigBean bean, Date now,
										ChPwAuditwork auditWork,String stepid ){
		
		ChPwAdvinfo info = new ChPwAdvinfo();
		info.setTitle(bean.getTitel());
		info.setUrl(getPendingTaskURL(bean.getUrl(),auditWork.getApplyno(),auditWork.getSeqid(),stepid));
		info.setType(new Long(CPDictionary.PENDING_REQUEST));//��������
		info.setReleasetime(now);
		info.setPlantime(DateUtil.getDate(now,bean.getPlantime()));
		info.setDesttype(new Long(bean.getDesttype()));
		info.setSmsnotify(new Long(bean.getSmsnotify()));
		info.setNdapproval(new Long(bean.getNdapproval()));
		info.setState(new Long(bean.getState()));
		return info;
	}
	/**
	 * �õ���������URL
	 * @param url 		�����ļ��е�URL
	 * @param applyno 	����ID
	 * @param seqid		����
	 * @param stepid	����id
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
	// ����fOmit
	// ������ʡ���ַ���
	// ������
	// strText -- ָ���ַ���
	// intKeepLen -- ָ��ʡ�Գ���
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
     * ɾ��input�ַ����е�html��ʽ  
     *   
     * @param input  
     * @param length  
     * @return  
     */  
    public static String moveHTML(String input, int length) {   
        if (input == null || input.trim().equals("")) {   
            return "";   
        }   
         // ȥ������htmlԪ��,     
        String str = input.replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "").replaceAll("</[a-zA-Z]+[1-9]?>", "");  
        
//        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
//        str = str.replaceAll("[(/>)<]", "");
        //ȥ���ո�&nbsp;
        str = str.replaceAll("&nbsp;", "");  
        if (length>0){
        	str = fOmit(str, length); 
        }
        return str;
    }  
    
	/**
	 * ��PropertyUtils.getProperty�Ĳ���,����ȡ��Map���Ӧkey��ֵ
	 * @param value
	 * @param arg
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
    public static Object getProperty(Object value,String key) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Object obj = null;
		if (value instanceof Map){//�ж�value�Ƿ�Map��ʵ��,��ΪMap�Ѿ�Ŀ��ӿ�,����ҪisAssignableFrom���жϳ���
			//���value��Map������,ֱ��ȡKEY
			Map m = (Map)value;
			obj = m.get(key);
			
		}else{
			obj =  PropertyUtils.getProperty(value, key);
		}
		
		return obj;
	}
}
