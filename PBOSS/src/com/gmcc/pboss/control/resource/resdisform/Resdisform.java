/**
 * auto-generated code
 * Fri Oct 02 10:38:11 CST 2009
 */
package com.gmcc.pboss.control.resource.resdisform;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDBParam;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVOHelper;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resdisform </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Resdisform extends AbstractControl {
    public ResdisformVO doCreate(ResdisformVO vo) throws Exception;

    public void doRemoveByVO(ResdisformVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResdisformVO doUpdate(ResdisformVO vo) throws Exception;

    public ResdisformVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResdisformDBParam params) throws Exception;
    

    /**�鿴��Ʒ��ϸ
     * @param discomcode �����̱��
     * @param disi	���䵥��
     */
    public DataPackage doQueryProductDetail(String discomcode,String disi,ResdisformDBParam params) throws Exception;
    
    public String batchUpdate(String[] pk,ResdisformVOHelper voHelper,List<String> employeeID) throws Exception ;
    
    /**
     * ��������
     * @param item item[0]:�����̱��� item[1]:���� item[2]:����
     * @param ways �����б�
     * @param disid ���䵥��
     * @param storarea ��Դ����
     */
    public Map<String,String> doUpdate(String[] item,List<WayVO> ways,String disid,String storarea) throws Exception;
    
  //ȡ�ò�ѯ������CH_PW_WAY������ȡ�������ϣ��������������ѯ������Ա������Ϣ��(CH_PW_EMPLOYEE)
    // ƥ���Ƿ�Ϊ�����ֶ�Ϊ�ǣ���ISNET=1����ƥ���ù�״̬Ϊ�ڸڣ���EMPSTATUS=0������ȡ���������������������ֻ����루����������룩
    public DataPackage doQueryEmployee(ResdisformDBParam params) throws Exception;
}
