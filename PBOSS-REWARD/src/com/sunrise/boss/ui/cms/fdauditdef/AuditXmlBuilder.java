package com.sunrise.boss.ui.cms.fdauditdef; 

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefDAO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.delegate.cms.fdauditdef.FdauditdefDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.xtree.AbstractXmlBuilder;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;

public class AuditXmlBuilder extends AbstractXmlBuilder {
	private String audittype = "";

	private String parentname = "";

	private User user;

	private String currentime;

	public AuditXmlBuilder(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	public String getChildXml(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		String layer = xtreeNode.getId();
		if ("root".equals(audittype)) {

		    FdauditdefDelegate delegate = new FdauditdefDelegate();		
			List list = (List)delegate.queryTypes(user).getDatas();			
			
			XTreeNode node = null;
			StringBuffer buf = new StringBuffer(40 * list.size());
			for (Iterator it = list.iterator(); it.hasNext();) {
				Object[] type = (Object[]) it.next();
				node = new XTreeNode((String) type[1], layer, (String) type[0],
						FdauditdefTreeBean.TYPE_AUDIT);
				node.setChildrenURL(xtreeNode.getChildrenURL());
				node.setFunction(xtreeNode.getFunction());
				buf.append(getNodeString(node));
			} 

			return buf.toString();
		}
		if ("type".equals(audittype)) {
			FdauditdefListVO listvo = new FdauditdefListVO();
			listvo.set_se_typename(layer);
			listvo.set_pagesize("1000000");
			FdauditdefDelegate delegate = new FdauditdefDelegate();
			List list = (List) delegate.doQuery(listvo, user).getDatas();
			XTreeNode node = null;
			StringBuffer buf = new StringBuffer(40 * list.size());
			for (Iterator it = list.iterator(); it.hasNext();) {
				FdauditdefVO vo = (FdauditdefVO) it.next();
				node = new XTreeNode(vo.getTablename(), layer, vo
						.getTablechname(), FdauditdefTreeBean.TYPE_AUDIT);
				node.setChildrenURL(xtreeNode.getChildrenURL());
				node.setFunction(xtreeNode.getFunction());
				buf.append(getNodeString(node));
			}
			return buf.toString();
		}
		return null;
	}

	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		// TODO Auto-generated method stub
		if ("root".equals(audittype)) {
			FdauditdefListVO listvo = new FdauditdefListVO();
			listvo.set_se_typename(xtreeNode.getId());
			listvo.set_pagesize("10000");
			FdauditdefDelegate delegate = new FdauditdefDelegate();
			List list = (List) delegate.doQuery(listvo, user).getDatas();
			if (list.size() > 0) {
				return false;
			}
			return true;

		} else {
			return true;
		}
	}

	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
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
		if ("root".equals(audittype)) {
			url.append("&queryText=").append("type");
			url.append("&parentname=").append(xtreeNode.getText());
		}
		url.append("&time=").append(currentime);
		buf.append(" src=\"").append(
				com.sunrise.boss.ui.commons.xtree.StringUtils.escapeForXML(url
						.toString())).append("\" ");
		System.out.println(buf.toString());
		return buf.toString();
	}

	public String getCurrentime() {
		return currentime;
	}

	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}

	protected String getActionString(XTreeNode xtreeNode) throws Exception {
		String parentid = xtreeNode.getParentId();
		String id = xtreeNode.getId();
		String text = xtreeNode.getText();
		String url = xtreeNode.getUrl();
		StringBuffer buf = new StringBuffer(80);
		if (!org.apache.commons.lang.StringUtils.isEmpty(url)) {
			buf.append(" action=\"" + url + "\" ");
		} else {
			String jsfunction = xtreeNode.getFunction();
			if (!org.apache.commons.lang.StringUtils.isEmpty(jsfunction)) {
				text = com.sunrise.pub.tools.StringUtils.escapeForXML(text);
				if (StringUtils.isNotEmpty(this.parentname)) {
					String paname = this.parentname;
					if(!this.doCheckidGBK(paname)){
						paname =new String(paname
								.getBytes("iso-8859-1"), "GBK");
					}
					buf.append(" action=\"javascript:").append(jsfunction)
							.append("('").append(id).append("','").append(text)
							.append("','").append(audittype).append("','")
							.append(paname).append("')\" ");
				} else {
					buf.append(" action=\"javascript:").append(jsfunction)
							.append("('").append(id).append("','").append(text)
							.append("','").append(audittype).append("')\" ");
				}
			}
		}
		return buf.toString();
	}

	protected String getTextString(XTreeNode xtreeNode) throws Exception {
		StringBuffer buf = new StringBuffer("");
		String id = xtreeNode.getId();
		String text = xtreeNode.getText();
		text = com.sunrise.pub.tools.StringUtils.escapeForXML(text);
		buf.append(" text=\"").append(text).append("\" ");
		return buf.toString();
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	private boolean doCheckidGBK(String value) throws Exception{
		String path="[\u4e00-\u9fa5]";
		Pattern pattern=Pattern.compile(path);
		Matcher matcher=pattern.matcher(value);
		return matcher.find();
	}
}
