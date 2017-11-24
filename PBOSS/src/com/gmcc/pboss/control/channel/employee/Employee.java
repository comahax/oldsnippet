/**
 * auto-generated code
 * Wed Jul 08 11:39:56 CST 2009
 */
package com.gmcc.pboss.control.channel.employee;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Employee </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Employee extends AbstractControl {
    public EmployeeVO doCreate(EmployeeVO vo) throws Exception;

    public void doRemoveByVO(EmployeeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmployeeVO doUpdate(EmployeeVO vo) throws Exception;
    
    public EmployeeVO doUpdate(EmployeeVO vo, DBAccessUser user) throws Exception;

    public EmployeeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmployeeDBParam params) throws Exception;
    
    /**
     * ���������ѯ
     * @param wayid	��¼���û���������
     * @param params
     * @return
     * @throws Exception
     */
    public DataPackage doManagerQuery(String wayid,EmployeeDBParam params) throws Exception;
    
    public EmployeeVO doCreateSociety(EmployeeVO vo, DBAccessUser user)	throws Exception;

//    /**
//     * ɾ����������:�޸��ù�״̬Ϊ1����ְ��
//     * @param pkArray
//     * @throws Exception
//     */
//    public void doDeleteManager(String[] pkArray) throws Exception;
    
  //����������
	public void  doManagerImport(String[] item , String loginwayid) throws Exception;
	
	/*
	 * ��Ͻ�����ѯ
	 */
	public DataPackage doQueryEmployee(EmployeeDBParam params,User user) throws Exception ;
	
	public DataPackage doQuerybywayid(String wayid,EmployeeDBParam params) throws Exception;
	
	/**
	 * ������Ա�ù�״̬
	 * @param employeeIDs ��Ա�б���ʶ��
	 * @param empstatus	����Ϊ��״̬
	 * @throws Exception
	 */
	public void doUpdateEmpstatus(String[] employeeIDs,Short empstatus) throws Exception;
	
	
	public String doAutoCreateEmployee(int i) throws Exception;
	
	public void checkOfficeTel(String officetel, DBAccessUser user) throws Exception ;
	public void checkOfficeTel1(String officetel, DBAccessUser user) throws Exception ;
	public void checkOfficeTel2(String officetel, String employeeid,DBAccessUser user) throws Exception ;
	
	public String getEmployeeid(DBAccessUser user) throws Exception;
	
	public DataPackage doZjtyQuery(String wayid,EmployeeDBParam params) throws Exception;
}
