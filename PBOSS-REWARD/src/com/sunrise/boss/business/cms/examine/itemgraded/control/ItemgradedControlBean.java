/**
* auto-generated code
* Sat Nov 28 17:53:15 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgraded.control;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.sunrise.boss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedDAO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.VItemgradedWayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.exmnaudit.ExmnauditDelegate;
import com.sunrise.boss.delegate.cms.examine.itemgraded.ItemgradedDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ItemgradedControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/itemgraded/control/ItemgradedControlBean"
 name="ItemgradedControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ItemgradedControlBean extends AbstractControlBean
    implements ItemgradedControl {

    public ItemgradedVO doCreate(ItemgradedVO vo, User user)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            // TODO  set the pk */
            return (ItemgradedVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ItemgradedVO vo, User user)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ItemgradedVO doUpdate(ItemgradedVO vo, User user)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            return (ItemgradedVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ItemgradedVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
        return (ItemgradedVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ItemgradedListVO params, User user)
        throws Exception {
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
        return dao.query(params);
    }
    public void doSubmitAuditInfo(String[] selectArray,String auditor,String curauditor, User user)throws Exception{
    	try{	
			 ExmnauditDelegate exmnauditBO=new ExmnauditDelegate();
			 ItemgradedDelegate itemgradedBO=new ItemgradedDelegate();
			 ExmnauditVO exmnauditVO=null;
			 ItemgradedVO itemgradedVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 /*
				  * 保存考核信息审核
				  */
				 exmnauditVO=new ExmnauditVO();
				 exmnauditVO.setPresenter(user.getOpercode());//提交人
				 exmnauditVO.setSubmissiontime(new Date());//提交时间
				 exmnauditVO.setAuditor(auditor);//审核人
				 exmnauditVO.setItemgradedid(Long.valueOf(selectArray[i]));//考核登记标识
				 exmnauditVO.setState("0");//状态[STATE]”为“待审核[0]
				 exmnauditBO.doCreate(exmnauditVO,user);
				 /*
				  * 修改考核项评分
				  */
				 itemgradedVO=(ItemgradedVO)itemgradedBO.doFindByPk(Long.valueOf(selectArray[i]),user);
				 itemgradedVO.setState("0");//状态[STATE]”为“待审核[0]
				 itemgradedVO.setCurauditor(curauditor);//审核人名字
				 itemgradedBO.doUpdate(itemgradedVO,user);
			 }
			 sendMessage(auditor,user);//判断是否调用短信模块,并通知审核人
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
            throw ex;
		}
    }
    /**
	  * 查找所有可提交的考核项评分标识信息
	  */
	 public List doFindAllSubmitSeqid(User user)throws Exception{
		 ItemgradedDAO itemgradedDAO = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class,user);
		 return itemgradedDAO.doFindAllSubmitSeqid(user.getOpercode(),user);
	 }
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception{
		 try{
			 ExmnauditDelegate exmnauditBO=new ExmnauditDelegate();
			 ItemgradedDelegate itemgradedBO=new ItemgradedDelegate();
			 exmnauditBO.doRemoveCallbackInfo(selectArray, user.getOpercode(),user);//删除回收的考核信息审核信息R
			 ItemgradedVO itemgradedVO=null;
			 for(int i=0;i<selectArray.length;i++){
				 /*
				  * 修改考核项评分
				  */
				 itemgradedVO=(ItemgradedVO)itemgradedBO.doFindByPk(Long.valueOf(selectArray[i]),user);
				 if(itemgradedVO!=null){
					 itemgradedVO.setState("99");//状态[STATE]”为“未提交[99]
					 itemgradedVO.setCurauditor("");//审核人名字为空'
					 itemgradedBO.doUpdate(itemgradedVO,user);
				 }
			 }
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
	  * 删除评分登记与关联的评分审核记录
	  */
	 public void doRemoveJoinExmnaudit(ItemgradedVO vo, User user)
     throws Exception{
		 	try {
				//删除关联的评分审核记录
				ExmnauditDelegate exmnauditDelegate=new ExmnauditDelegate();
				ExmnauditListVO listVO =new ExmnauditListVO();
				listVO.set_ne_itemgradedid(vo.getSeqid()+"");
				Iterator it=exmnauditDelegate.doQuery(listVO, user).getDatas().iterator();
				ExmnauditVO exmnauditVO=null;
				while(it.hasNext()){
					exmnauditVO=(ExmnauditVO)it.next();
					exmnauditDelegate.doRemove(exmnauditVO, user);
				}
				this.doRemove(vo, user);//删除评分登记
			} catch (RuntimeException ex) {
				sessionContext.setRollbackOnly();
	            throw ex;
			}
	 }

	public DataPackage doGetItemgradedWayInfo(ItemgradedListVO listvo, User user) throws Exception {
		ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class,user);
		dao.setVoClass(VItemgradedWayVO.class);
		 return dao.getItemgradedWayInfo(listvo, user);
		
	}
}
