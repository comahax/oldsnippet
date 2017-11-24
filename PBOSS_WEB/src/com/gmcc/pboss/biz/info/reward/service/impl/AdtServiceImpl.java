package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.biz.info.reward.model.AdtCode;
import com.gmcc.pboss.biz.info.reward.service.AdtService;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;

public class AdtServiceImpl implements AdtService {

	private BaseDao dao;

	protected Map<String,String> cache = new LinkedHashMap<String, String>();
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(AdtServiceImpl.class);

	public void clear() {
		cache.clear();
	}

	public void init() {
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		int retCode = ServiceRetCode.FAIL;
		String serviceCode = ServiceCode.COMMON;
		String msg = ConfigUtil.getMessage(serviceCode, retCode	);
		
		try {
			List<AdtCode> adtCodeLst = getAdtCode();

			//没能发生错误，清空缓存
			this.clear();
			for (AdtCode code:adtCodeLst) {
				cache.put(code.getAdtcode(), code.getAdtremark());
			}
		} 
		catch (RuntimeException e) {
			// TODO Auto-generated catch block
			retCode = ServiceRetCode.EXCEPTION;
			msg = CommonUtil.createExceptionString(e);
			
			e.printStackTrace();
			logger.error("酬金错误代码提取失败:"+e.getMessage());
		}
		
		if(cache.size() != 0){
			retCode = ServiceRetCode.SUCCESS;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		else{
			retCode = ServiceRetCode.EMPTY;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		Log.cacheLog("AdtService","酬金错误代码",msg);
	}
	
	public List<AdtCode> getAdtCode(){
		//公共库
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		return getDao().getAll();
	}
	public void refresh() {
//		clear();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>酬金错误代码刷新");
		init();
	}

	public String getRemark(String code) {
		if (cache.containsKey(code)) {
			return (String) cache.get(code);
		}
		return "";
	}

	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

}
