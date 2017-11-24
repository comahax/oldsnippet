package com.gmcc.pboss.business.cms.examine.examinestd.persistent;


import java.sql.ResultSet;

import org.hibernate.Session;

import com.sunrise.jop.infrastructure.db.AbstractDAO;


/**
 * <p>Title: ExaminestdDAO</p>
 * <p>Description: Data Access Object for ExaminestdVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ExaminestdDAO(){
        super(ExaminestdVO.class);
    }
   
}
