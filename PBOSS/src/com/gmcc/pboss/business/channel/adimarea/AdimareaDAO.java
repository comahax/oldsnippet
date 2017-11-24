/**
 * auto-generated code
 * Tue Jul 07 15:33:22 CST 2009
 */
package com.gmcc.pboss.business.channel.adimarea;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

/**
 * <p>Title: AdimareaDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class AdimareaDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public AdimareaDAO(){
        super(AdimareaVO.class);
    }
    
    public List doQuerySuberada(String adacode) throws Exception {
		Session session = SessionUtils.currentSession(this.getDbFlag());
		Query query = session.getNamedQuery("boss.cms.adimarea.querySubAdas");
		query.setString("idorname", adacode);
		List list = query.list();
		return list;
	}
}
