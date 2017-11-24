package com.asisinfo.common.jdbc.commsave;

import java.sql.Types;
import java.io.StringReader;
import java.sql.PreparedStatement;
import java.io.ByteArrayInputStream;
import java.util.Vector;
import java.sql.*;
import com.asisinfo.common.jdbc.*;

/**
 * <p>Title: 中国移动广东省移动公司BOSS系统</p>
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
    * 数据库Bean,由于commonsave使用informix数据类型，所以保留了该类
    * 同步程序使用java.Types类型
    */
   private DbBean dbBean;
   /**
    * 数据库连接
    */
   private Connection connection;
   /**
    * 表名
    */
   private String tableName;
   /**
    * 操作类型
    */
   private int actionType;
   /**
    * 字段名
    * insert时包含需要插入的字段
    * update时包含主键和需要更新的非主键字段
    * delete时包含主键
    */
   private Vector columnNames;
   /**
    * 旧值
    */
   private Vector oldValues;
   /**
    * 新值
    */
   private Vector newValues;
   /**
    * 是否忽略该列,用于构造delete的where子句
    */
   private Vector ignore;

   private TableStructure ts;

   /**
    * 保存命令
    * @param dbBean 数据库Bean
    * @param connection 数据库连接
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
    * 设置操作类型
    * @param actionType 操作类型
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
    * 设置字段信息
    * @param columnName 字段名
    * @param oldValue 旧值
    * @param newValue 新值
    * @param ignore 在构造where条件时忽略该列
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
    * 执行方法，根据不同的操作类型调用不同的方法
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
    * 对PreparedStatement对象进行设值
    * @param pstmt PreparedStatement对象
    * @param position 位置
    * @param columnType 字段类型
    * @param columnValue 字段值
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
    * 获取插入SQL语句
    * @return 插入SQL语句
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
    * 插入方法
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
    * 获取更新SQL语句
    * @return 更新SQL语句
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
    * 更新方法
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
    * 获取删除操作SQL语句
    * @return 删除操作SQL语句
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
    * 删除方法
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
    * 获取新值通过非主键字段名
    * @param columnName 字段名
    * @return 字段新值
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
    * 获取旧值通过非主键字段名
    * @param columnName 字段名
    * @return 旧值
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
    * 获取主键字段信息,仅用于同步时查找原表数据
    * @return 主键字段信息
    * @throws java.lang.Exception
    * @todo 没pk的表也要处理
    */
   public String getNewKeyColumnsInfo() throws Exception
   {
      //delete不需要新值
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
               keyColumnsInfo += "@^@" + columnName; //用@^@作字段分割符
            }
            keyColumnsInfo += "@^@" + (String)this.newValues.elementAt(i);
         }
      }
      return keyColumnsInfo;
   }

   /**
    * 获取主键字段原信息,仅用于同步时update操作查找原表数据
    * @return 主键字段信息
    * @throws java.lang.Exception
    * @todo 没pk的表也要处理
    */
   public String getOldKeyColumnsInfo() throws Exception
   {
      //insert不需要旧值
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
               keyColumnsInfo += "@^@" + columnName; //用@^@作字段分割符
            }
            keyColumnsInfo += "@^@" + (String)this.oldValues.elementAt(i);
         }
      }
      return keyColumnsInfo;
   }

   /**
    * 获取需要更新的非主键字段,仅在update时用到
    * @return 非主键字段
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
