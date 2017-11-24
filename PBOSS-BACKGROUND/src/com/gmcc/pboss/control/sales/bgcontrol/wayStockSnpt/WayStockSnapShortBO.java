package com.gmcc.pboss.control.sales.bgcontrol.wayStockSnpt;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.comrescarddetail.ComrescarddetailDAO;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDAO;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptVO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.waystockrecord.Waystockrecord;
import com.gmcc.pboss.control.sales.waystockrecord.WaystockrecordBO;
import com.gmcc.pboss.control.sales.waystocksnpt.Waystocksnpt;
import com.gmcc.pboss.control.sales.waystocksnpt.WaystocksnptBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class WayStockSnapShortBO extends AbstractControlBean implements
		WayStockSnapShort {
	
	private Logger log = Logger.getLogger(WayStockSnapShortBO.class);

	public void doProcess(String starttime,String endtime) throws Exception {
		//重跑的时候先把当天的数据清理,防止数据重复
		doDelWaystockrecordProcess(starttime, endtime);
		// 套卡 网点库存快照
		doStatOrderAndSaveSnap("STOCK");
		doStatOrderAndSaveSnap("RECORD");
		
		//SIM空白卡
		doStatOrderAndSaveSnap("SIMSTOCK");
		doStatOrderAndSaveSnap("SIMRECORD");
		
		// 清理超过半个月网点库存快照的数据
		doDelComrescardProcess();
	}

	/**
	 * 根据资源类型统计垫资订单并保存网点库存快照
	 * @param restype
	 * @throws Exception
	 */
	private void doStatOrderAndSaveSnap(String restype) throws Exception {
		
		Waystocksnpt wssBO = (Waystocksnpt) BOFactory.build(
				WaystocksnptBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
		Waystockrecord wsrBO = (Waystockrecord) BOFactory.build(
				WaystockrecordBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
		Partnerres prsBO = (Partnerres)BOFactory.build(PartnerresBO.class, user);
		DataPackage dp = prsBO.doStatWayOrderForSnapShot(restype);
		List list = dp.getDatas();
		for(int i=0;i<list.size();i++) {
			try {
				Map data = (Map)list.get(i);
				if("STOCK".equalsIgnoreCase(restype)){
					WaystocksnptVO wssVO = this.setWssVO(data, "COMRESSMP");
					wssBO.doCreate(wssVO);
				}else if("RECORD".equals(restype)){
					WaystockrecordVO wsrVO = this.setWsrVO(data, "COMRESSMP");
					wsrBO.doCreate(wsrVO);
				}else if("SIMSTOCK".equals(restype)){
					WaystocksnptVO wssVO = this.setWssVO(data, "EMPTYSIM");
					wssBO.doCreate(wssVO);
				}else if("SIMRECORD".equals(restype)){
					WaystockrecordVO wsrVO = this.setWsrVO(data, "EMPTYSIM");
					wsrBO.doCreate(wsrVO);
				}
				
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
	}
	
	
	/**
	 * 清理超过一个月网点库存快照的数据
	 * @param restype
	 * @throws Exception
	 */
	public void doDelComrescardProcess() throws Exception {
		WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class, user);
		try {
		dao.doDelComrescarddetail();
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	/**
	 * 重跑的时候先把当天的数据清理
	 * @param startstocktime
	 * @param endstocktime
	 */
	public void doDelWaystockrecordProcess(String starttime, String endtime) throws Exception {
		WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class, user);
		try {
		dao.doDelWaystockrecord(starttime, endtime);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
	}
	
	
	private WaystocksnptVO setWssVO(Map data,String restype) throws Exception {
		WaystocksnptVO wssVO = new WaystocksnptVO();
		wssVO.setCountyid((String)data.get("countyid"));
		wssVO.setSvccode((String)data.get("svccode"));
		wssVO.setMareacode((String)data.get("mareacode"));
		wssVO.setOrderid(data.get("orderid") != null ? (String)data.get("orderid") : null);
		wssVO.setWayid((String)data.get("wayid"));
		wssVO.setWayname((String)data.get("wayname"));
		wssVO.setStarlevel(Short.valueOf((String)data.get("starlevel")));
		// 充值卡的brand字段为空
		wssVO.setBrand(data.get("brand") != null ? (String)data.get("brand") : null);
		wssVO.setComcategory((String)data.get("comcategory"));
		wssVO.setStocknum(Long.parseLong((String)data.get("cnt1")));
		wssVO.setStocktime(getStockTime());
		wssVO.setRestype(restype);
		return wssVO;
	}
	
	private WaystockrecordVO setWsrVO(Map data,String restype) throws Exception {
		WaystockrecordVO wsrVO = new WaystockrecordVO();
		wsrVO.setCountyid((String)data.get("countyid"));
		wsrVO.setSvccode((String)data.get("svccode"));
		wsrVO.setMareacode((String)data.get("mareacode"));
		wsrVO.setOrderid(data.get("orderid") != null ? (String)data.get("orderid") : null);
		wsrVO.setComresid((String)data.get("comresid"));
		wsrVO.setWayid((String)data.get("wayid"));
		wsrVO.setWayname((String)data.get("wayname"));
		wsrVO.setStarlevel(Short.valueOf((String)data.get("starlevel")));
		// 充值卡的brand字段为空
		wsrVO.setBrand(data.get("brand") != null ? (String)data.get("brand") : null);
		wsrVO.setComcategory((String)data.get("comcategory"));
		wsrVO.setStocktime(getStockTime());
		wsrVO.setEmptyno((String)data.get("emptyno"));
//		wsrVO.setRestype("COMRESSMP");
		return wsrVO;
	}
	
	private Date getStockTime() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH, -1);
		stocktime.set(Calendar.HOUR_OF_DAY, 23);
		stocktime.set(Calendar.MINUTE, 59);
		stocktime.set(Calendar.SECOND, 59);
		return stocktime.getTime();
	}
}
