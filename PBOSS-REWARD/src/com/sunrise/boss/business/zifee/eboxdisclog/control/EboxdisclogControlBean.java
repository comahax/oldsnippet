/**
* auto-generated code
* Thu Oct 19 11:53:38 CST 2006
*/
package com.sunrise.boss.business.zifee.eboxdisclog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.eboxdisclog.persistent.EboxdisclogVO;
import com.sunrise.boss.business.zifee.eboxdisclog.persistent.EboxdisclogDAO;
import com.sunrise.boss.business.zifee.eboxdisclog.persistent.EboxdisclogListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;

/**
 * <p>Title: EboxdisclogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/eboxdisclog/control/EboxdisclogControlBean"
*    name="EboxdisclogControl"
*    view-type="local"
*    type="Stateless"
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"    
*/
public class EboxdisclogControlBean extends AbstractControlBean
    implements EboxdisclogControl {

    public EboxdisclogVO doCreate(EboxdisclogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         EboxdisclogDAO dao = (EboxdisclogDAO) DAOFactory.build(EboxdisclogDAO.class, user);
            return (EboxdisclogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(EboxdisclogVO vo, User user)
        throws Exception {
        try{
         EboxdisclogDAO dao = (EboxdisclogDAO) DAOFactory.build(EboxdisclogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public EboxdisclogVO doUpdate(EboxdisclogVO vo, User user)
        throws Exception {
        try{
         EboxdisclogDAO dao = (EboxdisclogDAO) DAOFactory.build(EboxdisclogDAO.class, user);
            return (EboxdisclogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public EboxdisclogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         EboxdisclogDAO dao = (EboxdisclogDAO) DAOFactory.build(EboxdisclogDAO.class, user);
        return (EboxdisclogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(EboxdisclogListVO params, User user)
        throws Exception {
         EboxdisclogDAO dao = (EboxdisclogDAO) DAOFactory.build(EboxdisclogDAO.class, user);
         YxPlanListVO yxListVO = new YxPlanListVO();
   		//过虑日志记录，其他区域的日志信息不显示，集团统一营销案,全省,市公司,区域标识为空也在查询范围内
   		String _sql_areacode = " (areacode is null or  areacode in ('999','','"
   				+ user.getCityid() + "')) ";
   		yxListVO.set_sql_areacode(_sql_areacode);
   		EboxdisclogListVO paramListVO = new EboxdisclogListVO();
   		BeanUtils.copyProperties(paramListVO, params);
   		Object[] objs = { paramListVO, yxListVO };
   		Class[] classes = { EboxdisclogVO.class, YxPlanVO.class };
   		String[][] joins = { { "yxplanid", "yxplanid" } };
   		return dao.query2(objs, classes, joins);
    }
}
