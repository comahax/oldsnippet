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
 * 营销方案导出Excel
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
		//默认分页条件
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
		form.set_pagesize("200");//每页200条记录
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		YxPlanListVO listVO = new YxPlanListVO();
		BeanUtils.copyProperties(listVO, form);// 设置好listVO，作为查询条件		 
		listVO.set_ne_groupflag("0"); // 1 是, 0
										// 否（如果“是”营销方案组，则在[营销方案管理]中不可见，在[营销方案分组管理]中对营销方案组管理）
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
//		限制查询本工号所属市公司以及全省性营销方案，全国性营销方案 modify by luozhoujie 2006-11-29
		if (form.get_se_areacode() == null || "".equals(form.get_se_areacode())) {				
			//集团统一营销案,全省,市公司,区域标识为空也在查询范围内
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
//		暂时屏蔽05.29by Jerimy Wang 
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
		/*05.29 屏蔽掉"特殊方案标志"*/
		this.title = new String[] { "营销方案标识", "营销方案名称", "区域标识", "全省标识", "营销方案大类","营销方案类别",
				 "审批人工号", "操作员工号", "启动日期", "停用日期", "优惠范围", 
				"营销方案分组标识", "优惠属性","是否捆绑套餐", "捆绑期" ,
				"是否允许预约", "可享用次数", "最小优惠周期","优惠起算偏移量",
				"起算时间单元", "生效时间规则", "是否营销方案组", "是否打印到受理单","是否营业费优惠",
				"来源", "是否备份", "是否算费优惠", "是否网外成员优惠","固定费特殊标识","特殊方案标志",
				"资费说明","说明"};
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
