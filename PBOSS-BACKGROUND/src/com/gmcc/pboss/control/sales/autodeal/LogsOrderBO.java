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
			 * �������ݵ�������Դ���͵���FX_SW_DISFORM��
			 */
			Disform disformBO = (DisformBO)BOFactory.build(DisformBO.class,user);
			DisformVO disformVO = new DisformVO();
			disformVO.setOrderid(orderVO.getOrderid());//�������
			disformVO.setRecewayid(orderVO.getWayid());//�ջ�����ȡ�����̱���
			Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
			WayVO wayVO = wayBO.doFindByPk(orderVO.getWayid());
			disformVO.setDiscomcode(wayVO.getLogiscode() == null ?" ":wayVO.getLogiscode());
			// ���ݺ����̱����ѯ�������������ϱ�
			Cooperator cooperatorBO = (Cooperator)BOFactory.build(CooperatorBO.class,user);
			CooperatorVO cooperatorVO=cooperatorBO.doFindByPk(orderVO.getWayid());
			
			if(cooperatorVO!=null){
				disformVO.setReceadd(cooperatorVO.getSendaddr()==null?" ":cooperatorVO.getSendaddr());//��ȡ�ջ��˵�ַ�����ͻ���ַ��
				disformVO.setRecename(cooperatorVO.getRecpers()==null?" ":cooperatorVO.getRecpers());//�ջ������������ջ���ϵ��
				disformVO.setRecetel(cooperatorVO.getRecconntel()==null?" ":cooperatorVO.getRecconntel());//�ջ��˵绰�����ջ���ϵ���룩
			}else{
				disformVO.setReceadd(" ");//����
				disformVO.setRecename(" ");//����
				disformVO.setRecetel(" ");//����
			}
			//����ʱ��ȡ��ǰʱ�䣬Ҫ���ʹ�ʱ��ȡ��ǰʱ���48Сʱ�����͵�״̬ȡ����������ע�������˺ͷ���ʱ������
			Calendar calenDar = Calendar.getInstance();
			disformVO.setCreatetime(calenDar.getTime());
			calenDar.add(Calendar.HOUR, 48);
			disformVO.setArrivetime(calenDar.getTime());
			disformVO.setDisstate("WAITOUT");// ���͵�״̬ȡ������
			disformBO.doCreate(disformVO);
			
			Order bo = (Order)BOFactory.build(OrderBO.class,user);
			// ���¶������еĶ���״̬Ϊ���ѽ������͵���������״̬���ʱ��Ϊ��ǰʱ��
			OrderVO vo = bo.doFindByPk(orderVO.getOrderid());
			vo.setOrderstate("CREATEDDISF");// ����״̬Ϊ���ѽ������͵���
			vo.setStatechgtime(new Date());// ����״̬���ʱ��Ϊ��ǰʱ��
			bo.doUpdate(vo);
			// ���á�������һ�������÷����������жϴ�����			
			bo.doNextProcess(orderVO.getOrderid());
									
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

}
