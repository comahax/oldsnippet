/**
 * auto-generated code
 * Sun Sep 13 11:05:37 CST 2009
 */
package com.gmcc.pboss.control.channel.microarea;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Microarea </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface Microarea extends AbstractControl {
    public MicroareaVO doCreate(MicroareaVO vo) throws Exception;

    public void doRemoveByVO(MicroareaVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public MicroareaVO doUpdate(MicroareaVO vo) throws Exception;

    public MicroareaVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(MicroareaDBParam params) throws Exception;
    
    //查询分公司下的微区域
    public DataPackage doFindCountyMarea(MicroareaDBParam params) throws Exception;

}
