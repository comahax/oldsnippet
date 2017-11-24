/* Dom4JUtil.java	1.0 2006-6-9
 *
 * Copyright 2006 SunRise Electronics Development, Inc. 
 * All rights reserved.
 */
package com.asisinfo.common.xml;

import java.io.File;
import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

/**
 * 
 * @author rainver
 * @version 1.0, 2006-6-9
 * 
 */
public class Dom4JUtil {

	public static Document parseWithSAX(String xmlStr) throws DocumentException {
		try {
			InputSource is = new InputSource(new StringReader(xmlStr));
			SAXReader xmlReader = new SAXReader();
			Document doc = xmlReader.read(is);
			return doc;
		} catch (DocumentException ex) {
			throw ex;
		}

	}
	

	public static Document parseWithSAX(File file) throws DocumentException {
		try {
			SAXReader xmlReader = new SAXReader();
			Document doc = xmlReader.read(file);
			return doc;
		} catch (DocumentException ex) {
			throw ex;
		}
	}

	public static Document parseWithSAX(File file, String encoding)
			throws DocumentException {
		try {
			SAXReader xmlReader = new SAXReader();
			xmlReader.setEncoding(encoding);
			Document doc = xmlReader.read(file);
			return doc;
		} catch (DocumentException ex) {
			throw ex;
		}
	}

	public static String getNodeValue(Document doc, String path) {
		return doc.valueOf(path);
	}

	public static void deleteNode(Document doc, String nodeName) {
		Node node = doc.selectSingleNode(nodeName);
		if (null != node)
			doc.getRootElement().remove(node);
	}
	
	public static String getNodeText(Node node, String path){
		Node valuenode = node.selectSingleNode(path);
		return valuenode == null ?  null: valuenode.getText();
	}
	
	public static String getNodeAttribute(Node node, String attrName){
		Node attrnode = node.selectSingleNode("@" + attrName);
		if(attrnode != null)
			return attrnode.getText();
		return "";
	}
	

}
