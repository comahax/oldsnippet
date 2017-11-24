package com.gmcc.pboss.biz.basic.dictItem.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.biz.basic.dictItem.model.DictItem;
import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.model.constant.SaDbDictitem;
import com.gmcc.pboss.biz.basic.dictItem.dao.DictItemDao;

public class DictItemServiceImpl extends BaseServiceImpl implements DictItemService {

	// 服务器缓存 业务编码数据
	protected Map<String,DictItem> cache = new LinkedHashMap<String,DictItem>();
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(DictItemServiceImpl.class);

	public DictItemServiceImpl() {
		this.isNeedLogin = true;
		this.serviceCode = ServiceCode.DICTITEM;
		this.serviceName = "商品种类";
		setProcessor(new DefaultQueryParameterProcessor());
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
		Iterator<Entry<String, DictItem>> it = cache.entrySet().iterator(); 
        while (it.hasNext()) { 
            Entry<String, DictItem> entry = it.next(); 
            String key = entry.getKey(); 
            DictItem value = (DictItem)entry.getValue(); 
            t.put(key, value.getName());
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
			List<SaDbDictitem> dictItems = getDictItems();

			//没能发生错误，清空缓存
			this.clear();
			for (SaDbDictitem dictItem: dictItems) {
				DictItem saveObj = new DictItem(dictItem.getId().getDictid(),dictItem.getDictname(),(String)dictItem.getDatas().get("restype"));
				cache.put(saveObj.getCode(), saveObj);
			}
		} 
		catch (RuntimeException e) {
			// TODO Auto-generated catch block
			retCode = ServiceRetCode.EXCEPTION;
			msg = CommonUtil.createExceptionString(e);
			
			e.printStackTrace();
			logger.error("商品种类提取失败:"+e.getMessage());
		}
		
		if(cache.size() != 0){
			retCode = ServiceRetCode.SUCCESS;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		else{
			retCode = ServiceRetCode.EMPTY;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		Log.cacheLog("DictItemService","商品种类",msg);
	}
	
	public List<SaDbDictitem> getDictItems(){
		//公共库
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		return getDao().getAll();
	}
	// 在 quartz 中配置，每天凌晨1点调用, 具体配置参考 applicationContext-quartz.xml
	public void refresh() {
//		clear();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>商品类型刷新");
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
			return ((DictItem) cache.get(opnId)).getName();
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
			return ((DictItem) cache.get(opnId)).getType();
		}
		return "";
	}

	/**
	 * 通过业务代码判断是否套卡
	 * 
	 * @param opnId 业务代码
	 * @return 是套卡
	 */
	public boolean isComrescard(String opnId) {
		String restype = this.getTypeByCode(opnId);
		return ConstantsType.COMRESCARD.equals(restype);
	}
	
	//查询IM_PR_COMCATEGORYRELA表，获取商品种类-资源类别组合
	//key-商品种类，value-资源列别
	public Map<String,String> getComcatoAndRestype(){
		DictItemDao dictItemDao = (DictItemDao)this.getDao();
		return dictItemDao.getComcatoAndRestype();
	}
}
