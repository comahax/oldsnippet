/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-9-15
 */
package com.sunrise.jop.infrastructure.sysadmin;

import java.io.*;

/**
 * DefaultOperationLog
 * <br> Description: ������־�ӿ�. ��Ҫ�Ǽǲ�����־��VO��,��Ҫʵ�ִ˽ӿ�.
 * һ�����Ӧһ����־��,��ṹ������ϲ�����־����ƹ淶.
 * <br> Company: Sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-9-15
 */
public interface BusinessLog extends Serializable {
	
	public static final Byte STATE_SUCCESS = Byte.valueOf("0");
	public static final Byte STATE_FAIL = Byte.valueOf("-1");
	
	public static final Short ACTION_CREATE = Short.valueOf("0"); 
	public static final Short ACTION_UPDATE = Short.valueOf("1"); 
	public static final Short ACTION_REMOVE = Short.valueOf("2");
	public static final Short ACTION_UNKNOWN = Short.valueOf("-1"); 
	
	/**
	 * ���ض�Ӧ�Ĳ�����־VO��.
	 * @return
	 */
	Class logVOClass();
}
