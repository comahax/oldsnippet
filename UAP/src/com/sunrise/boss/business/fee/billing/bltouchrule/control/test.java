package com.sunrise.boss.business.fee.billing.bltouchrule.control;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		String strRegArg = "(?s)(%s)(?=.*\\1)";
		
		//List lstRuleName = Arrays.asList(new String[]{"MAXMOB", "MAXNO", "MINTT", "PCT", "TMS"});
		List lstRuleName = Arrays.asList(new String[]{"(?s)(MAXMOB)(?=.*\1)", "(?s)(MAXNO)(?=.*\1)", "(?s)(MINTT)(?=.*\1)", "(?s)(PCT)(?=.*\1)", "(?s)(TMS)(?=.*\1)"});
		Iterator itrRuleName = lstRuleName.iterator();
		while (itrRuleName.hasNext()) {
//			String strRealReg = String.format(strRegArg, new String[]{(String) itrRuleName.next()});
			String strRealReg = (String) itrRuleName.next();
			System.out.println("" + strRealReg);
		}
	}

}
