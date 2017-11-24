/**
 * auto-generated code
 * Thu Jan 26 11:26:19 CST 2012
 */
package com.gmcc.pboss.control.sales.sellnotice;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.sales.sellnotice.SellnoticeDAO;
import com.gmcc.pboss.business.sales.sellnotice.SellnoticeDBParam;
import com.gmcc.pboss.business.sales.sellnotice.SellnoticeVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SellnoticeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SellnoticeBO extends AbstractControlBean implements
		Sellnotice {
	DecimalFormat df = new DecimalFormat("0.00");

	public SellnoticeVO doCreate(SellnoticeVO vo) throws Exception {
		try {
			SellnoticeDAO dao = (SellnoticeDAO) DAOFactory.build(SellnoticeDAO.class, user);
			// TODO set the pk */
			return (SellnoticeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SellnoticeVO vo) throws Exception {
		try {
			SellnoticeDAO dao = (SellnoticeDAO) DAOFactory.build(SellnoticeDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SellnoticeDAO dao = (SellnoticeDAO) DAOFactory.build(SellnoticeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SellnoticeVO doUpdate(SellnoticeVO vo) throws Exception {
		try {
			SellnoticeDAO dao = (SellnoticeDAO) DAOFactory.build(SellnoticeDAO.class,user);
			return (SellnoticeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SellnoticeVO doFindByPk(Serializable pk) throws Exception {
		SellnoticeDAO dao = (SellnoticeDAO) DAOFactory.build(SellnoticeDAO.class,user);
		return (SellnoticeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SellnoticeDBParam params)
			throws Exception {
		SellnoticeDAO dao = (SellnoticeDAO) DAOFactory.build(SellnoticeDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryByNamedSqlQuery(String name, DBQueryParam param)
			throws Exception {
		SellnoticeDAO dao = (SellnoticeDAO) DAOFactory.build(SellnoticeDAO.class,user);
		return dao.queryByNamedSqlQuery(name,param);
	}

	public DataPackage doCountyList(DataPackage tmp) throws Exception {
		Iterator itSell=tmp.getDatas().iterator();
		Map<String, SellnoticeVO> eMap = new HashMap<String, SellnoticeVO>();
		while(itSell.hasNext()){
			SellnoticeVO sellnoticeVO = (SellnoticeVO)itSell.next();
			String countyid = sellnoticeVO.getCountyid();
			if(eMap.containsKey(countyid)){//存在
				SellnoticeVO eVO = eMap.get(countyid);
				Long eSellcount = eVO.getSellcount();
				Long eSalesstd = eVO.getSalesstd();
				
				Long nSellcount = sellnoticeVO.getSellcount();
				Long nSalesstd = sellnoticeVO.getSalesstd();
				
				Long aSellcount = eSellcount + nSellcount;
				Long aSalesstd = eSalesstd + nSalesstd;
				
				Double comrate = 0D;
				if(aSalesstd != 0)
					comrate = (1.0*aSellcount/aSalesstd)*100;
				
				eVO.setSellcount(aSellcount);
				eVO.setSalesstd(aSalesstd);
				eVO.setComrate(Double.parseDouble(df.format(comrate)));
			}else{//不存在
				Double comrate = 0D;
				Long sellcount = sellnoticeVO.getSellcount();
				Long salesstd = sellnoticeVO.getSalesstd();
				if(salesstd != 0)
					comrate = (1.0*sellcount/salesstd)*100;
				sellnoticeVO.setComrate(Double.parseDouble(df.format(comrate)));
				
				eMap.put(countyid, sellnoticeVO);
			}
		}
		
		Iterator eMapIt = eMap.entrySet().iterator();
		List list = new ArrayList();
		while (eMapIt.hasNext()) {
		    Map.Entry entry = (Map.Entry) eMapIt.next();
		    SellnoticeVO val = (SellnoticeVO)entry.getValue();
		    
		    list.add(val);
		}
		tmp.setDatas(list);
		return tmp;
	}

	public DataPackage doMareacodeList(DataPackage tmp) throws Exception {
		Iterator itSell=tmp.getDatas().iterator();
		Map<String, SellnoticeVO> eMap = new HashMap<String, SellnoticeVO>();
		while(itSell.hasNext()){
			SellnoticeVO sellnoticeVO = (SellnoticeVO)itSell.next();
			String mareacode = sellnoticeVO.getMareacode();
			if(eMap.containsKey(mareacode)){//存在
				SellnoticeVO eVO = eMap.get(mareacode);
				Long eSellcount = eVO.getSellcount();
				Long eSalesstd = eVO.getSalesstd();
				
				Long nSellcount = sellnoticeVO.getSellcount();
				Long nSalesstd = sellnoticeVO.getSalesstd();
				
				Long aSellcount = eSellcount + nSellcount;
				Long aSalesstd = eSalesstd + nSalesstd;
				
				Double comrate = 0D;
				if(aSalesstd != 0)
					comrate = (1.0*aSellcount/aSalesstd)*100;
				
				eVO.setSellcount(aSellcount);
				eVO.setSalesstd(aSalesstd);
				eVO.setComrate(Double.parseDouble(df.format(comrate)));
			}else{//不存在
				Double comrate = 0D;
				Long sellcount = sellnoticeVO.getSellcount();
				Long salesstd = sellnoticeVO.getSalesstd();
				if(salesstd != 0)
					comrate = (1.0*sellcount/salesstd)*100;
				
				sellnoticeVO.setComrate(Double.parseDouble(df.format(comrate)));
				
				eMap.put(mareacode, sellnoticeVO);
			}
		}
		
		Iterator eMapIt = eMap.entrySet().iterator();
		List list = new ArrayList();
		while (eMapIt.hasNext()) {
		    Map.Entry entry = (Map.Entry) eMapIt.next();
		    SellnoticeVO val = (SellnoticeVO)entry.getValue();
		    
		    list.add(val);
		}
		tmp.setDatas(list);
		return tmp;
	}

	public DataPackage doWayList(DataPackage tmp) throws Exception {
		Iterator itSell=tmp.getDatas().iterator();
		while(itSell.hasNext()){
			SellnoticeVO sellnoticeVO = (SellnoticeVO)itSell.next();
			Double comrate = sellnoticeVO.getComrate();
			comrate = comrate*100;
			sellnoticeVO.setComrate(Double.parseDouble(df.format(comrate)));
		}
		return tmp;
	}

	public DataPackage doWayMagList(DataPackage tmp) throws Exception {
		Iterator itSell=tmp.getDatas().iterator();			
		
		//渠道经理去重(key为去重后的数据)
		Map<String, List<SellnoticeVO>> eMap = new HashMap<String, List<SellnoticeVO>>();
		while(itSell.hasNext()){
			SellnoticeVO sellnoticeVO = (SellnoticeVO)itSell.next();
			String waymagcode = sellnoticeVO.getWaymagcode();
			String wayidTmp = sellnoticeVO.getWayid();
			if(eMap.containsKey(waymagcode)){//存在
				eMap.get(waymagcode).add(sellnoticeVO);
			}else{//不存在
				List<SellnoticeVO> list = new ArrayList<SellnoticeVO>();
				list.add(sellnoticeVO);
				eMap.put(waymagcode, list);
			}
			
		}
		
		Iterator eMapIt = eMap.entrySet().iterator();
		List datas = new ArrayList();
		while (eMapIt.hasNext()) {
		    Map.Entry entry = (Map.Entry) eMapIt.next();
		    String waymagcode = (String)entry.getKey();
		    List valueList = (List)entry.getValue();
		    String countyid = "";
		    if(valueList != null && valueList.size() > 0){
		    	countyid = ((SellnoticeVO)valueList.get(0)).getCountyid();
		    }
		    
		    Long sellcount = 0L;
			Long salesstd = 0L;				
			Double comrate = 0D;
			
			//对该渠道经理下的所有记录进行统计
			Iterator valueListIt = valueList.iterator();
			while(valueListIt.hasNext()){
				SellnoticeVO voTmp = (SellnoticeVO)valueListIt.next();
				Long s1 = voTmp.getSellcount();
				Long s2 = voTmp.getSalesstd();
				//累计子渠道销售量、销售阀值
				sellcount = sellcount + s1;
				salesstd = salesstd + s2;
			}	
			
			//设定页面数据
			if(salesstd.longValue() != 0 )
				comrate = 1.0 * sellcount/salesstd*100;
		    SellnoticeVO tmpVO = new SellnoticeVO();
		    tmpVO.setCountyid(countyid);
		    tmpVO.setWaymagcode(waymagcode);
		    tmpVO.setSellcount(sellcount);
		    tmpVO.setSalesstd(salesstd);
		    tmpVO.setComrate(Double.parseDouble(df.format(comrate)));
		    datas.add(tmpVO);
		}
		
		tmp.setDatas(datas);
		return tmp;
	}
}
