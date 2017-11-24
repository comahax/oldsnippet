/**
* auto-generated code
* Tue Oct 28 11:34:48 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.control;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.business.cms.zjty.zjtystdreward.control.ZjtyStdrewardControl;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.control.ZjtyStdrewardControlBean;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjDAO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjListVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ZjtyStdrewardbjControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtystdrewardbj/control/ZjtyStdrewardbjControlBean"
 name="ZjtyStdrewardbjControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyStdrewardbjControlBean extends AbstractControlBean
    implements ZjtyStdrewardbjControl {

    public ZjtyStdrewardbjVO doCreate(ZjtyStdrewardbjVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardbjDAO dao = (ZjtyStdrewardbjDAO) DAOFactory.build(ZjtyStdrewardbjDAO.class, user);
            // TODO  set the pk */
            return (ZjtyStdrewardbjVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ZjtyStdrewardbjVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardbjDAO dao = (ZjtyStdrewardbjDAO) DAOFactory.build(ZjtyStdrewardbjDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyStdrewardbjVO doUpdate(ZjtyStdrewardbjVO vo, User user)
        throws Exception {
        try{
			ZjtyStdrewardbjDAO dao = (ZjtyStdrewardbjDAO) DAOFactory.build(ZjtyStdrewardbjDAO.class, user);
            return (ZjtyStdrewardbjVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyStdrewardbjVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyStdrewardbjDAO dao = (ZjtyStdrewardbjDAO) DAOFactory.build(ZjtyStdrewardbjDAO.class, user);
        return (ZjtyStdrewardbjVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyStdrewardbjListVO params, User user)
        throws Exception {
			ZjtyStdrewardbjDAO dao = (ZjtyStdrewardbjDAO) DAOFactory.build(ZjtyStdrewardbjDAO.class, user);
        return dao.query(params);
    }
    
	/**
	 * 计件酬金标准设置 保存
	 * 
	 * @param list
	 * @param user
	 * @throws Exception
	 */
	public void doSave(List list, User user) throws Exception {
		try {
			if (null == list || list.size() == 0) {
				return;
			}

			ZjtyStdrewardbjDAO dao = (ZjtyStdrewardbjDAO) DAOFactory.build(
					ZjtyStdrewardbjDAO.class, user);
			ZjtyStdrewardControl zjtystdrewardControl = (ZjtyStdrewardControl) ControlFactory
					.build(ZjtyStdrewardControlBean.class);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				ZjtyStdrewardVO zjtystdrewardVO = new ZjtyStdrewardVO();
				BeanUtils.copyProperties(zjtystdrewardVO, item);

				//删除操作
				if (item.isDeletefalg()) {
					zjtystdrewardControl.doRemove(zjtystdrewardVO, user);
					ZjtyStdrewardbjVO zjtystdrewardbjVO = new ZjtyStdrewardbjVO();
					BeanUtils.copyProperties(zjtystdrewardbjVO, item);
					zjtystdrewardbjVO.setRewardid(item.getRewardid());
					dao.remove(zjtystdrewardbjVO);
					continue;
				}
				
				//新增或更新操作
				if (null == item.getRewardid()) {
					zjtystdrewardVO = zjtystdrewardControl.doCreate(zjtystdrewardVO, user);
				} else {
					zjtystdrewardVO = zjtystdrewardControl.doUpdate(zjtystdrewardVO, user);
				}

				ZjtyStdrewardbjVO zjtystdrewardbjVO = new ZjtyStdrewardbjVO();
				BeanUtils.copyProperties(zjtystdrewardbjVO, item);
				zjtystdrewardbjVO.setRewardid(item.getRewardid());
				if (null == item.getRewardid()) {
					dao.create(zjtystdrewardbjVO);
				} else {
					dao.update(zjtystdrewardbjVO);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	/**
	 * 市公司计件酬金上限设置 保存
	 * 
	 * @param list
	 * @param user
	 * @throws Exception
	 */
	public void doSavecity(List list, User user) throws Exception {
		try {
			if (null == list || list.size() == 0) {
				return;
			}
	
			ZjtyStdrewardbjDAO dao = (ZjtyStdrewardbjDAO) DAOFactory.build(
					ZjtyStdrewardbjDAO.class, user);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				ZjtyStdrewardbjVO item = (ZjtyStdrewardbjVO) iter.next();
				ZjtyStdrewardbjVO vo = new ZjtyStdrewardbjVO();
				vo.setRegion(user.getCityid());
				vo.setRewardid(item.getRewardid());
				vo.setWayid(item.getWayid());
				vo = (ZjtyStdrewardbjVO) dao.findByPk(vo);
				if (null == vo) {
					item.setRegion(user.getCityid());
					dao.create(item);
				} else {
					BeanUtils.copyProperties(vo, item);
					dao.update(vo);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
