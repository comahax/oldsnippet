/**
 * auto-generated code
 * Thu Jul 08 10:27:55 CST 2010
 */
 package com.gmcc.pboss.web.sales.ressum;

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
import com.gmcc.pboss.business.sales.chargesum.ChargesumVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.ressum.RessumDBParam;
import com.gmcc.pboss.business.sales.ressum.RessumVO;
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
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: LimitsetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RessumAction extends BaseAction{
	
	public RessumAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new RessumForm());
		RessumDBParam param = new RessumDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		param.setStarttimeStr(todayStr);
		param.setEndtimeStr(todayStr);
		this.setParam(param);

        //指定VO类
        setClsVO(RessumVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Ressum.class);
		this.setClsQueryParam(RessumDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		RessumDBParam param = (RessumDBParam)getParam();
		String starttimeStr = param.getStarttimeStr();
		String endtimeStr = param.getEndtimeStr();
		
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
			starttimeStr = starttimeStr + " 00:00:00";
			endtimeStr = endtimeStr + " 23:59:59";
			
			conditionMap.put("starttimeStr", starttimeStr);
			conditionMap.put("endtimeStr", endtimeStr);
		}
		
		if(!StringUtils.isEmpty(param.getWayid()))
		{
			conditionMap.put("wayid", param.getWayid());
		}
		param.setQueryAll(true);
		Ressum ressum = (Ressum)BOFactory.build(RessumBO.class, getDBAccessUser());
		DataPackage dp = ressum.doQueryRessum(conditionMap,param);
		
		List<RessumVO> ressumList = dp.getDatas();
		//获取原价
		String comid = "";
		Com com = (Com)BOFactory.build(ComBO.class, getDBAccessUser());
		DataPackage dp1 = new DataPackage();
		ComDBParam param1 = new ComDBParam();
		for(int i=0; i<ressumList.size(); i++)
		{
			comid = ressumList.get(i).getComid();
			if(!StringUtils.isEmpty(comid))
			{
				param1.set_ne_comid(comid);
				dp1 = com.doQuery(param1);
				if(dp1.getRowCount()>0)
				{
					Long price = ((List<ComVO>)dp1.getDatas()).get(0).getComprice();
					if(null!=price)
						ressumList.get(i).setComprice(Double.valueOf(String.valueOf(price))/100);
				}
			}
		}
		
		
		//获取实价
		Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, getDBAccessUser());
		Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class, getDBAccessUser());
		
		String comcategory = "";
		DataPackage dp2 = new DataPackage();
		DataPackage dp3 = new DataPackage();
		ComcategoryrelaDBParam param2 = new ComcategoryrelaDBParam();
		CompriceDBParam param3 = new CompriceDBParam();
		for(int i=0; i<ressumList.size(); i++)
		{
			comid = ressumList.get(i).getComid();
			if(!StringUtils.isEmpty(comid))
			{
				param2.set_ne_comid(comid);
				dp2 = comcategoryrela.doQuery(param2);
				if(dp2.getRowCount()>0)
				{
					comcategory = ((List<ComcategoryrelaVO>)dp2.getDatas()).get(0).getComcategory();
					if(!StringUtils.isEmpty(comcategory))
					{
						param3.set_se_cityid(getDBAccessUser().getCityid());
						param3.set_se_comcategory(comcategory);
						param3.set_se_pricediftype(ComorderConstant.PRICEDIFTYPE_NODIF);
						dp3 = comprice.doQuery(param3);
						if(dp3.getRowCount()>0)
						{
							Double relprice = ((List<CompriceVO>)dp3.getDatas()).get(0).getPrice1();
							ressumList.get(i).setRelprice(relprice);
						}
					}
				}
			}
		}
		
		
		//获取应收和实收
		Double oriprice = null;
		Double relprice = null;
		Integer amount = null;
		for(int i=0; i<ressumList.size(); i++)
		{
			oriprice = ressumList.get(i).getComprice();
			relprice = ressumList.get(i).getRelprice();
			amount = ressumList.get(i).getAmount();
			if(null!=amount)
			{
				if(null!=oriprice)ressumList.get(i).setRecamt(oriprice*amount);
				if(null!=relprice)ressumList.get(i).setActamt(relprice*amount);
			}
		}
		//格式化数据
		BigDecimal oripriceFormat = null;
		BigDecimal relpriceFormat = null;
		BigDecimal recamtFormat = null;
		BigDecimal actamtFormat = null;
		
		Integer amountTotal = 0;
		BigDecimal recamtTotal = new BigDecimal("0");
		BigDecimal actamtTotal = new BigDecimal("0");
		
		String wayid = "";
		Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayVO = new WayVO();
		for(int i=0; i<ressumList.size(); i++)
		{
			if(null!=ressumList.get(i).getComprice())
			{
				oripriceFormat = new BigDecimal(ressumList.get(i).getComprice());
				oripriceFormat = oripriceFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				ressumList.get(i).setCompriceFormat(oripriceFormat.toString());
			}
			if(null!=ressumList.get(i).getRelprice())
			{
				relpriceFormat = new BigDecimal(ressumList.get(i).getRelprice());
				relpriceFormat = relpriceFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				ressumList.get(i).setRelpriceFormat(relpriceFormat.toString());
			}
			if(null!=ressumList.get(i).getRecamt())
			{
				recamtFormat = new BigDecimal(ressumList.get(i).getRecamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				ressumList.get(i).setRecamtFormat(recamtFormat.toString());
			}
			if(null!=ressumList.get(i).getActamt())
			{
				actamtFormat = new BigDecimal(ressumList.get(i).getActamt());
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				ressumList.get(i).setActamtFormat(actamtFormat.toString());
			}
			
			amountTotal = amountTotal + ressumList.get(i).getAmount();
			recamtTotal = recamtTotal.add(recamtFormat);
			actamtTotal = actamtTotal.add(actamtFormat);
			
			wayid = ressumList.get(i).getWayid();
			wayVO = way.doFindByPk(wayid);
			ressumList.get(i).setWayname(wayVO.getWayname());
		}
		
		RessumVO ressumVO = new RessumVO();
		ressumVO.setWayid("合计");
		ressumVO.setAmount(amountTotal);
		recamtTotal = recamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		actamtTotal = actamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		ressumVO.setRecamtFormat(recamtTotal.toString());
		ressumVO.setActamtFormat(actamtTotal.toString());
		ressumList.add(ressumVO);
		
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("资源汇总");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("comid", "商品名称",CommonExportBean.CODE2NAME,"#COMSYSTEM");
		export.addOutputProperty("compriceFormat", "原价（元）");
		export.addOutputProperty("relpriceFormat", "实价（元）");
		export.addOutputProperty("amount", "数量（套/张）");
		export.addOutputProperty("recamtFormat", "应收（元）");
		export.addOutputProperty("actamtFormat", "实收（元）");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}