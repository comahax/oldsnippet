package com.sunrise.jop.infrastructure.control;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBLocalObject;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * <p>Title: 抽象ControlBeanRemote类</p>
 *
 * <p>Description: 封装了SessionBean接口必须实现的方法</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author liaojinbo
 *
 * @version 1.0
 */
public class AbstractControlRemoteBean implements SessionBean {

    public SessionContext sessionContext;

    /**
     * EJB规范里要实现的方法
     */
    public void ejbCreate()
        throws CreateException {
    }

    /**
     * SessionBean方法
     */
    public void ejbActivate()
        throws EJBException {
    }

    public void ejbPassivate()
        throws EJBException {
    }

    public void ejbRemove()
        throws EJBException {
    }

    public void setSessionContext(SessionContext sessionContext)
        throws
        EJBException {
        this.sessionContext = sessionContext;
    }

    public Object getPrimaryKey()
        throws EJBException {
        return null;
    }

    public void remove()
        throws EJBException {
    }

    public boolean isIdentical(EJBLocalObject eJBLocalObject)
        throws
        EJBException {
        return false;
    }

}
