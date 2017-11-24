package com.sunrise.boss.ui.cms.way;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.*;

import com.sunrise.boss.business.cms.cntycompany.persistent.*;
import com.sunrise.boss.business.cms.way.persistent.*;
import com.sunrise.boss.delegate.cms.cntycompany.*;
import com.sunrise.boss.delegate.cms.way.*;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.boss.ui.commons.xtree.*;

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
		
		CntycompanyDelegate delegate = new CntycompanyDelegate();
		List countycoms = (List)delegate.getCntycompanysOfCity(parentid, user).getDatas();
				
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
		WayDelegate wayDelegate = new WayDelegate();
		List ways =(List) wayDelegate.getWaysOfCitycom(parentid, user).getDatas();	
		
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
