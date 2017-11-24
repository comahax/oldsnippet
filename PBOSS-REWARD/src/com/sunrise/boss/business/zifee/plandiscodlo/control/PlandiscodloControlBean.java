/**
* auto-generated code
* Fri Oct 20 14:08:21 CST 2006
*/
package com.sunrise.boss.business.zifee.plandiscodlo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.plandiscodlo.persistent.PlandiscodloVO;
import com.sunrise.boss.business.zifee.plandiscodlo.persistent.PlandiscodloDAO;
import com.sunrise.boss.business.zifee.plandiscodlo.persistent.PlandiscodloListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;

/**
 * <p>Title: PlandiscodloControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/plandiscodlo/control/PlandiscodloControlBean"
*    name="PlandiscodloControl"
*    view-type="local"
*    type="Stateless"
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required" 
*/
public class PlandiscodloControlBean extends AbstractControlBean
    implements PlandiscodloControl {

    public PlandiscodloVO doCreate(PlandiscodloVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         PlandiscodloDAO dao = (PlandiscodloDAO) DAOFactory.build(PlandiscodloDAO.class, user);
            return (PlandiscodloVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(PlandiscodloVO vo, User user)
        throws Exception {
        try{
         PlandiscodloDAO dao = (PlandiscodloDAO) DAOFactory.build(PlandiscodloDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PlandiscodloVO doUpdate(PlandiscodloVO vo, User user)
        throws Exception {
        try{
         PlandiscodloDAO dao = (PlandiscodloDAO) DAOFactory.build(PlandiscodloDAO.class, user);
            return (PlandiscodloVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PlandiscodloVO doFindByPk(Serializable pk, User user)
        throws Exception {
         PlandiscodloDAO dao = (PlandiscodloDAO) DAOFactory.build(PlandiscodloDAO.class, user);
        return (PlandiscodloVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(PlandiscodloListVO params, User user)
        throws Exception {
         PlandiscodloDAO dao = (PlandiscodloDAO) DAOFactory.build(PlandiscodloDAO.class, user);
         YxPlanListVO yxListVO = new YxPlanListVO();
			//过虑日志记录，其他区域的日志信息不显示，集团统一营销案,全省,市公司,区域标识为空也在查询范围内
			String _sql_areacode = " (areacode is null or  areacode in ('999','','"
					+ user.getCityid() + "')) ";
			yxListVO.set_sql_areacode(_sql_areacode);
			PlandiscodloListVO paramListVO = new PlandiscodloListVO();
			BeanUtils.copyProperties(paramListVO, params);
			Object[] objs = { paramListVO, yxListVO };
			Class[] classes = { PlandiscodloVO.class, YxPlanVO.class };
			String[][] joins = { { "yxplanid", "yxplanid" } };
			return dao.query2(objs, classes, joins);
    }
}
