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

	// ���������� ҵ���������
	protected Map<String,DictItem> cache = new LinkedHashMap<String,DictItem>();
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(DictItemServiceImpl.class);

	public DictItemServiceImpl() {
		this.isNeedLogin = true;
		this.serviceCode = ServiceCode.DICTITEM;
		this.serviceName = "��Ʒ����";
		setProcessor(new DefaultQueryParameterProcessor());
	}
	/**
	 * ��ҵ���߼������������б������������б�
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);

//		Map queryResult = getQueryResult((DictItemQueryParameter) parameter);

		result.setRetResult(null);
		//��װCache
		Map<String,String> t = new LinkedHashMap<String,String>();
		Iterator<Entry<String, DictItem>> it = cache.entrySet().iterator(); 
        while (it.hasNext()) { 
            Entry<String, DictItem> entry = it.next(); 
            String key = entry.getKey(); 
            DictItem value = (DictItem)entry.getValue(); 
            t.put(key, value.getName());
        }

		//��Object����
		result.setRetObject(t);
		
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		return result;
	}


	// ��ʼ�� ��������
	public void init() {
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		int retCode = ServiceRetCode.FAIL;
		String serviceCode = ServiceCode.COMMON;
		String msg = ConfigUtil.getMessage(serviceCode, retCode	);
		
		try {
			List<SaDbDictitem> dictItems = getDictItems();

			//û�ܷ���������ջ���
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
			logger.error("��Ʒ������ȡʧ��:"+e.getMessage());
		}
		
		if(cache.size() != 0){
			retCode = ServiceRetCode.SUCCESS;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		else{
			retCode = ServiceRetCode.EMPTY;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		Log.cacheLog("DictItemService","��Ʒ����",msg);
	}
	
	public List<SaDbDictitem> getDictItems(){
		//������
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		return getDao().getAll();
	}
	// �� quartz �����ã�ÿ���賿1�����, �������òο� applicationContext-quartz.xml
	public void refresh() {
//		clear();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>��Ʒ����ˢ��");
		init();
	}

	public void clear() {
		cache.clear();
	}

	/**
	 * ͨ��ҵ�����ӻ�����ȡ��ҵ�����Ʒ���
	 * 
	 * @param opnId ҵ�����
	 * @return ҵ������
	 */
	public String getNameByCode(String opnId) {
		if (cache.containsKey(opnId)) {
			return ((DictItem) cache.get(opnId)).getName();
		}
		return "";
	}

	/**
	 * ͨ��ҵ�����ӻ�����ȡ��ҵ�������
	 * 
	 * @param opnId ҵ�����
	 * @return ҵ������
	 */
	public String getTypeByCode(String opnId) {
		if (cache.containsKey(opnId)) {
			return ((DictItem) cache.get(opnId)).getType();
		}
		return "";
	}

	/**
	 * ͨ��ҵ������ж��Ƿ��׿�
	 * 
	 * @param opnId ҵ�����
	 * @return ���׿�
	 */
	public boolean isComrescard(String opnId) {
		String restype = this.getTypeByCode(opnId);
		return ConstantsType.COMRESCARD.equals(restype);
	}
	
	//��ѯIM_PR_COMCATEGORYRELA����ȡ��Ʒ����-��Դ������
	//key-��Ʒ���࣬value-��Դ�б�
	public Map<String,String> getComcatoAndRestype(){
		DictItemDao dictItemDao = (DictItemDao)this.getDao();
		return dictItemDao.getComcatoAndRestype();
	}
}
