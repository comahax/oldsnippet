package com.sunrise.jop.common.spring;

import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.xml.parsers.FactoryConfigurationError;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring 上下文管理器，ContextManager
 * @author He Kun
 *
 */
public class SpringContextManager {
	static private String SPRING_CONFIG = "jop.spring.config";
	static private boolean initFlag = false;
	
	public static boolean isInitFlag() {
		return initFlag;
	}

	public static final String CONFIG_NAME = "applicationContext.xml";
//	public static final Logger log = LoggerFactory.getLogger(SpringContextManager.class);
    protected static final Logger log = Logger.getLogger(SpringContextManager.class);

	private static Map contextCache = new HashMap();
	
	// 根据J2EE标准和WAS具体环境，若程序自定义启动的线程或静态代码块中有读取JNDI资源的动作，
	// 系统启动时会报错:无法找到JNDI资源;
	// 所以注释掉此静态代码块,SpringContextManager.init()初始化方法将在InitServlet中调用。
	// 参看web.xml和InitServlet
	// by zhangsiwei 2010-08-19
	/*static {
		init();
	}*/
	
	public static void init() {
		init(CONFIG_NAME);
	}
	
	public static void init(String resouce) {
		//2011-8-24 jinbo 允许由外部提供spring配置文件所在路径
		// 读取部分参数
		String path = CoreConfigInfo.getRuntimeParam(SPRING_CONFIG);

		try {
			if (path != null){
				init(new String[]{path});
			}else{
				init(new String[]{resouce });
			}
		} catch (Exception e) {
			System.out.println("Spring initial error.");
			e.printStackTrace();
		}
		
		//2011-8-24 jinbo 允许由外部提供spring配置文件所在路径
//		init(new String[]{resouce });
	}
	
	private static void init(String[] resouces) {
		for (int i = 0; i < resouces.length; i++) {
			File f = new File(resouces[i]);
			ApplicationContext context = null;
			if (f.exists()){
				context = new FileSystemXmlApplicationContext(resouces[i]);
			} else{
				context = new ClassPathXmlApplicationContext(resouces[i]);
			}
			
			contextCache.put("context" + ( i + 1), context);			
		}
		initFlag = true;
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
