/**
 * auto-generated code
 * Sat Aug 13 11:12:29 CST 2011
 */
package com.gmcc.pboss.control.resource.comcatebrand;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comcatebrand </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Comcatebrand extends AbstractControl {
    public ComcatebrandVO doCreate(ComcatebrandVO vo) throws Exception;

    public void doRemoveByVO(ComcatebrandVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComcatebrandVO doUpdate(ComcatebrandVO vo) throws Exception;

    public ComcatebrandVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComcatebrandDBParam params) throws Exception;
	
	/**
     * 载入地市资源代码对应关系
     * @param cityid 市公司标识
     * @return
     * @throws Exception
     */
    public DataPackage doQueryRes2Comcate(ComcatebrandDBParam params,String cityid) throws Exception;
}
