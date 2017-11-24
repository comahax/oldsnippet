/**
 * auto-generated code
 * Wed Jul 08 11:39:56 CST 2009
 */
package com.gmcc.pboss.control.channel.employee;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.sysparam.SysparamDAO;
import com.gmcc.pboss.business.channel.employee.EmployeeDAO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.channel.common.CMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: EmployeeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name=
 *           "com/sunrise/jop/business/channel/employee/control/EmployeeBO"
 *           name="Employee" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EmployeeBO extends AbstractControlBean implements Employee {

	public EmployeeVO doCreate(EmployeeVO vo) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// TODO set the pk */
			if( null == vo.getEmployeeid()){
				Long sequence = (Long) dao.getSequence("CH_PW_EMPLOYEE_SEQ");
				vo.setEmployeeid(user.getCityid() + String.valueOf(sequence));
			}
			// �����������ʱ
			if ("1".equals(vo.getPosittype())) {
				if (!"".equals(vo.getOprcode2()) && vo.getOprcode2() != null) {
					vo.setEmployeeid(vo.getOprcode2());
				} else {
					String seq = "0000000" + dao.getSequence("CH_PW_EMPLOYEEMAG_SEQ");
					int len = seq.length();
					seq = user.getCityid() + "PBOSS" + seq.substring(len-7, len);
					vo.setEmployeeid(seq);
				}
				EmployeeVO oldVO = (EmployeeVO) dao.findByPk(vo.getEmployeeid());
				if (oldVO != null) {
					throw new Exception("���� ����Ա["+ vo.getEmployeeid() + "]�Ѿ�����");
				}
			}
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmployeeVO vo) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeVO doUpdate(EmployeeVO vo) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			return (EmployeeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeVO doFindByPk(Serializable pk) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeeDBParam params) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return dao.query(params);
	}

	/**
	 * ���������ѯ
	 * 
	 * @param wayid
	 *            ��¼���û���������
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doManagerQuery(String wayid, EmployeeDBParam params)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
//		params
//				.setSelectFieldsString("employeeid,oprcode,employeename,sex,telephone,cityid,countyid,svccode,wayid,station,intime,employtype,");
		Map conditionMap = new HashMap();
		conditionMap.put("WAYID", wayid);
		params.setQueryConditions(conditionMap);
		return dao
				.queryByNamedSqlQuery(
						"com.gmcc.pboss.business.channel.employee.managerQuery",
						params);
	}
	
	//���������Ա�����ѯ
	public DataPackage doQuerybywayid(String wayid,EmployeeDBParam params) throws Exception{
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		params.getQueryConditions().put("basewayid", wayid);
		params.set_orderby("employeeid"); 
		params.set_desc("0");
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.employee.querybywayid",params);
	}
	

	/*
	 * �������������Ա
	 * //ȥ�������߼�,�¸��汾�����������ֶ�
	 */
	public EmployeeVO doCreateSociety(EmployeeVO vo, DBAccessUser user)
			throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayVO = way.doFindByPk2(vo.getWayid());
			if (wayVO == null) {
				throw new Exception("[��������/��������]:" + vo.getWayid() + "��ϵͳ�в�����");
			}
			//
			if(vo.getWaytype()==null || "".equals(vo.getWaytype()))
			{
				vo.setWaytype("AG");
			}
			//
			if(vo.getIsopen()==null)
			{
				vo.setIsopen(new Short("0"));
			}
			if (!"AG".equals(wayVO.getWaytype())) {
				throw new Exception("[��������]�����������");
			} else {
				//����������������.
//				if (vo.getSvccode() != null
//						&& !"".equals(vo.getSvccode().trim())) {
//					ServcentDBParam listVO = new ServcentDBParam();
//					listVO.set_se_countyid(vo.getCountyid());
//					listVO.set_se_svccode(vo.getSvccode());
//					Servcent servcent = (Servcent) BOFactory.build(
//							ServcentBO.class, user);
//					if (servcent.doQuery(listVO).getRowCount() == 0) {
//						throw new Exception("[������������]�����ڸ÷ֹ�˾");
//					}
//				}
			}
			vo.setEmployeeid( doAutoCreateEmployee(1000) );// ��Ա��ź�̨�Զ�����
			if (vo.getIsopen() == null) {// ��������־��д 0��δ��ͨ��
				vo.setIsopen(new Short("0"));
			}
			vo.setWaytype("AG");// Ĭ��Ϊ�������
			if (vo.getEmpstatus() == null) { // ����Ĭ���ڸ�
				vo.setEmpstatus(new Short("0"));
			}
			//��������߼�
			EmployeeVO checkVO=checkWaynet(null,vo,user,true);
			return (EmployeeVO) dao.create(checkVO);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/**
	 * ����ֻ������Ƿ��ظ�,
	 * @param vo
	 * @throws Exception
	 */
	public void checkSelectmobile(EmployeeVO vo) throws Exception
	{
		if(vo.getSelectmobile()!=null && vo.getSelectmobile().trim().length()==11){
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_orderby("selectmobile");
			listVO.set_ne_empstatus("0");
			listVO.set_se_selectmobile(vo.getSelectmobile());
			if (dao.query(listVO).getRowCount() > 0) {
				throw new Exception("����ѡ��/д��ר�ú��������ϵͳΨһ");
			}
		}
	}
	/*
	 * ����Ƿ��޸��˵����������ֻ�������޸ķ���. 
	 */
	public EmployeeVO doUpdate(EmployeeVO vo, DBAccessUser user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// �ж��ֻ��������ְ�����Ƿ�Ķ����иĶ���Ѹú�����Ϊ��ְ��������һ���¼�¼
			EmployeeVO dbVO = doFindByPk(vo.getEmployeeid());
			if (dbVO == null) {
				throw new Exception("û�и�PK:" + vo.getEmployeeid() + "��ӦVO�ļ�¼");
			}
		
			//ȥ�������߼�,�¸��汾�����������ֶ�
//			if (vo.getSvccode() != null
//					&& !"".equals(vo.getSvccode().trim())) {
//				ServcentDBParam listVO = new ServcentDBParam();
//				listVO.set_se_countyid(vo.getCountyid());
//				listVO.set_se_svccode(vo.getSvccode());
//				Servcent servcent = (Servcent) BOFactory.build(
//						ServcentBO.class, user);
//				if (servcent.doQuery(listVO).getRowCount() == 0) {
//					throw new Exception("[������������]�����ڸ÷ֹ�˾");
//				}
//			}
			
// 			���ĳ����¼����ְ״̬�ĳ���ְ,�����ǵ������ߵ�Ա,������Ϣ�������ڿ�ͨ״̬.�����Ա/�����Զ��˶�����.
			boolean csFlag = false;
			int csCount = 0;
			if (vo.getEmpstatus() != null && dbVO.getEmpstatus() != null && vo.getIsopen()!=null
					&& vo.getEmpstatus().shortValue() == (short) 1
					&& dbVO.getEmpstatus().shortValue() == (short) 0
					&& vo.getIsopen().shortValue() == (short) 1) {
				if (vo.getIsnet().shortValue() == (short) 0
						|| vo.getIsnet().shortValue() == (short) 1) {
					AGWay control = (AGWayBO) BOFactory.build(AGWayBO.class,
							user);
					csFlag = control.doCancelService(dbVO.getEmployeeid(), user, "update");
					csCount = 1;
				}
			}
			//����ڸ���Ա������ƽ̨�ֻ����뷢���䶯.����һ����¼Ϊ�¼�¼,ԭ����¼��Ϊ��ְ״̬,�º����Զ���ͨ�ֻ�������Ϣ����
			if (vo.getOfficetel() != null
					&& dbVO.getOfficetel() != null
					&& !dbVO.getOfficetel().trim().equals(
							vo.getOfficetel().trim()) && dbVO.getEmpstatus().shortValue()==(short)0) {
				//����Ƿ񱾵��ֻ�����
//				checkTelCity(vo.getOfficetel(), user);
				EmployeeVO newVO = new EmployeeVO();
				BeanUtils.copyProperties(newVO, vo);
				newVO.setEmpstatus(new Short("0"));
				newVO.setIsopen(new Short("0"));// ��������δ��ͨ״̬
				EmployeeVO creatEmployeeVO = this.doSocietyCopy(newVO, user);
				dbVO.setEmpstatus(new Short("1"));

				// ����޸Ĺ��ֻ�������ǵ���/��Ա,��Ҫ�����ֻ����˶�����,���µ����ֻ��ſ�ͨ����,��Ա���Զ���ͨ
				if (vo.getIsnet() != null && (vo.getIsnet().shortValue() == 1 || vo.getIsnet().shortValue()==(short)0)) {
					AGWay control = (AGWayBO) BOFactory.build(AGWayBO.class,user);
					//����������ѿ�ͨ�����˶�
					if(vo.getIsopen()!=null && vo.getIsopen().byteValue()==(byte)1){
						if(csCount == 0){//���ù���������ﲻ�ٵ���
							csFlag = control.doCancelService(dbVO.getEmployeeid(), user, "update");
						}
					}else if(vo.getIsopen()==null)
					{
						throw new Exception("���ܻ�ȡ[��ͨ�����־]ֵ");
					}
					//�����ſ�ͨ����
					if(vo.getIsnet().shortValue()==(short)1)
					{	
						control.doSetservice(vo.getWayid(), user);
					}
				}
				if(csFlag){
					dbVO.setIsopen((short)0);
				}
				dao.update(dbVO);
				return creatEmployeeVO;
			}
			if(csFlag){
				dbVO.setIsopen((short)0);
				vo.setIsopen((short)0);
			}
			// ��������ԴԴ�������޸�״̬ʱ��comsǰ̨����ʱ�쳣 by lyl 2013-09-16
			EmployeeVO updateVO=checkWaynet(dbVO,vo,user,false);
			EmployeeVO newVO = null; 
//			InputStream in = net.gmcc.ngcrm.pboss.GDProdServ.class.getResourceAsStream("/coreconfiginfo.properties");
//			Properties p = new Properties();
//			p.load(in);
//			in.close();
//			String path = (String) p.get("way.update.test"); 
//			
//			if(("ONE").equals(path)){ 
				BeanUtils.copyProperties(dbVO, updateVO);
				newVO = (EmployeeVO)dao.update(dbVO);
//			}else if(("TWO").equals(path)){
//				Session session = SessionUtils.currentSession(user.getCityid());
//				newVO = (EmployeeVO) session.merge(updateVO);
//				//session.flush();
//			}else{
//				Session session = SessionUtils.currentSession(user.getCityid());
//				newVO = (EmployeeVO) session.merge(updateVO);
//				session.flush();
//			}  //  2013-09-16 by lyl
			return newVO;
			// return (EmployeeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/*
	 * �����޸ĺ��뵼�µ��������������Ա�����ƣ�
	 */
	public EmployeeVO doSocietyCopy(EmployeeVO vo, DBAccessUser user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			checkOfficeTel(vo.getOfficetel(), user);
			checkSelectmobile(vo);
			String oldemployeeid=vo.getEmployeeid();
			if(!jdugeIsNetChange(vo.getWayid(),user,oldemployeeid) && vo.getIsnet().shortValue()==(short)1){
				throw new Exception("һ������ֻ����һ������!");
			}
			String newemployeeid=doAutoCreateEmployee(1000);
			vo.setEmployeeid(newemployeeid);// ��Ա��ź�̨�Զ�����
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/**
	 * �޸�ʱҪ�ѵ�Ա�ĳɵ���ʱ���޸���ְ״̬ʱ���á�
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean jdugeIsNetChange(String wayid, DBAccessUser user) throws Exception {
		Employee employeeControl = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		return employeeControl.doQuery(listVO).getRowCount() <= 0;
	}
	/**
	 * �޸�ʱҪ�޸ĵ������ֻ�����ʱ��������Ƿ�Ψһ,���ʱ���ϵ���״̬��δ�ı�
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean jdugeIsNetChange(String wayid, DBAccessUser user,String oldemployeeid) throws Exception {
		Employee employeeControl = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		listVO.set_sne_employeeid(oldemployeeid);
		return employeeControl.doQuery(listVO).getRowCount() <= 0;
	}
	private void checkOpercode(EmployeeVO vo, DBAccessUser user) throws Exception {
		if (vo.getOprcode2() == null || "".equals(vo.getOprcode2().trim())) {
			return;
		} else {
			Operator control = (OperatorBO) BOFactory
					.build(OperatorBO.class,user);
			OperatorVO opVO=control.doFindByPk(vo.getOprcode2());
			if ( opVO== null) {
				throw new Exception("ϵͳ������¼�빤��");
			}else  
			{
				if(opVO.getRegion()!=null){
					String hwRegion=String.valueOf(opVO.getRegion());
					if(!hwRegion.equals(((User)user).getHwcityid()))
					{
						throw new Exception("��ѡ���ŵ��б�־:"+hwRegion+" ��ϵͳ��¼���ŵ��б�־"+((User)user).getHwcityid()+"��һ��!");
					}
				}else
				{
					throw new Exception("��ѡ���ŵ��б�־ȱʧ! ����:"+vo.getOprcode2());
				}
			}
		}
	}

	/*
	 * ������Ա���
	 */
	public String getEmployeeid(DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return user.getCityid() + dao.getSequence("CH_PW_EMPLOYEE_SEQ");
	}

	public EmployeeVO doFindByOprcode(String oprcode, DBAccessUser user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.findByProperty("oprcode2", oprcode);
	}
	
	/**
	 * ����ֻ������Ƿ��ڱ�������Ψһ
	 * 
	 * @param officetel
	 * @param user
	 */
	//ע:�տ�������Ա��֪������߼�.©����.�¸��汾����.
	private void checkTelCity(String officetel, DBAccessUser user)
			throws Exception {
		Nosect control = (Nosect) BOFactory.build(NosectBO.class, user);
		String cityid = control.doQueryCityID(officetel);
		if (!user.getCityid().equals(cityid)) {
			throw new Exception("�ֻ�������������: "+cityid+" ���¼�����������в�һ��");
		}
	}
	/**
	 * ��ѯ��ְ�ֻ������Ƿ�Ψһ
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel(String officetel, DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		EmployeeDBParam listvo = new EmployeeDBParam();
		listvo.set_se_officetel(officetel);
		// 0-��ְ
		listvo.set_ne_empstatus("0");
		DataPackage pack = dao.query(listvo);
		if (pack.getDatas().size() > 0) {
			throw new Exception("ϵͳ�Ѵ��ڸ�[���������]�����������ֻ��ţ�");
		}
	}
	
	/**
	 * ��ѯ��ְ�ֻ������Ƿ�Ψһ(������������Ϣ���)
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel1(String officetel, DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user); 
		SysparamDAO  sysparamDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		
		EmployeeDBParam listvo = new EmployeeDBParam(); 
		listvo.set_se_officetel(officetel); 
		// ϵͳ����76��1:����������������� 0:��������û�в������� ��:��������û�в������� 
		String sysstr = sysparamDAO.doFindByID(76L, "channel"); 
	 
		// 0-��ְ
		listvo.set_ne_empstatus("0"); 
	
		if(("1").equals(sysstr)){ 
			// 4-��������
			listvo.set_nne_isnet("4");
			  
		} 
		  DataPackage  pack = dao.query(listvo);
			if(pack.getDatas().size()>0){
				throw new Exception("ϵͳ�Ѵ��ڸ�[���������]�����������ֻ��ţ�");
			}  
 	}
	
	/**
	 * ��ѯ��ְ�ֻ������Ƿ�Ψһ(�������ֻ���Ϣ���¼��)
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel2(String officetel, String employeeid,DBAccessUser user) throws Exception {
		
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user); 
		SysparamDAO  sysparamDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		
		EmployeeDBParam listvo = new EmployeeDBParam();  
		listvo.set_se_officetel(officetel); 
		listvo.set_sne_employeeid(employeeid);
		
		// ϵͳ����76��1:����������������� 0:��������û�в������� ��:��������û�в������� 
		String sysstr = sysparamDAO.doFindByID(76L, "channel"); 
 	   // 0-��ְ
		listvo.set_ne_empstatus("0"); 
 	 
		if(("1").equals(sysstr)){ 
			
		 listvo.set_nne_isnet("4");	
		 
		} 
		  DataPackage  pack = dao.query(listvo);
			if(pack.getDatas().size()>0){
				throw new Exception("ϵͳ�Ѵ��ڸ�[���������]�����������ֻ��ţ�");
			} 
  
 	}
	
	/**
	 * ��ѯ��ְ�ֻ������Ƿ�Ψһ(����������Ϣ���)
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel3(String officetel, DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user); 
		SysparamDAO  sysparamDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		
		EmployeeDBParam listvo = new EmployeeDBParam(); 
		listvo.set_se_officetel(officetel); 
		// ϵͳ����76��1:����������������� 0:��������û�в������� ��:��������û�в������� 
		String sysstr = sysparamDAO.doFindByID(76L, "channel"); 
	 
		// 0-��ְ
		listvo.set_ne_empstatus("0"); 
	
		if(("1").equals(sysstr)){ 
			// 3-������
			listvo.set_nne_isnet("3");
			  
		} 
		  DataPackage  pack = dao.query(listvo);
			if(pack.getDatas().size()>0){
				throw new Exception("ϵͳ�Ѵ��ڸ�[���������]�����������ֻ��ţ�");
			}  
 	}
	
    
//    /**
//     * ɾ����������:�޸��ù�״̬Ϊ1����ְ��
//     * @param pkArray
//     * @throws Exception
//     */
//    public void doDeleteManager(String[] pkArray) throws Exception{
//    	for(int i=0;i<pkArray.length;i++){
//    		EmployeeVO vo = this.doFindByPk(pkArray[i]);
//    		if(vo != null)
//    			vo.setEmpstatus(new Short("1"));
//    	}
//    }
	
	//����������
	public void  doManagerImport(String[] item ,String loginwayid) throws Exception{
		EmployeeVO vo = this.doFindByOprcode(item[0], user);
		if(vo != null &&   vo.getEmpstatus()==1)
			throw new Exception("����Ϊ:"+item[0] +" �����������Ѿ����� ");
		Operator operator = (Operator) BOFactory.build(OperatorBO.class, user);
		//��֤��Ա�Ƿ��ڲ���Ա����
		if (item[0] != null && !"".equals(item[0])) {
		if( null == operator.doFindByPk(item[0])){
			throw new Exception("���� ����Ա["
					+ item[0] + "] ���ڹ��ű��� ");
		}
		}
		vo = new EmployeeVO();
		vo.setWaytype("ET");
		vo.setEmployeeid(item[0]);
		vo.setOprcode2(item[0]);
		vo.setEmployeename(item[1]);
		vo.setBirthday(StringUtils.isNotEmpty(item[2])?stringToDate(item[2],"yyyy-MM-dd"):null);
		vo.setSex(StringUtils.isNotEmpty(item[3])?new Short(item[3]):null);
		vo.setNativehome(item[4]);
		vo.setPolivisage(StringUtils.isNotEmpty(item[5])?new Short(item[5]):null);
		vo.setHomeaddr(item[6]);
		vo.setCardid(item[7]);
		vo.setTelephone(item[8]);
		vo.setPvtemail(item[9]);
		vo.setOfcphone(item[10]);
		vo.setEdulevel(StringUtils.isNotEmpty(item[11])?new Short(item[11]):null);
		vo.setSpeciality(item[12]);
		vo.setCityid(item[13]);
		vo.setCountyid(item[14]);
		vo.setSvccode(item[15]);
		vo.setMareacode(item[16]);//����΢����
		vo.setWayid(item[17]);
		vo.setCompany(item[18]);
		vo.setStation(StringUtils.isNotEmpty(item[19])?new Long(item[19]):null);
		vo.setPosittype("1");//��λ����Ĭ�Ͼ���
		vo.setIsnet(new Short("4"));//Ĭ�Ͼ���
		vo.setJoblevel(StringUtils.isNotEmpty(item[21])?new Short(item[21]):null);
		vo.setDepartment(item[22]);
		vo.setGradtime(StringUtils.isNotEmpty(item[23])?stringToDate(item[23],"yyyy-MM-dd"):null);
		vo.setGradschool(item[24]);
		vo.setIntime(StringUtils.isNotEmpty(item[25])?stringToDate(item[25],"yyyy-MM-dd"):null);
		vo.setContacttype(StringUtils.isNotEmpty(item[26])?new Short(item[26]):null);
		vo.setEmploytype(StringUtils.isNotEmpty(item[27])?new Short(item[27]):null);
		vo.setEmpstatus(StringUtils.isNotEmpty(item[28])?new Short(item[28]):null);
		vo.setWorktime(StringUtils.isNotEmpty(item[29])?new Short(item[29]):null);
		vo.setHereworktime(StringUtils.isNotEmpty(item[30])?new Short(item[30]):null);
		vo.setIsmarried(StringUtils.isNotEmpty(item[31])?new Short(item[31]):null);
		//vo.setSelectmobile(item[31]);
		if(!checkWayid(item[17],loginwayid)){
			throw new Exception("������(��������)���ǵ�¼�������ߵ�¼�����¼�����");
		}
		// ��֤�����ֻ�������Ч��
		this.checkOfficeTel3(item[32], user);
		this.checkTelCity(item[32], user);
		vo.setOfficetel(item[32]);
		EmployeeBO bo = (EmployeeBO)BOFactory.build(EmployeeBO.class,user);
		bo.doCreate(vo);
	}
	
	/*
	 * ��Ͻ�����ѯ
	 */
	public DataPackage doQueryEmployee(EmployeeDBParam params,User user) throws Exception {
		List collection = new ArrayList();
		DataPackage dp = new DataPackage();
		Way wayBO = (WayBO) BOFactory.build(WayBO.class,user);
		WayDBParam wayParam = new WayDBParam();
		wayParam.set_se_waymagcode(params.get_se_employeeid());
		
		DataPackage dataPackage = wayBO.doQueryEmployee(wayParam, user);
		List list = (List) dataPackage.getDatas();
		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			AGWayVO agway = new AGWayVO();
			BeanUtils.copyProperties(agway, wayVO);
			params.set_se_wayid(wayVO.getWayid());
			params.set_ne_isnet("1");
			params.set_ne_empstatus("0");
			Iterator employee = this.doQuery(params).getDatas().iterator();
			if (employee.hasNext()) {
				EmployeeVO employeevo = (EmployeeVO) employee.next();
				agway.setIsopen(employeevo.getIsopen());
				agway.setOfficetel(employeevo.getOfficetel());
			}
			collection.add(agway);
		}
		dp.setDatas(collection);
		dp.setRowCount(dataPackage.getRowCount());
		dp.setPageNo(dataPackage.getPageNo());
		dp.setPageSize(dataPackage.getPageSize());
		return dp;
	}
	
	/**
	 * ������Ա�ù�״̬
	 * @param employeeIDs ��Ա�б���ʶ��
	 * @param empstatus	����Ϊ��״̬
	 * @throws Exception
	 */
	public void doUpdateEmpstatus(String[] employeeIDs,Short empstatus) throws Exception{
		for(String employeeid:employeeIDs){
			EmployeeVO employeevo = this.doFindByPk(employeeid);
			employeevo.setEmpstatus(empstatus);
			Employee bo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class,user);
			bo.doUpdate(employeevo);
		}
	}
	public Date stringToDate(String dateStr,String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(dateStr);
	}
	
	// �Զ������������Ա����
	public void doCustomPeopleImport(String[] item) throws Exception {
		Employee employee = (Employee) BOFactory.build(EmployeeBO.class, user);
		EmployeeVO employeeVO = new EmployeeVO();
		EmployeeVO dbVO = this.doFindByPk(item[0]);
		if( null == dbVO) {
			throw new Exception ("ϵͳ�����ڸ���Աid������˶�");
		}
		BeanUtils.copyProperties(employeeVO, dbVO);
		employeeVO.setEmployeeid(item[0]);
		if (item[1] != null && "".equals(item[1])) {
			employeeVO.setOfficetel(null);
		} else if (item[1] != null && !"".equals(item[1])) { 
			checkTelCity( item[1], user);
			employeeVO.setOfficetel(item[1]);
		}
		if (item[2] != null && "".equals(item[2])) {
			employeeVO.setEmployeename(null);
		} else if (item[2] != null && !"".equals(item[2])) {
			employeeVO.setEmployeename(item[2]);
		}
		if (item[3] != null && "".equals(item[3])) {
			employeeVO.setBirthday(null);
		} else if (item[3] != null && !"".equals(item[3])) {
			employeeVO.setBirthday(stringToDate(item[3], "yyyy-MM-dd"));
		}
		if (item[4] != null && "".equals(item[4])) {
			employeeVO.setSex(null);
		} else if (item[4] != null && !"".equals(item[4])) {
			employeeVO.setSex(new Short(item[4]));
		}
		if (item[5] != null && "".equals(item[5])) {
			employeeVO.setCardid(null);
		} else if (item[5] != null && !"".equals(item[5])) {
			employeeVO.setCardid(item[5]);
		}
		if (item[6] != null && "".equals(item[6])) {
			employeeVO.setCityid(null);
		} else if (item[6] != null && !"".equals(item[6])) {
			employeeVO.setCityid(item[6]);
		}
		if (item[7] != null && "".equals(item[7])) {
			employeeVO.setCountyid(null);
		} else if (item[7] != null && !"".equals(item[7])) {
			employeeVO.setCountyid(item[7]);
		}
		if (item[8] != null && "".equals(item[8])) {
			employeeVO.setWayid(null);
		} else if (item[8] != null && !"".equals(item[8])) {
			employeeVO.setWayid(item[8]);
		}
		if (item[9] != null && "".equals(item[9])) {
			employeeVO.setIntime(null);
		} else if (item[9] != null && !"".equals(item[9])) {
			employeeVO.setIntime(stringToDate(item[9], "yyyy-MM-dd"));
		}
		if (item[10] != null && "".equals(item[10])) {
			employeeVO.setContacttype(null);
		} else if (item[10] != null && !"".equals(item[10])) {
			employeeVO.setContacttype(new Short(item[10]));
		}
		if (item[11] != null && "".equals(item[11])) {
			employeeVO.setEmploytype(null);
		} else if (item[11] != null && !"".equals(item[11])) {
			employeeVO.setEmploytype(new Short(item[11]));
		}
		if (item[12] != null && "".equals(item[12])) {
			employeeVO.setEmpstatus(null);
		} else if (item[12] != null && !"".equals(item[12])) {
			employeeVO.setEmpstatus(new Short(item[12]));
		}
		if (item[13] != null && "".equals(item[13])) {
			employeeVO.setIsnet(new Short("0"));
		} else if (item[13] != null && !"".equals(item[13])) {
			employeeVO.setIsnet(new Short(item[13]));
		}
		if (item[14] != null && "".equals(item[14])) {
			employeeVO.setTelephone(null);
		} else if (item[14] != null && !"".equals(item[14])) {
			employeeVO.setTelephone(item[14]);
		}
		if (item[15] != null && "".equals(item[15])) {
			employeeVO.setSvccode(null);
		} else if (item[15] != null && !"".equals(item[15])) {
			employeeVO.setSvccode(item[15]);
		}
		if (item[16] != null && "".equals(item[16])) {
			employeeVO.setBail(null);
		} else if (item[16] != null && !"".equals(item[16])) {
			employeeVO.setBail(new Double(item[16]));
		}
		if (item[17] != null && "".equals(item[17])) {
			employeeVO.setSelectmobile(null);
		} else if (item[17] != null && !"".equals(item[17])) {
			employeeVO.setSelectmobile(item[17]);
		}
		// ���̶�����
		User tuser = (User) user;
		if(employeeVO.getContacttype() != null && !CheckUtil.getInstance().
				checkDictitem("CH_CONTACTTYPE", (""+employeeVO.getContacttype()), tuser)) {
			throw new JOPException("[�Ͷ���ϵ]:"+employeeVO.getContacttype()+" �̶���������ȷ");
		}
		if(employeeVO.getEmploytype() != null && !CheckUtil.getInstance().
				checkDictitem("CH_EMPLOYTYPE", (""+employeeVO.getEmploytype()), tuser)) {
			throw new JOPException("[�ù�����]:"+employeeVO.getEmploytype()+" �̶���������ȷ");
		}
		if(employeeVO.getEmpstatus() != null && !CheckUtil.getInstance().
				checkDictitem("CH_EMPSTATUS", (""+employeeVO.getEmpstatus()), tuser)) {
			throw new JOPException("[�ù�״̬]:"+employeeVO.getEmpstatus()+" �̶���������ȷ");
		}
		// ����߼�
		employeeVO=checkWaynet(dbVO, employeeVO, user, false);
		employee.doUpdate(employeeVO, user);
	}

	//���������Ա����
	public void  doSocietypeopleImport(String[] item) throws Exception{
//		����ʱ�ж�����ĵ�һ���Ƿ�Ϊ�գ����Ϊ�գ��������������߼����룬�����Ϊ�գ�������Աid��ѯ��Ա��
//		�жϼ�¼�Ƿ���ڣ���������ڣ���ʾ��ϵͳ�����ڸ���Աid������˶ԡ�
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		String param92 = sysparamBO.doFindByID("92", "channel");
		Way way = (Way) BOFactory.build(WayBO.class, user); 
		
		boolean isCreate=false;
		EmployeeVO employeeVO = new EmployeeVO();
		EmployeeVO dbVO=null;
		Employee emp = (Employee) BOFactory.build(EmployeeBO.class, user);
		if(item[0].trim().length()==0){//����	
			employeeVO.setIsnet(new Short("0"));//����ʱĬ���ǵ�Ա�����Ƿ�Ϊ��������ֵΪ0����Ա����
			if(item[1] != null && !"".equals(item[1])){
				checkTelCity( item[1], user);
				employeeVO.setOfficetel(item[1]);
			} 
			employeeVO.setEmployeename(item[2]);
			employeeVO.setBirthday(item[3].trim().length() == 0? null:stringToDate(item[3],"yyyy-MM-dd"));
			employeeVO.setSex(new Short(item[4]));
			employeeVO.setCardid(item[5].trim().length() == 0?null:item[5]);
//			vo.setTelephone(item[6].trim().length() == 0?null:item[6]);
			employeeVO.setPvtemail(item[6].trim().length() == 0 ? null:item[6]);
			employeeVO.setEdulevel(item[7].trim().length() == 0?null:new Short(item[7]));
			employeeVO.setCityid(item[8]);
			employeeVO.setCountyid(item[9]);
			employeeVO.setSvccode(item[10].trim().length() == 0?null:item[10]);
		    if (null != item[11] && !("").equals(item[11])){
			   WayVO wayVO = way.doFindByPk2(item[11]);
			   if(null==wayVO){
			       throw new Exception("����������" +item[11] + "������");
			    }else{
			    	employeeVO.setWayid(item[11]);	
			    }
			 } 
			employeeVO.setIntime(stringToDate(item[12],"yyyy-MM-dd"));
			employeeVO.setContacttype(new Short(item[13]));
			employeeVO.setEmploytype(new Short(item[14]));
			employeeVO.setBail(item[15].trim().length() ==0?null:new Double(item[15]));
			employeeVO.setEmpstatus(new Short(item[16])); 
			employeeVO.setSelectmobile(item[17].trim().length()==0?null:item[17]);
			employeeVO.setOprcode2(item[18].trim().length() == 0?null:item[18]);
			employeeVO.setWaytype("AG");//��ֵΪAG
			employeeVO.setIsopen(new Short("0"));
			isCreate=true;
			
			if (param92 != null && param92.equals("1") 
					&& item[19] != null && item[19].trim().equals("1")) {
				employeeVO.setIsnet(new Short("1"));
			}
		}else{//�޸�
			dbVO= this.doFindByPk(item[0]);
			if( null == dbVO)
				throw new Exception ("ϵͳ�����ڸ���Աid������˶�");
			BeanUtils.copyProperties(employeeVO,dbVO);
			employeeVO.setEmployeeid(item[0]); 
			if(item[1] != null && !"".equals(item[1])){
			 checkTelCity( item[1], user);
			 employeeVO.setOfficetel(item[1]);
			}
			employeeVO.setEmployeename(item[2]);
			employeeVO.setBirthday(item[3].trim().length() == 0? null:stringToDate(item[3],"yyyy-MM-dd"));
			employeeVO.setSex(new Short(item[4]));
			employeeVO.setCardid(item[5].trim().length() == 0?null:item[5]);
//			employeeVO.setTelephone(item[6].trim().length() == 0?null:item[6]);
			employeeVO.setPvtemail(item[6].trim().length() == 0 ? null:item[6]);
			employeeVO.setEdulevel(item[7].trim().length() == 0?null:new Short(item[7]));
			employeeVO.setCityid(item[8]);
			employeeVO.setCountyid(item[9]);
			employeeVO.setSvccode(item[10].trim().length() == 0?null:item[10]);
		    if (null != item[11] && !("").equals(item[11])){
		    	WayVO wayVO = way.doFindByPk2(item[11]);
		    	if(null==wayVO){
		    	throw new Exception("����������" +item[11] + "������");
		    	}else{
			    	employeeVO.setWayid(item[11]);	
			    }
		    }
			employeeVO.setIntime(stringToDate(item[12],"yyyy-MM-dd"));
			employeeVO.setContacttype(new Short(item[13]));
			employeeVO.setEmploytype(new Short(item[14]));
			employeeVO.setBail(item[15].trim().length() ==0?null:new Double(item[15].trim()));
			employeeVO.setEmpstatus(new Short(item[16]));
			if ("1"==item[16] || ("1").equals(item[16])){
			    employeeVO.setOuttime(new Date());
				}
			employeeVO.setSelectmobile(item[17].trim().length()==0?null:item[17]);
			employeeVO.setOprcode2(item[18].trim().length() == 0?null:item[18]);
			
			if (param92 != null && param92.equals("1") 
					&& item[19] != null && item[19].trim().equals("1")) {
				employeeVO.setIsnet(new Short("1"));
			}
		}
			//���̶�����
			User tuser=(User)user;
			if(!CheckUtil.getInstance().checkDictitem("CH_SEX",(""+employeeVO.getSex()), tuser))
			{
				throw new JOPException("[�Ա�]:"+employeeVO.getSex()+"\t�̶���������ȷ");
			}
			if(employeeVO.getContacttype()!=null && !CheckUtil.getInstance().checkDictitem("CH_CONTACTTYPE", (""+employeeVO.getContacttype()), tuser))
			{
				throw new JOPException("[�Ͷ���ϵ]:"+employeeVO.getContacttype()+"�̶���������ȷ");
			}
			if(employeeVO.getEmploytype()!=null && !CheckUtil.getInstance().checkDictitem("CH_EMPLOYTYPE", (""+employeeVO.getEmploytype()), tuser))
			{
				throw new JOPException("[�ù�����]:"+employeeVO.getEmploytype()+"�̶���������ȷ");
			}
			if(employeeVO.getEmpstatus()!=null && !CheckUtil.getInstance().checkDictitem("CH_EMPSTATUS", (""+employeeVO.getEmpstatus()), tuser))
			{
				throw new JOPException("[�ù�״̬]:"+employeeVO.getEmpstatus()+"�̶���������ȷ");
			}
			//����߼�
			employeeVO=checkWaynet(dbVO, employeeVO, user, isCreate);
			if(isCreate)
			{   
				 WayVO wayVO = null;
				//����������ʱ���ſ����й�˾�ͷֹ�˾�ļ��
				if(null != employeeVO.getWayid() || !("").equals(employeeVO.getWayid())){ 
				   wayVO = way.doFindByPk2(employeeVO.getWayid());
				}else{
					throw new Exception("����������" +item[11] + "������");
				}
				if (employeeVO.getCityid() != null
						&& wayVO.getCityid() != null
						&& !employeeVO.getCityid().trim().equals(
								wayVO.getCityid().trim())) {
					throw new Exception("[���й�˾]" + employeeVO.getCityid()
							+ "����ѡ�����ĵ��й�˾" + wayVO.getCityid() + "��һ��");
				}
				if (employeeVO.getCountyid() != null
						&& !employeeVO.getCountyid().trim().equals(wayVO.getCountyid())) {
					throw new Exception("[�ֹ�˾]:" + employeeVO.getCountyid()
							+ "����ѡ�����ķֹ�˾" + wayVO.getCountyid() + "��һ��");
				}
				emp.doCreateSociety(employeeVO, user);		
			}
			else{
				emp.doUpdate(employeeVO, user);
			}
		
	}
	
	/**
	 * �Զ�������ԱID
	 * @return ��ʽ:���б�ʶ+Sequence  һ�������������100000�η��䶼�Ҳ�������������ID���׳��쳣
	 * @param i ��ྭ�����ٴη���,i<0����������,���򳬹����������δ�ҵ������ID���׳��쳣
	 * @throws Exception 
	 */
	public String doAutoCreateEmployee(int i) throws Exception {
		// TODO Auto-generated method stub
/*		Ϊ�������ɵ���Ա������֮ǰ���еı��뷢����ͻ���ȼ�����ɵ���Ա�����Ƿ���ϵͳ�Ѿ����ڣ�
		���������˵�����ظ��ɹ�������Ѿ����ڣ�ȡ���б�־+���кŵ���һֵ�������ж��Ƿ��ڿ���Ѿ����ڣ�
		ֱ�����ɵ���Ա���벻�����ݿ����б����ظ�Ϊֹ��
		���磺��ǰ���к���10000007��ȡ��һ��ֵ��10000008�����ݿ��Ѵ�����Ա����FS10000007��FS10000008��FS10000009��
		����FS10000008�ڿ���Ѿ����ڣ������ж�FS10000009Ҳ�ڿ����ڣ�
		�����ж�FS10000010�����ڣ��������ɵ���Ա������FS10000010.
*/		
		String newemployeeid=null;
		if(null == user.getCityid())
		{	
			throw new Exception(" ���б�ʶΪ�� ");
		}
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		newemployeeid=getEmployeeid(user);
		//���Ҵ���,�Ѿ�������һ��
		int n=1;
		EmployeeVO oldVO = (EmployeeVO) dao.findByPk(newemployeeid);
		while (oldVO != null) {
			if(n>i && i>0)
			{
				throw new Exception(" �� "+n+" �η��� δ�ҵ�������Ա�ı�ʶ ");
			}
			newemployeeid = getEmployeeid(user);
			oldVO = (EmployeeVO) dao.findByPk(newemployeeid);
			n++;
		}
		return newemployeeid;
	}
	
	/**
	 * ��������,�޸ļ�⹫���߼�����,ע�����޸������е�ֵ�Ժ����(������ʱ��oldVO���ս���
	 * @param oldvo
	 * @param updateVO
	 * @param user
	 * @throws Exception
	 */
	public EmployeeVO checkWaynet(EmployeeVO dbVO,EmployeeVO updateVO,DBAccessUser user,boolean isCreate) throws Exception
	{
		//����ǵ���,�����޸ĺ��ֵ���ڸ�״̬
		if (updateVO.getIsnet()!=null && updateVO.getIsnet() == 1 && updateVO.getEmpstatus() == 0) {
			if (isCreate) {

				if (!jdugeIsNetChange(updateVO.getWayid(), user)) {
					throw new Exception("һ������ֻ����һ������");
				}
				// ֻ�е�������������ȷ����
				updateVO.setNetpass(CMSUtils.genRandomNumer(6));// ����ȷ������λ�����
			} else {
				if (!jdugeIsNetChange(updateVO.getWayid(), user,updateVO.getEmployeeid())) {
					throw new Exception("һ������ֻ����һ������");
				}
			}

		}
		if(updateVO.getEmpstatus()!=null && updateVO.getEmpstatus().shortValue()==(short)0)
		{
		// �жϲɼ�ƽ̨�����ֻ�����,ǰ����ǰ̨������11λ����
		// �жϿ���ѡ���ֻ�����
		if (updateVO.getOfficetel() != null
				&& updateVO.getOfficetel().trim().length() == 11) {
			if (isCreate) {
				checkOfficeTel(updateVO.getOfficetel(), user);
				checkSelectmobile(updateVO);
			}
			//�ֻ����뷢���䶯��Ҫͬʱ���
			else if (dbVO.getOfficetel() != null
					&& !updateVO.getOfficetel().equals(dbVO.getOfficetel())) {
				checkOfficeTel(updateVO.getOfficetel(), user);
				checkSelectmobile(updateVO);
			}
			//��ְ״̬�ĳ��ڸ�״̬��Ҫ���
			else if(dbVO.getEmpstatus()!=null && dbVO.getEmpstatus().shortValue()==(short)1){
				checkOfficeTel(updateVO.getOfficetel(), user);
				checkSelectmobile(updateVO);
			}
		}
			
		}
		//�ж��Ƿ�ͬ����.
		checkTelCity(updateVO.getOfficetel(), user);
		//
		if (updateVO.getOprcode2() != null && !updateVO.getOprcode2().trim().equals("")) {
			// �жϹ����Ƿ��ڹ��ű����
			checkOpercode(updateVO,user);
			// �жϹ����Ƿ��Ѿ�����
			if (isCreate
					|| (!isCreate && dbVO.getOprcode2() != null
							&& updateVO.getOprcode2() != null && !updateVO
							.getOprcode2().equals(dbVO.getOprcode2()))) {
				if (doFindByOprcode(updateVO.getOprcode2(), user) != null)
					throw new Exception("Ա��������Ϣ���Ѿ����ڸù���");
			} 
		}
	return updateVO;
	}
	
	//������������Ƿ��ǵ�ǰ��¼���������������߼�����������
	private boolean checkWayid(String wayid,String loginwayid) throws Exception{
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		EmployeeDBParam params = new EmployeeDBParam();
		params.getQueryConditions().put("loginwayid", loginwayid);
		params.getQueryConditions().put("wayid",wayid);
		Integer result = (Integer)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.channel.employee.checkwayid", params);
		return result>0;
	}

	public DataPackage doZjtyQuery(String wayid, EmployeeDBParam params)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		params.getQueryConditions().put("basewayid", wayid);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.employee.zjtyquerybywayid",params);
	}
}
