package com.asisinfo.common.jdbc.commsave;

import java.sql.Types;
import java.io.StringReader;
import java.sql.PreparedStatement;
import java.io.ByteArrayInputStream;
import java.util.Vector;
import java.sql.*;
import com.asisinfo.common.jdbc.*;

/**
 * <p>Title: �й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: asisinfo Electronics Development Co., LTD</p>
 *
 * @author chenhm
 * @version 1.0
 * @deprecated
 */
public class SaveCmdOld
{
   /**
    * ���ݿ�Bean,����commonsaveʹ��informix�������ͣ����Ա����˸���
    * ͬ������ʹ��java.Types����
    */
   private DbBean dbBean;
   /**
    * ���ݿ�����
    */
   private Connection connection;
   /**
    * ����
    */
   private String tableName;
   /**
    * ��������
    */
   private int actionType;
   /**
    * �ֶ���
    * insertʱ������Ҫ������ֶ�
    * updateʱ������������Ҫ���µķ������ֶ�
    * deleteʱ��������
    */
   private Vector columnNames;
   /**
    * ��ֵ
    */
   private Vector oldValues;
   /**
    * ��ֵ
    */
   private Vector newValues;
   /**
    * �Ƿ���Ը���,���ڹ���delete��where�Ӿ�
    */
   private Vector ignore;

   private TableStructure ts;

   /**
    * ��������
    * @param dbBean ���ݿ�Bean
    * @param connection ���ݿ�����
    */
   public SaveCmdOld(String tableName, DbBean dbBean, Connection connection)
   {
      this.ts = DBSniffer.getTS(connection, tableName);
      this.tableName = tableName.toLowerCase();
      this.dbBean = dbBean;
      this.connection = connection;
      this.columnNames = new Vector();
      this.oldValues = new Vector();
      this.newValues = new Vector();
      this.ignore = new Vector();
   }

   public String getTableName()
   {
      return tableName;
   }

   public int getActionType()
   {
      return actionType;
   }

   /**
    * ���ò�������
    * @param actionType ��������
    */
   public void setActionType(int actionType)
   {
      this.actionType = actionType;
   }

   public void setColumnInfo(String columnName, String oldValue,
                             String newValue)
   {
      setColumnInfo(columnName, oldValue, newValue, false);
   }

   /**
    * �����ֶ���Ϣ
    * @param columnName �ֶ���
    * @param oldValue ��ֵ
    * @param newValue ��ֵ
    * @param ignore �ڹ���where����ʱ���Ը���
    */
   public void setColumnInfo(String columnName, String oldValue,
                             String newValue, boolean ignore)
   {
      columnName = columnName.toLowerCase();
      this.columnNames.addElement(columnName);
      this.ignore.addElement(new Boolean(ignore));
      switch (this.actionType)
      {
         case CommonSave.INSERT:
            this.newValues.addElement(newValue);
            this.oldValues.addElement(null);
            break;
         case CommonSave.UPDATE:
            this.newValues.addElement(newValue);
            this.oldValues.addElement(oldValue);
            break;
         case CommonSave.DELETE:
            this.newValues.addElement(null);
            this.oldValues.addElement(oldValue);
            break;
      }
   }

   /**
    * ִ�з��������ݲ�ͬ�Ĳ������͵��ò�ͬ�ķ���
    * @throws java.lang.Exception
    * @return int
    */
   public int excute() throws Exception
   {
      switch (this.actionType)
      {
         case CommonSave.INSERT:
            return this.insert();
         case CommonSave.UPDATE:
            return this.update();
         case CommonSave.DELETE:
            return this.delete();
      }
      return 0;
   }

   /**
    * ��PreparedStatement���������ֵ
    * @param pstmt PreparedStatement����
    * @param position λ��
    * @param columnType �ֶ�����
    * @param columnValue �ֶ�ֵ
    * @throws java.lang.Exception
    */
   private void setPstmtValue(PreparedStatement pstmt, int position,
                              int columnType, String columnValue) throws
      Exception
   {
      if (columnType >= 256)
      {
         columnType = columnType - 256;
      }
      if (columnType == InformixDataType.CHAR ||
          columnType == InformixDataType.INTERVAL ||
          columnType == InformixDataType.NCHAR ||
          columnType == InformixDataType.NVARCHAR ||
          columnType == InformixDataType.VARCHAR)
      {
         if (columnValue == null || columnValue.trim().equals(""))
         {
            pstmt.setNull(position, Types.VARCHAR);
         }
         else
         {
            pstmt.setString(position, columnValue);
         }
      }
      if (columnType == InformixDataType.DATE ||
          columnType == InformixDataType.DATETIME)
      {
         if (columnValue == null || columnValue.trim().equals(""))
         {
            pstmt.setNull(position, Types.TIMESTAMP);
         }
         else
         {
            try
            {
               java.sql.Timestamp dt = java.sql.Timestamp.valueOf(
                  columnValue.trim());
               pstmt.setTimestamp(position, dt);
            }
            catch (Exception ex)
            {
               java.sql.Date dt = java.sql.Date.valueOf(columnValue.
                  trim());
               pstmt.setDate(position, dt);
            }
//      System.out.println(dt.toString());
         }
      }
      if (columnType == InformixDataType.LVARCHAR)
      {
         if (columnValue == null || columnValue.trim().equals(""))
         {
            pstmt.setNull(position, Types.LONGVARCHAR);
         }
         else
         {
            String data = columnValue;
            StringReader sr = new StringReader(data);
            pstmt.setString(position, columnValue);
         }
      }
      if (columnType == InformixDataType.CLOB)
      {
         String data = columnValue;
         if (columnValue == null || columnValue.trim().equals(""))
         {
            pstmt.setNull(position, Types.CLOB);
         }
         else
         {

            ByteArrayInputStream bisData = new ByteArrayInputStream(
               data.getBytes("GB2312"));
            System.out.println(data);
//            java.sql.Clob clob = new com.informix.jdbc.IfxCblob(bisData);
            pstmt.setAsciiStream(position, bisData, bisData.available());
         }
      }
      if (columnType == InformixDataType.DECIMAL ||
          columnType == InformixDataType.FLOAT)
      {
         if (columnValue == null || columnValue.trim().equals(""))
         {
            pstmt.setNull(position, Types.FLOAT);
         }
         else
         {
            pstmt.setFloat(position, Float.parseFloat(columnValue));
         }
      }
      if (columnType == InformixDataType.INTEGER ||
          columnType == InformixDataType.SERIAL4 ||
          columnType == InformixDataType.SERIAL8 ||
          columnType == InformixDataType.SMALLFLOAT ||
          columnType == InformixDataType.SMALLINT)
      {
         if (columnValue == null || columnValue.trim().equals(""))
         {
            pstmt.setNull(position, Types.INTEGER);
         }
         else
         {
            pstmt.setInt(position, Integer.parseInt(columnValue));
         }
      }
   }

   /**
    * ��ȡ����SQL���
    * @return ����SQL���
    * @throws java.lang.Exception
    */
   private String getInsertSql() throws Exception
   {
      String modelName = ts.getSchema();
      String sql = "insert into " + modelName + "." + this.tableName +
         "(";
      for (int i = 0; i < this.columnNames.size(); i++)
      {
         if (i == 0)
         {
            sql += (String)this.columnNames.elementAt(i);
         }
         else
         {
            sql += "," + (String)this.columnNames.elementAt(i);
         }
      }
      sql += ") " + "values(";

      for (int i = 0; i < this.columnNames.size(); i++)
      {
         if (i == 0)
         {
            sql += "?";
         }
         else
         {
            sql += ",?";
         }
      }
      sql += ");";
      return sql;
   }

   /**
    * ���뷽��
    * @throws java.lang.Exception
    */
   private int insert() throws Exception
   {
//            System.out.println("---------1");
      String sql = this.getInsertSql();
      PreparedStatement pstmt = null;
      try
      {
         pstmt = this.connection.prepareStatement(sql);
         for (int i = 0; i < this.columnNames.size(); i++)
         {
            int columnType = this.dbBean.getColumnType(this.tableName,
               (String)this.columnNames.elementAt(i), this.connection);
            this.setPstmtValue(pstmt, i + 1, columnType,
                               (String)this.newValues.elementAt(i));
         }
         return pstmt.executeUpdate();
      }
      catch (SQLException ex)
      {
         if (this.tableName.equals("ratp0_fee") &&
             this.tableName.equals("disp0_fee"))
         {
            System.out.println(ex.getMessage() + ex.getErrorCode());
         }
         throw ex;
      }
      finally
      {
         DBTools.closeDB(null, pstmt, null);
      }
   }

   /**
    * ��ȡ����SQL���
    * @return ����SQL���
    * @throws java.lang.Exception
    */
   private String getUpdateSql() throws Exception
   {
      String modelName = ts.getSchema();
      String sql = "update " + modelName + "." + this.tableName + " set ";
      String notKeyColumns[] = this.getNotKeyColumns();
      if (notKeyColumns.length == 0)
      {
         throw new NoColumnException("Can't modify primary key column.");
      }
      for (int i = 0; i < notKeyColumns.length; i++)
      {
         if (i == 0)
         {
            sql += notKeyColumns[i] + "=?";
         }
         else
         {
            sql += "," + notKeyColumns[i] + "=?";
         }
      }
      sql += " where ";
      String[] keyColumnNames = ts.getPKColumns();
//         this.dbBean.getPKColumns(this.tableName,
//         this.connection);
      if (keyColumnNames.length == 0)
      {
         throw new NoPKException("table(" + this.tableName +
                                 ") no PrimaryKey");
      }
      for (int i = 0; i < keyColumnNames.length; i++)
      {
         if (i == 0)
         {
            sql += keyColumnNames[i] + "=?";
         }
         else
         {
            sql += " and " + keyColumnNames[i] + "=?";
         }
      }
      sql += ";";

      System.out.println(sql);
      return sql;
   }

   /**
    * ���·���
    * @throws java.lang.Exception
    * @return int
    */
   private int update() throws Exception
   {
      String sql = this.getUpdateSql();
      System.out.println(sql);
      PreparedStatement pstmt = null;
      try
      {
         pstmt = this.connection.prepareStatement(sql);

         String notKeyColumns[] = this.getNotKeyColumns();
         for (int i = 0; i < notKeyColumns.length; i++)
         {
            int columnType = this.dbBean.getColumnType(this.tableName,
               notKeyColumns[i], this.connection);
            String s = this.getNewValueByNotKeyColumnName(notKeyColumns[i]);
            this.setPstmtValue(pstmt, i + 1, columnType,
                               this.getNewValueByNotKeyColumnName(
                                  notKeyColumns[i]));
         }

         String keyColumnNames[] = ts.getPKColumns();
//            this.dbBean.getPKColumns(this.tableName,
//            this.connection);
         for (int i = 0; i < keyColumnNames.length; i++)
         {
            int columnType = this.dbBean.getColumnType(this.tableName,
               keyColumnNames[i], this.connection);
            String s = this.getOldValueByKeyColumnName(keyColumnNames[i]);
            this.setPstmtValue(pstmt, notKeyColumns.length + i + 1,
                               columnType,
                               this.getOldValueByKeyColumnName(
                                  keyColumnNames[i]));
         }
         return pstmt.executeUpdate();
      }
      finally
      {
         DBTools.closeDB(null, pstmt, null);
      }
   }

   /**
    * ��ȡɾ������SQL���
    * @return ɾ������SQL���
    * @throws java.lang.Exception
    */
   private String getDeleteSql() throws Exception
   {
      String modelName = ts.getSchema();
      String sql = "delete from " + modelName + "." + this.tableName +
         " where ";
      String[] keyColumnNames = ts.getPKColumns();
      if (keyColumnNames.length == 0)
      {
         throw new NoPKException("table(" + this.tableName +
                                 ") no PrimaryKey");
      }
      String where = "";
      for (int i = 0; i < keyColumnNames.length; i++)
      {
         if (ignoreColumn(keyColumnNames[i]))
         {
            continue;
         }
         if (where.length() == 0)
         {
            where += keyColumnNames[i] + "=?";
         }
         else
         {
            where += " and " + keyColumnNames[i] + "=?";
         }
      }
      sql += where + ";";
      System.out.println(sql);
      return sql;
   }

   /**
    * ɾ������
    * @throws java.lang.Exception
    */
   private int delete() throws Exception
   {
      String sql = this.getDeleteSql();
      PreparedStatement pstmt = null;
      try
      {
         pstmt = this.connection.prepareStatement(sql);

         String keyColumnNames[] = ts.getPKColumns();
//            this.dbBean.getPKColumns(this.tableName,
//            this.connection);
         for (int i = 0; i < keyColumnNames.length; i++)
         {
            if (ignoreColumn(keyColumnNames[i]))
            {
               continue;
            }
            int columnType = this.dbBean.getColumnType(this.tableName,
               keyColumnNames[i], this.connection);
            this.setPstmtValue(pstmt, i + 1, columnType,
                               this.getOldValueByKeyColumnName(
                                  keyColumnNames[i]));
         }
         return pstmt.executeUpdate();
      }
      finally
      {
         DBTools.closeDB(null, pstmt, null);
      }
   }

   /**
    * ��ȡ��ֵͨ���������ֶ���
    * @param columnName �ֶ���
    * @return �ֶ���ֵ
    * @throws java.lang.Exception
    */
   private String getNewValueByNotKeyColumnName(String columnName) throws
      Exception
   {
      for (int i = 0; i < this.columnNames.size(); i++)
      {
//         System.out.println(columnNames.elementAt(i));
         if ( ( (String)this.columnNames.elementAt(i)).equalsIgnoreCase(
            columnName))
         {
            return (String)this.newValues.elementAt(i);
         }
      }
      throw new Exception("need table " + this.tableName + "'s colums " +
                          columnName +
                          "'s newValue.");
   }

   /**
    * ��ȡ��ֵͨ���������ֶ���
    * @param columnName �ֶ���
    * @return ��ֵ
    * @throws java.lang.Exception
    */
   private String getOldValueByKeyColumnName(String columnName) throws
      Exception
   {
      for (int i = 0; i < this.columnNames.size(); i++)
      {
         if ( ( (String)this.columnNames.elementAt(i)).equalsIgnoreCase(
            columnName))
         {
            return (String)this.oldValues.elementAt(i);
         }
      }
      throw new Exception("need table " + this.tableName + "'s column " +
                          columnName +
                          "'s oldValue.");
   }

   /**
    * ��ȡ�����ֶ���Ϣ,������ͬ��ʱ����ԭ������
    * @return �����ֶ���Ϣ
    * @throws java.lang.Exception
    * @todo ûpk�ı�ҲҪ����
    */
   public String getNewKeyColumnsInfo() throws Exception
   {
      //delete����Ҫ��ֵ
      if (this.actionType == CommonSave.DELETE)
      {
         return "";
      }

      String keyColumnsInfo = "";
      java.util.Vector pkv = ts.getPrimaryKeyColumnNames();
      if (pkv.size() == 0)
      {
         throw new NoPKException("table(" + this.tableName +
                                 ") no PrimaryKey");
      }

      for (int i = 0; i < this.columnNames.size(); i++)
      {
         String columnName = (String)this.columnNames.elementAt(i);
         if (ts.isPK(columnName))
         {
            if (keyColumnsInfo.equals(""))
            {
               keyColumnsInfo += columnName;
            }
            else
            {
               keyColumnsInfo += "@^@" + columnName; //��@^@���ֶηָ��
            }
            keyColumnsInfo += "@^@" + (String)this.newValues.elementAt(i);
         }
      }
      return keyColumnsInfo;
   }

   /**
    * ��ȡ�����ֶ�ԭ��Ϣ,������ͬ��ʱupdate��������ԭ������
    * @return �����ֶ���Ϣ
    * @throws java.lang.Exception
    * @todo ûpk�ı�ҲҪ����
    */
   public String getOldKeyColumnsInfo() throws Exception
   {
      //insert����Ҫ��ֵ
      if (this.actionType == CommonSave.INSERT)
      {
         return "";
      }

      String keyColumnsInfo = "";
      java.util.Vector pkv = ts.getPrimaryKeyColumnNames();
      if (pkv.size() == 0)
      {
         throw new NoPKException("table(" + this.tableName +
                                 ") no PrimaryKey");
      }

      for (int i = 0; i < this.columnNames.size(); i++)
      {
         String columnName = (String)this.columnNames.elementAt(i);
         if (ts.isPK(columnName))
         {
            if (keyColumnsInfo.length() == 0)
            {
               keyColumnsInfo += columnName;
            }
            else
            {
               keyColumnsInfo += "@^@" + columnName; //��@^@���ֶηָ��
            }
            keyColumnsInfo += "@^@" + (String)this.oldValues.elementAt(i);
         }
      }
      return keyColumnsInfo;
   }

   /**
    * ��ȡ��Ҫ���µķ������ֶ�,����updateʱ�õ�
    * @return �������ֶ�
    * @throws java.lang.Exception
    */
   private String[] getNotKeyColumns() throws Exception
   {
      Vector vNotKeyColumns = new Vector();
      for (int i = 0; i < this.columnNames.size(); i++)
      {
         if (!ts.isPK( (String)this.columnNames.elementAt(i)))
         {
            vNotKeyColumns.addElement(this.columnNames.elementAt(i));
         }
      }
      String notKeyColumns[] = new String[vNotKeyColumns.size()];
      vNotKeyColumns.toArray(notKeyColumns);
      return notKeyColumns;
   }

   private boolean ignoreColumn(String colname)
   {
      for (int i = 0; i < this.columnNames.size(); i++)
      {
         if ( ( (String)this.columnNames.elementAt(i)).equals(colname))
         {
            return ( (Boolean)this.ignore.get(i)).booleanValue();
         }
      }
      return false;
   }
}
