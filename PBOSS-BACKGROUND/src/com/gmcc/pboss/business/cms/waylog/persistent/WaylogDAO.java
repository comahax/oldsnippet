package com.gmcc.pboss.business.cms.waylog.persistent;

import com.sunrise.jop.infrastructure.db.AbstractDAO;


/**
 * <p>Title: WaylogDAO</p>
 * <p>Description: Data Access Object for WaylogVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaylogDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public WaylogDAO(){
        super(WaylogVO.class);
    }
}
