package com.asisinfo.common.container;

/**
 * @author Quake Wang
 * @since 2004-7-13
 * @version $Revision$
 */
public class ComponentNotFoundException extends RuntimeException {

    public ComponentNotFoundException(String message) {
        super(message);
    }

    public ComponentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}