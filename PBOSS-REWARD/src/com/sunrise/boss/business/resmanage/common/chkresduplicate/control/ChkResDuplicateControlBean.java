package com.sunrise.boss.business.resmanage.common.chkresduplicate.control;

import com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent.ChkResDuplicateDAO;
import com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent.ChkResDuplicateListVO;
import com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent.ChkResDuplicateVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;

/**
 * 2.2.3.17	资源批量调拨重复性检查模块
 * @author David
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/resmanage/common/chkresduplicate/control/ChkResDuplicateControlBean"
 *           name="ChkResDuplicateControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ChkResDuplicateControlBean extends AbstractControlBean implements
		ChkResDuplicateControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1934158897359038240L;

	/**
	 * 根据资源编号、商品标识、资源操作动作、流入渠道、流出渠道从资源请求表中查询记录总数返回
	 */
	public int doChkResDupl(ChkResDuplicateVO vo, User user) throws Exception {
		int recCount = 0;
		ChkResDuplicateDAO dao = (ChkResDuplicateDAO)DAOFactory.build(ChkResDuplicateDAO.class, user);
		dao.setVoClass(vo.getResreqvo());//voClass在获得DAO实例后再设置
		ChkResDuplicateListVO listvo = new ChkResDuplicateListVO();
		listvo.set_snl_begno(vo.getResno());
		listvo.set_snm_endno(vo.getResno());
		listvo.set_ne_comid(vo.getComid().toString());
		listvo.set_ne_resoprtype(vo.getResoprtype().toString());
		listvo.set_se_inwayid(vo.getInwayid());
		listvo.set_se_outwayid(vo.getOutwayid());
		recCount = dao.count(listvo);
		return recCount;
	}

}
