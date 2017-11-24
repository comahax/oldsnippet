/**
* auto-generated code
* Tue Nov 17 16:06:35 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinestd.persistent;

import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExaminestdDAO</p>
 * <p>Description: Data Access Object for ExaminestdVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public ExaminestdDAO(){
        super(ExaminestdVO.class);
    }
    public int doValidateSQL(String sql, User user)throws Exception{
    	Session session = SessionUtil.currentSession(user.getCityid());
    	ResultSet rs = session.connection().createStatement().executeQuery(sql);
    	int count=0;
    	while(rs.next()){
    		count++;
    	}
    	return count;
	}
}
