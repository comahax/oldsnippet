/**
* auto-generated code
* Fri Feb 01 14:20:31 CST 2013
*/
package com.sunrise.boss.business.cms.chadtclassplatformtdstd.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.delegate.cms.chadtclassplatformtdinfo.ChAdtClassplatformtdinfoDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoListVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdDAO;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdListVO;

/**
 * <p>Title: ChAdtClassplatformtdstdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtclassplatformtdstd/control/ChAdtClassplatformtdstdControlBean"
 name="ChAdtClassplatformtdstdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtClassplatformtdstdControlBean extends AbstractControlBean
    implements ChAdtClassplatformtdstdControl {

    public ChAdtClassplatformtdstdVO doCreate(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception {
        try{
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String currdate = format.format(new Date());
			ChAdtClassplatformtdinfoDelegate infoDelegate = new ChAdtClassplatformtdinfoDelegate();
			ChAdtClassplatformtdinfoListVO tdinfoListVO = new ChAdtClassplatformtdinfoListVO();
			tdinfoListVO.set_se_comid(vo.getComid());
			tdinfoListVO.set_dnl_enddate(currdate);
			tdinfoListVO.set_dnm_startdate(currdate);
			DataPackage tdinfodp = infoDelegate.doQuery(tdinfoListVO, user);
			if(tdinfodp == null || tdinfodp.getDatas() == null || tdinfodp.getDatas().size() <= 0){
				throw new Exception("BOSS��ƷID���Ϸ���");
			}
        	
			ChAdtClassplatformtdstdDAO dao = (ChAdtClassplatformtdstdDAO) DAOFactory.build(ChAdtClassplatformtdstdDAO.class, user);
            //����ʱ����֤��
			//rewardtype=1ʱ����rewardtype=1���������棬����comid��rewardtype��citycodeΨһ���жϡ�
			//rewardtype=2�ǣ���rewardtype=2���������棬����comid��rewardtype��saleslower��salesupper��citycodeΨһ���жϡ�
			
			if(vo != null && vo.getRewardtype() != null){
				ChAdtClassplatformtdstdListVO chAdtClassplatformtdstdListVO = new ChAdtClassplatformtdstdListVO();
				if(vo.getRewardtype() == 1){
					chAdtClassplatformtdstdListVO.set_ne_comid(vo.getComid());
					chAdtClassplatformtdstdListVO.set_ne_rewardtype(vo.getRewardtype()+"");
					chAdtClassplatformtdstdListVO.set_ne_citycode(vo.getCitycode()+"");
				}else if(vo.getRewardtype() == 2){
					chAdtClassplatformtdstdListVO.set_ne_comid(vo.getComid());
					chAdtClassplatformtdstdListVO.set_ne_rewardtype(vo.getRewardtype()+"");
					chAdtClassplatformtdstdListVO.set_ne_citycode(vo.getCitycode()+"");
					chAdtClassplatformtdstdListVO.set_ne_saleslower(vo.getSaleslower()+"");
					chAdtClassplatformtdstdListVO.set_ne_salesupper(vo.getSalesupper()+"");
				}
				DataPackage dp =  dao.query(chAdtClassplatformtdstdListVO);
				if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
					throw new Exception("�����ظ���������ٴα��棡");			
				}else{
					 return (ChAdtClassplatformtdstdVO) dao.create(vo);
				}		
			}
			return null;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformtdstdDAO dao = (ChAdtClassplatformtdstdDAO) DAOFactory.build(ChAdtClassplatformtdstdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtClassplatformtdstdVO doUpdate(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception {
        try{
			ChAdtClassplatformtdstdDAO dao = (ChAdtClassplatformtdstdDAO) DAOFactory.build(ChAdtClassplatformtdstdDAO.class, user);
			//����ʱ����֤��
			//rewardtype=1ʱ����rewardtype=1���������棬����comid��rewardtype��citycodeΨһ���жϡ�
			//rewardtype=2�ǣ���rewardtype=2���������棬����comid��rewardtype��saleslower��salesupper��citycodeΨһ���жϡ�
			
			if(vo != null && vo.getRewardtype() != null){
				ChAdtClassplatformtdstdListVO chAdtClassplatformtdstdListVO = new ChAdtClassplatformtdstdListVO();
				if(vo.getRewardtype() == 1){
					chAdtClassplatformtdstdListVO.set_ne_comid(vo.getComid());
					chAdtClassplatformtdstdListVO.set_ne_rewardtype(vo.getRewardtype()+"");
					chAdtClassplatformtdstdListVO.set_ne_citycode(vo.getCitycode()+"");
				}else if(vo.getRewardtype() == 2){
					chAdtClassplatformtdstdListVO.set_ne_comid(vo.getComid());
					chAdtClassplatformtdstdListVO.set_ne_rewardtype(vo.getRewardtype()+"");
					chAdtClassplatformtdstdListVO.set_ne_citycode(vo.getCitycode()+"");
					chAdtClassplatformtdstdListVO.set_ne_saleslower(vo.getSaleslower()+"");
					chAdtClassplatformtdstdListVO.set_ne_salesupper(vo.getSalesupper()+"");
				}
				DataPackage dp =  dao.query(chAdtClassplatformtdstdListVO);
				if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
					throw new Exception("�����ظ���������ٴα��棡");			
				}else{
					return (ChAdtClassplatformtdstdVO) dao.update(vo);
				}		
			}
			return null;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtClassplatformtdstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtClassplatformtdstdDAO dao = (ChAdtClassplatformtdstdDAO) DAOFactory.build(ChAdtClassplatformtdstdDAO.class, user);
        return (ChAdtClassplatformtdstdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtClassplatformtdstdListVO params, User user)
        throws Exception {
			ChAdtClassplatformtdstdDAO dao = (ChAdtClassplatformtdstdDAO) DAOFactory.build(ChAdtClassplatformtdstdDAO.class, user);
        return dao.query(params);
    }
}
