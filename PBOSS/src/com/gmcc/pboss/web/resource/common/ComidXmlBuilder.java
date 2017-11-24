package com.gmcc.pboss.web.resource.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.common.utils.tools.CacheSinglton;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.ui.User;

public class ComidXmlBuilder extends AbstractXmlBuilder {

	private static long treeInitTime;

	private static Logger log = Logger.getRootLogger();

	public final String PARENTTYPE_TOP = "top";

	public final String PARENTTYPE_COMCLASSID = "comclassid";

	public final String PARNETTYPE_COMTYPE = "comtype";

	public final String PARNETTYPE_COMID = "comid";

	public final int PARENT = -1;

	public final int PRE_PARENT = -2;

	private String condition;

	String filterFlag;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public ComidXmlBuilder(User user, String condition, String filterFlag) {
		this.user = user;
		this.condition = condition;
		this.filterFlag = filterFlag;
	}

	public String getChildXml(XTreeNode xTreeNode) throws Exception {
		String parentType = xTreeNode.getType();
		String parentId = getSpecParentId(xTreeNode, PARENT);
		XTreeNode node;
		// String cityId =
		// SessionFactoryRouter.conversionCityid(user.getCityid());
		String cityId = user.getCityid();

		StringBuffer buf = new StringBuffer("");

		// ��ѯ�����ŵ��ŵ�map��(���ʱ��:20081210 zengwenqu)
		// (�ж��Ƿ��������BOSS,���������Ʒ����ʾ��ʽ����Ʒ�����ñ����Ϣ��ʾ,���������������ԭ���ķ�ʽ��ʾ)
		Map map = ComidTreeHelper.getConditions2(user);
		if (map.isEmpty()) {
			map = ComidTreeHelper.getConditions(condition);// ��ȡ��ѯ����
		}

		if (PARENTTYPE_TOP.equals(parentType)) {
			buf.append(buildSpecTree(xTreeNode, map, cityId));
			// if (StringUtils.isBlank(condition)
			// || !map.containsKey("comclassid")) {
			// buf.append(buildSpecTree(xTreeNode,
			// ComidTreeHelper.comclassids, cityId));
			// } else {
			// buf.append(buildSpecTree(xTreeNode, ((List) map
			// .get("comclassid")).toArray(), cityId));
			// }
		} else if (PARENTTYPE_COMCLASSID.equals(parentType)) {
			String comclassid = parentId;
			ComidTree tree;
			String comtype;
			String comtypeName;

			tree = getTree(comclassid);
			if (tree != null && tree.haveChilds()) {
				for (int i = 0; i < tree.childsLength(); i++) {
					ComidTree childTree = (ComidTree) tree.getChild(i);
					// ֻ��ʾ�趨����Ʒ���͵�����
					if (map.containsKey("comtype") && !((List) map.get("comtype")).contains(childTree.getValue())) {
						continue;
					}
					List list = childTree.getLeafsByCityid(cityId, filterFlag);
					if (list != null && list.size() > 0) {
						comtype = childTree.getValue();
						comtypeName = childTree.getName();
						node = createNode(comtype, xTreeNode.getParentId(), comtypeName, PARNETTYPE_COMTYPE, xTreeNode);
						buf.append(getNodeString(node));
					}
				}
			}
		} else if (PARNETTYPE_COMTYPE.equals(parentType)) {
			String text;
			String id;
			String preParentId = getSpecParentId(xTreeNode, PRE_PARENT);
			ComidTree tree = getTree(preParentId);
			List leafs;
			if (tree != null && tree.getChild(parentId) != null) {
				leafs = tree.getChild(parentId).getLeafsByCityid(cityId, filterFlag);
				if (leafs != null && leafs.size() > 0) {
					for (Iterator it = leafs.iterator(); it.hasNext();) {
						ComVO vo = (ComVO) it.next();
						id = vo.getComid().toString();
						text = vo.getComname();
						node = createNode(id, xTreeNode.getParentId(), text, PARNETTYPE_COMID, xTreeNode);
						buf.append(getNodeString(node));
					}
				}
			}
		}
		return buf.toString();
	}

	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		return PARNETTYPE_COMID.equals(xtreeNode.getType());
	}

	/**
	 * SrcString��ʵ��
	 * 
	 * @param parentid
	 *            String
	 * @param url
	 *            String
	 * @return String
	 */
	protected String getSrcString(XTreeNode xtreeNode) throws Exception {
		String parentid = xtreeNode.getParentId() + "_" + xtreeNode.getId();
		String url = xtreeNode.getChildrenURL();
		if (isLeaf(xtreeNode) || url == null || url.length() < 1) {
			return "";
		}
		StringBuffer buf = new StringBuffer("");
		if (url.indexOf("?") < 0) {
			url = url + "?parentid=" + parentid + "&parenttype=" + xtreeNode.getType();
		} else {
			url = url + "&parentid=" + parentid + "&parenttype=" + xtreeNode.getType();
		}

		if (!org.apache.commons.lang.StringUtils.isEmpty(xtreeNode.getFunction()))
			url += "&function=" + xtreeNode.getFunction();

		if (!org.apache.commons.lang.StringUtils.isEmpty(xtreeNode.getChildrenURL()))
			url += "&childrenURL=" + xtreeNode.getChildrenURL();

		if (!StringUtils.isBlank(filterFlag)) {
			url += "&filterFlag=" + filterFlag;
		}

		if (!StringUtils.isBlank(condition)) {
			url += "&condition=" + condition;
		}
		url = com.sunrise.jop.common.utils.lang.StringUtils.escapeForXML(url);
		buf.append(" src=\"").append(url).append("\" ");
		return buf.toString();
	}

	/**
	 * ���ָ���ڵ��ָ����εĸ��ڵ�
	 * 
	 * @param xtreeNode
	 * @param layer
	 *            ���:ֵ����0ʱ��ʾ�Ӷ��㿪ʼ��ε���,1��ʾ����,2��ʾ�ڶ���,��������ӽڵ�;
	 *            ֵС��0ʱ,��ʾ�Ӹýڵ㿪ʼ��εݼ�,-1��ʾ�ýڵ����һ��,-2��ʾ������,���ýڵ�ĸ��ڵ�ĸ��ڵ�;
	 *            ֵ����0ʱ,��ʾ�ڵ㱾�� ����ֵ�ľ���ֵ���ڵ��ڽڵ����ڵĲ��ֵ,�򷵻ؿ��ַ���.
	 * @return
	 */
	protected String getSpecParentId(XTreeNode xtreeNode, int layer) {
		String[] parentIds = StringUtils.split(xtreeNode.getParentId(), "_");

		if (Math.abs(layer) > parentIds.length) {
			return "";
		}
		if (layer == 0) {
			return xtreeNode.getId();
		}
		if (layer < 0) {
			layer = Math.abs(layer);
			return parentIds[parentIds.length - layer];
		} else {
			return parentIds[layer - 1];
		}
	}

	protected String buildSpecTree(XTreeNode xTreeNode, Map map, String cityId) throws Exception {
		XTreeNode node;
		String comclassidName;
		StringBuffer buf = new StringBuffer("");
		Object[] comclassids = null;
		List comtypes = null;

		if (StringUtils.isBlank(condition) || !map.containsKey("comclassid")) {
			comclassids = ComidTreeHelper.comclassids;
		} else {
			comclassids = ((List) map.get("comclassid")).toArray();
		}

		if (map.containsKey("comtype")) {
			comtypes = (List) map.get("comtype");
		}

		buf.append(writeFirstNode(xTreeNode.getParentId(), xTreeNode));
		for (int i = 0; i < comclassids.length; i++) {
			String comclassid = (String) comclassids[i];
			if (ComidTreeHelper.comclassidMap.containsKey(comclassid)) {
				ComidTree tree = getTree(comclassid);
				// ***�ж������Ƿ���ںϷ�������Ҷ��,����������ʾ������***//
				if (checkTree(tree, comtypes, cityId)) {
					comclassidName = (String) ComidTreeHelper.comclassidMap.get(comclassids[i]);
					node = createNode(comclassid, xTreeNode.getParentId(), comclassidName, PARENTTYPE_COMCLASSID, xTreeNode);
					buf.append(getNodeString(node));
				}

			}
		}

		return buf.toString();
	}

	private boolean checkTree(ComidTree tree, List list, String cityId) {
		List comtypes;
		if (list != null) {
			// ������Ʒ���͵�����
			comtypes = list;
		} else {
			// ��������Ʒ���͵�����
			comtypes = new ArrayList();
			for (int i = 0; i < tree.childsLength(); i++) {
				comtypes.add(((ComidTree) tree.getChild(i)).getValue());
			}
		}
		// ***�ж������Ƿ���ںϷ�������Ҷ��,����������ʾ������***//
		if (comtypes != null && comtypes.size() > 0) {
			for (Iterator it = comtypes.iterator(); it.hasNext();) {
				String comtype = (String) it.next();
				if (tree.containsChild(comtype)) {
					ComidTree child = tree.getChild(comtype);
					if (child.haveLeafs(cityId, filterFlag)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	protected ComidTree getTree(String comclassid) {
		ComidTree tree = null;
		if (CoreConfigInfo.USE_CACHE_FLAG) {
			try {
				Cache cache = CacheSinglton.getInstance().getCache();
				if (cache.get(comclassid) != null) {
					tree = (ComidTree) cache.get(comclassid).getValue();
				}
			} catch (Exception e) {
				log.error("get Cache Error:", e);
			}
		} else {
			if (ComidTreeHelper.treeMap == null) {
				ComidTreeHelper.initTreeMap();
				treeInitTime = System.currentTimeMillis();
			} else {
				long curTime = System.currentTimeMillis();
				// if ((curTime - treeInitTime) > 1000*3600){//ÿ��һСʱ���¼���
				treeInitTime = curTime;
				ComidTreeHelper.initTreeMap();
				// }
			}
			tree = (ComidTree) ComidTreeHelper.treeMap.get(comclassid);
		}
		return tree;
	}

	private XTreeNode createNode(String id, String parentId, String text, String type, XTreeNode xTreeNode) {
		XTreeNode node = new XTreeNode(id, parentId, text, type);
		if (!StringUtils.isEmpty(xTreeNode.getFunction()))
			node.setFunction(xTreeNode.getFunction());
		if (!StringUtils.isEmpty(xTreeNode.getChildrenURL()))
			node.setChildrenURL(xTreeNode.getChildrenURL());
		return node;
	}

	private String writeFirstNode(String parentId, XTreeNode xTreeNode) throws Exception {
		XTreeNode node = createNode(" ", parentId, "��ֵ", PARNETTYPE_COMID, xTreeNode);
		return getNodeString(node);
	}
}
