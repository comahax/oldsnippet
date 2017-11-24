package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.model.BbcOperation;
import com.gmcc.pboss.biz.info.reward.support.OperationQueryParameter;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;

public class BbcOperationServiceImpl extends OperationServiceImpl implements OperationService {

	// ���������� ҵ���������
	protected Map<String,BbcOperation> cache = new LinkedHashMap<String,BbcOperation>();
	
	// ���� query ��ƥ��ҵ�����,���� ��� limit ����¼
	protected QueryResult getQueryResult(final OperationQueryParameter parameter) {

		List<BbcOperation> data = new ArrayList<BbcOperation>();

		for (Iterator<BbcOperation> iter = cache.values().iterator(); iter.hasNext();) {
			BbcOperation opn = (BbcOperation) iter.next();
			String query = parameter.getQuery();
			
			if (StringUtils.isEmpty(query)) query = "";
			if (opn.getName().toLowerCase().indexOf(parameter.getQuery().toLowerCase()) > -1) {
				data.add(opn);
			}
		}

		Collections.sort(data, new Comparator<BbcOperation>() {

			public int compare(BbcOperation o1, BbcOperation o2) {
				String n1 = o1.getName().toLowerCase();
				String n2 = o2.getName().toLowerCase();

				if (n1.indexOf(parameter.getQuery()) > n2.indexOf(parameter.getQuery())) {
					return 1;
				} else if (n1.indexOf(parameter.getQuery()) > n2.indexOf(parameter.getQuery())) {
					return -1;
				}
				return 0;
			}
		});

		return new QueryResult(Page.EMPTY, data.size() > parameter.getLimit() ? data.subList(0, parameter.getLimit()) : data);
	}

	// ��ʼ�� ��������
	public void init() {
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		int retCode = ServiceRetCode.FAIL;
		String serviceCode = ServiceCode.COMMON;
		String msg = ConfigUtil.getMessage(serviceCode, retCode	);
		
		try {
			List<BbcOperation> opnLst = getBBCOperationCode();
			//û�ܷ���������ջ���
			this.clear();
			for (BbcOperation operation:opnLst) {
				cache.put(operation.getOpnid(), operation);
			}
			
			retCode = ServiceRetCode.SUCCESS;
			msg = ConfigUtil.getMessage(serviceCode, retCode);
		} 
		catch (RuntimeException e) {
			// TODO Auto-generated catch block
			retCode = ServiceRetCode.EXCEPTION;
			msg = CommonUtil.createExceptionString(e);
			e.printStackTrace();
			logger.error("�������ҵ�������ȡʧ��:"+e.getMessage());
		}
		Log.cacheLog("BbcOperationService","��վ����ҵ�����",msg);
	}
	
	public List<BbcOperation> getBBCOperationCode(){
		//������
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		return getDao().getAll();
	}

	public String getOperationName(String opnId) {
		if (cache.containsKey(opnId)) {
			return ((BbcOperation) cache.get(opnId)).getName();
		}
		return "";
	}

}
