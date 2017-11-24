package com.sunrise.boss.business.zifee.feedisc.control;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemDAO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.fee.woff.acct.control.AcctControl;
import com.sunrise.boss.business.fee.woff.acct.control.AcctControlBean;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctDAO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.business.zifee.areagroupinfo.persistent.AreaGroupInfoDAO;
import com.sunrise.boss.business.zifee.areagroupinfo.persistent.AreaGroupInfoVO;
import com.sunrise.boss.business.zifee.areagroupscale.persistent.AreaGroupScaleDAO;
import com.sunrise.boss.business.zifee.areagroupscale.persistent.AreaGroupScaleListVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscDAO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscListVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanDAO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/feedisc/control/FeediscControlBean"
 *           name="FeediscControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class FeediscControlBean extends AbstractControlBean implements
		FeediscControl {

	public FeediscVO doCreate(FeediscVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			// 检查 [帐单科目状态]是否为可用[1]
			AcctControl acctcontrol = (AcctControl) ControlFactory
					.build(AcctControlBean.class);
			AcctVO acctVO = new AcctVO();
			if (vo.getAcctid() != null) {
				acctVO = (AcctVO) acctcontrol.doFindByPk(vo.getAcctid(), user);
			}
			if (acctVO != null)
				if (acctVO.getAcctstate() != null) {
					int flag = 1;
					if (flag != acctVO.getAcctstate().intValue()) {
						throw new BusinessException("", "录入记录出错：帐单科目已禁用");
					}
				} 

			FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class,
					user);

			return (FeediscVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(FeediscVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeediscVO doUpdate(FeediscVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			// 检查 [帐单科目状态]是否为可用[1]
			// AcctDAO acctDAO=(AcctDAO)DAOFactory.build(AcctDAO.class, user);

			AcctControl acctcontrol = (AcctControl) ControlFactory
					.build(AcctControlBean.class);

			AcctVO acctVO = new AcctVO();
			if (vo.getAcctid() != null) {
				acctVO = (AcctVO) acctcontrol.doFindByPk(vo.getAcctid(), user);
			}

			FeediscControl control = (FeediscControl) ControlFactory
					.build(FeediscControlBean.class);
			FeediscVO vo2 = (FeediscVO) control.doFindByPk(vo.getFeediscid(),
					user);

			if (vo != null && vo2 != null) {
				if (vo.getAcctid() != vo2.getAcctid() && acctVO != null) {

					if (acctVO.getAcctstate() != null) {
						int flag = 1;
						if (flag != acctVO.getAcctstate().intValue()) {
							throw new BusinessException("", "修改记录出错：帐单科目已禁用");
						}
					} else {
						throw new BusinessException("", "修改记录出错：查不到相关的[帐单科目状态]");
					}
				}

			}
			FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class,
					user);
			BeanUtils.copyProperties(vo2, vo);
			return (FeediscVO) dao.update(vo2);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeediscVO doFindByPk(Serializable pk, User user) throws Exception {
		// TODO Auto-generated method stub
		FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class, user);
		return (FeediscVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FeediscListVO params, User user)
			throws Exception {
		// TODO Auto-generated method stub
		FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class, user);
		return dao.query(params);
	}

	/**
	 * 批量新增
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public FeediscVO doBatchCreate(FeediscVO vo, User user) throws Exception {
		try {
			YxPlanDAO yxPlanDAO = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class,
					user);
			YxPlanVO yxPlanVO = (YxPlanVO) yxPlanDAO.findByPk(vo.getYxplanid());

			if (yxPlanVO == null) {
				throw new Exception("所要增加的[营销方案标识]在主表中应该存在!");
			}
			if (null != vo.getAcctid()) {
				checkAcctid(vo, user);
			}
			if (null != vo.getDisckind()) {
				checkDisckind(vo, user);
			}
			if (null != vo.getAreagroupid() || null != vo.getAreagroupid()
					&& null != vo.getAreacod()) {
				checkGroup(vo, user);
			}
			if (null != vo.getCurrbillcode()) {
				checkCurrbillcode(vo, user);
			}
			if (null != vo.getPaybyothersflag()) {
				checkPaybyothersflag(vo, user);
			}
			checkDefault(vo);
			FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class,
					user);

			return (FeediscVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}

	}

	/**
	 * 将游离对象的值赋到持久对象中
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	protected void setSaveVO(Object vo, Object vo1) throws Exception {
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(vo, vo1);
	}

	/**
	 * 检测主键
	 * 
	 * @param feediscid
	 * @param yxplanid
	 * @throws Exception
	 * @param user
	 */
	private void checkKey(Long feediscid, Long yxplanid, User user)
			throws Exception {
		FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class, user);
		FeediscVO vo = new FeediscVO();
		vo = (FeediscVO) dao.findByPk(feediscid);
		if (vo == null) {
			throw new Exception("要修改与[套餐计费帐务优惠标识]相关的记录不在数据库中!");
		}
		if (!vo.getYxplanid().equals(yxplanid)) {
			throw new Exception(
					"修改失败，系统中[套餐计费帐务优惠标识]对应的[营销方案标识]与导入文件的[营销方案标识]不一致");
		}
		dao.clearSession();
	}

	/**
	 * 批量更新
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public FeediscVO doBatchUpdate(FeediscVO vo1, User user) throws Exception {
		FeediscDAO dao = (FeediscDAO) DAOFactory.build(FeediscDAO.class, user);
		FeediscVO vo2 = null;
		if (vo1.getFeediscid() != null) {
			checkKey(vo1.getFeediscid(), vo1.getYxplanid(), user);
		}

		if (null != vo1.getAcctid()) {
			if (vo1.getFeediscid() != null) {
				FeediscControl control = (FeediscControl) ControlFactory
						.build(FeediscControlBean.class);
				vo2 = (FeediscVO) control.doFindByPk(vo1.getFeediscid(), user);
			}
			// 转换类型
			AcctVO vo = new AcctVO();
			vo.setAcctid(vo1.getAcctid());
			AcctDAO acctDAO = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
			AcctVO voResult = (AcctVO) acctDAO.findByPk(vo.getAcctid());

			if (voResult == null) {
				throw new Exception("[账单科目标识](" + vo1.getAcctid() + ")在相关表中不存在");
			}
			if (vo2 != null) {
				if (vo1 != null) {
					if (vo1.getAcctid() != vo2.getAcctid()) {

						if (voResult.getAcctstate() != null) {
							// int flag = 1;
							if (voResult.getAcctstate().intValue() != 1) {
								throw new Exception("[账单科目标识]("
										+ vo1.getAcctid() + ")已禁用");
							}
						}
					}
				}
			}

		}
		if (null != vo1.getDisckind()) {
			checkDisckind(vo1, user);
		}
		if (null != vo1.getAreagroupid() || null != vo1.getAreagroupid()
				&& null != vo1.getAreacod()) {
			checkGroup(vo1, user);
		}
		if (null != vo1.getCurrbillcode()) {
			checkCurrbillcode(vo1, user);
		}
		if (null != vo1.getPaybyothersflag()) {
			checkPaybyothersflag(vo1, user);
		}
		// vo = vo1;
		checkDefault(vo1);
		try {
			// vo.setYxplanid(vo1.getYxplanid());
			// vo.setHalfwrapfee(vo1.getHalfwrapfee());
			if (vo2 != null) {
				BeanUtils.copyProperties(vo2, vo1);
				return (FeediscVO) dao.update(vo2);
			} else {
				return (FeediscVO) dao.update(vo1);
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * 根据字符串构造FeediscVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             营销方案标识0|营销方案名称1|全省标识2|启动日期3|停用日期4|区域标识5|最低消费额6|最低消费跨越周期7|
	 *             是否需要捆绑套餐8|捆绑期9|是否允许预约10|是否预收月租11|可享用次数12|最小优惠周期数13|优惠起算偏移量14|
	 *             起算时间单元15|生效时间规则16|营销方案分组标识17|是否备份18|是否打印到受理单19|
	 *             是否算费优惠20|是否营业费优惠21|停机状态是否收取月租费22|是否网外成员优惠23|来源24|营销类别25|
	 *             营销方案类别26|特殊方案标志27|优惠范围28|资费说明29|说明30|
	 */
	public FeediscVO buildVO(String[] fields, User user) throws Exception {
		FeediscVO result = null;
		try {
			result = new FeediscVO();

			return result;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 检查入库文件的合法性(正则表达式匹配)
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ResultBean doCheck(String[] fields, User user) throws Exception {
		ResultBean result = new ResultBean();
		result.setCode(0);
		result.setInfo("");

		return result;
	}

	// 检查小区组及小区代码
	private void checkGroup(FeediscVO feedVO, User user) throws Exception {
		AreaGroupInfoDAO groupInfoDAO = (AreaGroupInfoDAO) DAOFactory.build(
				AreaGroupInfoDAO.class, user);
		AreaGroupInfoVO groupInfoVO = (AreaGroupInfoVO) groupInfoDAO
				.findByPk(feedVO.getAreagroupid());
		if (groupInfoVO == null) {
			throw new Exception("[小区组](" + feedVO.getAreagroupid().toString()
					+ ")不存在!");
		}
		AreaGroupScaleDAO areaGroupScaleDAO = (AreaGroupScaleDAO) DAOFactory
				.build(AreaGroupScaleDAO.class, user);
		AreaGroupScaleListVO listVO = new AreaGroupScaleListVO();
		listVO.set_ne_areagroupid(feedVO.getAreagroupid().toString());
		listVO.set_ne_areagroupid(feedVO.getAreacod());
		if (areaGroupScaleDAO.query(listVO).getDatas().size() <= 0) {
			throw new Exception("[小区代码](" + feedVO.getAreacod()
					+ ")不存在或不在[小区组](" + feedVO.getAreagroupid().toString()
					+ ")内!");
		}
	}

	// 检查账单科目标识
	private void checkAcctid(FeediscVO feedVO, User user) throws Exception {

		// 转换类型
		AcctVO vo = new AcctVO();
		vo.setAcctid(feedVO.getAcctid());
		AcctDAO acctDAO = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
		AcctVO voResult = (AcctVO) acctDAO.findByPk(vo.getAcctid());
		if (voResult == null) {
			throw new Exception("[账单科目标识](" + feedVO.getAcctid() + ")在相关表中不存在");
		}
		if (voResult.getAcctstate().intValue() != 1) {
			throw new Exception("[账单科目标识](" + feedVO.getAcctid() + ")已禁用");
		}
	}

	// 检查优惠种类DiscKind
	private void checkDisckind(FeediscVO feedVO, User user) throws Exception {
		// 转换类型
		DictitemVO vo = new DictitemVO();
		vo.setDictid(feedVO.getDisckind());
		DictitemDAO dictitemDAO = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_dictid(vo.getDictid());
		listVO.set_se_groupid("PC_FEEDISCTYPE");
		DataPackage dp = dictitemDAO.query(listVO, true);
		if (dp.getRowCount() <= 0) {
			throw new Exception("[优惠种类](" + feedVO.getDisckind() + ")不存在");
		}
	}

	// 检查 当月生效帐单优惠代码
	private void checkCurrbillcode(FeediscVO feedVO, User user)
			throws Exception {
		// 转换类型
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_CURRBILLCODE");
		listVO.set_se_dictid(feedVO.getCurrbillcode());
		DictitemDAO dictitemDAO = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DataPackage dp = dictitemDAO.query(listVO, true);
		if (dp.getRowCount() <= 0) {
			throw new Exception("[当月生效帐单优惠代码](" + feedVO.getCurrbillcode()
					+ ")不存在");
		}
	}

	/**
	 * 检测是否代付
	 * 
	 * @param feedVO
	 * @param user
	 * @throws Exception
	 */
	private void checkPaybyothersflag(FeediscVO feedVO, User user)
			throws Exception {
		DictitemDAO delegate = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_PAYBYOTHERSFLAG");
		listVO.set_se_dictid(feedVO.getPaybyothersflag().toString());
		if (delegate.query(listVO).getRowCount() == 0) {
			throw new Exception(
					"是否代付字段内容不合法，请参考0 集团不代付功能费、不代付套餐费;1 集团不代付功能费、代付套餐费;2 集团代付功能费、不代付套餐费;3 集团代付功能费、代付套餐费");
		}
	}

	/**
	 * 检测必须有值的字段是否有值，如果没有值强制后台赋给默认值。 是否定时上传schedsendflag 是否代付paybyothersflag
	 * 业务类型busitype 接入平台accessplatform 全球通上行费率gotoneuprate 全球通下行费率
	 * gotonedownrate 智能网上行费率smpuprate 智能网下行费率smpdownrate
	 */
	private void checkDefault(FeediscVO feedVO) throws Exception {
		if (feedVO.getSchedsendflag() == null) {
			feedVO.setSchedsendflag(new Byte("0"));
		}
		if (feedVO.getPaybyothersflag() == null) {
			feedVO.setPaybyothersflag(new Byte("0"));
		}
		if (feedVO.getBusitype() == null) {
			feedVO.setBusitype("1");
		}
		if (feedVO.getAccessplatform() == null) {
			feedVO.setAccessplatform("01");
		}
		if (feedVO.getGotoneuprate() == null) {
			feedVO.setGotoneuprate(new Double("0"));
		}
		if (feedVO.getGotonedownrate() == null) {
			feedVO.setGotonedownrate(new Double("0"));
		}
		if (feedVO.getSmpuprate() == null) {
			feedVO.setSmpuprate(new Double("0"));
		}
		if (feedVO.getSmpdownrate() == null) {
			feedVO.setSmpdownrate(new Double("0"));
		}

	}

}
