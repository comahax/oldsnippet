/**
* auto-generated code
* Wed Oct 18 21:00:42 CST 2006
*/
package com.sunrise.boss.business.zifee.fixfeedisclog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeedislogVO;
import com.sunrise.boss.business.zifee.fixfeedisclog.persistent.FixfeedisclogDAO;
import com.sunrise.boss.business.zifee.fixfeedisclog.persistent.FixfeedisclogListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;

/**
 * <p>Title: FixfeedisclogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/fixfeedisclog/control/FixfeedisclogControlBean"
 name="FixfeedisclogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class FixfeedisclogControlBean extends AbstractControlBean
    implements FixfeedisclogControl {

    public PcPsFixfeedislogVO doCreate(PcPsFixfeedislogVO vo, User user)
        throws Exception {
        try{
			FixfeedisclogDAO dao = (FixfeedisclogDAO) DAOFactory.build(FixfeedisclogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (PcPsFixfeedislogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(PcPsFixfeedislogVO vo, User user)
        throws Exception {
        try{
			FixfeedisclogDAO dao = (FixfeedisclogDAO) DAOFactory.build(FixfeedisclogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PcPsFixfeedislogVO doUpdate(PcPsFixfeedislogVO vo, User user)
        throws Exception {
        try{
			FixfeedisclogDAO dao = (FixfeedisclogDAO) DAOFactory.build(FixfeedisclogDAO.class, user.getCityid());
            return (PcPsFixfeedislogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PcPsFixfeedislogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			FixfeedisclogDAO dao = (FixfeedisclogDAO) DAOFactory.build(FixfeedisclogDAO.class, user.getCityid());
        return (PcPsFixfeedislogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(FixfeedisclogListVO params, User user)
        throws Exception {
			FixfeedisclogDAO dao = (FixfeedisclogDAO) DAOFactory.build(FixfeedisclogDAO.class, user.getCityid());
			YxPlanListVO yxListVO = new YxPlanListVO();
			//过虑日志记录，其他区域的日志信息不显示，集团统一营销案,全省,市公司,区域标识为空也在查询范围内
			String _sql_areacode = " (areacode is null or  areacode in ('999','','"
					+ user.getCityid() + "')) ";
			yxListVO.set_sql_areacode(_sql_areacode);
			FixfeedisclogListVO paramListVO = new FixfeedisclogListVO();
			BeanUtils.copyProperties(paramListVO, params);
			Object[] objs = { paramListVO, yxListVO };
			Class[] classes = { PcPsFixfeedislogVO.class, YxPlanVO.class };
			String[][] joins = { { "yxplanid", "yxplanid" } };
			return dao.query2(objs, classes, joins);
    }
}
