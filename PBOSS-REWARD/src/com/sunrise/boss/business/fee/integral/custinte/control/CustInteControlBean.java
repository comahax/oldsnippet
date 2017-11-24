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
	
	/** ע�� �������з������userid����ʵ��Ӧ�û��������subsid**/
	private Logger log = Logger.getLogger(CustInteControlBean.class);

	/**
	 * ��������ת��ҵ��
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

			/**��֤ת���������Ч��**/
			if (validateNum(vo, mobilenum, inteCyc, user)) {
				
				/**��֤ת��������Ч��**/
				if (validateBatchNum(vo1, mobilenum1, inteCyc, user)) {
					
					/**��֤ת���������Ȼ��ּ�¼**/
					if (getCustInteVO(vo, dao)) {
						
						/**��֤ת��������Ȼ��ּ�¼**/
						if (getCustInteVO(vo1, dao)) {
							
							/**��֤ת��������Ƿ����㹻�Ļ��ֽ���ת��**/
							if (validateint(vo, inte)) {
								long value = 0;
								
								/***�޸�ת�����ּ�¼��д��־***/
								value = updateCustInteVO(vo, inte, dao, true);
								createLog(vo,value, 0-inte, user);

								/***�޸�ת����ּ�¼��д��־***/
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
		/**ҵ��ʧ�ܣ�����ع�����ҵ���쳣**/
		if (!"".equals(code)) {
			sessionContext.setRollbackOnly();
			throw new BusinessException(code, "business validate fail!");
		}

		return isDoTransfer;
	}

	/**
	 * ����ת��ҵ��
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
	
				/**��֤ת���������Ч��**/
				if (validateNum(vo, mobileno, inteCyc, user)) {
					
					/**��֤ת���������Ȼ��ּ�¼**/
					if (getCustInteVO(vo, dao)) {
						
						/**��֤ת��������Ȼ��ּ�¼**/
						if (getCustInteVO(vo1, dao)) {
							
							/**��֤ת��������Ƿ����㹻�Ļ��ֽ���ת��**/
							if (validateint(vo, inte)) {
								long value = 0;
								
								/***�޸�ת�����ּ�¼��д��־***/
								value = updateCustInteVO(vo, inte, dao, true);
								createLog(vo,value, 0-inte, user);
	
								/***�޸�ת����ּ�¼��д��־***/
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
		/**ҵ��ʧ�ܣ�����ع�����ҵ���쳣**/
		if (!"".equals(code)) {
			sessionContext.setRollbackOnly();
			throw new BusinessException(code, "business validate fail!");
		}

		return isDoTransfer;
	}

	/**
	 * ���ֲ�ѯҵ��
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
	 * ���ֲ�ѯҵ��
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
		
			/**�Խ��������2�δ���**/
			if (coll != null && coll.size() > 0) {
				
				CustInteDetaListVO param = new CustInteDetaListVO();
				param.set_ne_jftype("3"); // �������� 3�����������
				param.set_ne_custid(custid);
				
				List dates = new ArrayList();
				for(Iterator iter = coll.iterator();iter.hasNext();){	
					
					CustInteVO vo = (CustInteVO) iter.next();										
					param.set_nnl_validbillcyc(InteUtils.getLowerDate(vo.getIntegralcyc().toString()));
					param.set_nnm_validbillcyc(InteUtils.getUpDate(vo.getIntegralcyc().toString()));			
					
					/**��ȡ�ÿͻ��û������������������ڵĵ�������ֵ���ܶ�**/
					Long Inte = getInteSum(param, user, "value");	
					
					if (null == Inte) {
						Inte = new Long(0);
					}
					vo.setInte(Inte);					
					vo.setMobileno(mobileno);
					dates.add(vo);
				}
				
				coll.clear();    /**�ͷ�ԭ�������**/
				dp.setDatas(dates);	
			}
		}
		return dp;
	}
	
	/**
	 * �ͻ����ֲ�ѯҵ���� �����û��ֶҽ����,�Ѷҽ������ۼƣ�
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
		
		/** �Ѷҽ������ۼ� **/
		sumExchintegral = getSum(param, user, "exchintegral");
		
		
		
		/** ���û��ֶҽ���� **/
		sumAvailintegral = getSum(params, dao, "availintegral");		
		
		return new Long[]{sumAvailintegral,sumExchintegral };

	}
	
	

	/**
	 * �����Ҫ��ʾ��ĳ���ܷ��ֶΣ�sumProperty��
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
	 * �����Ҫ��ʾ��ĳ���ܷ��ֶΣ�sumProperty��
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
	 * �����Ҫ��ʾ��ĳ�����������ܷ��ֶΣ�sumProperty��
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
	 * �ж��ֻ�������Ч�ԣ�����ȥ�û���ʶ�Ϳͻ���ʶ
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
	 * �ж��ֻ�������Ч��, �����Ӧ��ͻ�����ȡ��Ч��״̬�µĿͻ���ʶ
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
	 * ��֤�Ƿ����㹻�Ŀ��û��ֿ�ת��
	 */
	public boolean validateint(CustInteVO vo, long inte) throws Exception {

		if (vo != null && null != vo.getAvailintegral()) {
			return vo.getAvailintegral().longValue() >= inte ? true : false;
		}
		return false;
	}

	/**
	 * ͨ���ֻ�����ͻ������ڻ��CustInteVO
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
	 * �޸�ת�ƿͻ����û���
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
	 * ���ת�ƻ�����־
	 */
	public void createLog(CustInteVO vo, long value ,long transferinte, User user)
			throws Exception {

		InteUtils.createInteLog(vo.getUserid(),vo.getCustid(),vo.getIntegralcyc(),
				new Long(value),vo.getAvailintegral(),
				transferinte,-1,"",user,false);
	}
	
	//���ֵ�����adjintΪ��������
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
			throw new Exception("���ֵ���ʧ�ܣ� "  + e.getCause());
		}
		
		return vo;
	}
	
}
