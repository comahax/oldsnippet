package com.sunrise.boss.ui.cms.opntree;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeListVO;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeVO;
import com.sunrise.boss.delegate.cms.opntree.OpnTreeDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.xtree.AbstractXmlBuilder;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;

public class OpnTreeXmlBuilder extends AbstractXmlBuilder{

	private String _sk_opname;
	private String _ne_opnid;
	private String showdisable= "";
	private String currentime = "";
	private String isLeaf;
	
	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String get_sk_opname() {
		return _sk_opname;
	}

	public void set_sk_opname(String _sk_opname) {
		this._sk_opname = _sk_opname;
	}

	public String get_ne_opnid() {
		return _ne_opnid;
	}

	public void set_ne_opnid(String _ne_opnid) {
		this._ne_opnid = _ne_opnid;
	}

	public String getShowdisable() {
		return showdisable;
	}

	public void setShowdisable(String showdisable) {
		this.showdisable = showdisable;
	}

	public OpnTreeXmlBuilder(User user){
		this.user = user;
	}
	
	
	public String getChildXml(XTreeNode xtreeNode) throws Exception {
		String nodeType = xtreeNode.getType();
		StringBuffer buffer = new StringBuffer();
		String parentid = xtreeNode.getId();
		String parenttype = xtreeNode.getType();
		List list = this.doGetsubop(parentid, parenttype);
		
		for (Iterator it = list.iterator(); it.hasNext();) {
			OpnTreeVO vo = (OpnTreeVO) it.next();
			XTreeNode node = new XTreeNode(vo.getOpnid(), vo.getParentid()
					.toString(), vo.getName(), nodeType);
			node.setFunction("selectOpn");
			doCheckoperation(xtreeNode, buffer, vo, node);
		}
		if (list.size() == 0) {
			XTreeNode node = new XTreeNode("", "0", "-----", parenttype);
			node.setFunction("");
			buffer.append(getNodeString(node));
		}
		return buffer.toString();
	}
	
	private void doCheckoperation(XTreeNode xtreeNode, StringBuffer buffer, OpnTreeVO vo, XTreeNode node) throws Exception {
		if (("yes".equals(isLeaf)) && vo.getIsbusi().intValue()==0) {//如果显示的是业务细项，则业务分类不能选中
			node.setFunction("");
		}else if("no".equals(isLeaf) && vo.getIsbusi().intValue()==1){
			node.setFunction("");
		}
		if (StringUtils.isNotBlank(xtreeNode.getChildrenURL()))
			node.setChildrenURL(xtreeNode.getChildrenURL());
		if (("no".equals(isLeaf) && vo.getIsbusi().intValue()==0) || "yes".equals(isLeaf)){
			if("false".equals(showdisable)){
				if(!this.doChecktime(vo.getEnddate())){
					buffer.append(getNodeString(node));
				}
			}else if("true".equals(showdisable)){
				if(this.doChecktime(vo.getEnddate())){
					node.setFunction("");
				}
				buffer.append(getNodeString(node));
			}
		}
	}
	
	protected boolean doChecktime(Date endtime) throws Exception{
		if(endtime==null){
			return true;
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String now=format.format(new Date());
		return Long.valueOf(format.format(endtime)).longValue()<Long.valueOf(now).longValue();
	}

	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		if (StringUtils.isEmpty(xtreeNode.getId())) {
			return true;
		}
		
		OpnTreeDelegate delegate = new OpnTreeDelegate();
		OpnTreeListVO listvo = new OpnTreeListVO();
		listvo.set_se_opnid(xtreeNode.getId());
		listvo.setTreetype(xtreeNode.getType());
		Iterator itt = delegate.doQueryUpData(listvo, user).toList(OpnTreeVO.class).iterator();
		if(itt.hasNext()){
			OpnTreeVO operationVO = (OpnTreeVO)itt.next();
			if (operationVO.getIsbusi().intValue() == 1) {// 如果是业务明细。
				return true;
			} else {
				String parentid = xtreeNode.getId();
				String parenttype = xtreeNode.getType();
				List list = this.doGetsubop(parentid, parenttype);
				if (list.size() == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected List doGetsubop(String parentid, String parenttype) throws Exception {
		
		OpnTreeDelegate delegate = new OpnTreeDelegate();
		OpnTreeListVO listVO = new OpnTreeListVO();
		listVO.set_pagesize("0");
		listVO.set_se_parentid(parentid);
		listVO.setTreetype(parenttype);
		if ("no".equals(isLeaf) || StringUtils.isEmpty(isLeaf)) {
			listVO.set_ne_isbusi("0");
		}
		
		List all = (List) delegate.doQueryDownData(listVO, user).getDatas();
		List others = new ArrayList();
		if (StringUtils.isNotEmpty(_sk_opname) && !"null".equals(_sk_opname)) {
			listVO.set_sk_name(_sk_opname);
		}
		if (StringUtils.isNotEmpty(_ne_opnid) && !"null".equals(_ne_opnid)) {
			listVO.set_se_opnid(_ne_opnid);
		}
		if (StringUtils.isNotEmpty(_sk_opname)
				|| StringUtils.isNotEmpty(_ne_opnid)) {
			others = (List)delegate.doQueryUpData(listVO, user).getDatas();
			List tmp = new ArrayList();
			for (Iterator it1 = others.iterator(); it1.hasNext();) {
				OpnTreeVO obj1 = (OpnTreeVO)it1.next();
				for (Iterator it2 = all.iterator(); it2.hasNext();) {
					OpnTreeVO obj2 = (OpnTreeVO)it2.next();
					if(obj1.getOpnid().equals(obj2.getOpnid())){
						tmp.add(obj1);
					}
				}
//				if (others.contains(object)) {
//					tmp.add(object);
//				}
			}
			//去重
			List tmp2 = new ArrayList();
			for (Iterator itt = tmp.iterator(); itt.hasNext();) {
				OpnTreeVO vo = (OpnTreeVO)itt.next();
				if(!tmp2.contains(vo)){
					tmp2.add(vo);
				}
			}
			return tmp2;
		}
		return all;
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

		url.append("&isLeaf=").append(isLeaf);
		url.append("&times=").append(currentime);
		url.append("&showDisable=").append(showdisable);
		buf.append(" src=\"").append(
				com.sunrise.boss.ui.commons.xtree.StringUtils.escapeForXML(url
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
				text = com.sunrise.pub.tools.StringUtils.escapeForXML(text);
				buf.append(" action=\"javascript:").append(jsfunction).append(
						"('").append(id).append("','").append(text).append(
						"','").append(xtreeNode.getType()).append("')\" ");
			}
		}
		return buf.toString();
	}

	protected String getTextString(XTreeNode xtreeNode) throws Exception {
		StringBuffer buf = new StringBuffer("");
		String id = xtreeNode.getId();
		String text = xtreeNode.getText();
		text = com.sunrise.boss.ui.commons.xtree.StringUtils.escapeForXML(text);
		if (StringUtils.isEmpty(id)) {
			buf.append(" text=\"").append(text).append("\" ");
		} else {
			buf.append(" text=\"").append("(" + id + ")" + text).append("\" ");
		}
		return buf.toString();
	}

	public String getCurrentime() {
		return currentime;
	}

	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}
	
}
