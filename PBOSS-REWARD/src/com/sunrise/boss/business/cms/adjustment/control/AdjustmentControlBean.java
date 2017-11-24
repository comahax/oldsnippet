/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.business.cms.adjustment.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.apache.log4j.Logger;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentDAO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentDAO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentListVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordDAO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchDAO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamDAO;

/**
 * <p>Title: AdjustmentControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/adjustment/control/AdjustmentControlBean"
 name="AdjustmentControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AdjustmentControlBean extends AbstractControlBean
    implements AdjustmentControl {
	
	private static final Logger log = Logger.getLogger(AdjustmentControlBean.class);
	
	public static final Long SUBOPNID_REPOERT_ID = 94L;
	public static final String SYS_CHANNEL = "channel";

    public AdjustmentVO doCreate(AdjustmentVO vo, User user)
        throws Exception {
        try{
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
            // TODO  set the pk */
            return (AdjustmentVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(AdjustmentVO vo, User user)
        throws Exception {
        try{
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AdjustmentVO doUpdate(AdjustmentVO vo, User user)
        throws Exception {
        try{
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
            return (AdjustmentVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AdjustmentVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
        return (AdjustmentVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(AdjustmentListVO params, User user)
        throws Exception {
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQuery(VAdjustmentListVO params, User user)
			throws Exception {
		VAdjustmentDAO dao = (VAdjustmentDAO) DAOFactory.build(VAdjustmentDAO.class, user);
		if(params.get_checked()==null || (params.get_checked()!=0 && params.get_checked()!=1) ){
			throw new Exception("[是否核对]只支持已核对和未核对查询");
		}
		int checked = params.get_checked();
		String namesql = null;
		if(checked==0){//已核对
			if(params.get_se_batchno()==null || "".equals(params.get_se_batchno().trim())){
				//付款批次查询条件为空，已经有批次号的记录不能查询和展示
				params.set_sql_batchno("batchno is null");
			}
			if(!params.suppertUpper()){//不支持业务大类
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.checked";
			}else{//支持业务大类
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.checked.withupperopnid";
			}			
		}else {//if(checked==1) 未核对
			if(!params.suppertUpper()){//不支持业务大类
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.unchecked";
			}else{//支持业务大类
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.unchecked.withupperopnid";
			}			
		}
		params.getQueryConditions().put("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return dao.queryByNamedSqlQuery(namesql, params);
	}
    
    //保存界面勾选的单条或多条记录
    public String doSaveUnchecked(VAdjustmentListVO params, User user) throws Exception{
    	int retcount = 0;
    	String retinfo = null;
    	try{
    		String[] selectArray = params.get_selectitem();
        	if(!params.suppertUpper()){//付款报表不支持业务大类
        		retcount = this.doSaveNoUpperopnid(selectArray, user);         	
        	}else{
        		retcount = this.doSaveWithUpperopnid(selectArray, user);
        	}
        	retinfo = ""+retcount;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		retinfo = "-1:"+retcount+":"+ex.getMessage();
    	}    	
    	return retinfo;
    }
    //付款报表不支持业务大类
    private int doSaveNoUpperopnid(String[] selectArray,User user)throws Exception{
    	int retcount = 0;
    	AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    	Session session = SessionUtil.currentSession(user.getCityid());
    	SQLQuery query = null;
    	List ret = null;
    	query = (SQLQuery)session.getNamedQuery("com.sunrise.boss.business.cms.adjustment.persistent.dosaveunchecked");
    	for(int i=0; i<selectArray.length; i++){
    		String[] info = selectArray[i].split("\\|");
    		query.setString("wayid", info[1]);
    		query.setString("rewardmonth", info[2]);
    		query.setString("countyid", info[3]);
    		ret = query.list();
    		for(Iterator it=ret.iterator();it.hasNext();){
    			Object[] obj = (Object[])it.next();
    			AdjustmentVO vo = new AdjustmentVO(obj[0].toString(),
    					obj[1].toString(),
    					obj[2].toString(),
    					(Double)obj[3]
    					);
    			vo.setConfirmoprcode(user.getOpercode());
    			vo.setConfirmptime(new Date());
    			dao.create(vo);
    			retcount++;
    		}
    	} 
    	return retcount;
    }
    //付款报表支持业务大类
    private int doSaveWithUpperopnid(String[] selectArray,User user)throws Exception{
    	int retcount = 0;
    	AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    	Session session = SessionUtil.currentSession(user.getCityid());
    	SQLQuery query = null;
    	List ret = null;
    	query = (SQLQuery)session.getNamedQuery("com.sunrise.boss.business.cms.adjustment.persistent.dosaveunchecked.withupperopnid");
    	for(int i=0; i<selectArray.length; i++){
    		String[] info = selectArray[i].split("\\|");
    		query.setString("wayid", info[1]);
    		query.setString("rewardmonth", info[2]);
    		query.setString("countyid", info[3]);
    		query.setString("upperopnid", info[4]);
    		ret = query.list();
    		for(Iterator it=ret.iterator();it.hasNext();){
    			Object[] obj = (Object[])it.next();
    			AdjustmentVO vo = new AdjustmentVO(obj[0].toString(),
    					obj[1].toString(),
    					obj[2].toString(),
    					obj[3].toString(),
    					(Double)obj[4]
    					);
    			vo.setConfirmoprcode(user.getOpercode());
    			vo.setConfirmptime(new Date());
    			dao.create(vo);
    			retcount++;
    		}
    	}
    	return retcount;
    }
    
    public String doSaveAllUnchecked(VAdjustmentListVO params, User user) throws Exception{
    	String retinfo = null;
    	try{
    		AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    		int ret = dao.doSaveAllUnchecked(params, user);
    		retinfo = ""+ret;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		retinfo="-1:"+ex.getMessage();
    	}
    	return retinfo;
    }
    
    public String doDeleteAllChecked(VAdjustmentListVO params, User user) throws Exception{
    	String retinfo = null;
    	try{
    		AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    		int ret = dao.doDeleteAllChecked(params, user);
    		retinfo = ""+ret;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		retinfo="-1:"+ex.getMessage();
    	}
    	return retinfo;
    }
    
    public String doCreatereport(VAdjustmentListVO params, User user) throws Exception{
    	try{
    		PaymentbatchDAO pdao = (PaymentbatchDAO)DAOFactory.build(PaymentbatchDAO.class, user);
        	AdjustmentDAO adao =(AdjustmentDAO)DAOFactory.build(AdjustmentDAO.class, user);
        	SysparamDAO sysdao = (SysparamDAO)DAOFactory.build(SysparamDAO.class, user);
        	
        	//获取【channel，94】系统参数，确定地市是否需要按业务小类展示报表
        	String sysvalue = sysdao.doFindByID(SUBOPNID_REPOERT_ID, SYS_CHANNEL);
        	if(sysvalue!=null && "1".equals(sysvalue)){//支持根据业务小类展示报表
        		params.set_hassubopnidreport(sysvalue);
        	}else{//不支持根据业务小类展示报表
        		params.set_hassubopnidreport("0");
        	}
        	String batchno = null;
        	try{//生成批次号
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            	String month = sdf.format(new Date());
            	String city = SessionFactoryRouter.conversionCityid(user.getCityid());//地市标识字符
            	Long sequence = (Long)adao.getSequence("CH_ADT_ADJUSTMENT_BATCHNO_SEQ");
            	if((sequence%1000)==0){//后三位为000,取下一个值
            		sequence = (Long)adao.getSequence("CH_ADT_ADJUSTMENT_BATCHNO_SEQ");
            	}
            	String reportseq = sequence.toString();
            	reportseq = reportseq.substring(reportseq.length()-3);
            	batchno = "C" + city + month + reportseq;
            	System.out.print("生成支付批次号:"+batchno);
            	log.info("生成支付批次号:"+batchno);
        	}catch(Exception ex){
        		ex.printStackTrace();
        		log.info("生成批次号失败，原因：", ex);
        		throw new Exception("生成批次号失败，原因："+ex.getMessage());
        	}        	
        	//更新酬金出帐明细ch_adt_Dcord表中当前isflag=0且batchno is null的明细记录
        	try{
            	int result = adao.doUpdatedcord(batchno, params, user.getOpercode());//params.get_se_countyid()
        		if(result>=0){
        			System.out.println("更新酬金出帐明细表ch_adt_Dcord中"+result+"条数据");
        			log.info("更新酬金出帐明细表ch_adt_Dcord中"+result+"条数据");
        		}
        		//根据修改的CH_ADT_DCORD表记录，关联CH_ADT_CITYRECORD表，修改对应数据的isflag状态值
        		//史晓龙 20140217
        		//取消对ch_adt_cityrecord表状态的修改，避免前台操作时频繁事务超时，3月版本将该部分逻辑迁移到后台。
//        		CityrecordDAO cityrecordDAO = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
//        		int rows = cityrecordDAO.updateCityRecordIsflag(Short.parseShort("5"), batchno);
//        		if(rows>=0){
//        			System.out.println("更新地市酬金上传明细表CH_ADT_CITYRECORD中"+rows+"条数据");
//        			log.info("更新地市酬金上传明细表CH_ADT_CITYRECORD中"+rows+"条数据");
//        		}
        	}catch(Exception ex){
        		System.out.println("更新酬金出帐明细表ch_adt_Dcord数据失败");
        		log.info("更新酬金出帐明细表ch_adt_Dcord数据失败",ex);
				throw new Exception("更新酬金出帐明细表数据失败");
        	}
        	//更新付款数据调整表CH_ADT_ADJUSTMENT,获取CH_ADT_ADJUSTMENT表中BATCHNO 为空的记录
        	try{
            	int result = adao.doUpdateadjustment(batchno, params);//params.get_se_countyid()
        		if(result>=0){
        			System.out.println("更新付款数据调整表CH_ADT_ADJUSTMENT中"+result+"条数据");
        			log.info("更新付款数据调整表CH_ADT_ADJUSTMENT中"+result+"条数据");
        		}
        	}catch(Exception ex){
        		System.out.println("更新付款数据调整表CH_ADT_ADJUSTMENT数据失败");
        		log.info("更新付款数据调整表CH_ADT_ADJUSTMENT数据失败",ex);
				throw new Exception("更新付款数据调整表数据失败");
        	}
        	//将以上批次号的ch_adt_Dcord明细记录汇总插入到CH_ADT_PAYMENT中
        	try{        		
            	int result = adao.doCreatepayment(batchno, params);//params.get_se_countyid()
        		if(result>=0){
        			System.out.println("酬金付款报表CH_ADT_PAYMENT表中插入"+result+"条数据");
        			log.info("酬金付款报表CH_ADT_PAYMENT表中插入"+result+"条数据");
        		}
        	}catch(Exception ex){
        		System.out.println("酬金付款报表CH_ADT_PAYMENT表中插入数据失败");
        		log.info("酬金付款报表CH_ADT_PAYMENT表中插入数据失败",ex);
				throw new Exception("酬金付款报表新增数据失败");
        	}
        	//往CH_ADT_PAYMENTBATCH中插入记录
        	PaymentbatchVO pvo = new PaymentbatchVO();
        	pvo.setCityid(Short.parseShort(user.getCityid()));
        	pvo.setPaymentflag((short)0);
        	pvo.setPaymentoprcode(user.getOpercode());
        	pvo.setPaymentoprtime(new Date());
        	pvo.setListflag((short)0);
        	pvo.setEndflag((short)0);
        	pvo.setBatchno(batchno);
        	if(params.isSupportPaymonth()){
        		pvo.setPaymonth(params.get_paymonth());
        	}
        	pdao.create(pvo);
        	    	
        	return batchno;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		sessionContext.setRollbackOnly();
    		log.info("生成支付报表失败，请稍后再试！", ex);
    		throw new Exception("生成支付报表失败，请稍后再试！"+ex.getMessage());
    	}
    }
}
