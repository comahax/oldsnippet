/**
 * auto-generated code
 * Thu Jul 09 10:43:47 CST 2009
 */
package com.gmcc.pboss.control.base.operator;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operator </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Operator extends AbstractControl {
    public OperatorVO doCreate(OperatorVO vo) throws Exception;

    public void doRemoveByVO(OperatorVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperatorVO doUpdate(OperatorVO vo) throws Exception;

    public OperatorVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperatorDBParam params) throws Exception;
    /**
     * 根据角色标识查找操作员用户列表
     * @param roleids
     * @param params TODO
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOperatorList(String roleids, OperatorDBParam params) throws Exception ;
    /**
     * 查询网点审批可用操作员列表
     * step=1，第一步审批，step=2第二部审批，step=djugeAudit 判断登陆工号有没有审批权限。
     * @param region
     * @param param
     * @return
     * @throws Exception
     */
    public DataPackage doQueryWayOperatorList(String step,OperatorDBParam param) throws Exception ;
    public DataPackage doQueryLowerOperator(OperatorDBParam param) throws Exception;

}
