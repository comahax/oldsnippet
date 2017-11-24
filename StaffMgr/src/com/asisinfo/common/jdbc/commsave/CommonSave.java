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
 * <p>中国移动广东省移动公司BOSS系统</p>
 * <p>通用保存类,用于解析saveXml文件,实际的保存操作在SaveCmd</p>
 * <p>Copyright (c) 2004</p>
 * <p>中国广州从兴电子开发有限公司</p>
 * @author BOSS前台组 <a href = "mailto:wudi@exchange.ricsson.com">吴迪</a>
 * @author chenhm
 * @version 1.0
 */
public class CommonSave
{
   /**
    * 插入操作 : 0
    */
   public final static int INSERT = 0;
   /**
    * 更新操作 : 1
    */
   public final static int UPDATE = 1;
   /**
    * 删除操作 : 2
    */
   public final static int DELETE = 2;

   // 私有日志类
   private class Log
   {
      // 私有操作记录
      private class ActionRecord
      {
         /**
          * 用户名
          */
         public String userName;
         /**
          * 表名
          */
         public String tableName;
         /**
          * 操作类型
          */
         public String actionType;
         /**
          * 操作次数
          */
         public int actionCount;

         /**
          * 构造方法
          * @param userName 用户名
          * @param tableName 表名
          * @param actionType 操作类型
          * @param actionCount 操作次数
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
       * 操作记录
       */
      private Vector actionRecords = new Vector();

      /**
       * 获取操作记录
       * @param userName 用户名
       * @param tableName 表名
       * @param actionType 操作类型
       * @return 操作记录
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
       * 增加日志
       * @param userName 用户名
       * @param tableName 表名
       * @param actionType 操作类型
       */
      public void addLog(String userName, String tableName, String actionType)
      {
         ActionRecord actionRecord = this.getRecord(userName, tableName,
            actionType);
         actionRecord.actionCount += 1;
      }

      /**
       * 获取保存XML字符串
       * @return XML字符串
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
    * 保存XML字符串到数据库
    * @param saveXml 需要保存的XML字符串
    * @param connection 数据库连接
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
    * 保存方法
    * @param saveXml 需要保存的XML字符串
    * @param userName 用户名
    * @param connection 数据库连接
    * @param dstConn 生产机连接
    * @throws java.lang.Exception
    * @return int 修改的记录数
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

            //同时update生产数据库
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
            //增加同步步骤信息
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
    * 自动将保存的数据同步
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
//         System.out.println("同步错误:" + e);
//         throw e;
//      }
//      finally
//      {
//         DBTools.closeAll(srcCon, null, null);
//         DBTools.closeAll(dstCon, null, null);
//      }
//   }

   /**
    * 获得SaveCmd对象
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
