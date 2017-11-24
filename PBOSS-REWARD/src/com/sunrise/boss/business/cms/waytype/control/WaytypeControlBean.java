/**
* auto-generated code
* Fri Aug 25 11:24:52 CST 2006
*/
package com.sunrise.boss.business.cms.waytype.control;

import java.io.Serializable;
import java.util.*;

import org.apache.commons.lang.*;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeDAO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeListVO;

/**
 * <p>Title: WaytypeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/waytype/control/WaytypeControlBean"
*    name="WaytypeControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaytypeControlBean extends AbstractControlBean
    implements WaytypeControl {
	
	private static final String FIX_WAYTYPECODE=",ET,G100,BAND,TOP,SFSV,EXPE,AG,DIS,DISB,STRT,STRB,BANK,TEMI,ITF,EC,SITE,CCET,1380,9622,SMSG,SA,SMAG,CMAG,AV,AVAG,VTAG,";  //固定的渠道类型编码，不能删除

    public WaytypeVO doCreate(WaytypeVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user );
            return (WaytypeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WaytypeVO vo, User user)
        throws Exception {
        try{
         WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user );
         
         String codeStr =","+vo.getWaytypecode().trim().toUpperCase()+",";
         if (FIX_WAYTYPECODE.indexOf(codeStr)>0)
        	 throw new BusinessException("","该类型为系统固定类型，不能删除");
         
         WaytypeListVO listVO = new WaytypeListVO();
         listVO.set_se_uppercode(vo.getWaytypecode());  
         DataPackage sub = dao.query(listVO);
         if(sub.getDatas().size() > 0)
        	 throw new BusinessException("","该类型拥有子类型，不能删除");
         
         WayControl wayControl = (WayControl)ControlFactory.build( WayControlBean.class);
         DataPackage dp = wayControl.getByWaytype(vo.getWaytypecode(), user);
         if(dp.getDatas().size() > 0)
        	 throw new BusinessException("","渠道基本资料引用了该渠道类别，不能删除");
         
         dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaytypeVO doUpdate(WaytypeVO vo, User user)
        throws Exception {
        try{
         WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user );
            return (WaytypeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaytypeVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user );
        return (WaytypeVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WaytypeListVO params, User user)
        throws Exception {
         WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user );
        return dao.query(params);
    }
  /**
   * 判断是否是实体渠道, 逻辑：类别编码=ET 
   * @param type
   * @param user
   * @return
   * @throws Exception
   */
	public boolean isET(String type,User user) throws Exception {		
		return "ET".equals(type);
	}
	
	/**
	 * 判断是否是实体渠道, 逻辑：父类别编码=ET	
	 * @param subType
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean isETBranch(String subType,User user) throws Exception {
		WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user );
	
		WaytypeVO waytypeVO = new WaytypeVO();
		waytypeVO.setWaytypecode(subType);
		
		WaytypeVO waytypeVO2 = (WaytypeVO)dao.findByPk(subType);
		if(waytypeVO2 == null) 
			return false;
		else {
			return "ET".equals(waytypeVO2.getUppercode());
		}
	}
	/**
	 * 判断是否是代理渠道, 逻辑：类别编码=AG 或 DIS （分销商） 或 STRT（经销商） 或 LOGS（物流商）
	 * @param type
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean isAG(String type,User user) throws Exception {
		return "AG".equals(type) ||  "DIS".equals(type)  ||  "STRT".equals(type) || "LOGS".equals(type) ;
	}
	
	/**
	 *  判断是否是代理渠道网点, 逻辑：父类别编码=AG， 排除DIS （分销商） 或 STRT（经销商） 或 LOGS（物流商）
	 * @param subType
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean isAGBranch(String subType,User user) throws Exception {
		//排除DIS （分销商） 或 STRT（经销商） 或 LOGS（物流商）
		if("DIS".equals(subType)  ||  "STRT".equals(subType) || "LOGS".equals(subType))
			return false;
		
		WaytypeDAO dao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class, user );
		
		WaytypeVO waytypeVO = new WaytypeVO();
		waytypeVO.setWaytypecode(subType);
		
		WaytypeVO waytypeVO2 = (WaytypeVO)dao.findByPk(subType);
		if(waytypeVO2 == null) 
			return false;
		else {
			return "AG".equals(waytypeVO2.getUppercode());
		}
	}
}
