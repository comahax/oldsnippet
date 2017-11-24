/**
 * auto-generated code
 * Fri Sep 25 15:08:39 CST 2009
 */
package com.gmcc.pboss.control.resource.compack;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.resource.compack.ComcategoryInfo;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.compack.PackResourceInfo;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: Compack </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Compack extends AbstractControl {
    public CompackVO doCreate(CompackVO vo) throws Exception;

    public void doRemoveByVO(CompackVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CompackVO doUpdate(CompackVO vo) throws Exception;

    public CompackVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CompackDBParam params) throws Exception;
    
    public DataPackage doQueryBynameSql(String sqlName,DBQueryParam params)throws Exception;
    
    /**
	 * ��ȡ��Ʒ����ȡ���ܵ���Ʒ��(��������Ĺ����Ի�ȡ��Ʒ�������ֹ�˾)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryCompackResdraw(CompackDBParam param,String countyid,String svccode,String mareacode)throws Exception ;
	/**
	 * ȷʵ��ԴĿ��
	 * @param wayid ��������
	 * @param batchno	��Ʒ����
	 * @throws Exception
	 */
	public DataPackage doConfirmResource(String wayid,String batchno) throws Exception;
	
	public void packResource(List<ComcategoryInfo> comcateList,String wayid,String batchno,PackResourceInfo packInfo,OutputStream os) throws Exception;
	
	public DataPackage doPackToolConfirmResource(Map<String,List<ComressmpVO>> resourceMap,String comcategory) throws Exception;
	
	public void packToolResource(ComcategoryInfo comcategoryInfo,Map<String,List<ComressmpVO>> resourceMap,PackResourceInfo packInfo,OutputStream os) throws Exception;
	
	/**
	 * �׿���������
	 * ������Ʒ�������׿���������Ʒ�������κͰ��ţ��޸�����׿���
	 * ����Ʒ�������ж�Ӧ���׿���¼�����������ֶθĳ��µ���������
	 * @param compackVO ��Ʒ��
	 * @param newWayid	����������
	 */
	public void doUpdateComressmp(CompackVO compackVO, String newWayid);
}
