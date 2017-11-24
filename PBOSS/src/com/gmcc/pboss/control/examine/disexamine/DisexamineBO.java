/**
 * auto-generated code
 * Wed Dec 28 15:16:03 CST 2011
 */
package com.gmcc.pboss.control.examine.disexamine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.examine.disexamine.DisexamineDBParam;
import com.gmcc.pboss.business.examine.disexamine.DisexamineDAO;
import com.gmcc.pboss.business.examine.disexamine.DisexamineVO;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: DisexamineBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class DisexamineBO extends AbstractControlBean implements
		Disexamine {

	public DisexamineVO doCreate(DisexamineVO vo) throws Exception {
		try {
			DisexamineDAO dao = (DisexamineDAO) DAOFactory.build(DisexamineDAO.class, user);
			// TODO set the pk */
			return (DisexamineVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisexamineVO vo) throws Exception {
		try {
			DisexamineDAO dao = (DisexamineDAO) DAOFactory.build(DisexamineDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisexamineDAO dao = (DisexamineDAO) DAOFactory.build(DisexamineDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisexamineVO doUpdate(DisexamineVO vo) throws Exception {
		try {
			DisexamineDAO dao = (DisexamineDAO) DAOFactory.build(DisexamineDAO.class,user);
			return (DisexamineVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisexamineVO doFindByPk(Serializable pk) throws Exception {
		DisexamineDAO dao = (DisexamineDAO) DAOFactory.build(DisexamineDAO.class,user);
		return (DisexamineVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DisexamineDBParam params)
			throws Exception {
		DisexamineDAO dao = (DisexamineDAO) DAOFactory.build(DisexamineDAO.class,user);
		return dao.query(params);
	}
	
	//批量导入 
	public void doDisexamineImport(String[] items) throws Exception {		 
/*		 DisexamineDBParam disexamineDBParam = new DisexamineDBParam ();
		 disexamineDBParam.set_se_discomcode(items[0]);
		 disexamineDBParam.set_se_exmnperiod(items[1]);
		 disexamineDBParam.set_ne_penalamt(items[2]);
		 disexamineDBParam.set_se_memo(items[3]);
		 DataPackage  dp = doQuery(disexamineDBParam);
		 List<DisexamineVO> list = dp.getDatas();  
		    if (list.isEmpty())
		    {*/
		    	 DisexamineVO disexamineVO = new DisexamineVO();
				 disexamineVO.setDiscomcode(items[0]); 
				 disexamineVO.setExmnperiod(items[1]);
				 disexamineVO.setPenalamt(Double.parseDouble(items[2]));
				 disexamineVO.setMemo(items[3]);
				 disexamineVO.setCreatetime(new Date());
				 disexamineVO.setCreatecode(user.getOprcode());  
		         doCreate(disexamineVO);  
		         
/*		    }else if (!list.isEmpty())
		    {
		    	DisexamineVO disexamineVO = list.get(0);
		    	disexamineVO.setPenalamt(Double.parseDouble(items[2]));
				 disexamineVO.setMemo(items[3]);
				 disexamineVO.setCreatetime(new Date());
				 disexamineVO.setCreatecode(user.getOprcode()); 
		    	//数据存在 执行更新  
				   doUpdate(disexamineVO);  
			 
		    }  */
	}
}
