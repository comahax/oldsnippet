/**
 * auto-generated code
 * Tue Dec 14 15:42:11 CST 2010
 */
 package com.gmcc.pboss.web.sales.wayfxsworder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.ressum.RessumDBParam;
import com.gmcc.pboss.business.sales.ressum.RessumVO;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderDAO;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderVO ;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.control.sales.ressum.Ressum;
import com.gmcc.pboss.control.sales.ressum.RessumBO;
import com.gmcc.pboss.control.sales.wayfxsworder.WayFxSwOrder ;
import com.gmcc.pboss.control.sales.wayfxsworder.WayFxSwOrderBO;

/**
 * <p>Title: WayFxSwOrderAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
//public class WayFxSwOrderAction extends BaseAction{
public class WayFxSwOrderAction extends BaseAction {
	
	public WayFxSwOrderAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WayFxSwOrderForm());
		WayFxSwOrderDBParam param=new WayFxSwOrderDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		param.set_dnl_recordtime(todayStr+ " 00:00:00");
		param.set_dnm_recordtime(todayStr+ " 23:59:59");
		this.setParam(param);

        //指定VO类
        setClsVO(WayFxSwOrderVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
//        this.pkNameArray=new String[]{"countyid"};
        this.pkNameArray=new String[]{"rowcountid"};
		this.setClsControl(WayFxSwOrder.class);
		this.setClsQueryParam(WayFxSwOrderDBParam.class) ;

	}
	
	public String doList() throws Exception{
		WayFxSwOrderDBParam param = (WayFxSwOrderDBParam)getParam();
		String starttimeStr = param.get_dnl_recordtime() ;
		String endtimeStr = param.get_dnm_recordtime() ;
		
		Map<String,String> conditionMap = new HashMap<String, String>();
		
		//两者差距不能超过30天
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			int diff = DateUtil.operationDate(enddate, startdate, DateUtil.DateOperationType.DIFF);
			if(diff>30)
			{
				setActionMessage("时间间隔不能超过30天。");
				return WEB_RESULT_LIST;
			}
//			starttimeStr = starttimeStr + " 00:00:00";
//			endtimeStr = endtimeStr + " 23:59:59";
			
			conditionMap.put("starttimeStr", starttimeStr);
			conditionMap.put("endtimeStr", endtimeStr);
		}
		
		if(!StringUtils.isEmpty(param.get_se_countyid()))
		{
			conditionMap.put("COUNTYID", param.get_se_countyid());
		}
		if(!StringUtils.isEmpty(param.get_se_svccode()))
		{
			conditionMap.put("SVCCODE", param.get_se_svccode());
		}
		if(!StringUtils.isEmpty(param.get_se_mareacode()))
		{
			conditionMap.put("MAREACODE", param.get_se_mareacode());
		}
		if(!StringUtils.isEmpty(param.get_ne_starlevel()))
		{
			conditionMap.put("STARLEVEL", param.get_ne_starlevel());
		}
//		WayFxSwOrder fxSwOrder = (WayFxSwOrder)BOFactory.build(WayFxSwOrderBO.class, getDBAccessUser());
		WayFxSwOrder fxSwOrder = (WayFxSwOrder)BOFactory.build(WayFxSwOrderBO.class, getDBAccessUser());
		
		String minTime=param.get_dnl_recordtime();
		String maxTime=param.get_dnm_recordtime();
		param.set_dnl_recordtime(null);
		param.set_dnm_recordtime(null);
		param.setQueryAll(true);
		DataPackage dp=fxSwOrder.doQueryWayFxOrder(conditionMap, param);
		
		if(null==param.get_dnl_recordtime()&&null==param.get_dnm_recordtime())
		{
//			Date today = new Date();
//			String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
//			starttimeStr = todayStr + " 00:00:00";
//			endtimeStr = todayStr + " 23:59:59";
			param.set_dnl_recordtime(minTime);
			param.set_dnm_recordtime(maxTime);
		}
		
		List<WayFxSwOrderVO> wayList=dp.getDatas();
		BigDecimal recamtFormat = null;
		BigDecimal actamtFormat = null;
		BigDecimal recamtTotal = new BigDecimal("0");
		BigDecimal actamtTotal = new BigDecimal("0");
		for(int i=0;i<wayList.size();i++){
			if(null!=wayList.get(i).getSumrecamt())
			{
				recamtFormat = new BigDecimal(wayList.get(i).getSumrecamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				wayList.get(i).setSumrecamtFormat(recamtFormat.toString());
			}
			if(null!=wayList.get(i).getSumactamt())
			{
				actamtFormat = new BigDecimal(wayList.get(i).getSumactamt());
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				wayList.get(i).setSumactamtFormat(actamtFormat.toString());
			}
			recamtTotal=recamtTotal.add(recamtFormat);
			actamtTotal=actamtTotal.add(actamtFormat);
		}
		recamtTotal=recamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		actamtTotal=actamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		
		WayFxSwOrderVO fxSwOrderVO=new WayFxSwOrderVO();
		fxSwOrderVO.setCountyid("合计");
		fxSwOrderVO.setSumrecamtFormat(recamtTotal.toString());
		fxSwOrderVO.setSumactamtFormat(actamtTotal.toString());
		wayList.add(fxSwOrderVO);
		setDp(dp);
//    	WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,getDBAccessUser());
//    	dao.query(param);
//		return WebConstant.PAGE_ATTRIBUTE_LIST;返回的页面时LIST,而不是list
		return WEB_RESULT_LIST;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("营收汇总[星级]费用汇总");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
//		export.addOutputProperty("state.count", " 序号");
		export.addOutputProperty("countyid", "分公司",CommonExportBean.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务营销中心",CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域",CommonExportBean.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "星级",CommonExportBean.CODE2NAME,"#CH_STARLEVEL");
		export.addOutputProperty("paytype", "缴费方式",CommonExportBean.CODE2NAME,"$FX_PAYTYPE");
		export.addOutputProperty("sumrecamtFormat", "应收（元）");
		export.addOutputProperty("sumactamtFormat", "实收（元）");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}