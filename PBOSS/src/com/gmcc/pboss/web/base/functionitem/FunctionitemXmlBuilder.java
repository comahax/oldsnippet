package com.gmcc.pboss.web.base.functionitem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.functionitem.FunctionitemVO;
import com.gmcc.pboss.control.base.functionitem.Functionitem;
import com.gmcc.pboss.control.base.functionitem.FunctionitemBO;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class FunctionitemXmlBuilder extends AbstractXmlBuilder{

	private String funcId;
	private String funcName;
	private User user;
	private String queryText;
	
	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public FunctionitemXmlBuilder(String funcId,String funcName,User user,String queryText) {
		// TODO Auto-generated constructor stub
		this.funcId = funcId;
		this.funcName = funcName;
		this.user = user;
		this.queryText = queryText;
	}
	@Override
	protected String getSrcString(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		String parentid = xtreeNode.getId();
		String url = xtreeNode.getChildrenURL();
		if (isLeaf(xtreeNode) || url == null || url.length() < 1) {
			return "";
		}
		StringBuffer buf = new StringBuffer("");
		if (url.indexOf("?") < 0) {
			url = url + "?parentid=" + parentid + "&parenttype="
					+ xtreeNode.getType();
		} else {
			url = url + "&parentid=" + parentid + "&parenttype="
					+ xtreeNode.getType();
		}
		if (!StringUtils.isEmpty(queryText)){
			url += "&queryText="+queryText;
		}
		if (!org.apache.commons.lang.StringUtils.isEmpty(xtreeNode
				.getFunction()))
			url += "&function=" + xtreeNode.getFunction();
		if (!org.apache.commons.lang.StringUtils.isEmpty(xtreeNode
				.getChildrenURL()))
			url += "&childrenURL=" + xtreeNode.getChildrenURL();
		
		
		url = com.sunrise.jop.common.utils.lang.StringUtils.escapeForXML(url);
		buf.append(" src=\"").append(url).append("\" ");
		return buf.toString();
	}
	
	
	@Override
	public String getChildXml(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		
		Functionitem functionitem = (Functionitem) BOFactory.build(FunctionitemBO.class, user);
		FunctionitemDBParam param = new FunctionitemDBParam();
		param.getQueryConditions().put("parentid", xtreeNode.getId());
		param.getQueryConditions().put("operid", getUser().getOprcode());
		param.setQueryAll(true);
		DataPackage dp = null;
		if(CoreConfigInfo.IGNORE_MENU_PERM_FLAG){
			dp = functionitem.doQueryByNameSql("system.functionitem.queryTopMenuTree.test", param);
		}else{
			dp = functionitem.doQueryByNameSql("system.functionitem.queryTopMenuTree", param);
		}
		
		if(!StringUtils.isEmpty(queryText)){
			List dpQueryText = functionitem.doQueryText(queryText).getDatas();
			List dpList = new ArrayList();
			Iterator ittText = dpQueryText.iterator();
			while(ittText.hasNext()){
				FunctionitemVO vo = (FunctionitemVO) ittText.next();
				if(dp.getDatas().contains(vo)){
					dpList.add(vo);
				}
			}
			dp.setDatas(dpList);
		}
		
		StringBuffer buf = new StringBuffer(40 * dp.getDatas().size());
		Iterator itt = dp.getDatas().iterator();
		while(itt.hasNext()){
			FunctionitemVO item = (FunctionitemVO) itt.next();
			XTreeNode node = new XTreeNode(item.getFuncid(),xtreeNode.getId(),item.getFuncname(),null);
			if(StringUtils.isNotBlank(xtreeNode.getChildrenURL())) 
				node.setChildrenURL( xtreeNode.getChildrenURL());
			buf.append(getNodeString(node));
		}
		
		return buf.toString();
	}

	@Override
	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		Functionitem functionitem = (Functionitem) BOFactory.build(FunctionitemBO.class, user);
		FunctionitemDBParam param = new FunctionitemDBParam();
		param.set_se_parentid(xtreeNode.getId());
		DataPackage dp = functionitem.doQuery(param);
		if(dp.getDatas() != null && dp.getDatas().size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	protected String getChecked(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		return " check=''";
	}
}
