/**
 * auto-generated code
 * Wed Sep 21 15:48:50 CST 2011
 */
package com.gmcc.pboss.control.base.dbloginlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.dbloginlog.DbLoginlogDBParam;
import com.gmcc.pboss.business.base.dbloginlog.DbLoginlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DbLoginlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface DbLoginlog extends AbstractControl {
    public DbLoginlogVO doCreate(DbLoginlogVO vo) throws Exception;

    public void doRemoveByVO(DbLoginlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DbLoginlogVO doUpdate(DbLoginlogVO vo) throws Exception;

    public DbLoginlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DbLoginlogDBParam params) throws Exception;

}
