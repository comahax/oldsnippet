package net.gmcc.pboss.domain.business.returnorderin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.pboss4crmservice.Returnorderinreq;
import net.gmcc.pboss.pboss4crmservice.Msgreqheader.Channelinfo;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.AbstractService;
import net.gmcc.pboss.domain.business.OprType;
import net.gmcc.pboss.domain.business.service.BaseCrmService;
import net.gmcc.pboss.domain.model.dictitem.DictitemVO;
import net.gmcc.pboss.domain.model.employee.EmployeeVO;
import net.gmcc.pboss.domain.model.order.OrderVO;
import net.gmcc.pboss.domain.model.order.OrderlogVO;
import net.gmcc.pboss.domain.model.smsobject.SmsobjectVO;
import net.gmcc.pboss.domain.model.smstmpl.SmstmplVO;
import net.gmcc.pboss.domain.model.sysparam.SysparamVO;
import net.gmcc.pboss.domain.model.waitreq.WaitreqVO;

import net.gmcc.pboss.utils.BeanUtils;
import net.gmcc.pboss.utils.ParamsUtil;
import net.gmcc.pboss.utils.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ReturnorderinService extends BaseCrmService{
	private static final Logger log = Logger.getLogger(ReturnorderinService.class);
	
	public void doBusiness(Object requestin, Msgrspheader rspheader)throws Exception{		
		try{
			Returnorderinreq request = (Returnorderinreq)requestin;
			Msgreqheader reqheader = request.getMsgreqheader();
			//校验请求信息头，构造反馈消息头
			//this.checkAndSet(reqheader, rspheader);
			this.setProcessCode(reqheader);
			String routeValue = reqheader.getRoute().getRouteValue();
			routeValue = ParamsUtil.getRegionLetterMap().get(routeValue);
			
			//校验请求消息体
			Returnorderinreq.Msgbody reqbody = request.getMsgbody();
			//this.checkReqBody(reqbody);
			String orderid = reqbody.getOrderid().trim();
			String busitype = reqbody.getBusitype().trim();
			String bossworkfid = reqbody.getBossworkfid().trim();
			String orderresult = reqbody.getOrderresult().trim();
			String orderresultinfo =reqbody.getOrderresultinfo();
			
			log.info(processCode.get()+"-------------------------[PBOSS_IM_011订单入帐/退入帐处理结果:returnorderin]处理请求：开始-----");	
			System.out.println(processCode.get()+"-------------------------[PBOSS_IM_011订单入帐/退入帐处理结果:returnorderin]处理请求：开始-----");
			OrderVO orderVO = dao.find(OrderVO.class, orderid);
			
			if("0".equals(busitype)){
				if(orderVO!=null){				
					//发送短信
					//工单号不为空且不为“-1”
					if ("0".equals(orderresult) && StringUtil.isNotEmpty(bossworkfid)) {// 入账成功，且工单号不为空
						orderVO.setBossworkfid(bossworkfid);
						String memo = orderresult + "入账成功(" + orderresultinfo + ")";
						if (memo.length() > 256) {
							memo = memo.substring(0, 256);
						}
						orderVO.setMemo(memo);
						this.executeSingleData(OprType.UPDATE, orderVO);

						// 发送售卡通知
						try {
							log.info(processCode.get() + "写短信待发送表：开始，入账成功，发送售卡通知");
							this.doSmsForSale(orderVO, routeValue);
							log.info(processCode.get() + "写短信待发送表：完成，入账成功，发送售卡通知");
						} catch (Exception e) {
							log.info(processCode.get() + "入账成功，发送售卡通知-写短信待发送表：失败");
						}
					}else{
						orderVO.setBossworkfid("-1");	
						String memo = "";
						if("0".equals(orderresult) && StringUtil.isEmpty(bossworkfid)){//入账成功，但工单号为空值
							memo = orderresult+"入账报文显示入账成功[orderresult=0]，但工单号[bossworkfid]为空，按失败处理";
						}else{// orderresult="-1" 入账失败
							memo = orderresult+"入账失败("+orderresultinfo+")";
							if(memo.length()>256){
								memo = memo.substring(0, 256);
							}
						}
						orderVO.setMemo(memo);
						this.executeSingleData(OprType.UPDATE, orderVO);
						
						//短信提醒渠道主管
						try{
							log.info(processCode.get()+"写短信待发送表：开始，入账失败，短信提醒渠道主管");
							this.doSendFailSms(orderVO, routeValue);
							log.info(processCode.get()+"写短信待发送表：完成，入账失败，短信提醒渠道主管");
						}catch(Exception e){
							log.info(processCode.get()+"入账失败，短信提醒渠道主管-写短信待发送表：失败");
						}												
					}
					
					//写日志表
					OrderlogVO orderlogVO = new OrderlogVO();
					BeanUtils.copyProperties(orderlogVO, orderVO);
					orderlogVO.setOptime(new Date());
					String operatorid = "CRMSYN";
					Channelinfo channelinfo = reqheader.getChannelinfo();
					if(channelinfo != null && !"".equals(channelinfo)){
						if(channelinfo.getOperatorid() != null 
								&& !"".equals(channelinfo.getOperatorid())){
							operatorid = channelinfo.getOperatorid();
						}
					}
					orderlogVO.setOprcode(operatorid);
					orderlogVO.setOprtype(OprType.CREATE);
					orderlogVO.setSuccess("success");
					this.executeBusinessLog(orderlogVO);					
				}else{
					throw new RequestMessageException("请求信息[orderid="+orderid+"]订单信息不存在。");
				}
			}else{// busitype=1退入帐:COMS目前不支持
				throw new RequestMessageException("请求操作类型[busitype="+busitype+"]COMS系统不支持，目前仅支持[0:入账]。");
			}
			log.info(processCode.get()+"-------------------------[PBOSS_IM_011订单入帐/退入帐处理结果:returnorderin]处理请求：完成-----");	
		}catch(RequestMessageException e){//参数完整性校验-报文格式异常
			rspheader.getRetinfo().setRetcode(888001);
			rspheader.getRetinfo().setRetype(600);
			rspheader.getRetinfo().setRetmsg("报文格式异常:"+e.getMessage());
			log.info(processCode.get()+"报文格式异常:"+e.getMessage());
			log.info(processCode.get()+"-------------------------[PBOSS_IM_011订单入帐/退入帐处理结果:returnorderin]处理请求：结束-----");	
		}catch(Exception e){//其他异常，主要是数据库操作异常信息
			e.printStackTrace();
			rspheader.getRetinfo().setRetcode(888002);
			rspheader.getRetinfo().setRetype(600);
			rspheader.getRetinfo().setRetmsg(e.getMessage());
			log.info(processCode.get()+e.getMessage());
			log.info(processCode.get()+"-------------------------[PBOSS_IM_011订单入帐/退入帐处理结果:returnorderin]处理请求：结束-----");	
		}
	}
	
	@Override
	public void checkReqBody(Object reqbody) throws RequestMessageException {
		if(reqbody==null){
			throw new RequestMessageException("请求体[msgbody]不能为空");
		}
		String busitype = ((Returnorderinreq.Msgbody)reqbody).getBusitype();
		if(busitype==null || "".equals(busitype) || "null".equals(busitype)){
			throw new RequestMessageException("请求体[busitype]不能为空");
		}
		String orderid = ((Returnorderinreq.Msgbody)reqbody).getOrderid();
		if(orderid==null || "".equals(orderid) || "null".equals(orderid)){
			throw new RequestMessageException("请求体[orderid]不能为空");
		}
		
	}
	
	private void doSendFailSms(OrderVO vo, String cityid) throws Exception{
		String FAULT = "向分公司渠道经理发送入账失败短信异常，";
		/*
		 * 新增数据到短信待发送表(CH_SMS_WAITREQ)，字段取值如下：
		 * 短信类型取3；
		 * 发送号码：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“42”，发送号码取参数值。
		 * 接收号码：分公司渠道经理；
		 * 短信内容：调用商品订购短信公用方法（入账失败通知FX_ORDER_RECORDEDN）获取。
		 * 客户名称取分公司渠道经理名称，如果该字段为空则默认取“渠道经理”；订单号；
		 * 获取渠道经理手机号：
			查询短信通知对象表(FX_SW_SMSOBJECT),匹配分公司为此订单的分公司，通知对象类型为‘渠道经理’，
			业务类型为‘其他’，获取手机号码（如果不只一条，需对每一条手机号码发送短信）。
		 */
		
		if(vo.getCountyid()==null || "".equals(vo.getCountyid().trim())){
			log.info(processCode.get()+FAULT+"订单["+vo.getOrderid()+"]分公司为空");
			return;
		}
		
		//获取分公司渠道经理
		String smsobjectHQL = "from SmsobjectVO where countyid=? and objecttype=? and busitype=?";
		List smsobjectList = (List)dao.find(smsobjectHQL, vo.getCountyid(),"WAYMANAGER","OTHERS");
		if(smsobjectList.size()>0){//分公司渠道经理存在
			//获取发送号码
			String sysparamvalue42="";
			String sysparamSql = " from SysparamVO vo where vo.id.systemid=? and vo.id.paramtype=? ";
			List sysparamList = (List)dao.find(sysparamSql, Long.parseLong("42"), "pboss_fx");
			if(sysparamList.size() > 0){
				SysparamVO sysparamVO = (SysparamVO)sysparamList.get(0);
				sysparamvalue42 = sysparamVO.getParamvalue();
			}else{
				log.info(processCode.get()+FAULT+"无法获取发送号码");
				return;
			}
			
			//获取短信内容
			String content = "";
			//查询短信模板表
			SmstmplVO smstmplVO=dao.find(SmstmplVO.class, "FX_ORDER_RECORDEDN");
			if(smstmplVO!=null && "1".equals(smstmplVO.getSstate())){
				content = smstmplVO.getScontent();
			}else{
				log.info(processCode.get()+FAULT+"无短信模板[FX_ORDER_RECORDEDN]，或者短信模板失效");
				return;
			}
			
			String custname = "";
			for(Iterator iter = smsobjectList.iterator();iter.hasNext(); ){
				SmsobjectVO soVO = (SmsobjectVO)iter.next();
				if(soVO.getName()==null || "".equals(soVO.getName())){
					custname="渠道经理";
				}else{
					custname = soVO.getName();
				}				
				WaitreqVO waitreqVO=new WaitreqVO();
				waitreqVO.setSmstype((short)3);
				waitreqVO.setSendno(sysparamvalue42);
				waitreqVO.setRecno(soVO.getMobile());
				waitreqVO.setAreacode(cityid);
				waitreqVO.setCreattime(new java.util.Date());
				
				String itercontent = content;
				itercontent = this.replace(itercontent, custname);
				itercontent = this.replace(itercontent, vo.getOrderid());
				waitreqVO.setMessage(itercontent);
				this.executeSingleData(OprType.CREATE, waitreqVO);
			}			
		}else{
			log.info(processCode.get()+FAULT+"[FX_SW_SMSOBJECT]无分公司["+vo.getCountyid()+"]渠道经理记录");
			return;
		}		
	}
	
	/**
	 * 写短信表-	接口调用成功后发送售卡通知
	 * 
	 * @param orderVO
	 * @throws Exception
	 */
	public void doSmsForSale(OrderVO orderVO, String cityid) throws Exception {
		//如果BOSS返回成功，且订单资源明细FX_SW_ORDERRESDET存在套卡数据（资源类别为套卡），则发送售卡通知短信，否则不处理。
		String orderresdetSql = " from OrderresdetVO vo " +
				"where vo.orderid=? and vo.restype=?";
		List orderresdetList = (List)dao.find(orderresdetSql, orderVO.getOrderid(),"COMRESSMP");
		
		if(orderresdetList.size()>0)
		{
			//描述
			String desc=null;
			//手机号码
			String officetel=null;
			//查询短信模板表
			SmstmplVO smstmplVO=dao.find(SmstmplVO.class, "FX_SALE_NOTICE");;
			if(smstmplVO!=null && "1".equals(smstmplVO.getSstate()))
			{
				//查询手机号码
				String employeeSql = " from EmployeeVO vo " +
					"where vo.wayid=? and vo.empstatus=? and vo.isnet=?";
				List employeeList = (List)dao.find(employeeSql, orderVO.getWayid(), Byte.parseByte("0"), Byte.parseByte("1"));
				if(employeeList.size() > 0){
					EmployeeVO empVO = (EmployeeVO)employeeList.get(0);
					if(empVO.getOfficetel()!=null)
					{
						officetel=empVO.getOfficetel();
						//统计商品种类
						desc= groupbyDet(orderVO.getOrderid());
						//替换短信模板
						String content=smstmplVO.getScontent();
						Date creTime=orderVO.getCreatetime();
						SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
						String sTime=sm.format(creTime);
						String time[]=StringUtils.splitPreserveAllTokens(sTime,"-");
						content=replace(content,time[0]);
						content=replace(content,time[1]);
						content=replace(content,time[2]);
						content=replace(content,desc);
						//新增数据到短信待发送表(CH_SMS_WAITREQ)，短信类型取3，短信内容和接收号码取已获取的数据。
						WaitreqVO waitreqVO=new WaitreqVO();
						String sysparamvalue42="";//sysparamBO.doFindByID("42", "pboss_fx");
						String sysparamSql = " from SysparamVO vo " +
							"where vo.id.systemid=? and vo.id.paramtype=? ";
						List sysparamList = (List)dao.find(sysparamSql, Long.parseLong("42"), "pboss_fx");
						if(sysparamList.size() > 0){
							SysparamVO sysparamVO = (SysparamVO)sysparamList.get(0);
							sysparamvalue42 = sysparamVO.getParamvalue();
						}
						waitreqVO.setSmstype((short)3);
						waitreqVO.setAreacode(cityid);
						waitreqVO.setCreattime(new java.util.Date());
						waitreqVO.setSendno(sysparamvalue42);
						waitreqVO.setDealcount(new Short("0"));
						waitreqVO.setIssuccess(new Short("0"));
						waitreqVO.setMessage(content);
						waitreqVO.setRecno(officetel);
						//dao.save(waitreqVO);
						this.executeSingleData(OprType.CREATE, waitreqVO);
					}
				}
			}
		}
	}
	
	/**
	 * 将订单资源明细表中的数据按商品种类进行分组合计,拼成字符串
	 * 
	 * @param params
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	public String groupbyDet(String orderid)
			throws Exception {
		String desc="";
		// 用wayid 装载 count出来的数字
		List myGroupby = groupbyDet1(orderid);
		if(myGroupby.size()>0)
		{
			List<Object[]> myIt=myGroupby;
			int cnt=0;
			for(Object[] objMap:myIt){
				if(objMap[0]!=null && objMap[1]!=null){
					//翻译
					String dictitemSql = " from DictitemVO vo " +
							"where vo.id.groupid=? and vo.id.dictid=? ";
					List dictitemList = (List)dao.find(dictitemSql, "IM_FXCOMCATEGORY", objMap[0]);
					DictitemVO dictitemVO=null;
					if(dictitemList.size() > 0){
						dictitemVO = (DictitemVO)dictitemList.get(0);
						if(dictitemVO!=null)
						{
							desc+=dictitemVO.getDictname();
							desc+=objMap[1];
							if(dictitemVO.getDictname().indexOf("套卡")!=-1)
							{
								desc+="套,";
							}else if(dictitemVO.getDictname().indexOf("充值卡")!=-1)
							{
								desc+="张,";
							}
						}
					}
				}
			}
			if(!"".equals(desc) && desc.length()>0){
				desc=desc.substring(0,desc.length()-1);
			}
		}
		return desc;
	}
	
	/**
	 * 将订单资源明细表中的数据按商品种类进行分组合计
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws Exception
	 */
	public List groupbyDet1(String orderid)throws Exception {
		//用wayid 装载 count出来的数字
		String sales_orderresdet_groupby = " select vo.comcategory,count(vo.comcategory) as orderid " +
				"from OrderresdetVO vo " +
				"where vo.orderid=? GROUP BY vo.comcategory ";
		List orderresdetList = (List)dao.find(sales_orderresdet_groupby, orderid);
		return orderresdetList;
	}
	
	public  String replace(String org,String str)
	{
		int start=org.indexOf("{");
		int end=org.indexOf("}");
		org=org.substring(0,start)+str+org.substring(end+1);
		return org;
	}
}
