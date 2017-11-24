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
 * WebFXLoadTree������
 * @author Canigar
 */
public class WebFXLoadTreeConfiger {

	private static final Logger log = Logger.getLogger(WebFXLoadTreeConfiger.class);
	
	// ����ע�������Ĳ���XML�ļ�����Ƕ�׵Ĳ��
	public final static String TREE_HEAD_0 = "tree";
	// ����ע�������Ĳ���XML�ļ��������ṹ�ĳ�������
	public final static String TREE_NODE_ATTR_TEXT = "text";
	public final static String TREE_NODE_ATTR_ACTION = "action";
	public final static String TREE_NODE_ATTR_SRC = "src";
	
	/**
	 * ��xml�ļ�ת����Node�б�洢
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
	 * �ڵ�ת����XML��дҳ��,ֻˢ���ʹ�õ�����,�Ժ���Ҫ������
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
	 * �����Ժ���Ѷ���ʹ��FreeMaker��дҳ��,����̫�鷳��...
	 * �ļ�ͷ
	 * @return
	 */
	public static String node2XmlHead(){
		return "<?xml version=\"1.0\" encoding=\"GBK\"?><tree>\n";
	}
	
	/**
	 * �����Ժ���Ѷ���ʹ��FreeMaker��дҳ��,����̫�鷳��...
	 * �ļ�β
	 * @return
	 */
	public static String node2XmlEnd(){
		return "</tree>";
	}
	
	/**
	 * �����Ժ���Ѷ���ʹ��FreeMaker��дҳ��,����̫�鷳��...
	 * List���滹��Nodeʣ��,��ĩβ����Ӹľ� 
	 * @param parentNode ���ڵ���Ϣ
	 * @return
	 */
	public static String node2XmlRemainTag(String parentNodeKey){
		return "<tree text=\"...(���չʾ��������)\" action=\"javascript:rebuildWebFXLoadTree('/common/rebuildWebTreeXml.jsp?parentNodeKey="+parentNodeKey+"')\"/>";
	}
	
}
