/**
 * auto-generated code
 * Tue Jul 07 15:33:22 CST 2009
 */
package com.gmcc.pboss.control.channel.adimarea;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.channel.adimarea.AdimareaDBParam;
import com.gmcc.pboss.business.channel.adimarea.AdimareaVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Adimarea </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Adimarea extends AbstractControl {
    public AdimareaVO doCreate(AdimareaVO vo) throws Exception;

    public void doRemoveByVO(AdimareaVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdimareaVO doUpdate(AdimareaVO vo) throws Exception;

    public AdimareaVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdimareaDBParam params) throws Exception;
    
    public List doQueryUpperada(String adacode) throws Exception;

}
