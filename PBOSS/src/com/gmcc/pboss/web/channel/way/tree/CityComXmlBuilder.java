package com.gmcc.pboss.web.channel.way.tree;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.*;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class CityComXmlBuilder  extends AbstractXmlBuilder {
	
  private static Log log = LogFactory.getLog(CityComXmlBuilder.class);
  
  public CityComXmlBuilder(User user) {
	  this.user = user;
  }
  
  /**
   * getChildXml
   *
   * @param xtreeNode XTreeNode
   * @return String
   */
  public String getChildXml(XTreeNode xtreeNode) throws Exception {
	  	StringBuffer buf = new StringBuffer(1024);
	  	String parentid = xtreeNode.getParentId(); // cityid
		if(log.isInfoEnabled()) log.info("市公司:" + parentid);
		
		Cntycompany cntycompany = (Cntycompany) BOFactory.build(CntycompanyBO.class, user);
		List countycoms = (List)cntycompany.doGetCntycompanysOfCity(parentid).getDatas();
				
		for(int i=0;i<countycoms.size(); i++) {
			CntycompanyVO cntycompanyVO =(CntycompanyVO )countycoms.get(i);
			XTreeNode cntyNode = new XTreeNode(cntycompanyVO.getCountycompid(),parentid ,cntycompanyVO.getCountycompname(),WayTreeBean.TYPE_COUNTYCOM);
			
			if(!StringUtils.isEmpty(xtreeNode.getFunction())) 
				cntyNode.setFunction(xtreeNode.getFunction());
			if(!StringUtils.isEmpty(xtreeNode.getChildrenURL())) 
				cntyNode.setChildrenURL( xtreeNode.getChildrenURL());
		    buf.append(getNodeString(cntyNode));
		}
		
//		查找直属渠道, 条件:上级标识,市公司标识,县公司标识全为 -1, 区域中心标识为空
		Way way = (Way) BOFactory.build(WayBO.class, user);
		List ways =(List) way.doGetWaysOfCitycom(parentid).getDatas();	
		
		for(int i=0;i<ways.size(); i++) {
			WayVO wayvo = (WayVO)ways.get(i);
			XTreeNode wayNode = new XTreeNode(wayvo.getWayid(), parentid ,wayvo.getWayname(),WayTreeBean.TYPE_WAY);
			if(!StringUtils.isEmpty(xtreeNode.getFunction())) 
				wayNode.setFunction(xtreeNode.getFunction());
			if(!StringUtils.isEmpty(xtreeNode.getChildrenURL())) 
				wayNode.setChildrenURL( xtreeNode.getChildrenURL());
		    buf.append(getNodeString(wayNode));
		}	
	    return buf.toString();
  }
  
  protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
	  return WayTreeBean.getChildrenCount(xtreeNode, getUser()) < 1;
  }  
}
