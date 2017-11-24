/**
 * auto-generated code
 * Wed Jul 08 11:40:54 CST 2009
 */
package com.gmcc.pboss.control.channel.svwaycnstr;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.svwaycnstr.SvwaycnstrDBParam;
import com.gmcc.pboss.business.channel.svwaycnstr.SvwaycnstrVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Svwaycnstr </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Svwaycnstr extends AbstractControl {
    public SvwaycnstrVO doCreate(SvwaycnstrVO vo) throws Exception;

    public void doRemoveByVO(SvwaycnstrVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SvwaycnstrVO doUpdate(SvwaycnstrVO vo) throws Exception;

    public SvwaycnstrVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SvwaycnstrDBParam params) throws Exception;

}
