package com.gmcc.pboss.BgProcess.service.sms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 所有标注了此Annotation的非静态(static)方法
 * 都会被{@link org.springframework.aop.support.annotation.AnnotationMatchingPointcut} 
 * 匹配并织入(Weaving){@link com.gmcc.pboss.BgProcess.service.sms.advise.DBConnectionMonitorAdvise}
 * 指定的逻辑,相关配置请参看applicationContext3.xml
 * </pre>
 * @author zhangsiwei
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodLevelPointcut {
}
