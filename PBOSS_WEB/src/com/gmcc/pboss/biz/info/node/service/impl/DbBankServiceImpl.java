package com.gmcc.pboss.biz.info.node.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.biz.info.node.service.DbBankService;
import com.gmcc.pboss.biz.info.node.support.processor.DbBankQueryProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.model.wayapply.SaDbBank;


public class DbBankServiceImpl extends BaseServiceImpl implements DbBankService {

	// 服务器缓存 业务编码数据
	protected Map<String,SaDbBank> cache = new LinkedHashMap<String,SaDbBank>();
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(DbBankServiceImpl.class);

	public DbBankServiceImpl() {
		this.isNeedLogin = true;
		this.serviceCode = ServiceCode.DBBank;
		this.serviceName = "卡类购销划扣银行标识加载";
		setProcessor(new DbBankQueryProcessor());
	}
	/**
	 * 按业务逻辑，返回整个列表，以生成下拉列表
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);

//		Map queryResult = getQueryResult((DictItemQueryParameter) parameter);

		result.setRetResult(null);
		//封装Cache
		Map<String,String> t = new LinkedHashMap<String,String>();
		Iterator<Entry<String, SaDbBank>> it = cache.entrySet().iterator(); 
        while (it.hasNext()) { 
            Entry<String, SaDbBank> entry = it.next(); 
            String key = entry.getKey(); 
            SaDbBank value = (SaDbBank)entry.getValue(); 
            t.put(key, value.getBankname());
        }

		//以Object返回
		result.setRetObject(t);
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}


	// 初始化 缓存数据
	public void init() {
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		int retCode = ServiceRetCode.FAIL;
		String serviceCode = ServiceCode.COMMON;
		String msg = ConfigUtil.getMessage(serviceCode, retCode	);
		
		try {
			List<SaDbBank> dbBankItems = getDbBankItems();

			//没能发生错误，清空缓存
			this.clear();
			for (SaDbBank dbBank: dbBankItems) {
				cache.put(dbBank.getBankid(), dbBank);
			}
		} 
		catch (RuntimeException e) {
			// TODO Auto-generated catch block
			retCode = ServiceRetCode.EXCEPTION;
			msg = CommonUtil.createExceptionString(e);
			
			e.printStackTrace();
			logger.error("银行标识提取失败:"+e.getMessage());
		}
		
		if(cache.size() != 0){
			retCode = ServiceRetCode.SUCCESS;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		else{
			retCode = ServiceRetCode.EMPTY;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		Log.cacheLog("DictItemService","银行标识",msg);
	}
	
	public List<SaDbBank> getDbBankItems(){
		//公共库
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		return getDao().getAll();
	}
	// 在 quartz 中配置，每天凌晨1点调用, 具体配置参考 applicationContext-quartz.xml
	public void refresh() {
//		clear();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>银行标识刷新");
		init();
	}

	public void clear() {
		cache.clear();
	}

	/**
	 * 通过业务代码从缓存中取得业务名称返回
	 * 
	 * @param opnId 业务代码
	 * @return 业务名称
	 */
	public String getNameByCode(String opnId) {
		if (cache.containsKey(opnId)) {
			return (cache.get(opnId)).getBankname();
		}
		return "";
	}

	/**
	 * 通过业务代码从缓存中取得业务的类型
	 * 
	 * @param opnId 业务代码
	 * @return 业务类型
	 */
	public String getTypeByCode(String opnId) {
		if (cache.containsKey(opnId)) {
			return ((SaDbBank) cache.get(opnId)).getBrandName();
		}
		return "";
	}
}
