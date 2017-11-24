package com.gmcc.pboss.common.constant.service;

import java.util.Map;

import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.CacheService;
import com.gmcc.pboss.model.constant.ChPwCntycompany;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-22
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public interface ConstantService extends BaseService, CacheService{
	/**
	 * 获得固定参数名称
	 * @param groupid
	 * 			固定参数标识
	 * @param dictid
	 * 			固定参数key
	 * @return
	 * 			dictName
	 */
	public String getConstantName(String groupid, String dictid);
	
	/**
	 * 获得固定参数表示为groupid的集合
	 * @param groupid
	 * 			固定参数标识
	 * @return
	 * 			Map<dictid,dictname>
	 */
	public Map<String, String> getConstantMap(String groupid);
	
	/**
	 * 按代码返回地市子公司的名称
	 * @param companycode 代码
	 * @return 名称
	 */
	public String getCntcompanyName(String companycode);
	
	/**
	 * 按地市标识提取地市分公司
	 * @param cityid 地市标识
	 * @return
	 */
	public Map<String,ChPwCntycompany> getBranchCntyComps(String cityid);
}
