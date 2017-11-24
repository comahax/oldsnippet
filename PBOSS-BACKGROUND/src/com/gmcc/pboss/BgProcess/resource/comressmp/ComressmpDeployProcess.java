package com.gmcc.pboss.BgProcess.resource.comressmp;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.resource.comressmp.ComressmpDeploy;
import com.gmcc.pboss.control.resource.comressmp.ComressmpDeployBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * 套卡资源发布
 * @author wefrogll
 * @version 1.0 2009-12-15
 */
public class ComressmpDeployProcess extends BgBase {

	public static void main(String[] args){
		try{
			ComressmpDeployProcess comressDeployProcess = new ComressmpDeployProcess();
			boolean isPass = comressDeployProcess.checkArgs(args);
			if (!isPass) {
				return;
			}
			User user = comressDeployProcess.getUser(args[0]);
			comressDeployProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/resource/comressmp/hibernate.cfg.xml");
			comressDeployProcess.setMyProfilePath("/resource_comressmpdeploy.properties");
			comressDeployProcess.init(args);
			long sleepSec = Long.parseLong(comressDeployProcess.properties.getProperty(args[0]+"_interval"));
			ComressmpDeploy comressmpDeployBO = (ComressmpDeployBO)BOFactory.build(ComressmpDeployBO.class,user);
			while(true){
				try{
					comressmpDeployBO.process();
					System.out.println("===============休眠 "+sleepSec +"秒==================");
					Thread.sleep(sleepSec*1000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
