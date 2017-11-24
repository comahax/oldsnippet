/**
 * auto-generated code
 * Wed Jul 08 11:37:50 CST 2009
 */
package com.gmcc.pboss.control.channel.way;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;

import com.gmcc.pboss.business.channel.adimarea.AdimareaVO;
import com.gmcc.pboss.business.channel.areacenter.AreacenterVO;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.changelog.ChangelogVO;
import com.gmcc.pboss.business.channel.citycompany.CitycompanyVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDAO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.common.AuditUtils;
import com.gmcc.pboss.business.channel.cooperator.CooperatorDAO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDAO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.microarea.MicroareaDAO;
import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.business.channel.netsyn.NetsynVO;
import com.gmcc.pboss.business.channel.servcent.ServcentDAO;
import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDAO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyDBParam;
import com.gmcc.pboss.business.channel.wayhierarchy.WayhierarchyVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.business.channel.waysyn.WaysynVO;
import com.gmcc.pboss.business.channel.waytype.WaytypeDAO;
import com.gmcc.pboss.business.channel.waytype.WaytypeDBParam;
import com.gmcc.pboss.common.sms.ComOrderSms;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.changelog.Changelog;
import com.gmcc.pboss.control.channel.changelog.ChangelogBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.netsyn.Netsyn;
import com.gmcc.pboss.control.channel.netsyn.NetsynBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.control.channel.wayhierarchy.Wayhierarchy;
import com.gmcc.pboss.control.channel.wayhierarchy.WayhierarchyBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.gmcc.pboss.control.channel.waysyn.Waysyn;
import com.gmcc.pboss.control.channel.waysyn.WaysynBO;
import com.gmcc.pboss.web.common.webservice.CRMService;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.filter.PermissionChecker;

/**
 * <p>Title: WayBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
 * @ejb.bean 
 *           local-jndi-name="com/sunrise/jop/business/channel/way/control/WayBO"
 *           name="Way" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class WayBO extends AbstractControlBean implements Way {

	private static Log log = LogFactory.getLog(WayBO.class);

	public Object doFindByPk3(Serializable pk) throws Exception {
		// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
		// "DB_BOSSCOMMON");
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.findByPk(pk);
	}

	public WayVO doCreate(WayVO vo) throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
			// "DB_BOSSCOMMON");
			if (vo.getUpperwayid() != null) {
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (null == upVO || upVO.getWaylevel() == null) {
					throw new Exception("�ϼ����� " + vo.getWayid()
							+ " ȱ�� �����������Ƚ���������ȷ��");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
			}
			// TODO set the pk */
			return (WayVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayVO doCreate(WayVO vo, DBAccessUser user) throws Exception {
		try {
			// TODO set the pk */
			// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
			// "DB_BOSSCOMMON");
			// WayDAO dao2 = (WayDAO) DAOFactory.build(WayDAO.class, user);
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			if (null == vo.getCreatetime()) {
				vo.setCreatetime(new Date());
			}
			if (dao.findByPk(vo.getWayid()) != null) {
				throw new Exception("�Ѿ����ڸ���������:" + vo.getWayid());
			}
			this.doCheckwayVO(vo, "0", user);// ��ӹ��˼��
			// �޸�waylevel waylevel= �ϼ�����waylevel + 1
			if (vo.getUpperwayid() != null) {
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (null == upVO || null == upVO.getWaylevel()) {
					throw new Exception(vo.getWayid() + "���ϼ����� "
							+ vo.getUpperwayid() + " ȱ�� ����������߲����ڣ� ���Ƚ���������ȷ��");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
			}
			WayVO wayVO = (WayVO) dao.create(vo);
			if (log.isInfoEnabled())
				log.info("create way wayid:" + wayVO.getWayid());

			// ����������ι�ϵ��, ��Ӳ��ֲ�Ľڵ��ϵ.
			createWayHierarchy(wayVO, user);
			// this.doCreateWaySyn(vo, "create",new Short("0"),user);
			// this.doCreateWaySyn(vo, "create", new Short("2"), user);
			// 6��11��,���Ѹ�ӵ��У������޸���������ʱ������дch_pw_waysyn��
			if ("N".equals(getCRMCityPortState(user.getCityid()))) {
				this.doCreateWaySyn(vo, "update", new Short("0"), user);
				this.doCreateWaySyn(vo, "update", new Short("2"), user);
			}
			// д���Ǽ��䶯��־��
			// ����DIS��LOGS���͵ľ����Ǽ��䶯���ж�
			if ("DIS".equals(vo.getWaysubtype())
					|| "LOGS".equals(vo.getWaysubtype())) {

			} else {
				this.doCreateChangelog(vo, "create", null, vo.getStarlevel(),
						user);
			}

			return wayVO;
		} catch (Exception ex) {
			if (log.isInfoEnabled()) {
				log.info("create way failed, wayid:" + vo.getWayid(), ex);
			}
			throw new JOPException(ex.getMessage());

		}
	}

	public WayVO doUpdate(WayVO vo, DBAccessUser user) throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
			// "DB_BOSSCOMMON"); ��Ϊȡ��BOSS�˵�����
			if (vo.getWaystate().intValue() > 0) {
				this.doCheckwayVO(vo, "1", user);// ��ӹ��˼��
			}
			// dao.flushSession();
			// Short upperwaylevel = (Short) dao.getMaxid("wayid", vo
			// .getUpperwayid(), "waylevel");

			// vo.setWaylevel(new Short((short) (upperwaylevel.intValue() +
			// 1)));
			// WayVO tmpvo=(WayVO)BeanUtils.cloneBean(vo);
			/*
			 * dao.flushSession();
			 * 
			 * WayVO wayVO=(WayVO)dao.findByPk(vo.getWayid()); String
			 * upperwayid=wayVO.getUpperwayid(); BeanUtils.copyProperties(wayVO,
			 * vo); wayVO.setUpperwayid(upperwayid);//�ϼ������������޸�
			 */
			// ���¸�waylevel��ֵ����ֹҳ�洫������ֵ����
			if (vo.getUpperwayid() != null) {
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (null == upVO || upVO.getWaylevel() == null) {
					throw new Exception("�ϼ����� " + vo.getWayid()
							+ " ȱ�� �����������Ƚ���������ȷ��");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
			}
			// �����Ƿ��޸����ϼ�������������޸����¹�����ι�ϵ��¼
			WayVO oldVO = (WayVO) dao.findByPk(vo.getWayid());
			if (vo.getUpperwayid() != null
					&& !vo.getUpperwayid().equalsIgnoreCase(
							oldVO.getUpperwayid())) {
				if (dao.findByProperty("upperwayid", vo.getWayid()) != null) {
					throw new Exception("�޸�ʧ�ܣ��������޸��˹������ϼ���������������������");
				}
				// WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				// if (null == upVO || upVO.getWaylevel() == null) {
				// throw new Exception("�ϼ����� " + vo.getWayid()
				// + " ȱ�� �����������Ƚ���������ȷ��");
				// }
				// short ulevel = upVO.getWaylevel().shortValue();
				// vo.setWaylevel(new Short((short) (ulevel + 1)));
				removeWayHierarchy(vo, user);
				createWayHierarchy(vo, user);
			}
			if (!vo.getUpperwayid().equals(oldVO.getUpperwayid())
					|| !vo.getWayname().equals(oldVO.getWayname())) {
				if (!new AuditUtils().doCheckPre("CH_PW_WAY_UPDATE", user)) {
					throw new Exception("�ù���û���޸��������ƻ��޸��ϼ����������Ȩ��,����ϵ����Ա��Ȩ!");
				}
			}
			// �ж�������������DIS��LOGS���͵ľ�,�����Ǽ��䶯���ж�
			if ("DIS".equals(vo.getWaysubtype())
					|| "LOGS".equals(vo.getWaysubtype())) {
				// this.doCreateChangelog(vo, "update", oldVO.getStarlevel(),
				// vo.getStarlevel(), user);
			} else {
				// add by 20120210 liuchao
				// if(vo.getStarlevel()!=null&&oldVO.getStarlevel()!=null)����ж�,�����Խ���Ӫ��������ʱ
				if (vo.getStarlevel() != null && oldVO.getStarlevel() != null) {
					if (!vo.getStarlevel().equals(oldVO.getStarlevel())) {
						// ���Ȩ������
						Sysparam sysparam = (Sysparam) BOFactory.build(
								SysparamBO.class, user);
						String paramvalue = sysparam.doFindByID(new Long("72"),
								"channel");
						// ���paramvalue�鵽��¼����ֵΪ1������ΪҪ���Ȩ������
						boolean hasPermission = false;
						if ("1".equals(paramvalue)) {
							PermissionChecker checker = (PermissionChecker) InterfaceUtils
									.getInstance().createImplObject(
											PermissionChecker.class);
							hasPermission = checker.checkPermission(
									user.getOprcode(), "CH_PW_STARLEVEL");
							if (!hasPermission) {
								throw new Exception("�ù���û���޸������Ǽ���Ȩ��,����ϵ����Ա��Ȩ!");
							} else {
								// д���Ǽ��䶯��־��
								this.doCreateChangelog(vo, "update",
										oldVO.getStarlevel(),
										vo.getStarlevel(), user);
							}
						} else {
							// д���Ǽ��䶯��־��
							this.doCreateChangelog(vo, "update",
									oldVO.getStarlevel(), vo.getStarlevel(),
									user);
						}
					}
				}
				// �ж��Ǽ��ֶ���û���޸�
			}
			// this.doCreateWaySyn(vo, "update",new Short("0"),user);
			// this.doCreateWaySyn(vo, "update", new Short("2"), user);
			// 6��11��,���Ѹ�ӵ��У������޸���������ʱ������дch_pw_waysyn��
			if ("N".equals(getCRMCityPortState(user.getCityid()))) {
				this.doCreateWaySyn(vo, "update", new Short("0"), user);
				this.doCreateWaySyn(vo, "update", new Short("2"), user);
			}
			// Session session = SessionUtils.currentSession("DB_BOSSCOMMON");
			Session session = SessionUtils.currentSession("DB_COMMON");
			// �������ʱ��Ϊ�գ��������ݿ�ԭ��ֵ�趨��������ʱ��
			if (vo.getCreatetime() == null) {
				vo.setCreatetime(oldVO.getCreatetime());
			}
			// InputStream in =
			// net.gmcc.ngcrm.pboss.GDProdServ.class.getResourceAsStream("/coreconfiginfo.properties");
			// Properties p = new Properties();
			// p.load(in);
			// in.close();
			// String path = (String) p.get("way.update.test");
			// path="ONE";
			// if(("ONE").equals(path)){
			WayVO newVO = null;
			BeanUtils.copyProperties(oldVO, vo);
			newVO = (WayVO) dao.update(oldVO);
			// }else if(("TWO").equals(path)){
			// newVO = (WayVO) session.merge(vo);
			// //session.flush();
			// }else{
			// newVO = (WayVO) session.merge(vo);
			// session.flush();
			// }
			return newVO;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doDelete(WayVO vo, DBAccessUser user) throws Exception {
		try {
			Way control = (Way) BOFactory.build(WayBO.class, user);
			CooperatorDAO cooperatorDAO = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			Employee employeeControl = (Employee) BOFactory.build(
					EmployeeBO.class, user);
			Netsyn netsynControl = (Netsyn) BOFactory.build(NetsynBO.class,
					user);
			CooperatorVO cooperatorVO = (CooperatorVO) cooperatorDAO
					.findByPk(vo.getWayid());
			WayVO wayVO = (WayVO) control.doFindByPk(vo.getWayid());
			wayVO.setWaystate(new Short((short) 0));
			control.doUpdate(wayVO, user);
			if (cooperatorVO != null) {
				cooperatorVO.setState(new Short((short) 0));
				cooperatorDAO.update(cooperatorVO);
			}
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("3");// 1�޸�Ϊ3 2011.02.28
			listVO.set_ne_empstatus("0");
			Iterator iterator = employeeControl.doQuery(listVO).getDatas()
					.iterator();
			if (iterator.hasNext()) {
				EmployeeVO employeeVO = (EmployeeVO) iterator.next();
				if (employeeVO != null) {
					if (canSetservice(user)) {
						NetsynVO netsynVO = setNetsynVO(
								employeeVO.getOfficetel(),
								new Short((short) 1), user.getOprcode());
						netsynControl.doCreate(netsynVO);
					}
					employeeVO.setEmpstatus(new Short((short) 1));// �޸ĳ���ְ״̬
					// 0���ڸ� 1����ְ
					employeeControl.doUpdate(employeeVO, user);
				}
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/*
	 * public void doRemoveByVO(WayVO vo) throws Exception { try { WayDAO dao =
	 * (WayDAO) DAOFactory.build(WayDAO.class, user); dao.remove(vo); } catch
	 * (Exception ex) { throw new JOPException(ex); } }
	 * 
	 * public void doRemoveByPK(Serializable pk) throws Exception { try { WayDAO
	 * dao = (WayDAO) DAOFactory.build(WayDAO.class, user); dao.removeByPk(pk);
	 * } catch (Exception ex) { throw new JOPException(ex); } }
	 */

	public WayVO doUpdate(WayVO vo) throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
			// "DB_BOSSCOMMON");
			if (vo.getUpperwayid() != null) {
				if (dao.findByProperty("upperwayid", vo.getWayid()) != null) {
					throw new Exception("�޸�ʧ�ܣ��������޸��˹������ϼ���������������������");
				}
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (null == upVO || upVO.getWaylevel() == null) {
					throw new Exception("�ϼ����� " + vo.getWayid()
							+ " ȱ�� �����������Ƚ���������ȷ��");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
			}
			// �������ʱ��Ϊ�գ��������ݿ�ԭ��ֵ�趨��������ʱ��
			if (vo.getCreatetime() == null) {
				WayVO oldVO = (WayVO) dao.findByPk(vo.getWayid());
				vo.setCreatetime(oldVO.getCreatetime());
				BeanUtils.copyProperties(oldVO, vo);
				return (WayVO) dao.update(oldVO);
			}
			return (WayVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	public WayVO doFindByPk(Serializable pk) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return (WayVO) dao.findByPk(pk);
	}

	/**
	 * ��ѯ�Ƿ񱾵��е�¼������ͬ���е�����
	 */
	public WayVO doFindByPkAndCityid(Serializable pk) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO resVO = (WayVO) dao.findByPk(pk);
		if (resVO == null) {
			return null;
		} else {
			if (resVO.getCityid() == null) {
				throw new JOPException("���ݴ���:�ϼ������ĵ��й�˾�ֶβ���Ϊ��!");
			} else
				return user.getCityid().equals(resVO.getCityid()) ? resVO
						: null;
		}
	}

	// ��ѯbosscommon����Դ
	public WayVO doFindByPk2(Serializable pk) throws Exception {
		// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
		// "DB_BOSSCOMMON");
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return (WayVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayDBParam params) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.query(params);

		List list = dp.getDatas();
		if(list == null){
			return null;
		}

		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			// ���²�ѯ������Ϣ��Ȧ
			WaybusicircleDAO waybusicircleDAO = (WaybusicircleDAO) DAOFactory
					.build(WaybusicircleDAO.class, user);
			WaybusicircleDBParam waybusicircleVO = new WaybusicircleDBParam();
			waybusicircleVO.set_se_wayid(wayVO.getWayid());
			DataPackage WaybusicircleDP = waybusicircleDAO
					.query(waybusicircleVO);
			if (WaybusicircleDP != null && !"".equals(WaybusicircleDP)
					&& WaybusicircleDP.getDatas() != null
					&& !"".equals(WaybusicircleDP.getDatas())
					&& WaybusicircleDP.getDatas().size() > 0) {
				WaybusicircleVO wbVO = (WaybusicircleVO) WaybusicircleDP
						.getDatas().get(0);
				wayVO.setRewardkind("" + wbVO.getRewardkind());
				wayVO.setBuscno(wbVO.getBuscno());
				wayVO.setWayattr(wbVO.getWayattr());
				if (wbVO.getWaymod() != null && !"".equals(wbVO.getWaymod()))
					wayVO.setWaymod("" + wbVO.getWaymod());
			}
		}

		return dp;
	}

	/**
	 * ���ݵ���ID,�������Ͳ�ѯ������������Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryWayByCityidAndType(String cityid, String waytype)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.doQueryWayByCityidAndType(cityid, waytype);
	}

	public String doQueryWaybyCityid(String cityid) throws Exception {
		// TODO Auto-generated method stub
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO wayvo = dao.queryWaybyCityid(cityid);
		if (wayvo != null) {
			return wayvo.getWayid();
		}
		return null;
	}

	/**
	 * ȡ�����������Ӧ���������̵��������
	 */
	public WayapplyVO doGetageidt(String wayid, DBAccessUser user)
			throws Exception {
		WayapplyVO vo = new WayapplyVO();

		Way delegate = (Way) BOFactory.build(WayBO.class, user);
		Bchcontact bchcontactDelegate = (Bchcontact) BOFactory.build(
				BchcontactBO.class, user);
		Wayaccount wayaccountDelegate = (Wayaccount) BOFactory.build(
				WayaccountBO.class, user);
		Waycompact waycompactDelegate = (Waycompact) BOFactory.build(
				WaycompactBO.class, user);
		Cooperator cooperatorDelegate = (Cooperator) BOFactory.build(
				CooperatorBO.class, user);

		WayVO wayvo = delegate.doFindByPk(wayid);
		BchcontactVO bchcontactvo = bchcontactDelegate.doFindByPk(wayid);
		WayaccountVO volist = new WayaccountVO();
		volist.setAccid(1);
		volist.setWayid(wayid);
		WayaccountVO wayaccountvo = wayaccountDelegate.doFindByPk(volist);
		CooperatorVO cooperatorvo = cooperatorDelegate.doFindByPk(wayid);
		WaycompactVO waycompactvo = waycompactDelegate.doFindByPk(wayid);

		if (cooperatorvo != null) {
			BeanUtils.copyProperties(vo, cooperatorvo);
		}
		if (wayaccountvo != null) {
			BeanUtils.copyProperties(vo, wayaccountvo);
		}

		BeanUtils.copyProperties(vo, wayvo);

		if (bchcontactvo != null) {
			BeanUtils.copyProperties(vo, bchcontactvo);
		}
		if (waycompactvo != null) {
			BeanUtils.copyProperties(vo, waycompactvo);
		}

		return vo;
	}

	/**
	 * ȡ�����������Ӧ���������������
	 */
	public WayapplyVO doGetsaleeidt(String wayid, DBAccessUser user)
			throws Exception {
		WayapplyVO vo = new WayapplyVO();
		Date starttime = null;

		Way way = (Way) BOFactory.build(WayBO.class, user);
		Bchcontact bchcontact = (Bchcontact) BOFactory.build(
				BchcontactBO.class, user);
		Waycompact waycompact = (Waycompact) BOFactory.build(
				WaycompactBO.class, user);
		Wayaccount wayaccount = (Wayaccount) BOFactory.build(
				WayaccountBO.class, user);
		Cooperator cooperator = (Cooperator) BOFactory.build(
				CooperatorBO.class, user);
		Employee employee = (Employee) BOFactory.build(EmployeeBO.class, user);

		WayVO wayVO = way.doFindByPk(wayid);
		if (wayVO != null) {
			starttime = wayVO.getStarttime();
		}

		BchcontactVO bchcontactVO = bchcontact.doFindByPk(wayid);
		WaycompactVO waycompactVO = waycompact.doFindByPk(wayid);
		WayaccountVO wayaccountVO = new WayaccountVO();
		wayaccountVO.setWayid(wayid);
		if ("DIS".equals(wayVO.getWaysubtype())) {
			wayaccountVO.setAccid(new Integer(1));
		} else {
			wayaccountVO.setAccid(new Integer(0));
		}
		wayaccountVO = wayaccount.doFindByPk(wayaccountVO);
		CooperatorVO cooperatorVO = cooperator.doFindByPk(wayid);
		// ����ʡ��˾���Ա�
		Wayprovince wayprovince = (Wayprovince) BOFactory.build(
				WayprovinceBO.class, user);
		List wList = wayprovince.doQueryWpByWayid(wayid);
		if (wList != null && !"".equals(wList) && wList.size() > 0) {
			WayprovinceVO wVO = (WayprovinceVO) wList.get(0);
			BeanUtils.copyProperties(vo, wVO);
		}
		// ȡ���������������Ϣ
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_isnet("1");
		listVO.set_ne_empstatus("0");
		Iterator iterator = employee.doQuery(listVO).getDatas().iterator();
		if (iterator.hasNext()) {
			vo.setOfficetel(((EmployeeVO) iterator.next()).getOfficetel());
		}
		// ����������ϵ���ϱ���Ϣ
		if (bchcontactVO != null) {
			BeanUtils.copyProperties(vo, bchcontactVO);
			vo.setAddress(null);// ���������addressΪ׼.
		}
		BeanUtils.copyProperties(vo, wayVO);
		// ���ƺ�ͬ������Ϣ
		if (waycompactVO != null) {
			BeanUtils.copyProperties(vo, waycompactVO);
		}
		// ���������˻�������Ϣ
		if (wayaccountVO != null) {
			BeanUtils.copyProperties(vo, wayaccountVO);
		}
		// ���ƺ�����������Ϣ
		if (cooperatorVO != null) {
			BeanUtils.copyProperties(vo, cooperatorVO);
		}
		vo.setEndtime(waycompactVO.getEndtime());
		vo.setStarttime(starttime);
		// vo.setOldstate(wayVO.getWaystate());
		return vo;
	}

	/**
	 * ��ȡ�ϼ�����
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public WayVO doGetUpperWay(String wayid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO wayVO = (WayVO) dao.findByPk(wayid);
		if (wayVO == null || wayVO.getUpperwayid() == null)
			return null;
		else
			return (WayVO) dao.findByPk(wayVO.getUpperwayid());
	}

	private WayVO checkWayid(String wayid) throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid, null);
		return wayVO;
	}

	private void doCheckwayVO(WayVO vo, String oprtype, DBAccessUser user)
			throws Exception {
		String option = "";
		if ("0".equals(oprtype)) {
			option = "��������,";
		} else {
			option = "�޸Ĳ���,";
		}
		if ("true".equals(vo.getIsCooperator())) {
			// ��������������ʽ
		} else {
			if (!AuditUtils.doCheckWayidStyle(vo.getWayid())) {
				throw new Exception(option + "���������ʽ����ȷ,ֻ������ĸ+���ֻ���'-'");
			}
		}
		WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		Session session = SessionUtils.currentSession(waydao.getDbFlag());
		WayVO tmpwayvo = (WayVO) session.get(WayVO.class, vo.getWayid());
		session.evict(tmpwayvo);
		if (tmpwayvo != null
				&& StringUtils.isNotEmpty(vo.getLatitude())
				&& StringUtils.isNotEmpty(vo.getLongtitude())
				&& (!StringUtils.equals(vo.getLatitude(),
						tmpwayvo.getLatitude()) || !StringUtils.equals(
						vo.getLongtitude(), tmpwayvo.getLongtitude()))) {
			WayDBParam waylistvo = new WayDBParam();
			waylistvo.set_se_latitude(vo.getLatitude());
			waylistvo.set_se_longtitude(vo.getLongtitude());
			waylistvo.set_ne_waystate("1");
			List waylist = (ArrayList) waydao.query(waylistvo).getDatas();
			for (Iterator wayit = waylist.iterator(); wayit.hasNext();) {
				WayVO wayVO = (WayVO) wayit.next();
				if (!vo.getWayid().equals(wayVO.getWayid())) {
					throw new Exception(option + "����" + wayVO.getLatitude()
							+ ",γ��" + wayVO.getLongtitude()
							+ "���Ѿ�����.������ȷʵͬһ��γ��,�����޸�С������6λ��ʾ����");
				}
			}
		}

		if (vo.getWayid().equals(vo.getUpperwayid())) {
			throw new Exception(option + "�ϼ����������������������ͬ,�ϼ����������Ǹ���������");
		}
		if (!this.doCheckwayid(vo.getUpperwayid(), user)) {
			throw new Exception(option + "�ϼ���������:" + vo.getUpperwayid()
					+ "������,��ȷ�����������Ƿ���ȷ");
		}

		WayVO upperwayvo = (WayVO) waydao.findByPk(vo.getUpperwayid());

		if (upperwayvo.getWaystate().intValue() == -1
				|| upperwayvo.getWaystate().intValue() == 0) {
			throw new Exception(option + "�ϼ�����״̬ΪʧЧ����ɾ��,��ȷ��");
		}

		WaytypeDBParam typelistvo = new WaytypeDBParam();
		typelistvo.set_se_uppercode(vo.getWaytype());
		typelistvo.set_se_waytypecode(vo.getWaysubtype());
		WaytypeDAO waytypedao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class,
				user);
		if (waytypedao.query(typelistvo).getDatas().size() == 0
				&& (!"true".equals(vo.getIsCooperator()))
				&& !"KF".equalsIgnoreCase(vo.getWaytype())) {
			throw new Exception(option + "��������û�ж���������������:" + vo.getWaytype()
					+ "�������:" + vo.getWaysubtype());
		}
		// �ж�������������Ƿ���ڿ����
		if (StringUtils.isNotEmpty(vo.getAdacode())
				&& !"0".equals(vo.getAdacode())) {
			AdimareaVO adimareavo = new AdimareaVO();
			adimareavo.setAdacode(vo.getAdacode());
			if (!this.doQueryExsist(adimareavo, user)) {
				throw new Exception(option + "�����������:" + vo.getAdacode()
						+ "������");
			}
		}
		if (StringUtils.isNotEmpty(vo.getCenterid())) {
			AreacenterVO centvo = new AreacenterVO();
			centvo.setCenterid(vo.getCenterid());
			if (!this.doQueryExsist(centvo, user)) {
				throw new Exception(option + "�������ı���:" + vo.getCenterid()
						+ "������");
			}
		}
		if (StringUtils.isNotEmpty(vo.getCityid())) {
			CitycompanyVO cityvo = new CitycompanyVO();
			cityvo.setCitycompid(vo.getCityid());
			if (StringUtils.isNotEmpty(upperwayvo.getCityid())
					&& !"GDYD".equals(upperwayvo.getWayid())) { // ����ϼ������еĵ��й�˾��Ϊ�գ������ϼ��������ǹ㶫�ܹ�˾
				if (!StringUtils.equals(vo.getCityid(), upperwayvo.getCityid())) {
					throw new Exception(option + "���й�˾Ӧ�����ϼ������еĵ��й�˾����һ��");
				}
			}
			if (!this.doQueryExsist(cityvo, user)) {
				throw new Exception(option + "���й�˾��ʶ:" + vo.getCityid() + "������");
			}

		}

		if (StringUtils.isNotEmpty(vo.getCountyid())) {
			if (StringUtils.isEmpty(vo.getCityid())) {
				throw new Exception(option + "�ϼ����й�˾����Ϊ��");
			}
			CntycompanyDBParam cntlistvo = new CntycompanyDBParam();
			cntlistvo.set_se_citycompid(vo.getCityid());
			cntlistvo.set_se_countycompid(vo.getCountyid());
			CntycompanyDAO cntdao = (CntycompanyDAO) DAOFactory.build(
					CntycompanyDAO.class, user);

			if (StringUtils.isNotEmpty(upperwayvo.getCountyid())) {
				if (!StringUtils.equals(upperwayvo.getCountyid(),
						vo.getCountyid()))
					throw new Exception(option + "�ع�˾��ʶ:" + vo.getCountyid()
							+ "Ӧ�����ϼ������е��ع�˾" + upperwayvo.getCountyid()
							+ "����һ��");
			}
			if (cntdao.query(cntlistvo, cntdao.QUERY_TYPE_DATA).getDatas()
					.size() == 0) {
				throw new Exception(option + "�ع�˾��ʶ:" + vo.getCountyid()
						+ "������,�����ڸõ��й�˾");
			}
		}

		if (StringUtils.isNotEmpty(vo.getSvccode())) {
			if (StringUtils.isEmpty(vo.getCountyid())) {
				throw new Exception(option + "�ϼ��ع�˾��ʶ����Ϊ��");
			}
			ServcentDBParam svclistvo = new ServcentDBParam();
			svclistvo.set_se_countyid(vo.getCountyid());
			svclistvo.set_se_svccode(vo.getSvccode());
			ServcentDAO cntdao = (ServcentDAO) DAOFactory.build(
					ServcentDAO.class, user);
			if (cntdao.query(svclistvo, cntdao.QUERY_TYPE_DATA).getDatas()
					.size() == 0) {
				throw new Exception(option + "�����������ı���:" + vo.getSvccode()
						+ "�����ڣ������ڸ÷ֹ�˾" + vo.getCountyid());
			}
		}

		if (StringUtils.isNotEmpty(vo.getMareacode())) {
			if (StringUtils.isEmpty(vo.getSvccode())) {
				throw new Exception(option + "�����������ı��벻��Ϊ��");
			}
			MicroareaDBParam micrlistvo = new MicroareaDBParam();
			micrlistvo.set_se_macode(vo.getMareacode());
			micrlistvo.set_se_svccode(vo.getSvccode());
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(
					MicroareaDAO.class, user);
			if (dao.query(micrlistvo, dao.QUERY_TYPE_DATA).getDatas().size() == 0) {
				throw new Exception(option + "΢�������:" + vo.getMareacode()
						+ "�����ڣ������ڸ÷�����������" + vo.getSvccode());
			}
		}

		if (StringUtils.isNotEmpty(vo.getWaymagcode())
				&& !"true".equals(vo.getIsCooperator())) {
			EmployeeDBParam emlistvo = new EmployeeDBParam();
			emlistvo.set_se_employeeid(vo.getWaymagcode());
			emlistvo.set_ne_posittype("1");
			emlistvo.set_se_waytype("ET");
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			if (dao.query(emlistvo, dao.QUERY_TYPE_DATA).getDatas().size() == 0) {
				throw new Exception(option + "�����������Ա����:" + vo.getWaymagcode()
						+ "������");
			}
		}

		if (StringUtils.isNotEmpty(vo.getLogiscode())) {
			WayVO wayVO = new WayVO();
			wayVO.setWayid(vo.getLogiscode());
			if (!this.doQueryExsist(wayVO, user)) {
				throw new Exception(option + "������������������:" + vo.getLogiscode()
						+ "������");
			}
		}

		// if (StringUtils.isNotEmpty(vo.getChainhead())) {
		// if (!vo.getChainhead().equals("0000")){
		// WayDBParam waylistvo = new WayDBParam();
		// waylistvo.set_se_waytype("AG");
		// waylistvo.set_se_waysubtype("DIS");
		// waylistvo.set_ne_waystate("1");
		// waylistvo.set_se_wayid(vo.getChainhead());
		// if (waydao.query(waylistvo).getRowCount() <= 0) {
		// throw new Exception( "���������̱���:" + vo.getChainhead()
		// + "�����ڻ��߲���������Ӫ������");
		// }
		// }
		// }
		User cuser = (User) user;
		// �жϹ̶�����
		if (StringUtils.isNotEmpty(vo.getSvbrchcode())) {
			if (!CheckUtil.getInstance().checkDictitem("CH_SVBRCHTYPE",
					vo.getSvbrchcode(), cuser)) {
				throw new Exception(option + "��д�ķ��������Ϊ:" + vo.getSvbrchcode()
						+ "�̶�����������");
			}
		}
		if (vo.getAdtypecode() != null && vo.getAdtypecode().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_ADTYPE",
					vo.getAdtypecode().toString(), cuser)) {
				throw new Exception(option + "��д����������Ϊ:"
						+ vo.getAdtypecode().toString() + "�̶�����������");
			}
		}
		if (vo.getCatetype() != null && vo.getCatetype().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_CATETYPE",
					vo.getCatetype().toString(), cuser)) {
				throw new Exception(option + "��д����������Ϊ:"
						+ vo.getCatetype().toString() + "�̶�����������");
			}
		}
		if (vo.getFormtype() != null && vo.getFormtype().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_FORMTYPE",
					vo.getFormtype().toString(), cuser)) {
				throw new Exception(option + "��д��ҵ̬����Ϊ:"
						+ vo.getFormtype().toString() + "�̶�����������");
			}
		}
		if (vo.getMainlayer() != null && vo.getMainlayer().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_COPLAYER",
					vo.getMainlayer().toString(), cuser)) {
				throw new Exception(option + "��д�ĺ����㼶Ϊ:"
						+ vo.getMainlayer().toString() + "�̶�����������");
			}
		}
		if (vo.getCooperator() != null && vo.getCooperator().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_COOPERATOR",
					vo.getCooperator().toString(), cuser)) {
				throw new Exception(option + "��д�ĺ�����Ϊ:" + vo.getCooperator()
						+ "�̶�����������");
			}
		}
		if (StringUtils.isNotEmpty(vo.getCusttype())
				&& !"0".endsWith(vo.getCusttype())) {
			CustwaytypeVO custvo = new CustwaytypeVO();
			custvo.setCustwaytypecode(vo.getCusttype());
			custvo.setCitycompid(user.getCityid());
			if (!this.doQueryExsist(custvo, user)) {
				throw new Exception(option + "��������:" + vo.getCusttype() + "������");
			}
		}
		if (vo.getCitylevel() != null && vo.getCitylevel().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_CITYLEVEL",
					vo.getCitylevel().toString(), cuser)) {
				throw new Exception(option + "��д�ĳ��м���Ϊ:"
						+ vo.getCitylevel().toString() + "�̶�����������");
			}
		}
		if (StringUtils.isNotEmpty(vo.getBchlevel())
				&& !"0".equals(vo.getBchlevel())) {
			if (!CheckUtil.getInstance().checkDictitem("CH_BCHLEVEL",
					vo.getBchlevel(), cuser)) {
				throw new Exception(option + "��д�������ȼ�(�������������)Ϊ:"
						+ vo.getBchlevel() + "�̶�����������");
			}
		}
		if (vo.getWaystate() != null && vo.getWaystate().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_VALIDFLAG",
					vo.getWaystate().toString(), cuser)) {
				throw new Exception(option + "��д������״̬Ϊ:"
						+ vo.getWaystate().toString() + "�̶�����������");
			}
		}
		if (vo.getPrtsource() != null && vo.getPrtsource().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_PRTSOURCE",
					vo.getPrtsource().toString(), cuser)) {
				throw new Exception(option + "��д����ҵ��Դ����Ϊ:"
						+ vo.getPrtsource().toString() + "�̶�����������");
			}
		}
		if (vo.getIsconnected() != null && vo.getIsconnected().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_ISCONNECTED",
					vo.getIsconnected().toString(), cuser)) {
				throw new Exception(option + " ��д���Ƿ�����Ϊ:"
						+ vo.getIsconnected().toString() + "�̶�����������");
			}
		}
		if (vo.getConnecttype() != null && vo.getConnecttype().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_CONNECTTYPE",
					vo.getConnecttype().toString(), cuser)) {
				throw new Exception(option + "��д��������ʽΪ:"
						+ vo.getConnecttype().toString() + " �̶�����������");
			}
		}
		if (vo.getRunmode() != null && vo.getRunmode().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_RUNMODE",
					vo.getRunmode().toString(), cuser)) {
				throw new Exception(option + "��д�ľ�ӪģʽΪ:"
						+ vo.getRunmode().toString() + " �̶�����������");
			}
		}
		if (vo.getIscoreway() != null && vo.getIscoreway().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_ISCOREWAY",
					vo.getIscoreway().toString(), cuser)) {
				throw new Exception(option + "��д���Ƿ���������Ϊ:"
						+ vo.getIscoreway().toString() + " �̶�����������");
			}
		}
		if (vo.getStarlevel() != null && vo.getStarlevel().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_STARLEVEL",
					vo.getStarlevel().toString(), cuser)) {
				throw new Exception(option + "��д���Ǽ�Ϊ:"
						+ vo.getStarlevel().toString() + "�̶�����������");
			}
		}
		if (vo.getPt() != null && vo.getPt().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_PT",
					vo.getPt().toString(), cuser)) {
				throw new Exception(option + "��д��������Ϊ:" + vo.getPt().toString()
						+ "�̶�����������");
			}
		}
		if (vo.getSignstatus() != null && vo.getSignstatus().longValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_SIGNSTATUS",
					vo.getSignstatus().toString(), cuser)) {
				throw new Exception(option + "��д��ǩԼ״̬Ϊ:"
						+ vo.getSignstatus().toString() + "�̶�����������");
			}
		}
		if (vo.getIsstraitprd() != null && vo.getIsstraitprd().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_STRAITPRD",
					vo.getIsstraitprd().toString(), cuser)) {
				throw new Exception(option + "��д���Ƿ�ֱ��Ϊ:"
						+ vo.getIsstraitprd().toString() + "�̶�����������");
			}
		}
		if (vo.getTaxtype() != null && vo.getTaxtype().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_STTAXTYPE",
					vo.getTaxtype().toString(), cuser)) {
				throw new Exception(option + "��д�Ŀ�˰��ʽΪ:"
						+ vo.getTaxtype().toString() + "�̶�����������");
			}
		}
		if (vo.getBuztypecode() != null && vo.getBuztypecode().intValue() > 0) {
			if (!CheckUtil.getInstance().checkDictitem("CH_BUZTYPE",
					vo.getBuztypecode().toString(), cuser)) {
				throw new Exception(option + "��д����Ȧ����Ϊ:"
						+ vo.getBuztypecode().toString() + "�̶�����������");
			}
		}
		if (StringUtils.isNotEmpty(vo.getCreditlevel())) {
			if (!CheckUtil.getInstance().checkDictitem("CH_CREDITLEVEL",
					vo.getCreditlevel(), cuser)) {
				throw new Exception(option + "��д�����õȼ�Ϊ:" + vo.getCreditlevel()
						+ "�̶�����������");
			}
		}

	}

	/**
	 * ����һ���ض�����, ��ȡ�������й�˾��ֱ��(����)����
	 */
	public WayVO doGetCitycomDirectWayByWay(String wayid) throws Exception {
		WayVO wayVO = checkWayid(wayid);

		String cityid = wayVO.getCityid();
		if (cityid == null) {
			// throw new Exception("CMS-10121","��ǰ�����������й�˾,��������:" +
			// wayid);
			// �����䱾��
			return wayVO;
		}

		WayDBParam listVO = new WayDBParam();
		listVO.set_se_cityid(cityid);
		listVO.getQueryConditions().put("_ne_waylevel", new Short((short) 1));

		List list = (List) (doQuery(listVO).getDatas());
		if (list.size() > 0)
			return (WayVO) list.get(0);

		return null;
	}

	public boolean doGetwaytype(WayVO wayvo, Map waytypeMap, Map waysubtypeMap,
			String runmode) throws Exception {
		if (waytypeMap == null || waytypeMap.size() <= 0) {
			return true;
		}
		if (wayvo.getWaystate().intValue() != 1) {
			return false;
		}
		// String[] waytypes = StringUtils.split(waytype, "\\|");
		// Map<String,String> waytypeMap = new HashMap<String,String>();
		// for(String wt : waytypes) {
		// waytypeMap.put(wt, wt);
		// }
		// ��չwaytypeΪ����������͵����
		if (waytypeMap.containsKey(wayvo.getWaytype())) {
			if (waysubtypeMap == null || waysubtypeMap.size() <= 0) {
				return true;
			} else {
				// String[] waysubtypes = StringUtils.split(waysubtype,"\\|");
				// Map<String,String> waysubtypeMap = new
				// HashMap<String,String>();
				// for(String wst : waysubtypes) {
				// waysubtypeMap.put(wst, wst);
				// }
				if (waysubtypeMap.containsKey(wayvo.getWaysubtype())) {
					if (StringUtils.isEmpty(runmode)) {
						return true;
					} else {
						if (StringUtils.equals(wayvo.getRunmode().toString(),
								runmode)) {
							return true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	public boolean doCheckisNetWork(String wayid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.checkisNetWork(wayid);
	}

	public List doQueryNetWork(String wayid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryNetWork(wayid);
	}

	public WayVO doEdit(WayVO oldVO, WayVO newVO, DBAccessUser user)
			throws Exception {
		this.doRemove(oldVO, user);
		this.doCreate(newVO, user);
		return null;
	}

	public DataPackage doQueryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryUpperWaysAndMeByIdOrName(queryText, showDisabled);
	}

	public DataPackage doGetWaysOfHeadquarter() throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayDBParam wayListVO = new WayDBParam();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.getQueryConditions().put("_sn_centerid", "");
		wayListVO.getQueryConditions().put("_sn_cityid", "");
		wayListVO.getQueryConditions().put("_sn_countyid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage doGetWaysOfCountycom(String countyid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayDBParam wayListVO = new WayDBParam();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.getQueryConditions().put("_sn_centerid", "");
		wayListVO.getQueryConditions().put("_sn_cityid", "");
		wayListVO.set_se_countyid(countyid);
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage doGetWaysOfCitycom(String cityid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayDBParam wayListVO = new WayDBParam();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.getQueryConditions().put("_sn_centerid", "");
		wayListVO.set_se_cityid(cityid);
		wayListVO.getQueryConditions().put("_sn_countyid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage doGetWaysOfCenter(String centerid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayDBParam wayListVO = new WayDBParam();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.set_se_centerid(centerid);
		wayListVO.getQueryConditions().put("_sn_cityid", "");
		wayListVO.getQueryConditions().put("_sn_countyid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage doGetSubways(String wayid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayDBParam wayListVO = new WayDBParam();
		wayListVO.set_se_upperwayid(wayid);
		wayListVO.set_pagesize("0"); // ��pagesize��Ϊ0ʱ���������ݣ�����ҳ
		wayListVO.set_orderby("wayid"); // ��������ؼ���Ϊ����������
		return dao.query(wayListVO);
	}

	/**
	 * ��ѯ����������Ϣ����
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerysaleway(WayDBParam params, User user)
			throws Exception {
		WayDAO wdao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = new DataPackage();
		DataPackage dataPackage = wdao.querySaleway(params, user.getWayid());
		List list = (List) dataPackage.getDatas();
		Collection collection = new ArrayList();
		EmployeeDAO edao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		WaybusicircleDAO waybusicircleDAO = (WaybusicircleDAO) DAOFactory
				.build(WaybusicircleDAO.class, user);
		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			AGWayVO agway = new AGWayVO();
			BeanUtils.copyProperties(agway, wayVO);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("1");
			listVO.set_ne_empstatus("0");
			Iterator employee = edao.query(listVO).getDatas().iterator();
			if (employee.hasNext()) {
				EmployeeVO employeevo = (EmployeeVO) employee.next();
				agway.setIsopen(employeevo.getIsopen());
				agway.setOfficetel(employeevo.getOfficetel());
			}

			// ���²�ѯ������Ϣ��Ȧ
			WaybusicircleDBParam waybusicircleVO = new WaybusicircleDBParam();
			waybusicircleVO.set_se_wayid(wayVO.getWayid());
			DataPackage WaybusicircleDP = waybusicircleDAO
					.query(waybusicircleVO);
			if (WaybusicircleDP != null && !"".equals(WaybusicircleDP)
					&& WaybusicircleDP.getDatas() != null
					&& !"".equals(WaybusicircleDP.getDatas())
					&& WaybusicircleDP.getDatas().size() > 0) {
				WaybusicircleVO wbVO = (WaybusicircleVO) WaybusicircleDP
						.getDatas().get(0);
				agway.setRewardkind("" + wbVO.getRewardkind());
				agway.setBuscno(wbVO.getBuscno());
				agway.setWayattr(wbVO.getWayattr());
				if (wbVO.getWaymod() != null && !"".equals(wbVO.getWaymod()))
					agway.setWaymod("" + wbVO.getWaymod());
			}

			collection.add(agway);
		}
		dp.setDatas((List) collection);
		dp.setRowCount(dataPackage.getRowCount());
		dp.setPageNo(dataPackage.getPageNo());
		dp.setPageSize(dataPackage.getPageSize());
		return dp;
	}

	public DataPackage doQuerySubSaleway(WayDBParam params, User user)
			throws Exception {
		WayDAO wdao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		// DataPackage dp = new DataPackage();t
		String st = params.get_se_wayid();
		params.set_se_wayid("");
		DataPackage dataPackage = wdao.querySubSaleway(params, st);
		params.set_se_wayid(st);
		/*
		 * List list = (List) dataPackage.getDatas(); Collection collection =
		 * new ArrayList(); EmployeeDAO edao = (EmployeeDAO)
		 * DAOFactory.build(EmployeeDAO.class, user); for (int i = 0; i <
		 * list.size(); i++) { WayVO wayVO = (WayVO) list.get(i); AGWayVO agway
		 * = new AGWayVO(); BeanUtils.copyProperties(agway, wayVO);
		 * EmployeeDBParam listVO = new EmployeeDBParam();
		 * listVO.set_se_wayid(wayVO.getWayid()); listVO.set_ne_isnet("1");
		 * listVO.set_ne_empstatus("0"); Iterator employee =
		 * edao.query(listVO).getDatas().iterator(); if (employee.hasNext()) {
		 * EmployeeVO employeevo = (EmployeeVO) employee.next();
		 * agway.setIsopen(employeevo.getIsopen());
		 * agway.setOfficetel(employeevo.getOfficetel()); }
		 * collection.add(agway); } dp.setDatas((List) collection);
		 * dp.setRowCount(dataPackage.getRowCount());
		 * dp.setPageNo(dataPackage.getPageNo());
		 * dp.setPageSize(dataPackage.getPageSize());
		 */
		return dataPackage;
	}

	/**
	 * ��ѯ����������Ϣ����,�й���������ѯ�����������
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerysalewayWithOfficetel(WayDBParam params, User user)
			throws Exception {
		EmployeeDAO edao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_ne_isnet("1");
		listVO.set_ne_empstatus("0");
		listVO.set_se_officetel(params.get_se_officetel());
		DataPackage dp = edao.query(listVO);
		Iterator employee = dp.getDatas().iterator();
		WaybusicircleDAO waybusicircleDAO = (WaybusicircleDAO) DAOFactory
				.build(WaybusicircleDAO.class, user);
		if (employee.hasNext()) {
			EmployeeVO employeevo = (EmployeeVO) employee.next();
			WayDAO wdao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			if (employeevo.getWayid() != null) {
				WayVO vo = (WayVO) wdao.findByPk(employeevo.getWayid());
				AGWayVO agway = new AGWayVO();
				BeanUtils.copyProperties(agway, vo);
				agway.setOfficetel(employeevo.getOfficetel());
				agway.setIsopen(employeevo.getIsopen());
				dp = new DataPackage();
				List list = new ArrayList();

				// ���²�ѯ������Ϣ��Ȧ
				WaybusicircleDBParam waybusicircleVO = new WaybusicircleDBParam();
				waybusicircleVO.set_se_wayid(vo.getWayid());
				DataPackage WaybusicircleDP = waybusicircleDAO
						.query(waybusicircleVO);
				if (WaybusicircleDP != null && !"".equals(WaybusicircleDP)
						&& WaybusicircleDP.getDatas() != null
						&& !"".equals(WaybusicircleDP.getDatas())
						&& WaybusicircleDP.getDatas().size() > 0) {
					WaybusicircleVO wbVO = (WaybusicircleVO) WaybusicircleDP
							.getDatas().get(0);
					agway.setRewardkind("" + wbVO.getRewardkind());
					agway.setBuscno(wbVO.getBuscno());
					agway.setWayattr(wbVO.getWayattr());
					if (wbVO.getWaymod() != null
							&& !"".equals(wbVO.getWaymod()))
						agway.setWaymod("" + wbVO.getWaymod());
				}

				list.add(agway);
				dp.setDatas(list);
				dp.setRowCount(list.size());
				dp.setPageNo(1);
				dp.setPageSize(1);
			}
		}
		return dp;
	}

	/**
	 * ��ѯ����������
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryLogsway(WayDBParam params, User user)
			throws Exception {
		WayDAO wdao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = new DataPackage();
		DataPackage dataPackage = wdao.queryByOprcode(params, user.getWayid());
		List list = (List) dataPackage.getDatas();
		Collection collection = new ArrayList();
		EmployeeDAO edao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			AGWayVO agway = new AGWayVO();
			BeanUtils.copyProperties(agway, wayVO);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("3");
			listVO.set_ne_empstatus("0");
			Iterator employee = edao.query(listVO).getDatas().iterator();
			if (employee.hasNext()) {
				EmployeeVO employeevo = (EmployeeVO) employee.next();
				agway.setOfficetel(employeevo.getOfficetel());
			}
			collection.add(agway);
		}
		dp.setDatas((List) collection);
		dp.setRowCount(dataPackage.getRowCount());
		dp.setPageNo(dataPackage.getPageNo());
		dp.setPageSize(dataPackage.getPageSize());
		return dp;
	}

	/**
	 * �߼�ɾ��������״̬��Ϊ -1
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void doRemove(WayVO vo, DBAccessUser user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
		// "DB_BOSSCOMMON");
		vo.setWaystate(new Short("0"));
		// this.doCreateWaySyn(vo, "update",new Short("0"),user);
		// this.doCreateWaySyn(vo, "update", new Short("2"), user);
		// 6��11��,���Ѹ�ӵ��У������޸���������ʱ������дch_pw_waysyn��
		if ("N".equals(getCRMCityPortState(user.getCityid()))) {
			this.doCreateWaySyn(vo, "update", new Short("0"), user);
			this.doCreateWaySyn(vo, "update", new Short("2"), user);
		}
		dao.update(vo);
	}

	public void doCreateWaySyn(WayVO vo, String flag, Short Opract,
			DBAccessUser user) throws Exception {
		WaysynVO synVO = new WaysynVO();
		synVO.setOpract(Opract);
		synVO.setOprtype(flag);
		synVO.setOprcode(user.getOprcode());
		synVO.setOprtime(new Date(System.currentTimeMillis()));
		synVO.setWayid(vo.getWayid());
		synVO.setWayname(vo.getWayname());
		synVO.setUpperwayid(vo.getUpperwayid());
		synVO.setCityid(user.getCityid());
		synVO.setWaytype(vo.getWaytype());
		synVO.setWaystate(vo.getWaystate());
		Waysyn waysyn = (Waysyn) BOFactory.build(WaysynBO.class, user);
		waysyn.doCreate(synVO);
	}

	// public void doCreateChangelog(WayVO vo, String oprtype, String
	// oldstarlevel, String newstarlevel, DBAccessUser user)
	public void doCreateChangelog(WayVO vo, String oprtype, Long oldstarlevel,
			Long newstarlevel, DBAccessUser user) throws Exception {
		Changelog changelog = (Changelog) BOFactory.build(ChangelogBO.class,
				user);
		ChangelogVO changelogvo = new ChangelogVO();
		changelogvo.setOptime(new Date());
		changelogvo.setOprcode(user.getOprcode());
		changelogvo.setOprtype(oprtype);
		changelogvo.setWayid(vo.getWayid());
		changelogvo.setChangetype(Short.valueOf("1"));
		if (oldstarlevel != null) {
			changelogvo.setOldvalue(oldstarlevel.toString());
		}
		if (newstarlevel != null) {
			changelogvo.setNowvalue(newstarlevel.toString());
		}
		// changelogvo.setNowvalue(newstarlevel);
		changelog.doCreate(changelogvo);
	}

	/*
	 * ��Ͻ�����ѯ
	 */
	public DataPackage doQueryEmployee(WayDBParam params, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		params.getQueryConditions().put("basewayid", user.getWayid());
		return dao.queryByNamedSqlQuery("boss.cms.querySvwayinfo", params);
	}

	/**
	 * ���ݲ���Ա���ڵ�������ѯ�����������������¼
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByOprcode(WayDBParam params, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.queryByOprcode(params, user.getWayid());
		return dp;
	}

	private boolean doCheckwayid(String upperwayid, DBAccessUser user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		Object object = dao.findByPk(upperwayid);
		if (object == null) {
			return false;
		}
		return true;
	}

	// =========================================================================================================================
	// �����̵���
	public void doLogiswayImport(String[] items) throws Exception {
		WayVO wayVO = new WayVO();

		WayVO wayVO1 = new WayVO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {

			// �������������Ϣ
			wayVO.setWayid(items[0]);
			wayVO1 = this.doFindByPk(wayVO.getWayid());
			if (wayVO1 == null) {
				// ����
				wayVO.setWayname(items[1]);
				wayVO.setUpperwayid(items[2]);
				wayVO.setCooperator("".equals(items[3].trim()) ? null
						: new Short(items[3]));
				if (wayVO.getCityid() == null) {
					WayVO uppvo = this.doFindByPk(wayVO.getUpperwayid());
					if (uppvo == null) {
						throw new Exception("�ϼ�����������" + wayVO.getUpperwayid());
					} else if (uppvo.getCityid() != null) {
						wayVO.setCityid(uppvo.getCityid());
					} else if (uppvo.getCityid() == null) {
						throw new Exception("�ϼ�����" + wayVO.getUpperwayid()
								+ "�ĵ��б�־�������벹������");
					}
				} else {
					wayVO.setCityid(items[4]);
				}
				wayVO.setCountyid(items[5]);
				wayVO.setSvccode(items[6]);
				wayVO.setMiscode(items[7]);
				wayVO.setAdacode(items[8]);
				wayVO.setLongtitude(items[9]);
				wayVO.setLatitude(items[10]);
				wayVO.setAddress(items[11]);
				wayVO.setWaytype("AG");
				wayVO.setWaysubtype("LOGS");
				wayVO.setWaystate(new Short("1"));
				// this.doCreate(wayVO);
				// û������־,��Ϊ��������������־�ķ���
				// this.doCreate(wayVO, user);
				Way way = (Way) BOFactory.build(WayBO.class, user);
				way.doCreate(wayVO, user);
			} else {
				BeanUtils.copyProperties(wayVO, wayVO1);
				if (items[1] == null || "".equals(items[1])) {
					wayVO.setWayname(wayVO1.getWayname());
				} else if ("null".equals(items[1]) || "��".equals(items[1])) {
					throw new Exception("�������Ʋ����޸�Ϊ��!");
				} else
					wayVO.setWayname(items[1]);
				if (items[2] == null || "".equals(items[2])) {
					wayVO.setUpperwayid(wayVO1.getUpperwayid());
				} else if ("null".equals(items[2]) || "��".equals(items[2])) {
					throw new Exception("�ϼ��������벻���޸�Ϊ��!");
				} else
					wayVO.setUpperwayid(items[2]);
				if (items[3] == null || "".equals(items[3])) {
					wayVO.setCooperator(wayVO1.getCooperator());
				} else if ("null".equals(items[3]) || "��".equals(items[3])) {
					wayVO.setCooperator(null);
				} else
					wayVO.setCooperator(new Short(items[3]));
				if (items[4] == null || "".equals(items[4])) {
					wayVO.setCityid(wayVO1.getCityid());
				} else if ("null".equals(items[4]) || "��".equals(items[4])) {
					wayVO.setCityid(null);
				} else
					wayVO.setCityid(items[4]);
				if (items[5] == null || "".equals(items[5])) {
					wayVO.setCountyid(wayVO1.getCountyid());
				} else if ("null".equals(items[5]) || "��".equals(items[5])) {
					wayVO.setCountyid(null);
				} else
					wayVO.setCountyid(items[5]);
				if (items[6] == null || "".equals(items[6])) {
					wayVO.setSvccode(wayVO1.getSvccode());
				} else if ("null".equals(items[6]) || "��".equals(items[6])) {
					wayVO.setSvccode(null);
				} else
					wayVO.setSvccode(items[6]);
				if (items[7] == null || "".equals(items[7])) {
					wayVO.setMiscode(wayVO1.getMiscode());
				} else if ("null".equals(items[7]) || "��".equals(items[7])) {
					wayVO.setMiscode(null);
				} else
					wayVO.setMiscode(items[7]);
				if (items[8] == null || "".equals(items[8])) {
					wayVO.setAdacode(wayVO1.getAdacode());
				} else if ("null".equals(items[8]) || "��".equals(items[8])) {
					wayVO.setAdacode(null);
				} else
					wayVO.setAdacode(items[8]);
				if (items[9] == null || "".equals(items[9])) {
					wayVO.setLatitude(wayVO1.getLatitude());
				} else if ("null".equals(items[9]) || "��".equals(items[9])) {
					wayVO.setLatitude(null);
				} else
					wayVO.setLatitude(items[9]);
				if (items[10] == null || "".equals(items[10])) {
					wayVO.setLongtitude(wayVO1.getLongtitude());
				} else if ("null".equals(items[10]) || "��".equals(items[10])) {
					wayVO.setLongtitude(null);
				} else
					wayVO.setLongtitude(items[10]);
				if (items[11] == null || "".equals(items[11])) {
					wayVO.setAddress(wayVO1.getAddress());
				} else if ("null".equals(items[11]) || "��".equals(items[11])) {
					wayVO.setAddress(null);
				} else
					wayVO.setAddress(items[11]);

				BeanUtils.copyProperties(wayVO1, wayVO);
				// this.doUpdate(wayVO1);
				// û������־,��Ϊ��������������־�ķ���
				// this.doUpdate(wayVO1, user);
				Way way = (Way) BOFactory.build(WayBO.class, user);
				way.doUpdate(wayVO1, user);
			}

			Employee employeeControl = (Employee) BOFactory.build(
					EmployeeBO.class, user);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(items[0]);
			listVO.set_ne_isnet("3");
			listVO.set_ne_empstatus("0");
			Iterator iterator = employeeControl.doQuery(listVO).getDatas()
					.iterator();
			if (iterator.hasNext()) {
				EmployeeVO empvo = (EmployeeVO) iterator.next();
				empvo.setOfficetel(items[13]);
				empvo.setEmployeename(items[12]);
				employeeControl.doUpdate(empvo);
			} else {
				employeeControl.checkOfficeTel1(items[13], user);
				EmployeeVO empvo = new EmployeeVO();
				empvo.setEmployeeid(employeeControl.getEmployeeid(user));
				empvo.setEmployeename(items[12]);
				empvo.setWayid(items[0]);
				empvo.setEmpstatus(new Short("0"));
				empvo.setOfficetel(items[13]);
				empvo.setIsnet(new Short("3"));
				empvo.setIsopen(new Short("0"));
				empvo.setWaytype("AG");
				// empvo.setCityid(vo.getCityid());
				// empvo.setCountyid(vo.getCountyid());
				// empvo.setSvccode(StringUtils.isNotEmpty(vo.getSvccode())?vo.getSvccode():null);
				employeeControl.doCreate(empvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (null != e.getCause())
				throw new Exception(e.getCause());
			throw e;
		}
	}

	// ������Ӫ�����̵���
	public void doDiswayImport(String[] items) throws Exception {
		WayVO wayVO = new WayVO();
		Way way = (WayBO) BOFactory.build(WayBO.class, user);
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		CooperatorVO cooperatorvo = new CooperatorVO();// ������

		WayVO wayVO1 = new WayVO();
		BchcontactVO bchcontactVO1 = new BchcontactVO();
		WaycompactVO waycompactVO1 = new WaycompactVO();
		WayaccountVO wayaccountVO1 = new WayaccountVO();
		CooperatorVO cooperatorvo1 = new CooperatorVO();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {

			// �������������Ϣ
			wayVO.setWayid(items[0]);
			wayVO1 = this.doFindByPk(wayVO.getWayid());
			if (wayVO1 == null) {// ����
				wayVO.setWayid(items[0]);
				wayVO.setWayname(items[1]);
				wayVO.setUpperwayid(items[2]);
				wayVO.setCooperator("".equals(items[3]) ? null : new Short(
						items[3]));
				wayVO.setCityid(items[4]);
				wayVO.setCountyid(items[5]);
				wayVO.setSvccode(items[6]);
				wayVO.setMareacode(items[7]);

				wayVO.setWaystate("".equals(items[48]) ? null : new Short(
						items[48]));// ����״̬

				wayVO.setTaxtype("".equals(items[8]) ? null : new Short(
						items[8]));
				wayVO.setMainlayer("".equals(items[9]) ? null : new Short(
						items[9]));

				wayVO.setAdacode(items[10]);
				wayVO.setLongtitude(items[11]);
				wayVO.setLatitude(items[12]);
				wayVO.setAddress(items[13]);
				wayVO.setDistype("".equals(items[49]) ? null : new Short(
						items[49]));// ����������
				wayVO.setStarlevel("".equals(items[50]) ? null : new Long(
						items[50]));// �Ǽ�
				// ��������ʱ,�����ģʽ�ֶ�calcumodeΪ��,��Ĭ����0
				wayVO.setCalcumode(new Short("0"));
				wayVO.setWaytype("AG");
				wayVO.setWaysubtype("DIS");
				// ����������Ĭ��ֵΪ1�����ã�
				wayVO.setWaystate(new Short("1"));
				way.doCreate(wayVO, user);
			} else {
				BeanUtils.copyProperties(wayVO, wayVO1);
				if (items[1] == null || "".equals(items[1])) {
					wayVO.setWayname(wayVO1.getWayname());
				} else if ("null".equals(items[1]) || "��".equals(items[1])) {
					throw new Exception("�������Ʋ����޸�Ϊ��!");
				} else
					wayVO.setWayname(items[1]);
				if (items[2] == null || "".equals(items[2])) {
					wayVO.setUpperwayid(wayVO1.getUpperwayid());
				} else if ("null".equals(items[2]) || "��".equals(items[2])) {
					throw new Exception("�ϼ��������벻���޸�Ϊ��!");
				} else
					wayVO.setUpperwayid(items[2]);
				if (items[3] == null || "".equals(items[3])) {
					wayVO.setCooperator(wayVO1.getCooperator());
				} else if ("null".equals(items[3]) || "��".equals(items[3])) {
					wayVO.setCooperator(null);
				} else
					wayVO.setCooperator(new Short(items[3]));
				if (items[4] == null || "".equals(items[4])) {
					wayVO.setCityid(wayVO1.getCityid());
				} else if ("null".equals(items[4]) || "��".equals(items[4])) {
					wayVO.setCityid(null);
				} else
					wayVO.setCityid(items[4]);
				if (items[5] == null || "".equals(items[5])) {
					wayVO.setCountyid(wayVO1.getCountyid());
				} else if ("null".equals(items[5]) || "��".equals(items[5])) {
					wayVO.setCountyid(null);
				} else
					wayVO.setCountyid(items[5]);
				if (items[6] == null || "".equals(items[6])) {
					wayVO.setSvccode(wayVO1.getSvccode());
				} else if ("null".equals(items[6]) || "��".equals(items[6])) {
					wayVO.setSvccode(null);
				} else
					wayVO.setSvccode(items[6]);
				if (items[7] == null || "".equals(items[7])) {
					wayVO.setMareacode(wayVO1.getMareacode());
				} else if ("null".equals(items[7]) || "��".equals(items[7])) {
					wayVO.setMareacode(null);
				} else
					wayVO.setMareacode(items[7]);
				if (items[8] == null || "".equals(items[8])) {
					wayVO.setTaxtype(wayVO1.getTaxtype());
				} else if ("null".equals(items[8]) || "��".equals(items[8])) {
					wayVO.setTaxtype(null);
				} else
					wayVO.setTaxtype(new Short(items[8]));
				if (items[9] == null || "".equals(items[9])) {
					wayVO.setMainlayer(wayVO1.getMainlayer());
				} else if ("null".equals(items[9]) || "��".equals(items[9])) {
					wayVO.setMainlayer(null);
				} else
					wayVO.setMainlayer(new Short(items[9]));
				if (items[10] == null || "".equals(items[10])) {
					wayVO.setAdacode(wayVO1.getAdacode());
				} else if ("null".equals(items[10]) || "��".equals(items[10])) {
					wayVO.setAdacode(null);
				} else
					wayVO.setAdacode(items[10]);
				if (items[11] == null || "".equals(items[11])) {
					wayVO.setLatitude(wayVO1.getLatitude());
				} else if ("null".equals(items[11]) || "��".equals(items[11])) {
					wayVO.setLatitude(null);
				} else
					wayVO.setLatitude(items[11]);
				if (items[12] == null || "".equals(items[12])) {
					wayVO.setLongtitude(wayVO1.getLongtitude());
				} else if ("null".equals(items[12]) || "��".equals(items[12])) {
					wayVO.setLongtitude(null);
				} else
					wayVO.setLongtitude(items[12]);
				if (items[13] == null || "".equals(items[13])) {
					wayVO.setAddress(wayVO1.getAddress());
				} else if ("null".equals(items[13]) || "��".equals(items[13])) {
					wayVO.setAddress(null);
				} else
					wayVO.setAddress(items[13]);
				if (items[48] == null || "".equals(items[48])) {
					wayVO.setWaystate(wayVO1.getWaystate());
				} else if ("null".equals(items[48]) || "��".equals(items[48])) {
					throw new Exception("����״̬�����޸�Ϊ��,������0��1!");
				} else
					wayVO.setWaystate(new Short(items[48]));
				wayVO.setDistype("".equals(items[49]) ? null : new Short(
						items[49]));// ����������
				wayVO.setStarlevel("".equals(items[50]) ? null : new Long(
						items[50]));// �Ǽ�
				// �����޸�ʱ,����ԭ��ֵ
				wayVO.setCalcumode(wayVO1.getCalcumode());

				BeanUtils.copyProperties(wayVO1, wayVO);
				way.doUpdate(wayVO1);
			}

			// ��ͨ��Ϣ
			Bchcontact bchdelegate = (BchcontactBO) BOFactory.build(
					BchcontactBO.class, user);
			bchcontactVO.setWayid(items[0]);
			bchcontactVO1 = bchdelegate.doFindByPk(bchcontactVO.getWayid());
			if (bchcontactVO1 == null) { // ����
				bchcontactVO.setPrincipal(items[14]);
				bchcontactVO.setPrincipaltel(items[15]);
				bchcontactVO.setPrincipalemail(items[16]);
				bchcontactVO.setLinkman(items[17]);
				bchcontactVO.setLinkmantel(items[18]);
				bchcontactVO.setLinkmanemail(items[19]);
				bchcontactVO.setCompany(items[41]);
				if (!"".equals(items[42]))
					bchcontactVO.setCoplevel(new Short(items[42]));
				bchcontactVO.setBusnum(items[43]);
				if (!"".equals(items[44]))
					bchcontactVO.setCertitype(new Short(items[44]));
				bchcontactVO.setCertinum(items[45]);
				bchcontactVO.setRegadress(items[46]);
				if (!"".equals(items[47]))
					bchcontactVO.setRegcapital(new Long(items[47]));
				bchdelegate.doCreate(bchcontactVO);
			} else {
				BeanUtils.copyProperties(bchcontactVO, bchcontactVO1);
				if (items[14] == null || "".equals(items[14])) {
					bchcontactVO.setPrincipal(bchcontactVO1.getPrincipal());
				} else if ("null".equals(items[14]) || "��".equals(items[14])) {
					throw new Exception("���������������޸�Ϊ��!");
				} else
					bchcontactVO.setPrincipal(items[14]);
				if (items[15] == null || "".equals(items[15])) {
					bchcontactVO.setPrincipaltel(bchcontactVO1
							.getPrincipaltel());
				} else if ("null".equals(items[15]) || "��".equals(items[15])) {
					throw new Exception("��������ϵ�绰�����޸�Ϊ��!");
				} else
					bchcontactVO.setPrincipaltel(items[15]);
				if (items[16] == null || "".equals(items[16])) {
					bchcontactVO.setPrincipalemail(bchcontactVO1
							.getPrincipalemail());
				} else if ("null".equals(items[16]) || "��".equals(items[16])) {
					bchcontactVO.setPrincipalemail(null);
				} else
					bchcontactVO.setPrincipalemail(items[16]);
				if (items[17] == null || "".equals(items[17])) {
					bchcontactVO.setLinkman(bchcontactVO1.getLinkman());
				} else if ("null".equals(items[17]) || "��".equals(items[17])) {
					throw new Exception("ҵ����ϵ�����������޸�Ϊ��!");
				} else
					bchcontactVO.setLinkman(items[17]);
				if (items[18] == null || "".equals(items[18])) {
					bchcontactVO.setLinkmantel(bchcontactVO1.getLinkmantel());
				} else if ("null".equals(items[18]) || "��".equals(items[18])) {
					bchcontactVO.setLinkmantel(null);
				} else
					bchcontactVO.setLinkmantel(items[18]);
				if (items[19] == null || "".equals(items[19])) {
					bchcontactVO.setLinkmanemail(bchcontactVO1
							.getLinkmanemail());
				} else if ("null".equals(items[19]) || "��".equals(items[19])) {
					bchcontactVO.setLinkmanemail(null);
				} else
					bchcontactVO.setLinkmanemail(items[19]);

				if (items[41] == null || "".equals(items[41])) {
					bchcontactVO.setCompany((bchcontactVO1.getCompany()));
				} else if ("null".equals(items[41]) || "��".equals(items[41])) {
					bchcontactVO.setCompany(null);
				} else
					bchcontactVO.setLinkmanemail(items[41]);

				if (items[42] == null || "".equals(items[42])) {
					bchcontactVO.setCoplevel(bchcontactVO1.getCoplevel());
				} else if ("null".equals(items[42]) || "��".equals(items[42])) {
					bchcontactVO.setCoplevel(null);
				} else
					bchcontactVO.setCoplevel(new Short(items[42]));

				if (items[43] == null || "".equals(items[43])) {
					bchcontactVO.setBusnum(bchcontactVO1.getBusnum());
				} else if ("null".equals(items[43]) || "��".equals(items[43])) {
					bchcontactVO.setBusnum(null);
				} else
					bchcontactVO.setBusnum(items[43]);

				if (items[44] == null || "".equals(items[44])) {
					bchcontactVO.setCertitype(bchcontactVO1.getCertitype());
				} else if ("null".equals(items[44]) || "��".equals(items[44])) {
					bchcontactVO.setCertitype(null);
				} else
					bchcontactVO.setCertitype(new Short(items[44]));

				if (items[45] == null || "".equals(items[45])) {
					bchcontactVO.setCertinum(bchcontactVO1.getCertinum());
				} else if ("null".equals(items[45]) || "��".equals(items[45])) {
					bchcontactVO.setCertinum(null);
				} else
					bchcontactVO.setCertinum(items[45]);

				if (items[46] == null || "".equals(items[46])) {
					bchcontactVO.setRegadress(bchcontactVO1.getRegadress());
				} else if ("null".equals(items[46]) || "��".equals(items[46])) {
					bchcontactVO.setRegadress(null);
				} else
					bchcontactVO.setRegadress(items[46]);

				if (items[47] == null || "".equals(items[47])) {
					bchcontactVO.setRegcapital(bchcontactVO1.getRegcapital());
				} else if ("null".equals(items[47]) || "��".equals(items[47])) {
					bchcontactVO.setRegcapital(null);
				} else
					bchcontactVO.setRegcapital(new Long(items[47]));

				BeanUtils.copyProperties(bchcontactVO1, bchcontactVO);
				bchdelegate.doUpdate(bchcontactVO1);
			}

			// ��ͬ��Ϣ
			Waycompact comdelegate = (WaycompactBO) BOFactory.build(
					WaycompactBO.class, user);
			waycompactVO.setWayid(items[0]);
			waycompactVO1 = comdelegate.doFindByPk(waycompactVO.getWayid());
			if (waycompactVO1 == null) {
				// ��������ʱ,�����ģʽ�ֶ�calcumodeΪ��,��Ĭ����0
				// waycompactVO.setCalcumode(new Short("0"));
				waycompactVO.setCompactno(items[20]);
				waycompactVO.setCompactname(items[21]);
				waycompactVO.setBegintime("".equals(items[22]) ? null
						: new java.sql.Date(format.parse(items[22]).getTime()));
				waycompactVO.setSigntime("".equals(items[22]) ? null
						: new java.sql.Date(format.parse(items[22]).getTime()));
				waycompactVO.setEndtime("".equals(items[23]) ? null
						: new java.sql.Date(format.parse(items[23]).getTime()));
				waycompactVO.setPrincipal(items[24]);
				waycompactVO.setLicenceno(items[25]);
				waycompactVO.setRunareatype("".equals(items[26]) ? null
						: new Short(items[26]));
				waycompactVO.setCopbound(items[27]);
				waycompactVO.setBail("".equals(items[37]) ? null : new Double(
						items[37]));
				waycompactVO.setBegintime("".equals(items[39]) ? null
						: new java.sql.Date(format.parse(items[39]).getTime()));
				waycompactVO.setEndtime("".equals(items[40]) ? null
						: new java.sql.Date(format.parse(items[40]).getTime()));
				comdelegate.doCreate(waycompactVO);
			} else {
				BeanUtils.copyProperties(waycompactVO, waycompactVO1);
				// ��������ʱ,�����ģʽ�ֶ�calcumodeΪ��,��Ĭ����0
				// waycompactVO.setCalcumode(new Short("0"));
				if (items[20] == null || "".equals(items[20])) {
					waycompactVO.setCompactno(waycompactVO1.getCompactno());
				} else if ("null".equals(items[20]) || "��".equals(items[20])) {
					throw new Exception("��ͬ���벻���޸�Ϊ��!");
				} else
					waycompactVO.setCompactno(items[20]);
				if (items[21] == null || "".equals(items[21])) {
					waycompactVO.setCompactname(waycompactVO1.getCompactname());
				} else if ("null".equals(items[21]) || "��".equals(items[21])) {
					throw new Exception("��ͬ���Ʋ����޸�Ϊ��!");
				} else
					waycompactVO.setCompactname(items[21]);
				if (items[22] == null || "".equals(items[22])) {
					waycompactVO.setBegintime(waycompactVO1.getBegintime());
					waycompactVO.setSigntime(waycompactVO1.getSigntime());
				} else if ("null".equals(items[22]) || "��".equals(items[22])) {
					throw new Exception("ǩ���ͬʱ����ߺ�ͬ�����ղ����޸�Ϊ��!");
				} else {
					waycompactVO.setBegintime(new java.sql.Date(format.parse(
							items[22]).getTime()));
					waycompactVO.setSigntime(new java.sql.Date(format.parse(
							items[22]).getTime()));
				}

				if (items[23] == null || "".equals(items[23])) {
					waycompactVO.setEndtime(waycompactVO1.getEndtime());
				} else if ("null".equals(items[23]) || "��".equals(items[23])) {
					waycompactVO.setEndtime(null);
				} else
					waycompactVO.setEndtime(new java.sql.Date(format.parse(
							items[23]).getTime()));
				if (items[24] == null || "".equals(items[24])) {
					waycompactVO.setPrincipal(waycompactVO1.getPrincipal());
				} else if ("null".equals(items[24]) || "��".equals(items[24])) {
					waycompactVO.setPrincipal(null);
				} else
					waycompactVO.setPrincipal(items[24]);
				if (items[25] == null || "".equals(items[25])) {
					waycompactVO.setLicenceno(waycompactVO1.getLicenceno());
				} else if ("null".equals(items[25]) || "��".equals(items[25])) {
					waycompactVO.setLicenceno(null);
				} else
					waycompactVO.setLicenceno(items[25]);
				if (items[26] == null || "".equals(items[26])) {
					waycompactVO.setRunareatype(waycompactVO1.getRunareatype());
				} else if ("null".equals(items[26]) || "��".equals(items[26])) {
					waycompactVO.setRunareatype(null);
				} else
					waycompactVO.setRunareatype(new Short(items[26]));
				if (items[27] == null || "".equals(items[27])) {
					waycompactVO.setCopbound(waycompactVO1.getCopbound());
				} else if ("null".equals(items[27]) || "��".equals(items[27])) {
					waycompactVO.setCopbound(null);
				} else
					waycompactVO.setCopbound(items[27]);
				if (items[37] == null || "".equals(items[37])) {
					waycompactVO.setBail(waycompactVO1.getBail());
				} else if ("null".equals(items[37]) || "��".equals(items[37])) {
					waycompactVO.setBail(null);
				} else
					waycompactVO.setBail(new Double(items[37]));

				BeanUtils.copyProperties(waycompactVO1, waycompactVO);
				comdelegate.doUpdate(waycompactVO1);
			}

			// �ʻ���Ϣ
			Wayaccount accdelegate = (WayaccountBO) BOFactory.build(
					WayaccountBO.class, user);
			wayaccountVO.setWayid(items[0]);
			wayaccountVO.setAccid(new Integer(1));
			WayaccountDBParam acclistvo = new WayaccountDBParam();
			acclistvo.set_ne_accid("" + wayaccountVO.getAccid());
			acclistvo.set_se_wayid(wayaccountVO.getWayid());
			DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo);
			List acclist = (List) accdp.getDatas();
			if (acclist.size() == 0) {
				wayaccountVO.setAccid(new Integer(1));
				wayaccountVO.setBankname(items[29]);
				wayaccountVO.setAcctno(items[28]);
				wayaccountVO.setAcctname(items[30]);
				wayaccountVO.setAcctfid(items[31]);
				wayaccountVO.setAccttype(new Short("0"));
				wayaccountVO.setChargetype(new Short("0"));
				wayVO.setWaystate(new Short("1"));
				accdelegate.doCreate(wayaccountVO);
			} else {
				wayaccountVO1 = (WayaccountVO) acclist.get(0);
				BeanUtils.copyProperties(wayaccountVO, wayaccountVO1);

				if (items[28] == null || "".equals(items[28])) {
					wayaccountVO.setBankname(wayaccountVO.getBankname());
				} else if ("null".equals(items[28]) || "��".equals(items[28])) {
					throw new Exception("�����ʺŲ����޸�Ϊ��!");
				} else
					wayaccountVO.setBankname(items[28]);
				if (items[29] == null || "".equals(items[29])) {
					wayaccountVO.setBankname(wayaccountVO.getBankname());
				} else if ("null".equals(items[29]) || "��".equals(items[29])) {
					throw new Exception("�������в����޸�Ϊ��!");
				} else
					wayaccountVO.setBankname(items[29]);
				if (items[30] == null || "".equals(items[30])) {
					wayaccountVO.setAcctname(wayaccountVO.getAcctname());
				} else if ("null".equals(items[30]) || "��".equals(items[30])) {
					throw new Exception("�����ʺ����Ʋ����޸�Ϊ��!");
				} else
					wayaccountVO.setAcctname(items[30]);
				if (items[31] == null || "".equals(items[31])) {
					wayaccountVO.setAcctfid(wayaccountVO.getAcctfid());
				} else if ("null".equals(items[31]) || "��".equals(items[31])) {
					wayaccountVO.setAcctfid(null);
				} else
					wayaccountVO.setAcctfid(items[31]);

				BeanUtils.copyProperties(wayaccountVO1, wayaccountVO);
				accdelegate.doUpdate(wayaccountVO1);
			}

			BeanUtils.copyProperties(cooperatorvo, wayVO);
			BeanUtils.copyProperties(cooperatorvo, bchcontactVO);
			BeanUtils.copyProperties(cooperatorvo, waycompactVO);
			BeanUtils.copyProperties(cooperatorvo, wayaccountVO);

			Cooperator coopdelegate = (CooperatorBO) BOFactory.build(
					CooperatorBO.class, user);
			cooperatorvo.setCooperauid(wayVO.getWayid());
			cooperatorvo1 = coopdelegate.doFindByPk(cooperatorvo
					.getCooperauid());
			if (cooperatorvo1 == null) {
				cooperatorvo.setCooperaname(wayVO.getWayname());
				cooperatorvo.setCpabbrname(wayVO.getWayname());
				cooperatorvo.setCocheckname(wayVO.getShortname());
				cooperatorvo.setState(new Short("1"));
				cooperatorvo.setMemo(wayVO.getFunction());
				cooperatorvo.setOldcoopera(wayVO.getBusicode());
				cooperatorvo.setSmsmobileno(wayVO.getBuzphoneno());
				cooperatorvo.setServman(bchcontactVO.getPrincipal());
				cooperatorvo.setCooperadel(bchcontactVO.getPrincipal());
				cooperatorvo.setConntel(bchcontactVO.getPrincipaltel());
				cooperatorvo.setUsremail(bchcontactVO.getPrincipalemail());
				cooperatorvo.setConnpers(bchcontactVO.getLinkman());
				cooperatorvo.setBusconntel(bchcontactVO.getLinkmantel());
				cooperatorvo.setConnfaxno(bchcontactVO.getFax());
				cooperatorvo.setStarttime(waycompactVO.getBegintime());
				cooperatorvo.setLicenceid(waycompactVO.getLicenceno());
				cooperatorvo.setCustmanager(wayVO.getWaymagcode());
				cooperatorvo.setBaillwrlmt(new Double("0"));
				cooperatorvo.setDistrictid(wayVO.getCityid());
				cooperatorvo.setSendaddr(items[32]);
				cooperatorvo.setRecpers(items[33]);
				cooperatorvo.setRecconntel(items[34]);
				cooperatorvo.setReccertno(items[35]);
				cooperatorvo.setLicvalidate("".equals(items[36]) ? null
						: new java.sql.Date(format.parse(items[36]).getTime()));
				cooperatorvo.setIntime("".equals(items[38]) ? null
						: new java.sql.Date(format.parse(items[38]).getTime()));
				coopdelegate.doCreate(cooperatorvo);
			} else {
				BeanUtils.copyProperties(cooperatorvo, cooperatorvo1);
				if (items[32] == null || "".equals(items[32])) {
					cooperatorvo.setSendaddr(cooperatorvo1.getSendaddr());
				} else if ("null".equals(items[32]) || "��".equals(items[32])) {
					cooperatorvo.setSendaddr(null);
				} else
					cooperatorvo.setSendaddr(items[32]);
				if (items[33] == null || "".equals(items[33])) {
					cooperatorvo.setRecpers(cooperatorvo1.getRecpers());
				} else if ("null".equals(items[33]) || "��".equals(items[33])) {
					cooperatorvo.setRecpers(null);
				} else
					cooperatorvo.setRecpers(items[33]);
				if (items[34] == null || "".equals(items[34])) {
					cooperatorvo.setRecconntel(cooperatorvo1.getRecconntel());
				} else if ("null".equals(items[34]) || "��".equals(items[34])) {
					cooperatorvo.setRecconntel(null);
				} else
					cooperatorvo.setRecconntel(items[34]);
				if (items[35] == null || "".equals(items[35])) {
					cooperatorvo.setReccertno(cooperatorvo1.getReccertno());
				} else if ("null".equals(items[35]) || "��".equals(items[35])) {
					cooperatorvo.setReccertno(null);
				} else
					cooperatorvo.setReccertno(items[35]);
				if (items[36] == null || "".equals(items[36])) {
					cooperatorvo.setLicvalidate(cooperatorvo1.getLicvalidate());
				} else if ("null".equals(items[36]) || "��".equals(items[36])) {
					cooperatorvo.setLicvalidate(null);
				} else
					cooperatorvo.setLicvalidate(new java.sql.Date(format.parse(
							items[36]).getTime()));
				if (items[38] == null || "".equals(items[38])) {
					cooperatorvo.setIntime(cooperatorvo1.getIntime());
				} else if ("null".equals(items[38]) || "��".equals(items[38])) {
					cooperatorvo.setIntime(null);
				} else
					cooperatorvo.setIntime(new java.sql.Date(format.parse(
							items[38]).getTime()));

				BeanUtils.copyProperties(cooperatorvo1, cooperatorvo);
				coopdelegate.doUpdate(cooperatorvo1);
			}

			// ����VO
			AuditUtils utils = new AuditUtils();
			String[] waypk = { "wayid" };
			String[] newwayfield = { "address" };
			String[] cooperaupk = { "cooperauid" };
			String[] cooperatorfield = { "sendaddr" };
			String[] wayaccountpk = { "accid", "wayid" };
			String[] wayaccountfield = { "acctno", "bankname" };

			wayVO1 = (WayVO) utils.doSaveAudit(wayVO1, "CH_PW_WAY",
					"CH_PW_STRBWAY", newwayfield, waypk, "CH_PW_SOTYWAY_AUDIT",
					user);
			cooperatorvo1 = (CooperatorVO) utils.doSaveAudit(cooperatorvo1,
					"CH_DST_COOPERATOR", "CH_PW_STRBWAY", cooperatorfield,
					cooperaupk, "CH_PW_SOTYWAY_AUDIT", user);
			wayaccountVO1 = (WayaccountVO) utils.doSaveAudit(wayaccountVO1,
					"CH_PW_WAYACCOUNT", "CH_PW_STRBWAY", wayaccountfield,
					wayaccountpk, "CH_PW_SOTYWAY_AUDIT", user);
		} catch (Exception e) {
			e.printStackTrace();
			if (null != e.getCause())
				throw new Exception(e.getCause());
			throw e;
		}
	}

	// ��ѯ��Ӧ��VO�Ƿ��ڿ���д���
	public boolean doQueryExsist(Object vo, DBAccessUser user) throws Exception {

		SessionFactory sessionFactory = SessionUtils.getSessionFactory(
				vo.getClass(), user.getCityid());
		Session session = sessionFactory.getCurrentSession();
		ClassMetadata meadata = sessionFactory.getClassMetadata(vo.getClass());

		Serializable pk = meadata.getIdentifier(vo, EntityMode.POJO);
		if (session.get(vo.getClass(), pk) == null) {
			return false;
		}
		return true;
	}

	/**
	 * ����������ι�ϵ
	 * 
	 * @param wayVO
	 * @param user
	 * @throws Exception
	 */
	protected void createWayHierarchy(WayVO wayVO, DBAccessUser user)
			throws Exception {

		if (log.isInfoEnabled())
			log.info("prepare to create way hierarchy of way, �������� "
					+ wayVO.getWayid());

		Wayhierarchy wayhierarchyControl = (Wayhierarchy) BOFactory.build(
				WayhierarchyBO.class, user);

		String upperwayid = wayVO.getUpperwayid();

		if (upperwayid == null) {
			if (log.isInfoEnabled())
				log.info("way with no upperway,exit. �������� " + wayVO.getWayid());
			return;
		}
		String wayid = wayVO.getWayid();

		short hicyoffset = 1;
		while (upperwayid != null) {

			WayhierarchyVO wayhierarchyVO = new WayhierarchyVO();
			wayhierarchyVO.setParwayid(upperwayid);
			wayhierarchyVO.setSubwayid(wayid);
			wayhierarchyVO.setHichyoffset(new Short(hicyoffset));
			wayhierarchyVO.setCreatetime(new Timestamp(System
					.currentTimeMillis()));

			wayhierarchyControl.doCreate(wayhierarchyVO);

			log.info("create way hierarchy,�������� " + wayVO.getWayid()
					+ " uppperid:" + upperwayid + " hicyoffset:" + hicyoffset);
			hicyoffset++;

			String thiswayid = upperwayid;
			wayVO = getUpperWay(thiswayid, user);
			if (wayVO == null)
				upperwayid = null;
			else
				upperwayid = wayVO.getWayid();
		}
	}

	/**
	 * ɾ��������ι�ϵ
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	protected void removeWayHierarchy(WayVO wayVO, DBAccessUser user)
			throws Exception {
		Wayhierarchy wayhierarchyControl = (Wayhierarchy) BOFactory.build(
				WayhierarchyBO.class, user);
		WayhierarchyDBParam listVO = new WayhierarchyDBParam();

		String wayid = wayVO.getWayid();
		// ɾ��wayid��Ϊ�������ļ�¼
		listVO.getQueryConditions().put("_se_parwayid", wayid);
		listVO.set_pagesize("0");

		DataPackage data = wayhierarchyControl.doQuery(listVO);
		List dataList = (List) data.getDatas();

		for (int i = 0; i < dataList.size(); i++) {
			WayhierarchyVO vo = (WayhierarchyVO) dataList.get(i);
			wayhierarchyControl.doRemoveByPK(vo);
		}

		// ɾ��wayid��Ϊ�������ļ�¼
		listVO = new WayhierarchyDBParam();
		listVO.set_pagesize("0");
		listVO.getQueryConditions().put("_se_subwayid", wayid);
		data = wayhierarchyControl.doQuery(listVO);
		dataList = (List) data.getDatas();
		for (int i = 0; i < dataList.size(); i++) {
			WayhierarchyVO vo = (WayhierarchyVO) dataList.get(i);
			wayhierarchyControl.doRemoveByPK(vo);
		}
	}

	/**
	 * ��ȡ�ϼ�����
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public WayVO getUpperWay(String wayid, DBAccessUser user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO wayVO = (WayVO) dao.findByPk(wayid);
		if (wayVO == null || wayVO.getUpperwayid() == null)
			return null;
		else
			return (WayVO) dao.findByPk(wayVO.getUpperwayid());
	}

	/**
	 * �鿴ϵͳ�������Ƿ������˸õ����ܿ�ͨ��������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private boolean canSetservice(DBAccessUser user) throws Exception {
		Sysparam control = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String value = control.doFindByID(new Long(5), "channel");
		return "1".equals(value) ? true : false;
	}

	private NetsynVO setNetsynVO(String officetel, Short opract, String oprcode)
			throws Exception {
		NetsynVO netsynVO = new NetsynVO();
		netsynVO.setMobile(officetel);
		netsynVO.setOpract(opract);
		netsynVO.setOprcode(oprcode);
		return netsynVO;
	}

	private Properties property = null;

	/**
	 * �ӹ��������ļ��ж�ȡ����
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private String getCRMCityPortState(String cityid) throws Exception {
		if (property == null) {
			property = new Properties();
		}
		if (property.isEmpty()) {
			InputStream in = ComOrderSms.class
					.getResourceAsStream("/data/CRMCityPortState.properties");
			property.load(in);
		}
		return property.getProperty(cityid);
	}

	public WayVO doUpdateNotCon(WayVO vo) throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			// WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,
			// "DB_BOSSCOMMON");

			return (WayVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	// ��Ȩ�����������ѡ���������㣬��������Ϊ׼�������ʱ�򣬲�ѯ��������������
	public DataPackage doQueryWayinfoForapplyway(WayDBParam params)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		params.getQueryConditions().put("cityid", params.get_se_cityid());
		return dao.queryByNamedSqlQuery(
				"pboss.channel.queryWayinfoForapplyway", params);
	}

	// ��Ȩ�����������ѡ���������㣬��������Ϊ�˳������ʱ�򣬲�ѯ���������������
	public DataPackage doQueryWayinfoForExitway(WayDBParam params)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		params.getQueryConditions().put("cityid", params.get_se_cityid());
		return dao.queryByNamedSqlQuery("pboss.channel.queryWayinfoForExitway",
				params);
	}

	public DataPackage doCheckWayState(WayDBParam params) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryByNamedSqlQuery(
				"pboss.channel.business.channel.way.CheckWayState", params);
	}

	public DataPackage doQueryWaytype(WayDBParam params) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		params.getQueryConditions().put("wayid", params.get_se_wayid());
		return dao.queryByNamedSqlQuery(
				"pboss.channel.business.channel.way.QueryWayType", params);
	}

	// ��ѯ�����������Ϣ
	public DataPackage doQueryImpWay(WayDBParam params, User user)
			throws Exception {
		params.set_se_waytype("IMP");
		if (params.get_ne_waystate() == null
				|| params.get_ne_waystate().equals("")) {
			params.set_sql_waycondition("waystate = 1 or waystate = 0");
		}
		String basewayid = StringUtils.isEmpty(params.getBasewayid()) ? user
				.getWayid() : params.getBasewayid();
		params.getQueryConditions().put("basewayid", basewayid);
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao
				.queryByNamedSqlQuery("pboss.channel.queryImpWayinfo", params);
	}

	// ɾ�������������Ϣ
	public WayVO doRemove(WayVO vo) throws Exception {
		CRMService crmService = new CRMService();
		WayDAO dao = null;
		if (crmService.isCRMCityPort(user.getCityid())) {
			dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		} else {
			// dao = (WayDAO) DAOFactory.build(WayDAO.class, "DB_BOSSCOMMON");
			dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		}
		return (WayVO) dao.update(vo);
	}

	public DataPackage doQueryWayByParams(WayDBParam params) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.query(params);
	}

	public WayVO doSave(WayVO vo) throws Exception {
		try {
			CRMService crmService = new CRMService();
			WayDAO dao = null;
			if (crmService.isCRMCityPort(user.getCityid())) {
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			} else {
				// dao = (WayDAO) DAOFactory.build(WayDAO.class,
				// "DB_BOSSCOMMON");
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			}
			if (vo.getUpperwayid() != null) {
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (null == upVO || upVO.getWaylevel() == null) {
					throw new Exception("�ϼ����� " + vo.getWayid()
							+ " ȱ�� �����������Ƚ���������ȷ��");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
			}
			return (WayVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayVO doUpdateImpWay(WayVO vo) throws Exception {
		try {
			CRMService crmService = new CRMService();
			WayDAO dao = null;
			if (crmService.isCRMCityPort(user.getCityid())) {
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			} else {
				// dao = (WayDAO) DAOFactory.build(WayDAO.class,
				// "DB_BOSSCOMMON");
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			}
			if (vo.getUpperwayid() != null) {
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (null == upVO || upVO.getWaylevel() == null) {
					throw new Exception("�ϼ����� " + vo.getWayid()
							+ " ȱ�� �����������Ƚ���������ȷ��");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
			}
			return (WayVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	// ----------------���ڹ�������
	// ��ѯ���ڹ�������
	public DataPackage doQueryFinanceWay(WayDBParam params, User user)
			throws Exception {

		// if (params.get_ne_waystate() == null ||
		// params.get_ne_waystate().equals("")) {
		// params.set_sql_waycondition(" waystate = 1 or waystate = 0 ");
		// }
		if (params.get_se_cityid() == null || params.get_se_cityid().equals("")) {
			params.set_se_cityid(user.getCityid());
		}

		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryByNamedSqlQuery("pboss.channel.queryFinanceWayinfo",
				params);
	}

	// ɾ�����ڹ���������Ϣ
	public WayVO doRemoveFinanc(WayVO vo) throws Exception {
		CRMService crmService = new CRMService();
		WayDAO dao = null;
		if (crmService.isCRMCityPort(user.getCityid())) {
			dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		} else {
			// dao = (WayDAO) DAOFactory.build(WayDAO.class, "DB_BOSSCOMMON");
			dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		}
		return (WayVO) dao.update(vo);
	}

	// ��ӽ��ڹ���������Ϣ
	public WayVO doCreateFinance(WayVO vo) throws Exception {
		try {
			CRMService crmService = new CRMService();
			WayDAO dao = null;
			if (crmService.isCRMCityPort(user.getCityid())) {
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			} else {
				// dao = (WayDAO) DAOFactory.build(WayDAO.class,
				// "DB_BOSSCOMMON");
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			}

			return (WayVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	// �޸Ľ��ڹ���������Ϣ
	public WayVO doUpdateFinanceWay(WayVO vo) throws Exception {
		try {
			CRMService crmService = new CRMService();
			WayDAO dao = null;
			if (crmService.isCRMCityPort(user.getCityid())) {
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			} else {
				// dao = (WayDAO) DAOFactory.build(WayDAO.class,
				// "DB_BOSSCOMMON");
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			}

			return (WayVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	// ----------------����������
	// ��ѯ����������
	public DataPackage doQueryNetWay(WayDBParam params, User user)
			throws Exception {

		// if (params.get_ne_waystate() == null ||
		// params.get_ne_waystate().equals("")) {
		// params.set_sql_waycondition(" waystate = 1 or waystate = 0 ");
		// }
		if (params.get_se_cityid() == null || params.get_se_cityid().equals("")) {
			params.set_se_cityid(user.getCityid());
		}

		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao
				.queryByNamedSqlQuery("pboss.channel.queryNetWayinfo", params);
	}

	// ɾ��������������Ϣ
	public WayVO doRemoveNetWay(WayVO vo) throws Exception {
		CRMService crmService = new CRMService();
		WayDAO dao = null;
		if (crmService.isCRMCityPort(user.getCityid())) {
			dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		} else {
			// dao = (WayDAO) DAOFactory.build(WayDAO.class, "DB_BOSSCOMMON");
			dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		}
		return (WayVO) dao.update(vo);
	}

	// ��ӻ�����������Ϣ
	public WayVO doCreateNetWay(WayVO vo) throws Exception {
		try {
			CRMService crmService = new CRMService();
			WayDAO dao = null;
			if (crmService.isCRMCityPort(user.getCityid())) {
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			} else {
				// dao = (WayDAO) DAOFactory.build(WayDAO.class,
				// "DB_BOSSCOMMON");
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			}

			return (WayVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	// �޸Ļ�����������Ϣ
	public WayVO doUpdateNetWay(WayVO vo) throws Exception {
		try {
			CRMService crmService = new CRMService();
			WayDAO dao = null;
			if (crmService.isCRMCityPort(user.getCityid())) {
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			} else {
				// dao = (WayDAO) DAOFactory.build(WayDAO.class,
				// "DB_BOSSCOMMON");
				dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			}

			return (WayVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

	// ���ݵ���ID ����ѯ�õ��к�ʡ�ı���
	public DataPackage doQueryWayIdByCityId(WayDBParam params, User user)
			throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			return dao.queryByNamedSqlQuery("pboss.channel.queryWayIdByCityId",
					params);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}

}
