package com.asisinfo.common.jdbc.commsave;

/**
 * <p>中国移动广东省移动公司BOSS系统</p>
 * <p>Informix数据类型</p>
 * <p>Copyright (c) 2004</p>
 * <p>中国广州从兴电子开发有限公司</p>
 * @author BOSS前台组 <a href = "mailto:wudi@exchange.ricsson.com">吴迪</a>
 * @version 1.0
 * @deprecated
 */
public abstract class InformixDataType
{ //加256是非空同类型，例如10和266都是datetime型
    /**
     * 字符型 - 0
     */
    public final static int CHAR = 0;
    /**
     * 短整型 - 1
     */
    public final static int SMALLINT = 1;
    /**
     * 整型 - 2
     */
    public final static int INTEGER = 2;
    /**
     * 浮点型 - 3
     */
    public final static int FLOAT = 3;
    /**
     * 短浮点型 - 4
     */
    public final static int SMALLFLOAT = 4;
    /**
     * 小数型 - 5
     */
    public final static int DECIMAL = 5;
    /**
     * 连续型4 - 6
     */
    public final static int SERIAL4 = 6;
    /**
     * 日期型 - 7
     */
    public final static int DATE = 7;
    /**
     * 日期时间型 - 10
     */
    public final static int DATETIME = 10;
    /**
     * 可变长字符型 - 13
     */
    public final static int VARCHAR = 13;
    /**
     * 时间间隔型 - 14
     */
    public final static int INTERVAL = 14;
    /**
     * Unicode字符型 - 15
     */
    public final static int NCHAR = 15;
    /**
     * 可变长Unicode字符型 - 16
     */
    public final static int NVARCHAR = 16;
    /**
     * 连续型8 - 18
     */
    public final static int SERIAL8 = 18;
    /**
     * 长字符型 - 40
     */
    public final static int LVARCHAR = 40;
    /**
     * 块型 - 41
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
