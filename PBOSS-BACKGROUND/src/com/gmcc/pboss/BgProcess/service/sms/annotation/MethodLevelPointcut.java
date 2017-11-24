package com.gmcc.pboss.BgProcess.service.sms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * ���б�ע�˴�Annotation�ķǾ�̬(static)����
 * ���ᱻ{@link org.springframework.aop.support.annotation.AnnotationMatchingPointcut} 
 * ƥ�䲢֯��(Weaving){@link com.gmcc.pboss.BgProcess.service.sms.advise.DBConnectionMonitorAdvise}
 * ָ�����߼�,���������ο�applicationContext3.xml
 * </pre>
 * @author zhangsiwei
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodLevelPointcut {
}
