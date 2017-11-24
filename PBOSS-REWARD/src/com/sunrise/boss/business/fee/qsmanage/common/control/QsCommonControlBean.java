package com.sunrise.boss.business.fee.qsmanage.common.control;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.boss.business.fee.qsmanage.common.utils.QsUtils;
import com.sunrise.boss.business.fee.qsmanage.fixfeesettle.persistent.FixFeeSettleBakVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisDAO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqDAO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/qsmanage/common/control/QsCommonControlBean"
*    name="QsCommonControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class QsCommonControlBean extends AbstractControlBean implements QsCommonControl {

	public Object doFindByPk(Serializable pk, Class voClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        return ordinaryDAO.findByPk(pk);
    }
	
    //  --------------------for Qs log --------------------------
    public Object doCreateWithQsLog(Object vo, Class voClass, Long matchid, String chgreason, boolean isbatch, User user) throws Exception {
        
        try {
        	BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        	Object tmpvo = null ;
        	Object tmpusevo = null ;
        	if(!voClass.getName().equals(FixFeeSettleBakVO.class.getName())){//固定费结算管理新增要做判断，因为pk是sequence
        		tmpvo = getBakVO(vo, voClass, user);
            	tmpusevo = getUseVO(vo, voClass, user);
        	}else{
        		BeanUtils.setProperty((Serializable)vo, "dataid", new Long(FEEUtils.getSequence("IB_RENT_SETTLEPERCENT_SEQ", user)));
        	}
        	
        	if(tmpvo != null){
        		if(isbatch){//如果是批量操作，不做报错处理，直接跳过这张表的保存过程。
        			return null;
        		}else{
        			throw new BusinessException("保存失败，失败原因：临时表中已经存在此记录！"); 
        		}
        	}
        	
        	if(tmpusevo != null){
        		if(isbatch){//如果是批量操作，不做报错处理，直接跳过这张表的保存过程。
        			return null;
        		}else{
        			throw new BusinessException("保存失败，失败原因：正式表中已经存在此记录！");
        		}
        	}
        	
        	Short chgtype = null;
        	if(isbatch){
        		chgtype = new Short("1");
        	}else{
        		chgtype = new Short("0");
        	}
        	
            vo = ordinaryDAO.create(vo);
            doCreateReq(vo, voClass, "I", matchid, chgreason, chgtype, user);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
	}

	public void doRemoveByPkWithQsLog(Serializable pk, Class voClass, User user) throws Exception {

        try {        	
        	BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        	Object vo = ordinaryDAO.findByPk(pk);  
        	if(vo != null){
        		throw new BusinessException("临时表中已经存在此记录，不能再次删除！！");
        	}
        	
        	BaseDAO dao = new BaseDAO(Class.forName(QsUtils.getUseVO(voClass, user)),user.getCityid());
        	Object usevo = dao.findByPk(pk);
        	Object tmpvo = voClass.newInstance();
        	BeanUtils.copyProperties(tmpvo, usevo);
        	ordinaryDAO.create(tmpvo);
        	doCreateReq(tmpvo, voClass, "D", null, null, new Short("0"), user);

        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }

	}

	public void doRemoveByVoWithQsLog(Object vo, Class voClass, User user) throws Exception {       
		
        try {
        	
        	BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        	Object bakvo = voClass.newInstance();
        	BeanUtils.copyProperties(bakvo, vo);
        	Object tmpvo = ordinaryDAO.findByPk((Serializable) bakvo);
        	if(tmpvo != null){
        		throw new BusinessException("临时表中已经存在此记录，不能再次删除！！");
        	}
        	
        	BaseDAO dao = new BaseDAO(Class.forName(QsUtils.getUseVO(voClass, user)),user.getCityid());
        	Object usevo = dao.findByPk((Serializable) vo);
        	Object tmpvo2 = voClass.newInstance();
        	BeanUtils.copyProperties(tmpvo2, usevo);
        	ordinaryDAO.create(tmpvo2);
        	
        	doCreateReq(tmpvo2, voClass, "D", null, null, new Short("0"), user);
        
        }
        catch (Exception ex) {
        	
            sessionContext.setRollbackOnly();
            throw ex;
        }

	}

	public Object doUpdateWithQsLog(Object vo, Class voClass, User user) throws Exception {
		
        try {    	        	
        	BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        	Object tmpvo = getBakVO(vo, voClass, user);
        	
        	if(tmpvo != null){
        		throw new BusinessException("临时表中已经存在此记录，不能再次更新！！");
        	}
        	
        	doCreateReq(vo, voClass, "U", null, null, new Short("0"), user);
        	vo = ordinaryDAO.create(vo);        	
        	
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
	}
	
	
	
	/**
	 * 修改、新增、删除登记参数变更请求表 	 * 
	 */
	public ChgReqVO doCreateReq(Object clazzvo, Class voClass, String opertype, Long matchid, String chgreason, Short chgtype, User user) throws Exception {       
      
        try {  
        	ChgReqDAO reqdao = (ChgReqDAO) DAOFactory.build(ChgReqDAO.class,user);
			
        	ChgReqVO crvo = new ChgReqVO();
        	
        	crvo.setMainkey(QsUtils.getTablePKStr(voClass, user));
        	crvo.setMainvalue(QsUtils.getTablePkStrValue(clazzvo, user));
        	crvo.setOprcode(user.getOpercode());
        	crvo.setOprstate(new Long(0));  //0-设置完成
        	crvo.setOprtime(new Date(System.currentTimeMillis()));
        	crvo.setOprtype(opertype);
        	crvo.setTabname(QsUtils.getTableName(voClass, user));
        	crvo.setTabtype(new Long(0));  //0-从兴 1-华为
        	crvo.setMatchid(matchid == null ? new Long(-1) : matchid);
        	crvo.setChgreason(chgreason);
        	crvo.setChgtype(chgtype);
			
        	
			reqdao.create(crvo);
			
			ChgHisDAO hisdao = (ChgHisDAO) DAOFactory.build(ChgHisDAO.class, user.getCityid());
			ChgHisVO hisvo = new ChgHisVO();
			BeanUtils.copyProperties(hisvo, crvo);
			if(opertype.equals("U")){
        		Object tmpvo = getUseVO(clazzvo, voClass, user);
        		hisvo.setOldvalue(tmpvo.toString());
        		hisvo.setNewvalue(clazzvo.toString());
        	}else if(opertype.equals("D")){
        		hisvo.setOldvalue(clazzvo.toString());
        	}else if(opertype.equals("I")){
        		hisvo.setNewvalue(clazzvo.toString());
        	}
			
			hisdao.create(hisvo);
			
			
			return crvo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
	}
	
	
	private Object getBakVO(Object vo, Class voClass, User user) throws Exception{
		BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
    	Object tmpvo = null;
    	
    	String[] pks = QsUtils.getTablePKStr(voClass, user).split("~");
		if(pks.length == 1){
			tmpvo = ordinaryDAO.findByPk((Serializable) BeanUtils.getProperty(vo, pks[0]));
		}else{
			tmpvo = ordinaryDAO.findByPk((Serializable) vo);
		}
		return tmpvo;
	}
	
	private Object getUseVO(Object vo, Class voClass, User user) throws Exception {

		BaseDAO ordinaryDAO = new BaseDAO(Class.forName(QsUtils.getUseVO(voClass, user)), user.getCityid());
		Object tmpvo = null;
		String[] pks = QsUtils.getTablePKStr(voClass, user).split("~");
		if (pks.length == 1) {
			tmpvo = ordinaryDAO.findByPk((Serializable) BeanUtils.getProperty(vo, pks[0]));
		} else {
			Object usevo = Class.forName(QsUtils.getUseVO(voClass, user)).newInstance();
			BeanUtils.copyProperties(usevo, vo);
			tmpvo = ordinaryDAO.findByPk((Serializable) usevo);
		}
		return tmpvo;
	}
	
	public void doBatch(HashMap map, Long matchid, String chgreason, User user) throws Exception {
		try {
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				String tabcode = it.next().toString();
				Object obj = map.get(tabcode);
				doCreateWithQsLog(obj, obj.getClass(), matchid, chgreason, true, user);
			}
		} catch (Exception e) {
			 sessionContext.setRollbackOnly();
	         throw e;
		}
	}
	     
		
	
}
