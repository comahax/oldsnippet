package com.gmcc.pboss.web.channel.operation;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.operation.OperationDBParam;
import com.gmcc.pboss.business.channel.operation.OperationVO;
import com.gmcc.pboss.control.channel.operation.Operation;
import com.gmcc.pboss.control.channel.operation.OperationBO;
import com.gmcc.pboss.web.channel.way.tree.WayTreeBean;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class OpnXmlBuilder extends AbstractXmlBuilder {

	private String opnproxy;// 当前的用户所在的层次

	private String opntype;// 当前的层次

	private String currentime = "";

	private String currentlayer = "";

	public OpnXmlBuilder(User user) {
		this.user = user;
	}

	public String getChildXml(XTreeNode xtreeNode) throws Exception {
		String nodeType = xtreeNode.getType();
		int curr = StringUtils.isEmpty(opntype) ? 5 : (new Integer(opntype)
				.intValue());
		if ("opn".equals(nodeType)) {
			String parentid = xtreeNode.getId();
			if (StringUtils.isNotEmpty(opnproxy)
					&& (curr == 0 || new Integer(opnproxy).intValue() < curr)) {
				int layer = (new Integer(opnproxy).intValue() + 1);
				setOpnproxy(new Integer(layer).toString());
				Operation operation = (Operation) BOFactory.build(OperationBO.class, user);
				OperationDBParam listVO = new OperationDBParam();
				listVO.set_pagesize("0");
				listVO.set_se_parentid(parentid);
				listVO.set_ne_state("1");
				List list = (List) operation.doQuery(listVO).getDatas();
				currentlayer = layer + "";
				StringBuffer buffer = new StringBuffer();
				for (Iterator it = list.iterator(); it.hasNext();) {
					OperationVO vo = (OperationVO) it.next();
					XTreeNode node = new XTreeNode(vo.getOpnid().toString(), vo
							.getParentid().toString(), vo.getName(),
							WayTreeBean.TYPE_OPN);
					if(!"6".equals(opnproxy)){
						node.setFunction("selectOpn");
					}
					if (StringUtils.isNotBlank(xtreeNode.getChildrenURL()))
						node.setChildrenURL(xtreeNode.getChildrenURL());
					buffer.append(getNodeString(node));
				}
				return buffer.toString();
			}
		}
		return "";
	}

	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		if (opnproxy.equals("5")) {
			return true;
		} else {
			String parentid = xtreeNode.getId();
			Operation operation = (Operation) BOFactory.build(OperationBO.class, user);
			OperationDBParam listVO = new OperationDBParam();
			listVO.set_pagesize("0");
			listVO.set_se_parentid(parentid);
			List list = (List) operation.doQuery(listVO).getDatas();
			if (list.size() == 0) {
				return true;
			}
		}
		return false;
	}
	
	protected String getSrcString(XTreeNode xtreeNode) throws Exception {
		String parentid = xtreeNode.getId();
		StringBuffer url = new StringBuffer(100);
		url.append(xtreeNode.getChildrenURL());
		if (isLeaf(xtreeNode) || url == null || url.length() < 1) {
			return "";
		}
		StringBuffer buf = new StringBuffer("");
		if (url.indexOf("?") < 0) {
			url = url.append("?parentid=").append(parentid).append(
					"&parenttype=").append(xtreeNode.getType());
		} else {
			url = url.append("&parentid=").append(parentid).append(
					"&parenttype=").append(xtreeNode.getType());
		}

		if (StringUtils.isNotBlank(xtreeNode.getFunction()))
			url.append("&function=").append(xtreeNode.getFunction());

		if (StringUtils.isNotBlank(xtreeNode.getChildrenURL()))
			url.append("&childrenURL=").append(xtreeNode.getChildrenURL());
		if (StringUtils.isNotBlank(opnproxy))
			url.append("&opnproxy=").append(opnproxy);

		url.append("&opntype=").append(opntype);
		url.append("&times=").append(currentime);
		buf.append(" src=\"").append(com.sunrise.jop.common.utils.lang.StringUtils.escapeForXML(url
						.toString())).append("\" ");
		System.out.println(buf.toString());
		return buf.toString();
	}
	
	protected String getActionString(XTreeNode xtreeNode) throws Exception {
		String id = xtreeNode.getId();
		String text = xtreeNode.getText();
		String url = xtreeNode.getUrl();
		StringBuffer buf = new StringBuffer(80);
		if (!org.apache.commons.lang.StringUtils.isEmpty(url)) {
			buf.append(" action=\"" + url + "\" ");
		} else {
			String jsfunction = xtreeNode.getFunction();
			if (!org.apache.commons.lang.StringUtils.isEmpty(jsfunction)) {
				text = com.sunrise.jop.common.utils.lang.StringUtils.escapeForXML(text);
				buf.append(" action=\"javascript:").append(jsfunction).append(
						"('").append(id).append("','").append(text).append(
						"','").append(xtreeNode.getType()).append("')\" ");
			}
		}
		return buf.toString();
	}

	public String getOpnproxy() {
		return opnproxy;
	}

	public void setOpnproxy(String opnproxy) {
		this.opnproxy = opnproxy;
	}

	public String getOpntype() {
		return opntype;
	}

	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}

	public String getCurrentime() {
		return currentime;
	}

	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}

}
