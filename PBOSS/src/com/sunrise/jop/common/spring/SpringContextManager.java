package com.sunrise.jop.common.spring;

import java.util.*;

import org.apache.commons.logging.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

/**
 * Spring 上下文管理器，ContextManager
 * @author He Kun
 *
 */
public class SpringContextManager {
	
	public static final String CONFIG_NAME = "applicationContext.xml";
	public static final Log log = LogFactory.getLog(SpringContextManager.class);
	
	private static Map contextCache = new HashMap();
	
	static {
		//init();
	}
	
	public static void init() {
		init(CONFIG_NAME);
	}
	
	public static void init(String resouce) {
		init(new String[]{resouce });
	}
	
	public static void init(String[] resouces) {
		for (int i = 0; i < resouces.length; i++) {
			ApplicationContext context = new ClassPathXmlApplicationContext(resouces[i]);
			contextCache.put("context" + ( i + 1), context);			
		}
	}
	
	/**
	 * 获取缺省配置（第一个配置）对应的context
	 * @return
	 */
	public static ApplicationContext getDefaultContext() {
		return (ApplicationContext)contextCache.get("context1");
	}
	
	/**
	 * 获取缺省配置（第一个配置）对应的context
	 * @return
	 */
	public static DefaultListableBeanFactory getDefaultBeanFactory() {
		AbstractXmlApplicationContext context = (AbstractXmlApplicationContext)contextCache.get("context1");
		return (DefaultListableBeanFactory)context.getBeanFactory();
	}
	
	/**
	 * 从缺省的bean工厂中获取指定名称的bean实例
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return getBean(name,null);
	}
	
	/**
	 * 判断缺省bean容器中是否包含指定的Bean
	 * @param beanName
	 * @return
	 */
	public static boolean containsBean(String beanName) {
		return getDefaultBeanFactory().containsBean(beanName);
	}
	/**
	 * 从缺省的bean工厂中获取指定名称的bean实例
	 * @param name
	 * @param args
	 * @return
	 */
	public static Object getBean(String name,Object[] args) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		if(args == null) 
			return beanFactory.getBean(name,args);
		else
			return beanFactory.getBean(name,args); //这个方法有问题，Spring不支持构造函数传参，将来修改
	}
	
	
	/**
	 * 注册bean定义,使用protype
	 * @param idOrName
	 * @param beanClass
	 */
	public static void registerBean(String idOrName,Class beanClass) {
		registerBean(idOrName, beanClass,false);
	}
	
	/**
	 * 注册bean定义
	 * @param idOrName
	 * @param beanClass
	 * @param isSingleton
	 */
	public static void registerBean(String idOrName,Class beanClass,boolean isSingleton) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		if(!beanFactory.containsBean( idOrName )){
			
			RootBeanDefinition beanDefinition = new RootBeanDefinition();
			beanDefinition.setBeanClassName(beanClass.getName());
			beanDefinition.setSingleton(isSingleton); //默认为true, 需要增加可配置性
			beanFactory.registerBeanDefinition( idOrName , beanDefinition);
			
			if(log.isDebugEnabled()) log.debug("注册bean: " + idOrName +" singleton?:" + isSingleton);
		}
		
	}
	
	/**
	 * 获取bean定义
	 * @param beanName
	 */
	public static BeanDefinition getBeanDefinition(String beanName) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		BeanDefinition def = beanFactory.getBeanDefinition(beanName);
		return def;
	}
	/**
	 * demo
	 * @param args
	 */
	public static void main(String[] args) {
		SpringContextManager.registerBean(HashMap.class.getName(), HashMap.class);
		Map hashMap = (Map)SpringContextManager.getBean(HashMap.class.getName());
		System.out.println("bean:" + hashMap);
	}
}
