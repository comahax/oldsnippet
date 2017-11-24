/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custinte.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.sunrise.boss.business.common.subscriber.persistent.SubscriberDAO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberListVO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberVO;
import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.boss.business.fee.integral.common.InteUtils;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteDAO;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteListVO;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteVO;
import com.sunrise.boss.business.fee.integral.custinte.persistent.VCustInteDAO;
import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgDAO;
import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgVO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaDAO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaListVO;
import com.sunrise.boss.business.fee.persistent.custintmonch.CustIntMonChDAO;
import com.sunrise.boss.business.fee.persistent.custintmonch.CustIntMonChListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * 
 * Title: CustInteControlBean Description: Copyright: Copyright (c) 2006
 * Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/integral/custinte/control/CustInteControlBean"
*    name="CustInteControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CustInteControlBean extends AbstractControlBean implements
		CustInteControl {
	
	/** 注： 以下所有方法里的userid，其实对应用户表里的是subsid**/
	private Logger log = Logger.getLogger(CustInteControlBean.class);

	/**
	 * 批量积分转移业务
	 */
	public boolean doBatch(CustInteListVO params, User user) throws Exception {
		
		CustInteDAO dao = (CustInteDAO) DAOFactory.build(CustInteDAO.class ,user);
		boolean isDoTransfer = false;
		String code = "";
		try{
		if (null != params && null != params.getTransferinte()) {

			String mobilenum = params.getMobilenum();
			String mobilenum1 = params.getMobileno();
			Long inteCyc = params.getIntecyc();
			long inte = params.getTransferinte().longValue();
			CustInteVO vo = new CustInteVO();
			CustInteVO vo1 = new CustInteVO();

			/**验证转出号码的有效性**/
			if (validateNum(vo, mobilenum, inteCyc, user)) {
				
				/**验证转入号码的有效性**/
				if (validateBatchNum(vo1, mobilenum1, inteCyc, user)) {
					
					/**验证转出号码的年度积分记录**/
					if (getCustInteVO(vo, dao)) {
						
						/**验证转入号码的年度积分记录**/
						if (getCustInteVO(vo1, dao)) {
							
							/**验证转出号码的是否有足够的积分进行转移**/
							if (validateint(vo, inte)) {
								long value = 0;
								
								/***修改转出积分记录，写日志***/
								value = updateCustInteVO(vo, inte, dao, true);
								createLog(vo,value, 0-inte, user);

								/***修改转入积分记录，写日志***/
								value = updateCustInteVO(vo1, inte, dao, false);
								createLog(vo1,value, inte, user);

								isDoTransfer = true;
							} else code = "1";
							
						} else  code = "2";
						
					} else  code = "3";
					
				} else code = "4";
				
			} else code = "5";
		
		}
		}catch(Exception ex){
			sessionContext.setRollbackOnly();
			log.info("doBatch(CustInteListVO, User) error!");
			throw ex;
		}
		/**业务失败，事务回滚，抛业务异常**/
		if (!"".equals(code)) {
			sessionContext.setRollbackOnly();
			throw new BusinessException(code, "business validate fail!");
		}

		return isDoTransfer;
	}

	/**
	 * 积分转移业务
	 */
	public boolean doTransferInte(CustInteListVO params, User user)
			throws Exception {
		CustInteDAO dao = (CustInteDAO) DAOFactory.build(CustInteDAO.class,user);

		boolean isDoTransfer = false;
		String code = "";
		try{
			if (null != params && null != params.getTransferinte()) {
				long inte = params.getTransferinte().longValue();
				Long inteCyc = params.getIntecyc();
	
				String datas = params.getDatas();
				String content[] = datas.split("\\|");
				String mobileno = params.getMobilenum();
				String custid = FEEUtils.chgGroCustid(content[6], content[4], content[1], user);
				
				CustInteVO vo1 = new CustInteVO();
				vo1.setCustid(new Long(custid));
				vo1.setUserid(Long.valueOf(content[0]));
				vo1.setIntegralcyc(inteCyc);
				CustInteVO vo = new CustInteVO();
	
				/**验证转出号码的有效性**/
				if (validateNum(vo, mobileno, inteCyc, user)) {
					
					/**验证转出号码的年度积分记录**/
					if (getCustInteVO(vo, dao)) {
						
						/**验证转入号码的年度积分记录**/
						if (getCustInteVO(vo1, dao)) {
							
							/**验证转出号码的是否有足够的积分进行转移**/
							if (validateint(vo, inte)) {
								long value = 0;
								
								/***修改转出积分记录，写日志***/
								value = updateCustInteVO(vo, inte, dao, true);
								createLog(vo,value, 0-inte, user);
	
								/***修改转入积分记录，写日志***/
								value = updateCustInteVO(vo1, inte, dao, false);
								createLog(vo1, value,inte,user);
								isDoTransfer = true;
	
							} else {
								code = "1";
							}
						} else {
							code = "2";
						}
					} else {
						code = "3";
					}
				} else {
					code = "4";
				}
			}
		}catch(Exception ex){
			sessionContext.setRollbackOnly();
			log.info("doTransferInte(CustInteListVO, User) error!");
			throw ex;
		}
		/**业务失败，事务回滚，抛业务异常**/
		if (!"".equals(code)) {
			sessionContext.setRollbackOnly();
			throw new BusinessException(code, "business validate fail!");
		}

		return isDoTransfer;
	}

	/**
	 * 积分查询业务
	 */
	public DataPackage doQuery(CustInteListVO params, User user)
			throws Exception {
		VCustInteDAO dao = (VCustInteDAO) DAOFactory.build(VCustInteDAO.class, user);
		DataPackage dp = new DataPackage();
		if(null != params 
				&& null != params.get_ne_custid() && !"".equals(params.get_ne_custid())){
			
			dp = dao.doQueryInte(params);			
		}		
		
		return dp;	
		
	}
	
	/**
	 * 积分查询业务
	 * @deprecated
	 */
	public DataPackage doQuery1(CustInteListVO params, User user)
			throws Exception {
		
		CustInteDAO dao = (CustInteDAO) DAOFactory.build(CustInteDAO.class,user.getCityid());
		
		String datas = params.getDatas();
		String content[] = datas.split("\\|");
		String custid = content[1];
		String mobileno = content[3];
	
		params.set_ne_custid(custid);
		DataPackage dp = dao.query(params);		
		
		if(null != dp){
			List coll = (List) dp.getDatas();
		
			/**对结果集进行2次处理**/
			if (coll != null && coll.size() > 0) {
				
				CustInteDetaListVO param = new CustInteDetaListVO();
				param.set_ne_jftype("3"); // 积分类型 3代表调整积分
				param.set_ne_custid(custid);
				
				List dates = new ArrayList();
				for(Iterator iter = coll.iterator();iter.hasNext();){	
					
					CustInteVO vo = (CustInteVO) iter.next();										
					param.set_nnl_validbillcyc(InteUtils.getLowerDate(vo.getIntegralcyc().toString()));
					param.set_nnm_validbillcyc(InteUtils.getUpDate(vo.getIntegralcyc().toString()));			
					
					/**获取该客户该积分年内所有帐务周期的调整积分值的总额**/
					Long Inte = getInteSum(param, user, "value");	
					
					if (null == Inte) {
						Inte = new Long(0);
					}
					vo.setInte(Inte);					
					vo.setMobileno(mobileno);
					dates.add(vo);
				}
				
				coll.clear();    /**释放原来结果集**/
				dp.setDatas(dates);	
			}
		}
		return dp;
	}
	
	/**
	 * 客户积分查询业务中 （可用积分兑奖余额,已兑奖积分累计）
	 */
	public Long[] doTototal(CustInteListVO params, User user) throws Exception{
		
		CustInteDAO dao = (CustInteDAO) DAOFactory.build(CustInteDAO.class, user.getCityid());
		String datas = params.getDatas();
		String content[] = datas.split("\\|");
		
		Long sumAvailintegral = new Long(0);
		Long sumExchintegral = new Long(0);

		String custid = FEEUtils.chgGroCustid(content[6], content[4], content[1], user);
		
		CustIntMonChListVO param = new CustIntMonChListVO();
		params.set_ne_custid(custid);
		param.set_ne_custid(custid);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date now = new Date(System.currentTimeMillis());
		params.setStoptime(now);		
		param.set_ne_billcyc(sdf.format(now)+"0100");
		
		/** 已兑奖积分累计 **/
		sumExchintegral = getSum(param, user, "exchintegral");
		
		
		
		/** 可用积分兑奖余额 **/
		sumAvailintegral = getSum(params, dao, "availintegral");		
		
		return new Long[]{sumAvailintegral,sumExchintegral };

	}
	
	

	/**
	 * 获得所要显示的某个总分字段（sumProperty）
	 */
	public Long getSum(CustInteListVO param, CustInteDAO dao, String sumProperty)
			throws Exception {
		Long sumvalue = null;
		if (null != dao) {

			try {
				sumvalue = dao.getSum(param, sumProperty);
			} catch (Exception ex) {
				if (log.isEnabledFor(Level.ERROR))
					if (null != ex.getMessage()) {
						log.error("error:" + ex.getMessage(), ex);
					} else {
						log.error("error", ex);
					}
			}
		}
		if(null == sumvalue){
			sumvalue = new Long(0);
		}
		return sumvalue;
	}

	/**
	 * 获得所要显示的某个总分字段（sumProperty）
	 */
	public Long getSum(CustIntMonChListVO param, User user, String sumProperty)
			throws Exception {

		CustIntMonChDAO detadao = (CustIntMonChDAO) DAOFactory.build(
				CustIntMonChDAO.class, user);
		Long sumvalue = null;

		try {
			sumvalue = detadao.getSum(param, sumProperty);
		} catch (Exception ex) {
			if (log.isEnabledFor(Level.ERROR))
				if (null != ex.getMessage()) {
					log.error("error:" + ex.getMessage(), ex);
				} else {
					log.error("error", ex);
				}
		}
		if(null == sumvalue){
			sumvalue = new Long(0);
		}
		return sumvalue;
	}

	/**
	 * 获得所要显示的某个积分类型总分字段（sumProperty）
	 */
	public Long getInteSum(CustInteDetaListVO param, User user,
			String sumProperty) throws Exception {

		CustInteDetaDAO detadao = (CustInteDetaDAO) DAOFactory.build(
				CustInteDetaDAO.class, user);
		Long Inte = new Long(0);

		try {
			Inte = detadao.findSumInType(param, sumProperty);
		} catch (Exception ex) {
			if (log.isEnabledFor(Level.ERROR))
				if (null != ex.getMessage()) {
					log.error("error:" + ex.getMessage(), ex);
				} else {
					log.error("error", ex);
				}
		}

		return Inte;
	}



	/**
	 * 判断手机号码有效性，并过去用户标识和客户标识
	 */
	public boolean validateNum(CustInteVO vo, String mobilenum, Long inteCyc,
			User user) throws Exception {
		
		if (vo != null) {
			SubscriberVO svo = FEEUtils.getSubscriberVO(mobilenum, user);
			if( !(SubscriberDAO.SUBS_STATE_NORMAL.equals(svo.getStatus()) 
					|| SubscriberDAO.SUBS_STATE_STOP.equals(svo.getStatus()))) {						
				return false;	
			}
											
			String custid = FEEUtils.chgGroCustid(svo.getProid(), 
					svo.getAcctid().toString(), svo.getCustid().toString(), user);
		
			vo.setCustid(new Long(custid));
			vo.setUserid(svo.getSubsid());
			vo.setIntegralcyc(inteCyc);
			return true;
				
		}
		return false;
	}
	
	/**
	 * 判断手机号码有效性, 如果对应多客户，则取有效的状态下的客户标识
	 */
	public boolean validateBatchNum(CustInteVO vo, String mobilenum, Long inteCyc,
			User user) throws Exception {
		
		SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(SubscriberDAO.class, user);
		if (vo != null) {
			SubscriberListVO listsvo = new SubscriberListVO();
			listsvo.set_se_servnumber(mobilenum);
			listsvo.set_desc("0");
			listsvo.set_pagesize("0");

			DataPackage dp = dao.query(listsvo,false);
			if (null != dp && null != dp.getDatas() && dp.getDatas().size() > 0) {
				
				vo.setIntegralcyc(inteCyc);				
				if(dp.getDatas().size() > 1){
					for(Iterator iter = dp.getDatas().iterator();iter.hasNext();){
						
						SubscriberVO svo = (SubscriberVO) iter.next();
						if( null != svo && null != svo.getStatus() 
								&& (SubscriberDAO.SUBS_STATE_NORMAL.equals(svo.getStatus()) 
								|| SubscriberDAO.SUBS_STATE_STOP.equals(svo.getStatus()))){
							
							String custid = FEEUtils.chgGroCustid(svo.getProid(), 
									svo.getAcctid().toString(), svo.getCustid().toString(), user);
							vo.setCustid(new Long(custid));
							vo.setUserid(svo.getSubsid());
							return true;
						}
					}
					
				}else if(null != dp && null != dp.getDatas() && dp.getDatas().size() == 1){
					
					SubscriberVO svo = (SubscriberVO) dp.getDatas().iterator().next();
					
					String custid = FEEUtils.chgGroCustid(svo.getProid(), 
							svo.getAcctid().toString(), svo.getCustid().toString(), user);
					vo.setCustid(new Long(custid));
					vo.setUserid(svo.getSubsid());
					return true;
				}							
			}
		}
		return false;
	}

	/**
	 * 验证是否用足够的可用积分可转移
	 */
	public boolean validateint(CustInteVO vo, long inte) throws Exception {

		if (vo != null && null != vo.getAvailintegral()) {
			return vo.getAvailintegral().longValue() >= inte ? true : false;
		}
		return false;
	}

	/**
	 * 通过手机号码和积分周期获得CustInteVO
	 */
	public boolean getCustInteVO(CustInteVO vo, CustInteDAO dao)
			throws Exception {
		vo = (CustInteVO) dao.findByPk(vo);
		if (null != vo) {
			return true;
		}
		return false;
	}

	/**
	 * 修改转移客户可用积分
	 */
	public long  updateCustInteVO(CustInteVO vo, long inte, CustInteDAO dao,
			boolean input) throws Exception {
		long value = 0;
		if (vo != null || dao != null) {
			if (null == vo.getAvailintegral())
				vo.setAvailintegral(new Long(0));
			if (null == vo.getMoveint())
				vo.setMoveint(new Long(0));
			value = vo.getAvailintegral().longValue();
			if (input) {
				vo.setAvailintegral(new Long(vo.getAvailintegral().longValue()
						- inte));
				vo.setMoveint(new Long(vo.getMoveint().longValue() + inte));
			} else {
				vo.setAvailintegral(new Long(vo.getAvailintegral().longValue()
						+ inte));
				vo.setMoveint(new Long(vo.getMoveint().longValue() - inte));
			}
			vo.setUpdatetime(new Date(System.currentTimeMillis()));
		}
		return value;

	}

	/**
	 * 添加转移积分日志
	 */
	public void createLog(CustInteVO vo, long value ,long transferinte, User user)
			throws Exception {

		InteUtils.createInteLog(vo.getUserid(),vo.getCustid(),vo.getIntegralcyc(),
				new Long(value),vo.getAvailintegral(),
				transferinte,-1,"",user,false);
	}
	
	//积分调整，adjint为调整积分
	public CustInteVO doAdj(CustInteVO vo, Long adjint, Integer intchgrsn, String memo, User user) throws Exception {
		
		try {
			CustInteDAO dao = (CustInteDAO) DAOFactory.build(CustInteDAO.class, user.getCityid());
			dao.update(vo);
			
			CustInteChgDAO chgdao = (CustInteChgDAO) DAOFactory.build( CustInteChgDAO.class, user.getCityid());
			CustInteChgVO chgvo = new CustInteChgVO();
			chgvo.setCustid(vo.getCustid());
			chgvo.setSubsid(vo.getUserid());
			chgvo.setIntegralcyc(vo.getIntegralcyc());
			chgvo.setBeforeavlint(new Long(vo.getAvailintegral().longValue() - adjint.longValue()));
			chgvo.setAfteravlint(vo.getAvailintegral());
			chgvo.setIntchgrsn(intchgrsn);
			chgvo.setOprcode(user.getOpercode());
			chgvo.setUpdatetime(InteUtils.getNowDate());
			chgvo.setDescrp(memo);
			chgdao.create(chgvo);
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw new Exception("积分调整失败， "  + e.getCause());
		}
		
		return vo;
	}
	
}
