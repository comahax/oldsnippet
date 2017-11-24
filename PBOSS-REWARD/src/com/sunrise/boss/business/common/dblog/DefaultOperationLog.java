/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-9-15
 */
package com.sunrise.boss.business.common.dblog;

import org.apache.commons.lang.*;

/**
 * DefaultOperationLog
 * <br> Description: ȱʡ�� OperationLog �ӿ�ʵ��. �ṩĬ�Ϸ�ʽ��ȡ VO���Ӧ�� logVO��.
 * ��ʵ�ֱ������VO, logVO�İ�����,VO����������.
 * ��: VO��: AbcVO, 
 *     logVO��, AbclogVO
 * <br> �����������һ��������, ����Ҫʵ�� logVOClass ����, ���ض�Ӧ��logVOClass ����.   
 * <br> Company: Sunrise,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-9-15
 */
public abstract class DefaultOperationLog implements OperationLog {

	/**
	 * �Զ�����logVOClass
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
