package com.gmcc.pboss.web.channel.way.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.common.xtree.AbstractXmlBuilder;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class WayXmlBuilder  extends AbstractXmlBuilder {
	
  private String showDisabled = "false";
  private String queryText;
  private String waytype="";
  private String waysubtype="";
  private String runmode="";
  private String currenttime="";
  private String layer="";
  private Map<String,String> waytypeMap = new HashMap<String,String>();
  private Map<String,String> waysubtypeMap = new HashMap<String,String>();
  
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
	  
	Way way = (Way) BOFactory.build(WayBO.class, user);
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
	    if (StringUtils.isNotEmpty(waytype)) {
			String[] waytypes = StringUtils.split(waytype, "\\|");
			for(String wt : waytypes) {
				waytypeMap.put(wt, wt);
			}
		}
	    if (StringUtils.isNotEmpty(waysubtype)) {
			String[] waytypes = StringUtils.split(waysubtype, "\\|");
			for(String wt : waytypes) {
				waysubtypeMap.put(wt, wt);
			}
		}
	    
	    for (Iterator it = datas.iterator(); it.hasNext(); ) {
	      WayVO wayVO = (WayVO) it.next();
	      //����XTreeNode��parentid��nameΪ��ǰ��������Ӧ����
	      XTreeNode node = new XTreeNode(wayVO.getWayid(), upperwayid ,wayVO.getWayname(),WayTreeBean.TYPE_WAY);
	      if(StringUtils.isNotBlank(xtreeNode.getFunction()) && way.doGetwaytype(wayVO, waytypeMap, waysubtypeMap,runmode)){
	    	  node.setFunction(xtreeNode.getFunction());
	      }else if(StringUtils.isEmpty(xtreeNode.getFunction()) && (way.doGetwaytype(wayVO, waytypeMap, waysubtypeMap,runmode))){
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
	  Way way = (Way) BOFactory.build(WayBO.class, user);
	  if(way.doCheckisNetWork(user.getWayid())){
		  List list=way.doQueryNetWork(user.getWayid());
		  XTreeNode node = new XTreeNode("SUBNET", user.getWayid() ,"��Ͻ����(����)",WayTreeBean.TYPE_WAY);
		  node.setChildrenURL(xtreeNode.getChildrenURL());
		  return node;
		  
	  }
	  return null;
  }
  
  private List doQuerynetwork() throws Exception{
	  Way way = (Way) BOFactory.build(WayBO.class, user);
	  return way.doQueryNetWork(user.getWayid());
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
	    			.append(com.sunrise.jop.common.utils.lang.StringUtils.escapeForXML(url.toString()))
	    			.append("\" ");
	    return buf.toString();
  }
  
  protected List querySubWays(String upperwayid) throws Exception {
	   Way way = (Way) BOFactory.build(WayBO.class, user);
	   if("SUBNET".equals(upperwayid)){
		   return this.doQuerynetwork();
	   }
	    boolean bShowDisabled = "true".equals(showDisabled);
	  	WayDBParam listVO = new WayDBParam();
	  	
	  	listVO.set_se_upperwayid(upperwayid);
	  	
	  	if(StringUtils.isNotBlank(queryText)) {
	  		//�����ѯ������ֻ�������֣���ĸ���򰴱������ģ����ѯ�������������ƽ���ģ����ѯ
	  		if(StringUtils.isAlphanumericSpace(queryText))
	  			listVO.set_sk_wayid(queryText);
	  		else
	  			listVO.set_sk_wayname(queryText);
	  	}
	  	if(!bShowDisabled)	//ȱʡ����ʾ���õ���Ŀ
	  		listVO.set_ne_waystate("1");
	  	
	  	listVO.set_pagesize("0"); //����ҳ
	  	listVO.set_sne_waytype("RIVL");//���ӹ��˾�����������
	  	DataPackage dataPackage = way.doQuery(listVO);
	  	Collection datas = dataPackage.getDatas();
	  	
	  	DataPackage possibleUpperWays = way.doQueryUpperWaysAndMeByIdOrName(queryText, bShowDisabled);//�������ͽṹ����ѯ�����������������Ľ��
	  	List<WayVO> possibleUpperWaysList = (List<WayVO>)possibleUpperWays.getDatas();
	  	StringBuffer wayids = new StringBuffer();
	  	for (WayVO wayVO : possibleUpperWaysList) {
	  		wayids.append("'").append(wayVO.getWayid()).append("',");
		}
	  	
	  	listVO.set_sk_wayid(null);
	  	listVO.set_sk_wayname(null);
	  	List resultList = new ArrayList(possibleUpperWaysList.size());
	  	if (wayids.length() > 0) {
	  		listVO.set_sql_waycondition(" wayid in (" + wayids.toString().substring(0, wayids.length()-1) + ")");
		  	//��̬��ֻ�ܲ�ֱ���¼��� ��˰����ƺͱ��룬�ὫĿ�������ĸ������ų�������ˣ���Ҫ�����ѯ��������������
	  		//��ѯ����ǰ����ﱻ����ƥ��©���ġ�
		  	DataPackage allPossibleWays = way.doQuery(listVO);//��ǰ�������������
		  	resultList = allPossibleWays.getDatas();
	  	}
	  	
	  	//�����ӽڵ����ƥ�䣬�����ڵ㲻ƥ�䱻��©�ġ�
	  	for(int i=0;i<resultList.size();i++) {
	  		WayVO wayVO = (WayVO)resultList.get(i);
	  		if(!datas.contains(wayVO))
	  			datas.add(wayVO);
	  	}	 
	  	dataPackage.setDatas((List)datas);
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
