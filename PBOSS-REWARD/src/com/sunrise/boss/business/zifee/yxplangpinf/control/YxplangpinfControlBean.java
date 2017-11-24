/**
 * auto-generated code
 * Sat Jan 13 14:53:14 CST 2007
 */
package com.sunrise.boss.business.zifee.yxplangpinf.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfVO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfDAO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfListVO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupListVO;
import com.sunrise.boss.business.zifee.yxplangroup.control.YxPlanGroupControl;
import com.sunrise.boss.business.zifee.yxplangroup.control.YxPlanGroupControlBean;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.exception.delegate.DelegateException;

/**
 * <p>
 * Title: YxplangpinfControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/yxplangpinf/control/YxplangpinfControlBean"
 *           name="YxplangpinfControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class YxplangpinfControlBean extends AbstractControlBean implements
		YxplangpinfControl {

	public YxplangpinfVO doCreate(YxplangpinfVO vo, User user) throws Exception {
		try {
			YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
					YxplangpinfDAO.class, user);
			if (null == vo.getAreacode()
					|| !vo.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				throw new BusinessException("",
						"����ʧ��,��ǰӪ����������������ʶΪ�ջ��뵱ǰ�������������ʶ��һ��");
			}
			// TODO set the pk */
			return (YxplangpinfVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(YxplangpinfVO vo, User user) throws Exception {
		try {
			YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
					YxplangpinfDAO.class, user);
			if (null == vo.getGroupid())
				throw new BusinessException("", "ɾ��Ӫ����������ʱ����Ӫ�����������ʶΪ��");
			Long pk = vo.getGroupid();
			if (null == vo.getAreacode()
					|| !vo.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				throw new BusinessException("",
						"ɾ��Ӫ�����������ʶʧ��,��ǰӪ���������������ʶΪ�ջ��뵱ǰ�������������ʶ��һ��,������ɾ��");
			}
			YxPlanGroupListVO groupMemListVO = new YxPlanGroupListVO();
			groupMemListVO.set_ne_groupyxplan(pk.toString());
			YxPlanGroupControl yxPlanGroupControl = (YxPlanGroupControl) ControlFactory
					.build(YxPlanGroupControlBean.class);
			if (null == yxPlanGroupControl) {
				throw new DelegateException(this.getClass()
						+ " initialize failed");
			}
			DataPackage groupMemVO = yxPlanGroupControl.doQuery(groupMemListVO,
					user);
			if (null != groupMemVO && groupMemVO.getRowCount() > 0) {
				String msginf = "������ɾ����Ӫ�����������ʶ[" + pk
						+ "]�´��ڳ�ԱӪ������������ɾ����ԱӪ��������ɾ��Ӫ����������";
				throw new BusinessException("", msginf);
			}
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplangpinfVO doUpdate(YxplangpinfVO vo, User user) throws Exception {
		try {
			YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
					YxplangpinfDAO.class, user);
			if (null == vo.getAreacode()
					|| !vo.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				throw new BusinessException("",
						"�޸�ʧ��,��ǰӪ����������������ʶΪ�ջ��뵱ǰ�������������ʶ��һ�£��������޸�");
			}
			return (YxplangpinfVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplangpinfVO doFindByPk(Serializable pk, User user)
			throws Exception {
		YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
				YxplangpinfDAO.class, user);
		return (YxplangpinfVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(YxplangpinfListVO params, User user)
			throws Exception {
		YxplangpinfDAO dao = (YxplangpinfDAO) DAOFactory.build(
				YxplangpinfDAO.class, user);
		return dao.query(params);
	}
}
