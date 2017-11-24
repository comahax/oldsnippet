package com.gmcc.pboss.web.common.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.loginlog.LoginlogVO;
import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.channel.nosect.NosectDBParam;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.common.sms.ComOrderSms;
import com.gmcc.pboss.common.sms.RndNumberBuilder;
import com.gmcc.pboss.common.sms.SMSRndCode;
import com.gmcc.pboss.control.base.loginlog.Loginlog;
import com.gmcc.pboss.control.base.loginlog.LoginlogBO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.sunrise.ws.client.Result;

/**
 * @author 黃佰明
 */
public class LoginAction extends BaseAction {
	//配置在 log4.xml中
	public static final String LOGIN_LOGGER_NAME = "com.gmcc._login";
	public static final Logger log = Logger.getLogger(LOGIN_LOGGER_NAME);
	
	private ILoginCheck loginCheck;
	private Properties property = null;
	private static  String FAILURE="2";//失败
	private static  String SUCCESS="1";//成功
	private static  String WAIT="0";//等待或下一步
	private INGLoginCheck ngLoginCheck;
	private static Properties propNGLogin = null;//NG登录地市配置

	private Map citymap = new LinkedHashMap<String,String>();//省公司人员登录使用
	private String cityno;//省公司人员登录使用
	private static final String SMS_CODE = "SMS_CODE";//短信验证码在session的标识
	private String rndsmscode;

	public LoginAction() throws Exception {
		if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
			loginCheck = new NewLoginCheck();
		}else{
			loginCheck = new LoginCheck();
			FAILURE="-1";
			SUCCESS="0";
			WAIT="1";
		}
		super.setForm(new LoginForm());
		
		ngLoginCheck = null;
	}
	
	public String doCityselect() throws Exception{
//		String oprcode = form.getUser().getOprcode().trim();
//		//Pattern p = Pattern.compile("a*b");
//		//Matcher m = p.matcher("aaaaab");
//		//boolean b = m.matches();
//		//boolean b = Pattern.matches("a*b", "aaaaab");
//		Pattern p = Pattern.compile("[1-9]{1}[0-9]{10}");
//		Matcher m = p.matcher(oprcode);
//		if(m.matches()){
		try{
			InputStream in = LoginAction.class.getResourceAsStream("/data/cityNOtoName.properties");
			Properties props = new Properties();
			props.load(in);
			in.close();
			//Set<Map.Entry<String,String>> set = (Set<Map.Entry<String,String>>)props.entrySet();
			Set<Map.Entry<Object,Object>> set = props.entrySet();
				
			if(this.citymap==null){
				this.citymap = new LinkedHashMap<String,String>();
			}
			for(Iterator iter=set.iterator();iter.hasNext();){
				Map.Entry<String, String> me = (Map.Entry<String, String>)iter.next();
				this.citymap.put(me.getKey(), me.getValue());
			}
		}catch(Exception e){
			e.printStackTrace();
			addActionError("加载地市列表失败。");
			return "login";
		}
		return "cityselect";
	}
	public Map getCitymap() {
		return citymap;
	}
	
	public String doLoginprov() throws Exception{
		LoginForm form = (LoginForm) this.getForm();
		LoginlogVO logVO=null;
		try{
			if (form.getUser() == null) {
				return "login";
			} else if (!StringUtils.isValuedString(form.getUser().getOprcode())) {
				addActionError("手机号码缺失!");
				return "login";
			} else if (!StringUtils.isValuedString(this.getCityno())){
				addActionError("地市缺失!");
				return "login";
			} else {
				User user = form.getUser();
				//验证人员是否存在
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorDBParam params = new OperatorDBParam();
				params.set_pagesize("0");
				params.setDataOnly(true);
				params.set_se_contactphone(form.getUser().getOprcode().trim());
				params.set_se_logintype("NOTBOSS");
				DataPackage operdp = operator.doQuery(params);				
				OperatorVO vo = null;
				if(operdp!=null && operdp.getDatas()!=null && operdp.getDatas().size()>0){
					vo = (OperatorVO)operdp.getDatas().get(0);
				}else{
					throw new BusinessException("用户名不存在!");
				}				
				//if(vo.getRegion()==999){
				//	throw new BusinessException("当前登录工号没有访问PBOSS的权限!");
				//}
				if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("当前登录工号已无效!");
				}
				
				
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				user.setRemoteName(request.getRemoteHost());
				//记录日志
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getContactphone());//省公司人员用手机号码登录
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(CityMappingUtil.getCityid(this.getCityno()));
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());
				logVO.setIpaddress(ip);
				logVO.setLogintype(vo.getLogintype());
				
				//构建新数据库用户
				String cityid = CityMappingUtil.getCityid(this.getCityno());
				DBAccessUser dbuser = new DBAccessUser();
				dbuser.setCityid(cityid);
				dbuser.setIp(ip);
				dbuser.setRemoteName(request.getRemoteAddr());
				//发送随机短信
				return this.sendRandomSms(form.getUser().getOprcode().trim(), dbuser, "loginprov");
			}			
		}catch(Exception e){
			e.printStackTrace();
			if(logVO!=null){
				Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			this.addActionError("由于内部异常而无法登录! 原因:" + e.getMessage());
			return "login";
		}
	}
	
	public String doResendSms() throws Exception{
		String retmsg = null;
		LoginForm form = (LoginForm) this.getForm();
		String phone = form.getUser().getOprcode().trim();
		String isCitySms = form.getIsCitySms();
		OperatorVO vo = null;
		if("true".equals(isCitySms)){//地市公司时，工号转手机号码
			Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
			vo = operator.doFindByPk(phone);
			if(vo != null){
				phone = vo.getContactphone();
			}
		}
		
		//构建新数据库用户
		DBAccessUser dbuser = new DBAccessUser();
		if("true".equals(isCitySms)){
			String cityid = CityMappingUtil.getCityid(""+vo.getRegion());
			dbuser.setCityid(cityid);
		}else{
			String cityid = CityMappingUtil.getCityid(this.getCityno());
			dbuser.setCityid(cityid);
		}
		
		//从Session中取出短信验证码对象（SMSRndCode）;判断是否为null。若为null，则创建一个短信验证码对象，并记录创建的时间。
		Object obj = this.getRequest().getSession().getAttribute(SMS_CODE);
		SMSRndCode smsRndCode = null;
		if(obj==null){
			smsRndCode = new SMSRndCode(phone);
		}else{
			smsRndCode = (SMSRndCode)obj;
			smsRndCode.setMobile(phone);
		}		
		//获取6位随机短信码
		String rndCode = RndNumberBuilder.getRndNumber(6);		
		//随机码添加成功
		if(smsRndCode.addRndCode(rndCode).equals(SMSRndCode.PASS)){
			try{
				//发送号码
				Sysparam sysparam = (SysparamBO)BOFactory.build(SysparamBO.class, dbuser);
				String sendno = sysparam.doFindByID("42", "pboss_fx");
				
				//短信内容
				String msg = SMSRndCode.getSMS_MSG().replace("$", rndCode);
				Waitreq waitreq = (WaitreqBO)BOFactory.build(WaitreqBO.class, dbuser);
				
				WaitreqVO wrvo = waitreq.doInsert2((short)1, msg, sendno, phone);
				System.out.print(msg);
				log.info(msg);
				retmsg = "随机短信码发送成功，请注意查收";
			}catch(Exception e){//短信发送失败
				e.printStackTrace();
				retmsg = "随机短信码短信发送失败，请联系管理员";
			}			
		}else{//随机码发送过于频繁，请稍后再试
			retmsg = "短信发送发送过于频繁，请稍后再试";
		}
		//更新session
		this.getRequest().getSession().setAttribute(SMS_CODE, smsRndCode);
		
		try {
			HttpServletResponse response = getResponse();
			response.setContentType("text/html;charset=GBK");
			response.getWriter().write(retmsg);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
	/**
	 * 随机短信发送
	 * @param phone 
	 * @param cityno
	 * @param dbuser
	 * @return 
	 * @throws Exception
	 */
	private String sendRandomSms(String phone, DBAccessUser dbuser, String rtnPage){
		//	从Session中取出短信验证码对象（SMSRndCode）;判断是否为null。若为null，则创建一个短信验证码对象，并记录创建的时间。
		Object obj = this.getRequest().getSession().getAttribute(SMS_CODE);
		SMSRndCode smsRndCode = null;
		if(obj==null){
			smsRndCode = new SMSRndCode(phone);
		}else{
			smsRndCode = (SMSRndCode)obj;
			smsRndCode.setMobile(phone);
		}
		
		//判断是否为广东移动号码
		try{
			if("loginprov".equals(rtnPage)){//省公司手机号验证(地市公司工号登录时不再验证)
				Nosect nosect = (NosectBO)BOFactory.build(NosectBO.class, dbuser);
				NosectDBParam listVO = new NosectDBParam();
				listVO.set_snm_beginno(phone);
				listVO.set_snl_endno(phone);
				listVO.setCountOnly(true);
				DataPackage dp = nosect.doQuery(listVO);
				if(dp==null && dp.getRowCount()==0){//是
					this.addActionError("手机号码不是有效的广东移动号码");
					return "login";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("号码验证异常");
			log.info("号码验证异常");
			this.addActionError("号码验证异常，请联系管理员");
			return "login";
		}		
		
		//获取6位随机短信码
		String rndCode = RndNumberBuilder.getRndNumber(6);
		
		//随机码添加成功
		if(smsRndCode.addRndCode(rndCode).equals(SMSRndCode.PASS)){
			try{
				//发送号码
				Sysparam sysparam = (SysparamBO)BOFactory.build(SysparamBO.class, dbuser);
				String sendno = sysparam.doFindByID("42", "pboss_fx");
				
				//短信内容
				String msg = SMSRndCode.getSMS_MSG().replace("$", rndCode);
				Waitreq waitreq = (WaitreqBO)BOFactory.build(WaitreqBO.class, dbuser);
				
				WaitreqVO wrvo = waitreq.doInsert2((short)1, msg, sendno, phone);
			}catch(Exception e){//短信发送失败
				e.printStackTrace();
				this.addActionError("随机短信码短信发送失败，请联系管理员");
				return "login";
			}			
		}else{//随机码发送过于频繁，请稍后再试
			this.addActionError("短信发送发送过于频繁，请稍后再试");
			return rtnPage;
		}
		
		this.getRequest().getSession().setAttribute(SMS_CODE, smsRndCode);
		return rtnPage;
	}
	
	public String doLoginprov2() throws Exception{
		LoginForm form = (LoginForm) this.getForm();
		LoginlogVO logVO = null;
		try{
			if (form.getUser() == null) {
				return "login";
			} else if(!StringUtils.isValuedString(this.getRndsmscode())){
				this.addActionError("请输入短信中的验证码");
				return "loginprov";
			} else {
				//校验随机短信验证码
				if(!this.validateRndCode(this.getRndsmscode())){
					return "loginprov";
				}
				
				User user = form.getUser();
				//验证人员是否存在
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorDBParam params = new OperatorDBParam();
				params.set_pagesize("0");
				params.setDataOnly(true);
				params.set_se_contactphone(form.getUser().getOprcode().trim());
				params.set_se_logintype("NOTBOSS");
				DataPackage operdp = operator.doQuery(params);				
				OperatorVO vo = null;
				if(operdp!=null && operdp.getDatas()!=null && operdp.getDatas().size()>0){
					vo = (OperatorVO)operdp.getDatas().get(0);
				}else{
					throw new BusinessException("用户名不存在!");
				}				
				//if(vo.getRegion()==999){
				//	throw new BusinessException("当前登录工号没有访问PBOSS的权限!");
				//}
				if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("当前登录工号已无效!");
				}
				
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				user.setRemoteName(request.getRemoteHost());
				//记录日志
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getContactphone());//省公司人员使用手机号码登录
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(CityMappingUtil.getCityid(this.getCityno()));
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());				
				logVO.setIpaddress(ip);
				logVO.setLogintype(vo.getLogintype());				
				
//				String cityid = CityMappingUtil.getCityid(this.getCityno());
//				DBAccessUser dbuser = new DBAccessUser();
//				dbuser.setCityid(cityid);
//				dbuser.setIp(ip);
//				dbuser.setRemoteName(request.getRemoteAddr());				
				return this.sessionOperationProv(user, logVO, vo, this.getCityno());				
			}			
		}catch(Exception e){
			e.printStackTrace();
			if(logVO!=null){
				Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			this.addActionError(e.getMessage());
			return "loginprov";
		}
	}
	
	public String doLogin2smscity() throws Exception{
		LoginForm form = (LoginForm) this.getForm();
		LoginlogVO logVO = null;
		try{
			if (form.getUser() == null) {
				return "login";
			} else if(!StringUtils.isValuedString(this.getRndsmscode())){
				this.addActionError("请输入短信中的验证码");
				return "login2smscity";
			} else {
				//校验随机短信验证码
				if(!this.validateRndCode(this.getRndsmscode())){
					return "login2smscity";
				}
				
				User user = form.getUser();
				//查询人员信息
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("用户名在COMS端不存在!");
				}
				
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				user.setRemoteName(request.getRemoteHost());
				
				//记录日志
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getOperid());
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(CityMappingUtil.getCityid(vo.getRegion().toString()));
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());				
				logVO.setIpaddress(ip);
				logVO.setLogintype("COMSMS");
				
				return sessionOperation(user,logVO);
			}			
		}catch(Exception e){
			e.printStackTrace();
			if(logVO!=null){
				Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			this.addActionError(e.getMessage());
			return "login2smscity";
		}
	}
	
	private String sessionOperationProv(User user,LoginlogVO logVO,OperatorVO oprVO,String cityno) throws Exception{
		Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
		try{			
			//在session里设置相应信息
			// 补充用户工号外的其他信息，包括 cityid等
			// dbFlag 暂用内置用户的 cityid 代替。实际中需要考虑如何判断，还是固定为此值。
			// 将用户放入会话中				
			HttpServletRequest request = ServletActionContext.getRequest();
			user.setSessionID(request.getSession().getId());
			user.setIp(request.getRemoteHost());
			user.setLogintime(new Date());
			user.setCityid(CityMappingUtil.getCityid(cityno));
			user.setHwcityid(cityno);
			user.setWayid(oprVO.getOrgid());
			// TODO: 后续功能，记录登录历史
			ActionContext.getContext().getSession().put(WebConstant.SESSION_ATTRIBUTE_USER, user);
			ActionContext.getContext().getSession().put(WebConstant.LOGIN_TYPE, "NOTBOSS");
			//获取省公司人员登录报表平台工号
			InputStream in = LoginAction.class.getResourceAsStream("/coreconfiginfo.properties");
			Properties props = new Properties();
			props.load(in);
			in.close();
			ActionContext.getContext().getSession().put(WebConstant.PROV_REPORT_OPERCODE, props.getProperty("province.login.report.opercode"));
			
			logVO.setIssuccess((short)1);
			loginlogBO.doCreate(logVO);
			return "index";
		}catch(Exception e){
			if(logVO!=null){
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			addActionError(e.getMessage());
			return "login";
		}
	}
	
	private boolean validateRndCode(String rndcode){
		Object obj = this.getRequest().getSession().getAttribute(SMS_CODE);
		SMSRndCode smsRndCode = null;
		if(obj!=null){
			smsRndCode = (SMSRndCode)obj;
			List<String> codes = smsRndCode.getCodeList();
			if(codes.contains(rndcode)){
				this.getRequest().getSession().removeAttribute(SMS_CODE);
				return true;
			}
		}else{
			this.addActionError("验证失败，请重新获取随机短信验证码");
			return false;
		}
		this.addActionError("随机短信码错误，请确保输入正确的短信验证码");
		return false;
	}
	
	public String doChangecity() throws Exception{
		if(StringUtils.isEmpty(this.getCityno())){//没有选择任何地市
			return null;
		}
		
		User user = (User)this.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		if(user==null){
			return null;//会话超时，需要用户先重新登录
		}
		user.setCityid(CityMappingUtil.getCityid(cityno));
		user.setHwcityid(cityno);
		this.getRequest().getSession().setAttribute(WebConstant.SESSION_ATTRIBUTE_USER, user);
		//System.out.println("-----------------------省公司["+user.getOprcode()+"]切换到["+user.getCityid()+"]库");
		log.info("-----------------------省公司["+user.getOprcode()+"]切换到["+user.getCityid()+"]库");
		return null;
	}

	public String doLogin() throws Exception{
		LoginForm form = (LoginForm) this.getForm();
		LoginlogVO logVO=null;
		try {
			if (form.getUser() == null) {
				return "login";
			} else if (!StringUtils.isValuedString(form.getUser().getOprcode())) {
				addActionError("工号缺失!");
				return "login";
			} else {
				//System.out.println("***********************登录工号："+form.getUser().getOprcode());
				log.info("***********************登录工号："+form.getUser().getOprcode());
				User user = form.getUser();
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("用户名在COMS端不存在!");
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				//String macAddr=this.getMACAddress(ip);
				//user.setMacAddr(macAddr);
				user.setRemoteName(request.getRemoteHost());
				//记录日志
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getOperid());
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(CityMappingUtil.getCityid(vo.getRegion().toString()));
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());
				
				logVO.setIpaddress(ip);
				//logVO.setMacaddress(macAddr);			
				
				//if(!CoreConfigInfo.LOGIN_FLAG && !"pbosstest".equals(user.getOprcode())){ //记得上正式环境的时候把pbosstest这个特殊工号删掉
				if(!CoreConfigInfo.LOGIN_FLAG){ //记得上正式环境的时候把pbosstest这个特殊工号删掉
					 if(vo.getRegion()==999){
						throw new BusinessException("当前登录工号没有访问PBOSS的权限!");
					}else if(vo.getStatus()==null || vo.getStatus()==0){
						throw new BusinessException("当前登录工号已无效!");
					}else{
						String cityid=CityMappingUtil.getCityid(vo.getRegion().toString());
						
						ResourceBundle rs = ResourceBundle.getBundle("data/SMSLoginCity");						
						String isComsverify = (String)rs.getObject(cityid);//Y：COMS随机短信码登录，其他boss或NG
						
						if("Y".equals(isComsverify)){
							//发送随机短信
							user.setCityid(cityid);
							this.sendRandomSms(vo.getContactphone(), user, "login2smscity");
							
							return "login2smscity";
						}else{
							if(!this.isNGLoginCheck(cityid)){//地市尚未割接NG鉴权
								if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
									if(CoreConfigInfo.LOGIN_DISTRIBUTION){
										String cityidJQ=getCityidLogAuthProperty(cityid);
										if(cityidJQ.equals("GZJQ")){//调用BOSS广州集群鉴权
											loginCheck=new NewLoginCheckGZ();
										}else if(cityidJQ.equals("SZJQ")){//调用BOSS深圳集群鉴权
											loginCheck=new NewLoginCheckSZ();
										}else {//调用BOSS东莞集群鉴权
											loginCheck=new NewLoginCheckDG();
										}
									}
								}
								Result result = loginCheck.doSend2WS(user, ILoginCheck.QUERY_USER_TYPE);
								if(!SUCCESS.equals(result.getResultCode())){
									throw new Exception(result.getResultDec());
								}
								logVO.setLogintype(result.getUserType());
								form.setResult(result);
								doGetPassword(form);
								return "login2";
							}else{//地市已经割接NG鉴权
								//System.out.println("***********************地市已经割接NG鉴权***************************");
								log.info("***********************地市已经割接NG鉴权***************************");
								//System.out.println("***********************工号："+user.getOprcode());
								log.info("***********************工号："+user.getOprcode());
								this.ngLoginCheck = NGLoginPortFactory.createPort(cityid);
								Result result = this.ngLoginCheck.getLogintype(user);
								if( !INGLoginCheck.SUCCESS.equals(result.getResultCode()) ){
									throw new Exception(result.getResultDec());
								}
								logVO.setLogintype(result.getUserType());
								//System.out.println("***********************登录方式："+result.getUserType());
								log.info("***********************登录方式："+result.getUserType());
								form.setResult(result);
								doGetPasswordNG(form);
								return "login2ngauth";
							}
						}
					}
				}
				return sessionOperation(user,logVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(logVO!=null){
				Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			addActionError("由于内部异常而无法登录! 原因:" + e.getMessage());
			return "login";
		}
	}
	
	private boolean isNGLoginCheck(String cityid)throws Exception{		
		if (propNGLogin == null) {
			propNGLogin = new Properties();
		}
		if (propNGLogin.isEmpty()) {
			InputStream in = LoginAction.class.getResourceAsStream("/data/NGLoginCheckCityMapping.properties");
			propNGLogin.load(in);
		}
		if("Y".equals(propNGLogin.get(cityid))){
			return true;
		}		
		return false;
	}
	
	/**
	 * 跳入密码界面的操作
	 * @param form
	 * @throws Exception
	 */
	public void doGetPassword(LoginForm form) throws Exception{
		//除了SimpAuth和Dynamic之外,其他都要进行请求 OLD
		if(ILoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){//静态密码校验
			
		}else if(ILoginCheck.DYANMIC_LOGIN.equals(form.getResult().getUserType())){//动态密码校验
			if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
				form.getUser().setStep(1);
				loginCheck.doDynamicCheck(form.getUser());
			}
		}else if(ILoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){//短信校验
			if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
				if(null==form.getUser().getStep())
					form.getUser().setStep(1);
			}else{
				loginCheck.doSend2WS(form.getUser(), ILoginCheck.SEC_SAND);
			}
		}else if(ILoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){//挑战码校验
			Result result=loginCheck.doSend2WS(form.getUser(), ILoginCheck.CHALLENGE_QUERY_VALUE);
			String safeword = result.getSafewordMessage();
			String code=result.getSafewordCode();
			form.getUser().setSafewordMessage(safeword);
			form.getUser().setSafewordCode(code);
			if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
				if(!WAIT.equals(result.getResultCode()))
						throw new Exception(result.getResultDec());
			}
		}else if(ILoginCheck.RSA_LOGIN.equals(form.getResult().getUserType())){
			// TODO: RSA鉴权
			if(null == form.getUser().getRSAStatus()){
				form.getUser().setRSAStatus(ILoginCheck.SIMP_AUTH);//设置状态未固定密码状态
			}else if(ILoginCheck.SIMP_AUTH.equals(form.getUser().getRSAStatus())){
				form.getUser().setRSAStatus(ILoginCheck.DYNAMIC_PASS_AUTH);//设置状态为挑战码状态
			}else if(ILoginCheck.DYNAMIC_PASS_AUTH.equals(form.getUser().getRSAStatus())){
				form.getUser().setRSAStatus(ILoginCheck.DYNAMIC_EXCURSION_AUTH);//设置为漂移码状态
			}
		}else{
			throw new Exception("无此用户鉴权类型:"+form.getResult().getUserType());
		}
	}
	
	private void doGetPasswordNG(LoginForm form) throws Exception{
		if(INGLoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){
			
		}else if(INGLoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){
			form.getUser().setStep(1);
		}else if(INGLoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){
			//System.out.println("***********************挑战码鉴权，获取挑战码");
			log.info("***********************挑战码鉴权，获取挑战码");
			form.getUser().setStep(1);
			Result result = this.ngLoginCheck.doSafewordAuth(form.getUser());
			if( !result.getResultCode().equals(INGLoginCheck.SUCCESS) ){
				//System.out.println("***********************挑战码鉴权，获取挑战码失败");
				log.info("***********************挑战码鉴权，获取挑战码失败");
				throw new Exception("获取挑战码失败，"+result.getResultDec());
			}else{
				String retinfo[] = result.getResultDec().split("\\|");
				if(retinfo.length!=2){
					//System.out.println("***********************挑战码鉴权，挑战码或挑战信息格式错误："+result.getResultDec());
					log.info("***********************挑战码鉴权，挑战码或挑战信息格式错误："+result.getResultDec());
					throw new Exception("挑战码或挑战信息格式错误,"+result.getResultDec());
				}
				form.getUser().setSafewordCode(retinfo[0]);
				form.getUser().setSafewordMessage(retinfo[1]);
				//form.getUser().setSafewordCode(result.getResultDec());
				//System.out.println("***********************挑战码鉴权，获取挑战码："+result.getResultDec());
				log.info("***********************挑战码鉴权，获取挑战码："+result.getResultDec());
			}
		}else if(INGLoginCheck.RSA_LOGIN.equals(form.getResult().getUserType())){
			form.getUser().setStep(1);			
		}else{
			throw new Exception("无此用户鉴权类型:"+form.getResult().getUserType());
		}
	}
	
	public String doLogin2()throws Exception {
		LoginForm form = (LoginForm) this.getForm();
		Result result = null;
		LoginlogVO logVO=null;
		try {
			if (form.getUser() == null || form.getResult() == null) {
				return "login";
			} else{
				//System.out.println("***********************登录工号："+form.getUser().getOprcode());
				log.info("***********************登录工号："+form.getUser().getOprcode());
				User user = form.getUser();
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("用户名在PBOSS端不存在!");
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				//记录日志
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getOperid());
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(CityMappingUtil.getCityid(vo.getRegion().toString()));
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());
				String ip=this.getClientIpAddress(request);
				logVO.setIpaddress(ip);
				//logVO.setMacaddress(this.getMACAddress(ip));
				logVO.setLogintype(form.getResult().getUserType());
				
				 if(vo.getRegion()==999){
					throw new BusinessException("当前登录工号没有访问PBOSS的权限!");
				}else if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("当前登录工号已无效!");
				}else{
					if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
						if(CoreConfigInfo.LOGIN_DISTRIBUTION){
							String cityidJQ=getCityidLogAuthProperty(CityMappingUtil.getCityid(vo.getRegion().toString()));
							if(cityidJQ.equals("GZJQ")){//调用BOSS广州集群鉴权
								loginCheck=new NewLoginCheckGZ();
							}else if(cityidJQ.equals("SZJQ")){//调用BOSS深圳集群鉴权
								loginCheck=new NewLoginCheckSZ();
							}else {//调用BOSS东莞集群鉴权
								loginCheck=new NewLoginCheckDG();
							}
						}
					}
				}
				if(ILoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){
					result = loginCheck.doSend2WS(user, ILoginCheck.SIMP_AUTH);
				}else if(ILoginCheck.DYANMIC_LOGIN.equals(form.getResult().getUserType())){//动态
					if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
						user.setStep(2);
						result=loginCheck.doDynamicCheck(user);//验证动态密码
					}else{
						result = loginCheck.doSend2WS(user, ILoginCheck.SIMP_AUTH);
					}
				}else if(ILoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){//短信
					if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
						if(user.getStep()==1){
							user.setStep(2);
							result = loginCheck.doSend2WS(user, ILoginCheck.SEC_AUTH);//验证固定密码
							if(WAIT.equals(result.getResultCode())){
								this.doGetPassword(form);  //进入下一步
								return "login2";
							}else{
								form.getUser().setStep(null);//失败退回第一步
							}
						}else if(user.getStep()==2){//校验短信验证码
							user.setStep(3);
							result = loginCheck.doSend2WS(user, ILoginCheck.SEC_AUTH);
						}
					}else{
						result = loginCheck.doSend2WS(user, ILoginCheck.SEC_AUTH);
					}
					
				}else if(ILoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){//挑战码
					result = loginCheck.doSend2WS(user, ILoginCheck.CHALLENGE_AUTH_VALUE);
				}else if(ILoginCheck.RSA_LOGIN.equals(form.getResult().getUserType())){//RSA
					// TODO: RSA鉴权
					if(ILoginCheck.SIMP_AUTH.equals(form.getUser().getRSAStatus())){//固定密码验证
						if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
							user.setStep(2);
							result = loginCheck.doSend2WS(user, ILoginCheck.DYNAMIC_PASS_AUTH);//2,验证固定密码
							if(WAIT.equals(result.getResultCode())){
								this.doGetPassword(form);  //进入下一步
								return "login2";
							}else{
								form.getUser().setRSAStatus(null);//失败退回第一步
							}
						}else{
							result = loginCheck.doSend2WS(user, ILoginCheck.SIMP_AUTH);
							if(SUCCESS.equals(result.getResultCode())){
								this.doGetPassword(form);  //进入下一步
								return "login2";
							}else{
								form.getUser().setRSAStatus(null);//失败退回第一步
							}
						}
					}
					
					if(ILoginCheck.DYNAMIC_PASS_AUTH.equals(form.getUser().getRSAStatus())){//挑战码验证
						user.setStep(3);
						result = loginCheck.doSend2WS(user, ILoginCheck.DYNAMIC_PASS_AUTH);
						if(SUCCESS.equals(result.getResultCode())){
							return this.sessionOperation(user,logVO); //调用8成功
						}else if(WAIT.equals(result.getResultCode())){
							//form.getUser().setSafewordMessage(form.getUser().getPassword());
							this.doGetPassword(form);  //进入下一步
							return "login2";
						}else{
							form.getUser().setRSAStatus(null);//退回第一步
						}
					}
					
					if(ILoginCheck.DYNAMIC_EXCURSION_AUTH.equals(form.getUser().getRSAStatus())){//漂移码验证
						result = loginCheck.doSend2WS(user, ILoginCheck.DYNAMIC_EXCURSION_AUTH);
						if(SUCCESS.equals(result.getResultCode())){
							return this.sessionOperation(user,logVO); //调用8成功
						}else{
							form.getUser().setRSAStatus(null);//退回第一步
						}
					}
				}
				if(SUCCESS.equals(result.getResultCode())){
					return this.sessionOperation(user,logVO);
				}else{
					this.doGetPassword(form);
					throw new Exception(result==null?"密码错误!":result.getResultDec());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			if(logVO!=null){
				Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			addActionError(e.getMessage());
			return "login2";
		}
	}

	public String doLogin2NGAuth() throws Exception{
		LoginForm form = (LoginForm) this.getForm();
		Result result = null;
		LoginlogVO logVO=null;
		try {
			if (form.getUser() == null || form.getResult() == null) {
				return "login";
			} else{
				//System.out.println("***********************登录工号："+form.getUser().getOprcode());
				log.info("***********************登录工号："+form.getUser().getOprcode());
				User user = form.getUser();
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("用户名在PBOSS端不存在!");
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				//记录日志
				String cityid = CityMappingUtil.getCityid(vo.getRegion().toString());
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getOperid());
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(cityid);
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());
				String ip=this.getClientIpAddress(request);
				logVO.setIpaddress(ip);
				//logVO.setMacaddress(this.getMACAddress(ip));
				logVO.setLogintype(form.getResult().getUserType());
				
				if(vo.getRegion()==999){
					throw new BusinessException("当前登录工号没有访问PBOSS的权限!");
				}else if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("当前登录工号已无效!");
				}				
				 
				this.ngLoginCheck = NGLoginPortFactory.createPort(cityid);
				if(INGLoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){
					//System.out.println("***********************简单密码验证");
					log.info("***********************简单密码验证");
					result = this.ngLoginCheck.doSimpAuth(user);
				}else if(INGLoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){//短信
					if(1==user.getStep()){//验证固定密码并获取随机短信码
						//System.out.println("***********************短信随机码密码验证：验证固定密码，以获取短信随机码");
						log.info("***********************短信随机码密码验证：验证固定密码，以获取短信随机码");
						result = this.ngLoginCheck.doSecAuth(user);	
						if(INGLoginCheck.SUCCESS.equals(result.getResultCode())){
							user.setStep(2);
							ActionContext.getContext().getSession().put("smspassword", result.getResultDec());
							return "login2ngauth";
						}						
					}else{//user.getStep=2
						//System.out.println("***********************短信随机码密码验证：验证短信随机码");
						log.info("***********************短信随机码密码验证：验证短信随机码");
						result = new Result();
						String smspassword = (String)ActionContext.getContext().getSession().get("smspassword");
						if(user.getSecondPass().equals(smspassword)){
							result.setResultCode(INGLoginCheck.SUCCESS);
						}else{
							result.setResultCode(INGLoginCheck.WRONG_PASSWORD);
							result.setResultDec("随机短信码错误");
						}
						ActionContext.getContext().getSession().remove("smspassword");
					}					
				}else if(INGLoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){//挑战码
					//System.out.println("***********************挑战码验证");
					log.info("***********************挑战码验证");
					form.getUser().setStep(2);
					result = this.ngLoginCheck.doSafewordAuth(user);
				}else if(INGLoginCheck.RSA_LOGIN.equals(form.getResult().getUserType())){//RSA
					if(1==form.getUser().getStep()){
						//System.out.println("***********************RSA密码验证：验证固定密码");
						log.info("***********************RSA密码验证：验证固定密码");
						result = this.ngLoginCheck.doRSAAuth(form.getUser());
						if(INGLoginCheck.SUCCESS.equals(result.getResultCode())){
							//System.out.println("***********************RSA密码验证：验证固定密码通过");
							log.info("***********************RSA密码验证：验证固定密码通过");
							form.getUser().setStep(2);
						}else{
							//System.out.println("***********************RSA密码验证：验证固定失败，"+result.getResultDec());
							log.info("***********************RSA密码验证：验证固定失败，"+result.getResultDec());
							addActionError("密码验证失败，原因："+result.getResultDec());
						}
						return "login2ngauth";						
					}else if(2==form.getUser().getStep()){
						//System.out.println("***********************RSA密码验证：验证RSA挑战码");
						log.info("***********************RSA密码验证：验证RSA挑战码");
						result = this.ngLoginCheck.doRSAAuth(form.getUser());
						if(INGLoginCheck.WRONG_RSA.equals(result.getResultCode())){// RSA码发生漂移
							//System.out.println("***********************RSA密码验证：RSA码发生漂移");
							log.info("***********************RSA密码验证：RSA码发生漂移");
							form.getUser().setStep(3);
							return "login2ngauth";
						}else if( !INGLoginCheck.SUCCESS.equals(result.getResultCode()) ){//RSA挑战码认证失败
							//System.out.println("***********************RSA密码验证：验证RSA挑战码失败，"+result.getResultDec());
							log.info("***********************RSA密码验证：验证RSA挑战码失败，"+result.getResultDec());
							addActionError("RSA挑战码验证失败，原因："+result.getResultDec());
							return "login2ngauth";
						}
					}else if(3==form.getUser().getStep()){
						//System.out.println("***********************RSA密码验证：验证RSA漂移码");
						log.info("***********************RSA密码验证：验证RSA漂移码");
						result = this.ngLoginCheck.doRSAAuth(form.getUser());
						if(INGLoginCheck.WRONG_RSA.equals(result.getResultCode())){// RSA码发生漂移
							//System.out.println("***********************RSA密码验证：RSA码再次漂移");
							log.info("***********************RSA密码验证：RSA码再次漂移");
							return "login2ngauth";
						}
					}					
				}
				if(INGLoginCheck.SUCCESS.equals(result.getResultCode())){
					return this.sessionOperation(user,logVO);
				}else{
					this.doGetPasswordNG(form);
					throw new Exception(result==null?"密码错误!":result.getResultDec());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			if(logVO!=null){
				Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			addActionError(e.getMessage());
			return "login2ngauth";
		}
	}
	
	private String sessionOperation(User user,LoginlogVO logVO) throws Exception{
		Loginlog loginlogBO = (Loginlog)BOFactory.build(LoginlogBO.class,DBAccessUser.getInnerUser());
		try{
			//在session里设置相应信息
			Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
			OperatorVO vo = operator.doFindByPk(user.getOprcode());
			if(vo == null){
				logVO=null;
				throw new BusinessException("用户名在PBOSS端不存在!");
			}
			if(vo.getRegion()==999){
				throw new BusinessException("当前登录工号没有访问PBOSS的权限!");
			}
			if(vo.getStatus()==null || vo.getStatus()==0){
				throw new BusinessException("当前登录工号已无效!");
			}else{
				// 补充用户工号外的其他信息，包括 cityid等
				// dbFlag 暂用内置用户的 cityid 代替。实际中需要考虑如何判断，还是固定为此值。
				// 将用户放入会话中
				
				HttpServletRequest request = ServletActionContext.getRequest();
				user.setSessionID(request.getSession().getId());
				user.setIp(request.getRemoteHost());
				user.setLogintime(new Date());
				user.setCityid(CityMappingUtil.getCityid(vo.getRegion().toString()));
				user.setHwcityid(vo.getRegion().toString());
				user.setWayid(vo.getOrgid());
				// TODO: 后续功能，记录登录历史
				ActionContext.getContext().getSession().put(WebConstant.SESSION_ATTRIBUTE_USER, user);
			}
			logVO.setIssuccess((short)1);
			loginlogBO.doCreate(logVO);
			return "index";
		}catch (Exception e) {
			if(logVO!=null){
				logVO.setIssuccess((short)0);
				logVO.setMemo( e.getMessage());
				loginlogBO.doCreate(logVO);
			}
			addActionError(e.getMessage());
			return "login";
		}
	}
	
	public String doLogout() {
		ActionContext.getContext().getSession().put(WebConstant.SESSION_ATTRIBUTE_USER, null);
		if(ActionContext.getContext().getSession().get(WebConstant.LOGIN_TYPE)!=null){
			ActionContext.getContext().getSession().put(WebConstant.LOGIN_TYPE, null);
		}
		return "logout";
	}

	public ILoginCheck getLoginCheck() {
		return loginCheck;
	}
	/**
	 * 从规则配置文件中读取内容
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private String getCityidLogAuthProperty(String cityid) throws Exception {
		if (property == null) {
			property = new Properties();
		}
		if (property.isEmpty()) {
			InputStream in = ComOrderSms.class
					.getResourceAsStream("/data/cityidLoginAuth.properties");
			property.load(in);
		}
		return property.getProperty(cityid);
	}	
	 public String getClientIpAddress(HttpServletRequest request) {
	        String ip = request.getHeader("X-Forwarded-For");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	    } 

	public String getMACAddress(String ip){ 
        String str = ""; 
        String macAddress = ""; 
        try { 
        	String fileSeparator = System.getProperty("file.separator"); //根据文件分隔符号区分平台   
            if (fileSeparator.equals("/")){  
            	macAddress=this.getMacInLinux(ip);
                System.out.println(macAddress);   
            }   
            else if(fileSeparator.equals("\\")){   
            	macAddress=getMacInWindows(ip);
                System.out.println(macAddress);  //nicrosoft喜欢对着干   
                //System.out.println(getMacInWindows("127.0.0.1"));   
            } 
            
        } catch (Exception e) { 
            e.printStackTrace(System.out); 
        } 
        return macAddress; 
    } 
	public static String callCmd(String[] cmd) {   
        String result = "";   
        String line = "";   
        try {   
            Process proc = Runtime.getRuntime().exec(cmd);   
            InputStreamReader is = new InputStreamReader(proc.getInputStream());   
            BufferedReader br = new BufferedReader (is);   
            while ((line = br.readLine ()) != null) {   
            result += line;   
            }   
        }   
        catch(Exception e) {   
            e.printStackTrace();   
        }   
        return result;   
    }   
  
    /**  
     *  
     * @param cmd  第一个命令  
     * @param another 第二个命令  
     * @return   第二个命令的执行结果  
     */  
    public static String callCmd(String[] cmd,String[] another) {   
        String result = "";   
        String line = "";   
        try {   
            Runtime rt = Runtime.getRuntime();   
            Process proc = rt.exec(cmd);   
            int exitVal = proc.waitFor();  //已经执行完第一个命令，准备执行第二个命令   
            proc = rt.exec(another);   
            InputStreamReader is = new InputStreamReader(proc.getInputStream());   
            BufferedReader br = new BufferedReader (is);   
            while ((line = br.readLine ()) != null) {   
                result += line;   
            }   
        }   
        catch(Exception e) {   
            e.printStackTrace();   
        }   
        return result;   
    }   
  
  
  
  
    /**  
     *  
     * @param ip  目标ip,一般在局域网内  
     * @param sourceString 命令处理的结果字符串  
     * @param macSeparator mac分隔符号  
     * @return  mac地址，用上面的分隔符号表示  
     */  
    public  String filterMacAddress( String ip,  String sourceString, String macSeparator) {   
        String result = "";   
        String regExp = "((([0-9,A-F,a-f]{1,2}" + macSeparator + "){1,5})[0-9,A-F,a-f]{1,2})";   
        Pattern pattern = Pattern.compile(regExp);   
        Matcher matcher = pattern.matcher(sourceString);   
        while(matcher.find()){   
            result = matcher.group(1);   
            if(sourceString.indexOf(ip) <= sourceString.lastIndexOf(matcher.group(1))) {   
                break;  //如果有多个IP,只匹配本IP对应的Mac.   
            }   
        }   
  
        return result;   
    }   
  
    /**  
     *  
     * @param ip 目标ip  
     * @return   Mac Address  
     *  
     */  
    public  String getMacInWindows( String ip){   
        String result = "";   
        String[] cmd = {   
                "cmd",   
                "/c",   
                "ping " +  ip   
                };   
        String[] another = {   
                "cmd",   
                "/c",   
                "arp -a"  
                };   
  
        String cmdResult = callCmd(cmd,another);   
        result = filterMacAddress(ip,cmdResult,"-");   
  
        return result;   
    }   
    /**  
     *  
     * @param ip 目标ip  
     * @return   Mac Address  
     *  
     */  
     public  String getMacInLinux( String ip){   
         String result = "";   
         String[] cmd = {   
                 "/bin/sh",   
                 "-c",   
                 "ping " +  ip + " -c 2 && arp -a"  
                 };   
         String cmdResult = callCmd(cmd);   
         result = filterMacAddress(ip,cmdResult,":");   
   
         return result;   
     }
     
     public String getCityno() {
 		return cityno;
 	}

 	public void setCityno(String cityno) {
 		this.cityno = cityno;
 	}

 	public String getRndsmscode() {
		return rndsmscode;
	}

	public void setRndsmscode(String rndsmscode) {
		this.rndsmscode = rndsmscode;
	}
	
	public INGLoginCheck getNgLoginCheck() {
		return ngLoginCheck;
	}

}
