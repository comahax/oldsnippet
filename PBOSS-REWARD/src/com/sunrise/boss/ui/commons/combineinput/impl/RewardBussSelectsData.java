package com.sunrise.boss.ui.commons.combineinput.impl;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.common.combineinput.CombineinputDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.combineinput.SelectsData;

/**
 * <p>Title: BilltypeSelectsData </p>
 * <p>Description: �ʵ����ͺ��ʵ���Ŀ��ȡʵ���� </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class RewardBussSelectsData implements SelectsData {
	/**
	 * ��ȡ�ʵ����ͼ���
	 */
	public List getType2Collection(CombineinputListVO listVO, User user) {
		try {
			List retlist = new ArrayList();
			CombineinputDelegate delegate = new CombineinputDelegate();
			List nindictid = new ArrayList();
			List idid = new ArrayList();
			String extend1=listVO.get_se_extend1();
			listVO.set_se_extend1(null);
			if(extend1==null || extend1.equals("")){
				return retlist;
			}else{
//				if(extend1.indexOf("0")!=-1 
//						|| extend1.indexOf("1")!=-1 
//						|| extend1.indexOf("2")!=-1 ){
//					nindictid.add("CARD");
//				}
//				if(extend1.indexOf("3")!=-1  
//						|| extend1.indexOf("4")!=-1 ){
//					nindictid.add("DATA");
//				}
//				if(extend1.indexOf("5")!=-1  
//						|| extend1.indexOf("6")!=-1 ){
//					nindictid.add("SERV");
//				}				
				switch (Integer.parseInt(extend1)) {
				case 0:
				case 1:
				case 2:
					nindictid.add("CARD");
					break;
				case 9:
				case 10:
					nindictid.add("DATA");
					break;
				case 5:
				case 6:
					nindictid.add("SERV");
					break;
				case 54:
					idid.add("0701010100003");
					idid.add("0701010100006");
					break;
				case 55:
					idid.add("0701010100002");
					idid.add("0701010100012");
					break;
				default:
					break;
				}
				if(nindictid.isEmpty() && idid.isEmpty()){
					return retlist;
				}
			}
			listVO.set_sin_extend1(nindictid);
			listVO.set_sin_id(idid);
			DataPackage dp = delegate.queryOperationOption(listVO, user);
			if (null == dp || null == dp.getDatas()) {
				return retlist;
			}
			
			retlist.addAll(dp.getDatas());
			return retlist;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList(0);
		}
	}
	
	/**
	 * ��ȡ�ʵ���Ŀ����
	 */
	public List getType1Collection(CombineinputListVO listVO, User user) {
		
		return new ArrayList(); 
	}
	
	/**
	 * ��δ�õ�������
	 */
	public List getType3Collection(CombineinputListVO listVO, User user) {
		return new ArrayList(0);
	}
}
