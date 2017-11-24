/**
 * auto-generated code
 * Wed Jul 01 17:30:39 CST 2009
 */
package com.gmcc.pboss.business.channel.wayaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WayaccountDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class WayaccountDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public WayaccountDAO(){
        super(WayaccountVO.class);
    }
    
    /**
	 * <pre>
	 * 查询指定渠道及其下级渠道的详细信息
	 * (包括渠道信息，店员信息，渠道网点联系资料，渠道合同协议资料，渠道帐户资料，分销合作商资料表)
	 * </pre>
	 * @param params
	 * @param wayid
	 * @return DataPackage 里面的元素是AGWayVO
	 * @throws Exception
	 */
	public DataPackage queryWayAndSubwayDetailInfo(WayaccountDBParam params,String wayid) 
			throws Exception {
		params.setSelectFieldsString("wayid,wayname,waysubtype,upperwayid,starlevel,pt,waystate,cityid,countyid,svccode,mareacode,isstraitprd,adtypecode,adacode,formtype,starttime,buzarea,logiscode,waymagcode,bchlevel,officetel,alarmbizamount,address,latitude,longtitude,checked,principal,principaltel,principalphone,principalemail,sendaddr, recpers,recconntel,reccertno,compacttype,compactno,compactname,signtime,begintime,cmpendtime,licenceno,licvalidate,bail,bailstatus,baillwrlmt,bankname,acctno,acctname,acctfid,signstatus,bailtype, servbound,provcode,deacctno,deacctname,debankname,chainhead,isb2m,accttype,debankid,destate,custtype,starlev,istop,buztypecode,rewardkind,buscno,wayattr,waymod,creditlevel,taxcertificate");
		params.getQueryConditions().put("wayid", wayid);
		
		String rewardkind = params.get_se_rewardkind();
		if("0".equals(rewardkind)){
			params.set_sql_starlevel("STARLEVEL != 7 and STARLEVEL != 8 and STARLEVEL != 9 OR STARLEVEL IS NULL"); 
		}else if("1".equals(rewardkind)){
			params.set_ne_starlevel("7");
		}else if("2".equals(rewardkind)){
			params.set_ne_starlevel("8");
		}else if("3".equals(rewardkind)){
			params.set_ne_starlevel("9");
		} 
		DataPackage tempDp = queryByNamedSqlQuery("com.gmcc.pboss.business.channel.wayaccount.QueryWayAndSubwayDetailInfo",params);
		List list = tempDp.getDatas();
		
		DataPackage resultDp = new DataPackage();
		List collection = new ArrayList();
		for(int i = 0;i<list.size();i++) {
			AGWayVO agway = new AGWayVO();
			Map map = (Map)list.get(i);
			BeanUtils.copyProperties(agway, map);
			collection.add(agway);
		}
		resultDp.setDatas(collection);
		resultDp.setRowCount(tempDp.getRowCount());
		resultDp.setPageNo(tempDp.getPageNo());
		resultDp.setPageSize(tempDp.getPageSize());
		return resultDp;
		
	}
}
