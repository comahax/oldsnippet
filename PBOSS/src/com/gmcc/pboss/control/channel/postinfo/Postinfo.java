/**
 * auto-generated code
 * Wed Jul 01 17:28:49 CST 2009
 */
package com.gmcc.pboss.control.channel.postinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.postinfo.PostinfoDBParam;
import com.gmcc.pboss.business.channel.postinfo.PostinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Postinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Postinfo extends AbstractControl {
    public PostinfoVO doCreate(PostinfoVO vo) throws Exception;

    public void doRemoveByVO(PostinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PostinfoVO doUpdate(PostinfoVO vo) throws Exception;

    public PostinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PostinfoDBParam params) throws Exception;

}
