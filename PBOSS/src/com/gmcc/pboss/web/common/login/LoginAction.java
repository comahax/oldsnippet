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
 * @author �S����
 */
public class LoginAction extends BaseAction {
	//������ log4.xml��
	public static final String LOGIN_LOGGER_NAME = "com.gmcc._login";
	public static final Logger log = Logger.getLogger(LOGIN_LOGGER_NAME);
	
	private ILoginCheck loginCheck;
	private Properties property = null;
	private static  String FAILURE="2";//ʧ��
	private static  String SUCCESS="1";//�ɹ�
	private static  String WAIT="0";//�ȴ�����һ��
	private INGLoginCheck ngLoginCheck;
	private static Properties propNGLogin = null;//NG��¼��������

	private Map citymap = new LinkedHashMap<String,String>();//ʡ��˾��Ա��¼ʹ��
	private String cityno;//ʡ��˾��Ա��¼ʹ��
	private static final String SMS_CODE = "SMS_CODE";//������֤����session�ı�ʶ
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
			addActionError("���ص����б�ʧ�ܡ�");
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
				addActionError("�ֻ�����ȱʧ!");
				return "login";
			} else if (!StringUtils.isValuedString(this.getCityno())){
				addActionError("����ȱʧ!");
				return "login";
			} else {
				User user = form.getUser();
				//��֤��Ա�Ƿ����
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
					throw new BusinessException("�û���������!");
				}				
				//if(vo.getRegion()==999){
				//	throw new BusinessException("��ǰ��¼����û�з���PBOSS��Ȩ��!");
				//}
				if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("��ǰ��¼��������Ч!");
				}
				
				
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				user.setRemoteName(request.getRemoteHost());
				//��¼��־
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getContactphone());//ʡ��˾��Ա���ֻ������¼
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(CityMappingUtil.getCityid(this.getCityno()));
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());
				logVO.setIpaddress(ip);
				logVO.setLogintype(vo.getLogintype());
				
				//���������ݿ��û�
				String cityid = CityMappingUtil.getCityid(this.getCityno());
				DBAccessUser dbuser = new DBAccessUser();
				dbuser.setCityid(cityid);
				dbuser.setIp(ip);
				dbuser.setRemoteName(request.getRemoteAddr());
				//�����������
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
			this.addActionError("�����ڲ��쳣���޷���¼! ԭ��:" + e.getMessage());
			return "login";
		}
	}
	
	public String doResendSms() throws Exception{
		String retmsg = null;
		LoginForm form = (LoginForm) this.getForm();
		String phone = form.getUser().getOprcode().trim();
		String isCitySms = form.getIsCitySms();
		OperatorVO vo = null;
		if("true".equals(isCitySms)){//���й�˾ʱ������ת�ֻ�����
			Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
			vo = operator.doFindByPk(phone);
			if(vo != null){
				phone = vo.getContactphone();
			}
		}
		
		//���������ݿ��û�
		DBAccessUser dbuser = new DBAccessUser();
		if("true".equals(isCitySms)){
			String cityid = CityMappingUtil.getCityid(""+vo.getRegion());
			dbuser.setCityid(cityid);
		}else{
			String cityid = CityMappingUtil.getCityid(this.getCityno());
			dbuser.setCityid(cityid);
		}
		
		//��Session��ȡ��������֤�����SMSRndCode��;�ж��Ƿ�Ϊnull����Ϊnull���򴴽�һ��������֤����󣬲���¼������ʱ�䡣
		Object obj = this.getRequest().getSession().getAttribute(SMS_CODE);
		SMSRndCode smsRndCode = null;
		if(obj==null){
			smsRndCode = new SMSRndCode(phone);
		}else{
			smsRndCode = (SMSRndCode)obj;
			smsRndCode.setMobile(phone);
		}		
		//��ȡ6λ���������
		String rndCode = RndNumberBuilder.getRndNumber(6);		
		//�������ӳɹ�
		if(smsRndCode.addRndCode(rndCode).equals(SMSRndCode.PASS)){
			try{
				//���ͺ���
				Sysparam sysparam = (SysparamBO)BOFactory.build(SysparamBO.class, dbuser);
				String sendno = sysparam.doFindByID("42", "pboss_fx");
				
				//��������
				String msg = SMSRndCode.getSMS_MSG().replace("$", rndCode);
				Waitreq waitreq = (WaitreqBO)BOFactory.build(WaitreqBO.class, dbuser);
				
				WaitreqVO wrvo = waitreq.doInsert2((short)1, msg, sendno, phone);
				System.out.print(msg);
				log.info(msg);
				retmsg = "��������뷢�ͳɹ�����ע�����";
			}catch(Exception e){//���ŷ���ʧ��
				e.printStackTrace();
				retmsg = "�����������ŷ���ʧ�ܣ�����ϵ����Ա";
			}			
		}else{//����뷢�͹���Ƶ�������Ժ�����
			retmsg = "���ŷ��ͷ��͹���Ƶ�������Ժ�����";
		}
		//����session
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
	 * ������ŷ���
	 * @param phone 
	 * @param cityno
	 * @param dbuser
	 * @return 
	 * @throws Exception
	 */
	private String sendRandomSms(String phone, DBAccessUser dbuser, String rtnPage){
		//	��Session��ȡ��������֤�����SMSRndCode��;�ж��Ƿ�Ϊnull����Ϊnull���򴴽�һ��������֤����󣬲���¼������ʱ�䡣
		Object obj = this.getRequest().getSession().getAttribute(SMS_CODE);
		SMSRndCode smsRndCode = null;
		if(obj==null){
			smsRndCode = new SMSRndCode(phone);
		}else{
			smsRndCode = (SMSRndCode)obj;
			smsRndCode.setMobile(phone);
		}
		
		//�ж��Ƿ�Ϊ�㶫�ƶ�����
		try{
			if("loginprov".equals(rtnPage)){//ʡ��˾�ֻ�����֤(���й�˾���ŵ�¼ʱ������֤)
				Nosect nosect = (NosectBO)BOFactory.build(NosectBO.class, dbuser);
				NosectDBParam listVO = new NosectDBParam();
				listVO.set_snm_beginno(phone);
				listVO.set_snl_endno(phone);
				listVO.setCountOnly(true);
				DataPackage dp = nosect.doQuery(listVO);
				if(dp==null && dp.getRowCount()==0){//��
					this.addActionError("�ֻ����벻����Ч�Ĺ㶫�ƶ�����");
					return "login";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("������֤�쳣");
			log.info("������֤�쳣");
			this.addActionError("������֤�쳣������ϵ����Ա");
			return "login";
		}		
		
		//��ȡ6λ���������
		String rndCode = RndNumberBuilder.getRndNumber(6);
		
		//�������ӳɹ�
		if(smsRndCode.addRndCode(rndCode).equals(SMSRndCode.PASS)){
			try{
				//���ͺ���
				Sysparam sysparam = (SysparamBO)BOFactory.build(SysparamBO.class, dbuser);
				String sendno = sysparam.doFindByID("42", "pboss_fx");
				
				//��������
				String msg = SMSRndCode.getSMS_MSG().replace("$", rndCode);
				Waitreq waitreq = (WaitreqBO)BOFactory.build(WaitreqBO.class, dbuser);
				
				WaitreqVO wrvo = waitreq.doInsert2((short)1, msg, sendno, phone);
			}catch(Exception e){//���ŷ���ʧ��
				e.printStackTrace();
				this.addActionError("�����������ŷ���ʧ�ܣ�����ϵ����Ա");
				return "login";
			}			
		}else{//����뷢�͹���Ƶ�������Ժ�����
			this.addActionError("���ŷ��ͷ��͹���Ƶ�������Ժ�����");
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
				this.addActionError("����������е���֤��");
				return "loginprov";
			} else {
				//У�����������֤��
				if(!this.validateRndCode(this.getRndsmscode())){
					return "loginprov";
				}
				
				User user = form.getUser();
				//��֤��Ա�Ƿ����
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
					throw new BusinessException("�û���������!");
				}				
				//if(vo.getRegion()==999){
				//	throw new BusinessException("��ǰ��¼����û�з���PBOSS��Ȩ��!");
				//}
				if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("��ǰ��¼��������Ч!");
				}
				
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				user.setRemoteName(request.getRemoteHost());
				//��¼��־
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getContactphone());//ʡ��˾��Աʹ���ֻ������¼
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
				this.addActionError("����������е���֤��");
				return "login2smscity";
			} else {
				//У�����������֤��
				if(!this.validateRndCode(this.getRndsmscode())){
					return "login2smscity";
				}
				
				User user = form.getUser();
				//��ѯ��Ա��Ϣ
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("�û�����COMS�˲�����!");
				}
				
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				user.setRemoteName(request.getRemoteHost());
				
				//��¼��־
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
			//��session��������Ӧ��Ϣ
			// �����û��������������Ϣ������ cityid��
			// dbFlag ���������û��� cityid ���档ʵ������Ҫ��������жϣ����ǹ̶�Ϊ��ֵ��
			// ���û�����Ự��				
			HttpServletRequest request = ServletActionContext.getRequest();
			user.setSessionID(request.getSession().getId());
			user.setIp(request.getRemoteHost());
			user.setLogintime(new Date());
			user.setCityid(CityMappingUtil.getCityid(cityno));
			user.setHwcityid(cityno);
			user.setWayid(oprVO.getOrgid());
			// TODO: �������ܣ���¼��¼��ʷ
			ActionContext.getContext().getSession().put(WebConstant.SESSION_ATTRIBUTE_USER, user);
			ActionContext.getContext().getSession().put(WebConstant.LOGIN_TYPE, "NOTBOSS");
			//��ȡʡ��˾��Ա��¼����ƽ̨����
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
			this.addActionError("��֤ʧ�ܣ������»�ȡ���������֤��");
			return false;
		}
		this.addActionError("��������������ȷ��������ȷ�Ķ�����֤��");
		return false;
	}
	
	public String doChangecity() throws Exception{
		if(StringUtils.isEmpty(this.getCityno())){//û��ѡ���κε���
			return null;
		}
		
		User user = (User)this.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		if(user==null){
			return null;//�Ự��ʱ����Ҫ�û������µ�¼
		}
		user.setCityid(CityMappingUtil.getCityid(cityno));
		user.setHwcityid(cityno);
		this.getRequest().getSession().setAttribute(WebConstant.SESSION_ATTRIBUTE_USER, user);
		//System.out.println("-----------------------ʡ��˾["+user.getOprcode()+"]�л���["+user.getCityid()+"]��");
		log.info("-----------------------ʡ��˾["+user.getOprcode()+"]�л���["+user.getCityid()+"]��");
		return null;
	}

	public String doLogin() throws Exception{
		LoginForm form = (LoginForm) this.getForm();
		LoginlogVO logVO=null;
		try {
			if (form.getUser() == null) {
				return "login";
			} else if (!StringUtils.isValuedString(form.getUser().getOprcode())) {
				addActionError("����ȱʧ!");
				return "login";
			} else {
				//System.out.println("***********************��¼���ţ�"+form.getUser().getOprcode());
				log.info("***********************��¼���ţ�"+form.getUser().getOprcode());
				User user = form.getUser();
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("�û�����COMS�˲�����!");
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				String ip=this.getClientIpAddress(request);
				user.setIp(request.getRemoteAddr());
				//String macAddr=this.getMACAddress(ip);
				//user.setMacAddr(macAddr);
				user.setRemoteName(request.getRemoteHost());
				//��¼��־
				logVO=new LoginlogVO();
				logVO.setOprcode(vo.getOperid());
				logVO.setWayid(vo.getOrgid());
				logVO.setCityid(CityMappingUtil.getCityid(vo.getRegion().toString()));
				logVO.setLogintime(new Date());
				logVO.setClientname(request.getRemoteHost());
				
				logVO.setIpaddress(ip);
				//logVO.setMacaddress(macAddr);			
				
				//if(!CoreConfigInfo.LOGIN_FLAG && !"pbosstest".equals(user.getOprcode())){ //�ǵ�����ʽ������ʱ���pbosstest������⹤��ɾ��
				if(!CoreConfigInfo.LOGIN_FLAG){ //�ǵ�����ʽ������ʱ���pbosstest������⹤��ɾ��
					 if(vo.getRegion()==999){
						throw new BusinessException("��ǰ��¼����û�з���PBOSS��Ȩ��!");
					}else if(vo.getStatus()==null || vo.getStatus()==0){
						throw new BusinessException("��ǰ��¼��������Ч!");
					}else{
						String cityid=CityMappingUtil.getCityid(vo.getRegion().toString());
						
						ResourceBundle rs = ResourceBundle.getBundle("data/SMSLoginCity");						
						String isComsverify = (String)rs.getObject(cityid);//Y��COMS����������¼������boss��NG
						
						if("Y".equals(isComsverify)){
							//�����������
							user.setCityid(cityid);
							this.sendRandomSms(vo.getContactphone(), user, "login2smscity");
							
							return "login2smscity";
						}else{
							if(!this.isNGLoginCheck(cityid)){//������δ���NG��Ȩ
								if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
									if(CoreConfigInfo.LOGIN_DISTRIBUTION){
										String cityidJQ=getCityidLogAuthProperty(cityid);
										if(cityidJQ.equals("GZJQ")){//����BOSS���ݼ�Ⱥ��Ȩ
											loginCheck=new NewLoginCheckGZ();
										}else if(cityidJQ.equals("SZJQ")){//����BOSS���ڼ�Ⱥ��Ȩ
											loginCheck=new NewLoginCheckSZ();
										}else {//����BOSS��ݸ��Ⱥ��Ȩ
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
							}else{//�����Ѿ����NG��Ȩ
								//System.out.println("***********************�����Ѿ����NG��Ȩ***************************");
								log.info("***********************�����Ѿ����NG��Ȩ***************************");
								//System.out.println("***********************���ţ�"+user.getOprcode());
								log.info("***********************���ţ�"+user.getOprcode());
								this.ngLoginCheck = NGLoginPortFactory.createPort(cityid);
								Result result = this.ngLoginCheck.getLogintype(user);
								if( !INGLoginCheck.SUCCESS.equals(result.getResultCode()) ){
									throw new Exception(result.getResultDec());
								}
								logVO.setLogintype(result.getUserType());
								//System.out.println("***********************��¼��ʽ��"+result.getUserType());
								log.info("***********************��¼��ʽ��"+result.getUserType());
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
			addActionError("�����ڲ��쳣���޷���¼! ԭ��:" + e.getMessage());
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
	 * �����������Ĳ���
	 * @param form
	 * @throws Exception
	 */
	public void doGetPassword(LoginForm form) throws Exception{
		//����SimpAuth��Dynamic֮��,������Ҫ�������� OLD
		if(ILoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){//��̬����У��
			
		}else if(ILoginCheck.DYANMIC_LOGIN.equals(form.getResult().getUserType())){//��̬����У��
			if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
				form.getUser().setStep(1);
				loginCheck.doDynamicCheck(form.getUser());
			}
		}else if(ILoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){//����У��
			if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
				if(null==form.getUser().getStep())
					form.getUser().setStep(1);
			}else{
				loginCheck.doSend2WS(form.getUser(), ILoginCheck.SEC_SAND);
			}
		}else if(ILoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){//��ս��У��
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
			// TODO: RSA��Ȩ
			if(null == form.getUser().getRSAStatus()){
				form.getUser().setRSAStatus(ILoginCheck.SIMP_AUTH);//����״̬δ�̶�����״̬
			}else if(ILoginCheck.SIMP_AUTH.equals(form.getUser().getRSAStatus())){
				form.getUser().setRSAStatus(ILoginCheck.DYNAMIC_PASS_AUTH);//����״̬Ϊ��ս��״̬
			}else if(ILoginCheck.DYNAMIC_PASS_AUTH.equals(form.getUser().getRSAStatus())){
				form.getUser().setRSAStatus(ILoginCheck.DYNAMIC_EXCURSION_AUTH);//����ΪƯ����״̬
			}
		}else{
			throw new Exception("�޴��û���Ȩ����:"+form.getResult().getUserType());
		}
	}
	
	private void doGetPasswordNG(LoginForm form) throws Exception{
		if(INGLoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){
			
		}else if(INGLoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){
			form.getUser().setStep(1);
		}else if(INGLoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){
			//System.out.println("***********************��ս���Ȩ����ȡ��ս��");
			log.info("***********************��ս���Ȩ����ȡ��ս��");
			form.getUser().setStep(1);
			Result result = this.ngLoginCheck.doSafewordAuth(form.getUser());
			if( !result.getResultCode().equals(INGLoginCheck.SUCCESS) ){
				//System.out.println("***********************��ս���Ȩ����ȡ��ս��ʧ��");
				log.info("***********************��ս���Ȩ����ȡ��ս��ʧ��");
				throw new Exception("��ȡ��ս��ʧ�ܣ�"+result.getResultDec());
			}else{
				String retinfo[] = result.getResultDec().split("\\|");
				if(retinfo.length!=2){
					//System.out.println("***********************��ս���Ȩ����ս�����ս��Ϣ��ʽ����"+result.getResultDec());
					log.info("***********************��ս���Ȩ����ս�����ս��Ϣ��ʽ����"+result.getResultDec());
					throw new Exception("��ս�����ս��Ϣ��ʽ����,"+result.getResultDec());
				}
				form.getUser().setSafewordCode(retinfo[0]);
				form.getUser().setSafewordMessage(retinfo[1]);
				//form.getUser().setSafewordCode(result.getResultDec());
				//System.out.println("***********************��ս���Ȩ����ȡ��ս�룺"+result.getResultDec());
				log.info("***********************��ս���Ȩ����ȡ��ս�룺"+result.getResultDec());
			}
		}else if(INGLoginCheck.RSA_LOGIN.equals(form.getResult().getUserType())){
			form.getUser().setStep(1);			
		}else{
			throw new Exception("�޴��û���Ȩ����:"+form.getResult().getUserType());
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
				//System.out.println("***********************��¼���ţ�"+form.getUser().getOprcode());
				log.info("***********************��¼���ţ�"+form.getUser().getOprcode());
				User user = form.getUser();
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("�û�����PBOSS�˲�����!");
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				//��¼��־
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
					throw new BusinessException("��ǰ��¼����û�з���PBOSS��Ȩ��!");
				}else if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("��ǰ��¼��������Ч!");
				}else{
					if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
						if(CoreConfigInfo.LOGIN_DISTRIBUTION){
							String cityidJQ=getCityidLogAuthProperty(CityMappingUtil.getCityid(vo.getRegion().toString()));
							if(cityidJQ.equals("GZJQ")){//����BOSS���ݼ�Ⱥ��Ȩ
								loginCheck=new NewLoginCheckGZ();
							}else if(cityidJQ.equals("SZJQ")){//����BOSS���ڼ�Ⱥ��Ȩ
								loginCheck=new NewLoginCheckSZ();
							}else {//����BOSS��ݸ��Ⱥ��Ȩ
								loginCheck=new NewLoginCheckDG();
							}
						}
					}
				}
				if(ILoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){
					result = loginCheck.doSend2WS(user, ILoginCheck.SIMP_AUTH);
				}else if(ILoginCheck.DYANMIC_LOGIN.equals(form.getResult().getUserType())){//��̬
					if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
						user.setStep(2);
						result=loginCheck.doDynamicCheck(user);//��֤��̬����
					}else{
						result = loginCheck.doSend2WS(user, ILoginCheck.SIMP_AUTH);
					}
				}else if(ILoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){//����
					if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
						if(user.getStep()==1){
							user.setStep(2);
							result = loginCheck.doSend2WS(user, ILoginCheck.SEC_AUTH);//��֤�̶�����
							if(WAIT.equals(result.getResultCode())){
								this.doGetPassword(form);  //������һ��
								return "login2";
							}else{
								form.getUser().setStep(null);//ʧ���˻ص�һ��
							}
						}else if(user.getStep()==2){//У�������֤��
							user.setStep(3);
							result = loginCheck.doSend2WS(user, ILoginCheck.SEC_AUTH);
						}
					}else{
						result = loginCheck.doSend2WS(user, ILoginCheck.SEC_AUTH);
					}
					
				}else if(ILoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){//��ս��
					result = loginCheck.doSend2WS(user, ILoginCheck.CHALLENGE_AUTH_VALUE);
				}else if(ILoginCheck.RSA_LOGIN.equals(form.getResult().getUserType())){//RSA
					// TODO: RSA��Ȩ
					if(ILoginCheck.SIMP_AUTH.equals(form.getUser().getRSAStatus())){//�̶�������֤
						if(CoreConfigInfo.LOGIN_VERSION.equals("new")){
							user.setStep(2);
							result = loginCheck.doSend2WS(user, ILoginCheck.DYNAMIC_PASS_AUTH);//2,��֤�̶�����
							if(WAIT.equals(result.getResultCode())){
								this.doGetPassword(form);  //������һ��
								return "login2";
							}else{
								form.getUser().setRSAStatus(null);//ʧ���˻ص�һ��
							}
						}else{
							result = loginCheck.doSend2WS(user, ILoginCheck.SIMP_AUTH);
							if(SUCCESS.equals(result.getResultCode())){
								this.doGetPassword(form);  //������һ��
								return "login2";
							}else{
								form.getUser().setRSAStatus(null);//ʧ���˻ص�һ��
							}
						}
					}
					
					if(ILoginCheck.DYNAMIC_PASS_AUTH.equals(form.getUser().getRSAStatus())){//��ս����֤
						user.setStep(3);
						result = loginCheck.doSend2WS(user, ILoginCheck.DYNAMIC_PASS_AUTH);
						if(SUCCESS.equals(result.getResultCode())){
							return this.sessionOperation(user,logVO); //����8�ɹ�
						}else if(WAIT.equals(result.getResultCode())){
							//form.getUser().setSafewordMessage(form.getUser().getPassword());
							this.doGetPassword(form);  //������һ��
							return "login2";
						}else{
							form.getUser().setRSAStatus(null);//�˻ص�һ��
						}
					}
					
					if(ILoginCheck.DYNAMIC_EXCURSION_AUTH.equals(form.getUser().getRSAStatus())){//Ư������֤
						result = loginCheck.doSend2WS(user, ILoginCheck.DYNAMIC_EXCURSION_AUTH);
						if(SUCCESS.equals(result.getResultCode())){
							return this.sessionOperation(user,logVO); //����8�ɹ�
						}else{
							form.getUser().setRSAStatus(null);//�˻ص�һ��
						}
					}
				}
				if(SUCCESS.equals(result.getResultCode())){
					return this.sessionOperation(user,logVO);
				}else{
					this.doGetPassword(form);
					throw new Exception(result==null?"�������!":result.getResultDec());
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
				//System.out.println("***********************��¼���ţ�"+form.getUser().getOprcode());
				log.info("***********************��¼���ţ�"+form.getUser().getOprcode());
				User user = form.getUser();
				Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
				OperatorVO vo = operator.doFindByPk(user.getOprcode());
				if(vo == null){
					throw new BusinessException("�û�����PBOSS�˲�����!");
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				//��¼��־
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
					throw new BusinessException("��ǰ��¼����û�з���PBOSS��Ȩ��!");
				}else if(vo.getStatus()==null || vo.getStatus()==0){
					throw new BusinessException("��ǰ��¼��������Ч!");
				}				
				 
				this.ngLoginCheck = NGLoginPortFactory.createPort(cityid);
				if(INGLoginCheck.SIMP_LOGIN.equals(form.getResult().getUserType())){
					//System.out.println("***********************��������֤");
					log.info("***********************��������֤");
					result = this.ngLoginCheck.doSimpAuth(user);
				}else if(INGLoginCheck.SEC_LOGIN.equals(form.getResult().getUserType())){//����
					if(1==user.getStep()){//��֤�̶����벢��ȡ���������
						//System.out.println("***********************���������������֤����֤�̶����룬�Ի�ȡ���������");
						log.info("***********************���������������֤����֤�̶����룬�Ի�ȡ���������");
						result = this.ngLoginCheck.doSecAuth(user);	
						if(INGLoginCheck.SUCCESS.equals(result.getResultCode())){
							user.setStep(2);
							ActionContext.getContext().getSession().put("smspassword", result.getResultDec());
							return "login2ngauth";
						}						
					}else{//user.getStep=2
						//System.out.println("***********************���������������֤����֤���������");
						log.info("***********************���������������֤����֤���������");
						result = new Result();
						String smspassword = (String)ActionContext.getContext().getSession().get("smspassword");
						if(user.getSecondPass().equals(smspassword)){
							result.setResultCode(INGLoginCheck.SUCCESS);
						}else{
							result.setResultCode(INGLoginCheck.WRONG_PASSWORD);
							result.setResultDec("������������");
						}
						ActionContext.getContext().getSession().remove("smspassword");
					}					
				}else if(INGLoginCheck.CHALLENGE_LOGIN.equals(form.getResult().getUserType())){//��ս��
					//System.out.println("***********************��ս����֤");
					log.info("***********************��ս����֤");
					form.getUser().setStep(2);
					result = this.ngLoginCheck.doSafewordAuth(user);
				}else if(INGLoginCheck.RSA_LOGIN.equals(form.getResult().getUserType())){//RSA
					if(1==form.getUser().getStep()){
						//System.out.println("***********************RSA������֤����֤�̶�����");
						log.info("***********************RSA������֤����֤�̶�����");
						result = this.ngLoginCheck.doRSAAuth(form.getUser());
						if(INGLoginCheck.SUCCESS.equals(result.getResultCode())){
							//System.out.println("***********************RSA������֤����֤�̶�����ͨ��");
							log.info("***********************RSA������֤����֤�̶�����ͨ��");
							form.getUser().setStep(2);
						}else{
							//System.out.println("***********************RSA������֤����֤�̶�ʧ�ܣ�"+result.getResultDec());
							log.info("***********************RSA������֤����֤�̶�ʧ�ܣ�"+result.getResultDec());
							addActionError("������֤ʧ�ܣ�ԭ��"+result.getResultDec());
						}
						return "login2ngauth";						
					}else if(2==form.getUser().getStep()){
						//System.out.println("***********************RSA������֤����֤RSA��ս��");
						log.info("***********************RSA������֤����֤RSA��ս��");
						result = this.ngLoginCheck.doRSAAuth(form.getUser());
						if(INGLoginCheck.WRONG_RSA.equals(result.getResultCode())){// RSA�뷢��Ư��
							//System.out.println("***********************RSA������֤��RSA�뷢��Ư��");
							log.info("***********************RSA������֤��RSA�뷢��Ư��");
							form.getUser().setStep(3);
							return "login2ngauth";
						}else if( !INGLoginCheck.SUCCESS.equals(result.getResultCode()) ){//RSA��ս����֤ʧ��
							//System.out.println("***********************RSA������֤����֤RSA��ս��ʧ�ܣ�"+result.getResultDec());
							log.info("***********************RSA������֤����֤RSA��ս��ʧ�ܣ�"+result.getResultDec());
							addActionError("RSA��ս����֤ʧ�ܣ�ԭ��"+result.getResultDec());
							return "login2ngauth";
						}
					}else if(3==form.getUser().getStep()){
						//System.out.println("***********************RSA������֤����֤RSAƯ����");
						log.info("***********************RSA������֤����֤RSAƯ����");
						result = this.ngLoginCheck.doRSAAuth(form.getUser());
						if(INGLoginCheck.WRONG_RSA.equals(result.getResultCode())){// RSA�뷢��Ư��
							//System.out.println("***********************RSA������֤��RSA���ٴ�Ư��");
							log.info("***********************RSA������֤��RSA���ٴ�Ư��");
							return "login2ngauth";
						}
					}					
				}
				if(INGLoginCheck.SUCCESS.equals(result.getResultCode())){
					return this.sessionOperation(user,logVO);
				}else{
					this.doGetPasswordNG(form);
					throw new Exception(result==null?"�������!":result.getResultDec());
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
			//��session��������Ӧ��Ϣ
			Operator operator = (Operator)BOFactory.build(OperatorBO.class,DBAccessUser.getInnerUser());
			OperatorVO vo = operator.doFindByPk(user.getOprcode());
			if(vo == null){
				logVO=null;
				throw new BusinessException("�û�����PBOSS�˲�����!");
			}
			if(vo.getRegion()==999){
				throw new BusinessException("��ǰ��¼����û�з���PBOSS��Ȩ��!");
			}
			if(vo.getStatus()==null || vo.getStatus()==0){
				throw new BusinessException("��ǰ��¼��������Ч!");
			}else{
				// �����û��������������Ϣ������ cityid��
				// dbFlag ���������û��� cityid ���档ʵ������Ҫ��������жϣ����ǹ̶�Ϊ��ֵ��
				// ���û�����Ự��
				
				HttpServletRequest request = ServletActionContext.getRequest();
				user.setSessionID(request.getSession().getId());
				user.setIp(request.getRemoteHost());
				user.setLogintime(new Date());
				user.setCityid(CityMappingUtil.getCityid(vo.getRegion().toString()));
				user.setHwcityid(vo.getRegion().toString());
				user.setWayid(vo.getOrgid());
				// TODO: �������ܣ���¼��¼��ʷ
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
	 * �ӹ��������ļ��ж�ȡ����
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
        	String fileSeparator = System.getProperty("file.separator"); //�����ļ��ָ���������ƽ̨   
            if (fileSeparator.equals("/")){  
            	macAddress=this.getMacInLinux(ip);
                System.out.println(macAddress);   
            }   
            else if(fileSeparator.equals("\\")){   
            	macAddress=getMacInWindows(ip);
                System.out.println(macAddress);  //nicrosoftϲ�����Ÿ�   
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
     * @param cmd  ��һ������  
     * @param another �ڶ�������  
     * @return   �ڶ��������ִ�н��  
     */  
    public static String callCmd(String[] cmd,String[] another) {   
        String result = "";   
        String line = "";   
        try {   
            Runtime rt = Runtime.getRuntime();   
            Process proc = rt.exec(cmd);   
            int exitVal = proc.waitFor();  //�Ѿ�ִ�����һ�����׼��ִ�еڶ�������   
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
     * @param ip  Ŀ��ip,һ���ھ�������  
     * @param sourceString �����Ľ���ַ���  
     * @param macSeparator mac�ָ�����  
     * @return  mac��ַ��������ķָ����ű�ʾ  
     */  
    public  String filterMacAddress( String ip,  String sourceString, String macSeparator) {   
        String result = "";   
        String regExp = "((([0-9,A-F,a-f]{1,2}" + macSeparator + "){1,5})[0-9,A-F,a-f]{1,2})";   
        Pattern pattern = Pattern.compile(regExp);   
        Matcher matcher = pattern.matcher(sourceString);   
        while(matcher.find()){   
            result = matcher.group(1);   
            if(sourceString.indexOf(ip) <= sourceString.lastIndexOf(matcher.group(1))) {   
                break;  //����ж��IP,ֻƥ�䱾IP��Ӧ��Mac.   
            }   
        }   
  
        return result;   
    }   
  
    /**  
     *  
     * @param ip Ŀ��ip  
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
     * @param ip Ŀ��ip  
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
