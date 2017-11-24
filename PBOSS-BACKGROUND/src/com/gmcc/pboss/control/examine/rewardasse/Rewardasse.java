package com.gmcc.pboss.control.examine.rewardasse;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.rewardasse.RewardasseDBParam;
import com.gmcc.pboss.business.cms.examine.rewardasse.RewardasseVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardasse </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Rewardasse extends AbstractControl {
    public RewardasseVO doCreate(RewardasseVO vo) throws Exception;

    public void doRemoveByVO(RewardasseVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardasseVO doUpdate(RewardasseVO vo) throws Exception;

    public RewardasseVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardasseDBParam params) throws Exception;

}
