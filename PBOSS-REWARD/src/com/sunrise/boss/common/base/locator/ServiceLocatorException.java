package com.sunrise.boss.common.base.locator;

/**
 * <p>Title: GDIBOSS</p>
 *
 * <p>Description: ����λ��ServiceLocator�׳����쳣</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author HuangBaiming
 *
 * @version 1.0
 */
public class ServiceLocatorException
    extends Exception {

    public ServiceLocatorException() {
        super();
    }

    public ServiceLocatorException(String message) {
        super(message);
    }

    public ServiceLocatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceLocatorException(Throwable cause) {
        super(cause);
    }
}
