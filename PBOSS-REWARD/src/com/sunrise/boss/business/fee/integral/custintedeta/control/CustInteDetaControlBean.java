/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custintedeta.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.fee.common.PageSetting;
import com.sunrise.boss.business.fee.integral.common.InteUtils;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteDAO;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteVO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaDAO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaListVO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaVO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.VCustInteDetaDAO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
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
*    local-jndi-name="com/sunrise/boss/business/fee/integral/custintedeta/control/CustInteDetaControlBean"
*    name="CustInteDetaControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CustInteDetaControlBean extends AbstractControlBean implements
		CustInteDetaControl {

	
	/** 注： 以下所有方法里的userid，其实对应用户表里的是subsid**/
	private Logger log = Logger.getLogger(CustInteDetaControlBean.class);
	
	
	/**
	 * 批量积分修正
	 */
	public void doBatch(CustInteDetaVO params, User user) throws Exception {
		CustInteDetaDAO detadao = (CustInteDetaDAO) DAOFactory.build(
				CustInteDetaDAO.class, user.getCityid());

		String code = "1";
		long value = 0;
		boolean isSuccess = false;
		
		try{
			if (null != params && null != params.getValue()) {
	
				CustInteDetaVO savevo = new CustInteDetaVO();
				
				/**判断是否能成功获取客户标识和用户标识**/
				if (InteUtils.getCustidAndUserid(params, user)) {
					
					/***设置主键查询属性***/
					savevo.setCustid(params.getCustid());
					savevo.setUserid(params.getUserid());
					savevo.setValidbillcyc(params.getValidbillcyc());
					savevo.setJftype(params.getJftype());
	
					CustInteDetaVO updatevo = (CustInteDetaVO) detadao.findByPk(savevo);
					
					/***有记录则修改，否则新增记录***/
					if (null != updatevo) {
						
						if (null == updatevo.getValue()) updatevo.setValue(new Long(0));
						updatevo.setOprtime(InteUtils.getNowDate());
	
						/***更新类型和累加类型2种处理***/
						if (null != params.getType()&& params.getType().intValue() == 1) {
	
							value = 0 - params.getValue().longValue();
							updatevo.setValue(new Long(updatevo.getValue().longValue()- value));
							isSuccess = true;
						} else {
							value = updatevo.getValue().longValue()- params.getValue().longValue();
							updatevo.setValue(params.getValue());
							isSuccess = true;
						}
	
					} else {
						value = 0 - params.getValue().longValue();
						if (value != 0) {
	
							savevo.setValue(params.getValue());
							savevo.setOprtime(InteUtils.getNowDate());
							detadao.create(savevo);
						}
						isSuccess = true;
					}
	
					
					if (value != 0) {
						
						/***积分差值大于0，修改客户年度积分***/
						UpdateCustInte(params, value, user, params.getJftype().intValue(), params.getMemo());
					}
				} else {
					code = "3";
				}
			}
		}catch(Exception ex){
			log.info("doBatch(CustInteDetaVO params, User user) error!");			
			sessionContext.setRollbackOnly();
			throw ex;
		}
		/**业务失败，事务回滚，抛业务异常**/
		if (!isSuccess) {
			BusinessException bex = new BusinessException(code);
			log.info("error: business error!");			
			sessionContext.setRollbackOnly();
			throw bex;
		}
	}
	
	
	
	
	/** 客户积分修正查询 **/
	public DataPackage doQuery(CustInteDetaListVO params, User user)
			throws Exception {

		VCustInteDetaDAO dao = (VCustInteDetaDAO) DAOFactory.build(VCustInteDetaDAO.class, user.getCityid());
		DataPackage dp = new DataPackage();
		if(null != params 
				&& null != params.get_ne_custid() && !"".equals(params.get_ne_custid())
				&& null != params.get_ne_userid() && !"".equals(params.get_ne_userid())){
			
			/** 如果查询条件是年，则转换成某年01-12月份 **/
			if (null != params.get_ne_validbillcyc() && !"".equals(params.get_ne_validbillcyc().trim())){
				if(params.get_ne_validbillcyc().length() == 4) {
					params.set_nnl_validbillcyc(InteUtils.getLowerDate(params.get_ne_validbillcyc()));
					params.set_nnm_validbillcyc(InteUtils.getUpDate(params.get_ne_validbillcyc()));
					params.set_ne_validbillcyc(null);			
				}
			}		
			dp = dao.doQueryInteDeta(params);			
		}		
		
		return dp;		
	}
	
	/** 客户积分查询调用，客户积分明细列表 **/
	public DataPackage doQuery1(CustInteDetaListVO params, User user)
			throws Exception {

		VCustInteDetaDAO dao = (VCustInteDetaDAO) DAOFactory.build(VCustInteDetaDAO.class, user.getCityid());
		DataPackage dp = new DataPackage();
		if(null != params 
				&& null != params.get_ne_custid() && !"".equals(params.get_ne_custid())){
			
			dp = dao.doQueryInteDeta(params);			
		}		
		
		return dp;		
	}
	
	
	
	/**
	 * 积分修正,  只能修改3--调整积分，6--公务机减免积分
	 */
	public CustInteDetaVO doUpdate(CustInteDetaVO params, User user)
			throws Exception {

		long value = 0;
		try{
			for (int jftype = InteUtils.CONSUME; jftype < InteUtils.HORTATION; jftype++) {
				if (jftype == InteUtils.TUNE || jftype == InteUtils.OFFICIALDERATE) {
					
					/**积分修正，取得修正后和修正前的差值**/
					value = saveOrUpdate(params, jftype, user);
					if (value != 0) {
						
						/**取得积分类型对应的备注信息**/
						String meno = InteUtils.selectGetMemo(params, jftype);
						
						/**客户年积分修正**/
						UpdateCustInte(params, value, user, jftype, meno);
					}
				}
				
			}
			/**计算修正后的总积分**/
			params.setSumValue(InteUtils.sumValue(params));
			
		}catch(Exception ex){
			log.info("doUpdate(CustInteDetaVO params, User user) error!");			
			sessionContext.setRollbackOnly();
			throw ex;
		}
		
		return params;

	}

	/**
	 * 根据客户标识、用户产品、帐务周期返回一个vo
	 */
	public CustInteDetaVO findByObj(CustInteDetaVO params, User user)
			throws Exception {

		CustInteDetaDAO detadao = (CustInteDetaDAO) DAOFactory.build(
				CustInteDetaDAO.class, user.getCityid());
		if (null != params) {
		
			String mobileno = params.getMobilenum();
			Collection coll = new ArrayList();
	
			/**积分类型1-7，不取4和7 的积分类型**/
			for (int jftype = InteUtils.CONSUME; jftype < InteUtils.HORTATION; jftype++) {
				if (jftype == InteUtils.YEARINTE || jftype == InteUtils.HORTATION) {
					continue;
				}
				CustInteDetaVO vo = new CustInteDetaVO();
				BeanUtils.copyProperties(vo, params);
				vo.setJftype(new Integer(jftype));
				vo = (CustInteDetaVO) detadao.findByPk(vo);
				if (null != vo) {
					coll.add(vo);
				}
			}
			if (null != coll && coll.size() > 0) {
				
				/****根据结果集，进行二次封装****/
				Iterator iter = reSetDatas(coll, mobileno, user.getOpercode()).iterator();
				if (null != iter && iter.hasNext()) {
					return (CustInteDetaVO) iter.next();
				}
			}
		}	
		return new CustInteDetaVO();
	}

	/** ********************子函数****************************** */
	
	/**
	 * 写日志
	 */	
	public void createLog(CustInteVO vo, Long beforeavlint, long value,
			User user, int jftype, String memo) throws Exception {

		InteUtils.createInteLog(vo.getUserid(),vo.getCustid(),vo.getIntegralcyc(),
				beforeavlint,vo.getAvailintegral(),value,jftype,memo,user,true);

	}

	/**
	 * value为正数表示减少，负数为增加
	 */
	public void UpdateCustInte(CustInteDetaVO params, long value, User user,
			int jftype, String memo) throws Exception, BusinessException {

		boolean isSuccess = false;
		String code = "1";

		CustInteDAO dao = (CustInteDAO) DAOFactory.build(CustInteDAO.class,
				user.getCityid());

		if (null != params) {
			CustInteVO vo = new CustInteVO();
			
			vo.setCustid(params.getCustid());
			vo.setIntegralcyc(new Long(InteUtils.getIntegralcyc(params.getValidbillcyc())));
			vo = (CustInteVO) dao.findByPk(vo);
				
			if (null != vo) {
				vo.setUserid(params.getUserid());
				long integral = (null != vo.getIntegral()) ? vo.getIntegral().longValue() : 0;
				long availintegral = (null != vo.getAvailintegral()) ? vo.getAvailintegral().longValue() : 0;
				long sumvalue = integral - value;
				Long beforeavlint = (null != vo.getAvailintegral()) ? vo.getAvailintegral() : new Long(0);
				
				/***业务逻辑：根据年度积分计算可用积分***/
				if (sumvalue >= 0) {
					int result = InteUtils.checkCustInteLimit( params.getCustid(), user.getCityid());
					
					if(result == -1){
						log.info("checkCustInteLimit error!");			
						code = "2";
					}else{
						if (result == 1) {
							vo.setAvailintegral(new Long(availintegral - value));
						} else if (result == 0) {
							;    /** 变更的积分不加入可用积分 **/
						}
						vo.setIntegral(new Long(sumvalue));
						vo.setUpdatetime(new Date(System.currentTimeMillis()));
						
						/**写日志，积分值为-表示增加，+表示减少**/
						createLog(vo, beforeavlint,0-value, user, jftype, memo);
						isSuccess = true;
					}	

				} else {
					code = "4";
				}
			} else {
				code = "2";
			}
		} else {
			code = "1";
		}
		
		/**业务失败，事务回滚，抛业务异常**/
		if (!isSuccess) {
			BusinessException bex = new BusinessException(code);
			log.info("error: business error!");			
			sessionContext.setRollbackOnly();
			throw bex;
		}
	}

	/**
	 * 客户积分明细，积分修正，如果没有该记录则增加一条
	 * @return 修正后积分值和原始积分值之差
	 * @throws Exception
	 */
	public long saveOrUpdate(CustInteDetaVO params, int jftype, User user)
			throws Exception {
		CustInteDetaDAO detadao = (CustInteDetaDAO) DAOFactory.build(
				CustInteDetaDAO.class, user.getCityid());
		long value = 0;
		boolean isSuccess = false;
		String code = "1";

		if (null != params) {
			CustInteDetaVO saveVO = new CustInteDetaVO();
			saveVO.setCustid(params.getCustid());
			saveVO.setUserid(params.getUserid());
			saveVO.setValidbillcyc(params.getValidbillcyc());
			saveVO.setJftype(new Integer(jftype));
			
			CustInteDetaVO updateVO = (CustInteDetaVO) detadao.findByPk(saveVO);
			
			/***查找到就修改，否则新增***/
			if (null != updateVO) {
				value = selectSet(updateVO, params, value, jftype);
			} else {
				InteUtils.intiCustInteDetaVO(saveVO);
				value = selectSet(saveVO, params, value, jftype);
				if (value != 0) {
					detadao.create(saveVO);
				}
			}
			isSuccess = true;
		}
		
		/**业务失败，事务回滚，抛业务异常**/
		if (!isSuccess) {
			BusinessException bex = new BusinessException(code);
			log.info("error: business error!");			
			sessionContext.setRollbackOnly();
			throw bex;
		}
		return value;
	}

	
	

	/**
	 * 二次封装结果集 把一个帐务周期的所有积分类型整和为一条记录（一个帐务周期一条记录）
	 * 
	 * @param coll 原始的结果集
	 * @return list 二次封装后的结果集
	 * @throws Exception
	 */
	public Collection reSetDatas(Collection coll, String mobileno,
			String opercode) throws Exception {
		Collection list = new ArrayList();
		if (null != coll && coll.size() > 0) {

			Long userid = new Long(0);
			Long validbillcyc = new Long(0);
			Long custid = new Long(0);

			Long userId = new Long(0);
			Long validbillCyc = new Long(0);
			Long custId = new Long(0);

			Iterator iter = coll.iterator();
			CustInteDetaVO vo = InteUtils.intiCustInteDetaVO(null);
			CustInteDetaVO vo1 = new CustInteDetaVO();
			
			/**同一客户标识，用户标识，帐务周期的记录进行整合**/
			while (null != iter && iter.hasNext()) {

				vo1 = (CustInteDetaVO) iter.next();

				userId = vo1.getUserid();
				validbillCyc = vo1.getValidbillcyc();
				custId = vo1.getCustid();

				if (0 == userid.longValue()) {
					userid = userId;
				}
				if (0 == validbillcyc.longValue()) {
					validbillcyc = validbillCyc;
				}
				if (0 == custid.longValue()) {
					custid = custId;
				}
				if (userid.longValue() != userId.longValue()
						|| validbillcyc.longValue() != validbillCyc.longValue()
						|| custid.longValue() != custId.longValue()) {

					list.add(setCustInteDetaVO(vo, vo1, opercode, userid,
							validbillcyc, mobileno));

					userid = userId;
					validbillcyc = validbillCyc;
					custid = custId;

					vo = InteUtils.intiCustInteDetaVO(null);
				}
				InteUtils.selectSetItem(vo, vo1);
			}
			if (userid.longValue() == userId.longValue()
					&& validbillcyc.longValue() == validbillCyc.longValue()
					&& custid.longValue() == custId.longValue()) {
				list.add(setCustInteDetaVO(vo, vo1, opercode, userid,
						validbillcyc, mobileno));
			}
			coll.clear(); /**释放原来结果集**/
		}

		return list;

	}

	/**
	 * 设置实体的各种的属性
	 */
	public CustInteDetaVO setCustInteDetaVO(CustInteDetaVO vo,
			CustInteDetaVO vo1, String opercode, Long userid,
			Long validbillcyc, String mobileno) {
		if (null != vo && null != vo1) {
			vo.setCustid(vo1.getCustid());
			vo.setValidbillcyc(validbillcyc);
			vo.setUserid(userid);
			vo.setOpercode(opercode);
			vo.setSumValue(InteUtils.sumValue(vo));
			vo.setMobilenum(mobileno);
		}
		return vo;
	}



	

	/**
	 * 根据积分类型设置积分值和备注
	 * 如果各种积分值为null，设置初始值为0
	 * @return 修正后积分值和原始积分值之差
	 */
	public long selectSet(CustInteDetaVO vo, CustInteDetaVO params, long value,
			int jftype) {

		if (null != params && null != vo) {
			
			/**设置共同的属性**/
			vo.setCustid(params.getCustid());
			vo.setUserid(params.getUserid());
			vo.setValidbillcyc(params.getValidbillcyc());
			vo.setJftype(new Integer(jftype));
			vo.setOprtime(new Date(System.currentTimeMillis()));
			
			if (null == vo.getValue())
				vo.setValue(new Long(0));
			
			switch (jftype) {
				case InteUtils.CONSUME:
					if (null == params.getConsumeinte())
						params.setConsumeinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getConsumeinte().longValue();
					vo.setValue(params.getConsumeinte());
					vo.setMemo(params.getMemo0());
					break;
				case InteUtils.INNET:
					if (null == params.getInnetinte())
						params.setInnetinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getInnetinte().longValue();
					vo.setValue(params.getInnetinte());
					vo.setMemo(params.getMemo1());
					break;
				case InteUtils.CREDIT:
					if (null == params.getCreditinte())
						params.setCreditinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getCreditinte().longValue();
					vo.setValue(params.getCreditinte());
					vo.setMemo(params.getMemo2());
					break;
				case InteUtils.TUNE:
					if (null == params.getTuneinte())
						params.setTuneinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getTuneinte().longValue();
					vo.setValue(params.getTuneinte());
					vo.setMemo(params.getMemo3());
					break;
				case InteUtils.YEARINTE:
					if (null == params.getYearinte())
						params.setYearinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getYearinte().longValue();
					vo.setValue(params.getYearinte());
					vo.setMemo(params.getMemo4());
					break;
				case InteUtils.DATAOPER:
					if (null == params.getDataoperinte())
						params.setDataoperinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getDataoperinte().longValue();
					vo.setValue(params.getDataoperinte());
					vo.setMemo(params.getMemo5());
					break;
				case InteUtils.OFFICIALDERATE:
					if (null == params.getOfficialderateinte())
						params.setOfficialderateinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getOfficialderateinte().longValue();
					vo.setValue(params.getOfficialderateinte());
					vo.setMemo(params.getMemo6());
					break;
				case InteUtils.HORTATION:
					if (null == params.getHortationinte())
						params.setHortationinte(new Long(0));
					value = vo.getValue().longValue()
							- params.getHortationinte().longValue();
					vo.setValue(params.getHortationinte());
					vo.setMemo(params.getMemo7());
					break;
			}
		}
		return value;
	}

	/**
	 * 客户积分修正查询
	 * @deprecated
	 */
	public DataPackage doQuery11(CustInteDetaListVO params, User user)
			throws Exception {

		CustInteDetaDAO dao = (CustInteDetaDAO) DAOFactory.build(CustInteDetaDAO.class, user.getCityid());
		
		int pageno = Integer.parseInt(params.get_pageno());
		int pagesize = Integer.parseInt(params.get_pagesize());		
		
		DataPackage dp = new DataPackage();
		String opercode = user.getOpercode();
		
		/**设置相应的查询条件**/
		String datas = params.getDatas();
		String content[] = datas.split("\\|");
		String custid = content[1];
		String subsid = content[0]; // 对应subsid
		String mobileno = content[3];

		params.set_ne_custid(custid);
		params.set_ne_userid(subsid);		

		params.set_orderby("validbillcyc");

		/**如果有积分年周期（yyyy）条件，转化为帐务周期(yyyyMM00)，设置帐务周期查询条件范围**/
		/** 如果有时间条件，直接查询结果集 因为不用分页了 整合一年内最多12条数据**/
		if (null != params.get_ne_validbillcyc() && !"".equals(params.get_ne_validbillcyc().trim())){
			if(params.get_ne_validbillcyc().length() == 4) {
				params.set_nnl_validbillcyc(InteUtils.getLowerDate(params.get_ne_validbillcyc()));
				params.set_nnm_validbillcyc(InteUtils.getUpDate(params.get_ne_validbillcyc()));
			}
			if(params.get_ne_validbillcyc().length() == 8) {
				params.set_nnl_validbillcyc(params.get_ne_validbillcyc());
				params.set_nnm_validbillcyc(params.get_ne_validbillcyc());
			}
			params.set_ne_validbillcyc(null);			
			params.set_pagesize("");				
			
			DataPackage dp1 = dao.query(params,false);
			
			if (null != dp1 && null != dp1.getDatas() && dp1.getDatas().size() > 0) {
				
				/****根据结果集，进行二次封装****/
				List list = (List) reSetDatas(dp1.getDatas(), mobileno,  opercode);
				if(null != list ){
					dp1.setRowCount(list.size());
				}else{
					dp1.setRowCount(0);
				}
				dp1.getDatas().clear();
				dp1.setDatas(list);
				return dp1;
			}
			
		}
		
		/***取得结果集总记录和总记录数***/
		dp = dao.getGroupCountAndDpForDeta(params);
		if(null != dp && null != dp.getDatas() && dp.getDatas().size() > 0){
			
			/***检查页码是否超出总页码范围，返回正确的页码值***/
			pageno = PageSetting.checkPageNo(dp.getRowCount(), pageno, pagesize);			
			dp.setPageNo(pageno);
			dp.setPageSize(pagesize);
			List list = (List) dp.getDatas();		

			/***当前页码的第一条记录号和最后一条记录号***/
			int firstRs = PageSetting.getFirstResult(dp.getRowCount(), pageno, pagesize);			
			int lastRs = PageSetting.getLastResult(dp.getRowCount(), pageno, pagesize);			
			
			/*****处理降序排序时：当前页码的第一条记录号和最后一条记录号转化*****/
			if(null != params.get_desc() && "1".equals(params.get_desc())){
				int temp = firstRs;
				firstRs = dp.getRowCount() - lastRs - 1;
				lastRs = dp.getRowCount() - temp - 1;													
			}
			
			/*****取得当前页码的第一条记录的帐务周期和最后一条记录的帐务周期*****/		
			Object[] ob1 = (Object[]) list.get(firstRs);
			Long frCyc = (Long) ob1[1];
			Object[] ob2 = (Object[]) list.get(lastRs);
			Long lrCyc = (Long) ob2[1];
			
			/***设置相应的查询条件查询出结果集***/
			if(frCyc != null && lrCyc != null){
				params.set_nnl_validbillcyc(frCyc.toString());
				params.set_nnm_validbillcyc(lrCyc.toString());
				params.set_pagesize("");
				params.set_pageno("");
				
				DataPackage dp1 = dao.query(params);
				list.clear();/** 释放查询条件结果集 **/
				
				if (null != dp1 && null != dp1.getDatas() && dp1.getDatas().size() > 0) {
					
					/****根据结果集，进行二次封装****/
					dp.setDatas(reSetDatas(dp1.getDatas(), mobileno,  opercode));
					return dp;
				}
			}			
		}		
		return null;
	}

	/** 
	 * 客户积分查询调用，客户积分明细列表
	 * @deprecated
	 */
	public DataPackage doQuery2(CustInteDetaListVO params, User user)
			throws Exception {

		CustInteDetaDAO dao = (CustInteDetaDAO) DAOFactory.build(
				CustInteDetaDAO.class, user.getCityid());
		
		int pageno = Integer.parseInt(params.get_pageno());
		int pagesize = Integer.parseInt(params.get_pagesize());		
		
		DataPackage dp = new DataPackage();
		String opercode = user.getOpercode();
		
		/**设置相应的查询条件**/
		String datas = params.getDatas();
		String content[] = datas.split("\\|");
		String custid = content[1];
		String mobileno = content[3];

		params.set_ne_custid(custid);
		
		/**如果有积分年周期条件，转化为帐务周期**/
		if (null != params.get_ne_validbillcyc()
				&& params.get_ne_validbillcyc().length() == 4) {
			params.set_nnl_validbillcyc(InteUtils.getLowerDate(params.get_ne_validbillcyc()));
			params.set_nnm_validbillcyc(InteUtils.getUpDate(params.get_ne_validbillcyc()));
			params.set_ne_validbillcyc(null);
		}
		
		/***取得结果集总记录和总记录数***/
		dp = dao.getGroupCountAndDp(params);
		
		if(null != dp && null != dp.getDatas() && dp.getDatas().size() > 0 && dp.getRowCount() > 0){
			
			/***检查页码是否超出总页码范围，返回正确的页码值***/
			pageno = PageSetting.checkPageNo(dp.getRowCount(), pageno, pagesize);			
			
			dp.setPageNo(pageno);
			dp.setPageSize(pagesize);
			List list = (List) dp.getDatas();		

			/***当前页码的第一条记录号和最后一条记录号***/
			int firstRs = PageSetting.getFirstResult(dp.getRowCount(), pageno, pagesize);			
			int lastRs = PageSetting.getLastResult(dp.getRowCount(), pageno, pagesize);	
			
		
			/*****取得当前页码的第一条记录的帐务周期、userid和最后一条记录的帐务周期、userid*****/
			Object[] ob1 = (Object[]) list.get(firstRs);
			Long frCyc = (Long) ob1[1];
			Long userid = (Long) ob1[2];
			Object[] ob2 = (Object[]) list.get(lastRs);
			Long lrCyc = (Long) ob2[1];
			Long userid1 = (Long) ob2[2];
			
			
			/***设置相应的查询条件查询出结果集***/
			if(frCyc != null && lrCyc != null){
				params.set_nnl_validbillcyc(frCyc.toString());
				params.set_nnm_validbillcyc(lrCyc.toString());
				params.set_pagesize("");
				params.set_pageno("");

				List list1 = dao.doQueryList(params,userid,userid1);
				
				list.clear();/** 释放查询条件结果集 **/
				
				if (null != list1 && list1.size() > 0) {
					
					/****根据结果集，进行二次封装****/
					dp.setDatas(reSetDatas(list1, mobileno,  opercode));
					return dp;
				}
			}		
		}		
		return null;
	}



	

}
