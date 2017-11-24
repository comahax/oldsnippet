package com.gmcc.pboss.BgProcess.sales.notice;


import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;

import com.gmcc.pboss.control.sales.notice.DeliverTakeGoodsNotice;
import com.gmcc.pboss.control.sales.notice.DeliverTakeGoodsNoticeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

import com.sunrise.jop.ui.User;

public class DeliverTakeGoodsNoticeProcess extends BgBase {

	private static Logger logger = Logger.getLogger(DeliverTakeGoodsNoticeProcess.class);
	
	public static void main(String[] args){
		try{
			DeliverTakeGoodsNoticeProcess notice = new DeliverTakeGoodsNoticeProcess();
			if( !notice.checkArgs(args))
				return;
			String cityid = args[0];
			User user = notice.getUser(cityid);
			notice.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/sales/notice/hibernate.cfg.xml");
			notice.setMyProfilePath("/sales_delivertakegoodsnotice.properties");
			notice.init(args);
			notice.process(cityid, user);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void process(String cityid,User user) throws Exception{
		DeliverTakeGoodsNotice bo = (DeliverTakeGoodsNotice) BOFactory.build(DeliverTakeGoodsNoticeBO.class,user);
		bo.doNotice();
	}
}
