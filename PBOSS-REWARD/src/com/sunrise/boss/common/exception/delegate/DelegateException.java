package com.sunrise.boss.common.exception.delegate;

/**
 * <p>Title: GDIBOSS</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author HuangBaiming
 *
 * @version 1.0
 */
public class DelegateException
    extends Exception {
    public DelegateException() {
        super();
    }

    public DelegateException(String message) {
        super(message);
    }

    public DelegateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DelegateException(Throwable cause) {
        super(cause);
    }
}
