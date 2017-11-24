package com.sunrise.boss.business.fee.common;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.delegate.common.subscriber.SubscriberDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.PublicUtils;

public class FixfeeUtils {
	/*
	 *�̶���ilog�����������״̬�ֶ�
	 */
	public static final Long ILOGTESTREQUESTSTATE_TEST = new Long(0);
	public static final Long ILOGTESTREQUESTSTATE_SUCESS = new Long(1);
	public static final Long ILOGTESTREQUESTSTATE_RETEST= new Long(2);
	public static final Long ILOGTESTREQUESTSTATE_FAIL = new Long(3);
	
	/*
	 *�̶���ilog���������������־
	 */
	public static final Short ILOGUPLOADREQUESTFLAG_REQUEST = new Short("0");
	public static final Short ILOGUPLOADREQUESTFLAG_DONE= new Short("1");
	
	/*
	 *�̶���ilog�����ϴ�ftp����������(ϵͳ����)
	 */
	public static final Long IMPILOGRULE_SERVDIR = new Long(38);
	
	/**
	 * ͨ���ֻ������ȡ�û���ʶ
	 * @param servNum �ֻ�����
	 * @param user ��½�û�
	 * @return subsid �û���ʶ
	 * @throws Exception
	 * modifyday:20081120(zengwenqu)
	 */
	public static Long getValidSubsidByServnum(String servNum,User user) throws Exception{
		Long subsid = null;
		try {
			BaseListVO listvo = new BaseListVO();
			
			//������δ��������⣬�����޸�(20081120)
			//Map map = listvo.getQueryConditions();
			//map.put("servnumber", servNum);
			//map.put("start_validbill", getCurMonthBegin());
			//map.put("end_validbill", getCurMothEnd());
			
			Map map = new HashMap();//�޸ĺ����(20081120)
			map.put("servnumber", servNum);//�޸ĺ����(20081120)
			map.put("start_validbill", getCurMonthBegin());//�޸ĺ����(20081120)
			map.put("end_validbill", getCurMothEnd());//�޸ĺ����(20081120)
			listvo.setQueryConditions(map);//�޸ĺ����(20081120)
			
			subsid = new SubscriberDelegate().getValidSusbidByServnumber(listvo, user);
		} catch (Exception e) {
			throw new Exception("�Ҳ�����Ч���û���ʶ!");
		}
		return subsid;
	}
	
	public static Date getCurMonthBegin() throws Exception{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String dateStr =  PublicUtils.formatUtilDate(calendar.getTime(), "yyyy-MM-dd") + " 00:00:00";
		return PublicUtils.UtilStrToDate(dateStr);
	}
	
	public static Date getCurMothEnd() throws Exception{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		String dateStr =  PublicUtils.formatUtilDate(calendar.getTime(), "yyyy-MM-dd") + " 23:59:59";
		return PublicUtils.UtilStrToDate(dateStr);
	}
	
	public static String getPrevalidbillcyc(String validbillcyc){
		String date =validbillcyc;
		try {
			Calendar cal = Calendar.getInstance();
			if (StringUtils.isEmpty(validbillcyc)){
				cal.setTime(new Date());
			}else {
				String dStr = Long.parseLong(validbillcyc) + 1 + "";
				cal.setTime(PublicUtils.UtilStrToDate(dStr, "yyyyMMdd"));
			}
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
			date = PublicUtils.formatUtilDate(cal.getTime(), "yyyyMM'00'");
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
