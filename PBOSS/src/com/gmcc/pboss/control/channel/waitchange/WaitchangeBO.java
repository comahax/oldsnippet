/**
 * auto-generated code
 * Thu Dec 01 02:42:27 GMT 2011
 */
package com.gmcc.pboss.control.channel.waitchange;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.channel.waitchange.WaitchangeDAO;
import com.gmcc.pboss.business.channel.waitchange.WaitchangeDBParam;
import com.gmcc.pboss.business.channel.waitchange.WaitchangeVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaitchangeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WaitchangeBO extends AbstractControlBean implements
		Waitchange {

	public WaitchangeVO doCreate(WaitchangeVO vo) throws Exception {
		try {
			WaitchangeDAO dao = (WaitchangeDAO) DAOFactory.build(WaitchangeDAO.class, user);
			// TODO set the pk */
			return (WaitchangeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaitchangeVO vo) throws Exception {
		try {
			WaitchangeDAO dao = (WaitchangeDAO) DAOFactory.build(WaitchangeDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaitchangeDAO dao = (WaitchangeDAO) DAOFactory.build(WaitchangeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaitchangeVO doUpdate(WaitchangeVO vo) throws Exception {
		try {
			WaitchangeDAO dao = (WaitchangeDAO) DAOFactory.build(WaitchangeDAO.class,user);
			return (WaitchangeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaitchangeVO doFindByPk(Serializable pk) throws Exception {
		WaitchangeDAO dao = (WaitchangeDAO) DAOFactory.build(WaitchangeDAO.class,user);
		return (WaitchangeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaitchangeDBParam params)
			throws Exception {
		WaitchangeDAO dao = (WaitchangeDAO) DAOFactory.build(WaitchangeDAO.class,user);
		return dao.query(params);
	}
	
	/**
	 * 【发送短信】公共方法 --采集平台所用到的
	 *  @param 短信标识,需替换参数的键值，接收号码,flag
	 *  
	 * 根据短信标识查询短信模板表，并对短信内容进行替换，然后插入短信待发送表           
	 * @author yedaoe
	 */
	public WaitchangeVO doInsertForCj(String sId, Map<String,String> keyAndValue, String recno) 
			throws Exception {
		/*Smstmpl smstmpl = (Smstmpl)BOFactory.build(SmstmplBO.class, user);
		String content = smstmpl.doGenSMS(sId, keyAndValue);
		WaitreqVO newVO = new WaitreqVO();
		WaitreqDAO dao = (WaitreqDAO) DAOFactory.build(WaitreqDAO.class, user);
		newVO.setSmstype(new Short("0"));//短信类型（SMSTYPE）取0（渠道）
		newVO.setAreacode(user.getCityid());
		newVO.setCreattime(new java.util.Date());
		newVO.setMessage(content);
		newVO.setRecno(recno);
		newVO.setDealcount(new Short("0"));
		newVO.setSendno("10086111");//短信发送号码(SENDNO=10086111)
		newVO.setIssuccess(new Short("0"));
		newVO.setResultcode("");
		newVO.setResultdesc("");
		return (WaitreqVO) dao.create(newVO);*/
		
		WaitchangeDAO dao = (WaitchangeDAO) DAOFactory.build(WaitchangeDAO.class, user);
		Smstmpl smstmpl = (Smstmpl)BOFactory.build(SmstmplBO.class, user);
		String content = smstmpl.doGenSMS(sId, keyAndValue);
		WaitchangeVO newVO = new WaitchangeVO();
		newVO.setCreattime(new java.util.Date());
		newVO.setDealtime(new java.util.Date());
		newVO.setMessage(content);
		newVO.setSendno("10086111");//短信发送号码(SENDNO=10086111)
		newVO.setRecno(recno);
		newVO.setIssuccess(new Short("0"));
		newVO.setResultcode("");
		newVO.setResultdesc("");
		newVO.setSenttime(new java.util.Date());
		return (WaitchangeVO) dao.create(newVO);
	}
}
