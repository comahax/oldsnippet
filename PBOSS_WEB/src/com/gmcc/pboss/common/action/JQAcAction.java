package com.gmcc.pboss.common.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.node.service.DbBankService;
import com.gmcc.pboss.biz.info.node.support.DbBankQueryParameter;
import com.gmcc.pboss.biz.info.reward.model.BbcOperation;
import com.gmcc.pboss.biz.info.reward.model.Operation;
import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.support.OperationQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.Code;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.JQACKey;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.wayapply.SaDbBank;

public class JQAcAction extends AbstractAction {

	private static final Log logger = LogFactory.getLog(JQAcAction.class);
	public String query;
	public String limit;
	public String format;
	public String type;

	// ��ѯҵ�����
	private OperationService operation;
	private OperationService bbcOperationService;
	
	/**
	 * ���б�ʶ
	 */
	private DbBankService dbBankService; 

	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	public String doQuery() {
		// �ֹ�¼������
		// List rtn = new ArrayList();
		// rtn.add(new Code("1","aaa"));
		// rtn.add(new Code("2","abc"));
		// rtn.add(new Code("3","bbb"));
		// ��дJSON
		// ͨ��ҵ���ѯ�������ȵ�¼
		LoginMember member = this.getMember();
		List<Code> rtn = new ArrayList<Code>();
		// ����ֵ
		ServiceResult result = null;
		if (JQACKey.OPERATION.equals(type) || JQACKey.BBCOPERATION.equals(type)) {
			// ȡҵ�����
			OperationQueryParameter parameter = new OperationQueryParameter();
			// ��װ��ѯ����
			int limit = 20;// Ĭ��20��
			parameter.setQuery(this.getQuery());
			if (StringUtils.isNumeric(this.getLimit())) {
				limit = Integer.parseInt(this.getLimit());
				parameter.setLimit(limit);
			}

			if (JQACKey.OPERATION.equals(type)) {// 
				// �������ҵ�����
				result = operation.transact(member, parameter, ServiceType.QUERY);
				// ��װList
				List<Operation> datas = result.getRetResult().getData();
				int size = datas.size();
				for (int i = 0; i < size; i++) {
					if (i >= limit)
						break;
					// ��ȡ��ϸ
					Operation a = datas.get(i);
					Code s = new Code(a.getOpnid(), a.getName());
					rtn.add(s);
				}
			} else if (JQACKey.BBCOPERATION.equals(type)) {
				// b2m--��վ����ҵ�����
				result = bbcOperationService.transact(member, parameter, ServiceType.QUERY);
				// ��װList
				List<BbcOperation> datas = result.getRetResult().getData();
				int size = datas.size();
				for (int i = 0; i < size; i++) {
					if (i >= limit)
						break;
					// ��ȡ��ϸ
					BbcOperation a = (BbcOperation) datas.get(i);
					Code s = new Code(a.getOpnid(), a.getName());
					rtn.add(s);
				}

			}
		}else if (JQACKey.DBBank.equals(type)){
			// ȡ���б�ʶ
			DbBankQueryParameter parameter = new DbBankQueryParameter();
			// ���๺���������б�ʶ
			result = this.dbBankService.transact(member, parameter,ServiceType.QUERY);
			Map<String,String> dbBankItems = (Map<String, String>) result.getRetObject();

			Iterator<Entry<String,String>> it = dbBankItems.entrySet().iterator();
			//��װ����ֵ
			while(it.hasNext()){
				Entry<String,String> entry = it.next();
	            String key = entry.getKey();
				Code s = new Code(key, entry.getValue());
				rtn.add(s);
			}//while
		} else {
			// û��
			result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage("û�в�ѯ��ҵ��!");
		}

		if (!result.isSuccess()) {
			// ����
			renderHtml(writeJSONServiceError(result).toString());
		} else {
			// JSONObject jsonObject = new JSONObject();
			//

			// ��дJSON
			JSONArray jsonObject = JSONArray.fromObject(rtn);
			renderHtml(jsonObject.toString());
		}
		return null;
	}

	public void prepare() throws Exception {
		// System.out.println("����֮ǰ");
	}

	/**
	 * @return the query
	 * @throws
	 */
	public String getQuery() {
//		logger.info(">>>>JQAC��ѯ>>ת��ǰ��"+query);
//		try {
//			String rtn = new String(query.getBytes("ISO-8859-1"), "UTF-8");
//			logger.info(">>>>JQAC��ѯ>>ת����"+query);
//			return rtn;
//		} catch (UnsupportedEncodingException e) {
//			logger.error(">>ת������>>"+e.getMessage());
//		}

		logger.info(">>>>ʹ��JQuery AC��ѯ>>>>��"+query);
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the operation
	 */
	public OperationService getOperation() {
		return operation;
	}

	/**
	 * @param operation
	 *            the operation to set
	 */
	public void setOperation(OperationService operation) {
		this.operation = operation;
	}

	/**
	 * @return the bbcOperationService
	 */
	public OperationService getBbcOperationService() {
		return bbcOperationService;
	}

	/**
	 * @param bbcOperationService
	 *            the bbcOperationService to set
	 */
	public void setBbcOperationService(OperationService bbcOperationService) {
		this.bbcOperationService = bbcOperationService;
	}

	/**
	 * @return the dbBankService
	 */
	public DbBankService getDbBankService() {
		return dbBankService;
	}

	/**
	 * @param dbBankService the dbBankService to set
	 */
	public void setDbBankService(DbBankService dbBankService) {
		this.dbBankService = dbBankService;
	}

}
