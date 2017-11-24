/**
* auto-generated code
* Thu Mar 15 09:32:40 CST 2012
*/
package com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: XjjlywjfmxDAO</p>
 * <p>Description: Data Access Object for XjjlywjfmxVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class XjjlywjfmxDAO extends BaseDAO {

    /**
     * default constructor
     */
    public XjjlywjfmxDAO(){
        super(XjjlywjfmxVO.class);
    }
    
    public  DataPackage  query2(XjjlywjfmxListVO param, User user)throws Exception {
    	Session session = SessionUtil.currentSession(getDbFlag());
    	
    	if("".equals(param.get_se_wayid())){
    		Query query = session.getNamedQuery("boss.cms.xjjlywjfmx");
    		query.setParameter("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
//    		query.setParameter("calcmonth", "201111");
    		query.setParameter("calcmonth", param.get_se_calcmonth());
    		
    		@SuppressWarnings("unused")
			String s = query.getQueryString();
    		
//    		query.setParameter("calcmonth", param.get_ne_calcmonth());
    		List<XjjlywjfmxVO> list = query.list();
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
    			XjjlywjfmxVO ywjfVO=new XjjlywjfmxVO();
    			String wayid=(String)wayids[i];
    			for(int j=0;j<list.size();j++){
    				String newwayid=list.get(j).getWayid();
    				if(!newwayid.equals(wayid))
    					continue;
    				ywjfVO.setWayid(list.get(j).getWayid());
    				ywjfVO.setChainhead(list.get(j).getChainhead());
    				ywjfVO.setCountycompid(list.get(j).getCountycompid());
    				ywjfVO.setCountycompname(list.get(j).getCountycompname());
    				ywjfVO.setWayname(list.get(j).getWayname());
    				ywjfVO.setCalcmonth(list.get(j).getCalcmonth());
    				ywjfVO.setStarlevel(list.get(j).getStarlevel());
    				ywjfVO.setCreditaccount(list.get(j).getCreditaccount());
    				ywjfVO.setPaysum(list.get(j).getPaysum());
    				String flag=list.get(j).getFlag();
    				if(newwayid.equals(wayid)&&"dzzd".equals(flag)){
    					ywjfVO.setDzzd(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"sjyw_sr".equals(flag)){
    					ywjfVO.setSr(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"sjyw_fsr".equals(flag)){
    					ywjfVO.setFsr(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"czjf".equals(flag)){
    					ywjfVO.setCzjf(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"yckb".equals(flag)){
    					ywjfVO.setYckb(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"jtdh".equals(flag)){
    					ywjfVO.setJtdh(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"dhjq".equals(flag)){
    					ywjfVO.setDhjq(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"lxw".equals(flag)){
    					ywjfVO.setLxw(list.get(j).getBusivalue());
    				}
    				if(newwayid.equals(wayid)&&"a+jh".equals(flag)){
    					ywjfVO.setAjh(list.get(j).getBusivalue());
    				}
    			}
    			newlist.add(ywjfVO);
    			
    		}
    		DataPackage dataPack = new DataPackage();
    		dataPack.setDatas(newlist);
    		dataPack.setPageNo(1);
    		dataPack.setPageSize(10);
    		dataPack.setRowCount(newlist.size());
    		return dataPack;
    		
    		
    		
    		
    	}else{
    		Query query = session.getNamedQuery("boss.cms.xjjlywjfmxbywayid");
    		query.setParameter("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
    		query.setParameter("calcmonth", param.get_se_calcmonth());
    		query.setParameter("wayid", param.get_se_wayid());
    		List<XjjlywjfmxVO> list = query.list();
    		XjjlywjfmxVO ywjfVO=new XjjlywjfmxVO();
    		
    		List newlist=new ArrayList();
    		
    		for(int j=0;j<list.size();j++){
				
				ywjfVO.setWayid(list.get(j).getWayid());
				ywjfVO.setChainhead(list.get(j).getChainhead());
				ywjfVO.setCountycompid(list.get(j).getCountycompid());
				ywjfVO.setCountycompname(list.get(j).getCountycompname());
				ywjfVO.setWayname(list.get(j).getWayname());
				ywjfVO.setCalcmonth(list.get(j).getCalcmonth());
				ywjfVO.setStarlevel(list.get(j).getStarlevel());
				ywjfVO.setCreditaccount(list.get(j).getCreditaccount());
				ywjfVO.setPaysum(list.get(j).getPaysum());
				String flag=list.get(j).getFlag();
				if("dzzd".equals(flag)){
					ywjfVO.setDzzd(list.get(j).getBusivalue());
				}
				if("sjyw_sr".equals(flag)){
					ywjfVO.setSr(list.get(j).getBusivalue());
				}
				if("sjyw_fsr".equals(flag)){
					ywjfVO.setFsr(list.get(j).getBusivalue());
				}
				if("czjf".equals(flag)){
					ywjfVO.setCzjf(list.get(j).getBusivalue());
				}
				if("yckb".equals(flag)){
					ywjfVO.setYckb(list.get(j).getBusivalue());
				}
				if("jtdh".equals(flag)){
					ywjfVO.setJtdh(list.get(j).getBusivalue());
				}
				if("dhjq".equals(flag)){
					ywjfVO.setDhjq(list.get(j).getBusivalue());
				}
				if("lxw".equals(flag)){
					ywjfVO.setLxw(list.get(j).getBusivalue());
				}
				if("a+jh".equals(flag)){
					ywjfVO.setAjh(list.get(j).getBusivalue());
				}
			}
    		newlist.add(ywjfVO);
    		
			DataPackage dataPack = new DataPackage();
			dataPack.setDatas(newlist);
    		dataPack.setPageNo(1);
    		dataPack.setPageSize(10);
    		dataPack.setRowCount(newlist.size());
			return dataPack;
    		
    	}
    	
    }
    
}
