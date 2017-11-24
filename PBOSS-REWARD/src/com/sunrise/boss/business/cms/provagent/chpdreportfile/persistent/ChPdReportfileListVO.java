/**
* auto-generated code
* Wed Sep 04 16:27:47 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdReportfileListVO</p>
 * <p>Description: Query Params Object for ChPdReportfileDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdReportfileListVO extends BaseListVO {
    private String _se_rewardmonth;
    private String _se_provagentid;

    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_se_provagentid(){
        return _se_provagentid;
    }

    public void set_se_provagentid(String _se_provagentid){
        this._se_provagentid = _se_provagentid;
    }

}
