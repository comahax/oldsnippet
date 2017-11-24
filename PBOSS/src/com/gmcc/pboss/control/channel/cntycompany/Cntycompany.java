/**
 * auto-generated code
 * Wed Jul 08 10:58:02 CST 2009
 */
package com.gmcc.pboss.control.channel.cntycompany;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cntycompany </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Cntycompany extends AbstractControl {
    public CntycompanyVO doCreate(CntycompanyVO vo) throws Exception;

    public void doRemoveByVO(CntycompanyVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CntycompanyVO doUpdate(CntycompanyVO vo) throws Exception;

    public CntycompanyVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CntycompanyDBParam params) throws Exception;
    
    public DataPackage doGetCntycompanysOfCity(String cityid) throws Exception;

}
