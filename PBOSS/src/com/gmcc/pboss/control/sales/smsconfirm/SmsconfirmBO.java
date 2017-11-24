/**
 * auto-generated code
 * Mon May 24 14:01:26 CST 2010
 */
package com.gmcc.pboss.control.sales.smsconfirm;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDAO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.common.sms.ComOrderSms;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SmsconfirmBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class SmsconfirmBO extends AbstractControlBean implements
		Smsconfirm {

	public SmsconfirmVO doCreate(SmsconfirmVO vo) throws Exception {
		try {
			SmsconfirmDAO dao = (SmsconfirmDAO) DAOFactory.build(SmsconfirmDAO.class, user);
			// TODO set the pk */
			return (SmsconfirmVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SmsconfirmVO vo) throws Exception {
		try {
			SmsconfirmDAO dao = (SmsconfirmDAO) DAOFactory.build(SmsconfirmDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SmsconfirmDAO dao = (SmsconfirmDAO) DAOFactory.build(SmsconfirmDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsconfirmVO doUpdate(SmsconfirmVO vo) throws Exception {
		try {
			SmsconfirmDAO dao = (SmsconfirmDAO) DAOFactory.build(SmsconfirmDAO.class,user);
			return (SmsconfirmVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SmsconfirmVO doFindByPk(Serializable pk) throws Exception {
		SmsconfirmDAO dao = (SmsconfirmDAO) DAOFactory.build(SmsconfirmDAO.class,user);
		return (SmsconfirmVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SmsconfirmDBParam params)
			throws Exception {
		SmsconfirmDAO dao = (SmsconfirmDAO) DAOFactory.build(SmsconfirmDAO.class,user);
		return dao.query(params);
	}
    /**
     * �ط�����ȷ��
     * @param pkItem
     * @throws Exception
     */
	public void doSecondConfirm(String[] pkItem) throws Exception{
		try {
			SmsconfirmDBParam params=new SmsconfirmDBParam();
			params.set_se_type("ORDERCON");
			params.set_se_state("WAITREP");
			List<SmsconfirmVO> list=null;
			SmsconfirmVO smsconvo=null;
			OrderVO orderVO=null;
			CooperatorVO cooperatorVO=null;
			Order orderBO=(Order) BOFactory.build(OrderBO.class,user);
			Cooperator  cooperatorBO=(Cooperator) BOFactory.build(CooperatorBO.class,user);
			Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
			//��ȡ���ŷ��ͺ���
			String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
			WaitreqVO waitreqVO=null;
			ComOrderSms comOrderSms=new ComOrderSms();
			
			for(String orderid:pkItem){
				orderVO=orderBO.doFindByPk(orderid);
				waitreqVO=new WaitreqVO();
				params.set_se_orderid(orderid);
				list=this.doQuery(params).getDatas();
				if(list!=null && list.size()>0){//��������ݣ��޸�֪ͨʱ��Ϊ��ǰʱ�䣬
					for(SmsconfirmVO vo:list){
						vo.setSendtime(new Date());
						waitreqVO.setRecno(vo.getMobileno());
						this.doUpdate(vo);
					}
					
				}else{//��������ݣ�����һ�����ݷ�������ȷ�ϱ�
					smsconvo=new SmsconfirmVO();
					smsconvo.setType("ORDERCON");//����ȡ��������ȷ��
					smsconvo.setStream(orderid.substring(orderid.length()-4, orderid.length()));//ȷ����ˮ��ȡ����ĩβ4λ
					smsconvo.setOrderid(orderid);//����������ȡ�������
					smsconvo.setState("WAITREP");//״̬ȡ���ظ�
					smsconvo.setSendtime(new Date());//֪ͨʱ��ȡ��ǰʱ��
					////���ݺ����̱����ѯ�������������ϱ�CH_DST_COOPERATOR�����ֻ�����ȡ�ջ���ϵ����
					cooperatorVO=cooperatorBO.doFindByPk(orderVO.getWayid());
					if(cooperatorVO!=null){
						smsconvo.setMobileno(cooperatorVO.getRecconntel());
						waitreqVO.setRecno(cooperatorVO.getRecconntel());
					}
					this.doCreate(smsconvo);
				}
				////��ζ���״̬���ǡ���ȷ�ϡ����������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)����������ȡ3�������ֻ�����ȡ��Ʒ������������ֻ����룬���ŷ��ͺ���ȡ��һ����ȡ�Ĳ���ֵ��
				
				waitreqVO.setSmstype((short)3);
				waitreqVO.setAreacode(user.getCityid());
				waitreqVO.setCreattime(new java.util.Date());
				waitreqVO.setSendno(sysparamvalue42);
				if(!"WAITCON".equals(orderVO.getOrderstate())){
					waitreqVO.setMessage(comOrderSms.getSuccessSms(orderVO.getOrderid(), user));//�������ݵ�����Ʒ�������Ź��÷����������ɹ����ţ���ȡ��
				}else{
					waitreqVO.setMessage(comOrderSms.getConfirmSms(orderVO.getOrderid(), user));//�������ݵ�����Ʒ�������Ź��÷�����ȡ������ȷ��֪ͨ��
				}
				waitreqBO.doCreate(waitreqVO);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new JOPException(ex);
		}
	}
	public void doConfirmSaveSmsWAITREQ(OrderVO orderVO) throws Exception{
		
		
	
		
	}
	
	/**
	 * ��������ǩ�ն���
	 * @param mobileno �������͵��Ľ��պ���
	 * @param stream ��������
	 * @return
	 */
	public SmsconfirmVO doFind4BatchSign(String mobileno, String orderid){
		SmsconfirmVO vo = null;
		try{
			SmsconfirmDAO dao = (SmsconfirmDAO) DAOFactory.build(SmsconfirmDAO.class,user);
			SmsconfirmDBParam params=new SmsconfirmDBParam();
			params.set_se_type("PARSIGN");//����-������ǩ��
			params.set_se_mobileno(mobileno);
			params.set_se_orderid(orderid);
			params.set_se_state("WAITREP");//״̬-���ָ�		
			params.set_orderby("sendtime");
			params.set_desc("0");
			params.set_pagesize("0");
			params.setDataOnly(true);
			DataPackage dp = dao.query(params);
			if(dp.getDatas().size()==0){
				return null;
			}
			else{
				vo = (SmsconfirmVO)dp.getDatas().get(0);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new JOPException(ex);
		}
		return vo;
	}
	
	
}

