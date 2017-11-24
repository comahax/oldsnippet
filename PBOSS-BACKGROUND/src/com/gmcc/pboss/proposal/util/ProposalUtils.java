package com.gmcc.pboss.proposal.util;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.common.utils.tools.TiedComInfo;
import com.gmcc.pboss.control.promotion.spproposal.Spproposal;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;

/**
 * <pre>
 * 外部模块接口
 * 根据概要设计，ProposalUtils是供外部模块调用的类，
 * 本不须继承BgBase，此处继承是为了方便测试。
 * </pre>
 * @author zhangsiwei
 *
 */
public class ProposalUtils extends BgBase{

	
	/**
	 * 参看getHelp()中对入口参数的说明
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{

		ProposalUtils pro = new ProposalUtils();
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
		String wayid = args[2];
		String comcategory = args[3];
		List resids = new ArrayList();
		for(int i = 4;i<args.length;i++) {
			resids.add(args[i]);
		}
		
		if("0".equals(args[1])) {
			List<TiedComInfo> resultList = new ArrayList<TiedComInfo>();
			resultList = pro.tieInSale(wayid, comcategory, resids, args[0]);
			for(TiedComInfo cominfo : resultList) {
				long pid = cominfo.getPid();
				long ruleid = cominfo.getRuleid();
				String tComcategory = cominfo.getTComCategory();
				int tQuantity = cominfo.getTQuantity();
				System.out.println(
							"方案标识："+pid
							+"\t规则标识："+ruleid
							+"\t搭售商品种类："+tComcategory
							+"\t搭售商品数量："+tQuantity
						);
			}
		}else {
			List<TiedComInfo> resultList = new ArrayList<TiedComInfo>();
			resultList = pro.presentingB(wayid, comcategory, resids, args[0]);
			for(TiedComInfo cominfo : resultList) {
				long pid = cominfo.getPid();
				long ruleid = cominfo.getRuleid();
				String pComcategory = cominfo.getTComCategory();
				int pQuantity = cominfo.getTQuantity();
				System.out.println(
							"方案标识："+pid
							+"\t规则标识："+ruleid
							+"\t赠送商品种类："+pComcategory
							+"\t赠送商品数量："+pQuantity
						);
			}
		}
		
	}

	/**
	 * 搭售促销方案
	 * 返回渠道可搭售的商品种类及数量
	 * @param wayId
	 * @param comCategory
	 * @param resids
	 * @param cityid
	 * @return
	 * @throws Exception
	 */
	public static List tieInSale(String wayId, String comCategory, List resids,
			String cityid) throws Exception {

		List<TiedComInfo> resultList = new ArrayList<TiedComInfo>();
		User user = new User();
		user.setCityid(cityid);
		user.setOpername("PBOSS-BG");
		Spproposal spBo = (SpproposalBO)BOFactory.build(SpproposalBO.class,user);
		resultList = spBo.doTieInSale(wayId, comCategory, resids);
		return resultList;
	}

	/**
	 * 赠送（事前）促销方案模块
	 * @param wayId
	 * @param comCategory
	 * @param resids
	 * @param cityid
	 * @return
	 * @throws Exception
	 */
	public static List presentingB(String wayId, String comCategory,
			List resids, String cityid) throws Exception {
		
		List<TiedComInfo> resultList = new ArrayList<TiedComInfo>();
		User user = new User();
		user.setCityid(cityid);
		user.setOpername("PBOSS-BG");
		Spproposal spBo = (SpproposalBO)BOFactory.build(SpproposalBO.class,user);
		resultList = spBo.doPresentingB(wayId, comCategory, resids);
		return resultList;
	}

	
	@Override
	protected boolean checkArgs(String[] args) {
		if (args.length < 5) {
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
		sb.append("the args number is not less than 5").append("\n");
		sb.append("[cityid] [0 for tieInSale; 1 for presentingB] [wayid] [comcategary] [resids1] [resids2] ...").append("\n");
		sb.append("e.g. [ZS 0 CH_2323 100DZ 13988888888 13712345678]");
		return sb.toString();
	}
}
