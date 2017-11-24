/**
 * auto-generated code
 * Wed Apr 29 14:17:22 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent;

import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryDAO;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: BbcFaildataqueryDAO</p>
 * <p>Description: Data Access Object for BbcFaildataqueryVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcFaildataqueryDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public BbcFaildataqueryDAO() {
		super(BbcFaildataqueryVO.class);
	}

	/**
	 * 按酬金类型查询
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuery(BbcFaildataqueryListVO params) throws Exception {
		int rewardtype = Integer.parseInt(params.get_se_rewardtype());
		String ossrc = params.get_se_ossrc();
		params.set_se_rewardtype(null);
		if ("0".equals(ossrc)) {
			switch (rewardtype) {
			case 9:
				return this.doQuerySellfail(params);
			case 10:
				return this.doQuerySelegflfail(params);
			case 11:
				return this.doQueryWebfail(params);
			case 12:
				return this.doQueryWebegflfail(params);
			case 13:
				return this.doQueryE100fail(params);
			case 14:
				return this.doQueryE100egflfail(params);
			case 88:
				return this.doQueryAdtfail(params);
			case 99:
				return this.doQueryAllfail(params);
			default:
				return null;
			}
		}else if("".equals(ossrc)){
			switch (rewardtype) {
			case 9:
//				return this.doQuerySellfailall(params);
				return this.doQuerySellfail(params);
			case 10:
				return this.doQuerySelegflfailall(params);
			case 11:
				return this.doQueryWebfailall(params);
			case 12:
				return this.doQueryWebegflfailall(params);
			case 13:
				return this.doQueryE100failall(params);
			case 14:
				return this.doQueryE100egflfailall(params);
			case 88:
				return this.doQueryAdtfailall(params);
			case 99:
				return this.doQueryAllfailall(params);
			default:
				return null;
			}
		}else{
			switch (rewardtype) {
			case 9:
//				return this.doQuerySellfailnas(params);
				return this.doQuerySellfail(params);
			case 10:
				return this.doQuerySelegflfailnas(params);
			case 11:
				return this.doQueryWebfailnas(params);
			case 12:
				return this.doQueryWebegflfailnas(params);
			case 13:
				return this.doQueryE100failnas(params);
			case 14:
				return this.doQueryE100egflfailnas(params);
			case 88:
				return this.doQueryAdtfailnas(params);
			case 99:
				return this.doQueryAllfailnas(params);
			default:
				return null;
			}
		}
	}

	private DataPackage doQuerySellfail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.sellfail", params);
	}

	private DataPackage doQuerySellfailall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.sellfailall", params);
	}	

	private DataPackage doQuerySellfailnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.sellfailnas", params);
	}

	private DataPackage doQuerySelegflfail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.selegflfail", params);
	}

	private DataPackage doQuerySelegflfailall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.selegflfailall", params);
	}
	
	private DataPackage doQuerySelegflfailnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.selegflfailnas",
				params);
	}

	private DataPackage doQueryWebfail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.webfail", params);
	}
	
	private DataPackage doQueryWebfailall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.webfailall", params);
	}

	private DataPackage doQueryWebfailnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.webfailnas", params);
	}

	private DataPackage doQueryWebegflfail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.webegflfail", params);
	}

	private DataPackage doQueryWebegflfailall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.webegflfailall", params);
	}
	
	private DataPackage doQueryWebegflfailnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.webegflfailnas",
				params);
	}

	private DataPackage doQueryE100fail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.e100fail", params);
	}

	private DataPackage doQueryE100failall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.e100failall", params);
	}
	
	private DataPackage doQueryE100failnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this
				.queryByNamedSqlQuery("bbcfaildataquery.e100failnas", params);
	}

	private DataPackage doQueryE100egflfail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.e100egflfail",
				params);
	}
	
	private DataPackage doQueryE100egflfailall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.e100egflfailall",
		params);
	}
	
	private DataPackage doQueryE100egflfailnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.e100egflfailnas",
				params);
	}

	private DataPackage doQueryAdtfail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.adtfail", params);
	}
	
	private DataPackage doQueryAdtfailall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.adtfailall", params);
	}

	private DataPackage doQueryAdtfailnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.adtfailnas", params);
	}

	private DataPackage doQueryAllfail(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.allfail", params);
	}

	private DataPackage doQueryAllfailall(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.allfailall", params);
	}
	
	private DataPackage doQueryAllfailnas(BbcFaildataqueryListVO params)
			throws Exception {
		return this.queryByNamedSqlQuery("bbcfaildataquery.allfailnas", params);
	}
}
