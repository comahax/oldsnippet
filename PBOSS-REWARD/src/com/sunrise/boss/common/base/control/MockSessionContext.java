package com.sunrise.boss.common.base.control;

import com.sunrise.boss.common.base.db.SessionUtil;

import java.security.Identity;
import java.security.Principal;
import java.util.Properties;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.ejb.SessionContext;
/**
 ע�⣺����2��import���� J2EE1.4ʱҪ�����
 */
import javax.ejb.TimerService;
import javax.transaction.UserTransaction;
import javax.xml.rpc.handler.MessageContext;

/**
 * <p>Title: SessionContextʵ���� J2EE1.3</p>
 *
 * <p>Description: ģ��EJB�������ɵ�SessionContextʵ��</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author HuangBaiming
 *
 * @version 1.0
 */
public class MockSessionContext implements SessionContext {
    private boolean isRollbackOnly; //�ع���־λ

    public MockSessionContext() {
        isRollbackOnly = false;
    }

    public void setRollbackOnly()
        throws IllegalStateException {
        isRollbackOnly = true;
    }

    public boolean getRollbackOnly()
        throws IllegalStateException {
        return isRollbackOnly;
    }

    /**
     ע�⣺����3���������� J2EE1.4ʱҪʵ�ֵķ���
     */
    public TimerService getTimerService()
        throws IllegalStateException {
        return null;
    }

    public Object lookup(String string) {
        return null;
    }

    public MessageContext getMessageContext()
        throws IllegalStateException {
        return null;
    }

    //----------------- ����ķ������Ǽ�ʵ�֣�Ҳ����û�������ʵ�֣� ------------------------
    public Principal getCallerPrincipal() {
        return null;
    }

    public EJBHome getEJBHome()
        throws IllegalStateException {
        return null;
    }

    public EJBLocalHome getEJBLocalHome()
        throws IllegalStateException {
        return null;
    }

    public EJBLocalObject getEJBLocalObject()
        throws IllegalStateException {
        return null;
    }

    public EJBObject getEJBObject()
        throws IllegalStateException {
        return null;
    }

    public Properties getEnvironment() {
        return null;
    }

    public UserTransaction getUserTransaction()
        throws IllegalStateException {
        return null;
    }

    public boolean isCallerInRole(String string) {
        return false;
    }

    public boolean isCallerInRole(Identity identity) {
        return false;
    }

    public Identity getCallerIdentity() {
        return null;
    }

    public Object getBusinessObject(Class _class) throws IllegalStateException {
        return null;
    }

	public Object getInvokedBusinessInterface() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

}
