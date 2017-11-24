/**
 * auto-generated code
 * Fri Jun 25 10:41:22 CST 2010
 */
package com.gmcc.pboss.business.sales.alaordercol;

import java.util.HashMap;
import java.util.Map;

import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AlaordercolDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class AlaordercolDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public AlaordercolDAO(){
        super(AlaordercolVO.class);
    }
    public DataPackage groupQuery(AlaordercolDBParam param) throws Exception {
    	Map conditionMap = new HashMap();
    	AlaordercolDBParam newparam=new AlaordercolDBParam();
    	BeanUtils.copyProperties(newparam, param);
		conditionMap.put("begincoldate", param.get_snl_coldate());
		
		param.set_snl_coldate(null);
		conditionMap.put("endcoldate", param.get_snm_coldate());
		param.set_snm_coldate(null);
		param.setQueryConditions(conditionMap);
		param.setSelectFieldsString("countyid,svccode,macode,starlevel,alarmlevel,brand,amount,orderamt,cancelamt,overamt");
		DataPackage dp=queryByNamedSqlQuery("com.gmcc.pboss.business.sales.alaordercol.groupQuery", param);
		BeanUtils.copyProperties(param, newparam);
		return dp;
    	
	}
}
