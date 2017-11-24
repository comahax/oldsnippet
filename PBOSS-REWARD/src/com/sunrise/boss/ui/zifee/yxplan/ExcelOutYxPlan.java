package com.sunrise.boss.ui.zifee.yxplan;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.ExcelCodeToName;
import com.sunrise.boss.common.utils.export.ExcelMoreCodeToName;
import com.sunrise.boss.common.utils.export.ExportDataCreator;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;


/**
 * Ӫ����������Excel
 * 
 * @author luozhoujie
 * 
 */
public class ExcelOutYxPlan extends ExportDataCreator {

	public ExcelOutYxPlan(User user) {
		super(user);
	}
	private Logger log = Logger.getLogger(ExcelOutYxPlan.class);
	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) queryVO;
		//Ĭ�Ϸ�ҳ����
		if (form.get_pageno() != null
				&& form.get_pageno().trim().length() != 0) {
			;
		} else {
			form.set_pageno(WebConstant.DEFAULT_PAGE);
		}
		/*
		if (form.get_pagesize() != null
				&& form.get_pagesize().trim().length() != 0) {
			;
		} else {
				form.set_pagesize(WebConstant.DEFAULT_LINES_PER_PAGE);			
		}*/
		form.set_pagesize("200");//ÿҳ200����¼
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		YxPlanListVO listVO = new YxPlanListVO();
		BeanUtils.copyProperties(listVO, form);// ���ú�listVO����Ϊ��ѯ����		 
		listVO.set_ne_groupflag("0"); // 1 ��, 0
										// ��������ǡ�Ӫ�������飬����[Ӫ����������]�в��ɼ�����[Ӫ�������������]�ж�Ӫ�����������
		if (form.getStartdate() != null && !"".equals(form.getStartdate())) {
			listVO.set_dnl_startdate(df.format(form.getStartdate())
					+ " 00:00:00");
			listVO.set_dnm_startdate(df.format(form.getStartdate())
					+ " 23:59:59");
			form.setStartdate(null);
		}
		if (form.getStopdate() != null && !"".equals(form.getStopdate())) {
			listVO.set_dnl_stopdate(df.format(form.getStopdate())
					+ " 00:00:00");
			listVO.set_dnm_stopdate(df.format(form.getStopdate())
					+ " 23:59:59");
			form.setStopdate(null);
		}
//		���Ʋ�ѯ�����������й�˾�Լ�ȫʡ��Ӫ��������ȫ����Ӫ������ modify by luozhoujie 2006-11-29
		if (form.get_se_areacode() == null || "".equals(form.get_se_areacode())) {				
			//����ͳһӪ����,ȫʡ,�й�˾,�����ʶΪ��Ҳ�ڲ�ѯ��Χ��
			String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"+user.getCityid()+"')) ";
			listVO.set_sql_areacode(_sql_areacode);
		}
		YxPlanDelegate delegate = new YxPlanDelegate();
		DataPackage dp = new DataPackage();
		dp = delegate.doQuery(listVO, user);
		int rowcount = dp.getRowCount();
		int pageSize = (new Integer(listVO.get_pagesize())).intValue();
		int totalPageNum = rowcount/pageSize;
		if (rowcount%pageSize > 0) {
			totalPageNum++;
        }
		
		addOutputProperty(0, "yxplanid", null, null);
		addOutputProperty(0, "yxplanname", null, null);
		addOutputProperty(0, "areacode", null, null);
		addOutputProperty(0, "yxplancode", null, null);
		addOutputProperty(0, "planbigkind", CODE2NAME, null);
		addOutputProperty(0, "plankind", CODE2NAME, null);	
		addOutputProperty(0, "checkercode", null, null);
		addOutputProperty(0, "operatorcode", null, null);
		addOutputProperty(0, "startdate", DATE, "yyyy-MM-dd HH:mm:ss");
		addOutputProperty(0, "stopdate", DATE, "yyyy-MM-dd HH:mm:ss");
		addOutputProperty(0, "discscope", null, null);
		addOutputProperty(0, "yxplangroupid", null, null);
		addOutputProperty(0, "privelgepro", CODE2NAME, null);
		addOutputProperty(0, "bindpackageflag", CODE2NAME, null);
		addOutputProperty(0, "bindmonths", null, null);
		addOutputProperty(0, "bookflag", CODE2NAME, null);
		//addOutputProperty(0, "rcprepayflag", CODE2NAME, null);
		addOutputProperty(0, "couldusetimes", null, null);
		addOutputProperty(0, "mindisccycle", null, null);
		addOutputProperty(0, "discoffset", null, null);
		addOutputProperty(0, "timeunit", CODE2NAME, null);
		addOutputProperty(0, "starttimetype", CODE2NAME, null);
		addOutputProperty(0, "groupflag", CODE2NAME, null);
		addOutputProperty(0, "printflag", CODE2NAME, null);
		addOutputProperty(0, "recfeeprivflag", CODE2NAME, null);
		addOutputProperty(0, "source", null, null);
		addOutputProperty(0, "backupflag", CODE2NAME, null);
		addOutputProperty(0, "feecalcprivflag", CODE2NAME, null);
		addOutputProperty(0, "isoutmemberpriv", CODE2NAME, null);
		//addOutputProperty(0, "stopuserrentflag", CODE2NAME, null);
		addOutputProperty(0, "fixfeespecflag", CODE2NAME, null);
//		��ʱ����05.29by Jerimy Wang 
		addOutputProperty(0, "specialflag", CODE2NAME, null);
		addOutputProperty(0, "feecomment", null, null);
		addOutputProperty(0, "remark", null, null);
		int countNum=1 ;
		while(countNum<=totalPageNum)
		{
			List list = null;
			try{
			listVO.set_pageno(String.valueOf(countNum));			
			dp = delegate.doQuery(listVO, user);
			if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
				list = (List) dp.getDatas();
			}			
		    }catch(Exception e){
		    	log.error("ExcelOut Error: doQuery error!");
		    	e.printStackTrace();
		    	throw new Exception();
		    }
		    if (list != null && list.size() > 0 && os != null) {
				write(os, list.iterator(), new Class[] { YxPlanVO.class });
			}
			if(list == null || list.size() < 200){ 
				break;	
			}
			list.clear();
			countNum++;
		}
		close();
	}

	protected void writeTitle() {
		/*05.29 ���ε�"���ⷽ����־"*/
		this.title = new String[] { "Ӫ��������ʶ", "Ӫ����������", "�����ʶ", "ȫʡ��ʶ", "Ӫ����������","Ӫ���������",
				 "�����˹���", "����Ա����", "��������", "ͣ������", "�Żݷ�Χ", 
				"Ӫ�����������ʶ", "�Ż�����","�Ƿ������ײ�", "������" ,
				"�Ƿ�����ԤԼ", "�����ô���", "��С�Ż�����","�Ż�����ƫ����",
				"����ʱ�䵥Ԫ", "��Чʱ�����", "�Ƿ�Ӫ��������", "�Ƿ��ӡ������","�Ƿ�Ӫҵ���Ż�",
				"��Դ", "�Ƿ񱸷�", "�Ƿ�����Ż�", "�Ƿ������Ա�Ż�","�̶��������ʶ","���ⷽ����־",
				"�ʷ�˵��","˵��"};
	}

	protected String codeToName(String propertyName, String code, User user) {
		if (propertyName!=null && "planbigkind".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$PC_BIGKIND", code, user);
		}
		if (propertyName!=null && "plankind".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$PC_YXPLANKIND", code, user);
		}
		if(StringUtils.equals(propertyName, "specialflag")){
			ExcelMoreCodeToName et = new ExcelMoreCodeToName();
			code = et.moreCodeToName("$PC_SPECIALPLAN", code, user);
		}
		if (propertyName!=null && "privelgepro".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$PC_PRIVELGEPRO", code, user);
		}
		if (propertyName!=null && "bindpackageflag".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if(StringUtils.equals(propertyName, "bookflag")){
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$PC_BOOKFLAG", code, user);
		}
		if (propertyName!=null && "rcprepayflag".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if(StringUtils.equals(propertyName, "timeunit")){
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("$PC_TIMEUNIT", code, user);
		}
		if (propertyName!=null && "starttimetype".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_STARTIMETYPE", code, user);
		}
		if(StringUtils.equals(propertyName, "groupflag")){
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if (propertyName!=null && "printflag".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if(StringUtils.equals(propertyName, "recfeeprivflag")){
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if (propertyName!=null && "backupflag".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if(StringUtils.equals(propertyName, "feecalcprivflag")){
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if (propertyName!=null && "isoutmemberpriv".equals(propertyName)) {
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		if(StringUtils.equals(propertyName, "stopuserrentflag")){
			ExcelCodeToName et = new ExcelCodeToName();
			code = et.codeToName("#ZIFEE_YON", code, user);
		}
		return code;
	}

}
