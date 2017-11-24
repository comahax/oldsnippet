/**
 * auto-generated code
 * Tue Sep 01 14:54:44 CST 2009
 */
package com.gmcc.pboss.control.resource.comrescard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.business.resource.comrescard.ComrescardDAO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComrescardBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comrescard/control/ComrescardBO"
*    name="Comrescard"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComrescardBO extends AbstractControlBean implements
		Comrescard {

	public ComrescardVO doCreate(ComrescardVO vo) throws Exception {
		try {
			ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class, user);
			// TODO set the pk */
			return (ComrescardVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComrescardVO vo) throws Exception {
		try {
			ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComrescardVO doUpdate(ComrescardVO vo) throws Exception {
		try {
			ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
			return (ComrescardVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComrescardVO doFindByPk(Serializable pk) throws Exception {
		ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
		return (ComrescardVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComrescardDBParam params)
			throws Exception {
		ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
		return dao.query(params);
	}
	/**
	 * 根据商品种类查询充值卡资源与商品种类组合集合
	 * @param param
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByComcategory(ComrescardDBParam param,String comcategory,String countyid,String svccode,String mareacode)
	throws Exception {
		ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
		/*ComcategoryrelaDBParam comcatParam=new ComcategoryrelaDBParam();
		comcatParam.set_se_comcategory(comcategory);
		param.setQueryAll(true);
		comcatParam.setQueryAll(true);
    	 Object params[] = {
    			 param, comcatParam
    	        };
    	        Class vos[] = {
    	        		ComrescardVO.class, ComcategoryrelaVO.class
    	        };
    	        String joins[][] = {
    	            {
    	                "comid", "comid"
    	            }
    	        };*/
		return dao.doQueryComcategory(param,comcategory,countyid,svccode,mareacode);//dao.unionQuery(params, vos, joins);
	}

	public DataPackage doStat(ComrescardDBParam params) throws Exception {
		// TODO Auto-generated method stub
		ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
		params.setSelectFieldsString("countyid,wayid,comcategory,comstate,ncount");
		params.setDataOnly(true);
		int count=0;//合计
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comrescard.doStat", params);
		if(dp != null && dp.getDatas() != null){
			List list = dp.getDatas();
			List<ComrescardTableVO> resultList = new ArrayList<ComrescardTableVO>();
			List<ComrescardTableVO> sourceList= new ArrayList<ComrescardTableVO>();

			for(int i = list.size()-1;i>=0;i--){
				ComrescardTableVO tableVO = new ComrescardTableVO();
				Map map = (Map)list.get(i);
				
				tableVO.setCountyid((String)map.get("countyid"));
				tableVO.setWayid( (String)map.get("wayid"));
				tableVO.setComcategory((String)map.get("comcategory"));
				System.out.println(map.get("comstate"));
				tableVO.setComstate(map.get("comstate").toString());
				tableVO.setNcount((String)map.get("ncount"));
				count += Integer.parseInt((String)map.get("ncount"));
				sourceList.add(tableVO);
			}
			
			int countyCount = 1;
			int wayCount = 1;
			int comcateCount = 1;
			
			ComrescardTableVO vo = null;
			
			ComrescardTableVO prevVO = new ComrescardTableVO();
			for(int i =0; i<sourceList.size(); i++){
				ComrescardTableVO nextVO = sourceList.get(i);
				if(nextVO.getCountyid().equals(prevVO.getCountyid())){
					countyCount++;
						vo = resultList.get(i-countyCount+1);
						vo.setCountyCount(countyCount);
					if(nextVO.getWayid().equals(prevVO.getWayid())){
						wayCount++;
						vo = resultList.get(i-wayCount+1);
						vo.setWayCount(wayCount);						
							if(nextVO.getComcategory().equals(prevVO.getComcategory())){
								comcateCount++;
								vo = resultList.get(i-comcateCount+1);
								vo.setComcateCount(comcateCount);	
								if(nextVO.getComstate().equals(prevVO.getComstate())){
									
								}else{
									BeanUtils.copyProperties(prevVO, nextVO);
									resultList.add(this.rebuildVO(nextVO, 4));
									continue;
								}
							}else{
								BeanUtils.copyProperties(prevVO, nextVO);
								resultList.add(this.rebuildVO(nextVO, 3));
								comcateCount = 1;
								continue;
							}
					}else{
						BeanUtils.copyProperties(prevVO, nextVO);
						resultList.add(this.rebuildVO(nextVO, 2));
						wayCount=1;
						comcateCount = 1;
						continue;
					}
				}else{
					BeanUtils.copyProperties(prevVO, nextVO);
					resultList.add(this.rebuildVO(nextVO, 1));
					countyCount=1;
					wayCount=1;
					comcateCount = 1;
					continue;
				}
			}
			
			dp.setDatas(resultList);
			dp.setRowCount(count);//因为不需要分页，借用DP的属性保存统计总量
		}
		return dp;
	}
	
	
	private ComrescardTableVO rebuildVO(ComrescardTableVO vo,int num) throws Exception{
		ComrescardTableVO tempvo = new ComrescardTableVO();
		BeanUtils.copyProperties(tempvo, vo);
		switch (num) {
			case 4:
				BeanUtils.setProperty(tempvo, "comcategory", "");
			case 3:
				BeanUtils.setProperty(tempvo, "wayid", "");				
			case 2:
				BeanUtils.setProperty(tempvo, "countyid", "");
			case 1:				
				break;
		}
		return tempvo;
	}
	
	public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)
			throws Exception {
		ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
		return dao.unionQuery(params, classvo, joins);
	}
	
	public Integer doStatCardStock(String countyid,String comcategory) throws Exception {
		ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
		ComrescardDBParam params = new ComrescardDBParam();
		params.getQueryConditions().put("countyid", countyid);
		params.getQueryConditions().put("comcategory",comcategory);
		Integer result = (Integer)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.resource.comrescard.doStatCardStock", params);
		return result;
	}
	
	public DataPackage doQueryBySqlName(String sqlName,DBQueryParam param) throws Exception{
		ComrescardDAO dao = (ComrescardDAO) DAOFactory.build(ComrescardDAO.class,user);
		return dao.queryByNamedSqlQuery(sqlName, param);
	}
}
