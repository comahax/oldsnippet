package com.gmcc.pboss.test.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.Code;
import com.gmcc.pboss.common.dictionary.JSONKey;
import com.gmcc.pboss.common.support.QueryParameter;

@SuppressWarnings("serial")
public class TestAction extends AbstractAction {

	public String query;
	public String btest;
	
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the btest
	 */
	public String getBtest() {
		return btest;
	}

	/**
	 * @param btest the btest to set
	 */
	public void setBtest(String btest) {
		this.btest = btest;
	}

	public String doQuery(){
		//�ֹ�¼������
		List<Code> rtn = new ArrayList<Code>();
		rtn.add(new Code("1","aaa"));
		rtn.add(new Code("2","abc"));
		rtn.add(new Code("3","bbb"));
		//��дJSON
//		JSONObject jsonObject = new JSONObject();
		JSONArray jsonList = JSONArray.fromObject(rtn);

		JSONObject jsonObject = new JSONObject();
		// �Ƿ�ɹ�
		jsonObject.put("isSuccess", Boolean.valueOf(true));
		//
		jsonObject.put("datas", jsonList);
//		jsonObject.put("isSuccess", Boolean.valueOf(false));
//		//
//		jsonObject.put("message", "�ڲ�����");
		renderHtml(jsonObject.toString());
		return null;
	}
	
	public void prepare() throws Exception {
		System.out.println("����֮ǰ");
	}
	public String doSubmit(){
		this.setMessage("����");
//		this.setMessage("����");
//		return SUCCESS;
		return "success2";
	}
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}


	public String doTest(){
		return this.execute();
	}
	

	public String doTAjax(){
//		this.setMessage("����");
//		return SUCCESS;
//		this.query = URLEncoder.encode(query);
		System.out.println("�ύ��"+this.query);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(JSONKey.MESSAGE, "�ύ��"+this.query);
		renderHtml(jsonObject.toString());
		return null;
	}
}
