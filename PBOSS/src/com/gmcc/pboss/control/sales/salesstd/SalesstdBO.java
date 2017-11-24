/**
 * auto-generated code
 * Tue Oct 25 16:42:25 CST 2011
 */
package com.gmcc.pboss.control.sales.salesstd;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.gmcc.pboss.business.sales.partnerres.PartnerresDAO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDAO;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.business.sales.salesstd.SalesstdVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: SalesstdBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class SalesstdBO extends AbstractControlBean implements Salesstd {

	public SalesstdVO doCreate(SalesstdVO vo) throws Exception {
		try {
			SalesstdDAO dao = (SalesstdDAO) DAOFactory.build(SalesstdDAO.class,
					user);
			// TODO set the pk */
			return (SalesstdVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SalesstdVO vo) throws Exception {
		try {
			SalesstdDAO dao = (SalesstdDAO) DAOFactory.build(SalesstdDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SalesstdDAO dao = (SalesstdDAO) DAOFactory.build(SalesstdDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SalesstdVO doUpdate(SalesstdVO vo) throws Exception {
		try {
			SalesstdDAO dao = (SalesstdDAO) DAOFactory.build(SalesstdDAO.class,
					user);
			return (SalesstdVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SalesstdVO doFindByPk(Serializable pk) throws Exception {
		SalesstdDAO dao = (SalesstdDAO) DAOFactory.build(SalesstdDAO.class,
				user);
		return (SalesstdVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SalesstdDBParam params) throws Exception {
		SalesstdDAO dao = (SalesstdDAO) DAOFactory.build(SalesstdDAO.class,
				user);
		return dao.query(params);
	}

	public DataPackage doListQuery(SalesstdDBParam params) throws Exception {
		// 保存处理完后的完整数据
		List rulist = new ArrayList();

		// 关联合作商销量阀值表（FX_RU_SALESSTD）、渠道表（CH_PW_WAY）和商品订购辅助信息表（FX_RU_WAYASSISTANT）确定网点、品牌及阀值基础数据，
		WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(WayassistantDAO.class,
				user);
		
		params.setSelectFieldsString("cityid,countyid,mareacode,starlevel,wayid,wayname,salesstd");
		DataPackage dp = dao.queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.salesstdquery.doListQuery",
				params);
		List<Object> list = dp.getDatas();
		HashMap map = null;
		HashMap map2 = null;

		// 然后对结果数据逐条处理以获取当月销量，根据合作商编码、套卡品牌、激活时间等条件查询合作商资源表（FX_SW_PARTNERRES），如果无数据默认取零。
		PartnerresDAO partdao = (PartnerresDAO) DAOFactory.build(
				PartnerresDAO.class, user);
		PartnerresDBParam partparams = new PartnerresDBParam();
		partparams.setSelectFieldsString("wayid,Qty");
		partparams.getQueryConditions().put("begintime", this.getCurMath());
		partparams.getQueryConditions().put("endtime", this.getCurDate());
		partparams.setDataOnly(true);
		partparams.set_pagesize("0");
		DataPackage dpp = null;
		// partparams.set_se_cityid(null);
		for (int i = 0; i < list.size(); i++) {
			SalesstdVO salesstdvo = new SalesstdVO();
			map = (HashMap) list.get(i);
			if (map.get("wayid") != null)
				salesstdvo.setWayid((String) map.get("wayid"));
//			if (map.get("brand") != null)去掉品牌
//				salesstdvo.setBrand((String) map.get("brand"));
			if (map.get("mareacode") != null)
				salesstdvo.setMareacode((String) map.get("mareacode"));
			if (map.get("starlevel") != null)
				salesstdvo.setStarlevel(Short.parseShort(map.get("starlevel").toString()));
			if (map.get("wayname") != null)
				salesstdvo.setWayname((String) map.get("wayname"));
			if (map.get("countyid") != null)
				salesstdvo.setCountyid((String) map.get("countyid"));
			if (map.get("cityid") != null)
				salesstdvo.setCityid((String) map.get("cityid"));
			if (map.get("salesstd") != null)
				salesstdvo.setSalesstd(Long.parseLong(map.get("salesstd").toString()));

			partparams.set_se_wayid(salesstdvo.getWayid());
//			partparams.set_se_brand(salesstdvo.getBrand());去掉品牌查询条件
			dpp = partdao
					.queryByNamedSqlQuery(
							"com.gmcc.pboss.business.sales.partnerres.doStatWayActiveAmount_11",
							partparams);

			if (dpp == null || dpp.getDatas() == null
					|| dpp.getDatas().size() == 0) {
				salesstdvo.setSalescount(0L);
			} else {
				map2 = (HashMap) dpp.getDatas().get(0);
				if (map2.get("Qty") != null)
					salesstdvo.setSalescount(Long.parseLong(map2.get("Qty")+""));
				else
					salesstdvo.setSalescount(0L);
			}
			rulist.add(salesstdvo);
		}
		dp.setDatas(rulist);

		return dp;
	}

	// 获取当前月的第一天的0时0分0秒
	public Date getCurMath() {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Date da = new Date(date.getYear(), date.getMonth(), 01);
		java.sql.Timestamp startTime = java.sql.Timestamp.valueOf(df1
				.format(da));
		return startTime;
	}

	// 获取当前时间
	public Date getCurDate() {

		Date now = new Date();
		DateFormat d2 = DateFormat.getDateTimeInstance();
		String str2 = d2.format(now);
		Date date = null;
		try {
			date = d2.parse(str2);
		} catch (ParseException e) {

		}
		return date;
	}

	public DataPackage doExportExcel(SalesstdDBParam params) throws Exception {
		// 保存处理完后的完整数据
		List rulist = new ArrayList();

		// 关联合作商销量阀值表（FX_RU_SALESSTD）、渠道表（CH_PW_WAY）和商品订购辅助信息表（FX_RU_WAYASSISTANT）确定网点、品牌及阀值基础数据，
		WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(WayassistantDAO.class,
				user);
		
		params.setSelectFieldsString("cityid,countyid,mareacode,starlevel,wayid,wayname,salesstd");
		DataPackage dp = dao.queryByNamedSqlQuery(
				"com.gmcc.pboss.business.sales.salesstdquery.doListQuery",
				params);
		List<Object> list = dp.getDatas();
		HashMap map = null;
		HashMap map2 = null;

		// 然后对结果数据逐条处理以获取当月销量，根据合作商编码、套卡品牌、激活时间等条件查询合作商资源表（FX_SW_PARTNERRES），如果无数据默认取零。
		PartnerresDAO partdao = (PartnerresDAO) DAOFactory.build(
				PartnerresDAO.class, user);
		PartnerresDBParam partparams = new PartnerresDBParam();
		partparams.setSelectFieldsString("wayid,Qty");
		partparams.getQueryConditions().put("begintime", this.getCurMath());
		partparams.getQueryConditions().put("endtime", this.getCurDate());
		partparams.setDataOnly(true);
		partparams.set_pagesize("0");
		DataPackage dpp = null;
		String wayid = null;
		String brand = null;
		
		dpp = partdao
				.queryByNamedSqlQuery(
						"com.gmcc.pboss.business.sales.partnerres.doStatWayActiveAmount_11",
						partparams);
		List list2 = dpp.getDatas();

		// partparams.set_se_cityid(null);
		for (int i = 0; i < list.size(); i++) {
			SalesstdVO salesstdvo = new SalesstdVO();
			map = (HashMap) list.get(i);
			if (map.get("wayid") != null)
				wayid = (String) map.get("wayid");
			salesstdvo.setWayid(wayid);
//			if (map.get("brand") != null)去掉品牌
//				brand = (String) map.get("brand");
//				salesstdvo.setBrand(brand);
			if (map.get("mareacode") != null)
				salesstdvo.setMareacode((String) map.get("mareacode"));
			if (map.get("starlevel") != null)
				salesstdvo.setStarlevel(Short.parseShort(map.get("starlevel").toString()));
			if (map.get("wayname") != null)
				salesstdvo.setWayname((String) map.get("wayname"));
			if (map.get("countyid") != null)
				salesstdvo.setCountyid((String) map.get("countyid"));
			if (map.get("cityid") != null)
				salesstdvo.setCityid((String) map.get("cityid"));
			if (map.get("salesstd") != null)
				salesstdvo.setSalesstd(Long.parseLong(map.get("salesstd").toString()));

			boolean bo = true;
			
			for (int j = 0; j < list2.size(); j++) {
				map2 = (HashMap) list2.get(j);
				Object obj = map2.get("wayid");
//				Object obj1 = map2.get("brand");去掉品牌
				
				if (obj != null) {
					String rewayid = (String) obj;
//					String rebrand = (String) obj1;
					
					if (wayid != null && !wayid.equals("")
							&& !rewayid.equals("") && wayid.equals(rewayid)) {
						salesstdvo.setSalescount(Long.parseLong(map2.get("Qty")+""));
						bo=false;
					}
				} 
			}
			if(bo){				
					salesstdvo.setSalescount(0L);				
			}			
			
			rulist.add(salesstdvo);
		}
		dp.setDatas(rulist);

		return dp;
	}

}
