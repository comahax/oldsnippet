package com.gmcc.pboss.BgProcess.promotion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.control.promotion.elmtinst.ElmtinstBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;

/**
 * 数据采集模块
 * @author zhangsiwei
 * @version 1.0
 */
public class PromotionsGatheringBgProcess extends BgBase{
	
	public static void main(String[] args) throws Exception{
		PromotionsGatheringBgProcess pro = new PromotionsGatheringBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// 获取User
		User user = pro.getUser(args[0]);
		// 设置hibernate配置文件路径（相对于class path的路径）
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/promotion/hibernate.cfg.xml");
		// 设置个性化配置文件路径（相对于class path的路径）
		pro.setMyProfilePath("/promotionBgProcess.properties");
		// 初始化
		pro.init(args);
		List resultList = new ArrayList();
		resultList = pro.doGatherPromotionsDataByInstId(args[1],user);
		for(int i=0;i<resultList.size();i++) {
			DefaultVO defaultVo = (DefaultVO)resultList.get(i);
			Map<String, ?> keys = defaultVo.getKeys();
			Set<String> keySet = keys.keySet();
			for(Iterator<String> it = keySet.iterator();it.hasNext();) {
				String key = it.next();
				Object keyValue = keys.get(key);
				System.out.print(key+": "+keyValue+"\t");
			}
			if(defaultVo.getValue() != null) {
				System.out.println("BUSIVALUE: "+defaultVo.getValue());
			}else {
				System.out.println("");
			}
		}
	}
	
	public List doGatherPromotionsDataByInstId(String instId,User user) throws Exception{
		List resultList = new ArrayList();
		ElmtinstBO eiBO = (ElmtinstBO)BOFactory.build(ElmtinstBO.class, user);
		try {
			resultList = eiBO.doGatherPromotionsDataByInstId(instId);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
		return resultList;
	}

	@Override
	protected boolean checkArgs(String[] args) {
		if (args.length < 2) {
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		return true;
	}
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 2").append("\n");
		sb.append("[cityid][instid]").append("\n");
		sb.append("e.g. [ZS][I1211]");
		return sb.toString();
	}
	
	

	

}
