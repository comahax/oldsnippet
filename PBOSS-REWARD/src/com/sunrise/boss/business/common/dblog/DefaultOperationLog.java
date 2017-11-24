/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-9-15
 */
package com.sunrise.boss.business.common.dblog;

import org.apache.commons.lang.*;

/**
 * DefaultOperationLog
 * <br> Description: 缺省的 OperationLog 接口实现. 提供默认方式获取 VO类对应的 logVO类.
 * 此实现必须符合VO, logVO的包命名,VO类命名规则.
 * 如: VO类: AbcVO, 
 *     logVO类, AbclogVO
 * <br> 如果不符合这一命名规则, 则需要实现 logVOClass 方法, 返回对应的logVOClass 类名.   
 * <br> Company: Sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-9-15
 */
public abstract class DefaultOperationLog implements OperationLog {

	/**
	 * 自动构造logVOClass
	 */
	public Class logVOClass() {
		return getLogVOClassByVOClass();
	}
	
	protected Class getLogVOClassByVOClass() {
		String className = this.getClass().getName();
		
		String voName = ClassUtils.getShortClassName(className);
		if(voName.endsWith("VO"))
			voName = voName.substring(0,voName.length() - 2);
		
		String moduleName = voName.toLowerCase();		
		String packPrefix  = ClassUtils.getPackageName(className);
		
		String logVOClassModule = moduleName + "log";
		String logVOPackPrefix = StringUtils.replace(packPrefix, moduleName , logVOClassModule);
		
		String logVOClass = new StringBuffer(logVOPackPrefix.length())
			.append(logVOPackPrefix).append(".")
			.append(voName).append("logVO").toString();
		try {
			return Class.forName(logVOClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
