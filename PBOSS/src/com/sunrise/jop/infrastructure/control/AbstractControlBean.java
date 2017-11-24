package com.sunrise.jop.infrastructure.control;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.sunrise.jop.infrastructure.db.*;

/**
 * <p>Title: ����ControlBean��</p>
 *
 * <p>Description: ��װ��SessionBean��EJBLocalObject�ӿڱ���ʵ�ֵķ���</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author DuHuazheng && HuangBaiming
 * @author He Kun
 *
 * @version 1.0
 * @version 1.2 He Kun 2007-12, ʵ�� Authorizable �ӿڣ��������� user����
 */
public class AbstractControlBean implements SessionBean, EJBLocalObject, Authorizable {

    public SessionContext sessionContext;
    protected DBAccessUser user;
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

    /**
     * EJBLocalObject
     * ���·���ģ���������ɵ�control�ķ�����
     */
    public EJBLocalHome getEJBLocalHome()
        throws EJBException {
        return null;
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

	public DBAccessUser getUser() {
		return user;
	}

	public void setUser(DBAccessUser user) {
		this.user = user;
	}

}
