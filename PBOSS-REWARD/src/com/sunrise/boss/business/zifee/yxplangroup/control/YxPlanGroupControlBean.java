/**
* auto-generated code
* Fri Aug 18 11:29:20 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplangroup.control;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.*;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControl;
import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControlBean;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanDAO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfDAO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfVO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupVO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupDAO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.delegate.zifee.log.YxPlanFeeLogDelegate;
/**
 * <p>Title: YxPlanGroupControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/yxplangroup/control/YxPlanGroupControlBean"
*    name="YxPlanGroupControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class YxPlanGroupControlBean extends AbstractControlBean
    implements YxPlanGroupControl {

	private YxPlanFeeLogDelegate logDeltegate ;
	static StringBuffer queryItems;
	
	public YxPlanGroupVO doCreate(YxPlanGroupVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
            
        	doCheckAdd(vo,user);
        	vo=(YxPlanGroupVO) dao.create(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Create","PC_PS_YXPLANGROUP","");//��¼��־������
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public void doRemoveByVO(YxPlanGroupVO vo, User user) throws Exception {
    	YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
        try {
        	doCheckDelete(vo,user);
        	dao.remove(vo);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANGROUP","");//��¼��־��ɾ��    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, User user) throws Exception {
    	//YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
        try {
        	YxPlanGroupVO vo = doFindByPk(pk,user);
        	doRemoveByVO(vo,user);
        	//dao.removeByPk(pk);
            //logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Remove","PC_PS_YXPLANGROUP","");//��¼��־��ɾ��    
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanGroupVO doUpdate(YxPlanGroupVO vo, User user)
        throws Exception {
        try{
        	YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
        	vo = (YxPlanGroupVO) dao.update(vo);
        	//logDeltegate = new YxPlanFeeLogDelegate();            
            //logDeltegate.doLog("Update","PC_PS_YXPLANGROUP","");//��¼��־���޸�
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public YxPlanGroupVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
        return (YxPlanGroupVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(YxPlanGroupListVO params, User user)
        throws Exception {
    	YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
        return dao.query(params);
    }
    /**
     * ����Ӫ��������Ϊ��("1")�ģ���Ӫ����������еõ����еĳ�ԱӪ������,Ȼ����ת��ΪӪ������VO��Datapackage
     * @param params
     * @param user
     * @return
     * @throws Exception
     */
    public DataPackage doQueryByGroup(YxPlanGroupListVO params, User user)
      throws Exception {
    	
	  YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
	  DataPackage memyxplan = dao.query(params);
	  
	  if (memyxplan!=null&&memyxplan.getDatas()!=null){
		  List memList = (List) memyxplan.getDatas();
		  if (memList.size() !=0){
			  YxPlanControl yxPlanControl = (YxPlanControl)ControlFactory.build(YxPlanControlBean.class);
			  List result = new ArrayList();
			  Iterator iter = memList.iterator();
			  while (iter.hasNext()){
				  YxPlanGroupVO memVO  = (YxPlanGroupVO)iter.next();
				  YxPlanVO yxplanVO = yxPlanControl.doFindByPk(memVO.getMemyxplan(),user);
				  if (yxplanVO.getGroupflag().intValue()==0){
					  result.add(yxplanVO);
				  }
			  }
			  memyxplan.setDatas(result);
			  return memyxplan;
		  }
	  }
      return null;
    }  
    
    /**
     *  ����Ӫ���������ʶɾ�����еĳ�Ա��ϵ
     */
    public void deleteByGroupid(Long groupid, User user) throws Exception {
	   YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
	   dao.deleteByGroupid(groupid,user);
    }
    /**
     * ��������Ӫ��������ĳ�Ա
     * @param groupid
     * @param user
     * @throws Exception
     */
    public YxPlanGroupVO doBatchCreate(YxPlanGroupVO vo, User user) throws Exception{
    	try{
    		YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
    		doCheckAdd(vo,user);
    		return (YxPlanGroupVO)dao.create(vo);
    	}catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    /**
     * ������ѯӪ��������ĳ�Ա
     * @param groupid
     * @param user
     * @throws Exception
     */
    public DataPackage doBatchQueryGroup(String queryItems, User user) throws Exception {
		YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
		return dao.batchQueryGroup(queryItems, user);
	}
	public DataPackage doBatchQueryAll(String queryItems, User user) throws Exception {
		YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
		return dao.batchQueryAll(queryItems, user);
	}
	public DataPackage doBatchQueryMem(String queryItems, User user) throws Exception {
		YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
		return dao.batchQueryMem(queryItems, user);
	}

    /**
     *  ������һ�£�ͬʱ�����������������ṩ���Ľӿ� modify by yijianrong
     * @param vo
     * @param user
     * @throws Exception
     */
    private void doCheckAdd(YxPlanGroupVO vo, User user) throws Exception {
    	YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
    	YxPlanDAO yxplandao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class,user );
    	YxPlanVO yxplanvo=(YxPlanVO)yxplandao.findByPk(vo.getMemyxplan());
    	YxplangpinfDAO yxplangpinf = (YxplangpinfDAO) DAOFactory.build(YxplangpinfDAO.class,user );
    	YxplangpinfVO yxplangpinfvo=(YxplangpinfVO)yxplangpinf.findByPk(vo.getGroupyxplan());
    	String code="";
    	if (dao.findByPk(vo)!=null){
    		throw new BusinessException(code,"Ҫ�����ļ�¼�Ѿ������ݿ���");
    	}
    	if(yxplanvo==null){
    		throw new BusinessException(code,"Ҫ�����ļ�¼������Ӫ������ID�Ҳ���");
    	}
    	if(yxplangpinfvo==null){
    		throw new BusinessException(code,"Ҫ�����ļ�¼�����ķ�����ϢID�Ҳ���");
    	}
    	if(yxplangpinfvo.getAreacode()!=null){
    		if(!yxplangpinfvo.getAreacode().equals(user.getCityid()))
    			throw new BusinessException(code,"��ǰ�������ڵ�������Ӫ������������������һ��");
    		if(yxplanvo.getAreacode()==null)
    			throw new BusinessException(code,"��ǰӪ��������������Ϊ��,����ѡӪ������");
    		if(!yxplanvo.getAreacode().equals("865") && !yxplanvo.getAreacode().equals("100") && !yxplanvo.getAreacode().equals("999")){ //�����ʡ��Ӫ������
    			if(!yxplanvo.getAreacode().equals(yxplangpinfvo.getAreacode())){
    				throw new BusinessException(code,"Ӫ����������������Ӫ������������������һ��");
    			}
    		}
    	}else{
    		throw new BusinessException(code,"Ӫ������������������Ϊ��");
    	}
    	
    }

    /**
     * ����ɾ��Ӫ��������ĳ�Ա
     * @param groupid
     * @param user
     * @throws Exception
     */
    public void doBatchDelete(YxPlanGroupVO vo, User user) throws Exception{
    	try{
    		YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
    		doCheckDelete(vo,user);
    		dao.remove(vo);
    	}catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    /**
     *  ������һ�£�ͬʱ�����������������ṩ���Ľӿ� modify by yijianrong
     * @param vo
     * @param user
     * @throws Exception
     */
    private void doCheckDelete(YxPlanGroupVO vo, User user) throws Exception {
    	YxPlanGroupDAO dao = (YxPlanGroupDAO) DAOFactory.build(YxPlanGroupDAO.class,user );
    	YxPlanDAO yxplandao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class,user );
    	YxPlanVO yxplanvo=(YxPlanVO)yxplandao.findByPk(vo.getMemyxplan());
    	YxplangpinfDAO yxplangpinf = (YxplangpinfDAO) DAOFactory.build(YxplangpinfDAO.class,user );
    	YxplangpinfVO yxplangpinfvo=(YxplangpinfVO)yxplangpinf.findByPk(vo.getGroupyxplan());
    	String code="";
    	if (dao.findByPk(vo)==null){
    		throw new BusinessException(code,"Ҫɾ���ļ�¼�������ݿ���");
    	}
    	if(yxplanvo==null){
    		throw new BusinessException(code,"Ҫɾ���ļ�¼������Ӫ������ID�Ҳ���");
    	}
    	if(yxplangpinf.findByPk(vo.getGroupyxplan())==null){
    		throw new BusinessException(code,"Ҫɾ���ļ�¼�����ķ�����ϢID�Ҳ���");
    	}
    	if(yxplangpinfvo.getAreacode()!=null){
    		if(!yxplangpinfvo.getAreacode().equals(user.getCityid()))
    			throw new BusinessException(code,"��ǰ�������ڵ�������Ӫ������������������һ��");
    	}else{
    		throw new BusinessException(code,"Ӫ������������������Ϊ��");
    	}	
    }
    /**
	 * ����������ֵ�����־ö�����
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	protected void setSaveVO(Object vo, Object vo1) throws Exception {
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(vo, vo1);
	}


	

	
    
}
