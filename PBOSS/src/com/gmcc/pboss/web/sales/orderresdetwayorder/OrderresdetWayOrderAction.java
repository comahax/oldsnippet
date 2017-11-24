/**
 * auto-generated code
 * Sat Dec 18 09:48:51 CST 2010
 */
 package com.gmcc.pboss.web.sales.orderresdetwayorder;

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
import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderDBParam;
import com.gmcc.pboss.business.sales.ressum.RessumVO;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderDBParam;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.orderresdetwayorder.OrderresdetWayOrder ;
import com.gmcc.pboss.control.sales.orderresdetwayorder.OrderresdetWayOrderBO;
import com.gmcc.pboss.control.sales.wayfxsworder.WayFxSwOrder;
import com.gmcc.pboss.control.sales.wayfxsworder.WayFxSwOrderBO;

/**
 * <p>Title: OrderresdetWayOrderAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderAction extends BaseAction{
	
	public OrderresdetWayOrderAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderresdetWayOrderForm());
		//���ڲ���ʼ��,�������е�����
		OrderresdetWayOrderDBParam orderDBParam =new OrderresdetWayOrderDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		orderDBParam.set_dnl_recordtime(todayStr+ " 00:00:00");
		orderDBParam.set_dnm_recordtime(todayStr+ " 23:59:59");
		this.setParam(orderDBParam);

        //ָ��VO��
        setClsVO(OrderresdetWayOrderVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
//        this.pkNameArray=new String[]{"countyid"};
        this.pkNameArray=new String[]{"rowcountid"};
		this.setClsControl(OrderresdetWayOrder.class);
		this.setClsQueryParam(OrderresdetWayOrderDBParam.class) ;

	}
	public String doList() throws Exception{
		OrderresdetWayOrderDBParam param = (OrderresdetWayOrderDBParam)getParam();
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
		
		if(!StringUtils.isEmpty(param.get_ne_countyid()))
		{
			conditionMap.put("COUNTYID", param.get_ne_countyid());
		}
		if(!StringUtils.isEmpty(param.get_ne_svccode()))
		{
			conditionMap.put("SVCCODE", param.get_ne_svccode());
		}
		if(!StringUtils.isEmpty(param.get_ne_mareacode()))
		{
			conditionMap.put("MAREACODE", param.get_ne_mareacode());
		}
		if(!StringUtils.isEmpty(param.get_ne_starlevel()))
		{
			conditionMap.put("STARLEVEL", param.get_ne_starlevel());
		}
//		WayFxSwOrder fxSwOrder = (WayFxSwOrder)BOFactory.build(WayFxSwOrderBO.class, getDBAccessUser());
		OrderresdetWayOrder fxSwOrder = (OrderresdetWayOrder)BOFactory.build(OrderresdetWayOrderBO.class, getDBAccessUser());
		
		String minTime=param.get_dnl_recordtime();
		String maxTime=param.get_dnm_recordtime();
		param.set_dnl_recordtime(null);
		param.set_dnm_recordtime(null);
		param.setQueryAll(true);
		DataPackage dp=fxSwOrder.doQueryOrderresdetWayOrder(conditionMap, param);
		//����һ�ε�ʱ��,����Ĭ�ϵ�ʱ��,��ǰʱ��,��action��ʼ����ֵ,�Ѿ�����form����
		if(null==param.get_dnl_recordtime()&&null==param.get_dnm_recordtime())
		{
//			Date today = new Date();
//			String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
//			starttimeStr = todayStr + " 00:00:00";
//			endtimeStr = todayStr + " 23:59:59";
			param.set_dnl_recordtime(minTime);
			param.set_dnm_recordtime(maxTime);
		}
		List<OrderresdetWayOrderVO> owoList=dp.getDatas();
		//��ȡӦ�պ�ʵ��
		Double oriprice = null;//Ӧ���ܺ�(һ��)
		Double relprice = null;//ʵ���ܺ�(һ��)
		Long amount = null;
		for(int i=0; i<owoList.size(); i++)
		{
			oriprice = owoList.get(i).getComprice();
			relprice = owoList.get(i).getActprice();
			amount = owoList.get(i).getCountvalue();
			if(null!=amount)
			{	//�п��ܱ��еļ۸��ֶ�û��ֵ,����null,�������û��ܵ�ֵΪ0.00����ʽ��һ��
//				if(null!=oriprice)owoList.get(i).setComcamt(oriprice*amount);
//				if(null!=relprice)owoList.get(i).setActamt(relprice*amount);
				if(null==oriprice){
					owoList.get(i).setComcamt(0.00);
				}else{
					owoList.get(i).setComcamt(oriprice*amount);
					System.out.println("owoList.get(i).setComcamt(oriprice*amount)"+owoList.get(i).getComcamt());
				}
				if(null==relprice){
					owoList.get(i).setActamt(0.00);
				}else{
					owoList.get(i).setActamt(relprice*amount);
					System.out.println("owoList.get(i).setActamt(oriprice*amount)"+owoList.get(i).getActamt());
				}
			}
		}
		//��ʽ������
		BigDecimal oripriceFormat = null;//Ӧ�յ���
		BigDecimal relpriceFormat = null;//ʵ�յ���
		BigDecimal recamtFormat = null;//Ӧ���ܺ�(һ��)
		BigDecimal actamtFormat = null;//ʵ���ܺ�(һ��)
		
		Long amountTotal = 0L;//�����ܺ�(���е���)
		BigDecimal recamtTotal = new BigDecimal("0");//Ӧ���ܺ�(���е���)
		BigDecimal actamtTotal = new BigDecimal("0");//ʵ���ܺ�(���е���)
		
		for(int i=0; i<owoList.size(); i++)
		{
			if(null!=owoList.get(i).getComprice())//Ӧ�յ���
			{
				oripriceFormat = new BigDecimal(owoList.get(i).getComprice());
				oripriceFormat = oripriceFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setCompriceFormat(oripriceFormat.toString());
//				System.out.println("owoList.get(i).getComprice()Ӧ�յ���:"+owoList.get(i).getCompriceFormat());
			}
			if(null!=owoList.get(i).getActprice())//ʵ�յ���
			{
				relpriceFormat = new BigDecimal(owoList.get(i).getActprice());
				relpriceFormat = relpriceFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActpriceFormat(relpriceFormat.toString());
//				System.out.println("owoList.get(i).getActprice()ʵ�յ���:"+owoList.get(i).getActpriceFormat());
			}
			if(null!=owoList.get(i).getActamt()||!("".equals(owoList.get(i).getActamt())))//ʵ��һ�е��ܼ�
			{
				actamtFormat = new BigDecimal(owoList.get(i).getActamt());
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
//				System.out.println("owoList.get(i).getActamtFormat ʵ��һ�е��ܼ� "+owoList.get(i).getActamtFormat());
			}else{
			
				actamtFormat = new BigDecimal(0.0);
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
//				System.out.println("owoList.get(i).getActamtFormat ʵ��һ�е��ܼ� "+owoList.get(i).getActamtFormat());
			}
			if(null!=owoList.get(i).getComcamt()||!("".equals(owoList.get(i).getComcamt())))//Ӧ��һ�е��ܼ�
			{
				recamtFormat = new BigDecimal(owoList.get(i).getComcamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setComcamtFormat(recamtFormat.toString());
//				System.out.println("owoList.get(i).getComcamt Ӧ��һ�е��ܼ� "+owoList.get(i).getComcamtFormat());
			}else{
			
				recamtFormat = new BigDecimal(0.0);
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(recamtFormat.toString());
//				System.out.println("owoList.get(i).getComcamt Ӧ��һ�е��ܼ� "+owoList.get(i).getComcamtFormat());
			}
			
			amountTotal = amountTotal + owoList.get(i).getCountvalue();
			recamtTotal = recamtTotal.add(recamtFormat);//Ӧ���ܺ�(���е���)
			actamtTotal = actamtTotal.add(actamtFormat);//ʵ���ܺ�(���е���)
			
		}
		
		OrderresdetWayOrderVO orderresdetWayOrderVO = new OrderresdetWayOrderVO();
		orderresdetWayOrderVO.setCountyid("�ϼ�");
		orderresdetWayOrderVO.setCountvalue(amountTotal);
		recamtTotal = recamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		actamtTotal = actamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		orderresdetWayOrderVO.setComcamtFormat(recamtTotal.toString());
		orderresdetWayOrderVO.setActamtFormat(actamtTotal.toString());
		owoList.add(orderresdetWayOrderVO);
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
		export.setFileName("Ӫ�ջ���[�Ǽ�]��Դ����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
//		export.addOutputProperty("state.count", " ���");
		export.addOutputProperty("countyid", "�ֹ�˾",CommonExportBean.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("svccode", "����Ӫ������",CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����",CommonExportBean.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ�",CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comid", "��Ʒ����",CommonExportBean.CODE2NAME,"#COMSYSTEM");
		export.addOutputProperty("countvalue", "����(��/��)");
		export.addOutputProperty("compriceFormat", "ԭ�ۣ�Ԫ��");
		export.addOutputProperty("actpriceFormat", "ʵ�ۣ�Ԫ��");
		export.addOutputProperty("comcamtFormat", "Ӧ�գ�Ԫ��");
		export.addOutputProperty("actamtFormat", "ʵ�գ�Ԫ��");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
}