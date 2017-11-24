/**
* auto-generated code
* Tue May 01 15:39:58 CST 2007
*/
package com.sunrise.boss.business.cms.coststatrelative.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeVO;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeDAO;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeListVO;

/**
 * <p>Title: CoststatrelativeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/coststatrelative/control/CoststatrelativeControlBean"
 name="CoststatrelativeControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CoststatrelativeControlBean extends AbstractControlBean
    implements CoststatrelativeControl {

    public CoststatrelativeVO doCreate(CoststatrelativeVO vo, User user)
        throws Exception {
        try{
         CoststatrelativeDAO dao = (CoststatrelativeDAO) DAOFactory.build(CoststatrelativeDAO.class, user);
            return (CoststatrelativeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CoststatrelativeVO vo, User user)
        throws Exception {
        try{
         CoststatrelativeDAO dao = (CoststatrelativeDAO) DAOFactory.build(CoststatrelativeDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CoststatrelativeVO doUpdate(CoststatrelativeVO vo, User user)
        throws Exception {
        try{
         CoststatrelativeDAO dao = (CoststatrelativeDAO) DAOFactory.build(CoststatrelativeDAO.class, user);
            return (CoststatrelativeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CoststatrelativeVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CoststatrelativeDAO dao = (CoststatrelativeDAO) DAOFactory.build(CoststatrelativeDAO.class, user);
        return (CoststatrelativeVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CoststatrelativeListVO params, User user)
        throws Exception {
         CoststatrelativeDAO dao = (CoststatrelativeDAO) DAOFactory.build(CoststatrelativeDAO.class, user);
        return dao.query(params);
    }
	public void doSave(List strtitem, List scaleitem, Long ID, User user) throws Exception {
		CoststatrelativeListVO listVO = new CoststatrelativeListVO();
		listVO.set_ne_recid(ID.toString());
		List list = (List)doQuery(listVO, user).getDatas();
		for(int k = 0; k < list.size(); k++){
			doRemove((CoststatrelativeVO)list.get(k), user);
		}
		if(strtitem != null && strtitem.size() > 0){
			for (int i = 0; i < strtitem.size(); i++) {
				CoststatrelativeVO coststatrelativeVO = new CoststatrelativeVO();
				coststatrelativeVO.setRecid(ID);
				coststatrelativeVO.setFnlcostitem(new Short(strtitem.get(i).toString()));
				coststatrelativeVO.setStatmode(new Short((short) 0));
				doCreate(coststatrelativeVO, user);
			}
		}
		if(scaleitem!= null && scaleitem.size() > 0){
			for (int j = 0; j < scaleitem.size(); j++) {
				CoststatrelativeVO vo = new CoststatrelativeVO();
				vo.setRecid(ID);
				vo.setFnlcostitem(new Short(scaleitem.get(j).toString()));
				vo.setStatmode(new Short((short) 1));
				doCreate(vo, user);
			} 
		}
	}
}
