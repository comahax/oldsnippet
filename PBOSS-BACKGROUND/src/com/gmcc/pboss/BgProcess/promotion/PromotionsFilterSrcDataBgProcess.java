package com.gmcc.pboss.BgProcess.promotion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import open.tool.rule.data.VO;


import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.control.promotion.ruleitem.Ruleitem;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;
/**
 * Դ���ݹ���
 * @author zhangsiwei
 * @version 1.0
 */
public class PromotionsFilterSrcDataBgProcess extends BgBase {

	public static void main(String[] args) throws Exception{
		
		PromotionsFilterSrcDataBgProcess pro = new PromotionsFilterSrcDataBgProcess();
		boolean isPass = pro.checkArgs(args);
		if (!isPass) {
			return;
		}
		// ��ȡUser
		User user = pro.getUser(args[0]);
		// ����hibernate�����ļ�·���������class path��·����
		pro.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/promotion/hibernate.cfg.xml");
		// ���ø��Ի������ļ�·���������class path��·����
		pro.setMyProfilePath("/promotionBgProcess.properties");
		// ��ʼ��
		pro.init(args);
		Map<VO,Object> resultMap = new HashMap<VO,Object>();
		resultMap = pro.srcDataFiltering(Long.parseLong(args[1]), Long.parseLong(args[2]), user);
		// ========������=================
		Set<Map.Entry<VO,Object>> entrySet = resultMap.entrySet();
		for(Iterator<Map.Entry<VO,Object>> it = entrySet.iterator();it.hasNext();) {
			Map.Entry<VO,Object> entry = it.next();
			DefaultVO defaultVo = (DefaultVO)entry.getKey();
			Map<String, ?> keys = defaultVo.getKeys();
			Set<String> keySet = keys.keySet();
			for(Iterator<String> keyIt = keySet.iterator();keyIt.hasNext();) {
				String key = keyIt.next();
				Object keyValue = keys.get(key);
				System.out.print(key+": "+keyValue+"\t");
			}
			System.out.println("������: "+entry.getValue());
		}
	}
	/**
	 * ���� �������(����)����Ʒ���࣬��Դ ����Դ����
	 * @param pId ������ʶ
	 * @param ruleId  �����ʶ
	 * @param cityId  ���б�ʶ
	 * @return
	 * @throws Exception
	 */
	public Map<VO,Object> srcDataFiltering(long pId,long ruleId,User user)throws Exception {
		
		Map<VO,Object> resultMap = new HashMap<VO,Object>();
		Ruleitem riBo = (RuleitemBO)BOFactory.build(RuleitemBO.class, user);
		try {
			resultMap = riBo.doSrcDataFiltering(pId, ruleId);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
		return resultMap;
	}
	
	protected static String getHelp() {
		StringBuffer sb = new StringBuffer();
		sb.append("Explain of args:").append("\n");
		sb.append("the args number is 5").append("\n");
		sb.append("[cityid][Pid][ruleid]").append("\n");
		sb.append("e.g. [ZS][815][1201]");
		return sb.toString();
	}
	@Override
	protected boolean checkArgs(String[] args) {
		if (args.length < 3) {
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		return true;
	}
	
	

}
