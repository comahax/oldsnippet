/**
 * auto-generated code
 * Fri Jul 11 10:08:49 CST 2008
 */
package com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.control;

import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisDAO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqDAO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqListVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: ChgReqControlBean
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
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/qsmanage/paramsmanage/chgreq/control/ChgReqControlBean"
 *           name="ChgReqControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ChgReqControlBean extends AbstractControlBean implements
		ChgReqControl {

	public void doUpdate(ChgReqVO vo, User user) throws Exception {

		try {
			ChgReqDAO reqdao = (ChgReqDAO) DAOFactory.build(ChgReqDAO.class, user.getCityid());
			ChgHisDAO hisdao = (ChgHisDAO) DAOFactory.build(ChgHisDAO.class, user.getCityid());
			
			ChgReqVO oldvo = (ChgReqVO) reqdao.findByPk(vo.getReqid());
			if(oldvo.getOprstate().intValue() == 4 && vo.getOprstate().intValue() != 3){
				throw new Exception("审批状态为4：审批不通过的请求只能做撤消变更操作！！");
			}
			oldvo.setChkinfo(vo.getChkinfo());
			oldvo.setOprstate(vo.getOprstate());
			oldvo.setOprtime(vo.getOprtime());
			oldvo.setOprcode(vo.getOprcode());
			BeanUtils.copyProperties(oldvo, vo);
			reqdao.update(oldvo);

			
			ChgHisVO hisvo = new ChgHisVO();
			BeanUtils.copyProperties(hisvo, oldvo);
			hisdao.create(hisvo);
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}

	}
	
	public void doBatch(ChgReqVO vo, User user) throws Exception {

		try {
			ChgReqDAO reqdao = (ChgReqDAO) DAOFactory.build(ChgReqDAO.class, user);
			ChgHisDAO hisdao = (ChgHisDAO) DAOFactory.build(ChgHisDAO.class, user.getCityid());
			DataPackage dp = null ;
			ChgReqListVO listVO = new ChgReqListVO();
			listVO.set_ne_matchid(vo.getMatchid().toString());
			listVO.set_pagesize("0");
			dp = reqdao.query(listVO, false);
			
			if(dp != null && dp.getDatas() != null && dp.getDatas().size() != 0){
				for(int i = 0 ; i < dp.getDatas().size() ; i++){
					ChgReqVO tmpvo = (ChgReqVO) dp.toList(ChgReqVO.class).get(i);
					ChgReqVO reqvo = (ChgReqVO) reqdao.findByPk(tmpvo.getReqid());
					if(reqvo.getOprstate().intValue() == 4 && vo.getOprstate().intValue() != 3){
						continue;
					}
					reqvo.setChkinfo(vo.getChkinfo());
					reqvo.setOprstate(vo.getOprstate());
					reqvo.setOprtime(vo.getOprtime());
					reqvo.setOprcode(vo.getOprcode());
					
					reqdao.update(reqvo);
					
					ChgHisVO hisvo = new ChgHisVO();
					BeanUtils.copyProperties(hisvo, reqvo);
					hisdao.create(hisvo);
				}
			}
			
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}

	}


}
