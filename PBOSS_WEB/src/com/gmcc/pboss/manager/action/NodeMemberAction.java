package com.gmcc.pboss.manager.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.manager.service.NodeMemberService;
import com.gmcc.pboss.manager.support.NodeMemberQueryParameter;

public class NodeMemberAction extends AbstractAction {

	//��������wayid��ѯ�������ڸ������ĵ�Ա
	private String wayid;
	public String getWayid(){
		return this.wayid;
	}
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	
	//��ѯ��Ա��Ϣ��service
	private NodeMemberService nodeMemberService;
	public void setNodeMemberService(NodeMemberService nodeMemberService){
		this.nodeMemberService = nodeMemberService;
	}
	public NodeMemberService getNodeMemberService(){
		return this.nodeMemberService;
	}
	/**
	 * ת���Ա�б�
	 */
	public String doList(){
		this.setTitle(PageLoction.MAG_NODE_MEMBER);
		return SUCCESS;
	}
	
	/**
	 * ��ѯ��Ա
	 */
	public String doAjaxList(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = nodeMemberService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * ��ѯĳ����Ա��ϸ��Ϣ������ʱδҪ��˹��ܣ������Ժ���չ
	public String doLoad(){
		this.setTitle(PageLoction.MAG_NODE_INFO);
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = service.transact(getMember(), getNodeParameter(), ServiceType.QUERY);
		if(result.isSuccess()){
			setResult(result.getRetResult());
			return SUCCESS;
		}
		else{
			setMessage(result.getMessage());
			return ERROR;
		}
	}
	 */
	
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		NodeMemberQueryParameter parameter = new NodeMemberQueryParameter();
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С  
		parameter.setAction(QueryAction.SECTION);//��Ҫ��ҳ
		parameter.setWayid(this.getWayid());
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("officetel"));
		//setCols.add(new ColumnSet("oprcode", "����"));
		//setCols.add(new ColumnSet("employeeid"));
		setCols.add(new ColumnSet("employeeid", "��Ա���"));
		setCols.add(new ColumnSet("employeename", "����"));
		setCols.add(new ColumnSet("intime", "��ְʱ��"));
		setCols.add(new ColumnSet("officetel", "���������"));
		setCols.add(new ColumnSet("empstatusName", "�ù�״̬"));
		//setCols.add(new ColumnSet("oper", "����",true));
		
		return setCols;
	}
	
	 /**
	 * ����ҳ����ʾ��Ч��
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}

}
