/**
* auto-generated code
* Wed Dec 07 14:34:03 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.unvrcfailday.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayVO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayDAO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayListVO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.VUnvrcfaildayDAO;

/**
 * <p>Title: UnvrcfaildayControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/unvrcfailday/control/UnvrcfaildayControlBean"
 name="UnvrcfaildayControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class UnvrcfaildayControlBean extends AbstractControlBean
    implements UnvrcfaildayControl {

    public UnvrcfaildayVO doCreate(UnvrcfaildayVO vo, User user)
        throws Exception {
        try{
			UnvrcfaildayDAO dao = (UnvrcfaildayDAO) DAOFactory.build(UnvrcfaildayDAO.class, user);
            // TODO  set the pk */
            return (UnvrcfaildayVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(UnvrcfaildayVO vo, User user)
        throws Exception {
        try{
			UnvrcfaildayDAO dao = (UnvrcfaildayDAO) DAOFactory.build(UnvrcfaildayDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvrcfaildayVO doUpdate(UnvrcfaildayVO vo, User user)
        throws Exception {
        try{
			UnvrcfaildayDAO dao = (UnvrcfaildayDAO) DAOFactory.build(UnvrcfaildayDAO.class, user);
            return (UnvrcfaildayVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public UnvrcfaildayVO doFindByPk(Serializable pk, User user)
        throws Exception {
			UnvrcfaildayDAO dao = (UnvrcfaildayDAO) DAOFactory.build(UnvrcfaildayDAO.class, user);
        return (UnvrcfaildayVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(UnvrcfaildayListVO params, User user)
        throws Exception {
			UnvrcfaildayDAO dao = (UnvrcfaildayDAO) DAOFactory.build(UnvrcfaildayDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQueryWithEmpinfo(UnvrcfaildayListVO params, User user)
    	throws Exception{
    	VUnvrcfaildayDAO dao = (VUnvrcfaildayDAO) DAOFactory.build(VUnvrcfaildayDAO.class, user);
    	String oprcode = user.getOpercode();//登录工号
    	UnvrcfaildayListVO listvo = new UnvrcfaildayListVO();
    	listvo.getQueryConditions().put("oprcode", oprcode);
    	Integer cityAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCityAdmin", listvo, Integer.class);
    	if(cityAdmin!=null && cityAdmin>0){//不为空，登录工号为市公司管理员
			return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.unvrcfailday.queryVUnvrifaildayCityAdmin", params);
		}else{
			listvo = new UnvrcfaildayListVO();
			listvo.getQueryConditions().put("oprcode", oprcode);
			String upperwayid = "TD"+SessionFactoryRouter.conversionCityid(user.getCityid())+"-----";//市公司对应渠道编码
			listvo.getQueryConditions().put("upperwayid", upperwayid);
			Integer countyAdmin = (Integer)dao.queryUniqueByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.isCountyAdmin", listvo, Integer.class);
			if(countyAdmin!=null && countyAdmin>0){//不为空，登录工号为分公司管理员
				params.getQueryConditions().put("wayid", user.getWayid());
				return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.bbc.unvrcfailday.queryVUnvrifaildayCountyAdmin", params);
			}else{//登陆工号不是市公司管理员或分公司管理员，不允许使用该功能
				throw new Exception("登陆工号不是市公司管理员或分公司管理员，不允许使用该功能");
			}
		}
    }
}
