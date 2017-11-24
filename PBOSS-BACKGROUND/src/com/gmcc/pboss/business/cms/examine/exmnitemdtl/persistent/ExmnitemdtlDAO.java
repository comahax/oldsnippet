package com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent;

import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.jop.infrastructure.db.AbstractDAO;


/**
 * <p>Title: ExmnitemdtlDAO</p>
 * <p>Description: Data Access Object for ExmnitemdtlVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtlDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ExmnitemdtlDAO(){
        super(ExmnitemdtlVO.class);
    }
   
}
