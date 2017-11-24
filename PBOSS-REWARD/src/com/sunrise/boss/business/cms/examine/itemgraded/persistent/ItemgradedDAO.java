/**
* auto-generated code
* Sat Nov 28 17:53:15 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgraded.persistent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;


/**
 * <p>Title: ItemgradedDAO</p>
 * <p>Description: Data Access Object for ItemgradedVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ItemgradedDAO(){
        super(ItemgradedVO.class);
    }
    /**
     * 查找所有可提交信息得ID集合
     * @param registercode
     * @return
     * @throws Exception
     */
    public List doFindAllSubmitSeqid(String registercode,User user)throws Exception{
    	String sql = "select seqid from ch_pw_itemgraded d where d.state='99' ";
    	if(registercode!=null)
    		sql+=" and d.registercode='"+registercode+"'";
    	Session session = SessionUtil.currentSession(user.getCityid());
		Query query=session.createSQLQuery(sql).addScalar("seqid", Hibernate.STRING);
		return query.list();
    }
    /**
	 * 查找评分渠道信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage getItemgradedWayInfo(ItemgradedListVO listvo, User user)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
    	Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","8");
		BeanUtils.setProperty(pkVO, "paramtype","pboss");
		SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		
//		ItemgradedListVO listVO=new ItemgradedListVO();
		listvo.getQueryConditions().put("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		listvo.getQueryConditions().put("likecityid", "%"+SessionFactoryRouter.conversionCityid(user.getCityid())+"%");
		String sqlname="getItemgradedWayInfo2";
		if("1".equals(sysparamVO.getParamvalue())){
			listvo.getQueryConditions().put("operid", user.getOpercode());
			sqlname="getItemgradedWayInfo";
		}
		//listvo.set_pagesize("0");
		List selectFields=new ArrayList();
		selectFields.add("wayid");
		selectFields.add("wayname");
		selectFields.add("adtypecode");
		selectFields.add("starlevel");
		selectFields.add("exmnid");
		selectFields.add("exmnname"); 
		selectFields.add("exmnstdid");
		selectFields.add("exmnstdname");
		selectFields.add("isvoted");
		selectFields.add("exmnscore");
		listvo.setSelectFields(selectFields);
		return super.queryByNamedSqlQuery(sqlname, listvo);
	}
}
