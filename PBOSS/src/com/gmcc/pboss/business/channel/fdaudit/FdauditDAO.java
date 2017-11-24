/**
 * auto-generated code
 * Wed Oct 07 14:01:03 CST 2009
 */
package com.gmcc.pboss.business.channel.fdaudit;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.AbstractComponentType;
import org.hibernate.type.Type;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.hibernate3.Hibernate3BaseDAO;

/**
 * <p>Title: FdauditDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public FdauditDAO(){
        super(FdauditVO.class);
    }
    
	public Object doGetorgVO(Object vo, DBAccessUser user) throws Exception {
		Session session=SessionUtils.currentSession(getDbFlag());
		SessionFactory sessionFactory = session.getSessionFactory();
		session.evict(vo);
		ClassMetadata metadata = sessionFactory.getClassMetadata(vo.getClass());
		Type atype = metadata.getIdentifierType();
		Hibernate3BaseDAO dao = new Hibernate3BaseDAO(vo.getClass(),user.getCityid());
		if (!(atype instanceof AbstractComponentType)) {
			String pk = metadata.getIdentifierPropertyName();
			return dao.findByUniqueKey(pk, BeanUtils.getProperty(vo, pk));
		} else {
			AbstractComponentType type = (AbstractComponentType) atype;
			Serializable serializable = (Serializable) vo.getClass()
					.newInstance();
			String[] pks = type.getPropertyNames();
			for (int i = 0; i < pks.length; i++) {
				BeanUtils.copyProperty(serializable,pks[i],BeanUtils.getProperty(vo, pks[i]));
			}
			return dao.findByPk(serializable);
		}

	}
}
