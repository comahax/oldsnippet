/**
 * auto-generated code
 * Wed Nov 14 09:57:16 CST 2012
 */
package com.gmcc.pboss.control.channel.busicircle;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.busicircle.BusicircleDBParam;
import com.gmcc.pboss.business.channel.busicircle.BusicircleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Busicircle </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Busicircle extends AbstractControl {
    public BusicircleVO doCreate(BusicircleVO vo) throws Exception;

    public void doRemoveByVO(BusicircleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BusicircleVO doUpdate(BusicircleVO vo) throws Exception;

    public BusicircleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BusicircleDBParam params) throws Exception;

}
