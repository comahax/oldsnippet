package com.asisinfo.common.jdbc;

/**
 * <p>�й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ</p>
 * <p>���ݿ����ޱ��쳣</p>
 * <p>Copyright (c) 2004</p>
 * <p>�й����ݴ��˵��ӿ������޹�˾</p>
 * @author BOSSǰ̨�� <a href = "mailto:wudi@exchange.ricsson.com">���</a>
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
     * ���췽��
     * @param errMsg ������Ϣ
     */
    public NoTableException(String errMsg)
    {
        super(errMsg);
    }
}
