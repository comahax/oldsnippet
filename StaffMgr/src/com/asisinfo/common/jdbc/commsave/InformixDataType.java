package com.asisinfo.common.jdbc.commsave;

/**
 * <p>�й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ</p>
 * <p>Informix��������</p>
 * <p>Copyright (c) 2004</p>
 * <p>�й����ݴ��˵��ӿ������޹�˾</p>
 * @author BOSSǰ̨�� <a href = "mailto:wudi@exchange.ricsson.com">���</a>
 * @version 1.0
 * @deprecated
 */
public abstract class InformixDataType
{ //��256�Ƿǿ�ͬ���ͣ�����10��266����datetime��
    /**
     * �ַ��� - 0
     */
    public final static int CHAR = 0;
    /**
     * ������ - 1
     */
    public final static int SMALLINT = 1;
    /**
     * ���� - 2
     */
    public final static int INTEGER = 2;
    /**
     * ������ - 3
     */
    public final static int FLOAT = 3;
    /**
     * �̸����� - 4
     */
    public final static int SMALLFLOAT = 4;
    /**
     * С���� - 5
     */
    public final static int DECIMAL = 5;
    /**
     * ������4 - 6
     */
    public final static int SERIAL4 = 6;
    /**
     * ������ - 7
     */
    public final static int DATE = 7;
    /**
     * ����ʱ���� - 10
     */
    public final static int DATETIME = 10;
    /**
     * �ɱ䳤�ַ��� - 13
     */
    public final static int VARCHAR = 13;
    /**
     * ʱ������ - 14
     */
    public final static int INTERVAL = 14;
    /**
     * Unicode�ַ��� - 15
     */
    public final static int NCHAR = 15;
    /**
     * �ɱ䳤Unicode�ַ��� - 16
     */
    public final static int NVARCHAR = 16;
    /**
     * ������8 - 18
     */
    public final static int SERIAL8 = 18;
    /**
     * ���ַ��� - 40
     */
    public final static int LVARCHAR = 40;
    /**
     * ���� - 41
     */
    public final static int CLOB = 41;


//  public static final short IFX_TYPE_CHAR = 0;
//  public static final short IFX_TYPE_SMALLINT = 1;
//  public static final short IFX_TYPE_INT = 2;
//  public static final short IFX_TYPE_FLOAT = 3;
//  public static final short IFX_TYPE_SMFLOAT = 4;
//  public static final short IFX_TYPE_DECIMAL = 5;
//  public static final short IFX_TYPE_SERIAL = 6;
//  public static final short IFX_TYPE_DATE = 7;
//  public static final short IFX_TYPE_MONEY = 8;
//  public static final short IFX_TYPE_NULL = 9;
//  public static final short IFX_TYPE_DATETIME = 10;
//  public static final short IFX_TYPE_BYTE = 11;
//  public static final short IFX_TYPE_TEXT = 12;
//  public static final short IFX_TYPE_VARCHAR = 13;
//  public static final short IFX_TYPE_INTERVAL = 14;
//  public static final short IFX_TYPE_NCHAR = 15;
//  public static final short IFX_TYPE_NVCHAR = 16;
//  public static final short IFX_TYPE_INT8 = 17;
//  public static final short IFX_TYPE_SERIAL8 = 18;
//  public static final short IFX_TYPE_SET = 19;
//  public static final short IFX_TYPE_MULTISET = 20;
//  public static final short IFX_TYPE_LIST = 21;
//  public static final short IFX_TYPE_ROW = 22;
//  public static final short IFX_TYPE_COLLECTION = 23;
//  public static final short IFX_TYPE_ROWREF = 24;
//  public static final short IFX_TYPE_UDTVAR = 40;
//  public static final short IFX_TYPE_UDTFIXED = 41;
//  public static final short IFX_TYPE_REFSER8 = 42;
//  public static final short IFX_TYPE_LVARCHAR = 43;
//  public static final short IFX_TYPE_SENDRECV = 44;
//  public static final short IFX_TYPE_BOOL = 45;
//  public static final short IFX_TYPE_IMPEXP = 46;
//  public static final short IFX_TYPE_IMPEXPBIN = 47;
//  public static final short IFX_TYPE_SQLUDRDEFAULT = 48;
//  public static final short IFX_TYPE_UNKNOWN = -99;
//  public static final short IFX_TYPE_MAX = 49;
//  public static final short IFX_TYPE_CLOB = 101;
//  public static final short IFX_TYPE_BLOB = 102;

}
