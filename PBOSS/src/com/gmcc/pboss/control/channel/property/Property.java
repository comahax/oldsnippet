/**
 * auto-generated code
 * Sat Jan 24 11:49:16 CST 2015
 */
package com.gmcc.pboss.control.channel.property;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.property.PropertyDBParam;
import com.gmcc.pboss.business.channel.property.PropertyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Property </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Property extends AbstractControl {
    public PropertyVO doCreate(PropertyVO vo) throws Exception;

    public void doRemoveByVO(PropertyVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PropertyVO doUpdate(PropertyVO vo) throws Exception;

    public PropertyVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PropertyDBParam params) throws Exception;

}
