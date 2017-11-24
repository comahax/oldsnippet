package com.sunrise.boss.ui.cms.zjty.zjtyoperation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationListVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationVO;
import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.delegate.cms.zjty.zjtyoperation.ZjtyOperationDelegate;
import com.sunrise.boss.ui.commons.xtree.AbstractXmlBuilder;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;
import com.sunrise.boss.ui.commons.User;

public class ZjtyOperationXmlBuilder extends AbstractXmlBuilder {

	private String opntype;// 需要显示的层次
	private String _sk_opname;
	private String _ne_opnid;
	private String currentime = "";
	private String showdisable="";
	
	public ZjtyOperationXmlBuilder(User user){
		this.user = user;
	}
	
	private String[] remove(String[] str) throws Exception{
		if(str.length>0){
			if(str.length>1){
				String[] temp=new String[str.length-1];
				System.arraycopy(str, 1, temp, 0, str.length-1);
				str=temp;
			}else{
				str=null;
			}
		}
		return str;
	}
	
	public String getChildXml(XTreeNode xtreeNode) throws Exception {
		String nodeType = xtreeNode.getType();
		Cache cache = CacheSinglton.getInstance().getCache();
		Element element=cache.get(user.getOpercode());
		boolean isremove=true;
		if ("operation".equals(nodeType)) {
			StringBuffer buffer = new StringBuffer();
			String parentid = xtreeNode.getId();
			if(element!=null && element.getValue()!=null){
				HashSet set=new HashSet();
				List list=(ArrayList)element.getValue();
				for(int index=0;index<list.size();index++){
					String[] values=(String[])list.get(index);
					if(values!=null && values.length>0){
					ZjtyOperationDelegate delegate=new ZjtyOperationDelegate();
					ZjtyOperationVO vo=delegate.doFindByPk(values[0], user);
					if(set.add(values[0]) && parentid.equals(vo.getParentid())){
					XTreeNode node = new XTreeNode(vo.getOpnid(), vo.getParentid()
							.toString(), vo.getName(), "operation");
					node.setFunction("selectOpn");
					doCheckoperation(xtreeNode, buffer, vo, node);
					}
					if(parentid.equals(vo.getParentid())){
					values=remove(values);
					list.remove(index);
					list.add(index, values);
					}
					}
				}
				//删除缓存
				for(int index=0;index<list.size();index++){
					String[] values=(String[])list.get(index);
					if(values!=null){
						isremove=false;
					}
				}
				if(isremove){
					cache.remove(user.getOpercode());
//					System.out.println("the element is remove");
				}
				return buffer.toString();
			}else{
			
			List list = this.doGetsubop(parentid);
			// currentlayer = layer + "";
			
			for (Iterator it = list.iterator(); it.hasNext();) {
				ZjtyOperationVO vo = (ZjtyOperationVO) it.next();
				XTreeNode node = new XTreeNode(vo.getOpnid(), vo.getParentid()
						.toString(), vo.getName(), "operation");
				node.setFunction("selectOpn");
				doCheckoperation(xtreeNode, buffer, vo, node);
			}
			if (list.size() == 0) {
				XTreeNode node = new XTreeNode("", "0", "-----", "operation");
				node.setFunction("");
				buffer.append(getNodeString(node));
			}
			return buffer.toString();
		}
		}
		// }
		return "";
	}
	
	protected List doGetsubop(String parentid) throws Exception {
		ZjtyOperationDelegate delegate = new ZjtyOperationDelegate();
		ZjtyOperationListVO listVO = new ZjtyOperationListVO();
		listVO.set_pagesize("0");
		listVO.set_se_parentid(parentid);
		//listVO.set_ne_state("1");
		if ("nobusi".equals(opntype) || StringUtils.isEmpty(opntype)) {
			listVO.set_ne_isbusi("0");
		}
		List all = (List) delegate.doQuery(listVO, user).getDatas();
		List others = new ArrayList();
		if (StringUtils.isNotEmpty(_sk_opname) && !"null".equals(_sk_opname)) {
			listVO.set_sk_name(_sk_opname);
		}
		if (StringUtils.isNotEmpty(_ne_opnid) && !"null".equals(_ne_opnid)) {
			listVO.set_se_opnid(_ne_opnid);
		}
		if (StringUtils.isNotEmpty(_sk_opname)
				|| StringUtils.isNotEmpty(_ne_opnid)) {
			others = delegate.doQueryupper(listVO, user);
			List tmp = new ArrayList();
			for (Iterator it = all.iterator(); it.hasNext();) {
				Object object = it.next();
				if (others.contains(object)) {
					tmp.add(object);
				}
			}
			return tmp;
		}
		return all;
	}
	
	
	private void doCheckoperation(XTreeNode xtreeNode, StringBuffer buffer, ZjtyOperationVO vo, XTreeNode node) throws Exception {
		if (("busi".equals(opntype)) && vo.getIsbusi().intValue()==0) {//如果显示的是业务细项，则业务分类不能选中
			node.setFunction("");
		}else if("nobusi".equals(opntype) && vo.getIsbusi().intValue()==1){
			node.setFunction("");
		}
		if (StringUtils.isNotBlank(xtreeNode.getChildrenURL()))
			node.setChildrenURL(xtreeNode.getChildrenURL());
		if (("nobusi".equals(opntype) && vo.getIsbusi().intValue()==0) || "busi".equals(opntype)){
		if(!this.doChecktime(vo.getEnddate()) && "false".equals(showdisable)){
			buffer.append(getNodeString(node));
		}else if("true".equals(showdisable) && this.doChecktime(vo.getEnddate())){
				node.setFunction("");
				buffer.append(getNodeString(node));
		}
		}
	}
	

	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		ZjtyOperationDelegate delegate = new ZjtyOperationDelegate();
		if (StringUtils.isEmpty(xtreeNode.getId())) {
			return true;
		}
		ZjtyOperationVO operationVO = delegate.doFindByPk(xtreeNode.getId(), user);
		if (operationVO.getIsbusi().intValue() == 1) {// 如果是业务明细。
			return true;
		} else {
			String parentid = xtreeNode.getId();
			List list = this.doGetsubop(parentid);
			if (list.size() == 0) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean doChecktime(Date endtime) throws Exception{
		if(endtime==null){
			return true;
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		String now=format.format(new Date());
		return Long.valueOf(format.format(endtime)).longValue()<Long.valueOf(now).longValue();
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
		// if (StringUtils.isNotBlank(opnproxy))
		// url.append("&opnproxy=").append(opnproxy);

		url.append("&opntype=").append(opntype);
		url.append("&times=").append(currentime);
		url.append("&showdisable=").append(showdisable);
		buf.append(" src=\"").append(
				com.sunrise.boss.ui.commons.xtree.StringUtils.escapeForXML(url
						.toString())).append("\" ");
//		System.out.println(buf.toString());
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

	public String getOpntype() {
		return opntype;
	}

	public void setOpntype(String opntype) {
		this.opntype = opntype;
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

	public String getCurrentime() {
		return currentime;
	}

	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}

	public String getShowdisable() {
		return showdisable;
	}

	public void setShowdisable(String showdisable) {
		this.showdisable = showdisable;
	}

}
