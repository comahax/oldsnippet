/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custintechg.control;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteDAO;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteVO;
import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgDAO;
import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgListVO;
import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * 
 * Title: CustInteChgControlBean Description: Copyright: Copyright (c) 2006
 * Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/integral/custintechg/control/CustInteChgControlBean"
*    name="CustInteChgControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CustInteChgControlBean extends AbstractControlBean implements
		CustInteChgControl {


	private Logger log = Logger.getLogger(CustInteChgControlBean.class);

	public DataPackage doQueryInteLog(CustInteChgListVO params, User user) throws Exception {
		
		CustInteChgDAO dao = (CustInteChgDAO) DAOFactory.build(CustInteChgDAO.class,user.getCityid());

		return dao.query(params);
	}

	//积分回退
	public void doInteback(Long logid, User user) throws Exception{
		
		CustInteChgDAO dao = (CustInteChgDAO) DAOFactory.build(CustInteChgDAO.class, user.getCityid());
		CustInteChgVO vo = (CustInteChgVO) dao.findByPk((Serializable)logid);
		
		//判断积分变更原因是否在系统参数定义的积分变更原因内
		String params = FEEUtils.getSysParamValue(79, user);
		String[] param = params.split(",");
		for (int i = 0; i < param.length; i++) {
			if (param[i].equals(vo.getIntchgrsn().toString())) {
				break;
			} else if (i == param.length - 1
					&& !param[i].equals(vo.getIntchgrsn().toString())) {
				throw new Exception("该业务不允许回退！");
			}
		}
		
		CustInteChgVO tmpvo = null;
		try {
			String logs[] = vo.getDescrp().split("~");
			Long tmplogid = new Long(logs[0]);
			tmpvo = (CustInteChgVO) dao.findByPk((Serializable) tmplogid);
		} catch (Exception e) {
			//抛出异常的话表示未做过回退，不对异常处理，继续处理下面的业务
		}
		
		if (tmpvo != null && tmpvo.getCustid().equals(vo.getCustid())
			&& tmpvo.getIntegralcyc().equals(vo.getIntegralcyc())
			&& tmpvo.getIntchgrsn().equals(new Integer(75))
			&& tmpvo.getDescrp().equals(vo.getLogid().toString())) {
			throw new Exception("该记录已经回退过，不允许再次回退！");
		}
		
		try {//回退业务
			CustInteVO intvo = new CustInteVO();
			intvo.setCustid(vo.getCustid());
			intvo.setIntegralcyc(vo.getIntegralcyc());
			
			
			CustInteDAO dao1 = (CustInteDAO) DAOFactory.build(CustInteDAO.class, user.getCityid());
			CustInteVO invo = (CustInteVO) dao1.findByPk((Serializable)intvo);
			if(invo == null){
				throw new Exception("未找到客户积分记录！！");
			}
				
			CustInteChgVO logvo = new CustInteChgVO();
			BeanUtils.copyProperties(logvo, vo);
					
			logvo.setBeforeavlint(invo.getAvailintegral());
			invo.setAvailintegral(new Long(invo.getAvailintegral().longValue()
					+ vo.getBeforeavlint().longValue()
					- vo.getAfteravlint().longValue()));
			invo.setMoveint(new Long(invo.getMoveint().longValue()
					- vo.getBeforeavlint().longValue()
					+ vo.getAfteravlint().longValue()));
			dao1.update(invo);
					
			logvo.setLogid(null);
			logvo.setAfteravlint(invo.getAvailintegral());
			logvo.setUpdatetime(new Date(System.currentTimeMillis()));
			logvo.setOprcode(user.getOpercode());
			logvo.setIntchgrsn(new Integer(75));
			logvo.setDescrp(vo.getLogid().toString());
			dao.create(logvo);
			
			vo.setDescrp(logvo.getLogid() + "~" + (vo.getDescrp() == null? "" : vo.getDescrp()));
			dao.update(vo);
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}
	}

	
	

	
}
