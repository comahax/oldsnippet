package com.sunrise.boss.common.client.sso;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.apache.log4j.Logger;

import com.sunrise.boss.common.client.sso.Esop2CRMStub.AuthResultToken_type0;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.AuthResult_type0;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.CheckMenu;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.CheckMenuAuthResult_type0;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.CheckMenuResponse;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.TokenValidate;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.TokenValidateResponse;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.ValidateToken;
import com.sunrise.boss.common.client.sso.Esop2CRMStub.ValidateTokenResponse;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.User;

 
/**
 * 
 * @author pmf , 2014-1
 *
 */
public class PublicService {
	public static Logger logger = Logger.getLogger(PublicService.class);
 
	private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
 
	private static HashMap<String, Esop2CRMStub> stubmap  ;
	
	private final static String UAP = "UAP";
	
	static{
		try {

			String urlstr = CoreConfigInfo.SSO_WEBSERVICE_URL;
			String[] urlarr = urlstr.split("\\|\\|");
			
			stubmap = new HashMap<String, Esop2CRMStub>();
			
			for(int i=0;i<urlarr.length;i++){
				String url = urlarr[i];
				Esop2CRMStub stub = new Esop2CRMStub(url);
				i++;
				String[] city = urlarr[i].split(",");
				for(int c=0;c<city.length;c++){
					stubmap.put(city[c], stub );
				}
				logger.info("多个鉴权服务地址："+urlarr[i]+"->"+url);
			}
			logger.info("鉴权服务初始化完成");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}
	
	/**
	 * 根据工号获取鉴权接口
	 * @param user
	 * @return
	 */
	public static Esop2CRMStub getStub(User user){
		Esop2CRMStub stub;
		stub = stubmap.get(user.getCityid());
		return stub;
	}

	/**
	 * 查询操作员是否合法登录，validateToken接口
	 * @param user
	 * @param tokenid
	 * @return
	 * @throws Exception
	 */
	public static boolean validateToken(User user,String tokenid) {
		// 票据验证开关
		if(!CoreConfigInfo.SSO_FLAG){
			user.setOprcode("test_user"); // 测试工号
			logger.info("票据验证未启用，默认放开！");
			return true;
		}
		logger.info("[ValidateToken]Start:system="+user.getSystem()+"&region="+user.getCityid()+"&token="+tokenid);
				
		ValidateToken token = new ValidateToken();
		token.setRegion(user.getCityid());
		token.setToken(tokenid);
		token.setSystem(UAP);
		
		Esop2CRMStub stub = getStub(user);
		ValidateTokenResponse resp;
		try {
			resp = stub.validateToken(token);
			AuthResult_type0 result = resp.getAuthResult();

			logger.info("[ValidateToken]Result:"+result.getAuthMsg());			
			//校验不通过
			if(!result.getAuthResult()){
				logger.error("该请求票据鉴权不通过，非法登录！");
				return false;
			}
			
			//校验通过后，获取工号
			user.setOprcode(result.getAccount());
			
			logger.info("操作员ID："+user.getOprcode()+","+user.getCityid()+"，成功登录！"); 
			return true;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}	
	
	/**
	 * 查询操作员是否合法登录，tokenValidate接口，被废弃
	 * @param user
	 * @param tokenid
	 * @return
	 * @throws Exception
	 */
	public static boolean tokenValidate(User user,String tokenid) {
		
		// 票据验证开关
		if(!CoreConfigInfo.SSO_FLAG){
			user.setOprcode("test_user"); // 测试工号
			logger.info("票据验证未启用，默认放开！");
			return true;
		}
		logger.info("[TokenValidate]Start:system="+user.getSystem()+",region="+user.getCityid()+",token="+tokenid);
		
		TokenValidate token = new TokenValidate();
		token.setRegion(user.getCityid());
		token.setToken(tokenid);
		token.setSystem(UAP);

		TokenValidateResponse resp;
		try {
			resp = getStub(user).tokenValidate(token);
			AuthResultToken_type0 result = resp.getAuthResultToken();
			
			logger.info("[TokenValidate]Result:"+result.getAuthmsg());	
			//校验不通过
			if(result.getAuthresult().equals("0")){
				logger.error("该请求票据鉴权不通过，非法登录！");
				return false;
			}
			
			//校验通过后，获取工号
			user.setOprcode(result.getAccount());
			
			logger.info("操作员ID："+user.getOprcode()+","+user.getCityid()+"，成功登录！"); 
			return true;
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}	
	
	/**
	 * 查询操作员是否有菜单的权限
	 * @param user
	 * @param menuid
	 * @return
	 * @throws Exception
	 */
	public static boolean checkMenu(User user,String menuid) {
		
		// 鉴权开关
		if(!CoreConfigInfo.MENU_FLAG){
			logger.info("菜单鉴权未启用，默认放开！");
			return true;
		}
		
		CheckMenu request = new CheckMenu();
		request.setResource("UAP");
		request.setPassword("cx123456");
		int i = randomSenven();
		request.setTransid(generateTransid(user.getCityid(),new Date(),i));//区域：+yyyymmddhhmmss+7位随机数 举例：756201108312107080000000
		request.setOprid(user.getOprcode());//操作员ID
		request.setMenuid(menuid);//菜单ID
		request.setRegion(user.getCityid());
		
		boolean result = false;
		try{
			CheckMenuResponse response = getStub(user).checkMenu(request);
			CheckMenuAuthResult_type0 res = response.getCheckMenuAuthResult();
			if("0".equals(res.getRspcode())){
				result = true;
			} 
		}catch (Exception e) {
			logger.error("【CheckMenu】菜单鉴权服务异常："+e.getMessage(), e);
		}
		
		logger.info("【CheckMenu】操作员ID："+user.getOprcode()+", 菜单ID："+ menuid +"->" + result);
		return result;
	}	
	
	private static int randomSenven(){
		 Random rdm=new Random();  
		return  rdm.nextInt(10000000);
	}
	
	private static String generateTransid(String city,java.util.Date date,int l)
	{
		String s = "0000000" + l;
		return city + formatter.format(date) + s.substring(s.length() - 7);
	}
	
	//-- for test 
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setCityid("757");
		user.setOprcode("fscz");
		System.out.println("-----1----" + new PublicService().getStub(user));
		System.out.println("-----2----" + new PublicService().validateToken(user, "ticket_1"));
		System.out.println("-----3----" + new PublicService().checkMenu(user, "UAP010101"));
	}
	
}
