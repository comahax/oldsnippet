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
     * ���ݽ�ɫ��ʶ���Ҳ���Ա�û��б�
     * @param roleids
     * @param params TODO
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOperatorList(String roleids, OperatorDBParam params) throws Exception ;
    /**
     * ��ѯ�����������ò���Ա�б�
     * step=1����һ��������step=2�ڶ���������step=djugeAudit �жϵ�½������û������Ȩ�ޡ�
     * @param region
     * @param param
     * @return
     * @throws Exception
     */
    public DataPackage doQueryWayOperatorList(String step,OperatorDBParam param) throws Exception ;
    public DataPackage doQueryLowerOperator(OperatorDBParam param) throws Exception;

}
