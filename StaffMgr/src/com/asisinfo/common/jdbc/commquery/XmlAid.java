package com.asisinfo.common.jdbc.commquery;

import java.util.*;
import org.w3c.dom.*;

/**
 * <p>中国移动广东省移动公司BOSS系统</p>
 * <p>XML辅助类</p>
 * <p>Copyright (c) 2004</p>
 * <p>中国广州从兴电子开发有限公司</p>
 * @author BOSS前台组 <a href = "mailto:wudi@exchange.ricsson.com">吴迪</a>
 * @version 1.0
 */
public abstract class XmlAid
{
    /**
     * 获取指定结点的孩子结点
     * @param node 结点
     * @return 孩子结点组成的元素
     * @throws java.lang.Exception
     */
    public final static Element[] getChildNodesOf(Element node) throws
        Exception
    {
        NodeList nl = node.getChildNodes();
        Vector vChildNodes = new Vector();
        for (int i = 0; i < nl.getLength(); i++)
        {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE)
            {
                vChildNodes.addElement(nl.item(i));
            }
        }

        Element[] childElements = new Element[vChildNodes.size()];
        for (int i = 0; i < vChildNodes.size(); i++)
        {
            childElements[i] = (Element) vChildNodes.elementAt(i);
        }
        return childElements;
    }

    /**
     * 获取某个结点指定名称的所有孩子结点
     * @param node 结点
     * @param childTagName 孩子结点名
     * @return 给定结点名的孩子结点组成的元素
     * @throws java.lang.Exception
     */
    public final static Element[] getChildNodesOf(Element node,
                                                  String childTagName) throws
        Exception
    {
        NodeList nl = node.getChildNodes();
        Vector vChildNodes = new Vector();
        for (int i = 0; i < nl.getLength(); i++)
        {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE &&
                ( (Element) nl.item(i)).getTagName().toLowerCase().equals(
                childTagName.toLowerCase()))
            {
                vChildNodes.addElement(nl.item(i));
            }
        }

        Element[] childElements = new Element[vChildNodes.size()];
        for (int i = 0; i < vChildNodes.size(); i++)
        {
            childElements[i] = (Element) vChildNodes.elementAt(i);
        }
        return childElements;
    }

    /**
     * 获取某个结点指定名称的孩子结点
     * @param node 结点
     * @param childTagName 孩子结点名
     * @return 给定结点名的孩子结点的元素，如果没有则返回null
     * @throws java.lang.Exception
     */
    public final static Element getChildNodeOf(Element node,
                                               String childTagName) throws
        Exception
    {
        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++)
        {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE &&
                nl.item(i).
                getNodeName().toLowerCase().equals(childTagName.toLowerCase()))
            {
                return (Element) nl.item(i);
            }
        }
        return null;
    }

    /**
     * 获取结点的属性
     * @param node 结点
     * @param attriubteName 属性名
     * @return 结点的属性值
     * @throws java.lang.Exception
     */
    public final static String getAttributeOf(Element node,
                                              String attriubteName) throws
        Exception
    {
        return node.getAttributes().getNamedItem(attriubteName).getNodeValue();
    }

    /**
     * 获取结点值
     * @param node 结点
     * @return 结点值
     * @throws java.lang.Exception
     */
    public final static String getValueOf(Element node) throws Exception
    {
        return node.getChildNodes().item(0).getNodeValue();
    }
}
