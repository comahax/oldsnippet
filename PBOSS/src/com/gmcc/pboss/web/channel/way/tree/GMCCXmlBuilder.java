package com.gmcc.pboss.web.channel.way.tree;

import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.areacenter.AreacenterVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.areacenter.Areacenter;
import com.gmcc.pboss.control.channel.areacenter.AreacenterBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class GMCCXmlBuilder  extends AbstractXmlBuilder {
  
  public GMCCXmlBuilder(User user) {
	  this.user = user;
  }
  
  /**
   * getChildXml
   *
   * @param xtreeNode XTreeNode
   * @return String
   */
  public String getChildXml(XTreeNode xtreeNode) throws Exception {    
    //更改XTreeNode的parentid和name为当前渠道的相应数据
    //查找区域中心及 GMCC 直属渠道
    
    StringBuffer buf = new StringBuffer(1024);
    String parentId = xtreeNode.getId();
    Areacenter areacenter = (Areacenter) BOFactory.build(AreacenterBO.class, user);
    
	List areaCenters = areacenter.doGetCenters().getDatas();
	
	for(int i=0;i<areaCenters.size(); i++) {
		AreacenterVO areacenterVO = (AreacenterVO)areaCenters.get(i);
		XTreeNode centerNode = new XTreeNode(areacenterVO.getCenterid(), parentId ,areacenterVO.getCentername(),WayTreeBean.TYPE_AREACENTER);
		if(!StringUtils.isEmpty(xtreeNode.getFunction())) 
			centerNode.setFunction(xtreeNode.getFunction());
		if(!StringUtils.isEmpty(xtreeNode.getChildrenURL())) 
			centerNode.setChildrenURL( xtreeNode.getChildrenURL());
		
	    buf.append(getNodeString(centerNode));
	}
	
	//查找直属渠道, 条件:上级标识,市公司标识,县公司标识全为 -1, 区域中心标识为空
	
	Way way = (Way) BOFactory.build(Way.class, user);
	List ways = way.doGetWaysOfHeadquarter().getDatas();	
	
	for(int i=0;i<ways.size(); i++) {
		WayVO wayvo = (WayVO)ways.get(i);
		XTreeNode wayNode = new XTreeNode(wayvo.getWayid(), parentId ,wayvo.getWayname(),WayTreeBean.TYPE_WAY);
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
