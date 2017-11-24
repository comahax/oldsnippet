package com.sunrise.boss.business.cms.way.control;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpDAO;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpVO;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControl;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControlBean;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorDAO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.employee.control.EmployeeControl;
import com.sunrise.boss.business.cms.employee.control.EmployeeControlBean;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.netsyn.control.NetsynControl;
import com.sunrise.boss.business.cms.netsyn.control.NetsynControlBean;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynDAO;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynListVO;
import com.sunrise.boss.business.cms.netsyn.persistent.NetsynVO;
import com.sunrise.boss.business.cms.way.persistent.AGWayVO;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControl;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControlBean;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.control.WaycompactControl;
import com.sunrise.boss.business.cms.waycompact.control.WaycompactControlBean;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.business.common.sysparam.control.SysparamControl;
import com.sunrise.boss.business.common.sysparam.control.SysparamControlBean;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.PublicUtils;

/**
 * 
 * @author caijianhui
 *
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/way/control/AGWayControlBean"
 *           name="AGWayControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class AGWayControlBean extends AbstractControlBean implements
		AGWayControl {

	private static Log log = LogFactory.getLog(AGWayControlBean.class);
	private static String smsMsgPattern = "�𾴵ĺ�����飬��������������{0}������������{1}��Ϣ�ѷ���������������Ϣ:{2}�й��ƶ�";
	private static int smsMsgPatternLen = 40;

	public int doCreate(AGWayVO vo, User user) throws Exception {
		int cando = 0;
		try {
			CooperatorDAO cooperatorDAO = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			WayControl control = (WayControl) ControlFactory
					.build(WayControlBean.class);
			BchcontactControl bchcontactControl = (BchcontactControl) ControlFactory
					.build(BchcontactControlBean.class);
			WaycompactControl waycompactControl = (WaycompactControl) ControlFactory
					.build(WaycompactControlBean.class);
			WayaccountControl wayaccountControl = (WayaccountControl) ControlFactory
					.build(WayaccountControlBean.class);
			EmployeeControl employeeControl = (EmployeeControl) ControlFactory
					.build(EmployeeControlBean.class);
			NetsynControl netsynControl = (NetsynControl) ControlFactory
					.build(NetsynControlBean.class);
			WayVO wayVO = new WayVO();
			BchcontactVO bchcontactVO = new BchcontactVO();
			WaycompactVO waycompactVO = new WaycompactVO();
			WayaccountVO wayaccountVO = new WayaccountVO();
			CooperatorVO cooperatorVO = new CooperatorVO();
			EmployeeVO employeeVO = new EmployeeVO();
			NetsynVO netsynVO = new NetsynVO();

			if (vo.getOfficetel() == null
					|| StringUtils.isBlank(vo.getOfficetel())) {
				throw new Exception("�ɼ�ƽ̨�����ֻ��ű�����д");
			}
			EmployeeListVO employeeListVO = new EmployeeListVO();
			employeeListVO.set_ne_empstatus("0");
			employeeListVO.set_se_officetel(vo.getOfficetel());
			if (employeeControl.doQuery(employeeListVO, user).getRowCount() > 0) {
				throw new Exception("ϵͳ�Ѵ��ڸòɼ�ƽ̨�����ֻ��ţ����������ֻ���");
			}
			// ���û������״̬��Ĭ��Ϊ1����Ч��
			if (vo.getWaystate() == null) {
				vo.setWaystate(new Short((short) 1));
			}

			// �����̲��Դ������ֶν��д���
			setCoopVO(cooperatorVO, vo,user);
			String[] pk = new String[] { "wayid" };
			AuditUtils utils = new AuditUtils();

			BeanUtils.copyProperties(wayVO, vo);
			BeanUtils.copyProperties(bchcontactVO, vo);
			BeanUtils.copyProperties(waycompactVO, vo);
			waycompactVO.setEndtime(vo.getCmpendtime());
			BeanUtils.copyProperties(wayaccountVO, vo);

			bchcontactVO.setLinkman(vo.getPrincipal());
			bchcontactVO.setLinkmantel(vo.getPrincipaltel());
			// ���������ǵ��˻���Ĭ��Ϊ0
			wayaccountVO.setAccid(new Integer(0));
			// �ɷ����ͣ��ʺ����Ͷ���̶�ֵ 0
			wayaccountVO.setAccttype(new Short((short) 0));
			wayaccountVO.setChargetype(new Short((short) 0));
			if (control.doFindByPk(wayVO.getWayid(), user) != null) {
				throw new BusinessException("CMS-10001", "�Ѿ����ڸ���������:"
						+ vo.getWayid());
			}
			wayVO = (WayVO) utils.doSaveAudit(wayVO, "CH_PW_WAY",
					"CH_PW_SALEWAY", null, pk, "CH_PW_SALEWAY_AUDIT", user);
			bchcontactVO = (BchcontactVO) utils.doSaveAudit(bchcontactVO,
					"CH_PW_BCHCONTACT", "CH_PW_SALEWAY", null, pk,
					"CH_PW_SALEWAY_AUDIT", user);
			waycompactVO = (WaycompactVO) utils.doSaveAudit(waycompactVO,
					"CH_PW_WAYCOMPACT", "CH_PW_SALEWAY", null, pk,
					"CH_PW_SALEWAY_AUDIT", user);
			wayaccountVO = (WayaccountVO) utils.doSaveAudit(wayaccountVO,
					"CH_PW_WAYACCOUNT", "CH_PW_SALEWAY", null, new String[] {
							"wayid", "accid" }, "CH_PW_SALEWAY_AUDIT", user);
			control.doCreate(wayVO, user);
			bchcontactControl.doCreate(bchcontactVO, user);
			waycompactControl.doCreate(waycompactVO, user);
			wayaccountControl.doCreate(wayaccountVO, user);
			cooperatorDAO.create(cooperatorVO);
			// ��¼������Ϣ
			employeeVO = setEmployVO(vo);
			boolean iscanSetservice = this.canSetservice(user);
			if (iscanSetservice) {
				employeeVO.setIsopen(new Short((short) 2));
			}
			employeeControl.doSocietycreate(employeeVO, user);
			if (iscanSetservice) {
				// д���㶨���м��
				netsynVO = setNetsynVO(vo.getOfficetel(), new Short((short) 0),
						user.getOpercode());
				netsynControl.doCreate(netsynVO, user);
				cando = 1;
			}

		} catch (Exception e) {
			log.error(e);
			sessionContext.setRollbackOnly();
			throw e;
		}
		return cando;
	}

	public void doDelete(WayVO vo, User user) throws Exception {
		try {
			WayControl control = (WayControl) ControlFactory
					.build(WayControlBean.class);
			CooperatorDAO cooperatorDAO = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			EmployeeControl employeeControl = (EmployeeControl) ControlFactory
					.build(EmployeeControlBean.class);
			NetsynControl netsynControl = (NetsynControl) ControlFactory
					.build(NetsynControlBean.class);
			CooperatorVO cooperatorVO = (CooperatorVO) cooperatorDAO
					.findByPk(vo.getWayid());
			WayVO wayVO = (WayVO) control.doFindByPk(vo.getWayid(), user);
			wayVO.setWaystate(new Short((short) 0));
			control.doUpdate(wayVO, user);
			if (cooperatorVO != null) {
				cooperatorVO.setState(new Short((short) 0));
				cooperatorDAO.update(cooperatorVO);
			}
			EmployeeListVO listVO = new EmployeeListVO();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("1");
			listVO.set_ne_empstatus("0");
			Iterator iterator = employeeControl.doQuery(listVO, user)
					.getDatas().iterator();
			if (iterator.hasNext()) {
				EmployeeVO employeeVO = (EmployeeVO) iterator.next();
				if (employeeVO != null) {
					if (canSetservice(user)) {
						NetsynVO netsynVO = setNetsynVO(employeeVO
								.getOfficetel(), new Short((short) 1), user
								.getOpercode());
						netsynControl.doCreate(netsynVO, user);
					}
					employeeVO.setEmpstatus(new Short((short) 1));// �޸ĳ���ְ״̬
					// 0���ڸ� 1����ְ
					employeeControl.doUpdate(employeeVO, user);
				}
			}
		} catch (Exception e) {
			log.error(e);
			sessionContext.setRollbackOnly();
			throw e;
		}
	}

	public int doUpdate(AGWayVO vo, User user) throws Exception {
		int cando = 0;
		try {
			CooperatorDAO cooperatorDAO = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			WayControl control = (WayControl) ControlFactory
					.build(WayControlBean.class);
			BchcontactControl bchcontactControl = (BchcontactControl) ControlFactory
					.build(BchcontactControlBean.class);
			WaycompactControl waycompactControl = (WaycompactControl) ControlFactory
					.build(WaycompactControlBean.class);
			WayaccountControl wayaccountControl = (WayaccountControl) ControlFactory
					.build(WayaccountControlBean.class);
			EmployeeControl employeeControl = (EmployeeControl) ControlFactory
					.build(EmployeeControlBean.class);
			NetsynControl netsynControl = (NetsynControl) ControlFactory
					.build(NetsynControlBean.class);
			WayVO wayVO = new WayVO();
			BchcontactVO bchcontactVO = new BchcontactVO();
			WaycompactVO waycompactVO = new WaycompactVO();
			WayaccountVO wayaccountVO = new WayaccountVO();
			CooperatorVO cooperatorVO = new CooperatorVO();
			EmployeeVO employeeVO = new EmployeeVO();
			NetsynVO netsynVO = new NetsynVO();

			// �����޸�ʱ���������ȡԭ����״̬��null����1��
			if (vo.getOldstate() == null) {
				BaseDAO baseDAO = new BaseDAO(WayVO.class, user.getCityid());
				Short oldState = (Short) baseDAO.getMaxid("wayid", vo
						.getWayid(), "waystate");
				if (oldState == null) {
					oldState = new Short((short) 1);
				}
				vo.setOldstate(oldState);
			}
			String[] pk = new String[] { "wayid" };
			AuditUtils utils = new AuditUtils();
			setCoopVO(cooperatorVO, vo,user);
			BeanUtils.copyProperties(wayVO, vo);
			BeanUtils.copyProperties(bchcontactVO, vo);
			BeanUtils.copyProperties(waycompactVO, vo);
			waycompactVO.setEndtime(vo.getCmpendtime());
			BeanUtils.copyProperties(wayaccountVO, vo);
			// ���������ǵ��˻���Ĭ��Ϊ0
			wayaccountVO.setAccid(new Integer(0));
			// �ɷ����ͣ��ʺ����Ͷ���̶�ֵ 0
			wayaccountVO.setAccttype(new Short((short) 0));
			wayaccountVO.setChargetype(new Short((short) 0));

			bchcontactVO.setLinkman(vo.getPrincipal());
			bchcontactVO.setLinkmantel(vo.getPrincipaltel());
			wayVO = (WayVO) utils.doUpdateValue(wayVO, "CH_PW_WAY",
					"CH_PW_SALEWAY", null, pk, "CH_PW_SALEWAY_AUDIT", user);
			bchcontactVO = (BchcontactVO) utils.doUpdateValue(bchcontactVO,
					"CH_PW_BCHCONTACT", "CH_PW_SALEWAY", null, pk,
					"CH_PW_SALEWAY_AUDIT", user);
			waycompactVO = (WaycompactVO) utils.doUpdateValue(waycompactVO,
					"CH_PW_WAYCOMPACT", "CH_PW_SALEWAY", null, pk,
					"CH_PW_SALEWAY_AUDIT", user);
			wayaccountVO = (WayaccountVO) utils.doUpdateValue(wayaccountVO,
					"CH_PW_WAYACCOUNT", "CH_PW_SALEWAY", null, new String[] {
							"wayid", "accid" }, "CH_PW_SALEWAY_AUDIT", user);

			control.doUpdate(wayVO, user);
			CooperatorVO cooperatorvo2 = (CooperatorVO) cooperatorDAO
					.findByPk(cooperatorVO.getCooperauid());
			if (cooperatorvo2 == null) {
				cooperatorDAO.create(cooperatorVO);
			} else {
				BeanUtils.copyProperties(cooperatorvo2, cooperatorVO);
				cooperatorDAO.update(cooperatorvo2);
			}
			WaycompactVO waycompactvo2 = (WaycompactVO) waycompactControl
					.doFindByPk(waycompactVO.getWayid(), user);
			if (waycompactvo2 == null) {
				waycompactControl.doCreate(waycompactVO, user);
			} else {
				BeanUtils.copyProperties(waycompactvo2, waycompactVO);
				if(null==waycompactVO.getLicenceno()||"".equals(waycompactVO.getLicenceno())){
					waycompactvo2.setLicenceno(null);
				}
				waycompactControl.doUpdate(waycompactvo2, user);
			}
			WayaccountVO pkVO = new WayaccountVO();
			pkVO.setAccid(new Integer(0));
			pkVO.setWayid(wayaccountVO.getWayid());
			WayaccountVO wayaccountvo2 = (WayaccountVO) wayaccountControl
					.doFindByPk(pkVO, user);
			if (wayaccountvo2 == null) {
				wayaccountControl.doCreate(wayaccountVO, user);
			} else {
				BeanUtils.copyProperties(wayaccountvo2, wayaccountVO);
				wayaccountControl.doUpdate(wayaccountvo2, user);
			}
			BchcontactVO bchcontactvo2 = (BchcontactVO) bchcontactControl
					.doFindByPk(bchcontactVO.getWayid(), user);
			if (bchcontactvo2 == null) {
				bchcontactControl.doCreate(bchcontactVO, user);
			} else {
				BeanUtils.copyProperties(bchcontactvo2, bchcontactVO);
				bchcontactControl.doUpdate(bchcontactvo2, user);
			}

			// ����Ƿ��Ѵ��������ֻ���
			if(StringUtils.isBlank(vo.getOfficetel()))
			{
				throw new Exception("�޸�ʧ��,�ɼ�ƽ̨�����ֻ���Ϊ�գ���¼���ٽ����޸Ĳ���");
			}
			EmployeeListVO employeeListVO = new EmployeeListVO();
			employeeListVO.set_se_officetel(vo.getOfficetel());
			employeeListVO.set_ne_empstatus("0");
			employeeListVO.getQueryConditions()
					.put("_sne_wayid", vo.getWayid());
			Iterator iterator = employeeControl.doQuery(employeeListVO, user)
					.getDatas().iterator();
			if (iterator.hasNext()) {
				throw new Exception("ϵͳ�Ѵ��ڸòɼ�ƽ̨�����ֻ��ţ����������ֻ���");
			}

			// ����޸ĵ������Ƿ���ڵ�����Ϣ
			EmployeeListVO listVO = new EmployeeListVO();
			listVO.set_se_wayid(vo.getWayid());
			listVO.set_ne_empstatus("0");
			listVO.set_ne_isnet("1");

			Iterator itr = employeeControl.doQuery(listVO, user).getDatas()
					.iterator();
			// ��������ڣ�������
			if (!itr.hasNext()) {
				employeeVO = setEmployVO(vo);
				employeeControl.doSocietycreate(employeeVO, user);
			} else {// ������ڣ��޸���Ա��Ϣ
				employeeVO = (EmployeeVO) itr.next();
				String oldOfficetel = employeeVO.getOfficetel(); // ԭ���ֻ���
				EmployeeVO newEmployeeVO = new EmployeeVO();
				BeanUtils.copyProperties(newEmployeeVO, employeeVO);
				newEmployeeVO.setOfficetel(vo.getOfficetel());
				//�޸���Ա����Ϣ
				if ((vo.getWaystate().intValue() == 0 || vo.getWaystate()
						.intValue() == -1)
						&& vo.getOldstate().intValue() == 1) { // ��Ч ��Ϊ ʧЧ��ɾ��
					newEmployeeVO.setEmpstatus(new Short((short) 1)); // ����Ϊ��ְ
					employeeControl.doUpdate(newEmployeeVO, user);
				} else if (!StringUtils.equals(newEmployeeVO.getOfficetel(),
						oldOfficetel)) {
					employeeControl.doUpdate(newEmployeeVO, user);
				}
//				//�޸��ֻ��ţ������˶���ͨ
//				if (canSetservice(user) && !oldOfficetel.equals(vo.getOfficetel()) && (vo.getWaystate().intValue() == 1)) {
//					// ��������˵����ֻ����룬ϵͳ�Ծ��ֻ�������˶����񣬿�ͨ���ֻ��ŷ���
//					NetsynVO oldnetsyn = setNetsynVO(oldOfficetel, new Short(
//							(short) 1), user.getOpercode());// �˶�
//					NetsynVO newnetsyn = setNetsynVO(vo.getOfficetel(),
//							new Short((short) 0), user.getOpercode());// ��ͨ
//					netsynControl.doCreate(oldnetsyn, user);
//					netsynControl.doCreate(newnetsyn, user);
//					cando = 2;
//				}
			}
			if (this.canSetservice(user)) {
				if (vo.getWaystate().intValue() == 1 // ʧЧ��ɾ�� ��Ϊ ��Ч
						&& (vo.getOldstate().intValue() == 0 || vo
								.getOldstate().intValue() == -1)) {
					netsynVO = setNetsynVO(vo.getOfficetel(), new Short(
							(short) 0), user.getOpercode());
					netsynControl.doCreate(netsynVO, user);
				} else if ((vo.getWaystate().intValue() == 0 || vo
						.getWaystate().intValue() == -1)
						&& vo.getOldstate().intValue() == 1) { // ��Ч ��Ϊ ʧЧ��ɾ��
					netsynVO = setNetsynVO(vo.getOfficetel(), new Short(
							(short) 1), user.getOpercode());
					netsynControl.doCreate(netsynVO, user);
				}
					cando = 1;
			}
			
			//��ɼ�ƽ̨�ǼǱ��֪ͨ����
			if ("1".equals(vo.getSendFlag())){
				sendMessage(vo, user);
			}
		} catch (Exception e) {
			log.error(e);
			sessionContext.setRollbackOnly();
			throw e;
		}
		return cando;
	}

	public void doSetservice(String wayid, User user) throws Exception {
		if (!canSetservice(user)) {
			throw new Exception("�õ��в�����ͨ������Ϣ������ȷ��ϵͳ���������Ƿ���ȷ");
		}
		EmployeeControl employeeControl = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		EmployeeVO employeeVO = getEmployee(wayid, user);
		String officetel = employeeVO.getOfficetel();
		NetsynControl netsynControl = (NetsynControl) ControlFactory
				.build(NetsynControlBean.class);
		NetsynVO netsynVO = setNetsynVO(officetel, new Short((short) 0), user
				.getOpercode());
		netsynControl.doCreate(netsynVO, user);
		employeeVO.setIsopen(new Short((short) 2));
		employeeControl.doUpdate(employeeVO, user);
	}

	public boolean doCancelService(String employeeID, User user)
			throws Exception {
		if (!canSetservice(user)) {
			throw new Exception("�õ��в�����ͨ������Ϣ������ȷ��ϵͳ���������Ƿ���ȷ");
		}
		EmployeeControl employeeControl = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		EmployeeVO employeeVO = employeeControl.doFindByPk(employeeID, user);
		String officetel = employeeVO.getOfficetel();
		//��ԱҲ�����˶�������
		if (employeeVO.getIsnet().shortValue() == (short) 1 || employeeVO.getIsnet().shortValue()==(short)0) {
			NetsynControl netsynControl = (NetsynControl) ControlFactory
					.build(NetsynControlBean.class);
			NetsynVO netsynVO = setNetsynVO(officetel, new Short((short) 1),
					user.getOpercode());
			netsynControl.doCreate(netsynVO, user);
			return true;
		} else {
			throw new BusinessException("����Ա��" + employeeID + " ���ǵ�Ա�����");
		}
	}

	/**
	 * �鿴ϵͳ�������Ƿ������˸õ����ܿ�ͨ��������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private boolean canSetservice(User user) throws Exception {
		SysparamControl control = (SysparamControl) ControlFactory
				.build(SysparamControlBean.class);
		String value = control.doFindByID(new Long(5), "channel", user);
		return "1".equals(value) ? true : false;
	}

	/**
	 * ������������õ�������Ϣ
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private EmployeeVO getEmployee(String wayid, User user) throws Exception {
		EmployeeControl employeeControl = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		EmployeeListVO listVO = new EmployeeListVO();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		Iterator iterator = employeeControl.doQuery(listVO, user).getDatas()
				.iterator();
		if (iterator.hasNext()) {
			EmployeeVO tempvo = (EmployeeVO) iterator.next();
			if (tempvo.getIsopen().intValue() > 0) {
				throw new BusinessException("",
						"��Ӧ�Ĳɼ�ƽ̨�����ֻ����ѿ�ͨ�����ڿ�ͨ������Ϣ����,����Ҫ�ظ���ͨ");
			}
			return tempvo;
		} else {
			throw new Exception("��Ӧ�Ĳɼ�ƽ̨�����ֻ���Ϊ��,����¼��");
		}

	}

	private void setCoopVO(CooperatorVO cooperatorvo, AGWayVO wayVO,User user)
			throws Exception {
		BeanUtils.copyProperties(cooperatorvo, wayVO);
		cooperatorvo.setCooperauid(wayVO.getWayid());
		cooperatorvo.setCooperaname(wayVO.getWayname());
		if (wayVO.getShortname() == null || "".equals(wayVO.getShortname())) {
			cooperatorvo.setCpabbrname(wayVO.getWayname());
		} else {
			cooperatorvo.setCpabbrname(wayVO.getShortname());
		}
		cooperatorvo.setCocheckname(wayVO.getShortname());
		cooperatorvo.setCustmanager(wayVO.getWaymagcode());
		if (wayVO.getBuzarea() != null) {
			cooperatorvo.setArea(new Double(wayVO.getBuzarea().longValue()));
		}
		cooperatorvo.setMemo(wayVO.getFunction());
		cooperatorvo.setState(wayVO.getWaystate());
		cooperatorvo.setOldcoopera(wayVO.getBusicode());
		cooperatorvo.setSmsmobileno(wayVO.getBuzphoneno());
		cooperatorvo.setServman(wayVO.getPrincipal());
		cooperatorvo.setCooperadel(wayVO.getPrincipal());
		cooperatorvo.setConntel(wayVO.getPrincipaltel());
		cooperatorvo.setUsremail(wayVO.getPrincipalemail());
		cooperatorvo.setConnpers(wayVO.getPrincipal());
		cooperatorvo.setBusconntel(wayVO.getPrincipaltel());
		cooperatorvo.setStarttime(wayVO.getBegintime());
		if(null==wayVO.getLicvalidate()||"".equals(wayVO.getLicvalidate())){
			cooperatorvo.setLicvalidate(PublicUtils.UtilStrToDate("1900-01-01 00:00:00"));
		}
		if(null==wayVO.getLicenceno()||"".equals(wayVO.getLicenceno())){
			cooperatorvo.setLicenceid("-1");
		}else{
			cooperatorvo.setLicenceid(wayVO.getLicenceno());
		}
		cooperatorvo.setDistrictid(user.getCityid());  //Ӫҵ������д�й�˾��־
	}

	/**
	 * employeeID,NETPASS��EmployeeControlBean����
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	private EmployeeVO setEmployVO(AGWayVO vo) throws Exception {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setWayid(vo.getWayid());
		employeeVO.setWaytype("AG");
		employeeVO.setCityid(vo.getCityid());
		employeeVO.setCountyid(vo.getCountyid());
		employeeVO.setSvccode(vo.getSvccode());
		employeeVO.setEmpstatus(new Short((short) 0));
		employeeVO.setOfficetel(vo.getOfficetel());
		employeeVO.setIsnet(new Short((short) 1));
		employeeVO.setIsopen(new Short((short) 0));
		return employeeVO;
	}

	private NetsynVO setNetsynVO(String officetel, Short opract, String oprcode)
			throws Exception {
		NetsynVO netsynVO = new NetsynVO();
		netsynVO.setMobile(officetel);
		netsynVO.setOpract(opract);
		netsynVO.setOprcode(oprcode);
		return netsynVO;
	}

	public WayVO doFindByPk(Serializable pk, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);

		return (WayVO) dao.findByPk(pk);
	}

	/**
	 * �������������Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgcreate(WayVO newVO, CooperatorVO cooperatorvo,
			WaycompactVO waycompactvo, WayaccountVO wayaccountvo,
			BchcontactVO bchcontactvo, User user) throws Exception {
		boolean falg = false;
		try {

			// ����VO
			AuditUtils utils = new AuditUtils();
			String[] waypk = { "wayid" };
			String[] newwayfield = { "address" };

			String[] cooperaupk = { "cooperauid" };
			String[] cooperatorfield = { "sendaddr" };

			String[] wayaccountpk = { "accid", "wayid" };
			String[] wayaccountfield = { "acctno", "bankname" };

			newVO = (WayVO) utils.doSaveAudit(newVO, "CH_PW_WAY",
					"CH_PW_STRBWAY", newwayfield, waypk, "CH_PW_SOTYWAY_AUDIT",
					user);
			cooperatorvo = (CooperatorVO) utils.doSaveAudit(cooperatorvo,
					"CH_DST_COOPERATOR", "CH_PW_STRBWAY", cooperatorfield,
					cooperaupk, "CH_PW_SOTYWAY_AUDIT", user);
			wayaccountvo = (WayaccountVO) utils.doSaveAudit(wayaccountvo,
					"CH_PW_WAYACCOUNT", "CH_PW_STRBWAY", wayaccountfield,
					wayaccountpk, "CH_PW_SOTYWAY_AUDIT", user);
			WayControl control = (WayControl) ControlFactory
					.build(WayControlBean.class);
			WayaccountControl wayaccountcontrol = (WayaccountControl) ControlFactory
					.build(WayaccountControlBean.class);
			WaycompactControl waycompactcontrol = (WaycompactControl) ControlFactory
					.build(WaycompactControlBean.class);
			BchcontactControl bchcontactcontrol = (BchcontactControl) ControlFactory
					.build(BchcontactControlBean.class);

			CooperatorDAO cooperatordao = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);

			control.doCreate(newVO, user);

			waycompactcontrol.doCreate(waycompactvo, user);
			wayaccountcontrol.doCreate(wayaccountvo, user);
			bchcontactcontrol.doCreate(bchcontactvo, user);
			cooperatordao.create(cooperatorvo);
			falg = true;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}

		return falg;
	}

	/**
	 * �޸����������Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgupdate(WayVO oldVO, WayVO newVO,
			CooperatorVO cooperatorvo, WaycompactVO waycompactvo,
			WayaccountVO wayaccountvo, BchcontactVO bchcontactvo,
			boolean upperwayfalg, User user) throws Exception {
		boolean falg = false;
		try {
			// ����VO
			AuditUtils utils = new AuditUtils();
			String[] waypk = { "wayid" };
			String[] newwayfield = { "address" };

			String[] cooperaupk = { "cooperauid" };
			String[] cooperatorfield = { "sendaddr" };

			String[] wayaccountpk = { "accid", "wayid" };
			String[] wayaccountfield = { "acctno", "bankname" };

			// oldVO = (WayVO)utils.doUpdateValue(oldVO, "CH_PW_WAY",
			// "CH_PW_STRBWAY",oldwayfield,waypk, "CH_PW_SOTYWAY_AUDIT",user);
			newVO = (WayVO) utils.doUpdateValue(newVO, "CH_PW_WAY",
					"CH_PW_STRBWAY", newwayfield, waypk, "CH_PW_SOTYWAY_AUDIT",
					user);
			cooperatorvo = (CooperatorVO) utils.doUpdateValue(cooperatorvo,
					"CH_DST_COOPERATOR", "CH_PW_STRBWAY", cooperatorfield,
					cooperaupk, "CH_PW_SOTYWAY_AUDIT", user);
			wayaccountvo = (WayaccountVO) utils.doUpdateValue(wayaccountvo,
					"CH_PW_WAYACCOUNT", "CH_PW_STRBWAY", wayaccountfield,
					wayaccountpk, "CH_PW_SOTYWAY_AUDIT", user);

			WayControl control = (WayControl) ControlFactory
					.build(WayControlBean.class);
			WayaccountControl wayaccountcontrol = (WayaccountControl) ControlFactory
					.build(WayaccountControlBean.class);
			WaycompactControl waycompactcontrol = (WaycompactControl) ControlFactory
					.build(WaycompactControlBean.class);
			BchcontactControl bchcontactcontrol = (BchcontactControl) ControlFactory
					.build(BchcontactControlBean.class);

			CooperatorDAO cooperatordao = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			if (upperwayfalg) {
				control.doRemove(oldVO, user);
				control.doCreate(newVO, user);
			} else {
				control.doUpdate(newVO, user);
			}

			CooperatorVO cooperatorvo2 = (CooperatorVO) cooperatordao
					.findByPk(cooperatorvo.getCooperauid());
			if (cooperatorvo2 == null) {
				cooperatordao.create(cooperatorvo);
			} else {
				BeanUtils.copyProperties(cooperatorvo2, cooperatorvo);
				cooperatordao.update(cooperatorvo2);
			}
			WaycompactVO waycompactvo2 = (WaycompactVO) waycompactcontrol
					.doFindByPk(waycompactvo.getWayid(), user);
			if (waycompactvo2 == null) {
				waycompactcontrol.doCreate(waycompactvo, user);
			} else {
				BeanUtils.copyProperties(waycompactvo2, waycompactvo);
				waycompactcontrol.doUpdate(waycompactvo2, user);
			}
			WayaccountVO pkVO = new WayaccountVO(); 
			pkVO.setAccid(wayaccountvo.getAccid());
			pkVO.setWayid(wayaccountvo.getWayid());
			WayaccountVO wayaccountvo2 = (WayaccountVO) wayaccountcontrol
					.doFindByPk(pkVO, user);
			if (wayaccountvo2 == null) {
				wayaccountcontrol.doCreate(wayaccountvo, user);
			} else {
				BeanUtils.copyProperties(wayaccountvo2, wayaccountvo);
				wayaccountcontrol.doUpdate(wayaccountvo2, user);
			}
			BchcontactVO bchcontactvo2 = (BchcontactVO) bchcontactcontrol
					.doFindByPk(bchcontactvo.getWayid(), user);
			if (bchcontactvo2 == null) {
				bchcontactcontrol.doCreate(bchcontactvo, user);
			} else {
				BeanUtils.copyProperties(bchcontactvo2, bchcontactvo);
				bchcontactcontrol.doUpdate(bchcontactvo2, user);
			}
			falg = true;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}

		return falg;
	}
/**
 * ���Ƿ��ж����˶���¼Ҫ����,�����һ�������򷵻���.
 */
	public boolean doHasRecords(String officeTel, User user) throws Exception {
		NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
		NetsynListVO listvo = new NetsynListVO();
		listvo.set_se_mobile(officeTel);
		listvo.set_ne_opract("1");
		if (dao.query(listvo).getRowCount() <= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	private void sendMessage(AGWayVO vo, User user) throws Exception{
		try {
			int len = vo.getWayid().length() + vo.getWayname().length()
					+ smsMsgPatternLen;
			String msg = vo.getSmsMsg();
			String chgInfo = msg;
			if (msg != null) {
				if ((msg.length() + len) > 134) {
					int legalLen = 134 - len;
					chgInfo = msg.substring(0, legalLen - 17)
							+ "...������������������������ϵ��";
				}
			}
			msg = MessageFormat.format(smsMsgPattern, new Object[] {
					vo.getWayid(), vo.getWayname(), chgInfo });
			if (msg.length() > 67) {
				insertMessage(msg.substring(0, 67), vo,user);
				insertMessage(msg.substring(67), vo,user);
			} else {
				insertMessage(msg.substring(0), vo,user);
			}
		} catch (Exception e) {
			throw new Exception("��ɼ�ƽ̨�ǼǱ��֪ͨ���ų���������룺" + e.getMessage());
		}
		
	}
	
	private void insertMessage(String message, AGWayVO vo,User user) throws Exception{
		WaittmpDAO dao = (WaittmpDAO)DAOFactory.build(WaittmpDAO.class, user);
		WaittmpVO msgVO = new WaittmpVO();
		msgVO.setCreattime(new Timestamp(new Date().getTime()));
		msgVO.setDealtime(new Timestamp(new Date().getTime()));
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) + 1);
		msgVO.setDeadtime(new Timestamp(now.getTimeInMillis()));
		msgVO.setSmtype(new Short("101"));
		msgVO.setMessage(message);
		msgVO.setRecno(vo.getOfficetel());
		msgVO.setSmprior(new Short("100"));
		msgVO.setSmstatu(new Short("0"));
		msgVO.setLimitflag(new Short("1"));
		msgVO.setSndtime("0800-2200");
		msgVO.setMaxtimes(new Short("2"));
		msgVO.setHavetimes(new Short("0"));
		dao.create(msgVO);
	}
}
