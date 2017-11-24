/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-8-28
 */
package com.sunrise.boss.ui.cms.way;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.areacenter.AreacenterDelegate;
import com.sunrise.boss.delegate.cms.citycompany.CitycompanyDelegate;
import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.cms.operation.OpnFifthXmlBuilder;
import com.sunrise.boss.ui.cms.operation.OpnXmlBuilder;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;
import com.sunrise.boss.ui.commons.xtree.XmlBuilder;


/**
 * WayTreeBean
 * <br> Description: class WayTreeBean
 * <br> Company: Maywide,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-8-28
 */
public class WayTreeBean {	
	
	public static final String TYPE_GMCC = "GMCC";
	public static final String TYPE_AREACENTER = "Areacenter";
	public static final String TYPE_CITYCOM = "Citycom";
	public static final String TYPE_COUNTYCOM = "Countycom";
	public static final String TYPE_WAY = "Way";
	public static final String TYPE_DEFAULT = TYPE_WAY;
	public static final String TYPE_ADIMAREA="adimarea";//行政区划
	public static final String TYPE_ORG="org";//组织结构
	public static final String TYPE_OPN="opn";//业务类型
	public static final String TYPE_OPNFIFTH="opn5";//只选择第五层业务类型
	
	
	private String childrenURL;
	private String function;
	private String showDisabled = "false";
	private String queryText;
	private String orgtype;
	private String opntype;
	private String currentime;
	private String waytype;
	private String waysubtype;
	private String runmode;
	private String layer;
	
	public String outputXml(HttpServletRequest request) throws Exception {
		User user = (User)(request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER));
		//changed by liwenjing
		//if(user == null) user = new User();
		
		String id = request.getParameter("parentid");
		String type = request.getParameter("parenttype");
		
		if(id == null) id = "-1";		
//		throw new RuntimeException("id must be specified for xtree.");
		if(StringUtils.isEmpty(type)) type = TYPE_DEFAULT;
		
		String xml = "";
		//根据type的不同,使用不同的 xmlBuilder 来生成节点.
		if(TYPE_GMCC.equals(type))
			xml = buildGMCC(id,user);
		else if(TYPE_AREACENTER.equals(type))
			xml = buildAreacenter(id,user);
		else if(TYPE_CITYCOM.equals(type))
			xml = buildCitycom(id,user);
		else if(TYPE_COUNTYCOM.equals(type))
			xml = buildCountycom(id,user);
		else if(TYPE_ADIMAREA.equals(type))
			xml=buildAda(id,user);
		else if(TYPE_ORG.equals(type))
			xml=buildOrg(id,user);
		else if(TYPE_OPN.equals(type))
			xml=buildOpn(id, user);
		else if(TYPE_OPNFIFTH.equals(type))
			xml=buildOpnfifth(id, user);
		
		else
			xml = buildWay(id,user);		
		return xml;		
	}
	
	
	private String buildGMCC(String id,User user) throws Exception {
		XmlBuilder builder = new GMCCXmlBuilder(user);
		XTreeNode xtreeNode = new XTreeNode("GMCC", "GMCC" ,"广东移动通信有限公司",WayTreeBean.TYPE_GMCC);
		
		if(!StringUtils.isEmpty(function)) xtreeNode.setFunction( function );
		if(!StringUtils.isEmpty(childrenURL)) xtreeNode.setChildrenURL( childrenURL );    
	    String xml = builder.getXml(xtreeNode);
		return xml;
	}
	
	private String buildCountycom(String id, User user) throws Exception {
		XmlBuilder builder = new CountyComXmlBuilder(user);
		XTreeNode xtreeNode = new XTreeNode(id ,id,"Root",TYPE_COUNTYCOM);
		if(!StringUtils.isEmpty(function)) xtreeNode.setFunction( function );		
		if(!StringUtils.isEmpty(childrenURL)) xtreeNode.setChildrenURL( childrenURL ); 
		String xml = builder.getXml(xtreeNode);
		return xml;
	}

	private String buildCitycom(String id, User user) throws Exception {
		XmlBuilder builder = new CityComXmlBuilder(user);
		XTreeNode xtreeNode = new XTreeNode(id ,id,"Root",TYPE_CITYCOM);
		if(!StringUtils.isEmpty(function)) xtreeNode.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) xtreeNode.setChildrenURL( childrenURL ); 
		String xml = builder.getXml(xtreeNode);
		return xml;
	}

	
	
	private String buildAreacenter(String id,User user) throws Exception {
		XmlBuilder builder = new AreaCenterXmlBuilder(user);
		XTreeNode xtreeNode = new XTreeNode(id ,id,"Root",TYPE_AREACENTER);
		if(!StringUtils.isEmpty(function)) xtreeNode.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) xtreeNode.setChildrenURL( childrenURL ); 
		String xml = builder.getXml(xtreeNode);
		return xml;
	}
	
	private String buildOrg(String id,User user) throws Exception{
		OrgXmlBuilder builder=new OrgXmlBuilder(user);
		XTreeNode node=new XTreeNode(id,id,"Root",TYPE_ORG);
		if(!StringUtils.isEmpty(function)) node.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) node.setChildrenURL( childrenURL ); 
		if(!StringUtils.isEmpty(queryText)) builder.setOrgproxy(queryText);
		builder.setOrgtype(orgtype);
		builder.setCurrentime(currentime);
		String xml = builder.getXml(node);
		return xml;
	}
	
	public String buildOpn(String id,User user) throws Exception{
		OpnXmlBuilder builder = new OpnXmlBuilder(user);
		XTreeNode node=new XTreeNode(id,id,"Root",TYPE_OPN);

		if(!StringUtils.isEmpty(function)) node.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) node.setChildrenURL( childrenURL );
		if(!StringUtils.isEmpty(queryText)) builder.setOpnproxy(queryText);
		builder.setOpntype(opntype);
		builder.setCurrentime(currentime);
		String xml = builder.getXml(node);
		return xml;
	}

	
	public String buildOpnfifth(String id,User user) throws Exception{
		OpnFifthXmlBuilder builder = new OpnFifthXmlBuilder(user);
		XTreeNode node=new XTreeNode(id,id,"Root",TYPE_OPNFIFTH);

		if(!StringUtils.isEmpty(function)) node.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) node.setChildrenURL( childrenURL );
		if(!StringUtils.isEmpty(queryText)) builder.setOpnproxy(queryText);
		builder.setOpntype(opntype);
		builder.setCurrentime(currentime);
		String xml = builder.getXml(node);
		return xml;
	}
	
	private String buildAda(String id,User user) throws Exception{
		AdaXmlBuilder builder=new AdaXmlBuilder(user);
		XTreeNode node=new XTreeNode(id,id,"Root",TYPE_ADIMAREA);
		if(!StringUtils.isEmpty(function)) node.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) node.setChildrenURL( childrenURL ); 
		if(!StringUtils.isEmpty(queryText)) builder.setTimes(queryText);
		String xml = builder.getXml(node);
		return xml;
	}

	private String buildWay(String id,User user) throws Exception {
		WayXmlBuilder builder = new WayXmlBuilder(user);
		XTreeNode xtreeNode = new XTreeNode(id ,id,"Root",TYPE_WAY);
		if(!StringUtils.isEmpty(function)) xtreeNode.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) xtreeNode.setChildrenURL( childrenURL ); 
		builder.setShowDisabled(showDisabled);
		builder.setQueryText(queryText);
		builder.setWaytype(waytype);
		builder.setWaysubtype(waysubtype);
		builder.setCurrenttime(currentime);
		builder.setRunmode(runmode);
		builder.setLayer(layer);
		String xml = builder.getXml(xtreeNode);
		return xml;
	}
	
	public static int getChildrenCount(XTreeNode xtreeNode,User user) throws Exception {
		String parentId = xtreeNode.getId();
		String type = xtreeNode.getType();
		  
		int childrenCount ;
		//根据type的不同,使用不同的 xmlBuilder 来生成节点.
		if(TYPE_GMCC.equals(type))
			childrenCount = getChildrenCountOfHeadquarter(parentId,user);
		else if(TYPE_AREACENTER.equals(type))
			childrenCount = getChildrenCountOfAreacenter(parentId,user);
		else if(TYPE_CITYCOM.equals(type))
			childrenCount = getChildrenCountOfCitycom(parentId,user);
		else if(TYPE_COUNTYCOM.equals(type))
			childrenCount = getChildrenCountOfCountycom(parentId,user);
		else if (TYPE_ADIMAREA.equals(type))
			childrenCount= getChildrenCountOfAda(parentId,user);
		else if("SUBNET".equals(parentId))
			childrenCount=getChildrenSubNet(parentId,user);
		else
			childrenCount = getChildrenCountOfWay(parentId,user);
		return childrenCount;
	}

	private static int getChildrenSubNet(String parentadacode,User user) throws Exception{
		WayDelegate delegate = new WayDelegate();
		 return delegate.doQueryNetWork(user.getWayid(), user).size();
	}
	private static int getChildrenCountOfAda(String parentadacode,User user) throws Exception{
		AdimareaDelegate delegate=new AdimareaDelegate();
		List list=delegate.doQueryUpperada(parentadacode, user);
		return list.size();
	}

	private static int getChildrenCountOfWay(String parentId,User user) throws Exception {
		WayDelegate delegate = new WayDelegate();
		List ways = (List)delegate.getSubways(parentId, user).getDatas();
		return ways.size();
	}


	private static int getChildrenCountOfCountycom(String parentId,User user) throws Exception {
		WayDelegate wayDelegate = new WayDelegate();
		List ways =(List) wayDelegate.getWaysOfCountycom(parentId, user).getDatas();	
		return ways.size();
	}
	

	private static int getChildrenCountOfCitycom(String parentId, User user) throws Exception {
		CntycompanyDelegate delegate = new CntycompanyDelegate();
		List countycoms = (List)delegate.getCntycompanysOfCity(parentId, user).getDatas();
		
		WayDelegate wayDelegate = new WayDelegate();
		List ways =(List) wayDelegate.getWaysOfCitycom(parentId, user).getDatas();	
		return countycoms.size() + ways.size();
	}
	

	private static int getChildrenCountOfAreacenter(String parentId,User user) throws Exception {
		CitycompanyDelegate delegate = new CitycompanyDelegate();
		List citycoms = (List)delegate.getCitycompanysOfCenter(parentId, user).getDatas();
		
		WayDelegate wayDelegate = new WayDelegate();
		List ways =(List) wayDelegate.getWaysOfCenter(parentId, user).getDatas();	
		return citycoms.size() + ways.size();
	}


	private static int getChildrenCountOfHeadquarter(String parentId,User user) throws Exception {
		AreacenterDelegate delegate = new AreacenterDelegate();
		List areaCenters = (List)delegate.getCenters(user).getDatas();
		
		WayDelegate wayDelegate = new WayDelegate();
		List ways =(List) wayDelegate.getWaysOfHeadquarter(user).getDatas();	
		
		return areaCenters.size() + ways.size();		
	}


	public String getChildrenURL() {
		return childrenURL;
	}


	public void setChildrenURL(String childrenURL) {
		this.childrenURL = childrenURL;
	}


	public String getFunction() {
		return function;
	}


	public void setFunction(String function) {
		this.function = function;
	}


	public String getShowDisabled() {
		return showDisabled;
	}


	public void setShowDisabled(String showDisabled) {
		this.showDisabled = showDisabled;
	}


	public String getQueryText() {
		return queryText;
	}


	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}


	public String getOrgtype() {
		return orgtype;
	}


	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}


	public String getCurrentime() {
		return currentime;
	}


	public void setCurrentime(String currentime) {
		this.currentime = currentime;
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


	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}


	public String getOpntype() {
		return opntype;
	}


	public void setOpntype(String opntype) {
		this.opntype = opntype;
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
