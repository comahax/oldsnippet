/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-9-15
 */
package com.sunrise.boss.business.common.dblog;

import java.io.*;

/**
 * DefaultOperationLog
 * <br> Description: 操作日志接口. 需要登记操作日志的VO类,需要实现此接口.
 * 一个表对应一张日志表,表结构必须符合操作日志表设计规范.
 * <br> Company: Sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-9-15
 */
public interface OperationLog extends Serializable {
	
	/**
	 * 返回对应的操作日志VO类.
	 * @return
	 */
	Class logVOClass();
}
