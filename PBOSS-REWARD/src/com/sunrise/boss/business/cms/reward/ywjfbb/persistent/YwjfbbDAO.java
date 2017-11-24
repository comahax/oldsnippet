/**
* auto-generated code
* Thu Nov 17 11:10:29 CST 2011
*/
package com.sunrise.boss.business.cms.reward.ywjfbb.persistent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.regnewwayemptotal.persistent.RegNewWayEmpTotalListVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: YwjfbbDAO</p>
 * <p>Description: Data Access Object for YwjfbbVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class YwjfbbDAO extends BaseLogDAO {

    /**`
     * default constructor
     */
    public YwjfbbDAO(){
        super(YwjfbbVO.class);
    }
    
    
    public  DataPackage  query2(YwjfbbListVO param, User user)throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	
    	if("".equals(param.get_se_wayid())){
    		Query query = session.getNamedQuery("boss.cms.ywjfbb");
    		query.setParameter("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
//    		query.setParameter("calcmonth", "201111");
    		query.setParameter("calcmonth", param.get_se_calcmonth());
    		
    		@SuppressWarnings("unused")
			String s = query.getQueryString();
    		
//    		query.setParameter("calcmonth", param.get_ne_calcmonth());
    		List<YwjfbbVO> list = query.list();
    		Set<String> wayidset=new HashSet<String>();
    		for(int j=1;j<list.size();j++){
    			wayidset.add(list.get(j).getWayid());
    		}
    		Object[] wayids=wayidset.toArray();
    		
//    		Query query2 = session.getNamedQuery("boss.cms.ywjfbbonlywayid");
//    		query2.setParameter("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
//    		query2.setParameter("calcmonth", "201111");
////    		query2.setParameter("calcmonth", param.get_ne_calcmonth());
//    		List<YwjfbbVO> onlywayidlist = query2.list();
    		
    		List newlist=new ArrayList();
    		
    		for(int i=0;i<wayids.length;i++){
    			YwjfbbVO ywjfbbVO=new YwjfbbVO();
    			String wayid=(String)wayids[i];
    			for(int j=0;j<list.size();j++){
    				String newwayid=list.get(j).getWayid();
    				if(!newwayid.equals(wayid))
    					continue;
    				ywjfbbVO.setWayid(list.get(j).getWayid());
    				ywjfbbVO.setChainhead(list.get(j).getChainhead());
    				ywjfbbVO.setCountycompid(list.get(j).getCountycompid());
    				ywjfbbVO.setCountycompname(list.get(j).getCountycompname());
    				ywjfbbVO.setWayname(list.get(j).getWayname());
    				ywjfbbVO.setCalcmonth(list.get(j).getCalcmonth());
    				ywjfbbVO.setStarlevel(list.get(j).getStarlevel());
    				String flag=list.get(j).getFlag();
    				if(newwayid.equals(wayid)&&"dzzd".equals(flag)){
    					ywjfbbVO.setDzzd(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"sjyw_sr".equals(flag)){
    					ywjfbbVO.setSr(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"sjyw_fsr".equals(flag)){
    					ywjfbbVO.setFsr(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"czjf".equals(flag)){
    					ywjfbbVO.setCzjf(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"yckb".equals(flag)){
    					ywjfbbVO.setYckb(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"jtdh".equals(flag)){
    					ywjfbbVO.setJtdh(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"dhjq".equals(flag)){
    					ywjfbbVO.setDhjq(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"lxw".equals(flag)){
    					ywjfbbVO.setLxw(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"a+jh".equals(flag)){
    					ywjfbbVO.setAjh(list.get(j).getBusivalue());
    				}
    			}
    			newlist.add(ywjfbbVO);
    			
    		}
    		DataPackage dataPack = new DataPackage();
    		dataPack.setDatas(newlist);
    		dataPack.setPageNo(1);
    		dataPack.setPageSize(10);
    		dataPack.setRowCount(newlist.size());
    		return dataPack;
    		
    		
    		
    		
    	}else{
    		Query query = session.getNamedQuery("boss.cms.ywjfbbbywayid");
    		query.setParameter("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
    		query.setParameter("calcmonth", param.get_se_calcmonth());
    		query.setParameter("wayid", param.get_se_wayid());
    		List<YwjfbbVO> list = query.list();
    		YwjfbbVO ywjfbbVO=new YwjfbbVO();
    		
    		List newlist=new ArrayList();
    		
    		for(int j=0;j<list.size();j++){
				
				ywjfbbVO.setWayid(list.get(j).getWayid());
				ywjfbbVO.setChainhead(list.get(j).getChainhead());
				ywjfbbVO.setCountycompid(list.get(j).getCountycompid());
				ywjfbbVO.setCountycompname(list.get(j).getCountycompname());
				ywjfbbVO.setWayname(list.get(j).getWayname());
				ywjfbbVO.setCalcmonth(list.get(j).getCalcmonth());
				ywjfbbVO.setStarlevel(list.get(j).getStarlevel());
				String flag=list.get(j).getFlag();
				if("dzzd".equals(flag)){
					ywjfbbVO.setDzzd(list.get(j).getBusivalue());
				}
				if("sjyw_sr".equals(flag)){
					ywjfbbVO.setSr(list.get(j).getBusivalue());
				}
				if("sjyw_fsr".equals(flag)){
					ywjfbbVO.setFsr(list.get(j).getBusivalue());
				}
				if("czjf".equals(flag)){
					ywjfbbVO.setCzjf(list.get(j).getBusivalue());
				}
				if("yckb".equals(flag)){
					ywjfbbVO.setYckb(list.get(j).getBusivalue());
				}
				if("jtdh".equals(flag)){
					ywjfbbVO.setJtdh(list.get(j).getBusivalue());
				}
				if("dhjq".equals(flag)){
					ywjfbbVO.setDhjq(list.get(j).getBusivalue());
				}
				if("lxw".equals(flag)){
					ywjfbbVO.setLxw(list.get(j).getBusivalue());
				}
				if("a+jh".equals(flag)){
					ywjfbbVO.setAjh(list.get(j).getBusivalue());
				}
			}
    		newlist.add(ywjfbbVO);
    		
			DataPackage dataPack = new DataPackage();
			dataPack.setDatas(newlist);
    		dataPack.setPageNo(1);
    		dataPack.setPageSize(10);
    		dataPack.setRowCount(newlist.size());
			return dataPack;
    		
    	}
    	
    }
    
}
