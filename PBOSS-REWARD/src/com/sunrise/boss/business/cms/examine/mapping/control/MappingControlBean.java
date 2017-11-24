/**
* auto-generated code
* Sat Nov 28 17:48:47 CST 2009
*/
package com.sunrise.boss.business.cms.examine.mapping.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingDAO;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingListVO;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: MappingControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/mapping/control/MappingControlBean"
 name="MappingControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MappingControlBean extends AbstractControlBean
    implements MappingControl {

    public MappingVO doCreate(MappingVO vo, User user)
        throws Exception {
        try{
			MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class, user);
            // TODO  set the pk */
            return (MappingVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(MappingVO vo, User user)
        throws Exception {
        try{
			MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MappingVO doUpdate(MappingVO vo, User user)
        throws Exception {
        try{
			MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class, user);
            return (MappingVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MappingVO doFindByPk(Serializable pk, User user)
        throws Exception {
			MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class, user);
        return (MappingVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(MappingListVO params, User user)
        throws Exception {
			MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class, user);
        return dao.query(params);
    }
    public boolean doCheckBeingMark(MappingVO vo, User user)
    throws Exception{
    	MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class, user);
    	return dao.doCheckBeingMark(vo, user);
    }
	public String doQueryToCheck(MappingListVO params,User user) throws Exception {
		// TODO Auto-generated method stub
		DataPackage dataPackage = new DataPackage();
		StringBuffer loseArea = new StringBuffer(50);
		MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class,user);
		params.set_pagesize("0");
		params.set_orderby("markll");
		params.set_desc("0");//设置成升序排序
		DataPackage dp = dao.query(params);
		List dpList = (List)dp.getDatas();
		for(int i = 0;i<dpList.size()-1;i++)
		{
			MappingVO vo1 = (MappingVO)dpList.get(i);
			MappingVO vo2 = (MappingVO)dpList.get(i+1);
			if(i==0 && vo1.getMarkll().doubleValue()>0){//检查是否从0开始
				loseArea.append("[0,").append(vo1.getMarkll()).append(")");
			}
			if((vo2.getMarkll().doubleValue()-vo1.getMarkul().doubleValue())>0.01){
				loseArea.append("[").append(vo1.getMarkul()).append(",");
				loseArea.append(vo2.getMarkll()).append("), ");
			}
		}
		if(dpList.size() == 1){
			MappingVO vo1 = (MappingVO)dpList.get(0);
			if(vo1.getMarkll().doubleValue()>0){//检查是否从0开始
				loseArea.append("[0,").append(vo1.getMarkll()).append(")");
			}
		}
		return loseArea.toString();
	}
	 public DataPackage doQueryMappingList(MappingListVO params, User user)
	    throws Exception{
		 MappingDAO dao = (MappingDAO) DAOFactory.build(MappingDAO.class, user);
		 return dao.queryMappingList(params, SessionFactoryRouter.conversionCityid(user.getCityid()));
	 }
}
