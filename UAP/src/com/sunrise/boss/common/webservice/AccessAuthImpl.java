package com.sunrise.boss.common.webservice;

import javax.jws.WebService;

import org.apache.log4j.Logger;


import com.sunrise.boss.business.common.loginlog.persistent.LoginLogDBParam;
import com.sunrise.boss.business.common.loginlog.persistent.LoginLogVO;

import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.commoncontrol.CommonControl;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * @author qhb
 * webservices 外部请求处理
 */
@WebService(serviceName="Zw2UapSoap",
			endpointInterface="com.sunrise.boss.common.webservice.AccessAuth",
			targetNamespace="http://www.gmcc.net/Esop2CRM/")
public class AccessAuthImpl implements AccessAuth{
	
	private static final Logger logger = Logger.getLogger(AccessAuthImpl.class);
	/**
	 * @author qhb
	 * @param region 区域
	 * @param token 请求的ticket 格式：logid|staffid  9032|fscz
	 * @param system 外部请求的系统标识
	 * @return RetResult	
	 */
	public RetResult receiveRequestToken(String region,String token,String system) {
		// TODO Auto-generated method stub
		CommonControl delegate=null;
		RetResult ret = new RetResult();
		try {
			DBAccessUser user = new DBAccessUser();
			user.setDbFlag(DBConstant.DB_FLAG_COMMON);
			delegate = (CommonControl) BOFactory.build(CommonBO.class,user);
			
			delegate.setVoClass(LoginLogVO.class);
			LoginLogDBParam param = new LoginLogDBParam();
			String temp[] = {};
			if(token != null && token.length() > 0) 
			{
				temp = StringUtils.split(token, "|");
				logger.info("获取请求访问鉴权信息："+token);
				logger.info("获取请求地区："+region);
				logger.info("获取外部请求系统："+system);				
			
				param.set_ne_logid(temp[0]);
				param.set_se_staffid(temp.length>1?temp[1]:"");			
				param.set_ne_result("1");
				param.set_orderby("logid");
				param.set_desc("1");
				param.setDataOnly(true);
			}
			
			DataPackage dp = delegate.doQuery(param);
			// 组装返回报文
			if(dp!= null && dp.getDatas()!=null && dp.getDatas().size()>0){
				LoginLogVO vo =(LoginLogVO) dp.getDatas().get(0);
				token = vo.getLogid()+"|"+vo.getStaffid();
				ret.setAccount(vo.getStaffid());				
				ret.setAuthResult(true);
				ret.setIdsTokenName("ZW访问令牌");
				ret.setIdsTokenValue(token);				
				ret.setAuthMsg("成功");
			}else{				
				ret.setAccount(temp.length>1 ? temp[1]:"");				
				ret.setAuthResult(false);
				ret.setIdsTokenName("ZW访问令牌");
				ret.setIdsTokenValue(token);				
				ret.setAuthMsg("错误");
			}
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return ret;
		
	}
	

}
