package com.gmcc.pboss.web.common.xtree;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunrise.jop.common.utils.lang.StringUtils;

/**
 * WebFXLoadTree工具类
 * @author Canigar
 */
public class WebFXLoadTreeConfiger {

	private static final Logger log = Logger.getLogger(WebFXLoadTreeConfiger.class);
	
	// 下面注释描述的层是XML文件里面嵌套的层次
	public final static String TREE_HEAD_0 = "tree";
	// 下面注释描述的层是XML文件里面树结构的常用属性
	public final static String TREE_NODE_ATTR_TEXT = "text";
	public final static String TREE_NODE_ATTR_ACTION = "action";
	public final static String TREE_NODE_ATTR_SRC = "src";
	
	/**
	 * 将xml文件转换成Node列表存储
	 * @param xmlStr
	 * @return
	 */
	public static List<WebFXLoadTreeNode> getNodePackage(String xmlStr){
		
		List<WebFXLoadTreeNode> nodesList = new LinkedList<WebFXLoadTreeNode>();
		SAXReader saxReader = new SAXReader();
		try {
			InputStream is = new ByteArrayInputStream(xmlStr.getBytes());
			Document document = saxReader.read(is);
			List dynamicList = document.selectNodes(TREE_HEAD_0 + "/" + TREE_HEAD_0);
			for(Iterator itt = dynamicList.iterator(); itt.hasNext() ; ){
				Element ele = (Element) itt.next();
				String text = null,action = null,src = null;
				if(ele.attribute(ele.getQName(TREE_NODE_ATTR_TEXT)) != null){
					text = ele.attribute(ele.getQName(TREE_NODE_ATTR_TEXT)).getValue().trim();
				}
				if(ele.attribute(ele.getQName(TREE_NODE_ATTR_ACTION)) != null){
					action = ele.attribute(ele.getQName(TREE_NODE_ATTR_ACTION)).getValue().trim();
				}
				if(ele.attribute(ele.getQName(TREE_NODE_ATTR_SRC)) != null){
					src = ele.attribute(ele.getQName(TREE_NODE_ATTR_SRC)).getValue().trim();
				}
				WebFXLoadTreeNode node = new WebFXLoadTreeNode(text,src,action);
				nodesList.add(node);
			}
			
		}catch (Exception e) {
			log.error("WebFxLoadTreeConfiger config init error", e);
			e.printStackTrace();
			// TODO: handle exception
		}
		return nodesList;
	}
	
	/**
	 * 节点转化成XML回写页面,只刷出最常使用的三个,以后需要再增加
	 * @param node
	 * @return
	 */
	public static String node2XmlContent(WebFXLoadTreeNode node){
		StringBuffer sb = new StringBuffer("<tree ");
		if(!StringUtils.isEmpty(node.getSText())){
			sb.append("text=\"").append(node.getSText()).append("\" ");
		}
		if(!StringUtils.isEmpty(node.getSAction())){
			sb.append("action=\"").append(node.getSAction()).append("\" ");
		}
		if(!StringUtils.isEmpty(node.getSXmlSrc())){
			sb.append("src=\"").append(node.getSXmlSrc()).append("\" ");
		}
		sb.append("/>");
		return sb.toString();
	}
	
	/**
	 * 考虑以后将这堆东西使用FreeMaker回写页面,否则太麻烦了...
	 * 文件头
	 * @return
	 */
	public static String node2XmlHead(){
		return "<?xml version=\"1.0\" encoding=\"GBK\"?><tree>\n";
	}
	
	/**
	 * 考虑以后将这堆东西使用FreeMaker回写页面,否则太麻烦了...
	 * 文件尾
	 * @return
	 */
	public static String node2XmlEnd(){
		return "</tree>";
	}
	
	/**
	 * 考虑以后将这堆东西使用FreeMaker回写页面,否则太麻烦了...
	 * List里面还有Node剩余,则末尾行添加改句 
	 * @param parentNode 父节点信息
	 * @return
	 */
	public static String node2XmlRemainTag(String parentNodeKey){
		return "<tree text=\"...(点击展示下批数据)\" action=\"javascript:rebuildWebFXLoadTree('/common/rebuildWebTreeXml.jsp?parentNodeKey="+parentNodeKey+"')\"/>";
	}
	
}
