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
 * <p>�й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ</p>
 * <p>���ݿ���,�����б���informix��������</p>
 * <p>Copyright (c) 2004</p>
 * <p>�й����ݴ��˵��ӿ������޹�˾</p>
 * @author BOSSǰ̨��
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
       * ģʽ����
       */
      public String schema; //owner
      private String catalog; //db name
      private String table_name;
      /**
       * �ֶ���Ϣ
       */
      public HashMap columnInfos;
      /**
       * �����ֶ���
       */
      public String[] keyColumnNames;
      /**
       * �������ֶ���
       */
      public String[] notKeyColumnNames;

      /**
       * ���캯��
       * @param modelName ģʽ��
       * @param columnNames �ֶ���
       * @param columnTypes �ֶ�����
       * @param isPKs �Ƿ�����
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
       * �ж��ֶ��Ƿ�Ϊ����
       * @param columnName �ֶ���
       * @return ����������ֶ����������򷵻�true�����򷵻�false
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
       * ��ȡ�ֶ�����
       * @param columnName �ֶ���
       * @return �ֶ�����
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
       * ��ȡ�����ֶ�
       * @return �����ַ�������
       */
      public String[] getPKColumns()
      {
         return this.keyColumnNames;
      }

      /**
       * ��ȡ�������ֶ�
       * @return �������ֶ��ַ�������
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
    * ������ݿ����Ƿ��������
    * @param tableName ����
    * @param connection ���ݿ�����
    * @return ������ݿ����д˱��򷵻�true�����򷵻�false
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
    * ��ȡ���ģʽ
    * @param tableName ����
    * @param connection ���ݿ�����
    * @return ��ģʽ
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

   //ȡ��������
   /**
    * ȡ��������
    * @param tableName ����
    * @param connection ���ݿ�����
    * @return ��������
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

      //�����ַ������磺"  2 [1], 3 [1], 4 [1], 6 [1]"
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
    * ���ӱ�ṹ����
    * @param tableName ����
    * @param modelName ģʽ��
    * @param columnNames �ֶ���
    * @param columnTypes �ֶ�����
    * @param isPKs �Ƿ�����
    * @return ��ṹ����
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
    * װ�ر�ṹ
    * @param tableName ����
    * @param connection ���ݿ�����
    * @return ��ṹ����
    * @throws java.lang.Exception
    */
   private TableStructureBean loadTableStructure(String tableName,
                                                 Connection connection) throws
      Exception
   {

      String model;
      String columnNames[]; //����
      int columnNos[]; //�к�
      int columnTypes[]; //������
      boolean isPKs[]; //�Ƿ�����

      if (!tableExist(tableName, connection))
      {
         throw new NoTableException("���ݿ���û�У�" + tableName + "����");
      }
      model = getModel(tableName, connection);
      int keyColumnNos[] = getKeyColumnNo(tableName, connection);

      //ȡ���ֶ���Ϣ
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
    * �жϱ����ֶ��Ƿ�Ϊ����
    * @param tableName ����
    * @param columnName �ֶ���
    * @param connection ���ݿ�����
    * @return ����ֶ�Ϊ�����򷵻�true�����򷵻�false
    * @throws java.lang.Exception
    */
   public synchronized boolean isPK(String tableName, String columnName,
                                    Connection connection) throws Exception
   {
      return DBSniffer.getTS(connection, tableName).isPK(columnName);
   }

   /**
    * ��ȡ�ֶ�����
    * @param tableName ����
    * @param columnName �ֶ���
    * @param connection ���ݿ�����
    * @return �ֶ�����  commsave.InformixDataType
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
            throw new NoColumnException("��" + tableName + "��û��" +
                                        columnName + "�ֶΣ�");
         }
      }

      //û���ҵ�����Ϣ������װ�����Ϣ
      TableStructureBean tableStructure = this.loadTableStructure(tableName,
         connection);
      return tableStructure.getColumnType(columnName);
   }

   /**
    * ��ȡģʽ��
    * @param tableName ����
    * @param connection ���ݿ�����
    * @return ģʽ��
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
    * ��ȡ���������ֶ�
    * @param tableName ����
    * @param connection ���ݿ�����
    * @return �����ֶ�
    * @throws java.lang.Exception
    */
   public synchronized String[] getPKColumns(String tableName,
                                             Connection connection) throws
      Exception
   {
      return DBSniffer.getTS(connection, tableName).getPKColumns();
   }

   /**
    * ��ȡ�������ֶ�
    * @param tableName ����
    * @param connection ���ݿ�����
    * @return �������ֶ�
    * @throws java.lang.Exception
    */
   public synchronized String[] getNotPKColumns(String tableName,
                                                Connection connection) throws
      Exception
   {
      return DBSniffer.getTS(connection, tableName).getNotPKColumns();
   }
}
