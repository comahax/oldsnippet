/**
 * @author He Kun (Henry He), Guangzhou, China
 * Oct 12, 2006
 */
package com.sunrise.boss.ui.commons.integration;

import java.util.List;

import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * IntegrationUtil
 * <br> Description: 用于获取系统集成相关参数, 如华为程序的IP, 端口等.
 * <br> Company: Maywide,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * Oct 12, 2006
 */
public class IntegrationBean {	
	private User user;
	
	public static final String PARAM_HuaweiIP = "huaweiIP";
	public static final String PARAM_HuaweiPort = "huaweiPort";
	public static final String PARAM_HuaweiWebRoot = "huaweiWebRoot";	
	/**
	 * 
	 */
	public IntegrationBean(User user) {		
		this.user = user;
	}
	
	/**
	 * 获取华为程序的IP地址. 系统参数名: huaweiIP 
	 * @return
	 */
	public String getHuaweiIP() {		
		String huaweiIP = null; //从数据库中取系统参数
		SysparamVO sysparamVO = getSysparamVOByName(PARAM_HuaweiIP);
		if( sysparamVO!=null) {
			huaweiIP = sysparamVO.getParamvalue();
		}		
		return huaweiIP;
	}
	
	/**
	 * 获取华为程序的端口. 系统参数名: huaweiPort 
	 * @return
	 */
	public String getHuaweiPort() {
		String huaweiPort =  null ; //从数据库中取系统参数
		SysparamVO sysparamVO = getSysparamVOByName(PARAM_HuaweiPort);
		if( sysparamVO!=null) {
			huaweiPort = sysparamVO.getParamvalue();			
		}
		return huaweiPort;
	}
	
	/**
	 * 获取华为程序的web上下文根. 系统参数名: huaweiWebRoot 
	 * @return
	 */
	public String getHuaweiWebRoot() {
		String huaweiWebRoot = null; //从数据库中取系统参数
		SysparamVO sysparamVO = getSysparamVOByName(PARAM_HuaweiWebRoot);
		if( sysparamVO!=null) {
			huaweiWebRoot = sysparamVO.getParamvalue();			
		}
		return huaweiWebRoot;
	}
	
	
	private SysparamVO getSysparamVOByName(String name) {
		try {
			SysparamDelegate delegate = new SysparamDelegate();
			SysparamListVO listVO = new SysparamListVO();
			listVO.getQueryConditions().put("_se_paramname",name);
			List list = (List)delegate.doQuery(listVO, user ).getDatas();
			
			SysparamVO retVO = (SysparamVO)(list.size() > 0 ? list.get(0) : null);			
			return retVO;
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return null;
	}	
}
