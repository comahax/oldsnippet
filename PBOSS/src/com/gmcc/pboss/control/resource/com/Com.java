/**
 * auto-generated code
 * Sat Sep 05 11:44:39 CST 2009
 */
package com.gmcc.pboss.control.resource.com;

import java.io.Serializable;
import java.util.Collection;

import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Com </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Com extends AbstractControl {
    public ComVO doCreate(ComVO vo) throws Exception;

    public void doRemoveByVO(ComVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComVO doUpdate(ComVO vo) throws Exception;

    public ComVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComDBParam params) throws Exception;
    /**
	 * 创建号码规则
	 */
	public NumsortruleVO doCreateNumsortruleVO(NumsortruleVO vo) throws Exception ;

}
