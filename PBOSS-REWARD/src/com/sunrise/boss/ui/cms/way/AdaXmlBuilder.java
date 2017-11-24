package com.sunrise.boss.ui.cms.way;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.xtree.AbstractXmlBuilder;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;

public class AdaXmlBuilder extends AbstractXmlBuilder {
	private String times;
	public AdaXmlBuilder(User user) {
		this.user=user;
		// TODO Auto-generated constructor stub
	}

	public String getChildXml(XTreeNode xtreeNode) throws Exception {
	    String nodeType = xtreeNode.getType();
	    
	    if("adimarea".equals(nodeType)) {    	
	    	String upperwayid = xtreeNode.getId();    	
		   List datas = querySubWays(upperwayid);
		    
		    StringBuffer buf = new StringBuffer(40 * datas.size());
		    for (Iterator it = datas.iterator(); it.hasNext(); ) {
		      AdimareaVO adavo = (AdimareaVO) it.next();
		      //更改XTreeNode的parentid和name为当前渠道的相应数据
		      XTreeNode node = new XTreeNode(adavo.getAdacode(), upperwayid ,adavo.getAdaname(),WayTreeBean.TYPE_ADIMAREA);
		      if(StringUtils.isNotBlank(xtreeNode.getFunction())) 
		    	  node.setFunction(xtreeNode.getFunction());
				if(StringUtils.isNotBlank(xtreeNode.getChildrenURL())) 
					node.setChildrenURL( xtreeNode.getChildrenURL());
		      buf.append(getNodeString(node));
		    }
		    return buf.toString();
	    }
		return "";
	}

	protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
		return WayTreeBean.getChildrenCount(xtreeNode, user) < 1;
	}
	private List querySubWays(String ada) throws Exception{
		AdimareaDelegate delegate=new AdimareaDelegate();
		return delegate.doQueryUpperada(ada, user);
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	 protected String getSrcString(XTreeNode xtreeNode) throws Exception {
		    String parentid = xtreeNode.getId();
		    String url = xtreeNode.getChildrenURL();
		    if(isLeaf(xtreeNode) || url == null || url.length() < 1){
		      return "";
		    }
		    StringBuffer buf = new StringBuffer("");
		    if (url.indexOf("?") < 0) {
		      url = url + "?parentid=" + parentid +"&parenttype=" + xtreeNode.getType();
		    }
		    else {
		      url = url + "&parentid=" + parentid +"&parenttype=" + xtreeNode.getType();
		    }
		    
		    if( !org.apache.commons.lang.StringUtils.isEmpty(xtreeNode.getFunction()))
		    	url += "&function=" + xtreeNode.getFunction();
		    
		    if( !org.apache.commons.lang.StringUtils.isEmpty(xtreeNode.getChildrenURL()))
		    	url += "&childrenURL=" + xtreeNode.getChildrenURL();
		    url+="&times="+this.getTimes();
		    buf.append(" src=\"").append(
					com.sunrise.boss.ui.commons.xtree.StringUtils.escapeForXML(url
							.toString())).append("\" ");
		    System.out.println(buf.toString());
		    return buf.toString();
		  }
}
