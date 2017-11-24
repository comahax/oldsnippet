package com.sunrise.boss.business.fee.acccounting.control;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleDAO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleListVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDAO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.StringSplit;

/**
 * User: mys
 * Date: 2007-12-24
 * ���˹�����
 */

public class AccountingUtils {
	
	public Map errMap = new HashMap();

	/** �й�˾* */
	public static final String[] region = new String[] { "jm", "zj", "yj",
			"mm", "dg", "hy", "hz", "qy", "st", "sw", "cz", "mz", "gz", "zh",
			"zs", "fs", "yf", "sg", "zq", "jy" };

	/** �б�ʶ* */
	public static final String[] CITYID = new String[] { "757", "756", "760",
			"755", "200", "751", "763", "766", "758", "769", "762", "753",
			"752", "750", "668", "662", "759", "754", "663", "660", "768" };

	public static HashMap cityGroup = new HashMap();
	static {
		cityGroup.put("999", "�㶫");
		cityGroup.put("200", "����");
		cityGroup.put("755", "����");
		cityGroup.put("756", "�麣");
		cityGroup.put("757", "��ɽ");
		cityGroup.put("754", "��ͷ");
		cityGroup.put("752", "����");
		cityGroup.put("759", "տ��");
		cityGroup.put("750", "����");
		cityGroup.put("758", "����");
		cityGroup.put("751", "�ع�");
		cityGroup.put("753", "÷��");
		cityGroup.put("769", "��ݸ");
		cityGroup.put("760", "��ɽ");
		cityGroup.put("668", "ï��");
		cityGroup.put("660", "��β");
		cityGroup.put("768", "����");
		cityGroup.put("663", "����");
		cityGroup.put("662", "����");
		cityGroup.put("763", "��Զ");
		cityGroup.put("762", "��Դ");
		cityGroup.put("766", "�Ƹ�");
	}

	/** �����б�ʶ **/
	public static String getCityName(String cityid) {
		String _cityid = SessionFactoryRouter.conversionCityid2Num(cityid);
		if (cityGroup.containsKey(_cityid)) {
			return (String) cityGroup.get(_cityid);
		}
		return _cityid;
	}

	/** ��ȡ�б�ʶ **/
	public static String getCityid(String cityid) {
		return SessionFactoryRouter.conversionCityid2Num(cityid);
	}

	/** �����й�˾���� **/
	public static String getCityCompid(String cityid) {
		return SessionFactoryRouter.conversionCityid(cityid);
	}

	/** ��ȡ�������ʶ **/
	public static String getCommonDB() {
		return SysInfo.COMMON_DB_FLAG;
	}
	
	/** ���������й�˾��ʶ **/
    public static String[] getcitys(String regiongroup){
    	String[] citys;
    	if(regiongroup != null && !"*,".equals(regiongroup)){
    	     citys = StringUtils.split(regiongroup, ",");
    	} else{    		
    		 citys= AccountingUtils.CITYID;
    	}
    	return citys;
    }

	/** ��ȡ��һ����Ч���ڣ�����,����Ҳ���,����״̬Ϊ-1 ע��ֻ����controlbean����� **/
	public static ValidBillCycVO getVbcVO(Long validbillcyc, String cityid) {
		ValidBillCycVO vbcvo = null;
		try {
			ValidBillCycDAO vbcdao = (ValidBillCycDAO) DAOFactory.build(
					ValidBillCycDAO.class, cityid);
			vbcvo = (ValidBillCycVO) vbcdao.findByPk(validbillcyc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (null == vbcvo) {
			vbcvo = new ValidBillCycVO();
			vbcvo.setState(new Long(-1));
		}
		return vbcvo;
	}

	/** ��ȡ��һ�����˹�������,����Ҳ���,����״̬Ϊ-1 ע��ֻ����controlbean����� * */
	public static BlTouchRuleVO getBtrVO(AccountingVO params, String cityid) {
		try {
			BlTouchRuleDAO btrdao = (BlTouchRuleDAO) DAOFactory.build(
					BlTouchRuleDAO.class, cityid);
			DataPackage dp = btrdao.query(params, false);
			if (null != dp && null != dp.getDatas() && dp.getDatas().size() > 0) {
				return (BlTouchRuleVO) ((List) (dp.getDatas())).get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	/** ��ȡ��һ�����˹��� **/
	public static BlTouchRuleVO getBlTouchRule(String validbillcyc, User user) {
		try {
			if(validbillcyc == null || "".equals(validbillcyc.trim())){
				return null;
			}
			BlTouchRuleListVO listvo = new BlTouchRuleListVO();
			listvo.set_ne_validbillcyc(validbillcyc);
			listvo.set_se_batchnum("01");
			
			CommonDelegate delegate = new CommonDelegate(BlTouchRuleVO.class);
			
			
			DataPackage dp = delegate.doQuery(listvo,user, false);
			if (null != dp && null != dp.getDatas() && dp.getDatas().size() > 0) {
				return (BlTouchRuleVO) ((List) (dp.getDatas())).get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	


	/**��forward��״̬������ת�ɳ���������־���˲������ֵ  **/
	public static String startStep2Num(String startStep) {
		if ("FIX".equals(startStep) || "fixlist".equals(startStep)) {
			return "101";
		}
		if ("USR".equals(startStep) || "usrlist".equals(startStep)) {
			return "102";
		}
		if ("ACC".equals(startStep) || "acclist".equals(startStep)) {
			return "103";
		}
		if ("CFM".equals(startStep) || "cfmlist".equals(startStep)) {
			return "104";
		}
		if ("WOF".equals(startStep) || "woflist".equals(startStep)) {
			return "105";
		}
		if ("FIXC".equals(startStep) || "fixclist".equals(startStep)) {
			return "1011";
		}
		if ("PRMC".equals(startStep) || "prmclist".equals(startStep)) {
			return "100";
		}
		if ("RED".equals(startStep) || "redlist".equals(startStep)) {
			return "80";
		}
		if ("NUL".equals(startStep) || "nullist".equals(startStep)) {
			return "75";
		}	
		return startStep;
	}
	
	/**�ѳ���������־���˲������ֵת��״̬������  **/
	public static String num2StartStep(String startStep) {
		if ("101".equals(startStep)) {
			return "FIX";
		}
		if ("102".equals(startStep)) {
			return "USR";
		}
		if ("103".equals(startStep)) {
			return "ACC";
		}
		if ("104".equals(startStep)) {
			return "CFM";
		}
		if ("105".equals(startStep)) {
			return "WOF";
		}
		if ("1011".equals(startStep)) {
			return "FIXC";
		}
		if ("100".equals(startStep)) {
			return "PRMC";
		}
		if ("80".equals(startStep)) {
			return "RED";
		}
		if ("75".equals(startStep)) {
			return "NUL";
		}	
		return startStep;
	}
	
	/**
	 * ���ȼ�: 4 -> 2 -> 1 -> 3 -> 0	
	 * @param list	          
	 * @return String
	 */
	public static String chkState(List list) {
		String state = "0";
		StringBuffer _strBState = new StringBuffer();

		if (null != list) {

			for (int i = 0; i < list.size(); i++) {

				String _state = (String) list.get(i);
				_strBState.append(_state);

				if ("4".equals(_state)) {
					return _state;
				}

				if ("2".equals(state)) {
					continue;
				}
				if ("2".equals(_state)) {
					state = _state;
					continue;
				}
			}
			if ("2".equals(state)) {
				return state;
			}

			String _strState = _strBState.toString();
			if (_strState.indexOf("3") == -1) {
				if (_strState.indexOf("1") == -1) {
					return "0";
				} else {
					return "1";
				}
			}
			if (_strState.indexOf("0") == -1 && _strState.indexOf("1") == -1) {
				return "3";
			}
			return "2";
		}

		return state;
	}

	/** ��ȡ�������˲���״̬ **/
	public static List getState(List list, int step) {
		
		List newlist = new ArrayList();
		if (null != list) {			

			for (int i = 0; i < list.size(); i++) {
				String _state = "0";
				AccountingVO vo = (AccountingVO) list.get(i);
				BlTouchRuleVO btrvo = vo.getBtrvo();

				switch (step) {
					case 101:
						if (null != btrvo.getFixstate()) {
							_state = btrvo.getFixstate().toString();
						}
						newlist.add(_state);
						break;
					case 50:
						if (null != btrvo.getFixcfmstate()) {
							_state = btrvo.getFixcfmstate().toString();
						}
						newlist.add(_state);
						break;
					case 51:
						if (null != btrvo.getPrmcfmstate()) {
							_state = btrvo.getPrmcfmstate().toString();
						}
						newlist.add(_state);
						break;
					case 102:
						if (null != btrvo.getUsrbillstate()) {
							_state = btrvo.getUsrbillstate().toString();
						}
						newlist.add(_state);
						break;
					case 103:
						if (null != btrvo.getAccbillstate()) {
							_state = btrvo.getAccbillstate().toString();
						}
						newlist.add(_state);
						break;
					case 104:
						if (null != btrvo.getCfmbillstate()) {
							_state = btrvo.getCfmbillstate().toString();
						}
						newlist.add(_state);
						break;
					case 105:
						if (null != btrvo.getWoffstate()) {
							_state = btrvo.getWoffstate().toString();
						}
						newlist.add(_state);
						break;
					case 75:
						if (null != btrvo.getNullrecstate()) {
							_state = btrvo.getNullrecstate().toString();
						}
						newlist.add(_state);
						break;	
					case 80:
						if (null != btrvo.getReducestate()) {
							_state = btrvo.getReducestate().toString();
						}
						newlist.add(_state);
						break;	
					case 1010:
						if (null != btrvo.getDgfixfeestate()) {
							_state = btrvo.getDgfixfeestate().toString();
						}
						newlist.add(_state);
						break;	
				}
			}			
		}
		return newlist;
	}

	/**
	 * @param args test
	 */
	public static void main(String[] args) {

		List list = new ArrayList();
		list.add("3");
		list.add("0");
		list.add("3");
		list.add("3");
		list.add("3");
		System.out.println(chkState(null));
		;
		
	
	}

	//***************************new add by mys 20080905**************************//
	
	/** ����Ƿ񵥸����д���������simple **/
	public static String isSimple(String regroup) {
	
		
    	if(regroup != null && !"*,".equals(regroup)){
    		String[] citys = StringSplit.split(regroup, ",");
    		if(citys.length == 1){
    			return "simple";
    		}
    	}
		return "";
	}
	
	/**����״̬��������**/
	public static  void setState(BlTouchRuleVO btrvo,String stepKey) throws Exception{			
		
		int fix = null != btrvo.getFixstate() ? btrvo.getFixstate().intValue() : 0;
		int usr = null != btrvo.getUsrbillstate() ? btrvo.getUsrbillstate().intValue() : 0;
		int acc = null != btrvo.getAccbillstate() ? btrvo.getAccbillstate().intValue() : 0;
		int cfm = null != btrvo.getCfmbillstate() ? btrvo.getCfmbillstate().intValue() : 0;
		int wof = null != btrvo.getWoffstate() ? btrvo.getWoffstate().intValue() : 0;
		int fcfm = null != btrvo.getFixcfmstate() ? btrvo.getFixcfmstate().intValue() : 0;	
		int pcfm = null != btrvo.getPrmcfmstate() ? btrvo.getPrmcfmstate().intValue() : 0;	
		int nul = null != btrvo.getNullrecstate() ? btrvo.getNullrecstate().intValue() : 0;	
		int red = null != btrvo.getReducestate() ? btrvo.getReducestate().intValue() : 0;	
		int dgfix = null != btrvo.getDgfixfeestate() ? btrvo.getDgfixfeestate().intValue() : 0;	
		
		
		if("NUL".equals(stepKey)){

			if(nul == 1 || nul == 2){
				throw new Exception("���������Ѵ��� [������] ���� [������]!");
			}
			btrvo.setNullrecstime(new Timestamp(System.currentTimeMillis()));
			btrvo.setNullrecstate(new Long(1));
			
		}else if("RED".equals(stepKey)){
			if(nul != 3){
				throw new Exception("��������δ���,���ܽ����Żݴ���!");
			}
			if(red == 1 || red == 2){
				throw new Exception("�Żݴ����Ѵ��� [������] ���� [������]!");
			}
			btrvo.setReducestime(new Timestamp(System.currentTimeMillis()));
			btrvo.setReducestate(new Long(1));
			
		}else if("PRMC".equals(stepKey)){
			if(red != 3){
				throw new Exception("�Żݴ���δ���,���ܽ���Ԥ����ȷ��!");
			}
			btrvo.setPrmcfmtime(new Timestamp(System.currentTimeMillis()));
			btrvo.setPrmcfmstate(new Long(3));
		}else if("FIXC".equals(stepKey)){
			if( fix != 3){
				throw new Exception("ȫ��ͨ�̶���δ���,���ܽ��й̶���ȷ��!");
			}
			btrvo.setFixcfmtime(new Timestamp(System.currentTimeMillis()));
			btrvo.setFixcfmstate(new Long(3));
			
		}else if("USR".equals(stepKey)){
			if(fcfm != 3 || pcfm != 3){
				throw new Exception("Ԥ������߹̶���δȷ����� ,���ܽ����û�����!");
			}
			if(acc == 1 || acc == 2){
				throw new Exception("�ʻ����˴���[������] ���� [������] ,���ܽ����û�����!");
			}
			
			if(usr == 1 || usr == 2){
				throw new Exception("�û������Ѵ��� [������] ���� [������]!");
			}
			btrvo.setUsrbillstime(new Timestamp(System.currentTimeMillis()));
			btrvo.setUsrbillstate(new Long(1));						
			
			
		}else if("ACC".equals(stepKey)){
			if(usr != 3){
				throw new Exception("�û�����δȷ����� ,���ܽ����ʻ�����!");
			}
			if(acc == 1 || acc == 2 ){
				throw new Exception("�ʻ������Ѵ��� [������] ���� [������]!");
			}
			btrvo.setAccbillstime(new Timestamp(System.currentTimeMillis()));
			btrvo.setAccbillstate(new Long(1));
					
			
		}else if("CFM".equals(stepKey)){
			if(acc != 3 || usr != 3){
				throw new Exception("�û����˺��ʻ�����δ���,���ܽ��г���ȷ��!");
			}
			if(cfm == 1 || cfm == 2){
				throw new Exception("����ȷ���Ѵ��� [������] ���� [������]!");
			}
			if(cfm == 3 || cfm == 4){
				throw new Exception("����ȷ��[�����] ���� [����],�����˹���Ԥ,��������������!");
			}
			btrvo.setCfmbillstime(new Timestamp(System.currentTimeMillis()));
			btrvo.setCfmbillstate(new Long(1));
			
		}else if("WOF".equals(stepKey)){
			if(cfm != 3){
				throw new Exception("����ȷ��δ���,���ܽ��������ſ�!");
			}
			if(wof == 1 || wof == 2){
				throw new Exception("�����ſ��Ѵ��� [������] ���� [������]!");
			}
			btrvo.setWofftime(new Timestamp(System.currentTimeMillis()));
			btrvo.setWoffstate(new Long(1));
		}else{
			throw new Exception("�ò��費���ڣ� " + stepKey);
		}
		
	}
	
}
