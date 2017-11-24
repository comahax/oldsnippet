package com.asisinfo.common.jdbc;

/**
 * <p>中国移动广东省移动公司BOSS系统</p>
 * <p>无字段异常</p>
 * <p>Copyright (c) 2004</p>
 * <p>中国广州从兴电子开发有限公司</p>
 * @author BOSS前台组 <a href = "mailto:wudi@exchange.ricsson.com">吴迪</a>
 * @version 1.0
 */
public class NoColumnException
    extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5714143285649169959L;

	public NoColumnException()
    {
    }

    /**
     * 构造方法
     * @param errMsg 错误信息
     */
    public NoColumnException(String errMsg)
    {
        super(errMsg);
    }
}
