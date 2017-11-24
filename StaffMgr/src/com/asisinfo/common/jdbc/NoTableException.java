package com.asisinfo.common.jdbc;

/**
 * <p>中国移动广东省移动公司BOSS系统</p>
 * <p>数据库中无表异常</p>
 * <p>Copyright (c) 2004</p>
 * <p>中国广州从兴电子开发有限公司</p>
 * @author BOSS前台组 <a href = "mailto:wudi@exchange.ricsson.com">吴迪</a>
 * @version 1.0
 */
public class NoTableException
    extends java.sql.SQLException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5670741529521494510L;

	/**
     * 构造方法
     * @param errMsg 错误信息
     */
    public NoTableException(String errMsg)
    {
        super(errMsg);
    }
}
