package com.gmcc.pboss.web.channel.way.tree;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.*;

import com.gmcc.pboss.business.channel.citycompany.CitycompanyVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.citycompany.Citycompany;
import com.gmcc.pboss.control.channel.citycompany.CitycompanyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class AreaCenterXmlBuilder extends AbstractXmlBuilder {
	
  private static Log log = LogFactory.getLog(CityComXmlBuilder.class);	  
  
  public AreaCenterXmlBuilder(User user) {
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
  	String parentid = xtreeNode.getParentId();
	if(log.isInfoEnabled()) log.info("区域中心:" + parentid);
	
	Citycompany citycompany = (Citycompany) BOFactory.build(CitycompanyBO.class, user);
	List citycoms = (List)citycompany.doGetCitycompanysOfCenter(parentid).getDatas();
	
	for(int i=0;i<citycoms.size(); i++) {
		CitycompanyVO citycompanyVO =(CitycompanyVO )citycoms.get(i);		
		XTreeNode cityNode = new XTreeNode(citycompanyVO.getCitycompid(),parentid ,citycompanyVO.getCitycompname(),WayTreeBean.TYPE_CITYCOM);
		if(!StringUtils.isEmpty(xtreeNode.getFunction())) 
			cityNode.setFunction(xtreeNode.getFunction());
		if(!StringUtils.isEmpty(xtreeNode.getChildrenURL())) 
			cityNode.setChildrenURL( xtreeNode.getChildrenURL());
	    buf.append(getNodeString(cityNode));
	}
	
	//获取直属渠道
//	查找直属渠道, 条件:上级标识,区域中心标识,市公司标识,县公司标识全为 -1
	Way way = (Way) BOFactory.build(WayBO.class, user);
	List ways =(List) way.doGetWaysOfCenter(parentid).getDatas();	
	
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
