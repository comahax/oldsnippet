package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.biz.info.reward.model.Operation;
import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.support.OperationQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.DefaultQueryParameterProcessor;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.CommonUtil;
import com.gmcc.pboss.member.service.MemberServiceRetCode;

public class OperationServiceImpl extends BaseServiceImpl implements OperationService {

	// ���������� ҵ���������
	protected Map<String,Operation> cache = new LinkedHashMap<String,Operation>();

	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(OperationServiceImpl.class);
	
	public OperationServiceImpl() {
		this.isNeedLogin = true;
		this.serviceCode = ServiceCode.OPERATION;
		this.serviceName = "ҵ�����";
		setProcessor(new DefaultQueryParameterProcessor());
	}

	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(MemberServiceRetCode.FAIL);

		QueryResult queryResult = getQueryResult((OperationQueryParameter) parameter);

		result.setRetResult(queryResult);

		result.setRetObject(member);
		result.setSuccess(true);
		result.setRetCode(MemberServiceRetCode.SUCCESS);
		return result;
	}

	// ���� query ��ƥ��ҵ�����,���� ��� limit ����¼
	protected QueryResult getQueryResult(final OperationQueryParameter parameter) {

		List<Operation> data = new ArrayList<Operation>();

		for (Iterator<Operation> iter = cache.values().iterator(); iter.hasNext();) {
			Operation opn = (Operation) iter.next();
			String query = parameter.getQuery();
			if (StringUtils.isEmpty(query)) query = "";
			if (opn.getName()!=null && opn.getName().toLowerCase().indexOf(query.toLowerCase()) > -1) {
				data.add(opn);
			}
		}

		Collections.sort(data, new Comparator<Operation>() {
			public int compare(Operation o1, Operation o2) {
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
			List<Operation> operationList = getOperationCode();
			//û�ܷ���������ջ���
			this.clear();
			for (Operation operation:operationList) {
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
		Log.cacheLog("OperationService","�������ҵ�����",msg);
	}
	
	public List<Operation> getOperationCode(){
		//������
		SessionFactoryContextHolder.setSessionFactoryContext(null);
		
		return getDao().getAll();
	}

	// �� quartz �����ã�ÿ���賿1�����, �������òο� applicationContext-quartz.xml
	public void refresh() {
		//��¼��־
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ҵ�����ˢ��");
		init();
	}

	public void clear() {
		cache.clear();
	}

	public String getOperationName(String opnId) {
		if (cache.containsKey(opnId)) {
			return ((Operation) cache.get(opnId)).getName();
		}
		return "";
	}

}
