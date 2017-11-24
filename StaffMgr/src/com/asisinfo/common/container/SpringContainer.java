package com.asisinfo.common.container;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Quake Wang
 * @since 2004-7-13
 * @version $Revision$
 */
public class SpringContainer implements Container {
    private ApplicationContext applicationContext;

    public SpringContainer(ServletContext servletContext) {
        this.applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }

    public SpringContainer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * @param key
     *            component class type or component name
     * @return @throws
     *         ComponentNotFoundException
     */
    public Object getComponent(Object key) throws ComponentNotFoundException {
        if (applicationContext == null)
            throw new IllegalStateException("Spring Application context has not been set");
        if (key == null)
            throw new ComponentNotFoundException("The component key can not be null");
        if (key instanceof Class) {
            Map beans = applicationContext.getBeansOfType((Class) key);
            if (beans == null)
                throw new ComponentNotFoundException("The container is unable to resolve single instance of " + ((Class) key).getName()
                        + ", none instances found");
            if (beans.size() == 0 || beans.size() > 1)
                throw new ComponentNotFoundException("The container is unable to resolve single instance of " + ((Class) key).getName()
                        + ", number of instances found was: " + beans.size());
            key = beans.keySet().iterator().next();
        }
        return applicationContext.getBean(key.toString());
    }

    public void reload() {
        close();
        ((AbstractApplicationContext) applicationContext).refresh();
    }

    public void autowireComponent(Object bean) {
        ((AbstractApplicationContext) applicationContext).getBeanFactory().autowireBeanProperties(bean, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
    }

    public void close() {
        ((AbstractApplicationContext) applicationContext).close();
    }

}