/**
 * auto-generated code
 * Mon Mar 01 14:59:35 CST 2010
 */
package com.gmcc.pboss.control.channel.result;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.result.ResultDBParam;
import com.gmcc.pboss.business.channel.result.ResultVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Result </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Result extends AbstractControl {
    public ResultVO doCreate(ResultVO vo) throws Exception;

    public void doRemoveByVO(ResultVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResultVO doUpdate(ResultVO vo) throws Exception;

    public ResultVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResultDBParam params) throws Exception;

}
