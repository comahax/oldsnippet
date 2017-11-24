package com.gmcc.pboss.member.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.Channel;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.member.service.IMemberService;
import com.gmcc.pboss.member.service.MemberServiceRetCode;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-11-11
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ��������¼Action
 */
public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 8493745511522538626L;
	
	/***
	 * ��¼ʱ����Service
	 */
	private IMemberService service;
	
	/**
	 * BackURl
	 */
	private String backUrl;
	
	/**��¼ʱ���ò�����
	 * inputCode
	 * officeTel
	 * */
	private MemberQueryParameter loginParameter;
	
	/**
	 * ��ѯ������Ϣ���õ�Service
	 */
	private CommunicatePlateauService cpService;
	
	/**
	 * ������Ϣ�б�
	 */
	private List<ChPwAdvinfo> publicList;
	
	private String _cityid;

	/**������֤��*/
	private String vaildateCode;
	public String getVaildateCode() {
		return vaildateCode;
	}
	public void setVaildateCode(String vaildateCode) {
		this.vaildateCode = vaildateCode;
	}
	
	/**
	 * ע��ConstantService�ӿڣ����ڴ����ݿ���ع̶�����-�������ڼ��ص�½��ʽWEB_AUTHTYPE
	 */
	private ConstantService constantService;
	public void setConstantService(ConstantService constantService){
		this.constantService = constantService;
	}
	
	/*
	 * �û���Ϣչʾ-��������
	 * ���ݵ�½�û���wayid��ѯ�����ţ��ڲ�ѯ���ű�õ���������
	 */
	//private SaSoOperatorService operatorService;
	//public  void setOperatorService(SaSoOperatorService operatorService){
	//	this.operatorService = operatorService;
	//}
	
	/**
	 * ��ȡ��½��ʽ
	 * @return ���ؿ�ѡ��½��ʽ-���������or�̶�����<dictid,dictname>
	 */
	public Map getAuthType(){
		Map<String,String> t = this.constantService.getConstantMap(CodeReverseKey.AUTH_TYPE);
		return t;
	}
			
	public String toLogin(){
		//��BackURL���ص�¼ҳ��
		try {
			Object obj = this.getSessionAttribute(HttpDictionary.BACK_URL);
			String backURL = (obj == null)?INDEX:(String)obj;
			setRequestAttribute(HttpDictionary.BACK_URL, backURL);
			this.setBackUrl(backURL);
			removeSessionAttribute(HttpDictionary.BACK_URL);
			String cityid ;
			if(_cityid!=null)
				cityid = _cityid;
			else
				cityid = getDefaultCityID();
			queryPublic(cityid);
			
			//����
			setRequestAttribute(HttpDictionary.CITYID, cityid);
		}catch(Exception e){
			logger.error("��׽�쳣������������������:"+e.getMessage());//������û�
			e.printStackTrace();
		}finally{
			return SUCCESS;
		}
	}
	
	public String toLogin2(){
		return "login2";
	}
	
	/**
	 * 20140407 ʷ���� ����ʹ�ô˷���
	 * ʹ�ù��������officetel��¼����֧��רԱtelephone��¼
	 * �û���¼
	 * @return
	 */
//	public String doLoginOld() {
//		//��¼ʱ���ʱ�����ڴ�ӡ��¼��־����������¼����
//		long starttime = System.currentTimeMillis();
//		String cityinfo = "";//���ڵ�¼��־�еǼǵ��б�ʶ
//		
//		HttpSession session = getSession();
//		ServiceResult result = null;
//		LoginMember member = getMember();
//		
//		//����Ƿ��Ѿ���¼
//		if(member !=null){
//			return ERROR;
//		}		
//		//����¼�����Ƿ�Ϊ��
//		MemberQueryParameter loginParameter = getLoginParameter();
//		if(loginParameter == null){
//			String cityid = getRequest().getParameter(HttpDictionary.CITYID);
//			queryPublic(cityid);
//			return NONE;
//		}		
//		//�ӵ�һ����¼������룬��֤��������������֤��
//		if(!loginParameter.isStep2()){
//			//�ж���֤��
//			//ʹ������������¼
//			if(loginParameter.getChosenAuthType().equals("SecAuth")){
//				//��֤�������У����
//				result = validateSMSRndCode(loginParameter.getInputCode());
//			}
//			//ʹ�ù̶������¼
//			else{//"SimpAuth"			
//					result = validateImageCode(this.getVaildateCode());
//			}
//		}else{//�ӵڶ�����¼������룬�������κ���֤
//			result = new ServiceResult();
//			//����Ǵӵڶ�����¼������ת��������session��ȡ����¼���ͺ͹��������
//			Object obj = session.getAttribute("loginInfo");
//			if(obj!=null){
//				MemberQueryParameter loginInfo = (MemberQueryParameter)obj;
//				loginParameter.setChosenAuthType(loginInfo.getChosenAuthType());
//				loginParameter.setOfficeTel(loginInfo.getOfficeTel());
//				result.setSuccess(true);
//			}else{
//				result.setSuccess(false);
//				//result.setRetObject("/tologin.do");
//			}
//			
//		}
//		
//		if(result.isSuccess()){
//			result = service.transactionProcessing(getMember(), loginParameter, ServiceType.INITIATE);
//			int retCode = result.getRetCode();
//			String backURL = loginParameter.getBackURL();
//			if(retCode==MemberServiceRetCode.MIX_ROLE){//��Ͻ�ɫ��Ա��¼����Ҫ�����ڶ�����¼������֤
//				backURL = "/tologin2.do";
//				result.setRetObject(backURL);
//				session.setAttribute("loginInfo", loginParameter);
//			}
//			// ��¼�ɹ�
//			else if (result.isSuccess()) {
//				member = (LoginMember) result.getRetObject();	
//				cityinfo = member.getCityid();
//				//��ȡ�˵���
//				//Map<String,ArrayList> menuMap = member.getMenuMap();
//     			//session.setAttribute("menuMap", menuMap);//���˵���Ϣ����session��
//     			//member.setMenuMap(null);//������session�з���2��
//				
//				long isnet = member.getIsnet();
//				//�����̵�¼
//				if( isnet == Role.SHOP_ASSISTANT || isnet == Role.SHOP_MASTER ){
//					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? INDEXACTION : backURL;//		INDEX			
//					//����ͻ���cookies�еĳ��ò˵�
//					//filterCookie(member,menuMap);				    
//				}
//				//�ƹ�רԱ
//				else if( isnet == Role.MISSIONER){
//					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MISSIONER_PAGE : backURL;
//					//��Ϊ������ʱ,��index.do������ת����������ҳ
//					if (backURL.indexOf(INDEXACTION)>=0) backURL = MISSIONER_PAGE;
//				}
//				//�����̵�¼
//				else if( isnet == Role.DELIVERY_MAN){
//					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? DELIVERY_PAGE : backURL;
//					//��Ϊ������ʱ,��index.do������ת����������ҳ
//					if (backURL.indexOf(INDEXACTION)>=0) backURL = DELIVERY_PAGE;
//				}
//				//������Ա��¼
//				else if( isnet == Role.MANAGER){
//					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MANAGER_PAGE : backURL;
//					//��Ϊ������Աʱ����index.do������ת��������Ա��ҳ
//					if(backURL.indexOf(INDEXACTION)>=0) backURL = MANAGER_PAGE;
//				}
//				
//				//����Session
//				session.setAttribute(HttpDictionary.USER_NAME, member);
//				session.removeAttribute("loginInfo");
//			
//				result.setRetObject(backURL);
//			}
//		}
//		
//		// ����JSON
//		writeJSONServiceData(result);
//		// ��¼��־
//		Log.loginLog(loginParameter.getOfficeTel(), result, starttime, cityinfo);
//		
//		return null;
//	}
	
	/*
	 * 20140307 ʷ���� ����
	 * ͬʱ��ѯ�����officetel��רԱ����telephone��ֻ�����������Ա��¼
	 */
	public String doLogin(){
		//��¼ʱ���ʱ�����ڴ�ӡ��¼��־����������¼����
		long starttime = System.currentTimeMillis();
		String cityinfo = "";//���ڵ�¼��־�еǼǵ��б�ʶ		
		HttpSession session = getSession();
		ServiceResult result = null;
		//����Ƿ��Ѿ���¼
		LoginMember member = getMember();	
		
		if(member !=null){
			return ERROR;
		}		
		//����¼�����Ƿ�Ϊ��
		MemberQueryParameter loginParameter = getLoginParameter();
		if(loginParameter == null){
			String cityid = getRequest().getParameter(HttpDictionary.CITYID);
			queryPublic(cityid);
			return NONE;
		}
		
		//�ӵ�һ����¼������룬��֤��������������֤��
		if(!loginParameter.isStep2()){
			//ʹ������������¼,��֤�������У����
			if(loginParameter.getChosenAuthType().equals("SecAuth")){
				result = validateSMSRndCode(loginParameter.getInputCode());
			}else{//"SimpAuth",ʹ�ù̶������¼,��֤ͼƬ��֤��			
				result = validateImageCode(this.getVaildateCode());
			}
		}else{//�ӵڶ�����¼������룬�������κ���֤
			result = new ServiceResult();
			//session.removeAttribute("isnetmap");//����ڶ�����¼�����ɫ��������Ϣ��������Ҫ
			//����Ǵӵڶ�����¼������ת��������session��ȡ����¼���ͺ͹��������
			Object obj = session.getAttribute("loginInfo");
			if(obj!=null){
				MemberQueryParameter loginInfo = (MemberQueryParameter)obj;
				loginParameter.setChosenAuthType(loginInfo.getChosenAuthType());
				loginParameter.setOfficeTel(loginInfo.getOfficeTel());
				session.removeAttribute("loginInfo");
				session.removeAttribute("isnetmap");//����ڶ�����¼�����ɫ��������Ϣ��������Ҫ
				result.setSuccess(true);
			}else{
				result.setSuccess(false);
			}
		}
		
		if(result.isSuccess()){
			result = service.transactionProcessing(getMember(), loginParameter, ServiceType.INITIATE);
			int retCode = result.getRetCode();
			String backURL = loginParameter.getBackURL();
			if(retCode==MemberServiceRetCode.MIX_ROLE){//��Ͻ�ɫ��Ա��¼����Ҫ�����ڶ�����¼������֤
				backURL = "/tologin2.do";
				Map<Integer,String> retmap = new HashMap<Integer,String>();
				retmap.putAll((Map<Integer,String>)(result.getRetObject()));
				//����sessionǰ����գ���ֹ��ͻ
				session.removeAttribute("isnetmap");
				session.setAttribute("isnetmap", retmap);//�ڶ�����¼���棬��ɫѡ��������
				result.setRetObject(backURL);
				session.removeAttribute("loginInfo");
				session.setAttribute("loginInfo", loginParameter);
			}			
			else if (result.isSuccess()) {// ��¼�ɹ�
				member = (LoginMember) result.getRetObject();	
				cityinfo = member.getCityid();
				//�����ѯ��Ա��ch_pw_employee��¼��cityidΪ�գ���ȡ��Ӧ������ch_pw_way��¼��cityid
//				if (member.getCityid() == null) {
//					Channel way = new Channel();
//					way = service.getByWayId(member.getWayid());
//					String cityid = way.getCityid();
//					if (way.getCityid() == null) {
//						this.setMessage("�޷�ȷ����½��Ա��������");
//					} else {
//						member.setCityid(cityid);
//					}
//				}
				long isnet = member.getIsnet();
				//�����̵�¼
				if( isnet == Role.SHOP_ASSISTANT || isnet == Role.SHOP_MASTER ){
					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? INDEXACTION : backURL;//		INDEX			
				}
				//�ƹ�רԱ
				else if( isnet == Role.MISSIONER){
//					if(member.getEmpattr2()== null){
//						this.setMessage("רԱ����Ϊ�գ����ܷ���");
//						
//					}else if (member.getEmpattr2()!= 1 && member.getEmpattr2()!= 2 &&member.getEmpattr2()!= 3){
//						this.setMessage("��������רԱ���Ͳ�֧�ַ���");
//					}
					
					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MISSIONER_PAGE : backURL;
					//��Ϊ������ʱ,��index.do������ת����������ҳ
					if (backURL.indexOf(INDEXACTION)>=0) backURL = MISSIONER_PAGE;
				}
				//�����̵�¼
				else if( isnet == Role.DELIVERY_MAN){
					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? DELIVERY_PAGE : backURL;
					//��Ϊ������ʱ,��index.do������ת����������ҳ
					if (backURL.indexOf(INDEXACTION)>=0) backURL = DELIVERY_PAGE;
				}
				//������Ա��¼
				else if( isnet == Role.MANAGER){
					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MANAGER_PAGE : backURL;
					//��Ϊ������Աʱ����index.do������ת��������Ա��ҳ
					if(backURL.indexOf(INDEXACTION)>=0) backURL = MANAGER_PAGE;
				}
				//ʡ��˾����Ա��¼
				else if( isnet == Role.GD_MANAGER){
					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? GD_MANAGER_PAGE : backURL;
					//��ʡ��˾����Ա��¼ʱ����index.do������ת��ʡ��˾����Ա��ҳ
					result.setRetCode(MemberServiceRetCode.GDMEMBERTYPE);
					if(backURL.indexOf(INDEXACTION)>=0) backURL = GD_MANAGER_PAGE;
				}
				//�й�˾����Ա��¼
				else if( isnet == Role.CITY_MANAGER){
					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? CITY_MANAGER_PAGE : backURL;
					//��Ϊ������Աʱ����index.do������ת��������Ա��ҳ
					result.setRetCode(MemberServiceRetCode.CITYMEMBERTYPE);
					if(backURL.indexOf(INDEXACTION)>=0) backURL = CITY_MANAGER_PAGE;
				}
				
				//����Session
				session.setAttribute(HttpDictionary.USER_NAME, member);
				session.removeAttribute("loginInfo");
				session.removeAttribute("isnetmap");//����ڶ�����¼�����ɫ��������Ϣ��������Ҫ
				result.setRetObject(backURL);
			}
		}
		
		// ����JSON
		writeJSONServiceData(result);
		// ��¼��־
		//Log.loginLog(loginParameter.getOfficeTel(), result, starttime, cityinfo);
		return null;
	}
	
//	/**
//	 * ���ز˵���Service���˵���Ϣ�������ݿ��SA_DB_WEBFUNCTIONITEM��
//	 */
//	private SaDbWebfunctionitemService saDbWebfunctionitemService;
//	//����ͻ���cookies�еĳ��ò˵�
//	private void filterCookie(LoginMember loginMember,Map<String,ArrayList> menuMap ){
//		//����ͻ���cookies�еĳ��ò˵�
//		try{
//			//��ȡ�ɼ��˵�
//			//Map visiableMenuMap = this.saDbWebfunctionitemService.getVisiableMenu();
//			Map visiableMenuMap = new HashMap<String,String>();
//			Collection<ArrayList> menuValues;
//			if(menuMap != null){
//				menuValues = menuMap.values();
//			}else{
//				return;
//			}
//			for(Iterator iter = menuValues.iterator();iter.hasNext();){
//				ArrayList item = (ArrayList)iter.next();
//				for(int i=0;i<item.size();i++){
//					SaDbWebfunctionitem tempVar = (SaDbWebfunctionitem)item.get(i);
//					visiableMenuMap.put(tempVar.getFuncname(), tempVar.getGuiobject());
//				}
//			}
//			
//			//����wayid��ȡcookie
//			Cookie[] cookies = this.getRequest().getCookies();
//			Cookie commonMenuCookie = null;
//			for(int i=0;i<cookies.length;i++){
//				if(cookies[i].getName().equals(loginMember.getWayid())){
//					commonMenuCookie = cookies[i];
//					break;
//				}	
//			}
//			
//			//δ�ҵ����cookie����cookie��valueΪ�գ���������������
//			if(commonMenuCookie==null || commonMenuCookie.getValue()==null){
//				return;
//			}
//			//����
//			String menuValue = Escape.unescape(commonMenuCookie.getValue());
//			//�ָ�
//			String[] items = menuValue.trim().split("\\|");
//			//�ָ�ÿ���˵�
//			String[] menuInfo;
//			for(int i=0;i<items.length;i++){
//				menuInfo = items[i].split("~");
//				if(!visiableMenuMap.containsKey(menuInfo[0])){//���ɼ���ɾ��
//					items[i]=null;
//				}
//			}
//						
//			//д��cookie
//			StringBuilder sb = new StringBuilder();
//			for(int j=0;j<items.length;j++){
//				if(items[j]!=null){
//					sb.append(items[j]+"|");
//				}
//			}
//			sb.deleteCharAt(sb.length()-1);
//			String cookieValue = sb.toString();
//			//cookieValue = cookieValue.substring(0, cookieValue.length()-1);
//			
//			//����
//			commonMenuCookie.setValue(Escape.escape(cookieValue));
//			this.getResponse().addCookie(commonMenuCookie);
//		}catch(Exception e){
//			//e.printStackTrace();
//		}
//	}
	
	/**
	 * �û��˳�
	 */
	public String doLogout() {
		LoginMember member = this.getMember();
		String cityid = (member !=null )?member.getCityid():getDefaultCityID();
		
		//����ɾ��Session�µĶ���
		Enumeration enums = getSession().getAttributeNames();
		while (enums.hasMoreElements()) {
			String attrName = (String)enums.nextElement();
			removeSessionAttribute(attrName);
			enums = getSession().getAttributeNames();//����getһ�Σ���֤attNames�����µ�,����Session�������ı�
		}
		
		queryPublic(cityid);
		setRequestAttribute(HttpDictionary.CITYID, cityid);
		return SUCCESS;
	}
	
	/**
	 * ��ѯ������Ϣ
	 */
	private void queryPublic(String cityid){
		//logger.info("Query Public Information For " + cityid);
		cityid = (cityid != null)?cityid:getDefaultCityID();
		setRequestAttribute(HttpDictionary.CITYID, cityid);
		setPublicList(cpService.getPublicInfoByCityid(cityid));
	}
	
	/**
	 * �õ�Ĭ�ϵ��б���
	 */
	private String getDefaultCityID(){
		String defaultCityid = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, 
				CommonConfig.PUBLIC_CITY_ID);
		return defaultCityid;
	}
	//////////////////////Getter And Setter////////////////////////////////////
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
	}

	public IMemberService getService() {
		return service;
	}

	public void setService(IMemberService service) {
		this.service = service;
	}

	public MemberQueryParameter getLoginParameter() {
		return loginParameter;
	}

	public void setLoginParameter(MemberQueryParameter loginParameter) {
		this.loginParameter = loginParameter;
	}
	public CommunicatePlateauService getCpService() {
		return cpService;
	}
	public void setCpService(CommunicatePlateauService cpService) {
		this.cpService = cpService;
	}
	public List<ChPwAdvinfo> getPublicList() {
		return publicList;
	}
	public void setPublicList(List<ChPwAdvinfo> publicList) {
		this.publicList = publicList;
	}
	/**
	 * @return the backUrl
	 */
	public String getBackUrl() {
		return backUrl;
	}
	/**
	 * @param backUrl the backUrl to set
	 */
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	public String get_cityid() {
		return _cityid;
	}
	public void set_cityid(String _cityid) {
		this._cityid = _cityid;
	}
	
}
