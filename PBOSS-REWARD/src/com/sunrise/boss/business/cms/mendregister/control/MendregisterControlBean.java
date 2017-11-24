/**
* auto-generated code
* Mon Jun 20 09:11:28 GMT 2011
*/
package com.sunrise.boss.business.cms.mendregister.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterDAO;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterListVO;
import com.sunrise.boss.business.cms.mendregister.persistent.MendregisterVO;
import com.sunrise.boss.business.cms.registersim.control.RegistersimControl;
import com.sunrise.boss.business.cms.registersim.control.RegistersimControlBean;
import com.sunrise.boss.business.cms.registersim.persistent.RegistersimListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: MendregisterControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/mendregister/control/MendregisterControlBean"
 name="MendregisterControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MendregisterControlBean extends AbstractControlBean
    implements MendregisterControl {

    public MendregisterVO doCreate(MendregisterVO vo, User user)
        throws Exception {
        try{
			MendregisterDAO dao = (MendregisterDAO) DAOFactory.build(MendregisterDAO.class, user);
            // TODO  set the pk */
            return (MendregisterVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(MendregisterVO vo, User user)
        throws Exception {
        try{
			MendregisterDAO dao = (MendregisterDAO) DAOFactory.build(MendregisterDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MendregisterVO doUpdate(MendregisterVO vo, User user)
        throws Exception {
        try{
			MendregisterDAO dao = (MendregisterDAO) DAOFactory.build(MendregisterDAO.class, user);
            return (MendregisterVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public MendregisterVO doFindByPk(Serializable pk, User user)
        throws Exception {
			MendregisterDAO dao = (MendregisterDAO) DAOFactory.build(MendregisterDAO.class, user);
        return (MendregisterVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(MendregisterListVO params, User user)
        throws Exception {
			MendregisterDAO dao = (MendregisterDAO) DAOFactory.build(MendregisterDAO.class, user);
        return dao.query(params);
    }
    
    public boolean checkIfExistIn31Days(String mobile, Date selltime, User user)
			throws Exception {
		RegistersimControl rcontrol = (RegistersimControl) ControlFactory
				.build(RegistersimControlBean.class);
		RegistersimListVO params = new RegistersimListVO();
		params.set_se_mobile(mobile);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selltime);
		calendar.add(Calendar.DATE, -31);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		calendar2.add(Calendar.DATE, +1);

		params.set_dnl_oprtime(format.format(calendar.getTime()));
		params.set_dnm_oprtime(format.format(calendar2.getTime()));
		DataPackage dp = rcontrol.doQuery(params, user);
		if (null != dp && dp.getDatas().size() > 0) {
			return true;
		} else {
			return false;
		}
    }
    
//    public MendregisterVO doCreateWithCheck(MendregisterVO vo, User user)
//			throws Exception {
//		try {
//			
//			this.queryAvailableBrand("15975046028", "760", user);
//			MendregisterDAO dao = (MendregisterDAO) DAOFactory.build(
//					MendregisterDAO.class, user);
//			if (checkIfExistIn31Days(vo.getMobile(), vo.getSelltime(), user)) {
//				throw new BusinessException("该号码31天内有重复登记数据");
//			}
//			EmployeeControl econtrol = (EmployeeControl) ControlFactory
//					.build(EmployeeControlBean.class);
//			EmployeeListVO elistvo = new EmployeeListVO();
//			elistvo.set_se_officetel(vo.getOfficetel());
//			DataPackage edp = econtrol.mobileEmployeeQuery(elistvo, user);
//			if (null == edp || edp.getDatas().size() == 0) {
//				throw new BusinessException("本地市不存在有效的人员或网点");
//			}
//			List list = (List) edp.getDatas();
//			EmployeeVO employeevo = (EmployeeVO) list.get(0);
//			// 4. 查询BOSS库中号段表
//			NosectControl ncontrol = (NosectControl)ControlFactory
//				.build(NosectControlBean.class);
//			String bossarea = ncontrol.doQueryCityID(vo.getMobile(), user);
//
//			//插入套卡前台补登记信息表
//			MendregisterControl mcontrol = (MendregisterControl) ControlFactory
//					.build(MendregisterControlBean.class);
//			MendregisterVO mvo = new MendregisterVO();
//			BeanUtils.copyProperties(mvo, vo);
//			mvo.setOptime(new Date());
//			mvo.setOprcode(user.getOpercode());
//			mvo.setSuccess("0");
//			mcontrol.doCreate(mvo, user);
//			//插入套卡销售登记信息表
//			RegistersimControl rcontrol = (RegistersimControl)ControlFactory.build(RegistersimControlBean.class);
//			RegistersimVO rvo = new RegistersimVO();
//			rvo.setCityid(user.getCityid());
//			rvo.setOprcode(employeevo.getOprcode2());
//			rvo.setWayid(employeevo.getWayid());
//			rvo.setMobile(vo.getMobile());
//			rvo.setPosvalid("00");
//			rvo.setPosdiff(new Short("-1"));
//			rvo.setAddtime(new Date());
//			rvo.setOprtime(vo.getSelltime());
//			rvo.setMendfalg(new Short("2"));
//			rvo.setMendtime(new Date());
//			
//			rcontrol.doCreate(rvo, user);
//
//			return (MendregisterVO) dao.create(vo);
//		} catch (Exception ex) {
//			sessionContext.setRollbackOnly();
//			throw ex;
//		}
//	}
    
//	public DataPackage queryAvailableBrand(String mobile,String region,User user) throws Exception{
//		DataPackage dp = new DataPackage();
//		MendregisterDAO dao = (MendregisterDAO) DAOFactory.build(
//				MendregisterDAO.class, user);
//		dp = dao.queryAvailableBrand(mobile, region, user);
//    	return dp;
//	}

}
