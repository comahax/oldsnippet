package com.sunrise.boss.ui.cms.way;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.cms.commons.CMSUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.xtree.AbstractXmlBuilder;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;

public class WayXmlBuilder  extends AbstractXmlBuilder {
  private String showDisabled = "false";
  private String queryText;
  private String waytype="";
  private String waysubtype="";
  private String runmode="";
  private String currenttime="";
  private String layer="";
  public WayXmlBuilder(User user) {
	  this.user = user;
  }
  
  /**
   * getChildXml
   *
   * @param xtreeNode XTreeNode
   * @return String
   */
  public String getChildXml(XTreeNode xtreeNode) throws Exception {    
    String nodeType = xtreeNode.getType();
    
    if("Way".equals(nodeType)) {    	
    	String upperwayid = xtreeNode.getId();    	
	   List datas = querySubWays(upperwayid);
	    
	    StringBuffer buf = new StringBuffer(40 * datas.size());
	    if(StringUtils.isNotEmpty(layer)){
	    	XTreeNode subnetnode=this.doCheckisnetwork(xtreeNode);
	    	if(subnetnode!=null){
	    		buf.append(getNodeString(subnetnode));
	    	}
	    }
	    for (Iterator it = datas.iterator(); it.hasNext(); ) {
	      WayVO wayVO = (WayVO) it.next();
	      //����XTreeNode��parentid��nameΪ��ǰ��������Ӧ����
	      XTreeNode node = new XTreeNode(wayVO.getWayid(), upperwayid ,wayVO.getWayname(),WayTreeBean.TYPE_WAY);
	      if(StringUtils.isNotBlank(xtreeNode.getFunction()) && CMSUtils.doGetwaytype(wayVO, waytype, waysubtype,runmode)){
	    	  node.setFunction(xtreeNode.getFunction());
	      }else if(StringUtils.isEmpty(xtreeNode.getFunction()) && (CMSUtils.doGetwaytype(wayVO, waytype, waysubtype,runmode))){
	    	  node.setFunction("selectWay");
	      }
	      if(StringUtils.isNotBlank(xtreeNode.getChildrenURL())) 
				node.setChildrenURL( xtreeNode.getChildrenURL());
	      buf.append(getNodeString(node));
	    }
	    
	    return buf.toString();
    }   
    return "";
  }
  
  private XTreeNode doCheckisnetwork(XTreeNode xtreeNode) throws Exception{
	  WayDelegate delegate = new WayDelegate();
	  if(delegate.doCheckisNetWork(user.getWayid(), user)){
		  List list=delegate.doQueryNetWork(user.getWayid(), user);
		  XTreeNode node = new XTreeNode("SUBNET", user.getWayid() ,"��Ͻ����(����)",WayTreeBean.TYPE_WAY);
		  node.setChildrenURL(xtreeNode.getChildrenURL());
		  return node;
		  
	  }
	  return null;
  }
  
  private List doQuerynetwork() throws Exception{
	  WayDelegate delegate = new WayDelegate();
	  return delegate.doQueryNetWork(user.getWayid(), user);
	  
  }
  
  /**
   * Ĭ�ϵ�SrcString��ʵ��
   * @param parentid String
   * @param url String
   * @return String
   */
  protected String getSrcString(XTreeNode xtreeNode) throws Exception {
	    String parentid = xtreeNode.getId();
	    StringBuffer url = new StringBuffer(100);
	    url.append( xtreeNode.getChildrenURL() );
	    if(isLeaf(xtreeNode) || url == null || url.length() < 1){
	      return "";
	    }
	    StringBuffer buf = new StringBuffer("");
	    if (url.indexOf("?") < 0) {
	      url = url.append( "?parentid=" ).append( parentid ).append("&parenttype=" ).append( xtreeNode.getType());
	    }
	    else {
	      url = url.append( "&parentid=" ).append( parentid ).append("&parenttype=" ).append( xtreeNode.getType());
	    }
	    url.append("&time=").append(currenttime);
	    if( StringUtils.isNotBlank(xtreeNode.getFunction()))
	    	url.append( "&function=" ).append( xtreeNode.getFunction());
	    
	    if( StringUtils.isNotBlank(xtreeNode.getChildrenURL()))
	    	url.append("&childrenURL=" ).append( xtreeNode.getChildrenURL());
	    
	    url.append("&showDisabled=" ).append( showDisabled);
	    
	    if( StringUtils.isNotBlank( queryText ))
	    	url.append("&queryText=" ).append( queryText );
	    if(StringUtils.isNotEmpty(waytype))
	    	url.append("&waytype=").append(waytype);
	    if(StringUtils.isNotEmpty(waysubtype))
	    	url.append("&waysubtype=").append(waysubtype);
	    if(StringUtils.isNotEmpty(runmode))
	    	url.append("&runmode=").append(runmode);

	    buf.append(" src=\"")
	    			.append(com.sunrise.boss.ui.commons.xtree.StringUtils.escapeForXML(url.toString()))
	    			.append("\" ");
	    return buf.toString();
  }
  
  protected List querySubWays(String upperwayid) throws Exception {
	   if("SUBNET".equals(upperwayid)){
		   return this.doQuerynetwork();
	   }
	    boolean bShowDisabled = "true".equals(showDisabled);
	    WayDelegate delegate = new WayDelegate();
	  	WayListVO listVO = new WayListVO();
	  	
	  	List selectFields = new ArrayList(4);
	  	selectFields.add("wayid");
	  	selectFields.add("wayname");
	  	selectFields.add("upperwayid");
	  	selectFields.add("waystate");
	  	selectFields.add("waytype");
	  	selectFields.add("waysubtype");
	  	selectFields.add("runmode");
	  	listVO.setSelectFields(selectFields);
	  	
	  	listVO.set_se_upperwayid(upperwayid);
	  	
	  	if(StringUtils.isNotBlank(queryText)) {
	  		//�����ѯ������ֻ�������֣���ĸ���򰴱������ģ����ѯ�������������ƽ���ģ����ѯ
	  		if(StringUtils.isAlphanumericSpace(queryText))
	  			listVO.set_sk_wayid(queryText);
	  		else
	  			listVO.set_sk_wayname(queryText);
	  	}
	  	if(!bShowDisabled)	//ȱʡ����ʾ���õ���Ŀ
	  		listVO.set_ne_waystate(new Short((short)1));
	  	
	  	listVO.set_pagesize("0"); //����ҳ
	  	listVO.set_sne_waytype("RIVL");//���ӹ��˾�����������
	  	DataPackage dataPackage = delegate.doQuery(listVO, user);
	  	Collection datas = dataPackage.getDatas();
	  	
	  	//��̬��ֻ�ܲ�ֱ���¼��� ��˰����ƺͱ��룬�ὫĿ�������ĸ������ų�������ˣ���Ҫ�����ѯ��������������
	  	listVO.set_sk_wayid(null);
	  	listVO.set_sk_wayname(null);
	  	DataPackage allPossibleWays = delegate.doQuery(listVO, user);//��ǰ�������������
	  	DataPackage possibleUpperWays = delegate.queryUpperWaysAndMeByIdOrName(queryText, bShowDisabled , user);//�������ͽṹ����ѯ�����������������Ľ��
	  	
	  	List allPossibleWaysList = (List)allPossibleWays.getDatas();
	  	List possibleUpperWaysList = (List)possibleUpperWays.getDatas();
	  	
	  	List resultList = new ArrayList(allPossibleWaysList.size());
	  	//resultList.addAll(allPossibleWaysList);
	  	
	  	//�жϵ�ǰ������Ƿ��б�����ƥ��©���ġ�
	  	for(int i=0;i<allPossibleWaysList.size();i++) {
	  		WayVO wayVO = (WayVO)allPossibleWaysList.get(i);
	  		if(possibleUpperWaysList.contains(wayVO))
	  			resultList.add(wayVO);
	  	}
//	  	allPossibleWays.setDatas(resultList);
//	  	allPossibleWays.setRowCount(resultList.size());	  	
	  	
	  	//�����ӽڵ����ƥ�䣬�����ڵ㲻ƥ�䱻��©�ġ�
	  	for(int i=0;i<resultList.size();i++) {
	  		WayVO wayVO = (WayVO)resultList.get(i);
	  		if(!datas.contains(wayVO))
	  			datas.add(wayVO);
	  	}	 
	  	dataPackage.setDatas(datas);
	  	dataPackage.setRowCount(datas.size());
	  	return (List)datas;
  }
  protected boolean isLeaf(XTreeNode xtreeNode) throws Exception {
	  return WayTreeBean.getChildrenCount(xtreeNode, user) < 1;
  }

	public String getQueryText() {
		return queryText;
	}
	
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getShowDisabled() {
		return showDisabled;
	}

	public void setShowDisabled(String showDisabled) {
		this.showDisabled = showDisabled;
	}

	public String getWaysubtype() {
		return waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytpe) {
		this.waytype = waytpe;
	}

	public String getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(String currenttime) {
		this.currenttime = currenttime;
	}

	public String getRunmode() {
		return runmode;
	}

	public void setRunmode(String runmode) {
		this.runmode = runmode;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}  
	
}
