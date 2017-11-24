package com.gmcc.pboss.BgProcess.resource.baodi;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.resource.baodi.Baodi;
import com.gmcc.pboss.control.resource.baodi.BaodiBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;



/**
 * 保底资源释放
 * @author wefrogll
 * @version 1.0 2009-10-28
 */
public class BaodiReleaseProcess extends BgBase{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			BaodiReleaseProcess baidiReleaseProcess = new BaodiReleaseProcess();
			boolean isPass = baidiReleaseProcess.checkArgs(args);
			if (!isPass) {
				return;
			}
			User user = baidiReleaseProcess.getUser(args[0]);
			baidiReleaseProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/resource/baodi/hibernate.cfg.xml");
			baidiReleaseProcess.setMyProfilePath("/resource_baodirelease.properties");
			baidiReleaseProcess.init(args);
			
			Baodi baodiBO = (BaodiBO)BOFactory.build(BaodiBO.class,user);
			baodiBO.process();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
