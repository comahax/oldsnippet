package com.sunrise.boss.ui.commons.plugin;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author sunil
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HibernateStrutsPlugIn implements PlugIn {

  /* (non-Javadoc)
   * @see org.apache.struts.action.PlugIn#destroy()
   */
  public void destroy() {
    System.out.println("Calling HibernateStrutsPlugIn.destroy()");
  }

  /* (non-Javadoc)
   * @see org.apache.struts.action.PlugIn#init(org.apache.struts.action.ActionServlet, org.apache.struts.config.ModuleConfig)
   */
  public void init(ActionServlet arg0, ModuleConfig arg1) throws
      ServletException {
    System.out.println("Entering HibernateStrutsPlugIn.init()");
    try {
      SessionFactory sessionFactory = new Configuration().configure().
          buildSessionFactory();
      System.out.println("SessionFactory configured sucessfully");
    }
    catch (HibernateException e) {
      System.out.println("Error in configuring SessionFactory");
      e.printStackTrace();
    }
    System.out.println("Exiting HibernateStrutsPlugIn.init()");
  }
}
