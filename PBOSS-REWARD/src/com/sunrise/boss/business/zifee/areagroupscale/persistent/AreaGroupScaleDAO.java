/**
* auto-generated code
* Mon Aug 21 20:59:07 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupscale.persistent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.*;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AreaGroupScaleDAO</p>
 * <p>Description: Data Access Object for AreaGroupScaleVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class AreaGroupScaleDAO extends BaseLogDAO {

    /**
     * default constructor
     */
    public AreaGroupScaleDAO(){
        super(AreaGroupScaleVO.class);
    }
    
    /**
     * 根据表areagroupid查找，返回list
     * added by yijianrong
     */
    public List findByGroupid(String groupid,User user)
        throws Exception {
        if ( groupid != null) {
            StringBuffer selectHQL = new StringBuffer("FROM ").append(AreaGroupScaleVO.class.getName())
                .append(" this ").append("where this.areagroupid = " + groupid );
            Session session = SessionUtil.currentSession(user.getCityid());
            try {
                Query query = session.createQuery(selectHQL.toString());
                return query.list();
            }
            catch (Exception ex) {
                throw ex;
            }
        }
        return null;
    }
    
}
