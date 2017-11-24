/**
 * auto-generated code
 * Wed May 18 19:21:10 CST 2011
 */
package com.gmcc.pboss.control.channel.changelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.changelog.ChangelogDBParam;
import com.gmcc.pboss.business.channel.changelog.ChangelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Changelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface Changelog extends AbstractControl {
    public ChangelogVO doCreate(ChangelogVO vo) throws Exception;

    public void doRemoveByVO(ChangelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ChangelogVO doUpdate(ChangelogVO vo) throws Exception;

    public ChangelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ChangelogDBParam params) throws Exception;

}
