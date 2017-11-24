package net.gmcc.pboss.domain.business;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import net.gmcc.pboss.utils.StringUtil;
import net.gmcc.pboss.b2mservice.Monthdetailrequest;
import net.gmcc.pboss.b2mservice.Monthdetailresponse;
import net.gmcc.pboss.b2mservice.Monthstatisticrequest;
import net.gmcc.pboss.b2mservice.Monthstatisticresponse;
import net.gmcc.pboss.b2mservice.Singlerecordrequest;
import net.gmcc.pboss.b2mservice.Singlerecordresponse;
import net.gmcc.pboss.b2mservice.Smsbosynrequest;
import net.gmcc.pboss.b2mservice.Smsbosynresponse;
import net.gmcc.pboss.b2mservice.Sumstatisticrequest;
import net.gmcc.pboss.b2mservice.Sumstatisticresponse;
import net.gmcc.pboss.common.dynamicds.DynamicSourceHelper;
import net.gmcc.pboss.common.dynamicds.DynamicSourceMap;
import net.gmcc.pboss.comswebservice.Opncodeapplyrsp;
import net.gmcc.pboss.comswebservice.Opncodeapplyreq;
import net.gmcc.pboss.comswebservice.Reqheader;
import net.gmcc.pboss.comswebservice.Rspheader;
import net.gmcc.pboss.pboss4crmservice.Empsynreq;
import net.gmcc.pboss.pboss4crmservice.Empsynrsp;
import net.gmcc.pboss.pboss4crmservice.Modifypromcomminforeq;
import net.gmcc.pboss.pboss4crmservice.Modifypromcomminforsp;
import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
import net.gmcc.pboss.pboss4crmservice.Oprsynreq;
import net.gmcc.pboss.pboss4crmservice.Oprsynrsp;
import net.gmcc.pboss.pboss4crmservice.Returnorderinreq;
import net.gmcc.pboss.pboss4crmservice.Returnorderinrsp;
import net.gmcc.pboss.pboss4crmservice.Waysynreq;
import net.gmcc.pboss.pboss4crmservice.Waysynrsp;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader.Retinfo;
import net.gmcc.pboss.domain.additional.xmldispatch.XMLDispatcher;
import net.gmcc.pboss.domain.business.b2m.monthdetail.MonthdetailService;
import net.gmcc.pboss.domain.business.b2m.monthstatistic.MonthstatisticService;
import net.gmcc.pboss.domain.business.b2m.singlerecord.SingleRecordService;
import net.gmcc.pboss.domain.business.b2m.smsbosyn.SmsbosynService;
import net.gmcc.pboss.domain.business.b2m.sumstatistic.SumstatisticService;
import net.gmcc.pboss.domain.business.empsyn.EmpsynService;
import net.gmcc.pboss.domain.business.modifypromcomminfo.ModifypromcomminfoService;
import net.gmcc.pboss.domain.business.opncodeapply.OpncodeapplyService;
import net.gmcc.pboss.domain.business.oprsyn.OprsynService;
import net.gmcc.pboss.domain.business.returnorderin.ReturnorderinCheckService;
import net.gmcc.pboss.domain.business.returnorderin.ReturnorderinService;
import net.gmcc.pboss.domain.business.waysyn.WaysynBOSSService;
import net.gmcc.pboss.domain.business.waysyn.WaysynService;
import net.gmcc.pboss.utils.ParamsUtil;
import net.gmcc.pboss.utils.ServiceUtil;

import org.apache.log4j.Logger;

public class ServiceDispatcher {
	
	private static final Logger log = Logger.getLogger(ServiceDispatcher.class);
	
	/**
	 * 渠道同步
	 * @param request
	 * @return
	 */
	public Waysynrsp waysyn(Waysynreq request){
		Waysynrsp response = new Waysynrsp();
		Msgrspheader rspheader = new Msgrspheader();
		rspheader.setRetinfo(new Retinfo());
		response.setMsgrspheader(rspheader);
		if(null != ServiceUtil.ac){
			try{				
				//渠道表在公共库，渠道日志表在地市库，切换到地市库处理，
				//要求地市库有别名，且公共库中在渠道表上赋权允许地市库登录角色修改				
				//切换数据源				
				String cityid = null;
				//根据请求报文头的路由信息，切换地市库
				try{//路由信息必须为route:routetype=0，routevalue=760形式					
					String cityno = request.getMsgreqheader().getRoute().getRouteValue();
					cityid = ParamsUtil.getRegionLetterMap().get(cityno);
				}catch(Exception e){
					//存在null引用，不处理异常，待业务处理类中校验报文时处理
				}
				//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
				if(cityid!=null && !"".equals(cityid)){
					//DynamicSourceHelper.setDataSourceUser(cityid);	
					//全省NGBOSS启用后，注释下面代码，上面一行代码取消注释
					InputStream in = ServiceDispatcher.class.getResourceAsStream("/data/NGBOSSCityConfig.properties");
					Properties props = new Properties();
					props.load(in);
					String BOSSstate = props.getProperty("BOSS");
					if("Y".equals(BOSSstate)){//21个地市尚有使用BOSS的，将渠道数据修改到BOSS公共库，让BOSS同步到COMS公共库
						if(props.get(cityid).equals("Y")){//当前地市启用了NG
							DynamicSourceHelper.setDataSourceUser(cityid);
							//DynamicSourceHelper.setDataSourceUser(DynamicSourceMap.BOSS);
							WaysynBOSSService service = ServiceUtil.ac.getBean(WaysynBOSSService.class);
							log.info("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn:WaysynBOSSService]-----");
							System.out.println("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn:WaysynBOSSService]-----");
							//所有异常处理,放在业务处理方法中.
							service.doBusiness(request, rspheader);
						}else{
							//未启用NG，不能调用Web Service服务
							Msgrspheader.Retinfo retinfo = new Msgrspheader.Retinfo();
							rspheader.setRetinfo(retinfo);
							rspheader.getRetinfo().setRetcode(888002);
							rspheader.getRetinfo().setRetmsg("缺少配置信息，地市未放通渠道同步接口开关.");
							rspheader.getRetinfo().setRetype(600);
							log.info("-------------------------缺少配置信息，地市未放通渠道同步接口开关NGBOSSCityConfig.properties.");
							System.out.println("-------------------------缺少配置信息，地市未放渠道同步通接口开关NGBOSSCityConfig.properties.");
						}						
					}else{//全省启用NG，BOSS不再使用，直接将渠道数据同步到COMS公共库
						DynamicSourceHelper.setDataSourceUser(cityid);	
						
						WaysynService service = ServiceUtil.ac.getBean(WaysynService.class);
						log.info("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn:WaysynService]-----");
						System.out.println("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn:WaysynService]-----");
						//所有异常处理,放在业务处理方法中.
						service.doBusiness(request, rspheader);
					}
//					if(props.get(cityid).equals("Y")){//地市启用NGBOSS，将渠道数据直接同步到COMS渠道表
//						DynamicSourceHelper.setDataSourceUser(cityid);	
//						
//						WaysynService service = ServiceUtil.ac.getBean(WaysynService.class);
//						log.info("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn]-----");
//						System.out.println("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn]-----");
//						//所有异常处理,放在业务处理方法中.
//						service.doBusiness(request, rspheader);
//					}else{//地市尚未启用NGBOSS，将渠道信息先同步到BOSS，由BOSS把渠道信息同步到COMS
//						DynamicSourceHelper.setDataSourceUser(cityid);
//						//DynamicSourceHelper.setDataSourceUser(DynamicSourceMap.BOSS);
//						WaysynBOSSService service = ServiceUtil.ac.getBean(WaysynBOSSService.class);
//						log.info("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn]-----");
//						System.out.println("-------------------------开始业务处理[PBOSS_IM_009PBOSS渠道资料更新:waysyn]-----");
//						//所有异常处理,放在业务处理方法中.
//						service.doBusiness(request, rspheader);
//					}					
				}				
				//切换回默认数据源
				if(cityid!=null && !"".equals(cityid)){
					DynamicSourceHelper.removeDataSurceUser();		
				}	
			}catch(Exception e){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", e);
			}
		}else{
			Msgrspheader.Retinfo retinfo = new Msgrspheader.Retinfo();
			rspheader.setRetinfo(retinfo);
			rspheader.getRetinfo().setRetcode(888003);
			rspheader.getRetinfo().setRetmsg("不能获取服务上下文.");
			rspheader.getRetinfo().setRetype(600);
			log.info("-------------------------不能获取服务上下文.");
		}		
		return response;
	}
	
	/**
	 * 人员同步
	 * @param request
	 * @return
	 */
	public Empsynrsp empsyn(Empsynreq request){
		Empsynrsp response = new Empsynrsp();
		Msgrspheader rspheader = new Msgrspheader();
		rspheader.setRetinfo(new Retinfo());
		response.setMsgrspheader(rspheader);
		if(null != ServiceUtil.ac){
			try{
				//切换数据源				
				String cityid = null;
				//根据请求报文头的路由信息，切换地市库
				try{//路由信息必须为route:routetype=0，routevalue=760形式					
					String cityno = request.getMsgreqheader().getRoute().getRouteValue();
					cityid = ParamsUtil.getRegionLetterMap().get(cityno);
				}catch(Exception e){
					//存在null引用，不处理异常，待业务处理类中校验报文时处理
				}
				//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
				if(cityid!=null && !"".equals(cityid)){
					DynamicSourceHelper.setDataSourceUser(cityid);	
				}
				
				EmpsynService service = ServiceUtil.ac.getBean(EmpsynService.class);
				log.info("-------------------------开始业务处理[PBOSS_IM_008人员资料更新:empsyn]-----");
				System.out.println("-------------------------开始业务处理[PBOSS_IM_008人员资料更新:empsyn]-----");
				service.doBusiness(request, rspheader);
				
				//切换回默认数据源
				if(cityid!=null && !"".equals(cityid)){
					DynamicSourceHelper.removeDataSurceUser();		
				}	
			}catch(Exception e){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", e);
			}
		}else{
			Msgrspheader.Retinfo retinfo = new Msgrspheader.Retinfo();
			rspheader.setRetinfo(retinfo);
			rspheader.getRetinfo().setRetcode(888003);
			rspheader.getRetinfo().setRetmsg("不能获取服务上下文.");
			rspheader.getRetinfo().setRetype(600);
			log.info("-------------------------不能获取服务上下文.");
		}		
		return response;
	}
	
	/**
	 * 推广专员注册、修改
	 * @param request
	 * @return
	 */
	public Modifypromcomminforsp modifypromcomminfo(Modifypromcomminforeq request){
		Modifypromcomminforsp response = new Modifypromcomminforsp();
		Msgrspheader rspheader = new Msgrspheader();
		response.setMsgrspheader(rspheader);
		if(null != ServiceUtil.ac){
			try{
				//切换数据源				
				String cityid = null;
				//根据请求报文头的路由信息，切换地市库
				try{//路由信息必须为route:routetype=0，routevalue=760形式					
					String cityno = request.getMsgreqheader().getRoute().getRouteValue();
					cityid = ParamsUtil.getRegionLetterMap().get(cityno);
				}catch(Exception e){
					//存在null引用，不处理异常，待业务处理类中校验报文时处理
				}
				//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
				if(cityid!=null && !"".equals(cityid)){
					DynamicSourceHelper.setDataSourceUser(cityid);	
				}
				
				ModifypromcomminfoService service = ServiceUtil.ac.getBean(ModifypromcomminfoService.class);
				log.info("-------------------------开始业务处理[PBOSS_IM_010 新增注册推广专员信息:modifypromcomminfo]-----");
				System.out.println("-------------------------开始业务处理[PBOSS_IM_010 新增注册推广专员信息:modifypromcomminfo]-----");
				//所有异常处理,放在业务处理方法中.
				service.doBusiness(request, rspheader);
				
				//切换回默认数据源
				if(cityid!=null && !"".equals(cityid)){
					DynamicSourceHelper.removeDataSurceUser();		
				}
			}catch(Exception e){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", e);
			}
		}else{
			Msgrspheader.Retinfo retinfo = new Msgrspheader.Retinfo();
			rspheader.setRetinfo(retinfo);
			rspheader.getRetinfo().setRetcode(888003);
			rspheader.getRetinfo().setRetmsg("不能获取服务上下文.");
			rspheader.getRetinfo().setRetype(600);
			log.info("-------------------------不能获取服务上下文.");
		}		
		return response;
	}
	
	/**
	 * 工号同步
	 * @param request
	 * @return
	 */
	public Oprsynrsp oprsyn(Oprsynreq request){
		Oprsynrsp response = new Oprsynrsp();
		Msgrspheader rspheader = new Msgrspheader();
		rspheader.setRetinfo(new Retinfo());
		response.setMsgrspheader(rspheader);
		if(null != ServiceUtil.ac){
			try{
				DynamicSourceHelper.removeDataSurceUser();		
				//工号表在公共库，使用默认数据源，无需切换数据库				
				OprsynService service = ServiceUtil.ac.getBean(OprsynService.class);
				log.info("-------------------------开始业务处理[PBOSS_IM_007工号资料更新:oprsyn]-----");
				System.out.println("-------------------------开始业务处理[PBOSS_IM_007工号资料更新:oprsyn]-----");
				service.doBusiness(request, rspheader);
			}catch(Exception e){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", e);
			}
		}else{
			Msgrspheader.Retinfo retinfo = new Msgrspheader.Retinfo();
			rspheader.setRetinfo(retinfo);
			rspheader.getRetinfo().setRetcode(888003);
			rspheader.getRetinfo().setRetmsg("不能获取服务上下文.");
			rspheader.getRetinfo().setRetype(600);
			log.info("-------------------------不能获取服务上下文.");
		}		
		return response;
	}
	
	/**
	 * CRM订单入账回调接口：COMS调用CRM入账后，CRM通过调用此接口反馈入账结果给COMS
	 * @param request
	 * @return
	 */
	public Returnorderinrsp returnorderin(Returnorderinreq request){
		Returnorderinrsp response = new Returnorderinrsp();
		Msgrspheader rspheader = new Msgrspheader();
		rspheader.setRetinfo(new Retinfo());
		response.setMsgrspheader(rspheader);
		Msgrspheader.Retinfo retinfo = new Msgrspheader.Retinfo();
		rspheader.setRetinfo(retinfo);
		if(null != ServiceUtil.ac){
			try{
				//切换数据源				
				String cityid = null;
				//根据请求报文头的路由信息，切换地市库
				try{//路由信息必须为route:routetype=0，routevalue=760形式					
					String cityno = request.getMsgreqheader().getRoute().getRouteValue();
					cityid = ParamsUtil.getRegionLetterMap().get(cityno);
				}catch(Exception e){//存在null引用，不处理异常，待业务处理类中校验报文时处理
				}
				//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
				if(cityid!=null && !"".equals(cityid)){
					DynamicSourceHelper.setDataSourceUser(cityid);	
				}
				
				//先对请求报文校验，通过校验后启动新线程处理具体业务逻辑
				log.info("-------------------------开始业务处理[PBOSS_IM_011订单入帐/退入帐处理结果:returnorderin]-----");
				System.out.println("-------------------------开始业务处理[PBOSS_IM_011订单入帐/退入帐处理结果:returnorderin]-----");
				ReturnorderinCheckService checkService = ServiceUtil.ac.getBean(ReturnorderinCheckService.class);
				boolean pass = checkService.doBusiness(request, rspheader);
				
				if (pass) {//校验通过，直接进行后续处理，不使用多线程处理
					ReturnorderinService service = ServiceUtil.ac.getBean(ReturnorderinService.class);				
					service.doBusiness(request, rspheader);
				}
				
				/* 
				 * 何晋文：
				 * 5.2	COMS对外Web服务程序
				 * 	5.2.1    修改【CRM回调COMS订单入账接口程序】逻辑
				 *           新逻辑：将报文格式检验和报文处理放在一个类中处理，不使用多线程
				 if(pass){//校验通过，启动新线程处理
					Thread t = new Thread(new ServiceThread(request,rspheader,cityid));
					log.info("-------------------------启动新线程处理请求：开始-----");
					t.start();
					log.info("-------------------------启动新线程处理请求：结束-----");
				}				*/
				//切换回默认数据源
				if(cityid!=null && !"".equals(cityid)){
					DynamicSourceHelper.removeDataSurceUser();		
				}
			}catch(Exception e){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", e);
			}
		}else{
			rspheader.getRetinfo().setRetcode(888003);
			rspheader.getRetinfo().setRetmsg("不能获取服务上下文.");
			rspheader.getRetinfo().setRetype(600);
			log.info("-------------------------不能获取服务上下文.");
		}
		return response;
	}
	
	private class ServiceThread implements Runnable{
		Object request;
		Msgrspheader rspheader;
		String cityid;
		ServiceThread(Object request,Msgrspheader rspheader,String cityid){
			this.cityid = cityid;
			this.request = request;
			this.rspheader = rspheader;
		}
		
		public void run(){
			try{
				DynamicSourceHelper.setDataSourceUser(cityid);	
				ReturnorderinService service = ServiceUtil.ac.getBean(ReturnorderinService.class);				
				service.doBusiness(request, rspheader);
			}catch(Exception e){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", e);
			}
		}
	}
	
	/**
	 * 品高精益营销管理平台：业务编码注册接口
	 * 史晓龙：该接口一致未使用，也为联调20140102
	 * @param opncodeapplyreq
	 * @return
	 */
	public Opncodeapplyrsp opncodeapply(Opncodeapplyreq opncodeapplyreq){
		Opncodeapplyrsp rsp = new Opncodeapplyrsp();
		Rspheader rsphead = new Rspheader();
		Rspheader.Retinfo ret = new Rspheader.Retinfo();
		ret.setRetcode(1);//默认失败
		rsphead.setRetinfo(ret);
		rsp.setRspheader(rsphead);
		Opncodeapplyrsp.Rspbody rspbody = new Opncodeapplyrsp.Rspbody();
		rsp.setRspbody(rspbody);
		if(null != ServiceUtil.ac){
			try{
				//使用默认数据源，无需切换数据库				
				OpncodeapplyService service = ServiceUtil.ac.getBean(OpncodeapplyService.class);
				log.info("-------------------------开始业务处理[新业务编码申请接口:opncodeapply]-----");
				//所有异常处理,放在业务处理方法中.
				service.doBusiness(opncodeapplyreq,rsp);
			}catch(Exception e){
				//所有异常处理,放在业务处理方法中.
				//此处，如果数据库无法连接，上面的service对象还是可以创建的，但只是创建了一个标识，由于数据库无法连接导致DAO成员无法依赖注入，
				//实际service对象并没有成功创建，由于Spring延迟创建对象，所以在调用doBusiness()方法时才会抛出异常，而且程序也未进入doBusiness()方法
				log.info("请求处理时发生异常", e);
				String errmsg = rsp.getRspheader().getRetinfo().getRetmsg();
				if(errmsg==null || "".equals(errmsg)){//发生异常且错误信息为空，说明出现了非业务异常或其他未能捕获的异常
					rsp.getRspheader().getRetinfo().setRetmsg(e.getMessage());
					rsp.getRspheader().getRetinfo().setRetcode(1);
					return rsp;
				}				
			}
		}else{
			log.info("-------------------------不能获取服务上下文.");
			Reqheader rh = opncodeapplyreq.getReqheader();
			Opncodeapplyreq.Reqbody rb = opncodeapplyreq.getReqbody();
			//业务平台来源：PSGM 业务标识：opncodeapply
			rsphead.setPlatform(rh.getPlatform());//"PSGM"
			rsphead.setProcessCode(rh.getProcessCode());//opncodeapply
			rsphead.setReqSeq(rh.getReqSeq());
			rsphead.setRspSeq(StringUtil.getSequenceId());
			rsphead.setRspTime(StringUtil.changeDateToStr14(new Date()));
			//ret = new Rspheader.Retinfo();
			ret.setRetcode(1);
			ret.setRetmsg("接口服务上下文不可用");
			//rsphead.setRetinfo(ret);
			
			rspbody.setId(rb.getId());
			rspbody.setOpnid("");
			rspbody.setParentid(rb.getParentid());
			rspbody.setState(1);			
		}
		
		return rsp;
	}
	
	/**
	 * 客户端酬金单条明细查询接口
	 * @param request
	 * @return
	 */
	public Singlerecordresponse singlerecord(Singlerecordrequest request){
		Singlerecordresponse rsp = new Singlerecordresponse();
		net.gmcc.pboss.b2mservice.Msgrspheader rsphead = new net.gmcc.pboss.b2mservice.Msgrspheader();
		rsp.setMsgrspheader(rsphead);
		Singlerecordresponse.Msgbody body = new Singlerecordresponse.Msgbody();
		rsp.setMsgbody(body);
		if(null != ServiceUtil.ac){
			//根据请求报文头的路由信息，切换地市库			
			String cityid = null;			
			try{//路由信息必须为route:routetype=0，routevalue=760形式					
				String cityno = request.getMsgreqheader().getRoute();
				cityid = ParamsUtil.getRegionLetterMap().get(cityno);
			}catch(Exception e){//存在null引用，不处理异常，待业务处理类中校验报文时处理
			}
			//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.setDataSourceUser(cityid);	
			}
			
			try{
				SingleRecordService service = ServiceUtil.ac.getBean(SingleRecordService.class);
				log.info("-------------------------开始业务处理[客户端酬金单条明细查询接口:singlerecord]-----");
				service.doBusiness(request,rsp);
			}catch(Exception ex){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", ex);			
			}
			//切换回默认数据源
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.removeDataSurceUser();		
			}
		}else{
			net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo ret = new net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo();
			ret.setRetmsg("不能获取服务上下文.");
			ret.setRettype(600);
			ret.setRetcode(600);
			rsphead.setRetinfo(ret);
			log.info("-------------------------不能获取服务上下文.");
		}
		return rsp;
	}
	/**
	 * 客户端月酬金统计接口
	 * @param request
	 * @return
	 */
	public Monthstatisticresponse monthstatistic(Monthstatisticrequest request){
		Monthstatisticresponse rsp = new Monthstatisticresponse();
		net.gmcc.pboss.b2mservice.Msgrspheader rsphead = new net.gmcc.pboss.b2mservice.Msgrspheader();
		rsp.setMsgrspheader(rsphead);
		Monthstatisticresponse.Msgbody body = new Monthstatisticresponse.Msgbody();
		rsp.setMsgbody(body);
		if(null != ServiceUtil.ac){
			//根据请求报文头的路由信息，切换地市库			
			String cityid = null;			
			try{//路由信息必须为route:routetype=0，routevalue=760形式					
				String cityno = request.getMsgreqheader().getRoute();
				cityid = ParamsUtil.getRegionLetterMap().get(cityno);
			}catch(Exception e){//存在null引用，不处理异常，待业务处理类中校验报文时处理
			}
			//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.setDataSourceUser(cityid);	
			}
			
			try{
				MonthstatisticService service = ServiceUtil.ac.getBean(MonthstatisticService.class);
				log.info("-------------------------开始业务处理[客户端月酬金统计接口:monthstatistic]-----");
				service.doBusiness(request,rsp);
			}catch(Exception ex){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", ex);			
			}
			//切换回默认数据源
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.removeDataSurceUser();		
			}
		}else{
			net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo ret = new net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo();
			ret.setRetmsg("不能获取服务上下文.");
			ret.setRettype(600);
			ret.setRetcode(600);
			rsphead.setRetinfo(ret);
			log.info("-------------------------不能获取服务上下文.");
		}
		return rsp;
	}
	/**
	 * 客户端总酬金统计接口
	 * @param request
	 * @return
	 */
	public Sumstatisticresponse sumstatistic(Sumstatisticrequest request){
		Sumstatisticresponse rsp = new Sumstatisticresponse();
		net.gmcc.pboss.b2mservice.Msgrspheader rsphead = new net.gmcc.pboss.b2mservice.Msgrspheader();
		rsp.setMsgrspheader(rsphead);
		Sumstatisticresponse.Msgbody body = new Sumstatisticresponse.Msgbody();
		rsp.setMsgbody(body);
		if(null != ServiceUtil.ac){
			//根据请求报文头的路由信息，切换地市库			
			String cityid = null;			
			try{//路由信息必须为route:routetype=0，routevalue=760形式					
				String cityno = request.getMsgreqheader().getRoute();
				cityid = ParamsUtil.getRegionLetterMap().get(cityno);
			}catch(Exception e){//存在null引用，不处理异常，待业务处理类中校验报文时处理
			}
			//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.setDataSourceUser(cityid);	
			}
			
			try{
				SumstatisticService service = ServiceUtil.ac.getBean(SumstatisticService.class);
				log.info("-------------------------开始业务处理[客户端总酬金统计:sumstatistic]-----");
				service.doBusiness(request,rsp);
			}catch(Exception ex){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", ex);				
			}
			
			//切换回默认数据源
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.removeDataSurceUser();		
			}
		}else{
			net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo ret = new net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo();
			ret.setRetmsg("不能获取服务上下文.");
			ret.setRettype(600);
			ret.setRetcode(600);
			rsphead.setRetinfo(ret);
			log.info("-------------------------不能获取服务上下文.");
		}
		return rsp;
	}
	/**
	 * 客户端月酬金明细查询接口
	 * @param request
	 * @return
	 */
	public Monthdetailresponse monthdetail(Monthdetailrequest request){
		Monthdetailresponse rsp = new Monthdetailresponse();
		net.gmcc.pboss.b2mservice.Msgrspheader rsphead = new net.gmcc.pboss.b2mservice.Msgrspheader();
		rsp.setMsgrspheader(rsphead);
		Monthdetailresponse.Msgbody body = new Monthdetailresponse.Msgbody();
		rsp.setMsgbody(body);
		if(null != ServiceUtil.ac){
			//根据请求报文头的路由信息，切换地市库			
			String cityid = null;			
			try{//路由信息必须为route:routetype=0，routevalue=760形式					
				String cityno = request.getMsgreqheader().getRoute();
				cityid = ParamsUtil.getRegionLetterMap().get(cityno);
			}catch(Exception e){//存在null引用，不处理异常，待业务处理类中校验报文时处理
			}
			//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.setDataSourceUser(cityid);	
			}
			
			try{
				MonthdetailService service = ServiceUtil.ac.getBean( MonthdetailService.class);
				log.info("-------------------------开始业务处理[客户端月酬金明细查询接口:monthdetail]-----");
				service.doBusiness(request,rsp);
			}catch(Exception ex){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", ex);
			}
			//切换回默认数据源
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.removeDataSurceUser();		
			}
		}else{
			net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo ret = new net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo();
			ret.setRetmsg("不能获取服务上下文.");
			ret.setRettype(600);
			ret.setRetcode(600);
			rsphead.setRetinfo(ret);
			log.info("-------------------------不能获取服务上下文.");
		}
		return rsp;
	}
	
	public Smsbosynresponse smsbosyn(Smsbosynrequest request){
		Smsbosynresponse rsp = new Smsbosynresponse();
		net.gmcc.pboss.b2mservice.Msgrspheader rsphead = new net.gmcc.pboss.b2mservice.Msgrspheader();
		rsp.setMsgrspheader(rsphead);
		if(null != ServiceUtil.ac){
			//根据请求报文头的路由信息，切换地市库			
			String cityid = null;			
			try{//路由信息必须为route:routetype=0，routevalue=760形式					
				String cityno = request.getMsgreqheader().getRoute();
				cityid = ParamsUtil.getRegionLetterMap().get(cityno);
			}catch(Exception e){//存在null引用，不处理异常，待业务处理类中校验报文时处理
			}
			//此处不处理地市为空的异常，地市标识为空的异常在业务类中处理返回给地市
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.setDataSourceUser(cityid);	
			}
			
			try{
				SmsbosynService service = ServiceUtil.ac.getBean(SmsbosynService.class);
				log.info("-------------------------开始业务处理[日办理业务数据实时接口:smsbosyn]-----");
				service.doBusiness(request, rsp);
			}catch(Exception ex){//所有异常处理,放在业务处理方法中.
				log.info("请求处理时发生异常", ex);
			}
			//切换回默认数据源
			if(cityid!=null && !"".equals(cityid)){
				DynamicSourceHelper.removeDataSurceUser();		
			}
		}else{
			net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo ret = new net.gmcc.pboss.b2mservice.Msgrspheader.Retinfo();
			ret.setRetmsg("不能获取服务上下文.");
			ret.setRettype(600);
			ret.setRetcode(600);
			rsphead.setRetinfo(ret);
			log.info("-------------------------不能获取服务上下文.");
		}
		
		return rsp;
	}
	
	public void dispatch(Object request,Msgreqheader reqHeader){
		//System.out.println("-----I am in ServiceDispatcher.dispatch()");
		XMLDispatcher xmlDispatcher = ServiceUtil.ac.getBean(XMLDispatcher.class);
		log.info(StringUtil.getProcessCode(reqHeader)+xmlDispatcher.toString()+" "+xmlDispatcher.hashCode());
	    xmlDispatcher.dispatch(request,reqHeader);
	    //System.out.println("-----I am out ServiceDispatcher.dispatch()");
	}
}
