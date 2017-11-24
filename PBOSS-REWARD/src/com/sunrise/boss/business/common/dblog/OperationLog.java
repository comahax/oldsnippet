/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-9-15
 */
package com.sunrise.boss.business.common.dblog;

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
public interface OperationLog extends Serializable {
	
	/**
	 * ���ض�Ӧ�Ĳ�����־VO��.
	 * @return
	 */
	Class logVOClass();
}
