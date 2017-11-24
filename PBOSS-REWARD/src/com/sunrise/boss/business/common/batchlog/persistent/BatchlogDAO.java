package com.sunrise.boss.business.common.batchlog.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;

/**
 * <p>Title: BatchlogDAO</p>
 * <p>Description: Data Access Object for BatchlogVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liminghao
 * @version 1.0
 */
public class BatchlogDAO extends BaseDAO {

    /**
     * default constructor
     */
    public BatchlogDAO(){
        super(BatchlogVO.class);
    }
}
