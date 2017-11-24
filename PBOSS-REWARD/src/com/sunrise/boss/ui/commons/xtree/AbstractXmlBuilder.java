package com.sunrise.boss.ui.commons.xtree;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.StringUtils;

public abstract class AbstractXmlBuilder implements XmlBuilder {
	
  private static Log log = LogFactory.getLog(AbstractXmlBuilder.class);
  
  protected User user;
  
  public AbstractXmlBuilder() {
  }

  public String getXml(XTreeNode xtreeNode) throws Exception {
    StringBuffer buf = new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?>"); //
    try {
		buf.append("<tree>\n");
		try {
		  String childXml = getChildXml(xtreeNode);	
		  
		  if(!org.apache.commons.lang.StringUtils.isEmpty(childXml))
			  buf.append( childXml );
		  else
			  buf.append("<tree text=\"-----\" />");
		}
		catch (Exception ex) {
		  ex.printStackTrace();
		  if(log.isInfoEnabled()) log.info(ex);
		}
		buf.append("</tree>");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return buf.toString();
  }

  public abstract String getChildXml(XTreeNode xtreeNode) throws Exception;
  
  protected abstract boolean isLeaf(XTreeNode xtreeNode)  throws Exception;

  public String getNodeString(XTreeNode xtreeNode) throws Exception {
    StringBuffer buf = new StringBuffer("");
    buf.append("<tree");
    buf.append(getTextString(xtreeNode));
    buf.append(getActionString(xtreeNode));
    buf.append(getSrcString(xtreeNode));
    buf.append("/>\n");
    return buf.toString();
  }

  /**
   * 默认的TextString的实现
   * @param name String
   * @return String
   */
  protected String getTextString(XTreeNode xtreeNode) throws Exception {
    StringBuffer buf = new StringBuffer("");
    String id = xtreeNode.getId();
    String text = xtreeNode.getText();
    text = StringUtils.escapeForXML(text);
    buf.append(" text=\"").append("(" + id + ")" + text).append("\" ");
    return buf.toString();
  }


  /**
   * 默认的SrcString的实现
   * @param parentid String
   * @param url String
   * @return String
   */
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
    
    url = StringUtils.escapeForXML(url);
    buf.append(" src=\"").append(url).append("\" ");
    return buf.toString();
  }

  /**
   * 默认的ActionString的实现
   * @param parentid String
   * @param jsfunction String
   * @return String
   */
  protected String getActionString(XTreeNode xtreeNode) throws Exception {
    String parentid = xtreeNode.getParentId();
    String id = xtreeNode.getId();
    String text = xtreeNode.getText();
    String url = xtreeNode.getUrl();
    StringBuffer buf = new StringBuffer(80);
    if( !org.apache.commons.lang.StringUtils.isEmpty(url)) {
    	buf.append(" action=\"" + url +"\" ");
    }else {
    	String jsfunction = xtreeNode.getFunction();    	   
	    if ( !org.apache.commons.lang.StringUtils.isEmpty(jsfunction)){
	    	text = StringUtils.escapeForXML(text);
	    	buf.append(" action=\"javascript:").append(jsfunction).append("('").
	          append(id).append("','").append( text).append("','").append( xtreeNode.getType()).append("')\" ");
	    }
    }
    return buf.toString();
  }

	/**
	 * @return Returns the user.
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
