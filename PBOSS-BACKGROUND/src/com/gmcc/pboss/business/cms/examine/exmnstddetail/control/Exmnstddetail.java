package com.gmcc.pboss.business.cms.examine.exmnstddetail.control;


import java.io.Serializable;


import com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent.ExmnstddetailDBParam;
import com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent.ExmnstddetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Exmnstddetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnstddetail extends AbstractControl {
    public ExmnstddetailVO doCreate(ExmnstddetailVO vo) throws Exception;

    public void doRemoveByVO(ExmnstddetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ExmnstddetailVO doUpdate(ExmnstddetailVO vo) throws Exception;

    public ExmnstddetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ExmnstddetailDBParam params) throws Exception;
    /**
     * ������������[WAYID]���������˱�ʶ[EXMNID]��������������[EXMNPERIOD]
     * ����ͳ��ָ��÷���ϸ�ġ����˷���[EXMNMARK]�����õ��������ܷ֡��������Ϣ
     * @return
     * @throws Exception
     */
    public DataPackage doSumGroupExmnmarkInfo(String exmnperiod) throws Exception ;
    /**
     * ���ݡ���������[WAYID]���������˱�ʶ[EXMNID]�������������ڡ��ж�
     * ָ��÷���ϸ�����Ƿ���ڡ������[ISVOTED]��Ϊ����[1]������ָ��
     * @param wayid
     * @param exmnid
     * @param exmnperiod
     * @return
     * @throws Exception
     */
    public boolean doHasIsvotedExmnstddetail(String wayid,Integer exmnid,String exmnperiod)throws Exception;
    /**
	 * ���ݿ�������ɾ���Ѵ��ڵ�ָ��÷���ϸ��Ϣ
	 * @param exmnperiod
	 * @throws Exception
	 */
	public void doDelBeingExmnstddetail(String exmnperiod)throws Exception;

}
