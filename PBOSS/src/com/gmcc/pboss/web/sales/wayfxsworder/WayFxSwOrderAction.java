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

		//���¼��������Ǳ����
		this.setForm(new WayFxSwOrderForm());
		WayFxSwOrderDBParam param=new WayFxSwOrderDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		param.set_dnl_recordtime(todayStr+ " 00:00:00");
		param.set_dnm_recordtime(todayStr+ " 23:59:59");
		this.setParam(param);

        //ָ��VO��
        setClsVO(WayFxSwOrderVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
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
		
		//���߲�಻�ܳ���30��
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			int diff = DateUtil.operationDate(enddate, startdate, DateUtil.DateOperationType.DIFF);
			if(diff>30)
			{
				setActionMessage("ʱ�������ܳ���30�졣");
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
		fxSwOrderVO.setCountyid("�ϼ�");
		fxSwOrderVO.setSumrecamtFormat(recamtTotal.toString());
		fxSwOrderVO.setSumactamtFormat(actamtTotal.toString());
		wayList.add(fxSwOrderVO);
		setDp(dp);
//    	WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,getDBAccessUser());
//    	dao.query(param);
//		return WebConstant.PAGE_ATTRIBUTE_LIST;���ص�ҳ��ʱLIST,������list
		return WEB_RESULT_LIST;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("Ӫ�ջ���[�Ǽ�]���û���");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
//		export.addOutputProperty("state.count", " ���");
		export.addOutputProperty("countyid", "�ֹ�˾",CommonExportBean.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("svccode", "����Ӫ������",CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����",CommonExportBean.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ�",CommonExportBean.CODE2NAME,"#CH_STARLEVEL");
		export.addOutputProperty("paytype", "�ɷѷ�ʽ",CommonExportBean.CODE2NAME,"$FX_PAYTYPE");
		export.addOutputProperty("sumrecamtFormat", "Ӧ�գ�Ԫ��");
		export.addOutputProperty("sumactamtFormat", "ʵ�գ�Ԫ��");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}