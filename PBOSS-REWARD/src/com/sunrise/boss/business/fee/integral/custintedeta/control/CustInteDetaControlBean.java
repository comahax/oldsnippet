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

	
	/** ע�� �������з������userid����ʵ��Ӧ�û��������subsid**/
	private Logger log = Logger.getLogger(CustInteDetaControlBean.class);
	
	
	/**
	 * ������������
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
				
				/**�ж��Ƿ��ܳɹ���ȡ�ͻ���ʶ���û���ʶ**/
				if (InteUtils.getCustidAndUserid(params, user)) {
					
					/***����������ѯ����***/
					savevo.setCustid(params.getCustid());
					savevo.setUserid(params.getUserid());
					savevo.setValidbillcyc(params.getValidbillcyc());
					savevo.setJftype(params.getJftype());
	
					CustInteDetaVO updatevo = (CustInteDetaVO) detadao.findByPk(savevo);
					
					/***�м�¼���޸ģ�����������¼***/
					if (null != updatevo) {
						
						if (null == updatevo.getValue()) updatevo.setValue(new Long(0));
						updatevo.setOprtime(InteUtils.getNowDate());
	
						/***�������ͺ��ۼ�����2�ִ���***/
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
						
						/***���ֲ�ֵ����0���޸Ŀͻ���Ȼ���***/
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
		/**ҵ��ʧ�ܣ�����ع�����ҵ���쳣**/
		if (!isSuccess) {
			BusinessException bex = new BusinessException(code);
			log.info("error: business error!");			
			sessionContext.setRollbackOnly();
			throw bex;
		}
	}
	
	
	
	
	/** �ͻ�����������ѯ **/
	public DataPackage doQuery(CustInteDetaListVO params, User user)
			throws Exception {

		VCustInteDetaDAO dao = (VCustInteDetaDAO) DAOFactory.build(VCustInteDetaDAO.class, user.getCityid());
		DataPackage dp = new DataPackage();
		if(null != params 
				&& null != params.get_ne_custid() && !"".equals(params.get_ne_custid())
				&& null != params.get_ne_userid() && !"".equals(params.get_ne_userid())){
			
			/** �����ѯ�������꣬��ת����ĳ��01-12�·� **/
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
	
	/** �ͻ����ֲ�ѯ���ã��ͻ�������ϸ�б� **/
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
	 * ��������,  ֻ���޸�3--�������֣�6--������������
	 */
	public CustInteDetaVO doUpdate(CustInteDetaVO params, User user)
			throws Exception {

		long value = 0;
		try{
			for (int jftype = InteUtils.CONSUME; jftype < InteUtils.HORTATION; jftype++) {
				if (jftype == InteUtils.TUNE || jftype == InteUtils.OFFICIALDERATE) {
					
					/**����������ȡ�������������ǰ�Ĳ�ֵ**/
					value = saveOrUpdate(params, jftype, user);
					if (value != 0) {
						
						/**ȡ�û������Ͷ�Ӧ�ı�ע��Ϣ**/
						String meno = InteUtils.selectGetMemo(params, jftype);
						
						/**�ͻ����������**/
						UpdateCustInte(params, value, user, jftype, meno);
					}
				}
				
			}
			/**������������ܻ���**/
			params.setSumValue(InteUtils.sumValue(params));
			
		}catch(Exception ex){
			log.info("doUpdate(CustInteDetaVO params, User user) error!");			
			sessionContext.setRollbackOnly();
			throw ex;
		}
		
		return params;

	}

	/**
	 * ���ݿͻ���ʶ���û���Ʒ���������ڷ���һ��vo
	 */
	public CustInteDetaVO findByObj(CustInteDetaVO params, User user)
			throws Exception {

		CustInteDetaDAO detadao = (CustInteDetaDAO) DAOFactory.build(
				CustInteDetaDAO.class, user.getCityid());
		if (null != params) {
		
			String mobileno = params.getMobilenum();
			Collection coll = new ArrayList();
	
			/**��������1-7����ȡ4��7 �Ļ�������**/
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
				
				/****���ݽ���������ж��η�װ****/
				Iterator iter = reSetDatas(coll, mobileno, user.getOpercode()).iterator();
				if (null != iter && iter.hasNext()) {
					return (CustInteDetaVO) iter.next();
				}
			}
		}	
		return new CustInteDetaVO();
	}

	/** ********************�Ӻ���****************************** */
	
	/**
	 * д��־
	 */	
	public void createLog(CustInteVO vo, Long beforeavlint, long value,
			User user, int jftype, String memo) throws Exception {

		InteUtils.createInteLog(vo.getUserid(),vo.getCustid(),vo.getIntegralcyc(),
				beforeavlint,vo.getAvailintegral(),value,jftype,memo,user,true);

	}

	/**
	 * valueΪ������ʾ���٣�����Ϊ����
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
				
				/***ҵ���߼���������Ȼ��ּ�����û���***/
				if (sumvalue >= 0) {
					int result = InteUtils.checkCustInteLimit( params.getCustid(), user.getCityid());
					
					if(result == -1){
						log.info("checkCustInteLimit error!");			
						code = "2";
					}else{
						if (result == 1) {
							vo.setAvailintegral(new Long(availintegral - value));
						} else if (result == 0) {
							;    /** ����Ļ��ֲ�������û��� **/
						}
						vo.setIntegral(new Long(sumvalue));
						vo.setUpdatetime(new Date(System.currentTimeMillis()));
						
						/**д��־������ֵΪ-��ʾ���ӣ�+��ʾ����**/
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
		
		/**ҵ��ʧ�ܣ�����ع�����ҵ���쳣**/
		if (!isSuccess) {
			BusinessException bex = new BusinessException(code);
			log.info("error: business error!");			
			sessionContext.setRollbackOnly();
			throw bex;
		}
	}

	/**
	 * �ͻ�������ϸ���������������û�иü�¼������һ��
	 * @return ���������ֵ��ԭʼ����ֵ֮��
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
			
			/***���ҵ����޸ģ���������***/
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
		
		/**ҵ��ʧ�ܣ�����ع�����ҵ���쳣**/
		if (!isSuccess) {
			BusinessException bex = new BusinessException(code);
			log.info("error: business error!");			
			sessionContext.setRollbackOnly();
			throw bex;
		}
		return value;
	}

	
	

	/**
	 * ���η�װ����� ��һ���������ڵ����л�����������Ϊһ����¼��һ����������һ����¼��
	 * 
	 * @param coll ԭʼ�Ľ����
	 * @return list ���η�װ��Ľ����
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
			
			/**ͬһ�ͻ���ʶ���û���ʶ���������ڵļ�¼��������**/
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
			coll.clear(); /**�ͷ�ԭ�������**/
		}

		return list;

	}

	/**
	 * ����ʵ��ĸ��ֵ�����
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
	 * ���ݻ����������û���ֵ�ͱ�ע
	 * ������ֻ���ֵΪnull�����ó�ʼֵΪ0
	 * @return ���������ֵ��ԭʼ����ֵ֮��
	 */
	public long selectSet(CustInteDetaVO vo, CustInteDetaVO params, long value,
			int jftype) {

		if (null != params && null != vo) {
			
			/**���ù�ͬ������**/
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
	 * �ͻ�����������ѯ
	 * @deprecated
	 */
	public DataPackage doQuery11(CustInteDetaListVO params, User user)
			throws Exception {

		CustInteDetaDAO dao = (CustInteDetaDAO) DAOFactory.build(CustInteDetaDAO.class, user.getCityid());
		
		int pageno = Integer.parseInt(params.get_pageno());
		int pagesize = Integer.parseInt(params.get_pagesize());		
		
		DataPackage dp = new DataPackage();
		String opercode = user.getOpercode();
		
		/**������Ӧ�Ĳ�ѯ����**/
		String datas = params.getDatas();
		String content[] = datas.split("\\|");
		String custid = content[1];
		String subsid = content[0]; // ��Ӧsubsid
		String mobileno = content[3];

		params.set_ne_custid(custid);
		params.set_ne_userid(subsid);		

		params.set_orderby("validbillcyc");

		/**����л��������ڣ�yyyy��������ת��Ϊ��������(yyyyMM00)�������������ڲ�ѯ������Χ**/
		/** �����ʱ��������ֱ�Ӳ�ѯ����� ��Ϊ���÷�ҳ�� ����һ�������12������**/
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
				
				/****���ݽ���������ж��η�װ****/
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
		
		/***ȡ�ý�����ܼ�¼���ܼ�¼��***/
		dp = dao.getGroupCountAndDpForDeta(params);
		if(null != dp && null != dp.getDatas() && dp.getDatas().size() > 0){
			
			/***���ҳ���Ƿ񳬳���ҳ�뷶Χ��������ȷ��ҳ��ֵ***/
			pageno = PageSetting.checkPageNo(dp.getRowCount(), pageno, pagesize);			
			dp.setPageNo(pageno);
			dp.setPageSize(pagesize);
			List list = (List) dp.getDatas();		

			/***��ǰҳ��ĵ�һ����¼�ź����һ����¼��***/
			int firstRs = PageSetting.getFirstResult(dp.getRowCount(), pageno, pagesize);			
			int lastRs = PageSetting.getLastResult(dp.getRowCount(), pageno, pagesize);			
			
			/*****����������ʱ����ǰҳ��ĵ�һ����¼�ź����һ����¼��ת��*****/
			if(null != params.get_desc() && "1".equals(params.get_desc())){
				int temp = firstRs;
				firstRs = dp.getRowCount() - lastRs - 1;
				lastRs = dp.getRowCount() - temp - 1;													
			}
			
			/*****ȡ�õ�ǰҳ��ĵ�һ����¼���������ں����һ����¼����������*****/		
			Object[] ob1 = (Object[]) list.get(firstRs);
			Long frCyc = (Long) ob1[1];
			Object[] ob2 = (Object[]) list.get(lastRs);
			Long lrCyc = (Long) ob2[1];
			
			/***������Ӧ�Ĳ�ѯ������ѯ�������***/
			if(frCyc != null && lrCyc != null){
				params.set_nnl_validbillcyc(frCyc.toString());
				params.set_nnm_validbillcyc(lrCyc.toString());
				params.set_pagesize("");
				params.set_pageno("");
				
				DataPackage dp1 = dao.query(params);
				list.clear();/** �ͷŲ�ѯ��������� **/
				
				if (null != dp1 && null != dp1.getDatas() && dp1.getDatas().size() > 0) {
					
					/****���ݽ���������ж��η�װ****/
					dp.setDatas(reSetDatas(dp1.getDatas(), mobileno,  opercode));
					return dp;
				}
			}			
		}		
		return null;
	}

	/** 
	 * �ͻ����ֲ�ѯ���ã��ͻ�������ϸ�б�
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
		
		/**������Ӧ�Ĳ�ѯ����**/
		String datas = params.getDatas();
		String content[] = datas.split("\\|");
		String custid = content[1];
		String mobileno = content[3];

		params.set_ne_custid(custid);
		
		/**����л���������������ת��Ϊ��������**/
		if (null != params.get_ne_validbillcyc()
				&& params.get_ne_validbillcyc().length() == 4) {
			params.set_nnl_validbillcyc(InteUtils.getLowerDate(params.get_ne_validbillcyc()));
			params.set_nnm_validbillcyc(InteUtils.getUpDate(params.get_ne_validbillcyc()));
			params.set_ne_validbillcyc(null);
		}
		
		/***ȡ�ý�����ܼ�¼���ܼ�¼��***/
		dp = dao.getGroupCountAndDp(params);
		
		if(null != dp && null != dp.getDatas() && dp.getDatas().size() > 0 && dp.getRowCount() > 0){
			
			/***���ҳ���Ƿ񳬳���ҳ�뷶Χ��������ȷ��ҳ��ֵ***/
			pageno = PageSetting.checkPageNo(dp.getRowCount(), pageno, pagesize);			
			
			dp.setPageNo(pageno);
			dp.setPageSize(pagesize);
			List list = (List) dp.getDatas();		

			/***��ǰҳ��ĵ�һ����¼�ź����һ����¼��***/
			int firstRs = PageSetting.getFirstResult(dp.getRowCount(), pageno, pagesize);			
			int lastRs = PageSetting.getLastResult(dp.getRowCount(), pageno, pagesize);	
			
		
			/*****ȡ�õ�ǰҳ��ĵ�һ����¼���������ڡ�userid�����һ����¼���������ڡ�userid*****/
			Object[] ob1 = (Object[]) list.get(firstRs);
			Long frCyc = (Long) ob1[1];
			Long userid = (Long) ob1[2];
			Object[] ob2 = (Object[]) list.get(lastRs);
			Long lrCyc = (Long) ob2[1];
			Long userid1 = (Long) ob2[2];
			
			
			/***������Ӧ�Ĳ�ѯ������ѯ�������***/
			if(frCyc != null && lrCyc != null){
				params.set_nnl_validbillcyc(frCyc.toString());
				params.set_nnm_validbillcyc(lrCyc.toString());
				params.set_pagesize("");
				params.set_pageno("");

				List list1 = dao.doQueryList(params,userid,userid1);
				
				list.clear();/** �ͷŲ�ѯ��������� **/
				
				if (null != list1 && list1.size() > 0) {
					
					/****���ݽ���������ж��η�װ****/
					dp.setDatas(reSetDatas(list1, mobileno,  opercode));
					return dp;
				}
			}		
		}		
		return null;
	}



	

}
