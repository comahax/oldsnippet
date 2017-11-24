package com.sunrise.jop.common.spring;

import java.io.*;
import java.util.*;
import java.util.zip.*;

import org.apache.commons.logging.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.*;
import org.springframework.core.*;
import org.springframework.util.*;

/**
 * ��;���Զ��ѷ���������classע��Ϊbean ���ã�����xml����
 * 
 * @author Huang Baiming
 * @version 1.0 2007-12-4
 * @version 1.1 2007-12-11 ������ʽƥ�����spring�Դ���PatternMatchUtils
 */
public class AutoBeanCreator implements BeanFactoryPostProcessor, Ordered {
	
	private static Log log = LogFactory.getLog(AutoBeanCreator.class);
	// --------------------------------------------------------------
	private int order; // BeanFactoryPostProcessor��ʼ��˳��Spring������
	private boolean singleton;
	
	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	private List packageNames; // Ҫ���Զ�����bean��package�б�

	public void setPackageNames(String[] names) {
		this.packageNames = new ArrayList(names.length);
		for (int i = 0; i < names.length; i++) {
			this.packageNames.add(StringUtils.trimWhitespace(names[i]));
		}
	}

	private List patterns = null; // ����beanʱ������������Ҫ���ϸ�ģʽ����ű�����ΪBean

	public void setPatterns(String[] patterns) {
		this.patterns = new ArrayList(patterns.length);
		for (int i = 0; i < patterns.length; i++) {
			String pattern = StringUtils.trimWhitespace(patterns[i]);
			this.patterns.add(pattern);
		}
	}

	private boolean readJar = false; // �Ƿ���Ҫ��ȡjar����Ĭ��Ϊfalse���Ż������ٶ�

	public void setReadJar(boolean readJar) {
		this.readJar = readJar;
	}

	public boolean isReadJar() {
		return this.readJar;
	}

	// -- getter and setter ---------------------------------------------------

	/**
	 * ��ȡclasspath,��������class�ļ����ѷ���������ע��Ϊspring���������bean
	 */
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {

		List beanNames = new ArrayList(); // ��list���ڱ������������bean���ƣ�Ҳ����������

		/* 1.����class·�������з���������Bean */
		String[] classPaths = findClassPaths();
		java.net.URL webPath = this.getClass().getResource("/");
		Iterator iter = this.packageNames.iterator();
		while (iter.hasNext()) {
			try {
				String packageName = (String) iter.next();
				findBeanNamesFromClassPaths(classPaths, packageName, beanNames);
				findBeanNamesFromWebInfo(webPath, packageName, beanNames);
			} catch (Exception e) {
				throw new FatalBeanException(" Find bean names Error��", e);
			}
		}

		/* 2.ע��Bean */
		DefaultListableBeanFactory bf = (DefaultListableBeanFactory) factory;
		Iterator iter2 = beanNames.iterator();
		while (iter2.hasNext()) {
			String beanName = (String) iter2.next();
			try {
				if (Class.forName(beanName).isInterface()) {// ���Խӿ�
					continue;
				}
				if (bf.containsBean(beanName)) { // ���ظ�ʱ���쳣
					throw new FatalBeanException(" Repeated bean name Error��");
				}
				BeanDefinition beanDefinition = new RootBeanDefinition();
				beanDefinition.setBeanClassName(beanName);
				bf.registerBeanDefinition(beanName, beanDefinition);
				if(log.isDebugEnabled()) log.debug("ע��bean: " + beanName);
			} catch (ClassNotFoundException e) {
				throw new FatalBeanException("Can't find class for the bean name:" + beanName, e);
			}
		}
	}

	protected String[] findClassPaths() {
		String classpath = System.getProperty("java.class.path");
		String split;
		if (classpath.indexOf(";") > 0) {
			split = ";";
		} else {
			split = ":";
		}
		return classpath.split(split);
	}

	protected void findBeanNamesFromClassPaths(String[] classPaths, String packageName, List beanNames) throws Exception {
		for (int i = 0; i < classPaths.length; ++i) {
			String path = classPaths[i];
			if (path.endsWith(".jar")) {
				if (this.readJar) {
					findFromJar(path, packageName, beanNames);
				}
			} else {
				File file = new File(path + File.separator + StringUtils.replace(packageName,".", File.separator));
				findFromFile(file, packageName, beanNames);
			}
		}
	}

	/**
	 * ��ʱֻ֧�ֲ���WEB-INF/classesĿ¼�µ��ļ�����֧��WEB-INF/libĿ¼
	 */
	protected void findBeanNamesFromWebInfo(java.net.URL webPath, String packageName, List beanNames) throws Exception {
		String filePath = webPath.toString();
		filePath = filePath.substring(5, filePath.length());
		if (filePath.indexOf("WEB-INF") >= 0) {
			File file = new File(filePath + File.separator + StringUtils.replace(packageName,".", File.separator));
			findFromFile(file, packageName, beanNames);
		}
	}

	/**
	 * ZipEntry��ʾZIP�ļ���Ŀ
	 */
	protected void findFromJar(String jarPath, String packageName, List beanNames) throws Exception {
		ZipInputStream in = new ZipInputStream(new FileInputStream(new File(jarPath)));
		ZipEntry ze = null;
		while ((ze = in.getNextEntry()) != null) {
			String name = ze.getName();
			if (name.startsWith(  StringUtils.replace(packageName,".", "/")) && name.endsWith(".class")) {
				String className = name.substring(0, name.length() - 6);
				if (isMatch(className)) {
					beanNames.add(className);
				}
			}
		}
		in.close();
	}

	/**
	 * �ݹ鷽��
	 */
	protected void findFromFile(File file, String packageName, List beanNames) throws Exception {
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; ++i) {
					findFromFile(files[i], packageName + "." + files[i].getName(), beanNames);
				}
			} else {
				if(log.isDebugEnabled()) log.debug("check class file:" + file.getName());
				if (file.getName().endsWith(".class")) {
					String className = packageName.substring(0, packageName.length() - 6); // �����packageName�Ѿ���class�ļ���
					if (isMatch(className)) {
						if(log.isDebugEnabled()) log.debug("add class file:" + file.getName());
						beanNames.add(className);
					}
				}
			}
		}
	}

	protected boolean isMatch(String name) {
		if (this.patterns == null) {
			return true;
		}
		Iterator iter = this.patterns.iterator();
		while (iter.hasNext()) {
			String pattern = (String) iter.next();
			if (PatternMatchUtils.simpleMatch(pattern, name)) {
				return true;
			}
		}
		return false;
	}

	public boolean isSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}
}
