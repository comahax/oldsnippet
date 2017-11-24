package com.asisinfo.common.jdbc.commsave;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import com.asisinfo.common.jdbc.DBSniffer;
import com.asisinfo.common.jdbc.NoColumnException;
import com.asisinfo.common.jdbc.NoTableException;


/**
 * <p>中国移动广东省移动公司BOSS系统</p>
 * <p>数据库类,该类中保存informix数据类型</p>
 * <p>Copyright (c) 2004</p>
 * <p>中国广州从兴电子开发有限公司</p>
 * @author BOSS前台组
 * @version 1.0
 * @deprecated
 */
public class DbBean
{
   private class TableStructureBean
   {
      public class ColumnInfo
      {
         public boolean isPK;
         public int columnType;
      }

      /**
       * 模式名称
       */
      public String schema; //owner
      private String catalog; //db name
      private String table_name;
      /**
       * 字段信息
       */
      public HashMap columnInfos;
      /**
       * 主键字段名
       */
      public String[] keyColumnNames;
      /**
       * 非主键字段名
       */
      public String[] notKeyColumnNames;

      /**
       * 构造函数
       * @param modelName 模式名
       * @param columnNames 字段名
       * @param columnTypes 字段类型
       * @param isPKs 是否主键
       */
      public TableStructureBean(String modelName, String[] columnNames,
                                int[] columnTypes, boolean[] isPKs)
      {
         this.schema = modelName;
         this.columnInfos = new HashMap();
         Vector vKeyColumnNames = new Vector();
         Vector vNotKeyColumnNames = new Vector();
         for (int i = 0; i < columnNames.length; i++)
         {
            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.isPK = isPKs[i];
            columnInfo.columnType = columnTypes[i];
            columnInfos.put(columnNames[i], columnInfo);
            if (isPKs[i])
            {
               vKeyColumnNames.addElement(columnNames[i]);
            }
            else
            {
               vNotKeyColumnNames.addElement(columnNames[i]);
            }
         }

         keyColumnNames = new String[vKeyColumnNames.size()];
         for (int i = 0; i < vKeyColumnNames.size(); i++)
         {
            keyColumnNames[i] = (String) vKeyColumnNames.elementAt(i);
         }

         notKeyColumnNames = new String[vNotKeyColumnNames.size()];
         for (int i = 0; i < vNotKeyColumnNames.size(); i++)
         {
            notKeyColumnNames[i] = (String) vNotKeyColumnNames.elementAt(i);
         }
      }

      /**
       * 判断字段是否为主键
       * @param columnName 字段名
       * @return 如果给出的字段是主键，则返回true，否则返回false
       * @throws java.lang.Exception
       */
      public boolean isPK(String columnName) throws Exception
      {
         ColumnInfo columnInfo = (ColumnInfo) columnInfos.get(columnName);
         if (columnInfo != null)
         {
            return columnInfo.isPK;
         }
         else
         {
            throw new NoColumnException();
         }
      }

      /**
       * 获取字段类型
       * @param columnName 字段名
       * @return 字段类型
       * @throws java.lang.Exception
       */
      public int getColumnType(String columnName) throws Exception
      {
         ColumnInfo columnInfo = (ColumnInfo) columnInfos.get(columnName);
         if (columnInfo != null)
         {
            return columnInfo.columnType;
         }
         else
         {
            throw new NoColumnException();
         }
      }

      /**
       * 获取主键字段
       * @return 主键字符串数组
       */
      public String[] getPKColumns()
      {
         return this.keyColumnNames;
      }

      /**
       * 获取非主键字段
       * @return 非主键字段字符串数组
       */
      public String[] getNotPKColumns()
      {
         return this.notKeyColumnNames;
      }
   }

   private HashMap tableStructures;

   public DbBean()
   {
      this.tableStructures = new HashMap();
   }

   /**
    * 检查数据库中是否有这个表
    * @param tableName 表名
    * @param connection 数据库连接
    * @return 如果数据库中有此表则返回true，否则返回false
    * @throws java.lang.Exception
    */
   private boolean tableExist(String tableName, Connection connection) throws
      Exception
   {
      Statement st = connection.createStatement();
      String sql = "select count(*) from systables where tabname = '" +
         tableName + "';";
      ResultSet rs = st.executeQuery(sql);
      rs.next();
      int tableCount = rs.getInt(1);
      if (tableCount < 1)
      {
         return false;
      }
      else
      {
         return true;
      }
   }

   /**
    * 获取表的模式
    * @param tableName 表名
    * @param connection 数据库连接
    * @return 表模式
    * @throws java.lang.Exception
    */
   private String getModel(String tableName, Connection connection) throws
      Exception
   {
      Statement st = connection.createStatement();
      String sql = "select owner from systables where tabname = '" +
         tableName + "';";
      ResultSet rs = st.executeQuery(sql);
      rs.next();
      return rs.getString("owner");
   }

   //取主键序列
   /**
    * 取主键序列
    * @param tableName 表名
    * @param connection 数据库连接
    * @return 主键序列
    * @throws java.lang.Exception
    */
   private int[] getKeyColumnNo(String tableName, Connection connection) throws
      Exception
   {
      Statement st = connection.createStatement();
      String sql = "select 'informix'.indexkeyarray_out(indexkeys) " +
         "from sysconstraints, systables, sysindices " +
         "where systables.tabname = '" + tableName + "' and " +
         "sysconstraints.constrtype='P' and " +
         "sysconstraints.tabid = systables.tabid and " +
         "sysindices.tabid = systables.tabid and " +
         "sysindices.idxname = sysconstraints.idxname;";
//System.out.println("sql is:"+sql);
      ResultSet rs = st.executeQuery(sql);
      if (!rs.next())
      {
         return new int[0];
      }
      String indexKeys = rs.getString(1);

      //分析字符串，如："  2 [1], 3 [1], 4 [1], 6 [1]"
      Vector vKeyColumnNos = new Vector();
      char whiteSpace = ' ';
      int thelength = indexKeys.length();
      for (int i = thelength - 1; i > -1; i--)
      {
         if (indexKeys.charAt(i) == whiteSpace)
         {
            int length = indexKeys.length();
            if (length == i + 1)
            {
               indexKeys = indexKeys.trim();
            }
            else
            {
               indexKeys = indexKeys.substring(0, i) +
                  indexKeys.substring(i + 1);
            }

         }
      }
      int endIndex = 0;
      while (true)
      {
         endIndex = indexKeys.indexOf('[', endIndex);
         if (endIndex >= 0)
         {
            int startIndex = -1;
            startIndex = indexKeys.lastIndexOf(',', endIndex);
            if (startIndex < 0)
            {
               vKeyColumnNos.addElement(indexKeys.substring(0, endIndex));
            }
            else
            {
               vKeyColumnNos.addElement(indexKeys.substring(startIndex + 1,
                  endIndex));
            }
         }
         else
         {
            break;
         }
         endIndex++;
      }

      int keyColumnNos[] = new int[vKeyColumnNos.size()];
      for (int i = 0; i < vKeyColumnNos.size(); i++)
      {
         keyColumnNos[i] = Integer.parseInt( (String) vKeyColumnNos.
                                            elementAt(i));
      }
      return keyColumnNos;
   }

   /**
    * 增加表结构对象
    * @param tableName 表名
    * @param modelName 模式名
    * @param columnNames 字段名
    * @param columnTypes 字段类型
    * @param isPKs 是否主键
    * @return 表结构对象
    */
   private TableStructureBean addTableStructureObj(String tableName,
      String modelName,
      String[] columnNames,
      int[] columnTypes,
      boolean[] isPKs)
   {
      TableStructureBean tableStructure = new TableStructureBean(modelName,
         columnNames, columnTypes, isPKs);
      this.tableStructures.put(tableName, tableStructure);
      return tableStructure;
   }

   /**
    * 装载表结构
    * @param tableName 表名
    * @param connection 数据库连接
    * @return 表结构对象
    * @throws java.lang.Exception
    */
   private TableStructureBean loadTableStructure(String tableName,
                                                 Connection connection) throws
      Exception
   {

      String model;
      String columnNames[]; //列名
      int columnNos[]; //列号
      int columnTypes[]; //列类型
      boolean isPKs[]; //是否主键

      if (!tableExist(tableName, connection))
      {
         throw new NoTableException("数据库中没有（" + tableName + "）表！");
      }
      model = getModel(tableName, connection);
      int keyColumnNos[] = getKeyColumnNo(tableName, connection);

      //取表字段信息
      Statement st = connection.createStatement();
      String sql = "select count(*) from syscolumns, systables " +
         "where systables.tabname = '" + tableName + "' and " +
         "syscolumns.tabid = systables.tabid;";
//      java.util.ArrayList v = new ArrayList();

      ResultSet rs = st.executeQuery(sql);
      rs.next();
      int columnCount = rs.getInt(1);
      columnNames = new String[columnCount];
      columnNos = new int[columnCount];
      columnTypes = new int[columnCount];
      isPKs = new boolean[columnCount];

      sql = "select colno, colname, coltype from syscolumns, systables " +
         "where systables.tabname = '" + tableName + "' and " +
         "syscolumns.tabid = systables.tabid " +
         "order by colno;";
      rs = st.executeQuery(sql);
      for (int i = 0; i < columnCount; i++)
      {
         rs.next();
         columnNos[i] = rs.getInt("colno");
         columnNames[i] = rs.getString("colname").trim();
         columnTypes[i] = rs.getInt("coltype");
      }

      for (int i = 0; i < columnNos.length; i++)
      {
         isPKs[i] = false;
         for (int j = 0; j < keyColumnNos.length; j++)
         {
            if (columnNos[i] == keyColumnNos[j])
            {
               isPKs[i] = true;
               break;
            }
         }
      }

      return addTableStructureObj(tableName, model, columnNames, columnTypes,
                                  isPKs);
   }

   /**
    * 判断表中字段是否为主键
    * @param tableName 表名
    * @param columnName 字段名
    * @param connection 数据库连接
    * @return 如果字段为主键则返回true，否则返回false
    * @throws java.lang.Exception
    */
   public synchronized boolean isPK(String tableName, String columnName,
                                    Connection connection) throws Exception
   {
      return DBSniffer.getTS(connection, tableName).isPK(columnName);
   }

   /**
    * 获取字段类型
    * @param tableName 表名
    * @param columnName 字段名
    * @param connection 数据库连接
    * @return 字段类型  commsave.InformixDataType
    * @throws java.lang.Exception
    */
   public synchronized int getColumnType(String tableName, String columnName,
                                         Connection connection) throws
      Exception
   {
      tableName = tableName.toLowerCase();
      columnName = columnName.toLowerCase();
      TableStructureBean ts = (TableStructureBean)this.tableStructures.get(
         tableName);
      if (ts != null)
      {
         try
         {
            return ts.getColumnType(columnName);
         }
         catch (NoColumnException e)
         {
            throw new NoColumnException("表" + tableName + "中没有" +
                                        columnName + "字段！");
         }
      }

      //没有找到表信息，则先装入表信息
      TableStructureBean tableStructure = this.loadTableStructure(tableName,
         connection);
      return tableStructure.getColumnType(columnName);
   }

   /**
    * 获取模式名
    * @param tableName 表名
    * @param connection 数据库连接
    * @return 模式名
    * @throws java.lang.Exception
    * @deprecated
    */
   public synchronized String getModelName(String tableName,
                                           Connection connection) throws
      Exception
   {
      return DBSniffer.getTS(connection, tableName).getSchema();
   }

   /**
    * 获取表中主键字段
    * @param tableName 表名
    * @param connection 数据库连接
    * @return 主键字段
    * @throws java.lang.Exception
    */
   public synchronized String[] getPKColumns(String tableName,
                                             Connection connection) throws
      Exception
   {
      return DBSniffer.getTS(connection, tableName).getPKColumns();
   }

   /**
    * 获取非主键字段
    * @param tableName 表名
    * @param connection 数据库连接
    * @return 非主键字段
    * @throws java.lang.Exception
    */
   public synchronized String[] getNotPKColumns(String tableName,
                                                Connection connection) throws
      Exception
   {
      return DBSniffer.getTS(connection, tableName).getNotPKColumns();
   }
}
