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

	// ���������� ҵ���������
	protected Map<String,SaDbBank> cache = new LinkedHashMap<String,SaDbBank>();
	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(DbBankServiceImpl.class);

	public DbBankServiceImpl() {
		this.isNeedLogin = true;
		this.serviceCode = ServiceCode.DBBank;
		this.serviceName = "���๺���������б�ʶ����";
		setProcessor(new DbBankQueryProcessor());
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
		Iterator<Entry<String, SaDbBank>> it = cache.entrySet().iterator(); 
        while (it.hasNext()) { 
            Entry<String, SaDbBank> entry = it.next(); 
            String key = entry.getKey(); 
            SaDbBank value = (SaDbBank)entry.getValue(); 
            t.put(key, value.getBankname());
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
			List<SaDbBank> dbBankItems = getDbBankItems();

			//û�ܷ���������ջ���
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
			logger.error("���б�ʶ��ȡʧ��:"+e.getMessage());
		}
		
		if(cache.size() != 0){
			retCode = ServiceRetCode.SUCCESS;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		else{
			retCode = ServiceRetCode.EMPTY;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		}
		Log.cacheLog("DictItemService","���б�ʶ",msg);
	}
	
	public List<SaDbBank> getDbBankItems(){
		//������
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		return getDao().getAll();
	}
	// �� quartz �����ã�ÿ���賿1�����, �������òο� applicationContext-quartz.xml
	public void refresh() {
//		clear();
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>���б�ʶˢ��");
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
			return (cache.get(opnId)).getBankname();
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
			return ((SaDbBank) cache.get(opnId)).getBrandName();
		}
		return "";
	}
}
