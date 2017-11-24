package com.sunrise.boss.business.cms.reward.faildataquery.persistent;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;


/**
 * <p>
 * Title: FaildataqueryDAO
 * </p>
 * <p>
 * Description: Data Access Object for FaildataqueryVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author	Linli
 * @version 1.0
 */
public class FaildataqueryDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public FaildataqueryDAO() {
		super(FaildataqueryVO.class);
	}
	public DataPackage doQuery(FaildataqueryListVO params)
			throws Exception {
		int rewardtype=Integer.parseInt(params.get_se_rewardtype());
		params.set_se_rewardtype(null);
		
		// 增加查询_se_calcmonth的限制 add  by liuchao 
		Date date=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Integer i33=new Integer(format.format(date).substring(4, 6))-1;
		String month33="";
		if(i33<Integer.parseInt("10"))
			month33=format.format(date).substring(0, 4)+"0"+i33.toString();
		else
			month33=format.format(date).substring(0, 4)+i33.toString();
		
		if(Integer.parseInt(params.get_se_calcmonth())<=Integer.parseInt(month33)){
			switch(rewardtype){
			case 1:
				return this.doQuerySimfail(params);
			case 2:
				return this.doQueryJmjtfail(params);
			case 5:
				return this.doQueryBossfail(params);
			case 6:
				return this.doQueryBossjlfail(params);
			case 7:
				return this.doQuerySalefail(params);
			case 11:
				return this.doQueryfaildata11(params);
			case 22:
				return this.doQueryfaildata22(params);
			case 33:
				return this.doQueryfaildata33(params);
			case 44:
				return this.doQueryfaildata44(params);
			case 55:
				return this.doQueryfaildata55(params);
			case 66:
				return this.doQueryfaildata66(params);
			case 90:
				return this.doQueryfaildata90(params);
			case 91:
				return this.doQueryfaildata91(params);
			case 92:
				return this.doQueryfaildata92(params);
			case 93:
				return this.doQueryfaildata93(params);
			case 99:
				return this.doQueryAllfail(params);
			case 111:
				return this.doQueryAllfail111(params);
			case 112:
				return this.doQueryAllfail112(params);
			case 113:
				return this.doQueryAllfail113(params);
			default: 
				return null;
			}
		}else{
			switch(rewardtype){
			case 1:
				return this.doQuerySimfailhis(params);
			case 2:
				return this.doQueryJmjtfailhis(params);
			case 5:
				return this.doQueryBossfailhis(params);
			case 6:
				return this.doQueryBossjlfailhis(params);
			case 7:
				return this.doQuerySalefailhis(params);
			case 11:
				return this.doQueryfaildatahis11(params);
			case 22:
				return this.doQueryfaildatahis22(params);
			case 33:
				return this.doQueryfaildatahis33(params);
			case 44:
				return this.doQueryfaildatahis44(params);
			case 55:
				return this.doQueryfaildatahis55(params);
			case 66:
				return this.doQueryfaildatahis66(params);
			case 90:
				return this.doQueryfaildatahis90(params);
			case 91:
				return this.doQueryfaildatahis91(params);
			case 92:
				return this.doQueryfaildatahis92(params);
			case 93:
				return this.doQueryfaildatahis93(params);
			case 99:
				return this.doQueryAllfail(params);
			case 111:
				return this.doQueryfaildatahis111(params);
			case 112:
				return this.doQueryfaildatahis112(params);
			case 113:
				return this.doQueryfaildatahis113(params);
			default: 
				return null;
			}
		}
		
	}
	private DataPackage doQuerySimfail(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.simfail",params);
	}
	private DataPackage doQueryJmjtfail(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.jmjtfail",params);
	}
	private DataPackage doQueryBossfail(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.bossfail",params);
	}
	private DataPackage doQueryBossjlfail(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.bossjlfail",params);
	}
	private DataPackage doQuerySalefail(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.salefail",params);
	}
	private DataPackage doQueryAllfail(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.allfail",params);
	}
	
	////
	private DataPackage doQueryfaildata11(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata11",params);
	}
	private DataPackage doQueryfaildata22(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata22",params);
	}
	private DataPackage doQueryfaildata33(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata33",params);
	}
	private DataPackage doQueryfaildata44(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata44",params);
	}
	private DataPackage doQueryfaildata55(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata55",params);
	}
	private DataPackage doQueryfaildata66(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata66",params);
	}
	private DataPackage doQueryAllfail111(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata111",params);
	}
	private DataPackage doQueryAllfail112(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata112",params);
	}
	private DataPackage doQueryAllfail113(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata113",params);
	}
	
	//历史数据查询调用的方法
	private DataPackage doQuerySimfailhis(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.simfailhis",params);
	}
	private DataPackage doQueryJmjtfailhis(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.jmjtfailhis",params);
	}
	private DataPackage doQueryBossfailhis(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.bossfailhis",params);
	}
	private DataPackage doQueryBossjlfailhis(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.bossjlfailhis",params);
	}
	private DataPackage doQuerySalefailhis(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.salefailhis",params);
	}
	
	/////
	private DataPackage doQueryfaildatahis11(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis11",params);
	}
	private DataPackage doQueryfaildatahis22(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis22",params);
	}
	private DataPackage doQueryfaildatahis33(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis33",params);
	}
	private DataPackage doQueryfaildatahis44(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis44",params);
	}
	private DataPackage doQueryfaildatahis55(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis55",params);
	}
	private DataPackage doQueryfaildatahis66(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis66",params);
	}
	
	private DataPackage doQueryfaildata90(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata90",params);
	}
	private DataPackage doQueryfaildata91(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata91",params);
	}
	private DataPackage doQueryfaildata92(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata92",params);
	}
	private DataPackage doQueryfaildata93(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildata93",params);
	}
	private DataPackage doQueryfaildatahis90(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis90",params);
	}
	private DataPackage doQueryfaildatahis91(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis91",params);
	}
	private DataPackage doQueryfaildatahis92(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis92",params);
	}
	private DataPackage doQueryfaildatahis93(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis93",params);
	} 
	private DataPackage doQueryfaildatahis111(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis111",params);
	}
	private DataPackage doQueryfaildatahis112(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis112",params);
	}
	private DataPackage doQueryfaildatahis113(FaildataqueryListVO params) throws Exception {
		return this.queryByNamedSqlQuery("faildataquery.faildatahis113",params);
	}
	
	
//	private DataPackage doQueryAllfailhis(FaildataqueryListVO params) throws Exception {
//		return this.queryByNamedSqlQuery("faildataquery.allfailhis",params);
//	}
	
	/**
	 * 	这里的类命名queryallfaildata结束不能够用fail结尾,否则程序将陷入死循环
	 *  以后要加入表的话在faildataquery.hbm.xml里面加入相应sql-query,类命名
	 *  采用doQuery***fail这种格式,类型为private
	 *  例如：private DataPackage doQuery***fail(FaildataqueryListVO params){}
	 * @param params
	 * @return DataPackage
	 * @throws Exception
	 * 
	 */
	private DataPackage doQueryAllfaildata(FaildataqueryListVO params) throws Exception {
		Method[] methods=FaildataqueryDAO.class.getDeclaredMethods();
		DataPackage allDp=new DataPackage();
		
		
		allDp.setPageSize(Integer.parseInt(params.get_pagesize()));
		allDp.setPageNo(Integer.parseInt(params.get_pageno()));
		List l=new ArrayList();
		int rowCount=0;
		
		int modNum = 0; //每个块的叠加后mod的总数
		int modLastNum = 0; //
		int pageNum = 0;
		int realMod = 0;
		
		for(int i=0;i<methods.length;i++){
			
			if(methods[i].getName().trim().startsWith("doQuery")&&methods[i].getName().trim().endsWith("fail")){
				//System.out.println(methods[i].getName());
				DataPackage dp=(DataPackage) methods[i].invoke(this, new Object[]{params});
				//修改分页bug
				if(l.size() < Integer.parseInt(params.get_pagesize())){
					l.addAll(dp.getDatas());
				}
				
				modNum = (modNum + modLastNum ) % Integer.parseInt(params.get_pagesize());
				modLastNum = dp.getRowCount() % Integer.parseInt(params.get_pagesize());
				realMod = (modNum + modLastNum) % Integer.parseInt(params.get_pagesize());
				
				pageNum = (dp.getRowCount()+ modNum ) / Integer.parseInt(params.get_pagesize());
				if(pageNum < Integer.parseInt(params.get_pageno())){
					params.set_pageno(String.valueOf(Integer.parseInt(params.get_pageno())-pageNum));
				}else{
					params.set_pageno("1");
				}
				
				rowCount+=dp.getRowCount();
				
			}else{
				continue;
			}
		}
		allDp.setDatas(l);
		allDp.setRowCount(rowCount);
		return allDp;
	}
}
