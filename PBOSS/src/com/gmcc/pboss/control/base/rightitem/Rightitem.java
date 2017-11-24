/**
 * auto-generated code
 * Mon Jul 13 10:27:28 CST 2009
 */
package com.gmcc.pboss.control.base.rightitem;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rightitem.RightitemDBParam;
import com.gmcc.pboss.business.base.rightitem.RightitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rightitem </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public interface Rightitem extends AbstractControl {
	
    public RightitemVO doCreate(RightitemVO vo) throws Exception;

    public void doRemoveByVO(RightitemVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RightitemVO doUpdate(RightitemVO vo) throws Exception;

    public RightitemVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RightitemDBParam params) throws Exception;
	
	public DataPackage doQueryRightRootId() throws Exception;
	
	public DataPackage doQueryText(String queryText) throws Exception;
}
