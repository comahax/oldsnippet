/**
 * auto-generated code
 * Tue Oct 13 14:27:11 CST 2009
 */
package com.gmcc.pboss.control.sales.monamtchgrule;

import java.io.Serializable;
import java.util.Iterator;

import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleDBParam;
import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleDAO;
import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: MonamtchgruleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class MonamtchgruleBO extends AbstractControlBean implements
		Monamtchgrule {

	public MonamtchgruleVO doCreate(MonamtchgruleVO vo) throws Exception {
		try {
			MonamtchgruleDAO dao = (MonamtchgruleDAO) DAOFactory.build(MonamtchgruleDAO.class, user);
			// TODO set the pk */
			return (MonamtchgruleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(MonamtchgruleVO vo) throws Exception {
		try {
			MonamtchgruleDAO dao = (MonamtchgruleDAO) DAOFactory.build(MonamtchgruleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			MonamtchgruleDAO dao = (MonamtchgruleDAO) DAOFactory.build(MonamtchgruleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public MonamtchgruleVO doUpdate(MonamtchgruleVO vo) throws Exception {
		try {
			MonamtchgruleDAO dao = (MonamtchgruleDAO) DAOFactory.build(MonamtchgruleDAO.class,user);
			return (MonamtchgruleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public MonamtchgruleVO doFindByPk(Serializable pk) throws Exception {
		MonamtchgruleDAO dao = (MonamtchgruleDAO) DAOFactory.build(MonamtchgruleDAO.class,user);
		return (MonamtchgruleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MonamtchgruleDBParam params)
			throws Exception {
		MonamtchgruleDAO dao = (MonamtchgruleDAO) DAOFactory.build(MonamtchgruleDAO.class,user);
		return dao.query(params);
	}
	
	public boolean doCheckActrate(MonamtchgruleVO vo,DataPackage dp) throws Exception {
		Double actratelow = vo.getActratelow();//将要保存的记录
		Double actrateup = vo.getActrateup();
		boolean flag = true;
		for(Iterator<MonamtchgruleVO> it = dp.getDatas().iterator(); it.hasNext();){
			MonamtchgruleVO vo2 = it.next();
			Double actratelow2 = vo2.getActratelow();//数据库中已存在的记录
			Double actrateup2 = vo2.getActrateup();
			if(!((actratelow<actratelow2 && actrateup<=actratelow2)||(actratelow>=actrateup2 && actrateup>actrateup2))){
				flag = false;//有交叉
				break;
			}
		}
		return flag;
	}
}
