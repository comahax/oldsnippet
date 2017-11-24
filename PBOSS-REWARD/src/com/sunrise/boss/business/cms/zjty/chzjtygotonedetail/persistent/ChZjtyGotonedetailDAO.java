/**
* auto-generated code
* Tue Jul 09 08:59:10 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: ChZjtyGotonedetailDAO</p>
 * <p>Description: Data Access Object for ChZjtyGotonedetailVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChZjtyGotonedetailDAO extends BaseDAO {

    /**
     * default constructor
     */
    public ChZjtyGotonedetailDAO(){
        super(ChZjtyGotonedetailVO.class);
    }

	public DataPackage query(ChZjtyGotonedetailListVO params) throws Exception {
		List<String> selectFields = new ArrayList<String>();
		selectFields.add("cooperauid");
		selectFields.add("city");
		selectFields.add("wayname");
		selectFields.add("rewardreporttime");
		selectFields.add("ywl58khcj");
		selectFields.add("ywl58jlcj1");
		selectFields.add("ywl58jlcj2");
		selectFields.add("ywl58jlcj3");
		selectFields.add("ywl58jlcj4");
		selectFields.add("ywl58jlcj5");
		selectFields.add("ywl58jlcj6");
		selectFields.add("ywl58jlcj7");
		selectFields.add("ywl58jlcj8");
		selectFields.add("ywl58jlcj9");
		selectFields.add("ywl58jlcj10");
		selectFields.add("ywl58jlcj11");
		selectFields.add("ywl58jlcj12");
		selectFields.add("ywl88khcj");
		selectFields.add("ywl88jlcj1");
		selectFields.add("ywl88jlcj2");
		selectFields.add("ywl88jlcj3");
		selectFields.add("ywl88jlcj4");
		selectFields.add("ywl88jlcj5");
		selectFields.add("ywl88jlcj6");
		selectFields.add("ywl88jlcj7");
		selectFields.add("ywl88jlcj8");
		selectFields.add("ywl88jlcj9");
		selectFields.add("ywl88jlcj10");
		selectFields.add("ywl88jlcj11");
		selectFields.add("ywl88jlcj12");
		selectFields.add("ywl128khcj");
		selectFields.add("ywl128jlcj1");
		selectFields.add("ywl128jlcj2");
		selectFields.add("ywl128jlcj3");
		selectFields.add("ywl128jlcj4");
		selectFields.add("ywl128jlcj5");
		selectFields.add("ywl128jlcj6");
		selectFields.add("ywl128jlcj7");
		selectFields.add("ywl128jlcj8");
		selectFields.add("ywl128jlcj9");
		selectFields.add("ywl128jlcj10");
		selectFields.add("ywl128jlcj11");
		selectFields.add("ywl128jlcj12");
		selectFields.add("ywl158khcj");
		selectFields.add("ywl158jlcj1");
		selectFields.add("ywl158jlcj2");
		selectFields.add("ywl158jlcj3");
		selectFields.add("ywl158jlcj4");
		selectFields.add("ywl158jlcj5");
		selectFields.add("ywl158jlcj6");
		selectFields.add("ywl158jlcj7");
		selectFields.add("ywl158jlcj8");
		selectFields.add("ywl158jlcj9");
		selectFields.add("ywl158jlcj10");
		selectFields.add("ywl158jlcj11");
		selectFields.add("ywl158jlcj12");
		selectFields.add("ywl188khcj");
		selectFields.add("ywl188jlcj1");
		selectFields.add("ywl188jlcj2");
		selectFields.add("ywl188jlcj3");
		selectFields.add("ywl188jlcj4");
		selectFields.add("ywl188jlcj5");
		selectFields.add("ywl188jlcj6");
		selectFields.add("ywl188jlcj7");
		selectFields.add("ywl188jlcj8");
		selectFields.add("ywl188jlcj9");
		selectFields.add("ywl188jlcj10");
		selectFields.add("ywl188jlcj11");
		selectFields.add("ywl188jlcj12");
		selectFields.add("ywl288khcj");
		selectFields.add("ywl288jlcj1");
		selectFields.add("ywl288jlcj2");
		selectFields.add("ywl288jlcj3");
		selectFields.add("ywl288jlcj4");
		selectFields.add("ywl288jlcj5");
		selectFields.add("ywl288jlcj6");
		selectFields.add("ywl288jlcj7");
		selectFields.add("ywl288jlcj8");
		selectFields.add("ywl288jlcj9");
		selectFields.add("ywl288jlcj10");
		selectFields.add("ywl288jlcj11");
		selectFields.add("ywl288jlcj12");
		selectFields.add("ywlmzonetogotone");
		selectFields.add("dwkhcj");
		selectFields.add("dw58cj");
		selectFields.add("dw88cj");
		selectFields.add("dw128cj");
		selectFields.add("dw158cj");
		selectFields.add("dw188cj");
		selectFields.add("dw288cj");
		selectFields.add("dwmzonetogotone");
		selectFields.add("cjtotal58khcj");
		selectFields.add("cjtotal58jlcj1");
		selectFields.add("cjtotal58jlcj2");
		selectFields.add("cjtotal58jlcj3");
		selectFields.add("cjtotal58jlcj4");
		selectFields.add("cjtotal58jlcj5");
		selectFields.add("cjtotal58jlcj6");
		selectFields.add("cjtotal58jlcj7");
		selectFields.add("cjtotal58jlcj8");
		selectFields.add("cjtotal58jlcj9");
		selectFields.add("cjtotal58jlcj10");
		selectFields.add("cjtotal58jlcj11");
		selectFields.add("cjtotal58jlcj12");
		selectFields.add("cjtotal88khcj");
		selectFields.add("cjtotal88jlcj1");
		selectFields.add("cjtotal88jlcj2");
		selectFields.add("cjtotal88jlcj3");
		selectFields.add("cjtotal88jlcj4");
		selectFields.add("cjtotal88jlcj5");
		selectFields.add("cjtotal88jlcj6");
		selectFields.add("cjtotal88jlcj7");
		selectFields.add("cjtotal88jlcj8");
		selectFields.add("cjtotal88jlcj9");
		selectFields.add("cjtotal88jlcj10");
		selectFields.add("cjtotal88jlcj11");
		selectFields.add("cjtotal88jlcj12");
		selectFields.add("cjtotal128khcj");
		selectFields.add("cjtotal128jlcj1");
		selectFields.add("cjtotal128jlcj2");
		selectFields.add("cjtotal128jlcj3");
		selectFields.add("cjtotal128jlcj4");
		selectFields.add("cjtotal128jlcj5");
		selectFields.add("cjtotal128jlcj6");
		selectFields.add("cjtotal128jlcj7");
		selectFields.add("cjtotal128jlcj8");
		selectFields.add("cjtotal128jlcj9");
		selectFields.add("cjtotal128jlcj10");
		selectFields.add("cjtotal128jlcj11");
		selectFields.add("cjtotal128jlcj12");
		selectFields.add("cjtotal158khcj");
		selectFields.add("cjtotal158jlcj1");
		selectFields.add("cjtotal158jlcj2");
		selectFields.add("cjtotal158jlcj3");
		selectFields.add("cjtotal158jlcj4");
		selectFields.add("cjtotal158jlcj5");
		selectFields.add("cjtotal158jlcj6");
		selectFields.add("cjtotal158jlcj7");
		selectFields.add("cjtotal158jlcj8");
		selectFields.add("cjtotal158jlcj9");
		selectFields.add("cjtotal158jlcj10");
		selectFields.add("cjtotal158jlcj11");
		selectFields.add("cjtotal158jlcj12");
		selectFields.add("cjtotal188khcj");
		selectFields.add("cjtotal188jlcj1");
		selectFields.add("cjtotal188jlcj2");
		selectFields.add("cjtotal188jlcj3");
		selectFields.add("cjtotal188jlcj4");
		selectFields.add("cjtotal188jlcj5");
		selectFields.add("cjtotal188jlcj6");
		selectFields.add("cjtotal188jlcj7");
		selectFields.add("cjtotal188jlcj8");
		selectFields.add("cjtotal188jlcj9");
		selectFields.add("cjtotal188jlcj10");
		selectFields.add("cjtotal188jlcj11");
		selectFields.add("cjtotal188jlcj12");
		selectFields.add("cjtotal288khcj");
		selectFields.add("cjtotal288jlcj1");
		selectFields.add("cjtotal288jlcj2");
		selectFields.add("cjtotal288jlcj3");
		selectFields.add("cjtotal288jlcj4");
		selectFields.add("cjtotal288jlcj5");
		selectFields.add("cjtotal288jlcj6");
		selectFields.add("cjtotal288jlcj7");
		selectFields.add("cjtotal288jlcj8");
		selectFields.add("cjtotal288jlcj9");
		selectFields.add("cjtotal288jlcj10");
		selectFields.add("cjtotal288jlcj11");
		selectFields.add("cjtotal288jlcj12");
		selectFields.add("cjtotalmzonetogotone");
		selectFields.add("manageexamine");
		selectFields.add("vetocoefficient");
		selectFields.add("ordercoefficient");
		selectFields.add("campaigncoefficient");
		selectFields.add("totalreward");
		params.setSelectFields(selectFields);
		return this.queryByNamedSqlQuery("querychzjtygotonedetail", params);
	}
}
