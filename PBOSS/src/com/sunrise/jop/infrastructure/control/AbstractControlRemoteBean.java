package com.sunrise.jop.infrastructure.control;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBLocalObject;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * <p>Title: ����ControlBeanRemote��</p>
 *
 * <p>Description: ��װ��SessionBean�ӿڱ���ʵ�ֵķ���</p>
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
     * EJB�淶��Ҫʵ�ֵķ���
     */
    public void ejbCreate()
        throws CreateException {
    }

    /**
     * SessionBean����
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
