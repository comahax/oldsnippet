/**
 * auto-generated code
 * Sat Dec 18 20:30:45 CST 2010
 */
 package com.gmcc.pboss.web.sales.orderresdetwayorderdetail;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailDBParam;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;
import com.gmcc.pboss.control.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetail;
import com.gmcc.pboss.control.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OrderresdetWayOrderDetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderDetailAction extends BaseAction{
	
	public OrderresdetWayOrderDetailAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderresdetWayOrderDetailForm());
		//���ڲ���ʼ��,�������е�����
		OrderresdetWayOrderDetailDBParam detailDBParam =new OrderresdetWayOrderDetailDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		detailDBParam.set_dnl_recordtime(todayStr+ " 00:00:00");
		detailDBParam.set_dnm_recordtime(todayStr+ " 23:59:59");
		this.setParam(detailDBParam);

        //ָ��VO��
        setClsVO(OrderresdetWayOrderDetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
//        this.pkNameArray=new String[]{"countyid"};
        this.pkNameArray=new String[]{"rowcountid"};
		this.setClsControl(OrderresdetWayOrderDetail.class);
		this.setClsQueryParam(OrderresdetWayOrderDetailDBParam.class) ;

	}
	
	public String doList() throws Exception{
		OrderresdetWayOrderDetailDBParam param = (OrderresdetWayOrderDetailDBParam)getParam();
		String starttimeStr = param.get_dnl_recordtime() ;
		String endtimeStr = param.get_dnm_recordtime() ;
		Map<String,String> conditionMap = new HashMap<String, String>();
		
		//���߲�಻�ܳ���30��
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
//			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
//			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
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
		if(!StringUtils.isEmpty(param.get_se_wayid()))
		{
			conditionMap.put("WAYID", param.get_se_wayid());
		}
		if(!StringUtils.isEmpty(param.get_se_orderid()))
		{
			conditionMap.put("ORDERID", param.get_se_orderid());
		}
		if(!StringUtils.isEmpty(param.get_se_comcategory()))
		{
			conditionMap.put("COMCATEGORY", param.get_se_comcategory());
		}
//		WayFxSwOrder fxSwOrder = (WayFxSwOrder)BOFactory.build(WayFxSwOrderBO.class, getDBAccessUser());
		OrderresdetWayOrderDetail orderDetail = (OrderresdetWayOrderDetail)BOFactory.build(OrderresdetWayOrderDetailBO.class, getDBAccessUser());
		
		String minTime=param.get_dnl_recordtime();
		String maxTime=param.get_dnm_recordtime();
		param.set_dnl_recordtime(null);
		param.set_dnm_recordtime(null);
		
//		param.setQueryAll(true);
		DataPackage dp=orderDetail.doQueryOrderresdetWayOrderDetail(conditionMap, param);
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
		
		List<OrderresdetWayOrderDetailVO> owoList=dp.getDatas();
		//��ȡӦ�պ�ʵ��
		Double oriprice = null;//Ӧ���ܺ�(һ��)
		Double relprice = null;//ʵ���ܺ�(һ��)
		Long amount = null;
		for(int i=0; i<owoList.size(); i++)
		{
			oriprice = owoList.get(i).getComprice();
			relprice = owoList.get(i).getActprice();
//			System.out.println("----i-----"+i+"---oriprice---"+oriprice);
//			System.out.println("----i-----"+i+"---relprice---"+relprice);
			amount = owoList.get(i).getCountvalue();
			if(null!=amount)
			{	//�п��ܱ��еļ۸��ֶ�û��ֵ,����null,�������û��ܵ�ֵΪ0.00����ʽ��һ��
				if(null==oriprice){
					owoList.get(i).setComcamt(0.00);
				}else{
					owoList.get(i).setComcamt(oriprice*amount);
				}
				if(null==relprice){
					owoList.get(i).setActamt(0.00);
				}else{
					owoList.get(i).setActamt(relprice*amount);
				}
//				if(null!=oriprice)owoList.get(i).setComcamt(oriprice*amount);
//				if(null!=relprice)owoList.get(i).setActamt(relprice*amount);
			}
		}
		//��ʽ������
		BigDecimal recamtFormat = null;//Ӧ���ܺ�(һ��)
		BigDecimal actamtFormat = null;//ʵ���ܺ�(һ��)
		
		for(int i=0; i<owoList.size(); i++)
		{
			if(null!=owoList.get(i).getActamt()||!("".equals(owoList.get(i).getActamt())))//ʵ��һ�е��ܼ�
			{
				actamtFormat = new BigDecimal(owoList.get(i).getActamt());
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
			}else{
			
				actamtFormat = new BigDecimal(0.0);
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
			}
			if(null!=owoList.get(i).getComcamt()||!("".equals(owoList.get(i).getComcamt())))//Ӧ��һ�е��ܼ�
			{
				recamtFormat = new BigDecimal(owoList.get(i).getComcamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setComcamtFormat(recamtFormat.toString());
			}else{
			
				recamtFormat = new BigDecimal(0.0);
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(recamtFormat.toString());
			}
		}
		//����ʱ�䣺���ݶ�����ţ�ORDERID����ѯ������FX_SW_ORDER����ȡ����ʱ�䣨RECORDTIME��
		Order  order=(Order)BOFactory.build(OrderBO.class ,getDBAccessUser());	
		DataPackage dp1 = new DataPackage();
		OrderDBParam orderDBParam =new OrderDBParam();
		String orderid="";
		for(int i=0; i<owoList.size(); i++)
		{
			orderid=owoList.get(i).getOrderid();
			if(!StringUtils.isEmpty(orderid))
			{
				orderDBParam.set_se_orderid(orderid);
				dp1=order.doQuery(orderDBParam);
				if(dp1.getRowCount()>0)
				{
					Date orderrecordtime=((List<OrderVO>)dp1.getDatas()).get(0).getRecordtime();
//					System.out.println("---------orderrecordtime---------"+orderrecordtime);
					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateStr1 = sdf1.format(orderrecordtime); 
					owoList.get(i).setOrderrecordtime((dateStr1));
				}
			}
		}
//		���˹��ţ����ݶ�����ţ�ORDERID��������״̬Ϊ����ɣ���ORDERSTATE='FINISHED'��
//		��ѯ������־��FX_SW_ORDERLOG����ȡ����Ա���ţ�OPRCODE�������ж���ȡ��һ�����ɡ�
		Orderlog  orderlog=(Orderlog)BOFactory.build(OrderlogBO.class ,getDBAccessUser());	
		DataPackage dp2 = new DataPackage();
		OrderlogDBParam orderlogDBParam =new OrderlogDBParam();
		for(int i=0; i<owoList.size(); i++)
		{
			orderid=owoList.get(i).getOrderid();
//			System.out.println("----orderid---000-----"+orderid);
			if(!StringUtils.isEmpty(orderid))
			{
				orderlogDBParam.set_se_orderid(orderid);
//				System.out.println("----orderid---1111-----"+orderid);
				orderlogDBParam.set_se_orderstate("FINISHED");
				dp2=orderlog.doQuery(orderlogDBParam);
				if(dp2.getRowCount()>0)
				{
					String oprcode=((List<OrderlogVO>)dp2.getDatas()).get(0).getOprcode();
					owoList.get(i).setOprcode(oprcode);
				}
			}
		}
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
		export.setFileName("Ӫ����ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
//		export.addOutputProperty("state.count", " ���");
		export.addOutputProperty("orderid", "�������");
		export.addOutputProperty("countyid", "�ֹ�˾",CommonExportBean.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("svccode", "����Ӫ������",CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����",CommonExportBean.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ�",CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayid", "��������",CommonExportBean.CODE2NAME,"#WAYIDINFO");
		export.addOutputProperty("comid", "��Ʒ����",CommonExportBean.CODE2NAME,"#COMSYSTEM");
		export.addOutputProperty("countvalue", "����(��/��)");
		export.addOutputProperty("comcamtFormat", "Ӧ�գ�Ԫ��");
		export.addOutputProperty("actamtFormat", "ʵ�գ�Ԫ��");
		export.addOutputProperty("orderrecordtime", "����ʱ��");
		export.addOutputProperty("oprcode", "���˹���");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		OrderresdetWayOrderDetailDBParam orderDBParam = (OrderresdetWayOrderDetailDBParam) getParam();
		orderDBParam.setQueryAll(true);
		export.queryMethodName = "doList";
//		orderDBParam.set_pagesize("65535");
//		getParam().set_pagesize("65535");
//		OrderresdetWayOrderDetailDBParam detailDBParam =new OrderresdetWayOrderDetailDBParam();
//		detailDBParam.setQueryAll(true);
		
		return super.doExcel();
	}
	
	
}