/**
 * auto-generated code
 * Sun Nov 01 15:18:07 CST 2009
 */
package com.gmcc.pboss.control.channel.flowname;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.flowname.FlownameDBParam;
import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Flowname </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Flowname extends AbstractControl {
    public FlownameVO doCreate(FlownameVO vo) throws Exception;

    public void doRemoveByVO(FlownameVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public FlownameVO doUpdate(FlownameVO vo) throws Exception;

    public FlownameVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(FlownameDBParam params) throws Exception;

}
