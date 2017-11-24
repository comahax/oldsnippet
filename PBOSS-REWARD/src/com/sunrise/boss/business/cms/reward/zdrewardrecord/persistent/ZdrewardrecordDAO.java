/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ZdrewardrecordDAO</p>
 * <p>Description: Data Access Object for ZdrewardrecordVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ZdrewardrecordDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ZdrewardrecordDAO(){
        super(ZdrewardrecordVO.class);
    }
    public static void main(String[] args) {
    	Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String month = format.format(calendar.getTime());
		System.out.println(month);
	}
    public DataPackage doQuery(ZdrewardrecordListVO params) throws Exception {
    	String zdreward = params.get_se_zdreward();
    	String calcmonth = params.get_se_calcmonth();
    	//String repairmonth = params.get_se_repairmonth();
    	   	
    	int noncyc = Integer.parseInt(params.get_ne_noncyc());
    	if("zdyzq".equals(params.get_se_zdreward())){
    		//终端类型下拉框增加【终端优质渠道半月预发酬金】对应酬金类型下拉框隐藏，NONCYC默认为1
    		noncyc = 1;
    	}
		params.getQueryConditions().put("noncyc", noncyc);
		params.getQueryConditions().put("calcmonth", calcmonth);
		//params.getQueryConditions().put("repairmonth", repairmonth);
		
		params.set_ne_noncyc(null);
		params.set_se_calcmonth(null);
		params.set_se_zdreward(null);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String month = format.format(calendar.getTime());
		
		String sqlname = "";
		
		if ("allzd".equals(zdreward)) {
			//全终端
			sqlname = "zdrewardrecord.allzdjcreward";
		} else if ("hyzd".equals(zdreward)) {
			//合约终端
			sqlname = "zdrewardrecord.hyzdjcreward";			
		} else if ("lhyzd".equals(zdreward)) {
			//零合约
			sqlname = "zdrewardrecord.lhyzdreward";
		} else if ("ljzd".equals(zdreward)) {
			//裸机
			sqlname = "zdrewardrecord.ljzdreward";
		} else if ("lptzd".equals(zdreward)) {
			//类平台
			sqlname = "zdrewardrecord.lptzdreward";
		} else if ("newzd".equals(zdreward)) {
			//2104新终端
			sqlname = "zdrewardrecord.newzdreward";
		} else if ("zdyzq".equals(zdreward)) {
			//终端优质渠道半月预发酬金
			sqlname = "zdrewardrecord.zdyzqreward";
		} else if ("jdljarpu".equals(zdreward)) {
			//京东商城裸机终端酬金>ARPU分成酬金
			sqlname = "zdrewardrecord.arpureward";
		} else if ("jdljstd".equals(zdreward)) {
			//京东商城裸机终端酬金>基准价分成酬金
			sqlname = "zdrewardrecord.jdljreward";
		}else if ("g3timefisrt".equals(zdreward)) {
			//3GTIMES机首期酬金
			sqlname = "zdrewardrecord.g3timefisrt";
		}else if ("g3timearpu".equals(zdreward)) {
			//3GTIMES机ARPU分成酬金
			sqlname = "zdrewardrecord.g3timearpu";
		}else if ("g4timezh".equals(zdreward)) {
			//4GTIMES机转化酬金
			sqlname = "zdrewardrecord.g4timezh";
		}else if ("g4timeph".equals(zdreward)) {
			//4GTIMES机普惠办理酬金
			sqlname = "zdrewardrecord.g4timeph";
		}else if ("g4notimeph".equals(zdreward)) {
			//4G非TIMES机普惠办理酬金
			sqlname = "zdrewardrecord.g4notimeph";
		}else if ("g4notime3in1".equals(zdreward)) {
			//4G非TIMES机三合一升级酬金
			sqlname = "zdrewardrecord.g4notime3in1";
		}else if ("kuneijizhuanhua".equals(zdreward)) {
			//库内机转化酬金opnid like '04110501%'
			sqlname = "zdrewardrecord.kuneijizhuanhua";
		}else if ("kuneijifencheng".equals(zdreward)) {
			//库内机分成酬金      opnid like '04110502%'
			sqlname = "zdrewardrecord.kuneijifencheng";
		}else if ("zidaijizhuanhua".equals(zdreward)) {
			//自带机转化酬金      opnid like '04111501%'
			sqlname = "zdrewardrecord.zidaijizhuanhua";
		}else if ("zidaijifencheng".equals(zdreward)) {
			//自带机分成酬金      opnid like '04111502%'
			sqlname = "zdrewardrecord.zidaijifencheng";
		}
		if(!"".equals(sqlname) && noncyc == 0){
			sqlname += ".noqs";
		}
		
		if(!"".equals(sqlname)){
			return this.queryByNamedSqlQuery(sqlname, params);
		}else{
			return new DataPackage();
		}
		
		//2014-06-09取消历史数据显示
//		if(Integer.parseInt(calcmonth) >= Integer.parseInt(month)){
//			if ("allzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.allzdjcreward", params);
//			} else if ("hyzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.hyzdjcreward", params);			
//			} else if ("lhyzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.lhyzdreward", params);
//			} else if ("ljzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.ljzdreward", params);
//			} else if ("lptzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.lptzdreward", params);
//			} else if ("newzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.newzdreward", params);
//			} else if ("zdyzq".equals(zdreward)) {
//				//终端优质渠道半月预发酬金
//				return this.queryByNamedSqlQuery("zdrewardrecord.zdyzqreward", params);
//			} else if ("jdlj".equals(zdreward) && noncyc == 1) {
//				//京东商城裸机终端酬金>ARPU分成酬金
//				return this.queryByNamedSqlQuery("zdrewardrecord.arpureward", params);
//			} else if ("jdlj".equals(zdreward) && noncyc == 2) {
//				//京东商城裸机终端酬金>基准价分成酬金
//				return this.queryByNamedSqlQuery("zdrewardrecord.jdljreward", params);
//			}else {
//				return new DataPackage();
//			}
//		}else{
//			if ("hyzd".equals(zdreward) && noncyc == 1) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.hyzdjcrewardhis", params);
//			} else if ("hyzd".equals(zdreward) && noncyc == 2) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.hyzdjlrewardhis", params);
//			} else if ("lhyzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.lhyzdrewardhis", params);
//			} else if ("ljzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.ljzdrewardhis", params);
//			} else if ("lptzd".equals(zdreward)) {
//				return this.queryByNamedSqlQuery("zdrewardrecord.lptzdrewardhis", params);
//			} else {
//				return new DataPackage();
//			}
//		}
    }
}
