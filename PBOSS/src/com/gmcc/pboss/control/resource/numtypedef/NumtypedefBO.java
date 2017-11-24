/**
 * auto-generated code
 * Sat Sep 05 16:02:03 CST 2009
 */
package com.gmcc.pboss.control.resource.numtypedef;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDBParam;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDAO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.gmcc.pboss.control.resource.numsortrule.Numsortrule;
import com.gmcc.pboss.control.resource.numsortrule.NumsortruleBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NumtypedefBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/numtypedef/control/NumtypedefBO"
*    name="Numtypedef"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class NumtypedefBO extends AbstractControlBean implements
		Numtypedef {

	public NumtypedefVO doCreate(NumtypedefVO vo) throws Exception {
		try {
			NumtypedefDAO dao = (NumtypedefDAO) DAOFactory.build(NumtypedefDAO.class, user);
			// TODO set the pk */
			return (NumtypedefVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NumtypedefVO vo) throws Exception {
		try {
			NumtypedefDAO dao = (NumtypedefDAO) DAOFactory.build(NumtypedefDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NumtypedefDAO dao = (NumtypedefDAO) DAOFactory.build(NumtypedefDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumtypedefVO doUpdate(NumtypedefVO vo) throws Exception {
		try {
			NumtypedefDAO dao = (NumtypedefDAO) DAOFactory.build(NumtypedefDAO.class,user);
			return (NumtypedefVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumtypedefVO doFindByPk(Serializable pk) throws Exception {
		NumtypedefDAO dao = (NumtypedefDAO) DAOFactory.build(NumtypedefDAO.class,user);
		return (NumtypedefVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NumtypedefDBParam params)
			throws Exception {
		NumtypedefDAO dao = (NumtypedefDAO) DAOFactory.build(NumtypedefDAO.class,user);
		return dao.query(params);
	}
	 public void doRemoveJoinNumsortrule(String[] selectArray) throws Exception{
		 	try {
				Numtypedef numtypedef=(Numtypedef)BOFactory.build(NumtypedefBO.class,user);
				Numsortrule numsortrule=(Numsortrule)BOFactory.build(NumsortruleBO.class,user);	
				NumsortruleDBParam param=new NumsortruleDBParam();
				List<NumsortruleVO> ruleList=null;
				for (int i = 0; i < selectArray.length; i++) {
					
					param.set_ne_typeid(Long.valueOf(selectArray[i]));
					ruleList=numsortrule.doQuery(param).getDatas();
					for(NumsortruleVO ruleVO:ruleList){
						numsortrule.doRemoveByPK(ruleVO.getRuleid());
					}
					numtypedef.doRemoveByPK(Long.valueOf(selectArray[i]));
				}
			}  catch (Exception ex) {
				throw new JOPException(ex);
			}
	 }
}
