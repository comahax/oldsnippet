package com.asisinfo.common.jdbc.commquery;

import java.util.*;
import org.w3c.dom.*;

/**
 * <p>�й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ</p>
 * <p>XML������</p>
 * <p>Copyright (c) 2004</p>
 * <p>�й����ݴ��˵��ӿ������޹�˾</p>
 * @author BOSSǰ̨�� <a href = "mailto:wudi@exchange.ricsson.com">���</a>
 * @version 1.0
 */
public abstract class XmlAid
{
    /**
     * ��ȡָ�����ĺ��ӽ��
     * @param node ���
     * @return ���ӽ����ɵ�Ԫ��
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
     * ��ȡĳ�����ָ�����Ƶ����к��ӽ��
     * @param node ���
     * @param childTagName ���ӽ����
     * @return ����������ĺ��ӽ����ɵ�Ԫ��
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
     * ��ȡĳ�����ָ�����Ƶĺ��ӽ��
     * @param node ���
     * @param childTagName ���ӽ����
     * @return ����������ĺ��ӽ���Ԫ�أ����û���򷵻�null
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
     * ��ȡ��������
     * @param node ���
     * @param attriubteName ������
     * @return ��������ֵ
     * @throws java.lang.Exception
     */
    public final static String getAttributeOf(Element node,
                                              String attriubteName) throws
        Exception
    {
        return node.getAttributes().getNamedItem(attriubteName).getNodeValue();
    }

    /**
     * ��ȡ���ֵ
     * @param node ���
     * @return ���ֵ
     * @throws java.lang.Exception
     */
    public final static String getValueOf(Element node) throws Exception
    {
        return node.getChildNodes().item(0).getNodeValue();
    }
}
