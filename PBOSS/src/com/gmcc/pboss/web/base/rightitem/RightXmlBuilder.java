package com.gmcc.pboss.web.base.rightitem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.operright.OperrightDBParam;
import com.gmcc.pboss.business.base.operright.OperrightVO;
import com.gmcc.pboss.business.base.rightitem.RightitemDBParam;
import com.gmcc.pboss.business.base.rightitem.RightitemVO;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.rightitem.Rightitem;
import com.gmcc.pboss.control.base.rightitem.RightitemBO;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class RightXmlBuilder extends AbstractXmlBuilder{

	private String rightId;
	private String rightName;
	private User user;
	private String queryText;
	
	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getRightId() {
		return rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RightXmlBuilder(String rightId,String rightName,User user,String queryText) {
		// TODO Auto-generated constructor stub
		this.rightId = rightId;
		this.rightName = rightName;
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
		
		Rightitem rightitem = (Rightitem) BOFactory.build(RightitemBO.class, user);
		RightitemDBParam param = new RightitemDBParam();
		param.set_se_rightgroup(xtreeNode.getId());
		param.setQueryAll(true);
		DataPackage dp = rightitem.doQuery(param);
		
		if(!StringUtils.isEmpty(queryText)){
			List dpQueryText = rightitem.doQueryText(queryText).getDatas();
			List dpList = new ArrayList();
			Iterator ittText = dpQueryText.iterator();
			while(ittText.hasNext()){
				RightitemVO vo = (RightitemVO) ittText.next();
				if(dp.getDatas().contains(vo)){
					dpList.add(vo);
				}
			}
			dp.setDatas(dpList);
		}
		
		StringBuffer buf = new StringBuffer(40 * dp.getDatas().size());
		Iterator itt = dp.getDatas().iterator();
		while(itt.hasNext()){
			RightitemVO item = (RightitemVO) itt.next();
			XTreeNode node = new XTreeNode(item.getRightid(),xtreeNode.getId(),item.getRightname(),null);
			if(StringUtils.isNotBlank(xtreeNode.getChildrenURL())) 
				node.setChildrenURL( xtreeNode.getChildrenURL());
			buf.append(getNodeString(node));
		}
		
		return buf.toString();
	}

	@Override
	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		Rightitem rightitem = (Rightitem) BOFactory.build(RightitemBO.class, user);
		RightitemDBParam param = new RightitemDBParam();
		param.set_se_rightgroup(xtreeNode.getId());
		DataPackage dp = rightitem.doQuery(param);
		if(dp.getDatas() != null && dp.getDatas().size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
//	@Override
//	/**
//	 * 实现多选树
//	 */
//	protected String getChecked(XTreeNode xtreeNode) throws Exception {
//		
//		Operright operright = (Operright) BOFactory.build(OperrightBO.class, user);
//		Rightitem rightitem = (Rightitem) BOFactory.build(RightitemBO.class, user);
//		// TODO Auto-generated method stub
//		if(isLeaf(xtreeNode)){
//			//叶子节点处理
//			OperrightVO rightvo = new OperrightVO();
//			rightvo.setOperid(user.getOprcode());
//			rightvo.setRightid(xtreeNode.getId());
//			rightvo = operright.doFindByPk(rightvo);
//			if(rightvo != null){
//				return " check='true'";
//			}else{
//				return " check=''";
//			}
//		}else{
//			//树节点处理
//			RightitemDBParam param = new RightitemDBParam();
//			param.set_se_rightgroup(xtreeNode.getId());
//			param.set_se_region(user.getCityid());
//			DataPackage dp = rightitem.doQuery(param);
//			Iterator itt = dp.getDatas().iterator();
//			while(itt.hasNext()){
//				RightitemVO itemvo = (RightitemVO) itt.next();
//				XTreeNode subNode = new XTreeNode(itemvo.getRightid(),itemvo.getRightgroup(),null,null);
//				String result = getChecked(subNode);
//				if(" check=''".equals(result)){
//					flag = false;
//					break;
//				}
//			}
//		}
//		if(flag == true){
//			return " check='true'";
//		}else{
//			return " check=''";
//		}
//	}
//	
//	private boolean flag = true;
	
	@Override
	protected String getChecked(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		return " check=''";
	}
}
