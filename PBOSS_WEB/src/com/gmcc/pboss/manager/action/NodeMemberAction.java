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

	//根据渠道wayid查询所有属于该渠道的店员
	private String wayid;
	public String getWayid(){
		return this.wayid;
	}
	public void setWayid(String wayid){
		this.wayid = wayid;
	}
	
	//查询店员信息的service
	private NodeMemberService nodeMemberService;
	public void setNodeMemberService(NodeMemberService nodeMemberService){
		this.nodeMemberService = nodeMemberService;
	}
	public NodeMemberService getNodeMemberService(){
		return this.nodeMemberService;
	}
	/**
	 * 转入店员列表
	 */
	public String doList(){
		this.setTitle(PageLoction.MAG_NODE_MEMBER);
		return SUCCESS;
	}
	
	/**
	 * 查询店员
	 */
	public String doAjaxList(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = nodeMemberService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * 查询某个店员详细信息——暂时未要求此功能，留待以后扩展
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
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小  
		parameter.setAction(QueryAction.SECTION);//需要分页
		parameter.setWayid(this.getWayid());
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		//setCols.add(new ColumnSet("officetel"));
		//setCols.add(new ColumnSet("oprcode", "工号"));
		//setCols.add(new ColumnSet("employeeid"));
		setCols.add(new ColumnSet("employeeid", "人员编号"));
		setCols.add(new ColumnSet("employeename", "姓名"));
		setCols.add(new ColumnSet("intime", "入职时间"));
		setCols.add(new ColumnSet("officetel", "公务机号码"));
		setCols.add(new ColumnSet("empstatusName", "用工状态"));
		//setCols.add(new ColumnSet("oper", "操作",true));
		
		return setCols;
	}
	
	 /**
	 * 返回页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
	}

}
