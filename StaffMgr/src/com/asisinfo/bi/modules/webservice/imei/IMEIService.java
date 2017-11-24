/**
 * IMEIService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.asisinfo.bi.modules.webservice.imei;

public interface IMEIService extends java.rmi.Remote {
    public java.lang.String queryIMEI(java.lang.String mobile, java.lang.String get_type) throws java.rmi.RemoteException;
    public java.lang.String queryICCID(java.lang.String mobile, java.lang.String get_type) throws java.rmi.RemoteException;
}
