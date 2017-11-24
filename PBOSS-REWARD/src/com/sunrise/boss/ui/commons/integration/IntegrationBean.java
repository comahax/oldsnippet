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
 * <br> Description: ���ڻ�ȡϵͳ������ز���, �绪Ϊ�����IP, �˿ڵ�.
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
	 * ��ȡ��Ϊ�����IP��ַ. ϵͳ������: huaweiIP 
	 * @return
	 */
	public String getHuaweiIP() {		
		String huaweiIP = null; //�����ݿ���ȡϵͳ����
		SysparamVO sysparamVO = getSysparamVOByName(PARAM_HuaweiIP);
		if( sysparamVO!=null) {
			huaweiIP = sysparamVO.getParamvalue();
		}		
		return huaweiIP;
	}
	
	/**
	 * ��ȡ��Ϊ����Ķ˿�. ϵͳ������: huaweiPort 
	 * @return
	 */
	public String getHuaweiPort() {
		String huaweiPort =  null ; //�����ݿ���ȡϵͳ����
		SysparamVO sysparamVO = getSysparamVOByName(PARAM_HuaweiPort);
		if( sysparamVO!=null) {
			huaweiPort = sysparamVO.getParamvalue();			
		}
		return huaweiPort;
	}
	
	/**
	 * ��ȡ��Ϊ�����web�����ĸ�. ϵͳ������: huaweiWebRoot 
	 * @return
	 */
	public String getHuaweiWebRoot() {
		String huaweiWebRoot = null; //�����ݿ���ȡϵͳ����
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
