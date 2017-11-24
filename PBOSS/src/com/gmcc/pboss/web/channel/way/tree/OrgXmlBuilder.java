package com.gmcc.pboss.web.channel.way.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.citycompany.CitycompanyDBParam;
import com.gmcc.pboss.business.channel.citycompany.CitycompanyVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.business.channel.servcent.ServcentVO;
import com.gmcc.pboss.control.channel.citycompany.Citycompany;
import com.gmcc.pboss.control.channel.citycompany.CitycompanyBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.microarea.Microarea;
import com.gmcc.pboss.control.channel.microarea.MicroareaBO;
import com.gmcc.pboss.control.channel.servcent.Servcent;
import com.gmcc.pboss.control.channel.servcent.ServcentBO;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class OrgXmlBuilder extends AbstractXmlBuilder {
	private String orgproxy;//当前的用户所在的层次

	private String orgtype;//当前的层次

	private boolean isleafs = false;

	private String currentlayer = "";
	
	private String currentime="";

	public OrgXmlBuilder(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	public String getChildXml(XTreeNode xtreeNode) throws Exception {
		String nodeType = xtreeNode.getType();
		int orgtypes = StringUtils.isEmpty(orgtype) ? 0 : (new Integer(orgtype)
		.intValue());
		if ("org".equals(nodeType)) {
			String upperorgid = xtreeNode.getId();
			if (StringUtils.isNotEmpty(orgproxy) && ( orgtypes==0 || new Integer(orgproxy).intValue()<orgtypes)) {
				int layer = (new Integer(orgproxy).intValue() + 1);
				this.setOrgproxy(new Integer(layer).toString());//在这里将orgproxy直接设置为下一层
				if (layer == 2) {// 市公司
					Citycompany citycompany = (Citycompany) BOFactory.build(CitycompanyBO.class, user);
					CitycompanyDBParam listvo = new CitycompanyDBParam();
					listvo.set_pagesize("0");
					List list = citycompany.doQuery(listvo).getDatas();
					if (list.size() == 0) {
						isleafs = true;
					}
					currentlayer = layer + "";
					return doBuilderXml(list, layer, upperorgid, xtreeNode);
				} else if (layer == 3) {// 县公司
					Cntycompany cntycompany = (Cntycompany) BOFactory.build(CntycompanyBO.class, user);
					CntycompanyDBParam listvo = new CntycompanyDBParam();
					listvo.set_pagesize("0");
					listvo.set_se_citycompid(upperorgid);
					List list = cntycompany.doQuery(listvo).getDatas();
					if (list.size() == 0) {
						isleafs = true;
					}
					currentlayer = layer + "";
					return doBuilderXml(list, layer, upperorgid, xtreeNode);
				} else if (layer == 4) {// 服务中心
					Servcent servcent = (Servcent) BOFactory.build(ServcentBO.class, user);
					ServcentDBParam listvo = new ServcentDBParam();
					listvo.set_pagesize("0");
					listvo.set_se_countyid(upperorgid);
					List list = servcent.doQuery(listvo).getDatas();
					if (list.size() == 0) {
						isleafs = true;
					}
					currentlayer = layer + "";
					return doBuilderXml(list, layer, upperorgid, xtreeNode);
				} else if (layer == 5) {// 微区域
					Microarea microarea = (Microarea) BOFactory.build(MicroareaBO.class, user);
					MicroareaDBParam listvo = new MicroareaDBParam();
					listvo.set_pagesize("0");
					listvo.set_se_svccode(upperorgid);
					List list = microarea.doQuery(listvo).getDatas();
					if (list.size() == 0) {
						isleafs = true;
					}
					currentlayer = layer + "";
					return doBuilderXml(list, layer, upperorgid, xtreeNode);
				}
			}
		}
		return "";
	}

	private String doBuilderXml(List list, int orgproxy, String upperwayid,
			XTreeNode xtreeNode) throws Exception {
		int orgtypes = StringUtils.isEmpty(orgtype) ? 0 : (new Integer(orgtype)
				.intValue());
		StringBuffer buf = new StringBuffer(40 * list.size());
		XTreeNode node = null;
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof CitycompanyVO) {
				CitycompanyVO tempvo = (CitycompanyVO) object;
				node = new XTreeNode(tempvo.getCitycompid(), upperwayid, tempvo
						.getCitycompname(), WayTreeBean.TYPE_ORG);
				xtreeNode.setText(tempvo.getCitycompname());

			} else if (object instanceof CntycompanyVO) {
				CntycompanyVO tempvo = (CntycompanyVO) object;
				node = new XTreeNode(tempvo.getCountycompid(), upperwayid,
						tempvo.getCountycompname(), WayTreeBean.TYPE_ORG);
			} else if (object instanceof ServcentVO) {
				ServcentVO tempvo = (ServcentVO) object;
				node = new XTreeNode(tempvo.getSvccode(), upperwayid, tempvo
						.getSvcname(), WayTreeBean.TYPE_ORG);
			} else if (object instanceof MicroareaVO) {
				MicroareaVO tempvo = (MicroareaVO) object;
				node = new XTreeNode(tempvo.getMacode(), upperwayid, tempvo
						.getManame(), WayTreeBean.TYPE_ORG);
			}
			if ((StringUtils.isNotBlank(xtreeNode.getFunction()))) {
				if (orgtypes == orgproxy || orgtypes == 0) {
					node.setFunction(xtreeNode.getFunction());
				}
			} else if (orgtypes == orgproxy || orgtypes == 0) {
				node.setFunction("selectOrg");
			}
			if (StringUtils.isNotBlank(xtreeNode.getChildrenURL()))
				node.setChildrenURL(xtreeNode.getChildrenURL());
			buf.append(getNodeString(node));
		}
		return buf.toString();
	}

	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		String upperorgid = xtreeNode.getId();
		int orgtypes = StringUtils.isEmpty(orgtype) ? 0 : (new Integer(orgtype)
		.intValue());
		if (orgproxy.equals("5")) {
			return true;
		}
		int layer = (new Integer(orgproxy).intValue() + 1);
		if(orgtypes==new Integer(orgproxy).intValue()){//如果下一层等于输入的条件，则设定为叶子
			return true;
		}
		if (layer == 2) {// 市公司
			Citycompany citycompany = (Citycompany) BOFactory.build(CitycompanyBO.class, user);
			CitycompanyDBParam listvo = new CitycompanyDBParam();
			listvo.set_pagesize("0");
			List list = (ArrayList) citycompany.doQuery(listvo).getDatas();
			if (list.size() == 0) {
				return true;
			}
		} else if (layer == 3) {// 县公司
			Cntycompany cntycompany = (Cntycompany) BOFactory.build(CntycompanyBO.class, user);
			CntycompanyDBParam listvo = new CntycompanyDBParam();
			listvo.set_pagesize("0");
			listvo.set_se_citycompid(upperorgid);
			List list = (List) cntycompany.doQuery(listvo).getDatas();
			if (list.size() == 0) {
				return true;
			}

		} else if (layer == 4) {// 服务中心
			Servcent servcent = (Servcent) BOFactory.build(ServcentBO.class, user);
			ServcentDBParam listvo = new ServcentDBParam();
			listvo.set_pagesize("0");
			listvo.set_se_countyid(upperorgid);
			List list = (List) servcent.doQuery(listvo).getDatas();
			if (list.size() == 0) {
				return true;
			}

		} else if (layer == 5) {// 微区域
			Microarea microarea = (Microarea) BOFactory.build(MicroareaBO.class, user);
			MicroareaDBParam listvo = new MicroareaDBParam();
			listvo.set_pagesize("0");
			listvo.set_se_svccode(upperorgid);
			List list = (List) microarea.doQuery(listvo).getDatas();
			if (list.size() == 0) {
				return true;
			}
		}
		return false;
	}

	public String getOrgproxy() {
		return orgproxy;
	}

	public void setOrgproxy(String orgproxy) {
		this.orgproxy = orgproxy;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	
	public String getCurrentime() {
		return currentime;
	}

	public void setCurrentime(String currentime) {
		this.currentime = currentime;
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
		if (StringUtils.isNotBlank(orgproxy))
			url.append("&orgproxy=").append(orgproxy);

		url.append("&orgtype=").append(orgtype);
		url.append("&times=").append(currentime);
		buf.append(" src=\"").append(com.sunrise.jop.common.utils.lang.StringUtils.escapeForXML(url
						.toString())).append("\" ");
		System.out.println(buf.toString());
		return buf.toString();
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
				text = com.sunrise.jop.common.utils.lang.StringUtils.escapeForXML(text);
				buf.append(" action=\"javascript:").append(jsfunction).append(
						"('").append(id).append("','").append(text).append(
						"','").append(xtreeNode.getType()).append("','")
						.append(this.doGetOrgtypebynumber(currentlayer) + "").append("')\" ");
			}
		}
		return buf.toString();
	}
	
	private String doGetOrgtypebynumber(String orgtype) {
		if (StringUtils.equals("2", orgtype)) {
			return "Citycom";
		}
		if (StringUtils.equals("3", orgtype)) {
			return "Cntycom";
		}
		if (StringUtils.equals("4", orgtype)) {
			return "Svc";
		}
		if (StringUtils.equals("5", orgtype)) {
			return "Ma";
		}
		return "";
	}
}
