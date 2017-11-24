/**
* auto-generated code
* Thu Sep 04 10:43:57 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.opnacctmap.persistent;


import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: OpnacctmapDAO</p>
 * <p>Description: Data Access Object for OpnacctmapVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OpnacctmapDAO extends BaseLogDAO {

	
    /**
     * default constructor
     */
    public OpnacctmapDAO(){
        super(OpnacctmapVO.class);
    }
    
    public DataPackage doQuery(OpnacctmapListVO params) throws Exception{
    	/*DataPackage dp=this.queryByNamedSqlQuery("cms.bbc.mapQuery2", params);
    	if(dp.getDatas()!=null && dp.getDatas().size()>0){
	    	AcctDelegate delegate=new AcctDelegate();
	    	AcctListVO acctListVO=new AcctListVO();
	    	BeanUtils.copyProperties(acctListVO, params);
    	}*/
    	//acctListVO.set
    	
    	//正式环境用这个
    	return  queryByNamedSqlQuery("cms.bbc.mapQuery2", params);
    	//本地测时用下面这个,以重现ora-24777错误
    	//return this.queryByNamedSqlQuery("cms.bbc.mapQuery", params);
    }
}
