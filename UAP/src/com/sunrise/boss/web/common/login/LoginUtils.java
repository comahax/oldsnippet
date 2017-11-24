package com.sunrise.boss.web.common.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunrise.boss.business.common.loginlog.persistent.LoginLogDBParam;
import com.sunrise.boss.business.common.loginlog.persistent.LoginLogVO;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.commoncontrol.CommonControl;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class LoginUtils {	

	public static void saveLoginLog(Byte result, String errormsg, User user) {
		
		try {
			
			CommonControl comm = (CommonControl)BOFactory.build(CommonBO.class,DBAccessUser.getCommonUser(user));
			comm.setVoClass(LoginLogVO.class);
			
			LoginLogVO vo = new LoginLogVO();
			vo.setOpertime(new Date());
			vo.setSystemid(user.getSystem());
			vo.setStaffid(user.getOprcode());
			vo.setResult(result);
			vo.setErrormsg(errormsg);
			comm.doCreate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 从文件获取临时用户
	 */
	public static Map getTmpUser() {
		Map userMap = new HashMap();
		try {
			File file = new File(LoginAction.class.getResource("/data/user.txt").getFile());
			FileReader fr = new FileReader(file);
			BufferedReader inFile = new BufferedReader(fr);
						
			String line = inFile.readLine();
			while(line!=null){
				if(!"".equals(line.trim()) && !line.startsWith("#")){
					String[] record = line.split("\\|");
					User user = new User();
					user.setOprcode(record[0]);
					user.setPassword(record[1]);
					user.setCityid(record[2]);
					userMap.put(record[0], user);		
				}
				line = inFile.readLine();
			}

			inFile.close();
			fr.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return userMap;
	}
	/*
	 * 获取用户最新的登录id
	 */
	public static Long getLoginLogid(User user) {
		
		Long logid = null;
		
		try {
			LoginLogDBParam param = new LoginLogDBParam();
			param.set_se_staffid(user.getOprcode());
			param.set_ne_result("1");
			param.set_orderby("logid");
			param.set_desc("1");
			param.setDataOnly(true);
			
			CommonControl comm = (CommonControl)BOFactory.build(CommonBO.class,DBAccessUser.getCommonUser(user));
			comm.setVoClass(LoginLogVO.class);
			DataPackage dp = comm.doQuery(param);
			List list = (List) dp.getDatas();
			if(list != null && list.size()>0 ) {
				LoginLogVO vo = (LoginLogVO)list.get(0);
				logid = vo.getLogid();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return logid;
	}
	
}
