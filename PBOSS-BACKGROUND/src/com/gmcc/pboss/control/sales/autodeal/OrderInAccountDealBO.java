package com.gmcc.pboss.control.sales.autodeal;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.resource.resoperator.ResoperatorDBParam;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.control.resource.resoperator.Resoperator;
import com.gmcc.pboss.control.resource.resoperator.ResoperatorBO;
import com.gmcc.pboss.control.sales.bgcontrol.autobossinaccount.AutoBossInAccountBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.web.common.webservice.CRMServiceforback;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class OrderInAccountDealBO extends AbstractControlBean implements OrderDeal {

	private static Logger logger = Logger.getLogger(OrderInAccountDealBO.class);
	
	public boolean doDeal(OrderVO order, DBAccessUser user1) throws Exception {
		// 对订单信息遍历做入账处理
		OrderVO vo = order;
		User user = (User) user1;
		Order bo = (Order) BOFactory.build(OrderBO.class, user);
		try {
			logger.info("开始处理*************"+vo.getOrderid()+"****************");
			logger.info("后台调用COMS入账开始*************"+vo.getOrderid()+"****************");
			OrderVO orderVO = bo.recorded(vo.getOrderid(), vo.getWayid(),"0");// 调用本地入账程序
			logger.info("后台调用COMS入账结束*************"+vo.getOrderid()+"****************");
			//OrderVO orderVO = bo.doFindByPk(vo.getOrderid());//测试使用，测试时可把上面一行COMS入账代码注释掉，直接测试CRM入账
			if(new CRMServiceforback().isCRMCityPort(user1.getCityid())){//如果是CRM入账，则进行调用CRM入账接口。
				logger.info(user1.getCityid()+"地市为CRM入账地市，进入CRM入账流程*************"+vo.getOrderid()+"****************");
				//2012-05-28
				// 根据订单编号和资源类别不等于空白SIM卡为条件查询订单资源明细表（FX_SW_ORDERRESDET）如果没数据，跳过以下CRM入账操作。
				logger.info(vo.getOrderid()+"*************根据订单编号和资源类别不等于空白SIM卡为条件查询订单资源明细表,如果没数据，跳过以下CRM入账操作****************");
				Orderresdet orderdet = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);				
				OrderresdetDBParam orderresdet = new OrderresdetDBParam();
				orderresdet.setQueryAll(true);
				orderresdet.setDataOnly(true);
				orderresdet.set_se_orderid(orderVO.getOrderid());
				orderresdet.set_sne_restype("EMPTYSIM");
				DataPackage orderresdetdp = orderdet.doQuery(orderresdet);
				//2012-05-28
				//在调用接口封装操作工号参数时，根据资源所属渠道和地市标识去查询资源操作工号设置表(IM_FX_RESOPERATOR)，
				//获取对应的操作工号。如没有对应的工号信息则将BOSS工号修改为“-1”，将订单表的备注字段修改为“资源自动入
				//账对应的操作工号未设置”
				if (orderresdetdp != null && orderresdetdp.getDatas() != null && orderresdetdp.getDatas().size() > 0) {
					logger.info(vo.getOrderid()+"*************明细记录存在，继续后续CRM入账流程****************");
					String operatorid = null;
					String wayid = null;
					//根据第一条资源明细获取资源所属渠道
					OrderresdetVO orderresdetVO = (OrderresdetVO)orderresdetdp.getDatas().get(0);
					String reswayid = orderresdetVO.getWayid();
					logger.info(vo.getOrderid()+"*************根据第一条资源明细获取资源所属渠道："+reswayid+"****************");
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
						logger.info(vo.getOrderid()+"*************入账操作工号："+operatorid+"****************");
						wayid = resoperVO.getWayid();
						logger.info(vo.getOrderid()+"*************入账操作渠道："+wayid+"****************");
						//调用NGCRM入账
						logger.info("后台调用CRM入账开始*************"+vo.getOrderid()+"****************");
						orderVO = bo.recordByCRM(orderVO.getOrderid(), wayid, operatorid);
						logger.info("后台调用CRM入账结束*************"+vo.getOrderid()+"****************");
					}else{
						orderVO.setBossworkfid("-1");
						orderVO.setMemo(vo.getOrderid()+"资源自动入账对应的操作工号未设置");
						bo.doUpdate(orderVO);
						logger.info("处理完毕*************"+vo.getOrderid()+"*******资源自动入账对应的操作工号未设置*********");
						return false;
					}
				}else{
					logger.info(vo.getOrderid()+"*************明细记录不存在，跳过CRM入账操作****************");
				}
			}			
			logger.info("处理完毕*************"+vo.getOrderid()+"****************");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
