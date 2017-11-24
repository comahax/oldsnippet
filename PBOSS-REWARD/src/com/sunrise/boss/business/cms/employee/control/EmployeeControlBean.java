/**
 * auto-generated code Sun Aug 27 13:31:54 CST 2006
 */
package com.sunrise.boss.business.cms.employee.control;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.sunrise.boss.business.admin.operator.control.OperatorControl;
import com.sunrise.boss.business.admin.operator.control.OperatorControlBean;
import com.sunrise.boss.business.cms.audit.common.CityIDMap;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamDAO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamVO;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmDAO;
import com.sunrise.boss.business.cms.emodconfirm.persistent.EmodconfirmVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmDAO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmListVO;
import com.sunrise.boss.business.cms.empconfirm.persistent.EmpconfirmVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeDAO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.employee.persistent.VEmployeeDAO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelDAO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelVO;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentListVO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqDAO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqVO;
import com.sunrise.boss.business.cms.way.control.AGWayControl;
import com.sunrise.boss.business.cms.way.control.AGWayControlBean;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactDAO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamDAO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleDAO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.ExcelCodeToName;
import com.sunrise.boss.delegate.cms.servcent.ServcentDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.resmanage.nores.nosect.NosectDelegate;
import com.sunrise.boss.ui.cms.commons.CMSUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: EmployeeControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/employee/control/EmployeeControlBean"
 *           name="EmployeeControl" view-type="local" type="Stateless"
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EmployeeControlBean extends AbstractControlBean implements
		EmployeeControl {
	public static final String []smsModelAdd={"�𾴵��û�����������ע��Ϊ","�ƹ�רԱ,�յ���������24Сʱ�ڻظ�Y��ע��ɹ����ظ�N��ȡ��ע�ᣬ24Сʱ�ڲ��ظ�Ĭ��ע��ɹ�"};
	public static final String []smsModelUpdate={"�𾴵��û�������ƹ�רԱ��Ϣ����ѱ��޸�Ϊ",",�յ���������24Сʱ�ڻظ�Y��ȷ���޸ģ��ظ�N��ȡ���޸ģ�24Сʱ�ڲ��ظ�Ĭ��ȷ���޸�"};
	public static final String smsModelRemove="�𾴵��û������������˳��ƹ�רԱ���յ���������24Сʱ�ڻظ�Y��ȷ���˳����ظ�N��ȡ���˳���24Сʱ�ڲ��ظ�Ĭ��ȷ���˳�";
	private final long  aday=1000*60*60*24;
	public EmployeeVO doCreate(EmployeeVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);

			// �������ΪNULL���߿ո�������Ӷ��������Ҫ����Ƿ����ظ�����
			if (vo.getOprcode2() != null && !vo.getOprcode2().trim().equals("")) {

				// �жϹ����Ƿ��Ѿ�����
				if (doFindByOprcode(vo.getOprcode2(), user) != null)
					throw new BusinessException("", "Ա��������Ϣ���Ѿ����ڸù���");
			}
			
			if(vo.getSelectmobile()!=null)
			{
				checkTelCity(vo.getSelectmobile(), user);
			}
			if(vo.getOfficetel()!=null){
				checkTelCity(vo.getOfficetel(), user);
			}
			if(vo.getTelephone()!=null){
				checkTelCity(vo.getTelephone(), user);
			}

			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(EmployeeVO vo, User user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/*
	 * ԭ�����޸ĺ���,���ⲿ���޸ĵ���,���漰�����߼�
	 */
	public EmployeeVO doUpdate2(EmployeeVO vo, User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.update(vo);
	}

	/*
	 * ����Ƿ��޸��˵����������ֻ�������޸ķ���. (non-Javadoc) �����͵�Ա��ְʱ�Զ�����ȡ������,����Ѿ������˷���.
	 * 
	 * @see com.sunrise.boss.business.cms.employee.control.EmployeeControl#doUpdate(com.sunrise.boss.business.cms.employee.persistent.EmployeeVO,
	 *      com.sunrise.boss.ui.commons.User)
	 */
	public EmployeeVO doUpdate(EmployeeVO vo, User user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// �ж��ֻ��������ְ�����Ƿ�Ķ�������ֻ������иĶ����ԭ�ֻ�������Ϊ��ְ��������һ���¼�¼
			EmployeeVO telVO = doFindByPk(vo.getEmployeeid(), user);
			if (telVO == null) {
				throw new Exception("û�и�PK:" + vo.getEmployeeid() + "��ӦVO�ļ�¼");
			}
			// ���ĳ����¼����ְ״̬�ĳ����ڸ�,Ҫ���¼�����Ψһ��,��ѡ�ֻ�����Ψһ��,�ɼ�ƽ̨�����ֻ�����Ψһ��
			if ((vo.getSelectmobile() != null && telVO.getEmpstatus() != null
					&& telVO.getEmpstatus().shortValue() == 1 && vo
					.getEmpstatus().shortValue() == 0)
					|| (vo.getSelectmobile() != null
							&& vo.getEmpstatus().shortValue() == 0 && !vo
							.getSelectmobile().equals(telVO.getSelectmobile()))) {
				//  
				if (!jdugeIsNetChange(vo.getWayid(), user)) {
					throw new BusinessException("", "һ������ֻ����һ������!");
				}
				//
				checkSelectmobile(vo.getOfficetel(), user);
				//
				checkOfficeTel(vo.getOfficetel(), user);

			}
			// �������ѡ���ֻ�����䶯
			if (vo.getSelectmobile() != null && telVO.getSelectmobile() != null
					&& !vo.getSelectmobile().equals(telVO.getSelectmobile())) {
				checkSelectmobile(vo.getOfficetel(), user);
			}
			// �ɼ�ƽ̨�����ֻ����뷢���䶯,���¼��
			if (vo.getOfficetel() != null
					&& telVO.getOfficetel() != null
					&& !telVO.getOfficetel().trim().equals(
							vo.getOfficetel().trim())) {
				// ����Ƿ񱾵��ֻ�����
				checkOfficeTel(vo.getOfficetel(), user);
				EmployeeVO newVO = new EmployeeVO();
				BeanUtils.copyProperties(newVO, vo);
				newVO.setEmpstatus(new Short("0"));
				newVO.setIsopen(new Short("0"));// ��������δ��ͨ״̬
				EmployeeVO creatEmployeeVO = this.doSocietyCopy(newVO, user);
				// EMPSTAUTS=1Ϊ��ְ״̬,�м�!
				telVO.setEmpstatus(new Short("1"));

				// ����޸Ĺ��ֻ�������ǵ���,��Ҫ�����ֻ����˶�����,�����ֻ��ſ�ͨ����(��ԱҲ��Ҫ�˶�����!������ͨ)
				if (vo.getIsnet() != null
						&& (vo.getIsnet().shortValue() == (short) 1 || vo
								.getIsnet().shortValue() == (short) 0)) {
					AGWayControl control = (AGWayControl) ControlFactory
							.build(AGWayControlBean.class);
					control.doCancelService(telVO.getEmployeeid(), user);
					// ����ǵ���,�����ֻ����뿪ͨ����.
					if (vo.getIsnet().shortValue() == (short) 1) {
						control.doSetservice(vo.getWayid(), user);
					}
				}
				dao.update(telVO);
				return creatEmployeeVO;
			}
			// �ѵ�Ա�ĳɵ���Ҫ������Ψһ��
			if (vo.getIsnet() != null && telVO.getIsnet() != null
					&& telVO.getIsnet().shortValue() == (short) 0
					&& vo.getIsnet().shortValue() == (short) 1) {
				if (vo.getEmpstatus().shortValue() == (short) 0) {
					// �õ���Ϊ�ڸ�״̬�ż�����������Ŀ
					if (!jdugeIsNetChange(vo.getWayid(), user)) {
						throw new BusinessException("", "һ������ֻ����һ������!");
					}
				}
			}

			// �жϹ����Ƿ����޸ģ����޸��������Ƿ��ظ������޸�Ҳֱ�Ӹ���
			EmployeeVO existVO = doFindByPk(vo.getEmployeeid(), user);
			if (existVO.getOprcode2() == null
					|| existVO.getOprcode2().trim().equals("")) {

				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					// �жϹ����Ƿ��Ѿ�����
					if (doFindByOprcode(vo.getOprcode2(), user) != null)
						throw new BusinessException("", "Ա��������Ϣ���Ѿ����ڸù���");
				}

			} else {
				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					if (!existVO.getOprcode2().equals(vo.getOprcode2())) {

						if (doFindByOprcode(vo.getOprcode2(), user) != null)
							throw new BusinessException("", "Ա��������Ϣ���Ѿ����ڸù���");
					}
				}
			}
			// ��鹤���Ƿ����
			checkOpercode(telVO, user);
			if(vo.getSelectmobile()!=null)
			{
				checkTelCity(vo.getSelectmobile(), user);
			}
			if(vo.getOfficetel()!=null){
				checkTelCity(vo.getOfficetel(), user);
			}
			if(vo.getTelephone()!=null){
				checkTelCity(vo.getTelephone(), user);
			}
			// ��Ա���ߵ������ڸڸĳ���ְ,����ж���������Ϣ����,���Զ��˶�����
			if (vo.getEmpstatus() != null && telVO.getEmpstatus() != null
					&& telVO.getEmpstatus().shortValue() == (short) 0
					&& vo.getEmpstatus().shortValue() == (short) 1) {
				// ֻ�е�����Ա����������˶�
				if (vo.getIsnet().shortValue() == (short) 1
						|| vo.getIsnet().shortValue() == (short) 0) {
					AGWayControl control = (AGWayControl) ControlFactory
							.build(AGWayControlBean.class);
					// �˶��м��û���˶���¼ʱ�Ž����˶�.
					if (!control.doHasRecords(vo.getEmployeeid(), user)) {
						control.doCancelService(telVO.getEmployeeid(), user);
					}
				}
			}

			AuditUtils auditutils = new AuditUtils();
			if (vo.getRight() != null && vo.getRight().intValue() != 0) {
				if (!auditutils.doCheckSystemParam("CH_STEMPRIGHT", vo
						.getRight().toString(), user)) {
					throw new BusinessException("", "��Ȩ�޼���("
							+ vo.getRight().toString() + ")����Ч����");
				}
			}
			BeanUtils.copyProperties(existVO, vo);
			return (EmployeeVO) dao.update(existVO);
			// return (EmployeeVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EmployeeVO doFindByPk(Serializable pk, User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.findByPk(pk);
	}

	// ���������Ա��Ϣ��ѯ
	public DataPackage doSocietyEmployeeQuery(EmployeeListVO params, User user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return dao.societyEmployeeQuery(params);
	}

	public DataPackage doQuery(EmployeeListVO params, User user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return dao.query(params);
	}

	public EmployeeVO doFindByOprcode(String oprcode, User user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.findByProperty("oprcode2", oprcode);
	}

	/**
	 * ���ݸ�λ��Ϣ��ѯ
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage getByPostinfo(Long postid, User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		EmployeeListVO listVO = new EmployeeListVO();
		listVO.set_ne_station(postid.toString());
		return dao.query(listVO);
	}

	// �����Ѵ��ڵ�Ⱥ���Ա��ѯ����ӵĳ�Ա
	public DataPackage getSelectEmployee(List groupoprList,
			EmployeeListVO params, User user) throws Exception {
		DataPackage result = null;
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);

		String orStr = "";
		if (groupoprList != null && groupoprList.size() != 0) {
			Iterator iter = groupoprList.iterator();
			while (iter.hasNext()) {
				GroupoprVO groupoprVO = (GroupoprVO) iter.next();
				orStr = orStr + groupoprVO.getOprseq().toString() + ",";
			}
		}

		if (orStr.length() > 1) {
			result = dao.query(params, orStr, 0, user);
		} else {
			result = dao.query(params);
		}

		return result;
	}

	// �����ƶ�������Ա��Ϣ����������Ƿ��ǵ�ǰ��������������
	public EmployeeVO doDitchcreate(EmployeeVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);

			// �������ΪNULL���߿ո�������Ӷ��������Ҫ����Ƿ����ظ�����
			if (vo.getOprcode2() != null && !vo.getOprcode2().trim().equals("")) {
				// �жϹ����Ƿ��ڹ��ű����
				checkOpercode(vo, user);
				// �жϹ����Ƿ��Ѿ�����
				if (doFindByOprcode(vo.getOprcode2(), user) != null)
					throw new BusinessException("", "Ա��������Ϣ���Ѿ����ڸù���");
			}
			// ���������Ƿ��ǵ�ǰ������������ʵ�壩����
			if (vo.getWayid() != null && !vo.getWayid().trim().equals("")) {

				if (waydao.getIsupperwayid(user.getWayid(), vo.getWayid())
						.getDatas().size() == 0)
					throw new BusinessException("", "�����������ڵ�ǰ����������(ʵ��)����");
			}
			AuditUtils auditutils = new AuditUtils();
			if (vo.getPosittype() != null
					&& !vo.getPosittype().trim().equals("")) {
				if (!auditutils.doCheckSystemParam("CH_POSTKIND", vo
						.getPosittype(), user)) {
					throw new BusinessException("", "�ø�λ����("
							+ vo.getPosittype() + ")����Ч����");
				}
			}
			// ����ɼ�ƽ̨�����ֻ�������
			if (vo.getOfficetel() != null) {
				checkTelCity(vo.getOfficetel(), user);
				if (vo.getEmpstatus() != null
						&& vo.getEmpstatus().shortValue() == 0) {
					checkOfficeTel(vo.getOfficetel(), user);
				}
			}
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	// �ƶ�������Ա��Ϣ�޸ģ���������Ƿ��ǵ�ǰ��������������
	public EmployeeVO doDitchupdate(EmployeeVO vo, User user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);

			// �жϹ����Ƿ����޸ģ����޸��������Ƿ��ظ������޸�Ҳֱ�Ӹ���
			EmployeeVO existVO = doFindByPk(vo.getEmployeeid(), user);

			if (existVO.getOprcode2() == null
					|| existVO.getOprcode2().trim().equals("")) {

				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					// �жϹ����Ƿ��Ѿ�����
					if (doFindByOprcode(vo.getOprcode2(), user) != null)
						throw new BusinessException("", "Ա��������Ϣ���Ѿ����ڸù���");
				}

			} else {
				// �жϹ����Ƿ��ڹ��ű����
				checkOpercode(vo, user);
				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					if (!existVO.getOprcode2().equals(vo.getOprcode2())) {

						if (doFindByOprcode(vo.getOprcode2(), user) != null)
							throw new BusinessException("", "Ա��������Ϣ���Ѿ����ڸù���");
					}
				}

			}
			if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() == 11) {
				checkTelCity(vo.getOfficetel(), user);
				// ��ְ+�ı��ֻ�����
				if (vo.getEmpstatus() != null
						&& vo.getEmpstatus().shortValue() == (short) 0) {
					if (!vo.getOfficetel().equals(existVO.getOfficetel())) {

						checkOfficeTel(vo.getOfficetel(), user);
					}
				}
				// ��ְ�ĳ���ְҪ�ټ���ֻ�����,�����ֻ�����䲻��
				if (vo.getEmpstatus() != null
						&& vo.getEmpstatus().shortValue() == (short) 0
						&& existVO.getEmpstatus() != null
						&& existVO.getEmpstatus().shortValue() == (short) 1) {
					checkOfficeTel(vo.getOfficetel(), user);
				}
			}
			// ���������Ƿ��ǵ�ǰ������������ʵ�壩����
			if (vo.getWayid() != null && !vo.getWayid().trim().equals("")) {

				if (waydao.getIsupperwayid(user.getWayid(), vo.getWayid())
						.getDatas().size() == 0)
					throw new BusinessException("", "�����������ڵ�ǰ����������(ʵ��)����");
			}
			AuditUtils auditutils = new AuditUtils();
			if (vo.getPosittype() != null
					&& !vo.getPosittype().trim().equals("")) {
				if (!auditutils.doCheckSystemParam("CH_POSTKIND", vo
						.getPosittype(), user)) {
					throw new BusinessException("", "�ø�λ����("
							+ vo.getPosittype() + ")����Ч����");
				}
			}

			BeanUtils.copyProperties(existVO, vo);
			return (EmployeeVO) dao.update(existVO);
			// return (EmployeeVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	// ���������Ա��Ϣ��������,�÷���������ʹ��
	public EmployeeVO doSocietyBatchCreate(EmployeeVO vo, User user)
			throws Exception {
		try {
			// EmployeeDAO dao = (EmployeeDAO)
			// DAOFactory.build(EmployeeDAO.class,
			// user);
			//
			// AuditUtils auditutils = new AuditUtils();
			//
			// if (vo.getRight() != null && vo.getRight().intValue() != 0) {
			// if (!auditutils.doCheckSystemParam("CH_STEMPRIGHT", vo
			// .getRight().toString(), user)) {
			// throw new BusinessException("", "��Ȩ�޼���("
			// + vo.getRight().toString() + ")����Ч����");
			// }
			// }
			// vo.setWaytype("AG");
			// return (EmployeeVO) dao.create(vo);
			return null;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * �������������Ƿ�Ϊ�û���������������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage checkWayIsValid(String wayid, User user)
			throws Exception {
		EmployeeListVO listVO = new EmployeeListVO();
		String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
				+ user.getWayid()
				+ "' connect by prior   wayid   = upperwayid) and wayid='"
				+ wayid + "'"; // ����Ȩ������

		listVO.set_sql_waycondition(sql);
		return this.doSocietyEmployeeQuery(listVO, user);
	}

	// �ƶ�������Ա��Ϣ��������
	public EmployeeVO doDitchBatchCreate(EmployeeVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);

			WayDelegate wdelegate = new WayDelegate();
			WayVO wayVO = wdelegate.doFindByPk(vo.getWayid(), user);
			if (wayVO == null) {
				throw new Exception("[������������������]������");
			}

			// ���������Ƿ��ǵ�ǰ������������ʵ�壩����

			if (waydao.getIsupperwayid(user.getWayid(), wayVO.getWayid())
					.getDatas().size() == 0) {
				throw new BusinessException("", "�����������ڵ�ǰ����������(ʵ��)����");

			} else {
				if (!vo.getCityid().equals(wayVO.getCityid())) {
					throw new Exception("[���й�˾]����ѡ�����ĵ��й�˾��һ��");
				}
				if (vo.getCountyid() != null
						&& !vo.getCountyid().equals(wayVO.getCountyid())) {
					throw new Exception("[�ֹ�˾]����ѡ�����ķֹ�˾��һ��");
				}
				if (vo.getSvccode() != null
						&& !"".equals(vo.getSvccode().trim())) {
					ServcentListVO listVO = new ServcentListVO();
					listVO.set_se_countyid(vo.getCountyid());
					listVO.set_se_svccode(vo.getSvccode());
					ServcentDelegate sdelegate = new ServcentDelegate();
					if (sdelegate.doQuery(listVO, user).getRowCount() == 0) {
						throw new Exception("[������������]�����ڸ÷ֹ�˾");
					}
				}
			}
			if (doFindByPk(vo.getEmployeeid(), user) != null) {
				throw new Exception("[��Ա���]�Ѿ�����");
			}
			// �жϹ����Ƿ��ڹ��ű����
			checkOpercode(vo, user);
			AuditUtils auditutils = new AuditUtils();
			if (vo.getPosittype() != null
					&& !vo.getPosittype().trim().equals("")) {
				if (!auditutils.doCheckSystemParam("CH_POSTKIND", vo
						.getPosittype(), user)) {
					throw new BusinessException("", "�ø�λ����("
							+ vo.getPosittype() + ")����Ч����");
				}
			}
			// �жϲɼ�ƽ̨�ֻ������Ƿ�һ��
			if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() == 11) {
				checkTelCity(vo.getOfficetel(), user);
				checkOfficeTel(vo.getOfficetel(), user);
			}
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/*
	 * �õ���ǰ�������ϼ�ʵ������
	 */
	public DataPackage doUpperwayid(String basewayid, String wayid, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.getIsupperwayid(basewayid, wayid);
	}

	// �ƶ�������������Ա��Ϣ��ѯ
	public DataPackage doServerhallEmployeeQuery(EmployeeListVO params,
			User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		OperroleDAO Operroledao = (OperroleDAO) DAOFactory.build(
				OperroleDAO.class, user);
		OperroleListVO operrolelistvo = new OperroleListVO();
		operrolelistvo.set_se_operid(user.getOpercode());
		operrolelistvo.set_se_roleid("bchworker");
		int i = Operroledao.query(operrolelistvo).getDatas().size();
		return dao.serverhallEmployeeQuery(params, user, i);
	}

	// �ƶ���������������Ϣ��ѯ
	public DataPackage doDitchmgrEmployeeQuery(EmployeeListVO params, User user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		OperroleDAO Operroledao = (OperroleDAO) DAOFactory.build(
				OperroleDAO.class, user);
		OperroleListVO operrolelistvo = new OperroleListVO();
		operrolelistvo.set_se_operid(user.getOpercode());
		operrolelistvo.set_se_roleid("waymanager");
		int i = Operroledao.query(operrolelistvo).getDatas().size();
		return dao.ditchmgrEmployeeQuery(params, user, i);
	}

	/*
	 * ������Ա���
	 */
	public String getEmployeeid(User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);

		return SessionFactoryRouter.conversionCityid(user.getCityid())
				+ dao.getSequence();
	}

	/*
	 * �������������Ա
	 */
	public EmployeeVO doSocietycreate(EmployeeVO vo, User user)
			throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			WayDelegate wdelegate = new WayDelegate();
			WayVO wayVO = wdelegate.doFindByPk(vo.getWayid(), user);
			if (wayVO == null) {
				throw new Exception("[��������/��������]:" + vo.getWayid() + "��ϵͳ�в�����");
			}
			if (!"AG".equals(wayVO.getWaytype())
					&& !("ET".equals(wayVO.getWaytype()) && 1 == wayVO
							.getRunmode().longValue())) {
				throw new Exception("[��������]��������������Խ���Ӫ����");
			} else {
				if (vo.getCityid() != null
						&& wayVO.getCityid() != null
						&& !vo.getCityid().trim().equals(
								wayVO.getCityid().trim())) {
					throw new Exception("[���й�˾]" + vo.getCityid()
							+ "����ѡ�����ĵ��й�˾" + wayVO.getCityid() + "��һ��");
				}
				if (vo.getCountyid() != null
						&& !vo.getCountyid().trim().equals(wayVO.getCountyid())) {
					throw new Exception("[�ֹ�˾]:" + vo.getCountyid()
							+ "����ѡ�����ķֹ�˾" + wayVO.getCountyid() + "��һ��");
				}
				if (vo.getSvccode() != null
						&& !"".equals(vo.getSvccode().trim())) {
					ServcentListVO listVO = new ServcentListVO();
					listVO.set_se_countyid(vo.getCountyid());
					listVO.set_se_svccode(vo.getSvccode());
					ServcentDelegate sdelegate = new ServcentDelegate();
					if (sdelegate.doQuery(listVO, user).getRowCount() == 0) {
						throw new Exception("[������������]�����ڸ÷ֹ�˾");
					}
				}
			}
			if (vo.getIsnet().intValue() == 1) {
				EmployeeListVO employeelistvo = new EmployeeListVO();
				employeelistvo.set_se_wayid(vo.getWayid());
				employeelistvo.set_ne_empstatus("0");
				employeelistvo.set_ne_isnet("1");
				DataPackage pack = dao.query(employeelistvo);
				if (pack.getDatas().size() > 0) {
					throw new BusinessException("", "һ������ֻ����һ������");
				}
				// ֻ�е�������������ȷ����
				vo.setNetpass(CMSUtils.genRandomNumer(6));// ����ȷ������λ�����
			}
			if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() == 11) {
				// ���ɼ�ƽ̨�����ֻ����Ƿ���ں��Ƿ�͵�¼����һ������
				checkTelCity(vo.getOfficetel(), user);
				// ���ɼ�ƽ̨�����ֻ����Ƿ�Ψһ
				checkOfficeTel(vo.getOfficetel(), user);

			} else if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() != 11) {
				throw new BusinessException("", "�ɼ�ƽ̨�����ֻ���λ������ȷ,����Ϊ11λ!");
			}
			String employeeid = getEmployeeid(user);
			EmployeeVO oldVO = (EmployeeVO) dao.findByPk(employeeid);
			while (oldVO != null) {
				employeeid = getEmployeeid(user);
				oldVO = (EmployeeVO) dao.findByPk(employeeid);
			}
			vo.setEmployeeid(employeeid);// ��Ա��ź�̨�Զ�����
			if (vo.getIsopen() == null) {// ��������־��д 0��δ��ͨ��
				vo.setIsopen(new Short("0"));
			}
			vo.setWaytype("AG");// Ĭ��Ϊ�������
			if (vo.getEmpstatus() == null) { // ����Ĭ���ڸ�
				vo.setEmpstatus(new Short("0"));
			}
			// �������ΪNULL���߿ո�������Ӷ��������Ҫ����Ƿ����ظ�����
			if (vo.getOprcode2() != null && !vo.getOprcode2().trim().equals("")) {
				// �жϹ����Ƿ��ڹ��ű����
				checkOpercode(vo, user);
				// �жϹ����Ƿ��Ѿ�����
				if (doFindByOprcode(vo.getOprcode2(), user) != null)
					throw new BusinessException("", "Ա��������Ϣ���Ѿ����ڸù���");
			}
			// add by wh,��������ѡ���ֻ�����,Ҫƥ���ڸ�Ϊ������֤Ψһ
			if (vo.getSelectmobile() != null
					&& vo.getSelectmobile().length() > 0) {
				EmployeeListVO listVO = new EmployeeListVO();
				listVO.set_orderby("selectmobile");
				listVO.set_ne_empstatus("0");
				listVO.set_se_selectmobile(vo.getSelectmobile());
				if (dao.query(listVO).getRowCount() > 0) {
					throw new Exception("����ѡ��/д��ר�ú��������ϵͳΨһ");
				}
			}
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/*
	 * �����޸ĺ��뵼�µ��������������Ա�����ƣ�
	 */
	public EmployeeVO doSocietyCopy(EmployeeVO vo, User user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);

			if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() == 11) {
				checkOfficeTel(vo.getOfficetel(), user);
			} else if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() != 11) {
				throw new BusinessException("", "�ɼ�ƽ̨�����ֻ���λ������ȷ,����Ϊ11λ!");
			}
			vo.setEmployeeid(getEmployeeid(user));// ��Ա��ź�̨�Զ�����
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * ����ʱ�ж�һ�����������Ŀֻ��С�ڵ���һ
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean jdugeIsNet(String wayid, User user) throws Exception {
		EmployeeControl employeeControl = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		EmployeeListVO listVO = new EmployeeListVO();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		return employeeControl.doQuery(listVO, user).getRowCount() <= 1;

	}

	/**
	 * �޸�ʱҪ�ѵ�Ա�ĳɵ���ʱ���޸���ְ״̬ʱ���á�
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean jdugeIsNetChange(String wayid, User user) throws Exception {
		EmployeeControl employeeControl = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		EmployeeListVO listVO = new EmployeeListVO();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		return employeeControl.doQuery(listVO, user).getRowCount() <= 0;
	}

	private void checkOpercode(EmployeeVO vo, User user) throws Exception {
		if (vo.getOprcode2() == null || "".equals(vo.getOprcode2().trim())) {
			return;
		} else {
			OperatorControl control = (OperatorControl) ControlFactory
					.build(OperatorControlBean.class);
			if (control.doFindByPk(vo.getOprcode2(), user) == null) {
				throw new BusinessException("", "ϵͳ������¼�빤��");
			}
		}
	}

	/**
	 * ��ѯ��ְ�ֻ������Ƿ�Ψһ
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	private void checkOfficeTel(String officetel, User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		EmployeeListVO listvo = new EmployeeListVO();
		listvo.set_se_officetel(officetel);
		// 0-��ְ
		listvo.set_ne_empstatus("0");
		DataPackage pack = dao.query(listvo);
		if (pack.getDatas().size() > 0) {
			throw new BusinessException("", "ϵͳ�Ѵ��ڸ�[�ɼ�ƽ̨�����ֻ���]�����������ֻ��ţ�");
		}
	}

	/**
	 * ����ֻ������Ƿ��ڱ�������Ψһ
	 * 
	 * @param officetel
	 * @param user
	 */
	private void checkTelCity(String officetel, User user) throws Exception {
		NosectDelegate delegate = new NosectDelegate();
		String cityid = delegate.doQueryCityID(officetel, user);
		if (cityid != null
				&& !cityid.equals(SessionFactoryRouter.conversionCityid(user
						.getCityid()))) {
			throw new Exception("�ɼ�ƽ̨�ֻ��������¼�����������в�һ��");
		}
	}

	public DataPackage doWayproemployeeQuery(EmployeeListVO listvo, User user)
			throws Exception {
		VEmployeeDAO dao = (VEmployeeDAO) DAOFactory.build(VEmployeeDAO.class,
				user);
		return dao.queryByNamedSqlQuery("WayproemployeeQuery", listvo);
	}
	
	public void doSendMsg(EmpconfirmVO confirmVO,String operate,User user)throws Exception {
		//ȡ�ö��Ŷ˿�
		SysparamDAO paramDao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		String smsPort =paramDao.doFindByID(new Long("1"), "pboss_unpb");
		if(smsPort==null)
		{
			throw new Exception("ϵͳ������δȡ��ϵͳ���Ͷ��Ŷ˿�!");
		}
		WaitreqDAO reqDAO=(WaitreqDAO) DAOFactory.build(WaitreqDAO.class,
				user);
		WaitreqVO reqVO=new WaitreqVO();
//		reqVO.setStreamno("");
		reqVO.setSmstype(WebConstant.SMS_TYPE_REWARD_5);
		reqVO.setAreacode(CityIDMap
				.conversionCityid(user.getCityid()));
		java.util.Date date=new java.util.Date();
		reqVO.setCreattime(date);
		reqVO.setDealtime(date);
		//��������
		String message="";
		ExcelCodeToName et = new ExcelCodeToName();
		String wayname=et.codeToName("#WAY", confirmVO.getWayid(), user);
		if("NEW".equals(operate)){
			if(confirmVO.getWayid().endsWith("U_00000"))
			{
				message=smsModelAdd[0]+wayname+"����"+smsModelAdd[1];
			}else
			{
				message=smsModelAdd[0]+wayname+"������"+smsModelAdd[1];
			}
		}else if("EDIT".equals(operate)){
			if(confirmVO.getEmpstatus().shortValue()==(short)0){
				if(confirmVO.getWayid().endsWith("U_00000"))
				{
					message=smsModelUpdate[0]+wayname+"����"+smsModelUpdate[1];
				}else
				{
					message=smsModelUpdate[0]+wayname+"������"+smsModelUpdate[1];
				}
			}else if(confirmVO.getEmpstatus().shortValue()==(short)1)
			{
				message=smsModelRemove;
			}
		}else if("REMOVE".equals(operate))
		{
			message=smsModelRemove;
		}
		reqVO.setMessage(message);
		reqVO.setSendno(smsPort);
		reqVO.setRecno(confirmVO.getTelephone());
		reqVO.setDealcount(new Short("0"));
		reqVO.setIssuccess(new Short("0"));
		reqDAO.create(reqVO);
	}
	
	// �ж��Ƿ���Ҫ����ȷ��
	public boolean doMessage(EmployeeVO empVO, User user, String operate)
			throws Exception {
		if ("EDIT".equals(operate)) {
			return checkChanged(user, empVO) && doMessage(user);
		} else {
			return doMessage(user);
		}
	}
	//�ж��Ƿ���Ҫ����ȷ��
	public boolean doMessage(User user) throws Exception {
		boolean shouldSendmessage = false;
		DictparamDAO dao = (DictparamDAO) DAOFactory.build(DictparamDAO.class,
				user);
		DictparamVO dictParmVO = new DictparamVO();
		dictParmVO.setDkey("BBC_SMSCONFIRM");
		dictParmVO.setDvalue("1");
		shouldSendmessage = (dao.findByPk(dictParmVO) != null);
		return shouldSendmessage;
	}
	//�ж϶���ȷ���Ƿ���24Сʱ֮��
	public void check24(EmployeeVO empVO,User user) throws Exception{
		EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class,
				user);
		EmpconfirmListVO confListVO =new EmpconfirmListVO();
		confListVO.set_se_telephone(empVO.getTelephone());
		confListVO.set_ne_smsstatus("0");
		confListVO.set_orderby("smscreattime");
		confListVO.set_desc("1");
		DataPackage dp=dao.query(confListVO);
		if(dp.getRowCount()>0){
		EmpconfirmVO confirmVO=(EmpconfirmVO)((List)dp.getDatas()).get(0);
		long time=(new Date()).getTime()-confirmVO.getSmscreattime().getTime();
		if(time-aday<0)
		{
			throw new Exception("ϵͳ������ͬ��רԱͬʱ���ڶ�����ȷ����Ϣ");
		}
		}
	}
	
	public EmpconfirmVO doConfirm(EmployeeVO empVO,User user,String operate) throws Exception{
		check24(empVO, user);
		EmpconfirmDAO dao = (EmpconfirmDAO) DAOFactory.build(EmpconfirmDAO.class,
				user);
		EmpconfirmVO confirmVO = new EmpconfirmVO();
		BeanUtils.copyProperties(confirmVO, empVO);
		if("NEW".equals(operate)){
			EmployeeDAO empDAO = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			String employeeid = CityIDMap
			.conversionCityid(user.getCityid())
			+ "UNRC_" + empDAO.getSequence();
			confirmVO.setEmployeeid(employeeid);
		}
		confirmVO.setSmscreattime(new java.util.Date());
		confirmVO.setSmsstatus(new Short("0"));
		 confirmVO=(EmpconfirmVO)dao.create(confirmVO);
		//�������Ƚ��鷳
		doUpdateModel(user, confirmVO.isIsunpb(), confirmVO.getEmployeeid(),confirmVO.getConfirmid());
		doSendMsg(confirmVO, operate, user);
		return confirmVO;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void doUpdateModel(User user, boolean yes, String employeeid,Long confirmid)
			throws Exception {
		EmpmodelDAO empDAO = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class,
				user);
		EmpmodelListVO listVO = new EmpmodelListVO();
		listVO.set_se_employeeid(employeeid);
		listVO.set_se_model("3");
		DataPackage dp = empDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			EmpmodelVO modelVO = (EmpmodelVO) (((List) dp.getDatas()).get(0));
			if (modelVO != null && modelVO.getState() != null) {
				if ((yes && modelVO.getState().shortValue() == 1)
						|| (!yes && modelVO.getState().shortValue() == 0)) {
					doInsertModel(yes, employeeid, user,modelVO.getEmpmodelid(),confirmid);
				}
			}
		} else {
			// ���ݲ�����,��һ����¼
			doInsertModel(yes, employeeid, user,null,confirmid);
		}
	}

	/**
	 * �����ȷ��ģʽ��
	 * 
	 * @param yes
	 * @param employeeid
	 * @param user
	 * @throws Exception
	 */
	public void doInsertModel(boolean yes, String employeeid, User user,Long oldempmodelid,Long confirmid)
			throws Exception {
		EmodconfirmDAO dao = (EmodconfirmDAO) DAOFactory.build(
				EmodconfirmDAO.class, user);
		EmodconfirmVO modVO = new EmodconfirmVO();
		modVO.setConfirmid(confirmid);
		modVO.setEmployeeid(employeeid);
		if(oldempmodelid==null){
			Long empmodelid=(Long)dao.getSequence("CH_PW_EMPMODEL_SEQ");
			modVO.setEmpmodelid(empmodelid);
		}else
		{
			modVO.setEmpmodelid(oldempmodelid);
		}
		modVO.setModel("3");
		modVO.setSmsstatus(new Short("0"));
		modVO.setSmscreattime(new Date());
		if (yes) {
			modVO.setState(new Short("0"));
		} else {
			modVO.setState(new Short("1"));
		}
		dao.create(modVO);
	}
	/**
	 * ��ѯ��ְ�ֻ������Ƿ�Ψһ
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	private void checkSelectmobile(String officetel, User user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		EmployeeListVO list = new EmployeeListVO();
		list.set_orderby("selectmobile");
		list.set_ne_empstatus("0");
		list.set_se_selectmobile(officetel);
		if (dao.query(list).getRowCount() >= 1) {
			throw new Exception("�ÿ���ѡ���ֻ���" + officetel + "�Ѿ�����һ���ڸڵļ�¼!");
		}
	}
	
	public EmployeeVO doUpdateWaypro(EmployeeVO empVO, User user)
			throws Exception {
		try {
			// ��������Ƿ����ȫԱ����
			checkUnpb(user, empVO);
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// ����Ƿ����ƹ�רԱ�Ѿ�����
				checkTelephone(user, empVO,empVO.getEmployeeid());
			// ����Ƿ���Ҫ����ȷ��
				//������������������Ա״̬�Ƿ�ı�,����ı�Ŷ���ȷ��ȥ������,����ԭ���߼�.
				
			if (doMessage(empVO,user,"EDIT")) {
				  doConfirm(empVO, user,"EDIT");
				  empVO.setChanged(true);
			} else {
				if(doMessage(user))
				{
					//����רԱ�Ƿ����޸Ĺ����������������Ա״̬�Ĵ�ȷ�ϼ�¼,�����,�Ͳ����޸�.
					check24(empVO, user);
				}
				// ȥģʽ���ѯ��¼
				EmpmodelDAO modelDAO = (EmpmodelDAO) DAOFactory.build(
						EmpmodelDAO.class, user);
				EmpmodelListVO empListvo = new EmpmodelListVO();
				empListvo.set_se_employeeid(empVO.getEmployeeid());
				empListvo.set_se_model("3");
				DataPackage empDp = modelDAO.query(empListvo);
				if(empDp.getRowCount()<=0)
				{
					//�ݴ���,���û�в�ѯ����¼����һ����¼
					EmpmodelVO modelvo = new EmpmodelVO();
					modelvo.setEmployeeid(empVO.getEmployeeid());
					modelvo.setModel("3");
					if(empVO.isIsunpb())
					{
						modelvo.setState(new Short("0"));
					}else
					{
						modelvo.setState(new Short("1"));
					}
					modelDAO.create(modelvo);
				}else
				{
					EmpmodelVO modelvo=(EmpmodelVO)((List)empDp.getDatas()).get(0);
					if(empVO.isIsunpb())
					{
						modelvo.setState(new Short("0"));
					}else
					{
						modelvo.setState(new Short("1"));
					}
					modelDAO.update(modelvo);
				}
				Session session = SessionUtil.currentSession(dao.getDbFlag());
				// session.evict(oldVO);
				EmployeeVO newVO = (EmployeeVO) session.merge(empVO);
				dao.registerLog("update", newVO, user);
				session.flush();
				return newVO;
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			ex.printStackTrace();
			throw ex;
		}
		return empVO;
	}
	public EmployeeVO doRemoveWaypro(EmployeeVO empVO, User user)
			throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			if (doMessage(user)) {
				doConfirm(empVO, user, "REMOVE");
			} else {
				dao.update(empVO);
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			ex.printStackTrace();
			throw ex;
		}
		return empVO;
	}
	/**
	 * ����޸ĵ�ʱ�����������������Ա״̬�Ƿ�ı�
	 * @param user
	 * @param employeeid
	 * @return
	 * @throws Exception
	 */
	public boolean checkChanged(User user,EmployeeVO empVO) throws Exception{
		boolean isChanged=false;
		if(empVO.getEmpstatus()==null || empVO.getWayid()==null)
		{
			throw new Exception("���ݴ���:��Ա״̬���������������벻��Ϊ��");
		}
		//��״̬�Ƿ�ı�
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		Object oldVO= dao.findByProperty("employeeid", empVO.getEmployeeid());
		if(oldVO!=null)
		{
			isChanged= !(empVO.getWayid().equals(((EmployeeVO) oldVO).getWayid()))
					|| !(empVO.getEmpstatus().equals(((EmployeeVO) oldVO).getEmpstatus()));
			empVO.setChanged(isChanged);
		}else
		{
			throw new Exception("��ԱID������:"+empVO.getEmployeeid());
		}
		return isChanged;
	}
	/**
	 * 
	 * @param empVO
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public EmployeeVO doCreateWaypro(EmployeeVO empVO, User user)
			throws Exception {
		try {
			//��������Ƿ����ȫԱ����
			checkUnpb(user, empVO);
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			//����Ƿ����ƹ�רԱ�Ѿ�����
			checkTelephone(user, empVO,null);
			//����Ƿ���Ҫ����ȷ��
			if(doMessage(empVO,user,"NEW"))
			{
				 doConfirm(empVO, user,"NEW");
			}else
			{
				String employeeid = CityIDMap
						.conversionCityid(user.getCityid())
						+ "UNRC_" + dao.getSequence();
				empVO.setEmployeeid(employeeid);
				//��ģʽ��
				EmpmodelDAO modelDAO = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class,
						user);
				EmpmodelVO modelvo = new EmpmodelVO();
				modelvo.setEmployeeid(empVO.getEmployeeid());
				modelvo.setModel("3");
				if(empVO.isIsunpb())
				{
					modelvo.setState(new Short("0"));
				}else
				{
					modelvo.setState(new Short("1"));
				}
				modelDAO.create(modelvo);
				empVO=(EmployeeVO)dao.create(empVO);
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
		return empVO;
	}
	
	public void checkUnpb(User user,EmployeeVO empVO) throws Exception {
		WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class,
				user);
		WaycompactListVO waycompactListVO = new WaycompactListVO();
		waycompactListVO.set_se_wayid(empVO.getWayid());
		waycompactListVO.set_ne_isunpb(Short.valueOf("1"));
		DataPackage dp = dao.query(waycompactListVO);
		if (dp.getRowCount() == 0) {
			throw new BusinessException("", "����������δ����ȫԱ����ģʽ");
		}
		
	}
	public void checkTelephone(User user,EmployeeVO empVO,String employeeid) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
			EmployeeListVO empListVO=new  EmployeeListVO();
			empListVO.set_se_telephone(empVO.getTelephone());
			empListVO.set_ne_isnet("2");
			if(null!=employeeid)
			{
				empListVO.set_sne_employeeid(employeeid);
			}
			DataPackage dp = dao.query(empListVO);
			if(dp.getRowCount()>0){
					throw new BusinessException("", "���ƹ�רԱ�Ѿ�����");
			}
		}
	
	// ���ݹ���������ѯ
	public DataPackage mobileEmployeeQuery(EmployeeListVO params,User user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return dao.mobileEmployeeQuery(params);
	}
	// ���ݹ���������ѯ
	public boolean mobileEmployeeQuery(String officetel,User user)
			throws Exception {
		EmployeeListVO elistvo = new EmployeeListVO();
		elistvo.set_se_officetel(officetel);
		DataPackage edp = this.mobileEmployeeQuery(elistvo, user);
		if (null == edp || edp.getDatas().size() == 0) {
			return false;
		}else{
			return true;
		}
	}
	
}
