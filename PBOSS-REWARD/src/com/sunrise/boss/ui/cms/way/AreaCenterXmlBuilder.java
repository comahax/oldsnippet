package com.sunrise.boss.ui.cms.way;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.*;
import com.sunrise.boss.business.cms.citycompany.persistent.*;
import com.sunrise.boss.business.cms.way.persistent.*;
import com.sunrise.boss.delegate.cms.citycompany.*;
import com.sunrise.boss.delegate.cms.way.*;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.boss.ui.commons.xtree.*;

public class AreaCenterXmlBuilder  extends AbstractXmlBuilder {
	
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
	
	CitycompanyDelegate delegate = new CitycompanyDelegate();
	List citycoms = (List)delegate.getCitycompanysOfCenter(parentid, user).getDatas();
	
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
	WayDelegate wayDelegate = new WayDelegate();
	List ways =(List) wayDelegate.getWaysOfCenter(parentid, user).getDatas();	
	
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
