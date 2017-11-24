package com.asisinfo.common.container;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



/**
 * DefaultApplicationSetupListener that sets up the environment so that
 * XWork and Webwork can load data and information from Spring. Relies on
 * Spring's {@link org.springframework.web.context.ContextLoaderListener}having
 * been called first.
 * 
 * @author Quake Wang
 * @since 2004-7-12
 * @version $Revision$
 */
public class DefaultApplicationSetupListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        SpringContainer container = new SpringContainer(event.getServletContext());
        Application.getInstance().setContainer(container);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // do nothing
    }

}