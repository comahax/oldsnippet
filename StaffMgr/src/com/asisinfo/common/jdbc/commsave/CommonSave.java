package com.asisinfo.common.jdbc.commsave;

import java.io.StringReader;
import java.sql.Connection;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;


/**
 * <p>�й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ</p>
 * <p>ͨ�ñ�����,���ڽ���saveXml�ļ�,ʵ�ʵı��������SaveCmd</p>
 * <p>Copyright (c) 2004</p>
 * <p>�й����ݴ��˵��ӿ������޹�˾</p>
 * @author BOSSǰ̨�� <a href = "mailto:wudi@exchange.ricsson.com">���</a>
 * @author chenhm
 * @version 1.0
 */
public class CommonSave
{
   /**
    * ������� : 0
    */
   public final static int INSERT = 0;
   /**
    * ���²��� : 1
    */
   public final static int UPDATE = 1;
   /**
    * ɾ������ : 2
    */
   public final static int DELETE = 2;

   // ˽����־��
   private class Log
   {
      // ˽�в�����¼
      private class ActionRecord
      {
         /**
          * �û���
          */
         public String userName;
         /**
          * ����
          */
         public String tableName;
         /**
          * ��������
          */
         public String actionType;
         /**
          * ��������
          */
         public int actionCount;

         /**
          * ���췽��
          * @param userName �û���
          * @param tableName ����
          * @param actionType ��������
          * @param actionCount ��������
          */
         public ActionRecord(String userName, String tableName,
                             String actionType,
                             int actionCount)
         {
            this.userName = userName;
            this.tableName = tableName;
            this.actionType = actionType;
            this.actionCount = actionCount;
         }
      }

      /**
       * ������¼
       */
      private Vector actionRecords = new Vector();

      /**
       * ��ȡ������¼
       * @param userName �û���
       * @param tableName ����
       * @param actionType ��������
       * @return ������¼
       */
      private ActionRecord getRecord(String userName, String tableName,
                                     String actionType)
      {
         for (int i = 0; i < actionRecords.size(); i++)
         {
            if ( ( (ActionRecord) actionRecords.elementAt(i)).userName.
                equals(
                   userName) &&
                ( (ActionRecord) actionRecords.elementAt(i)).tableName.
                equals(
                   tableName) &&
                ( (ActionRecord) actionRecords.elementAt(i)).actionType.
                equals(
                   actionType))
            {
               return (ActionRecord) actionRecords.elementAt(i);
            }
         }

         ActionRecord actionRecord = new ActionRecord(userName, tableName,
            actionType, 0);
         this.actionRecords.addElement(actionRecord);
         return actionRecord;
      }

      /**
       * ������־
       * @param userName �û���
       * @param tableName ����
       * @param actionType ��������
       */
      public void addLog(String userName, String tableName, String actionType)
      {
         ActionRecord actionRecord = this.getRecord(userName, tableName,
            actionType);
         actionRecord.actionCount += 1;
      }

      /**
       * ��ȡ����XML�ַ���
       * @return XML�ַ���
       */
      public String getSaveXml()
      {
         String saveXml = "<dataManageInfo>";
         for (int i = 0; i < this.actionRecords.size(); i++)
         {
            saveXml += "<action table='actionlog' type='insert'>"
               + "<column name='username'>"
               + "<newValue>"
               + ( (ActionRecord)this.actionRecords.elementAt(i)).userName
               + "</newValue>"
               + "</column>"

               + "<column name='tablename'>"
               + "<newValue>"
               + ( (ActionRecord)this.actionRecords.elementAt(i)).tableName
               + "</newValue>"
               + "</column>"

               + "<column name='actiontype'>"
               + "<newValue>"
               + ( (ActionRecord)this.actionRecords.elementAt(i)).actionType
               + "</newValue>"
               + "</column>"

               + "<column name='actioncount'>"
               + "<newValue>"
               + ( (ActionRecord)this.actionRecords.elementAt(i)).actionCount
               + "</newValue>"
               + "</column>"
               + "</action>";
         }
         saveXml += "</dataManageInfo>";
         return saveXml;
      }
   }

   /**
    * ����XML�ַ��������ݿ�
    * @param saveXml ��Ҫ�����XML�ַ���
    * @param connection ���ݿ�����
    * @throws java.lang.Exception
    */
   private void saveXmlToDb(String saveXml,
                            Connection connection) throws
      Exception
   {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document saveDoc = builder.parse(new InputSource(new StringReader(
         saveXml)));
      saveDoc.normalize();
      for (int i = 0;
           i < saveDoc.getDocumentElement().getChildNodes().getLength();
           i++)
      {
         Node actionNode = saveDoc.getDocumentElement().getChildNodes().item(i);
         if (actionNode.getNodeType() == Node.ELEMENT_NODE)
         {
            SaveCmd saveCmd = getSaveCmd(connection, actionNode);
            saveCmd.excute();
         }
      }
   }

  
   /**
    * ���淽��
    * @param saveXml ��Ҫ�����XML�ַ���
    * @param userName �û���
    * @param connection ���ݿ�����
    * @param dstConn ����������
    * @throws java.lang.Exception
    * @return int �޸ĵļ�¼��
    */
   public int save(String saveXml, String userName,
                   Connection connection, Connection dstConn) throws Exception
   {

      int count = 0;
//      Log log = new Log();
//      SaveSynInfo saveSynInfo = new SaveSynInfo();
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document saveDoc = builder.parse(new InputSource(new StringReader(
         saveXml)));
      saveDoc.normalize();

      for (int i = 0;
           i < saveDoc.getDocumentElement().getChildNodes().getLength();
           i++)
      {
         Node actionNode = saveDoc.getDocumentElement().getChildNodes().item(
            i);
         if (actionNode.getNodeType() == Node.ELEMENT_NODE)
         {
            SaveCmd saveCmd = getSaveCmd(connection, actionNode);
            count += saveCmd.excute();

            //ͬʱupdate�������ݿ�
            if (dstConn != null)
            {
               SaveCmd saveDst = getSaveCmd(dstConn, actionNode);
               saveDst.excute();
            }

            String theActionType = "";
            switch (saveCmd.getActionType())
            {
               case CommonSave.INSERT:
                  theActionType = "insert";
                  break;
               case CommonSave.UPDATE:
                  theActionType = "update";
                  break;
               case CommonSave.DELETE:
                  theActionType = "delete";
                  break;
            }
//            log.addLog(userName, saveCmd.getTableName(), theActionType);
            //����ͬ��������Ϣ
//               saveSynInfo.addStepInfo(saveCmd.getTableName(), theActionType,
//                                       saveCmd.getNewKeyColumnsInfo(),
//                                       saveCmd.getOldKeyColumnsInfo(),
//                                       connection);

         }
      }

//      int Transaction = saveSynInfo.finishTransaction(connection);
//      startSynTransaction(Transaction);
//      String logSaveXml = log.getSaveXml();
//      this.saveXmlToDb(logSaveXml, connection);

      return count;
   }

   /**
    * �Զ������������ͬ��
    * @param transId int
    * @throws Exception
    */
//   private void startSynTransaction(int transId) throws Exception
//   {
//      Connection srcCon = null;
//      Connection dstCon = null;
//      try
//      {
//         srcCon = DBTools.getConnection();
//         dstCon = DBTools.getBossTestConnection(); //172.21.21.25
//         gmcc.syn.DataSyn ds = new gmcc.syn.DataSyn("synuser", srcCon, dstCon);
//         ds.startSynOperation(String.valueOf(transId));
//      }
//      catch (Exception e)
//      {
//         System.out.println("ͬ������:" + e);
//         throw e;
//      }
//      finally
//      {
//         DBTools.closeAll(srcCon, null, null);
//         DBTools.closeAll(dstCon, null, null);
//      }
//   }

   /**
    * ���SaveCmd����
    * @param connection Connection
    * @param actionNode Node
    * @return SaveCmd
    * @throws DOMException
    */
   private SaveCmd getSaveCmd(Connection connection,
                              Node actionNode) throws DOMException
   {
      String tableName = actionNode.getAttributes()
         .getNamedItem("table").getNodeValue();
      SaveCmd saveCmd = new SaveCmd(tableName, connection);

      String actionType = actionNode.getAttributes()
         .getNamedItem("type").getNodeValue().toLowerCase();
      if (actionType.equals("insert"))
      {
         saveCmd.setActionType(CommonSave.INSERT);
      }
      if (actionType.equals("update"))
      {
         saveCmd.setActionType(CommonSave.UPDATE);
      }
      if (actionType.equals("delete"))
      {
         saveCmd.setActionType(CommonSave.DELETE);
      }

      for (int j = 0; j < actionNode.getChildNodes().getLength(); j++)
      {
         Node columnNode = actionNode.getChildNodes().item(j);
         if (columnNode.getNodeType() == Node.ELEMENT_NODE)
         {
            String colnumName = columnNode.getAttributes().
               getNamedItem("name").getNodeValue();
            String newValue = null;
            String oldValue = null;
            for (int p = 0; p < columnNode.getChildNodes().getLength(); p++)
            {
               Node valueNode = columnNode.getChildNodes().item(p);
               if (valueNode.getNodeType() == Node.ELEMENT_NODE)
               {
                  if (valueNode.getNodeName().equals("newValue"))
                  {
                     if (valueNode.getChildNodes().getLength() > 0)
                     {
                        newValue = valueNode.getFirstChild().getNodeValue();
                        if (newValue != null)
                        {
                           newValue = newValue.trim();
                        }
                     }
                  }
                  else if (valueNode.getNodeName().equals("oldValue"))
                  {
                     if (valueNode.getChildNodes().getLength() > 0)
                     {
                        oldValue = valueNode.getFirstChild().getNodeValue();
                        if (oldValue != null)
                        {
                           oldValue = oldValue.trim();
                        }
                     }
                  }

               }
            }

            Node attribute = columnNode.getAttributes().getNamedItem("ignore");
            if (attribute != null && "true".equals(attribute.getNodeValue()))
            {
               saveCmd.setColumnInfo(colnumName, oldValue, newValue, true);
            }
            else
            {
               saveCmd.setColumnInfo(colnumName, oldValue, newValue, false);
            }

         }
      }
      return saveCmd;
   }
}
