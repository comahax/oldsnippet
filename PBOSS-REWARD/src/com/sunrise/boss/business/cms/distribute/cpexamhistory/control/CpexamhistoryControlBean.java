/**
* auto-generated code
* Mon Jan 29 11:36:20 CST 2007
*/
package com.sunrise.boss.business.cms.distribute.cpexamhistory.control;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpexamhistory.persistent.CpexamhistoryDAO;
import com.sunrise.boss.business.cms.distribute.cpexamhistory.persistent.CpexamhistoryListVO;

/**
 * <p>Title: CpexamhistoryControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/distribute/cpexamhistory/control/CpexamhistoryControlBean"
 name="CpexamhistoryControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CpexamhistoryControlBean extends AbstractControlBean
    implements CpexamhistoryControl {
    public DataPackage doQuery(CpexamhistoryListVO params, User user)
        throws Exception {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	try{
    		if(params.get_dnl_optime() != null && !"".equals(params.get_dnl_optime())){
    			df.parse(params.get_dnl_optime());
    		}
    		if(params.get_dnm_optime() != null && !"".equals(params.get_dnm_optime())){
        		df.parse(params.get_dnm_optime());
    		}
    	}catch (ParseException e) {
			throw new Exception("时间格式不正确");
		}
         CpexamhistoryDAO dao = (CpexamhistoryDAO) DAOFactory.build(CpexamhistoryDAO.class, user);
        return dao.query(params);
    }
}
