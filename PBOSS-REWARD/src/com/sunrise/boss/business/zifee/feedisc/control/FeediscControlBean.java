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
			// ��� [�ʵ���Ŀ״̬]�Ƿ�Ϊ����[1]
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
						throw new BusinessException("", "¼���¼�����ʵ���Ŀ�ѽ���");
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
			// ��� [�ʵ���Ŀ״̬]�Ƿ�Ϊ����[1]
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
							throw new BusinessException("", "�޸ļ�¼�����ʵ���Ŀ�ѽ���");
						}
					} else {
						throw new BusinessException("", "�޸ļ�¼�����鲻����ص�[�ʵ���Ŀ״̬]");
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
	 * ��������
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
				throw new Exception("��Ҫ���ӵ�[Ӫ��������ʶ]��������Ӧ�ô���!");
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
	 * ����������ֵ�����־ö�����
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	protected void setSaveVO(Object vo, Object vo1) throws Exception {
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(vo, vo1);
	}

	/**
	 * �������
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
			throw new Exception("Ҫ�޸���[�ײͼƷ������Żݱ�ʶ]��صļ�¼�������ݿ���!");
		}
		if (!vo.getYxplanid().equals(yxplanid)) {
			throw new Exception(
					"�޸�ʧ�ܣ�ϵͳ��[�ײͼƷ������Żݱ�ʶ]��Ӧ��[Ӫ��������ʶ]�뵼���ļ���[Ӫ��������ʶ]��һ��");
		}
		dao.clearSession();
	}

	/**
	 * ��������
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
			// ת������
			AcctVO vo = new AcctVO();
			vo.setAcctid(vo1.getAcctid());
			AcctDAO acctDAO = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
			AcctVO voResult = (AcctVO) acctDAO.findByPk(vo.getAcctid());

			if (voResult == null) {
				throw new Exception("[�˵���Ŀ��ʶ](" + vo1.getAcctid() + ")����ر��в�����");
			}
			if (vo2 != null) {
				if (vo1 != null) {
					if (vo1.getAcctid() != vo2.getAcctid()) {

						if (voResult.getAcctstate() != null) {
							// int flag = 1;
							if (voResult.getAcctstate().intValue() != 1) {
								throw new Exception("[�˵���Ŀ��ʶ]("
										+ vo1.getAcctid() + ")�ѽ���");
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
	 * �����ַ�������FeediscVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             Ӫ��������ʶ0|Ӫ����������1|ȫʡ��ʶ2|��������3|ͣ������4|�����ʶ5|������Ѷ�6|������ѿ�Խ����7|
	 *             �Ƿ���Ҫ�����ײ�8|������9|�Ƿ�����ԤԼ10|�Ƿ�Ԥ������11|�����ô���12|��С�Ż�������13|�Ż�����ƫ����14|
	 *             ����ʱ�䵥Ԫ15|��Чʱ�����16|Ӫ�����������ʶ17|�Ƿ񱸷�18|�Ƿ��ӡ������19|
	 *             �Ƿ�����Ż�20|�Ƿ�Ӫҵ���Ż�21|ͣ��״̬�Ƿ���ȡ�����22|�Ƿ������Ա�Ż�23|��Դ24|Ӫ�����25|
	 *             Ӫ���������26|���ⷽ����־27|�Żݷ�Χ28|�ʷ�˵��29|˵��30|
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
	 * �������ļ��ĺϷ���(������ʽƥ��)
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

	// ���С���鼰С������
	private void checkGroup(FeediscVO feedVO, User user) throws Exception {
		AreaGroupInfoDAO groupInfoDAO = (AreaGroupInfoDAO) DAOFactory.build(
				AreaGroupInfoDAO.class, user);
		AreaGroupInfoVO groupInfoVO = (AreaGroupInfoVO) groupInfoDAO
				.findByPk(feedVO.getAreagroupid());
		if (groupInfoVO == null) {
			throw new Exception("[С����](" + feedVO.getAreagroupid().toString()
					+ ")������!");
		}
		AreaGroupScaleDAO areaGroupScaleDAO = (AreaGroupScaleDAO) DAOFactory
				.build(AreaGroupScaleDAO.class, user);
		AreaGroupScaleListVO listVO = new AreaGroupScaleListVO();
		listVO.set_ne_areagroupid(feedVO.getAreagroupid().toString());
		listVO.set_ne_areagroupid(feedVO.getAreacod());
		if (areaGroupScaleDAO.query(listVO).getDatas().size() <= 0) {
			throw new Exception("[С������](" + feedVO.getAreacod()
					+ ")�����ڻ���[С����](" + feedVO.getAreagroupid().toString()
					+ ")��!");
		}
	}

	// ����˵���Ŀ��ʶ
	private void checkAcctid(FeediscVO feedVO, User user) throws Exception {

		// ת������
		AcctVO vo = new AcctVO();
		vo.setAcctid(feedVO.getAcctid());
		AcctDAO acctDAO = (AcctDAO) DAOFactory.build(AcctDAO.class, user);
		AcctVO voResult = (AcctVO) acctDAO.findByPk(vo.getAcctid());
		if (voResult == null) {
			throw new Exception("[�˵���Ŀ��ʶ](" + feedVO.getAcctid() + ")����ر��в�����");
		}
		if (voResult.getAcctstate().intValue() != 1) {
			throw new Exception("[�˵���Ŀ��ʶ](" + feedVO.getAcctid() + ")�ѽ���");
		}
	}

	// ����Ż�����DiscKind
	private void checkDisckind(FeediscVO feedVO, User user) throws Exception {
		// ת������
		DictitemVO vo = new DictitemVO();
		vo.setDictid(feedVO.getDisckind());
		DictitemDAO dictitemDAO = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_dictid(vo.getDictid());
		listVO.set_se_groupid("PC_FEEDISCTYPE");
		DataPackage dp = dictitemDAO.query(listVO, true);
		if (dp.getRowCount() <= 0) {
			throw new Exception("[�Ż�����](" + feedVO.getDisckind() + ")������");
		}
	}

	// ��� ������Ч�ʵ��Żݴ���
	private void checkCurrbillcode(FeediscVO feedVO, User user)
			throws Exception {
		// ת������
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_CURRBILLCODE");
		listVO.set_se_dictid(feedVO.getCurrbillcode());
		DictitemDAO dictitemDAO = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DataPackage dp = dictitemDAO.query(listVO, true);
		if (dp.getRowCount() <= 0) {
			throw new Exception("[������Ч�ʵ��Żݴ���](" + feedVO.getCurrbillcode()
					+ ")������");
		}
	}

	/**
	 * ����Ƿ����
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
					"�Ƿ�����ֶ����ݲ��Ϸ�����ο�0 ���Ų��������ܷѡ��������ײͷ�;1 ���Ų��������ܷѡ������ײͷ�;2 ���Ŵ������ܷѡ��������ײͷ�;3 ���Ŵ������ܷѡ������ײͷ�");
		}
	}

	/**
	 * ��������ֵ���ֶ��Ƿ���ֵ�����û��ֵǿ�ƺ�̨����Ĭ��ֵ�� �Ƿ�ʱ�ϴ�schedsendflag �Ƿ����paybyothersflag
	 * ҵ������busitype ����ƽ̨accessplatform ȫ��ͨ���з���gotoneuprate ȫ��ͨ���з���
	 * gotonedownrate ���������з���smpuprate ���������з���smpdownrate
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
