package com.sunrise.boss.ui.cms.way;

import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.areacenter.persistent.*;
import com.sunrise.boss.business.cms.way.persistent.*;
import com.sunrise.boss.delegate.cms.areacenter.*;
import com.sunrise.boss.delegate.cms.way.*;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.boss.ui.commons.xtree.*;

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
    //����XTreeNode��parentid��nameΪ��ǰ��������Ӧ����
    //�����������ļ� GMCC ֱ������
    
    StringBuffer buf = new StringBuffer(1024);
    String parentId = xtreeNode.getId();
    AreacenterDelegate delegate = new AreacenterDelegate();
	List areaCenters = (List)delegate.getCenters(user).getDatas();
	
	for(int i=0;i<areaCenters.size(); i++) {
		AreacenterVO areacenterVO = (AreacenterVO)areaCenters.get(i);
		XTreeNode centerNode = new XTreeNode(areacenterVO.getCenterid(), parentId ,areacenterVO.getCentername(),WayTreeBean.TYPE_AREACENTER);
		if(!StringUtils.isEmpty(xtreeNode.getFunction())) 
			centerNode.setFunction(xtreeNode.getFunction());
		if(!StringUtils.isEmpty(xtreeNode.getChildrenURL())) 
			centerNode.setChildrenURL( xtreeNode.getChildrenURL());
		
	    buf.append(getNodeString(centerNode));
	}
	
	//����ֱ������, ����:�ϼ���ʶ,�й�˾��ʶ,�ع�˾��ʶȫΪ -1, �������ı�ʶΪ��
	WayDelegate wayDelegate = new WayDelegate();
	List ways =(List) wayDelegate.getWaysOfHeadquarter(user).getDatas();	
	
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
