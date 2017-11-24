package com.gmcc.pboss.biz.info.examine.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;

import com.gmcc.pboss.biz.info.examine.service.ChPwExmnRsltService;
import com.gmcc.pboss.biz.info.examine.support.ChPwExmnRsltQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.JSONKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.model.examine.ChPwExmnRslt;
import com.gmcc.pboss.model.examine.ChPwExmnStdDtl;

public class ChPwExmnRsltAction extends AbstractAction {

	private ChPwExmnRsltQueryParameter parameter;

	private ChPwExmnRsltService service;

	public QueryParameter getParameter() {

		parameter = parameter == null ? new ChPwExmnRsltQueryParameter() : parameter;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember member = getMember();

		parameter.setWayid(member.getWayid());

		return parameter;
	}

	public void setParameter(ChPwExmnRsltQueryParameter parameter) {
		this.parameter = parameter;
	}

	public ChPwExmnRsltService getService() {
		return service;
	}

	public void setService(ChPwExmnRsltService service) {
		this.service = service;
	}

	public void prepare() throws Exception {

	}

	public String doQuery() {

		LoginMember member = getMember();
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);

		writeJSONExamine(result);
		return null;
	}

	/**
	 * 
	 * дJSON�б���� - ����ΪServiceResult
	 * 
	 * @param serviceResult
	 */
	public void writeJSONExamine(ServiceResult serviceResult) {
		try {
			// Assert.notEmpty(args);
			QueryResult pageRslt = serviceResult.getRetResult();
			JSONObject jsonObject = new JSONObject();
			if (serviceResult.isSuccess()) {
				// ҵ��ɹ�
				List list = pageRslt.getData();
				List dataList = new java.util.ArrayList();

				Page page = pageRslt.getPage();
				// �Ƿ�ɹ�
				jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(serviceResult.isSuccess()));
				// ������
				jsonObject.put(JSONKey.RET_CODE, new Integer(serviceResult.getRetCode()));
				// ������Ϣ
				jsonObject.put(JSONKey.MESSAGE, serviceResult.getMessage());

				// ��д��ҳ����
				jsonObject.put(JSONKey.PAGE, page);
				// ��������
				Object value = null;
				double sum = 0;
				for (Iterator iter = list.iterator(); iter.hasNext();) {
					Map dataMap = new HashMap();
					ChPwExmnRslt element = (ChPwExmnRslt) iter.next();
					// ʱ��
					dataMap.put("exmnperiod", element.getExmnperiod());
					// ���˽��
					dataMap.put("exmnmark", element.getExmnmark());
					//�����ܷ�
					sum += element.getExmnmark().doubleValue();
					// ��ȡ��ϸ
					List dtl = new ArrayList(element.getDetails());
					List saveDtl = new ArrayList();// ��¼��ϸ
					int dtlSize = dtl.size();
					if (dtlSize>0){
						ChPwExmnStdDtl detail = (ChPwExmnStdDtl) dtl.get(0);
						// ��������
						dataMap.put("exmnname", detail.getExmnname());
					}
					for (int i = 0; i < dtlSize; i++) {
						Map dtlMap = new HashMap();
						ChPwExmnStdDtl detail = (ChPwExmnStdDtl) dtl.get(i);
						dtlMap.put("exmnstdname", detail.getExmnstdname());// ����
						dtlMap.put("exmnmark", detail.getExmnmark());// ��
						// ��¼��ϸ
						saveDtl.add(dtlMap);
					}// ��ϸ
					dataMap.put("dtlList", saveDtl);
					// �ŵ�List��
					dataList.add(dataMap);
				}//

				// ҳ������
				jsonObject.put(JSONKey.DATAS, JSONArray.fromObject(dataList));
				//�ܷ�
				jsonObject.put("allMark", new Double(sum));
			} else {
				// ҵ�������ʾ������Ϣ
				jsonObject = this.writeJSONServiceError(serviceResult);
			}
			renderHtml(jsonObject.toString());
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}

	private Object getProperty(Object element, String propertyName) {

		Object rtn = "";
		try {
			Object value = PropertyUtils.getProperty(element, "exmnperiod");
			if (value != null) {
				rtn = value;
			} else {
				logger.warn(element.getClass().getName() + "." + propertyName + "is Null");
			}
		} catch (Exception e) {
			logger.error("Myerror:" + element.getClass().getName() + " get " + propertyName + " has error!\n" + e.getMessage());
		}
		return rtn;

	};

	public String doList() {
		this.setTitle(PageLoction.ExamineList);
		return super.doList();
	}

}
