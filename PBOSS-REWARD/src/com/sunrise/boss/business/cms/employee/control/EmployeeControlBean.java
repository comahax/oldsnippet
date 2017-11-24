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
	public static final String []smsModelAdd={"尊敬的用户，你已申请注册为","推广专员,收到短信请在24小时内回复Y，注册成功，回复N，取消注册，24小时内不回复默认注册成功"};
	public static final String []smsModelUpdate={"尊敬的用户，你的推广专员信息身份已被修改为",",收到短信请在24小时内回复Y，确认修改，回复N，取消修改，24小时内不回复默认确认修改"};
	public static final String smsModelRemove="尊敬的用户，你已申请退出推广专员，收到短信请在24小时内回复Y，确认退出，回复N，取消退出，24小时内不回复默认确认退出";
	private final long  aday=1000*60*60*24;
	public EmployeeVO doCreate(EmployeeVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);

			// 如果工号为NULL或者空格，允许添加多个，不需要检查是否有重复现象
			if (vo.getOprcode2() != null && !vo.getOprcode2().trim().equals("")) {

				// 判断工号是否已经存在
				if (doFindByOprcode(vo.getOprcode2(), user) != null)
					throw new BusinessException("", "员工档案信息表已经存在该工号");
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
	 * 原生的修改函数,供外部纯修改调用,不涉及其它逻辑
	 */
	public EmployeeVO doUpdate2(EmployeeVO vo, User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.update(vo);
	}

	/*
	 * 检测是否修改了店主和捆绑手机号码的修改方法. (non-Javadoc) 店主和店员离职时自动触发取消服务,如果已经定制了服务.
	 * 
	 * @see com.sunrise.boss.business.cms.employee.control.EmployeeControl#doUpdate(com.sunrise.boss.business.cms.employee.persistent.EmployeeVO,
	 *      com.sunrise.boss.ui.commons.User)
	 */
	public EmployeeVO doUpdate(EmployeeVO vo, User user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// 判断手机号码和离职条件是否改动，如果手机号码有改动则把原手机号码置为离职，并复制一条新记录
			EmployeeVO telVO = doFindByPk(vo.getEmployeeid(), user);
			if (telVO == null) {
				throw new Exception("没有该PK:" + vo.getEmployeeid() + "对应VO的记录");
			}
			// 如果某条记录是离职状态改成了在岗,要重新检查店主唯一性,空选手机号码唯一性,采集平台捆绑手机号码唯一性
			if ((vo.getSelectmobile() != null && telVO.getEmpstatus() != null
					&& telVO.getEmpstatus().shortValue() == 1 && vo
					.getEmpstatus().shortValue() == 0)
					|| (vo.getSelectmobile() != null
							&& vo.getEmpstatus().shortValue() == 0 && !vo
							.getSelectmobile().equals(telVO.getSelectmobile()))) {
				//  
				if (!jdugeIsNetChange(vo.getWayid(), user)) {
					throw new BusinessException("", "一个网点只能有一个店主!");
				}
				//
				checkSelectmobile(vo.getOfficetel(), user);
				//
				checkOfficeTel(vo.getOfficetel(), user);

			}
			// 如果空中选号手机号码变动
			if (vo.getSelectmobile() != null && telVO.getSelectmobile() != null
					&& !vo.getSelectmobile().equals(telVO.getSelectmobile())) {
				checkSelectmobile(vo.getOfficetel(), user);
			}
			// 采集平台捆绑手机号码发生变动,重新检查
			if (vo.getOfficetel() != null
					&& telVO.getOfficetel() != null
					&& !telVO.getOfficetel().trim().equals(
							vo.getOfficetel().trim())) {
				// 检查是否本地手机号码
				checkOfficeTel(vo.getOfficetel(), user);
				EmployeeVO newVO = new EmployeeVO();
				BeanUtils.copyProperties(newVO, vo);
				newVO.setEmpstatus(new Short("0"));
				newVO.setIsopen(new Short("0"));// 增加设置未开通状态
				EmployeeVO creatEmployeeVO = this.doSocietyCopy(newVO, user);
				// EMPSTAUTS=1为离职状态,切记!
				telVO.setEmpstatus(new Short("1"));

				// 如果修改过手机号码的是店主,则要给旧手机号退订服务,给新手机号开通服务(店员也需要退订服务!但不开通)
				if (vo.getIsnet() != null
						&& (vo.getIsnet().shortValue() == (short) 1 || vo
								.getIsnet().shortValue() == (short) 0)) {
					AGWayControl control = (AGWayControl) ControlFactory
							.build(AGWayControlBean.class);
					control.doCancelService(telVO.getEmployeeid(), user);
					// 如果是店主,给新手机号码开通服务.
					if (vo.getIsnet().shortValue() == (short) 1) {
						control.doSetservice(vo.getWayid(), user);
					}
				}
				dao.update(telVO);
				return creatEmployeeVO;
			}
			// 把店员改成店主要检查店主唯一性
			if (vo.getIsnet() != null && telVO.getIsnet() != null
					&& telVO.getIsnet().shortValue() == (short) 0
					&& vo.getIsnet().shortValue() == (short) 1) {
				if (vo.getEmpstatus().shortValue() == (short) 0) {
					// 该店主为在岗状态才检查网点店主数目
					if (!jdugeIsNetChange(vo.getWayid(), user)) {
						throw new BusinessException("", "一个网点只能有一个店主!");
					}
				}
			}

			// 判断工号是否有修改，有修改则则检查是否重复，无修改也直接更新
			EmployeeVO existVO = doFindByPk(vo.getEmployeeid(), user);
			if (existVO.getOprcode2() == null
					|| existVO.getOprcode2().trim().equals("")) {

				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					// 判断工号是否已经存在
					if (doFindByOprcode(vo.getOprcode2(), user) != null)
						throw new BusinessException("", "员工档案信息表已经存在该工号");
				}

			} else {
				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					if (!existVO.getOprcode2().equals(vo.getOprcode2())) {

						if (doFindByOprcode(vo.getOprcode2(), user) != null)
							throw new BusinessException("", "员工档案信息表已经存在该工号");
					}
				}
			}
			// 检查工号是否存在
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
			// 店员或者店主从在岗改成离职,如果有定制渠道信息服务,则自动退订服务
			if (vo.getEmpstatus() != null && telVO.getEmpstatus() != null
					&& telVO.getEmpstatus().shortValue() == (short) 0
					&& vo.getEmpstatus().shortValue() == (short) 1) {
				// 只有店主店员两种情况才退订
				if (vo.getIsnet().shortValue() == (short) 1
						|| vo.getIsnet().shortValue() == (short) 0) {
					AGWayControl control = (AGWayControl) ControlFactory
							.build(AGWayControlBean.class);
					// 退订中间表没有退订记录时才进行退订.
					if (!control.doHasRecords(vo.getEmployeeid(), user)) {
						control.doCancelService(telVO.getEmployeeid(), user);
					}
				}
			}

			AuditUtils auditutils = new AuditUtils();
			if (vo.getRight() != null && vo.getRight().intValue() != 0) {
				if (!auditutils.doCheckSystemParam("CH_STEMPRIGHT", vo
						.getRight().toString(), user)) {
					throw new BusinessException("", "该权限级别("
							+ vo.getRight().toString() + ")属无效级别");
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

	// 社会渠道人员信息查询
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
	 * 根据岗位信息查询
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

	// 根据已存在的群组成员查询可添加的成员
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

	// 增加移动渠道人员信息，检查渠道是否是当前渠道的下属渠道
	public EmployeeVO doDitchcreate(EmployeeVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);

			// 如果工号为NULL或者空格，允许添加多个，不需要检查是否有重复现象
			if (vo.getOprcode2() != null && !vo.getOprcode2().trim().equals("")) {
				// 判断工号是否在工号表存在
				checkOpercode(vo, user);
				// 判断工号是否已经存在
				if (doFindByOprcode(vo.getOprcode2(), user) != null)
					throw new BusinessException("", "员工档案信息表已经存在该工号");
			}
			// 检查该渠道是否是当前渠道的下属（实体）渠道
			if (vo.getWayid() != null && !vo.getWayid().trim().equals("")) {

				if (waydao.getIsupperwayid(user.getWayid(), vo.getWayid())
						.getDatas().size() == 0)
					throw new BusinessException("", "该渠道不属于当前渠道的下属(实体)渠道");
			}
			AuditUtils auditutils = new AuditUtils();
			if (vo.getPosittype() != null
					&& !vo.getPosittype().trim().equals("")) {
				if (!auditutils.doCheckSystemParam("CH_POSTKIND", vo
						.getPosittype(), user)) {
					throw new BusinessException("", "该岗位级别("
							+ vo.getPosittype() + ")属无效级别");
				}
			}
			// 加入采集平台捆绑手机号码检测
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

	// 移动渠道人员信息修改，检查渠道是否是当前渠道的下属渠道
	public EmployeeVO doDitchupdate(EmployeeVO vo, User user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);

			// 判断工号是否有修改，有修改则则检查是否重复，无修改也直接更新
			EmployeeVO existVO = doFindByPk(vo.getEmployeeid(), user);

			if (existVO.getOprcode2() == null
					|| existVO.getOprcode2().trim().equals("")) {

				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					// 判断工号是否已经存在
					if (doFindByOprcode(vo.getOprcode2(), user) != null)
						throw new BusinessException("", "员工档案信息表已经存在该工号");
				}

			} else {
				// 判断工号是否在工号表存在
				checkOpercode(vo, user);
				if (vo.getOprcode2() != null
						&& !vo.getOprcode2().trim().equals("")) {
					if (!existVO.getOprcode2().equals(vo.getOprcode2())) {

						if (doFindByOprcode(vo.getOprcode2(), user) != null)
							throw new BusinessException("", "员工档案信息表已经存在该工号");
					}
				}

			}
			if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() == 11) {
				checkTelCity(vo.getOfficetel(), user);
				// 在职+改变手机号码
				if (vo.getEmpstatus() != null
						&& vo.getEmpstatus().shortValue() == (short) 0) {
					if (!vo.getOfficetel().equals(existVO.getOfficetel())) {

						checkOfficeTel(vo.getOfficetel(), user);
					}
				}
				// 离职改成在职要再检测手机号码,不关手机号码变不变
				if (vo.getEmpstatus() != null
						&& vo.getEmpstatus().shortValue() == (short) 0
						&& existVO.getEmpstatus() != null
						&& existVO.getEmpstatus().shortValue() == (short) 1) {
					checkOfficeTel(vo.getOfficetel(), user);
				}
			}
			// 检查该渠道是否是当前渠道的下属（实体）渠道
			if (vo.getWayid() != null && !vo.getWayid().trim().equals("")) {

				if (waydao.getIsupperwayid(user.getWayid(), vo.getWayid())
						.getDatas().size() == 0)
					throw new BusinessException("", "该渠道不属于当前渠道的下属(实体)渠道");
			}
			AuditUtils auditutils = new AuditUtils();
			if (vo.getPosittype() != null
					&& !vo.getPosittype().trim().equals("")) {
				if (!auditutils.doCheckSystemParam("CH_POSTKIND", vo
						.getPosittype(), user)) {
					throw new BusinessException("", "该岗位级别("
							+ vo.getPosittype() + ")属无效级别");
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

	// 社会渠道人员信息批量导入,该方法被废弃使用
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
			// throw new BusinessException("", "该权限级别("
			// + vo.getRight().toString() + ")属无效级别");
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
	 * 检测给出的渠道是否为用户渠道的下属渠道
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
				+ wayid + "'"; // 数据权限限制

		listVO.set_sql_waycondition(sql);
		return this.doSocietyEmployeeQuery(listVO, user);
	}

	// 移动渠道人员信息批量导入
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
				throw new Exception("[服务厅（所属渠道）]不存在");
			}

			// 检查该渠道是否是当前渠道的下属（实体）渠道

			if (waydao.getIsupperwayid(user.getWayid(), wayVO.getWayid())
					.getDatas().size() == 0) {
				throw new BusinessException("", "该渠道不属于当前渠道的下属(实体)渠道");

			} else {
				if (!vo.getCityid().equals(wayVO.getCityid())) {
					throw new Exception("[地市公司]和所选渠道的地市公司不一致");
				}
				if (vo.getCountyid() != null
						&& !vo.getCountyid().equals(wayVO.getCountyid())) {
					throw new Exception("[分公司]和所选渠道的分公司不一致");
				}
				if (vo.getSvccode() != null
						&& !"".equals(vo.getSvccode().trim())) {
					ServcentListVO listVO = new ServcentListVO();
					listVO.set_se_countyid(vo.getCountyid());
					listVO.set_se_svccode(vo.getSvccode());
					ServcentDelegate sdelegate = new ServcentDelegate();
					if (sdelegate.doQuery(listVO, user).getRowCount() == 0) {
						throw new Exception("[服务销售中心]不属于该分公司");
					}
				}
			}
			if (doFindByPk(vo.getEmployeeid(), user) != null) {
				throw new Exception("[人员编号]已经存在");
			}
			// 判断工号是否在工号表存在
			checkOpercode(vo, user);
			AuditUtils auditutils = new AuditUtils();
			if (vo.getPosittype() != null
					&& !vo.getPosittype().trim().equals("")) {
				if (!auditutils.doCheckSystemParam("CH_POSTKIND", vo
						.getPosittype(), user)) {
					throw new BusinessException("", "该岗位级别("
							+ vo.getPosittype() + ")属无效级别");
				}
			}
			// 判断采集平台手机号码是否一致
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
	 * 得到当前渠道的上级实体渠道
	 */
	public DataPackage doUpperwayid(String basewayid, String wayid, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.getIsupperwayid(basewayid, wayid);
	}

	// 移动渠道服务厅人员信息查询
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

	// 移动渠道渠道经理信息查询
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
	 * 生成人员编号
	 */
	public String getEmployeeid(User user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);

		return SessionFactoryRouter.conversionCityid(user.getCityid())
				+ dao.getSequence();
	}

	/*
	 * 新增社会渠道人员
	 */
	public EmployeeVO doSocietycreate(EmployeeVO vo, User user)
			throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			WayDelegate wdelegate = new WayDelegate();
			WayVO wayVO = wdelegate.doFindByPk(vo.getWayid(), user);
			if (wayVO == null) {
				throw new Exception("[所属网点/渠道编码]:" + vo.getWayid() + "在系统中不存在");
			}
			if (!"AG".equals(wayVO.getWaytype())
					&& !("ET".equals(wayVO.getWaytype()) && 1 == wayVO
							.getRunmode().longValue())) {
				throw new Exception("[所属网点]不是社会渠道或自建他营渠道");
			} else {
				if (vo.getCityid() != null
						&& wayVO.getCityid() != null
						&& !vo.getCityid().trim().equals(
								wayVO.getCityid().trim())) {
					throw new Exception("[地市公司]" + vo.getCityid()
							+ "和所选渠道的地市公司" + wayVO.getCityid() + "不一致");
				}
				if (vo.getCountyid() != null
						&& !vo.getCountyid().trim().equals(wayVO.getCountyid())) {
					throw new Exception("[分公司]:" + vo.getCountyid()
							+ "和所选渠道的分公司" + wayVO.getCountyid() + "不一致");
				}
				if (vo.getSvccode() != null
						&& !"".equals(vo.getSvccode().trim())) {
					ServcentListVO listVO = new ServcentListVO();
					listVO.set_se_countyid(vo.getCountyid());
					listVO.set_se_svccode(vo.getSvccode());
					ServcentDelegate sdelegate = new ServcentDelegate();
					if (sdelegate.doQuery(listVO, user).getRowCount() == 0) {
						throw new Exception("[服务销售中心]不属于该分公司");
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
					throw new BusinessException("", "一个网点只能有一个店主");
				}
				// 只有店主才生成网点确认码
				vo.setNetpass(CMSUtils.genRandomNumer(6));// 网点确认码六位随机数
			}
			if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() == 11) {
				// 检测采集平台捆绑手机号是否存在和是否和登录工号一个地市
				checkTelCity(vo.getOfficetel(), user);
				// 检测采集平台捆绑手机号是否唯一
				checkOfficeTel(vo.getOfficetel(), user);

			} else if (vo.getOfficetel() != null
					&& vo.getOfficetel().trim().length() != 11) {
				throw new BusinessException("", "采集平台捆绑手机号位数不正确,必须为11位!");
			}
			String employeeid = getEmployeeid(user);
			EmployeeVO oldVO = (EmployeeVO) dao.findByPk(employeeid);
			while (oldVO != null) {
				employeeid = getEmployeeid(user);
				oldVO = (EmployeeVO) dao.findByPk(employeeid);
			}
			vo.setEmployeeid(employeeid);// 人员编号后台自动生成
			if (vo.getIsopen() == null) {// 网点服务标志填写 0（未开通）
				vo.setIsopen(new Short("0"));
			}
			vo.setWaytype("AG");// 默认为社会渠道
			if (vo.getEmpstatus() == null) { // 设置默认在岗
				vo.setEmpstatus(new Short("0"));
			}
			// 如果工号为NULL或者空格，允许添加多个，不需要检查是否有重复现象
			if (vo.getOprcode2() != null && !vo.getOprcode2().trim().equals("")) {
				// 判断工号是否在工号表存在
				checkOpercode(vo, user);
				// 判断工号是否已经存在
				if (doFindByOprcode(vo.getOprcode2(), user) != null)
					throw new BusinessException("", "员工档案信息表已经存在该工号");
			}
			// add by wh,新增空中选号手机号码,要匹配在岗为条件保证唯一
			if (vo.getSelectmobile() != null
					&& vo.getSelectmobile().length() > 0) {
				EmployeeListVO listVO = new EmployeeListVO();
				listVO.set_orderby("selectmobile");
				listVO.set_ne_empstatus("0");
				listVO.set_se_selectmobile(vo.getSelectmobile());
				if (dao.query(listVO).getRowCount() > 0) {
					throw new Exception("空中选号/写卡专用号码必须在系统唯一");
				}
			}
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/*
	 * 由于修改号码导致的新增社会渠道人员（复制）
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
				throw new BusinessException("", "采集平台捆绑手机号位数不正确,必须为11位!");
			}
			vo.setEmployeeid(getEmployeeid(user));// 人员编号后台自动生成
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * 新增时判断一个网点店主数目只能小于等于一
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
	 * 修改时要把店员改成店主时和修改离职状态时调用。
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
				throw new BusinessException("", "系统不存在录入工号");
			}
		}
	}

	/**
	 * 查询在职手机号码是否唯一
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
		// 0-在职
		listvo.set_ne_empstatus("0");
		DataPackage pack = dao.query(listvo);
		if (pack.getDatas().size() > 0) {
			throw new BusinessException("", "系统已存在该[采集平台捆绑手机号]，请用其它手机号！");
		}
	}

	/**
	 * 检测手机号码是否在本地市内唯一
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
			throw new Exception("采集平台手机号码与登录工号所属地市不一致");
		}
	}

	public DataPackage doWayproemployeeQuery(EmployeeListVO listvo, User user)
			throws Exception {
		VEmployeeDAO dao = (VEmployeeDAO) DAOFactory.build(VEmployeeDAO.class,
				user);
		return dao.queryByNamedSqlQuery("WayproemployeeQuery", listvo);
	}
	
	public void doSendMsg(EmpconfirmVO confirmVO,String operate,User user)throws Exception {
		//取得短信端口
		SysparamDAO paramDao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		String smsPort =paramDao.doFindByID(new Long("1"), "pboss_unpb");
		if(smsPort==null)
		{
			throw new Exception("系统参数中未取得系统发送短信端口!");
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
		//短信内容
		String message="";
		ExcelCodeToName et = new ExcelCodeToName();
		String wayname=et.codeToName("#WAY", confirmVO.getWayid(), user);
		if("NEW".equals(operate)){
			if(confirmVO.getWayid().endsWith("U_00000"))
			{
				message=smsModelAdd[0]+wayname+"个人"+smsModelAdd[1];
			}else
			{
				message=smsModelAdd[0]+wayname+"代理商"+smsModelAdd[1];
			}
		}else if("EDIT".equals(operate)){
			if(confirmVO.getEmpstatus().shortValue()==(short)0){
				if(confirmVO.getWayid().endsWith("U_00000"))
				{
					message=smsModelUpdate[0]+wayname+"个人"+smsModelUpdate[1];
				}else
				{
					message=smsModelUpdate[0]+wayname+"代理商"+smsModelUpdate[1];
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
	
	// 判断是否需要二次确认
	public boolean doMessage(EmployeeVO empVO, User user, String operate)
			throws Exception {
		if ("EDIT".equals(operate)) {
			return checkChanged(user, empVO) && doMessage(user);
		} else {
			return doMessage(user);
		}
	}
	//判断是否需要二次确认
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
	//判断二次确认是否在24小时之内
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
			throw new Exception("系统不允许同个专员同时存在多条待确认信息");
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
		//这个处理比较麻烦
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
			// 数据不正常,加一条记录
			doInsertModel(yes, employeeid, user,null,confirmid);
		}
	}

	/**
	 * 查二次确认模式表
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
	 * 查询在职手机号码是否唯一
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
			throw new Exception("该空中选号手机号" + officetel + "已经存在一条在岗的记录!");
		}
	}
	
	public EmployeeVO doUpdateWaypro(EmployeeVO empVO, User user)
			throws Exception {
		try {
			// 检测渠道是否加入全员代理
			checkUnpb(user, empVO);
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// 检测是否有推广专员已经存在
				checkTelephone(user, empVO,empVO.getEmployeeid());
			// 检测是否需要二次确认
				//检查所属渠道编码和人员状态是否改变,如果改变才二次确认去发短信,否则按原来逻辑.
				
			if (doMessage(empVO,user,"EDIT")) {
				  doConfirm(empVO, user,"EDIT");
				  empVO.setChanged(true);
			} else {
				if(doMessage(user))
				{
					//看该专员是否有修改过所属渠道编码和人员状态的待确认记录,如果有,就不让修改.
					check24(empVO, user);
				}
				// 去模式表查询记录
				EmpmodelDAO modelDAO = (EmpmodelDAO) DAOFactory.build(
						EmpmodelDAO.class, user);
				EmpmodelListVO empListvo = new EmpmodelListVO();
				empListvo.set_se_employeeid(empVO.getEmployeeid());
				empListvo.set_se_model("3");
				DataPackage empDp = modelDAO.query(empListvo);
				if(empDp.getRowCount()<=0)
				{
					//容错处理,如果没有查询到记录增加一条记录
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
	 * 检查修改的时候所属渠道编码和人员状态是否改变
	 * @param user
	 * @param employeeid
	 * @return
	 * @throws Exception
	 */
	public boolean checkChanged(User user,EmployeeVO empVO) throws Exception{
		boolean isChanged=false;
		if(empVO.getEmpstatus()==null || empVO.getWayid()==null)
		{
			throw new Exception("数据错误:人员状态或者所属渠道编码不能为空");
		}
		//看状态是否改变
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
			throw new Exception("人员ID不存在:"+empVO.getEmployeeid());
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
			//检测渠道是否加入全员代理
			checkUnpb(user, empVO);
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			//检测是否有推广专员已经存在
			checkTelephone(user, empVO,null);
			//检测是否需要二次确认
			if(doMessage(empVO,user,"NEW"))
			{
				 doConfirm(empVO, user,"NEW");
			}else
			{
				String employeeid = CityIDMap
						.conversionCityid(user.getCityid())
						+ "UNRC_" + dao.getSequence();
				empVO.setEmployeeid(employeeid);
				//插模式表
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
			throw new BusinessException("", "所属代理商未加入全员代理模式");
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
					throw new BusinessException("", "该推广专员已经存在");
			}
		}
	
	// 根据公务机号码查询
	public DataPackage mobileEmployeeQuery(EmployeeListVO params,User user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return dao.mobileEmployeeQuery(params);
	}
	// 根据公务机号码查询
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
