package com.gmcc.pboss.business.cms.examine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * �������Զ����ֲ��� �����ַ�ʽ��ϵͳPGM��ʽʹ��
 * 
 * @author wefrogll
 * @version 1.0 2009-12-5
 */
public class ExamineImp implements Examine{

	public List examine(String starttime, String endtime,String cityid) {
		// TODO Auto-generated method stub
		List resultList = new ArrayList();
		Map wayBusiValueMap = new HashMap();
		wayBusiValueMap.put("WAYID", "MCMZIB0387");
		wayBusiValueMap.put("BUSIVALUE","5");
		resultList.add(wayBusiValueMap);
		
		wayBusiValueMap = new HashMap();
		wayBusiValueMap.put("WAYID", "TESTCCC");
		wayBusiValueMap.put("BUSIVALUE","30");
		resultList.add(wayBusiValueMap);
		return resultList;
	}

}
