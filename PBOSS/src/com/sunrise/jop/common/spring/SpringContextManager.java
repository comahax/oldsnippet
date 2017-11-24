package com.sunrise.jop.common.spring;

import java.util.*;

import org.apache.commons.logging.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

/**
 * Spring �����Ĺ�������ContextManager
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
	 * ��ȡȱʡ���ã���һ�����ã���Ӧ��context
	 * @return
	 */
	public static ApplicationContext getDefaultContext() {
		return (ApplicationContext)contextCache.get("context1");
	}
	
	/**
	 * ��ȡȱʡ���ã���һ�����ã���Ӧ��context
	 * @return
	 */
	public static DefaultListableBeanFactory getDefaultBeanFactory() {
		AbstractXmlApplicationContext context = (AbstractXmlApplicationContext)contextCache.get("context1");
		return (DefaultListableBeanFactory)context.getBeanFactory();
	}
	
	/**
	 * ��ȱʡ��bean�����л�ȡָ�����Ƶ�beanʵ��
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return getBean(name,null);
	}
	
	/**
	 * �ж�ȱʡbean�������Ƿ����ָ����Bean
	 * @param beanName
	 * @return
	 */
	public static boolean containsBean(String beanName) {
		return getDefaultBeanFactory().containsBean(beanName);
	}
	/**
	 * ��ȱʡ��bean�����л�ȡָ�����Ƶ�beanʵ��
	 * @param name
	 * @param args
	 * @return
	 */
	public static Object getBean(String name,Object[] args) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		if(args == null) 
			return beanFactory.getBean(name,args);
		else
			return beanFactory.getBean(name,args); //������������⣬Spring��֧�ֹ��캯�����Σ������޸�
	}
	
	
	/**
	 * ע��bean����,ʹ��protype
	 * @param idOrName
	 * @param beanClass
	 */
	public static void registerBean(String idOrName,Class beanClass) {
		registerBean(idOrName, beanClass,false);
	}
	
	/**
	 * ע��bean����
	 * @param idOrName
	 * @param beanClass
	 * @param isSingleton
	 */
	public static void registerBean(String idOrName,Class beanClass,boolean isSingleton) {
		DefaultListableBeanFactory beanFactory = getDefaultBeanFactory();
		if(!beanFactory.containsBean( idOrName )){
			
			RootBeanDefinition beanDefinition = new RootBeanDefinition();
			beanDefinition.setBeanClassName(beanClass.getName());
			beanDefinition.setSingleton(isSingleton); //Ĭ��Ϊtrue, ��Ҫ���ӿ�������
			beanFactory.registerBeanDefinition( idOrName , beanDefinition);
			
			if(log.isDebugEnabled()) log.debug("ע��bean: " + idOrName +" singleton?:" + isSingleton);
		}
		
	}
	
	/**
	 * ��ȡbean����
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
