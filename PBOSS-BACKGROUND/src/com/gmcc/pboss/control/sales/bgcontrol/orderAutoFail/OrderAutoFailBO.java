package com.gmcc.pboss.control.sales.bgcontrol.orderAutoFail;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.common.utils.lang.TimeUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderAutoFailBO extends AbstractControlBean implements
		OrderAutoFail {

	private Logger log = Logger.getLogger(OrderAutoFailBO.class);
	public  final double  oneHour=1000*60*60;

	/**
	 * 
	 * @param confirmTime
	 * @throws Exception
	 */
	public void failConfirmOutOrder(String confirmTime) throws Exception {
		long confTime = 0;
		try {
			confTime = Long.parseLong(confirmTime);
			if(confTime<=0)
			{
				return;
			}
		} catch (Exception ex) {
			log.info("系统参数转换错误：'pboss_fx','61'");
		}
		//查询订单表中状态为待确认的记录
		Order order= (Order) BOFactory.build(OrderBO.class, user);
		OrderDBParam listVO=new OrderDBParam();
		listVO.set_se_orderstate("WAITCON");
		listVO.set_pagesize("0");
		DataPackage dp=order.doQuery(listVO);
		if (null != dp && null != dp.getDatas()) {
			List<OrderVO> list = dp.getDatas();
			for (OrderVO vo : list) {
				 try {
					Date statechgtime=vo.getStatechgtime();
					 long pasttime=TimeUtils.getWorkdayTimeInMillis(statechgtime.getTime(),new Date().getTime());
					 if(((double)pasttime)/oneHour-(double)confTime>0)
					 {
						 //调用订单作废逻辑
						 vo.setMemo("确认超时"+TimeUtils.formatDate(new Date()));
						 vo.setStatechgtime(new Date());
						 order.doCancle(vo);
						 log.info("订单："+vo.getOrderid()+"被成功作废，作废原因：确认超时");
					 }
				} catch (Exception e) {
					log.error("订单："+vo.getOrderid()+"作废失败，失败原因：" + e.getMessage());
					continue;
				}
			}
		}
	}

	/**
	 * 
	 * @param sendTime
	 * @throws Exception
	 */
	public void failSendOutOrder(String sendTime) throws Exception {
		long sTime = 0;
		try {
			sTime = Long.parseLong(sendTime);
			if(sTime<=0)
			{
				return;
			}
		} catch (Exception ex) {
			log.info("系统参数转换错误：'pboss_fx','62'");
		}
		//查询配送单
		Order order= (Order) BOFactory.build(OrderBO.class, user);
		Disform disformbo = (Disform)BOFactory.build(DisformBO.class, user);
		DisformDBParam disparam = new DisformDBParam();
		disparam.set_se_disstate("WAITOUT");//待发货（WAITOUT）modify by panyonghui 
		disparam.set_pagesize("0");
		DataPackage dp = disformbo.doQuery(disparam);
		List<DisformVO> list = dp.getDatas();
		for (DisformVO vo : list) {
			 try {
				 OrderVO ordervo = order.doFindByPk(vo.getOrderid());
				Date createTime=vo.getCreatetime();
				 long pasttime=TimeUtils.getWorkdayTimeInMillis(createTime.getTime(),new Date().getTime());
				 if(((double)pasttime)/oneHour-(double)sTime>0)
				 {
					 //调用订单作废逻辑
					 ordervo.setMemo("配送超时"+TimeUtils.formatDate(new Date()));
					 ordervo.setStatechgtime(new Date());
					 order.doCancle(ordervo);
					 log.info("订单："+vo.getOrderid()+"被成功作废，作废原因：配送超时");
				 }
			} catch (Exception e) {
				log.error("订单："+vo.getOrderid()+"作废失败，失败原因：" + e.getMessage());
				continue;
			}
		}
	}
}
