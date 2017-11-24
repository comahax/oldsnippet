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
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-11
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：登录Action
 */
public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 8493745511522538626L;
	
	/***
	 * 登录时所用Service
	 */
	private IMemberService service;
	
	/**
	 * BackURl
	 */
	private String backUrl;
	
	/**登录时所用参数：
	 * inputCode
	 * officeTel
	 * */
	private MemberQueryParameter loginParameter;
	
	/**
	 * 查询公开信息所用的Service
	 */
	private CommunicatePlateauService cpService;
	
	/**
	 * 公开信息列表
	 */
	private List<ChPwAdvinfo> publicList;
	
	private String _cityid;

	/**输入验证码*/
	private String vaildateCode;
	public String getVaildateCode() {
		return vaildateCode;
	}
	public void setVaildateCode(String vaildateCode) {
		this.vaildateCode = vaildateCode;
	}
	
	/**
	 * 注入ConstantService接口，用于从数据库加载固定参数-这里用于加载登陆方式WEB_AUTHTYPE
	 */
	private ConstantService constantService;
	public void setConstantService(ConstantService constantService){
		this.constantService = constantService;
	}
	
	/*
	 * 用户信息展示-渠道经理
	 * 根据登陆用户的wayid查询经理工号，在查询工号表得到经理名称
	 */
	//private SaSoOperatorService operatorService;
	//public  void setOperatorService(SaSoOperatorService operatorService){
	//	this.operatorService = operatorService;
	//}
	
	/**
	 * 提取登陆方式
	 * @return 返回可选登陆方式-随机短信码or固定密码<dictid,dictname>
	 */
	public Map getAuthType(){
		Map<String,String> t = this.constantService.getConstantMap(CodeReverseKey.AUTH_TYPE);
		return t;
	}
			
	public String toLogin(){
		//将BackURL返回登录页面
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
			
			//地市
			setRequestAttribute(HttpDictionary.CITYID, cityid);
		}catch(Exception e){
			logger.error("扑捉异常》》》》》》》》》:"+e.getMessage());//输出到用户
			e.printStackTrace();
		}finally{
			return SUCCESS;
		}
	}
	
	public String toLogin2(){
		return "login2";
	}
	
	/**
	 * 20140407 史晓龙 不再使用此方法
	 * 使用公务机号码officetel登录，不支持专员telephone登录
	 * 用户登录
	 * @return
	 */
//	public String doLoginOld() {
//		//登录时间计时，用于打印登录日志，并分析登录性能
//		long starttime = System.currentTimeMillis();
//		String cityinfo = "";//用于登录日志中登记地市标识
//		
//		HttpSession session = getSession();
//		ServiceResult result = null;
//		LoginMember member = getMember();
//		
//		//检查是否已经登录
//		if(member !=null){
//			return ERROR;
//		}		
//		//检查登录参数是否为空
//		MemberQueryParameter loginParameter = getLoginParameter();
//		if(loginParameter == null){
//			String cityid = getRequest().getParameter(HttpDictionary.CITYID);
//			queryPublic(cityid);
//			return NONE;
//		}		
//		//从第一步登录界面进入，验证随机短信码或者验证码
//		if(!loginParameter.isStep2()){
//			//判断验证码
//			//使用随机短信码登录
//			if(loginParameter.getChosenAuthType().equals("SecAuth")){
//				//验证随机短信校验码
//				result = validateSMSRndCode(loginParameter.getInputCode());
//			}
//			//使用固定密码登录
//			else{//"SimpAuth"			
//					result = validateImageCode(this.getVaildateCode());
//			}
//		}else{//从第二步登录界面进入，不许做任何验证
//			result = new ServiceResult();
//			//如果是从第二步登录界面跳转而来，从session中取出登录类型和公务机号码
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
//			if(retCode==MemberServiceRetCode.MIX_ROLE){//混合角色人员登录，需要经过第二步登录界面验证
//				backURL = "/tologin2.do";
//				result.setRetObject(backURL);
//				session.setAttribute("loginInfo", loginParameter);
//			}
//			// 登录成功
//			else if (result.isSuccess()) {
//				member = (LoginMember) result.getRetObject();	
//				cityinfo = member.getCityid();
//				//获取菜单项
//				//Map<String,ArrayList> menuMap = member.getMenuMap();
//     			//session.setAttribute("menuMap", menuMap);//将菜单信息放入session中
//     			//member.setMenuMap(null);//避免在session中放置2次
//				
//				long isnet = member.getIsnet();
//				//渠道商登录
//				if( isnet == Role.SHOP_ASSISTANT || isnet == Role.SHOP_MASTER ){
//					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? INDEXACTION : backURL;//		INDEX			
//					//处理客户端cookies中的常用菜单
//					//filterCookie(member,menuMap);				    
//				}
//				//推广专员
//				else if( isnet == Role.MISSIONER){
//					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MISSIONER_PAGE : backURL;
//					//当为配送商时,把index.do的请求转到配送商首页
//					if (backURL.indexOf(INDEXACTION)>=0) backURL = MISSIONER_PAGE;
//				}
//				//配送商登录
//				else if( isnet == Role.DELIVERY_MAN){
//					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? DELIVERY_PAGE : backURL;
//					//当为配送商时,把index.do的请求转到配送商首页
//					if (backURL.indexOf(INDEXACTION)>=0) backURL = DELIVERY_PAGE;
//				}
//				//经理人员登录
//				else if( isnet == Role.MANAGER){
//					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MANAGER_PAGE : backURL;
//					//当为经理人员时，将index.do的请求转到经理人员首页
//					if(backURL.indexOf(INDEXACTION)>=0) backURL = MANAGER_PAGE;
//				}
//				
//				//设置Session
//				session.setAttribute(HttpDictionary.USER_NAME, member);
//				session.removeAttribute("loginInfo");
//			
//				result.setRetObject(backURL);
//			}
//		}
//		
//		// 返回JSON
//		writeJSONServiceData(result);
//		// 登录日志
//		Log.loginLog(loginParameter.getOfficeTel(), result, starttime, cityinfo);
//		
//		return null;
//	}
	
	/*
	 * 20140307 史晓龙 新增
	 * 同时查询公务机officetel和专员号码telephone，只是所有社会人员登录
	 */
	public String doLogin(){
		//登录时间计时，用于打印登录日志，并分析登录性能
		long starttime = System.currentTimeMillis();
		String cityinfo = "";//用于登录日志中登记地市标识		
		HttpSession session = getSession();
		ServiceResult result = null;
		//检查是否已经登录
		LoginMember member = getMember();	
		
		if(member !=null){
			return ERROR;
		}		
		//检查登录参数是否为空
		MemberQueryParameter loginParameter = getLoginParameter();
		if(loginParameter == null){
			String cityid = getRequest().getParameter(HttpDictionary.CITYID);
			queryPublic(cityid);
			return NONE;
		}
		
		//从第一步登录界面进入，验证随机短信码或者验证码
		if(!loginParameter.isStep2()){
			//使用随机短信码登录,验证随机短信校验码
			if(loginParameter.getChosenAuthType().equals("SecAuth")){
				result = validateSMSRndCode(loginParameter.getInputCode());
			}else{//"SimpAuth",使用固定密码登录,验证图片验证码			
				result = validateImageCode(this.getVaildateCode());
			}
		}else{//从第二步登录界面进入，不需做任何验证
			result = new ServiceResult();
			//session.removeAttribute("isnetmap");//清楚第二步登录界面角色下拉框信息，不再需要
			//如果是从第二步登录界面跳转而来，从session中取出登录类型和公务机号码
			Object obj = session.getAttribute("loginInfo");
			if(obj!=null){
				MemberQueryParameter loginInfo = (MemberQueryParameter)obj;
				loginParameter.setChosenAuthType(loginInfo.getChosenAuthType());
				loginParameter.setOfficeTel(loginInfo.getOfficeTel());
				session.removeAttribute("loginInfo");
				session.removeAttribute("isnetmap");//清楚第二步登录界面角色下拉框信息，不再需要
				result.setSuccess(true);
			}else{
				result.setSuccess(false);
			}
		}
		
		if(result.isSuccess()){
			result = service.transactionProcessing(getMember(), loginParameter, ServiceType.INITIATE);
			int retCode = result.getRetCode();
			String backURL = loginParameter.getBackURL();
			if(retCode==MemberServiceRetCode.MIX_ROLE){//混合角色人员登录，需要经过第二步登录界面验证
				backURL = "/tologin2.do";
				Map<Integer,String> retmap = new HashMap<Integer,String>();
				retmap.putAll((Map<Integer,String>)(result.getRetObject()));
				//加载session前先清空，防止冲突
				session.removeAttribute("isnetmap");
				session.setAttribute("isnetmap", retmap);//第二步登录界面，角色选择下拉框
				result.setRetObject(backURL);
				session.removeAttribute("loginInfo");
				session.setAttribute("loginInfo", loginParameter);
			}			
			else if (result.isSuccess()) {// 登录成功
				member = (LoginMember) result.getRetObject();	
				cityinfo = member.getCityid();
				//如果查询人员表ch_pw_employee记录的cityid为空，则取对应渠道表ch_pw_way记录的cityid
//				if (member.getCityid() == null) {
//					Channel way = new Channel();
//					way = service.getByWayId(member.getWayid());
//					String cityid = way.getCityid();
//					if (way.getCityid() == null) {
//						this.setMessage("无法确定登陆人员所属地市");
//					} else {
//						member.setCityid(cityid);
//					}
//				}
				long isnet = member.getIsnet();
				//渠道商登录
				if( isnet == Role.SHOP_ASSISTANT || isnet == Role.SHOP_MASTER ){
					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? INDEXACTION : backURL;//		INDEX			
				}
				//推广专员
				else if( isnet == Role.MISSIONER){
//					if(member.getEmpattr2()== null){
//						this.setMessage("专员类型为空，不能访问");
//						
//					}else if (member.getEmpattr2()!= 1 && member.getEmpattr2()!= 2 &&member.getEmpattr2()!= 3){
//						this.setMessage("您所属的专员类型不支持访问");
//					}
					
					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MISSIONER_PAGE : backURL;
					//当为配送商时,把index.do的请求转到配送商首页
					if (backURL.indexOf(INDEXACTION)>=0) backURL = MISSIONER_PAGE;
				}
				//配送商登录
				else if( isnet == Role.DELIVERY_MAN){
					backURL = (backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? DELIVERY_PAGE : backURL;
					//当为配送商时,把index.do的请求转到配送商首页
					if (backURL.indexOf(INDEXACTION)>=0) backURL = DELIVERY_PAGE;
				}
				//经理人员登录
				else if( isnet == Role.MANAGER){
					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? MANAGER_PAGE : backURL;
					//当为经理人员时，将index.do的请求转到经理人员首页
					if(backURL.indexOf(INDEXACTION)>=0) backURL = MANAGER_PAGE;
				}
				//省公司管理员登录
				else if( isnet == Role.GD_MANAGER){
					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? GD_MANAGER_PAGE : backURL;
					//当省公司管理员登录时，将index.do的请求转到省公司管理员首页
					result.setRetCode(MemberServiceRetCode.GDMEMBERTYPE);
					if(backURL.indexOf(INDEXACTION)>=0) backURL = GD_MANAGER_PAGE;
				}
				//市公司管理员登录
				else if( isnet == Role.CITY_MANAGER){
					backURL =(backURL == null || backURL.equals("") || INDEX.equals(backURL)) ? CITY_MANAGER_PAGE : backURL;
					//当为经理人员时，将index.do的请求转到经理人员首页
					result.setRetCode(MemberServiceRetCode.CITYMEMBERTYPE);
					if(backURL.indexOf(INDEXACTION)>=0) backURL = CITY_MANAGER_PAGE;
				}
				
				//设置Session
				session.setAttribute(HttpDictionary.USER_NAME, member);
				session.removeAttribute("loginInfo");
				session.removeAttribute("isnetmap");//清楚第二步登录界面角色下拉框信息，不再需要
				result.setRetObject(backURL);
			}
		}
		
		// 返回JSON
		writeJSONServiceData(result);
		// 登录日志
		//Log.loginLog(loginParameter.getOfficeTel(), result, starttime, cityinfo);
		return null;
	}
	
//	/**
//	 * 加载菜单的Service，菜单信息放在数据库表SA_DB_WEBFUNCTIONITEM中
//	 */
//	private SaDbWebfunctionitemService saDbWebfunctionitemService;
//	//处理客户端cookies中的常用菜单
//	private void filterCookie(LoginMember loginMember,Map<String,ArrayList> menuMap ){
//		//处理客户端cookies中的常用菜单
//		try{
//			//获取可见菜单
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
//			//根据wayid获取cookie
//			Cookie[] cookies = this.getRequest().getCookies();
//			Cookie commonMenuCookie = null;
//			for(int i=0;i<cookies.length;i++){
//				if(cookies[i].getName().equals(loginMember.getWayid())){
//					commonMenuCookie = cookies[i];
//					break;
//				}	
//			}
//			
//			//未找到相关cookie或者cookie的value为空，不用做后续处理
//			if(commonMenuCookie==null || commonMenuCookie.getValue()==null){
//				return;
//			}
//			//解码
//			String menuValue = Escape.unescape(commonMenuCookie.getValue());
//			//分割
//			String[] items = menuValue.trim().split("\\|");
//			//分割每条菜单
//			String[] menuInfo;
//			for(int i=0;i<items.length;i++){
//				menuInfo = items[i].split("~");
//				if(!visiableMenuMap.containsKey(menuInfo[0])){//不可见，删除
//					items[i]=null;
//				}
//			}
//						
//			//写回cookie
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
//			//编码
//			commonMenuCookie.setValue(Escape.escape(cookieValue));
//			this.getResponse().addCookie(commonMenuCookie);
//		}catch(Exception e){
//			//e.printStackTrace();
//		}
//	}
	
	/**
	 * 用户退出
	 */
	public String doLogout() {
		LoginMember member = this.getMember();
		String cityid = (member !=null )?member.getCityid():getDefaultCityID();
		
		//批量删除Session下的对象
		Enumeration enums = getSession().getAttributeNames();
		while (enums.hasMoreElements()) {
			String attrName = (String)enums.nextElement();
			removeSessionAttribute(attrName);
			enums = getSession().getAttributeNames();//重新get一次，保证attNames是最新的,避免Session对象发生改变
		}
		
		queryPublic(cityid);
		setRequestAttribute(HttpDictionary.CITYID, cityid);
		return SUCCESS;
	}
	
	/**
	 * 查询公开信息
	 */
	private void queryPublic(String cityid){
		//logger.info("Query Public Information For " + cityid);
		cityid = (cityid != null)?cityid:getDefaultCityID();
		setRequestAttribute(HttpDictionary.CITYID, cityid);
		setPublicList(cpService.getPublicInfoByCityid(cityid));
	}
	
	/**
	 * 得到默认地市编码
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
