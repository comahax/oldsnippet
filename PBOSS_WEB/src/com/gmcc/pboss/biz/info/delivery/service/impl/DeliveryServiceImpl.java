package com.gmcc.pboss.biz.info.delivery.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsSmstmplDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsWaitreqDao;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.biz.info.delivery.dao.FxSwSmsconfirmDao;
import com.gmcc.pboss.biz.info.delivery.service.DeliveryService;
import com.gmcc.pboss.biz.info.delivery.support.DeliveryQueryParameter;
import com.gmcc.pboss.biz.info.delivery.support.processor.DeliveryParameterProcessor;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesrServiceRetCode;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.model.constant.IbGlSysparam;
import com.gmcc.pboss.model.constant.IbGlSysparamId;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrdercomcate;
import com.gmcc.pboss.model.sms.ChSmsSmstmpl;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;
import com.gmcc.pboss.model.sms.FxSwSmsconfirm;
import com.gmcc.pboss.biz.info.salesRpt.dao.SalesOrderDao;
import com.gmcc.pboss.model.sales.FxSwOrder;

public class DeliveryServiceImpl extends QueryBaseServiceImpl implements DeliveryService {

	private static Logger logger = Logger.getLogger(DeliveryServiceImpl.class);
	public DeliveryServiceImpl() {
		serviceName = "配送商管理";
		serviceCode = ServiceCode.DELIVERY;
		isNeedLogin = true;

		setProcessor(new DeliveryParameterProcessor());
	}
	
	private FxSwSmsconfirmDao fxSwSmsconfirmDao;
	
	private IbGlSysparamDao ibGlSysparamDao;
	
	private ChSmsSmstmplDao chSmsSmstmplDao;
	
	private ChSmsWaitreqDao chSmsWaitreqDao;
	
	private SalesOrderDao salesOrderDao;
	
	/**
	 * 提取单条
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		DeliveryDao dao = (DeliveryDao) this.getDao();
		//ID验证
		Assert.notBlank(param.getRecid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");
		
		try{
//			FxSwDisform obj = (FxSwDisform) get(param.getOrderid());
//			String propertyNames[] = new String[1];
//			String values[] = new String[1];
//			propertyNames[0] = "orderid";values[0]=param.getOrderid();
			FxSwDisform obj = (FxSwDisform) dao.getOne(this.getProcessor(), param);
			//通过HQL提取VO对象
//			this.getOne(propertyNames, values);
			//验证用户权限
			Assert.isTrue(member.getWayid().equals(obj.getDiscomcode()), SalesrServiceRetCode.AUTHOR_FAIL, "ID不明确！");
			//查询
			result.setRetObject(obj);
			
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
		}catch(ObjectRetrievalFailureException e){
			//对象不存在异常
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5，错误代表：SALESORDER_5
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#modify(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		if(param.getModlogi()){//20120328新增“物流单号”
			return this.modigyLogs(member, parameter);
		}else{//20120328修改前处理启动配送、配送完成逻辑
			return this.modify1(member, parameter);
		}
	}//modify
	
	//启动配送、配送完成
	private ServiceResult modify1(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//判断参数
		Assert.notBlank(param.getRecids(), SalesrServiceRetCode.ID_Empty, "ID丢失!");
		Assert.notBlank(param.getDisstate(), SalesrServiceRetCode.State_Empty, "状态不存在!");
		//提取参数
		Map cnntDisstate = Constant.getConstantsMap(CodeReverseKey.CNNT_DISSTATE);

		SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
		
		//提交修改列表
		String[] recids = param.getRecids().split(",");
		if (recids.length < 1)	Assert.isTrue(false, SalesrServiceRetCode.ID_Empty, "ID丢失!");
		List saveList = new ArrayList();
		for (int i=0;i<recids.length;i++){
			Long id = null;
			try{
				id = new Long(recids[i]);
			}catch(Exception e){
				logger.error("DeliveryServiceImpl.modify[修改状态ID转换出错]:"+e.getMessage());
			}
			if (id!=null){
				if(ConstantsType.DISSTATE_DISING.equals(param.getDisstate())){//启动配送操作
					try{
						FxSwDisform obj = (FxSwDisform) this.get(id);
						if (member.getWayid()!= null && member.getWayid().equals(obj.getDiscomcode())){
							if (!cnntDisstate.containsKey(obj.getDisstate())){
								//修改状态:将状态由"待配送"改为"配送中"
								obj.setDisstate(param.getDisstate());
								saveList.add(obj);							
							}//状态判断
						}//Wayid 判断
					}catch(Exception e){
						//对象不存在
						logger.error("DeliveryServiceImpl.modify[对象不存在(id:"+ id +")]:"+e.getMessage());
					}
				}else{//完成配送操作
					FxSwDisform o = (FxSwDisform) this.get(id);
					if(ConstantsType.DISSTATE_WAITDIS.equals(o.getDisstate())||ConstantsType.DISSTATE_DISING.equals(o.getDisstate())){
						//将状态修改为"配送完成"
						o.setDisstate(ConstantsType.DISSTATE_DISOVER);
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
						fxSwSmsconfirmDao.save(smsconfirm);
						
						//通知合作商签收
						ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
						//短信类型取3
						smsWaitreq.setSmstype(new Long(3));
						//查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值
						IbGlSysparamId ibGlSysparamId = new IbGlSysparamId();
						ibGlSysparamId.setParamtype("pboss_fx");
						ibGlSysparamId.setSystemid(new Long(42));
						IbGlSysparam ibGlSysparam = (IbGlSysparam )ibGlSysparamDao.get(ibGlSysparamId);
						//发送号码
						smsWaitreq.setSendno(ibGlSysparam.getParamvalue());
						//取配送单中的收货人电话
						smsWaitreq.setRecno(o.getRecetel());
						ChSmsSmstmpl chSmsSmstmpl = null;
						try {
							//调用商品订购短信公用方法（合作商签收确认）获取。客户名称获取逻辑：
							//根据合作商编码查询渠道人员基本信息表（CH_PW_EMPLOYEE），匹配是否为店主字段为是（即ISNET=1）、
							//用工状态为在岗（即EMPSTATUS=0），客户名称取姓名，如果无数据或姓名为空，
							//则默认取“客户”；日期取当前时间；确认流水号取订单末尾四位；
							chSmsSmstmpl = (ChSmsSmstmpl)chSmsSmstmplDao.get("FX_ORDER_PARSIGNCON");
						} catch (ObjectRetrievalFailureException e) {
							//找不到短信模板不处理，照样配送完成
						}
						if(chSmsSmstmpl!=null){
							String scontent = chSmsSmstmpl.getScontent();
							//取客户名
//							Employee employee = ((DeliveryDao)getDao()).getWayNetEmployee(member.getWayid());
							
							String employeeName = "客户";
//							if(employee!=null){
//								employeeName = employee.getEmployeename()!=null&&
//								!"".equals(employee.getEmployeename().trim())?employee.getEmployeename():"客户";	
//							}
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
						}

						result.setSuccess(true);
						result.setRetCode(SalesrServiceRetCode.SUCCESS);
						
						//订单配送完成，修改相关信息
						//更新订单表FX_SW_ORDER中的配送完成时间DISOVERTIME为系统当前时间
							Date currentDate = new Date(System.currentTimeMillis());
							String orderId = o.getOrderid();
							FxSwOrder order = this.salesOrderDao.getById(orderId);
							order.setDisovertime(currentDate);
							this.salesOrderDao.update(order);
					}else if(ConstantsType.DISSTATE_DISOVER.equals(o.getDisstate())){
						result.setRetCode(SalesrServiceRetCode.State_Error_108);
					}else {
						result.setRetCode(SalesrServiceRetCode.State_Error);
					}
				}
			}//id 转换
		}//for
		if(ConstantsType.DISSTATE_DISING.equals(param.getDisstate())){
			if (saveList.size()<1) {
//				Assert.isTrue(false, SalesrServiceRetCode.State_Error, "状态错误!");
				result.setRetObject(new Integer(0));
				result.setRetCode(SalesrServiceRetCode.State_Error);
			}else{
				result.setSuccess(true);
				result.setRetObject(new Integer(saveList.size()));
				result.setRetCode(SalesrServiceRetCode.SUCCESS);
			}
		}
		return result;
	}

	private ServiceResult modigyLogs(LoginMember member, QueryParameter parameter){
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//判断参数
		Assert.notBlank(param.getRecid(), SalesrServiceRetCode.ID_Empty, "ID丢失!");
		
		DeliveryDao dao = (DeliveryDao) this.getDao();
		
		try{
			FxSwDisform obj = (FxSwDisform)dao.get(Long.parseLong(param.getRecid()));
			String logi = param.getLogisticsno();
			if(logi.getBytes().length<=32){
				obj.setLogisticsno(param.getLogisticsno());
				dao.save(obj);
				result.setSuccess(true);
				result.setRetCode(SalesrServiceRetCode.SUCCESS);
			}else{
				result.setSuccess(false);
				result.setRetCode(SalesrServiceRetCode.MOD_LOGI_ERROR);
			}
		}catch(ObjectRetrievalFailureException e){
			//对象不存在异常
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5，错误代表：SALESORDER_5
		}catch(Exception e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.MOD_LOGI_ERROR);
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#other(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	/**
	 * 重载Other方法，执行配送单明细子查询（明细列表）
	 */
	@Override
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		//定义返回信息
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		//ID验证
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID不存在！");
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//启动查询

		try{
			DeliveryDao dao = (DeliveryDao) this.getDao();
			List<FxSwOrdercomcate> lst = dao.getOrderComcateDtl(param.getOrderid());
			QueryResult retResult = new QueryResult(null, lst);
			//封装返回结果
			result.setRetResult(retResult);
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
		}catch(Exception e){
			//对象不存在异常
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5，错误代表：SALESORDER_5
		}
		
//		this.getDao().get
		return result;
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
	public SalesOrderDao getSalesOrderDao(){
		return this.salesOrderDao;
	}
	public void setSalesOrderDao(SalesOrderDao salesOrderDao){
		this.salesOrderDao = salesOrderDao;
	}
}
