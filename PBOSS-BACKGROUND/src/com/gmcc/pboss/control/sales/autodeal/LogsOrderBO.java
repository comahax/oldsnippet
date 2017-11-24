package com.gmcc.pboss.control.sales.autodeal;

import java.util.Calendar;
import java.util.Date;

import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * <p>Title: LogsOrderBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class LogsOrderBO extends AbstractControlBean implements OrderDeal {

	public boolean doDeal(OrderVO orderVO, DBAccessUser user) throws Exception {

		try {
			
			/*
			 * 新增数据到分销资源配送单（FX_SW_DISFORM）
			 */
			Disform disformBO = (DisformBO)BOFactory.build(DisformBO.class,user);
			DisformVO disformVO = new DisformVO();
			disformVO.setOrderid(orderVO.getOrderid());//订单编号
			disformVO.setRecewayid(orderVO.getWayid());//收货网点取合作商编码
			Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
			WayVO wayVO = wayBO.doFindByPk(orderVO.getWayid());
			disformVO.setDiscomcode(wayVO.getLogiscode() == null ?" ":wayVO.getLogiscode());
			// 根据合作商编码查询分销合作商资料表
			Cooperator cooperatorBO = (Cooperator)BOFactory.build(CooperatorBO.class,user);
			CooperatorVO cooperatorVO=cooperatorBO.doFindByPk(orderVO.getWayid());
			
			if(cooperatorVO!=null){
				disformVO.setReceadd(cooperatorVO.getSendaddr()==null?" ":cooperatorVO.getSendaddr());//获取收货人地址（即送货地址）
				disformVO.setRecename(cooperatorVO.getRecpers()==null?" ":cooperatorVO.getRecpers());//收货人姓名（即收货联系人
				disformVO.setRecetel(cooperatorVO.getRecconntel()==null?" ":cooperatorVO.getRecconntel());//收货人电话（即收货联系号码）
			}else{
				disformVO.setReceadd(" ");//留空
				disformVO.setRecename(" ");//留空
				disformVO.setRecetel(" ");//留空
			}
			//创建时间取当前时间，要求送达时间取当前时间加48小时，配送单状态取待发货，备注、发货人和发货时间留空
			Calendar calenDar = Calendar.getInstance();
			disformVO.setCreatetime(calenDar.getTime());
			calenDar.add(Calendar.HOUR, 48);
			disformVO.setArrivetime(calenDar.getTime());
			disformVO.setDisstate("WAITOUT");// 配送单状态取待发货
			disformBO.doCreate(disformVO);
			
			Order bo = (Order)BOFactory.build(OrderBO.class,user);
			// 更新订单表中的订单状态为“已建立配送单”，更新状态变更时间为当前时间
			OrderVO vo = bo.doFindByPk(orderVO.getOrderid());
			vo.setOrderstate("CREATEDDISF");// 订单状态为“已建立配送单”
			vo.setStatechgtime(new Date());// 更新状态变更时间为当前时间
			bo.doUpdate(vo);
			// 调用【订单下一步处理公用方法】，不判断处理结果			
			bo.doNextProcess(orderVO.getOrderid());
									
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

}
