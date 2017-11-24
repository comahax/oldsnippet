/**
 * auto-generated code
 * Wed Nov 14 09:58:01 CST 2012
 */
package com.gmcc.pboss.control.channel.busicirclelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogDBParam;
import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Busicirclelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Busicirclelog extends AbstractControl {
    public BusicirclelogVO doCreate(BusicirclelogVO vo) throws Exception;

    public void doRemoveByVO(BusicirclelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BusicirclelogVO doUpdate(BusicirclelogVO vo) throws Exception;

    public BusicirclelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BusicirclelogDBParam params) throws Exception;

}
