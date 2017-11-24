package com.gmcc.pboss.business.base.role;


import com.sunrise.jop.infrastructure.db.AbstractDAO;


/**
 * <p>Title: RoleDAO</p>
 * <p>Description: Data Access Object for RoleVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RoleDAO extends AbstractDAO{
	
	public RoleDAO(){
        super(RoleVO.class);
    }
}
