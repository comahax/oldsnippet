/**
 * auto-generated code
 * Tue Sep 29 10:21:01 CST 2009
 */
package com.gmcc.pboss.control.communication.advgroup;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.gmcc.pboss.business.communication.advgroup.AdvgroupDBParam;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupVO;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupVOHelper;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Advgroup </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Advgroup extends AbstractControl {
    public AdvgroupVO doCreate(AdvgroupVO vo) throws Exception;

    public void doRemoveByVO(AdvgroupVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AdvgroupVO doUpdate(AdvgroupVO vo) throws Exception;

    public AdvgroupVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AdvgroupDBParam params) throws Exception;

    public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)throws Exception;
    
    //保存群组
    public Long doSaveGroup(AdvgroupVOHelper helper, Boolean createFlag) throws Exception;
    //删除群组
    public void doDeleteGroup(Set<String> groupidSet) throws Exception;
    //删除群组人员
    public void doDeleteGroupobj(Set<String> groupidSet, List<String> groupoidList) throws Exception;
}
