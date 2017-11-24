package com.sunrise.jop.infrastructure.control;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.sunrise.jop.infrastructure.db.*;

/**
 * <p>Title: 抽象ControlBean类</p>
 *
 * <p>Description: 封装了SessionBean、EJBLocalObject接口必须实现的方法</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author DuHuazheng && HuangBaiming
 * @author He Kun
 *
 * @version 1.0
 * @version 1.2 He Kun 2007-12, 实现 Authorizable 接口，用于设置 user参数
 */
public class AbstractControlBean implements SessionBean, EJBLocalObject, Authorizable {

    public SessionContext sessionContext;
    protected DBAccessUser user;
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

    /**
     * EJBLocalObject
     * 以下方法模拟容器生成的control的方法。
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
