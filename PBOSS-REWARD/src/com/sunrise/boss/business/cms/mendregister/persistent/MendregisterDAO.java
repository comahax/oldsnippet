/**
* auto-generated code
* Mon Jun 20 09:11:28 GMT 2011
*/
package com.sunrise.boss.business.cms.mendregister.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;

/**
 * <p>Title: MendregisterDAO</p>
 * <p>Description: Data Access Object for MendregisterVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class MendregisterDAO extends BaseDAO {

    /**
     * default constructor
     */
    public MendregisterDAO(){
        super(MendregisterVO.class);
    }
    
//	public DataPackage queryAvailableBrand(String mobile,String region,User user) throws Exception{
//		Session session = SessionUtil.currentSession("DB_BOSSCOMMON");
////		String sql="select a.groupyxplan as groupyxplan,b.groupname as groupname,a.memyxplan as memyxplan,c.yxplanname as yxplanname "+
////					" from pc_ps_yxplangroup a,pc_ps_yxplangpinf b,pc_ps_yxplan c "+
////					" where a.groupyxplan=b.groupid and a.memyxplan=c.yxplanid and b.areacode= '"+user.getCityid()+"'"+
////					" and a.groupyxplan in ("+queryItems+") order by a.groupyxplan";
//		
////		String sql="select B.Comclassid as comclassid,B.Comprice as comprice,DECODE(d.brand,'BrandGotone',1,'BrandSzx',2,'BrandDzk',"+
////					"2,'BrandMzone',3) BRAND from im_pr_comressmp a, im_pr_com b, im_pr_nores c, pc_prod_main d where a.comid = b.comid"+
////					" and a.ISOPEN = 1 and a.comresid = c.mobileno and c.prodid = d.prodid and a.comstate not in (3, 4, 16)"+
////					" and d.brand in ('BrandDzk', 'BrandSzx', 'BrandGotone', 'BrandMzone') and a.comresid = '"+mobile+
////					"' and d.region = '"+region+"'";
//		
//		String sql="select d.brand, c.mobileno  from pc_prod_main d, im_pr_nores c  where c.prodid = d.prodid and d.region = '760' and c.mobileno = '13703116770' ";
//    	SQLQuery query = session.createSQLQuery(sql);
//    	query.addScalar("brand", Hibernate.STRING);
//    	List list = query.list();
//    	DataPackage dp = new DataPackage();
//    	dp.setDatas(list);
//    	dp.setRowCount(list.size());
//    	return dp;
//	}
}
