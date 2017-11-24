/**
* auto-generated code
* Tue Aug 21 10:38:31 CST 2012
*/
package com.sunrise.boss.business.cms.paymentbatch.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordDAO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordDAO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchVO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchDAO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchListVO;

/**
 * <p>Title: PaymentbatchControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/paymentbatch/control/PaymentbatchControlBean"
 name="PaymentbatchControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class PaymentbatchControlBean extends AbstractControlBean
    implements PaymentbatchControl {

    public PaymentbatchVO doCreate(PaymentbatchVO vo, User user)
        throws Exception {
        try{
			PaymentbatchDAO dao = (PaymentbatchDAO) DAOFactory.build(PaymentbatchDAO.class, user);
            // TODO  set the pk */
            return (PaymentbatchVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(PaymentbatchVO vo, User user)
        throws Exception {
        try{
			PaymentbatchDAO dao = (PaymentbatchDAO) DAOFactory.build(PaymentbatchDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public PaymentbatchVO doUpdate(PaymentbatchVO vo, User user)
        throws Exception {
        try{
			PaymentbatchDAO dao = (PaymentbatchDAO) DAOFactory.build(PaymentbatchDAO.class, user);
            return (PaymentbatchVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public PaymentbatchVO doFindByPk(Serializable pk, User user)
        throws Exception {
			PaymentbatchDAO dao = (PaymentbatchDAO) DAOFactory.build(PaymentbatchDAO.class, user);
        return (PaymentbatchVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(PaymentbatchListVO params, User user)
        throws Exception {
			PaymentbatchDAO dao = (PaymentbatchDAO) DAOFactory.build(PaymentbatchDAO.class, user);
        return dao.query(params);
    }

    public void doPayment(Short isflag, String batchno, User user)
        throws Exception {
    	DcordDAO dcordDAO = (DcordDAO) DAOFactory.build(DcordDAO.class, user);
    	int dcordRows = dcordDAO.updateDcordIsflag(isflag, batchno);
    	if (dcordRows >= 0) {
//    		System.out.println("共更新 CH_ADT_DCORD 表批次号为 " + batchno 
//    				+ " 的记录 " + dcordRows + " 条，更新状态为 " + isflag);
    	}
    	CityrecordDAO cityrecordDAO = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	int cityRecordRows = cityrecordDAO.updateCityRecordIsflag(isflag, batchno);
    	if (cityRecordRows >= 0) {
//    		System.out.println("共更新 CH_ADT_CITYRECORD 表记录 " + cityRecordRows 
//    				+ " 条，更新状态为 " + isflag);
    	}
    }
}
