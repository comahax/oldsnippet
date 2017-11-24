/**
* auto-generated code
* Mon Jan 29 11:36:20 CST 2007
*/
package com.sunrise.boss.business.cms.distribute.cpexamhistory.persistent;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: CpexamhistoryDAO</p>
 * <p>Description: Data Access Object for CpexamhistoryVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public class CpexamhistoryDAO extends BaseDAO {
	private static Log log = LogFactory.getLog(CpexamhistoryDAO.class);
	
    /**
     * default constructor
     */
    public CpexamhistoryDAO(){
        super(CpexamhistoryVO.class);
    }
    
    public DataPackage query(CpexamhistoryListVO params) throws Exception {    	

    	long start = System.currentTimeMillis(); 
    	DataPackage dataPack = queryByNamedSqlQuery("boss.cms.queryHistoryCooperatorAssessResult", params);
    	
    	List list = (List)dataPack.getDatas();
    	List newList = new ArrayList(list.size());
    	
    	for (int i=0 ; i < list.size() ;i++ ) {
    		CpexamhistoryVO vo = (CpexamhistoryVO)list.get(i);
    		
    		CpexamhistoryVO newVO = new CpexamhistoryVO();
    		BeanUtils.copyProperties(newVO, vo);
    		String cooperauid = newVO.getCooperauid();
    		
    		int examResult =  getHistoryCooperatorExamResult(cooperauid);
    		
    		newVO.setOdrdablenum(new Integer(examResult));
    		newList.add(newVO);
		}
    	dataPack.setDatas(newList);
		long end =  System.currentTimeMillis();		
		if(log.isInfoEnabled()) 
			log.info("ÓÃÊ±:" +(end- start));				
		return dataPack;
    }
    
    public int getHistoryCooperatorExamResult(String cooperauid) throws Exception {	
    	CpexamhistoryListVO listVO = new CpexamhistoryListVO();
    	listVO.getQueryConditions().put("cooperauid", cooperauid);
    	Integer val = (Integer)queryUniqueByNamedSqlQuery("boss.cms.getHistoryCooperatorExamResult", listVO);
    	int intValue = val.intValue();
    	return intValue;
	}
}
