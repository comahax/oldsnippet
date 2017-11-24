package com.asisinfo.common.jdbc.commquery;


import java.io.*;
import org.w3c.dom.*;

/**
 * 
 * @author zhang jiarui
 * @deprecated
 */
public class DOMSerializer
{

    private String indent; // 缩进的标志
    private String lineSeparator; // 换行的标志

    public DOMSerializer()
    {
        indent = " ";
        lineSeparator = "\n";
    }

    public void setLineSeparator(String lineSeparator)
    {
        this.lineSeparator = lineSeparator;
    }

    // 以下重组的方法,用到递归责任链模式
    public void serialize(Document doc, OutputStream out) throws IOException
    {

        Writer writer = new OutputStreamWriter(out);
        serialize(doc, writer);
    }

    public void serialize(Document doc, File file) throws IOException
    {

        Writer writer = new FileWriter(file);
        serialize(doc, writer);
    }

    public void serialize(Document doc, Writer writer) throws IOException
    {

        serializeNode(doc, writer, "");
        writer.flush();
    }

    public void serializeNode(Node node, Writer writer, String indentLevel) throws
        IOException
    {

        // 按节点类型确定操作
        switch (node.getNodeType())
        {

            case Node.DOCUMENT_NODE:
                writer.write("<?xml version=\"1.0\" encoding=\"gb2312\" ?>");
                writer.write(lineSeparator);

                Document doc = (Document) node;
                serializeNode(doc.getDocumentElement(), writer, ""); //得到根节点
                break;

            case Node.ELEMENT_NODE:
                String name = node.getNodeName();
                writer.write(indentLevel + "<" + name);
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++)
                {
                    Node current = attributes.item(i);
                    String value = current.getNodeValue().replaceAll("&", "&");
                    writer.write(" " + current.getNodeName() +
                                 " = \"" + value + "\"");

                }
                writer.write(">");

                // 以下遍历所有子节点
                NodeList children = node.getChildNodes();
                if (children != null)
                {
                    if (children.item(0) != null &&
                        (children.item(0).getNodeType() == Node.ELEMENT_NODE))
                    {
                        writer.write(lineSeparator);
                    }
                    for (int i = 0; i < children.getLength(); i++)
                    {
                        serializeNode(children.item(i), writer,
                                      indentLevel + indent);
                    }
                    if ( (children.item(0) != null) &&
                        (children.item(children.getLength() - 1).getNodeType() ==
                         Node.ELEMENT_NODE))
                    {
                        writer.write(lineSeparator);
                    }
                }
                writer.write(indentLevel + "</" + name + ">");
                writer.write(lineSeparator);
                break;

            case Node.TEXT_NODE:
                String value = node.getNodeValue().replaceAll("&", "&");
                value = value.replaceAll("<", "<");
                value = value.replaceAll(">", ">");
                writer.write(value);
                break;

            case Node.CDATA_SECTION_NODE:
                writer.write("<![CDATA[" + node.getNodeValue() + "]]>");
                writer.write(lineSeparator);
                break;

            case Node.COMMENT_NODE:
                writer.write(indentLevel + "<!-- " + node.getNodeValue() +
                             " -->");
                writer.write(lineSeparator);
                break;

            case Node.PROCESSING_INSTRUCTION_NODE:
                writer.write("<?" + node.getNodeName() +
                             " " + node.getNodeValue() + "?>");
                writer.write(lineSeparator);
                break;

            case Node.DOCUMENT_TYPE_NODE:
                DocumentType docType = (DocumentType) node;
                writer.write("<!DOCTYPE " + docType.getName());
                if (docType.getPublicId() != null)
                {
                    System.out.println(" PUBLIC \"" + docType.getPublicId() +
                                       "\" ");
                }
                else
                {
                    writer.write(" SYSTEM ");
                }
                writer.write("\"" + docType.getSystemId() + "\">");
                writer.write(lineSeparator);
                break;

            case Node.ENTITY_REFERENCE_NODE:
                writer.write("&" + node.getNodeName() + ";");
                break;
        }
    }
}
