/**
 * auto-generated code
 * Tue Jun 05 08:33:24 CST 2012
 */
package com.gmcc.pboss.control.channel.checkedapplydetail;

import java.io.Serializable;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Checkedapplydetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Checkedapplydetail extends AbstractControl {
    public CheckedapplydetailVO doCreate(CheckedapplydetailVO vo) throws Exception;

    public void doRemoveByVO(CheckedapplydetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CheckedapplydetailVO doUpdate(CheckedapplydetailVO vo) throws Exception;

    public CheckedapplydetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CheckedapplydetailDBParam params) throws Exception;
    
    public DataPackage doQueryCheckedapplydetail(CheckedapplydetailDBParam params) throws Exception;
    
   //���²�ѯ��Ȩ����������ϸ�� 
    public DataPackage doQueryInfoForUpdate(CheckedapplydetailDBParam params) throws Exception; 
    
    // ������ѯ��Ȩ����������ϸ�� 
    public DataPackage doQueryInfoForInsert(CheckedapplydetailDBParam params) throws Exception;
    
	// �ֹ�˾������ѯ��Ȩ����������ϸ��
    public DataPackage doQueryInfoForInsert_COUNTY(CheckedapplydetailDBParam params) throws Exception; 
    
	// �й�˾������������ѯ��Ȩ����������ϸ��
    public DataPackage doQueryInfoForInsert_MIDCITY(CheckedapplydetailDBParam params) throws Exception;
    
	//��Ȩ�����������ѡ���������㣬��������Ϊ׼�������ʱ�򣬲�ѯ��������������
	public DataPackage doQueryWayinfoForapplyway(WayDBParam params) throws Exception;
	
	//��Ȩ�����������ѡ���������㣬��������Ϊ�˳������ʱ�򣬲�ѯ���������������
	public DataPackage doQueryWayinfoForExitway(WayDBParam params) throws Exception;

}
