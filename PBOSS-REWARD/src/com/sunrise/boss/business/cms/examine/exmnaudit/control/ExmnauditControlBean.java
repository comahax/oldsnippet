/**
* auto-generated code
* Sat Nov 28 17:57:55 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnaudit.control;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditDAO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.VExmnauditDAO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.exmnaudit.ExmnauditDelegate;
import com.sunrise.boss.delegate.cms.examine.itemgraded.ItemgradedDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnauditControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnaudit/control/ExmnauditControlBean"
 name="ExmnauditControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnauditControlBean extends AbstractControlBean
    implements ExmnauditControl {

    public ExmnauditVO doCreate(ExmnauditVO vo, User user)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            // TODO  set the pk */
            return (ExmnauditVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnauditVO vo, User user)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnauditVO doUpdate(ExmnauditVO vo, User user)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            return (ExmnauditVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnauditVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
        return (ExmnauditVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnauditListVO params, User user)
        throws Exception {
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
        return dao.query(params);
    }
    /**
     * 根据考核登记ID数组查询验证能否被收回
     * @param itemgradeds
     * @return 不能被回收的考核登记标识集合
     * @throws Exception
     */
	 public List doValidateCallbackInfo(String[] itemgradeds,User user) throws Exception{
		 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
		 return dao.doValidateCallbackInfo(itemgradeds, user.getOpercode(), user);
	 }
	 /**
     * 删除回收的考核信息审核信息
     * @param itemgradeds
     * @param oprcode
     * @throws Exception
     */
    public void doRemoveCallbackInfo(String[] itemgradeds,String oprcode,User user) throws Exception{
    	ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
    	dao.removeCallbackInfo(itemgradeds, oprcode, user);
    }
    /**
	  * 查找所有可回收的考核项评分标识信息
	  */
	 public List doFindAllCallbackItemgradeds(User user)throws Exception{
		 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
		 return dao.doFindAllCallbackItemgradeds(user);
	 }
	 /**
	 * 查找考核信息审核和考核相关信息列表
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnauditList(ExmnauditListVO param,User user) throws Exception{
		String oprcode=user.getOpercode();//当前用户工号
		param.set_se_auditor(oprcode);//审核人[AUDITOR]”默认为当前工号
		VExmnauditDAO dao = (VExmnauditDAO) DAOFactory.build(VExmnauditDAO.class,user);
		/*ItemgradedListVO itemgradedListVO=new ItemgradedListVO();
		Object params[] = {
				param, itemgradedListVO
   	        };
   	        Class vos[] = {
   	        		ExmnauditVO.class, ItemgradedVO.class
   	        };
   	        String joins[][] = {
   	            {
   	                "itemgradedid", "seqid"
   	            }
   	        };
   	        DataPackage dp=dao.query2(params, vos, joins);*/
		return dao.queryExmnauditInfoList(param);
	}
	/**
     * 查找所有可提交考核信息审核的ID集合
     * @return
     * @throws Exception
     */
    public List doFindAllSubmitSeqid(User user)throws Exception{
    	 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
    	 String registercode=user.getOpercode();
    	 return dao.doFindAllSubmitSeqid(getNowMonth(), registercode,user);
    }
    /**
     * 验证最新审核人
     * @param itemgradeds
     * @param oprcode
     * @return 
     * @throws Exception
     */
    public List doValidateNewAuditor(String[] reqids,String[] itemgradeds,User user) throws Exception{
    	ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class,user);
    	return dao.doValidateNewAuditor(reqids, itemgradeds,user);
    }
  
	 /**
	  * 查找所有可审核的考核信息审核标识信息
	  */
	 public List doFindAllAuditExmnaudits(User user)throws Exception{
		 String registercode=user.getOpercode();
		 ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class,user);
	    	return dao.doFindAllAuditSeqid(getNowMonth(), registercode,user);
	 }
	 /**
	     * 删除回收的考核信息审核信息
	     * @param itemgradeds
	     * @param oprcode
	     * @throws Exception
	     */
	    public void doRemoveCallbackInfo(String[] itemgradeds,User user) throws Exception{
	    	ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class,user);
			 dao.removeCallbackInfo(itemgradeds, user.getOpercode(),user);
	    }
	 /**
	  * 执行回收相关操作(删除相关考核信息审核信息,更新考核项评分信息)--考核信息审核功能
	  */
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception{
		 try{
			 ItemgradedDelegate itemgradedDelegate=new ItemgradedDelegate();
			 ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
			 this.doRemoveCallbackInfo(selectArray, user);//删除回收的考核信息审核信息R
			 ItemgradedVO itemgradedVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 /*
				  * 修改考核项评分
				  */
				 itemgradedVO=itemgradedDelegate.doFindByPk(Long.valueOf(selectArray[i]),user);
				 itemgradedVO.setState("1");//状态[STATE]”为“通过[1]
				 itemgradedVO.setCurauditor("");//审核人名字为空
				 itemgradedDelegate.doUpdate(itemgradedVO,user);
			 }
		 }catch (Exception ex) {
			 sessionContext.setRollbackOnly();
	            throw ex;
		}
	 }
	 /**
	  * 执行审核相关操作(更新考核项评分表和考核信息表中的状态为所选的状态,和保存审核意见)
	  * @param selectArray
	  * @throws Exception
	  */
	 public void doAuditInfo(String[] selectArray,String state,String auditopinion,User user)throws Exception{
		 try{
			 ItemgradedDelegate itemgradedDelegate=new ItemgradedDelegate();
			 ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
			 ItemgradedVO itemgradedVO=null;
			 ExmnauditVO exmnauditVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 exmnauditVO=exmnauditDelegate.doFindByPk(Long.valueOf(selectArray[i]),user);
				 exmnauditVO.setState(state);
				 exmnauditVO.setAuditopinion(auditopinion);
				 exmnauditDelegate.doUpdate(exmnauditVO,user);
				 /*
				  * 修改考核项评分
				  */
				 itemgradedVO=itemgradedDelegate.doFindByPk(exmnauditVO.getItemgradedid(),user);
				 itemgradedVO.setState(state);//状态[STATE]”为“通过[1]
				 if("0".equals(state))
					 itemgradedVO.setCurauditor("");//审核人名字为空
				 itemgradedDelegate.doUpdate(itemgradedVO,user);
			 }
			 sendMessage(exmnauditVO.getAuditor(),user);//判断是否调用短信模块,并通知审核人
		 }catch (Exception ex) {
			 sessionContext.setRollbackOnly();
	            throw ex;
		}
	 }
	 /**
	  * 判断是否调用短信模块,并通知审核人
	  * @param auditor
	  * @throws Exception
	  */
	 private void sendMessage(String auditor,User user)throws Exception{
		//根据系统标识=62,参数类型==channel查找系统参数对象
	    	CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
	    	Serializable pkVO=new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid","62");
			BeanUtils.setProperty(pkVO, "paramtype","channel");
			SysparamVO vo=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
			//如果“参数值[PARAMVALUE]”为1,则调用“短信模块”通知审核人员；否则跳过；
			if(vo!=null && "1".equals( vo.getParamvalue())){
				/*
				 * 保留调用短信接口
				 */
			}
	 }
    /**
	 * 取上一个月的日期字符串,格式:yyyymm
	 * @return
	 */
	private String getNowMonth(){
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		if(month==0){
			year-=1;
			month=12;
		}
		return Integer.toString(year)+(month<10?'0'+Integer.toString(month):Integer.toString(month));
	}
}
