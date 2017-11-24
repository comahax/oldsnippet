package com.sunrise.boss.common.client.menutoken;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.apache.log4j.Logger;

import com.sunrise.boss.common.client.menutoken.PermissionServiceStub.CheckMenu;
import com.sunrise.boss.common.client.menutoken.PermissionServiceStub.CheckMenuResponse;
import com.sunrise.boss.common.client.menutoken.PermissionServiceStub.CheckToken;
import com.sunrise.boss.common.client.menutoken.PermissionServiceStub.CheckTokenResponse;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.User;
 

public class PublicService {
	public static Logger logger = Logger.getLogger(PublicService.class);
 
	private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
 
	private static HashMap<String, PermissionServiceStub> stubmap  ;
	
	
	static{
		try {

			String token_url = CoreConfigInfo.TOKEN_WEBSERVICE_URL;
			String[] tokens = token_url.split("\\|\\|");
			
			stubmap = new HashMap<String, PermissionServiceStub>();
			
			for(int i=0;i<tokens.length;i++){
				String url = tokens[i];
				PermissionServiceStub stub = new PermissionServiceStub(url);
				i++;
				String[] city = tokens[i].split(",");
				for(int c=0;c<city.length;c++){
					stubmap.put(city[c], stub );
				}
				logger.info("多个鉴权接口地址："+tokens[i]+"->"+url);
			}
			logger.info("鉴权接口初始化完成");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
	/**
	 * 根据工号获取鉴权接口
	 * @param user
	 * @return
	 */
	public static PermissionServiceStub getStub(User user){
		PermissionServiceStub stub;
		stub = stubmap.get(user.getCityid());
		return stub;
	}
	
	
	/**
	 * 查询操作员是否有令牌的权限
	 * @param user
	 * @param tokenid
	 * @return
	 * @throws Exception
	 */
	public static boolean checkToken(User user,String tokenid) {
		logger.info("操作员ID："+user.getOprcode()+", 令牌ID："+tokenid);
		// 令牌鉴权开关
		if(!CoreConfigInfo.TOKEN_FLAG){
			logger.info("令牌鉴权未启用，默认放开！");
			return true;
		}
		
		CheckToken request = new CheckToken();
		request.setResource("UAP");
		request.setPassword("cx123456");
		int i = randomSenven();
		request.setTransid(generateTransid(user.getCityid(),new Date(),i));//区域：+yyyymmddhhmmss+7位随机数 举例：756201108312107080000000
		request.setOprid(user.getOprcode());//操作员ID
		request.setTokenid(tokenid);//令牌ID
		request.setRegion(user.getCityid()); //新增地市标识
		
		boolean result = false;
		
		try{
			CheckTokenResponse response = getStub(user).checkToken(request);
			logger.info("CRM鉴权返回状态："+response.getRspcode());
			if("0".equals(response.getRspcode())){
				result = true;
			} 
		}catch (Exception e) {
			logger.error("【CheckToken】令牌鉴权服务异常："+e.getMessage(), e);
		}
		
		logger.info("【CheckToken】操作员ID："+user.getOprcode()+", 令牌ID："+tokenid +"->" + result);
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
	
	
	/**
	 * 查询操作员是否有菜单的权限
	 * @param user
	 * @param menuid
	 * @return
	 * @throws Exception
	 */
	public static boolean checkMenu(User user,String menuid) {
		logger.info("操作员ID："+user.getOprcode()+", 菜单ID：" + menuid);
		// 鉴权开关
		if(!CoreConfigInfo.TOKEN_FLAG){
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
		
		boolean result = false;
		try{
			CheckMenuResponse response = getStub(user).checkMenu(request);
			if("0".equals(response.getRspcode())){
				result = true;
			} 
		}catch (Exception e) {
			logger.error("【CheckMenu】菜单鉴权服务异常："+e.getMessage(), e);
		}
		
		logger.info("【CheckMenu】操作员ID："+user.getOprcode()+", 菜单ID："+ menuid +"->" + result);
		return result;
	}	

	//-- for test 
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setCityid("756");
		user.setOprcode("bbq");
		System.out.println("-----1" + new PublicService().getStub(user));
		System.out.println("-----token" + new PublicService().checkToken(user, "123"));
		
		System.out.println("-----menu" + new PublicService().checkMenu(user, "123"));
	}
	
}
