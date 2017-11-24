/**
* auto-generated code
* Thu Nov 19 11:08:41 CST 2009
*/
package com.sunrise.boss.business.cms.empmodel.persistent;

import com.sunrise.boss.common.base.db.BaseLogDAO;


/**
 * <p>Title: EmpmodelDAO</p>
 * <p>Description: Data Access Object for EmpmodelVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class EmpmodelDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public EmpmodelDAO(){
        super(EmpmodelVO.class);
    }
    
    public Object getSequence() throws Exception {
    	return this.getSequence("CH_PW_EMPMODEL_SEQ");
    }
}
