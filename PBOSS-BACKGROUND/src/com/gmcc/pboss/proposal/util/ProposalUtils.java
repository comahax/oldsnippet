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
 * �ⲿģ��ӿ�
 * ���ݸ�Ҫ��ƣ�ProposalUtils�ǹ��ⲿģ����õ��࣬
 * ������̳�BgBase���˴��̳���Ϊ�˷�����ԡ�
 * </pre>
 * @author zhangsiwei
 *
 */
public class ProposalUtils extends BgBase{

	
	/**
	 * �ο�getHelp()�ж���ڲ�����˵��
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{

		ProposalUtils pro = new ProposalUtils();
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
							"������ʶ��"+pid
							+"\t�����ʶ��"+ruleid
							+"\t������Ʒ���ࣺ"+tComcategory
							+"\t������Ʒ������"+tQuantity
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
							"������ʶ��"+pid
							+"\t�����ʶ��"+ruleid
							+"\t������Ʒ���ࣺ"+pComcategory
							+"\t������Ʒ������"+pQuantity
						);
			}
		}
		
	}

	/**
	 * ���۴�������
	 * ���������ɴ��۵���Ʒ���༰����
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
	 * ���ͣ���ǰ����������ģ��
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
