package com.gmcc.pboss.control.sales.bgcontrol.autobossinaccount;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.resource.resoperator.ResoperatorDBParam;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.control.resource.resoperator.Resoperator;
import com.gmcc.pboss.control.resource.resoperator.ResoperatorBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.web.common.webservice.CRMServiceforback;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class AutoBossInAccountBO extends AbstractControlBean implements
		AutoBossInAccount {

	private static Logger logger = Logger.getLogger(AutoBossInAccountBO.class);
	
	public void process(DataPackage dp, User user,Logger log) throws Exception {
		// 对订单信息遍历做入账处理
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
			for (Iterator<OrderVO> it = dp.getDatas().iterator(); it.hasNext();) {
				OrderVO vo = it.next();
				Order bo = (Order) BOFactory.build(OrderBO.class, user);
				try {
					logger.info("开始处理*************"+vo.getOrderid()+"****************");
					Orderresdet orderdet = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);

					// 根据订单编号和资源类别不等于空白SIM卡为条件查询订单资源明细表（FX_SW_ORDERRESDET）如果没数据，跳过以下BOSS入账操作。
					OrderresdetDBParam orderresdet = new OrderresdetDBParam();
					orderresdet.setQueryAll(true);
					orderresdet.setDataOnly(true);
					orderresdet.set_se_orderid(vo.getOrderid());
					orderresdet.set_sne_restype("EMPTYSIM");
					DataPackage orderresdetdp = orderdet.doQuery(orderresdet);
					if (orderresdetdp != null && orderresdetdp.getDatas() != null && orderresdetdp.getDatas().size() > 0) {
						//2012-05-28
						//在调用接口封装操作工号参数时，根据资源所属渠道和地市标识去查询资源操作工号设置表(IM_FX_RESOPERATOR)，
						//获取对应的操作工号。如没有对应的工号信息则将BOSS工号修改为“-1”，将订单表的备注字段修改为“资源自动入
						//账对应的操作工号未设置”
						String operatorid = null;
						//根据第一条资源明细获取资源所属渠道
						OrderresdetVO orderresdetVO = (OrderresdetVO)orderresdetdp.getDatas().get(0);
						String reswayid = orderresdetVO.getWayid();
						Resoperator resoper = (ResoperatorBO)BOFactory.build(ResoperatorBO.class, user);
						ResoperatorDBParam rparam = new ResoperatorDBParam();
						rparam.set_se_cityid(user.getCityid());
						rparam.set_se_wayid(reswayid);
						rparam.setDataOnly(true);
						rparam.setQueryAll(true);
						DataPackage resoperdp = resoper.doQuery(rparam);
						if(resoperdp!=null && resoperdp.getDatas()!=null && resoperdp.getDatas().size()>0){
							ResoperatorVO resoperVO = (ResoperatorVO)resoperdp.getDatas().get(0);
							operatorid = resoperVO.getOperid();
							String wayid = resoperVO.getWayid();
							OrderVO reorderVO = bo.recordByBoss(vo.getOrderid(), wayid, operatorid);
							log.info("BOSS入账成功");
							// 发送售卡短信
							bo.doSmsForSale(reorderVO);
						}else{
							vo.setBossworkfid("-1");
							vo.setMemo("资源自动入账对应的操作工号未设置");
							logger.info("资源自动入账对应的操作工号未设置");
							bo.doUpdate(vo);
						}						
						
						//以下代码2012-05-28注释掉
						//OrderVO reorderVO = bo.recordByBoss(vo.getOrderid(),wayid);
						//if (new CRMServiceforback().isCRMCityPort(user.getCityid())) {
						//	log.info("已经提交NGCRM入帐");
						//} else {
						//	log.info("BOSS入账成功");
						//	// 发送售卡短信
						//	Order boSms = (Order) BOFactory.build(OrderBO.class, user);
						//	boSms.doSmsForSale(reorderVO);
						//}
					}
					logger.info("处理完毕*************"+vo.getOrderid()+"****************");
				} catch (Exception e) {
					log.info(e.getMessage());
					logger.info("处理失败*************"+vo.getOrderid()+"****************"+e.getMessage());
				}

			}
		}

	}

}
