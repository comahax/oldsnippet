/**
* auto-generated code
* Fri Feb 01 12:08:34 CST 2013
*/
package com.sunrise.boss.business.cms.chadtclassplatformtdinfo.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoDAO;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoListVO;

/**
 * <p>Title: ChAdtClassplatformtdinfoControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtclassplatformtdinfo/control/ChAdtClassplatformtdinfoControlBean"
 name="ChAdtClassplatformtdinfoControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtClassplatformtdinfoControlBean extends AbstractControlBean
    implements ChAdtClassplatformtdinfoControl {

    public ChAdtClassplatformtdinfoVO doCreate(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformtdinfoDAO dao = (ChAdtClassplatformtdinfoDAO) DAOFactory.build(ChAdtClassplatformtdinfoDAO.class, user);
			//add verify
			//加上 COMID、startdate、enddate、citycode 唯一的判断
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			ChAdtClassplatformtdinfoListVO chAdtClassplatformtdinfoListVO = new ChAdtClassplatformtdinfoListVO();
			chAdtClassplatformtdinfoListVO.set_se_comid(vo.getComid());
			chAdtClassplatformtdinfoListVO.set_de_startdate(format.format(vo.getStartdate()));
			chAdtClassplatformtdinfoListVO.set_de_enddate(format.format(vo.getEnddate()));
			chAdtClassplatformtdinfoListVO.set_ne_citycode(vo.getCitycode()+"");
			
			DataPackage dp =  dao.query(chAdtClassplatformtdinfoListVO);
			if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
				throw new Exception("数据重复，请检查后再次保存！");			
			}else{
				 return (ChAdtClassplatformtdinfoVO) dao.create(vo);
			}		
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformtdinfoDAO dao = (ChAdtClassplatformtdinfoDAO) DAOFactory.build(ChAdtClassplatformtdinfoDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtClassplatformtdinfoVO doUpdate(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformtdinfoDAO dao = (ChAdtClassplatformtdinfoDAO) DAOFactory.build(ChAdtClassplatformtdinfoDAO.class, user);
			//add verify
			//加上 COMID、startdate、enddate、citycode 唯一的判断
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			ChAdtClassplatformtdinfoListVO chAdtClassplatformtdinfoListVO = new ChAdtClassplatformtdinfoListVO();
			chAdtClassplatformtdinfoListVO.set_se_comid(vo.getComid());
			chAdtClassplatformtdinfoListVO.set_de_startdate(format.format(vo.getStartdate()));
			chAdtClassplatformtdinfoListVO.set_de_enddate(format.format(vo.getEnddate()));
			chAdtClassplatformtdinfoListVO.set_ne_citycode(vo.getCitycode()+"");
			
			DataPackage dp =  dao.query(chAdtClassplatformtdinfoListVO);
			if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
				throw new Exception("数据重复，请检查后再次保存！");			
			}else{
				return (ChAdtClassplatformtdinfoVO) dao.update(vo);
			}
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtClassplatformtdinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtClassplatformtdinfoDAO dao = (ChAdtClassplatformtdinfoDAO) DAOFactory.build(ChAdtClassplatformtdinfoDAO.class, user);
        return (ChAdtClassplatformtdinfoVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtClassplatformtdinfoListVO params, User user)
        throws Exception {
			ChAdtClassplatformtdinfoDAO dao = (ChAdtClassplatformtdinfoDAO) DAOFactory.build(ChAdtClassplatformtdinfoDAO.class, user);
        return dao.query(params);
    }
}
