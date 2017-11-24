package com.sunrise.boss.common.base.control;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;

/**
 * <p>Title: </p>
 *
 * <p>Description: ¹«ÓÃEJBLocalHome </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise</p>
 *
 * @author DuHuazheng && HuangBaiming
 *
 * @version 1.0
 */
public interface ControlHome
    extends EJBLocalHome {
    public EJBLocalObject create()
        throws CreateException;
}
