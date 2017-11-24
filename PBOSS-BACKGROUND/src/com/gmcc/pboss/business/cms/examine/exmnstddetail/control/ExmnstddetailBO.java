package com.gmcc.pboss.business.cms.examine.exmnstddetail.control;


import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent.ExmnstddetailDAO;
import com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent.ExmnstddetailDBParam;
import com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent.ExmnstddetailVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnstddetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/examine/exmnstddetail/control/ExmnstddetailBO"
*    name="Exmnstddetail"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ExmnstddetailBO extends AbstractControlBean implements
		Exmnstddetail {

	public ExmnstddetailVO doCreate(ExmnstddetailVO vo) throws Exception {
		try {
			ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class, user);
			// TODO set the pk */
			return (ExmnstddetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ExmnstddetailVO vo) throws Exception {
		try {
			ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExmnstddetailVO doUpdate(ExmnstddetailVO vo) throws Exception {
		try {
			ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
			return (ExmnstddetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ExmnstddetailVO doFindByPk(Serializable pk) throws Exception {
		ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
		return (ExmnstddetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ExmnstddetailDBParam params)
			throws Exception {
		ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
		return dao.query(params);
	}
	 /**
     * 按“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期[EXMNPERIOD]
     * 分组统计指标得分明细的“考核分数[EXMNMARK]”，得到“考核总分”及相关信息
     * @return
     * @throws Exception
     */
    public DataPackage doSumGroupExmnmarkInfo(String exmnperiod) throws Exception {
    	ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
		return dao.doSumGroupExmnmarkInfo(exmnperiod);
    }
    /**
     * 根据“渠道代码[WAYID]”、“考核标识[EXMNID]”、“考核周期”判断
     * 指标得分明细表中是否存在“否决项[ISVOTED]”为“是[1]”的是指标
     * @param wayid
     * @param exmnid
     * @param exmnperiod
     * @return
     * @throws Exception
     */
    public boolean doHasIsvotedExmnstddetail(String wayid,Integer exmnid,String exmnperiod)throws Exception{
    	ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
		return dao.doHasIsvotedExmnstddetail(wayid, exmnid, exmnperiod);
    }
    /**
	 * 根据考核周期删除已存在的指标得分明细信息
	 * @param exmnperiod
	 * @throws Exception
	 */
	public void doDelBeingExmnstddetail(String exmnperiod)throws Exception{
		ExmnstddetailDAO dao = (ExmnstddetailDAO) DAOFactory.build(ExmnstddetailDAO.class,user);
		ExmnstddetailDBParam param=new ExmnstddetailDBParam();
		param.set_se_exmnperiod(exmnperiod);
		DataPackage data=dao.query(param);//doBeingExaminersltQuery(exmnperiod, null);
		List<ExmnstddetailVO> list=data.getDatas();
		try {
			for(ExmnstddetailVO vo:list){
				dao.remove(vo);
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
		
	}
}
