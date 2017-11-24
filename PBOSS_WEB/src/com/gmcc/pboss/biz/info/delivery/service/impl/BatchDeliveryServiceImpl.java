package com.gmcc.pboss.biz.info.delivery.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsSmstmplDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsWaitreqDao;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.biz.info.delivery.dao.FxSwSmsconfirmDao;
import com.gmcc.pboss.biz.info.delivery.service.BatchDeliveryService;
import com.gmcc.pboss.biz.info.delivery.support.BatchDeliveryParameter;
import com.gmcc.pboss.biz.info.salesRpt.dao.SalesOrderDao;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.model.sms.ChSmsSmstmpl;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;
import com.gmcc.pboss.model.sms.FxSwSmsconfirm;
import com.gmcc.pboss.biz.info.delivery.support.BatchProcessResult;

public class BatchDeliveryServiceImpl extends BaseServiceImpl implements BatchDeliveryService {
	
	/**
	 * 构造器：给ServiceCode与ServiceName赋值
	 */
	public BatchDeliveryServiceImpl(){
		super();
		this.serviceName = "批量配送处理";
		this.serviceCode = ServiceCode.BatchDelivery;
		this.isNeedLogin = true;
		this.setProcessor(null);
	}
	
	private DeliveryDao deliveryDao;

	private FxSwSmsconfirmDao fxSwSmsconfirmDao;
	
	private IbGlSysparamDao ibGlSysparamDao;
	
	private ChSmsSmstmplDao chSmsSmstmplDao;
	
	private ChSmsWaitreqDao chSmsWaitreqDao;
	
	private SalesOrderDao salesOrderDao;
	
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		BatchDeliveryParameter param = (BatchDeliveryParameter)parameter;
		String content = param.getContent().trim().replaceAll("\\s", "");//去掉前后空格，去掉非打印字符
		String type = param.getType();
		List<BatchProcessResult> processResults = null;
		if(type.equals("1")){
			processResults = this.doBatchDisover(member, content);
		}
		else if(type.equals("2")){
			processResults = this.doBatchSMSSign(member, content);
		}
		else if(type.equals("3")){
			processResults = this.doBatchLogiMod(member, content);
		}
//		else{
//			processResults = new ArrayList<BatchProcessResult>();
//		}
		
		//排序
		BatchProcessResult[] notSort = processResults.toArray(new BatchProcessResult[]{new BatchProcessResult()});
		Arrays.sort(notSort);
		processResults = Arrays.asList(notSort);
		
		result.setSuccess(true);
		result.setRetObject(processResults);
		result.setRetResult(null);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}
	
	private List<BatchProcessResult> doBatchDisover(LoginMember member, String content){
		List<BatchProcessResult> processResults = new ArrayList<BatchProcessResult>();
		String[] codes = content.split(",");		
		String discomcode = member.getChannel().getWayid();
		for(String code : codes){
			BatchProcessResult processResult = null;
			Long id = null;
			try{
				if(code.trim().length()>14){//结果标记0，"配送单输入错误"					
					processResult = new BatchProcessResult(0,code,"配送单输入错误");
					processResults.add(processResult);
					continue;
				}else{
					id = new Long(code);
				}				
			}catch(Exception e){//输入内容不是纯数字
				processResult = new BatchProcessResult(0,code,"配送单输入错误");//结果标记0，"配送单输入错误"
				processResults.add(processResult);
				continue;
			}
			
			FxSwDisform o = null;
			try{
				o = (FxSwDisform)this.deliveryDao.getDisform(id, discomcode);
			}catch(Exception e){//查询数据失败	
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"配送单不存在");
				processResults.add(processResult);
				continue;
			}
			if(o==null){//结果标记0，"配送单不存在"
				processResult = new BatchProcessResult(0,code,"配送单不存在");
				processResults.add(processResult);
				continue;
			}
			if( !ConstantsType.DISSTATE_DISING.equals(o.getDisstate())){//状态不为配送中
				//结果标记2，"配送单状态不正确，配送中状态才能完成配送"
				processResult = new BatchProcessResult(2,code,"配送单状态不正确，配送中状态才能完成配送");
				processResults.add(processResult);
				continue;
			}			
			
			//写确认短信
			//登记短信确认记录
			FxSwSmsconfirm smsconfirm = new FxSwSmsconfirm();
			//类型取合作商签收
			smsconfirm.setType(ConstantsType.FX_SMSCONTYPE_PARSIGN);
			//确认流水号取订单末尾4位
			smsconfirm.setStream(o.getOrderid().substring(o.getOrderid().length()-4));
			//手机号码取配送单中的收货人电话
			smsconfirm.setMobileno(o.getRecetel());
			//关联订单号取订单编号
			smsconfirm.setOrderid(o.getOrderid());
			//状态取待回复
			smsconfirm.setState(ConstantsType.FX_SMSREPSTATE_WAITREP);
			Date d = new Date();
			//通知时间取当前时间
			smsconfirm.setSendtime(d);
			
			//集中更新数据
			//将状态修改为"配送完成"
			o.setDisstate(ConstantsType.DISSTATE_DISOVER);
			this.deliveryDao.update(o);			
			//订单配送完成，修改相关信息
			//更新订单表FX_SW_ORDER中的配送完成时间DISOVERTIME为系统当前时间
			Date currentDate = new Date(System.currentTimeMillis());
			String orderId = o.getOrderid();
			FxSwOrder order = this.salesOrderDao.getById(orderId);
			order.setDisovertime(currentDate);
			this.salesOrderDao.update(order);
			//写确认短信
			fxSwSmsconfirmDao.save(smsconfirm);
			
			//通知合作商签收
			ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
			//短信类型取3
			smsWaitreq.setSmstype(new Long(3));
			//查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值
			String sendNO = this.ibGlSysparamDao.getSysValue(42L, "pboss_fx");
			if(sendNO==null ||"".equals(sendNO.trim())){//结果标记0，"已完成配送，但通知短信失败，发送号码为空"				
				processResult = new BatchProcessResult(0,code,"已完成配送，但通知短信失败，发送号码为空");
				processResults.add(processResult);
				continue;				
			}
			//发送号码 
			smsWaitreq.setSendno(sendNO);
			//接受取配送单中的收货人电话
			if(o.getRecetel()==null ||"".equals(o.getRecetel().trim())){//结果标记0，"已完成配送，但通知短信失败，接收号码为空"				
				processResult = new BatchProcessResult(0,code,"已完成配送，但通知短信失败，接收号码为空");
				processResults.add(processResult);
				continue;				
			}
			smsWaitreq.setRecno(o.getRecetel());
			ChSmsSmstmpl chSmsSmstmpl = null;
			try {
				chSmsSmstmpl = (ChSmsSmstmpl)chSmsSmstmplDao.get("FX_ORDER_PARSIGNCON");
			} catch (ObjectRetrievalFailureException e) {
				//找不到短信模板不处理，短信内容为空，不发短信
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"已完成配送，但通知短信失败，短信内容为空");
				processResults.add(processResult);	
				continue;
			}
			//查询模版不为空，且模版内容不为空或者空字符串
			if(chSmsSmstmpl!=null && chSmsSmstmpl.getScontent()!=null && !"".equals(chSmsSmstmpl.getScontent().trim())){
				String scontent = chSmsSmstmpl.getScontent().trim();
				
				String employeeName = "客户";
				if(o.getRecename()!=null&&!"".equals(o.getRecename().trim())){
					employeeName = o.getRecename();
				}
				//日期
				String[] arrayDate = DateUtil.convertDateToString(d).split("-");
				scontent = scontent.replace("{CUSTNAME}", employeeName);
				scontent = scontent.replace("{YEAR}", arrayDate[0]);
				scontent = scontent.replace("{MONTH}", arrayDate[1]);
				scontent = scontent.replace("{DAY}", arrayDate[2]);
				scontent = scontent.replace("{ORDERID}", o.getOrderid());
				scontent = scontent.replace("{STREAM}", o.getOrderid().substring(o.getOrderid().length()-4));
				String logi = o.getLogisticsno()==null?"":o.getLogisticsno();
				scontent = scontent.replace("{LOGISTICSINFO}", logi);
				
				//短信内容
				smsWaitreq.setMessage(scontent);
				smsWaitreq.setCreattime(d);
				//地市码
				smsWaitreq.setAreacode(member.getCityid());
				//处理次数
				smsWaitreq.setDealcount((long)0);
				//处理状态
				smsWaitreq.setIssuccess((long)0);
				if(smsWaitreq.getSendno()!=null&&!"".equals(smsWaitreq.getSendno().trim())
						&&smsWaitreq.getRecno()!=null&&!"".equals(smsWaitreq.getRecno().trim())
						&&smsWaitreq.getMessage()!=null&&!"".equals(smsWaitreq.getMessage().trim())){
					chSmsWaitreqDao.save(smsWaitreq);
				}							
			}else{
				//结果标记0，"已完成配送，但通知短信失败，短信内容为空"
				processResult = new BatchProcessResult(0,code,"已完成配送，但通知短信失败，短信内容为空");
				processResults.add(processResult);	
				continue;
			}	
			
			//结果标记“1”，提示信息“配送完成”
			processResult = new BatchProcessResult(1,code,"配送完成");
			processResults.add(processResult);
		}	
		
		return processResults;
	}
	
	private List<BatchProcessResult> doBatchSMSSign(LoginMember member, String content ){
		List<BatchProcessResult> processResults = new ArrayList<BatchProcessResult>();
		String[] codes = content.split(",");		
		String discomcode = member.getChannel().getWayid();
		for(String code : codes){
			BatchProcessResult processResult = null;
			Long id = null;
			try{
				if(code.trim().length()>14){//结果标记0，"配送单输入错误"					
					processResult = new BatchProcessResult(0,code,"配送单输入错误");
					processResults.add(processResult);
					continue;
				}else{
					id = new Long(code);
				}				
			}catch(Exception e){//输入内容不是纯数字
				processResult = new BatchProcessResult(0,code,"配送单输入错误");//结果标记0，"配送单输入错误"
				processResults.add(processResult);
				continue;
			}
			
			FxSwDisform o = null;
			try{
				o = (FxSwDisform)this.deliveryDao.getDisform(id, discomcode);
			}catch(Exception e){//查询数据失败
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"配送单不存在");
				processResults.add(processResult);
				continue;
			}
			if(o==null){//结果标记0，"配送单不存在"				
				processResult = new BatchProcessResult(0,code,"配送单不存在");
				processResults.add(processResult);
				continue;
			}
			if( !ConstantsType.DISSTATE_DISOVER.equals(o.getDisstate())){//状态是否等于配送完成状态
				processResult = new BatchProcessResult(2,code,"配送单状态错误");//结果标记2，"配送单状态错误"
				processResults.add(processResult);
				continue;
			}			
			
			//登记短信确认记录
			// 根据类型（合作商签收）、手机号码（配送单中的收货人电话）、
			//订单编号、状态（待回复）查询分销短信确认表（FX_SW_SMSCONFIRM）
			Date d = new Date();//当前日期时间		
			FxSwSmsconfirm smsconfirm = fxSwSmsconfirmDao.getSmsconfirm(//此表有唯一主键:类型+订单号+状态
					ConstantsType.FX_SMSCONTYPE_PARSIGN, //类型-合作商签收
					o.getRecetel(), //手机号码-配送单收货人号码
					o.getOrderid(), //订单编号
					ConstantsType.FX_SMSREPSTATE_WAITREP //状态-待回复
					);
			if(smsconfirm==null){//数据不存在，新增一条记录
				smsconfirm = new FxSwSmsconfirm();
				//类型取合作商签收
				smsconfirm.setType(ConstantsType.FX_SMSCONTYPE_PARSIGN);
				//确认流水号取订单末尾4位
				smsconfirm.setStream(o.getOrderid().substring(o.getOrderid().length()-4));
				//手机号码取配送单中的收货人电话
				smsconfirm.setMobileno(o.getRecetel());
				//关联订单号取订单编号
				smsconfirm.setOrderid(o.getOrderid());
				//状态取待回复
				smsconfirm.setState(ConstantsType.FX_SMSREPSTATE_WAITREP);
				//通知时间取当前时间
				smsconfirm.setSendtime(d);
			}else{//记录已存在
				smsconfirm.setSendtime(d);
			}
			//写确认短信
			fxSwSmsconfirmDao.save(smsconfirm);
			
			//通知合作商签收
			ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
			//短信类型取3
			smsWaitreq.setSmstype(new Long(3));
			//查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值
			String sendNO = this.ibGlSysparamDao.getSysValue(42L, "pboss_fx");
			if(sendNO==null ||"".equals(sendNO.trim())){//结果标记0，"发送号码为空"				
				processResult = new BatchProcessResult(0,code,"发送号码为空");
				processResults.add(processResult);
				continue;				
			}
			//发送号码 
			smsWaitreq.setSendno(sendNO);
			//接受取配送单中的收货人电话
			if(o.getRecetel()==null ||"".equals(o.getRecetel().trim())){//结果标记0，"接收号码为空"				
				processResult = new BatchProcessResult(0,code,"接收号码为空");
				processResults.add(processResult);
				continue;				
			}
			smsWaitreq.setRecno(o.getRecetel());
			ChSmsSmstmpl chSmsSmstmpl = null;
			try {
				chSmsSmstmpl = (ChSmsSmstmpl)chSmsSmstmplDao.get("FX_ORDER_PARSIGNCON");
			} catch (ObjectRetrievalFailureException e) {//找不到短信模板不处理，短信内容为空，不发短信				
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"短信内容为空");
				processResults.add(processResult);	
				continue;
			}
			//查询模版不为空，且模版内容不为空或者空字符串
			if(chSmsSmstmpl!=null && chSmsSmstmpl.getScontent()!=null && !"".equals(chSmsSmstmpl.getScontent().trim())){
				String scontent = chSmsSmstmpl.getScontent().trim();				
				String employeeName = "客户";
				if(o.getRecename()!=null&&!"".equals(o.getRecename().trim())){
					employeeName = o.getRecename();
				}
				//日期
				String[] arrayDate = DateUtil.convertDateToString(d).split("-");
				scontent = scontent.replace("{CUSTNAME}", employeeName);
				scontent = scontent.replace("{YEAR}", arrayDate[0]);
				scontent = scontent.replace("{MONTH}", arrayDate[1]);
				scontent = scontent.replace("{DAY}", arrayDate[2]);
				scontent = scontent.replace("{ORDERID}", o.getOrderid());
				scontent = scontent.replace("{STREAM}", o.getOrderid().substring(o.getOrderid().length()-4));
				String logi = o.getLogisticsno()==null?"":o.getLogisticsno();
				scontent = scontent.replace("{LOGISTICSINFO}", logi);
				//短信内容
				smsWaitreq.setMessage(scontent);
				smsWaitreq.setCreattime(d);
				//地市码
				smsWaitreq.setAreacode(member.getCityid());
				//处理次数
				smsWaitreq.setDealcount((long)0);
				//处理状态
				smsWaitreq.setIssuccess((long)0);
				if(smsWaitreq.getSendno()!=null&&!"".equals(smsWaitreq.getSendno().trim())
						&&smsWaitreq.getRecno()!=null&&!"".equals(smsWaitreq.getRecno().trim())
						&&smsWaitreq.getMessage()!=null&&!"".equals(smsWaitreq.getMessage().trim())){
					chSmsWaitreqDao.save(smsWaitreq);
				}							
			}else{
				//结果标记0，"短信内容为空"
				processResult = new BatchProcessResult(0,code,"短信内容为空");
				processResults.add(processResult);	
				continue;
			}
			
			//结果标记“1”，提示信息"补发签收短信成功"
			processResult = new BatchProcessResult(1,code,"补发签收短信成功");
			processResults.add(processResult);			
		}
		
		return processResults;
	}
	
	private List<BatchProcessResult> doBatchLogiMod(LoginMember member, String content ){
		List<BatchProcessResult> processResults = new ArrayList<BatchProcessResult>();
		String[] infos = content.split(",");		
		String discomcode = member.getChannel().getWayid();
		for(String info : infos ){
			BatchProcessResult processResult = null;
			Long id = null;
			
			String[] recid_logi = info.trim().split("\\|");
			if(recid_logi.length!=2 || recid_logi[0].trim().equals("")){
				processResult = new BatchProcessResult(0,info,"格式错误\"配送单编码|物流单号\"");
				processResults.add(processResult);
				continue;
			}
			String recid = recid_logi[0].trim();
			String logi = recid_logi[1].trim();
			
			try{//配送单编码格式检查
				if(recid.length()>14){//结果标记0，"配送单输入错误"					
					processResult = new BatchProcessResult(0,info,"配送单输入错误");
					processResults.add(processResult);
					continue;
				}else{
					id = new Long(recid);
				}				
			}catch(Exception e){//输入内容不是纯数字
				processResult = new BatchProcessResult(0,info,"配送单输入错误");//结果标记0，"配送单输入错误"
				processResults.add(processResult);
				continue;
			}
			
			//物流单号格式检查
			if(logi.getBytes().length != logi.length()){
				processResult = new BatchProcessResult(0,info,"物流单单输入错误，只允许输入字母和数字");//结果标记0，"配送单输入错误"
				processResults.add(processResult);
				continue;
			}
			if(logi.getBytes().length>32){
				processResult = new BatchProcessResult(0,info,"物流单单输入错误");//结果标记0，"配送单输入错误"
				processResults.add(processResult);
				continue;
			}
			
			FxSwDisform o = null;
			try{
				o = (FxSwDisform)this.deliveryDao.getDisform(id, discomcode);
			}catch(Exception e){//查询数据失败
				e.printStackTrace();
				processResult = new BatchProcessResult(0,info,"配送单不存在");
				processResults.add(processResult);
				continue;
			}
			if(o==null){//结果标记0，"配送单不存在"				
				processResult = new BatchProcessResult(0,info,"配送单不存在");
				processResults.add(processResult);
				continue;
			}
			
			o.setLogisticsno(logi);
			this.deliveryDao.save(o);
			processResult = new BatchProcessResult(1,info,"物流单号录入成功");
			processResults.add(processResult);
		}
		return processResults;
	}
	
	public DeliveryDao getDeliveryDao() {
		return deliveryDao;
	}

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}
	
	public FxSwSmsconfirmDao getFxSwSmsconfirmDao() {
		return fxSwSmsconfirmDao;
	}

	public void setFxSwSmsconfirmDao(FxSwSmsconfirmDao fxSwSmsconfirmDao) {
		this.fxSwSmsconfirmDao = fxSwSmsconfirmDao;
	}

	public IbGlSysparamDao getIbGlSysparamDao() {
		return ibGlSysparamDao;
	}

	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}

	public ChSmsSmstmplDao getChSmsSmstmplDao() {
		return chSmsSmstmplDao;
	}

	public void setChSmsSmstmplDao(ChSmsSmstmplDao chSmsSmstmplDao) {
		this.chSmsSmstmplDao = chSmsSmstmplDao;
	}

	public ChSmsWaitreqDao getChSmsWaitreqDao() {
		return chSmsWaitreqDao;
	}

	public void setChSmsWaitreqDao(ChSmsWaitreqDao chSmsWaitreqDao) {
		this.chSmsWaitreqDao = chSmsWaitreqDao;
	}

	public SalesOrderDao getSalesOrderDao() {
		return salesOrderDao;
	}

	public void setSalesOrderDao(SalesOrderDao salesOrderDao) {
		this.salesOrderDao = salesOrderDao;
	}


}
