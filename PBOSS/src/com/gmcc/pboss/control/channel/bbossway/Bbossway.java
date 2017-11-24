/**
 * auto-generated code
 * Tue Apr 14 16:34:03 CST 2015
 */
package com.gmcc.pboss.control.channel.bbossway;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bbossway.BbosswayDBParam;
import com.gmcc.pboss.business.channel.bbossway.BbosswayVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bbossway </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Bbossway extends AbstractControl {
    public BbosswayVO doCreate(BbosswayVO vo) throws Exception;

    public void doRemoveByVO(BbosswayVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BbosswayVO doUpdate(BbosswayVO vo) throws Exception;

    public BbosswayVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BbosswayDBParam params) throws Exception;

}
