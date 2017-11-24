package com.gmcc.pboss.biz.basic.dictItem.support.processor;

import org.hibernate.Query;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class DicItemQueryProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor {
	/**
	 * ���캯��
	 */
	public DicItemQueryProcessor() {
		paramEnclose = true; //ʹ�ò�����װ
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		return;
	}

	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		String [] rtn = {"restype"};
		return rtn;
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.support.DefaultHqlQueryProcessor#getHql()
	 */
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		return "select dictItem,category.restype from SaDbDictitem dictItem,ImPrComcategoryrela category " +
				"where dictItem.id.dictid = category.comcategory and dictItem.id.groupid = 'IM_FXCOMCATEGORY'";
//		return "select dictItem from SaDbDictitem dictItem,ImPrComcategoryrela category where dictItem.id.groupid = 'IM_FXCOMCATEGORY'";
		
	}

	public String getCntHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		return super.getCntHql(parameter);
	}
}
